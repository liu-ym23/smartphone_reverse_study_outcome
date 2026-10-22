package com.bytedance.retrofit2;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n4.d f2491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f2492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r4.e f2493c;

    private a0(n4.d r10, T r11, r4.e r12) {
        this.f2491a = r10;
        this.f2492b = r11;
        this.f2493c = r12;
    }

    public static <T> a0<T> c(r4.e r10, n4.d r11) {
        Objects.requireNonNull(r10, "body == null");
        Objects.requireNonNull(r11, "rawResponse == null");
        if (r11.i() == true) goto L7;
        return new a0(r11, null, r10);
    L7:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> a0<T> j(T r10, n4.d r11) {
        Objects.requireNonNull(r11, "rawResponse == null");
        if (r11.i() == false) goto L7;
        return new a0(r11, r10, null);
    L7:
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f2492b;
    }

    public int b() {
        return this.f2491a.e();
    }

    public r4.e d() {
        return this.f2493c;
    }

    public List<n4.b> e() {
        return this.f2491a.d();
    }

    public boolean f() {
        return this.f2491a.i();
    }

    public String g() {
        return this.f2491a.j();
    }

    public n4.d h() {
        return this.f2491a;
    }

    public void i(RetrofitMetrics r10) {
    }
}
