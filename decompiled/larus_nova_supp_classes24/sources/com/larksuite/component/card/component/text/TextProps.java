package com.larksuite.component.card.component.text;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bE\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010?\u001a\u00020\u0017J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010P\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010R\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010S\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010T\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010U\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00108J\u009c\u0002\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00172\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0007HÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010%R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b+\u0010%R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b0\u0010%R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b1\u0010%R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b2\u0010%R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010&\u001a\u0004\b3\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b;\u00108R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b<\u00108R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b=\u00108R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b\u001c\u00108R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00109\u001a\u0004\b>\u00108¨\u0006\\"}, d2 = {"Lcom/larksuite/component/card/component/text/TextProps;", "", "id", "", "parentId", "textColor", "textSize", "", "bgColor", "maxLines", "textLines", "lineSpacing", "", "align", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "ellipsize", "contentProps", "", "Lcom/larksuite/component/card/component/text/ContentProps;", "atClickable", "", "linkClickable", "disableAtStyle", "disableTagStyle", "disableNumberTagStyle", "isTranslateElement", "inTable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getParentId", "getTextColor", "getTextSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgColor", "getMaxLines$annotations", "()V", "getMaxLines", "getTextLines", "getLineSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getAlign", "getPaddingLeft", "getPaddingRight", "getPaddingTop", "getPaddingBottom", "getEllipsize", "getContentProps", "()Ljava/util/List;", "getAtClickable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLinkClickable", "getDisableAtStyle", "getDisableTagStyle", "getDisableNumberTagStyle", "getInTable", "isTranslate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larksuite/component/card/component/text/TextProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TextProps {
    private final String align;
    private final Boolean atClickable;
    private final String bgColor;
    private final List<ContentProps> contentProps;
    private final Boolean disableAtStyle;
    private final Boolean disableNumberTagStyle;
    private final Boolean disableTagStyle;
    private final String ellipsize;
    private final String id;
    private final Boolean inTable;
    private final Boolean isTranslateElement;
    private final Float lineSpacing;
    private final Boolean linkClickable;
    private final Integer maxLines;
    private final Integer paddingBottom;
    private final Integer paddingLeft;
    private final Integer paddingRight;
    private final Integer paddingTop;
    private final String parentId;
    private final String textColor;
    private final Integer textLines;
    private final Integer textSize;

    public TextProps() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextProps copy$default(TextProps r17, String r19, String r110, String r20, Integer r21, String r22, Integer r23, Integer r24, Float r25, String r26, Integer r27, Integer r29, Integer r210, Integer r30, String r31, List r32, Boolean r33, Boolean r34, Boolean r35, Boolean r36, Boolean r37, Boolean r38, Boolean r39, int r40, Object r41) {
        if ((r40 & 1) == 0) goto L5;
        String r2 = r17.id;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r3 = r17.parentId;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r4 = r17.textColor;
    L15:
        if ((r40 & 8) == 0) goto L17;
        Integer r5 = r17.textSize;
    L19:
        if ((r40 & 16) == 0) goto L21;
        String r6 = r17.bgColor;
    L23:
        if ((r40 & 32) == 0) goto L25;
        Integer r7 = r17.maxLines;
    L27:
        if ((r40 & 64) == 0) goto L29;
        Integer r8 = r17.textLines;
    L31:
        if ((r40 & 128) == 0) goto L33;
        Float r9 = r17.lineSpacing;
    L35:
        if ((r40 & 256) == 0) goto L37;
        String r10 = r17.align;
    L39:
        if ((r40 & 512) == 0) goto L41;
        Integer r11 = r17.paddingLeft;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        Integer r12 = r17.paddingRight;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        Integer r13 = r17.paddingTop;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        Integer r14 = r17.paddingBottom;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        String r15 = r17.ellipsize;
    L58:
        String r310 = r15;
        if ((r40 & 16384) == 0) goto L61;
        List r16 = r17.contentProps;
    L62:
        List r311 = r16;
        if ((r40 & 32768) == 0) goto L65;
        Boolean r111 = r17.atClickable;
    L66:
        Boolean r312 = r111;
        if ((r40 & 65536) == 0) goto L69;
        Boolean r112 = r17.linkClickable;
    L70:
        Boolean r313 = r112;
        if ((r40 & 131072) == 0) goto L73;
        Boolean r113 = r17.disableAtStyle;
    L74:
        Boolean r314 = r113;
        if ((r40 & 262144) == 0) goto L77;
        Boolean r114 = r17.disableTagStyle;
    L78:
        Boolean r315 = r114;
        if ((r40 & 524288) == 0) goto L81;
        Boolean r115 = r17.disableNumberTagStyle;
    L82:
        Boolean r316 = r115;
        if ((r40 & 1048576) == 0) goto L85;
        Boolean r116 = r17.isTranslateElement;
    L87:
        if ((r40 & 2097152) == 0) goto L89;
        Boolean r1 = r17.inTable;
    L91:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r116, r1);
    L89:
        r1 = r39;
        goto L91
    L85:
        r116 = r38;
        goto L87
    L81:
        r115 = r37;
        goto L82
    L77:
        r114 = r36;
        goto L78
    L73:
        r113 = r35;
        goto L74
    L69:
        r112 = r34;
        goto L70
    L65:
        r111 = r33;
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
        r13 = r210;
        goto L51
    L45:
        r12 = r29;
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
        r3 = r110;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }

    @Deprecated(message = "only for lk_md")
    public static /* synthetic */ void getMaxLines$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final Integer component10() {
        return this.paddingLeft;
    }

    public final Integer component11() {
        return this.paddingRight;
    }

    public final Integer component12() {
        return this.paddingTop;
    }

    public final Integer component13() {
        return this.paddingBottom;
    }

    public final String component14() {
        return this.ellipsize;
    }

    public final List<ContentProps> component15() {
        return this.contentProps;
    }

    public final Boolean component16() {
        return this.atClickable;
    }

    public final Boolean component17() {
        return this.linkClickable;
    }

    public final Boolean component18() {
        return this.disableAtStyle;
    }

    public final Boolean component19() {
        return this.disableTagStyle;
    }

    public final String component2() {
        return this.parentId;
    }

    public final Boolean component20() {
        return this.disableNumberTagStyle;
    }

    public final Boolean component21() {
        return this.isTranslateElement;
    }

    public final Boolean component22() {
        return this.inTable;
    }

    public final String component3() {
        return this.textColor;
    }

    public final Integer component4() {
        return this.textSize;
    }

    public final String component5() {
        return this.bgColor;
    }

    public final Integer component6() {
        return this.maxLines;
    }

    public final Integer component7() {
        return this.textLines;
    }

    public final Float component8() {
        return this.lineSpacing;
    }

    public final String component9() {
        return this.align;
    }

    public final TextProps copy(String r25, String r26, String r27, Integer r29, String r210, Integer r30, Integer r31, Float r32, String r33, Integer r34, Integer r35, Integer r36, Integer r37, String r38, List<ContentProps> r39, Boolean r40, Boolean r41, Boolean r42, Boolean r43, Boolean r44, Boolean r45, Boolean r46) {
        return new TextProps(r25, r26, r27, r29, r210, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextProps) == true) goto L8;
        return false;
    L8:
        TextProps r6 = (TextProps) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentId, r6.parentId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textSize, r6.textSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgColor, r6.bgColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxLines, r6.maxLines) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.textLines, r6.textLines) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lineSpacing, r6.lineSpacing) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.align, r6.align) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.paddingLeft, r6.paddingLeft) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.paddingRight, r6.paddingRight) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.paddingTop, r6.paddingTop) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.paddingBottom, r6.paddingBottom) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ellipsize, r6.ellipsize) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.contentProps, r6.contentProps) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.atClickable, r6.atClickable) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.linkClickable, r6.linkClickable) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.disableAtStyle, r6.disableAtStyle) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.disableTagStyle, r6.disableTagStyle) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.disableNumberTagStyle, r6.disableNumberTagStyle) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.isTranslateElement, r6.isTranslateElement) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.inTable, r6.inTable) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.parentId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.textColor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.textSize;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.bgColor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.maxLines;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r19 = (r15 + r17) * 31;
        Integer r20 = this.textLines;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Float r23 = this.lineSpacing;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.align;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r29 = (r25 + r27) * 31;
        Integer r30 = this.paddingLeft;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        Integer r33 = this.paddingRight;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        Integer r36 = this.paddingTop;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        Integer r39 = this.paddingBottom;
        if (r39 != null) goto L53;
        int r40 = 0;
    L54:
        int r41 = (r38 + r40) * 31;
        String r42 = this.ellipsize;
        if (r42 != null) goto L57;
        int r43 = 0;
    L58:
        int r44 = (r41 + r43) * 31;
        List<ContentProps> r45 = this.contentProps;
        if (r45 != null) goto L61;
        int r46 = 0;
    L62:
        int r47 = (r44 + r46) * 31;
        Boolean r48 = this.atClickable;
        if (r48 != null) goto L65;
        int r49 = 0;
    L66:
        int r50 = (r47 + r49) * 31;
        Boolean r51 = this.linkClickable;
        if (r51 != null) goto L69;
        int r52 = 0;
    L70:
        int r53 = (r50 + r52) * 31;
        Boolean r54 = this.disableAtStyle;
        if (r54 != null) goto L73;
        int r55 = 0;
    L74:
        int r56 = (r53 + r55) * 31;
        Boolean r57 = this.disableTagStyle;
        if (r57 != null) goto L77;
        int r59 = 0;
    L78:
        int r60 = (r56 + r59) * 31;
        Boolean r61 = this.disableNumberTagStyle;
        if (r61 != null) goto L81;
        int r62 = 0;
    L82:
        int r63 = (r60 + r62) * 31;
        Boolean r64 = this.isTranslateElement;
        if (r64 != null) goto L85;
        int r65 = 0;
    L86:
        int r66 = (r63 + r65) * 31;
        Boolean r67 = this.inTable;
        if (r67 == null) goto L91;
        r1 = r67.hashCode();
    L91:
        return r66 + r1;
    L85:
        r65 = r64.hashCode();
        goto L86
    L81:
        r62 = r61.hashCode();
        goto L82
    L77:
        r59 = r57.hashCode();
        goto L78
    L73:
        r55 = r54.hashCode();
        goto L74
    L69:
        r52 = r51.hashCode();
        goto L70
    L65:
        r49 = r48.hashCode();
        goto L66
    L61:
        r46 = r45.hashCode();
        goto L62
    L57:
        r43 = r42.hashCode();
        goto L58
    L53:
        r40 = r39.hashCode();
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TextProps(id=" + this.id + ", parentId=" + this.parentId + ", textColor=" + this.textColor + ", textSize=" + this.textSize + ", bgColor=" + this.bgColor + ", maxLines=" + this.maxLines + ", textLines=" + this.textLines + ", lineSpacing=" + this.lineSpacing + ", align=" + this.align + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", paddingTop=" + this.paddingTop + ", paddingBottom=" + this.paddingBottom + ", ellipsize=" + this.ellipsize + ", contentProps=" + this.contentProps + ", atClickable=" + this.atClickable + ", linkClickable=" + this.linkClickable + ", disableAtStyle=" + this.disableAtStyle + ", disableTagStyle=" + this.disableTagStyle + ", disableNumberTagStyle=" + this.disableNumberTagStyle + ", isTranslateElement=" + this.isTranslateElement + ", inTable=" + this.inTable + ')';
    }

    public final boolean isTranslate() {
        Boolean r0 = this.isTranslateElement;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final String getAlign() {
        return this.align;
    }

    public final Boolean getAtClickable() {
        return this.atClickable;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final List<ContentProps> getContentProps() {
        return this.contentProps;
    }

    public final Boolean getDisableAtStyle() {
        return this.disableAtStyle;
    }

    public final Boolean getDisableNumberTagStyle() {
        return this.disableNumberTagStyle;
    }

    public final Boolean getDisableTagStyle() {
        return this.disableTagStyle;
    }

    public final String getEllipsize() {
        return this.ellipsize;
    }

    public final String getId() {
        return this.id;
    }

    public final Boolean getInTable() {
        return this.inTable;
    }

    public final Float getLineSpacing() {
        return this.lineSpacing;
    }

    public final Boolean getLinkClickable() {
        return this.linkClickable;
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final Integer getPaddingBottom() {
        return this.paddingBottom;
    }

    public final Integer getPaddingLeft() {
        return this.paddingLeft;
    }

    public final Integer getPaddingRight() {
        return this.paddingRight;
    }

    public final Integer getPaddingTop() {
        return this.paddingTop;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Integer getTextLines() {
        return this.textLines;
    }

    public final Integer getTextSize() {
        return this.textSize;
    }

    public final Boolean isTranslateElement() {
        return this.isTranslateElement;
    }

    public TextProps(String r3, String r4, String r5, Integer r6, String r7, Integer r8, Integer r9, Float r10, String r11, Integer r12, Integer r13, Integer r14, Integer r15, String r16, List<ContentProps> r17, Boolean r19, Boolean r110, Boolean r20, Boolean r21, Boolean r22, Boolean r23, Boolean r24) {
        this.id = r3;
        this.parentId = r4;
        this.textColor = r5;
        this.textSize = r6;
        this.bgColor = r7;
        this.maxLines = r8;
        this.textLines = r9;
        this.lineSpacing = r10;
        this.align = r11;
        this.paddingLeft = r12;
        this.paddingRight = r13;
        this.paddingTop = r14;
        this.paddingBottom = r15;
        this.ellipsize = r16;
        this.contentProps = r17;
        this.atClickable = r19;
        this.linkClickable = r110;
        this.disableAtStyle = r20;
        this.disableTagStyle = r21;
        this.disableNumberTagStyle = r22;
        this.isTranslateElement = r23;
        this.inTable = r24;
    }

    public /* synthetic */ TextProps(String r24, String r25, String r26, Integer r27, String r29, Integer r210, Integer r30, Float r31, String r32, Integer r33, Integer r34, Integer r35, Integer r36, String r37, List r38, Boolean r39, Boolean r40, Boolean r41, Boolean r42, Boolean r43, Boolean r44, Boolean r45, int r46, DefaultConstructorMarker r47) {
        if ((r46 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r46 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r46 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r46 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r46 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r46 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r46 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r46 & 128) == 0) goto L33;
        Float r9 = null;
    L35:
        if ((r46 & 256) == 0) goto L37;
        String r10 = "left";
    L39:
        if ((r46 & 512) == 0) goto L41;
        Integer r11 = 0;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        Integer r13 = 0;
    L47:
        if ((r46 & 2048) == 0) goto L49;
        Integer r14 = 0;
    L51:
        if ((r46 & 4096) == 0) goto L53;
        Integer r12 = 0;
    L55:
        if ((r46 & 8192) == 0) goto L57;
        String r15 = "end";
    L59:
        if ((r46 & 16384) == 0) goto L61;
        List r2 = null;
    L63:
        if ((r46 & 32768) == 0) goto L65;
        Boolean r16 = Boolean.TRUE;
    L67:
        if ((r46 & 65536) == 0) goto L69;
        Boolean r17 = Boolean.TRUE;
    L71:
        if ((r46 & 131072) == 0) goto L73;
        Boolean r19 = Boolean.FALSE;
    L75:
        if ((r46 & 262144) == 0) goto L77;
        Boolean r110 = Boolean.FALSE;
    L79:
        if ((r46 & 524288) == 0) goto L81;
        Boolean r20 = Boolean.FALSE;
    L83:
        if ((r46 & 1048576) == 0) goto L85;
        Boolean r21 = Boolean.FALSE;
    L87:
        if ((r46 & 2097152) == 0) goto L89;
        Boolean r0 = Boolean.FALSE;
    L90:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r12, r15, r2, r16, r17, r19, r110, r20, r21, r0);
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
    L77:
        r110 = r42;
        goto L79
    L73:
        r19 = r41;
        goto L75
    L69:
        r17 = r40;
        goto L71
    L65:
        r16 = r39;
        goto L67
    L61:
        r2 = r38;
        goto L63
    L57:
        r15 = r37;
        goto L59
    L53:
        r12 = r36;
        goto L55
    L49:
        r14 = r35;
        goto L51
    L45:
        r13 = r34;
        goto L47
    L41:
        r11 = r33;
        goto L43
    L37:
        r10 = r32;
        goto L39
    L33:
        r9 = r31;
        goto L35
    L29:
        r8 = r30;
        goto L31
    L25:
        r7 = r210;
        goto L27
    L21:
        r6 = r29;
        goto L23
    L17:
        r5 = r27;
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
