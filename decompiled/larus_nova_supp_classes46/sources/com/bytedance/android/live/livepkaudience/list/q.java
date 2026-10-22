package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.user.IUserService;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends me.drakeet.multitype.b<WaitingListUser, SimplePkGuestApplyViewHolder> {
    public final Function1<WaitingListUser, Integer> b;

    /* JADX WARN: Multi-variable type inference failed */
    public q(Function1<? super WaitingListUser, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "getItemPosition");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r14, Object r15) {
        final SimplePkGuestApplyViewHolder r16 = (SimplePkGuestApplyViewHolder) r14;
        final WaitingListUser r17 = (WaitingListUser) r15;
        Intrinsics.checkNotNullParameter(r16, "holder");
        Intrinsics.checkNotNullParameter(r17, "item");
        final Function1<WaitingListUser, Integer> r0 = this.b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r0, "getItemPosition");
        if (r17 == null) goto L74;
        vh7.c r1 = r17.getUser();
        if (r1 == null) goto L75;
        final User r2 = jm2.a.e(r1);
        if (r2 == null) goto L76;
        ImageUtil.loadRoundImage(r16.b, r2.getAvatarThumb());
        IBaseUser r3 = r17.getUserFlex();
        dl0.e r4 = null;
        if (r3 == null) goto L11;
        String r5 = r3.getIdString();
    L12:
        com.bytedance.android.livesdk.user.f r6 = jc1.k.n(IUserService.class).user();
        if (r6 == null) goto L15;
        String r7 = r6.n();
    L17:
        if (Intrinsics.areEqual(r5, r7) == false) goto L23;
        TextView r8 = r16.a;
        n0 r9 = tc0.c.h().P;
        if (r9 == null) goto L21;
        Long r10 = Long.valueOf(r9.getOffset());
    L22:
        r8.setText(String.valueOf(r10));
    L31:
        r16.c.setText(r2.getNickName());
        LinearLayout r11 = r16.d;
        boolean r12 = true;
        r11.removeViews(1, r11.getChildCount() - 1);
        dl0.a[] r13 = new dl0.a[5];
        s r18 = s.c;
        s.b = new WeakReference(r2);
        if (r18.d() == true) goto L35;
        r18 = null;
    L35:
        r13[0] = r18;
        dl0.g r19 = dl0.g.c;
        dl0.g.b = new WeakReference(r2);
        if (r19.d() == true) goto L39;
        r19 = null;
    L39:
        r13[1] = r19;
        dl0.o r20 = dl0.o.c;
        dl0.o.a = new WeakReference(r2);
        if (r20.d() == true) goto L43;
        r20 = null;
    L43:
        r13[2] = r20;
        c r21 = c.c;
        WeakReference<WaitingListUser> r22 = new WeakReference(r17);
        c.b = r22;
        WaitingListUser r23 = r22.get();
        if (r23 == null) goto L53;
        MicPosTagInfo r24 = r23.getMicPosTag();
        if (r24 == null) goto L53;
        if (r24.getTagType() <= 0) goto L53;
        int r25 = k81.c.a;
        if (k81.c.b(r24.getPositionTagName()) == false) goto L53;
    L54:
        if (r12 == true) goto L57;
        r21 = null;
    L57:
        r13[3] = r21;
        dl0.e r26 = dl0.e.c;
        dl0.e.b = new WeakReference(dl0.e.d(r2));
        if (r26.e() == false) goto L60;
        r4 = r26;
    L60:
        r13[4] = r4;
        List r27 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r13));
        boolean r28 = jc1.k.n(IKtvService.class).isKtvComponentOpen();
        int r29 = dl0.b.a;
        Iterator r30 = dl0.b.d(r27, r28).iterator();
    L62:
        if (r30.hasNext() == false) goto L67;
        dl0.a r31 = (dl0.a) r30.next();
        View r32 = r16.e.get(r31.b());
        if (r32 == null) goto L62;
        r31.c(r32);
        r16.d.addView(r32);
        goto L62
    L67:
        ((RecyclerView.ViewHolder) r16).itemView.setOnClickListener(x0.a(new SimplePkGuestApplyViewHolder$bindView$$inlined$let$lambda$1(r2, r16, r17, r0)));
        return;
    L53:
        r12 = false;
        goto L54
    L21:
        r10 = null;
        goto L22
    L23:
        TextView r33 = r16.a;
        if (((Number) r0.invoke(r17)).intValue() < 100) goto L27;
        String r34 = "99+";
    L30:
        r33.setText(r34);
        goto L31
    L27:
        if (((Number) r0.invoke(r17)).intValue() != 0) goto L29;
        r34 = "-";
        goto L30
    L29:
        r34 = String.valueOf(((Number) r0.invoke(r17)).intValue());
        goto L30
    L15:
        r7 = null;
        goto L17
    L11:
        r5 = null;
        goto L12
    L76:
        return;
    L75:
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = r8.inflate(2131566291, r9, false);
        List r0 = CollectionsKt.listOf(new dl0.a[]{s.c, dl0.o.c, dl0.g.c, dl0.e.c, c.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        dl0.a r3 = (dl0.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new SimplePkGuestApplyViewHolder(r10, r2);
    }
}
