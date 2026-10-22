package erb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.GroupMemAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtSelectableViewHolder;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements drb.a<GroupMemAtBean, AtSelectableViewHolder> {
    public Context b;
    public final i c;
    public int d;
    public final IItemContainer e;
    public final boolean f;

    public c(IItemContainer r3) {
        this.c = new i();
        this.e = r3;
        int r4 = com.ss.android.lark.mention.base.a.a;
        boolean r5 = FeatureGatingModule.getFeatureGatingService().isEnable("im.mention.display_department");
        this.f = r5;
        Log.i("OldIMMention_AtGroupMemBinder", "enableDisplayDepartmentFG, im.mention.display_department: " + r5);
    }

    @Override // drb.a
    public final long a(GroupMemAtBean r3) {
        return r3.getPinyin();
    }

    @Override // drb.a
    public final RecyclerView.ViewHolder b(ViewGroup r4) {
        Context r0 = r4.getContext();
        this.b = r0;
        return new AtSelectableViewHolder(LayoutInflater.from(r0).inflate(2131561574, r4, false));
    }

    @Override // drb.a
    public final void c(RecyclerView.ViewHolder r5, BaseAtBean r6, int r7) {
        AtSelectableViewHolder r8 = (AtSelectableViewHolder) r5;
        GroupMemAtBean r9 = (GroupMemAtBean) r6;
        if (this.b != null) goto L5;
        this.b = ((RecyclerView.ViewHolder) r8).itemView.getContext();
    L5:
        this.d = this.e.y0();
        r8.mNameTV.setText(r9.getDisplayName());
        int r0 = drb.a.a;
        r9.showAvatar(this.b, r8.mSingleAvatarIV, r0, r0);
        com.ss.android.lark.mention.base.impl.atselector.bean.a r1 = r9.getChatterInfo();
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.f == true) goto L11;
    L13:
        this.c.b(r1, r8);
    L14:
        this.c.h(r1, r8);
        this.c.i(r1, r8);
        this.c.g(r1, r8);
        this.c.f(r8, this.e.getItemCount(), this.e.getItems(), r7);
        this.c.d(r9, r8, this.d);
        this.c.c(r9, r8, this.e);
        if (r9.isShowShadow() == false) goto L17;
        r8.mShadow.setVisibility(0);
    L19:
        if (r9.isHideDivider() == false) goto L21;
        r8.mDividerView.setVisibility(8);
    L22:
        this.c.e(r1, r8);
        return;
    L21:
        r8.mDividerView.setVisibility(0);
        goto L22
    L17:
        r8.mShadow.setVisibility(8);
        goto L19
    L11:
        if (r1.b() == true) goto L13;
        this.c.a(r1, r8);
        goto L14
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ void d(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3, List r4) {
        AtSelectableViewHolder r5 = (AtSelectableViewHolder) r1;
        GroupMemAtBean r6 = (GroupMemAtBean) r2;
    }
}
