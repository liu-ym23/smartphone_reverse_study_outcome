package erb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtSelectableViewHolder;
import com.ss.android.lark.utils.y0;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements drb.a<SearchBean, AtSelectableViewHolder> {
    public Context b;
    public final i c;
    public int d;
    public final IItemContainer e;
    public final boolean f;

    public d(IItemContainer r3) {
        this.c = new i();
        this.e = r3;
        int r4 = com.ss.android.lark.mention.base.a.a;
        boolean r5 = FeatureGatingModule.getFeatureGatingService().isEnable("im.mention.display_department");
        this.f = r5;
        Log.i("OldIMMention_AtSearchBinder", "enableDisplayDepartmentFG, im.mention.display_department: " + r5);
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ long a(SearchBean r3) {
        return -1;
    }

    @Override // drb.a
    public final RecyclerView.ViewHolder b(ViewGroup r4) {
        Context r0 = r4.getContext();
        this.b = r0;
        return new AtSelectableViewHolder(LayoutInflater.from(r0).inflate(2131561574, r4, false));
    }

    public static void f(SearchBean r2, AtSelectableViewHolder r3) {
        ChatterSensitiveInfo r4 = r2.getChatterInfo().q;
        if (r4 != null) goto L5;
    L7:
        r3.departmentInfo.setVisibility(8);
        return;
    L5:
        if (r4.getChatterDepartmentName().isEmpty() == true) goto L7;
        r3.departmentInfo.setVisibility(0);
        r3.departmentInfo.setText(r4.getChatterDepartmentName());
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ void c(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3) {
        e((AtSelectableViewHolder) r1, (SearchBean) r2, r3);
    }

    public final void e(AtSelectableViewHolder r5, SearchBean r6, int r7) {
        if (this.b != null) goto L6;
        this.b = ((RecyclerView.ViewHolder) r5).itemView.getContext();
    L6:
        if (r6.getChatterInfo() != null) goto L8;
        return;
    L8:
        this.d = this.e.y0();
        int r0 = this.b.getResources().getColor(2131102125);
        if (r6.getChatterInfo().e.isEmpty() == true) goto L11;
        r5.mNameTV.setText(y0.c(r6.getDisplayName(), r6.getChatterInfo().e, r0));
    L12:
        int r1 = drb.a.a;
        r6.showAvatar(this.b, r5.mSingleAvatarIV, r1, r1);
        com.ss.android.lark.mention.base.impl.atselector.bean.a r2 = r6.getChatterInfo();
        if (this.f == true) goto L15;
    L17:
        this.c.b(r2, r5);
        r5.departmentInfo.setVisibility(8);
    L18:
        this.c.h(r2, r5);
        this.c.i(r2, r5);
        this.c.g(r2, r5);
        this.c.f(r5, this.e.getItemCount(), this.e.getItems(), r7);
        this.c.d(r6, r5, this.d);
        this.c.c(r6, r5, this.e);
        this.c.e(r2, r5);
        return;
    L15:
        if (r6.getChatterInfo().b() == true) goto L17;
        this.c.a(r2, r5);
        f(r6, r5);
        goto L18
    L11:
        r5.mNameTV.setText(r6.getDisplayName());
        goto L12
    }

    @Override // drb.a
    public final void d(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3, List r4) {
        AtSelectableViewHolder r5 = (AtSelectableViewHolder) r1;
        SearchBean r6 = (SearchBean) r2;
        if (CollectionUtils.isEmpty(r4) == false) goto L5;
        e(r5, r6, r3);
        return;
    L5:
        if (this.f == false) goto L7;
        f(r6, r5);
        return;
    L7:
        r5.departmentInfo.setVisibility(8);
    }
}
