package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f3593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0084a f3594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3595c;

    /* JADX INFO: renamed from: com.google.android.material.resources.a$a, reason: collision with other inner class name */
    public interface InterfaceC0084a {
        void a(Typeface r10);
    }

    public a(InterfaceC0084a r10, Typeface r11) {
        this.f3593a = r11;
        this.f3594b = r10;
    }

    private void d(Typeface r10) {
        if (this.f3595c == true) goto L6;
        this.f3594b.a(r10);
        return;
    }

    @Override // com.google.android.material.resources.e
    public void a(int r10) {
        d(this.f3593a);
    }

    @Override // com.google.android.material.resources.e
    public void b(Typeface r10, boolean r11) {
        d(r10);
    }

    public void c() {
        this.f3595c = true;
    }
}
