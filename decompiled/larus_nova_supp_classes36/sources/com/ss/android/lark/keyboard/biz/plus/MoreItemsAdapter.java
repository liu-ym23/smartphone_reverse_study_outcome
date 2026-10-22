package com.ss.android.lark.keyboard.biz.plus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ignition.widget.squircle.SquircleImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MoreItemsAdapter extends LarkRecyclerViewBaseAdapter<ViewHolder, d5b.a> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(10745)
        ImageView mIconIv;

        @BindView(10754)
        TextView mNameTv;

        @BindView(10746)
        ImageView mRedDot;

        public ViewHolder(View r1) {
            super(r1);
            ButterKnife.bind(this, r1);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        public final void unbind() {
            ViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.mIconIv = null;
            r0.mNameTv = null;
            r0.mRedDot = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public ViewHolder_ViewBinding(ViewHolder r4, View r5) {
            this.a = r4;
            r4.mIconIv = (ImageView) Utils.findRequiredViewAsType(r5, 2131375773, "field 'mIconIv'", ImageView.class);
            r4.mNameTv = (TextView) Utils.findRequiredViewAsType(r5, 2131375808, "field 'mNameTv'", TextView.class);
            r4.mRedDot = (ImageView) Utils.findRequiredViewAsType(r5, 2131375774, "field 'mRedDot'", ImageView.class);
        }
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        ViewHolder r8 = (ViewHolder) r6;
        d5b.a r9 = (d5b.a) getItem(r7);
        if (r9.isVisible() == false) goto L9;
        ((RecyclerView.ViewHolder) r8).itemView.setVisibility(0);
        r8.mNameTv.setText(r9.getName());
        SquircleImageView r0 = r8.mIconIv;
        r0.setBackgroundColor(UDColorUtils.getColor(null, 2131102437));
        r0.setBackgroundTintList(UDColorUtils.getColorStateList(null, 2131102495));
        UIHelper.dp2px(52.0f);
        if (r9.getIconId() == (-1)) goto L7;
        r0.setImageResource(r9.getIconId());
        r0.setImageTintList(null);
        r0.setRadius(UIHelper.dp2px(12.0f));
        r0.setBorderWidth(UIHelper.dp2px(0.0f));
        r0.setBorderColor(j08.b.b(ContextCompat.getColor(r0.getContext(), 2131103463), 0.1f));
    L8:
        ImageView r1 = r8.mRedDot;
        r9.showRedDot();
        r1.setVisibility(8);
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new b(this, r9, r8));
        return;
    L7:
        r9.b();
        ((RecyclerView.ViewHolder) r8).itemView.setVisibility(8);
        goto L8
    L9:
        ((RecyclerView.ViewHolder) r8).itemView.setVisibility(8);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new ViewHolder(LayoutInflater.from(null).inflate(2131561734, r3, false));
    }
}
