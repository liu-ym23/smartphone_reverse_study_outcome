package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b>\b\u0087\b\u0018\u00002\u00020\u0001Bû\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010@\u001a\u00020\u0012HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u001aHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0084\u0002\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00032\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0005HÖ\u0001J\t\u0010W\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b#\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b7\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b8\u0010\u001fR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b;\u0010\u001f¨\u0006X"}, d2 = {"Lcom/larus/business/markdown/api/model/TableConfig;", "", "enableTableHeader", "", "tableTitleBgColor", "", "tableTextSize", "", "tableBorderWidth", "tableBorderColor", "tableTextColor", "bottomRoundCornerRadius", "topRoundCornerRadius", "tableWidth", "cellMaxWidth", "cellVerticalPadding", "cellHorizontalPadding", "tableTitle", "", "tableTitleSize", "enableCopyButton", "copyExcelStyle", "enableDownloadButton", "enableFullScreenButton", "enableTableWidthMatchParent", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "tableOddRowBackgroundColor", "tableHeaderRowBackgroundColor", "(ZILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZZZZZLcom/larus/business/markdown/api/model/TitleStyle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottomRoundCornerRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCellHorizontalPadding", "getCellMaxWidth", "getCellVerticalPadding", "getCopyExcelStyle", "()Z", "getEnableCopyButton", "getEnableDownloadButton", "getEnableFullScreenButton", "getEnableTableHeader", "getEnableTableWidthMatchParent", "getTableBorderColor", "getTableBorderWidth", "getTableHeaderRowBackgroundColor", "getTableOddRowBackgroundColor", "getTableTextColor", "getTableTextSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTableTitle", "()Ljava/lang/String;", "getTableTitleBgColor", "()I", "getTableTitleSize", "getTableWidth", "getTitleStyle", "()Lcom/larus/business/markdown/api/model/TitleStyle;", "getTopRoundCornerRadius", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZZZZZLcom/larus/business/markdown/api/model/TitleStyle;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/TableConfig;", "equals", "other", "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TableConfig {
    private final Integer bottomRoundCornerRadius;
    private final Integer cellHorizontalPadding;
    private final Integer cellMaxWidth;
    private final Integer cellVerticalPadding;
    private final boolean copyExcelStyle;
    private final boolean enableCopyButton;
    private final boolean enableDownloadButton;
    private final boolean enableFullScreenButton;
    private final boolean enableTableHeader;
    private final boolean enableTableWidthMatchParent;
    private final Integer tableBorderColor;
    private final Integer tableBorderWidth;
    private final Integer tableHeaderRowBackgroundColor;
    private final Integer tableOddRowBackgroundColor;
    private final Integer tableTextColor;
    private final Float tableTextSize;
    private final String tableTitle;
    private final int tableTitleBgColor;
    private final Integer tableTitleSize;
    private final Integer tableWidth;
    private final TitleStyle titleStyle;
    private final Integer topRoundCornerRadius;

    public TableConfig() {
        this(false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, false, null, null, null, 4194303, null);
    }

    public static /* synthetic */ TableConfig copy$default(TableConfig r17, boolean r18, int r19, Float r20, Integer r21, Integer r22, Integer r23, Integer r24, Integer r25, Integer r26, Integer r27, Integer r28, Integer r29, String r30, Integer r31, boolean r32, boolean r33, boolean r34, boolean r35, boolean r36, TitleStyle r37, Integer r38, Integer r39, int r40, Object r41) {
        if ((r40 & 1) == 0) goto L5;
        boolean r2 = r17.enableTableHeader;
    L7:
        if ((r40 & 2) == 0) goto L9;
        int r3 = r17.tableTitleBgColor;
    L11:
        if ((r40 & 4) == 0) goto L13;
        Float r4 = r17.tableTextSize;
    L15:
        if ((r40 & 8) == 0) goto L17;
        Integer r5 = r17.tableBorderWidth;
    L19:
        if ((r40 & 16) == 0) goto L21;
        Integer r6 = r17.tableBorderColor;
    L23:
        if ((r40 & 32) == 0) goto L25;
        Integer r7 = r17.tableTextColor;
    L27:
        if ((r40 & 64) == 0) goto L29;
        Integer r8 = r17.bottomRoundCornerRadius;
    L31:
        if ((r40 & 128) == 0) goto L33;
        Integer r9 = r17.topRoundCornerRadius;
    L35:
        if ((r40 & 256) == 0) goto L37;
        Integer r10 = r17.tableWidth;
    L39:
        if ((r40 & 512) == 0) goto L41;
        Integer r11 = r17.cellMaxWidth;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        Integer r12 = r17.cellVerticalPadding;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        Integer r13 = r17.cellHorizontalPadding;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        String r14 = r17.tableTitle;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        Integer r15 = r17.tableTitleSize;
    L58:
        Integer r310 = r15;
        if ((r40 & 16384) == 0) goto L61;
        boolean r16 = r17.enableCopyButton;
    L62:
        boolean r311 = r16;
        if ((r40 & 32768) == 0) goto L65;
        boolean r110 = r17.copyExcelStyle;
    L66:
        boolean r312 = r110;
        if ((r40 & 65536) == 0) goto L69;
        boolean r111 = r17.enableDownloadButton;
    L70:
        boolean r313 = r111;
        if ((r40 & 131072) == 0) goto L73;
        boolean r112 = r17.enableFullScreenButton;
    L74:
        boolean r314 = r112;
        if ((r40 & 262144) == 0) goto L77;
        boolean r113 = r17.enableTableWidthMatchParent;
    L78:
        boolean r315 = r113;
        if ((r40 & 524288) == 0) goto L81;
        TitleStyle r114 = r17.titleStyle;
    L82:
        TitleStyle r316 = r114;
        if ((r40 & 1048576) == 0) goto L85;
        Integer r115 = r17.tableOddRowBackgroundColor;
    L87:
        if ((r40 & 2097152) == 0) goto L89;
        Integer r1 = r17.tableHeaderRowBackgroundColor;
    L91:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r115, r1);
    L89:
        r1 = r39;
        goto L91
    L85:
        r115 = r38;
        goto L87
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

    public final boolean component1() {
        return this.enableTableHeader;
    }

    public final Integer component10() {
        return this.cellMaxWidth;
    }

    public final Integer component11() {
        return this.cellVerticalPadding;
    }

    public final Integer component12() {
        return this.cellHorizontalPadding;
    }

    public final String component13() {
        return this.tableTitle;
    }

    public final Integer component14() {
        return this.tableTitleSize;
    }

    public final boolean component15() {
        return this.enableCopyButton;
    }

    public final boolean component16() {
        return this.copyExcelStyle;
    }

    public final boolean component17() {
        return this.enableDownloadButton;
    }

    public final boolean component18() {
        return this.enableFullScreenButton;
    }

    public final boolean component19() {
        return this.enableTableWidthMatchParent;
    }

    public final int component2() {
        return this.tableTitleBgColor;
    }

    public final TitleStyle component20() {
        return this.titleStyle;
    }

    public final Integer component21() {
        return this.tableOddRowBackgroundColor;
    }

    public final Integer component22() {
        return this.tableHeaderRowBackgroundColor;
    }

    public final Float component3() {
        return this.tableTextSize;
    }

    public final Integer component4() {
        return this.tableBorderWidth;
    }

    public final Integer component5() {
        return this.tableBorderColor;
    }

    public final Integer component6() {
        return this.tableTextColor;
    }

    public final Integer component7() {
        return this.bottomRoundCornerRadius;
    }

    public final Integer component8() {
        return this.topRoundCornerRadius;
    }

    public final Integer component9() {
        return this.tableWidth;
    }

    public final TableConfig copy(boolean r25, int r26, Float r27, Integer r28, Integer r29, Integer r30, Integer r31, Integer r32, Integer r33, Integer r34, Integer r35, Integer r36, String r37, Integer r38, boolean r39, boolean r40, boolean r41, boolean r42, boolean r43, TitleStyle r44, Integer r45, Integer r46) {
        Intrinsics.checkNotNullParameter(r37, "tableTitle");
        Intrinsics.checkNotNullParameter(r44, "titleStyle");
        return new TableConfig(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TableConfig) == true) goto L8;
        return false;
    L8:
        TableConfig r6 = (TableConfig) r5;
        if (this.enableTableHeader == r6.enableTableHeader) goto L12;
        return false;
    L12:
        if (this.tableTitleBgColor == r6.tableTitleBgColor) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tableTextSize, r6.tableTextSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tableBorderWidth, r6.tableBorderWidth) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tableBorderColor, r6.tableBorderColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tableTextColor, r6.tableTextColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bottomRoundCornerRadius, r6.bottomRoundCornerRadius) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.topRoundCornerRadius, r6.topRoundCornerRadius) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tableWidth, r6.tableWidth) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.cellMaxWidth, r6.cellMaxWidth) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.cellVerticalPadding, r6.cellVerticalPadding) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.cellHorizontalPadding, r6.cellHorizontalPadding) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tableTitle, r6.tableTitle) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.tableTitleSize, r6.tableTitleSize) == true) goto L51;
        return false;
    L51:
        if (this.enableCopyButton == r6.enableCopyButton) goto L54;
        return false;
    L54:
        if (this.copyExcelStyle == r6.copyExcelStyle) goto L57;
        return false;
    L57:
        if (this.enableDownloadButton == r6.enableDownloadButton) goto L60;
        return false;
    L60:
        if (this.enableFullScreenButton == r6.enableFullScreenButton) goto L63;
        return false;
    L63:
        if (this.enableTableWidthMatchParent == r6.enableTableWidthMatchParent) goto L66;
        return false;
    L66:
        if (this.titleStyle == r6.titleStyle) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.tableOddRowBackgroundColor, r6.tableOddRowBackgroundColor) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.tableHeaderRowBackgroundColor, r6.tableHeaderRowBackgroundColor) == true) goto L74;
        return false;
    L74:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    public int hashCode() {
        boolean r0 = this.enableTableHeader;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((r2 * 31) + this.tableTitleBgColor) * 31;
        Float r4 = this.tableTextSize;
        int r5 = 0;
        if (r4 != null) goto L8;
        int r6 = 0;
    L9:
        int r7 = (r3 + r6) * 31;
        Integer r8 = this.tableBorderWidth;
        if (r8 != null) goto L12;
        int r9 = 0;
    L13:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.tableBorderColor;
        if (r11 != null) goto L16;
        int r12 = 0;
    L17:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.tableTextColor;
        if (r14 != null) goto L20;
        int r15 = 0;
    L21:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.bottomRoundCornerRadius;
        if (r17 != null) goto L24;
        int r18 = 0;
    L25:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.topRoundCornerRadius;
        if (r20 != null) goto L28;
        int r21 = 0;
    L29:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.tableWidth;
        if (r23 != null) goto L32;
        int r24 = 0;
    L33:
        int r25 = (r22 + r24) * 31;
        Integer r26 = this.cellMaxWidth;
        if (r26 != null) goto L36;
        int r27 = 0;
    L37:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.cellVerticalPadding;
        if (r29 != null) goto L40;
        int r30 = 0;
    L41:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.cellHorizontalPadding;
        if (r32 != null) goto L44;
        int r33 = 0;
    L45:
        int r34 = (((r31 + r33) * 31) + this.tableTitle.hashCode()) * 31;
        Integer r35 = this.tableTitleSize;
        if (r35 != null) goto L48;
        int r36 = 0;
    L49:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.enableCopyButton;
        ?? r39 = r38;
        if (r38 == false) goto L52;
        r39 = 1;
    L52:
        int r40 = (r37 + r39) * 31;
        boolean r41 = this.copyExcelStyle;
        ?? r42 = r41;
        if (r41 == false) goto L55;
        r42 = 1;
    L55:
        int r43 = (r40 + r42) * 31;
        boolean r44 = this.enableDownloadButton;
        ?? r45 = r44;
        if (r44 == false) goto L58;
        r45 = 1;
    L58:
        int r46 = (r43 + r45) * 31;
        boolean r47 = this.enableFullScreenButton;
        ?? r48 = r47;
        if (r47 == false) goto L61;
        r48 = 1;
    L61:
        int r49 = (r46 + r48) * 31;
        boolean r50 = this.enableTableWidthMatchParent;
        if (r50 == true) goto L65;
        r1 = r50;
    L65:
        int r51 = (((r49 + r1) * 31) + this.titleStyle.hashCode()) * 31;
        Integer r52 = this.tableOddRowBackgroundColor;
        if (r52 != null) goto L68;
        int r53 = 0;
    L69:
        int r54 = (r51 + r53) * 31;
        Integer r55 = this.tableHeaderRowBackgroundColor;
        if (r55 == null) goto L74;
        r5 = r55.hashCode();
    L74:
        return r54 + r5;
    L68:
        r53 = r52.hashCode();
        goto L69
    L48:
        r36 = r35.hashCode();
        goto L49
    L44:
        r33 = r32.hashCode();
        goto L45
    L40:
        r30 = r29.hashCode();
        goto L41
    L36:
        r27 = r26.hashCode();
        goto L37
    L32:
        r24 = r23.hashCode();
        goto L33
    L28:
        r21 = r20.hashCode();
        goto L29
    L24:
        r18 = r17.hashCode();
        goto L25
    L20:
        r15 = r14.hashCode();
        goto L21
    L16:
        r12 = r11.hashCode();
        goto L17
    L12:
        r9 = r8.hashCode();
        goto L13
    L8:
        r6 = r4.hashCode();
        goto L9
    }

    public String toString() {
        return "TableConfig(enableTableHeader=" + this.enableTableHeader + ", tableTitleBgColor=" + this.tableTitleBgColor + ", tableTextSize=" + this.tableTextSize + ", tableBorderWidth=" + this.tableBorderWidth + ", tableBorderColor=" + this.tableBorderColor + ", tableTextColor=" + this.tableTextColor + ", bottomRoundCornerRadius=" + this.bottomRoundCornerRadius + ", topRoundCornerRadius=" + this.topRoundCornerRadius + ", tableWidth=" + this.tableWidth + ", cellMaxWidth=" + this.cellMaxWidth + ", cellVerticalPadding=" + this.cellVerticalPadding + ", cellHorizontalPadding=" + this.cellHorizontalPadding + ", tableTitle=" + this.tableTitle + ", tableTitleSize=" + this.tableTitleSize + ", enableCopyButton=" + this.enableCopyButton + ", copyExcelStyle=" + this.copyExcelStyle + ", enableDownloadButton=" + this.enableDownloadButton + ", enableFullScreenButton=" + this.enableFullScreenButton + ", enableTableWidthMatchParent=" + this.enableTableWidthMatchParent + ", titleStyle=" + this.titleStyle + ", tableOddRowBackgroundColor=" + this.tableOddRowBackgroundColor + ", tableHeaderRowBackgroundColor=" + this.tableHeaderRowBackgroundColor + ')';
    }

    public final Integer getBottomRoundCornerRadius() {
        return this.bottomRoundCornerRadius;
    }

    public final Integer getCellHorizontalPadding() {
        return this.cellHorizontalPadding;
    }

    public final Integer getCellMaxWidth() {
        return this.cellMaxWidth;
    }

    public final Integer getCellVerticalPadding() {
        return this.cellVerticalPadding;
    }

    public final boolean getCopyExcelStyle() {
        return this.copyExcelStyle;
    }

    public final boolean getEnableCopyButton() {
        return this.enableCopyButton;
    }

    public final boolean getEnableDownloadButton() {
        return this.enableDownloadButton;
    }

    public final boolean getEnableFullScreenButton() {
        return this.enableFullScreenButton;
    }

    public final boolean getEnableTableHeader() {
        return this.enableTableHeader;
    }

    public final boolean getEnableTableWidthMatchParent() {
        return this.enableTableWidthMatchParent;
    }

    public final Integer getTableBorderColor() {
        return this.tableBorderColor;
    }

    public final Integer getTableBorderWidth() {
        return this.tableBorderWidth;
    }

    public final Integer getTableHeaderRowBackgroundColor() {
        return this.tableHeaderRowBackgroundColor;
    }

    public final Integer getTableOddRowBackgroundColor() {
        return this.tableOddRowBackgroundColor;
    }

    public final Integer getTableTextColor() {
        return this.tableTextColor;
    }

    public final Float getTableTextSize() {
        return this.tableTextSize;
    }

    public final String getTableTitle() {
        return this.tableTitle;
    }

    public final int getTableTitleBgColor() {
        return this.tableTitleBgColor;
    }

    public final Integer getTableTitleSize() {
        return this.tableTitleSize;
    }

    public final Integer getTableWidth() {
        return this.tableWidth;
    }

    public final TitleStyle getTitleStyle() {
        return this.titleStyle;
    }

    public final Integer getTopRoundCornerRadius() {
        return this.topRoundCornerRadius;
    }

    public TableConfig(boolean r5, int r6, Float r7, Integer r8, Integer r9, Integer r10, Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, String r17, Integer r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, TitleStyle r24, Integer r25, Integer r26) {
        Intrinsics.checkNotNullParameter(r17, "tableTitle");
        Intrinsics.checkNotNullParameter(r24, "titleStyle");
        this.enableTableHeader = r5;
        this.tableTitleBgColor = r6;
        this.tableTextSize = r7;
        this.tableBorderWidth = r8;
        this.tableBorderColor = r9;
        this.tableTextColor = r10;
        this.bottomRoundCornerRadius = r11;
        this.topRoundCornerRadius = r12;
        this.tableWidth = r13;
        this.cellMaxWidth = r14;
        this.cellVerticalPadding = r15;
        this.cellHorizontalPadding = r16;
        this.tableTitle = r17;
        this.tableTitleSize = r18;
        this.enableCopyButton = r19;
        this.copyExcelStyle = r20;
        this.enableDownloadButton = r21;
        this.enableFullScreenButton = r22;
        this.enableTableWidthMatchParent = r23;
        this.titleStyle = r24;
        this.tableOddRowBackgroundColor = r25;
        this.tableHeaderRowBackgroundColor = r26;
    }

    public /* synthetic */ TableConfig(boolean r24, int r25, Float r26, Integer r27, Integer r28, Integer r29, Integer r30, Integer r31, Integer r32, Integer r33, Integer r34, Integer r35, String r36, Integer r37, boolean r38, boolean r39, boolean r40, boolean r41, boolean r42, TitleStyle r43, Integer r44, Integer r45, int r46, DefaultConstructorMarker r47) {
        if ((r46 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r46 & 2) == 0) goto L9;
        int r3 = -7829368;
    L11:
        if ((r46 & 4) == 0) goto L13;
        Float r4 = null;
    L15:
        if ((r46 & 8) == 0) goto L17;
        Integer r6 = null;
    L19:
        if ((r46 & 16) == 0) goto L21;
        Integer r7 = null;
    L23:
        if ((r46 & 32) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r46 & 64) == 0) goto L29;
        Integer r9 = null;
    L31:
        if ((r46 & 128) == 0) goto L33;
        Integer r10 = null;
    L35:
        if ((r46 & 256) == 0) goto L37;
        Integer r11 = null;
    L39:
        if ((r46 & 512) == 0) goto L41;
        Integer r12 = null;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        Integer r13 = null;
    L47:
        if ((r46 & 2048) == 0) goto L49;
        Integer r14 = null;
    L51:
        if ((r46 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r46 & 8192) == 0) goto L57;
        Integer r2 = null;
    L59:
        if ((r46 & 16384) == 0) goto L61;
        boolean r5 = false;
    L63:
        if ((r46 & 32768) == 0) goto L65;
        boolean r16 = false;
    L66:
        boolean r18 = true;
        if ((r46 & 65536) == 0) goto L69;
        boolean r17 = true;
    L71:
        if ((r46 & 131072) == 0) goto L73;
        boolean r19 = false;
    L75:
        if ((r46 & 262144) != 0) goto L79;
        r18 = r42;
    L79:
        if ((r46 & 524288) == 0) goto L81;
        TitleStyle r20 = TitleStyle.LARGE;
    L83:
        if ((r46 & 1048576) == 0) goto L85;
        Integer r21 = null;
    L87:
        if ((r46 & 2097152) == 0) goto L89;
        Integer r0 = null;
    L90:
        this(r1, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r5, r16, r17, r19, r18, r20, r21, r0);
        return;
    L89:
        r0 = r45;
        goto L90
    L85:
        r21 = r44;
        goto L87
    L81:
        r20 = r43;
        goto L83
    L73:
        r19 = r41;
        goto L75
    L69:
        r17 = r40;
        goto L71
    L65:
        r16 = r39;
        goto L66
    L61:
        r5 = r38;
        goto L63
    L57:
        r2 = r37;
        goto L59
    L53:
        r15 = r36;
        goto L55
    L49:
        r14 = r35;
        goto L51
    L45:
        r13 = r34;
        goto L47
    L41:
        r12 = r33;
        goto L43
    L37:
        r11 = r32;
        goto L39
    L33:
        r10 = r31;
        goto L35
    L29:
        r9 = r30;
        goto L31
    L25:
        r8 = r29;
        goto L27
    L21:
        r7 = r28;
        goto L23
    L17:
        r6 = r27;
        goto L19
    L13:
        r4 = r26;
        goto L15
    L9:
        r3 = r25;
        goto L11
    L5:
        r1 = r24;
        goto L7
    }
}
