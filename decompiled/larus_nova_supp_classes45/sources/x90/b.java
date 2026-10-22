package x90;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.widget.EmojiSelectPanel;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends GridPagerSnapHelper {
    public final /* synthetic */ EmojiSelectPanel h;

    public b(EmojiSelectPanel r1) {
        this.h = r1;
    }

    public final View findSnapView(RecyclerView.LayoutManager r3) {
        View r0 = super.findSnapView(r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        EmojiSelectPanel r1 = this.h;
        r1.f = r3.getPosition(r0);
        EmojiSelectPanel r4 = this.h;
        EmojiSelectPanel.R5(r4, r4.f);
        return r0;
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r2, int r3, int r4) {
        EmojiSelectPanel r0 = this.h;
        r0.f = super.findTargetSnapPosition(r2, r3, r4);
        EmojiSelectPanel r5 = this.h;
        EmojiSelectPanel.R5(r5, r5.f);
        return this.h.f;
    }
}
