package erb;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.LabelAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtLabelViewHolder;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements drb.a<LabelAtBean, AtLabelViewHolder> {
    public Context b;

    public j() {
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ long a(LabelAtBean r3) {
        return -1;
    }

    @Override // drb.a
    public final RecyclerView.ViewHolder b(ViewGroup r4) {
        Context r0 = r4.getContext();
        this.b = r0;
        return new AtLabelViewHolder(LayoutInflater.from(r0).inflate(2131561572, r4, false));
    }

    @Override // drb.a
    public final void c(RecyclerView.ViewHolder r5, BaseAtBean r6, int r7) {
        AtLabelViewHolder r8 = (AtLabelViewHolder) r5;
        LabelAtBean r9 = (LabelAtBean) r6;
        if (this.b != null) goto L5;
        this.b = ((RecyclerView.ViewHolder) r8).itemView.getContext();
    L5:
        r8.mLabelTV.setBackgroundColor(y9c.d.c(this.b, r9.getBgColorResId()));
        r8.mLabelTV.setTextSize(r9.getTextSize());
        TextView r10 = r8.mLabelTV;
        r10.setPadding(r10.getPaddingLeft(), r9.getVerticalPadding(), r8.mLabelTV.getPaddingRight(), r9.getVerticalPadding());
        if (TextUtils.isEmpty(r9.getSubLabel()) == false) goto L8;
        r8.mLabelTV.setText(r9.getDisplayName());
        return;
    L8:
        String r11 = r9.getDisplayName();
        String r12 = r9.getSubLabel();
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        r0.append(r11).append("  ").append(r12);
        int r13 = r11.length() + 2;
        r0.setSpan(new ForegroundColorSpan(y9c.d.c(this.b, 2131106607)), r13, r12.length() + r13, 33);
        r8.mLabelTV.setText(r0);
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ void d(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3, List r4) {
        AtLabelViewHolder r5 = (AtLabelViewHolder) r1;
        LabelAtBean r6 = (LabelAtBean) r2;
    }
}
