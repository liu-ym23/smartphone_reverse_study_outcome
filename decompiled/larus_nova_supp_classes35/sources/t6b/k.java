package t6b;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.d0;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class k implements s6b.b<k, l> {
    public final boolean a;
    public final boolean b;
    public final v4b.e c;
    public final long d;
    public final Map<com.ss.android.lark.blueprint.j, wza.b<y6b.a<?>, Object>> e;
    public final List<RecyclerView.ItemDecoration> f;
    public final Function1<y6b.c<?>, Unit> g;
    public final Function1<y6b.c<?>, Boolean> h;
    public final FirstMessagePaddingType i;
    public final a1 j;
    public final v4b.d k;
    public final v4b.c l;
    public final Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> m;
    public final o3b.a n;
    public final Boolean o;
    public final y6b.e<y6b.c<?>> p;
    public final d0 q;
    public final Map<Class<? extends mya.g>, List<mya.g>> r;

    public k() {
        this(false, false, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287);
    }

    public void r() {
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new l(this);
    }

    public Map<com.ss.android.lark.blueprint.j, wza.b<y6b.a<?>, Object>> c() {
        return this.e;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }

    public FirstMessagePaddingType f() {
        return this.i;
    }

    public List<RecyclerView.ItemDecoration> g() {
        return this.f;
    }

    public Map<Class<? extends mya.g>, List<mya.g>> h() {
        return this.r;
    }

    public v4b.c i() {
        return this.l;
    }

    public v4b.d j() {
        return this.k;
    }

    public Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> k() {
        return this.m;
    }

    public o3b.a l() {
        return this.n;
    }

    public a1 m() {
        return this.j;
    }

    public long n() {
        return this.d;
    }

    public Function1<y6b.c<?>, Unit> o() {
        return this.g;
    }

    public Function1<y6b.c<?>, Boolean> p() {
        return this.h;
    }

    public y6b.e<y6b.c<?>> q() {
        return this.p;
    }

    public Boolean s() {
        return this.o;
    }

    public v4b.e t() {
        return this.c;
    }

    public d0 u() {
        return this.q;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r23) {
        k r0 = (k) r23;
        Intrinsics.checkNotNullParameter(r0, "patch");
        boolean r3 = r0.e();
        boolean r4 = r0.d();
        v4b.e r5 = r0.t();
        long r6 = r0.n();
        Map<com.ss.android.lark.blueprint.j, wza.b<y6b.a<?>, Object>> r8 = r0.c();
        List<RecyclerView.ItemDecoration> r9 = r0.g();
        Function1<y6b.c<?>, Unit> r10 = r0.o();
        Function1<y6b.c<?>, Boolean> r11 = r0.p();
        FirstMessagePaddingType r12 = r0.f();
        r0.r();
        return new k(r3, r4, r5, r6, r8, r9, r10, r11, r12, r0.m(), r0.j(), r0.i(), r0.k(), r0.l(), null, r0.u(), r0.h(), 98304);
    }

    public k(boolean r20, boolean r21, v4b.e r22, long r23, Map r25, List r26, Function1 r27, Function1 r28, FirstMessagePaddingType r29, a1 r30, v4b.d r31, v4b.c r32, Map r33, o3b.a r34, y6b.e r35, d0 r36, Map r37, int r38) {
        boolean r3 = false;
        if ((r38 & 1) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r38 & 2) != 0) goto L11;
        r3 = r21;
    L11:
        if ((r38 & 4) == 0) goto L13;
        v4b.e r4 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        long r6 = 0;
    L19:
        if ((r38 & 16) == 0) goto L21;
        Map r8 = MapsKt.emptyMap();
    L23:
        if ((r38 & 32) == 0) goto L25;
        List r9 = CollectionsKt.emptyList();
    L27:
        if ((r38 & 64) == 0) goto L29;
        Function1 r10 = null;
    L31:
        if ((r38 & 128) == 0) goto L33;
        Function1 r11 = null;
    L35:
        if ((r38 & 256) == 0) goto L37;
        FirstMessagePaddingType r12 = FirstMessagePaddingType.NONE;
    L39:
        if ((r38 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L41;
        a1 r13 = null;
    L43:
        if ((r38 & 2048) == 0) goto L45;
        v4b.d r14 = null;
    L47:
        if ((r38 & 4096) == 0) goto L49;
        v4b.c r15 = null;
    L51:
        if ((r38 & 8192) == 0) goto L53;
        Map r5 = MapsKt.emptyMap();
    L54:
        v4b.c r24 = r15;
        if ((r38 & 16384) == 0) goto L57;
        o3b.a r16 = null;
    L59:
        if ((r38 & 65536) == 0) goto L61;
        y6b.e r17 = null;
    L63:
        if ((r38 & 131072) == 0) goto L65;
        d0 r18 = null;
    L67:
        if ((r38 & 262144) == 0) goto L69;
        Map r19 = null;
    L70:
        Intrinsics.checkNotNullParameter(r8, "blockFactoryList");
        Intrinsics.checkNotNullParameter(r9, "itemDecorationList");
        Intrinsics.checkNotNullParameter(r12, "firstMessagePaddingType");
        Intrinsics.checkNotNullParameter(r5, "messageCellParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r24;
        this.m = r5;
        this.n = r16;
        this.o = null;
        this.p = r17;
        this.q = r18;
        this.r = r19;
        return;
    L69:
        r19 = r37;
        goto L70
    L65:
        r18 = r36;
        goto L67
    L61:
        r17 = r35;
        goto L63
    L57:
        r16 = r34;
        goto L59
    L53:
        r5 = r33;
        goto L54
    L49:
        r15 = r32;
        goto L51
    L45:
        r14 = r31;
        goto L47
    L41:
        r13 = r30;
        goto L43
    L37:
        r12 = r29;
        goto L39
    L33:
        r11 = r28;
        goto L35
    L29:
        r10 = r27;
        goto L31
    L25:
        r9 = r26;
        goto L27
    L21:
        r8 = r25;
        goto L23
    L17:
        r6 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L5:
        r2 = r20;
        goto L7
    }
}
