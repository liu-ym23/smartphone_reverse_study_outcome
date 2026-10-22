package org.commonmark.internal;

import androidx.core.net.MailTo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes7.dex */
public class InlineParserImpl implements InlineParser {
    private static final Pattern AUTOLINK = null;
    private static final Pattern EMAIL_AUTOLINK = null;
    private static final Pattern ENTITY_HERE = null;
    private static final Pattern ESCAPABLE = null;
    private static final Pattern FINAL_SPACE = null;
    private static final Pattern HTML_TAG = null;
    private static final Pattern PUNCTUATION = null;
    private static final Pattern SPNL = null;
    private static final Pattern TICKS = null;
    private static final Pattern TICKS_HERE = null;
    private static final Pattern UNICODE_WHITESPACE_CHAR = null;
    private static final Pattern WHITESPACE = null;
    private final InlineParserContext context;
    private final BitSet delimiterCharacters;
    private final Map<Character, DelimiterProcessor> delimiterProcessors;
    private int index;
    private String input;
    private Bracket lastBracket;
    private Delimiter lastDelimiter;
    private final BitSet specialCharacters;

    private static class DelimiterData {
        final boolean canClose;
        final boolean canOpen;
        final int count;

        DelimiterData(int r1, boolean r2, boolean r3) {
            this.count = r1;
            this.canOpen = r2;
            this.canClose = r3;
        }
    }

    static {
        PUNCTUATION = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
        HTML_TAG = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-_]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-_]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
        ESCAPABLE = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
        ENTITY_HERE = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
        TICKS = Pattern.compile("`+");
        TICKS_HERE = Pattern.compile("^`+");
        EMAIL_AUTOLINK = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
        AUTOLINK = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
        SPNL = Pattern.compile("^ *(?:\n *)?");
        UNICODE_WHITESPACE_CHAR = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
        WHITESPACE = Pattern.compile("\\s+");
        FINAL_SPACE = Pattern.compile(" *$");
    }

    public InlineParserImpl(InlineParserContext r3) {
        InlineParserContext r4 = (InlineParserContext) ZeusTransformUtils.wrapperContextForParams(r3, InlineParserContext.class, "com.obric.memorydata.plugin");
        Map<Character, DelimiterProcessor> r0 = calculateDelimiterProcessors(r4.getCustomDelimiterProcessors());
        this.delimiterProcessors = r0;
        BitSet r1 = calculateDelimiterCharacters(r0.keySet());
        this.delimiterCharacters = r1;
        this.specialCharacters = calculateSpecialCharacters(r1);
        this.context = r4;
    }

    private void addBracket(Bracket r3) {
        Bracket r0 = this.lastBracket;
        if (r0 == null) goto L5;
        r0.bracketAfter = true;
    L5:
        this.lastBracket = r3;
    }

    private static void addDelimiterProcessorForChar(char r2, DelimiterProcessor r3, Map<Character, DelimiterProcessor> r4) {
        if (((DelimiterProcessor) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).put(Character.valueOf(r2), (DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r3, DelimiterProcessor.class, "com.obric.memorydata.plugin")), DelimiterProcessor.class, "com.obric.memorydata.plugin")) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + r2 + "'");
    }

    private static void addDelimiterProcessors(Iterable<DelimiterProcessor> r6, Map<Character, DelimiterProcessor> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L18;
        DelimiterProcessor r0 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(r10.next(), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        char r2 = r0.getOpeningCharacter();
        char r3 = r0.getClosingCharacter();
        if (r2 == r3) goto L7;
        addDelimiterProcessorForChar(r2, r0, r9);
        addDelimiterProcessorForChar(r3, r0, r9);
        goto L4
    L7:
        DelimiterProcessor r4 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(r9.get(Character.valueOf(r2)), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L16;
        if (r4.getOpeningCharacter() != r4.getClosingCharacter()) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, StaggeredDelimiterProcessor.class) == false) goto L14;
        StaggeredDelimiterProcessor r5 = (StaggeredDelimiterProcessor) ZeusTransformUtils.preCheckCast(r4, StaggeredDelimiterProcessor.class, "com.obric.memorydata.plugin");
    L15:
        r5.add(r0);
        r9.put(Character.valueOf(r2), r5);
        goto L4
    L14:
        StaggeredDelimiterProcessor r11 = new StaggeredDelimiterProcessor(r2);
        r11.add(r4);
        r5 = r11;
    L16:
        addDelimiterProcessorForChar(r2, r0, r9);
        goto L4
    }

    public static BitSet calculateDelimiterCharacters(Set<Character> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        BitSet r0 = new BitSet();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.set(((Character) ZeusTransformUtils.preCheckCast(r6.next(), Character.class, "com.obric.memorydata.plugin")).charValue());
        goto L4
    L6:
        return r0;
    }

    public static Map<Character, DelimiterProcessor> calculateDelimiterProcessors(List<DelimiterProcessor> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        addDelimiterProcessors(Arrays.asList(new DelimiterProcessor[]{new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()}), r0);
        addDelimiterProcessors(r5, r0);
        return r0;
    }

    public static BitSet calculateSpecialCharacters(BitSet r1) {
        BitSet r0 = new BitSet();
        r0.or(r1);
        r0.set(10);
        r0.set(96);
        r0.set(91);
        r0.set(93);
        r0.set(92);
        r0.set(33);
        r0.set(60);
        r0.set(38);
        return r0;
    }

    private String match(Pattern r4) {
        if (this.index < this.input.length()) goto L5;
        return null;
    L5:
        Matcher r5 = r4.matcher(this.input);
        r5.region(this.index, this.input.length());
        if (r5.find() == false) goto L9;
        this.index = r5.end();
        return r5.group();
    L9:
        return null;
    }

    private void mergeChildTextNodes(Node r3) {
        if (r3.getFirstChild() != r3.getLastChild()) goto L5;
        return;
    L5:
        mergeTextNodesInclusive(r3.getFirstChild(), r3.getLastChild());
    }

    private void mergeIfNeeded(Text r3, Text r4, int r5) {
        if (r3 == null) goto L11;
        if (r4 == null) goto L12;
        if (r3 == r4) goto L13;
        StringBuilder r2 = new StringBuilder(r5);
        r2.append(r3.getLiteral());
        Node r6 = r3.getNext();
        Node r7 = r4.getNext();
    L6:
        if (r6 == r7) goto L8;
        r2.append(((Text) ZeusTransformUtils.preCheckCast(r6, Text.class, "com.obric.memorydata.plugin")).getLiteral());
        Node r0 = r6.getNext();
        r6.unlink();
        r6 = r0;
        goto L6
    L8:
        r3.setLiteral(r2.toString());
        return;
    L13:
        return;
    L12:
        return;
    }

    private void mergeTextNodesBetweenExclusive(Node r2, Node r3) {
        if (r2 != r3) goto L4;
        return;
    L4:
        if (r2.getNext() == r3) goto L9;
        mergeTextNodesInclusive(r2.getNext(), r3.getPrevious());
        return;
    }

    private void mergeTextNodesInclusive(Node r7, Node r8) {
        int r4 = 0;
        Text r2 = null;
        Text r3 = null;
    L3:
        if (r7 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r7, Text.class) == false) goto L10;
        r3 = (Text) ZeusTransformUtils.preCheckCast(r7, Text.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        r2 = r3;
    L9:
        r4 = r4 + r3.getLiteral().length();
    L11:
        if (r7 == r8) goto L14;
        r7 = r7.getNext();
        goto L3
    L10:
        mergeIfNeeded(r2, r3, r4);
        r4 = 0;
        r2 = null;
        r3 = null;
    L14:
        mergeIfNeeded(r2, r3, r4);
    }

    private Node parseAutolink() {
        String r0 = match(EMAIL_AUTOLINK);
        if (r0 == null) goto L7;
        String r4 = r0.substring(1, r0.length() - 1);
        Link r1 = new Link(MailTo.MAILTO_SCHEME + r4, null);
        Text r2 = new Text(r4);
    L5:
        r1.appendChild(r2);
        return r1;
    L7:
        String r5 = match(AUTOLINK);
        if (r5 == null) goto L10;
        String r6 = r5.substring(1, r5.length() - 1);
        r1 = new Link(r6, null);
        r2 = new Text(r6);
        goto L5
    L10:
        return null;
    }

    private Node parseBackslash() {
        this.index++;
        if (peek() != '\n') goto L7;
        Node r0 = new HardLineBreak();
    L5:
        this.index++;
        return r0;
    L7:
        if (this.index >= this.input.length()) goto L12;
        Pattern r1 = ESCAPABLE;
        String r2 = this.input;
        int r3 = this.index;
        if (r1.matcher(r2.substring(r3, r3 + 1)).matches() == false) goto L12;
        String r4 = this.input;
        int r5 = this.index;
        r0 = text(r4, r5, r5 + 1);
    L12:
        return text("\\");
    }

    private Node parseBackticks() {
        String r0 = match(TICKS_HERE);
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = this.index;
    L7:
        String r2 = match(TICKS);
        if (r2 == null) goto L22;
        if (r2.equals(r0) == false) goto L7;
        Code r3 = new Code();
        String r4 = this.input.substring(r1, this.index - r0.length()).replace('\n', ' ');
        if (r4.length() >= 3) goto L14;
    L20:
        r3.setLiteral(r4);
        return r3;
    L14:
        if (r4.charAt(0) != ' ') goto L20;
        if (r4.charAt(r4.length() - 1) != ' ') goto L20;
        if (Parsing.hasNonSpace(r4) == false) goto L20;
        r4 = r4.substring(1, r4.length() - 1);
        goto L20
    L22:
        this.index = r1;
        return text(r0);
    }

    private Node parseBang() {
        int r0 = this.index;
        this.index = r0 + 1;
        if (peek() != '[') goto L7;
        this.index++;
        Text r1 = text("![");
        addBracket(Bracket.image(r1, r0 + 1, this.lastBracket, this.lastDelimiter));
        return r1;
    L7:
        return text("!");
    }

    private Node parseCloseBracket() {
        boolean r1 = true;
        int r0 = this.index + 1;
        this.index = r0;
        Bracket r2 = this.lastBracket;
        if (r2 != null) goto L7;
        return text("]");
    L7:
        if (r2.allowed == true) goto L10;
    L8:
        removeLastBracket();
        return text("]");
    L10:
        String r7 = null;
        if (peek() != '(') goto L23;
        this.index++;
        spnl();
        String r4 = parseLinkDestination();
        if (r4 == null) goto L22;
        spnl();
        Pattern r5 = WHITESPACE;
        String r8 = this.input;
        int r9 = this.index;
        if (r5.matcher(r8.substring(r9 - 1, r9)).matches() == false) goto L17;
        String r6 = parseLinkTitle();
        spnl();
    L19:
        if (peek() != ')') goto L21;
        this.index++;
        boolean r10 = true;
    L24:
        if (r10 == true) goto L35;
        int r11 = this.index;
        parseLinkLabel();
        int r12 = this.index - r11;
        if (r12 <= 2) goto L29;
        r7 = this.input.substring(r11, r12 + r11);
    L31:
        if (r7 == null) goto L35;
        LinkReferenceDefinition r13 = this.context.getLinkReferenceDefinition(Escaping.normalizeReference(r7));
        if (r13 == null) goto L35;
        r4 = r13.getDestination();
        r6 = r13.getTitle();
    L36:
        if (r1 == true) goto L38;
        this.index = r0;
        goto L8
    L38:
        if (r2.image == false) goto L40;
        Node r3 = new Image(r4, r6);
    L41:
        Node r14 = r2.node.getNext();
    L42:
        if (r14 == null) goto L44;
        Node r15 = r14.getNext();
        r3.appendChild(r14);
        r14 = r15;
        goto L42
    L44:
        processDelimiters(r2.previousDelimiter);
        mergeChildTextNodes(r3);
        r2.node.unlink();
        removeLastBracket();
        if (r2.image == true) goto L52;
        Bracket r16 = this.lastBracket;
    L47:
        if (r16 == null) goto L52;
        if (r16.image == true) goto L51;
        r16.allowed = false;
    L51:
        r16 = r16.previous;
    L52:
        return r3;
    L40:
        r3 = new Link(r4, r6);
        goto L41
    L29:
        if (r2.bracketAfter == true) goto L31;
        r7 = this.input.substring(r2.index, r0);
    L35:
        r1 = r10;
        goto L36
    L21:
        this.index = r0;
        r10 = false;
        goto L24
    L17:
        r6 = null;
        goto L19
    L22:
        r10 = false;
        r6 = null;
        goto L24
    L23:
        r10 = false;
        r4 = null;
        r6 = null;
        goto L24
    }

    private Node parseDelimiters(DelimiterProcessor r11, char r12) {
        DelimiterData r13 = scanDelimiters((DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r11, DelimiterProcessor.class, "com.obric.memorydata.plugin"), r12);
        if (r13 != null) goto L6;
        return null;
    L6:
        int r0 = r13.count;
        int r1 = this.index;
        int r2 = r1 + r0;
        this.index = r2;
        Text r3 = text(this.input, r1, r2);
        Delimiter r4 = new Delimiter(r3, r12, r13.canOpen, r13.canClose, this.lastDelimiter);
        this.lastDelimiter = r4;
        r4.length = r0;
        this.lastDelimiter.originalLength = r0;
        if (this.lastDelimiter.previous == null) goto L9;
        Delimiter r14 = this.lastDelimiter.previous;
        r14.next = this.lastDelimiter;
    L9:
        return r3;
    }

    private Node parseEntity() {
        String r0 = match(ENTITY_HERE);
        if (r0 != null) goto L5;
        return null;
    L5:
        return text(Html5Entities.entityToString(r0));
    }

    private Node parseHtmlInline() {
        String r1 = match(HTML_TAG);
        if (r1 == null) goto L6;
        HtmlInline r0 = new HtmlInline();
        r0.setLiteral(r1);
        return r0;
    L6:
        return null;
    }

    private Node parseInline(Node r4) {
        char r0 = peek();
        if (r0 != 0) goto L7;
        return null;
    L7:
        if (r0 != '\n') goto L9;
        Node r5 = parseNewline(r4);
    L31:
        if (r5 == null) goto L33;
        return r5;
    L33:
        this.index++;
        return text(String.valueOf(r0));
    L9:
        if (r0 != '!') goto L11;
        r5 = parseBang();
        goto L31
    L11:
        if (r0 != '&') goto L13;
        r5 = parseEntity();
        goto L31
    L13:
        if (r0 != '<') goto L15;
        r5 = parseAutolink();
        if (r5 != null) goto L31;
        r5 = parseHtmlInline();
        goto L31
    L15:
        if (r0 == '`') goto L24;
        switch(r0) {
            case 91: goto L23;
            case 92: goto L22;
            case 93: goto L21;
            default: goto L18;
        };
    L21:
        r5 = parseCloseBracket();
        goto L31
    L22:
        r5 = parseBackslash();
        goto L31
    L23:
        r5 = parseOpenBracket();
        goto L31
    L18:
        if (this.delimiterCharacters.get(r0) == false) goto L20;
        r5 = parseDelimiters((DelimiterProcessor) ZeusTransformUtils.preCheckCast(this.delimiterProcessors.get(Character.valueOf(r0)), DelimiterProcessor.class, "com.obric.memorydata.plugin"), r0);
        goto L31
    L20:
        r5 = parseString();
        goto L31
    L24:
        r5 = parseBackticks();
        goto L31
    }

    private String parseLinkDestination() {
        int r0 = LinkScanner.scanLinkDestination(this.input, this.index);
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        if (peek() != '<') goto L9;
        String r1 = this.input.substring(this.index + 1, r0 - 1);
    L10:
        this.index = r0;
        return Escaping.unescapeString(r1);
    L9:
        r1 = this.input.substring(this.index, r0);
        goto L10
    }

    private String parseLinkTitle() {
        int r0 = LinkScanner.scanLinkTitle(this.input, this.index);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        String r1 = this.input.substring(this.index + 1, r0 - 1);
        this.index = r0;
        return Escaping.unescapeString(r1);
    }

    private Node parseNewline(Node r4) {
        this.index++;
        if (ZeusTransformUtils.instanceOf(r4, Text.class) == false) goto L19;
        if (((Text) ZeusTransformUtils.preCheckCast(r4, Text.class, "com.obric.memorydata.plugin")).getLiteral().endsWith(" ") == false) goto L19;
        Text r3 = (Text) ZeusTransformUtils.preCheckCast(r4, Text.class, "com.obric.memorydata.plugin");
        String r5 = r3.getLiteral();
        Matcher r0 = FINAL_SPACE.matcher(r5);
        if (r0.find() == false) goto L9;
        int r1 = r0.end() - r0.start();
    L10:
        if (r1 <= 0) goto L13;
        r3.setLiteral(r5.substring(0, r5.length() - r1));
    L13:
        if (r1 < 2) goto L17;
        return new HardLineBreak();
    L17:
        return new SoftLineBreak();
    L9:
        r1 = 0;
    L19:
        return new SoftLineBreak();
    }

    private Node parseOpenBracket() {
        int r0 = this.index;
        this.index = r0 + 1;
        Text r1 = text("[");
        addBracket(Bracket.link(r1, r0, this.lastBracket, this.lastDelimiter));
        return r1;
    }

    private Node parseString() {
        int r0 = this.index;
        int r1 = this.input.length();
    L3:
        int r2 = this.index;
        if (r2 == r1) goto L9;
        if (this.specialCharacters.get(this.input.charAt(r2)) == true) goto L9;
        this.index++;
    L9:
        int r3 = this.index;
        if (r0 != r3) goto L12;
        return null;
    L12:
        return text(this.input, r0, r3);
    }

    private char peek() {
        if (this.index < this.input.length()) goto L5;
        return 0;
    L5:
        return this.input.charAt(this.index);
    }

    private void processDelimiters(Delimiter r12) {
        HashMap r0 = new HashMap();
        Delimiter r1 = this.lastDelimiter;
    L3:
        if (r1 == null) goto L7;
        if (r1.previous == r12) goto L7;
        r1 = r1.previous;
    L7:
        if (r1 == null) goto L39;
        char r2 = r1.delimiterChar;
        DelimiterProcessor r3 = (DelimiterProcessor) ZeusTransformUtils.preCheckCast(this.delimiterProcessors.get(Character.valueOf(r2)), DelimiterProcessor.class, "com.obric.memorydata.plugin");
        if (r1.canClose == false) goto L38;
        if (r3 == null) goto L38;
        char r4 = r3.getOpeningCharacter();
        Delimiter r5 = r1.previous;
        int r7 = 0;
        boolean r8 = false;
    L13:
        boolean r9 = true;
        if (r5 == null) goto L26;
        if (r5 == r12) goto L26;
        if (r5 == r0.get(Character.valueOf(r2))) goto L26;
        if (r5.canOpen == false) goto L25;
        if (r5.delimiterChar != r4) goto L25;
        r7 = r3.getDelimiterUse(r5, r1);
        r8 = true;
        if (r7 <= 0) goto L25;
    L27:
        if (r9 == true) goto L32;
        if (r8 == true) goto L38;
        r0.put(Character.valueOf(r2), r1.previous);
        if (r1.canOpen == true) goto L38;
        removeDelimiterKeepNode(r1);
        goto L38
    L32:
        Text r6 = r5.node;
        Text r10 = r1.node;
        r5.length -= r7;
        r1.length -= r7;
        r6.setLiteral(r6.getLiteral().substring(0, r6.getLiteral().length() - r7));
        r10.setLiteral(r10.getLiteral().substring(0, r10.getLiteral().length() - r7));
        removeDelimitersBetween(r5, r1);
        mergeTextNodesBetweenExclusive(r6, r10);
        r3.process(r6, r10, r7);
        if (r5.length != 0) goto L36;
        removeDelimiterAndNode(r5);
    L36:
        if (r1.length != 0) goto L7;
        Delimiter r11 = r1.next;
        removeDelimiterAndNode(r1);
        r1 = r11;
    L25:
        r5 = r5.previous;
    L26:
        r9 = false;
    L38:
        r1 = r1.next;
    L39:
        Delimiter r13 = this.lastDelimiter;
        if (r13 == null) goto L43;
        if (r13 == r12) goto L66;
        removeDelimiterKeepNode(r13);
        goto L39
    L66:
        return;
    }

    private void removeDelimiter(Delimiter r3) {
        if (r3.previous == null) goto L6;
        Delimiter r0 = r3.previous;
        r0.next = r3.next;
    L6:
        if (r3.next != null) goto L8;
        this.lastDelimiter = r3.previous;
        return;
    L8:
        Delimiter r2 = r3.next;
        r2.previous = r3.previous;
    }

    private void removeDelimiterAndNode(Delimiter r2) {
        r2.node.unlink();
        removeDelimiter(r2);
    }

    private void removeDelimiterKeepNode(Delimiter r1) {
        removeDelimiter(r1);
    }

    private void removeDelimitersBetween(Delimiter r2, Delimiter r3) {
        Delimiter r4 = r3.previous;
    L3:
        if (r4 == null) goto L6;
        if (r4 == r2) goto L9;
        Delimiter r0 = r4.previous;
        removeDelimiterKeepNode(r4);
        r4 = r0;
        goto L3
    L9:
        return;
    }

    private void removeLastBracket() {
        this.lastBracket = this.lastBracket.previous;
    }

    private DelimiterData scanDelimiters(DelimiterProcessor r10, char r11) {
        DelimiterProcessor r12 = (DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r10, DelimiterProcessor.class, "com.obric.memorydata.plugin");
        int r0 = this.index;
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (peek() != r11) goto L7;
        r2 = r2 + 1;
        this.index++;
        goto L4
    L7:
        if (r2 >= r12.getMinLength()) goto L10;
        this.index = r0;
        return null;
    L10:
        String r3 = "\n";
        if (r0 != 0) goto L13;
        String r5 = "\n";
    L14:
        char r6 = peek();
        if (r6 == 0) goto L18;
        r3 = String.valueOf(r6);
    L18:
        Pattern r7 = PUNCTUATION;
        boolean r8 = r7.matcher(r5).matches();
        Pattern r9 = UNICODE_WHITESPACE_CHAR;
        boolean r13 = r9.matcher(r5).matches();
        boolean r14 = r7.matcher(r3).matches();
        boolean r4 = r9.matcher(r3).matches();
        if (r4 == true) goto L24;
        if (r14 == false) goto L23;
        if (r13 == true) goto L23;
        if (r8 == false) goto L24;
    L23:
        boolean r15 = true;
    L25:
        if (r13 == true) goto L30;
        if (r8 == false) goto L29;
        if (r4 == true) goto L29;
        if (r14 == false) goto L30;
    L29:
        boolean r16 = true;
    L32:
        if (r11 != '_') goto L42;
        if (r15 == false) goto L37;
        if (r16 == false) goto L36;
        if (r8 == false) goto L37;
    L36:
        boolean r17 = true;
    L38:
        if (r16 == false) goto L52;
        if (r15 == false) goto L41;
        if (r14 == false) goto L52;
    L41:
        r1 = true;
    L52:
        this.index = r0;
        return new DelimiterData(r2, r17, r1);
    L37:
        r17 = false;
        goto L38
    L42:
        if (r15 == true) goto L44;
    L46:
        boolean r18 = false;
    L47:
        if (r16 == true) goto L49;
    L51:
        r17 = r18;
        goto L52
    L49:
        if (r11 != r12.getClosingCharacter()) goto L51;
        r1 = true;
        goto L51
    L44:
        if (r11 != r12.getOpeningCharacter()) goto L46;
        r18 = true;
    L30:
        r16 = false;
    L24:
        r15 = false;
        goto L25
    L13:
        r5 = this.input.substring(r0 - 1, r0);
        goto L14
    }

    private void spnl() {
        match(SPNL);
    }

    private Text text(String r1) {
        return new Text(r1);
    }

    private Text text(String r1, int r2, int r3) {
        return new Text(r1.substring(r2, r3));
    }

    @Override // org.commonmark.parser.InlineParser
    public void parse(String r2, Node r3) {
        reset(r2.trim());
        Node r0 = null;
    L3:
        r0 = parseInline(r0);
        if (r0 == null) goto L6;
        r3.appendChild(r0);
        goto L3
    L6:
        processDelimiters(null);
        mergeChildTextNodes(r3);
    }

    int parseLinkLabel() {
        if (this.index < this.input.length()) goto L5;
    L19:
        return 0;
    L5:
        if (this.input.charAt(this.index) != '[') goto L19;
        int r0 = this.index + 1;
        int r1 = LinkScanner.scanLinkLabelContent(this.input, r0);
        int r2 = r1 - r0;
        if (r1 == (-1)) goto L19;
        if (r2 > 999) goto L19;
        if (r1 >= this.input.length()) goto L19;
        if (this.input.charAt(r1) != ']') goto L19;
        this.index = r1 + 1;
        return r2 + 2;
    }

    void reset(String r1) {
        this.input = r1;
        this.index = 0;
        this.lastDelimiter = null;
        this.lastBracket = null;
    }
}
