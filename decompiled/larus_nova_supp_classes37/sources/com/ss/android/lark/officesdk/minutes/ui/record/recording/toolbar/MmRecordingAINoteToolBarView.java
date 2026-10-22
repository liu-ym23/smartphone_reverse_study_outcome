package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u0001:\u0001QB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007J*\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$J\u0012\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0002J(\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0012\u0010/\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u0007H\u0002J\u0012\u00100\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u001a\u00103\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00104\u001a\u00020\u0007H\u0002J\u0012\u00105\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J,\u00108\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$H\u0002J\u0018\u00109\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 H\u0002J,\u0010:\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$H\u0002J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010<\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010>\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010B\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010D\u001a\u00020\u001cH\u0002J\b\u0010E\u001a\u00020\u001cH\u0002J$\u0010F\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$H\u0002J\b\u0010G\u001a\u00020\u001cH\u0002J \u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0002J\u0010\u0010L\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010M\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00140$H\u0002J\b\u0010N\u001a\u00020\u001cH\u0014J\u000e\u0010O\u001a\u0004\u0018\u00010P*\u00020\u0003H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingAINoteToolBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingAiNoteToolbarViewContract;", "inflatedUiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "aiNoteControl", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteControl;", "aiNoteControlKey", "", "aiNoteVisibilityListenerKey", "isAiNotePageShowing", "", "latestRecordingState", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;", "pauseResumeVisible", "aiNoteTooltipBubble", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/IMmBubbleHandle;", "firstMarkTooltipBubble", "setBottomPadding", "", "padding", "bind", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onNavigateToSubtitle", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteSubtitleNavigationRequest;", "ensureBinding", "uiLaunchMode", "onSizeChanged", "w", "h", "oldw", "oldh", "refreshActionWidths", "viewWidthPx", "adjustActionWidthsIfNeeded", "updateAdaptiveWidth", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "updateWidth", "widthDp", "getMarginStart", "dpToPx", "valueDp", "subscribeDuration", "subscribeAudioVolume", "subscribeRecordingState", "renderResumePauseButton", "subscribePageViewTrack", "trackAiNotesEntryViewIfNeeded", "subscribeAINoteTooltip", "showAINoteTooltipAfterToolbarLayout", "showFirstMarkTooltipIfNeeded", "message", "canOpenAINote", "consumeAndDismissAINoteTooltip", "dismissAINoteTooltip", "dismissFirstMarkTooltip", "registerAINoteVisibilityListener", "syncRecordWaveBarState", "applyResumePauseButtonStyle", "iconRes", "backgroundRes", "tintRes", "buildAINoteOwnerKey", "getAINoteControl", "onDetachedFromWindow", "findFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingAINoteToolBarView extends ConstraintLayout {
    public static final /* synthetic */ int k = 0;
    public mwb.c a;
    public MmRecordingUILaunchMode b;
    public com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a c;
    public String d;
    public final String e;
    public boolean f;
    public MMRecordingState g;
    public boolean h;
    public qub.a i;
    public qub.a j;

    public static final class a {
    }

    public /* synthetic */ class b {
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

    public static final class c implements Runnable {
        public final /* synthetic */ MmRecordingAINoteToolBarView a;
        public final /* synthetic */ int b;

        public c(MmRecordingAINoteToolBarView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmRecordingAINoteToolBarView r0 = this.a;     // Catch: Throwable -> L16
            mwb.c r1 = r0.a;     // Catch: Throwable -> L16
            Integer r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("binding");     // Catch: Throwable -> L16
            r1 = null;
        L5:
            Integer r3 = Integer.valueOf(r1.f.getWidth());     // Catch: Throwable -> L16
            if (r3.intValue() <= 0) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == false) goto L11;
            r2 = r3;
        L11:
            if (r2 == null) goto L13;
            int r5 = r2.intValue();     // Catch: Throwable -> L16
        L14:
            r0.Z5(r5);     // Catch: Throwable -> L16
            return;
        L13:
            r5 = this.b;     // Catch: Throwable -> L16
            goto L14
        L8:
            r4 = false;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L20;
            return;
        L20:
            throw th;
        }
    }

    static {
    }

    public MmRecordingAINoteToolBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmRecordingAINoteToolBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmRecordingAINoteToolBarView#onDetachedFromWindow", "unregister listener=" + this.e, null, 8);
        qub.a r1 = this.i;
        this.i = null;
        if (r1 == null) goto L5;
        r1.hide();
    L5:
        qub.a r2 = this.j;
        this.j = null;
        if (r2 == null) goto L8;
        r2.hide();
    L8:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r3 = this.c;
        if (r3 == null) goto L11;
        String r4 = this.e;
        Intrinsics.checkNotNullParameter(r4, "listenerKey");
        r3.m.remove(r4);
    L11:
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    public static final void T5(MmRecordingAINoteToolBarView r6) {
        if (r6.a != null) goto L6;
        return;
    L6:
        if (r6.g == MMRecordingState.RECORDING) goto L8;
    L10:
        boolean r0 = false;
    L11:
        int r1 = bwb.b.a;
        mwb.c r5 = null;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmRecordingAINoteToolBarView#syncRecordWaveBarState", "shouldResume=" + r0 + " recordingState=" + r6.g + " aiNoteShowing=" + r6.f, null, 8);
        if (r0 == false) goto L18;
        mwb.c r7 = r6.a;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L17:
        r5.c.g();
        return;
    L16:
        r5 = r7;
        goto L17
    L18:
        mwb.c r8 = r6.a;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r5.c.b();
        return;
    L21:
        r5 = r8;
        goto L22
    L8:
        if (r6.f == true) goto L10;
        r0 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z5(int r10) {
        mwb.c r2 = null;
        if (this.h == true) goto L5;
        mwb.c r11 = this.a;
        if (r11 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L110:
        c6(r2.g);
        return;
    L109:
        r2 = r11;
        goto L110
    L5:
        if (this.a == null) goto L115;
        Integer r12 = Integer.valueOf(r10);
        boolean r3 = true;
        if (r12.intValue() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L14;
        r12 = null;
    L14:
        if (r12 == null) goto L16;
        int r13 = r12.intValue();
    L17:
        Resources r5 = getResources();
        float r1 = r13 / WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
        if (r1 < 600.0f) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == false) goto L34;
        mwb.c r14 = this.a;
        if (r14 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L25:
        c6(r14.g);
        mwb.c r15 = this.a;
        if (r15 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L28:
        i6(r15.h, 108);
        mwb.c r16 = this.a;
        if (r16 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L32:
        i6(r2.i, 108);
        return;
    L31:
        r2 = r16;
        goto L32
    L34:
        if (r1 <= 402.0f) goto L46;
        mwb.c r17 = this.a;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L38:
        c6(r17.g);
        mwb.c r18 = this.a;
        if (r18 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L41:
        i6(r18.h, 78);
        mwb.c r19 = this.a;
        if (r19 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L45:
        i6(r2.i, 78);
        return;
    L44:
        r2 = r19;
        goto L45
    L46:
        int r7 = 174;
        if (r1 >= 402.0f) goto L49;
        r7 = RangesKt.coerceAtLeast((int) (174 - (402 - r1)), 142);
    L49:
        Resources r8 = getResources();
        int r4 = (int) TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()));
        mwb.c r9 = this.a;
        if (r9 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L52:
        Integer r20 = Integer.valueOf(r9.f.getWidth());
        if (r20.intValue() > 0) goto L56;
        r3 = false;
    L56:
        if (r3 == true) goto L59;
        r20 = null;
    L59:
        if (r20 == null) goto L61;
        r13 = r20.intValue();
    L61:
        mwb.c r21 = this.a;
        if (r21 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L64:
        int r110 = r13 - r21.f.getPaddingLeft();
        mwb.c r22 = this.a;
        if (r22 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L67:
        int r111 = (r110 - r22.f.getPaddingRight()) - r4;
        mwb.c r23 = this.a;
        if (r23 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L70:
        ImageView r24 = r23.h;
        if (r24 == null) goto L73;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
    L75:
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L77;
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
    L78:
        if (r26 != null) goto L80;
        int r27 = 0;
    L81:
        int r112 = r111 - r27;
        mwb.c r28 = this.a;
        if (r28 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L84:
        View r29 = r28.i;
        if (r29 == null) goto L87;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
    L89:
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == false) goto L91;
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
    L92:
        if (r31 != null) goto L94;
        int r32 = 0;
    L95:
        float r113 = RangesKt.coerceAtLeast(r112 - r32, 0) / 2.0f;
        Resources r33 = getResources();
        int r114 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (r113 / WindowDisplayMetricsOverride.apply(r33, r33.getDisplayMetrics()).density), 60), 78);
        mwb.c r34 = this.a;
        if (r34 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L98:
        i6(r34.g, r7);
        mwb.c r35 = this.a;
        if (r35 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r35 = null;
    L101:
        i6(r35.h, r114);
        mwb.c r36 = this.a;
        if (r36 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L105:
        i6(r2.i, r114);
        return;
    L104:
        r2 = r36;
        goto L105
    L94:
        r32 = r31.getMarginStart();
        goto L95
    L91:
        r31 = null;
        goto L92
    L87:
        r30 = null;
        goto L89
    L80:
        r27 = r26.getMarginStart();
        goto L81
    L77:
        r26 = null;
        goto L78
    L73:
        r25 = null;
        goto L75
    L20:
        r6 = false;
        goto L21
    L16:
        Resources r115 = getResources();
        r13 = WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).widthPixels;
        goto L17
    L10:
        r0 = false;
        goto L11
    }

    public final void c6(View r5) {
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
    public final void setBottomPadding(int r2) {
        setPadding(0, 0, 0, r2);
    }

    public static final FragmentActivity R5(MmRecordingAINoteToolBarView r0, Context r1) {
        r0.getClass();
    L4:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof FragmentActivity) == true) goto L13;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L4
    L13:
        return (FragmentActivity) r1;
    L9:
        return null;
    }

    public static final void S5(MmRecordingAINoteToolBarView r7, MmRecordingViewModel r8) {
        r7.getClass();
        e r0 = e.a;
        MmRecordingUILaunchMode r9 = r8.getUiLaunchMode();
        r0.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.e r10 = e.b(r9).getDrawable();
        MMRecordingState r1 = r7.g;
        int r3 = 0;
        if (r1 != MMRecordingState.RECORDING) goto L5;
    L8:
        boolean r2 = true;
    L9:
        mwb.c r4 = r7.a;
        mwb.c r5 = null;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L12:
        ImageView r6 = r4.h;
        if (r7.h == true) goto L16;
        r3 = 8;
    L16:
        r6.setVisibility(r3);
        mwb.c r11 = r7.a;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L19:
        r7.Z5(r11.f.getWidth());
        int r12 = b.a[r7.g.ordinal()];
        if (r12 != 1) goto L22;
        r7.U5(r10.b(), r10.d(), r10.h());
    L26:
        mwb.c r13 = r7.a;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L30:
        r5.h.setEnabled(r2);
        return;
    L29:
        r5 = r13;
        goto L30
    L22:
        if (r12 == 2) goto L24;
        r7.U5(r10.j(), r10.i(), r10.g());
        goto L26
    L24:
        r7.U5(r10.j(), r10.d(), r10.h());
        goto L26
    L5:
        if (r1 == MMRecordingState.PAUSED) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a Y5(final MmRecordingViewModel r10, Function1<? super l, Boolean> r11) {
        int r0 = com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a.n;
        String r1 = r10.getMeetingId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r2 = String.valueOf(hashCode());
        Intrinsics.checkNotNullParameter(r1, "meetingId");
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);
        if ((!StringsKt.isBlank(r1)) == false) goto L9;
        String r3 = "meeting_".concat(r1);
    L12:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r4 = this.c;
        if (r4 != null) goto L15;
    L17:
        if (r4 == null) goto L19;
        String r5 = this.e;
        Intrinsics.checkNotNullParameter(r5, "listenerKey");
        r4.m.remove(r5);
    L19:
        String r6 = r10.getMeetingId();
        if (r6 != null) goto L22;
        String r7 = "";
    L23:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r8 = new com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a(r3, r7, r10.getUiLaunchMode(), new MmRecordingAINoteToolBarView$getAINoteControl$1(r10), r11);
        this.c = r8;
        this.d = r3;
        return r8;
    L22:
        r7 = r6;
        goto L23
    L15:
        if (Intrinsics.areEqual(this.d, r3) == false) goto L17;
        return r4;
    L9:
        if ((!StringsKt.isBlank(r2)) == false) goto L11;
        r3 = "token_" + r2;
        goto L12
    L11:
        r3 = "MmAINoteControl";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b6(String r26, final MmRecordingViewModel r27) {
        Intrinsics.checkNotNullParameter(r26, "message");
        Intrinsics.checkNotNullParameter(r27, "viewModel");
        if (StringsKt.isBlank(r26) == false) goto L5;
        return false;
    L5:
        mwb.c r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        View r4 = r2.g;
        qub.a r3 = this.j;
        if (r3 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L19;
        qub.a r6 = this.j;
        this.j = null;
        if (r6 == null) goto L19;
        r6.hide();
    L19:
        if (isAttachedToWindow() == true) goto L21;
    L41:
        int r1 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "showFirstMarkTooltipIfNeeded", "skip: view not ready, attached=" + isAttachedToWindow() + ", shown=" + isShown() + ", anchor=" + r4.getWidth() + 'x' + r4.getHeight(), null, 8);
        return false;
    L21:
        if (isShown() == false) goto L41;
        if (r4.getWidth() <= 0) goto L41;
        if (r4.getHeight() <= 0) goto L41;
        int r7 = UIUtils.dp2px(getContext(), 16.0f);
        int r8 = UIUtils.dp2px(getContext(), 18.0f);
        int r9 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((getWidth() - (r7 * 2)) - r8, UIUtils.dp2px(getContext(), 80.0f)), UIUtils.dp2px(getContext(), 220.0f) - r8);
        int r10 = com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.a;
        boolean r11 = true;
        qub.a r12 = com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.b(getContext(), r4, r26, MmBubbleDirection.BOTTOM, false, true, 3000, false, Integer.valueOf(r9), 2, null, null, (qub.b) r27.getUiProviders().g.getValue(), r27.getUiLaunchMode(), new MmRecordingAINoteToolBarView$showFirstMarkTooltipIfNeeded$1(this, r27), 10, 6152);
        this.j = r12;
        if (r12 == qub.a.C0180a.a) goto L30;
        boolean r13 = true;
    L32:
        if (r12.isShowing() == true) goto L35;
        r11 = false;
    L35:
        if (r13 == true) goto L39;
        qub.a r14 = this.j;
        this.j = null;
        if (r14 == null) goto L39;
        r14.hide();
    L39:
        int r15 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "showFirstMarkTooltipIfNeeded", "shown=" + r13 + ", actualIsShowing=" + r11, null, 8);
        return r13;
    L30:
        r13 = false;
        goto L32
    L11:
        if (r3.isShowing() != true) goto L13;
        r5 = true;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i6(View r5, int r6) {
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
    public MmRecordingAINoteToolBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = "MmRecordingAINoteToolBarView_" + hashCode();
        this.g = MMRecordingState.INIT;
        this.h = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(int r4, int r5, int r6) {
        mwb.c r0 = this.a;
        mwb.c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.h.setImageResource(r4);
        mwb.c r7 = this.a;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        r7.h.setImageTintList(ColorStateList.valueOf(UIUtils.getColor(getContext(), r6)));
        if (r5 == 0) goto L15;
        mwb.c r8 = this.a;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        r1.h.setBackgroundResource(r5);
        return;
    L13:
        r1 = r8;
        goto L14
    L15:
        mwb.c r9 = this.a;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        r1.h.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).z(getContext()));
        return;
    L18:
        r1 = r9;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(final MmRecordingViewModel r7, MmRecordingFragment r8, final Function1 r9) {
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r9, "onNavigateToSubtitle");
        MmRecordingUILaunchMode r0 = r7.getUiLaunchMode();
        if (this.a != null) goto L5;
    L7:
        removeAllViews();
        e.a.getClass();
        mwb.c r1 = e.b(r0).getLayout().s(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(getContext(), r0)), this);
        this.a = r1;
        this.b = r0;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L10:
        r1.d.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).o(getContext()));
        mwb.c r2 = this.a;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L13:
        r2.e.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).c(getContext()));
        mwb.c r3 = this.a;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L16:
        r3.g.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).z(getContext()));
        U5(e.b(r0).getDrawable().j(), e.b(r0).getDrawable().i(), e.b(r0).getDrawable().g());
        mwb.c r4 = this.a;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L19:
        r4.i.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).x(getContext()));
        mwb.c r5 = this.a;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L22:
        r5.f.post(new com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.a(this));
    L23:
        mwb.c r6 = this.a;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L26:
        h.a(r6.g, new MmRecordingAINoteToolBarView$bind$1(this, r7, r9));
        mwb.c r10 = this.a;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L29:
        h.a(r10.h, new MmRecordingAINoteToolBarView$bind$2(this, r7));
        mwb.c r11 = this.a;
        if (r11 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L32:
        h.a(r11.i, new MmRecordingAINoteToolBarView$bind$3(r7));
        r7.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r8), MmRecordingAINoteToolBarView$subscribeAudioVolume$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribeAudioVolume$2(this, null));
        r7.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r8), MmRecordingAINoteToolBarView$subscribeDuration$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribeDuration$2(this, r7, r9, null));
        r7.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r8), MmRecordingAINoteToolBarView$subscribeRecordingState$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribeRecordingState$2(this, r7, r9, null));
        r7.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r8), MmRecordingAINoteToolBarView$subscribeRecordingState$3.INSTANCE, new MmRecordingAINoteToolBarView$subscribeRecordingState$4(this, r7, null));
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r12 = Y5(r7, r9);
        String r13 = this.e;
        Function1<Boolean, Unit> r14 = new MmRecordingAINoteToolBarView$registerAINoteVisibilityListener$1(this);
        Intrinsics.checkNotNullParameter(r13, "listenerKey");
        Intrinsics.checkNotNullParameter(r14, "listener");
        r12.m.put(r13, r14);
        r14.invoke(Boolean.valueOf(r12.l));
        r7.trackAINoteEntryViewIfNeeded();
        r7.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r8), MmRecordingAINoteToolBarView$subscribePageViewTrack$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribePageViewTrack$2(this, r7, null));
        r7.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r8), MmRecordingAINoteToolBarView$subscribePageViewTrack$3.INSTANCE, new MmRecordingAINoteToolBarView$subscribePageViewTrack$4(this, r7, null));
        r7.refreshAINoteTooltipIfNeeded();
        r7.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r8), MmRecordingAINoteToolBarView$subscribeAINoteTooltip$1.INSTANCE, new MmRecordingAINoteToolBarView$subscribeAINoteTooltip$2(this, r7, null));
        return;
    L5:
        if (this.b != r0) goto L7;
        goto L7
    }

    public /* synthetic */ MmRecordingAINoteToolBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L12;
        if (r1 == r3) goto L13;
        mwb.c r5 = this.a;
        if (r5 == null) goto L14;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L10:
        r5.f.requestLayout();
        post(new c(this, r1));
        return;
    L14:
        return;
    L13:
        return;
    }
}
