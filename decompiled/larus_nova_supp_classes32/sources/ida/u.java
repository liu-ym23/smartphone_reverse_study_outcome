package ida;

import com.obric.assistant.cocreationreview.ModuleKey;
import hda.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u extends com.obric.assistant.cocreationreview.a {
    public final String a;
    public final ModuleKey b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final e1 m;
    public final String n;
    public final String o;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r5 = this.h;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.i;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.j;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        int r14 = 1231;
        if (this.k == false) goto L21;
        int r15 = 1231;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.l == true) goto L26;
        r14 = 1237;
    L26:
        int r17 = (((((r16 + r14) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31;
        String r18 = this.o;
        if (r18 == null) goto L31;
        r2 = r18.hashCode();
    L31:
        return r17 + r2;
    L21:
        r15 = 1237;
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioMemoryUsageRecord(id=" + this.a + ", module=" + this.b + ", heardAt=" + this.c + ", audioDomain=" + this.d + ", audioScenario=" + this.e + ", audioTitle=" + this.f + ", audioSummary=" + this.g + ", audioFileName=" + this.h + ", audioTranscriptText=" + this.i + ", audioTranscriptContentUrl=" + this.j + ", usesChunkedTranscript=" + this.k + ", hasLegacyOriginalRecording=" + this.l + ", uiModel=" + this.m + ", payload=" + this.n + ", traceJson=" + this.o + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.b;
    }

    public u(String r11, ModuleKey r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, boolean r20, boolean r21, e1 r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r12, "module");
        Intrinsics.checkNotNullParameter(r13, "heardAt");
        Intrinsics.checkNotNullParameter("环境人声", "audioDomain");
        Intrinsics.checkNotNullParameter(r15, "audioTitle");
        Intrinsics.checkNotNullParameter(r16, "audioSummary");
        Intrinsics.checkNotNullParameter(r22, "uiModel");
        Intrinsics.checkNotNullParameter(r23, "payload");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = "环境人声";
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r23;
        this.o = r24;
    }
}
