package org.apache.logging.log4j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.logging.log4j.util.q;

/* JADX INFO: loaded from: classes6.dex */
public final class MarkerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<String, Marker> f17880a = null;

    public static class Log4jMarker implements Marker, q {
        private static final long serialVersionUID = 100;
        private final String name;
        private volatile Marker[] parents;

        private Log4jMarker() {
            this.name = null;
            this.parents = null;
        }

        public Log4jMarker(String r2) {
            MarkerManager.a(r2, "Marker name cannot be null.");
            this.name = r2;
            this.parents = null;
        }

        private static void addParentInfo(StringBuilder r6, Marker... r7) {
            r6.append("[ ");
            int r1 = r7.length;
            boolean r3 = true;
            int r4 = 0;
        L3:
            if (r4 >= r1) goto L14;
            Marker r5 = r7[r4];
            if (r3 == true) goto L7;
            r6.append(", ");
        L7:
            r6.append(r5.getName());
            if (ZeusTransformUtils.instanceOf(r5, Log4jMarker.class) == false) goto L10;
            Marker[] r8 = ((Log4jMarker) ZeusTransformUtils.preCheckCast(r5, Log4jMarker.class, "com.obric.memorydata.plugin")).parents;
        L11:
            if (r8 == null) goto L13;
            addParentInfo(r6, r8);
        L13:
            r4 = r4 + 1;
            r3 = false;
            goto L3
        L10:
            r8 = r5.getParents();
            goto L11
        L14:
            r6.append(" ]");
        }

        private static boolean checkParent(Marker r5, Marker r6) {
            Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r5, Marker.class, "com.obric.memorydata.plugin");
            Marker r8 = (Marker) ZeusTransformUtils.wrapperContextForParams(r6, Marker.class, "com.obric.memorydata.plugin");
            if (r7 != r8) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, Log4jMarker.class) == false) goto L8;
            Marker[] r9 = ((Log4jMarker) ZeusTransformUtils.preCheckCast(r7, Log4jMarker.class, "com.obric.memorydata.plugin")).parents;
        L10:
            if (r9 == null) goto L30;
            int r2 = r9.length;
            if (r2 != 1) goto L16;
            return checkParent(r9[0], r8);
        L16:
            if (r2 == 2) goto L18;
            int r3 = 0;
        L25:
            if (r3 >= r2) goto L30;
            if (checkParent(r9[r3], r8) == true) goto L28;
            r3 = r3 + 1;
            goto L25
        L28:
            return true;
        L18:
            if (checkParent(r9[0], r8) == false) goto L20;
            return true;
        L20:
            if (checkParent(r9[1], r8) == false) goto L23;
            return true;
        L23:
            return false;
        L30:
            return false;
        L8:
            r9 = r7.getParents();
            goto L10
        }

        private static boolean contains(Marker r4, Marker... r5) {
            Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r4, Marker.class, "com.obric.memorydata.plugin");
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (r5[r2] == r6) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // org.apache.logging.log4j.Marker
        public synchronized Marker addParents(Marker... r8) {
            monitor-enter(this);
            MarkerManager.a(r8, "A parent marker must be specified");     // Catch: Throwable -> L36
            Marker[] r0 = this.parents;     // Catch: Throwable -> L36
            int r1 = r8.length;     // Catch: Throwable -> L36
            int r2 = 0;
            if (r0 == null) goto L17;
            int r3 = r8.length;     // Catch: Throwable -> L36
            int r4 = 0;
            int r5 = 0;
        L6:
            if (r4 >= r3) goto L13;
            Marker r6 = r8[r4];     // Catch: Throwable -> L36
            if (contains(r6, r0) == true) goto L12;
            if (r6.isInstanceOf(this) == true) goto L12;
            r5 = r5 + 1;
        L12:
            r4 = r4 + 1;
            goto L6
        L13:
            if (r5 != 0) goto L16;
            monitor-exit(this);
            return this;
        L16:
            r1 = r0.length + r5;     // Catch: Throwable -> L36
        L17:
            Marker[] r7 = new Marker[r1];     // Catch: Throwable -> L36
            if (r0 == null) goto L20;
            System.arraycopy(r0, 0, r7, 0, r0.length);     // Catch: Throwable -> L36
        L20:
            if (r0 != null) goto L22;
            int r9 = 0;
        L23:
            int r10 = r8.length;     // Catch: Throwable -> L36
        L24:
            if (r2 >= r10) goto L33;
            Marker r11 = r8[r2];     // Catch: Throwable -> L36
            if (r0 != null) goto L28;
        L31:
            r7[r9] = r11;     // Catch: Throwable -> L36
            r9 = r9 + 1;     // Catch: Throwable -> L36
        L32:
            r2 = r2 + 1;     // Catch: Throwable -> L36
            goto L24
        L28:
            if (contains(r11, r0) == true) goto L32;
            if (r11.isInstanceOf(this) == true) goto L32;
        L33:
            this.parents = r7;     // Catch: Throwable -> L36
            monitor-exit(this);
            return this;
        L22:
            r9 = r0.length;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            throw th;
        }

        @Override // org.apache.logging.log4j.Marker
        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, Marker.class) == false) goto L13;
            Marker r4 = (Marker) ZeusTransformUtils.preCheckCast(r3, Marker.class, "com.obric.memorydata.plugin");
            return this.name.equals(r4.getName());
        L13:
            return false;
        }

        @Override // org.apache.logging.log4j.util.q
        public void formatTo(StringBuilder r2) {
            r2.append(this.name);
            Marker[] r1 = this.parents;
            if (r1 == null) goto L6;
            addParentInfo(r2, r1);
            return;
        }

        @Override // org.apache.logging.log4j.Marker
        public String getName() {
            return this.name;
        }

        @Override // org.apache.logging.log4j.Marker
        public Marker[] getParents() {
            Marker[] r2 = this.parents;
            if (r2 != null) goto L7;
            return null;
        L7:
            return (Marker[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), Marker[].class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.logging.log4j.Marker
        public boolean hasParents() {
            if (this.parents == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.logging.log4j.Marker
        public int hashCode() {
            return this.name.hashCode();
        }

        @Override // org.apache.logging.log4j.Marker
        public boolean isInstanceOf(String r6) {
            MarkerManager.a(r6, "A marker name is required");
            if (r6.equals(getName()) == false) goto L5;
            return true;
        L5:
            Marker r7 = (Marker) ZeusTransformUtils.preCheckCast(MarkerManager.a().get(r6), Marker.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L8;
            return false;
        L8:
            Marker[] r5 = this.parents;
            if (r5 == null) goto L29;
            int r2 = r5.length;
            if (r2 != 1) goto L15;
            return checkParent(r5[0], r7);
        L15:
            if (r2 == 2) goto L17;
            int r3 = 0;
        L24:
            if (r3 >= r2) goto L29;
            if (checkParent(r5[r3], r7) == true) goto L27;
            r3 = r3 + 1;
            goto L24
        L27:
            return true;
        L17:
            if (checkParent(r5[0], r7) == false) goto L19;
            return true;
        L19:
            if (checkParent(r5[1], r7) == false) goto L22;
            return true;
        L22:
            return false;
        L29:
            return false;
        }

        @Override // org.apache.logging.log4j.Marker
        public boolean isInstanceOf(Marker r6) {
            Marker r7 = (Marker) ZeusTransformUtils.wrapperContextForParams(r6, Marker.class, "com.obric.memorydata.plugin");
            MarkerManager.a(r7, "A marker parameter is required");
            if (this != r7) goto L5;
            return true;
        L5:
            Marker[] r5 = this.parents;
            if (r5 == null) goto L26;
            int r2 = r5.length;
            if (r2 != 1) goto L12;
            return checkParent(r5[0], r7);
        L12:
            if (r2 == 2) goto L14;
            int r3 = 0;
        L21:
            if (r3 >= r2) goto L26;
            if (checkParent(r5[r3], r7) == true) goto L24;
            r3 = r3 + 1;
            goto L21
        L24:
            return true;
        L14:
            if (checkParent(r5[0], r7) == false) goto L16;
            return true;
        L16:
            if (checkParent(r5[1], r7) == false) goto L19;
            return true;
        L19:
            return false;
        L26:
            return false;
        }

        @Override // org.apache.logging.log4j.Marker
        public synchronized boolean remove(Marker r11) {
            monitor-enter(this);
            Marker r12 = (Marker) ZeusTransformUtils.wrapperContextForParams(r11, Marker.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
            MarkerManager.a(r12, "A parent marker must be specified");     // Catch: Throwable -> L31
            Marker[] r0 = this.parents;     // Catch: Throwable -> L31
            if (r0 != null) goto L8;
            monitor-exit(this);
            return false;
        L8:
            int r2 = r0.length;     // Catch: Throwable -> L31
            if (r2 == 1) goto L11;
            int r4 = r2 - 1;
            Marker[] r5 = new Marker[r4];     // Catch: Throwable -> L31
            int r6 = 0;
            int r7 = 0;
        L19:
            if (r6 >= r2) goto L28;
            Marker r8 = r0[r6];     // Catch: Throwable -> L31
            if (r8.equals(r12) == true) goto L27;
            if (r7 == r4) goto L23;
            int r9 = r7 + 1;
            r5[r7] = r8;     // Catch: Throwable -> L31
            r7 = r9;
            goto L27
        L23:
            monitor-exit(this);
            return false;
        L27:
            r6 = r6 + 1;     // Catch: Throwable -> L31
            goto L19
        L28:
            this.parents = r5;     // Catch: Throwable -> L31
            monitor-exit(this);
            return true;
        L11:
            if (r0[0].equals(r12) == false) goto L15;
            this.parents = null;     // Catch: Throwable -> L31
            monitor-exit(this);
            return true;
        L15:
            monitor-exit(this);
            return false;
        L31:
            th = move-exception;
            throw th;
        }

        @Override // org.apache.logging.log4j.Marker
        public Marker setParents(Marker... r4) {
            if (r4 != null) goto L4;
        L7:
            this.parents = null;
        L8:
            return this;
        L4:
            if (r4.length == 0) goto L7;
            Marker[] r0 = new Marker[r4.length];
            System.arraycopy(r4, 0, r0, 0, r4.length);
            this.parents = r0;
            goto L8
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            formatTo(r0);
            return r0.toString();
        }
    }

    static {
        f17880a = new ConcurrentHashMap();
    }

    static /* synthetic */ ConcurrentMap a() {
        return f17880a;
    }

    public static Marker a(String r4) {
        ConcurrentMap<String, Marker> r0 = f17880a;
        Marker r1 = (Marker) ZeusTransformUtils.preCheckCast(r0.get(r4), Marker.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        r0.putIfAbsent(r4, new Log4jMarker(r4));
        return (Marker) ZeusTransformUtils.preCheckCast(r0.get(r4), Marker.class, "com.obric.memorydata.plugin");
    L6:
        return r1;
    }

    static /* synthetic */ void a(Object r0, String r1) {
        b(r0, r1);
    }

    private static void b(Object r0, String r1) {
        if (r0 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }
}
