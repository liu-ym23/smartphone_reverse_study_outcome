package i31;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final PkBaseStateMachine.c a;
    public final IBaseBattleSetting b;
    public final long c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L12;
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PkBaseStateMachine.c r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        IBaseBattleSetting r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.c;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiPkBeforeFinishData(pkStateBeforeFinish=" + this.a + ", battleSetting=" + this.b + ", timestamp=" + this.c + ")";
    }

    public a(PkBaseStateMachine.c r4, IBaseBattleSetting r5) {
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r4, "pkStateBeforeFinish");
        this.a = r4;
        this.b = r5;
        this.c = r1;
    }
}
