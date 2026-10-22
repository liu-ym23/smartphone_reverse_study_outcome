package com.bytedance.android.live.room.api.messagewindow.builder.card;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CommonCardBuilder implements u61.b {
    public int a;
    public Function1<? super d, Unit> b;
    public Function1<? super b, Unit> c;
    public Function1<? super a, Unit> d;
    public Function1<? super c, Unit> e;

    public static final class a {
        public Function1<? super CardAnimType, Unit> a;
        public Function1<? super CardAnimType, Unit> b;

        public a() {
        }
    }

    public static final class b {
        public Function1<? super p71.a, Unit> a;

        public b() {
        }
    }

    public static final class c {
        public Function1<? super b71.a, Unit> a;

        public c() {
        }
    }

    public static final class d {
        public Function0<Unit> a;
        public Function0<Unit> b;
        public Function0<Unit> c;
        public Function0<Unit> d;
        public Function0<Unit> e;

        public d() {
        }
    }

    public final com.bytedance.android.live.room.api.messagewindow.builder.card.c b() {
        if (this.a != 0) goto L5;
        ALogger.e("CommonCardBuilder", "the value of type can't be 0");
    L5:
        int r2 = this.a;
        b r3 = new b();
        this.c.invoke(r3);
        a r4 = new a();
        this.d.invoke(r4);
        d r5 = new d();
        this.b.invoke(r5);
        c r6 = new c();
        this.e.invoke(r6);
        return new com.bytedance.android.live.room.api.messagewindow.builder.card.c(new com.bytedance.android.live.room.api.messagewindow.builder.card.b(r2, r3, r4, r5, r6));
    }

    public CommonCardBuilder() {
        this.b = CommonCardBuilder$lifeCycleCallback$1.INSTANCE;
        this.c = CommonCardBuilder$failCallback$1.INSTANCE;
        this.d = CommonCardBuilder$animCallback$1.INSTANCE;
        this.e = CommonCardBuilder$hideReasonCallback$1.INSTANCE;
    }

    @Override // u61.b
    public final CommonCardBuilder a(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "init");
        r2.invoke(this);
        return this;
    }

    public final void c(Function1<? super b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.c = r2;
    }
}
