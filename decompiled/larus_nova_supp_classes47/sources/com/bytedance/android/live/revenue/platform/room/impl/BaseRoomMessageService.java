package com.bytedance.android.live.revenue.platform.room.impl;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class BaseRoomMessageService implements yz0.l, yz0.i {
    public static final Observable<tlc.d> j = null;
    public final BehaviorSubject<sh6.b<com.bytedance.android.livesdk.revenue.message.b>> a;
    public final BehaviorSubject<sh6.b<com.bytedance.android.livesdk.revenue.message.d>> b;
    public final BehaviorSubject<sh6.b<com.bytedance.android.livesdk.revenue.message.c>> c;
    public final BehaviorSubject<sh6.b<com.bytedance.android.livesdk.revenue.message.a>> d;
    public final BehaviorSubject<sh6.b<wlc.c>> e;
    public final HashMap<b, Observable<? extends yh6.c>> f;
    public final HashMap<String, Observable<? extends Object>> g;
    public final HashMap<String, Observable<? extends Object>> h;
    public final HashMap<String, Observable<? extends Object>> i;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Class<?> b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Class<?> r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "MessageTypeKey(name=" + this.a + ", type=" + this.b + ")";
        }

        public final Class<?> getType() {
            return this.b;
        }

        public b(String r2, Class<?> r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean test(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.a();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.d r3 = (sh6.b) r2;
            Function1 r0 = this.a;
            if (r3 == null) goto L7;
            r0.invoke(r3.a);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.datacontext.util.Some<T>");
        }
    }

    public void onStart() {
    }

    public void onStop() {
    }

    static {
        com.bytedance.android.live.core.utils.rxutils.j.a r0 = com.bytedance.android.live.core.utils.rxutils.j.a;
        if (r0 == null) goto L7;
        j = RxJavaPlugins.onAssembly(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<T>");
    }

    public BaseRoomMessageService() {
        sh6.a r0 = sh6.a.a;
        this.a = BehaviorSubject.createDefault(r0);
        this.b = BehaviorSubject.createDefault(r0);
        this.c = BehaviorSubject.createDefault(r0);
        this.d = BehaviorSubject.createDefault(r0);
        this.e = BehaviorSubject.createDefault(r0);
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        new HashMap();
        this.i = new HashMap();
    }

    @Override // yz0.l
    public final void J0(final Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Function1<com.bytedance.android.livesdk.revenue.message.c, Unit> r0 = new BaseRoomMessageService$addRtcRoomConnectListener$1(r2);
        Intrinsics.checkNotNullParameter(r0, "action");
        a(this.c, r0);
    }

    @Override // yz0.i
    public final void Lk(Function1<? super com.bytedance.android.livesdk.revenue.message.a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        a(this.d, r2);
    }

    @Override // yz0.l
    public final void f0(final Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Function1<com.bytedance.android.livesdk.revenue.message.c, Unit> r0 = new BaseRoomMessageService$removeRtcRoomConnectListener$1(r2);
        Intrinsics.checkNotNullParameter(r0, "action");
        a(this.c, r0);
    }

    @Override // yz0.l
    public final void h(final vlc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ra(new BaseRoomMessageService$addInterceptor$1(r2));
    }

    @Override // yz0.l
    public final Observable nh(yh6.f r6) {
        Intrinsics.checkNotNullParameter(r6, "desc");
        HashMap<String, Observable<? extends Object>> r0 = this.h;
        String r1 = r6.a;
        Observable<? extends Object> r2 = r0.get(r1);
        if (r2 != null) goto L5;
        String r3 = r6.a;
        Class r7 = r6.getType().getType();
        r2 = this.c.switchMap(new com.bytedance.android.live.revenue.platform.room.impl.d(r7, r3));
        r0.put(r1, r2);
    L5:
        if (r2 == null) goto L9;
        return r2;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<T>");
    }

    @Override // yz0.i
    public final void pe(Function1<? super com.bytedance.android.livesdk.revenue.message.d, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        a(this.b, r2);
    }

    @Override // yz0.i
    public final void ra(Function1<? super com.bytedance.android.livesdk.revenue.message.b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        a(this.a, r2);
    }

    public static void a(BehaviorSubject r2, Function1 r3) {
        sh6.b r0 = (sh6.b) r2.getValue();
        if (r0 == null) goto L5;
        Object r1 = sh6.c.b(r0);
    L6:
        if (r1 == null) goto L9;
        r3.invoke(r1);
        return;
    L9:
        if (r2.hasComplete() == false) goto L11;
        return;
    L11:
        if (r2.hasThrowable() == true) goto L17;
        r2.filter(c.a).take(1).subscribe(new d(r3));
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // yz0.l
    public final Observable Dm(yh6.f r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "desc");
        HashMap<String, Observable<? extends Object>> r7 = this.i;
        String r0 = r5.a;
        Observable<? extends Object> r1 = r7.get(r0);
        if (r1 != null) goto L5;
        String r2 = r5.a;
        Class r8 = r5.getType().getType();
        r1 = this.e.switchMap(new f(r8, r2));
        r7.put(r0, r1);
    L5:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<T>");
    }

    @Override // yz0.l, yz0.f
    public void insert(final yh6.c r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        ra(new AnonymousClass1(r2, r3));
    }

    @Override // yz0.h
    public final <T extends yh6.c> Observable<T> S4(yh6.b<T> r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "desc");
        HashMap<b, Observable<? extends yh6.c>> r0 = this.f;
        b r1 = new b(r6.getName(), r6.getType().getType());
        Object r2 = r0.get(r1);
        if (r2 != null) goto L5;
        String r3 = r6.getName();
        Class r9 = r6.getType().getType();
        r2 = this.a.switchMap(new com.bytedance.android.live.revenue.platform.room.impl.b(r9, r3, r7, r8));
        r0.put(r1, (Observable<? extends yh6.c>) r2);
    L5:
        if (r2 == null) goto L9;
        return (Observable) r2;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<T>");
    }
}
