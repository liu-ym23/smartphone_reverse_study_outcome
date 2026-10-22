package zp9;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.profile.impl.creation.w3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final n a;
    public final m b;
    public final s c;
    public final RecyclerView.RecycledViewPool d;

    public e(n r3, m r4, w3 r5, RecyclerView.RecycledViewPool r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "repository");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
