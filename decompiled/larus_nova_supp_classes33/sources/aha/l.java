package aha;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class l implements jha.o, t {
    public final String a;
    public final String b;
    public final String c;
    public final ObricInteractionType d;
    public final jha.h e;
    public final String f;
    public final Map<String, Object> g;

    public static final class a extends l {
        public final String h;
        public final String i;
        public final String j;
        public final ObricInteractionType k;
        public final ModeRefreshSource l;
        public final jha.h m;
        public final Map<String, Object> n;

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
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L18;
            return false;
        L18:
            if (this.k == r6.k) goto L21;
            return false;
        L21:
            if (this.l == r6.l) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = this.h.hashCode() * 31;
            String r1 = this.i;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((((((r0 + r2) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Active(botId=" + this.h + ", conversationId=" + this.i + ", sessionId=" + this.j + ", interactionType=" + this.k + ", refreshSource=" + this.l + ", lifecycleStage=" + this.m + ", ext=" + this.n + ')';
        }

        @Override // aha.l, jha.a
        public final jha.h a() {
            return this.m;
        }

        @Override // aha.l
        public final String d() {
            return this.i;
        }

        @Override // aha.l
        public final ObricInteractionType e() {
            return this.k;
        }

        @Override // aha.l
        public final String f() {
            return this.j;
        }

        @Override // aha.l, aha.t
        public final String getBotId() {
            return this.h;
        }

        public a(String r9, String r10, String r11, ObricInteractionType r12, ModeRefreshSource r13, Map r14) {
            jha.h.a r7 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r9, "botId");
            Intrinsics.checkNotNullParameter(r11, "sessionId");
            Intrinsics.checkNotNullParameter(r12, "interactionType");
            Intrinsics.checkNotNullParameter(r13, "refreshSource");
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r14, "ext");
            super(r9, r10, r11, r12, r7, r14);
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r7;
            this.n = r14;
        }
    }

    public static final class b extends l {
        public final String h;
        public final String i;
        public final String j;
        public final ObricInteractionType k;
        public final ModeEndReason l;
        public final jha.h m;
        public final Map<String, Object> n;

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
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L18;
            return false;
        L18:
            if (this.k == r6.k) goto L21;
            return false;
        L21:
            if (this.l == r6.l) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = this.h.hashCode() * 31;
            String r1 = this.i;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((((((r0 + r2) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "End(botId=" + this.h + ", conversationId=" + this.i + ", sessionId=" + this.j + ", interactionType=" + this.k + ", reason=" + this.l + ", lifecycleStage=" + this.m + ", ext=" + this.n + ')';
        }

        @Override // aha.l, jha.a
        public final jha.h a() {
            return this.m;
        }

        @Override // aha.l
        public final String d() {
            return this.i;
        }

        @Override // aha.l
        public final ObricInteractionType e() {
            return this.k;
        }

        @Override // aha.l
        public final String f() {
            return this.j;
        }

        @Override // aha.l, aha.t
        public final String getBotId() {
            return this.h;
        }

        public b(String r9, String r10, String r11, ObricInteractionType r12, ModeEndReason r13, Map r14) {
            jha.h.c r7 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r9, "botId");
            Intrinsics.checkNotNullParameter(r11, "sessionId");
            Intrinsics.checkNotNullParameter(r12, "interactionType");
            Intrinsics.checkNotNullParameter(r13, WindowEvent.Params.REASON);
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r14, "ext");
            super(r9, r10, r11, r12, r7, r14);
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r7;
            this.n = r14;
        }
    }

    public static final class c extends l {
        public final String h;
        public final String i;
        public final String j;
        public final ObricInteractionType k;
        public final jha.h l;
        public final Map<String, Object> m;

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
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L18;
            return false;
        L18:
            if (this.k == r6.k) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.h.hashCode() * 31;
            String r1 = this.i;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((((r0 + r2) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Start(botId=" + this.h + ", conversationId=" + this.i + ", sessionId=" + this.j + ", interactionType=" + this.k + ", lifecycleStage=" + this.l + ", ext=" + this.m + ')';
        }

        @Override // aha.l, jha.a
        public final jha.h a() {
            return this.l;
        }

        @Override // aha.l
        public final String d() {
            return this.i;
        }

        @Override // aha.l
        public final ObricInteractionType e() {
            return this.k;
        }

        @Override // aha.l
        public final String f() {
            return this.j;
        }

        @Override // aha.l, aha.t
        public final String getBotId() {
            return this.h;
        }

        public c(String r9, String r10, String r11, ObricInteractionType r12, Map r13) {
            jha.h.a r7 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r9, "botId");
            Intrinsics.checkNotNullParameter(r11, "sessionId");
            Intrinsics.checkNotNullParameter(r12, "interactionType");
            Intrinsics.checkNotNullParameter(r7, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r13, "ext");
            super(r9, r10, r11, r12, r7, r13);
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r7;
            this.m = r13;
        }
    }

    public l() {
        throw null;
    }

    @Override // aha.t
    public final u b() {
        return new u(getBotId(), d(), e(), f());
    }

    @Override // jha.a
    public jha.h a() {
        return this.e;
    }

    @Override // aha.t
    public final String c() {
        return this.f;
    }

    public String d() {
        return this.b;
    }

    public ObricInteractionType e() {
        return this.d;
    }

    public String f() {
        return this.c;
    }

    @Override // aha.t
    public String getBotId() {
        return this.a;
    }

    public l(String r1, String r2, String r3, ObricInteractionType r4, jha.h r5, Map r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r3;
        this.g = r6;
    }
}
