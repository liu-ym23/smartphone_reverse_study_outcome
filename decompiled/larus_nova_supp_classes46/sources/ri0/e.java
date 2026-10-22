package ri0;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenue.game.wm.MultiLinkGameWindowManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements ne0.a {
    public final /* synthetic */ MultiLinkGameWindowManager a;

    public e(MultiLinkGameWindowManager r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r6, Object r7) {
        Intrinsics.checkNotNullParameter(r6, "store");
        MultiLinkGameWindowManager r8 = this.a;
        int r0 = MultiLinkGameWindowManager.b1;
        hg0.d r9 = r8.i;
        if (r9 == null) goto L16;
        ti0.a r1 = ti0.a.b;
        Intrinsics.checkNotNullParameter(r1, "action");
        ALogger.i("EffectCollect", "do layer action action:" + r1 + " to all");
        RecyclerView r10 = r9.a;
        if (r10 == null) goto L7;
        RecyclerView.Adapter r2 = r10.getAdapter();
    L8:
        if (r10 == null) goto L20;
        if (r2 == null) goto L21;
        int r3 = r2.getItemCount();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L22;
        hg0.b r5 = r10.findViewHolderForAdapterPosition(r4);
        if ((r5 instanceof hg0.b) == false) goto L15;
        r5.l().e(r4, r1, r7);
    L15:
        r4 = r4 + 1;
        goto L11
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r2 = null;
        goto L8
    }
}
