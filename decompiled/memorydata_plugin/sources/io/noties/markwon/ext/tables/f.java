package io.noties.markwon.ext.tables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes6.dex */
public class f extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TableBlock f16496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<CharSequence> f16497b;
    private final List<TableCell.Alignment> c;
    private final List<String> d;
    private final n e;
    private final StringBuilder f;
    private Boolean g;
    private boolean h;

    public static class a extends AbstractBlockParserFactory {
        public a() {
        }

        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState r4, MatchedBlockParser r5) {
            ParserState r3 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r4, ParserState.class, "com.obric.memorydata.plugin");
            MatchedBlockParser r6 = (MatchedBlockParser) ZeusTransformUtils.wrapperContextForParams(r5, MatchedBlockParser.class, "com.obric.memorydata.plugin");
            CharSequence r7 = r3.getLine();
            CharSequence r8 = r6.getParagraphContent();
            if (r8 == null) goto L17;
            if (r8.toString().contains("|") == false) goto L17;
            if (r8.toString().contains("\n") == true) goto L17;
            List<TableCell.Alignment> r9 = f.b(r7.subSequence(r3.getIndex(), r7.length()));
            if (r9 == null) goto L17;
            if (r9.isEmpty() == true) goto L17;
            List<String> r10 = f.a(r8);
            if (r9.size() < r10.size()) goto L17;
            return BlockStart.of(new BlockParser[]{new f(r9, r10)}).atIndex(r3.getIndex()).replaceActiveBlockParser();
        L17:
            return BlockStart.none();
        }
    }

    public f(List<TableCell.Alignment> r3, List<String> r4) {
        List<TableCell.Alignment> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f16496a = new TableBlock();
        this.f16497b = new ArrayList();
        this.e = new n();
        this.f = new StringBuilder();
        this.g = false;
        this.h = true;
        this.c = r5;
        this.d = r6;
    }

    public f(List<TableCell.Alignment> r3, List<String> r4, String r5, boolean r6) {
        List<TableCell.Alignment> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f16496a = new TableBlock();
        this.f16497b = new ArrayList();
        this.e = new n();
        StringBuilder r0 = new StringBuilder();
        this.f = r0;
        this.g = false;
        this.h = true;
        this.c = r7;
        this.d = r8;
        r0.append(r5);
        r0.append("\n");
        this.g = Boolean.valueOf(r6);
    }

    public static List<String> a(CharSequence r9) {
        String r10 = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString().trim();
        if (r10.startsWith("|") == false) goto L5;
        r10 = r10.substring(1);
    L5:
        ArrayList r0 = new ArrayList();
        StringBuilder r2 = new StringBuilder();
        int r4 = 0;
    L7:
        if (r4 >= r10.length()) goto L21;
        char r5 = r10.charAt(r4);
        if (r5 == '\\') goto L13;
        if (r5 == '|') goto L12;
        r2.append(r5);
    L19:
        r4 = r4 + 1;
        goto L7
    L12:
        r0.add(r2.toString());
        r2.setLength(0);
        goto L19
    L13:
        int r6 = r4 + 1;
        if (r6 < r10.length()) goto L16;
    L18:
        r2.append('\\');
        goto L19
    L16:
        if (r10.charAt(r6) != '|') goto L18;
        r2.append('|');
        r4 = r6;
        goto L19
    L21:
        if (r2.length() <= 0) goto L23;
        r0.add(r2.toString());
    L23:
        return r0;
    }

    private static TableCell.Alignment a(boolean r0, boolean r1) {
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return TableCell.Alignment.CENTER;
    L6:
        if (r0 == true) goto L8;
        if (r1 == true) goto L11;
        return null;
    L11:
        return TableCell.Alignment.RIGHT;
    L8:
        return TableCell.Alignment.LEFT;
    }

    private TableCell a(String r4, int r5, InlineParser r6) {
        InlineParser r7 = (InlineParser) ZeusTransformUtils.wrapperContextForParams(r6, InlineParser.class, "com.obric.memorydata.plugin");
        TableCell r0 = new TableCell();
        if (r5 >= this.c.size()) goto L5;
        r0.setAlignment((TableCell.Alignment) ZeusTransformUtils.preCheckCast(this.c.get(r5), TableCell.Alignment.class, "com.obric.memorydata.plugin"));
    L5:
        r7.parse(r4.trim(), r0);
        return r0;
    }

    public static List<TableCell.Alignment> b(CharSequence r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        int r2 = 0;
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r2 >= r12.length()) goto L42;
        char r5 = r12.charAt(r2);
        boolean r8 = true;
        if (r5 == '\t') goto L41;
        if (r5 == ' ') goto L41;
        if (r5 == '-') goto L19;
        if (r5 == ':') goto L19;
        if (r5 != '|') goto L14;
        r2 = r2 + 1;
        r4 = r4 + 1;
        if (r4 > 1) goto L17;
        r3 = true;
        goto L4
    L17:
        return null;
    L14:
        return null;
    L19:
        if (r4 == 0) goto L21;
    L23:
        if (r5 != ':') goto L25;
        r2 = r2 + 1;
        boolean r6 = true;
    L26:
        boolean r7 = false;
    L28:
        if (r2 >= r12.length()) goto L32;
        if (r12.charAt(r2) != '-') goto L32;
        r2 = r2 + 1;
        r7 = true;
    L32:
        if (r7 == false) goto L33;
        if (r2 < r12.length()) goto L37;
    L39:
        r8 = false;
    L40:
        r0.add(a(r6, r8));
        r4 = 0;
        goto L4
    L37:
        if (r12.charAt(r2) != ':') goto L39;
        r2 = r2 + 1;
        goto L40
    L33:
        return null;
    L25:
        r6 = false;
        goto L26
    L21:
        if (r0.isEmpty() == true) goto L23;
        return null;
    L41:
        r2 = r2 + 1;
        goto L4
    L42:
        if (r3 == true) goto L44;
        return null;
    L44:
        return r0;
    }

    public Node a(Node r3, StringBuilder r4) {
        if (ZeusTransformUtils.instanceOf(r3, Text.class) == false) goto L7;
        r4.append(((Text) ZeusTransformUtils.preCheckCast(r3, Text.class, "com.obric.memorydata.plugin")).getLiteral());
        return r3.next;
    L7:
        if (r3 == null) goto L9;
        Node r1 = r3.firstChild;
    L10:
        if (r1 == null) goto L12;
        r1 = a(r1, r4);
        goto L10
    L12:
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.next;
    L9:
        r1 = null;
        goto L10
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.h == false) goto L5;
        this.h = false;
    L6:
        this.f.append(r4);
        this.f.append("\n");
        return;
    L5:
        this.f16497b.add(r4);
        goto L6
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canHaveLazyContinuationLines() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        super.closeBlock();
        this.e.a("table");
        this.e.b(this.f.toString());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.f16496a;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser r13) {
        InlineParser r14 = (InlineParser) ZeusTransformUtils.wrapperContextForParams(r13, InlineParser.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        int r2 = this.d.size();
        this.f16496a.appendChild(this.e);
        TableHead r3 = new TableHead();
        this.f16496a.appendChild(r3);
        TableRow r4 = new TableRow();
        r3.appendChild(r4);
        int r5 = 0;
    L4:
        if (r5 >= r2) goto L9;
        TableCell r7 = a((String) ZeusTransformUtils.preCheckCast(this.d.get(r5), String.class, "com.obric.memorydata.plugin"), r5, r14);
        r7.setHeader(true);
        r4.appendChild(r7);
        if (this.g.booleanValue() == false) goto L8;
        a(r7, r0);
        r0.append('\t');
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        TableBody r6 = null;
        Iterator<CharSequence> r8 = this.f16497b.iterator();
    L11:
        if (r8.hasNext() == false) goto L29;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.next(), CharSequence.class, "com.obric.memorydata.plugin");
        if (this.g.booleanValue() == false) goto L15;
        r0.append('\n');
    L15:
        List<String> r10 = a(r9);
        TableRow r11 = new TableRow();
        int r12 = 0;
    L16:
        if (r12 >= r2) goto L25;
        if (r12 >= r10.size()) goto L20;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r10.get(r12), String.class, "com.obric.memorydata.plugin");
    L21:
        TableCell r16 = a(r15, r12, r14);
        r11.appendChild(r16);
        if (this.g.booleanValue() == false) goto L24;
        a(r16, r0);
        r0.append('\t');
    L24:
        r12 = r12 + 1;
        goto L16
    L20:
        r15 = "";
        goto L21
    L25:
        if (r6 != null) goto L27;
        r6 = new TableBody();
        this.f16496a.appendChild(r6);
    L27:
        r6.appendChild(r11);
        goto L11
    L29:
        if (this.g.booleanValue() == false) goto L41;
        this.e.c(r0.toString());
        return;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState r2) {
        ParserState r1 = (ParserState) ZeusTransformUtils.wrapperContextForParams(r2, ParserState.class, "com.obric.memorydata.plugin");
        if (r1.getLine().toString().contains("|") == false) goto L7;
        return BlockContinue.atIndex(r1.getIndex());
    L7:
        return BlockContinue.none();
    }
}
