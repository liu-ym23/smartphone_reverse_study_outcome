package com.ss.android.lark.passportc.impl.v2.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateUserRequest {
    public static final AtomicInteger d = null;
    public final d a;
    public final List<d> b;
    public final int c;

    public static final class a {
        public d a;
        public List<d> b;

        public a() {
        }

        public final UpdateUserRequest a() {
            return new UpdateUserRequest(this.a, this.b, UpdateUserRequest.d.incrementAndGet());
        }
    }

    public static final class b {
    }

    static {
        d = new AtomicInteger(100000);
    }

    public final String toString() {
        List<d> r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = "[" + CollectionsKt.joinToString$default(r0, "\n", null, null, 0, null, new UpdateUserRequest$toString$background$1$1(this), 30, null) + ']';
    L7:
        return "{id=" + this.c + ", foreground=" + a(this.a) + ", background=" + r1 + '}';
    L5:
        r1 = null;
        goto L7
    }

    public static String a(d r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.c == false) goto L6;
        String r0 = ", reset=true";
    L10:
        return "{" + r3.a.userId + ", " + r3.b + r0 + '}';
    L6:
        r0 = "";
        goto L10
    }

    public UpdateUserRequest(d r1, List r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
