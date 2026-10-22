package a6b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.SpaceViewHolder;
import com.ss.android.lark.chat.message.menu.v2.j0;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements e<zya.h, SpaceViewHolder> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // a6b.e
    public final /* synthetic */ void b(j0 r1) {
    }

    @Override // a6b.e
    public final RecyclerView.ViewHolder a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r0 = new View(r4.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, UIHelper.dp2px(12.0f)));
        return new SpaceViewHolder(r0);
    }

    @Override // a6b.e
    public final void c(RecyclerView.ViewHolder r3, zya.e r4) {
        SpaceViewHolder r5 = (SpaceViewHolder) r3;
        zya.h r6 = (zya.h) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "itemData");
        View r0 = ((RecyclerView.ViewHolder) r5).itemView;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        r1.height = UIUtils.dp2px(((RecyclerView.ViewHolder) r5).itemView.getContext(), r6.b);
        r0.setLayoutParams(r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
