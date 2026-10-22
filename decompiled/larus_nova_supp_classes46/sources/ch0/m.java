package ch0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    public static final /* synthetic */ int d = 0;
    public final List<ILinkPlayerInfoBridge> a;
    public final long b;
    public final n0 c;

    public static final class a {
        public static m a() {
            return new m(new ArrayList(), 0, null);
        }
    }

    static {
    }

    public final String toString() {
        return "WaitingListMergeData(waitingList=" + this.a + ", totalCount=" + this.b + ", waitingUser=" + this.c + ")";
    }

    public final int hashCode() {
        List<ILinkPlayerInfoBridge> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((int) (((long) (r2 * 37)) + this.b)) * 37;
        n0 r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if ((!Intrinsics.areEqual(m.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r8 == null) goto L34;
        m r9 = (m) r8;
        List<ILinkPlayerInfoBridge> r1 = this.a;
        if (r1 == null) goto L16;
    L17:
        if (r1 != null) goto L19;
    L26:
        n0 r3 = this.c;
        if (r3 != null) goto L29;
    L31:
        return false;
    L29:
        if (r3.equals(r9.c) != true) goto L31;
        return true;
    L19:
        if (r1.equals(r9.a) != true) goto L26;
        if (this.b != r9.b) goto L26;
        if (this.c != null) goto L26;
        if (r9.c != null) goto L26;
        return true;
    L16:
        if (r9.a != null) goto L17;
        return true;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.datamerge.entity.WaitingListMergeData");
    L8:
        r2 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(List<? extends ILinkPlayerInfoBridge> r1, long r2, n0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
