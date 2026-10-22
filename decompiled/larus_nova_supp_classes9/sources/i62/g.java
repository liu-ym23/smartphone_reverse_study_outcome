package i62;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelTipViewHolder;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends me.drakeet.multitype.b<hb2.a, ChatChannelTipViewHolder> {
    public static final tb2.d b = null;

    public static final class a {
    }

    static {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(s1.C(2131915717, new Object[]{String.valueOf(com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.k)})));
        yb2.a r1 = w.a();
        r1.d = ColorProtector.parseColor("#57ffffff");
        r1.a = ColorProtector.parseColor("#57ffffff");
        Unit r2 = Unit.INSTANCE;
        r0.b = r1;
        b = r0;
    }

    public g() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ChatChannelTipViewHolder r4 = (ChatChannelTipViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter((hb2.a) r3, "item");
        r4.T3(b);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        int r0 = ChatChannelTipViewHolder.d;
        return ChatChannelTipViewHolder.a.a(r2, r3);
    }
}
