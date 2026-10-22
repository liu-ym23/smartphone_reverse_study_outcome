package com.google.android.material.carousel;

import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f4539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f4540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f4541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f4542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f4543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f4545g;

    public c(b r8, ArrayList r10, ArrayList r11) {
        this.f4539a = r8;
        this.f4540b = Collections.unmodifiableList(r10);
        this.f4541c = Collections.unmodifiableList(r11);
        float r12 = ((b) r10.get(r10.size() - 1)).b().f4533a - r8.b().f4533a;
        this.f4544f = r12;
        float r13 = r8.d().f4533a - ((b) r11.get(r11.size() - 1)).d().f4533a;
        this.f4545g = r13;
        this.f4542d = b(r12, r10, true);
        this.f4543e = b(r13, r11, false);
    }

    public static float[] b(float r8, ArrayList r10, boolean r11) {
        int r12 = r10.size();
        float[] r13 = new float[r12];
        int r14 = 1;
    L3:
        if (r14 >= r12) goto L13;
        int r15 = r14 - 1;
        b r16 = (b) r10.get(r15);
        b r17 = (b) r10.get(r14);
        if (r11 == false) goto L7;
        float r18 = r17.b().f4533a - r16.b().f4533a;
    L8:
        float r19 = r18 / r8;
        if (r14 != (r12 - 1)) goto L11;
        float r20 = 1.0f;
    L12:
        r13[r14] = r20;
        r14 = r14 + 1;
        goto L3
    L11:
        r20 = r13[r15] + r19;
        goto L12
    L7:
        r18 = r16.d().f4533a - r17.d().f4533a;
        goto L8
    L13:
        return r13;
    }

    public static b c(b r8, int r10, int r11, float r12, int r13, int r14, float r15) {
        ArrayList r16 = new ArrayList(r8.f4521b);
        r16.add(r11, (b.C0049b) r16.remove(r10));
        b.a r17 = new b.a(r8.f4520a, r15);
        int r18 = 0;
    L4:
        if (r18 >= r16.size()) goto L12;
        b.C0049b r19 = (b.C0049b) r16.get(r18);
        float r20 = r19.f4536d;
        float r21 = (r20 / 2.0f) + r12;
        if (r18 < r13) goto L9;
        if (r18 > r14) goto L9;
        boolean r22 = true;
    L10:
        r17.b(r21, r19.f4535c, r20, r22, r19.f4537e, r19.f4538f);
        r12 = r12 + r19.f4536d;
        r18 = r18 + 1;
    L9:
        r22 = false;
        goto L10
    L12:
        return r17.d();
    }

    public final b a(float r17, float r18, float r19) {
        float r8 = this.f4544f + r18;
        float r10 = r19 - this.f4545g;
        if (r17 >= r8) goto L6;
        float r11 = h9.a.a(1.0f, 0.0f, r18, r8, r17);
        List<b> r12 = this.f4540b;
        float[] r13 = this.f4542d;
    L8:
        int r14 = r12.size();
        int r15 = 0;
        float r16 = r13[0];
        int r20 = 1;
    L10:
        if (r20 >= r14) goto L15;
        float r110 = r13[r20];
        if (r11 <= r110) goto L13;
        r20 = r20 + 1;
        r16 = r110;
        goto L10
    L13:
        float[] r21 = {h9.a.a(0.0f, 1.0f, r16, r110, r11), r20 - 1, r20};
    L16:
        b r22 = r12.get((int) r21[1]);
        b r23 = r12.get((int) r21[2]);
        float r24 = r21[0];
        if (r22.f4520a != r23.f4520a) goto L28;
        List<b.C0049b> r25 = r22.f4521b;
        int r26 = r25.size();
        List<b.C0049b> r27 = r23.f4521b;
        if (r26 != r27.size()) goto L26;
        ArrayList r28 = new ArrayList();
    L22:
        if (r15 >= r25.size()) goto L24;
        b.C0049b r29 = r25.get(r15);
        b.C0049b r30 = r27.get(r15);
        float r31 = r29.f4533a;
        float r111 = r30.f4533a;
        LinearInterpolator r112 = h9.a.f7943a;
        float r113 = defpackage.a.a(r111, r31, r24, r31);
        float r32 = r30.f4534b;
        float r114 = r29.f4534b;
        float r115 = defpackage.a.a(r32, r114, r24, r114);
        float r33 = r30.f4535c;
        float r116 = r29.f4535c;
        float r117 = defpackage.a.a(r33, r116, r24, r116);
        float r34 = r30.f4536d;
        float r35 = r29.f4536d;
        r28.add(new b.C0049b(r113, r115, r117, defpackage.a.a(r34, r35, r24, r35), false, 0.0f));
        r15 = r15 + 1;
        goto L22
    L24:
        LinearInterpolator r36 = h9.a.f7943a;
        int r37 = r23.f4522c;
        int r38 = r22.f4522c;
        int r39 = Math.round((r37 - r38) * r24) + r38;
        int r40 = r23.f4523d;
        int r41 = r22.f4523d;
        return new b(r22.f4520a, r28, r39, Math.round(r24 * (r40 - r41)) + r41);
    L26:
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
    L28:
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    L15:
        r21 = new float[]{0.0f, 0.0f, 0.0f};
        goto L16
    L6:
        if (r17 <= r10) goto L30;
        r11 = h9.a.a(0.0f, 1.0f, r10, r19, r17);
        r12 = this.f4541c;
        r13 = this.f4543e;
        goto L8
    L30:
        return this.f4539a;
    }
}
