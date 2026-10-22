package aha;

import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class d implements jha.o, t {
    public final String a;
    public final String b;
    public final DMTaskInfo c;
    public final jha.h d;
    public final Map<String, String> e;
    public final u f;

    public static final class a extends d {
        public final String g;
        public final String h;
        public final Integer i;
        public final DMTaskInfo j;
        public final jha.h k;
        public final Map<String, String> l;
        public final u m;

        public a() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.g;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.h;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.i;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            DMTaskInfo r10 = this.j;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (((r9 + r11) * 31) + this.k.hashCode()) * 31;
            Map<String, String> r13 = this.l;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return ((r12 + r1) * 31) + this.m.hashCode();
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Active(conversationId=" + this.g + ", taskId=" + this.h + ", dmComplexTaskState=" + this.i + ", taskInfo=" + this.j + ", lifecycleStage=" + this.k + ", ext=" + this.l + ", taskMetadata=" + this.m + ')';
        }

        @Override // aha.d, jha.a
        public final jha.h a() {
            return this.k;
        }

        @Override // aha.d, aha.t
        public final u b() {
            return this.m;
        }

        @Override // aha.d
        public final String d() {
            return this.g;
        }

        @Override // aha.d
        public final Map<String, String> e() {
            return this.l;
        }

        @Override // aha.d
        public final String f() {
            return this.h;
        }

        @Override // aha.d
        public final DMTaskInfo g() {
            return this.j;
        }

        public a(String r9, String r10, Integer r11, DMTaskInfo r12, Map r13, u r14) {
            jha.h.a r7 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r14, "taskMetadata");
            super(r9, r10, r12, r7, r13, r14);
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r7;
            this.l = r13;
            this.m = r14;
        }
    }

    public static final class b extends d {
        public final String g;
        public final String h;
        public final Integer i;
        public final DMTaskInfo j;
        public final jha.h k;
        public final Map<String, String> l;
        public final u m;

        public b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.g;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.h;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.i;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            DMTaskInfo r10 = this.j;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (((r9 + r11) * 31) + this.k.hashCode()) * 31;
            Map<String, String> r13 = this.l;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return ((r12 + r1) * 31) + this.m.hashCode();
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Init(conversationId=" + this.g + ", taskId=" + this.h + ", dmComplexTaskState=" + this.i + ", taskInfo=" + this.j + ", lifecycleStage=" + this.k + ", ext=" + this.l + ", taskMetadata=" + this.m + ')';
        }

        @Override // aha.d, jha.a
        public final jha.h a() {
            return this.k;
        }

        @Override // aha.d, aha.t
        public final u b() {
            return this.m;
        }

        @Override // aha.d
        public final String d() {
            return this.g;
        }

        @Override // aha.d
        public final Map<String, String> e() {
            return this.l;
        }

        @Override // aha.d
        public final String f() {
            return this.h;
        }

        @Override // aha.d
        public final DMTaskInfo g() {
            return this.j;
        }

        public b(String r9, String r10, DMTaskInfo r11, Map r12, u r13) {
            jha.h.a r7 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r13, "taskMetadata");
            super(r9, r10, r11, r7, r12, r13);
            this.g = r9;
            this.h = r10;
            this.i = null;
            this.j = r11;
            this.k = r7;
            this.l = r12;
            this.m = r13;
        }
    }

    public static final class c extends d {
        public final String g;
        public final String h;
        public final Integer i;
        public final DMTaskInfo j;
        public final jha.h k;
        public final Map<String, String> l;
        public final u m;

        public c() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.g;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.h;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.i;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            DMTaskInfo r10 = this.j;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (((r9 + r11) * 31) + this.k.hashCode()) * 31;
            Map<String, String> r13 = this.l;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return ((r12 + r1) * 31) + this.m.hashCode();
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Terminated(conversationId=" + this.g + ", taskId=" + this.h + ", dmComplexTaskState=" + this.i + ", taskInfo=" + this.j + ", lifecycleStage=" + this.k + ", ext=" + this.l + ", taskMetadata=" + this.m + ')';
        }

        @Override // aha.d, jha.a
        public final jha.h a() {
            return this.k;
        }

        @Override // aha.d, aha.t
        public final u b() {
            return this.m;
        }

        @Override // aha.d
        public final String d() {
            return this.g;
        }

        @Override // aha.d
        public final Map<String, String> e() {
            return this.l;
        }

        @Override // aha.d
        public final String f() {
            return this.h;
        }

        @Override // aha.d
        public final DMTaskInfo g() {
            return this.j;
        }

        public c(String r9, String r10, Integer r11, DMTaskInfo r12, Map r13, u r14) {
            jha.h.c r7 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r14, "taskMetadata");
            super(r9, r10, r12, r7, r13, r14);
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r7;
            this.l = r13;
            this.m = r14;
        }
    }

    public d() {
        throw null;
    }

    @Override // aha.t
    public final String c() {
        return b().d;
    }

    @Override // aha.t
    public final String getBotId() {
        return b().a;
    }

    @Override // jha.a
    public jha.h a() {
        return this.d;
    }

    @Override // aha.t
    public u b() {
        return this.f;
    }

    public String d() {
        return this.a;
    }

    public Map<String, String> e() {
        return this.e;
    }

    public String f() {
        return this.b;
    }

    public DMTaskInfo g() {
        return this.c;
    }

    public d(String r1, String r2, DMTaskInfo r3, jha.h r4, Map r5, u r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
