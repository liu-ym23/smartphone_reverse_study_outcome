package com.ss.android.lark.mention.base.impl.atselector.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.joooonho.SelectableRoundedImageView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtHeaderSelectedAdapter extends LarkRecyclerViewBaseAdapter<SelectedChatterViewHolder, BaseAtBean> {
    public static final int c = 0;
    public Context a;
    public a b;

    public static class SelectedChatterViewHolder extends RecyclerView.ViewHolder {

        @BindView(9088)
        SelectableRoundedImageView mAvatar;

        public SelectedChatterViewHolder(View r1) {
            super(r1);
            ButterKnife.bind(this, r1);
        }
    }

    public class SelectedChatterViewHolder_ViewBinding implements Unbinder {
        public SelectedChatterViewHolder a;

        public final void unbind() {
            SelectedChatterViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.mAvatar = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public SelectedChatterViewHolder_ViewBinding(SelectedChatterViewHolder r4, View r5) {
            this.a = r4;
            r4.mAvatar = (SelectableRoundedImageView) Utils.findRequiredViewAsType(r5, 2131363316, "field 'mAvatar'", SelectableRoundedImageView.class);
        }
    }

    public interface a {
    }

    static {
        c = UIHelper.getDimens(2131165373);
    }

    public AtHeaderSelectedAdapter() {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        SelectedChatterViewHolder r6 = (SelectedChatterViewHolder) r4;
        BaseAtBean r7 = (BaseAtBean) getItem(r5);
        Context r0 = this.a;
        SelectableRoundedImageView r1 = r6.mAvatar;
        int r2 = c;
        r7.showAvatar(r0, r1, r2, r2);
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new com.ss.android.lark.mention.base.impl.atselector.view.adapter.a(this, r7));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        this.a = r3.getContext();
        return new SelectedChatterViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131558739, r3, false));
    }
}
