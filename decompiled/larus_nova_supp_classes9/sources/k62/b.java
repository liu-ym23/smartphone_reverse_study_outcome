package k62;

import ak6.g;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelChatViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements qb2.e {
    public final /* synthetic */ ChatChannelChatViewHolder a;

    public b(ChatChannelChatViewHolder r1) {
        this.a = r1;
    }

    @Override // qb2.e
    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        TextView r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.setText(r2.a);
        return;
    }
}
