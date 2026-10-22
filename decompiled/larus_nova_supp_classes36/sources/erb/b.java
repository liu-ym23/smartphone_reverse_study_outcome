package erb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.AllAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtSelectableViewHolder;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements drb.a<AllAtBean, AtSelectableViewHolder> {
    public Context b;
    public int c;
    public final IItemContainer d;
    public IItemContainer.a e;

    public b(IItemContainer r1) {
        this.d = r1;
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ long a(AllAtBean r3) {
        return -1;
    }

    @Override // drb.a
    public final RecyclerView.ViewHolder b(ViewGroup r4) {
        Context r0 = r4.getContext();
        this.b = r0;
        return new AtSelectableViewHolder(LayoutInflater.from(r0).inflate(2131561574, r4, false));
    }

    @Override // drb.a
    public final void c(RecyclerView.ViewHolder r4, BaseAtBean r5, int r6) {
        AtSelectableViewHolder r7 = (AtSelectableViewHolder) r4;
        AllAtBean r8 = (AllAtBean) r5;
        if (this.b != null) goto L5;
        this.b = ((RecyclerView.ViewHolder) r7).itemView.getContext();
    L5:
        this.c = this.d.y0();
        this.e = this.d.a0();
        r7.mTagWrapper.setVisibility(8);
        r7.mUserStatus.setVisibility(8);
        r7.mWorkStatus.setVisibility(8);
        if (this.c != 0) goto L9;
        r7.mNameTV.setText(r8.getDisplayName());
        r7.mDividerView.setVisibility(8);
        r7.mOwnerTV.setVisibility(0);
        r7.mOwnerTV.setText(2131892035);
        r7.mOwnerTV.setTextColor(y9c.d.c(this.b, 2131106607));
        r7.mAtSelectCheckBox.setVisibility(8);
        int r9 = drb.a.a;
        r8.showAvatar(this.b, r7.mSingleAvatarIV, r9, r9);
        a r10 = new a(this, r8);
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(r10);
        return;
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ void d(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3, List r4) {
        AtSelectableViewHolder r5 = (AtSelectableViewHolder) r1;
        AllAtBean r6 = (AllAtBean) r2;
    }
}
