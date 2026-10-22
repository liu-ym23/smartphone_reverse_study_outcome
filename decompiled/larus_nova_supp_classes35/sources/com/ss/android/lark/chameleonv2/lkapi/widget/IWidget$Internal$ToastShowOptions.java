package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010>\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÂ\u0003JÈ\u0001\u0010G\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020\nHÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b)\u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001eR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006N"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastShowOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachedOnX", BuildConfig.FLAVOR, "content", "duration", BuildConfig.FLAVOR, "hoverBlockTimer", BuildConfig.FLAVOR, "lineClamp", BuildConfig.FLAVOR, "maxDisplayCount", "offsetY", "operations", BuildConfig.FLAVOR, "showClose", "showIcon", "typeX", "webviewId", "windowId", "wordWrap", "zOrderX", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHoverBlockTimer", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLineClamp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxDisplayCount", "getOffsetY", "getOperations", "()Ljava/util/List;", "getShowClose", "getShowIcon", "getWebviewId", "getWindowId", "getWordWrap", "attachedOn", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastAttachment;", "getAttachedOn", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastAttachment;", IPortraitService.TYPE, "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$XToastType;", "getType", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$XToastType;", "zOrder", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastZOrder;", "getZOrder", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastZOrder;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastShowOptions;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Internal$ToastShowOptions implements NonProguard {
    private final String attachedOnX;
    private final String content;
    private final Long duration;
    private final Boolean hoverBlockTimer;
    private final Integer lineClamp;
    private final Integer maxDisplayCount;
    private final Integer offsetY;
    private final List<String> operations;
    private final Boolean showClose;
    private final Boolean showIcon;
    private final String typeX;
    private final Integer webviewId;
    private final String windowId;
    private final Boolean wordWrap;
    private final String zOrderX;

    public IWidget$Internal$ToastShowOptions() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    private final String component1() {
        return this.attachedOnX;
    }

    private final String component11() {
        return this.typeX;
    }

    private final String component15() {
        return this.zOrderX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IWidget$Internal$ToastShowOptions copy$default(IWidget$Internal$ToastShowOptions r16, String r17, String r18, Long r19, Boolean r20, Integer r21, Integer r22, Integer r23, List r24, Boolean r25, Boolean r26, String r27, Integer r28, String r29, Boolean r30, String r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        String r2 = r16.attachedOnX;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = r16.content;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Long r4 = r16.duration;
    L15:
        if ((r32 & 8) == 0) goto L17;
        Boolean r5 = r16.hoverBlockTimer;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Integer r6 = r16.lineClamp;
    L23:
        if ((r32 & 32) == 0) goto L25;
        Integer r7 = r16.maxDisplayCount;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Integer r8 = r16.offsetY;
    L31:
        if ((r32 & 128) == 0) goto L33;
        List r9 = r16.operations;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Boolean r10 = r16.showClose;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Boolean r11 = r16.showIcon;
    L43:
        if ((r32 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        String r12 = r16.typeX;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Integer r13 = r16.webviewId;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        String r14 = r16.windowId;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        Boolean r15 = r16.wordWrap;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        String r1 = r16.zOrderX;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final Boolean component10() {
        return this.showIcon;
    }

    public final Integer component12() {
        return this.webviewId;
    }

    public final String component13() {
        return this.windowId;
    }

    public final Boolean component14() {
        return this.wordWrap;
    }

    public final String component2() {
        return this.content;
    }

    public final Long component3() {
        return this.duration;
    }

    public final Boolean component4() {
        return this.hoverBlockTimer;
    }

    public final Integer component5() {
        return this.lineClamp;
    }

    public final Integer component6() {
        return this.maxDisplayCount;
    }

    public final Integer component7() {
        return this.offsetY;
    }

    public final List<String> component8() {
        return this.operations;
    }

    public final Boolean component9() {
        return this.showClose;
    }

    public final IWidget$Internal$ToastShowOptions copy(@JSONField(name = "attachedOn") String r18, String r19, Long r20, Boolean r21, Integer r22, Integer r23, Integer r24, List<String> r25, Boolean r26, Boolean r27, @JSONField(name = IPortraitService.TYPE) String r28, Integer r29, String r30, Boolean r31, @JSONField(name = "zOrder") String r32) {
        return new IWidget$Internal$ToastShowOptions(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWidget$Internal$ToastShowOptions) == true) goto L8;
        return false;
    L8:
        IWidget$Internal$ToastShowOptions r6 = (IWidget$Internal$ToastShowOptions) r5;
        if (Intrinsics.areEqual(this.attachedOnX, r6.attachedOnX) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hoverBlockTimer, r6.hoverBlockTimer) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lineClamp, r6.lineClamp) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxDisplayCount, r6.maxDisplayCount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.offsetY, r6.offsetY) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.operations, r6.operations) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showClose, r6.showClose) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.showIcon, r6.showIcon) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.typeX, r6.typeX) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.webviewId, r6.webviewId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.windowId, r6.windowId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.wordWrap, r6.wordWrap) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.zOrderX, r6.zOrderX) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r0 = this.attachedOnX;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.duration;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.hoverBlockTimer;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.lineClamp;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.maxDisplayCount;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.offsetY;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        List<String> r22 = this.operations;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.showClose;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.showIcon;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.typeX;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.webviewId;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.windowId;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Boolean r40 = this.wordWrap;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.zOrderX;
        if (r43 == null) goto L63;
        r1 = r43.hashCode();
    L63:
        return r42 + r1;
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
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
        return "ToastShowOptions(attachedOnX=" + this.attachedOnX + ", content=" + this.content + ", duration=" + this.duration + ", hoverBlockTimer=" + this.hoverBlockTimer + ", lineClamp=" + this.lineClamp + ", maxDisplayCount=" + this.maxDisplayCount + ", offsetY=" + this.offsetY + ", operations=" + this.operations + ", showClose=" + this.showClose + ", showIcon=" + this.showIcon + ", typeX=" + this.typeX + ", webviewId=" + this.webviewId + ", windowId=" + this.windowId + ", wordWrap=" + this.wordWrap + ", zOrderX=" + this.zOrderX + ')';
    }

    public final IWidget$Internal$ToastAttachment getAttachedOn() {
        String r0 = this.attachedOnX;
        IWidget$Internal$ToastAttachment r1 = null;
        if (r0 == null) goto L15;
        IWidget$Internal$ToastAttachment.Companion.getClass();
        Intrinsics.checkNotNullParameter(r0, "value");
        IWidget$Internal$ToastAttachment[] r2 = IWidget$Internal$ToastAttachment.values();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        IWidget$Internal$ToastAttachment r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getValue(), r0) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        r1 = r5;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return IWidget$Internal$ToastAttachment.CURRENT_WINDOW;
    L15:
        return null;
    }

    public final IWidget$Internal$XToastType getType() {
        String r0 = this.typeX;
        IWidget$Internal$XToastType r1 = null;
        if (r0 == null) goto L15;
        IWidget$Internal$XToastType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r0, "value");
        IWidget$Internal$XToastType[] r2 = IWidget$Internal$XToastType.values();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        IWidget$Internal$XToastType r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getValue(), r0) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        r1 = r5;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return IWidget$Internal$XToastType.INFO;
    L15:
        return null;
    }

    public final IWidget$Internal$ToastZOrder getZOrder() {
        String r0 = this.zOrderX;
        IWidget$Internal$ToastZOrder r1 = null;
        if (r0 == null) goto L15;
        IWidget$Internal$ToastZOrder.Companion.getClass();
        Intrinsics.checkNotNullParameter(r0, "value");
        IWidget$Internal$ToastZOrder[] r2 = IWidget$Internal$ToastZOrder.values();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        IWidget$Internal$ToastZOrder r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getValue(), r0) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        r1 = r5;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return IWidget$Internal$ToastZOrder.DEFAULT;
    L15:
        return null;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Boolean getHoverBlockTimer() {
        return this.hoverBlockTimer;
    }

    public final Integer getLineClamp() {
        return this.lineClamp;
    }

    public final Integer getMaxDisplayCount() {
        return this.maxDisplayCount;
    }

    public final Integer getOffsetY() {
        return this.offsetY;
    }

    public final List<String> getOperations() {
        return this.operations;
    }

    public final Boolean getShowClose() {
        return this.showClose;
    }

    public final Boolean getShowIcon() {
        return this.showIcon;
    }

    public final Integer getWebviewId() {
        return this.webviewId;
    }

    public final String getWindowId() {
        return this.windowId;
    }

    public final Boolean getWordWrap() {
        return this.wordWrap;
    }

    public IWidget$Internal$ToastShowOptions(@JSONField(name = "attachedOn") String r1, String r2, Long r3, Boolean r4, Integer r5, Integer r6, Integer r7, List<String> r8, Boolean r9, Boolean r10, @JSONField(name = IPortraitService.TYPE) String r11, Integer r12, String r13, Boolean r14, @JSONField(name = "zOrder") String r15) {
        this.attachedOnX = r1;
        this.content = r2;
        this.duration = r3;
        this.hoverBlockTimer = r4;
        this.lineClamp = r5;
        this.maxDisplayCount = r6;
        this.offsetY = r7;
        this.operations = r8;
        this.showClose = r9;
        this.showIcon = r10;
        this.typeX = r11;
        this.webviewId = r12;
        this.windowId = r13;
        this.wordWrap = r14;
        this.zOrderX = r15;
    }

    public /* synthetic */ IWidget$Internal$ToastShowOptions(String r16, String r17, Long r18, Boolean r19, Integer r20, Integer r21, Integer r22, List r23, Boolean r24, Boolean r25, String r26, Integer r27, String r28, Boolean r29, String r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 1) == 0) goto L5;
        String r1 = "current-window";
    L6:
        String r3 = null;
        if ((r31 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        Long r4 = 3000L;
    L15:
        if ((r31 & 8) == 0) goto L17;
        Boolean r5 = Boolean.FALSE;
    L19:
        if ((r31 & 16) == 0) goto L21;
        Integer r6 = 2;
    L23:
        if ((r31 & 32) == 0) goto L25;
        Integer r7 = 2;
    L27:
        if ((r31 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r31 & 128) == 0) goto L33;
        List r9 = null;
    L35:
        if ((r31 & 256) == 0) goto L37;
        Boolean r10 = Boolean.FALSE;
    L39:
        if ((r31 & 512) == 0) goto L41;
        Boolean r11 = Boolean.TRUE;
    L43:
        if ((r31 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        String r12 = "info";
    L47:
        if ((r31 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r31 & 4096) != 0) goto L55;
        r3 = r28;
    L55:
        if ((r31 & 8192) == 0) goto L57;
        Boolean r14 = Boolean.TRUE;
    L59:
        if ((r31 & 16384) == 0) goto L61;
        String r0 = "default";
    L62:
        this(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r3, r14, r0);
        return;
    L61:
        r0 = r30;
        goto L62
    L57:
        r14 = r29;
        goto L59
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r2 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L6
    }
}
