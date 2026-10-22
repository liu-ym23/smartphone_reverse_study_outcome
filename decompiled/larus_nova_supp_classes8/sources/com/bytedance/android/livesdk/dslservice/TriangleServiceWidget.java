package com.bytedance.android.livesdk.dslservice;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.dslservice.gecko.GeckoUtils;
import com.bytedance.android.livesdk.dslservice.slice.cache.f;
import com.bytedance.android.livesdk.dslservice.util.k;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import dt2.e;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yt1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/TriangleServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TriangleServiceWidget extends LiveWidget {
    public k a;
    public final ArrayList<du1.a> b;
    public String c;
    public final Lazy d;

    public static final class a implements du1.a {
        public final /* synthetic */ TriangleServiceWidget a;

        @Override // du1.a
        public final boolean a() {
            return y3.m(((Widget) this.a).dataCenter).n(ToolbarButton.COMMERCE);
        }

        public a(TriangleServiceWidget r1) {
            this.a = r1;
        }

        @Override // du1.a
        public final void preLoad(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            q r0 = iv1.a.a(((Widget) this.a).dataCenter, 2);
            if (r0 == null) goto L10;
            j r1 = r0.E1();
            if (r1 == null) goto L11;
            n r2 = (n) r1.getValue();
            if (r2 == null) goto L12;
            r2.g(r3);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TriangleServiceWidget a;

        public b(TriangleServiceWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TriangleServiceWidget.wq(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TriangleServiceWidget a;

        public c(TriangleServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            TriangleServiceWidget.wq(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ TriangleServiceWidget a;

        public d(TriangleServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.dslservice.util.a.d.h("livesdk_dsl_low_memory_clear_log", MapsKt.mapOf(new Pair[]{TuplesKt.to("level", String.valueOf(((Integer) r3).intValue())), TuplesKt.to("score", (String) this.a.d.getValue())}));
            f.a.b().evictAll();
            f.b.b().evictAll();
            cu1.a.b.b().evictAll();
            SlcRenderContext r4 = com.bytedance.android.livesdk.dslservice.slice.cache.b.a;
            if (r4 == null) goto L5;
            r4.d();
        L5:
            com.bytedance.android.livesdk.dslservice.slice.cache.b.a = null;
        }
    }

    public TriangleServiceWidget() {
        this.b = new ArrayList();
        this.d = LazyKt.lazy(TriangleServiceWidget$score$2.INSTANCE);
    }

    public final void onCreate() {
        super.onCreate();
        this.b.add(new a(this));
        int r0 = Build.VERSION.SDK_INT;
        String r1 = null;
        if (r0 < 23) goto L16;
        Integer r3 = (Integer) e.a.getValue();
        if (r3 == null) goto L16;
        if (r3.intValue() != 1) goto L16;
        k r4 = new k(new b(this));
        if (r0 >= 23) goto L12;
    L14:
        r4 = null;
    L15:
        this.a = r4;
    L17:
        com.bytedance.android.livesdk.dslservice.util.c r2 = com.bytedance.android.livesdk.dslservice.util.c.b;
        d r5 = new d(this);
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.bytedance.android.livesdk.dslservice.util.c.a = r5;
        jc1.a.b().registerComponentCallbacks(r2);
        q r6 = iv1.a.a(((Widget) this).dataCenter, 2);
        if (r6 == null) goto L24;
        j r7 = r6.G1();
        if (r7 == null) goto L24;
        zt1.c r8 = (zt1.c) r7.getValue();
        if (r8 == null) goto L24;
        r8.b();
    L24:
        m r9 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), ((Widget) this).dataCenter, 0, 2).getRoom();
        if (r9 == null) goto L29;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L29;
        r1 = r10.getIdStr();
    L29:
        this.c = r1;
        return;
    L12:
        if (r4.a == true) goto L14;
        r4.a = true;
        ALogger.i("IdleTaskHandler", "start");
        Looper.getMainLooper().getQueue().removeIdleHandler((MessageQueue.IdleHandler) r4.c.getValue());
        Looper.getMainLooper().getQueue().addIdleHandler((MessageQueue.IdleHandler) r4.c.getValue());
    L16:
        ((ObservableSubscribeProxy) Observable.timer(6, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new c(this));
        goto L17
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.dslservice.util.c r0 = com.bytedance.android.livesdk.dslservice.util.c.b;
        com.bytedance.android.livesdk.dslservice.util.c.a = null;
        jc1.a.b().unregisterComponentCallbacks(r0);
        k r1 = this.a;
        if (r1 != null) goto L5;
    L9:
        GeckoUtils.a.clear();
        String r2 = this.c;
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        ALogger.i("TriangleManager", "onDestroy room=".concat(r2));
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (r1.a == false) goto L9;
        r1.a = false;
        Looper.getMainLooper().getQueue().removeIdleHandler((MessageQueue.IdleHandler) r1.c.getValue());
        goto L9
    }

    public static final void wq(TriangleServiceWidget r3) {
        Iterator<du1.a> r0 = r3.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        du1.a r1 = r0.next();
        if (r1.a() == false) goto L4;
        r1.preLoad(((Widget) r3).context);
        goto L4
    }
}
