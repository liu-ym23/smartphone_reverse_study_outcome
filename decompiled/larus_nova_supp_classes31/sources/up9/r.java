package up9;

import android.content.Context;
import com.larus.photopicker.v2.impl.j2;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r implements g0 {
    public final g0.a a;
    public final g0.b b;

    @Override // up9.g0
    public final void onDestroyView() {
    }

    @Override // up9.g0
    public final g0.a c() {
        return this.a;
    }

    public r(g0.a r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheetState");
        Intrinsics.checkNotNullParameter(r3, "selectionState");
        this.a = r2;
        this.b = r3;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [up9.q] */
    @Override // up9.g0
    public final MediaListAdapterV2 n(Context r8, int r9, int r10, j2 r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "loadMore");
        MediaListAdapterV2 r0 = new MediaListAdapterV2(r8, r9, r10, r11, new q(this));
        vp9.m r12 = this.a.c(r8, this.b);
        Intrinsics.checkNotNullParameter(r12, "state");
        r0.k = r12;
        return r0;
    }
}
