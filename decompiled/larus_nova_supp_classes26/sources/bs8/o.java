package bs8;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o {
    public final List<TaskSkill> a;
    public final List<TaskSkill> b;
    public final List<TaskSkill> c;
    public final be8.e d;
    public final boolean e;
    public final Integer f;

    public o() {
        this(false, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        be8.e r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.e == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        Integer r7 = this.f;
        if (r7 == null) goto L15;
        r2 = r7.hashCode();
    L15:
        return r6 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskSkillSessionState(selectedSkills=" + this.a + ", memorizedSkills=" + this.b + ", visibleSkills=" + this.c + ", selectedFolder=" + this.d + ", showSkillItem=" + this.e + ", maxVisibleSlotCount=" + this.f + ')';
    }

    public /* synthetic */ o(boolean r10, int r11) {
        List r1 = null;
        if ((r11 & 1) == 0) goto L5;
        List r3 = CollectionsKt.emptyList();
    L7:
        if ((r11 & 2) == 0) goto L9;
        List r4 = CollectionsKt.emptyList();
    L11:
        if ((r11 & 4) == 0) goto L13;
        r1 = CollectionsKt.emptyList();
    L13:
        List r5 = r1;
        if ((r11 & 16) == 0) goto L16;
        boolean r7 = false;
    L17:
        this(r3, r4, r5, null, r7, null);
        return;
    L16:
        r7 = r10;
        goto L17
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public o(List<TaskSkill> r2, List<TaskSkill> r3, List<TaskSkill> r4, be8.e r5, boolean r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r2, "selectedSkills");
        Intrinsics.checkNotNullParameter(r3, "memorizedSkills");
        Intrinsics.checkNotNullParameter(r4, "visibleSkills");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public static o a(o r7, List r8, List r9, List r10, boolean r11, Integer r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        List r1 = r8;
        if ((r13 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        List r2 = r9;
        if ((r13 & 4) == 0) goto L11;
        r10 = r7.c;
    L11:
        List r3 = r10;
        if ((r13 & 8) == 0) goto L14;
        be8.e r14 = r7.d;
    L15:
        be8.e r4 = r14;
        if ((r13 & 16) == 0) goto L18;
        r11 = r7.e;
    L18:
        boolean r5 = r11;
        if ((r13 & 32) == 0) goto L21;
        r12 = r7.f;
    L21:
        Intrinsics.checkNotNullParameter(r1, "selectedSkills");
        Intrinsics.checkNotNullParameter(r2, "memorizedSkills");
        Intrinsics.checkNotNullParameter(r3, "visibleSkills");
        return new o(r1, r2, r3, r4, r5, r12);
    L14:
        r14 = null;
        goto L15
    }
}
