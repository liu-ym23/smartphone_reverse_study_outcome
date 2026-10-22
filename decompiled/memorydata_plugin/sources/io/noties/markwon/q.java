package io.noties.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16661a;

    q(String r1) {
        this.f16661a = r1;
    }

    public static <T> q<T> a(Class<T> r0, String r1) {
        return new q(r1);
    }

    public static <T> q<T> a(String r1) {
        return new q(r1);
    }

    public T a(t r3) {
        return (T) ((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin")).a(this);
    }

    public T a(t r3, T r4) {
        return (T) ((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin")).a(this, r4);
    }

    public T b(t r3) {
        T r4 = a((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"));
        Objects.requireNonNull(r4, this.f16661a);
        return r4;
    }

    public void b(t r3, T r4) {
        ((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin")).b(this, r4);
    }

    public void c(t r3) {
        ((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin")).b(this);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() != r3.getClass()) goto L13;
        q r4 = (q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.memorydata.plugin");
        return this.f16661a.equals(r4.f16661a);
    L13:
        return false;
    }

    public int hashCode() {
        return this.f16661a.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.f16661a + "'}";
    }
}
