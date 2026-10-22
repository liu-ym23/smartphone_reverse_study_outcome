package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
abstract enum HtmlTreeBuilderState extends Enum<HtmlTreeBuilderState> {
    private static final /* synthetic */ HtmlTreeBuilderState[] $VALUES = null;
    public static final HtmlTreeBuilderState AfterAfterBody = null;
    public static final HtmlTreeBuilderState AfterAfterFrameset = null;
    public static final HtmlTreeBuilderState AfterBody = null;
    public static final HtmlTreeBuilderState AfterFrameset = null;
    public static final HtmlTreeBuilderState AfterHead = null;
    public static final HtmlTreeBuilderState BeforeHead = null;
    public static final HtmlTreeBuilderState BeforeHtml = null;
    public static final HtmlTreeBuilderState ForeignContent = null;
    public static final HtmlTreeBuilderState InBody = null;
    public static final HtmlTreeBuilderState InCaption = null;
    public static final HtmlTreeBuilderState InCell = null;
    public static final HtmlTreeBuilderState InColumnGroup = null;
    public static final HtmlTreeBuilderState InFrameset = null;
    public static final HtmlTreeBuilderState InHead = null;
    public static final HtmlTreeBuilderState InHeadNoscript = null;
    public static final HtmlTreeBuilderState InRow = null;
    public static final HtmlTreeBuilderState InSelect = null;
    public static final HtmlTreeBuilderState InSelectInTable = null;
    public static final HtmlTreeBuilderState InTable = null;
    public static final HtmlTreeBuilderState InTableBody = null;
    public static final HtmlTreeBuilderState InTableText = null;
    public static final HtmlTreeBuilderState InTemplate = null;
    public static final HtmlTreeBuilderState Initial = null;
    public static final HtmlTreeBuilderState Text = null;
    private static final String nullString = null;

    /* JADX INFO: renamed from: org.jsoup.parser.HtmlTreeBuilderState$25, reason: invalid class name */
    static /* synthetic */ class AnonymousClass25 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18272a = null;

        static {
            int[] r0 = new int[Token.TokenType.values().length];
            f18272a = r0;
            r0[Token.TokenType.Comment.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f18272a[Token.TokenType.Doctype.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f18272a[Token.TokenType.StartTag.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f18272a[Token.TokenType.EndTag.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f18272a[Token.TokenType.Character.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f18272a[Token.TokenType.EOF.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static final class a {
        static final String[] A = null;
        static final String[] B = null;
        static final String[] C = null;
        static final String[] D = null;
        static final String[] E = null;
        static final String[] F = null;
        static final String[] G = null;
        static final String[] H = null;
        static final String[] I = null;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        static final String[] f18273J = null;
        static final String[] K = null;
        static final String[] L = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String[] f18274a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final String[] f18275b = null;
        static final String[] c = null;
        static final String[] d = null;
        static final String[] e = null;
        static final String[] f = null;
        static final String[] g = null;
        static final String[] h = null;
        static final String[] i = null;
        static final String[] j = null;
        static final String[] k = null;
        static final String[] l = null;
        static final String[] m = null;
        static final String[] n = null;
        static final String[] o = null;
        static final String[] p = null;
        static final String[] q = null;
        static final String[] r = null;
        static final String[] s = null;
        static final String[] t = null;
        static final String[] u = null;
        static final String[] v = null;
        static final String[] w = null;
        static final String[] x = null;
        static final String[] y = null;
        static final String[] z = null;

        static {
            f18274a = new String[]{"base", "basefont", "bgsound", "command", "link"};
            f18275b = new String[]{"noframes", "style"};
            c = new String[]{"body", "br", "html"};
            d = new String[]{"body", "br", "html"};
            e = new String[]{"body", "br", "head", "html"};
            f = new String[]{"basefont", "bgsound", "link", "meta", "noframes", "style"};
            g = new String[]{"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "template", "title"};
            h = new String[]{MemoryKeyInfoEntity.KEY_ADDRESS, "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
            i = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            j = new String[]{MemoryKeyInfoEntity.KEY_ADDRESS, "div", "p"};
            k = new String[]{"dd", "dt"};
            l = new String[]{"applet", "marquee", "object"};
            m = new String[]{AutoTestConstant.PARAM, AILabCheckPermissionTask.KEY_SOURCE, "track"};
            n = new String[]{"action", ActivityLifecycle.NAME, Params.PROMPT};
            o = new String[]{"caption", "col", "colgroup", TypedValues.AttributesType.S_FRAME, "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
            p = new String[]{MemoryKeyInfoEntity.KEY_ADDRESS, "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
            q = new String[]{"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
            r = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            s = new String[]{"tbody", "tfoot", "thead"};
            t = new String[]{"td", "th", "tr"};
            u = new String[]{"script", "style", "template"};
            v = new String[]{"td", "th"};
            w = new String[]{"body", "caption", "col", "colgroup", "html"};
            x = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            y = new String[]{"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
            z = new String[]{"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
            A = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            B = new String[]{"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
            C = new String[]{"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};
            D = new String[]{"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
            E = new String[]{"body", "caption", "col", "colgroup", "html", "td", "th"};
            F = new String[]{"input", "keygen", "textarea"};
            G = new String[]{"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
            H = new String[]{"tbody", "tfoot", "thead"};
            I = new String[]{"head", "noscript"};
            f18273J = new String[]{"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
            K = new String[]{"base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "template", "title"};
            L = new String[]{"caption", "colgroup", "tbody", "tfoot", "thead"};
        }
    }

    private static /* synthetic */ HtmlTreeBuilderState[] $values() {
        return new HtmlTreeBuilderState[]{Initial, BeforeHtml, BeforeHead, InHead, InHeadNoscript, AfterHead, InBody, Text, InTable, InTableText, InCaption, InColumnGroup, InTableBody, InRow, InCell, InSelect, InSelectInTable, InTemplate, AfterBody, InFrameset, AfterFrameset, AfterAfterBody, AfterAfterFrameset, ForeignContent};
    }

    static {
        final String r1 = "Initial";
        final int r2 = 0;
        Initial = new AnonymousClass1(r1, r2);
        final String r3 = "BeforeHtml";
        final int r4 = 1;
        BeforeHtml = new AnonymousClass2(r3, r4);
        final String r5 = "BeforeHead";
        final int r6 = 2;
        BeforeHead = new AnonymousClass3(r5, r6);
        final String r7 = "InHead";
        final int r8 = 3;
        InHead = new AnonymousClass4(r7, r8);
        final String r9 = "InHeadNoscript";
        final int r10 = 4;
        InHeadNoscript = new AnonymousClass5(r9, r10);
        final String r11 = "AfterHead";
        final int r12 = 5;
        AfterHead = new AnonymousClass6(r11, r12);
        final String r13 = "InBody";
        final int r14 = 6;
        InBody = new AnonymousClass7(r13, r14);
        final String r15 = "Text";
        final int r16 = 7;
        Text = new AnonymousClass8(r15, r16);
        final String r17 = "InTable";
        final int r18 = 8;
        InTable = new AnonymousClass9(r17, r18);
        final String r19 = "InTableText";
        final int r20 = 9;
        InTableText = new AnonymousClass10(r19, r20);
        final String r21 = "InCaption";
        final int r22 = 10;
        InCaption = new AnonymousClass11(r21, r22);
        final String r23 = "InColumnGroup";
        final int r24 = 11;
        InColumnGroup = new AnonymousClass12(r23, r24);
        final String r25 = "InTableBody";
        final int r26 = 12;
        InTableBody = new AnonymousClass13(r25, r26);
        final String r27 = "InRow";
        final int r28 = 13;
        InRow = new AnonymousClass14(r27, r28);
        final String r29 = "InCell";
        final int r30 = 14;
        InCell = new AnonymousClass15(r29, r30);
        final String r31 = "InSelect";
        final int r32 = 15;
        InSelect = new AnonymousClass16(r31, r32);
        final String r33 = "InSelectInTable";
        final int r34 = 16;
        InSelectInTable = new AnonymousClass17(r33, r34);
        final String r35 = "InTemplate";
        final int r36 = 17;
        InTemplate = new AnonymousClass18(r35, r36);
        final String r37 = "AfterBody";
        final int r38 = 18;
        AfterBody = new AnonymousClass19(r37, r38);
        final String r39 = "InFrameset";
        final int r40 = 19;
        InFrameset = new AnonymousClass20(r39, r40);
        final String r41 = "AfterFrameset";
        final int r42 = 20;
        AfterFrameset = new AnonymousClass21(r41, r42);
        final String r43 = "AfterAfterBody";
        final int r44 = 21;
        AfterAfterBody = new AnonymousClass22(r43, r44);
        final String r45 = "AfterAfterFrameset";
        final int r46 = 22;
        AfterAfterFrameset = new AnonymousClass23(r45, r46);
        final String r47 = "ForeignContent";
        final int r48 = 23;
        ForeignContent = new AnonymousClass24(r47, r48);
        $VALUES = $values();
        nullString = String.valueOf(0);
    }

    private HtmlTreeBuilderState(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ HtmlTreeBuilderState(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ boolean access$100(Token r0) {
        return isWhitespace(r0);
    }

    static /* synthetic */ void access$200(Token.g r0, b r1) {
        handleRcData(r0, r1);
    }

    static /* synthetic */ void access$300(Token.g r0, b r1) {
        handleRawtext(r0, r1);
    }

    static /* synthetic */ String access$400() {
        return nullString;
    }

    static /* synthetic */ boolean access$500(String r0) {
        return isWhitespace(r0);
    }

    private static void handleRawtext(Token.g r2, b r3) {
        r3.l.a(TokeniserState.Rawtext);
        r3.c();
        r3.a(Text);
        r3.insert(r2);
    }

    private static void handleRcData(Token.g r2, b r3) {
        r3.l.a(TokeniserState.Rcdata);
        r3.c();
        r3.a(Text);
        r3.insert(r2);
    }

    private static boolean isWhitespace(String r0) {
        return org.jsoup.a.b.a(r0);
    }

    private static boolean isWhitespace(Token r1) {
        if (r1.m() == true) goto L5;
        return false;
    L5:
        return org.jsoup.a.b.a(r1.o().q());
    }

    public static HtmlTreeBuilderState valueOf(String r2) {
        return (HtmlTreeBuilderState) ZeusTransformUtils.preCheckCast(Enum.valueOf(HtmlTreeBuilderState.class, r2), HtmlTreeBuilderState.class, "com.obric.memorydata.plugin");
    }

    public static HtmlTreeBuilderState[] values() {
        return (HtmlTreeBuilderState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HtmlTreeBuilderState[].class, "com.obric.memorydata.plugin");
    }

    abstract boolean process(Token r1, b r2);
}
