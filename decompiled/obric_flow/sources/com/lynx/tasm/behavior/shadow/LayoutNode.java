package com.lynx.tasm.behavior.shadow;

import android.os.Handler;
import android.os.Looper;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LayoutNodeManager;
import com.lynx.tasm.image.AutoSizeImage;
import wn.a;
import ym.g;
import ym.h;
import ym.i;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public class LayoutNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutNodeManager f10334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10336c;
    public boolean d;
    public boolean e;
    public AutoSizeImage f;
    public ShadowNode g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f10337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10338i;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.lynx.tasm.behavior.shadow.ShadowNode, ym.e] */
    @CalledByNative
    public void align() {
        ?? r5 = this.g;
        if (r5 == 0) goto L6;
        r5.a();
        return;
    }

    public void c() {
        this.f10337h = new o((ShadowNode) this, 0);
        if (this.f10336c == true) goto L11;
        AutoSizeImage r5 = this.f;
        if (r5 == null) goto L11;
        this.f = r5;
        LayoutNodeManager r10 = this.f10334a;
        if (r10 == null) goto L18;
        this.f10336c = true;
        r10.d(this.f10335b, (ShadowNode) this);
        return;
    L18:
        return;
    L11:
        if (this.d == true) goto L19;
        ShadowNode r11 = this.g;
        if (r11 == null) goto L20;
        this.g = r11;
        LayoutNodeManager r12 = this.f10334a;
        if (r12 == null) goto L21;
        this.d = true;
        r12.d(this.f10335b, (ShadowNode) this);
        return;
    L21:
        return;
    L20:
        return;
    }

    public void d() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.lynx.tasm.behavior.shadow.ShadowNode, ym.e] */
    @CalledByNative
    public float[] measure(float r19, int r20, float r21, int r22, boolean r23) {
        float r5 = r19;
        float r10 = r21;
        float[] r11 = new float[3];
        AutoSizeImage r12 = this.f;
        if (r12 == null) goto L92;
        MeasureMode r13 = MeasureMode.a(r20);
        MeasureMode r14 = MeasureMode.a(r22);
        if (TraceController.g == false) goto L7;
        String r15 = "AutoSizeImage Measure: " + r5 + ":" + r13.f10341a + " - " + r10 + ":" + r14.f10341a + " " + r12.B;
        TraceEvent.c(r15);
    L8:
        Object r16 = r12.C;
        monitor-enter(r16);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (r12.f10888z != null) goto L17;
        Handler r17 = new Handler(Looper.myLooper());     // Catch: Throwable -> L15
        r12.f10888z = r17;     // Catch: Throwable -> L15
        a r18 = r12.A;     // Catch: Throwable -> L15
        if (r18 == null) goto L17;
        r17.post(r18);     // Catch: Throwable -> L15
        r12.A = null;     // Catch: Throwable -> L15
    L17:
        monitor-exit(r16);     // Catch: Throwable -> L15
        MeasureMode r110 = MeasureMode.f10340c;
        if (r13 != r110) goto L22;
        if (r14 != r110) goto L22;
        boolean r111 = true;
    L23:
        r12.f10887y = r111;
        if (r111 == true) goto L26;
        int r112 = r12.f10885w;
        int r113 = r12.f10886x;
        if (r5 != 0.0f) goto L34;
        if (r13 == MeasureMode.f10339b) goto L34;
    L37:
        boolean r24 = true;
    L39:
        r12.f10887y = r24;
        if (r12.f10884v == false) goto L78;
        if (r112 <= 0) goto L78;
        if (r113 <= 0) goto L78;
        if (r24 == true) goto L78;
        if (r13 != r110) goto L54;
        float r25 = (r113 / r112) * r5;
        if (r14 != MeasureMode.d) goto L52;
        if (r10 <= r25) goto L74;
    L53:
        r10 = r25;
    L74:
        if (TraceController.g == false) goto L76;
        TraceEvent.a(0, r15);
    L76:
        long r26 = h.b(r5, r10);
    L87:
        r11[0] = Float.intBitsToFloat((int) (r26 >> 32));
        r11[1] = Float.intBitsToFloat((int) r26);
        r11[2] = this.f10338i;
        return r11;
    L52:
        if (r14 != MeasureMode.f10339b) goto L74;
    L54:
        MeasureMode r27 = MeasureMode.f10339b;
        if (r13 != r27) goto L57;
        r5 = 65535;
    L57:
        if (r14 != r27) goto L59;
        r10 = 65535;
    L59:
        float r28 = r112;
        if (r14 != r110) goto L65;
        float r29 = (r28 / r113) * r10;
        if (r5 <= r29) goto L74;
        r5 = r29;
        goto L74
    L65:
        if (r28 > r5) goto L69;
        float r30 = r113;
        if (r30 > r10) goto L69;
        r5 = r28;
        r10 = r30;
    L69:
        float r31 = r113 / r28;
        if ((r10 / r5) >= r31) goto L72;
        r5 = r10 / r31;
        goto L74
    L72:
        r10 = r31 * r5;
    L78:
        if (TraceController.g == false) goto L80;
        TraceEvent.a(0, r15);
    L80:
        if (r13 == r110) goto L83;
        r5 = 0.0f;
    L83:
        if (r14 == r110) goto L86;
        r10 = 0.0f;
    L86:
        r26 = h.b(r5, r10);
    L34:
        if (r10 == 0.0f) goto L36;
    L38:
        r24 = false;
        goto L39
    L36:
        if (r14 == MeasureMode.f10339b) goto L38;
    L26:
        if (TraceController.g == false) goto L28;
        TraceEvent.a(0, r15);
    L28:
        r26 = h.b(r5, r10);
    L22:
        r111 = false;
        goto L23
    L7:
        r15 = null;
        goto L8
    L92:
        if (this.g == null) goto L94;
        g r32 = new g();
        r32.f23298a = r23;
        i r33 = new i();
        MeasureMode r34 = MeasureMode.a(r20);
        MeasureMode r35 = MeasureMode.a(r22);
        r33.f23299a = r5;
        r33.f23300b = r34;
        r33.f23301c = r10;
        r33.d = r35;
        float[] r36 = (float[]) this.g.a(r32, r33).f23302a;
        r11[0] = r36[0];
        r11[1] = r36[1];
        r11[2] = r36[2];
    L94:
        return r11;
    }
}
