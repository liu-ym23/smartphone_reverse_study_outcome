package com.larus.dora.impl.device.settings.lab.env.timer;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel;
import java.util.Calendar;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\u0017\u0010&\u001a\u00020!2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0013J\b\u0010*\u001a\u00020!H\u0002J\u0012\u0010+\u001a\u00020!2\b\b\u0002\u0010,\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0013H\u0002J\"\u00101\u001a\u0004\u0018\u0001022\u0006\u00100\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0013H\u0002J\u0018\u00109\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0010H\u0002J\b\u0010;\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020\u00102\u0006\u00106\u001a\u000205H\u0002J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u000205H\u0002J\u0006\u0010?\u001a\u00020\u0010J\b\u0010@\u001a\u000205H\u0002J\b\u0010A\u001a\u000205H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\bR\u001b\u0010\u001d\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001e\u0010\b¨\u0006C"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/timer/TimerJob;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/larus/dora/impl/device/settings/lab/env/infz/IEnvJob;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "MAX_CHECK_INTERVAL_MINUTES", "", "checkingLock", "", "job", "Lkotlinx/coroutines/Job;", "lastState", "", "Ljava/lang/Boolean;", "checkingGeneration", "", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "defaultStart", "getDefaultStart", "defaultStart$delegate", "defaultEnd", "getDefaultEnd", "defaultEnd$delegate", "init", "", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "restartChecking", "reasonCode", "(Ljava/lang/Integer;)V", "updateEnvTimeState", "startChecking", "startCheckingLocked", "skipInitialReport", "stopChecking", "stopCheckingLocked", "isCheckingGenerationActive", "generation", "nextTimerStateDecision", "Lcom/larus/dora/impl/device/settings/lab/env/timer/TimerStateDecision;", "inAutoStart", "getNextBoundaryTime", "Ljava/util/Calendar;", "now", "checkAndUpdateTime", "onTimeChange", "getAutoReasonCode", "isHeartbeat", "canEntry", "isInAutoStartPeriod", "getTotalMinutes", "calendar", "isTimeEnable", "startTime", "endTime", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimerJob extends p49.a implements DefaultLifecycleObserver {
    public static final a j = null;
    public static volatile TimerJob k;
    public final String a;
    public final long b;
    public final Object c;
    public Job d;
    public Boolean e;
    public int f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
        public final TimerJob a() {
            TimerJob r0 = TimerJob.k;
            if (r0 != null) goto L15;
            monitor-enter(this);
            r0 = TimerJob.k;     // Catch: Throwable -> L9
            if (r0 != null) goto L11;
            r0 = new TimerJob();     // Catch: Throwable -> L9
            TimerJob.k = r0;     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r0;
        }

        public a() {
        }
    }

    static {
        j = new a();
    }

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onDestroy(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onDestroy(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final void a() {
        new Handler(Looper.getMainLooper()).post(new i(this));
        Object r0 = this.c;
        monitor-enter(r0);
        g(false);     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final Calendar c() {
        IDoraPageConfig r0 = (IDoraPageConfig) this.g.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.f(EnvObserveViewModel.START_TIME_SET, (String) this.h.getValue());
        if (r1 == null) goto L6;
    L7:
        List r2 = StringsKt.split$default(r1, new String[]{":"}, false, 0, 6, null);
        IDoraPageConfig r3 = (IDoraPageConfig) this.g.getValue();
        if (r3 == null) goto L11;
        String r4 = r3.f(EnvObserveViewModel.END_TIME_SET, (String) this.i.getValue());
        if (r4 == null) goto L11;
    L12:
        List r5 = StringsKt.split$default(r4, new String[]{":"}, false, 0, 6, null);
        Calendar r6 = Calendar.getInstance();
        if (CastIntegerProtector.parseInt((String) ListProtector.get(r5, 0)) <= CastIntegerProtector.parseInt((String) ListProtector.get(r2, 0))) goto L15;
    L20:
        r6.set(11, CastIntegerProtector.parseInt((String) ListProtector.get(r5, 0)));
        r6.set(12, CastIntegerProtector.parseInt((String) ListProtector.get(r5, 1)));
        r6.set(13, 0);
        r6.set(14, 0);
        return r6;
    L15:
        if (CastIntegerProtector.parseInt((String) ListProtector.get(r5, 0)) == CastIntegerProtector.parseInt((String) ListProtector.get(r2, 0))) goto L17;
    L19:
        r6.add(5, 1);
        goto L20
    L17:
        if (CastIntegerProtector.parseInt((String) ListProtector.get(r5, 1)) <= CastIntegerProtector.parseInt((String) ListProtector.get(r2, 1))) goto L19;
    L11:
        r4 = (String) this.i.getValue();
    L6:
        r1 = (String) this.h.getValue();
        goto L7
    }

    public final Calendar h() {
        IDoraPageConfig r0 = (IDoraPageConfig) this.g.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.f(EnvObserveViewModel.START_TIME_SET, (String) this.h.getValue());
        if (r1 == null) goto L6;
    L7:
        List r2 = StringsKt.split$default(r1, new String[]{":"}, false, 0, 6, null);
        Calendar r3 = Calendar.getInstance();
        r3.set(11, CastIntegerProtector.parseInt((String) ListProtector.get(r2, 0)));
        r3.set(12, CastIntegerProtector.parseInt((String) ListProtector.get(r2, 1)));
        r3.set(13, 0);
        r3.set(14, 0);
        return r3;
    L6:
        r1 = (String) this.h.getValue();
        goto L7
    }

    public TimerJob() {
        this.a = "EnvTimeJob";
        this.b = 5;
        this.c = new Object();
        this.g = LazyKt.lazy(new f());
        this.h = LazyKt.lazy(new g());
        this.i = LazyKt.lazy(new h());
    }

    public final boolean e(Calendar r6) {
        Calendar r0 = h();
        int r2 = (r0.get(11) * 60) + r0.get(12);
        Calendar r1 = c();
        int r4 = (r1.get(11) * 60) + r1.get(12);
        int r3 = (r6.get(11) * 60) + r6.get(12);
        g49.d.d(this.a, "now min: " + r3 + ", startMin: " + r2 + ", endMin: " + r4);
        int r7 = com.larus.dora.impl.device.settings.lab.env.timer.a.a;
        IDoraPageConfig r8 = (IDoraPageConfig) this.g.getValue();
        if (r8 == null) goto L5;
        boolean r9 = r8.d("dora_g_config_key_env_observe_timer_enable", false);
    L6:
        if (r9 == false) goto L15;
        if (r2 == r4) goto L15;
        if (r4 <= r2) goto L13;
        if (r2 > r3) goto L17;
        if (r3 < r4) goto L15;
        return false;
    L17:
        return false;
    L13:
        if (r3 >= r2) goto L15;
        if (r3 < r4) goto L15;
        return false;
    L15:
        return true;
    L5:
        r9 = false;
        goto L6
    }

    public final void f(Integer r5) {
        Object r0 = this.c;
        monitor-enter(r0);
        boolean r2 = true;
        this.f++;     // Catch: Throwable -> L22
        Job r1 = this.d;     // Catch: Throwable -> L22
        if (r1 == null) goto L7;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);     // Catch: Throwable -> L22
    L7:
        this.d = null;     // Catch: Throwable -> L22
        this.e = null;     // Catch: Throwable -> L22
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r0);
        if (r5 == null) goto L11;
        int r4 = r5.intValue();
        EnvObserveChangeReason r6 = EnvObserveChangeReason.TIMER_CHANGE;
        Intrinsics.checkNotNullParameter(r6, "reason");
        DoraEnvObserveManager.a.getClass();
        DoraEnvObserveManager.h(r6, r4);
    L11:
        Object r7 = this.c;
        monitor-enter(r7);
        if (r5 != null) goto L25;
        r2 = false;
    L25:
        g(r2);     // Catch: Throwable -> L19
        monitor-exit(r7);
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    }

    public final void g(boolean r10) {
        IDoraPageConfig r0 = (IDoraPageConfig) this.g.getValue();
        boolean r1 = false;
        if (r0 == null) goto L5;
        r1 = r0.d("dora_g_config_key_env_observe_enable", false);
    L5:
        if (r1 == true) goto L8;
        g49.d.d(this.a, "env enable is false , don't start timer");
        return;
    L8:
        Job r2 = this.d;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        int r3 = this.f + 1;
        this.f = r3;
        this.d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault())), null, null, new TimerJob$startCheckingLocked$1(this, r3, r10, null), 3, null);
    }

    public final void onStart(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        g49.d.d(this.a, "App 回到前台，重新启动检测任务");
        f(null);
    }

    public final void onStop(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        g49.d.d(this.a, "App 进入后台，重新计算时间并重启检测任务");
        f(null);
    }

    public final int d(boolean r4, boolean r5) {
        IDoraPageConfig r0 = (IDoraPageConfig) this.g.getValue();
        boolean r1 = false;
        if (r0 == null) goto L6;
        r1 = r0.d("dora_g_config_key_env_observe_timer_enable", false);
    L6:
        if (r1 == true) goto L8;
        return 188;
    L8:
        if (r5 == false) goto L10;
        return 188;
    L10:
        if (r4 == false) goto L12;
        return 187;
    L12:
        return 186;
    }

    public static final j b(TimerJob r4, int r5, boolean r6, boolean r7) {
        Object r0 = r4.c;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (r4.f == r5) goto L7;
        j r8 = null;
    L20:
        monitor-exit(r0);
        return r8;
    L7:
        Boolean r9 = r4.e;     // Catch: Throwable -> L22
        if (r9 != null) goto L12;
        if (r7 == false) goto L12;
        boolean r10 = false;
    L13:
        if (r9 != null) goto L16;
        int r1 = r4.d(r6, false);     // Catch: Throwable -> L22
    L19:
        r4.e = Boolean.valueOf(r6);     // Catch: Throwable -> L22
        r8 = new j(r9, r1, r10);     // Catch: Throwable -> L22
        goto L20
    L16:
        if (Intrinsics.areEqual(r9, Boolean.valueOf(r6)) == true) goto L18;
        r1 = r4.d(r6, false);     // Catch: Throwable -> L22
        goto L19
    L18:
        r1 = r4.d(r6, true);     // Catch: Throwable -> L22
    L12:
        r10 = true;
        goto L13
    }
}
