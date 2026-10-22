package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.api.xplay.r;
import com.bytedance.android.live.broadcastgame.api.xplay.s;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator;
import com.bytedance.android.livesdk.utils.r2;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ti6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements j {
    public fi6.a a;
    public boolean b;
    public boolean c;
    public String d;
    public int e;
    public String f;
    public final CompositeDisposable g;
    public final p h;
    public final Pair<Integer, Integer> i;
    public final com.bytedance.android.live.broadcastgame.xplay.servermergecast.a j;
    public final r k;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ boolean b(aj6.d r1, aj6.b r2) {
        ti6.a.a(r1, r2);
        return false;
    }

    public final String a(int r18, int r19, List<ti6.f> r21) {
        Intrinsics.checkNotNullParameter(r21, "mixRegions");
        s r2 = this.h.j;
        if (r2 != null) goto L5;
    L7:
        c r3 = this.j.a(((Number) this.i.getFirst()).intValue(), ((Number) this.i.getSecond()).intValue());
    L8:
        r r5 = this.k;
        if (r5 == null) goto L11;
        String r6 = r5.i;
    L12:
        List r7 = CollectionsKt.toMutableList(r21);
        Iterator r8 = r7.iterator();
    L14:
        if (r8.hasNext() == false) goto L28;
        ti6.f r9 = (ti6.f) r8.next();
        if (Intrinsics.areEqual(r9.b, r6) == false) goto L24;
        if (this.b == false) goto L23;
        if (r3.f == 8) goto L21;
        r9.a = 1;
        float r11 = r3.c;
        float r12 = r3.a;
        double r13 = r11 - r12;
        float r14 = r3.d;
        float r15 = r3.b;
        List r110 = r7;
        r9.f = r13;
        r9.g = r14 - r15;
        r9.d = r12;
        r9.e = r15;
        r9.l = true;
        r9.o = 1;
    L27:
        r7 = r110;
        goto L14
    L21:
        r9.a = 1;
        r9.f = 0.0d;
        r9.g = 0.0d;
        r9.d = 0.0d;
        r9.e = 0.0d;
        r9.l = true;
        r9.o = 1;
        goto L14
    L23:
        r110 = r7;
        r9.a = 1;
        r9.f = 1.0d;
        r9.g = 1.0d;
        r9.d = 0.0d;
        r9.e = 0.0d;
        r9.o = 1;
        goto L27
    L24:
        r110 = r7;
        r9.o = 0;
        if (q1.c(this.h.h.b) == false) goto L27;
        r9.s = 2;
        goto L27
    L28:
        List r111 = r7;
        this.d = LiveSeiCreator.a(r111, this.a, 0).toString();
        if (r111 == null) goto L40;
        Iterator r4 = r111.iterator();
    L32:
        if (r4.hasNext() == false) goto L40;
        ti6.f r16 = (ti6.f) r4.next();
        if ((!Intrinsics.areEqual(r16.b, r6)) == false) goto L32;
        if (this.c == false) goto L32;
        if (r2.a(this.f) == false) goto L32;
        r16.c("");
        r16.b("");
        r16.a("");
        r16.y = this.f;
    L40:
        if (r111 == null) goto L47;
        ArrayList r17 = new ArrayList();
        Iterator r22 = r111.iterator();
    L43:
        if (r22.hasNext() == false) goto L48;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((ti6.f) r23).b, r6) == false) goto L43;
        r17.add(r23);
    L48:
        s r24 = this.h.j;
        if (r24 != null) goto L51;
    L54:
        r21.clear();
        if (r111 == null) goto L57;
        List r25 = r111;
    L58:
        r21.addAll(r25);
        s r26 = this.h.j;
        if (r26 != null) goto L61;
    L72:
        String r1 = LiveSeiCreator.a(r21, this.a, 0).toString();
        int r27 = XplayLog.a;
        XplayLog.c("XplayStreamMixer", "mix stream, rtcSeiJson = " + r1 + ", isFirstRemoteVideoArrived = " + this.b);
        return r1;
    L61:
        if (r26.g != true) goto L72;
        ArrayList r28 = new ArrayList();
        Iterator<T> r29 = r21.iterator();
    L64:
        if (r29.hasNext() == false) goto L68;
        Object r31 = r29.next();
        if ((!Intrinsics.areEqual(((ti6.f) r31).b, r6)) == false) goto L64;
        r28.add(r31);
        goto L64
    L68:
        Iterator r32 = r28.iterator();
    L70:
        if (r32.hasNext() == false) goto L72;
        ti6.f r33 = (ti6.f) r32.next();
        int r34 = this.e;
        r33.o = r34;
        this.e = r34 ^ 1;
        goto L70
    L57:
        r25 = new ArrayList();
        goto L58
    L51:
        if (r24.g != true) goto L54;
        if (r17 == null) goto L54;
        r111.removeAll(r17);
        goto L54
    L47:
        r17 = null;
        goto L48
    L11:
        r6 = null;
        goto L12
    L5:
        if (r2.h != true) goto L7;
        r3 = new c(0);
        goto L8
    }

    public g(p r2, Pair<Integer, Integer> r3, com.bytedance.android.live.broadcastgame.xplay.servermergecast.a r4, r r5) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayCanvasSize");
        Intrinsics.checkNotNullParameter(r4, "xplayLittleWindowCastManager");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.d = "";
        this.g = new CompositeDisposable();
    }
}
