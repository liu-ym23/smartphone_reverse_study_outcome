package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKActUserGroupViewHolder;
import com.bytedance.android.live.revlink.impl.pk.flexactivity.ActUserGroupView;
import com.bytedance.android.live.revlink.impl.pk.flexactivity.UserGroupAdapter;
import com.bytedance.android.livesdk.link.model.z9;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends me.drakeet.multitype.b<a, PKActUserGroupViewHolder> {
    public final AnchorInteractContainerFragment.b b;

    public static final class a {
        public final z9 a;

        public a(z9 r1) {
            this.a = r1;
        }
    }

    public g(com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c r1) {
        this.b = r1;
    }

    public final void g(RecyclerView.ViewHolder r2) {
        PKActUserGroupViewHolder r3 = (PKActUserGroupViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.getClass();
    }

    public final void b(RecyclerView.ViewHolder r6, Object r7) {
        PKActUserGroupViewHolder r8 = (PKActUserGroupViewHolder) r6;
        a r9 = (a) r7;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "item");
        r8.getClass();
        if (r9 == null) goto L26;
        z9 r10 = r9.a;
        if (r10 == null) goto L30;
        Object r0 = ((RecyclerView.ViewHolder) r8).itemView;
        if ((r0 instanceof ActUserGroupView) == true) goto L10;
        r0 = null;
    L10:
        ActUserGroupView r1 = (ActUserGroupView) r0;
        if (r1 == null) goto L27;
        r1.setUpdataTab(r8.a);
        List r12 = r10.getUsers();
        if (r12 == null) goto L15;
        int r13 = r12.size();
    L17:
        if (r13 <= 0) goto L24;
        ((LinearLayout) r1._$_findCachedViewById(2131371607)).setVisibility(4);
        ((LinearLayout) r1._$_findCachedViewById(2131374019)).setVisibility(0);
        ((TextView) r1._$_findCachedViewById(2131374011)).setText(r10.getName());
        UserGroupAdapter r14 = r1.b;
        if (r14 == null) goto L21;
        r14.c = r10.getUsers();
    L21:
        UserGroupAdapter r15 = r1.b;
        if (r15 == null) goto L28;
        r15.notifyDataSetChanged();
        return;
    L28:
        return;
    L24:
        ((LinearLayout) r1._$_findCachedViewById(2131371607)).setVisibility(0);
        ((TextView) r1._$_findCachedViewById(2131371602)).setText(r10.getEmptyTxt());
        ((LinearLayout) r1._$_findCachedViewById(2131374019)).setVisibility(4);
        return;
    L15:
        r13 = 0;
        goto L17
    L27:
        return;
    L30:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.flexactivity.ActUserGroupView] */
    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        ?? r5 = new ActUserGroupView(r4.getContext(), null);
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Unit r6 = Unit.INSTANCE;
        return new PKActUserGroupViewHolder(r5, this.b);
    }
}
