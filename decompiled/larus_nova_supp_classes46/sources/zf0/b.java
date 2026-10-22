package zf0;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.ChatRivalsSearchFootViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends me.drakeet.multitype.b<a, ChatRivalsSearchFootViewHolder> {

    public static final class a {
        public int a;

        public a() {
        }

        public final int getType() {
            return this.a;
        }
    }

    public b() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        final ChatRivalsSearchFootViewHolder r6 = (ChatRivalsSearchFootViewHolder) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        int r8 = r7.getType();
        if (r8 != 0) goto L5;
        r6.a.setText(2131918004);
        return;
    L5:
        r6.getClass();
        boolean r0 = true;
        if (r8 == 1) goto L8;
        return;
    L8:
        if (com.bytedance.android.live.liveinteract.api.utils.m.i() != null) goto L10;
    L12:
        r0 = false;
    L13:
        if (r0 == false) goto L15;
        r6.a.setText(2131918006);
        Drawable r9 = s1.m(2131251951);
        r9.setBounds(0, 0, s1.f(15.0f), s1.f(18.0f));
        r6.a.setCompoundDrawables(null, null, r9, null);
        r6.a.setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.viewholder.a(r6));
        return;
    L15:
        r6.a.setText(2131918005);
        return;
    L10:
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor().booleanValue() == false) goto L12;
        goto L12
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ChatRivalsSearchFootViewHolder(r4.inflate(2131566244, r5, false));
    }
}
