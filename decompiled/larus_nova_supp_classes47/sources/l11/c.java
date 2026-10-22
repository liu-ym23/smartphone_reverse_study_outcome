package l11;

import com.bytedance.android.scope.o;
import java.util.Map;
import k11.f;
import k11.g;
import k11.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements g, f, o {
    public k11.c a;

    public c() {
    }

    @Override // k11.g
    public final void loadLinker(long r1, long r3, boolean r5, k r6) {
        Intrinsics.checkNotNullParameter(r6, "logInfo");
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // k11.g
    public final void unloadLinker(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
    }

    @Override // k11.f
    public final k11.c a() {
        return this.a;
    }

    @Override // k11.g
    public final void updateLinkInfo(Map<String, String> r5, long r6, Map<String, String> r8) {
        if (r6 != 0) goto L7;
        this.a = null;
        return;
    L7:
        if (r5 == null) goto L9;
        Map r7 = MapsKt.toMap(r5);
    L10:
        if (r8 == null) goto L12;
        Map r9 = MapsKt.toMap(r8);
    L13:
        this.a = new k11.c(r7, r6, r9);
        StringBuilder r10 = new StringBuilder("updateLinkInfo ");
        k11.c r12 = this.a;
        if (r12 == null) goto L16;
        Map<String, String> r13 = r12.a;
    L17:
        r10.append(r13);
        jy0.b.c("LoadLinkerService", r10.toString(), null, 4);
        return;
    L16:
        r13 = null;
        goto L17
    L12:
        r9 = null;
        goto L13
    L9:
        r7 = null;
        goto L10
    }
}
