package i62;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelTipViewHolder;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements com.bytedance.android.livesdk.interactivity.service.messagelist.c, View.OnClickListener, wb2.d.a {
    public static final yb2.a f = null;
    public final long a;
    public final boolean b;
    public final boolean c;
    public final tb2.d d;
    public final com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b e;

    public static final class a {
    }

    /* JADX INFO: renamed from: i62.b$b, reason: collision with other inner class name */
    public static final class C0238b extends me.drakeet.multitype.b<b, ChatChannelTipViewHolder> {
        public C0238b() {
        }

        public final void b(RecyclerView.ViewHolder r2, Object r3) {
            ChatChannelTipViewHolder r4 = (ChatChannelTipViewHolder) r2;
            b r5 = (b) r3;
            Intrinsics.checkNotNullParameter(r4, "holder");
            Intrinsics.checkNotNullParameter(r5, "item");
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "listener");
            r4.c = r5;
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
        r0.a = ColorProtector.parseColor("#ffffff");
        f = r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean a() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final long getId() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean isFromFirstRequest() {
        return this.b;
    }

    public b(com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        this.e = r6;
        this.a = r6.getMessageId();
        this.b = r6.isFromFirstRequest();
        r6.getReceiveTime();
        this.c = !r6.isFromFirstRequest();
        CommonMessageData r7 = ((BaseMessage) r6).baseMessage;
        if (r7 == null) goto L7;
        Text r8 = r7.getDisplayText();
        if (r8 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r0 = r.b;
        yb2.a r1 = f;
        Intrinsics.checkNotNullParameter(r8, "text");
        tb2.d r9 = r.a(r8, r1);
    L8:
        Iterator<T> r2 = r9.a.iterator();
    L10:
        if (r2.hasNext() == false) goto L22;
        tb2.c r3 = (tb2.c) r2.next();
        i5 r4 = r3.getUserValue();
        IBaseUser r5 = null;
        if (r4 == null) goto L14;
        IBaseUser r10 = r4.getUser();
    L16:
        if ((r10 instanceof User) == false) goto L19;
        r5 = r10;
    L19:
        User r11 = (User) r5;
        if (r11 == null) goto L10;
        r3.setClickAction(new h62.a(r11));
        goto L10
    L14:
        r10 = null;
        goto L16
    L22:
        r9.b = f;
        Unit r13 = Unit.INSTANCE;
        this.d = r9;
        return;
    L7:
        r9 = new tb2.d();
        r9.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(BuildConfig.FLAVOR));
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        User r2 = this.e.getUser();
        if (r2 != null) goto L5;
        return;
    L5:
        e62.d.d(r2);
    }

    @Override // wb2.d.a
    public final boolean d(View r2, wb2.d r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "span");
        Object r4 = r3.b;
        if ((r4 instanceof h62.a) == true) goto L5;
        r4 = null;
    L5:
        h62.a r5 = (h62.a) r4;
        if (r5 != null) goto L9;
        return false;
    L9:
        int r6 = e62.d.a;
        e62.d.d(r5.a);
        return true;
    }
}
