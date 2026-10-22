package aha;

import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class h0 implements jha.o, t {
    public final jha.h a;
    public final Map<String, Object> b;
    public final u c;

    public static final class a extends h0 {
        public final String d;
        public final VoiceCaptureScene e;
        public final Integer f;
        public final jha.h g;
        public final Map<String, Object> h;
        public final u i;

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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (this.e == r6.e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.d;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.e.hashCode()) * 31;
            Integer r4 = this.f;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + this.g.hashCode()) * 31;
            Map<String, Object> r7 = this.h;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return ((r6 + r1) * 31) + this.i.hashCode();
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsrEnd(conversationId=" + this.d + ", scene=" + this.e + ", sourceType=" + this.f + ", lifecycleStage=" + this.g + ", ext=" + this.h + ", taskMetadata=" + this.i + ')';
        }

        @Override // aha.h0, jha.a
        public final jha.h a() {
            return this.g;
        }

        @Override // aha.h0, aha.t
        public final u b() {
            return this.i;
        }

        @Override // aha.h0
        public final Map<String, Object> d() {
            return this.h;
        }

        public a(String r3, VoiceCaptureScene r4, Integer r5, Map r6, u r7) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r4, "scene");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r7, "taskMetadata");
            super(r0, r6, r7);
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r0;
            this.h = r6;
            this.i = r7;
        }
    }

    public static final class b extends h0 {
        public final String d;
        public final VoiceCaptureScene e;
        public final Integer f;
        public final jha.h g;
        public final Map<String, Object> h;
        public final u i;

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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (this.e == r6.e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.d;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.e.hashCode()) * 31;
            Integer r4 = this.f;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + this.g.hashCode()) * 31;
            Map<String, Object> r7 = this.h;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return ((r6 + r1) * 31) + this.i.hashCode();
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsrStart(conversationId=" + this.d + ", scene=" + this.e + ", sourceType=" + this.f + ", lifecycleStage=" + this.g + ", ext=" + this.h + ", taskMetadata=" + this.i + ')';
        }

        @Override // aha.h0, jha.a
        public final jha.h a() {
            return this.g;
        }

        @Override // aha.h0, aha.t
        public final u b() {
            return this.i;
        }

        @Override // aha.h0
        public final Map<String, Object> d() {
            return this.h;
        }

        public b(String r3, VoiceCaptureScene r4, Integer r5, Map r6, u r7) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r4, "scene");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r7, "taskMetadata");
            super(r0, r6, r7);
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r0;
            this.h = r6;
            this.i = r7;
        }
    }

    public static final class c extends h0 {
        public final String d;
        public final VoiceCaptureScene e;
        public final Integer f;
        public final jha.h g;
        public final Map<String, Object> h;
        public final u i;

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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (this.e == r6.e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.d;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.e.hashCode()) * 31;
            Integer r4 = this.f;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + this.g.hashCode()) * 31;
            Map<String, Object> r7 = this.h;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return ((r6 + r1) * 31) + this.i.hashCode();
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "End(conversationId=" + this.d + ", scene=" + this.e + ", sourceType=" + this.f + ", lifecycleStage=" + this.g + ", ext=" + this.h + ", taskMetadata=" + this.i + ')';
        }

        @Override // aha.h0, jha.a
        public final jha.h a() {
            return this.g;
        }

        @Override // aha.h0, aha.t
        public final u b() {
            return this.i;
        }

        @Override // aha.h0
        public final Map<String, Object> d() {
            return this.h;
        }

        public c(String r3, VoiceCaptureScene r4, Integer r5, Map r6, u r7) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r4, "scene");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r7, "taskMetadata");
            super(r0, r6, r7);
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r0;
            this.h = r6;
            this.i = r7;
        }
    }

    public static final class d extends h0 {
        public final String d;
        public final VoiceCaptureScene e;
        public final Integer f;
        public final jha.h g;
        public final Map<String, Object> h;
        public final u i;

        public d() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (this.e == r6.e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.d;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.e.hashCode()) * 31;
            Integer r4 = this.f;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + this.g.hashCode()) * 31;
            Map<String, Object> r7 = this.h;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return ((r6 + r1) * 31) + this.i.hashCode();
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Start(conversationId=" + this.d + ", scene=" + this.e + ", sourceType=" + this.f + ", lifecycleStage=" + this.g + ", ext=" + this.h + ", taskMetadata=" + this.i + ')';
        }

        @Override // aha.h0, jha.a
        public final jha.h a() {
            return this.g;
        }

        @Override // aha.h0, aha.t
        public final u b() {
            return this.i;
        }

        @Override // aha.h0
        public final Map<String, Object> d() {
            return this.h;
        }

        public d(String r3, VoiceCaptureScene r4, Integer r5, Map r6, u r7) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r4, "scene");
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r7, "taskMetadata");
            super(r0, r6, r7);
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r0;
            this.h = r6;
            this.i = r7;
        }
    }

    public h0() {
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
        return this.a;
    }

    @Override // aha.t
    public u b() {
        return this.c;
    }

    public Map<String, Object> d() {
        return this.b;
    }

    public h0(jha.h r1, Map r2, u r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
