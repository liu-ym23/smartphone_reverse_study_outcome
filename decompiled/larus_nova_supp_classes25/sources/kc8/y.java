package kc8;

import android.view.animation.Interpolator;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotModel;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y {
    public static final /* synthetic */ int J = 0;
    public final z A;
    public final Function1<Boolean, Unit> B;
    public final Function0<Unit> C;
    public final Function1<Boolean, Unit> D;
    public final Function0<Integer> E;
    public final Function0<Integer> F;
    public final Function2<Integer, Integer, Unit> G;
    public final Function4<Integer, Integer, Interpolator, Integer, Unit> H;
    public final Function1<Integer, Unit> I;
    public final Fragment a;
    public final Long b;
    public final by7.e c;
    public final RecyclerView d;
    public final Function0<wc9.e> e;
    public final Function0<String> f;
    public final Boolean g;
    public final Boolean h;
    public final Boolean i;
    public final Integer j;
    public final Integer k;
    public final Function0<BotModel> l;
    public final Function0<ChatParam> m;
    public final Function0<ChatPageContext> n;
    public final Function0<de8.c> o;
    public final Function0<e5> p;
    public final Function0<Boolean> q;
    public final j r;
    public final Function0<Map<String, Object>> s;
    public final Integer t;
    public final com.larus.bmhome.chat.api.q0.a u;
    public final AttachReceiver v;
    public final RecyclerView.Adapter<?> w;
    public final com.larus.bmhome.chat.api.q0 x;
    public final LruSet<String> y;
    public final Function1<Integer, Unit> z;

    public static final class a {
        public com.larus.bmhome.chat.api.q0 A;
        public LruSet<String> B;
        public Fragment C;
        public z D;
        public Function2<? super Integer, ? super Integer, Unit> E;
        public Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> F;
        public Function0<Integer> G;
        public Function0<Integer> H;
        public Function1<? super Integer, Unit> I;
        public Function1<? super Boolean, Unit> a;
        public Function1<? super Boolean, Unit> b;
        public Function0<Unit> c;
        public Function1<? super Integer, Unit> d;
        public Long e;
        public by7.e f;
        public RecyclerView g;
        public Function0<BotModel> h;
        public Function0<ChatParam> i;
        public Function0<ChatPageContext> j;
        public Function0<de8.c> k;
        public Function0<e5> l;
        public Function0<Boolean> m;
        public j n;
        public Function0<wc9.e> o;
        public Function0<String> p;
        public Boolean q;
        public Boolean r;
        public Integer s;
        public Boolean t;
        public Integer u;
        public Function0<? extends Map<String, ? extends Object>> v;
        public Integer w;
        public com.larus.bmhome.chat.api.q0.a x;
        public AttachReceiver y;
        public RecyclerView.Adapter<?> z;

        /* JADX INFO: renamed from: kc8.y$a$a, reason: collision with other inner class name */
        public static final class C0079a implements Function0 {
            public static final C0079a a = null;

            static {
                a = new C0079a();
            }

            public C0079a() {
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return null;
            }
        }

        public static final class b implements Function0 {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return null;
            }
        }

        public static final class c implements Function0 {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return null;
            }
        }

        public static final class d implements Function2 {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }

            public final /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                ((Number) r1).intValue();
                ((Number) r2).intValue();
                return null;
            }
        }

        public static final class e implements Function4 {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }

            public final /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
                ((Number) r1).intValue();
                ((Number) r2).intValue();
                Interpolator r5 = (Interpolator) r3;
                ((Number) r4).intValue();
                return null;
            }
        }

        public static final class f implements Function0 {
            public static final f a = null;

            static {
                a = new f();
            }

            public f() {
            }

            public final /* bridge */ /* synthetic */ Object invoke() {
                return null;
            }
        }

        public final y a() {
            Long r3 = this.e;
            by7.e r4 = this.f;
            RecyclerView r5 = this.g;
            Function0<BotModel> r13 = this.h;
            Function0<ChatParam> r14 = this.i;
            Function0<ChatPageContext> r15 = this.j;
            Function0<de8.c> r1 = this.k;
            Function0<e5> r2 = this.l;
            Function0<Boolean> r6 = this.m;
            j r7 = this.n;
            Function0<wc9.e> r8 = this.o;
            Function0<String> r9 = this.p;
            Boolean r10 = this.q;
            Boolean r11 = this.r;
            Integer r12 = this.s;
            Boolean r16 = this.t;
            Integer r17 = this.u;
            Function0<? extends Map<String, ? extends Object>> r18 = this.v;
            Integer r19 = this.w;
            com.larus.bmhome.chat.api.q0.a r20 = this.x;
            AttachReceiver r21 = this.y;
            RecyclerView.Adapter<?> r22 = this.z;
            com.larus.bmhome.chat.api.q0 r23 = this.A;
            LruSet<String> r24 = this.B;
            Function1<? super Integer, Unit> r25 = this.d;
            z r26 = this.D;
            Function1<? super Boolean, Unit> r27 = this.a;
            Function0<Unit> r28 = this.c;
            Fragment r29 = this.C;
            Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> r30 = this.F;
            Function2<? super Integer, ? super Integer, Unit> r31 = this.E;
            Function0<Integer> r32 = this.G;
            Function0<Integer> r33 = this.H;
            return new y(r29, r3, r4, r5, r8, r9, r10, r11, r16, r12, r17, r13, r14, r15, r1, r2, r6, r7, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, this.b, r32, r33, r31, r30, this.I);
        }

        public a() {
            this.j = b.a;
            this.k = C0079a.a;
            this.l = c.a;
            Boolean r0 = Boolean.FALSE;
            this.q = r0;
            this.r = r0;
            this.t = r0;
            this.v = f.a;
            this.E = d.a;
            this.F = e.a;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean a() {
        if (this.k == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final a b() {
        a r0 = new a();
        r0.C = this.a;
        r0.e = this.b;
        r0.f = this.c;
        r0.g = this.d;
        r0.o = this.e;
        r0.p = this.f;
        r0.q = this.g;
        r0.r = this.h;
        r0.t = this.i;
        r0.s = this.j;
        r0.u = this.k;
        r0.h = this.l;
        r0.i = this.m;
        r0.v = this.s;
        r0.w = this.t;
        r0.x = this.u;
        r0.y = this.v;
        r0.z = this.w;
        r0.A = this.x;
        r0.B = this.y;
        r0.d = this.z;
        r0.D = this.A;
        r0.a = this.B;
        r0.c = this.C;
        r0.b = this.D;
        r0.G = this.E;
        Function2<Integer, Integer, Unit> r1 = this.G;
        Intrinsics.checkNotNullParameter(r1, "value");
        r0.E = r1;
        Function4<Integer, Integer, Interpolator, Integer, Unit> r2 = this.H;
        Intrinsics.checkNotNullParameter(r2, "value");
        r0.F = r2;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(Fragment r5, Long r6, by7.e r7, RecyclerView r8, Function0<wc9.e> r9, Function0<String> r10, Boolean r11, Boolean r12, Boolean r13, Integer r14, Integer r15, Function0<BotModel> r16, Function0<ChatParam> r17, Function0<ChatPageContext> r18, Function0<de8.c> r19, Function0<e5> r20, Function0<Boolean> r21, j r22, Function0<? extends Map<String, ? extends Object>> r23, Integer r24, com.larus.bmhome.chat.api.q0.a r25, AttachReceiver r26, RecyclerView.Adapter<?> r27, com.larus.bmhome.chat.api.q0 r28, LruSet<String> r29, Function1<? super Integer, Unit> r30, z r31, Function1<? super Boolean, Unit> r32, Function0<Unit> r33, Function1<? super Boolean, Unit> r34, Function0<Integer> r35, Function0<Integer> r36, Function2<? super Integer, ? super Integer, Unit> r37, Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> r38, Function1<? super Integer, Unit> r39) {
        Intrinsics.checkNotNullParameter(r37, "scrollBy");
        Intrinsics.checkNotNullParameter(r38, "smoothScrollBy");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
        this.o = r19;
        this.p = r20;
        this.q = r21;
        this.r = r22;
        this.s = r23;
        this.t = r24;
        this.u = r25;
        this.v = r26;
        this.w = r27;
        this.x = r28;
        this.y = r29;
        this.z = r30;
        this.A = r31;
        this.B = r32;
        this.C = r33;
        this.D = r34;
        this.E = r35;
        this.F = r36;
        this.G = r37;
        this.H = r38;
        this.I = r39;
    }
}
