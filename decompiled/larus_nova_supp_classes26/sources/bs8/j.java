package bs8;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final List<TaskSkill> a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "RecentExposedSkills(skills=" + this.a + ", maxVisibleSlotCount=" + this.b + ')';
    }

    public j() {
        this(CollectionsKt.emptyList(), 0);
    }

    public j(List<TaskSkill> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "skills");
        this.a = r2;
        this.b = r3;
    }
}
