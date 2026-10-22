package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u000bR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/PairUserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "a", "PairUserViewHolder", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PairUserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/PairUserAdapter$PairUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PairUserViewHolder extends RecyclerView.ViewHolder {
        public final a a;

        public interface a {
        }

        public PairUserViewHolder(View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            Intrinsics.checkNotNullParameter(null, "callback");
            super(r3);
            this.a = null;
        }
    }

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return null;
    }

    public final int getItemCount() {
        throw null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "viewHolder");
        if ((r9 instanceof PairUserViewHolder) == false) goto L25;
        PairUserViewHolder r11 = (PairUserViewHolder) r9;
        IBaseUser r0 = null;
        h0 r12 = (h0) ListProtector.get(null, r10);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "pairUser");
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390292)).setOnClickListener(new w(r11, r12));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391070)).setOnClickListener(new x(r11, r12));
        ILinkPlayerInfoBridge r1 = r12.getGuest();
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.getBaseUser();
        if (r2 == null) goto L9;
        ImageUtil.loadRoundImage((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131374063), r2.getAvatarMedium());
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390993)).setText(r2.getNickName());
    L9:
        ILinkPlayerInfoBridge r3 = r12.getInvestor();
        if (r3 == null) goto L13;
        r0 = r3.getBaseUser();
    L13:
        if (r0 != null) goto L15;
        ((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131376456)).setVisibility(8);
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131375583).setImageResource(2131250965);
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390809)).setText(s1.B(2131923095));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390809)).setTextColor(ColorProtector.parseColor("#57161823"));
        char r13 = 2;
    L21:
        if (r13 != 2) goto L23;
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390292)).setBackground(s1.m(2131250039));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390292)).setTextColor(ColorProtector.parseColor("#4D000000"));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390292)).setClickable(false);
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391070)).setBackground(s1.m(2131250042));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391070)).setTextColor(ColorProtector.parseColor("#7AFFFFFF"));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391070)).setClickable(false);
        return;
    L23:
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390292)).setBackground(s1.m(2131250038));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390292)).setTextColor(ColorProtector.parseColor("#E6000000"));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390292)).setClickable(true);
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391070)).setBackground(s1.m(2131250041));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391070)).setTextColor(ColorProtector.parseColor("#FFFFFF"));
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391070)).setClickable(true);
        return;
    L15:
        ILinkPlayerInfoBridge r14 = r12.getInvestor();
        if (r14 == null) goto L20;
        IBaseUser r15 = r14.getBaseUser();
        if (r15 == null) goto L20;
        ((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131376456)).setVisibility(0);
        ImageUtil.loadRoundImage((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131375583), r15.getAvatarMedium());
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390809)).setText(r15.getNickName());
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390809)).setTextColor(ColorProtector.parseColor("#B3161823"));
    L20:
        r13 = 0;
        goto L21
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PairUserViewHolder(LayoutInflater.from(null).inflate(2131566431, r4, false));
    }
}
