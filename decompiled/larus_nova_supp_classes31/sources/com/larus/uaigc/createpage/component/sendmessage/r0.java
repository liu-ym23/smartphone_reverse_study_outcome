package com.larus.uaigc.createpage.component.sendmessage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r0 {
    public static final ConcurrentHashMap<String, a> a = null;

    public static final class a {
        public final long a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "VideoContext(maxDurationSeconds=" + this.a + ", updatedAtMs=" + this.b + ')';
        }

        public a(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void a() {
        long r0 = System.currentTimeMillis() - 300000;
        Set<Map.Entry<String, a>> r2 = a.entrySet();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if (((a) ((Map.Entry) r5).getValue()).b >= r0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        r6 = false;
        goto L9
    L11:
        Iterator r1 = r3.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        Map.Entry r7 = (Map.Entry) r1.next();
        a.remove(r7.getKey(), r7.getValue());
        goto L13
    }
}
