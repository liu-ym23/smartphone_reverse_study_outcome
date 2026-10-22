package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mwb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingToolBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingToolbarViewContract;", "inflatedUiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "recordingState", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;", "pauseResumeVisible", "", "setBottomPadding", "", "padding", "bind", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "renderResumePauseButton", "ensureBinding", "uiLaunchMode", "subscribeDuration", "subscribeAudioVolume", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingToolBarView extends ConstraintLayout {
    public g a;
    public MmRecordingUILaunchMode b;
    public MMRecordingState c;
    public boolean d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MMRecordingState.values().length];
            r0[MMRecordingState.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MMRecordingState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public MmRecordingToolBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmRecordingToolBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBottomPadding(int r2) {
        setPadding(0, 0, 0, r2);
    }

    public static final void R5(MmRecordingToolBarView r5, MmRecordingViewModel r6) {
        r5.getClass();
        e r0 = e.a;
        MmRecordingUILaunchMode r7 = r6.getUiLaunchMode();
        r0.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.e r8 = e.b(r7).getDrawable();
        int r1 = a.a[r5.c.ordinal()];
        boolean r2 = true;
        g r3 = null;
        if (r1 != 1) goto L5;
        g r4 = r5.a;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L23:
        r4.f.setImageResource(r8.b());
        g r9 = r5.a;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L26:
        r9.b.g();
    L27:
        MMRecordingState r10 = r5.c;
        int r11 = 0;
        if (r10 != MMRecordingState.RECORDING) goto L30;
    L33:
        g r12 = r5.a;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L36:
        ImageView r13 = r12.f;
        if (r5.d == true) goto L40;
        r11 = 8;
    L40:
        r13.setVisibility(r11);
        g r14 = r5.a;
        if (r14 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L43:
        r14.f.setEnabled(r2);
        g r15 = r5.a;
        if (r15 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L47:
        r3.f.setAlpha(1.0f);
        return;
    L46:
        r3 = r15;
        goto L47
    L30:
        if (r10 == MMRecordingState.PAUSED) goto L33;
        r2 = false;
        goto L33
    L5:
        if (r1 == 2) goto L13;
        g r16 = r5.a;
        if (r16 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L9:
        r16.f.setImageResource(r8.j());
        g r17 = r5.a;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L12:
        r17.b.b();
        goto L27
    L13:
        g r18 = r5.a;
        if (r18 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L16:
        r18.f.setImageResource(r8.j());
        g r19 = r5.a;
        if (r19 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L19:
        r19.b.b();
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(final MmRecordingViewModel r6, LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        MmRecordingUILaunchMode r0 = r6.getUiLaunchMode();
        if (this.a != null) goto L5;
    L7:
        removeAllViews();
        e.a.getClass();
        g r1 = e.b(r0).getLayout().v(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(getContext(), r0)), this);
        this.a = r1;
        this.b = r0;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L10:
        r1.c.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).o(getContext()));
        g r2 = this.a;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L13:
        r2.d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).c(getContext()));
    L14:
        g r3 = this.a;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L17:
        h.a(r3.f, new MmRecordingToolBarView$bind$1(this, r6));
        g r4 = this.a;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L20:
        r4.g.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).x(getContext()));
        g r5 = this.a;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L23:
        h.a(r5.g, new MmRecordingToolBarView$bind$2(r6));
        r6.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r7), MmRecordingToolBarView$subscribeAudioVolume$1.INSTANCE, new MmRecordingToolBarView$subscribeAudioVolume$2(this, null));
        r6.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r7), MmRecordingToolBarView$subscribeDuration$1.INSTANCE, new MmRecordingToolBarView$subscribeDuration$2(this, null));
        r6.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r7), MmRecordingToolBarView$bind$3.INSTANCE, new MmRecordingToolBarView$bind$4(this, r6, null));
        r6.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r7), MmRecordingToolBarView$bind$5.INSTANCE, new MmRecordingToolBarView$bind$6(this, r6, null));
        return;
    L5:
        if (this.b != r0) goto L7;
        goto L7
    }

    public MmRecordingToolBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = MMRecordingState.INIT;
        this.d = true;
    }

    public /* synthetic */ MmRecordingToolBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
