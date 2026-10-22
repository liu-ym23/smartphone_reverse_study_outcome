package com.lynx.component.svg.parser;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f9844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9846c;
    public final Paint d;
    public final Paint e;
    public e f;
    public e g;

    public o0() {
        Paint r5 = new Paint();
        this.d = r5;
        r5.setFlags(193);
        r5.setHinting(0);
        r5.setStyle(Paint.Style.FILL);
        Typeface r10 = Typeface.DEFAULT;
        r5.setTypeface(r10);
        Paint r11 = new Paint();
        this.e = r11;
        r11.setFlags(193);
        r11.setHinting(0);
        r11.setStyle(Paint.Style.STROKE);
        r11.setTypeface(r10);
        this.f9844a = b0.a();
    }

    public o0(o0 r5) {
        this.f9845b = r5.f9845b;
        this.f9846c = r5.f9846c;
        this.d = new Paint(r5.d);
        this.e = new Paint(r5.e);
        e r10 = r5.f;
        if (r10 == null) goto L5;
        this.f = new e(r10);
    L5:
        e r11 = r5.g;
        if (r11 == null) goto L13;
        this.g = new e(r11);
    L13:
        this.f9844a = (b0) r5.f9844a.clone();     // Catch: CloneNotSupportedException -> L10
        return;
    L10:
        e = move-exception;
        Log.e("SVGAndroidRenderer", "Unexpected clone error", e);
        this.f9844a = b0.a();
    }
}
