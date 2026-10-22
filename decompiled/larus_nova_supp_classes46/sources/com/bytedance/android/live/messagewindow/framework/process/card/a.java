package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements h71.f<com.bytedance.android.live.messagewindow.framework.process.a> {
    public h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> a;
    public final PropertyOwner<c> b;
    public final PropertyOwner c;
    public Disposable d;

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.card.a$a, reason: collision with other inner class name */
    public static final class C0131a {
    }

    public static final class b {
        public final Map<String, String> a;
        public final Map<String, String> b;
        public p71.a c;

        /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.card.a$b$a, reason: collision with other inner class name */
        public static final class C0132a {
        }

        static {
            new b();
        }

        public b() {
            LinkedHashMap r0 = new LinkedHashMap();
            this.a = r0;
            this.b = r0;
        }

        public final void a(Pair... r2) {
            Intrinsics.checkNotNullParameter(r2, "pairs");
            MapsKt.putAll(this.a, r2);
        }
    }

    public static abstract class c {
        public final int a;

        /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.card.a$c$a, reason: collision with other inner class name */
        public static final class C0133a extends c {
            public static final C0133a b = null;

            public C0133a() {
                super(3);
            }

            static {
                b = new C0133a();
            }
        }

        public static final class b extends c {
            public static final b b = null;

            public b() {
                super(2);
            }

            static {
                b = new b();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.card.a$c$c, reason: collision with other inner class name */
        public static final class C0134c extends f {
            public final b c;

            @Override // com.bytedance.android.live.messagewindow.framework.process.card.a.c.f
            public final b a() {
                return this.c;
            }

            public C0134c(b r2) {
                Intrinsics.checkNotNullParameter(r2, "payload");
                super(r2);
                this.c = r2;
            }
        }

        public static final class d extends c {
            public static final d b = null;

            public d() {
                super(-1);
            }

            static {
                b = new d();
            }
        }

        public static final class e extends c {
            public static final e b = null;

            public e() {
                super(1);
            }

            static {
                b = new e();
            }
        }

        public static class f extends c {
            public final b b;

            public b a() {
                return this.b;
            }

            public f(b r2) {
                Intrinsics.checkNotNullParameter(r2, "payload");
                super(2);
                this.b = r2;
            }
        }

        public c(int r1) {
            this.a = r1;
        }
    }

    static {
    }

    public abstract CardPsId b();

    public abstract void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r1);

    public final void e() {
        c(c.C0133a.b);
        h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r0 = this.a;
        if (r0 == null) goto L5;
        r0.a(r0.d());
    L5:
        Disposable r1 = this.d;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public a() {
        PropertyOwner<c> r0 = new PropertyOwner(c.d.b);
        this.b = r0;
        this.c = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(hm0.a r6) {
        Intrinsics.checkNotNullParameter(r6, "chain");
        this.a = r6;
        com.bytedance.android.live.messagewindow.framework.process.a r0 = (com.bytedance.android.live.messagewindow.framework.process.a) r6.a;
        c(c.e.b);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r1 = r0.b.monitor();
        if (r1 == null) goto L6;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.c("当前节点：" + b().name());
        Unit r3 = Unit.INSTANCE;
        r1.d(r2.b());
    L6:
        im0.a r4 = r0.a;
        if (r4 == null) goto L23;
        Intrinsics.checkNotNullParameter(3, "state");
        if (Intrinsics.areEqual(3, r4.b.a) != true) goto L23;
        String r7 = b().name() + " process fail because the action is finish";
        if (r1 == null) goto L20;
        CardAlogParamsBuilder r5 = new CardAlogParamsBuilder();
        r5.c(r7);
        im0.a r8 = r0.a;
        if (r8 == null) goto L18;
        j71.a r9 = r8.c;
        if (r9 == null) goto L18;
    L19:
        r5.a("cmd", r9);
        Unit r10 = Unit.INSTANCE;
        r1.d(r5.b());
    L18:
        r9 = "unknown";
    L20:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r11 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_processor_handle_fail");
        r11.b = 1000;
        r11.b(r7);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r12 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r12 == null) goto L25;
        r12.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r11));
        return;
    L25:
        return;
    L23:
        d(r6);
    }

    public final void c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "newState");
        this.b.a(r2);
        if (r2.a != 3) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        this.b.onComplete();
        return;
    L9:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void f(Function1<? super b, Unit> r2) {
        if (r2 == null) goto L4;
        b r0 = new b();
        r2.invoke(r0);
        c r3 = new c.C0134c(r0);
    L5:
        c(r3);
        return;
    L4:
        r3 = c.b.b;
        goto L5
    }
}
