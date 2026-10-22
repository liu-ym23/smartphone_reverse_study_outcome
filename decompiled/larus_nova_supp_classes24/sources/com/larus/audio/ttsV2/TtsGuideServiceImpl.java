package com.larus.audio.ttsV2;

import android.os.Build;
import com.bytedance.keva.Keva;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.audio.TtsOpenGuideConfig;
import com.larus.utils.t0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J9\u0010!\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0018H\u0016J\f\u0010%\u001a\u00020\u0018*\u00020\u001aH\u0002J\u0010\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\b\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020\u0018H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR+\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/audio/ttsV2/TtsGuideServiceImpl;", "Lcom/larus/audio/ttsV2/ITtsGuideService;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "repo", "Lcom/bytedance/keva/Keva;", "getRepo", "()Lcom/bytedance/keva/Keva;", "repo$delegate", "popupShow", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showFrom", "", "isTtsOpen", "Lkotlin/Function0;", "", "config", "Lcom/larus/platform/model/audio/TtsOpenGuideConfig;", "getConfig", "()Lcom/larus/platform/model/audio/TtsOpenGuideConfig;", "config$delegate", "clickGuide", "headsetDetector", "Lcom/larus/audio/ttsV2/HeadsetDetector;", "initListener", "removeListener", "setGlobalTtsSwitch", "openTts", "checkShowGuide", "getEarphoneFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/audio/ttsV2/EarphoneState;", "isEarphoneOpenGlobal", "toggleTtsCheck", "isEarphoneOnAndTtsCheck", "isEarphoneOn", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TtsGuideServiceImpl implements ITtsGuideService {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public final Lazy b;
    public Function1<? super String, Unit> c;
    public Function0<Boolean> d;
    public final Lazy e;
    public final e f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void c() {
        this.d = null;
        this.c = null;
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void d() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        if (i().getEnableEarphoneAuto() == true) goto L7;
        return;
    L7:
        if (this.f == null) goto L12;
        StateFlowImpl r0 = e.b;
        com.larus.audio.ttsV2.a r1 = (com.larus.audio.ttsV2.a) r0.getValue();
        Intrinsics.checkNotNullParameter(r1, "current");
        r0.setValue(new com.larus.audio.ttsV2.a(r1.a, !r1.b));
        return;
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final boolean e() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L13:
        return false;
    L5:
        if (this.f == null) goto L13;
        StateFlowImpl r0 = e.c;
        if (r0 == null) goto L13;
        com.larus.audio.ttsV2.a r1 = (com.larus.audio.ttsV2.a) r0.getValue();
        if (r1 == null) goto L13;
        if (r1.a != true) goto L13;
        return true;
    }

    public final TtsOpenGuideConfig i() {
        return (TtsOpenGuideConfig) this.e.getValue();
    }

    public final Keva j() {
        return (Keva) this.b.getValue();
    }

    public TtsGuideServiceImpl() {
        this.a = LazyKt.lazy(new b0());
        this.b = LazyKt.lazy(new c0());
        this.e = LazyKt.lazy(new d0());
        if (Build.VERSION.SDK_INT < 23) goto L5;
        e r0 = e.a;
    L6:
        this.f = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final i1<com.larus.audio.ttsV2.a> f() {
        if (i().getEnableEarphoneAuto() == true) goto L5;
    L9:
        return null;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (this.f == null) goto L9;
        return e.c;
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final boolean g() {
        if (i().getEnableEarphoneAuto() == true) goto L5;
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return false;
    L7:
        if (this.f == null) goto L17;
        StateFlowImpl r0 = e.c;
        if (r0 == null) goto L17;
        com.larus.audio.ttsV2.a r1 = (com.larus.audio.ttsV2.a) r0.getValue();
        if (r1 == null) goto L17;
        if (r1.a == false) goto L17;
        if (r1.b == false) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L23;
        return true;
    L23:
        return false;
    L17:
        r2 = false;
        goto L18
    }

    public final boolean k() {
        if (i().getEnableEarphoneAuto() == true) goto L5;
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return false;
    L7:
        if (this.f == null) goto L15;
        StateFlowImpl r0 = e.c;
        if (r0 == null) goto L15;
        com.larus.audio.ttsV2.a r1 = (com.larus.audio.ttsV2.a) r0.getValue();
        if (r1 == null) goto L15;
        if (r1.a != true) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L21;
        return true;
    L21:
        return false;
    L15:
        r2 = false;
        goto L16
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "showFrom");
        t0.a(new e0(this, r2));
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void h(boolean r4) {
        if (r4 == false) goto L5;
        j().erase("tts_guide_click_array");
        j().erase("last_tts_close_time");
        return;
    L5:
        j().storeLong("last_tts_close_time", AppHost.a.getAppClock().currentTimeMillis());
    }

    @Override // com.larus.audio.ttsV2.ITtsGuideService
    public final void b(com.larus.tts.impl.t r2, com.larus.tts.impl.u r3) {
        Intrinsics.checkNotNullParameter(r2, "isTtsOpen");
        Intrinsics.checkNotNullParameter(r3, "popupShow");
        if (i().getEnableOpenTtsGuide() == true) goto L5;
        return;
    L5:
        this.d = r2;
        this.c = r3;
    }
}
