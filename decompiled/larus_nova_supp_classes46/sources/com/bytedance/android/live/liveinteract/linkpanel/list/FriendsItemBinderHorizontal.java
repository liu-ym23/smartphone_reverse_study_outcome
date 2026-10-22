package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class FriendsItemBinderHorizontal extends me.drakeet.multitype.b<f, ViewHolder> {
    public final boolean b;
    public final Function1<ILinkPlayerInfoBridge, Unit> c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/FriendsItemBinderHorizontal$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final HSImageView a;
        public final View b;
        public final TextView c;
        public final ImageView d;
        public final ImageView e;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131375128);
            this.b = r2.findViewById(2131392173);
            this.c = (TextView) r2.findViewById(2131392057);
            this.d = (ImageView) r2.findViewById(2131375622);
            this.e = (ImageView) r2.findViewById(2131375621);
        }
    }

    public final boolean h(ILinkPlayerInfoBridge r7) {
        int r0 = vm2.d.i();
        if (r7.getLastInvitedTimeMillis() >= 0) goto L5;
    L8:
        return true;
    L5:
        if ((p6.b() - r7.getLastInvitedTimeMillis()) > (r0 * 1000)) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsItemBinderHorizontal(boolean r2, Function1<? super ILinkPlayerInfoBridge, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onInvite");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        ViewHolder r10 = (ViewHolder) r8;
        f r11 = (f) r9;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        ILinkPlayerInfoBridge r12 = r11.a;
        HSImageView r0 = r10.a;
        IBaseUser r1 = r12.getUser();
        String r2 = null;
        if (r1 == null) goto L5;
        py.k r3 = r1.getAvatarThumbKt();
    L6:
        ImageUtil.loadRoundImage(r0, r3);
        View r4 = r10.b;
        if (r12.isActive() == false) goto L13;
        IBaseUser r5 = r12.getUser();
        if (r5 == null) goto L13;
        if (r5.isMysteryMan() == true) goto L13;
        int r6 = 0;
    L14:
        r4.setVisibility(r6);
        if (r12.isActive() == false) goto L21;
        IBaseUser r7 = r12.getUser();
        if (r7 == null) goto L21;
        if (r7.isMysteryMan() == true) goto L21;
        String r13 = s1.B(2131919317);
    L22:
        TextView r14 = r10.c;
        IBaseUser r15 = r12.getUser();
        if (r15 == null) goto L25;
        String r16 = r15.getRealNickName();
    L26:
        r14.setText(r16);
        if (h(r12) == false) goto L32;
        r10.c.setTextColor(ColorProtector.parseColor("#E5161823"));
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(new k(r10, this, r12));
        r10.d.setVisibility(8);
        r10.e.setVisibility(8);
        View r17 = ((RecyclerView.ViewHolder) r10).itemView;
        StringBuilder r18 = new StringBuilder();
        IBaseUser r19 = r12.getUser();
        if (r19 == null) goto L31;
        r2 = r19.getRealNickName();
    L31:
        r18.append(r2);
        r18.append(' ');
        r18.append(r13);
        r3.a(r17, r18.toString());
    L37:
        if (r12.isHasExposed() == true) goto L40;
        boolean r20 = this.b;
        IBaseUser r21 = r12.getUser();
        Intrinsics.checkNotNull(r21);
        String r22 = r21.getIdString();
        boolean r23 = r12.isActive();
        boolean r24 = h(r12);
        IBaseUser r25 = r12.getUser();
        Intrinsics.checkNotNull(r25);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.i(r20, r22, r23, r24, r25.isSubscriber(), "mutual");
        r12.setHasExposed(true);
        return;
    L40:
        return;
    L32:
        String r26 = s1.B(2131919321);
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(null);
        r10.c.setText(r26);
        r10.c.setTextColor(ColorProtector.parseColor("#57161823"));
        r10.d.setVisibility(0);
        r10.e.setVisibility(0);
        View r27 = ((RecyclerView.ViewHolder) r10).itemView;
        StringBuilder r28 = new StringBuilder();
        r28.append(r26);
        r28.append(' ');
        IBaseUser r29 = r12.getUser();
        if (r29 == null) goto L35;
        r2 = r29.getRealNickName();
    L35:
        r28.append(r2);
        r28.append(' ');
        r28.append(r13);
        r3.a(r27, r28.toString());
        goto L37
    L25:
        r16 = null;
    L21:
        r13 = "";
    L13:
        r6 = 8;
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566301, r5, false));
    }
}
