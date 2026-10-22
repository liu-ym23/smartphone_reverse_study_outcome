package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.livesdk.utils.x0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/SimplePreApplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SimplePreApplyViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, View> f;

    /* JADX WARN: Multi-variable type inference failed */
    public SimplePreApplyViewHolder(View r2, Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, ? extends View> r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "badgeTypeMap");
        super(r2);
        this.f = r3;
        this.a = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391017);
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376286);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390975);
        this.d = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390479);
        this.e = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131380597);
    }

    public final void T3(c1 r8, int r9) {
        if (r8 == null) goto L37;
        final IBaseUser r0 = r8.b();
        if (r0 == null) goto L38;
        ImageUtil.loadRoundImage(this.b, r0.getAvatarThumbKt());
        TextView r1 = this.a;
        if (r9 < 99) goto L8;
        String r10 = "99+";
    L9:
        r1.setText(r10);
        this.c.setText(r0.getNickName());
        LinearLayout r11 = this.e;
        r11.removeViews(1, r11.getChildCount() - 1);
        com.bytedance.android.live.liveinteract.linkpanel.util.a[] r12 = new com.bytedance.android.live.liveinteract.linkpanel.util.a[3];
        y r2 = y.c;
        r2.f(r0);
        if (r2.e() == true) goto L13;
        r2 = null;
    L13:
        r12[0] = r2;
        com.bytedance.android.live.liveinteract.linkpanel.util.e r3 = com.bytedance.android.live.liveinteract.linkpanel.util.e.c;
        r3.g(r0);
        if (r3.f() == true) goto L17;
        r3 = null;
    L17:
        r12[1] = r3;
        com.bytedance.android.live.liveinteract.linkpanel.util.d r4 = com.bytedance.android.live.liveinteract.linkpanel.util.d.c;
        r4.g(com.bytedance.android.live.liveinteract.linkpanel.util.d.e(r0, null));
        if (r4.f() == true) goto L21;
        r4 = null;
    L21:
        r12[2] = r4;
        List r13 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r12));
        int r5 = com.bytedance.android.live.liveinteract.linkpanel.util.b.a;
        Iterator r14 = com.bytedance.android.live.liveinteract.linkpanel.util.b.d(r13, o.u()).iterator();
    L23:
        if (r14.hasNext() == false) goto L28;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r6 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r14.next();
        View r7 = this.f.get(r6.b());
        if (r7 == null) goto L23;
        r6.d(r7, null);
        this.e.addView(r7);
        goto L23
    L28:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(x0.a(new SimplePreApplyViewHolder$bindView$1$2(r0)));
        TextView r15 = this.d;
        if (r15 == null) goto L39;
        long r16 = 1000;
        r15.setText(TimeUtils.getTimeDescription(s1.getContext(), r8.a() * r16, r8.b * r16));
        return;
    L39:
        return;
    L8:
        r10 = String.valueOf(r9);
        goto L9
    L38:
        return;
    }
}
