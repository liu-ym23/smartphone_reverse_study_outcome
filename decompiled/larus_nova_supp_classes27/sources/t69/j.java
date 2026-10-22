package t69;

import b49.g;
import com.bytedance.dora.camera.model.DoraVisionQueryTrackInfo;
import com.bytedance.dora.vision.DoraDataFrame;
import h49.d;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import uj4.a;
import uj4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements h {
    public j() {
    }

    public final void d(DoraDataFrame r15) {
        Iterator<d> r0 = k.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        d r1 = r0.next();
        int r3 = r15.stage;
        int r4 = r15.scene;
        int r5 = r15.id;
        int r6 = r15.type;
        int r7 = r15.seq;
        int r8 = r15.count;
        byte[] r2 = r15.data;
        if (r2 != null) goto L8;
        r2 = new byte[0];
    L8:
        byte[] r10 = r2;
        int r11 = r15.assId;
        byte[] r9 = r15.assData;
        if (r9 != null) goto L11;
        r9 = new byte[0];
    L11:
        r1.d(new g(r3, r4, r5, r6, r7, r8, r10, r11, r9));
        goto L4
    }

    public final void g(DoraVisionQueryTrackInfo r5) {
        b49.k r0 = new b49.k(r5.ttsStartTimestamp, r5.preCaptureLatency, r5.soundLatency);
        Iterator<d> r6 = k.a.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r6.next().w(r0);
        goto L4
    }

    public final void e(uj4.g r13, a r14) {
        Intrinsics.checkNotNullParameter(r13, "doraImageInfo");
        b49.h r0 = new b49.h(r13.a, r13.b, r13.c, r13.d, r13.e, r13.f, r13.g, r13.h, r13.i);
        b49.d r15 = new b49.d(r14.a, r14.b);
        Iterator<d> r16 = k.a.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r16.next().c(r0, r15);
        goto L4
    }

    public final void j(boolean r3, int r4, byte r5) {
        Iterator<d> r0 = k.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().j(r3, r4, r5);
        goto L4
    }

    public final void b(int r23, int r24, int r25, int r26, int r27, int r28, int r210, int r30, int r31, int r32, int r33, int r34, int r35, int r36, long r37, int r310, int r40, int r41) {
        Iterator<d> r0 = k.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b(r23, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33, r34, r35, r36, r37, r310, r40, r41);
        goto L4
    }
}
