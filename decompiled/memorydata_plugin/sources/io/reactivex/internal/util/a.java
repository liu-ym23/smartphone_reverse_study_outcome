package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.j;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f17151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f17152b;
    Object[] c;
    int d;

    /* JADX INFO: renamed from: io.reactivex.internal.util.a$a, reason: collision with other inner class name */
    public interface InterfaceC0877a<T> extends j<T> {
        @Override // io.reactivex.b.j
        boolean test(T r1);
    }

    public a(int r1) {
        this.f17151a = r1;
        Object[] r2 = new Object[r1 + 1];
        this.f17152b = r2;
        this.c = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(InterfaceC0877a<? super T> r5) {
        InterfaceC0877a r6 = (InterfaceC0877a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0877a.class, "com.obric.memorydata.plugin");
        Object[] r0 = this.f17152b;
        int r4 = this.f17151a;
    L3:
        if (r0 == null) goto L14;
        int r2 = 0;
    L5:
        if (r2 >= r4) goto L13;
        Object r3 = r0[r2];
        if (r3 == null) goto L13;
        if (r6.test(r3) == true) goto L11;
        r2 = r2 + 1;
        goto L5
    L11:
        return;
    L13:
        r0 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r0[r4], Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
        goto L3
    }

    public void a(T r4) {
        int r0 = this.f17151a;
        int r1 = this.d;
        if (r1 != r0) goto L5;
        Object[] r2 = new Object[r0 + 1];
        this.c[r0] = r2;
        this.c = r2;
        r1 = 0;
    L5:
        this.c[r1] = r4;
        this.d = r1 + 1;
    }

    public <U> boolean a(t<? super U> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        Object[] r0 = this.f17152b;
        int r4 = this.f17151a;
    L3:
        int r2 = 0;
        if (r0 == null) goto L15;
    L5:
        if (r2 >= r4) goto L14;
        Object r3 = r0[r2];
        if (r3 == null) goto L14;
        if (NotificationLite.acceptFull(r3, r6) == true) goto L11;
        r2 = r2 + 1;
        goto L5
    L11:
        return true;
    L14:
        r0 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r0[r4], Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
        goto L3
    L15:
        return false;
    }

    public <U> boolean a(org.a.c<? super U> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        Object[] r0 = this.f17152b;
        int r4 = this.f17151a;
    L3:
        int r2 = 0;
        if (r0 == null) goto L15;
    L5:
        if (r2 >= r4) goto L14;
        Object r3 = r0[r2];
        if (r3 == null) goto L14;
        if (NotificationLite.acceptFull(r3, r6) == true) goto L11;
        r2 = r2 + 1;
        goto L5
    L11:
        return true;
    L14:
        r0 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r0[r4], Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
        goto L3
    L15:
        return false;
    }

    public void b(T r2) {
        this.f17152b[0] = r2;
    }
}
