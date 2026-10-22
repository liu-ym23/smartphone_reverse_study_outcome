package i62;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelChatViewHolder;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements com.bytedance.android.livesdk.interactivity.service.messagelist.c, View.OnClickListener, View.OnLongClickListener {
    public final boolean a;
    public final User b;

    /* JADX INFO: renamed from: i62.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0237a<T extends a> extends me.drakeet.multitype.b<T, ChatChannelChatViewHolder> {
        public abstract void h(ChatChannelChatViewHolder r1, T r2);

        public AbstractC0237a() {
        }

        public final void b(RecyclerView.ViewHolder r3, Object r4) {
            ChatChannelChatViewHolder r5 = (ChatChannelChatViewHolder) r3;
            a r6 = (a) r4;
            Intrinsics.checkNotNullParameter(r5, "holder");
            Intrinsics.checkNotNullParameter(r6, "item");
            if ((r6 instanceof wb2.d.a) == true) goto L5;
            Object r0 = null;
        L6:
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "onClickListener");
            Intrinsics.checkNotNullParameter(r6, "longClickListener");
            r5.d = (wb2.d.a) r0;
            HSImageView r1 = r5.a;
            if (r1 == null) goto L9;
            r1.setOnClickListener(r6);
            r1.setOnLongClickListener(r6);
        L9:
            TextView r2 = r5.b;
            if (r2 == null) goto L12;
            r2.setOnLongClickListener(r6);
        L12:
            ((RecyclerView.ViewHolder) r5).itemView.setOnLongClickListener(r6);
            TextView r7 = r5.c;
            if (r7 == null) goto L15;
            r7.setOnClickListener(k62.c.a);
            r7.setOnLongClickListener(r6);
        L15:
            h(r5, r6);
            return;
        L5:
            r0 = r6;
            goto L6
        }

        public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
            Intrinsics.checkNotNullParameter(r4, "inflater");
            Intrinsics.checkNotNullParameter(r5, "parent");
            int r2 = ChatChannelChatViewHolder.e;
            Intrinsics.checkNotNullParameter(r4, "inflater");
            Intrinsics.checkNotNullParameter(r5, "parent");
            return new ChatChannelChatViewHolder(r4.inflate(2131566240, r5, false));
        }
    }

    public abstract String e();

    public abstract boolean f();

    public a(User r3) {
        this.b = r3;
        String r0 = null;
        if (r3 == null) goto L5;
        String r4 = r3.getCastSecUid();
    L6:
        IUserService r1 = k.f(IUserService.class);
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.user.f r2 = r1.user();
        if (r2 == null) goto L13;
        IUser r5 = r2.b();
        if (r5 == null) goto L13;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        r0 = r5.getCastSecUid();
    L13:
        this.a = Intrinsics.areEqual(r4, r0);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        User r5 = this.b;
        if (r5 != null) goto L5;
        return;
    L5:
        String r0 = e();
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = e62.d.a;
        e62.d.b(r5, getId(), r0);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        User r6 = this.b;
        if (r6 != null) goto L6;
        return false;
    L6:
        int r0 = e62.d.a;
        e62.d.c(r6, getId(), getChannelId());
        return true;
    }
}
