package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.i;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mwb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J \u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0012\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0002J(\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u0012J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010+\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u001a\u0010,\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010/\u001a\u00020\u0015J\u0006\u00100\u001a\u00020\u0015J\b\u00101\u001a\u00020\u0015H\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00063"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingTopBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/MmRecordingTopPaddingTarget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingTopBarViewContract;", "inflatedUiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "hasShownAudioSaveBoarding", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "onCloseClick", "Lkotlin/Function0;", "", "getOnCloseClick", "()Lkotlin/jvm/functions/Function0;", "setOnCloseClick", "(Lkotlin/jvm/functions/Function0;)V", "setTopPadding", "padding", "bind", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "navRectProvider", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmNavRectProvider;", "ensureBinding", "uiLaunchMode", "fragment", "subscribeData", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "showAudioSaveBoardingBubble", "initViews", "shouldShowMoreEntry", "createTopBarCapabilityContext", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/MmTopBarCapabilityContext;", "handleShareClick", "showTitleInBar", "hideTitleInBar", "onDetachedFromWindow", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingTopBarView extends ConstraintLayout implements com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.a {
    public static final /* synthetic */ int f = 0;
    public h a;
    public MmRecordingUILaunchMode b;
    public boolean c;
    public Fragment d;
    public Function0<Unit> e;

    public static final class a {
    }

    static {
    }

    public MmRecordingTopBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmRecordingTopBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        h r0 = this.a;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        r0.c.animate().cancel();
        return;
    }

    public final Function0<Unit> getOnCloseClick() {
        return this.e;
    }

    public final void setOnCloseClick(Function0<Unit> r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.a
    public void setTopPadding(int r2) {
        setPadding(0, r2, 0, 0);
    }

    public static i S5(MmRecordingViewModel r5, uub.b r6) {
        boolean r2 = false;
        if (r5.hostBridge() == null) goto L5;
        boolean r1 = true;
    L6:
        MmRecordingSource r4 = null;
        if (r6 == null) goto L9;
        Rect r7 = r6.p0();
    L10:
        if (r7 == null) goto L12;
        r2 = true;
    L12:
        MmRecordingSession r8 = r5.getSession();
        if (r8 == null) goto L18;
        k r9 = r8.f;
        if (r9 == null) goto L18;
        r4 = r9.a;
    L18:
        return new i(r1, r2, r4);
    L9:
        r7 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public MmRecordingTopBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ MmRecordingTopBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(final MmRecordingViewModel r7, MmRecordingFragment r8, uub.b r9, MmRecordingFragment r10) {
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "fragment");
        this.d = r10;
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        e r11 = e.a;
        MmRecordingUILaunchMode r2 = r7.getUiLaunchMode();
        r11.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.c r12 = e.b(r2).getCapability();
        i r3 = S5(r7, r9);
        int r4 = 0;
        if (r12.e() == true) goto L5;
    L7:
        boolean r13 = false;
    L8:
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        MmRecordingUILaunchMode r0 = r7.getUiLaunchMode();
        if (this.a != null) goto L11;
    L13:
        removeAllViews();
        this.a = e.b(r0).getLayout().e(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(getContext(), r0)), this);
        this.b = r0;
    L14:
        com.ss.android.lark.officesdk.minutes.ui.style.contract.c r1 = e.b(r7.getUiLaunchMode()).getCapability();
        h r5 = null;
        i r6 = S5(r7, null);
        h r14 = this.a;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L17:
        ImageView r15 = r14.h;
        r1.b(r6);
        r15.setVisibility(8);
        h r16 = this.a;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L20:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r16.b, new MmRecordingTopBarView$initViews$1(this));
        h r17 = this.a;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L23:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r17.g, new MmRecordingTopBarView$initViews$2(r7, this));
        h r18 = this.a;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L26:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r18.d, new MmRecordingTopBarView$initViews$3(r7, this));
        h r19 = this.a;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L29:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r19.e, new MmRecordingTopBarView$initViews$4(r7, this));
        h r20 = this.a;
        if (r20 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L32:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r20.f, new MmRecordingTopBarView$initViews$5(this, r7));
        h r21 = this.a;
        if (r21 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L35:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r21.h, new MmRecordingTopBarView$initViews$6(this, r7));
        LifecycleCoroutineScope r22 = LifecycleOwnerKt.getLifecycleScope(r8);
        r7.selectSubscribe(r22, MmRecordingTopBarView$subscribeData$1.INSTANCE, new MmRecordingTopBarView$subscribeData$2(this, null));
        r7.selectSubscribe(r22, MmRecordingTopBarView$subscribeData$3.INSTANCE, new MmRecordingTopBarView$subscribeData$4(this, null));
        r7.selectSubscribe(r22, MmRecordingTopBarView$subscribeData$5.INSTANCE, new MmRecordingTopBarView$subscribeData$6(this, r7, null));
        r7.selectSubscribe(r22, MmRecordingTopBarView$subscribeData$7.INSTANCE, new MmRecordingTopBarView$subscribeData$8(this, null));
        r7.selectSubscribe(r22, MmRecordingTopBarView$subscribeData$9.INSTANCE, new MmRecordingTopBarView$subscribeData$10(this, null));
        h r23 = this.a;
        if (r23 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L38:
        ImageView r24 = r23.g;
        if (e.b(r7.getUiLaunchMode()).getCapability().f(S5(r7, r9)) == true) goto L42;
        r4 = 8;
    L42:
        r24.setVisibility(r4);
        if (r13 == false) goto L50;
        h r25 = this.a;
        if (r25 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L48:
        r5.b.setVisibility(8);
        return;
    L47:
        r5 = r25;
        goto L48
    L50:
        return;
    L11:
        if (this.b != r0) goto L13;
    L5:
        if (r3.b == false) goto L7;
        r13 = true;
        goto L8
    }
}
