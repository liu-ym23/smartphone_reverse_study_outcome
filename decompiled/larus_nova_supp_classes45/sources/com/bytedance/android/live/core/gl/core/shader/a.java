package com.bytedance.android.live.core.gl.core.shader;

import android.opengl.GLES20;
import k50.f;
import kotlin.jvm.internal.Intrinsics;
import m50.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public final String a;
    public String[] b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final float[] k;
    public boolean l;
    public int m;

    public abstract void c();

    public abstract void d(f r1, d r2, n50.b r3);

    public abstract void e();

    public a() {
        this.a = getClass().getName();
        this.k = new float[16];
        this.m = -1;
    }

    public final void a(f r8) {
        Intrinsics.checkNotNullParameter(r8, "rendererParams");
        if (this.m != r8.b) goto L6;
        return;
    L6:
        if (this.l == true) goto L8;
        c();
        this.l = true;
    L8:
        String r0 = this.c;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("vertexShader");
    L11:
        this.f = b(35633, r0);
        String r1 = this.d;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentShader");
    L14:
        this.g = b(35632, r1);
        int r2 = GLES20.glCreateProgram();
        if (r2 == 0) goto L28;
        GLES20.glAttachShader(r2, this.f);
        GLES20.glAttachShader(r2, this.g);
        String[] r3 = this.b;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("attributes");
    L19:
        int r4 = r3.length;
        int r5 = 0;
    L20:
        if (r5 >= r4) goto L25;
        String[] r6 = this.b;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("attributes");
    L24:
        GLES20.glBindAttribLocation(r2, r5, r6[r5]);
        r5 = r5 + 1;
        goto L20
    L25:
        GLES20.glLinkProgram(r2);
        int[] r7 = new int[1];
        GLES20.glGetProgramiv(r2, 35714, r7, 0);
        if (r7[0] != 0) goto L28;
        int r9 = v50.b.a;
        Intrinsics.checkNotNullParameter("Error compiling program: " + GLES20.glGetProgramInfoLog(r2), "message");
        GLES20.glDeleteProgram(r2);
        r2 = 0;
    L28:
        if (r2 == 0) goto L32;
        this.e = r2;
        this.m = r8.b;
        return;
    L32:
        throw new RuntimeException("Error creating shader program.");
    }

    public final int b(int r3, String r4) {
        int r5 = GLES20.glCreateShader(r3);
        if (r5 == 0) goto L7;
        GLES20.glShaderSource(r5, r4);
        GLES20.glCompileShader(r5);
        int[] r6 = new int[1];
        GLES20.glGetShaderiv(r5, 35713, r6, 0);
        if (r6[0] != 0) goto L7;
        String r7 = GLES20.glGetShaderInfoLog(r5);
        GLES20.glDeleteShader(r5);
        r5 = 0;
    L8:
        if (r5 == 0) goto L11;
        return r5;
    L11:
        throw new RuntimeException("Error creating shader " + this.a + ": " + r7);
    L7:
        r7 = null;
        goto L8
    }
}
