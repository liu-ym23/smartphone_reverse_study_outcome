package i62;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.n;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelTipViewHolder;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements com.bytedance.android.livesdk.interactivity.service.messagelist.c, View.OnClickListener {
    public static final yb2.a f = null;
    public final long a;
    public final boolean b;
    public final boolean c;
    public final tb2.d d;
    public final n e;

    public static final class a {
    }

    public static final class b extends me.drakeet.multitype.b<h, ChatChannelTipViewHolder> {
        public b() {
        }

        public final void b(RecyclerView.ViewHolder r2, Object r3) {
            ChatChannelTipViewHolder r4 = (ChatChannelTipViewHolder) r2;
            h r5 = (h) r3;
            Intrinsics.checkNotNullParameter(r4, "holder");
            Intrinsics.checkNotNullParameter(r5, "item");
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "listener");
            r4.b = r5;
            r4.T3(r5.d);
        }

        public final RecyclerView.ViewHolder d(LayoutInflater r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "inflater");
            Intrinsics.checkNotNullParameter(r3, "parent");
            int r0 = ChatChannelTipViewHolder.d;
            return ChatChannelTipViewHolder.a.a(r2, r3);
        }
    }

    public static final class c implements IHostAction.IMOpenGroupChatCallback {
        public final /* synthetic */ String a;

        public final void onSuccess() {
            k.b("open conversation " + this.a + " success");
        }

        public c(String r1) {
            this.a = r1;
        }

        public final void onFailure(String r3) {
            k.b("open conversation " + this.a + " failed. reason=" + r3);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean b() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean c() {
        return false;
    }

    static {
        yb2.a r0 = w.a();
        r0.d = ColorProtector.parseColor("#80ffffff");
        r0.a = ColorProtector.parseColor("#face15");
        f = r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean a() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final long getId() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean isFromFirstRequest() {
        return this.c;
    }

    public h(n r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        this.e = r4;
        this.a = r4.getMessageId();
        r4.getReceiveTime();
        this.b = !r4.isFromFirstRequest();
        this.c = r4.isFromFirstRequest();
        CommonMessageData r0 = ((BaseMessage) r4).baseMessage;
        if (r0 == null) goto L7;
        Text r1 = r0.getDisplayText();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r5 = r.b;
        yb2.a r6 = f;
        Intrinsics.checkNotNullParameter(r1, "text");
        tb2.d r7 = r.a(r1, r6);
    L8:
        r7.b = f;
        this.d = r7;
        return;
    L7:
        tb2.d r2 = new tb2.d();
        r2.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("已加入群聊" + r4.getConversationId()));
        r7 = r2;
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        String r0 = this.e.getConversationId();
        if (r0 != null) goto L5;
        return;
    L5:
        IHostAction r1 = jc1.k.f(IHostAction.class);
        if (r1 == null) goto L9;
        r1.openGroupChat(r5.getContext(), r0, true, new c(r0));
        return;
    }
}
