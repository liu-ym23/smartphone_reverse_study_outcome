package com.ss.android.lark.mention.base.impl.atselector.view.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.WantAtMemBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtSelectableViewHolder;
import com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter;
import erb.d;
import erb.e;
import erb.f;
import erb.j;
import frb.b;
import java.util.List;
import q28.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtSelectAdapter extends SearchRecyclerViewBaseAdapter<RecyclerView.ViewHolder, BaseAtBean> implements c<RecyclerView.ViewHolder>, IItemContainer, b {
    public final SparseArray<drb.a<? extends BaseAtBean, ?>> a;
    public int b;
    public IItemContainer.a c;
    public boolean d;

    public class a extends RecyclerView.ViewHolder {
        public a(View r1) {
            super(r1);
        }
    }

    public AtSelectAdapter() {
        SparseArray<drb.a<? extends BaseAtBean, ?>> r0 = new SparseArray();
        this.a = r0;
        r0.put(1, new erb.b(this));
        r0.put(0, new erb.c(this));
        r0.put(3, new j());
        r0.put(2, new e(this));
        r0.put(4, new d(this));
        r0.put(5, new f(this));
        arb.a.b.Z(r0, this);
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer
    public final IItemContainer.a a0() {
        return this.c;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer
    public final int y0() {
        return this.b;
    }

    public final long getHeaderId(int r3) {
        int r0 = getItemViewType(r3);
        return this.a.get(r0).a(getItem(r3));
    }

    public final long getItemId(int r3) {
        return ((BaseAtBean) getItem(r3)).getId().hashCode() + r3;
    }

    public final int getItemViewType(int r1) {
        return ((BaseAtBean) getItem(r1)).getType();
    }

    public final String getTopNRptId(int r2) {
        BaseAtBean r3 = (BaseAtBean) getItem(r2);
        if ((r3 instanceof SearchBean) == true) goto L10;
        if ((r3 instanceof WantAtMemBean) == true) goto L10;
        return null;
    L10:
        return r3.getId();
    }

    public final boolean isItemSelectable(int r7) {
        int r0 = getItemViewType(r7);
        BaseAtBean r8 = (BaseAtBean) getItem(r7);
        int r1 = com.ss.android.lark.mention.base.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.messenger.mention_focus_default") == false) goto L23;
        if (r0 == 1) goto L22;
        if (r0 != 3) goto L7;
    L20:
        return false;
    L7:
        if (r0 == 4) goto L11;
        if (r0 == 5) goto L20;
        return true;
    L11:
        if ((r8 instanceof SearchBean) == false) goto L20;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r9 = ((SearchBean) r8).getChatterInfo();
        if (r9 != null) goto L16;
        return false;
    L16:
        if (r9.b() == true) goto L18;
        return true;
    L18:
        return !this.d;
    L22:
        return !this.d;
    L23:
        if (r0 == 3) goto L26;
        if (r0 == 5) goto L26;
        return true;
    L26:
        return false;
    }

    @Override // frb.b
    public final String k2(int r1) {
        return ((BaseAtBean) getItem(r1)).getId();
    }

    public final RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup r5) {
        return new a(LayoutInflater.from(r5.getContext()).inflate(2131561576, r5, false));
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        if ((r2 instanceof AtSelectableViewHolder) == false) goto L5;
        ImageLoader.clear(((AtSelectableViewHolder) r2).mSingleAvatarIV);
    L5:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
    }

    public final void onBindHeaderViewHolder(RecyclerView.ViewHolder r1, int r2) {
        ((TextView) r1.itemView).setText(String.valueOf(((BaseAtBean) getItem(r2)).getPinyin()));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        super.onBindViewHolder(r3, r4);
        int r0 = getItemViewType(r4);
        this.a.get(r0).c(r3, (BaseAtBean) getItem(r4), r4);
        if (this.d == true) goto L5;
        return;
    L5:
        if (r4 != getSelectedPosition()) goto L9;
        this.d = false;
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        return this.a.get(r3).b(r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List<Object> r5) {
        super.onBindViewHolder(r3, r4, r5);
        if (CollectionUtils.isEmpty(r5) == true) goto L9;
        int r0 = getItemViewType(r4);
        this.a.get(r0).d(r3, (BaseAtBean) getItem(r4), r4, r5);
        if (this.d == true) goto L7;
        return;
    L7:
        if (r4 != getSelectedPosition()) goto L12;
        this.d = false;
        return;
    L12:
        return;
    L9:
        onBindViewHolder(r3, r4);
    }
}
