package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.utils.x0;
import dl0.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends me.drakeet.multitype.b<c1, PkSimplePreApplyViewHolder> {
    public p() {
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        PkSimplePreApplyViewHolder r10 = (PkSimplePreApplyViewHolder) r8;
        c1 r11 = (c1) r9;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        int r0 = r10.getAdapterPosition();
        if (r11 == null) goto L44;
        final vh7.c r1 = r11.f();
        if (r1 == null) goto L45;
        ImageUtil.loadRoundImage(r10.b, r1.getAvatarThumbKt());
        TextView r2 = r10.a;
        if (r0 < 99) goto L9;
        String r3 = "99+";
    L10:
        r2.setText(r3);
        r10.c.setText(r1.getNickName());
        LinearLayout r4 = r10.e;
        r4.removeViews(1, r4.getChildCount() - 1);
        vh7.c r5 = jm2.a.d(r1);
        dl0.e r6 = null;
        if ((r5 instanceof User) == true) goto L13;
        r5 = null;
    L13:
        User r7 = (User) r5;
        dl0.a[] r12 = new dl0.a[3];
        s r13 = s.c;
        s.b = new WeakReference(r7);
        if (r13.d() == true) goto L17;
        r13 = null;
    L17:
        r12[0] = r13;
        dl0.g r14 = dl0.g.c;
        dl0.g.b = new WeakReference(r7);
        if (r14.d() == true) goto L21;
        r14 = null;
    L21:
        r12[1] = r14;
        dl0.e r15 = dl0.e.c;
        if (r7 == null) goto L24;
        com.bytedance.android.live.profit.fansclub.b r16 = dl0.e.d(r7);
    L25:
        dl0.e.b = new WeakReference(r16);
        if (r15.e() == false) goto L28;
        r6 = r15;
    L28:
        r12[2] = r6;
        List r17 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r12));
        boolean r18 = jc1.k.n(IKtvService.class).isKtvComponentOpen();
        int r19 = dl0.b.a;
        Iterator r20 = dl0.b.d(r17, r18).iterator();
    L30:
        if (r20.hasNext() == false) goto L35;
        dl0.a r21 = (dl0.a) r20.next();
        View r22 = r10.f.get(r21.b());
        if (r22 == null) goto L30;
        r21.c(r22);
        r10.e.addView(r22);
        goto L30
    L35:
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(x0.a(new PkSimplePreApplyViewHolder$bindView$1$2(r1)));
        TextView r23 = r10.d;
        if (r23 == null) goto L46;
        long r24 = 1000;
        r23.setText(TimeUtils.getTimeDescription(s1.getContext(), r11.a() * r24, r11.b * r24));
        return;
    L46:
        return;
    L24:
        r16 = null;
        goto L25
    L9:
        r3 = String.valueOf(r0);
        goto L10
    L45:
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = r8.inflate(2131566291, r9, false);
        List r0 = CollectionsKt.listOf(new dl0.a[]{dl0.g.c, dl0.e.c, s.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        dl0.a r3 = (dl0.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new PkSimplePreApplyViewHolder(r10, r2);
    }
}
