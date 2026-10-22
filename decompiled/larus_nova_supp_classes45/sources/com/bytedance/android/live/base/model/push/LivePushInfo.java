package com.bytedance.android.live.base.model.push;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LivePushInfo {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.live.base.model.push.b a;
    public final Map<String, String> b;
    public final InnerPushCallback c;
    public final boolean d;

    public static class InnerPushCallback extends b {
        public Function1<? super e, Unit> e;
        public Function1<? super e, Unit> f;
        public Function1<? super e, Unit> g;
        public Function2<? super e, ? super Boolean, Unit> h;

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final Function1<e, Unit> a() {
            return this.e;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final Function1<e, Unit> b() {
            return this.g;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final Function2<e, Boolean, Unit> c() {
            return this.h;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final Function1<e, Unit> d() {
            return this.f;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final void e(Function1<? super e, Unit> r1) {
            this.e = r1;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final void f(Function1<? super e, Unit> r1) {
            this.g = r1;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final void g(Function2<? super e, ? super Boolean, Unit> r1) {
            this.h = r1;
        }

        @Override // com.bytedance.android.live.base.model.push.LivePushInfo.b
        public final void h(Function1<? super e, Unit> r1) {
            this.f = r1;
        }

        public InnerPushCallback(final b r2, final f r3) {
            this.e = new LivePushInfo$InnerPushCallback$onCountdownFinish$1(r2);
            this.f = new LivePushInfo$InnerPushCallback$onPushShow$1(r2, r3);
            this.g = new LivePushInfo$InnerPushCallback$onPushClick$1(r2, r3);
            this.h = new LivePushInfo$InnerPushCallback$onPushDismiss$1(r2);
        }
    }

    public static final class a {
        public Function1<? super b, Unit> a;
        public Function1<? super f, Unit> b;
        public final Map<String, String> c;
        public boolean d;
        public final com.bytedance.android.live.base.model.push.b e;

        public a(com.bytedance.android.live.base.model.push.b r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.e = r2;
            LivePushViewStyle r3 = LivePushViewStyle.Normal;
            this.c = new LinkedHashMap();
        }

        public final void a(Pair... r6) {
            Intrinsics.checkNotNullParameter(r6, "pairs");
            int r0 = r6.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            Pair r2 = r6[r1];
            String r3 = (String) r2.getFirst();
            Object r4 = r2.getSecond();
            Intrinsics.checkNotNullParameter(r3, "key");
            this.c.put(r3, String.valueOf(r4));
            r1 = r1 + 1;
            goto L3
        }

        public final void b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.a = r2;
        }

        public final void c(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            this.b = r2;
        }
    }

    public static class b {
        public Function1<? super e, Unit> a;
        public Function1<? super e, Unit> b;
        public Function2<? super e, ? super Boolean, Unit> c;
        public Function1<? super e, Unit> d;

        public b() {
        }

        public Function1<e, Unit> a() {
            return this.d;
        }

        public Function1<e, Unit> b() {
            return this.b;
        }

        public Function2<e, Boolean, Unit> c() {
            return this.c;
        }

        public Function1<e, Unit> d() {
            return this.a;
        }

        public void e(Function1<? super e, Unit> r1) {
            this.d = r1;
        }

        public void f(Function1<? super e, Unit> r1) {
            this.b = r1;
        }

        public void g(Function2<? super e, ? super Boolean, Unit> r1) {
            this.c = r1;
        }

        public void h(Function1<? super e, Unit> r1) {
            this.a = r1;
        }
    }

    public static final class c {
        public static a a(com.bytedance.android.live.base.model.push.b r1) {
            Intrinsics.checkNotNullParameter(r1, "pushMsg");
            return new a(r1);
        }
    }

    public interface d {
        void dismiss();
    }

    public interface e {
        cv1.a getController();

        LivePushInfo getPushInfo();
    }

    public static class f {
        public Function1<? super LivePushInfo, Unit> a;
        public Function1<? super LivePushInfo, Unit> b;

        public f() {
        }
    }

    static {
    }

    public LivePushInfo(a r4) {
        this.a = r4.e;
        this.b = r4.c;
        Function1<? super f, Unit> r0 = r4.b;
        b r1 = null;
        if (r0 == null) goto L5;
        f r2 = new f();
        r0.invoke(r2);
    L6:
        Function1<? super b, Unit> r3 = r4.a;
        if (r3 == null) goto L9;
        r1 = new b();
        r3.invoke(r1);
    L9:
        this.c = new InnerPushCallback(r1, r2);
        this.d = r4.d;
        return;
    L5:
        r2 = null;
        goto L6
    }
}
