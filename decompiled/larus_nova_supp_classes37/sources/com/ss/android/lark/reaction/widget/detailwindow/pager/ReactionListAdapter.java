package com.ss.android.lark.reaction.widget.detailwindow.pager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import com.ss.android.lark.reaction.widget.detailwindow.userstatus.ReactionUserStatusLinearLayout;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Context a;
    public List<DetailUserInfo> b;
    public a c;
    public c d;
    public String e;

    public interface a {
    }

    public final int getItemCount() {
        return this.b.size() + (!TextUtils.isEmpty(this.e) ? 1 : 0);
    }

    public final int getItemViewType(int r2) {
        if (r2 < this.b.size()) goto L5;
        return 0;
    L5:
        return 1;
    }

    public ReactionListAdapter(Context r2, List<DetailUserInfo> r3) {
        this.e = "";
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        if ((r9 instanceof ReactionListItemViewHolder) == false) goto L23;
        if (this.d != null) goto L7;
        this.d = new c(this.a, this.c);
    L7:
        final c r0 = this.d;
        ReactionListItemViewHolder r1 = (ReactionListItemViewHolder) r9;
        final DetailUserInfo r11 = (DetailUserInfo) ListProtector.get(this.b, r10);
        r0.getClass();
        r1.c.setText(r11.getUserName());
        if (TextUtils.isEmpty(r11.getAvatarUrl()) == true) goto L10;
        IRequestCreator r2 = r0.d.load(r11.getAvatarUrl());
        int r3 = r0.c;
        r2.override(r3, r3).into(r1.b);
    L12:
        if (TextUtils.isEmpty(r11.getDescription()) == true) goto L14;
    L16:
        r1.d.setVisibility(0);
        int r4 = ContextCompat.getColor(r0.a, 2131103353);
        Context r5 = r0.a;
        r11.getDescType();
        Drawable r6 = UDIconUtils.getIconDrawable(r5, 2131247433, r4);
        ReactionUserStatusLinearLayout r7 = r1.d;
        String r8 = r11.getDescription();
        r7.a.setImageDrawable(r6);
        r7.b.setText(r8);
    L18:
        if (TextUtils.isEmpty(r11.getWorkStatusDesc()) == false) goto L20;
        r1.e.setVisibility(8);
    L21:
        ((RecyclerView.ViewHolder) r1).itemView.setOnClickListener(new b(r0, r11));
        goto L23
    L20:
        r1.e.setVisibility(0);
        r1.e.setText(r11.getWorkStatusDesc());
        goto L21
    L14:
        if (r11.getDescType() != DetailUserInfo.DescriptionType.DEFAULT) goto L16;
        r1.d.setVisibility(8);
        goto L18
    L10:
        String r12 = r11.getAvatarKey();
        String r13 = r11.getUserId();
        int r14 = r0.c;
        AvatarImage r15 = AvatarImage.Builder.obtain(r12, r13, r14, r14).build();
        IRequestCreator r16 = r0.d.load(r15);
        int r17 = r0.c;
        r16.override(r17, r17).into(r1.b);
    L23:
        if ((r9 instanceof ReactionTipListItemViewHolder) == false) goto L26;
        String r18 = this.e;
        ((ReactionTipListItemViewHolder) r9).a.setText(r18);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        LayoutInflater r0 = LayoutInflater.from(this.a);
        if (r5 != 1) goto L6;
        return new ReactionListItemViewHolder(r0.inflate(2131564260, r4, false));
    L6:
        return new ReactionTipListItemViewHolder(r0.inflate(2131564261, r4, false));
    }
}
