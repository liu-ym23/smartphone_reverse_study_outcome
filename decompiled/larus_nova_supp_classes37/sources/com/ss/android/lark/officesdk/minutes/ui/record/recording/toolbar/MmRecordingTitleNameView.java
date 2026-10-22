package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.MmStringCheckUtil;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmCoveredEditTextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mwb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\u001a\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020\u0013H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingTitleNameView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingTitleNameViewContract;", "inflatedUiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "hostFragment", "Landroidx/fragment/app/Fragment;", "bind", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "fragment", "isAiNotesDisabled", "", "ensureBinding", "uiLaunchMode", "initVMStateObserver", "initVMEventObserver", "initLocationChooseClickListener", "initTopicUpdateClickListener", "onTitleChanged", "title", "", "from", "showTitle", "ss", "getTitle", "onDetachedFromWindow", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingTitleNameView extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public f a;
    public MmRecordingUILaunchMode b;
    public MmRecordingViewModel c;
    public Fragment d;

    public MmRecordingTitleNameView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmRecordingTitleNameView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final String getTitle() {
        f r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        return r0.d.getText().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        f r0 = this.a;
        if (r0 == null) goto L11;
        MmCoveredEditTextView r1 = r0.c;
        if ((r1 instanceof MmCoveredEditTextView) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L12;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.d.a(new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.a(r1));
        return;
    L12:
        return;
    }

    public static final /* synthetic */ String R5(MmRecordingTitleNameView r0) {
        return r0.getTitle();
    }

    public static final void S5(MmRecordingTitleNameView r5, String r6) {
        r5.getClass();
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        MmCoveredEditTextView r1 = null;
        if (r0 == false) goto L9;
    L26:
        MmRecordingViewModel r7 = r5.c;
        if (r7 == null) goto L29;
        MmRecordingViewModel.trackPageClick$default(r7, "cancel_rename", null, 2, null);
    L29:
        r5.U5(null, "EditDown_SameOrEmpty");
        f r8 = r5.a;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L32:
        MmCoveredEditTextView r9 = r8.c;
        if ((r9 instanceof MmCoveredEditTextView) == true) goto L36;
        r9 = null;
    L36:
        if (r9 == null) goto L38;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.d.a(new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.a(r9));
    L38:
        int r10 = bwb.b.a;
        bwb.b.g(MmUiLogScene.TOOLBAR, "onTitleChanged", "title is same or empty, return", null, 8);
        return;
    L9:
        if (Intrinsics.areEqual(r6, r5.getTitle()) == true) goto L26;
        MmRecordingViewModel r2 = r5.c;
        if (r2 == null) goto L14;
        MmRecordingViewModel.trackPageClick$default(r2, "save_rename", null, 2, null);
    L14:
        MmRecordingViewModel r3 = r5.c;
        if (r3 == null) goto L17;
        r3.dispatchEvent(new g.v(r5.getTitle(), r6));
    L17:
        f r4 = r5.a;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L20:
        MmCoveredEditTextView r11 = r4.c;
        if ((r11 instanceof MmCoveredEditTextView) == false) goto L23;
        r1 = r11;
    L23:
        if (r1 == null) goto L25;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.d.a(new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.a(r1));
    L25:
        r5.U5(r6, "EditDown");
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void U5(String r5, String r6) {
        int r0 = bwb.b.a;
        f r2 = null;
        bwb.b.g(MmUiLogScene.TOOLBAR, "showTitle", "ss=" + r5 + ", from=" + r6, null, 8);
        if (r5 == null) goto L8;
        f r1 = this.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L7:
        r1.d.setText(r5);
    L8:
        f r7 = this.a;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        r7.d.setVisibility(0);
        f r8 = this.a;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r2.c.setVisibility(8);
        return;
    L14:
        r2 = r8;
        goto L15
    }

    public MmRecordingTitleNameView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ MmRecordingTitleNameView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [android.widget.TextView, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmCoveredEditTextView] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v16 */
    public final void T5(MmRecordingViewModel r4, final MmRecordingFragment r5, MmRecordingFragment r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        MmRecordingUILaunchMode r0 = r4.getUiLaunchMode();
        if (this.a != null) goto L5;
    L7:
        removeAllViews();
        e.a.getClass();
        this.a = e.b(r0).getLayout().E(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(getContext(), r0)), this);
        this.b = r0;
    L8:
        this.c = r4;
        this.d = r6;
        f r8 = this.a;
        f r1 = null;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L11:
        View r9 = r8.j;
        if (r9 == null) goto L17;
        if (r7 == false) goto L15;
        int r10 = 0;
    L16:
        r9.setVisibility(r10);
        goto L17
    L15:
        r10 = 8;
    L17:
        MmRecordingViewModel r11 = this.c;
        if (r11 == null) goto L20;
        r11.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r5), MmRecordingTitleNameView$initVMStateObserver$1.INSTANCE, new MmRecordingTitleNameView$initVMStateObserver$2(this, null));
    L20:
        MmRecordingViewModel r12 = this.c;
        if (r12 == null) goto L23;
        r12.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r5), MmRecordingTitleNameView$initVMStateObserver$3.INSTANCE, new MmRecordingTitleNameView$initVMStateObserver$4(this, null));
    L23:
        MmRecordingViewModel r13 = this.c;
        if (r13 == null) goto L26;
        r13.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r5), MmRecordingTitleNameView$initVMStateObserver$5.INSTANCE, new MmRecordingTitleNameView$initVMStateObserver$6(this, null));
    L26:
        f r14 = this.a;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L29:
        MmCoveredEditTextView r15 = r14.c;
        boolean r16 = r15 instanceof MmCoveredEditTextView;
        final ?? r17 = r15;
        if (r16 == true) goto L33;
        r17 = 0;
    L33:
        if (r17 == 0) goto L39;
        f r18 = this.a;
        if (r18 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L38:
        TextView r19 = r18.d;
        UIUtils.setTextViewCursorDrawable(r17, com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).t(getContext()));
        Intrinsics.checkNotNullParameter(r19, "view");
        r17.b = r19;
        r17.e = true;
        Function1<String, Unit> r2 = new MmRecordingTitleNameView$initTopicUpdateClickListener$1(this);
        Intrinsics.checkNotNullParameter(r2, "callback");
        r17.c = r2;
        Function2<String, MmStringCheckUtil.StringCheckoutErrorType, Unit> r3 = new MmRecordingTitleNameView$initTopicUpdateClickListener$2(r5, this);
        Intrinsics.checkNotNullParameter(r3, "callback");
        r17.d = r3;
        h.a(r19, new MmRecordingTitleNameView$initTopicUpdateClickListener$3(this, r17));
    L39:
        MmRecordingViewModel r20 = this.c;
        if (r20 == null) goto L42;
        r20.selectSubscribeVMEvent(LifecycleOwnerKt.getLifecycleScope(r5), new MmRecordingTitleNameView$initVMEventObserver$1(this, null));
    L42:
        final b r21 = new b(this);
        f r22 = this.a;
        if (r22 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L45:
        h.a(r22.i, new MmRecordingTitleNameView$initLocationChooseClickListener$1(r21));
        f r23 = this.a;
        if (r23 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L49:
        h.a(r1.h, new MmRecordingTitleNameView$initLocationChooseClickListener$2(r21));
        return;
    L48:
        r1 = r23;
        goto L49
    L5:
        if (this.b != r0) goto L7;
        goto L7
    }
}
