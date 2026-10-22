package com.larus.avlink.plugins;

import com.larus.im.service.audio.vlm.EncodedVideoFrameType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g4 extends com.larus.audio.call.arch.a<n4> implements x4 {
    public final String f;
    public volatile boolean g;
    public final Object h;
    public final w98.e i;

    public static final class a implements com.larus.im.service.audio.v {
        public final /* synthetic */ g4 a;

        public final String getName() {
            return "DoraVideoFrameSender#connStateListener";
        }

        public a(g4 r1) {
            this.a = r1;
        }

        public final void O1(jd9.c r2, jd9.c r3) {
            Intrinsics.checkNotNullParameter(r2, "oldState");
            Intrinsics.checkNotNullParameter(r3, "newState");
            if ((r3 instanceof jd9.c.a) == false) goto L5;
            g4.j3(this.a, "session connected");
            return;
        L5:
            this.a.g = false;
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ g4 b;

        public final void i() {
            com.larus.avlink.n1.d(this.b.f, "onExternalVideoEncoderStarted");
            this.b.g = true;
            g4.j3(this.b, "EncoderStarted");
        }

        public final void j() {
            com.larus.avlink.n1.d(this.b.f, "onExternalVideoEncoderStopped");
            this.b.g = false;
        }

        public final String g() {
            return this.a;
        }

        public b(g4 r1) {
            this.b = r1;
            this.a = r1.f;
        }
    }

    public final com.larus.im.service.audio.v R2() {
        return new a(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public final void g3() {
        super.g3();
        this.g = false;
    }

    public final boolean l3() {
        if (((n4) getContext()).E() == true) goto L5;
    L8:
        id9.d r0 = ((n4) getContext()).j();
        if (r0 == null) goto L11;
        jd9.c r1 = r0.state();
    L13:
        return r1 instanceof jd9.c.a;
    L11:
        r1 = null;
        goto L13
    L5:
        if (this.g == true) goto L8;
        return false;
    }

    public final String T2() {
        return this.f;
    }

    public g4(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraVideoFrameSender";
        this.h = new Object();
        this.i = new w98.e();
    }

    public static String n3(w98.c r4) {
        if ((r4 instanceof w98.c.b) == false) goto L10;
        StringBuilder r0 = new StringBuilder("type=video, isKey=");
        w98.c.b r5 = (w98.c.b) r4;
        if (r5.a.h != EncodedVideoFrameType.KEY) goto L7;
        boolean r1 = true;
    L8:
        r0.append(r1);
        r0.append(", ");
        tf9.a r6 = r5.a;
        r0.append("timestampUs=" + r6.c + ", frameType=" + r6.h + ", codec=" + r6.g + ", dataSize=" + r6.a.length + ", codecConfigSize=" + r6.b.length + ", width=" + r6.d + ", height=" + r6.e + ", rotation=" + r6.f);
        return r0.toString();
    L7:
        r1 = false;
        goto L8
    L10:
        if ((r4 instanceof w98.c.a) == false) goto L14;
        StringBuilder r2 = new StringBuilder("type=ocr, timestamp=");
        w98.c.a r7 = (w98.c.a) r4;
        r2.append(r7.a.c);
        r2.append(", hasText=");
        r2.append(r7.a.a);
        return r2.toString();
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final int k3(w98.c r7) {
        if ((r7 instanceof w98.c.b) == false) goto L9;
        w98.e r0 = this.i;
        tf9.a r8 = ((w98.c.b) r7).a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "frame");
        long r2 = r8.c / ((long) 1000);
        Map<Long, w98.e.a> r4 = r0.a;
        Long r3 = Long.valueOf(r2);
        LinkedHashMap r5 = (LinkedHashMap) r4;
        Object r6 = r5.get(r3);
        if (r6 != null) goto L7;
        r6 = new w98.e.a(null);
        r5.put(r3, r6);
    L7:
        ((w98.e.a) r6).a.add(r8);
        int r9 = r0.b + 1;
        r0.b = r9;
        return r9;
    L9:
        if ((r7 instanceof w98.c.a) == false) goto L16;
        w98.e r1 = this.i;
        we9.e r10 = ((w98.c.a) r7).a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "model");
        Map<Long, w98.e.a> r11 = r1.a;
        Long r12 = Long.valueOf(r10.c);
        LinkedHashMap r13 = (LinkedHashMap) r11;
        Object r14 = r13.get(r12);
        if (r14 != null) goto L13;
        r14 = new w98.e.a(null);
        r13.put(r12, r14);
    L13:
        ((w98.e.a) r14).b.add(r10);
        int r15 = r1.b + 1;
        r1.b = r15;
        return r15;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.avlink.plugins.x4
    public final void l2(we9.e r2) {
        Intrinsics.checkNotNullParameter(r2, "ocrModel");
        o3(new w98.c.a(r2));
    }

    public final void m3(List<? extends w98.c> r14) {
        Iterator<T> r0 = r14.iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L32;
        int r4 = r2 + 1;
        w98.c r5 = (w98.c) r0.next();
        if (l3() == false) goto L7;
        id9.d r6 = ((n4) getContext()).j();
        if (r6 == null) goto L10;
        if ((r5 instanceof w98.c.b) == false) goto L26;
        com.larus.im.service.audio.z r7 = r6.e();
        if (r7 == null) goto L15;
        w98.c.b r8 = (w98.c.b) r5;
        int r9 = r7.r(r8.a);
        w4 r10 = (w4) getContext().c(Reflection.getOrCreateKotlinClass(w4.class), null);
        if (r10 == null) goto L23;
        long r11 = r8.a.c / ((long) 1000);
        if (r9 < 0) goto L21;
        boolean r12 = true;
    L22:
        r10.S0(r11, r12);
        goto L23
    L21:
        r12 = false;
    L23:
        if (r9 >= 0) goto L28;
        com.larus.avlink.n1.e(this.f, "submit encoded video frame failed: result=" + r9 + ", " + n3(r5));
    L29:
        r2 = r4;
    L28:
        r3 = r3 + 1;
        goto L29
    L15:
        com.larus.avlink.n1.e(this.f, "stop video stream batch: video service unavailable, droppedRemaining=" + (r14.size() - r2) + ", " + n3(r5));
        goto L32
    L26:
        if ((r5 instanceof w98.c.a) == false) goto L31;
        r6.B(((w98.c.a) r5).a);
        goto L28
    L31:
        throw new NoWhenBranchMatchedException();
    L10:
        com.larus.avlink.n1.e(this.f, "stop video stream batch: media session unavailable, droppedRemaining=" + (r14.size() - r2) + ", " + n3(r5));
        goto L32
    L7:
        com.larus.avlink.n1.e(this.f, "stop video stream batch: session disconnected, droppedRemaining=" + (r14.size() - r2));
    L32:
        com.larus.avlink.n1.d(this.f, "submit video stream data, total=" + r14.size() + ", submitted=" + r3);
    }

    public final void o3(w98.c r6) {
        Object r1 = this.h;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (l3() == true) goto L9;
        int r2 = k3(r6);     // Catch: Throwable -> L13
        com.larus.avlink.n1.d(this.f, "cache video stream data: cacheSize=" + r2 + ", " + n3(r6));     // Catch: Throwable -> L13
        monitor-exit(r1);
        return;
    L9:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        m3(CollectionsKt.listOf(r6));
    }

    @Override // com.larus.avlink.plugins.x4
    public final void u1(tf9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        o3(new w98.c.b(r2));
    }

    public static final void j3(g4 r4, String r5) {
        Object r0 = r4.h;
        monitor-enter(r0);
        List<w98.c> r1 = r4.i.a();     // Catch: Throwable -> L10
        monitor-exit(r0);
        if ((!r1.isEmpty()) == false) goto L15;
        com.larus.avlink.n1.d(r4.f, "send cached video stream data, caller=" + r5 + ", size=" + r1.size());
        r4.m3(r1);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
