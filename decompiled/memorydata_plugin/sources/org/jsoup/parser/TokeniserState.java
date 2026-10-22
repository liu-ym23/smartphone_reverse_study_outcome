package org.jsoup.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes7.dex */
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
    static final char[] attributeNameCharsSorted = null;
    static final char[] attributeValueUnquoted = null;
    private static final char eof = 65535;
    static final char nullChar = 0;
    private static final char replacementChar = 65533;
    private static final String replacementStr = null;

    private static /* synthetic */ TokeniserState[] $values() {
        return new TokeniserState[]{Data, CharacterReferenceInData, Rcdata, CharacterReferenceInRcdata, Rawtext, ScriptData, PLAINTEXT, TagOpen, EndTagOpen, TagName, RcdataLessthanSign, RCDATAEndTagOpen, RCDATAEndTagName, RawtextLessthanSign, RawtextEndTagOpen, RawtextEndTagName, ScriptDataLessthanSign, ScriptDataEndTagOpen, ScriptDataEndTagName, ScriptDataEscapeStart, ScriptDataEscapeStartDash, ScriptDataEscaped, ScriptDataEscapedDash, ScriptDataEscapedDashDash, ScriptDataEscapedLessthanSign, ScriptDataEscapedEndTagOpen, ScriptDataEscapedEndTagName, ScriptDataDoubleEscapeStart, ScriptDataDoubleEscaped, ScriptDataDoubleEscapedDash, ScriptDataDoubleEscapedDashDash, ScriptDataDoubleEscapedLessthanSign, ScriptDataDoubleEscapeEnd, BeforeAttributeName, AttributeName, AfterAttributeName, BeforeAttributeValue, AttributeValue_doubleQuoted, AttributeValue_singleQuoted, AttributeValue_unquoted, AfterAttributeValue_quoted, SelfClosingStartTag, BogusComment, MarkupDeclarationOpen, CommentStart, CommentStartDash, Comment, CommentEndDash, CommentEnd, CommentEndBang, Doctype, BeforeDoctypeName, DoctypeName, AfterDoctypeName, AfterDoctypePublicKeyword, BeforeDoctypePublicIdentifier, DoctypePublicIdentifier_doubleQuoted, DoctypePublicIdentifier_singleQuoted, AfterDoctypePublicIdentifier, BetweenDoctypePublicAndSystemIdentifiers, AfterDoctypeSystemKeyword, BeforeDoctypeSystemIdentifier, DoctypeSystemIdentifier_doubleQuoted, DoctypeSystemIdentifier_singleQuoted, AfterDoctypeSystemIdentifier, BogusDoctype, CdataSection};
    }

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
        final int r20 = 9;
        TagName = new AnonymousClass10(r19, r20);
        final String r21 = "RcdataLessthanSign";
        final int r22 = 10;
        RcdataLessthanSign = new AnonymousClass11(r21, r22);
        final String r23 = "RCDATAEndTagOpen";
        final int r24 = 11;
        RCDATAEndTagOpen = new AnonymousClass12(r23, r24);
        final String r25 = "RCDATAEndTagName";
        final int r26 = 12;
        RCDATAEndTagName = new AnonymousClass13(r25, r26);
        final String r27 = "RawtextLessthanSign";
        final int r28 = 13;
        RawtextLessthanSign = new AnonymousClass14(r27, r28);
        final String r29 = "RawtextEndTagOpen";
        final int r30 = 14;
        RawtextEndTagOpen = new AnonymousClass15(r29, r30);
        final String r31 = "RawtextEndTagName";
        final int r32 = 15;
        RawtextEndTagName = new AnonymousClass16(r31, r32);
        final String r33 = "ScriptDataLessthanSign";
        final int r34 = 16;
        ScriptDataLessthanSign = new AnonymousClass17(r33, r34);
        final String r35 = "ScriptDataEndTagOpen";
        final int r36 = 17;
        ScriptDataEndTagOpen = new AnonymousClass18(r35, r36);
        final String r37 = "ScriptDataEndTagName";
        final int r38 = 18;
        ScriptDataEndTagName = new AnonymousClass19(r37, r38);
        final String r39 = "ScriptDataEscapeStart";
        final int r40 = 19;
        ScriptDataEscapeStart = new AnonymousClass20(r39, r40);
        final String r41 = "ScriptDataEscapeStartDash";
        final int r42 = 20;
        ScriptDataEscapeStartDash = new AnonymousClass21(r41, r42);
        final String r43 = "ScriptDataEscaped";
        final int r44 = 21;
        ScriptDataEscaped = new AnonymousClass22(r43, r44);
        final String r45 = "ScriptDataEscapedDash";
        final int r46 = 22;
        ScriptDataEscapedDash = new AnonymousClass23(r45, r46);
        final String r47 = "ScriptDataEscapedDashDash";
        final int r48 = 23;
        ScriptDataEscapedDashDash = new AnonymousClass24(r47, r48);
        final String r49 = "ScriptDataEscapedLessthanSign";
        final int r50 = 24;
        ScriptDataEscapedLessthanSign = new AnonymousClass25(r49, r50);
        final String r51 = "ScriptDataEscapedEndTagOpen";
        final int r52 = 25;
        ScriptDataEscapedEndTagOpen = new AnonymousClass26(r51, r52);
        final String r53 = "ScriptDataEscapedEndTagName";
        final int r54 = 26;
        ScriptDataEscapedEndTagName = new AnonymousClass27(r53, r54);
        final String r55 = "ScriptDataDoubleEscapeStart";
        final int r56 = 27;
        ScriptDataDoubleEscapeStart = new AnonymousClass28(r55, r56);
        final String r57 = "ScriptDataDoubleEscaped";
        final int r58 = 28;
        ScriptDataDoubleEscaped = new AnonymousClass29(r57, r58);
        final String r59 = "ScriptDataDoubleEscapedDash";
        final int r60 = 29;
        ScriptDataDoubleEscapedDash = new AnonymousClass30(r59, r60);
        final String r61 = "ScriptDataDoubleEscapedDashDash";
        final int r62 = 30;
        ScriptDataDoubleEscapedDashDash = new AnonymousClass31(r61, r62);
        final String r63 = "ScriptDataDoubleEscapedLessthanSign";
        final int r64 = 31;
        ScriptDataDoubleEscapedLessthanSign = new AnonymousClass32(r63, r64);
        final String r65 = "ScriptDataDoubleEscapeEnd";
        final int r66 = 32;
        ScriptDataDoubleEscapeEnd = new AnonymousClass33(r65, r66);
        final String r67 = "BeforeAttributeName";
        final int r68 = 33;
        BeforeAttributeName = new AnonymousClass34(r67, r68);
        final String r69 = "AttributeName";
        final int r70 = 34;
        AttributeName = new AnonymousClass35(r69, r70);
        final String r71 = "AfterAttributeName";
        final int r72 = 35;
        AfterAttributeName = new AnonymousClass36(r71, r72);
        final String r73 = "BeforeAttributeValue";
        final int r74 = 36;
        BeforeAttributeValue = new AnonymousClass37(r73, r74);
        final String r75 = "AttributeValue_doubleQuoted";
        final int r76 = 37;
        AttributeValue_doubleQuoted = new AnonymousClass38(r75, r76);
        final String r77 = "AttributeValue_singleQuoted";
        final int r78 = 38;
        AttributeValue_singleQuoted = new AnonymousClass39(r77, r78);
        final String r79 = "AttributeValue_unquoted";
        final int r80 = 39;
        AttributeValue_unquoted = new AnonymousClass40(r79, r80);
        final String r81 = "AfterAttributeValue_quoted";
        final int r82 = 40;
        AfterAttributeValue_quoted = new AnonymousClass41(r81, r82);
        final String r83 = "SelfClosingStartTag";
        final int r84 = 41;
        SelfClosingStartTag = new AnonymousClass42(r83, r84);
        final String r85 = "BogusComment";
        final int r86 = 42;
        BogusComment = new AnonymousClass43(r85, r86);
        final String r87 = "MarkupDeclarationOpen";
        final int r88 = 43;
        MarkupDeclarationOpen = new AnonymousClass44(r87, r88);
        final String r89 = "CommentStart";
        final int r90 = 44;
        CommentStart = new AnonymousClass45(r89, r90);
        final String r91 = "CommentStartDash";
        final int r92 = 45;
        CommentStartDash = new AnonymousClass46(r91, r92);
        final String r93 = "Comment";
        final int r94 = 46;
        Comment = new AnonymousClass47(r93, r94);
        final String r95 = "CommentEndDash";
        final int r96 = 47;
        CommentEndDash = new AnonymousClass48(r95, r96);
        final String r97 = "CommentEnd";
        final int r98 = 48;
        CommentEnd = new AnonymousClass49(r97, r98);
        final String r99 = "CommentEndBang";
        final int r100 = 49;
        CommentEndBang = new AnonymousClass50(r99, r100);
        final String r101 = "Doctype";
        final int r102 = 50;
        Doctype = new AnonymousClass51(r101, r102);
        final String r103 = "BeforeDoctypeName";
        final int r104 = 51;
        BeforeDoctypeName = new AnonymousClass52(r103, r104);
        final String r105 = "DoctypeName";
        final int r106 = 52;
        DoctypeName = new AnonymousClass53(r105, r106);
        final String r107 = "AfterDoctypeName";
        final int r108 = 53;
        AfterDoctypeName = new AnonymousClass54(r107, r108);
        final String r109 = "AfterDoctypePublicKeyword";
        final int r110 = 54;
        AfterDoctypePublicKeyword = new AnonymousClass55(r109, r110);
        final String r111 = "BeforeDoctypePublicIdentifier";
        final int r112 = 55;
        BeforeDoctypePublicIdentifier = new AnonymousClass56(r111, r112);
        final String r113 = "DoctypePublicIdentifier_doubleQuoted";
        final int r114 = 56;
        DoctypePublicIdentifier_doubleQuoted = new AnonymousClass57(r113, r114);
        final String r115 = "DoctypePublicIdentifier_singleQuoted";
        final int r116 = 57;
        DoctypePublicIdentifier_singleQuoted = new AnonymousClass58(r115, r116);
        final String r117 = "AfterDoctypePublicIdentifier";
        final int r118 = 58;
        AfterDoctypePublicIdentifier = new AnonymousClass59(r117, r118);
        final String r119 = "BetweenDoctypePublicAndSystemIdentifiers";
        final int r120 = 59;
        BetweenDoctypePublicAndSystemIdentifiers = new AnonymousClass60(r119, r120);
        final String r121 = "AfterDoctypeSystemKeyword";
        final int r122 = 60;
        AfterDoctypeSystemKeyword = new AnonymousClass61(r121, r122);
        final String r123 = "BeforeDoctypeSystemIdentifier";
        final int r124 = 61;
        BeforeDoctypeSystemIdentifier = new AnonymousClass62(r123, r124);
        final String r125 = "DoctypeSystemIdentifier_doubleQuoted";
        final int r126 = 62;
        DoctypeSystemIdentifier_doubleQuoted = new AnonymousClass63(r125, r126);
        final String r127 = "DoctypeSystemIdentifier_singleQuoted";
        final int r128 = 63;
        DoctypeSystemIdentifier_singleQuoted = new AnonymousClass64(r127, r128);
        final String r129 = "AfterDoctypeSystemIdentifier";
        final int r130 = 64;
        AfterDoctypeSystemIdentifier = new AnonymousClass65(r129, r130);
        final String r131 = "BogusDoctype";
        final int r132 = 65;
        BogusDoctype = new AnonymousClass66(r131, r132);
        final String r133 = "CdataSection";
        final int r134 = 66;
        CdataSection = new AnonymousClass67(r133, r134);
        $VALUES = $values();
        attributeNameCharsSorted = new char[]{'\t', '\n', '\f', '\r', ' ', Typography.quote, '\'', '/', Typography.less, '=', Typography.greater};
        attributeValueUnquoted = new char[]{0, '\t', '\n', '\f', '\r', ' ', Typography.quote, Typography.amp, '\'', Typography.less, '=', Typography.greater, '`'};
        replacementStr = String.valueOf(65533);
    }

    private TokeniserState(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ TokeniserState(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ void access$100(h r0, TokeniserState r1) {
        readCharRef(r0, r1);
    }

    static /* synthetic */ void access$200(h r0, a r1, TokeniserState r2, TokeniserState r3) {
        readRawData(r0, r1, r2, r3);
    }

    static /* synthetic */ String access$300() {
        return replacementStr;
    }

    static /* synthetic */ void access$400(h r0, a r1, TokeniserState r2, TokeniserState r3) {
        readEndTag(r0, r1, r2, r3);
    }

    static /* synthetic */ void access$500(h r0, a r1, TokeniserState r2) {
        handleDataEndTag(r0, r1, r2);
    }

    static /* synthetic */ void access$600(h r0, a r1, TokeniserState r2, TokeniserState r3) {
        handleDataDoubleEscapeTag(r0, r1, r2, r3);
    }

    private static void handleDataDoubleEscapeTag(h r2, a r3, TokeniserState r4, TokeniserState r5) {
        if (r3.w() == false) goto L6;
        String r6 = r3.s();
        r2.f18297b.append(r6);
        r2.a(r6);
        return;
    L6:
        char r0 = r3.i();
        if (r0 == '\t') goto L22;
        if (r0 == '\n') goto L22;
        if (r0 == '\f') goto L22;
        if (r0 == '\r') goto L22;
        if (r0 == ' ') goto L22;
        if (r0 == '/') goto L22;
        if (r0 == '>') goto L22;
        r3.j();
        r2.a(r5);
        return;
    L22:
        if (r2.f18297b.toString().equals("script") == false) goto L24;
        r2.a(r4);
    L25:
        r2.a(r0);
        return;
    L24:
        r2.a(r5);
        goto L25
    }

    private static void handleDataEndTag(h r3, a r4, TokeniserState r5) {
        if (r4.w() == false) goto L6;
        String r6 = r4.s();
        r3.e.c(r6);
        r3.f18297b.append(r6);
        return;
    L6:
        boolean r0 = false;
        boolean r2 = true;
        if (r3.i() == true) goto L9;
    L30:
        if (r2 == false) goto L33;
        r3.a("</");
        r3.a(r3.f18297b);
        r3.a(r5);
        return;
    L33:
        return;
    L9:
        if (r4.g() == true) goto L30;
        char r7 = r4.i();
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
        r3.f18297b.append(r7);
        r0 = true;
        goto L29
    L25:
        r3.b();
        r8 = Data;
        goto L28
    }

    private static void readCharRef(h r2, TokeniserState r3) {
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

    private static void readEndTag(h r0, a r1, TokeniserState r2, TokeniserState r3) {
        if (r1.x() == false) goto L5;
        r0.a(false);
        r0.a(r2);
        return;
    L5:
        r0.a("</");
        r0.a(r3);
    }

    private static void readRawData(h r1, a r2, TokeniserState r3, TokeniserState r4) {
        char r0 = r2.h();
        if (r0 != 0) goto L5;
        r1.c(r3);
        r2.k();
        r1.a(65533);
        return;
    L5:
        if (r0 != '<') goto L7;
        r1.b(r4);
        return;
    L7:
        if (r0 == 65535) goto L9;
        r1.a(r2.p());
        return;
    L9:
        r1.a(new Token.e());
    }

    public static TokeniserState valueOf(String r2) {
        return (TokeniserState) ZeusTransformUtils.preCheckCast(Enum.valueOf(TokeniserState.class, r2), TokeniserState.class, "com.obric.memorydata.plugin");
    }

    public static TokeniserState[] values() {
        return (TokeniserState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TokeniserState[].class, "com.obric.memorydata.plugin");
    }

    abstract void read(h r1, a r2);
}
