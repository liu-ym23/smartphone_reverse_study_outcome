package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DomainPreConnect {
    public static HashMap<String, a> a;
    public static final Lazy b = null;
    public static final DomainPreConnect c = null;

    public static final class a {
        public long a;
        public boolean b;
        public long c;
        public final String d;
        public final long e;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L10;
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L8;
            return false;
        L8:
            if (this.e == r11.e) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.d;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r10 = this.e;
            return (r1 * 31) + ((int) (r10 ^ (r10 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "PreConnectConfig(domainUrl=" + this.d + ", minIntervalNanoTime=" + this.e + ")";
        }

        public a(String r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "domainUrl");
            this.d = r10;
            this.e = r11;
        }
    }

    public DomainPreConnect() {
    }

    static {
        c = new DomainPreConnect();
        b = LazyKt.lazy(DomainPreConnect$preConnectHandler$2.INSTANCE);
    }

    public final void a(com.bytedance.android.ec.core.imagex.r r10) {
        a r1 = null;
        if ((r10 instanceof com.bytedance.android.ec.core.imagex.u) == true) goto L5;
        r10 = null;
    L5:
        com.bytedance.android.ec.core.imagex.u r11 = (com.bytedance.android.ec.core.imagex.u) r10;
        if (r11 == null) goto L10;
        com.bytedance.android.shopping.api.image.r r12 = r11.z;
        if (r12 == null) goto L10;
        String r13 = r12.getDomain();
    L11:
        c.getClass();
        ImageDomainPreConnectConfig r0 = ImageDomainPreConnectConfig.d;
        r0.getClass();
        if (((Boolean) ImageDomainPreConnectConfig.b.getValue()).booleanValue() == true) goto L14;
        return;
    L14:
        if (((com.bytedance.android.shopping.api.image.a0) ImageDomainPreConnectConfig.c.getValue(r0, ImageDomainPreConnectConfig.a[0])) == null) goto L31;
        if (r13 == null) goto L20;
        HashMap<String, a> r14 = a;
        if (r14 == null) goto L20;
        r1 = r14.get(r13);
    L20:
        if (r1 != null) goto L22;
        return;
    L22:
        if (r1.b == true) goto L29;
        long r15 = System.nanoTime();
        if ((r15 - r1.c) <= r1.e) goto L30;
        r1.b = true;
        r1.a = r15;
        ((DomainPreConnect$preConnectHandler$2.a) b.getValue()).post(new o(r1, r15));
        Logger.d("ImageDomainPreConnectConfig", "duration " + ThreadMethodProxy.currentThread().getName() + ' ' + com.bytedance.android.ec.core.imagex.common.e.a(r15));
        return;
    L30:
        return;
    L29:
        return;
    L31:
        return;
    L10:
        r13 = null;
        goto L11
    }
}
