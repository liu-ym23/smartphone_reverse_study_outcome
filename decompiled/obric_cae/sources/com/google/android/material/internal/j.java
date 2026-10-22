package com.google.android.material.internal;

import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f4879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f4880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f4881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<b> f4883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x9.d f4884f;

    public class a extends android.support.v4.media.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f4885c;

        public a(j r8) {
            this.f4885c = r8;
        }

        @Override // android.support.v4.media.a
        public final void q(int r8) {
            j r10 = this.f4885c;
            r10.f4882d = true;
            b r11 = r10.f4883e.get();
            if (r11 == null) goto L6;
            r11.a();
            return;
        }

        @Override // android.support.v4.media.a
        public final void r(Typeface r8, boolean r10) {
            if (r10 == false) goto L4;
            return;
        L4:
            j r11 = this.f4885c;
            r11.f4882d = true;
            b r12 = r11.f4883e.get();
            if (r12 == null) goto L8;
            r12.a();
            return;
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] r8);
    }

    public j(b r8) {
        this.f4879a = new TextPaint(1);
        this.f4880b = new a(this);
        this.f4882d = true;
        this.f4883e = new WeakReference(null);
        this.f4883e = new WeakReference(r8);
    }

    public final float a(String r8) {
        if (this.f4882d == false) goto L5;
        TextPaint r10 = this.f4879a;
        if (r8 != null) goto L9;
        float r11 = 0.0f;
    L10:
        this.f4881c = r11;
        if (r8 == null) goto L14;
        Math.abs(r10.getFontMetrics().ascent);
    L14:
        this.f4882d = false;
        return this.f4881c;
    L9:
        r11 = r10.measureText(r8, 0, r8.length());
        goto L10
    L5:
        return this.f4881c;
    }
}
