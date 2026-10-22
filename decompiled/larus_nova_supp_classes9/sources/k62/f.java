package k62;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.PadAdjustViewHolder;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ PadAdjustViewHolder a;

    public f(PadAdjustViewHolder r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        sh6.b r5 = (sh6.b) r4;
        if (((PadOrientation) sh6.c.b(r5)) != PadOrientation.LANDSCAPE) goto L6;
        UIUtils.updateLayout(((RecyclerView.ViewHolder) this.a).itemView, -1, -3);
        return;
    L6:
        if (((PadOrientation) sh6.c.b(r5)) != PadOrientation.PORTRAIT) goto L10;
        UIUtils.updateLayout(((RecyclerView.ViewHolder) this.a).itemView, (int) (s1.y() * 0.6f), -3);
        return;
    }
}
