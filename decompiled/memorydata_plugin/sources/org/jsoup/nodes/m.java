package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes7.dex */
public class m {
    private static final String c = null;
    private static final String d = null;
    private static final a e = null;
    private static final m f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f18267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f18268b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18270b;
        private final int c;

        public a(int r1, int r2, int r3) {
            this.f18269a = r1;
            this.f18270b = r2;
            this.c = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L21;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f18269a == r6.f18269a) goto L14;
            return false;
        L14:
            if (this.f18270b == r6.f18270b) goto L17;
            return false;
        L17:
            if (this.c != r6.c) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return (((this.f18269a * 31) + this.f18270b) * 31) + this.c;
        }

        public String toString() {
            return this.f18270b + "," + this.c + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.f18269a;
        }
    }

    static {
        c = b.i("jsoup.sourceRange");
        d = b.i("jsoup.endSourceRange");
        a r0 = new a(-1, -1, -1);
        e = r0;
        f = new m(r0, r0);
    }

    public m(a r1, a r2) {
        this.f18267a = r1;
        this.f18268b = r2;
    }

    static m a(j r1, boolean r2) {
        if (r2 == false) goto L4;
        String r3 = c;
    L6:
        if (r1.c(r3) == true) goto L10;
        return f;
    L10:
        return (m) ZeusTransformUtils.preCheckCast(org.jsoup.helper.b.b(r1.p().d(r3)), m.class, "com.obric.memorydata.plugin");
    L4:
        r3 = d;
        goto L6
    }

    public boolean a() {
        if (this == f) goto L5;
        return true;
    L5:
        return false;
    }

    public void b(j r1, boolean r2) {
        b r3 = r1.p();
        if (r2 == false) goto L5;
        String r4 = c;
    L6:
        r3.a(r4, this);
        return;
    L5:
        r4 = d;
        goto L6
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L15;
        m r5 = (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.memorydata.plugin");
        if (this.f18267a.equals(r5.f18267a) == true) goto L14;
        return false;
    L14:
        return this.f18268b.equals(r5.f18268b);
    }

    public int hashCode() {
        return (this.f18267a.hashCode() * 31) + this.f18268b.hashCode();
    }

    public String toString() {
        return this.f18267a + "-" + this.f18268b;
    }
}
