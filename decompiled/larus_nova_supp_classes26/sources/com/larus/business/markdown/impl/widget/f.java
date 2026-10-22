package com.larus.business.markdown.impl.widget;

import io.noties.markwon.ext.tables.TableTitle;
import io.noties.markwon.ext.tasklist.TaskListItem;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
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
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static uvc.b c(uvc.b r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof BlockQuote) == false) goto L6;
        BlockQuote r0 = new BlockQuote();
    L96:
        if (r0 == null) goto L100;
        Map r1 = ((uvc.b) r0).g;
        if (r1 == null) goto L100;
        HashMap r2 = (HashMap) r1;
        r2.putAll(r3.g);
    L100:
        return r0;
    L6:
        if ((r3 instanceof BulletList) == false) goto L9;
        r0 = new BulletList();
        BulletList r4 = (BulletList) r3;
        ((BulletList) r0).i = r4.i;
        ((ListBlock) r0).h = ((ListBlock) r4).h;
        goto L96
    L9:
        if ((r3 instanceof Code) == false) goto L12;
        r0 = new Code();
        ((Code) r0).h = ((Code) r3).h;
        goto L96
    L12:
        if ((r3 instanceof Document) == false) goto L15;
        r0 = new Document();
        goto L96
    L15:
        if ((r3 instanceof Emphasis) == false) goto L18;
        r0 = new Emphasis();
        ((Emphasis) r0).h = ((Emphasis) r3).h;
        goto L96
    L18:
        if ((r3 instanceof FencedCodeBlock) == false) goto L21;
        r0 = new FencedCodeBlock();
        FencedCodeBlock r5 = (FencedCodeBlock) r3;
        ((FencedCodeBlock) r0).h = r5.h;
        ((FencedCodeBlock) r0).i = r5.i;
        ((FencedCodeBlock) r0).j = r5.j;
        ((FencedCodeBlock) r0).k = r5.k;
        ((FencedCodeBlock) r0).l = r5.l;
        goto L96
    L21:
        if ((r3 instanceof HardLineBreak) == false) goto L24;
        r0 = new HardLineBreak();
        goto L96
    L24:
        if ((r3 instanceof Heading) == false) goto L27;
        r0 = new Heading();
        ((Heading) r0).h = ((Heading) r3).h;
        goto L96
    L27:
        if ((r3 instanceof ThematicBreak) == false) goto L30;
        r0 = new ThematicBreak();
        goto L96
    L30:
        if ((r3 instanceof HtmlInline) == false) goto L33;
        r0 = new HtmlInline();
        ((HtmlInline) r0).h = ((HtmlInline) r3).h;
        goto L96
    L33:
        if ((r3 instanceof HtmlBlock) == false) goto L36;
        r0 = new HtmlBlock();
        ((HtmlBlock) r0).h = ((HtmlBlock) r3).h;
        goto L96
    L36:
        if ((r3 instanceof Image) == false) goto L39;
        r0 = new Image();
        Image r6 = (Image) r3;
        ((Image) r0).h = r6.h;
        ((Image) r0).i = r6.i;
        goto L96
    L39:
        if ((r3 instanceof IndentedCodeBlock) == false) goto L42;
        r0 = new IndentedCodeBlock();
        ((IndentedCodeBlock) r0).h = ((IndentedCodeBlock) r3).h;
        goto L96
    L42:
        if ((r3 instanceof Link) == false) goto L45;
        r0 = new Link();
        Link r7 = (Link) r3;
        ((Link) r0).h = r7.h;
        ((Link) r0).i = r7.i;
        goto L96
    L45:
        if ((r3 instanceof ListItem) == false) goto L48;
        r0 = new ListItem();
        goto L96
    L48:
        if ((r3 instanceof OrderedList) == false) goto L51;
        r0 = new OrderedList();
        OrderedList r8 = (OrderedList) r3;
        ((OrderedList) r0).i = r8.i;
        ((OrderedList) r0).k = r8.k;
        goto L96
    L51:
        if ((r3 instanceof Paragraph) == false) goto L54;
        r0 = new Paragraph();
        goto L96
    L54:
        if ((r3 instanceof SoftLineBreak) == false) goto L57;
        r0 = new SoftLineBreak();
        goto L96
    L57:
        if ((r3 instanceof StrongEmphasis) == false) goto L60;
        r0 = new StrongEmphasis();
        ((StrongEmphasis) r0).h = ((StrongEmphasis) r3).h;
        goto L96
    L60:
        if ((r3 instanceof Text) == false) goto L63;
        r0 = new Text();
        ((Text) r0).h = ((Text) r3).h;
        goto L96
    L63:
        if ((r3 instanceof LinkReferenceDefinition) == false) goto L66;
        r0 = new LinkReferenceDefinition();
        LinkReferenceDefinition r9 = (LinkReferenceDefinition) r3;
        ((LinkReferenceDefinition) r0).h = r9.h;
        ((LinkReferenceDefinition) r0).i = r9.i;
        ((LinkReferenceDefinition) r0).j = r9.j;
        goto L96
    L66:
        if ((r3 instanceof LatexMathBlock) == false) goto L69;
        r0 = new LatexMathBlock();
        ((LatexMathBlock) r0).h = ((LatexMathBlock) r3).h;
        goto L96
    L69:
        if ((r3 instanceof TaskListItem) == false) goto L72;
        r0 = new TaskListItem(((TaskListItem) r3).h);
        goto L96
    L72:
        if ((r3 instanceof TableBlock) == false) goto L75;
        r0 = new TableBlock();
        goto L96
    L75:
        if ((r3 instanceof LatexMathNode) == false) goto L78;
        r0 = new LatexMathNode();
        ((LatexMathNode) r0).h = ((LatexMathNode) r3).h;
        goto L96
    L78:
        if ((r3 instanceof TableTitle) == false) goto L81;
        r0 = new TableTitle();
        TableTitle r10 = (TableTitle) r3;
        ((TableTitle) r0).h = r10.h;
        ((TableTitle) r0).i = r10.i;
        goto L96
    L81:
        if ((r3 instanceof Strikethrough) == false) goto L84;
        r0 = new Strikethrough();
        goto L96
    L84:
        if ((r3 instanceof TableBody) == false) goto L87;
        r0 = new TableBody();
        goto L96
    L87:
        if ((r3 instanceof TableCell) == false) goto L90;
        r0 = new TableCell();
        TableCell r11 = (TableCell) r3;
        ((TableCell) r0).h = r11.h;
        ((TableCell) r0).i = r11.i;
        goto L96
    L90:
        if ((r3 instanceof TableHead) == false) goto L93;
        r0 = new TableHead();
        goto L96
    L93:
        if ((r3 instanceof TableRow) == false) goto L95;
        r0 = new TableRow();
        goto L96
    L95:
        r0 = null;
        goto L96
    }

    public static void g(uvc.b r3) {
        uvc.b r0 = r3.b;
    L3:
        if (r0 == null) goto L8;
        g(r0);
        if ((r3 instanceof OrderedList) == false) goto L7;
        OrderedList r1 = (OrderedList) r3;
        r1.i = r1.j;
    L7:
        r0 = r0.e;
        goto L3
    }

    public static void h(uvc.b r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        uvc.b r0 = r3.d;
        if (r0 == null) goto L6;
        r0.e = r3.e;
    L6:
        uvc.b r1 = r3.e;
        if (r1 == null) goto L10;
        r1.d = r0;
    L10:
        uvc.b r2 = r3.a;
        if (r2 == null) goto L13;
        uvc.b r4 = r2.b;
    L15:
        if (Intrinsics.areEqual(r4, r3) == false) goto L20;
        uvc.b r5 = r3.a;
        if (r5 == null) goto L20;
        r5.b = r3.e;
    L20:
        uvc.b r6 = r3.a;
        if (r6 == null) goto L23;
        uvc.b r7 = r6.c;
    L25:
        if (Intrinsics.areEqual(r7, r3) == false) goto L30;
        uvc.b r8 = r3.a;
        if (r8 == null) goto L30;
        r8.c = r3.d;
    L30:
        r3.a = null;
        r3.e = null;
        r3.d = null;
        return;
    L23:
        r7 = null;
        goto L25
    L13:
        r4 = null;
        goto L15
    }

    public static void a(uvc.b r1, uvc.b r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "child");
        h(r2);
        r2.a = r1;
        uvc.b r0 = r1.c;
        if (r0 == null) goto L5;
        r0.e = r2;
        r2.d = r0;
        r1.c = r2;
        return;
    L5:
        r1.b = r2;
        r1.c = r2;
    }

    public static boolean b(uvc.b r7, uvc.b r8) {
        if (r7 != null) goto L7;
        if (r8 != null) goto L7;
        return true;
    L7:
        if (r7 == null) goto L376;
        if (r8 == null) goto L376;
        if (Intrinsics.areEqual(r7.getClass().getCanonicalName(), r8.getClass().getCanonicalName()) == true) goto L14;
    L359:
        boolean r2 = false;
    L360:
        if (r2 == true) goto L362;
        return false;
    L362:
        uvc.b r9 = r7.b;
        uvc.b r10 = r8.b;
    L363:
        if (r9 != null) goto L368;
        if (r10 != null) goto L368;
        return true;
    L368:
        if (b(r9, r10) == false) goto L369;
        if (r9 == null) goto L372;
        r9 = r9.e;
    L373:
        if (r10 != null) goto L374;
        r10 = null;
        goto L363
    L374:
        r10 = r10.e;
        goto L363
    L372:
        r9 = null;
        goto L373
    L369:
        return false;
    L14:
        if ((r7 instanceof BlockQuote) == true) goto L358;
        boolean r3 = r7 instanceof BulletList;
        if (r3 == false) goto L34;
        if (r3 == false) goto L20;
        BulletList r4 = (BulletList) r7;
    L21:
        if (r4 == null) goto L359;
        if ((r8 instanceof BulletList) == false) goto L26;
        BulletList r5 = (BulletList) r8;
    L27:
        if (r5 == null) goto L359;
        if (r4.i != r5.i) goto L359;
        if (((ListBlock) r4).h != ((ListBlock) r5).h) goto L359;
    L26:
        r5 = null;
        goto L27
    L20:
        r4 = null;
        goto L21
    L34:
        boolean r6 = r7 instanceof Code;
        if (r6 == false) goto L49;
        if (r6 == false) goto L38;
        Code r11 = (Code) r7;
    L39:
        if (r11 == null) goto L359;
        if ((r8 instanceof Code) == false) goto L44;
        Code r12 = (Code) r8;
    L45:
        if (r12 == null) goto L359;
        r2 = Intrinsics.areEqual(r11.h, r12.h);
        goto L360
    L44:
        r12 = null;
        goto L45
    L38:
        r11 = null;
        goto L39
    L49:
        if ((r7 instanceof Document) == true) goto L358;
        boolean r13 = r7 instanceof Emphasis;
        if (r13 == false) goto L65;
        if (r13 == false) goto L55;
        Emphasis r14 = (Emphasis) r7;
    L56:
        if (r14 == null) goto L359;
        if ((r8 instanceof Emphasis) == false) goto L61;
        Emphasis r15 = (Emphasis) r8;
    L62:
        if (r15 == null) goto L359;
        r2 = Intrinsics.areEqual(r14.h, r15.h);
        goto L360
    L61:
        r15 = null;
        goto L62
    L55:
        r14 = null;
        goto L56
    L65:
        boolean r16 = r7 instanceof FencedCodeBlock;
        if (r16 == false) goto L90;
        if (r16 == false) goto L69;
        FencedCodeBlock r17 = (FencedCodeBlock) r7;
    L70:
        if (r17 == null) goto L359;
        if ((r8 instanceof FencedCodeBlock) == false) goto L75;
        FencedCodeBlock r18 = (FencedCodeBlock) r8;
    L76:
        if (r18 == null) goto L359;
        if (r17.h != r18.h) goto L359;
        if (r17.i != r18.i) goto L359;
        if (r17.j != r18.j) goto L359;
        if (Intrinsics.areEqual(r17.k, r18.k) == false) goto L359;
        if (Intrinsics.areEqual(r17.l, r18.l) == false) goto L359;
    L75:
        r18 = null;
        goto L76
    L69:
        r17 = null;
        goto L70
    L90:
        if ((r7 instanceof HardLineBreak) == true) goto L358;
        boolean r19 = r7 instanceof Heading;
        if (r19 == false) goto L109;
        if (r19 == false) goto L96;
        Heading r20 = (Heading) r7;
    L97:
        if (r20 == null) goto L359;
        if ((r8 instanceof Heading) == false) goto L102;
        Heading r21 = (Heading) r8;
    L103:
        if (r21 == null) goto L359;
        if (r20.h != r21.h) goto L359;
    L102:
        r21 = null;
        goto L103
    L96:
        r20 = null;
        goto L97
    L109:
        if ((r7 instanceof ThematicBreak) == true) goto L358;
        boolean r22 = r7 instanceof HtmlInline;
        if (r22 == false) goto L125;
        if (r22 == false) goto L115;
        HtmlInline r23 = (HtmlInline) r7;
    L116:
        if (r23 == null) goto L359;
        if ((r8 instanceof HtmlInline) == false) goto L121;
        HtmlInline r24 = (HtmlInline) r8;
    L122:
        if (r24 == null) goto L359;
        r2 = Intrinsics.areEqual(r23.h, r24.h);
        goto L360
    L121:
        r24 = null;
        goto L122
    L115:
        r23 = null;
        goto L116
    L125:
        boolean r25 = r7 instanceof HtmlBlock;
        if (r25 == false) goto L139;
        if (r25 == false) goto L129;
        HtmlBlock r26 = (HtmlBlock) r7;
    L130:
        if (r26 == null) goto L359;
        if ((r8 instanceof HtmlBlock) == false) goto L135;
        HtmlBlock r27 = (HtmlBlock) r8;
    L136:
        if (r27 == null) goto L359;
        r2 = Intrinsics.areEqual(r26.h, r27.h);
        goto L360
    L135:
        r27 = null;
        goto L136
    L129:
        r26 = null;
        goto L130
    L139:
        boolean r28 = r7 instanceof Image;
        if (r28 == false) goto L157;
        if (r28 == false) goto L143;
        Image r29 = (Image) r7;
    L144:
        if (r29 == null) goto L359;
        if ((r8 instanceof Image) == false) goto L149;
        Image r30 = (Image) r8;
    L150:
        if (r30 == null) goto L359;
        if (Intrinsics.areEqual(r29.h, r30.h) == false) goto L359;
        if (Intrinsics.areEqual(r29.i, r30.i) == false) goto L359;
    L149:
        r30 = null;
        goto L150
    L143:
        r29 = null;
        goto L144
    L157:
        boolean r31 = r7 instanceof IndentedCodeBlock;
        if (r31 == false) goto L171;
        if (r31 == false) goto L161;
        IndentedCodeBlock r32 = (IndentedCodeBlock) r7;
    L162:
        if (r32 == null) goto L359;
        if ((r8 instanceof IndentedCodeBlock) == false) goto L167;
        IndentedCodeBlock r33 = (IndentedCodeBlock) r8;
    L168:
        if (r33 == null) goto L359;
        r2 = Intrinsics.areEqual(r32.h, r33.h);
        goto L360
    L167:
        r33 = null;
        goto L168
    L161:
        r32 = null;
        goto L162
    L171:
        boolean r34 = r7 instanceof Link;
        if (r34 == false) goto L190;
        if (r34 == false) goto L175;
        Link r35 = (Link) r7;
    L176:
        if (r35 == null) goto L359;
        if ((r8 instanceof Link) == false) goto L181;
        Link r36 = (Link) r8;
    L182:
        if (r36 == null) goto L359;
        if (Intrinsics.areEqual(r35.h, r36.h) == false) goto L359;
        if (Intrinsics.areEqual(r35.i, r36.i) == false) goto L359;
    L181:
        r36 = null;
        goto L182
    L175:
        r35 = null;
        goto L176
    L190:
        if ((r7 instanceof ListItem) == true) goto L358;
        boolean r37 = r7 instanceof OrderedList;
        if (r37 == false) goto L211;
        if (r37 == false) goto L196;
        OrderedList r38 = (OrderedList) r7;
    L197:
        if (r38 == null) goto L359;
        if ((r8 instanceof OrderedList) == false) goto L202;
        OrderedList r39 = (OrderedList) r8;
    L203:
        if (r39 == null) goto L359;
        if (r38.j != r39.j) goto L359;
        if (r38.k != r39.k) goto L359;
    L202:
        r39 = null;
        goto L203
    L196:
        r38 = null;
        goto L197
    L211:
        if ((r7 instanceof Paragraph) == true) goto L358;
        if ((r7 instanceof SoftLineBreak) == true) goto L358;
        boolean r40 = r7 instanceof StrongEmphasis;
        if (r40 == false) goto L230;
        if (r40 == false) goto L220;
        StrongEmphasis r41 = (StrongEmphasis) r7;
    L221:
        if (r41 == null) goto L359;
        if ((r8 instanceof StrongEmphasis) == false) goto L226;
        StrongEmphasis r42 = (StrongEmphasis) r8;
    L227:
        if (r42 == null) goto L359;
        r2 = Intrinsics.areEqual(r41.h, r42.h);
        goto L360
    L226:
        r42 = null;
        goto L227
    L220:
        r41 = null;
        goto L221
    L230:
        boolean r43 = r7 instanceof Text;
        if (r43 == false) goto L244;
        if (r43 == false) goto L234;
        Text r44 = (Text) r7;
    L235:
        if (r44 == null) goto L359;
        if ((r8 instanceof Text) == false) goto L240;
        Text r45 = (Text) r8;
    L241:
        if (r45 == null) goto L359;
        r2 = Intrinsics.areEqual(r44.h, r45.h);
        goto L360
    L240:
        r45 = null;
        goto L241
    L234:
        r44 = null;
        goto L235
    L244:
        boolean r46 = r7 instanceof LinkReferenceDefinition;
        if (r46 == false) goto L264;
        if (r46 == false) goto L248;
        LinkReferenceDefinition r47 = (LinkReferenceDefinition) r7;
    L249:
        if (r47 == null) goto L359;
        if ((r8 instanceof LinkReferenceDefinition) == false) goto L254;
        LinkReferenceDefinition r48 = (LinkReferenceDefinition) r8;
    L255:
        if (r48 == null) goto L359;
        if (Intrinsics.areEqual(r47.h, r48.h) == false) goto L359;
        if (Intrinsics.areEqual(r47.i, r48.i) == false) goto L359;
        if (Intrinsics.areEqual(r47.j, r48.j) == false) goto L359;
    L254:
        r48 = null;
        goto L255
    L248:
        r47 = null;
        goto L249
    L264:
        boolean r49 = r7 instanceof LatexMathBlock;
        if (r49 == false) goto L278;
        if (r49 == false) goto L268;
        LatexMathBlock r50 = (LatexMathBlock) r7;
    L269:
        if (r50 == null) goto L359;
        if ((r8 instanceof LatexMathBlock) == false) goto L274;
        LatexMathBlock r51 = (LatexMathBlock) r8;
    L275:
        if (r51 == null) goto L359;
        r2 = Intrinsics.areEqual(r50.h, r51.h);
        goto L360
    L274:
        r51 = null;
        goto L275
    L268:
        r50 = null;
        goto L269
    L278:
        boolean r52 = r7 instanceof TaskListItem;
        if (r52 == false) goto L295;
        if (r52 == false) goto L282;
        TaskListItem r53 = (TaskListItem) r7;
    L283:
        if (r53 == null) goto L359;
        if ((r8 instanceof TaskListItem) == false) goto L288;
        TaskListItem r54 = (TaskListItem) r8;
    L289:
        if (r54 == null) goto L359;
        if (r53.h != r54.h) goto L359;
    L288:
        r54 = null;
        goto L289
    L282:
        r53 = null;
        goto L283
    L295:
        if ((r7 instanceof TableBlock) == true) goto L358;
        boolean r55 = r7 instanceof LatexMathNode;
        if (r55 == false) goto L311;
        if (r55 == false) goto L301;
        LatexMathNode r56 = (LatexMathNode) r7;
    L302:
        if (r56 == null) goto L359;
        if ((r8 instanceof LatexMathNode) == false) goto L307;
        LatexMathNode r57 = (LatexMathNode) r8;
    L308:
        if (r57 == null) goto L359;
        r2 = Intrinsics.areEqual(r56.h, r57.h);
        goto L360
    L307:
        r57 = null;
        goto L308
    L301:
        r56 = null;
        goto L302
    L311:
        boolean r58 = r7 instanceof TableTitle;
        if (r58 == false) goto L330;
        if (r58 == false) goto L315;
        TableTitle r59 = (TableTitle) r7;
    L316:
        if (r59 == null) goto L359;
        if ((r8 instanceof TableTitle) == false) goto L321;
        TableTitle r60 = (TableTitle) r8;
    L322:
        if (r60 == null) goto L359;
        if (Intrinsics.areEqual(r59.h, r60.h) == false) goto L359;
        if (Intrinsics.areEqual(r59.i, r60.i) == false) goto L359;
    L321:
        r60 = null;
        goto L322
    L315:
        r59 = null;
        goto L316
    L330:
        if ((r7 instanceof Strikethrough) == true) goto L358;
        if ((r7 instanceof TableBody) == true) goto L358;
        boolean r61 = r7 instanceof TableCell;
        if (r61 == false) goto L354;
        if (r61 == false) goto L339;
        TableCell r62 = (TableCell) r7;
    L340:
        if (r62 == null) goto L359;
        if ((r8 instanceof TableCell) == false) goto L345;
        TableCell r63 = (TableCell) r8;
    L346:
        if (r63 == null) goto L359;
        if (r62.h != r63.h) goto L359;
        if (r62.i != r63.i) goto L359;
    L345:
        r63 = null;
        goto L346
    L339:
        r62 = null;
        goto L340
    L354:
        if ((r7 instanceof TableHead) == true) goto L358;
        if ((r7 instanceof TableRow) == false) goto L359;
    L358:
        r2 = true;
    L376:
        return false;
    }

    public static void d(uvc.b r1, uvc.b r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "sibling");
        h(r2);
        uvc.b r0 = r1.e;
        r2.e = r0;
        if (r0 == null) goto L5;
        r0.d = r2;
    L5:
        r2.d = r1;
        r1.e = r2;
        uvc.b r3 = r1.a;
        r2.a = r3;
        if (r2.e != null) goto L11;
        if (r3 == null) goto L12;
        r3.c = r2;
        return;
    L12:
        return;
    }

    public static void e(uvc.b r1, uvc.b r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "sibling");
        h(r2);
        uvc.b r0 = r1.d;
        r2.d = r0;
        if (r0 == null) goto L5;
        r0.e = r2;
    L5:
        r2.e = r1;
        r1.d = r2;
        uvc.b r3 = r1.a;
        r2.a = r3;
        if (r2.d != null) goto L11;
        if (r3 == null) goto L12;
        r3.b = r2;
        return;
    L12:
        return;
    }

    public static uvc.b f(uvc.b r8, Set r9) {
        Intrinsics.checkNotNullParameter(r9, "nodeList");
        uvc.b r4 = null;
        if ((r8 instanceof HtmlBlock) == false) goto L8;
        uvc.b r0 = (HtmlBlock) r8;
        if (StringsKt.startsWith$default(((HtmlBlock) r0).h, "<data-block", false, 2, null) == false) goto L71;
    L6:
        r4 = r0;
    L71:
        if (r4 == null) goto L74;
        r9.add(r4);
        return r4.e;
    L74:
        uvc.b r1 = r8.b;
    L75:
        if (r1 == null) goto L78;
        r1 = f(r1, r9);
        goto L75
    L78:
        return r8.e;
    L8:
        if ((r8 instanceof HtmlInline) == false) goto L49;
        HtmlInline r2 = (HtmlInline) r8;
        WidgetNode r5 = new WidgetNode();
        if (StringsKt.startsWith$default(r2.h, "<data-block", false, 2, null) == false) goto L13;
        String r3 = "</data-block";
    L15:
        HtmlInline r6 = r2;
    L16:
        if (r6 == null) goto L22;
        if ((r6 instanceof HtmlInline) == false) goto L21;
        if (StringsKt.startsWith$default(r6.h, r3, false, 2, null) == true) goto L22;
    L21:
        ((ArrayList) r5.h).add(r6);
        r6 = ((uvc.b) r6).e;
    L22:
        if (r6 == null) goto L24;
        ((ArrayList) r5.h).add(r6);
    L24:
        r0 = ((uvc.b) r2).a;
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r5.h), r0.b) == true) goto L27;
    L29:
        uvc.b r7 = (uvc.b) CollectionsKt.firstOrNull(r5.h);
        if (r7 == null) goto L32;
        uvc.b r10 = r7.d;
    L33:
        uvc.b r11 = (uvc.b) CollectionsKt.lastOrNull(r5.h);
        if (r11 == null) goto L36;
        uvc.b r12 = r11.e;
    L37:
        Iterator r13 = ((ArrayList) r5.h).iterator();
    L39:
        if (r13.hasNext() == false) goto L41;
        a(r5, (uvc.b) r13.next());
        goto L39
    L41:
        if (r10 == null) goto L44;
        if (r12 == null) goto L44;
        d(r10, r5);
    L48:
        r4 = r5;
    L44:
        if (r10 == null) goto L46;
        d(r10, r5);
        goto L48
    L46:
        if (r12 == null) goto L71;
        d(r12, r5);
        goto L48
    L36:
        r12 = null;
        goto L37
    L32:
        r10 = null;
        goto L33
    L27:
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull(r5.h), r0.c) == false) goto L29;
    L13:
        if (StringsKt.startsWith$default(r2.h, "<data-inline", false, 2, null) == false) goto L71;
        r3 = "</data-inline";
        goto L15
    L49:
        boolean r14 = true;
        if ((r8 instanceof Image) == false) goto L52;
        boolean r15 = true;
    L53:
        if (r15 == true) goto L56;
        r14 = r8 instanceof TableBlock;
    L56:
        if (r14 == false) goto L59;
        r4 = r8;
        goto L71
    L59:
        if ((r8 instanceof ListItem) == false) goto L71;
        ListItem r16 = (ListItem) r8;
        OrderedList r17 = ((uvc.b) r16).a;
        if ((r17 instanceof OrderedList) == false) goto L63;
        OrderedList r18 = r17;
    L64:
        if (r18 == null) goto L71;
        uvc.b r19 = ((uvc.b) r18).b;
        int r20 = r18.i;
    L66:
        if (r19 == null) goto L70;
        if (Intrinsics.areEqual(r19, r8) == true) goto L70;
        r20 = r20 + 1;
        r19 = r19.e;
    L70:
        ((HashMap) ((uvc.b) r16).g).put("order_number", Integer.valueOf(r20));
        goto L71
    L63:
        r18 = null;
        goto L64
    L52:
        r15 = r8 instanceof FencedCodeBlock;
        goto L53
    }
}
