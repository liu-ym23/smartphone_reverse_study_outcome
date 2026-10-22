package com.larus.business.markdown.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bP\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0010HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00100J\t\u0010S\u001a\u00020\u0006HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\fHÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J¢\u0002\u0010Z\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\u0003HÖ\u0001J\t\u0010_\u001a\u00020\fHÖ\u0001R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b%\u0010!R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b'\u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b(\u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010!R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b.\u0010!R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b<\u0010!R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b=\u0010!R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b>\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006`"}, d2 = {"Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "", "cornerRadius", "", "titleBgColor", "enableTitleBottomLine", "", "titleBottomLineColor", "codeTitleSize", "codeContentSize", "enableCodeFullScreenButton", "codeCopyTitle", "", "enablePreviewButton", "enableCodeCopyButton", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "enableCodeHeader", "backgroundColor", "blockBackgroundColor", "codeTextColor", "blockMargin", "enableScroll", "enableLineNumber", "lineNumberColor", "enableBlockBackground", "codeBlockTextColor", "blockBorderColor", "blockBorderWidth", "enableSyntaxHighlight", "disableReplacementSpan", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Integer;ZLjava/lang/String;ZZLcom/larus/business/markdown/api/model/TitleStyle;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Boolean;)V", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBlockBackgroundColor", "getBlockBorderColor", "getBlockBorderWidth", "getBlockMargin", "getCodeBlockTextColor", "getCodeContentSize", "getCodeCopyTitle", "()Ljava/lang/String;", "getCodeTextColor", "getCodeTitleSize", "()I", "getCornerRadius", "getDisableReplacementSpan", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableBlockBackground", "()Z", "getEnableCodeCopyButton", "getEnableCodeFullScreenButton", "getEnableCodeHeader", "getEnableLineNumber", "getEnablePreviewButton", "getEnableScroll", "getEnableSyntaxHighlight", "getEnableTitleBottomLine", "getLineNumberColor", "getTitleBgColor", "getTitleBottomLineColor", "getTitleStyle", "()Lcom/larus/business/markdown/api/model/TitleStyle;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Integer;ZLjava/lang/String;ZZLcom/larus/business/markdown/api/model/TitleStyle;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Boolean;)Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "equals", "other", "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        this(null, null, false, null, 0, null, false, null, false, false, null, false, null, null, null, null, false, false, null, false, null, null, null, false, null, 33554431, null);
    }

    public CodeBlockConfig(Integer r5, Integer r6, boolean r7, Integer r8, int r9, Integer r10, boolean r11, String r12, boolean r13, boolean r14, TitleStyle r15, boolean r16, Integer r17, Integer r18, Integer r19, Integer r20, boolean r21, boolean r22, Integer r23, boolean r24, Integer r25, Integer r26, Integer r27, boolean r28, Boolean r29) {
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
    }

    public /* synthetic */ CodeBlockConfig(Integer r27, Integer r28, boolean r29, Integer r30, int r31, Integer r32, boolean r33, String r34, boolean r35, boolean r36, TitleStyle r37, boolean r38, Integer r39, Integer r40, Integer r41, Integer r42, boolean r43, boolean r44, Integer r45, boolean r46, Integer r47, Integer r48, Integer r49, boolean r50, Boolean r51, int r52, DefaultConstructorMarker r53) {
        if ((r52 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r52 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r52 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r52 & 8) == 0) goto L17;
        Integer r6 = null;
    L19:
        if ((r52 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r52 & 32) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r52 & 64) == 0) goto L29;
        boolean r9 = true;
    L31:
        if ((r52 & 128) == 0) goto L33;
        String r11 = "";
    L35:
        if ((r52 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r52 & 512) == 0) goto L41;
        boolean r13 = true;
    L43:
        if ((r52 & 1024) == 0) goto L45;
        TitleStyle r14 = TitleStyle.NORMAL;
    L47:
        if ((r52 & 2048) == 0) goto L49;
        boolean r15 = true;
    L51:
        if ((r52 & 4096) == 0) goto L53;
        Integer r2 = null;
    L55:
        if ((r52 & 8192) == 0) goto L57;
        Integer r10 = null;
    L59:
        if ((r52 & 16384) == 0) goto L61;
        Integer r5 = null;
    L63:
        if ((r52 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r52 & 65536) == 0) goto L69;
        boolean r17 = false;
    L71:
        if ((r52 & 131072) == 0) goto L73;
        boolean r18 = false;
    L75:
        if ((r52 & 262144) == 0) goto L77;
        Integer r19 = null;
    L79:
        if ((r52 & 524288) == 0) goto L81;
        boolean r20 = true;
    L83:
        if ((r52 & 1048576) == 0) goto L85;
        Integer r21 = null;
    L87:
        if ((r52 & 2097152) == 0) goto L89;
        Integer r22 = null;
    L91:
        if ((r52 & 4194304) == 0) goto L93;
        Integer r23 = null;
    L95:
        if ((r52 & 8388608) == 0) goto L97;
        boolean r24 = true;
    L99:
        if ((r52 & 16777216) == 0) goto L101;
        Boolean r0 = false;
    L102:
        this(r1, r3, r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r2, r10, r5, r16, r17, r18, r19, r20, r21, r22, r23, r24, r0);
        return;
    L101:
        r0 = r51;
        goto L102
    L97:
        r24 = r50;
        goto L99
    L93:
        r23 = r49;
        goto L95
    L89:
        r22 = r48;
        goto L91
    L85:
        r21 = r47;
        goto L87
    L81:
        r20 = r46;
        goto L83
    L77:
        r19 = r45;
        goto L79
    L73:
        r18 = r44;
        goto L75
    L69:
        r17 = r43;
        goto L71
    L65:
        r16 = r42;
        goto L67
    L61:
        r5 = r41;
        goto L63
    L57:
        r10 = r40;
        goto L59
    L53:
        r2 = r39;
        goto L55
    L49:
        r15 = r38;
        goto L51
    L45:
        r14 = r37;
        goto L47
    L41:
        r13 = r36;
        goto L43
    L37:
        r12 = r35;
        goto L39
    L33:
        r11 = r34;
        goto L35
    L29:
        r9 = r33;
        goto L31
    L25:
        r8 = r32;
        goto L27
    L21:
        r7 = r31;
        goto L23
    L17:
        r6 = r30;
        goto L19
    L13:
        r4 = r29;
        goto L15
    L9:
        r3 = r28;
        goto L11
    L5:
        r1 = r27;
        goto L7
    }

    public static /* synthetic */ CodeBlockConfig copy$default(CodeBlockConfig r17, Integer r18, Integer r19, boolean r20, Integer r21, int r22, Integer r23, boolean r24, String r25, boolean r26, boolean r27, TitleStyle r28, boolean r29, Integer r30, Integer r31, Integer r32, Integer r33, boolean r34, boolean r35, Integer r36, boolean r37, Integer r38, Integer r39, Integer r40, boolean r41, Boolean r42, int r43, Object r44) {
        if ((r43 & 1) == 0) goto L5;
        Integer r2 = r17.cornerRadius;
    L7:
        if ((r43 & 2) == 0) goto L9;
        Integer r3 = r17.titleBgColor;
    L11:
        if ((r43 & 4) == 0) goto L13;
        boolean r4 = r17.enableTitleBottomLine;
    L15:
        if ((r43 & 8) == 0) goto L17;
        Integer r5 = r17.titleBottomLineColor;
    L19:
        if ((r43 & 16) == 0) goto L21;
        int r6 = r17.codeTitleSize;
    L23:
        if ((r43 & 32) == 0) goto L25;
        Integer r7 = r17.codeContentSize;
    L27:
        if ((r43 & 64) == 0) goto L29;
        boolean r8 = r17.enableCodeFullScreenButton;
    L31:
        if ((r43 & 128) == 0) goto L33;
        String r9 = r17.codeCopyTitle;
    L35:
        if ((r43 & 256) == 0) goto L37;
        boolean r10 = r17.enablePreviewButton;
    L39:
        if ((r43 & 512) == 0) goto L41;
        boolean r11 = r17.enableCodeCopyButton;
    L43:
        if ((r43 & 1024) == 0) goto L45;
        TitleStyle r12 = r17.titleStyle;
    L47:
        if ((r43 & 2048) == 0) goto L49;
        boolean r13 = r17.enableCodeHeader;
    L51:
        if ((r43 & 4096) == 0) goto L53;
        Integer r14 = r17.backgroundColor;
    L55:
        if ((r43 & 8192) == 0) goto L57;
        Integer r15 = r17.blockBackgroundColor;
    L58:
        Integer r310 = r15;
        if ((r43 & 16384) == 0) goto L61;
        Integer r16 = r17.codeTextColor;
    L62:
        Integer r311 = r16;
        if ((r43 & 32768) == 0) goto L65;
        Integer r110 = r17.blockMargin;
    L66:
        Integer r312 = r110;
        if ((r43 & 65536) == 0) goto L69;
        boolean r111 = r17.enableScroll;
    L70:
        boolean r313 = r111;
        if ((r43 & 131072) == 0) goto L73;
        boolean r112 = r17.enableLineNumber;
    L74:
        boolean r314 = r112;
        if ((r43 & 262144) == 0) goto L77;
        Integer r113 = r17.lineNumberColor;
    L78:
        Integer r315 = r113;
        if ((r43 & 524288) == 0) goto L81;
        boolean r114 = r17.enableBlockBackground;
    L82:
        boolean r316 = r114;
        if ((r43 & 1048576) == 0) goto L85;
        Integer r115 = r17.codeBlockTextColor;
    L86:
        Integer r317 = r115;
        if ((r43 & 2097152) == 0) goto L89;
        Integer r116 = r17.blockBorderColor;
    L90:
        Integer r318 = r116;
        if ((r43 & 4194304) == 0) goto L93;
        Integer r117 = r17.blockBorderWidth;
    L94:
        Integer r45 = r117;
        if ((r43 & 8388608) == 0) goto L97;
        boolean r118 = r17.enableSyntaxHighlight;
    L99:
        if ((r43 & 16777216) == 0) goto L101;
        Boolean r1 = r17.disableReplacementSpan;
    L103:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r45, r118, r1);
    L101:
        r1 = r42;
        goto L103
    L97:
        r118 = r41;
        goto L99
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

    public final CodeBlockConfig copy(Integer r28, Integer r29, boolean r30, Integer r31, int r32, Integer r33, boolean r34, String r35, boolean r36, boolean r37, TitleStyle r38, boolean r39, Integer r40, Integer r41, Integer r42, Integer r43, boolean r44, boolean r45, Integer r46, boolean r47, Integer r48, Integer r49, Integer r50, boolean r51, Boolean r52) {
        Intrinsics.checkNotNullParameter(r35, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(r38, "titleStyle");
        return new CodeBlockConfig(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CodeBlockConfig.class) == true) goto L8;
        return false;
    L8:
        CodeBlockConfig r6 = (CodeBlockConfig) ZeusTransformUtils.preCheckCast(r5, CodeBlockConfig.class, "com.obric.memorydata.plugin");
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
        if (Intrinsics.areEqual(this.disableReplacementSpan, r6.disableReplacementSpan) == true) goto L83;
        return false;
    L83:
        return true;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
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
        int r13 = (((r10 + r12) * 31) + Integer.hashCode(this.codeTitleSize)) * 31;
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
        if (r62 == true) goto L78;
        r8 = r62;
    L78:
        int r63 = (r61 + r8) * 31;
        Boolean r64 = this.disableReplacementSpan;
        if (r64 == null) goto L83;
        r1 = r64.hashCode();
    L83:
        return r63 + r1;
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
        StringBuilder r0 = new StringBuilder();
        r0.append("CodeBlockConfig(cornerRadius=").append(this.cornerRadius).append(", titleBgColor=").append(this.titleBgColor).append(", enableTitleBottomLine=").append(this.enableTitleBottomLine).append(", titleBottomLineColor=").append(this.titleBottomLineColor).append(", codeTitleSize=").append(this.codeTitleSize).append(", codeContentSize=").append(this.codeContentSize).append(", enableCodeFullScreenButton=").append(this.enableCodeFullScreenButton).append(", codeCopyTitle=").append(this.codeCopyTitle).append(", enablePreviewButton=").append(this.enablePreviewButton).append(", enableCodeCopyButton=").append(this.enableCodeCopyButton).append(", titleStyle=").append(this.titleStyle).append(", enableCodeHeader=");
        r0.append(this.enableCodeHeader).append(", backgroundColor=").append(this.backgroundColor).append(", blockBackgroundColor=").append(this.blockBackgroundColor).append(", codeTextColor=").append(this.codeTextColor).append(", blockMargin=").append(this.blockMargin).append(", enableScroll=").append(this.enableScroll).append(", enableLineNumber=").append(this.enableLineNumber).append(", lineNumberColor=").append(this.lineNumberColor).append(", enableBlockBackground=").append(this.enableBlockBackground).append(", codeBlockTextColor=").append(this.codeBlockTextColor).append(", blockBorderColor=").append(this.blockBorderColor).append(", blockBorderWidth=").append(this.blockBorderWidth);
        r0.append(", enableSyntaxHighlight=").append(this.enableSyntaxHighlight).append(", disableReplacementSpan=").append(this.disableReplacementSpan).append(')');
        return r0.toString();
    }
}
