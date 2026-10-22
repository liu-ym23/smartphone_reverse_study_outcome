package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final q f5032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f5033b = false;
    private static boolean c = true;
    private static volatile q d;
    private final Map<a, GeneratedMessageLite.e<?, ?>> e;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f5034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5035b;

        a(Object r1, int r2) {
            this.f5034a = r1;
            this.f5035b = r2;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L5;
            return false;
        L5:
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
            if (this.f5034a == r5.f5034a) goto L8;
            return false;
        L8:
            if (this.f5035b != r5.f5035b) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f5034a) * 65535) + this.f5035b;
        }
    }

    static {
        f5032a = new q(true);
    }

    q() {
        this.e = new HashMap();
    }

    q(boolean r1) {
        this.e = Collections.emptyMap();
    }

    public static q a() {
        if (c == false) goto L5;
        q r0 = d;
        if (r0 == null) goto L9;
    L18:
        return r0;
    L9:
        monitor-enter(q.class);
        r0 = d;     // Catch: Throwable -> L15
        if (r0 != null) goto L13;
        r0 = p.b();     // Catch: Throwable -> L15
        d = r0;     // Catch: Throwable -> L15
    L13:
        monitor-exit(q.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L5:
        return f5032a;
    }

    public <ContainingType extends at> GeneratedMessageLite.e<ContainingType, ?> a(ContainingType r3, int r4) {
        at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        return (GeneratedMessageLite.e) ZeusTransformUtils.preCheckCast(this.e.get(new a(r5, r4)), GeneratedMessageLite.e.class, "com.obric.memorydata.plugin");
    }
}
