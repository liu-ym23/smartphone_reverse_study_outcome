package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.dislike.preload.loader.watchlater.LongPanelControlApi;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ n a;

        public a(n r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.a r5 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.b) r4).data;
            if (r5 == null) goto L6;
            String r0 = r5.toast;
            if (r0 == null) goto L6;
        L8:
            if (r0.length() <= 0) goto L10;
            boolean r1 = true;
        L11:
            if (r1 == false) goto L13;
            f2.c(r0, 0);
        L13:
            if (r5 == null) goto L16;
            this.a.c.invoke(r5);
            return;
        L16:
            return;
        L10:
            r1 = false;
        L6:
            r0 = "";
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ n a;

        public b(n r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r0 = this.a.e;
            ALogger.e(r0, "接口请求失败", (Throwable) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ n a;

        public c(n r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.c r3 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.d) r2).data;
            if (r3 == null) goto L6;
            this.a.c.invoke(r3);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ n a;

        public d(n r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r0 = this.a.e;
            ALogger.e(r0, "接口请求失败", (Throwable) r3);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.f a;

        public e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.f r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ArrayList r0 = new ArrayList();
            com.bytedance.android.livesdk.dislike.preload.loader.watchlater.b r4 = ((com.bytedance.android.livesdk.dislike.preload.loader.watchlater.c) r3).a();
            if (r4 == null) goto L10;
            List<com.bytedance.android.livesdk.dislike.preload.loader.watchlater.d> r5 = r4.a();
            if (r5 == null) goto L10;
            Iterator<T> r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            r0.add((com.bytedance.android.livesdk.dislike.preload.loader.watchlater.d) r6.next());
        L10:
            this.a.b.invoke(r0);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.f a;

        public f(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.f r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r0 = this.a.d;
            ALogger.e(r0, "接口请求失败", (Throwable) r3);
        }
    }

    public static final void a(n r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        com.bytedance.android.livesdk.service.l.d().getClass();
        LiveWatchLaterApi r0 = (LiveWatchLaterApi) com.bytedance.android.live.network.c.b().e(LiveWatchLaterApi.class);
        if (r0 == null) goto L14;
        Observable<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.b> r1 = r0.addWatchLater(r4.a, r4.b);
        if (r1 == null) goto L15;
        Observable r2 = r1.timeout(5, TimeUnit.SECONDS);
        if (r2 == null) goto L16;
        Observable r3 = r2.compose(RxUtil.rxSchedulerHelper());
        if (r3 == null) goto L17;
        Disposable r5 = r3.subscribe(new a(r4), new b(r4));
        if (r5 == null) goto L18;
        RxUtilKt.c(r5, r4.d);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static final void b(n r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        com.bytedance.android.livesdk.service.l.d().getClass();
        LiveWatchLaterApi r0 = (LiveWatchLaterApi) com.bytedance.android.live.network.c.b().e(LiveWatchLaterApi.class);
        if (r0 == null) goto L14;
        Observable<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.d> r1 = r0.cancelWatchLater(r4.a, r4.b);
        if (r1 == null) goto L15;
        Observable r2 = r1.timeout(5, TimeUnit.SECONDS);
        if (r2 == null) goto L16;
        Observable r3 = r2.compose(RxUtil.rxSchedulerHelper());
        if (r3 == null) goto L17;
        Disposable r5 = r3.subscribe(new c(r4), new d(r4));
        if (r5 == null) goto L18;
        RxUtilKt.c(r5, r4.d);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static final void c(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.f r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        com.bytedance.android.livesdk.service.l.d().getClass();
        LongPanelControlApi r0 = (LongPanelControlApi) com.bytedance.android.live.network.c.b().e(LongPanelControlApi.class);
        if (r0 == null) goto L14;
        Observable<com.bytedance.android.livesdk.dislike.preload.loader.watchlater.c> r1 = r0.requestLongPanelData(r4.a);
        if (r1 == null) goto L15;
        Observable r2 = r1.timeout(5, TimeUnit.SECONDS);
        if (r2 == null) goto L16;
        Observable r3 = r2.compose(RxUtil.rxSchedulerHelper());
        if (r3 == null) goto L17;
        Disposable r5 = r3.subscribe(new e(r4), new f(r4));
        if (r5 == null) goto L18;
        RxUtilKt.c(r5, r4.c);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
