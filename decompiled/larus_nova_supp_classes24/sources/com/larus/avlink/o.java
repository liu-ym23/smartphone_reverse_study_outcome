package com.larus.avlink;

import android.os.SystemClock;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.avlink.plugins.n3;
import com.larus.avlink.plugins.n4;
import com.larus.avlink.plugins.o4;
import com.larus.im.service.audio.AudioSessionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class o extends LLMCallController<n4> {
    public static final /* synthetic */ int E = 0;
    public Function1<? super byte[], Unit> A;
    public boolean B;
    public final com.larus.avlink.rtc.e C;
    public final Lazy D;
    public final int v;
    public final String w;
    public final buc.a x;
    public final buc.a y;
    public final buc.a z;

    public static final class a {
    }

    public final class b extends LLMCallController<n4>.a implements n4 {
        public final /* synthetic */ o b;

        public final boolean A() {
            return this.b.C.a;
        }

        public final boolean E() {
            if (this.b.f.s != AudioSessionType.MMT) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean e() {
            return this.b.y.c();
        }

        public final void mute() {
            this.b.G(new RealtimeCallParam());
        }

        public final int q() {
            return this.b.v;
        }

        public final void unmute() {
            this.b.U(new RealtimeCallParam());
        }

        public final boolean x() {
            if (this.b.f.s != AudioSessionType.RTC) goto L5;
            return true;
        L5:
            return false;
        }

        public b(o r1) {
            this.b = r1;
            super(r1);
        }

        public final void f(int r2) {
            this.b.g0(r2);
        }

        public final void m(int r2) {
            this.b.d0(r2);
        }

        public final void o(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            Function1<? super byte[], Unit> r0 = this.b.A;
            if (r0 == null) goto L6;
            r0.invoke(r2);
            return;
        }

        public final void p(String r3, String r4) {
            Intrinsics.checkNotNullParameter("env_observe", "caller");
            this.b.h0("env_observe", r3, r4);
        }

        public final void d(boolean r2, int r3, int r4) {
            this.b.f0(r2, r3, r4);
        }
    }

    static {
    }

    public abstract void Y();

    public void Z() {
    }

    public abstract void c0(RealtimeCallParam r1, int r2, String r3, String r4);

    public abstract void e0(m r1);

    public abstract void i0(Map r1);

    @Override // com.larus.audio.call.arch.LLMCallController
    public final com.larus.audio.call.arch.c K() {
        return new b(this);
    }

    public final n3 X() {
        return LLMCallController.w(this, Reflection.getOrCreateKotlinClass(n3.class));
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public String A() {
        return this.w;
    }

    public CompletableDeferred V(int r1) {
        g0(r1);
        return I();
    }

    public final void W(Function1 r7) {
        long r0 = SystemClock.elapsedRealtime();
        List r2 = CollectionsKt.toList(((LinkedHashMap) x().b).values());
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if ((r5 instanceof com.larus.avlink.plugins.c) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterator r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r7.invoke((com.larus.avlink.plugins.c) r6.next());
        goto L10
    L12:
        com.larus.audio.call.util.e.a.i(A(), "onVoiceWakeUp total cost: " + (SystemClock.elapsedRealtime() - r0) + "ms");
    }

    public final void d0(final int r4) {
        n1.d(A(), "try stop call");
        Z();
        RealtimeCallParam r0 = this.f;
        RealtimeCallParam.k r1 = r0.p;
        if (r4 != 3) goto L5;
        RealtimeCallParam.DoraEndType r2 = RealtimeCallParam.DoraEndType.EIGHT_TIMEOUT;
    L9:
        r1.C = r2;
        RealtimeCallParam.j r3 = r0.n;
        r3.a = Integer.valueOf(r4);
        V(r4).invokeOnCompletion(new h(this, r4));
        return;
    L5:
        if (r4 == 6) goto L7;
        r2 = RealtimeCallParam.DoraEndType.OTHER;
        goto L9
    L7:
        r2 = RealtimeCallParam.DoraEndType.TOUCHPAD;
        goto L9
    }

    public final void g0(int r6) {
        n1.d(A(), "triggerConversationEnd, reason: " + r6 + ", isInConversation: " + this.y.c());
        if (this.y.a(true, false) == false) goto L25;
        List r0 = CollectionsKt.toList(((LinkedHashMap) x().b).values());
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if ((r3 instanceof o4) == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        ((o4) r4.next()).Q0(r6);
        goto L12
    L14:
        com.larus.avlink.rtc.e r7 = this.C;
        r7.getClass();
        Intrinsics.checkNotNullParameter("triggerConversationEnd", "caller");
        if (r7.a == false) goto L26;
        r7.a = false;
        return;
    L26:
        return;
    }

    public void b0(String r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r8, "name");
        Intrinsics.checkNotNullParameter(r9, "block");
        if (this.x.a(false, true) == false) goto L9;
        Function0<CoroutineScope> r0 = this.d;
        if (r0 == null) goto L11;
        CoroutineScope r1 = (CoroutineScope) r0.invoke();
        if (r1 == null) goto L12;
        BuildersKt.launch$default(r1, Dispatchers.getIO(), null, new BaseDoraCallLLMController$safeStop$1(r9, this, r8, null), 2, null);
        return;
    L12:
        return;
    L11:
        return;
    L9:
        n1.d(A(), "current stop job running, skip ".concat(r8));
    }

    public void f0(final boolean r4, int r5, final int r6) {
        n1.d(A(), "try stopVUI call: hash: " + hashCode() + ", isSilent: " + r4 + ", scene: " + r5);
        Z();
        this.f.n.a = Integer.valueOf(r6);
        V(r6).invokeOnCompletion(new g(this, r4, r6));
    }

    public final void h0(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "caller");
        n1.d(A(), "triggerConversationStart, caller: " + r5 + ", isInConversation: " + this.y.c());
        if (this.y.a(false, true) == false) goto L17;
        com.larus.avlink.rtc.e r0 = this.C;
        r0.getClass();
        com.larus.avlink.rtc.d.a.getClass();
        Boolean r1 = com.larus.avlink.rtc.d.a(r7);
        if (r1 == null) goto L7;
        r0.a = r1.booleanValue();
    L7:
        List r2 = CollectionsKt.toList(((LinkedHashMap) x().b).values());
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        Object r8 = r4.next();
        if ((r8 instanceof o4) == false) goto L9;
        r3.add(r8);
        goto L9
    L13:
        Iterator r9 = r3.iterator();
    L15:
        if (r9.hasNext() == false) goto L24;
        ((o4) r9.next()).i0(r5, r6, r7);
        goto L15
    L24:
        return;
    }

    public o(b78.c r2, com.larus.voicecall.impl.tracer.q r3, int r4, t r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionCreator");
        Intrinsics.checkNotNullParameter(r3, "traceSpan");
        Intrinsics.checkNotNullParameter(r5, "lifecycleScope");
        super(r2, r3, r5);
        this.v = r4;
        this.w = "DoraCallLLMController";
        this.x = buc.b.a(false);
        this.y = buc.b.a(false);
        this.z = buc.b.a(false);
        this.C = new com.larus.avlink.rtc.e();
        this.D = LazyKt.lazy(new e(this));
    }
}
