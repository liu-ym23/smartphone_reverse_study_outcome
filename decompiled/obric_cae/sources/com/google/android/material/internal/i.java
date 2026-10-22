package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f4867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f4868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Layout.Alignment f4871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f4874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f4878l;

    public static class a extends Exception {
    }

    public i(CharSequence r8, TextPaint r10, int r11) {
        this.f4867a = r8;
        this.f4868b = r10;
        this.f4869c = r11;
        this.f4870d = r8.length();
        this.f4871e = Layout.Alignment.ALIGN_NORMAL;
        this.f4872f = Integer.MAX_VALUE;
        this.f4873g = 0.0f;
        this.f4874h = 1.0f;
        this.f4875i = 1;
        this.f4876j = true;
        this.f4878l = null;
    }

    public final StaticLayout a() {
        if (this.f4867a != null) goto L5;
        this.f4867a = "";
    L5:
        int r8 = Math.max(0, this.f4869c);
        CharSequence r10 = this.f4867a;
        int r11 = this.f4872f;
        TextPaint r12 = this.f4868b;
        if (r11 != 1) goto L8;
        r10 = TextUtils.ellipsize(r10, r12, r8, this.f4878l);
    L8:
        int r13 = Math.min(r10.length(), this.f4870d);
        this.f4870d = r13;
        if (this.f4877k == true) goto L11;
    L13:
        StaticLayout.Builder r14 = StaticLayout.Builder.obtain(r10, 0, r13, r12, r8);
        r14.setAlignment(this.f4871e);
        r14.setIncludePad(this.f4876j);
        if (this.f4877k == false) goto L16;
        TextDirectionHeuristic r15 = TextDirectionHeuristics.RTL;
    L17:
        r14.setTextDirection(r15);
        TextUtils.TruncateAt r16 = this.f4878l;
        if (r16 == null) goto L20;
        r14.setEllipsize(r16);
    L20:
        r14.setMaxLines(this.f4872f);
        float r17 = this.f4873g;
        if (r17 == 0.0f) goto L23;
    L24:
        r14.setLineSpacing(r17, this.f4874h);
    L26:
        if (this.f4872f <= 1) goto L29;
        r14.setHyphenationFrequency(this.f4875i);
    L29:
        return r14.build();
    L23:
        if (this.f4874h == 1.0f) goto L26;
    L16:
        r15 = TextDirectionHeuristics.LTR;
        goto L17
    L11:
        if (this.f4872f != 1) goto L13;
        this.f4871e = Layout.Alignment.ALIGN_OPPOSITE;
        goto L13
    }
}
