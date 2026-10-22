package ib8;

import android.view.animation.Interpolator;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class k implements g {
    public final kc8.b a;
    public final nb8.a b;
    public final lb8.a c;
    public final kb8.t d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public Function1<? super d0, Unit> h;

    @Override // ib8.g
    public final void G2() {
        kc8.b r0 = this.a;
        if (r0 == null) goto L12;
        kc8.y r1 = r0.a;
        if (r1 == null) goto L13;
        kc8.j r2 = r1.r;
        if (r2 == null) goto L14;
        Function0<Unit> r3 = r2.e;
        if (r3 == null) goto L15;
        r3.invoke();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // ib8.g
    public final void U1() {
        kc8.b r0 = this.a;
        if (r0 == null) goto L12;
        kc8.y r1 = r0.a;
        if (r1 == null) goto L13;
        kc8.j r2 = r1.r;
        if (r2 == null) goto L14;
        Function0<Unit> r3 = r2.f;
        if (r3 == null) goto L15;
        r3.invoke();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // ib8.g
    public final do8.h d() {
        kc8.b r1 = this.a;
        if (r1 == null) goto L7;
        kc8.y r4 = r1.a;
        if (r4 == null) goto L7;
        Function0<ChatParam> r5 = r4.m;
    L8:
        if (r1 == null) goto L12;
        kc8.y r6 = r1.a;
        if (r6 == null) goto L12;
        Function0<de8.c> r7 = r6.o;
    L13:
        if (r1 == null) goto L17;
        kc8.y r8 = r1.a;
        if (r8 == null) goto L17;
        Function0<BotModel> r9 = r8.l;
    L18:
        if (r1 == null) goto L24;
        kc8.y r2 = r1.a;
        if (r2 == null) goto L24;
        Function0<String> r3 = r2.f;
        if (r3 == null) goto L24;
        String r10 = (String) r3.invoke();
    L25:
        kc8.b r11 = this.a;
        if (r11 == null) goto L30;
        kc8.y r12 = r11.a;
        if (r12 == null) goto L30;
        Fragment r13 = r12.a;
    L31:
        if (r11 == null) goto L35;
        kc8.y r14 = r11.a;
        if (r14 == null) goto L35;
        by7.e r15 = r14.c;
    L37:
        if ((r15 instanceof com.larus.trace.tracknode.a) == false) goto L39;
        com.larus.trace.tracknode.a r16 = (com.larus.trace.tracknode.a) r15;
    L40:
        if (r11 == null) goto L44;
        kc8.y r17 = r11.a;
        if (r17 == null) goto L44;
        com.larus.bmhome.chat.api.q0 r18 = r17.x;
    L45:
        if (r11 == null) goto L49;
        kc8.y r19 = r11.a;
        if (r19 == null) goto L49;
        LruSet<String> r110 = r19.y;
    L50:
        if (r11 == null) goto L54;
        kc8.y r20 = r11.a;
        if (r20 == null) goto L54;
        Boolean r111 = r20.g;
    L56:
        return new do8.h(null, r5, r7, r9, r10, r13, r16, r18, r110, r111, null, null, 3073);
    L54:
        r111 = null;
    L49:
        r110 = null;
    L44:
        r18 = null;
        goto L45
    L39:
        r16 = null;
    L35:
        r15 = null;
    L30:
        r13 = null;
    L24:
        r10 = null;
    L17:
        r9 = null;
    L12:
        r7 = null;
    L7:
        r5 = null;
        goto L8
    }

    @Override // ib8.g
    public final kb8.t c() {
        return this.d;
    }

    @Override // ib8.g
    public final lb8.a e() {
        return this.c;
    }

    @Override // ib8.g
    public final nb8.a f() {
        return this.b;
    }

    @Override // ib8.g
    public final void g(d0 r2) {
        Function1<? super d0, Unit> r0 = this.h;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    @Override // ib8.g
    public final void q(boolean r2, Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        kc8.b r0 = this.a;
        if (r0 == null) goto L12;
        kc8.y r1 = r0.a;
        if (r1 == null) goto L13;
        kc8.j r4 = r1.r;
        if (r4 == null) goto L14;
        Function2<Boolean, Message, Unit> r5 = r4.g;
        if (r5 == null) goto L15;
        r5.invoke(Boolean.valueOf(r2), r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // ib8.g
    public final void a(int r3, int r4, Interpolator r5) {
        Intrinsics.checkNotNullParameter(r5, "animationInterpolator");
        if (r4 != 0) goto L11;
        kc8.b r6 = this.a;
        if (r6 == null) goto L19;
        kc8.y r7 = r6.a;
        if (r7 == null) goto L20;
        Function2<Integer, Integer, Unit> r8 = r7.G;
        if (r8 == null) goto L21;
        Unit r9 = (Unit) r8.invoke(0, Integer.valueOf(r3));
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L11:
        kc8.b r1 = this.a;
        if (r1 == null) goto L23;
        kc8.y r2 = r1.a;
        if (r2 == null) goto L24;
        Function4<Integer, Integer, Interpolator, Integer, Unit> r10 = r2.H;
        if (r10 == null) goto L25;
        Unit r11 = (Unit) r10.invoke(0, Integer.valueOf(r3), r5, Integer.valueOf(r4));
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // ib8.g
    public final void h(String r85, Message r86, DeepThinkFoldStatus r87) {
        Intrinsics.checkNotNullParameter(r85, "clickPosition");
        Intrinsics.checkNotNullParameter(r86, "message");
        Intrinsics.checkNotNullParameter(r87, "deepThinkFoldStatus");
        kc8.b r1 = this.a;
        if (r1 == null) goto L10;
        kc8.y r2 = r1.a;
        if (r2 == null) goto L10;
        Function0<BotModel> r3 = r2.l;
        if (r3 == null) goto L10;
        BotModel r4 = (BotModel) r3.invoke();
        if (r4 == null) goto L10;
    L11:
        int r5 = oi8.n.a;
        ChatParam r6 = (ChatParam) this.f.getValue();
        if (r6 != null) goto L14;
        r6 = new ChatParam(null, null, null, null, null, 255);
    L14:
        ChatParam r7 = r6;
        if (com.larus.im.bean.message.a.f0(r86) == false) goto L17;
        String r8 = "thinking_progress";
    L18:
        String r9 = r8;
        String r10 = r4.getBotId();
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        boolean r11 = com.larus.im.bean.message.a.f0(r86);
        ri8.c r12 = ri8.c.a;
        String r13 = ri8.c.f(r87);
        de8.c r14 = (de8.c) this.e.getValue();
        if (r14 == null) goto L24;
        String r15 = ve8.c.b(r14.C());
    L25:
        de8.c r16 = (de8.c) this.e.getValue();
        if (r16 == null) goto L30;
        RecommendFrom r17 = r16.d;
        if (r17 == null) goto L30;
        String r18 = r17.a;
    L31:
        de8.c r19 = (de8.c) this.e.getValue();
        if (r19 == null) goto L36;
        RecommendFrom r20 = r19.d;
        if (r20 == null) goto L36;
        String r24 = r20.b;
    L37:
        oi8.n.a(r86, r7, 0, null, null, r9, r10, r13, r15, r18, r24, (String) this.g.getValue(), Boolean.valueOf(r11), r85, null, null, null, null, null, null, null, 4161816);
        return;
    L36:
        r24 = null;
    L30:
        r18 = null;
        goto L31
    L24:
        r15 = null;
        goto L25
    L17:
        r8 = "simple_search";
    L10:
        r4 = new BotModel(r86.getSenderId(), null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L11
    }

    public k(kc8.b r3, nb8.a r4, lb8.a r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = new kb8.t(r3);
        this.e = LazyKt.lazy(new h(this));
        this.f = LazyKt.lazy(new i(this));
        this.g = LazyKt.lazy(new j(this));
    }
}
