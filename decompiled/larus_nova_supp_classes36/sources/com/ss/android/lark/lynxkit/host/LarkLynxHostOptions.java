package com.ss.android.lark.lynxkit.host;

import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b2\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010=\u001a\u00020\u0011HÆ\u0003J\t\u0010>\u001a\u00020\u0013HÆ\u0003J\t\u0010?\u001a\u00020\u0013HÆ\u0003J\t\u0010@\u001a\u00020\u0013HÆ\u0003J\t\u0010A\u001a\u00020\u0017HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J«\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0013HÆ\u0001J\u0013\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0013HÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.¨\u0006K"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxHostOptions;", "", "renderOnCreateView", "", "lynxViewClient", "Lcom/lynx/tasm/LynxViewClient;", "imageInterceptor", "Lcom/lynx/tasm/behavior/ImageInterceptor;", "templateLoadListener", "Lcom/ss/android/lark/lynxkit/container/ITemplateLoadListener;", "lifecycleCallback", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostLifecycleCallback;", "closeCallback", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostCloseCallback;", "backPressedHandler", "Lcom/ss/android/lark/lynxkit/host/LarkLynxBackPressedHandler;", "pageSystemBarOptions", "Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;", "dialogWidth", "", "dialogHeight", "dialogGravity", "dialogDimAmount", "", "dialogCancelable", "dialogCanceledOnTouchOutside", "softInputMode", "<init>", "(ZLcom/lynx/tasm/LynxViewClient;Lcom/lynx/tasm/behavior/ImageInterceptor;Lcom/ss/android/lark/lynxkit/container/ITemplateLoadListener;Lcom/ss/android/lark/lynxkit/host/LarkLynxHostLifecycleCallback;Lcom/ss/android/lark/lynxkit/host/LarkLynxHostCloseCallback;Lcom/ss/android/lark/lynxkit/host/LarkLynxBackPressedHandler;Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;IIIFZZI)V", "getRenderOnCreateView", "()Z", "getLynxViewClient", "()Lcom/lynx/tasm/LynxViewClient;", "getImageInterceptor", "()Lcom/lynx/tasm/behavior/ImageInterceptor;", "getTemplateLoadListener", "()Lcom/ss/android/lark/lynxkit/container/ITemplateLoadListener;", "getLifecycleCallback", "()Lcom/ss/android/lark/lynxkit/host/LarkLynxHostLifecycleCallback;", "getCloseCallback", "()Lcom/ss/android/lark/lynxkit/host/LarkLynxHostCloseCallback;", "getBackPressedHandler", "()Lcom/ss/android/lark/lynxkit/host/LarkLynxBackPressedHandler;", "getPageSystemBarOptions", "()Lcom/ss/android/lark/lynxkit/host/LarkLynxSystemBarOptions;", "getDialogWidth", "()I", "getDialogHeight", "getDialogGravity", "getDialogDimAmount", "()F", "getDialogCancelable", "getDialogCanceledOnTouchOutside", "getSoftInputMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxHostOptions {
    private final LarkLynxBackPressedHandler backPressedHandler;
    private final LarkLynxHostCloseCallback closeCallback;
    private final boolean dialogCancelable;
    private final boolean dialogCanceledOnTouchOutside;
    private final float dialogDimAmount;
    private final int dialogGravity;
    private final int dialogHeight;
    private final int dialogWidth;
    private final m imageInterceptor;
    private final LarkLynxHostLifecycleCallback lifecycleCallback;
    private final q1 lynxViewClient;
    private final LarkLynxSystemBarOptions pageSystemBarOptions;
    private final boolean renderOnCreateView;
    private final int softInputMode;
    private final sqb.a templateLoadListener;

    public LarkLynxHostOptions() {
        this(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    }

    public static /* synthetic */ LarkLynxHostOptions copy$default(LarkLynxHostOptions r16, boolean r17, q1 r18, m r19, sqb.a r20, LarkLynxHostLifecycleCallback r21, LarkLynxHostCloseCallback r22, LarkLynxBackPressedHandler r23, LarkLynxSystemBarOptions r24, int r25, int r26, int r27, float r28, boolean r29, boolean r30, int r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        boolean r2 = r16.renderOnCreateView;
    L7:
        if ((r32 & 2) == 0) goto L9;
        q1 r3 = r16.lynxViewClient;
    L11:
        if ((r32 & 4) == 0) goto L13;
        m r4 = r16.imageInterceptor;
    L15:
        if ((r32 & 8) == 0) goto L17;
        sqb.a r5 = r16.templateLoadListener;
    L19:
        if ((r32 & 16) == 0) goto L21;
        LarkLynxHostLifecycleCallback r6 = r16.lifecycleCallback;
    L23:
        if ((r32 & 32) == 0) goto L25;
        LarkLynxHostCloseCallback r7 = r16.closeCallback;
    L27:
        if ((r32 & 64) == 0) goto L29;
        LarkLynxBackPressedHandler r8 = r16.backPressedHandler;
    L31:
        if ((r32 & 128) == 0) goto L33;
        LarkLynxSystemBarOptions r9 = r16.pageSystemBarOptions;
    L35:
        if ((r32 & 256) == 0) goto L37;
        int r10 = r16.dialogWidth;
    L39:
        if ((r32 & 512) == 0) goto L41;
        int r11 = r16.dialogHeight;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        int r12 = r16.dialogGravity;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        float r13 = r16.dialogDimAmount;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        boolean r14 = r16.dialogCancelable;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        boolean r15 = r16.dialogCanceledOnTouchOutside;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        int r1 = r16.softInputMode;
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

    public final boolean component1() {
        return this.renderOnCreateView;
    }

    public final int component10() {
        return this.dialogHeight;
    }

    public final int component11() {
        return this.dialogGravity;
    }

    public final float component12() {
        return this.dialogDimAmount;
    }

    public final boolean component13() {
        return this.dialogCancelable;
    }

    public final boolean component14() {
        return this.dialogCanceledOnTouchOutside;
    }

    public final int component15() {
        return this.softInputMode;
    }

    public final q1 component2() {
        return this.lynxViewClient;
    }

    public final m component3() {
        return this.imageInterceptor;
    }

    public final sqb.a component4() {
        return this.templateLoadListener;
    }

    public final LarkLynxHostLifecycleCallback component5() {
        return this.lifecycleCallback;
    }

    public final LarkLynxHostCloseCallback component6() {
        return this.closeCallback;
    }

    public final LarkLynxBackPressedHandler component7() {
        return this.backPressedHandler;
    }

    public final LarkLynxSystemBarOptions component8() {
        return this.pageSystemBarOptions;
    }

    public final int component9() {
        return this.dialogWidth;
    }

    public final LarkLynxHostOptions copy(boolean r18, q1 r19, m r20, sqb.a r21, LarkLynxHostLifecycleCallback r22, LarkLynxHostCloseCallback r23, LarkLynxBackPressedHandler r24, LarkLynxSystemBarOptions r25, int r26, int r27, int r28, float r29, boolean r30, boolean r31, int r32) {
        Intrinsics.checkNotNullParameter(r25, "pageSystemBarOptions");
        return new LarkLynxHostOptions(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkLynxHostOptions) == true) goto L8;
        return false;
    L8:
        LarkLynxHostOptions r6 = (LarkLynxHostOptions) r5;
        if (this.renderOnCreateView == r6.renderOnCreateView) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxViewClient, r6.lynxViewClient) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageInterceptor, r6.imageInterceptor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateLoadListener, r6.templateLoadListener) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lifecycleCallback, r6.lifecycleCallback) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.closeCallback, r6.closeCallback) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backPressedHandler, r6.backPressedHandler) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pageSystemBarOptions, r6.pageSystemBarOptions) == true) goto L33;
        return false;
    L33:
        if (this.dialogWidth == r6.dialogWidth) goto L36;
        return false;
    L36:
        if (this.dialogHeight == r6.dialogHeight) goto L39;
        return false;
    L39:
        if (this.dialogGravity == r6.dialogGravity) goto L42;
        return false;
    L42:
        if (Float.compare(this.dialogDimAmount, r6.dialogDimAmount) == 0) goto L45;
        return false;
    L45:
        if (this.dialogCancelable == r6.dialogCancelable) goto L48;
        return false;
    L48:
        if (this.dialogCanceledOnTouchOutside == r6.dialogCanceledOnTouchOutside) goto L51;
        return false;
    L51:
        if (this.softInputMode == r6.softInputMode) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.renderOnCreateView == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        q1 r3 = this.lynxViewClient;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        m r7 = this.imageInterceptor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        sqb.a r10 = this.templateLoadListener;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        LarkLynxHostLifecycleCallback r13 = this.lifecycleCallback;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        LarkLynxHostCloseCallback r16 = this.closeCallback;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        LarkLynxBackPressedHandler r19 = this.backPressedHandler;
        if (r19 == null) goto L30;
        r4 = r19.hashCode();
    L30:
        int r20 = (((((((((((r18 + r4) * 31) + this.pageSystemBarOptions.hashCode()) * 31) + this.dialogWidth) * 31) + this.dialogHeight) * 31) + this.dialogGravity) * 31) + Float.floatToIntBits(this.dialogDimAmount)) * 31;
        if (this.dialogCancelable == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        if (this.dialogCanceledOnTouchOutside == true) goto L39;
        r1 = 1237;
    L39:
        return ((r22 + r1) * 31) + this.softInputMode;
    L33:
        r21 = 1237;
        goto L34
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
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "LarkLynxHostOptions(renderOnCreateView=" + this.renderOnCreateView + ", lynxViewClient=" + this.lynxViewClient + ", imageInterceptor=" + this.imageInterceptor + ", templateLoadListener=" + this.templateLoadListener + ", lifecycleCallback=" + this.lifecycleCallback + ", closeCallback=" + this.closeCallback + ", backPressedHandler=" + this.backPressedHandler + ", pageSystemBarOptions=" + this.pageSystemBarOptions + ", dialogWidth=" + this.dialogWidth + ", dialogHeight=" + this.dialogHeight + ", dialogGravity=" + this.dialogGravity + ", dialogDimAmount=" + this.dialogDimAmount + ", dialogCancelable=" + this.dialogCancelable + ", dialogCanceledOnTouchOutside=" + this.dialogCanceledOnTouchOutside + ", softInputMode=" + this.softInputMode + ')';
    }

    public final LarkLynxBackPressedHandler getBackPressedHandler() {
        return this.backPressedHandler;
    }

    public final LarkLynxHostCloseCallback getCloseCallback() {
        return this.closeCallback;
    }

    public final boolean getDialogCancelable() {
        return this.dialogCancelable;
    }

    public final boolean getDialogCanceledOnTouchOutside() {
        return this.dialogCanceledOnTouchOutside;
    }

    public final float getDialogDimAmount() {
        return this.dialogDimAmount;
    }

    public final int getDialogGravity() {
        return this.dialogGravity;
    }

    public final int getDialogHeight() {
        return this.dialogHeight;
    }

    public final int getDialogWidth() {
        return this.dialogWidth;
    }

    public final m getImageInterceptor() {
        return this.imageInterceptor;
    }

    public final LarkLynxHostLifecycleCallback getLifecycleCallback() {
        return this.lifecycleCallback;
    }

    public final q1 getLynxViewClient() {
        return this.lynxViewClient;
    }

    public final LarkLynxSystemBarOptions getPageSystemBarOptions() {
        return this.pageSystemBarOptions;
    }

    public final boolean getRenderOnCreateView() {
        return this.renderOnCreateView;
    }

    public final int getSoftInputMode() {
        return this.softInputMode;
    }

    public final sqb.a getTemplateLoadListener() {
        return this.templateLoadListener;
    }

    public LarkLynxHostOptions(boolean r4, q1 r5, m r6, sqb.a r7, LarkLynxHostLifecycleCallback r8, LarkLynxHostCloseCallback r9, LarkLynxBackPressedHandler r10, LarkLynxSystemBarOptions r11, int r12, int r13, int r14, float r15, boolean r16, boolean r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, "pageSystemBarOptions");
        this.renderOnCreateView = r4;
        this.lynxViewClient = r5;
        this.imageInterceptor = r6;
        this.templateLoadListener = r7;
        this.lifecycleCallback = r8;
        this.closeCallback = r9;
        this.backPressedHandler = r10;
        this.pageSystemBarOptions = r11;
        this.dialogWidth = r12;
        this.dialogHeight = r13;
        this.dialogGravity = r14;
        this.dialogDimAmount = r15;
        this.dialogCancelable = r16;
        this.dialogCanceledOnTouchOutside = r17;
        this.softInputMode = r18;
    }

    public /* synthetic */ LarkLynxHostOptions(boolean r22, q1 r23, m r24, sqb.a r25, LarkLynxHostLifecycleCallback r26, LarkLynxHostCloseCallback r27, LarkLynxBackPressedHandler r28, LarkLynxSystemBarOptions r29, int r30, int r31, int r32, float r33, boolean r34, boolean r35, int r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 1) == 0) goto L5;
        boolean r1 = false;
    L6:
        LarkLynxBackPressedHandler r3 = null;
        if ((r37 & 2) == 0) goto L9;
        q1 r2 = null;
    L11:
        if ((r37 & 4) == 0) goto L13;
        m r4 = null;
    L15:
        if ((r37 & 8) == 0) goto L17;
        sqb.a r5 = null;
    L19:
        if ((r37 & 16) == 0) goto L21;
        LarkLynxHostLifecycleCallback r6 = null;
    L23:
        if ((r37 & 32) == 0) goto L25;
        LarkLynxHostCloseCallback r7 = null;
    L27:
        if ((r37 & 64) != 0) goto L31;
        r3 = r28;
    L31:
        if ((r37 & 128) == 0) goto L33;
        LarkLynxSystemBarOptions r8 = new LarkLynxSystemBarOptions(null, false, false, null, false, null, false, null, false, 511, null);
    L34:
        int r10 = -1;
        if ((r37 & 256) == 0) goto L37;
        int r9 = -1;
    L39:
        if ((r37 & 512) != 0) goto L43;
        r10 = r31;
    L43:
        if ((r37 & 1024) == 0) goto L45;
        int r11 = 80;
    L47:
        if ((r37 & 2048) == 0) goto L49;
        float r12 = 0.5f;
    L50:
        boolean r14 = true;
        if ((r37 & 4096) == 0) goto L53;
        boolean r13 = true;
    L55:
        if ((r37 & 8192) != 0) goto L59;
        r14 = r35;
    L59:
        if ((r37 & 16384) == 0) goto L61;
        int r0 = 18;
    L62:
        this(r1, r2, r4, r5, r6, r7, r3, r8, r9, r10, r11, r12, r13, r14, r0);
        return;
    L61:
        r0 = r36;
        goto L62
    L53:
        r13 = r34;
        goto L55
    L49:
        r12 = r33;
        goto L50
    L45:
        r11 = r32;
        goto L47
    L37:
        r9 = r30;
        goto L39
    L33:
        r8 = r29;
        goto L34
    L25:
        r7 = r27;
        goto L27
    L21:
        r6 = r26;
        goto L23
    L17:
        r5 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r2 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L6
    }
}
