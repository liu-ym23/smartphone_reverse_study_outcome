package x90;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.widget.EmojiSelectPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends RecyclerView.OnScrollListener {
    public final /* synthetic */ EmojiSelectPanel a;

    public c(EmojiSelectPanel r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        EmojiSelectPanel r0 = this.a;
        EmojiSelectPanel.R5(r0, r0.f);
        super.onScrollStateChanged(r3, r4);
    }
}
