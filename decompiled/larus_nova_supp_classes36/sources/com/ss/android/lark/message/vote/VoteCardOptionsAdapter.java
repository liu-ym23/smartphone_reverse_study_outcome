package com.ss.android.lark.message.vote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class VoteCardOptionsAdapter extends LarkRecyclerViewBaseAdapter<ViewHolder, irb.a> {
    public final Context a;
    public int b;
    public int c;
    public a d;
    public final int e;
    public final int f;
    public trb.a g;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(9195)
        UDCheckBox mCheckBox;

        @BindView(9259)
        TextView mContentTv;

        @BindView(9571)
        RelativeLayout mItemLayout;

        @BindView(9897)
        TextView mNumberTv;

        @BindView(9991)
        TextView mPollTv;

        @BindView(10022)
        ProgressBar mProgressBar;

        @BindView(10514)
        View mVoteResultLayout;

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
            r0.mNumberTv = null;
            r0.mContentTv = null;
            r0.mPollTv = null;
            r0.mProgressBar = null;
            r0.mItemLayout = null;
            r0.mVoteResultLayout = null;
            r0.mCheckBox = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public ViewHolder_ViewBinding(ViewHolder r4, View r5) {
            this.a = r4;
            r4.mNumberTv = (TextView) Utils.findRequiredViewAsType(r5, 2131381107, "field 'mNumberTv'", TextView.class);
            r4.mContentTv = (TextView) Utils.findRequiredViewAsType(r5, 2131367861, "field 'mContentTv'", TextView.class);
            r4.mPollTv = (TextView) Utils.findRequiredViewAsType(r5, 2131382747, "field 'mPollTv'", TextView.class);
            r4.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(r5, 2131383334, "field 'mProgressBar'", ProgressBar.class);
            r4.mItemLayout = (RelativeLayout) Utils.findRequiredViewAsType(r5, 2131375788, "field 'mItemLayout'", RelativeLayout.class);
            r4.mVoteResultLayout = Utils.findRequiredView(r5, 2131392811, "field 'mVoteResultLayout'");
            r4.mCheckBox = (UDCheckBox) Utils.findRequiredViewAsType(r5, 2131365640, "field 'mCheckBox'", UDCheckBox.class);
        }
    }

    public interface a {
    }

    public final long getItemId(int r3) {
        return r3;
    }

    public VoteCardOptionsAdapter(Context r2) {
        this.a = r2;
        this.e = UIUtils.getColor(r2, 2131105548);
        this.f = UIUtils.getColor(r2, 2131106622);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        ViewHolder r12 = (ViewHolder) r10;
        irb.a r0 = (irb.a) getItem(r11);
        if (r0.e == true) goto L5;
    L7:
        r12.mNumberTv.setTextColor(this.f);
        r12.mNumberTv.setTypeface(null, 0);
        r12.mContentTv.setTextColor(this.f);
        r12.mContentTv.setTypeface(null, 0);
        r12.mPollTv.setTextColor(this.f);
    L9:
        if (this.b != 1) goto L11;
        r12.mCheckBox.setType(UDCheckBox.CheckBoxType.RADIO);
    L13:
        if (r0.e == false) goto L18;
        if (r0.d == true) goto L18;
        r12.mCheckBox.setVisibility(0);
        r12.mCheckBox.setChecked(true);
    L21:
        r12.mNumberTv.setText(r0.f);
        r12.mContentTv.setText(r0.g);
        if (r0.d == false) goto L36;
        r12.mVoteResultLayout.setVisibility(0);
        r12.mProgressBar.setProgress(r0.h);
        r12.mProgressBar.setMax(r0.i);
        int r1 = r0.i;
        if (r1 == 0) goto L26;
        float r2 = (r0.h / r1) * 100.0f;
    L28:
        if (r2 < 0.1d) goto L30;
        String r3 = String.format("%.1f", new Object[]{Float.valueOf(r2)});
    L31:
        int r4 = r0.h;
        HashMap r5 = new HashMap();
        r5.put("vote_num", String.valueOf(r4));
        r5.put("percentage", r3);
        if (r4 <= 1) goto L34;
        int r6 = 2131892326;
    L35:
        r12.mPollTv.setText(UIHelper.mustacheFormat(r6, r5));
    L37:
        ((RecyclerView.ViewHolder) r12).itemView.setEnabled(!r0.d);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new com.ss.android.lark.message.vote.a(this, r12, r0, r11));
        TextView r13 = r12.mNumberTv;
        LarkFont r7 = LarkFont.BODY1;
        zz7.a.d(r13, r7);
        zz7.a.d(r12.mContentTv, r7);
        zz7.a.d(r12.mPollTv, LarkFont.CAPTION2);
        return;
    L34:
        r6 = 2131892325;
        goto L35
    L30:
        r3 = String.format("%04.1f", new Object[]{Float.valueOf(r2)});
        goto L31
    L26:
        r2 = 0.0f;
        goto L28
    L36:
        r12.mVoteResultLayout.setVisibility(8);
    L18:
        if (r0.d == false) goto L20;
        r12.mCheckBox.setVisibility(8);
        goto L21
    L20:
        r12.mCheckBox.setVisibility(0);
        r12.mCheckBox.setChecked(false);
        goto L21
    L11:
        r12.mCheckBox.setType(UDCheckBox.CheckBoxType.CHECK_BOX);
        goto L13
    L5:
        if (r0.d == false) goto L7;
        r12.mNumberTv.setTextColor(this.e);
        r12.mNumberTv.setTypeface(null, 1);
        r12.mContentTv.setTextColor(this.e);
        r12.mContentTv.setTypeface(null, 1);
        r12.mPollTv.setTextColor(this.e);
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new ViewHolder(LayoutInflater.from(this.a).inflate(2131568214, r3, false));
    }
}
