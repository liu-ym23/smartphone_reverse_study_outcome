package androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRInputStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.BailErrorStrategy;
import androidx.room.jarjarred.org.antlr.v4.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.ListTokenSource;
import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserInterpreter;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MultiMap;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.ParseCancellationException;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.RuleNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParseTreePatternMatcher {
    protected String escape;
    private final Lexer lexer;
    private final Parser parser;
    protected String start;
    protected String stop;

    public static class CannotInvokeStartRule extends RuntimeException {
        public CannotInvokeStartRule(Throwable r5) {
            super(r5);
        }
    }

    public static class StartRuleDoesNotConsumeFullPattern extends RuntimeException {
        public StartRuleDoesNotConsumeFullPattern() {
        }
    }

    public ParseTreePatternMatcher(Lexer r5, Parser r10) {
        this.start = "<";
        this.stop = ">";
        this.escape = "\\";
        this.lexer = r5;
        this.parser = r10;
    }

    public ParseTreePattern compile(String r10, int r11) {
        CommonTokenStream r5 = new CommonTokenStream(new ListTokenSource(tokenize(r10)));
        ParserInterpreter r12 = new ParserInterpreter(this.parser.getGrammarFileName(), this.parser.getVocabulary(), Arrays.asList(this.parser.getRuleNames()), this.parser.getATNWithBypassAlts(), r5);
        r12.setErrorHandler(new BailErrorStrategy());     // Catch: Exception -> L10 RecognitionException -> L12 ParseCancellationException -> L14
        ParserRuleContext r13 = r12.parse(r11);     // Catch: Exception -> L10 RecognitionException -> L12 ParseCancellationException -> L14
    L5:
        if (r5.LA(1) != (-1)) goto L9;
        return new ParseTreePattern(this, r10, r11, r13);
    L9:
        throw new StartRuleDoesNotConsumeFullPattern();
    L12:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        throw ((RecognitionException) e.getCause());
    L10:
        e = move-exception;
        throw new CannotInvokeStartRule(e);
    }

    public Lexer getLexer() {
        return this.lexer;
    }

    public Parser getParser() {
        return this.parser;
    }

    public RuleTagToken getRuleTagToken(ParseTree r5) {
        if ((r5 instanceof RuleNode) == false) goto L12;
        RuleNode r10 = (RuleNode) r5;
        if (r10.getChildCount() == 1) goto L7;
        return null;
    L7:
        if ((r10.getChild(0) instanceof TerminalNode) == false) goto L15;
        TerminalNode r11 = (TerminalNode) r10.getChild(0);
        if ((r11.getSymbol() instanceof RuleTagToken) == true) goto L11;
        return null;
    L11:
        return (RuleTagToken) r11.getSymbol();
    L15:
        return null;
    L12:
        return null;
    }

    public ParseTreeMatch match(ParseTree r5, String r10, int r11) {
        return match(r5, compile(r10, r11));
    }

    public ParseTree matchImpl(ParseTree r10, ParseTree r11, MultiMap<String, ParseTree> r12) {
        if (r10 == null) goto L47;
        if (r11 == null) goto L45;
        if ((r10 instanceof TerminalNode) == false) goto L21;
        if ((r11 instanceof TerminalNode) == false) goto L21;
        TerminalNode r5 = (TerminalNode) r10;
        TerminalNode r13 = (TerminalNode) r11;
        if (r5.getSymbol().getType() != r13.getSymbol().getType()) goto L19;
        if ((r13.getSymbol() instanceof TokenTagToken) == false) goto L16;
        TokenTagToken r14 = (TokenTagToken) r13.getSymbol();
        r12.map(r14.getTokenName(), r10);
        if (r14.getLabel() == null) goto L50;
        r12.map(r14.getLabel(), r10);
        return null;
    L50:
        return null;
    L16:
        if (r5.getText().equals(r13.getText()) == false) goto L19;
        return null;
    L19:
        return r5;
    L21:
        if ((r10 instanceof ParserRuleContext) == true) goto L23;
    L43:
        return r10;
    L23:
        if ((r11 instanceof ParserRuleContext) == false) goto L43;
        ParserRuleContext r15 = (ParserRuleContext) r10;
        ParserRuleContext r16 = (ParserRuleContext) r11;
        RuleTagToken r17 = getRuleTagToken(r16);
        if (r17 == null) goto L34;
        if (r15.getRuleContext().getRuleIndex() != r16.getRuleContext().getRuleIndex()) goto L32;
        r12.map(r17.getRuleName(), r10);
        if (r17.getLabel() == null) goto L53;
        r12.map(r17.getLabel(), r10);
        return null;
    L53:
        return null;
    L32:
        return r15;
    L34:
        if (r15.getChildCount() == r16.getChildCount()) goto L36;
        return r15;
    L36:
        int r18 = r15.getChildCount();
        int r19 = 0;
    L37:
        if (r19 >= r18) goto L42;
        ParseTree r20 = matchImpl(r15.getChild(r19), r11.getChild(r19), r12);
        if (r20 != null) goto L40;
        r19 = r19 + 1;
        goto L37
    L40:
        return r20;
    L42:
        return null;
    L45:
        throw new IllegalArgumentException("patternTree cannot be null");
    L47:
        throw new IllegalArgumentException("tree cannot be null");
    }

    public boolean matches(ParseTree r5, String r10, int r11) {
        return matches(r5, compile(r10, r11));
    }

    public void setDelimiters(String r5, String r10, String r11) {
        if (r5 == null) goto L13;
        if (r5.isEmpty() == true) goto L13;
        if (r10 == null) goto L11;
        if (r10.isEmpty() == true) goto L11;
        this.start = r5;
        this.stop = r10;
        this.escape = r11;
        return;
    L11:
        throw new IllegalArgumentException("stop cannot be null or empty");
    L13:
        throw new IllegalArgumentException("start cannot be null or empty");
    }

    public List<Chunk> split(String r12) {
        int r5 = r12.length();
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        ArrayList r13 = new ArrayList();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r5) goto L20;
        if (r15 == r12.indexOf(this.escape + this.start, r15)) goto L6;
        if (r15 == r12.indexOf(this.escape + this.stop, r15)) goto L10;
        if (r15 == r12.indexOf(this.start, r15)) goto L13;
        if (r15 == r12.indexOf(this.stop, r15)) goto L17;
        r15 = r15 + 1;
        goto L3
    L17:
        r13.add(Integer.valueOf(r15));
        int r16 = this.stop.length();
    L14:
        r15 = r15 + r16;
        goto L3
    L13:
        r11.add(Integer.valueOf(r15));
        r16 = this.start.length();
        goto L14
    L10:
        int r17 = this.escape.length();
        int r18 = this.stop.length();
    L7:
        r15 = r15 + (r18 + r17);
        goto L3
    L6:
        r17 = this.escape.length();
        r18 = this.start.length();
        goto L7
    L20:
        if (r11.size() > r13.size()) goto L62;
        if (r11.size() < r13.size()) goto L60;
        int r19 = r11.size();
        int r20 = 0;
    L24:
        if (r20 >= r19) goto L30;
        if (((Integer) r11.get(r20)).intValue() >= ((Integer) r13.get(r20)).intValue()) goto L29;
        r20 = r20 + 1;
        goto L24
    L29:
        throw new IllegalArgumentException("tag delimiters out of order in pattern: ".concat(r12));
    L30:
        if (r19 != 0) goto L32;
        r10.add(new TextChunk(r12.substring(0, r5)));
    L32:
        if (r19 > 0) goto L34;
    L36:
        int r21 = 0;
    L37:
        if (r21 >= r19) goto L46;
        String r22 = r12.substring(this.start.length() + ((Integer) r11.get(r21)).intValue(), ((Integer) r13.get(r21)).intValue());
        int r23 = r22.indexOf(58);
        if (r23 < 0) goto L41;
        String r24 = r22.substring(0, r23);
        r22 = r22.substring(r23 + 1, r22.length());
    L42:
        r10.add(new TagChunk(r24, r22));
        int r25 = r21 + 1;
        if (r25 >= r19) goto L45;
        r10.add(new TextChunk(r12.substring(this.stop.length() + ((Integer) r13.get(r21)).intValue(), ((Integer) r11.get(r25)).intValue())));
    L45:
        r21 = r25;
        goto L37
    L41:
        r24 = null;
        goto L42
    L46:
        if (r19 <= 0) goto L51;
        int r26 = this.stop.length() + ((Integer) r13.get(r19 - 1)).intValue();
        if (r26 >= r5) goto L51;
        r10.add(new TextChunk(r12.substring(r26, r5)));
    L51:
        if (r14 >= r10.size()) goto L58;
        Chunk r110 = (Chunk) r10.get(r14);
        if ((r110 instanceof TextChunk) == false) goto L57;
        TextChunk r111 = (TextChunk) r110;
        String r27 = r111.getText().replace(this.escape, "");
        if (r27.length() >= r111.getText().length()) goto L57;
        r10.set(r14, new TextChunk(r27));
    L57:
        r14 = r14 + 1;
        goto L51
    L58:
        return r10;
    L34:
        if (((Integer) r11.get(0)).intValue() <= 0) goto L36;
        r10.add(new TextChunk(r12.substring(0, ((Integer) r11.get(0)).intValue())));
        goto L36
    L60:
        throw new IllegalArgumentException("missing start tag in pattern: ".concat(r12));
    L62:
        throw new IllegalArgumentException("unterminated tag in pattern: ".concat(r12));
    }

    public List<? extends Token> tokenize(String r10) {
        List<Chunk> r5 = split(r10);
        ArrayList r11 = new ArrayList();
        Iterator<Chunk> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L27;
        Chunk r13 = r12.next();
        if ((r13 instanceof TagChunk) == true) goto L7;
        ANTLRInputStream r14 = new ANTLRInputStream(((TextChunk) r13).getText());
        this.lexer.setInputStream(r14);
        Token r15 = this.lexer.nextToken();
    L25:
        if (r15.getType() == (-1)) goto L4;
        r11.add(r15);
        r15 = this.lexer.nextToken();
        goto L25
    L7:
        TagChunk r16 = (TagChunk) r13;
        if (Character.isUpperCase(r16.getTag().charAt(0)) == true) goto L9;
        if (Character.isLowerCase(r16.getTag().charAt(0)) == false) goto L22;
        int r17 = this.parser.getRuleIndex(r16.getTag());
        if (r17 == (-1)) goto L20;
        int r18 = this.parser.getATNWithBypassAlts().ruleToTokenType[r17];
        r11.add(new RuleTagToken(r16.getTag(), r18, r16.getLabel()));
        goto L4
    L20:
        throw new IllegalArgumentException(a.t(new StringBuilder("Unknown rule "), r16.getTag(), " in pattern: ", r10));
    L22:
        throw new IllegalArgumentException(a.t(new StringBuilder("invalid tag: "), r16.getTag(), " in pattern: ", r10));
    L9:
        int r19 = this.parser.getTokenType(r16.getTag());
        if (r19 == 0) goto L13;
        r11.add(new TokenTagToken(r16.getTag(), r19, r16.getLabel()));
        goto L4
    L13:
        throw new IllegalArgumentException(a.t(new StringBuilder("Unknown token "), r16.getTag(), " in pattern: ", r10));
    L27:
        return r11;
    }

    public ParseTreeMatch match(ParseTree r5, ParseTreePattern r10) {
        MultiMap<String, ParseTree> r11 = new MultiMap();
        return new ParseTreeMatch(r5, r10, r11, matchImpl(r5, r10.getPatternTree(), r11));
    }

    public boolean matches(ParseTree r5, ParseTreePattern r10) {
        MultiMap<String, ParseTree> r11 = new MultiMap();
        if (matchImpl(r5, r10.getPatternTree(), r11) != null) goto L5;
        return true;
    L5:
        return false;
    }
}
