package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.ktv.common.model.api.p0;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.utils.d5;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b {
        public static final g a = null;

        static {
            a = new g();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public c(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.a r7 = (com.bytedance.android.live.network.response.a) r6;
            mb0.d.b(LinkMonitorData.ApiAddFavorite, System.currentTimeMillis() - this.a, ((ExtraResponse) r7).logId);
            this.b.invoke(r7);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public d(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            mb0.d.a(LinkMonitorData.ApiAddFavorite, System.currentTimeMillis() - this.a, r7);
            ExceptionUtils.handleException(s1.getContext(), r7);
            this.b.invoke(r7);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public e(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            mb0.d.b(LinkMonitorData.ApiAddSong, System.currentTimeMillis() - this.a, ((ExtraResponse) r7).logId);
            this.b.invoke(r7);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public f(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            mb0.d.a(LinkMonitorData.ApiAddSong, System.currentTimeMillis() - this.a, r7);
            this.b.invoke(r7);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.karaokestation.model.g$g, reason: collision with other inner class name */
    public static final class C0206g<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public C0206g(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.a r7 = (com.bytedance.android.live.network.response.a) r6;
            mb0.d.b(LinkMonitorData.ApiDelFavorite, System.currentTimeMillis() - this.a, ((ExtraResponse) r7).logId);
            this.b.invoke(r7);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public h(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            mb0.d.a(LinkMonitorData.ApiDelFavorite, System.currentTimeMillis() - this.a, r7);
            ExceptionUtils.handleException(s1.getContext(), r7);
            this.b.invoke(r7);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public i(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            mb0.d.b(LinkMonitorData.ApiGetTabList, System.currentTimeMillis() - this.a, ((ExtraResponse) r7).logId);
            this.b.invoke(r7);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public j(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            mb0.d.a(LinkMonitorData.ApiGetTabList, System.currentTimeMillis() - this.a, r7);
            ExceptionUtils.handleException(s1.getContext(), r7);
            this.b.invoke(r7);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public k(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.a r7 = (com.bytedance.android.live.network.response.a) r6;
            mb0.d.b(LinkMonitorData.ApiRemoveSong, System.currentTimeMillis() - this.a, ((ExtraResponse) r7).logId);
            this.b.invoke(r7);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public l(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            mb0.d.a(LinkMonitorData.ApiRemoveSong, System.currentTimeMillis() - this.a, r7);
            ExceptionUtils.handleException(s1.getContext(), r7);
            this.b.invoke(r7);
        }
    }

    static {
    }

    public g() {
    }

    public final Disposable a(long r3, long r5, int r7, Function1<? super com.bytedance.android.live.network.response.a, Unit> r8, Function1<? super Throwable, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "successCallback");
        Intrinsics.checkNotNullParameter(r9, "failCallback");
        return ((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).addFavorite(r5, r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r3, r8), new d(r3, r9));
    }

    public final Disposable c(long r3, long r5, int r7, Function1<? super com.bytedance.android.live.network.response.a, Unit> r8, Function1<? super Throwable, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "successCallback");
        Intrinsics.checkNotNullParameter(r9, "failCallback");
        return ((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).delFavorite(r5, r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0206g(r3, r8), new h(r3, r9));
    }

    public final Disposable d(long r3, long r5, Integer r7, int r8, Function1<? super com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.m>, Unit> r9, Function1<? super Throwable, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "successCallback");
        Intrinsics.checkNotNullParameter(r11, "failCallback");
        KtvCommonApi r0 = (KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class);
        if (r0 == null) goto L9;
        Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.m>> r6 = r0.getTabList(r5, r7, r8);
        if (r6 == null) goto L9;
        Observable r12 = r6.compose(RxUtil.rxSchedulerHelper());
        if (r12 == null) goto L9;
        return r12.subscribe(new i(r3, r9), new j(r3, r11));
    L9:
        return null;
    }

    public final Disposable e(long r19, long r21, long r23, long r25, String r27, boolean r28, int r29, int r31, Function1<? super com.bytedance.android.live.network.response.a, Unit> r32, Function1<? super Throwable, Unit> r33) {
        Intrinsics.checkNotNullParameter(r27, "toUserId");
        Intrinsics.checkNotNullParameter(r32, "successCallback");
        Intrinsics.checkNotNullParameter(r33, "failCallback");
        KtvCommonApi r5 = (KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class);
        if (r5 == null) goto L9;
        Observable<com.bytedance.android.live.network.response.a> r4 = r5.removeSong(r21, r23, r25, d5.c(r27), r27, r28, r29, r31);
        if (r4 == null) goto L9;
        Observable r6 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r6 == null) goto L9;
        return r6.subscribe(new k(r19, r32), new l(r19, r33));
    L9:
        return null;
    }

    public final Disposable b(long r18, long r21, long r22, long r24, int r26, String r27, String r28, String r29, String r31, Function1<? super com.bytedance.android.live.network.response.e<p0>, Unit> r32, Function1<? super Throwable, Unit> r33) {
        Intrinsics.checkNotNullParameter(r27, "addSongSource");
        Intrinsics.checkNotNullParameter(r28, "artistIds");
        Intrinsics.checkNotNullParameter(r29, "coldStartSongSource");
        Intrinsics.checkNotNullParameter(r32, "successCallback");
        Intrinsics.checkNotNullParameter(r33, "failCallback");
        KtvCommonApi r5 = (KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class);
        if (r5 == null) goto L9;
        Observable<com.bytedance.android.live.network.response.e<p0>> r4 = r5.addSong(r21, r22, r24, r26, r27, r28, r29, r31);
        if (r4 == null) goto L9;
        Observable r6 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r6 == null) goto L9;
        return r6.subscribe(new e(r18, r32), new f(r18, r33));
    L9:
        return null;
    }
}
