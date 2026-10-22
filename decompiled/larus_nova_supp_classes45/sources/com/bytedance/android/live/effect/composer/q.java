package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q {
    public Disposable a;
    public boolean b;
    public final Long c;
    public final CompositeDisposable d;
    public final com.bytedance.android.live.effect.base.e e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ q a;

        public b(q r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            q r4 = this.a;
            if ((!r4.b) == false) goto L6;
            r4.e(10001);
            return;
        }
    }

    static {
    }

    public final boolean a() {
        return !this.b;
    }

    public final void b() {
        if ((!this.b) == false) goto L8;
        this.e.i = System.currentTimeMillis();
        Disposable r0 = Observable.timer(LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG_TIME_OUT_DURATION.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        this.a = r0;
        if (r0 == null) goto L9;
        this.d.add(r0);
        return;
    L9:
        return;
    }

    public final void d() {
        if ((!this.b) == false) goto L9;
        Disposable r0 = this.a;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        e(10003);
        return;
    }

    public final void c(long r2) {
        if ((!this.b) == false) goto L9;
        Disposable r0 = this.a;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        this.e.k = r2;
        e(10002);
        return;
    }

    public final void e(int r12) {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = true;
        PthreadHandlerThreadV2 r1 = LiveEffectMonitor.a;
        LiveEffectMonitor.m(this.f, this.g, r12, "", "", "", "normal", this.h, this.e.d);
        Pair[] r2 = new Pair[12];
        r2[0] = TuplesKt.to("status_code", String.valueOf(r12));
        Sticker r13 = this.e.b;
        Integer r3 = null;
        if (r13 == null) goto L8;
        Long r14 = Long.valueOf(r13.getId());
    L9:
        r2[1] = TuplesKt.to("sticker_id", String.valueOf(r14));
        r2[2] = TuplesKt.to("panel", this.e.c);
        RenderTriggerType r15 = this.e.d;
        if (r15 == null) goto L12;
        r3 = Integer.valueOf(r15.getCode());
    L12:
        r2[3] = TuplesKt.to("trigger_type", String.valueOf(r3));
        if (this.e.e == false) goto L15;
        String r16 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L16:
        r2[4] = TuplesKt.to("hit_download_cache", r16);
        com.bytedance.android.live.effect.base.e r17 = this.e;
        long r4 = r17.g - r17.f;
        long r5 = r17.i;
        r2[5] = TuplesKt.to("total_duration", String.valueOf((r4 + (r5 - r17.h)) + (r17.j - r5)));
        com.bytedance.android.live.effect.base.e r18 = this.e;
        r2[6] = TuplesKt.to("download_duration", String.valueOf(r18.g - r18.f));
        com.bytedance.android.live.effect.base.e r19 = this.e;
        r2[7] = TuplesKt.to("first_frame_duration", String.valueOf(r19.j - r19.i));
        com.bytedance.android.live.effect.base.e r110 = this.e;
        r2[8] = TuplesKt.to("live_handle_duration", String.valueOf(r110.i - r110.h));
        com.bytedance.android.live.effect.base.e r111 = this.e;
        r2[9] = TuplesKt.to("tryout_duration", String.valueOf(r111.h - r111.g));
        com.bytedance.android.live.effect.base.e r112 = this.e;
        r2[10] = TuplesKt.to("override_time_gap", String.valueOf(r112.k - r112.i));
        r2[11] = TuplesKt.to("timeout_duration", String.valueOf(this.c.longValue()));
        HashMap r113 = MapsKt.hashMapOf(r2);
        int r6 = com.bytedance.android.live.effect.utils.m.a;
        com.bytedance.android.live.effect.utils.m.a(r113, this.i);
        return;
    L15:
        r16 = "0";
        goto L16
    L8:
        r14 = null;
        goto L9
    }

    public q(CompositeDisposable r3, com.bytedance.android.live.effect.base.e r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "compositeDisposable");
        Intrinsics.checkNotNullParameter(r4, "traceInfo");
        Intrinsics.checkNotNullParameter(r5, "reason");
        Intrinsics.checkNotNullParameter(r6, "trace");
        Intrinsics.checkNotNullParameter("", "curList");
        Intrinsics.checkNotNullParameter("", "addList");
        Intrinsics.checkNotNullParameter("", "removeList");
        Intrinsics.checkNotNullParameter(r7, "extraLog");
        Intrinsics.checkNotNullParameter(r8, "eventPage");
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.c = LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG_TIME_OUT_DURATION.getValue();
    }
}
