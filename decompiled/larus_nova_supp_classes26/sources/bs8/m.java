package bs8;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public final List<TaskSkill> a;
    public final boolean b;
    public final long c;

    public m() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        long r3 = this.c;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskSkillListCache(skills=" + this.a + ", hasMore=" + this.b + ", updateTimeMs=" + this.c + ')';
    }

    public /* synthetic */ m(int r4) {
        this(CollectionsKt.emptyList(), false, 0);
    }

    public m(List<TaskSkill> r2, boolean r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "skills");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
