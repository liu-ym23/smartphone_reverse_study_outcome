package io.noties.markwon.html.jsoup.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
abstract enum TokeniserState extends Enum<TokeniserState> {
    private static final /* synthetic */ TokeniserState[] $VALUES = null;
    public static final TokeniserState AfterAttributeName = null;
    public static final TokeniserState AfterAttributeValue_quoted = null;
    public static final TokeniserState AfterDoctypeName = null;
    public static final TokeniserState AfterDoctypePublicIdentifier = null;
    public static final TokeniserState AfterDoctypePublicKeyword = null;
    public static final TokeniserState AfterDoctypeSystemIdentifier = null;
    public static final TokeniserState AfterDoctypeSystemKeyword = null;
    public static final TokeniserState AttributeName = null;
    public static final TokeniserState AttributeValue_doubleQuoted = null;
    public static final TokeniserState AttributeValue_singleQuoted = null;
    public static final TokeniserState AttributeValue_unquoted = null;
    public static final TokeniserState BeforeAttributeName = null;
    public static final TokeniserState BeforeAttributeValue = null;
    public static final TokeniserState BeforeDoctypeName = null;
    public static final TokeniserState BeforeDoctypePublicIdentifier = null;
    public static final TokeniserState BeforeDoctypeSystemIdentifier = null;
    public static final TokeniserState BetweenDoctypePublicAndSystemIdentifiers = null;
    public static final TokeniserState BogusComment = null;
    public static final TokeniserState BogusDoctype = null;
    public static final TokeniserState CdataSection = null;
    public static final TokeniserState CharacterReferenceInData = null;
    public static final TokeniserState CharacterReferenceInRcdata = null;
    public static final TokeniserState Comment = null;
    public static final TokeniserState CommentEnd = null;
    public static final TokeniserState CommentEndBang = null;
    public static final TokeniserState CommentEndDash = null;
    public static final TokeniserState CommentStart = null;
    public static final TokeniserState CommentStartDash = null;
    public static final TokeniserState Data = null;
    public static final TokeniserState Doctype = null;
    public static final TokeniserState DoctypeName = null;
    public static final TokeniserState DoctypePublicIdentifier_doubleQuoted = null;
    public static final TokeniserState DoctypePublicIdentifier_singleQuoted = null;
    public static final TokeniserState DoctypeSystemIdentifier_doubleQuoted = null;
    public static final TokeniserState DoctypeSystemIdentifier_singleQuoted = null;
    public static final TokeniserState EndTagOpen = null;
    public static final TokeniserState MarkupDeclarationOpen = null;
    public static final TokeniserState PLAINTEXT = null;
    public static final TokeniserState RCDATAEndTagName = null;
    public static final TokeniserState RCDATAEndTagOpen = null;
    public static final TokeniserState Rawtext = null;
    public static final TokeniserState RawtextEndTagName = null;
    public static final TokeniserState RawtextEndTagOpen = null;
    public static final TokeniserState RawtextLessthanSign = null;
    public static final TokeniserState Rcdata = null;
    public static final TokeniserState RcdataLessthanSign = null;
    public static final TokeniserState ScriptData = null;
    public static final TokeniserState ScriptDataDoubleEscapeEnd = null;
    public static final TokeniserState ScriptDataDoubleEscapeStart = null;
    public static final TokeniserState ScriptDataDoubleEscaped = null;
    public static final TokeniserState ScriptDataDoubleEscapedDash = null;
    public static final TokeniserState ScriptDataDoubleEscapedDashDash = null;
    public static final TokeniserState ScriptDataDoubleEscapedLessthanSign = null;
    public static final TokeniserState ScriptDataEndTagName = null;
    public static final TokeniserState ScriptDataEndTagOpen = null;
    public static final TokeniserState ScriptDataEscapeStart = null;
    public static final TokeniserState ScriptDataEscapeStartDash = null;
    public static final TokeniserState ScriptDataEscaped = null;
    public static final TokeniserState ScriptDataEscapedDash = null;
    public static final TokeniserState ScriptDataEscapedDashDash = null;
    public static final TokeniserState ScriptDataEscapedEndTagName = null;
    public static final TokeniserState ScriptDataEscapedEndTagOpen = null;
    public static final TokeniserState ScriptDataEscapedLessthanSign = null;
    public static final TokeniserState ScriptDataLessthanSign = null;
    public static final TokeniserState SelfClosingStartTag = null;
    public static final TokeniserState TagName = null;
    public static final TokeniserState TagOpen = null;
    static final char[] attributeDoubleValueCharsSorted = null;
    static final char[] attributeNameCharsSorted = null;
    static final char[] attributeSingleValueCharsSorted = null;
    static final char[] attributeValueUnquoted = null;
    private static final char eof = 65535;
    static final char nullChar = 0;
    private static final char replacementChar = 65533;
    private static final String replacementStr = null;

    static {
        final String r1 = "Data";
        final int r2 = 0;
        Data = new AnonymousClass1(r1, r2);
        final String r3 = "CharacterReferenceInData";
        final int r4 = 1;
        CharacterReferenceInData = new AnonymousClass2(r3, r4);
        final String r5 = "Rcdata";
        final int r6 = 2;
        Rcdata = new AnonymousClass3(r5, r6);
        final String r7 = "CharacterReferenceInRcdata";
        final int r8 = 3;
        CharacterReferenceInRcdata = new AnonymousClass4(r7, r8);
        final String r9 = "Rawtext";
        final int r10 = 4;
        Rawtext = new AnonymousClass5(r9, r10);
        final String r11 = "ScriptData";
        final int r12 = 5;
        ScriptData = new AnonymousClass6(r11, r12);
        final String r13 = "PLAINTEXT";
        final int r14 = 6;
        PLAINTEXT = new AnonymousClass7(r13, r14);
        final String r15 = "TagOpen";
        final int r16 = 7;
        TagOpen = new AnonymousClass8(r15, r16);
        final String r17 = "EndTagOpen";
        final int r18 = 8;
        EndTagOpen = new AnonymousClass9(r17, r18);
        final String r19 = "TagName";
        final int r110 = 9;
        TagName = new AnonymousClass10(r19, r110);
        final String r20 = "RcdataLessthanSign";
        final int r111 = 10;
        RcdataLessthanSign = new AnonymousClass11(r20, r111);
        final String r21 = "RCDATAEndTagOpen";
        final int r112 = 11;
        RCDATAEndTagOpen = new AnonymousClass12(r21, r112);
        final String r22 = "RCDATAEndTagName";
        final int r113 = 12;
        RCDATAEndTagName = new AnonymousClass13(r22, r113);
        final String r23 = "RawtextLessthanSign";
        final int r114 = 13;
        RawtextLessthanSign = new AnonymousClass14(r23, r114);
        final String r24 = "RawtextEndTagOpen";
        final int r115 = 14;
        RawtextEndTagOpen = new AnonymousClass15(r24, r115);
        final String r25 = "RawtextEndTagName";
        final int r116 = 15;
        RawtextEndTagName = new AnonymousClass16(r25, r116);
        final String r26 = "ScriptDataLessthanSign";
        final int r117 = 16;
        ScriptDataLessthanSign = new AnonymousClass17(r26, r117);
        final String r27 = "ScriptDataEndTagOpen";
        final int r118 = 17;
        ScriptDataEndTagOpen = new AnonymousClass18(r27, r118);
        final String r28 = "ScriptDataEndTagName";
        final int r119 = 18;
        ScriptDataEndTagName = new AnonymousClass19(r28, r119);
        final String r29 = "ScriptDataEscapeStart";
        final int r120 = 19;
        ScriptDataEscapeStart = new AnonymousClass20(r29, r120);
        final String r30 = "ScriptDataEscapeStartDash";
        final int r121 = 20;
        ScriptDataEscapeStartDash = new AnonymousClass21(r30, r121);
        final String r31 = "ScriptDataEscaped";
        final int r122 = 21;
        ScriptDataEscaped = new AnonymousClass22(r31, r122);
        final String r32 = "ScriptDataEscapedDash";
        final int r123 = 22;
        ScriptDataEscapedDash = new AnonymousClass23(r32, r123);
        final String r33 = "ScriptDataEscapedDashDash";
        final int r124 = 23;
        ScriptDataEscapedDashDash = new AnonymousClass24(r33, r124);
        final String r34 = "ScriptDataEscapedLessthanSign";
        final int r125 = 24;
        ScriptDataEscapedLessthanSign = new AnonymousClass25(r34, r125);
        final String r35 = "ScriptDataEscapedEndTagOpen";
        final int r126 = 25;
        ScriptDataEscapedEndTagOpen = new AnonymousClass26(r35, r126);
        final String r36 = "ScriptDataEscapedEndTagName";
        final int r127 = 26;
        ScriptDataEscapedEndTagName = new AnonymousClass27(r36, r127);
        final String r37 = "ScriptDataDoubleEscapeStart";
        final int r128 = 27;
        ScriptDataDoubleEscapeStart = new AnonymousClass28(r37, r128);
        final String r38 = "ScriptDataDoubleEscaped";
        final int r129 = 28;
        ScriptDataDoubleEscaped = new AnonymousClass29(r38, r129);
        final String r39 = "ScriptDataDoubleEscapedDash";
        final int r130 = 29;
        ScriptDataDoubleEscapedDash = new AnonymousClass30(r39, r130);
        final String r40 = "ScriptDataDoubleEscapedDashDash";
        final int r131 = 30;
        ScriptDataDoubleEscapedDashDash = new AnonymousClass31(r40, r131);
        final String r41 = "ScriptDataDoubleEscapedLessthanSign";
        final int r132 = 31;
        ScriptDataDoubleEscapedLessthanSign = new AnonymousClass32(r41, r132);
        final String r42 = "ScriptDataDoubleEscapeEnd";
        final int r133 = 32;
        ScriptDataDoubleEscapeEnd = new AnonymousClass33(r42, r133);
        final String r43 = "BeforeAttributeName";
        final int r134 = 33;
        BeforeAttributeName = new AnonymousClass34(r43, r134);
        final String r44 = "AttributeName";
        final int r135 = 34;
        AttributeName = new AnonymousClass35(r44, r135);
        final String r45 = "AfterAttributeName";
        final int r136 = 35;
        AfterAttributeName = new AnonymousClass36(r45, r136);
        final String r46 = "BeforeAttributeValue";
        final int r137 = 36;
        BeforeAttributeValue = new AnonymousClass37(r46, r137);
        final String r47 = "AttributeValue_doubleQuoted";
        final int r138 = 37;
        AttributeValue_doubleQuoted = new AnonymousClass38(r47, r138);
        final String r48 = "AttributeValue_singleQuoted";
        final int r139 = 38;
        AttributeValue_singleQuoted = new AnonymousClass39(r48, r139);
        final String r49 = "AttributeValue_unquoted";
        final int r140 = 39;
        AttributeValue_unquoted = new AnonymousClass40(r49, r140);
        final String r50 = "AfterAttributeValue_quoted";
        final int r141 = 40;
        AfterAttributeValue_quoted = new AnonymousClass41(r50, r141);
        final String r51 = "SelfClosingStartTag";
        final int r142 = 41;
        SelfClosingStartTag = new AnonymousClass42(r51, r142);
        final String r52 = "BogusComment";
        final int r143 = 42;
        BogusComment = new AnonymousClass43(r52, r143);
        final String r53 = "MarkupDeclarationOpen";
        final int r144 = 43;
        MarkupDeclarationOpen = new AnonymousClass44(r53, r144);
        final String r54 = "CommentStart";
        final int r145 = 44;
        CommentStart = new AnonymousClass45(r54, r145);
        final String r55 = "CommentStartDash";
        final int r146 = 45;
        CommentStartDash = new AnonymousClass46(r55, r146);
        final String r56 = "Comment";
        final int r147 = 46;
        Comment = new AnonymousClass47(r56, r147);
        final String r57 = "CommentEndDash";
        final int r148 = 47;
        CommentEndDash = new AnonymousClass48(r57, r148);
        final String r58 = "CommentEnd";
        final int r149 = 48;
        CommentEnd = new AnonymousClass49(r58, r149);
        final String r59 = "CommentEndBang";
        final int r150 = 49;
        CommentEndBang = new AnonymousClass50(r59, r150);
        final String r60 = "Doctype";
        final int r151 = 50;
        Doctype = new AnonymousClass51(r60, r151);
        final String r61 = "BeforeDoctypeName";
        final int r152 = 51;
        BeforeDoctypeName = new AnonymousClass52(r61, r152);
        final String r62 = "DoctypeName";
        final int r153 = 52;
        DoctypeName = new AnonymousClass53(r62, r153);
        final String r63 = "AfterDoctypeName";
        final int r154 = 53;
        AfterDoctypeName = new AnonymousClass54(r63, r154);
        final String r64 = "AfterDoctypePublicKeyword";
        final int r155 = 54;
        AfterDoctypePublicKeyword = new AnonymousClass55(r64, r155);
        final String r65 = "BeforeDoctypePublicIdentifier";
        final int r156 = 55;
        BeforeDoctypePublicIdentifier = new AnonymousClass56(r65, r156);
        final String r66 = "DoctypePublicIdentifier_doubleQuoted";
        final int r157 = 56;
        DoctypePublicIdentifier_doubleQuoted = new AnonymousClass57(r66, r157);
        final String r67 = "DoctypePublicIdentifier_singleQuoted";
        final int r158 = 57;
        DoctypePublicIdentifier_singleQuoted = new AnonymousClass58(r67, r158);
        final String r68 = "AfterDoctypePublicIdentifier";
        final int r159 = 58;
        AfterDoctypePublicIdentifier = new AnonymousClass59(r68, r159);
        final String r69 = "BetweenDoctypePublicAndSystemIdentifiers";
        final int r160 = 59;
        BetweenDoctypePublicAndSystemIdentifiers = new AnonymousClass60(r69, r160);
        final String r70 = "AfterDoctypeSystemKeyword";
        final int r161 = 60;
        AfterDoctypeSystemKeyword = new AnonymousClass61(r70, r161);
        final String r71 = "BeforeDoctypeSystemIdentifier";
        final int r162 = 61;
        BeforeDoctypeSystemIdentifier = new AnonymousClass62(r71, r162);
        final String r72 = "DoctypeSystemIdentifier_doubleQuoted";
        final int r163 = 62;
        DoctypeSystemIdentifier_doubleQuoted = new AnonymousClass63(r72, r163);
        final String r73 = "DoctypeSystemIdentifier_singleQuoted";
        final int r164 = 63;
        DoctypeSystemIdentifier_singleQuoted = new AnonymousClass64(r73, r164);
        final String r74 = "AfterDoctypeSystemIdentifier";
        final int r165 = 64;
        AfterDoctypeSystemIdentifier = new AnonymousClass65(r74, r165);
        final String r75 = "BogusDoctype";
        final int r166 = 65;
        BogusDoctype = new AnonymousClass66(r75, r166);
        final String r76 = "CdataSection";
        final int r167 = 66;
        CdataSection = new AnonymousClass67(r76, r167);
        $VALUES = new TokeniserState[]{Data, CharacterReferenceInData, Rcdata, CharacterReferenceInRcdata, Rawtext, ScriptData, PLAINTEXT, TagOpen, EndTagOpen, TagName, RcdataLessthanSign, RCDATAEndTagOpen, RCDATAEndTagName, RawtextLessthanSign, RawtextEndTagOpen, RawtextEndTagName, ScriptDataLessthanSign, ScriptDataEndTagOpen, ScriptDataEndTagName, ScriptDataEscapeStart, ScriptDataEscapeStartDash, ScriptDataEscaped, ScriptDataEscapedDash, ScriptDataEscapedDashDash, ScriptDataEscapedLessthanSign, ScriptDataEscapedEndTagOpen, ScriptDataEscapedEndTagName, ScriptDataDoubleEscapeStart, ScriptDataDoubleEscaped, ScriptDataDoubleEscapedDash, ScriptDataDoubleEscapedDashDash, ScriptDataDoubleEscapedLessthanSign, ScriptDataDoubleEscapeEnd, BeforeAttributeName, AttributeName, AfterAttributeName, BeforeAttributeValue, AttributeValue_doubleQuoted, AttributeValue_singleQuoted, AttributeValue_unquoted, AfterAttributeValue_quoted, SelfClosingStartTag, BogusComment, MarkupDeclarationOpen, CommentStart, CommentStartDash, Comment, CommentEndDash, CommentEnd, CommentEndBang, Doctype, BeforeDoctypeName, DoctypeName, AfterDoctypeName, AfterDoctypePublicKeyword, BeforeDoctypePublicIdentifier, DoctypePublicIdentifier_doubleQuoted, DoctypePublicIdentifier_singleQuoted, AfterDoctypePublicIdentifier, BetweenDoctypePublicAndSystemIdentifiers, AfterDoctypeSystemKeyword, BeforeDoctypeSystemIdentifier, DoctypeSystemIdentifier_doubleQuoted, DoctypeSystemIdentifier_singleQuoted, AfterDoctypeSystemIdentifier, BogusDoctype, CdataSection};
        attributeSingleValueCharsSorted = new char[]{0, Typography.amp, '\''};
        attributeDoubleValueCharsSorted = new char[]{0, Typography.quote, Typography.amp};
        attributeNameCharsSorted = new char[]{0, '\t', '\n', '\f', '\r', ' ', Typography.quote, '\'', '/', Typography.less, '=', Typography.greater};
        attributeValueUnquoted = new char[]{0, '\t', '\n', '\f', '\r', ' ', Typography.quote, Typography.amp, '\'', Typography.less, '=', Typography.greater, '`'};
        replacementStr = String.valueOf(65533);
    }

    private TokeniserState(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ TokeniserState(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ void access$100(c r0, TokeniserState r1) {
        readCharRef(r0, r1);
    }

    static /* synthetic */ void access$200(c r0, a r1, TokeniserState r2, TokeniserState r3) {
        readData(r0, r1, r2, r3);
    }

    static /* synthetic */ String access$300() {
        return replacementStr;
    }

    static /* synthetic */ void access$400(c r0, a r1, TokeniserState r2, TokeniserState r3) {
        readEndTag(r0, r1, r2, r3);
    }

    static /* synthetic */ void access$500(c r0, a r1, TokeniserState r2) {
        handleDataEndTag(r0, r1, r2);
    }

    static /* synthetic */ void access$600(c r0, a r1, TokeniserState r2, TokeniserState r3) {
        handleDataDoubleEscapeTag(r0, r1, r2, r3);
    }

    private static void handleDataDoubleEscapeTag(c r2, a r3, TokeniserState r4, TokeniserState r5) {
        if (r3.p() == false) goto L6;
        String r6 = r3.l();
        r2.f16593b.append(r6);
        r2.a(r6);
        return;
    L6:
        char r0 = r3.d();
        if (r0 == '\t') goto L22;
        if (r0 == '\n') goto L22;
        if (r0 == '\f') goto L22;
        if (r0 == '\r') goto L22;
        if (r0 == ' ') goto L22;
        if (r0 == '/') goto L22;
        if (r0 == '>') goto L22;
        r3.e();
        r2.a(r5);
        return;
    L22:
        if (r2.f16593b.toString().equals("script") == false) goto L24;
        r2.a(r4);
    L25:
        r2.a(r0);
        return;
    L24:
        r2.a(r5);
        goto L25
    }

    private static void handleDataEndTag(c r3, a r4, TokeniserState r5) {
        if (r4.p() == false) goto L6;
        String r6 = r4.l();
        r3.c.b(r6);
        r3.f16593b.append(r6);
        return;
    L6:
        boolean r0 = false;
        boolean r2 = true;
        if (r3.i() == true) goto L9;
    L30:
        if (r2 == false) goto L33;
        r3.a("</" + r3.f16593b.toString());
        r3.a(r5);
        return;
    L33:
        return;
    L9:
        if (r4.b() == true) goto L30;
        char r7 = r4.d();
        if (r7 != '\t') goto L13;
    L27:
        TokeniserState r8 = BeforeAttributeName;
    L28:
        r3.a(r8);
    L29:
        r2 = r0;
        goto L30
    L13:
        if (r7 == '\n') goto L27;
        if (r7 == '\f') goto L27;
        if (r7 == '\r') goto L27;
        if (r7 == ' ') goto L27;
        if (r7 != '/') goto L23;
        r8 = SelfClosingStartTag;
        goto L28
    L23:
        if (r7 == '>') goto L25;
        r3.f16593b.append(r7);
        r0 = true;
        goto L29
    L25:
        r3.c();
        r8 = Data;
        goto L28
    }

    private static void readCharRef(c r2, TokeniserState r3) {
        int[] r0 = r2.a(null, false);
        if (r0 != null) goto L5;
        r2.a(Typography.amp);
    L6:
        r2.a(r3);
        return;
    L5:
        r2.a(r0);
        goto L6
    }

    private static void readData(c r1, a r2, TokeniserState r3, TokeniserState r4) {
        char r0 = r2.c();
        if (r0 != 0) goto L5;
        r1.c(r3);
        r2.f();
        r1.a(65533);
        return;
    L5:
        if (r0 != '<') goto L7;
        r1.b(r4);
        return;
    L7:
        if (r0 == 65535) goto L9;
        r1.a(r2.a(new char[]{Typography.less, 0}));
        return;
    L9:
        r1.a(new Token.e());
    }

    private static void readEndTag(c r0, a r1, TokeniserState r2, TokeniserState r3) {
        if (r1.p() == false) goto L5;
        r0.a(false);
        r0.a(r2);
        return;
    L5:
        r0.a("</");
        r0.a(r3);
    }

    public static TokeniserState valueOf(String r2) {
        return (TokeniserState) ZeusTransformUtils.preCheckCast(Enum.valueOf(TokeniserState.class, r2), TokeniserState.class, "com.obric.memorydata.plugin");
    }

    public static TokeniserState[] values() {
        return (TokeniserState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TokeniserState[].class, "com.obric.memorydata.plugin");
    }

    abstract void read(c r1, a r2);
}
