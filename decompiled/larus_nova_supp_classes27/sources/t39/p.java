package t39;

import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.IDoraService;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public final IDoraService.Debug.ResourceConfigSyncStatus a;
    public final Set<DoraEnableScope> b;
    public final Set<DoraEnableScope> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ResourceConfigSyncResult(status=" + this.a + ", updatedScopes=" + this.b + ", skippedScopes=" + this.c + ')';
    }

    public /* synthetic */ p(IDoraService.Debug.ResourceConfigSyncStatus r3) {
        this(r3, SetsKt.emptySet(), SetsKt.emptySet());
    }

    public p(IDoraService.Debug.ResourceConfigSyncStatus r2, Set<? extends DoraEnableScope> r3, Set<? extends DoraEnableScope> r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "updatedScopes");
        Intrinsics.checkNotNullParameter(r4, "skippedScopes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
