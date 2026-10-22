package w62;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.j;
import com.bytedance.android.livesdk.chatroom.model.l;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ LiveVideoCommentSearchVideoViewHolder a;

    public f(LiveVideoCommentSearchVideoViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        l r4 = this.a.k;
        if (r4 == null) goto L10;
        j r5 = r4.a;
        if (r5 == null) goto L11;
        Long r6 = r5.e();
        if (r6 == null) goto L12;
        long r0 = r6.longValue();
        this.a.o.Ip(r0);
        return;
    L12:
        return;
    L11:
        return;
    }
}
