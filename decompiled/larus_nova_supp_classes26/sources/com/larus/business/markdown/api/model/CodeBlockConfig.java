package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bV\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0002\u0010!J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010]\u001a\u00020\u0006HÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\u0006HÆ\u0003J¶\u0002\u0010`\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\u00062\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u0003HÖ\u0001J\t\u0010e\u001a\u00020\fHÖ\u0001R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010#R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b'\u0010#R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b(\u0010#R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b*\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u00105R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u00105R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u00105R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u00105R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u00105R\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u00105R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u00105R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b@\u0010#R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\bA\u0010#R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\bB\u0010#R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010D¨\u0006f"}, d2 = {"Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "", "cornerRadius", "", "titleBgColor", "enableTitleBottomLine", "", "titleBottomLineColor", "codeTitleSize", "codeContentSize", "enableCodeFullScreenButton", "codeCopyTitle", "", "enablePreviewButton", "enableCodeCopyButton", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "enableCodeHeader", "backgroundColor", "blockBackgroundColor", "codeTextColor", "blockMargin", "enableScroll", "enableLineNumber", "lineNumberColor", "enableBlockBackground", "codeBlockTextColor", "blockBorderColor", "blockBorderWidth", "enableSyntaxHighlight", "disableReplacementSpan", "enableCodeBlockStroke", "enableCodeBlockHeaderBackground", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Integer;ZLjava/lang/String;ZZLcom/larus/business/markdown/api/model/TitleStyle;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Boolean;ZZ)V", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBlockBackgroundColor", "getBlockBorderColor", "getBlockBorderWidth", "getBlockMargin", "getCodeBlockTextColor", "getCodeContentSize", "getCodeCopyTitle", "()Ljava/lang/String;", "getCodeTextColor", "getCodeTitleSize", "()I", "getCornerRadius", "getDisableReplacementSpan", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableBlockBackground", "()Z", "getEnableCodeBlockHeaderBackground", "getEnableCodeBlockStroke", "getEnableCodeCopyButton", "getEnableCodeFullScreenButton", "getEnableCodeHeader", "getEnableLineNumber", "getEnablePreviewButton", "getEnableScroll", "getEnableSyntaxHighlight", "getEnableTitleBottomLine", "getLineNumberColor", "getTitleBgColor", "getTitleBottomLineColor", "getTitleStyle", "()Lcom/larus/business/markdown/api/model/TitleStyle;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Integer;ZLjava/lang/String;ZZLcom/larus/business/markdown/api/model/TitleStyle;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Boolean;ZZ)Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "equals", "other", "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeBlockConfig {
    private final Integer backgroundColor;
    private final Integer blockBackgroundColor;
    private final Integer blockBorderColor;
    private final Integer blockBorderWidth;
    private final Integer blockMargin;
    private final Integer codeBlockTextColor;
    private final Integer codeContentSize;
    private final String codeCopyTitle;
    private final Integer codeTextColor;
    private final int codeTitleSize;
    private final Integer cornerRadius;
    private final Boolean disableReplacementSpan;
    private final boolean enableBlockBackground;
    private final boolean enableCodeBlockHeaderBackground;
    private final boolean enableCodeBlockStroke;
    private final boolean enableCodeCopyButton;
    private final boolean enableCodeFullScreenButton;
    private final boolean enableCodeHeader;
    private final boolean enableLineNumber;
    private final boolean enablePreviewButton;
    private final boolean enableScroll;
    private final boolean enableSyntaxHighlight;
    private final boolean enableTitleBottomLine;
    private final Integer lineNumberColor;
    private final Integer titleBgColor;
    private final Integer titleBottomLineColor;
    private final TitleStyle titleStyle;

    public CodeBlockConfig() {
        this(null, null, false, null, 0, null, false, null, false, false, null, false, null, null, null, null, false, false, null, false, null, null, null, false, null, false, false, 134217727, null);
    }

    public static /* synthetic */ CodeBlockConfig copy$default(CodeBlockConfig r17, Integer r18, Integer r19, boolean r20, Integer r21, int r22, Integer r23, boolean r24, String r25, boolean r26, boolean r27, TitleStyle r28, boolean r29, Integer r30, Integer r31, Integer r32, Integer r33, boolean r34, boolean r35, Integer r36, boolean r37, Integer r38, Integer r39, Integer r40, boolean r41, Boolean r42, boolean r43, boolean r44, int r45, Object r46) {
        if ((r45 & 1) == 0) goto L5;
        Integer r2 = r17.cornerRadius;
    L7:
        if ((r45 & 2) == 0) goto L9;
        Integer r3 = r17.titleBgColor;
    L11:
        if ((r45 & 4) == 0) goto L13;
        boolean r4 = r17.enableTitleBottomLine;
    L15:
        if ((r45 & 8) == 0) goto L17;
        Integer r5 = r17.titleBottomLineColor;
    L19:
        if ((r45 & 16) == 0) goto L21;
        int r6 = r17.codeTitleSize;
    L23:
        if ((r45 & 32) == 0) goto L25;
        Integer r7 = r17.codeContentSize;
    L27:
        if ((r45 & 64) == 0) goto L29;
        boolean r8 = r17.enableCodeFullScreenButton;
    L31:
        if ((r45 & 128) == 0) goto L33;
        String r9 = r17.codeCopyTitle;
    L35:
        if ((r45 & 256) == 0) goto L37;
        boolean r10 = r17.enablePreviewButton;
    L39:
        if ((r45 & 512) == 0) goto L41;
        boolean r11 = r17.enableCodeCopyButton;
    L43:
        if ((r45 & 1024) == 0) goto L45;
        TitleStyle r12 = r17.titleStyle;
    L47:
        if ((r45 & 2048) == 0) goto L49;
        boolean r13 = r17.enableCodeHeader;
    L51:
        if ((r45 & 4096) == 0) goto L53;
        Integer r14 = r17.backgroundColor;
    L55:
        if ((r45 & 8192) == 0) goto L57;
        Integer r15 = r17.blockBackgroundColor;
    L58:
        Integer r310 = r15;
        if ((r45 & 16384) == 0) goto L61;
        Integer r16 = r17.codeTextColor;
    L62:
        Integer r311 = r16;
        if ((r45 & 32768) == 0) goto L65;
        Integer r110 = r17.blockMargin;
    L66:
        Integer r312 = r110;
        if ((r45 & 65536) == 0) goto L69;
        boolean r111 = r17.enableScroll;
    L70:
        boolean r313 = r111;
        if ((r45 & 131072) == 0) goto L73;
        boolean r112 = r17.enableLineNumber;
    L74:
        boolean r314 = r112;
        if ((r45 & 262144) == 0) goto L77;
        Integer r113 = r17.lineNumberColor;
    L78:
        Integer r315 = r113;
        if ((r45 & 524288) == 0) goto L81;
        boolean r114 = r17.enableBlockBackground;
    L82:
        boolean r316 = r114;
        if ((r45 & 1048576) == 0) goto L85;
        Integer r115 = r17.codeBlockTextColor;
    L86:
        Integer r317 = r115;
        if ((r45 & 2097152) == 0) goto L89;
        Integer r116 = r17.blockBorderColor;
    L90:
        Integer r318 = r116;
        if ((r45 & 4194304) == 0) goto L93;
        Integer r117 = r17.blockBorderWidth;
    L94:
        Integer r47 = r117;
        if ((r45 & 8388608) == 0) goto L97;
        boolean r118 = r17.enableSyntaxHighlight;
    L98:
        boolean r48 = r118;
        if ((r45 & 16777216) == 0) goto L101;
        Boolean r119 = r17.disableReplacementSpan;
    L102:
        Boolean r49 = r119;
        if ((r45 & 33554432) == 0) goto L105;
        boolean r120 = r17.enableCodeBlockStroke;
    L107:
        if ((r45 & 67108864) == 0) goto L109;
        boolean r1 = r17.enableCodeBlockHeaderBackground;
    L111:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r47, r48, r49, r120, r1);
    L109:
        r1 = r44;
        goto L111
    L105:
        r120 = r43;
        goto L107
    L101:
        r119 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Integer component1() {
        return this.cornerRadius;
    }

    public final boolean component10() {
        return this.enableCodeCopyButton;
    }

    public final TitleStyle component11() {
        return this.titleStyle;
    }

    public final boolean component12() {
        return this.enableCodeHeader;
    }

    public final Integer component13() {
        return this.backgroundColor;
    }

    public final Integer component14() {
        return this.blockBackgroundColor;
    }

    public final Integer component15() {
        return this.codeTextColor;
    }

    public final Integer component16() {
        return this.blockMargin;
    }

    public final boolean component17() {
        return this.enableScroll;
    }

    public final boolean component18() {
        return this.enableLineNumber;
    }

    public final Integer component19() {
        return this.lineNumberColor;
    }

    public final Integer component2() {
        return this.titleBgColor;
    }

    public final boolean component20() {
        return this.enableBlockBackground;
    }

    public final Integer component21() {
        return this.codeBlockTextColor;
    }

    public final Integer component22() {
        return this.blockBorderColor;
    }

    public final Integer component23() {
        return this.blockBorderWidth;
    }

    public final boolean component24() {
        return this.enableSyntaxHighlight;
    }

    public final Boolean component25() {
        return this.disableReplacementSpan;
    }

    public final boolean component26() {
        return this.enableCodeBlockStroke;
    }

    public final boolean component27() {
        return this.enableCodeBlockHeaderBackground;
    }

    public final boolean component3() {
        return this.enableTitleBottomLine;
    }

    public final Integer component4() {
        return this.titleBottomLineColor;
    }

    public final int component5() {
        return this.codeTitleSize;
    }

    public final Integer component6() {
        return this.codeContentSize;
    }

    public final boolean component7() {
        return this.enableCodeFullScreenButton;
    }

    public final String component8() {
        return this.codeCopyTitle;
    }

    public final boolean component9() {
        return this.enablePreviewButton;
    }

    public final CodeBlockConfig copy(Integer r30, Integer r31, boolean r32, Integer r33, int r34, Integer r35, boolean r36, String r37, boolean r38, boolean r39, TitleStyle r40, boolean r41, Integer r42, Integer r43, Integer r44, Integer r45, boolean r46, boolean r47, Integer r48, boolean r49, Integer r50, Integer r51, Integer r52, boolean r53, Boolean r54, boolean r55, boolean r56) {
        Intrinsics.checkNotNullParameter(r37, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(r40, "titleStyle");
        return new CodeBlockConfig(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CodeBlockConfig) == true) goto L8;
        return false;
    L8:
        CodeBlockConfig r6 = (CodeBlockConfig) r5;
        if (Intrinsics.areEqual(this.cornerRadius, r6.cornerRadius) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleBgColor, r6.titleBgColor) == true) goto L15;
        return false;
    L15:
        if (this.enableTitleBottomLine == r6.enableTitleBottomLine) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.titleBottomLineColor, r6.titleBottomLineColor) == true) goto L21;
        return false;
    L21:
        if (this.codeTitleSize == r6.codeTitleSize) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.codeContentSize, r6.codeContentSize) == true) goto L27;
        return false;
    L27:
        if (this.enableCodeFullScreenButton == r6.enableCodeFullScreenButton) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.codeCopyTitle, r6.codeCopyTitle) == true) goto L33;
        return false;
    L33:
        if (this.enablePreviewButton == r6.enablePreviewButton) goto L36;
        return false;
    L36:
        if (this.enableCodeCopyButton == r6.enableCodeCopyButton) goto L39;
        return false;
    L39:
        if (this.titleStyle == r6.titleStyle) goto L42;
        return false;
    L42:
        if (this.enableCodeHeader == r6.enableCodeHeader) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.blockBackgroundColor, r6.blockBackgroundColor) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.codeTextColor, r6.codeTextColor) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.blockMargin, r6.blockMargin) == true) goto L57;
        return false;
    L57:
        if (this.enableScroll == r6.enableScroll) goto L60;
        return false;
    L60:
        if (this.enableLineNumber == r6.enableLineNumber) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.lineNumberColor, r6.lineNumberColor) == true) goto L66;
        return false;
    L66:
        if (this.enableBlockBackground == r6.enableBlockBackground) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.codeBlockTextColor, r6.codeBlockTextColor) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.blockBorderColor, r6.blockBorderColor) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.blockBorderWidth, r6.blockBorderWidth) == true) goto L78;
        return false;
    L78:
        if (this.enableSyntaxHighlight == r6.enableSyntaxHighlight) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.disableReplacementSpan, r6.disableReplacementSpan) == true) goto L84;
        return false;
    L84:
        if (this.enableCodeBlockStroke == r6.enableCodeBlockStroke) goto L87;
        return false;
    L87:
        if (this.enableCodeBlockHeaderBackground == r6.enableCodeBlockHeaderBackground) goto L89;
        return false;
    L89:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v52, types: [int] */
    /* JADX WARN: Type inference failed for: r0v54, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Integer r0 = this.cornerRadius;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.titleBgColor;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.enableTitleBottomLine;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r6 + r9) * 31;
        Integer r11 = this.titleBottomLineColor;
        if (r11 != null) goto L16;
        int r12 = 0;
    L17:
        int r13 = (((r10 + r12) * 31) + this.codeTitleSize) * 31;
        Integer r14 = this.codeContentSize;
        if (r14 != null) goto L20;
        int r15 = 0;
    L21:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.enableCodeFullScreenButton;
        ?? r18 = r17;
        if (r17 == false) goto L24;
        r18 = 1;
    L24:
        int r19 = (((r16 + r18) * 31) + this.codeCopyTitle.hashCode()) * 31;
        boolean r20 = this.enablePreviewButton;
        ?? r21 = r20;
        if (r20 == false) goto L27;
        r21 = 1;
    L27:
        int r22 = (r19 + r21) * 31;
        boolean r23 = this.enableCodeCopyButton;
        ?? r24 = r23;
        if (r23 == false) goto L30;
        r24 = 1;
    L30:
        int r25 = (((r22 + r24) * 31) + this.titleStyle.hashCode()) * 31;
        boolean r26 = this.enableCodeHeader;
        ?? r27 = r26;
        if (r26 == false) goto L33;
        r27 = 1;
    L33:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.backgroundColor;
        if (r29 != null) goto L36;
        int r30 = 0;
    L37:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.blockBackgroundColor;
        if (r32 != null) goto L40;
        int r33 = 0;
    L41:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.codeTextColor;
        if (r35 != null) goto L44;
        int r36 = 0;
    L45:
        int r37 = (r34 + r36) * 31;
        Integer r38 = this.blockMargin;
        if (r38 != null) goto L48;
        int r39 = 0;
    L49:
        int r40 = (r37 + r39) * 31;
        boolean r41 = this.enableScroll;
        ?? r42 = r41;
        if (r41 == false) goto L52;
        r42 = 1;
    L52:
        int r43 = (r40 + r42) * 31;
        boolean r44 = this.enableLineNumber;
        ?? r45 = r44;
        if (r44 == false) goto L55;
        r45 = 1;
    L55:
        int r46 = (r43 + r45) * 31;
        Integer r47 = this.lineNumberColor;
        if (r47 != null) goto L58;
        int r48 = 0;
    L59:
        int r49 = (r46 + r48) * 31;
        boolean r50 = this.enableBlockBackground;
        ?? r51 = r50;
        if (r50 == false) goto L62;
        r51 = 1;
    L62:
        int r52 = (r49 + r51) * 31;
        Integer r53 = this.codeBlockTextColor;
        if (r53 != null) goto L65;
        int r54 = 0;
    L66:
        int r55 = (r52 + r54) * 31;
        Integer r56 = this.blockBorderColor;
        if (r56 != null) goto L69;
        int r57 = 0;
    L70:
        int r58 = (r55 + r57) * 31;
        Integer r59 = this.blockBorderWidth;
        if (r59 != null) goto L73;
        int r60 = 0;
    L74:
        int r61 = (r58 + r60) * 31;
        boolean r62 = this.enableSyntaxHighlight;
        ?? r63 = r62;
        if (r62 == false) goto L77;
        r63 = 1;
    L77:
        int r64 = (r61 + r63) * 31;
        Boolean r65 = this.disableReplacementSpan;
        if (r65 == null) goto L81;
        r1 = r65.hashCode();
    L81:
        int r66 = (r64 + r1) * 31;
        boolean r67 = this.enableCodeBlockStroke;
        ?? r68 = r67;
        if (r67 == false) goto L84;
        r68 = 1;
    L84:
        int r69 = (r66 + r68) * 31;
        boolean r70 = this.enableCodeBlockHeaderBackground;
        if (r70 == true) goto L89;
        r8 = r70;
    L89:
        return r69 + r8;
    L73:
        r60 = r59.hashCode();
        goto L74
    L69:
        r57 = r56.hashCode();
        goto L70
    L65:
        r54 = r53.hashCode();
        goto L66
    L58:
        r48 = r47.hashCode();
        goto L59
    L48:
        r39 = r38.hashCode();
        goto L49
    L44:
        r36 = r35.hashCode();
        goto L45
    L40:
        r33 = r32.hashCode();
        goto L41
    L36:
        r30 = r29.hashCode();
        goto L37
    L20:
        r15 = r14.hashCode();
        goto L21
    L16:
        r12 = r11.hashCode();
        goto L17
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CodeBlockConfig(cornerRadius=" + this.cornerRadius + ", titleBgColor=" + this.titleBgColor + ", enableTitleBottomLine=" + this.enableTitleBottomLine + ", titleBottomLineColor=" + this.titleBottomLineColor + ", codeTitleSize=" + this.codeTitleSize + ", codeContentSize=" + this.codeContentSize + ", enableCodeFullScreenButton=" + this.enableCodeFullScreenButton + ", codeCopyTitle=" + this.codeCopyTitle + ", enablePreviewButton=" + this.enablePreviewButton + ", enableCodeCopyButton=" + this.enableCodeCopyButton + ", titleStyle=" + this.titleStyle + ", enableCodeHeader=" + this.enableCodeHeader + ", backgroundColor=" + this.backgroundColor + ", blockBackgroundColor=" + this.blockBackgroundColor + ", codeTextColor=" + this.codeTextColor + ", blockMargin=" + this.blockMargin + ", enableScroll=" + this.enableScroll + ", enableLineNumber=" + this.enableLineNumber + ", lineNumberColor=" + this.lineNumberColor + ", enableBlockBackground=" + this.enableBlockBackground + ", codeBlockTextColor=" + this.codeBlockTextColor + ", blockBorderColor=" + this.blockBorderColor + ", blockBorderWidth=" + this.blockBorderWidth + ", enableSyntaxHighlight=" + this.enableSyntaxHighlight + ", disableReplacementSpan=" + this.disableReplacementSpan + ", enableCodeBlockStroke=" + this.enableCodeBlockStroke + ", enableCodeBlockHeaderBackground=" + this.enableCodeBlockHeaderBackground + ')';
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Integer getBlockBackgroundColor() {
        return this.blockBackgroundColor;
    }

    public final Integer getBlockBorderColor() {
        return this.blockBorderColor;
    }

    public final Integer getBlockBorderWidth() {
        return this.blockBorderWidth;
    }

    public final Integer getBlockMargin() {
        return this.blockMargin;
    }

    public final Integer getCodeBlockTextColor() {
        return this.codeBlockTextColor;
    }

    public final Integer getCodeContentSize() {
        return this.codeContentSize;
    }

    public final String getCodeCopyTitle() {
        return this.codeCopyTitle;
    }

    public final Integer getCodeTextColor() {
        return this.codeTextColor;
    }

    public final int getCodeTitleSize() {
        return this.codeTitleSize;
    }

    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    public final Boolean getDisableReplacementSpan() {
        return this.disableReplacementSpan;
    }

    public final boolean getEnableBlockBackground() {
        return this.enableBlockBackground;
    }

    public final boolean getEnableCodeBlockHeaderBackground() {
        return this.enableCodeBlockHeaderBackground;
    }

    public final boolean getEnableCodeBlockStroke() {
        return this.enableCodeBlockStroke;
    }

    public final boolean getEnableCodeCopyButton() {
        return this.enableCodeCopyButton;
    }

    public final boolean getEnableCodeFullScreenButton() {
        return this.enableCodeFullScreenButton;
    }

    public final boolean getEnableCodeHeader() {
        return this.enableCodeHeader;
    }

    public final boolean getEnableLineNumber() {
        return this.enableLineNumber;
    }

    public final boolean getEnablePreviewButton() {
        return this.enablePreviewButton;
    }

    public final boolean getEnableScroll() {
        return this.enableScroll;
    }

    public final boolean getEnableSyntaxHighlight() {
        return this.enableSyntaxHighlight;
    }

    public final boolean getEnableTitleBottomLine() {
        return this.enableTitleBottomLine;
    }

    public final Integer getLineNumberColor() {
        return this.lineNumberColor;
    }

    public final Integer getTitleBgColor() {
        return this.titleBgColor;
    }

    public final Integer getTitleBottomLineColor() {
        return this.titleBottomLineColor;
    }

    public final TitleStyle getTitleStyle() {
        return this.titleStyle;
    }

    public CodeBlockConfig(Integer r5, Integer r6, boolean r7, Integer r8, int r9, Integer r10, boolean r11, String r12, boolean r13, boolean r14, TitleStyle r15, boolean r16, Integer r17, Integer r18, Integer r19, Integer r20, boolean r21, boolean r22, Integer r23, boolean r24, Integer r25, Integer r26, Integer r27, boolean r28, Boolean r29, boolean r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r12, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(r15, "titleStyle");
        this.cornerRadius = r5;
        this.titleBgColor = r6;
        this.enableTitleBottomLine = r7;
        this.titleBottomLineColor = r8;
        this.codeTitleSize = r9;
        this.codeContentSize = r10;
        this.enableCodeFullScreenButton = r11;
        this.codeCopyTitle = r12;
        this.enablePreviewButton = r13;
        this.enableCodeCopyButton = r14;
        this.titleStyle = r15;
        this.enableCodeHeader = r16;
        this.backgroundColor = r17;
        this.blockBackgroundColor = r18;
        this.codeTextColor = r19;
        this.blockMargin = r20;
        this.enableScroll = r21;
        this.enableLineNumber = r22;
        this.lineNumberColor = r23;
        this.enableBlockBackground = r24;
        this.codeBlockTextColor = r25;
        this.blockBorderColor = r26;
        this.blockBorderWidth = r27;
        this.enableSyntaxHighlight = r28;
        this.disableReplacementSpan = r29;
        this.enableCodeBlockStroke = r30;
        this.enableCodeBlockHeaderBackground = r31;
    }

    public /* synthetic */ CodeBlockConfig(Integer r29, Integer r30, boolean r31, Integer r32, int r33, Integer r34, boolean r35, String r36, boolean r37, boolean r38, TitleStyle r39, boolean r40, Integer r41, Integer r42, Integer r43, Integer r44, boolean r45, boolean r46, Integer r47, boolean r48, Integer r49, Integer r50, Integer r51, boolean r52, Boolean r53, boolean r54, boolean r55, int r56, DefaultConstructorMarker r57) {
        if ((r56 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r56 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r56 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r56 & 8) == 0) goto L17;
        Integer r6 = null;
    L19:
        if ((r56 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r56 & 32) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r56 & 64) == 0) goto L29;
        boolean r9 = true;
    L31:
        if ((r56 & 128) == 0) goto L33;
        String r11 = "";
    L35:
        if ((r56 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r56 & 512) == 0) goto L41;
        boolean r13 = true;
    L43:
        if ((r56 & 1024) == 0) goto L45;
        TitleStyle r14 = TitleStyle.NORMAL;
    L47:
        if ((r56 & 2048) == 0) goto L49;
        boolean r15 = true;
    L51:
        if ((r56 & 4096) == 0) goto L53;
        Integer r2 = null;
    L55:
        if ((r56 & 8192) == 0) goto L57;
        Integer r5 = null;
    L59:
        if ((r56 & 16384) == 0) goto L61;
        Integer r10 = null;
    L63:
        if ((r56 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r56 & 65536) == 0) goto L69;
        boolean r17 = false;
    L71:
        if ((r56 & 131072) == 0) goto L73;
        boolean r18 = false;
    L75:
        if ((r56 & 262144) == 0) goto L77;
        Integer r19 = null;
    L79:
        if ((r56 & 524288) == 0) goto L81;
        boolean r20 = true;
    L83:
        if ((r56 & 1048576) == 0) goto L85;
        Integer r21 = null;
    L87:
        if ((r56 & 2097152) == 0) goto L89;
        Integer r22 = null;
    L91:
        if ((r56 & 4194304) == 0) goto L93;
        Integer r23 = null;
    L95:
        if ((r56 & 8388608) == 0) goto L97;
        boolean r24 = true;
    L99:
        if ((r56 & 16777216) == 0) goto L101;
        Boolean r25 = Boolean.FALSE;
    L103:
        if ((r56 & 33554432) == 0) goto L105;
        boolean r26 = false;
    L107:
        if ((r56 & 67108864) == 0) goto L109;
        boolean r0 = false;
    L110:
        this(r1, r3, r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r2, r5, r10, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r0);
        return;
    L109:
        r0 = r55;
        goto L110
    L105:
        r26 = r54;
        goto L107
    L101:
        r25 = r53;
        goto L103
    L97:
        r24 = r52;
        goto L99
    L93:
        r23 = r51;
        goto L95
    L89:
        r22 = r50;
        goto L91
    L85:
        r21 = r49;
        goto L87
    L81:
        r20 = r48;
        goto L83
    L77:
        r19 = r47;
        goto L79
    L73:
        r18 = r46;
        goto L75
    L69:
        r17 = r45;
        goto L71
    L65:
        r16 = r44;
        goto L67
    L61:
        r10 = r43;
        goto L63
    L57:
        r5 = r42;
        goto L59
    L53:
        r2 = r41;
        goto L55
    L49:
        r15 = r40;
        goto L51
    L45:
        r14 = r39;
        goto L47
    L41:
        r13 = r38;
        goto L43
    L37:
        r12 = r37;
        goto L39
    L33:
        r11 = r36;
        goto L35
    L29:
        r9 = r35;
        goto L31
    L25:
        r8 = r34;
        goto L27
    L21:
        r7 = r33;
        goto L23
    L17:
        r6 = r32;
        goto L19
    L13:
        r4 = r31;
        goto L15
    L9:
        r3 = r30;
        goto L11
    L5:
        r1 = r29;
        goto L7
    }
}
