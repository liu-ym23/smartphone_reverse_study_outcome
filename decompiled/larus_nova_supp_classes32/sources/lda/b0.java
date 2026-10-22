package lda;

import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 extends com.obric.assistant.cocreationreview.a {
    public final String a;
    public final ModuleKey b;
    public final String c;
    public final long d;
    public final String e;
    public final String f;
    public final OmniTaskStatus g;
    public final OmniTaskTriggerType h;
    public final List<c> i;
    public final String j;
    public final String k;
    public final a5 l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r9 = (b0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (((((((((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        a5 r3 = this.l;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r2 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "OmniUsageRecord(id=" + this.a + ", module=" + this.b + ", taskId=" + this.c + ", createdAt=" + this.d + ", userQuery=" + this.e + ", doubaoAnswer=" + this.f + ", status=" + this.g + ", taskTriggerType=" + this.h + ", steps=" + this.i + ", timeCost=" + this.j + ", payload=" + this.k + ", feedback=" + this.l + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.b;
    }

    public /* synthetic */ b0(String r15, ModuleKey r16, String r17, long r18, String r20, String r21, OmniTaskStatus r22, OmniTaskTriggerType r23, List r24, String r25) {
        this(r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r17, null);
    }

    public b0(String r2, ModuleKey r3, String r4, long r5, String r7, String r8, OmniTaskStatus r9, OmniTaskTriggerType r10, List<c> r11, String r12, String r13, a5 r14) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r7, "userQuery");
        Intrinsics.checkNotNullParameter(r8, "doubaoAnswer");
        Intrinsics.checkNotNullParameter(r9, "status");
        Intrinsics.checkNotNullParameter(r10, "taskTriggerType");
        Intrinsics.checkNotNullParameter(r11, "steps");
        Intrinsics.checkNotNullParameter(r12, "timeCost");
        Intrinsics.checkNotNullParameter(r13, "payload");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
