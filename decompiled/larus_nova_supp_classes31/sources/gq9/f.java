package gq9;

import android.text.TextUtils;
import com.flow.cmark.adapter.CMarkNodeJava;
import com.larus.trace.CopyContentTypeString;
import io.noties.markwon.ext.tables.TableTitle;
import io.noties.markwon.ext.tasklist.TaskListItem;
import io.noties.markwon.onetex.LatexMathNode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new d());
        b = LazyKt.lazy(new e());
    }

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    public static b c(CMarkNodeJava r16) {
        if (r16 != null) goto L5;
        return null;
    L5:
        String r2 = r16.typeString;
        char r3 = 'l';
        int r6 = 1;
        if (r2 != null) goto L8;
    L152:
        HtmlInline r4 = new Text();
        ((Text) r4).h = r16.literal;
    L154:
        if ((r4 instanceof TableBlock) == false) goto L254;
        TableBlock r9 = (TableBlock) r4;
        if ((((b) r9).b instanceof TableTitle) == true) goto L254;
        TableTitle r10 = new TableTitle();
        r10.h = CopyContentTypeString.TABLE;
        StringBuilder r11 = new StringBuilder();
        StringBuilder r12 = new StringBuilder();
        if (Intrinsics.areEqual(r16.typeString, CopyContentTypeString.TABLE) == false) goto L246;
        CMarkNodeJava r8 = r16.firstChild;
    L160:
        if (r8 == null) goto L246;
        CMarkNodeJava r13 = r8.firstChild;
        int r15 = 0;
    L163:
        if (r13 == null) goto L196;
        CMarkNodeJava r5 = r13.firstChild;
        if (r5 == null) goto L167;
        String r7 = r5.literal;
    L169:
        if (TextUtils.isEmpty(r7) == true) goto L180;
        if (r13.prev != null) goto L173;
        r11.append('|');
    L173:
        r11.append(r13.content);
        if (a() == false) goto L176;
        b(r13, r12);
    L176:
        r11.append('|');
        if (a() == false) goto L188;
        r12.append('\t');
    L188:
        if (r13.next != null) goto L194;
        r11.append('\n');
        if (a() == false) goto L194;
        if (r8.next == null) goto L194;
        r12.append('\n');
    L194:
        r13 = r13.next;
        r15 = r15 + 1;
        goto L163
    L180:
        if (r13.prev != null) goto L182;
        r11.append('|');
    L182:
        r11.append(r13.content);
        r11.append('|');
        if (a() == false) goto L188;
        b(r13, r12);
        if (r13.next == null) goto L188;
        r12.append('\t');
        goto L188
    L167:
        r7 = null;
        goto L169
    L196:
        if (r8.prev != null) goto L245;
        if (Intrinsics.areEqual(r8.typeString, "table_header") == false) goto L200;
        CMarkNodeJava r14 = r8.firstChild;
    L201:
        r11.append('|');
        if (r6 > r15) goto L243;
        int r17 = 1;
    L204:
        if (r14 != null) goto L206;
    L208:
        boolean r18 = false;
    L210:
        if (r18 == true) goto L217;
        if (r14 != null) goto L213;
    L215:
        boolean r19 = false;
    L216:
        if (r19 == true) goto L217;
    L218:
        r11.append("---");
        if (r14 == null) goto L224;
        if (r14.tableAlignment != 'r') goto L224;
        boolean r20 = true;
    L225:
        if (r20 == true) goto L235;
        if (r14 == null) goto L231;
        if (r14.tableAlignment != 'c') goto L231;
        boolean r21 = true;
    L232:
        if (r21 == true) goto L235;
    L236:
        r11.append('|');
        if (r14 == null) goto L239;
        r14 = r14.next;
    L240:
        if (r17 == r15) goto L243;
        r17 = r17 + 1;
        r3 = 'l';
        goto L204
    L239:
        r14 = null;
    L231:
        r21 = false;
    L235:
        r11.append(':');
    L224:
        r20 = false;
        goto L225
    L213:
        if (r14.tableAlignment != 'c') goto L215;
        r19 = true;
    L217:
        r11.append(':');
        goto L218
    L206:
        if (r14.tableAlignment != r3) goto L208;
        r18 = true;
    L243:
        r11.append('\n');
        goto L245
    L200:
        r14 = null;
    L245:
        r8 = r8.next;
        r3 = 'l';
        r6 = 1;
    L246:
        Pair r1 = TuplesKt.to(r11.toString(), r12.toString());
        r10.i = (String) r1.getFirst();
        if (a() == false) goto L249;
        r10.j = (String) r1.getSecond();
    L249:
        r10.g();
        ((b) r10).a = r9;
        b r22 = ((b) r9).b;
        if (r22 == null) goto L252;
        r22.d = r10;
        ((b) r10).e = r22;
        ((b) r9).b = r10;
    L262:
        CMarkNodeJava r0 = r16.firstChild;
    L263:
        if (r0 == null) goto L277;
        if ((r4 instanceof TableHead) == false) goto L269;
        if ((((b) ((TableHead) r4)).b instanceof TableRow) == false) goto L269;
    L272:
        b r23 = ((b) ((CustomNode) r4)).b;
        if (r23 == null) goto L276;
        r23.b(c(r0));
    L276:
        r0 = r0.next;
    L269:
        if ((r4 instanceof TableBody) == true) goto L271;
    L275:
        r4.b(c(r0));
        goto L276
    L271:
        if ((((b) ((TableBody) r4)).b instanceof TableRow) == false) goto L275;
    L277:
        return r4;
    L252:
        ((b) r9).b = r10;
        ((b) r9).c = r10;
    L254:
        if ((r4 instanceof TableHead) == false) goto L258;
        if (((b) ((TableHead) r4)).b != null) goto L258;
    L261:
        ((CustomNode) r4).b(new TableRow());
    L258:
        if ((r4 instanceof TableBody) == false) goto L262;
        if (((b) ((TableBody) r4)).b != null) goto L262;
    L8:
        switch(r2.hashCode()) {
            case -2069336299: goto L149;
            case -1988194839: goto L145;
            case -1793359477: goto L141;
            case -1601338631: goto L137;
            case -1504954573: goto L125;
            case -972521773: goto L121;
            case -891980137: goto L117;
            case -677424794: goto L108;
            case -594415685: goto L104;
            case -409429085: goto L100;
            case 3059181: goto L96;
            case 3117216: goto L92;
            case 3242771: goto L88;
            case 3321850: goto L74;
            case 3322014: goto L67;
            case 3556653: goto L63;
            case 100313435: goto L59;
            case 110115790: goto L55;
            case 172286122: goto L51;
            case 589402601: goto L47;
            case 714512959: goto L43;
            case 795311618: goto L39;
            case 861720859: goto L35;
            case 877232935: goto L31;
            case 1225721930: goto L27;
            case 1248070172: goto L23;
            case 1285447710: goto L19;
            case 1949288814: goto L15;
            case 2100277677: goto L11;
            default: goto L152;
        };
    L11:
        if (r2.equals("html_inline") == false) goto L152;
        r4 = new HtmlInline();
        r4.h = r16.literal;
        goto L154
    L15:
        if (r2.equals("paragraph") == false) goto L152;
        r4 = new Paragraph();
        goto L154
    L19:
        if (r2.equals("table_header") == false) goto L152;
        r4 = new TableHead();
        goto L154
    L23:
        if (r2.equals("data-inline") == false) goto L152;
        r4 = new HtmlInline();
        r4.h = r16.literal;
        goto L154
    L27:
        if (r2.equals("block_quote") == false) goto L152;
        r4 = new BlockQuote();
        goto L154
    L31:
        if (r2.equals("custom_inline") == false) goto L152;
        r4 = new Text();
        ((Text) r4).h = r16.literal;
        goto L154
    L35:
        if (r2.equals("document") == false) goto L152;
        r4 = new Document();
        goto L154
    L39:
        if (r2.equals("heading") == false) goto L152;
        r4 = new Heading();
        ((Heading) r4).h = r16.headingLevel;
        goto L154
    L43:
        if (r2.equals("custom_block") == false) goto L152;
        r4 = new Text();
        ((Text) r4).h = r16.literal;
        goto L154
    L47:
        if (r2.equals("thematic_break") == false) goto L152;
        r4 = new ThematicBreak();
        goto L154
    L51:
        if (r2.equals("data-block") == false) goto L152;
        r4 = new HtmlBlock();
        ((HtmlBlock) r4).h = r16.literal;
        goto L154
    L55:
        if (r2.equals(CopyContentTypeString.TABLE) == false) goto L152;
        r4 = new TableBlock();
        goto L154
    L59:
        if (r2.equals("image") == false) goto L152;
        r4 = new Image();
        ((Image) r4).h = r16.url;
        ((Image) r4).i = r16.title;
        goto L154
    L63:
        if (r2.equals("text") == false) goto L152;
        r4 = new Text();
        ((Text) r4).h = r16.literal;
        goto L154
    L67:
        if (r2.equals("list") == false) goto L152;
        if (r16.listType != 1) goto L72;
        r4 = new BulletList();
        goto L154
    L72:
        r4 = new OrderedList();
        int r24 = r16.listStartIndex;
        ((OrderedList) r4).i = r24;
        ((OrderedList) r4).j = r24;
        goto L154
    L74:
        if (r2.equals(CopyContentTypeString.LINK) == false) goto L152;
        r4 = new Link();
        ((Link) r4).h = r16.url;
        CMarkNodeJava r25 = r16.firstChild;
        if (r25 == null) goto L79;
        String r26 = r25.typeString;
    L81:
        if (Intrinsics.areEqual(r26, "text") == false) goto L154;
        CMarkNodeJava r27 = r16.firstChild;
        if (r27 == null) goto L85;
        String r28 = r27.literal;
    L86:
        ((Link) r4).i = r28;
        goto L154
    L85:
        r28 = null;
        goto L86
    L79:
        r26 = null;
        goto L81
    L88:
        if (r2.equals("item") == false) goto L152;
        r4 = new ListItem();
        goto L154
    L92:
        if (r2.equals("emph") == false) goto L152;
        r4 = new Emphasis();
        goto L154
    L96:
        if (r2.equals(CopyContentTypeString.CODE) == false) goto L152;
        r4 = new Code();
        ((Code) r4).h = r16.literal;
        goto L154
    L100:
        if (r2.equals("tasklist") == false) goto L152;
        r4 = new TaskListItem(r16.isDone);
        goto L154
    L104:
        if (r2.equals("code_block") == false) goto L152;
        r4 = new FencedCodeBlock();
        ((FencedCodeBlock) r4).l = r16.codeLiteral;
        ((FencedCodeBlock) r4).k = r16.codeLanguage;
        goto L154
    L108:
        if (r2.equals("formula") == false) goto L152;
        r4 = new LatexMathNode();
        if (((Boolean) b.getValue()).booleanValue() == true) goto L113;
    L115:
        ((LatexMathNode) r4).h = r16.formulaLiteral;
        goto L154
    L113:
        if (r16.isFormulaByRedundantSlash == false) goto L115;
        ((LatexMathNode) r4).h = StringsKt.replace$default(r16.formulaLiteral, "\\\\", "\\", false, 4, null);
        goto L154
    L117:
        if (r2.equals("strong") == false) goto L152;
        r4 = new StrongEmphasis();
        goto L154
    L121:
        if (r2.equals("strikethrough") == false) goto L152;
        r4 = new Strikethrough();
        goto L154
    L125:
        if (r2.equals("table_cell") == false) goto L152;
        r4 = new TableCell();
        char r29 = r16.tableAlignment;
        if (r29 == 'c') goto L134;
        if (r29 == 'l') goto L133;
        if (r29 == 'r') goto L132;
        TableCell.Alignment r30 = TableCell.Alignment.LEFT;
    L135:
        ((TableCell) r4).i = r30;
        goto L154
    L132:
        r30 = TableCell.Alignment.RIGHT;
        goto L135
    L133:
        r30 = TableCell.Alignment.LEFT;
        goto L135
    L134:
        r30 = TableCell.Alignment.CENTER;
        goto L135
    L137:
        if (r2.equals("html_block") == false) goto L152;
        r4 = new HtmlBlock();
        ((HtmlBlock) r4).h = r16.literal;
        goto L154
    L141:
        if (r2.equals("linebreak") == false) goto L152;
        r4 = new SoftLineBreak();
        goto L154
    L145:
        if (r2.equals("table_row") == false) goto L152;
        r4 = new TableBody();
        goto L154
    L149:
        if (r2.equals("softbreak") == false) goto L152;
        r4 = new SoftLineBreak();
        goto L154
    }

    public static CMarkNodeJava b(CMarkNodeJava r2, StringBuilder r3) {
        if (Intrinsics.areEqual(r2.typeString, "text") == false) goto L6;
        r3.append(r2.literal);
        return r2.next;
    L6:
        CMarkNodeJava r0 = r2.firstChild;
    L7:
        if (r0 == null) goto L10;
        r0 = b(r0, r3);
        goto L7
    L10:
        return r2.next;
    }
}
