package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements com.bytedance.android.scope.o, yz0.m {
    public final CompositeDisposable a;
    public int b;
    public int c;
    public final String d;
    public final ou0.a e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ k a;

        public b(k r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ALogger.d("ExchangeCountDownService", "onRoomReady: 收到礼物切换事件 giftId=" + ((Long) r3) + "  写入倒计时=" + this.a.b);
            k r4 = this.a;
            r4.f(r4.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ k a;

        public c(k r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Map r10 = (Map) r9;
            ALogger.d("ExchangeCountDownService", "进房请求task_center/entrance接口，返回数据:" + r10);
            if (r10 == null) goto L34;
            String r0 = (String) r10.get("count_down");
            int r1 = 0;
            if (r0 == null) goto L7;
            int r2 = CastIntegerProtector.parseInt(r0);
        L8:
            String r3 = (String) r10.get("reward_times");
            if (r3 == null) goto L11;
            int r4 = CastIntegerProtector.parseInt(r3);
        L12:
            String r12 = (String) r10.get("action_times");
            if (r12 == null) goto L15;
            int r13 = CastIntegerProtector.parseInt(r12);
        L16:
            if (r13 == r4) goto L35;
            k r14 = this.a;
            r14.c = r4;
            Map<String, String> r5 = com.bytedance.android.live.recharge.util.a.i.a();
            if (r5.get("userId") != null) goto L20;
        L23:
            r14.d(r2);
        L25:
            if (r14.c(r5.get("date")) == true) goto L27;
        L31:
            r14.d(r2);
            r1 = r2;
        L32:
            UtilityKotlinExtentionsKt.s(0, false, false, new ExchangeCountDownService$updateCountDown$1(r14, r1, r2), 7);
            return;
        L27:
            if (Intrinsics.areEqual(r5.get("userId"), r14.d) == false) goto L31;
            String r6 = r5.get("countdown");
            if (r6 == null) goto L32;
            r1 = CastIntegerProtector.parseInt(r6);
            goto L32
        L20:
            if (r5.get("countdown") == null) goto L23;
            if (r5.get("date") != null) goto L25;
        L35:
            return;
        L15:
            r13 = 0;
            goto L16
        L11:
            r4 = 0;
            goto L12
        L7:
            r2 = 0;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            ALogger.e("ExchangeCountDownService", "task_center/entrance接口请求失败: " + ((Throwable) r3));
        }
    }

    static {
    }

    public final void onStart() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    public static boolean a() {
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.r.getValue(null, com.bytedance.android.live.recharge.utils.j.a[15])).booleanValue() == false) goto L7;
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final void onStop() {
        this.a.clear();
        f(this.b);
        ALogger.d("ExchangeCountDownService", "onStop: 倒计时Service停止");
    }

    @Override // yz0.m
    public final void i() {
        if (a() == true) goto L5;
        return;
    L5:
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        RxUtilKt.c(com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGiftSelectObservable().subscribe(new b(this)), this.a);
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class).registerJsEventSubscriber("excitation.douyin.dailyWatchTask.boxOpen").observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this)), this.a);
        RxUtilKt.c(this.e.Ql().subscribe(new c(this), d.a), this.a);
    }

    public k(ou0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "goldBoxService");
        this.e = r2;
        this.a = new CompositeDisposable();
        this.c = -1;
        this.d = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
    }

    public final boolean c(String r6) {
        if (r6 == null) goto L8;
        SimpleDateFormat r0 = new SimpleDateFormat("MM-dd");
        Calendar r2 = Calendar.getInstance();
        Calendar r3 = Calendar.getInstance();
        r2.setTime(r0.parse(r6));
        Calendar r7 = Calendar.getInstance();
        r3.setTime(r0.parse(new SimpleDateFormat("MM-dd").format(r7.getTime())));
        if (r2.get(6) != r3.get(6)) goto L8;
        if (r2.get(1) != r3.get(1)) goto L8;
        return true;
    L8:
        return false;
    }

    public final void d(int r5) {
        com.bytedance.android.live.recharge.util.a r0 = com.bytedance.android.live.recharge.util.a.i;
        MapsKt.toMutableMap(r0.a()).clear();
        Map r1 = MapsKt.toMutableMap(r0.a());
        r1.put("userId", this.d);
        r1.put("countdown", String.valueOf(r5));
        Calendar r6 = Calendar.getInstance();
        r1.put("date", new SimpleDateFormat("MM-dd").format(r6.getTime()));
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        com.bytedance.android.live.recharge.util.a.d.setValue(r0, com.bytedance.android.live.recharge.util.a.a[2], r1);
    }

    public final void f(int r6) {
        if (a() == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.recharge.util.a r0 = com.bytedance.android.live.recharge.util.a.i;
        Map r1 = MapsKt.toMutableMap(r0.a());
        if (c((String) r1.get("date")) == true) goto L8;
    L10:
        d(r6);
    L11:
        ALogger.d("ExchangeCountDownService", "updateSpCountDown: 缓存写入完毕，当前倒计时=" + r6 + "  缓存内容=" + r0.a());
        return;
    L8:
        if (Intrinsics.areEqual((String) r1.get("userId"), this.d) == false) goto L10;
        r1.put("countdown", String.valueOf(r6));
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        com.bytedance.android.live.recharge.util.a.d.setValue(r0, com.bytedance.android.live.recharge.util.a.a[2], r1);
        goto L11
    }
}
