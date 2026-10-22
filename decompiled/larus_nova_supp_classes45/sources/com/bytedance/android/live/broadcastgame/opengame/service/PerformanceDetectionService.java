package com.bytedance.android.live.broadcastgame.opengame.service;

import androidx.collection.LruCache;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.opengame.message.c0;
import com.bytedance.android.live.broadcastgame.opengame.message.j0;
import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfRuntime;
import com.bytedance.android.live.broadcastgame.opengame.performance.j;
import com.bytedance.android.live.broadcastgame.opengame.performance.l;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.o;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/PerformanceDetectionService;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/o;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PerformanceDetectionService implements y10.a, p, o {
    public OpenPlatformPerfRuntime a;
    public final PluginContext b;

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void e() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void f() {
        t r0 = this.b.m;
        OpenPlatformPerfRuntime r1 = this.a;
        if (r1 == null) goto L20;
        String r2 = r0.n;
        Intrinsics.checkNotNullParameter(r2, "$this$isNeedPerformance");
        LruCache r3 = LiveSchemaInfo.r;
        LiveSchemaInfo r4 = LiveSchemaInfo.c.a(r2);
        if (r4 == null) goto L7;
        String r5 = r4.b("needPerformance");
    L8:
        boolean r6 = Intrinsics.areEqual(r5, GamePromoteDataContext.GAME_TYPE_MOBILE);
        String r7 = r0.i;
        String r8 = r0.n;
        Intrinsics.checkNotNullParameter(r8, "$this$getPerfTaskId");
        LiveSchemaInfo r9 = LiveSchemaInfo.c.a(r8);
        if (r9 == null) goto L12;
        String r11 = r9.b("report_id");
        if (r11 == null) goto L12;
    L13:
        String r12 = r0.n;
        Intrinsics.checkNotNullParameter(r12, "$this$getLiveAppVersion");
        LiveSchemaInfo r13 = LiveSchemaInfo.c.a(r12);
        if (r13 == null) goto L17;
        String r14 = r13.b("live_app_version");
        if (r14 == null) goto L17;
    L18:
        r1.b(r6, r7, r11, r14);
        return;
    L17:
        r14 = "0.0";
    L12:
        r11 = "";
        goto L13
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
        OpenPlatformPerfDog.p.getClass();
        OpenPlatformPerfDog.g = false;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        if (this.a != null) goto L23;
        PluginContext r1 = this.b;
        OpenPlatformPerfRuntime r0 = new OpenPlatformPerfRuntime(r1.m.a, r1.getContext(), this.b.l);
        this.a = r0;
        if (r0.j == true) goto L24;
        r0.j = true;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r2 = AnchorGameContext.a.a();
        if (r2 == null) goto L15;
        k<Boolean> r3 = r2.getOpenGamePerfUploadEvent();
        if (r3 == null) goto L15;
        PublishSubject r4 = r3.onEvent();
        if (r4 == null) goto L15;
        Disposable r5 = r4.subscribe(new j(r0));
        if (r5 == null) goto L15;
        Intrinsics.checkNotNullParameter(r5, "$this$autoDispose");
        ((CompositeDisposable) r0.a.getValue()).add(r5);
    L15:
        c0 r6 = r0.m;
        if (r6 == null) goto L25;
        Observable r7 = r6.a(j0.class);
        if (r7 == null) goto L26;
        Disposable r8 = r7.subscribe(new com.bytedance.android.live.broadcastgame.opengame.performance.k(r0), l.a);
        if (r8 == null) goto L27;
        Intrinsics.checkNotNullParameter(r8, "$this$autoDispose");
        ((CompositeDisposable) r0.a.getValue()).add(r8);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        OpenPlatformPerfRuntime r0 = this.a;
        if (r0 == null) goto L22;
        ((OpenPlatformPerfDog) r0.d.getValue()).getClass();
        Disposable r1 = OpenPlatformPerfDog.o;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        com.bytedance.android.livesdk.utils.c r2 = OpenPlatformPerfDog.n;
        ((ArrayList) r2.a).clear();
        OpenPlatformPerfDog.e = 0;
        OpenPlatformPerfDog.m = 0;
        r0.c(3);
        r0.h = false;
        r0.i = false;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r5 = AnchorGameContext.a.a();
        if (r5 == null) goto L12;
        m<Boolean> r6 = r5.isLaunchFromPerfTest();
        if (r6 == null) goto L12;
        r6.setValue(Boolean.FALSE);
    L12:
        AnchorGameContext r7 = AnchorGameContext.a.a();
        if (r7 == null) goto L17;
        m<Boolean> r8 = r7.getOpenGamePerfPanel();
        if (r8 == null) goto L17;
        r8.setValue(Boolean.FALSE);
    L17:
        ((CompositeDisposable) r0.a.getValue()).clear();
        ((OpenPlatformPerfDog) r0.d.getValue()).getClass();
        Disposable r3 = OpenPlatformPerfDog.o;
        if (r3 == null) goto L20;
        r3.dispose();
    L20:
        ((ArrayList) r2.a).clear();
        OpenPlatformPerfDog.e = 0;
        OpenPlatformPerfDog.m = 0;
        return;
    }

    public PerformanceDetectionService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r1) {
        OpenPlatformPerfDog.p.getClass();
        OpenPlatformPerfDog.g = true;
    }
}
