package com.bytedance.android.live.revenue.core;

import com.bytedance.android.scope.j;
import com.bytedance.android.scope.m;
import cy0.k;
import cy0.l;
import java.util.HashMap;
import java.util.Map;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements a, b, com.bytedance.live.kmp.core.a {
    public final l a;
    public final k b;
    public final Map<Class<?>, j> c;
    public final com.bytedance.live.kmp.core.a d;

    @Override // com.bytedance.android.live.revenue.core.b
    public final vh6.a a() {
        return this.d.a();
    }

    public final u60.a c() {
        return this.d.c();
    }

    @Override // com.bytedance.android.live.revenue.core.b
    public final void start() {
        com.bytedance.android.scope.l.a(this.a);
        com.bytedance.android.scope.l.a(this.b);
    }

    public final void stop() {
        com.bytedance.android.scope.l.c(this.b);
        com.bytedance.android.scope.l.c(this.a);
        ((HashMap) this.c).clear();
    }

    @Override // com.bytedance.android.live.revenue.core.b
    public final l e() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revenue.core.a
    public final k getScope() {
        return this.b;
    }

    public e(com.bytedance.live.kmp.core.a r8) {
        String r0 = "roomInstance";
        Intrinsics.checkNotNullParameter(r8, "roomInstance");
        this.d = r8;
        l r9 = new l(c());
        Intrinsics.checkNotNullParameter(r9, "scope");
        Intrinsics.checkNotNullParameter(this, "value");
        r9.e = this;
        Object r3 = e33.k.a;
        if (this != r3) goto L6;
        String r6 = "revenueInstanceExt";
    L9:
        if (r6 != null) goto L26;
        this.a = r9;
        k r7 = new k(r9);
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(this, "value");
        r7.e = this;
        if (this != r3) goto L14;
        r0 = "revenueInstance";
    L20:
        if (r0 != null) goto L24;
        this.b = r7;
        this.c = new HashMap();
        return;
    L24:
        throw new UninitializedPropertyAccessException(r0);
    L14:
        if (r7.f != r3) goto L17;
        r0 = "revenueInstanceExt";
        goto L20
    L17:
        if (r7.g == r3) goto L20;
        r0 = null;
        goto L20
    L26:
        throw new UninitializedPropertyAccessException(r6);
    L6:
        if (r9.f != r3) goto L8;
        r6 = "roomInstance";
        goto L9
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revenue.core.b
    public final <T extends dy0.d> T getService(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        j r0 = (j) ((HashMap) this.c).get(r3);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) m.e.d(r0, r3);
    }

    @Override // com.bytedance.android.live.revenue.core.a
    public final void b(Class r2, cy0.f r3) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        Intrinsics.checkNotNullParameter(r3, "scope");
        if (m.e.d(r3, r2) == null) goto L7;
        ((HashMap) this.c).put(r2, r3);
        return;
    L7:
        throw new IllegalArgumentException("Service is not accessible");
    }

    @Override // com.bytedance.android.live.revenue.core.a
    public final void d(KClass r2, cy0.f r3) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        Intrinsics.checkNotNullParameter(r3, "scope");
        b(JvmClassMappingKt.getJavaClass(r2), r3);
    }
}
