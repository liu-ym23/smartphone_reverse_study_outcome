package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livehostapi.business.IHostCheckLive;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.live.listprovider.DrawRoomListProvider;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.model.LiveInnerCheckLiveConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExecutor;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExtKt;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.platform.bytelink.data.idl.TenantPublishers;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveInnerFeedHelper {
    public long a;
    public long b;
    public long c;
    public long d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final int h;
    public final int i;
    public DrawRoomListProvider j;
    public LiveVerticalViewPager k;
    public final Handler l;
    public final Lazy m;
    public final b n;
    public final a o;

    public static final class a implements Runnable {
        public final /* synthetic */ LiveInnerFeedHelper a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.utils.LiveInnerFeedHelper$a$a, reason: collision with other inner class name */
        public static final class RunnableC0031a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0031a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveInnerFeedHelper.i(this.a.a, 2);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(LiveInnerFeedHelper r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L4
            TTExecutors.getNormalExecutor().submit(new RunnableC0031a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LiveInnerFeedHelper a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveInnerFeedHelper.i(this.a.a, 1);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(LiveInnerFeedHelper r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L4
            TTExecutors.getNormalExecutor().submit(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final IHostCheckLive c() {
        return (IHostCheckLive) this.m.getValue();
    }

    public final boolean a() {
        if (((LiveInnerCheckLiveConfig) com.bytedance.android.livesdk.x0.a.getValue()).getHotUpdateEnable() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.e == false) goto L9;
        if (this.f == true) goto L9;
        return true;
    }

    public LiveInnerFeedHelper() {
        com.bytedance.android.livesdk.x0 r0 = com.bytedance.android.livesdk.x0.a;
        this.h = ((LiveInnerCheckLiveConfig) r0.getValue()).getHotUpdateInterval();
        this.i = ((LiveInnerCheckLiveConfig) r0.getValue()).getHotUpdateType();
        this.l = new Handler(Looper.getMainLooper());
        this.m = LazyKt.lazy(LiveInnerFeedHelper$checkLive$2.INSTANCE);
        this.n = new b(this);
        this.o = new a(this);
    }

    public final void b() {
        if (a() == true) goto L5;
        return;
    L5:
        this.l.removeCallbacks(this.o);
        long r0 = ((long) this.h) * 60000;
        long r2 = this.c;
        if (r0 > r2) goto L8;
        this.l.post(this.o);
        return;
    L8:
        this.l.postDelayed(this.o, r0 - r2);
    }

    public final void f() {
        if (a() == true) goto L6;
        return;
    L6:
        if (this.a != 0) goto L8;
        this.a = System.currentTimeMillis();
        this.b = 0;
    L10:
        if (this.d != 0) goto L12;
        this.d = System.currentTimeMillis();
    L13:
        long r0 = this.b;
        long r2 = ((long) this.h) * 60000;
        if (r0 >= r2) goto L20;
        if (this.c >= r2) goto L20;
        g();
        b();
        return;
    L20:
        if (r0 < r2) goto L22;
        h(1, 1, null);
        return;
    L22:
        h(2, 1, null);
        return;
    L12:
        this.c = System.currentTimeMillis() - this.d;
        goto L13
    L8:
        this.b = System.currentTimeMillis() - this.a;
        goto L10
    }

    public final void g() {
        if (a() == true) goto L5;
        return;
    L5:
        this.l.removeCallbacks(this.n);
        long r0 = ((long) this.h) * 60000;
        long r2 = this.b;
        if (r0 > r2) goto L8;
        this.l.post(this.n);
        return;
    L8:
        this.l.postDelayed(this.n, r0 - r2);
    }

    public static /* synthetic */ void i(LiveInnerFeedHelper r2, int r3) {
        r2.h(r3, 1, null);
    }

    public final void d(final TenantPublishers r3, final ti1.a.f r4) {
        final String r1 = "inner_feed";
        Intrinsics.checkNotNullParameter("inner_feed", "scene");
        Intrinsics.checkNotNullParameter(r3, "publishers");
        Intrinsics.checkNotNullParameter(r4, "callback");
        final Function0<Unit> r0 = new LiveInnerFeedHelper$registerPublisher$reportFunction$1(this, r1, r3, r4);
        AtlasAsyncExtKt.executeTask(AtlasAsyncExecutor.INSTANCE, "LiveInnerFeedHelper", new b1(r0), new LiveInnerFeedHelper$registerPublisher$2(r0));
    }

    public final void e(final String r3, final List r4) {
        final String r1 = "inner_feed";
        Intrinsics.checkNotNullParameter("inner_feed", "scene");
        Intrinsics.checkNotNullParameter(r3, "reason");
        Intrinsics.checkNotNullParameter(r4, "params");
        final Function0<Unit> r0 = new LiveInnerFeedHelper$registerPublisher$reportFunction$2(this, r1, r3, r4);
        AtlasAsyncExtKt.executeTask(AtlasAsyncExecutor.INSTANCE, "LiveInnerFeedHelper", new c1(r0), new LiveInnerFeedHelper$registerPublisher$4(r0));
    }

    public final void h(int r8, int r9, Long r10) {
        long r0 = System.currentTimeMillis() - this.a;
        long r2 = System.currentTimeMillis() - this.d;
        HashMap r4 = new HashMap();
        r4.put("report_reason", Long.valueOf(r8));
        long r5 = BubbleId.PadCast;
        r4.put("current_feed_stay_time", Long.valueOf(r0 / r5));
        r4.put("feed_refresh_time_gap", Long.valueOf(r2 / r5));
        r4.put("check_interval", Long.valueOf(this.h));
        r4.toString();
        this.a = System.currentTimeMillis();
        this.b = 0;
        this.c = 0;
        this.d = System.currentTimeMillis();
        LiveVerticalViewPager r11 = this.k;
        if (r11 == null) goto L7;
        DrawRoomListProvider r1 = this.j;
        if (r1 == null) goto L7;
        r1.autoLoadMore(r11.getCurrentItem(), this.i, r9, r10);
    L7:
        g();
        b();
    }
}
