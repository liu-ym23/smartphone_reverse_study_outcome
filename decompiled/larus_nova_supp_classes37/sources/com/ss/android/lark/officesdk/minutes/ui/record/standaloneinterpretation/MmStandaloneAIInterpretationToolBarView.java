package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.compose.foundation.widget.FlowSwitchStyle;
import com.ss.android.lark.foundation.widget.FlowSwitch;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J(\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\b\u0010$\u001a\u00020\u0014H\u0014J\u0012\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u0007H\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010)\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0012\u0010+\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J\u001c\u0010.\u001a\u00020\u0014*\u00020\u00102\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0002J \u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u000206H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationToolBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingAiNoteToolbarViewContract;", "saveSwitch", "Landroid/view/View;", "saveActionContainer", "stopButton", "Landroid/widget/ImageView;", "bindScope", "Lkotlinx/coroutines/CoroutineScope;", "bind", "", "scope", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/MmRecordingSlotScope;", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationViewModel;", "bindSaveSwitch", "coroutineScope", "showSettingsFailedToast", "subscribeDuration", "subscribeAudioVolume", "subscribeRecordingState", "onSizeChanged", "w", "h", "oldw", "oldh", "onDetachedFromWindow", "adjustActionWidthsIfNeeded", "viewWidthPx", "updateAdaptiveWidth", PickerReporterConstants.KEY.TARGET, "updateWidth", "widthDp", "getMarginStart", "dpToPx", "valueDp", "setIcon", "drawableRes", "colorRes", "applyResumePauseButtonStyle", "iconRes", "backgroundRes", "tintRes", "drawableProvider", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmUIDrawableProvider;", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmStandaloneAIInterpretationToolBarView extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public final mwb.c a;
    public final View b;
    public final View c;
    public final ImageView d;
    public CoroutineScope e;

    public static final class a implements Runnable {
        public final /* synthetic */ MmStandaloneAIInterpretationToolBarView a;

        public a(MmStandaloneAIInterpretationToolBarView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmStandaloneAIInterpretationToolBarView r0 = this.a;     // Catch: Throwable -> L4
            MmStandaloneAIInterpretationToolBarView.R5(r0, r0.a.f.getWidth());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MmStandaloneAIInterpretationToolBarView a;
        public final /* synthetic */ int b;

        public c(MmStandaloneAIInterpretationToolBarView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmStandaloneAIInterpretationToolBarView r0 = this.a;     // Catch: Throwable -> L14
            Integer r1 = Integer.valueOf(r0.a.f.getWidth());     // Catch: Throwable -> L14
            if (r1.intValue() <= 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == true) goto L9;
            r1 = null;
        L9:
            if (r1 == null) goto L11;
            int r3 = r1.intValue();     // Catch: Throwable -> L14
        L12:
            MmStandaloneAIInterpretationToolBarView.R5(r0, r3);     // Catch: Throwable -> L14
            return;
        L11:
            r3 = this.b;     // Catch: Throwable -> L14
            goto L12
        L5:
            r2 = false;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L18;
            return;
        L18:
            throw th;
        }
    }

    static {
    }

    public MmStandaloneAIInterpretationToolBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmStandaloneAIInterpretationToolBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.ss.android.lark.officesdk.minutes.ui.style.contract.e T5() {
        com.ss.android.lark.officesdk.minutes.ui.style.e r0 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r1 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(getContext());
        r0.getClass();
        return com.ss.android.lark.officesdk.minutes.ui.style.e.b(r1).getDrawable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        CoroutineScope r0 = this.e;
        if (r0 == null) goto L5;
        CoroutineScopeKt.cancel$default(r0, null, 1, null);
    L5:
        this.e = null;
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    public final void U5(View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if ((r0 instanceof LinearLayout.LayoutParams) == false) goto L7;
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
    L8:
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.width == 0) goto L13;
    L18:
        r1.width = 0;
        r1.weight = 1.0f;
        r5.setLayoutParams(r1);
        r5.requestLayout();
        return;
    L13:
        if (r1.weight != 1.0f) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        return;
    L15:
        r2 = false;
        goto L16
    L7:
        r1 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void R5(MmStandaloneAIInterpretationToolBarView r5, int r6) {
        r5.getClass();
        Integer r7 = Integer.valueOf(r6);
        boolean r2 = false;
        if (r7.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r7 = null;
    L9:
        if (r7 == null) goto L11;
        int r8 = r7.intValue();
    L12:
        Resources r1 = r5.getResources();
        float r9 = r8 / WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        if (r9 < 600.0f) goto L15;
        r2 = true;
    L15:
        if (r2 == false) goto L18;
        r5.U5(r5.a.g);
        r5.V5(r5.a.h, 108);
        r5.V5(r5.a.i, 108);
        return;
    L18:
        if (r9 <= 402.0f) goto L20;
        r5.U5(r5.a.g);
        r5.V5(r5.a.h, 78);
        r5.V5(r5.a.i, 78);
        return;
    L20:
        int r3 = 174;
        if (r9 >= 402.0f) goto L23;
        r3 = RangesKt.coerceAtLeast((int) (174 - (402 - r9)), 130);
    L23:
        Resources r4 = r5.getResources();
        TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
        r5.V5(r5.a.g, r3);
        r5.V5(r5.a.h, 78);
        r5.V5(r5.a.i, 78);
        return;
    L11:
        Resources r10 = r5.getResources();
        r8 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).widthPixels;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(View r5, int r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        Resources r0 = getResources();
        boolean r1 = true;
        int r7 = (int) TypedValue.applyDimension(1, r6, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
        ViewGroup.LayoutParams r2 = r5.getLayoutParams();
        if ((r2 instanceof LinearLayout.LayoutParams) == false) goto L7;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
    L8:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.width == r7) goto L13;
    L18:
        r3.width = r7;
        r3.weight = 0.0f;
        r5.setLayoutParams(r3);
        r5.requestLayout();
        return;
    L13:
        if (r3.weight == 0.0f) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        return;
    L7:
        r3 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmStandaloneAIInterpretationToolBarView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        int r8 = mwb.c.j;
        LayoutInflater r9 = LayoutInflater.from(r5);
        Intrinsics.checkNotNullParameter(r9, "inflater");
        mwb.c r10 = new mwb.c(r9.inflate(2131564109, this, true));
        this.a = r10;
        ViewStub r11 = (ViewStub) findViewById(2131385114);
        com.ss.android.lark.officesdk.minutes.ui.style.e r0 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r2 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(r5);
        r0.getClass();
        r11.setLayoutResource(com.ss.android.lark.officesdk.minutes.ui.style.e.b(r2).getLayout().o());
        FlowSwitch r12 = r11.inflate();
        if ((r12 instanceof FlowSwitch) == false) goto L5;
        FlowSwitch r1 = r12;
    L6:
        if (r1 == null) goto L8;
        r1.setStyle(FlowSwitchStyle.SMALL);
    L8:
        this.b = r12;
        this.c = findViewById(2131385088);
        View r13 = r10.i;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView r14 = (ImageView) r13;
        this.d = r14;
        Resources r3 = getResources();
        setMinHeight((int) TypedValue.applyDimension(1, 148, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        r10.b.setText("00:00");
        r10.d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r5).o(r5));
        r10.e.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r5).c(r5));
        S5(T5().j(), T5().i(), T5().g());
        r14.setImageDrawable(UDIconUtils.getIconDrawable(r14.getContext(), 2131253749, UIUtils.getColor(r14.getContext(), 2131102040)));
        r14.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r5).x(r5));
        r10.f.post(new a(this));
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(int r2, int r3, int r4) {
        this.a.h.setImageResource(r2);
        this.a.h.setImageTintList(ColorStateList.valueOf(UIUtils.getColor(getContext(), r4)));
        if (r3 == 0) goto L5;
        this.a.h.setBackgroundResource(r3);
        return;
    L5:
        this.a.h.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).z(getContext()));
    }

    public /* synthetic */ MmStandaloneAIInterpretationToolBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L8;
        if (r1 == r3) goto L9;
        this.a.f.requestLayout();
        post(new c(this, r1));
        return;
    L9:
        return;
    }
}
