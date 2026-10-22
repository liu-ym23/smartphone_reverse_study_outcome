package com.lynx.tasm.behavior.ui.utils;

import android.renderscript.Matrix4f;
import com.lynx.react.bridge.ReadableArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f10764c;
    public final int d;
    public final float e;
    public final k f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f10765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f10766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f10767j;

    public o(float r5, float r10, int r11, int r12, int r13, int r14) {
        this.f10762a = r11;
        this.f10764c = new k(0.0f);
        this.f10763b = r5;
        this.d = r12;
        this.f = new k(0.0f);
        this.e = r10;
        this.g = r13;
        this.f10765h = new k(0.0f);
        this.f10766i = r14;
        this.f10767j = new Matrix4f().getArray();
    }

    public static float a(List r5) {
        float r10 = 0.0f;
        if (r5 != null) goto L5;
    L16:
        return r10;
    L5:
        if (r5.isEmpty() == true) goto L16;
        Iterator r11 = r5.iterator();
    L9:
        if (r11.hasNext() == false) goto L16;
        o r12 = (o) r11.next();
        int r13 = r12.f10762a;
        if (r13 == 2) goto L15;
        if (r13 != 16) goto L9;
    L15:
        r10 = r12.f10764c.a();
        goto L9
    }

    public static ArrayList b(ReadableArray r17) {
        if (r17 != null) goto L5;
        return null;
    L5:
        if (r17.size() <= 0) goto L41;
        ArrayList r5 = new ArrayList();
        int r10 = 0;
    L9:
        if (r10 >= r17.size()) goto L32;
        ReadableArray r11 = r17.getArray(r10);
        if (r11.size() >= 7) goto L13;
        new IllegalArgumentException("transform params is error.");
    L31:
        r10 = r10 + 1;
        goto L9
    L13:
        int r12 = r11.getInt(0);
        if (r12 != 32768) goto L16;
    L27:
        float[] r13 = new float[16];
        r13[0] = 1.0f;
        r13[1] = 0.0f;
        r13[2] = 0.0f;
        r13[3] = 0.0f;
        r13[4] = 0.0f;
        r13[5] = 0.1f;
        r13[6] = 0.0f;
        r13[7] = 0.0f;
        r13[8] = 0.0f;
        r13[9] = 0.0f;
        r13[10] = 0.1f;
        r13[11] = 0.0f;
        r13[12] = 0.0f;
        r13[13] = 0.0f;
        r13[14] = 0.0f;
        r13[15] = 0.1f;
        int r14 = 0;
    L28:
        if (r14 >= 16) goto L30;
        int r15 = r14 + 1;
        r13[r14] = (float) r11.getDouble(r15);
        r14 = r15;
        goto L28
    L30:
        r5.add(new o(r12, r13));
        goto L31
    L16:
        if (r12 == 65536) goto L27;
        int r16 = r11.getInt(2);
        int r18 = r11.getInt(4);
        int r19 = r11.getInt(6);
        if (r12 == 1) goto L26;
        if (r12 == 2) goto L26;
        if (r12 == 4) goto L26;
        if (r12 == 8) goto L26;
        if (r12 == 16) goto L26;
        float r20 = (float) r11.getDouble(1);
        float r110 = (float) r11.getDouble(3);
        r11.getDouble(5);
        r5.add(new o(r20, r110, r12, r16, r18, r19));
    L26:
        r5.add(new o(r12, new k(r11.getDynamic(1), r16), r16, new k(r11.getDynamic(3), r18), r18, new k(r11.getDynamic(5), r19), r19));
        goto L31
    L32:
        return r5;
    L41:
        return null;
    }

    public static float c(List r5) {
        float r10 = 0.0f;
        if (r5 != null) goto L5;
    L17:
        return r10;
    L5:
        if (r5.isEmpty() == true) goto L17;
        Iterator r11 = r5.iterator();
    L9:
        if (r11.hasNext() == false) goto L17;
        o r12 = (o) r11.next();
        int r13 = r12.f10762a;
        if (r13 != 4) goto L13;
        r10 = r12.f10764c.a();
        goto L9
    L13:
        if (r13 != 16) goto L9;
        r10 = r12.f.a();
        goto L9
    }

    public o(int r5, k r10, int r11, k r12, int r13, k r14, int r15) {
        this.f10762a = r5;
        this.f10764c = r10;
        this.f10763b = 0.0f;
        this.d = r11;
        this.f = r12;
        this.e = 0.0f;
        this.g = r13;
        this.f10765h = r14;
        this.f10766i = r15;
        this.f10767j = new Matrix4f().getArray();
    }

    public o(int r5, float[] r10) {
        this.f10762a = r5;
        this.f10764c = new k(0.0f);
        this.f10763b = 0.0f;
        this.d = 0;
        this.f = new k(0.0f);
        this.e = 0.0f;
        this.g = 0;
        this.f10765h = new k(0.0f);
        this.f10766i = 0;
        this.f10767j = r10;
    }
}
