package com.ss.android.lark.reaction.widget.detailwindow.pager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.reaction.widget.detailwindow.userstatus.ReactionUserStatusLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionListItemViewHolder extends RecyclerView.ViewHolder {
    public final ViewGroup a;
    public final LKUIRoundedImageView b;
    public final TextView c;
    public final ReactionUserStatusLinearLayout d;
    public final TextView e;
    public final View f;

    public ReactionListItemViewHolder(View r2) {
        super(r2);
        this.a = (ViewGroup) r2.findViewById(2131382101);
        this.b = r2.findViewById(2131386551);
        ImageView r0 = (ImageView) r2.findViewById(2131375089);
        this.c = (TextView) r2.findViewById(2131388472);
        this.d = (ReactionUserStatusLinearLayout) r2.findViewById(2131392066);
        this.e = (TextView) r2.findViewById(2131393343);
        this.f = r2.findViewById(2131369240);
        DesktopUtil.a(r2.getContext());
    }
}
