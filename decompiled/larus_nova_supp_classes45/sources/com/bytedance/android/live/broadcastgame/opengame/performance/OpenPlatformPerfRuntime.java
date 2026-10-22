package com.bytedance.android.live.broadcastgame.opengame.performance;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.opengame.message.c0;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ad1;
import com.bytedance.android.livesdk.config.ge0;
import com.bytedance.android.livesdk.utils.z1;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPlatformPerfRuntime implements z1 {
    public static final /* synthetic */ int n = 0;
    public final Lazy a;
    public Disposable b;
    public final Lazy c;
    public final Lazy d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public volatile boolean i;
    public boolean j;
    public final long k;
    public final Context l;
    public final c0 m;

    public static final class a {
    }

    static {
    }

    public final c a() {
        return (c) this.c.getValue();
    }

    public final void d() {
        UtilityKotlinExtentionsKt.s(0, false, false, OpenPlatformPerfRuntime$stopUploadData$1.INSTANCE, 7);
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r0 = AnchorGameContext.a.a();
        if (r0 == null) goto L7;
        m<Boolean> r1 = r0.getOpenGamePerfUploadState();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.FALSE);
    L7:
        this.i = false;
        Disposable r2 = this.b;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNullParameter(r2, "d");
        ((CompositeDisposable) this.a.getValue()).remove(r2);
    L10:
        this.e = "invalid";
    }

    public final Context getContext() {
        return this.l;
    }

    public final void V1(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        ((CompositeDisposable) this.a.getValue()).add(r2);
    }

    public final void c(int r8) {
        if (this.h == true) goto L6;
        return;
    L6:
        if (r8 != 1) goto L8;
        UtilityKotlinExtentionsKt.s(0, false, false, OpenPlatformPerfRuntime$stopPerfCollectAndReport$1.INSTANCE, 7);
        d();
        return;
    L8:
        if (r8 != 2) goto L10;
        c r9 = a();
        Function1<Integer, Unit> r1 = new OpenPlatformPerfRuntime$stopPerfTestBySwitch$1(this);
        Function2<Integer, Long, Unit> r2 = new OpenPlatformPerfRuntime$stopPerfTestBySwitch$2(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "onCanStop");
        Intrinsics.checkNotNullParameter(r2, "onCannotStop");
        boolean r4 = false;
        if (r9.a.length() != 0) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L23;
    L28:
        r1.invoke(1);
        ALogger.d("OpenPlatformPerfReporter", "appId: " + r9.a + " or taskId: " + r9.b + " is empty!!");
        return;
    L23:
        if (r9.b.length() != 0) goto L25;
        r4 = true;
    L25:
        if (r4 == true) goto L28;
        Lazy r0 = LiveOpenGameClient.d;
        r9.V1(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).checkPerfTestStatus(r9.a, r9.e, r9.b).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r1, r2), new e(r1)));
        return;
    L20:
        r3 = false;
        goto L21
    L10:
        if (r8 != 3) goto L35;
        Disposable r11 = this.b;
        if (r11 != null) goto L15;
    L16:
        d();
        a().a();
        return;
    L15:
        if (r11.isDisposed() != true) goto L16;
        return;
    }

    public OpenPlatformPerfRuntime(long r2, Context r4, c0 r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.k = r2;
        this.l = r4;
        this.m = r5;
        this.a = LazyKt.lazy(OpenPlatformPerfRuntime$compositeDisposable$2.INSTANCE);
        this.c = LazyKt.lazy(new OpenPlatformPerfRuntime$openPlatformPerfReporter$2(this));
        this.d = LazyKt.lazy(OpenPlatformPerfRuntime$openPlatformPerfDog$2.INSTANCE);
        this.e = "";
        this.f = "";
        this.g = "";
    }

    public final void b(boolean r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "appId");
        Intrinsics.checkNotNullParameter(r13, "taskId");
        Intrinsics.checkNotNullParameter(r14, "appVersion");
        boolean r5 = true;
        if (r11 == true) goto L11;
        LiveMode r8 = null;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L10;
        com.bytedance.live.datacontext.i r7 = r6.getLiveMode();
        if (r7 == null) goto L10;
        r8 = (LiveMode) r7.getValue();
    L10:
        if (r8 == LiveMode.VIDEO) goto L11;
    L19:
        this.e = r13;
        this.f = r12;
        this.g = r14;
        if (r11 == false) goto L52;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r15 = AnchorGameContext.a.a();
        if (r15 == null) goto L27;
        m<Boolean> r16 = r15.isLaunchFromPerfTest();
        if (r16 == null) goto L27;
        r16.setValue(Boolean.TRUE);
    L27:
        if (this.i == false) goto L30;
        f2.c("性能测试中，无法重新启动性能测试", 0);
    L47:
        AnchorGameContext r17 = AnchorGameContext.a.a();
        if (r17 == null) goto L58;
        m<Boolean> r18 = r17.getOpenGamePerfPanel();
        if (r18 == null) goto L59;
        r18.setValue(Boolean.TRUE);
        return;
    L59:
        return;
    L58:
        return;
    L30:
        if (Intrinsics.areEqual(this.e, "invalid") == false) goto L32;
        f2.c("当前性能测试已结束，需要重新启动扫码方可测试！", 0);
        goto L47
    L32:
        this.h = false;
        this.i = true;
        c r19 = a();
        String r110 = this.f;
        String r111 = this.e;
        String r9 = this.g;
        Function0<Unit> r21 = new OpenPlatformPerfRuntime$startPerfCollectAndReport$1(this);
        Function0<Unit> r22 = new OpenPlatformPerfRuntime$startPerfCollectAndReport$2(this);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "taskId");
        Intrinsics.checkNotNullParameter(r9, "appVersion");
        Intrinsics.checkNotNullParameter(r21, "onSuccess");
        Intrinsics.checkNotNullParameter(r22, "onError");
        r19.a = r110;
        r19.b = r111;
        r19.c = r9;
        if (r110.length() != 0) goto L35;
        boolean r0 = true;
    L36:
        if (r0 == false) goto L38;
    L46:
        ALogger.d("OpenPlatformPerfReporter", "appId: " + r110 + " or taskId: " + r111 + " or " + r19.e + " is empty!!");
        r22.invoke();
        goto L47
    L38:
        if (r19.b.length() == 0) goto L41;
        r5 = false;
    L41:
        if (r5 == true) goto L46;
        if (r19.e == 0) goto L46;
        Lazy r112 = LiveOpenGameClient.d;
        r19.V1(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).runPerfTestTask(r19.a, r19.b, r19.e, r19.c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r21), new g(r22)));
        goto L47
    L35:
        r0 = false;
        goto L36
    L52:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r113 = AnchorGameContext.a.a();
        if (r113 == null) goto L61;
        m<Boolean> r114 = r113.isLaunchFromPerfTest();
        if (r114 == null) goto L62;
        r114.setValue(Boolean.FALSE);
        return;
    L62:
        return;
    L61:
        return;
    L11:
        ((OpenPlatformPerfDog) this.d.getValue()).getClass();
        Disposable r23 = OpenPlatformPerfDog.o;
        if (r23 != null) goto L14;
    L15:
        Disposable r24 = OpenPlatformPerfDog.o;
        if (r24 == null) goto L18;
        r24.dispose();
    L18:
        OpenPlatformPerfDog.o = Observable.interval(((ad1) ge0.a.getValue()).d(), TimeUnit.SECONDS).observeOn(Schedulers.computation()).subscribe(com.bytedance.android.live.broadcastgame.opengame.performance.a.a, b.a);
        goto L19
    L14:
        if (r23.isDisposed() == true) goto L18;
        goto L15
    }
}
