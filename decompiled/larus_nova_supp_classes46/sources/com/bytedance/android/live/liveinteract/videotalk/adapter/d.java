package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.util.e;
import com.bytedance.android.live.liveinteract.linkpanel.util.x;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.plantform.model.c0;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.live.liveinteract.videotalk.fragment.VideoRoomPreApplyFragment;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.f;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.utils.x0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends me.drakeet.multitype.b<c1, VideoRoomAudiencePreApplyViewHolder> {
    public final VideoRoomAudiencePreApplyViewHolder.a b;

    public d(VideoRoomPreApplyFragment.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r18, Object r19) {
        final VideoRoomAudiencePreApplyViewHolder r0 = (VideoRoomAudiencePreApplyViewHolder) r18;
        final c1 r1 = (c1) r19;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Intrinsics.checkNotNullParameter(r1, "item");
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "prepareApplyUser");
        final IBaseUser r2 = r1.b();
        if (r2 == null) goto L70;
        r0.b.setText(r2.getNickName());
        ImageUtil.loadRoundImage(r0.a, r2.getAvatarThumbKt());
        r0.a.setOnClickListener(x0.a(new VideoRoomAudiencePreApplyViewHolder$bindView$1$1(r2)));
        int r5 = r2.getGender();
        if (r5 == 1) goto L9;
        if (r5 == 2) goto L8;
        r0.f.setVisibility(8);
    L10:
        LinearLayout r6 = r0.d;
        r6.removeViews(1, r6.getChildCount() - 1);
        com.bytedance.android.live.liveinteract.linkpanel.util.a[] r7 = new com.bytedance.android.live.liveinteract.linkpanel.util.a[4];
        y r8 = y.c;
        r8.f(r2);
        if (r8.e() == true) goto L14;
        r8 = null;
    L14:
        r7[0] = r8;
        e r9 = e.c;
        r9.g(r2);
        if (r9.f() == true) goto L18;
        r9 = null;
    L18:
        r7[1] = r9;
        x r10 = x.e;
        x.a = new WeakReference(r2);
        x.b = new WeakReference(r1.e());
        if (r10.e() == true) goto L22;
        r10 = null;
    L22:
        r7[2] = r10;
        com.bytedance.android.live.liveinteract.linkpanel.util.d r11 = com.bytedance.android.live.liveinteract.linkpanel.util.d.c;
        r11.g(com.bytedance.android.live.liveinteract.linkpanel.util.d.e(r2, r1.e()));
        if (r11.f() == true) goto L26;
        r11 = null;
    L26:
        r7[3] = r11;
        List r12 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r7));
        String r13 = "";
        r0.i = "";
        int r14 = com.bytedance.android.live.liveinteract.linkpanel.util.b.a;
        if (k.n(IKtvService.class).isKtvComponentOpen() == false) goto L29;
    L32:
        boolean r15 = true;
    L33:
        Iterator r16 = com.bytedance.android.live.liveinteract.linkpanel.util.b.d(r12, r15).iterator();
    L35:
        if (r16.hasNext() == false) goto L46;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r17 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r16.next();
        View r20 = r0.k.get(r17.b());
        if (r20 == null) goto L35;
        r17.d(r20, null);
        r0.d.addView(r20);
        if (r17.c().length() <= 0) goto L42;
        boolean r21 = true;
    L43:
        if (r21 == false) goto L35;
        r0.i = r0.i + r17.c() + ',';
        goto L35
    L42:
        r21 = false;
        goto L43
    L46:
        if (r0.i.length() <= 0) goto L48;
        boolean r22 = true;
    L49:
        if (r22 == false) goto L52;
        String r23 = r0.i;
        r0.i = r23.substring(0, r23.length() - 1);
    L52:
        if (r1.a == false) goto L54;
        r0.e.setText(s1.B(2131919209));
        r0.e.setBackgroundResource(2131249430);
    L56:
        if (r1.c == true) goto L69;
        int r24 = jf0.b.a;
        String r25 = r2.getIdString();
        boolean r110 = r0.g;
        String r111 = r0.i;
        c0 r3 = r1.c();
        if (r3 == null) goto L67;
        Intrinsics.checkNotNullParameter(r3, "$this$exposeName");
        int r4 = r3.getEventInfoType();
        if (r4 != 5) goto L62;
        r13 = "browse";
    L66:
        String r112 = r13;
    L68:
        jf0.b.l(r25, true, "", "list", r110, r111, r112, "pre_request", 992);
        goto L69
    L62:
        if (r4 != 6) goto L66;
        r13 = "order";
        goto L66
    L67:
        r112 = null;
    L69:
        r0.e.setOnClickListener(x0.a(new VideoRoomAudiencePreApplyViewHolder$bindView$$inlined$let$lambda$1(r0, r1)));
        goto L70
    L54:
        r0.e.setText(s1.B(2131919204));
        r0.e.setBackgroundResource(2131249467);
        goto L56
    L48:
        r22 = false;
        goto L49
    L29:
        if (je0.d.y() == true) goto L32;
        r15 = false;
        goto L33
    L8:
        r0.f.setVisibility(0);
        r0.f.setImageResource(2131250687);
        goto L10
    L9:
        r0.f.setVisibility(0);
        r0.f.setImageResource(2131250688);
    L70:
        String r26 = TimeUtils.getTimeDescription(s1.getContext(), r1.a() * ((long) 1000));
        if (vm2.d.I0() == false) goto L82;
        c0 r27 = r1.c();
        if (r27 == null) goto L75;
        a5 r28 = r27.getContent();
    L76:
        if (r28 == null) goto L82;
        f.a.getClass();
        r r29 = r.g;
        c0 r30 = r1.c();
        if (r30 == null) goto L80;
        a5 r31 = r30.getContent();
    L81:
        Intrinsics.checkNotNull(r31);
        r29.d(r31, null, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(0.0f), new c(r1, r26, r0));
    L83:
        r1.c = true;
        return;
    L80:
        r31 = null;
        goto L81
    L75:
        r28 = null;
    L82:
        r0.c.setText(r26);
        goto L83
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = r8.inflate(2131566435, r9, false);
        List r0 = CollectionsKt.listOf(new com.bytedance.android.live.liveinteract.linkpanel.util.a[]{y.c, x.e, e.c, com.bytedance.android.live.liveinteract.linkpanel.util.d.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r3 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new VideoRoomAudiencePreApplyViewHolder(r10, this.b, r2);
    }
}
