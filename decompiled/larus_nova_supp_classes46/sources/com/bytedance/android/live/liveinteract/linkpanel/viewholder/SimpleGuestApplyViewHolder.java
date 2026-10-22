package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.linkpanel.util.HighScoreSongBadgeProvider;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/SimpleGuestApplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SimpleGuestApplyViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final LinearLayout f;
    public final View g;
    public n0 h;
    public final Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, View> i;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleGuestApplyViewHolder(View r2, Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, ? extends View> r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "badgeTypeMap");
        super(r2);
        this.i = r3;
        this.a = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391017);
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376286);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390975);
        this.d = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390479);
        this.e = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131380597);
        this.f = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388092);
        this.g = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372059);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.bytedance.android.live.liveinteract.linkpanel.util.a[], java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.bytedance.android.live.liveinteract.linkpanel.util.HighScoreSongBadgeProvider, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58, types: [com.bytedance.android.live.liveinteract.linkpanel.viewholder.b, java.lang.Object] */
    public final void T3(final n0 r19, final Function1<? super n0, Integer> r20) {
        Intrinsics.checkNotNullParameter(r20, "getItemPosition");
        this.h = r19;
        if (h.U().i() == false) goto L10;
        Integer r3 = (Integer) b6.B.getValue();
        if (r3 == null) goto L10;
        if (r3.intValue() != 42) goto L10;
        this.e.getViewTreeObserver().addOnPreDrawListener(new c(this));
    L10:
        if (r19 == null) goto L135;
        final IBaseUser r4 = r19.getUserFlex();
        if (r4 == null) goto L136;
        ImageUtil.loadRoundImage(this.b, r4.getAvatarThumbKt());
        int r5 = ((Number) r20.invoke(r19)).intValue();
        TextView r6 = this.a;
        if (r5 < 1000) goto L16;
        String r7 = "999+";
    L19:
        r6.setText(r7);
        this.c.setText(r4.getNickName());
        this.f.removeAllViews();
        g0 r8 = r19.getMicPosTagFlex();
        if (r8 != null) goto L23;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r9 = HighScoreSongBadgeProvider.d;
    L33:
        ?? r11 = new com.bytedance.android.live.liveinteract.linkpanel.util.a[4];
        y r12 = y.c;
        r12.f(r4);
        IRoom r14 = null;
        if (r12.e() == true) goto L37;
        r12 = null;
    L37:
        r11[0] = r12;
        com.bytedance.android.live.liveinteract.linkpanel.util.e r13 = com.bytedance.android.live.liveinteract.linkpanel.util.e.c;
        r13.g(r4);
        if (r13.f() == true) goto L41;
        r13 = null;
    L41:
        r11[1] = r13;
        com.bytedance.android.live.liveinteract.linkpanel.util.d r15 = com.bytedance.android.live.liveinteract.linkpanel.util.d.c;
        r15.g(com.bytedance.android.live.liveinteract.linkpanel.util.d.e(r4, null));
        if (r15.f() == true) goto L45;
        r15 = null;
    L45:
        r11[2] = r15;
        if ((r9 instanceof b) == false) goto L62;
        ?? r10 = (b) r9;
        r10.getClass();
        WeakReference<n0> r16 = new WeakReference(r19);
        b.a = r16;
        n0 r17 = r16.get();
        if (r17 == null) goto L58;
        g0 r18 = r17.getMicPosTagFlex();
        if (r18 == null) goto L58;
        if (r18.getTagType() <= 0) goto L58;
        if (r2.a(r18.getPositionTagName()) == false) goto L58;
        boolean r110 = true;
    L59:
        if (r110 == true) goto L67;
    L66:
        r10 = 0;
    L67:
        r11[3] = r10;
        List r21 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r11));
        int r111 = com.bytedance.android.live.liveinteract.linkpanel.util.b.a;
        Iterator r22 = com.bytedance.android.live.liveinteract.linkpanel.util.b.d(r21, o.u()).iterator();
    L69:
        if (r22.hasNext() == false) goto L78;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r112 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r22.next();
        View r113 = this.i.get(r112.b());
        if (r113 == null) goto L69;
        if ((r112 instanceof b) == false) goto L76;
        r112.d(r113, new SimpleGuestApplyViewHolder$bindView$$inlined$let$lambda$1(this, r19, r20));
    L77:
        this.f.addView(r113);
        goto L69
    L76:
        r112.d(r113, null);
        goto L77
    L78:
        o.z();
        if (o.z() == false) goto L81;
    L83:
        m r23 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r23 == null) goto L86;
        r14 = (IRoom) r23.getValue();
    L86:
        String r24 = "0";
        if (o.x(r14) == true) goto L89;
    L113:
        Integer r25 = (Integer) b6.B.getValue();
        if (r25 != null) goto L117;
    L122:
        if (r25 != null) goto L125;
    L127:
        long r26 = 1000;
        this.d.setText(TimeUtils.getTimeDescription(s1.getContext(), r19.getModifyTime() * r26, tc0.c.h().Q * r26));
    L128:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(x0.a(new SimpleGuestApplyViewHolder$bindView$$inlined$let$lambda$2(r4, this, r19, r20)));
        return;
    L125:
        if (r25.intValue() != 42) goto L127;
        TextView r27 = this.d;
        StringBuilder r28 = new StringBuilder();
        long r114 = 1000;
        r28.append(TimeUtils.getTimeDescription(s1.getContext(), r19.getModifyTime() * r114, tc0.c.h().Q * r114));
        r28.append(" | ");
        r28.append(r19.getFanTicket());
        r27.setText(r28.toString());
        goto L128
    L117:
        if (r25.intValue() != 41) goto L122;
        TextView r29 = this.d;
        String r30 = r19.getFanTicket();
        if (r30 == null) goto L121;
        r24 = r30;
    L121:
        r29.setText(r24);
        goto L128
    L89:
        if (o.y() == false) goto L113;
        if (r19.isAddPrice() == false) goto L93;
        this.d.setText(o.f(s1.getContext(), r19.getAddPriceTime(), tc0.c.h().Q * ((long) 1000)));
        goto L128
    L93:
        Integer r31 = (Integer) b6.B.getValue();
        if (r31 != null) goto L97;
    L102:
        TextView r32 = this.d;
        Context r33 = s1.getContext();
        long r115 = 1000;
        long r34 = r19.getModifyTime() * r115;
        long r116 = tc0.c.h().Q * r115;
        Intrinsics.checkNotNullParameter(r33, "context");
        long r117 = r116 - r34;
        long r118 = 60000;
        if (r117 > r118) goto L105;
        String r35 = r33.getString(2131921166);
    L112:
        r32.setText(r35);
        goto L128
    L105:
        long r36 = 3600000;
        if (r117 > r36) goto L109;
        int r37 = (int) (r117 / r118);
        r35 = r33.getResources().getQuantityString(2131755251, r37, new Object[]{Integer.valueOf(r37)});
        goto L112
    L109:
        if (r117 > 86400000) goto L111;
        int r38 = (int) (r117 / r36);
        r35 = r33.getResources().getQuantityString(2131755250, r38, new Object[]{Integer.valueOf(r38)});
        goto L112
    L111:
        r35 = o.a.format(new Date(r34));
        goto L112
    L97:
        if (r31.intValue() != 41) goto L102;
        TextView r39 = this.d;
        String r40 = r19.getFanTicket();
        if (r40 == null) goto L101;
        r24 = r40;
    L101:
        r39.setText(r24);
        goto L128
    L81:
        if (r19.getPaidAmount() <= 0) goto L83;
        this.d.setText(s1.C(2131897351, new Object[]{Long.valueOf(r19.getPaidAmount())}));
    L58:
        r110 = false;
        goto L59
    L62:
        if ((r9 instanceof HighScoreSongBadgeProvider) == false) goto L66;
        r10 = (HighScoreSongBadgeProvider) r9;
        fc r119 = r19.getUserHighScoreSongTagFlex();
        r10.getClass();
        HighScoreSongBadgeProvider.b = new WeakReference(r119);
        if (r10.e() == false) goto L66;
    L23:
        if (r8.getTagType() <= 0) goto L32;
        String r41 = r8.getPositionTagName();
        if (r41 == null) goto L32;
        if (r41.length() <= 0) goto L29;
        boolean r42 = true;
    L30:
        if (r42 != true) goto L32;
        r9 = b.b;
        goto L33
    L29:
        r42 = false;
    L32:
        r9 = HighScoreSongBadgeProvider.d;
        goto L33
    L16:
        if (r5 != 0) goto L18;
        r7 = "-";
        goto L19
    L18:
        r7 = String.valueOf(r5);
        goto L19
    L136:
        return;
    }
}
