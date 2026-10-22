package ed2;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.kickout.ui.BannedViewHolder;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends q0 {
    public final /* synthetic */ BannedViewHolder a;

    public d(BannedViewHolder r1) {
        this.a = r1;
    }

    public final void h(k r2, int r3, int r4) {
        ViewGroup.LayoutParams r5 = this.a.e.getLayoutParams();
        int r0 = s1.f(32.0f);
        r5.width = r0;
        r5.height = (r4 * r0) / r3;
        this.a.e.setLayoutParams(r5);
    }
}
