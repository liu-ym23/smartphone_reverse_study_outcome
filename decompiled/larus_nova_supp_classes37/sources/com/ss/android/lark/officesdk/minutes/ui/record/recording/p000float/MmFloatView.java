package com.ss.android.lark.officesdk.minutes.ui.record.recording.p000float;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import bwb.b;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingWindowMode;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.e;
import com.ss.android.lark.officesdk.minutes.ui.databinding.OfficeSdkMmViewFloatBinding;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.wavebar.MmAudioWaveBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.g;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import iub.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import uvb.c;
import yub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u0004\u0018\u00010&*\u0004\u0018\u00010&H\u0002J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0016H\u0014J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\rH\u0002J\u0010\u00102\u001a\u00020\u00162\u0006\u00101\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/float/MmFloatView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/databinding/OfficeSdkMmViewFloatBinding;", "currentState", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;", "pauseResumeVisible", "", "hardwareRecordingSession", "Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingSession;", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "onCloseWindow", "Lkotlin/Function0;", "", "getOnCloseWindow", "()Lkotlin/jvm/functions/Function0;", "setOnCloseWindow", "(Lkotlin/jvm/functions/Function0;)V", "feishuDrawableProvider", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmUIDrawableProvider;", "getFeishuDrawableProvider", "()Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmUIDrawableProvider;", "feishuDrawableProvider$delegate", "Lkotlin/Lazy;", "bindSession", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/MmRecordingSession;", "getRecordingLaunchContext", "availableActivity", "Landroid/app/Activity;", "trackFloatWindowClick", PickerReporterConstants.KEY.CLICK, "", "onDetachedFromWindow", "updateDuration", "durationMs", "", "updateVolume", "volume", "updateState", "state", "updateResumePauseButton", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmFloatView extends ConstraintLayout {
    public final OfficeSdkMmViewFloatBinding a;
    public MMRecordingState b;
    public boolean c;
    public e d;
    public CoroutineScope e;
    public Function0<Unit> f;
    public final Lazy g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MMRecordingState.values().length];
            r0[MMRecordingState.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MMRecordingState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MMRecordingState.DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public MmFloatView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmFloatView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.e getFeishuDrawableProvider() {
        return (com.ss.android.lark.officesdk.minutes.ui.style.contract.e) this.g.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Context getRecordingLaunchContext() {
        d r0 = d.a;
        Activity r1 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r1 != null) goto L5;
    L12:
        r1 = null;
    L13:
        if (r1 == null) goto L16;
        return r1;
    L16:
        return getContext();
    L5:
        if (r1.isFinishing() == false) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L12;
    L7:
        if (r1.isDestroyed() == true) goto L9;
        r2 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        int r0 = b.a;
        b.g(MmUiLogScene.FLOAT, "onDetachedFromWindow", null, null, 12);
        CoroutineScope r1 = this.e;
        if (r1 == null) goto L5;
        CoroutineScopeKt.cancel$default(r1, null, 1, null);
    L5:
        this.e = null;
    }

    public final Function0<Unit> getOnCloseWindow() {
        return this.f;
    }

    public static final /* synthetic */ Context R5(MmFloatView r0) {
        return r0.getRecordingLaunchContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(final MmRecordingSession r12) {
        Intrinsics.checkNotNullParameter(r12, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        int r0 = b.a;
        b.g(MmUiLogScene.FLOAT, "bindSession", "context=".concat(getContext().getClass().getName()), null, 8);
        CoroutineScope r1 = this.e;
        boolean r2 = true;
        if (r1 == null) goto L5;
        CoroutineScopeKt.cancel$default(r1, null, 1, null);
    L5:
        CoroutineScope r5 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.e = r5;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r12.p, new MmFloatView$bindSession$1(this, null)), r5);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r12.o, new MmFloatView$bindSession$2(this, null)), r5);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r12.b.L().h(), new MmFloatView$bindSession$3(this, r12, null)), r5);
        k r3 = r12.f;
        if (r3 == null) goto L8;
        MmRecordingSource r4 = r3.a;
    L10:
        if (r4 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L13;
        r2 = false;
    L13:
        BuildersKt.launch$default(r5, null, null, new MmFloatView$bindSession$4(r12, this, r2, null), 3, null);
        h.a(this.a.d, new MmFloatView$bindSession$5(this, r12));
        MmRecordingWindowMode r6 = MmRecordingWindowMode.FLOAT_WINDOW;
        Intrinsics.checkNotNullParameter(r6, "mode");
        MmRecordingRepo r7 = r12.f();
        if (r7 == null) goto L20;
        MmRecordingMetaRepo r8 = r7.w();
        if (r8 == null) goto L20;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.a r9 = r8.l();
        if (r9 == null) goto L20;
        r9.N(r6);
    L20:
        h.a(this, new MmFloatView$bindSession$6(this, r12));
        return;
    L8:
        r4 = null;
        goto L10
    }

    public final void setOnCloseWindow(Function0<Unit> r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void T5(MmFloatView r6, MMRecordingState r7) {
        r6.b = r7;
        if (r7 != MMRecordingState.IDLE) goto L7;
        Function0<Unit> r8 = r6.f;
        if (r8 == null) goto L45;
        r8.invoke();
        return;
    L45:
        return;
    L7:
        int r1 = 0;
        if (r6.a.d.getVisibility() == 0) goto L10;
        r6.a.d.setVisibility(0);
    L10:
        com.ss.android.lark.officesdk.minutes.ui.style.contract.e r0 = r6.getFeishuDrawableProvider();
        if (r0 == null) goto L13;
        r6.a.d.setImageTintList(ColorStateList.valueOf(UIUtils.getColor(r6.getContext(), r0.h())));
    L13:
        int r2 = a.a[r7.ordinal()];
        boolean r3 = true;
        if (r2 == 1) goto L28;
        int r5 = 2131255112;
        if (r2 != 2) goto L18;
        r6.a.e.b();
        r6.a.d.setEnabled(true);
        AppCompatImageView r4 = r6.a.d;
        if (r0 == null) goto L27;
        r5 = r0.j();
    L27:
        r4.setImageResource(r5);
    L34:
        if (r7 != MMRecordingState.RECORDING) goto L36;
    L39:
        AppCompatImageView r9 = r6.a.d;
        if (r6.c == true) goto L43;
        r1 = 8;
    L43:
        r9.setVisibility(r1);
        r6.a.d.setEnabled(r3);
        r6.a.d.setAlpha(1.0f);
        return;
    L36:
        if (r7 == MMRecordingState.PAUSED) goto L39;
        r3 = false;
        goto L39
    L18:
        if (r2 != 3) goto L34;
        r6.a.e.b();
        r6.a.d.setEnabled(false);
        AppCompatImageView r10 = r6.a.d;
        if (r0 == null) goto L23;
        r5 = r0.j();
    L23:
        r10.setImageResource(r5);
        goto L34
    L28:
        r6.a.e.g();
        r6.a.d.setEnabled(true);
        AppCompatImageView r11 = r6.a.d;
        if (r0 == null) goto L31;
        int r12 = r0.b();
    L32:
        r11.setImageResource(r12);
        goto L34
    L31:
        r12 = 2131255396;
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmFloatView(final Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        this.b = MMRecordingState.INIT;
        this.c = true;
        this.g = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MmFloatView$feishuDrawableProvider$2(r12));
        LayoutInflater.from(r12).inflate(2131564089, this);
        int r15 = 2131373884;
        View r16 = ViewBindings.findChildViewById(this, 2131373884);
        if (r16 == null) goto L20;
        r15 = 2131373885;
        View r7 = ViewBindings.findChildViewById(this, 2131373885);
        if (r7 == null) goto L20;
        r15 = 2131375939;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131375939);
        if (r4 == null) goto L20;
        MmAudioWaveBarView r5 = (MmAudioWaveBarView) ViewBindings.findChildViewById(this, 2131383984);
        if (r5 == null) goto L18;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131390023);
        if (r6 == null) goto L17;
        this.a = new OfficeSdkMmViewFloatBinding(this, r16, r7, r4, r5, r6);
        if (getId() != (-1)) goto L15;
        setId(2131380183);
    L15:
        int r0 = uvb.b.a;
        uvb.a.b(this, c.Y);
        uvb.b.a(this, 2131375939, c.Z);
        uvb.b.a(this, 2131390023, c.a0);
        uvb.b.a(this, 2131383984, c.b0);
        setLayoutParams(new ConstraintLayout.LayoutParams(UIUtils.dp2px(r12, 78.0f), UIUtils.dp2px(r12, 96.0f)));
        g r17 = com.ss.android.lark.officesdk.minutes.ui.style.b.a(r12);
        setBackground(r17.d(r12));
        r16.setBackground(r17.g(r12));
        r7.setBackground(r17.e(r12));
        return;
    L17:
        r15 = 2131390023;
        goto L20
    L18:
        r15 = 2131383984;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r15)));
    }

    public static final void S5(MmFloatView r2, MmRecordingSession r3, String r4) {
        r2.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.e r5 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.e) r3.b.N().d.getValue();
        String r6 = r3.e();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "sessionId");
        Intrinsics.checkNotNullParameter(r4, PickerReporterConstants.KEY.CLICK);
        if (r5.a.d(r6) == true) goto L5;
        lvb.a.b("MmRecordFloatWindowTracker", "[trackClick] commonParam invalid, sessionId=" + r6 + ", click=" + r4);
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r7 = r5.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r1 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r1.e(PickerReporterConstants.KEY.CLICK, r4);
        r7.g(r6, "vc_record_float_window_click", r1.a());
    }

    public /* synthetic */ MmFloatView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
