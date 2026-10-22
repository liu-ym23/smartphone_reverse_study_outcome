package com.larus.asr;

import com.bytedance.flow_audio.api.business.asr.result.FlowAsrResultType;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.asr.r;
import com.larus.audio.audiov3.task.asr.sami.data.AudioEvent;
import com.larus.audio.report.h;
import com.larus.utils.logger.FLogger;
import iw5.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w2 implements lw5.f {
    public final /* synthetic */ String b;
    public final /* synthetic */ qw5.a c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ KmpAsrSessionAdapter e;
    public final /* synthetic */ KmpAsrSessionAdapter.a f;
    public final /* synthetic */ String g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowAsrResultType.values().length];
            r0[FlowAsrResultType.STREAM_FINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public final void A2(jw5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Map<String, y5> r3 = this.e.c;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        y5 r5 = (y5) r4.get(this.b);
        if (r5 == null) goto L8;
        h r6 = r5.e;
        if (r6 == null) goto L9;
        r6.n(false);
        return;
    L9:
        return;
    }

    public final void G0(jw5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "session");
        Map<String, y5> r1 = this.e.c;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        y5 r3 = (y5) r2.get(this.b);
        if (r3 == null) goto L14;
        final n4 r5 = r3.h;
        if (r5 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "session");
        if ((r4 instanceof r4) == false) goto L9;
        final r4 r6 = (r4) r4;
    L10:
        if (r6 == null) goto L16;
        com.larus.utils.t0.e(new h4(r5, r6));
        return;
    L16:
        return;
    L9:
        r6 = null;
        goto L10
    L15:
        return;
    }

    public final Map<String, String> b3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return MapsKt.emptyMap();
    }

    public final void l1(jw5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
    }

    public final void n0(jw5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
    }

    public final void y(final jw5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "session");
        final KmpAsrSessionAdapter.a r0 = this.f;
        com.larus.utils.t0.e(new v2(r3, r0));
    }

    public final void y1(jw5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
    }

    public final void z2(jw5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
    }

    public final void E1(jw5.a r4, iw5.c r5) {
        Intrinsics.checkNotNullParameter(r4, "session");
        Intrinsics.checkNotNullParameter(r5, "result");
        FLogger.a.i("KmpAsrSessionAdapter", "[voiceInputSessionDidStream][" + r4.getTaskId() + "][" + r5.c + "] text: " + g2a.d.a(r5.a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.asr.s2] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.asr.t2] */
    public final jw5.a K(String r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r8, "id");
        Intrinsics.checkNotNullParameter(r9, "extra");
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService r0 = IFlowAsrClientService.a.a();
        final String r1 = this.b;
        qw5.a r2 = this.c;
        final KmpAsrSessionAdapter.a r10 = this.f;
        ?? r3 = new s2(r10, r1);
        final KmpAsrSessionAdapter r11 = this.e;
        ?? r4 = new t2(r11, r1);
        if (this.d == false) goto L5;
        u2 r5 = new u2(r11, r1);
    L6:
        r r12 = r0.l(r1, r2, r3, r4, r5);
        if (this.d == true) goto L13;
        ww5.a r13 = (ww5.a) this.e.a.getValue();
        if (r13 != null) goto L12;
        return null;
    L12:
        return r13.M1(this.c, r12);
    L13:
        return new r4(this.c, r12);
    L5:
        r5 = 0;
        goto L6
    }

    public final void Q(jw5.a r2, rw5.d r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "data");
    }

    public final void e1(final jw5.a r9, final FlowAsrCancelReason r10) {
        Intrinsics.checkNotNullParameter(r9, "session");
        Intrinsics.checkNotNullParameter(r10, "reason");
        final KmpAsrSessionAdapter r2 = this.e;
        final String r3 = this.b;
        final String r5 = this.g;
        final KmpAsrSessionAdapter.a r7 = this.f;
        com.larus.utils.t0.e(new q2(r2, r3, r9, r5, r10, r7));
    }

    public final void j(final jw5.a r9, final iw5.c r10) {
        Intrinsics.checkNotNullParameter(r9, "session");
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r9, "session");
        Intrinsics.checkNotNullParameter(r10, "result");
        FLogger.a.i("KmpAsrSessionAdapter", "[asrSessionDidReceiveStreamResult][" + r9.getTaskId() + "][" + r10.c + "] text: " + g2a.d.a(r10.a));
        if (a.a[r10.c.ordinal()] == 1) goto L5;
        return;
    L5:
        if (r10.a.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        final y5 r5 = (y5) ((LinkedHashMap) this.e.c).get(this.b);
        if (r5 == null) goto L13;
        r5.j = true;
    L13:
        if (r5 == null) goto L17;
        h r1 = r5.e;
        if (r1 == null) goto L17;
        r1.n(true);
    L17:
        final KmpAsrSessionAdapter.a r3 = this.f;
        final String r7 = this.g;
        com.larus.utils.t0.e(new r2(r3, r10, r5, r9, r7));
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void o1(final jw5.a r14, final iw5.c r15) {
        Intrinsics.checkNotNullParameter(r14, "session");
        String r0 = null;
        if (r15 == null) goto L5;
        b r1 = r15.e;
    L6:
        if (r1 == null) goto L20;
        b r2 = r15.e;
        if (r2 == null) goto L20;
        String r3 = this.g;
        KmpAsrSessionAdapter r4 = this.e;
        String r5 = r2.a;
        List r6 = r2.b;
        if ((!r6.isEmpty()) == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L19;
        Lazy r7 = com.larus.utils.gson.b.a;
        List r8 = r6;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        iw5.a r11 = (iw5.a) r10.next();
        r4.getClass();
        r9.add(new AudioEvent(r11.getType(), r11.b, r11.c, r11.d));
        goto L16
    L18:
        r0 = com.larus.utils.gson.b.a(r9);
    L19:
        final com.larus.audio.c r12 = new com.larus.audio.c(r3, r5, r0, r2.c);
    L21:
        final KmpAsrSessionAdapter r13 = this.e;
        final String r16 = this.b;
        final String r17 = this.g;
        final KmpAsrSessionAdapter.a r19 = this.f;
        com.larus.utils.t0.e(new o2(r13, r16, r14, r15, r17, r12, r19));
        return;
    L20:
        r12 = null;
        goto L21
    L5:
        r1 = null;
        goto L6
    }

    public final void x2(final jw5.a r9, final hw5.a r10) {
        Intrinsics.checkNotNullParameter(r9, "session");
        Intrinsics.checkNotNullParameter(r10, "error");
        final KmpAsrSessionAdapter r2 = this.e;
        final String r3 = this.b;
        final String r6 = this.g;
        final KmpAsrSessionAdapter.a r7 = this.f;
        com.larus.utils.t0.e(new p2(r2, r3, r9, r10, r6, r7));
    }

    public w2(String r1, qw5.a r2, boolean r3, KmpAsrSessionAdapter r4, KmpAsrSessionAdapter.a r5, String r6) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }
}
