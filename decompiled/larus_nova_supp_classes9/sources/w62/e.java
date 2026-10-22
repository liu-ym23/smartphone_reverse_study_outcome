package w62;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.l;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ LiveVideoCommentSearchVideoViewHolder a;
    public final /* synthetic */ l b;

    public e(LiveVideoCommentSearchVideoViewHolder r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.o.O80(this.b);
    }
}
