package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f3442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.material.resources.e f3443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private WeakReference<b> f3446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private TextAppearance f3447f;

    class a extends com.google.android.material.resources.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f3448a;

        a(i r10) {
            this.f3448a = r10;
        }

        @Override // com.google.android.material.resources.e
        public void a(int r10) {
            i.a(this.f3448a, true);
            b r11 = (b) i.b(this.f3448a).get();
            if (r11 == null) goto L6;
            r11.onTextSizeChange();
            return;
        }

        @Override // com.google.android.material.resources.e
        public void b(@NonNull Typeface r10, boolean r11) {
            if (r11 == false) goto L4;
            return;
        L4:
            i.a(this.f3448a, true);
            b r12 = (b) i.b(this.f3448a).get();
            if (r12 == null) goto L8;
            r12.onTextSizeChange();
            return;
        }
    }

    public interface b {
        @NonNull
        int[] getState();

        boolean onStateChange(int[] r10);

        void onTextSizeChange();
    }

    public i(@Nullable b r10) {
        this.f3442a = new TextPaint(1);
        this.f3443b = new a(this);
        this.f3445d = true;
        this.f3446e = new WeakReference(null);
        g(r10);
    }

    static /* synthetic */ boolean a(i r10, boolean r11) {
        r10.f3445d = r11;
        return r11;
    }

    static /* synthetic */ WeakReference b(i r10) {
        return r10.f3446e;
    }

    private float c(@Nullable CharSequence r10) {
        if (r10 != null) goto L6;
        return 0.0f;
    L6:
        return this.f3442a.measureText(r10, 0, r10.length());
    }

    @Nullable
    public TextAppearance d() {
        return this.f3447f;
    }

    @NonNull
    public TextPaint e() {
        return this.f3442a;
    }

    public float f(String r10) {
        if (this.f3445d == false) goto L5;
        float r11 = c(r10);
        this.f3444c = r11;
        this.f3445d = false;
        return r11;
    L5:
        return this.f3444c;
    }

    public void g(@Nullable b r10) {
        this.f3446e = new WeakReference(r10);
    }

    public void h(@Nullable TextAppearance r10, Context r11) {
        if (this.f3447f == r10) goto L14;
        this.f3447f = r10;
        if (r10 == null) goto L10;
        r10.o(r11, this.f3442a, this.f3443b);
        b r12 = this.f3446e.get();
        if (r12 == null) goto L9;
        TextPaint r13 = this.f3442a;
        r13.drawableState = r12.getState();
    L9:
        r10.n(r11, this.f3442a, this.f3443b);
        this.f3445d = true;
    L10:
        b r14 = this.f3446e.get();
        if (r14 == null) goto L15;
        r14.onTextSizeChange();
        r14.onStateChange(r14.getState());
        return;
    L15:
        return;
    }

    public void i(boolean r10) {
        this.f3445d = r10;
    }

    public void j(Context r10) {
        this.f3447f.n(r10, this.f3442a, this.f3443b);
    }
}
