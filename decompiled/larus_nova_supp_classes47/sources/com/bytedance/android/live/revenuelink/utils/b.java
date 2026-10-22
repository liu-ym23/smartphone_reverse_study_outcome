package com.bytedance.android.live.revenuelink.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n;
import com.bytedance.android.live.revenuelink.rtc.e;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.livesdk.link.model.p;
import fr2.g;
import fr2.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import xh6.c;
import y41.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends e {
    public final /* synthetic */ MultiChannelOptManager a;

    public b(MultiChannelOptManager r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.StringBuilder] */
    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void S2(String r7, Object r8, int r9, int r10) {
        MultiChannelOptManager r12 = this.a;
        i r13 = r12.h;
        if (r13 == null) goto L23;
        List<vc0.a> r14 = r13.L0();
        if (r14 == null) goto L23;
        List<vc0.a> r15 = r14;
        ?? r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L24;
        vc0.a r1 = (vc0.a) r16.next();
        Object r2 = r1.b;
        if ((r2 instanceof c) == true) goto L12;
        c r3 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(g.class), r1.a);
        if ((r3 instanceof g) == true) goto L18;
        r3 = null;
    L18:
        g r4 = (g) r3;
    L19:
        if (r4 == null) goto L21;
        String r5 = r4.getRoomId();
    L22:
        r0.add(r5);
        goto L8
    L21:
        r5 = null;
        goto L22
    L12:
        if ((r2 instanceof g) == true) goto L14;
        r2 = null;
    L14:
        r4 = (g) r2;
    L24:
        i11.b r17 = r12.i;
        if (r17 == null) goto L27;
        p r18 = r17.getGuestInfo(null, r7);
    L28:
        if (r18 == null) goto L30;
        IBaseUser r6 = r18.getUser();
    L32:
        if (r6 == null) goto L38;
        IBaseUser r19 = r18.getUser();
        if (r19 == null) goto L36;
        Long r20 = Long.valueOf(n.a(r19));
    L37:
        boolean r22 = r0.contains(String.valueOf(r20));
    L39:
        if (r22 == true) goto L56;
        ?? r23 = new StringBuilder("remote ");
        r23.append(r7);
        r23.append(" not forward, listUser=");
        if (r18 == null) goto L43;
        String r24 = r18.toSimpleString();
    L44:
        r23.append(r24);
        r23.append(" forwardList=");
        r23.append(r0);
        jy0.b.c("ttlive_anchor_link_MultiChannelOpt", r23.toString(), null, 4);
        if (f.N.h() == true) goto L58;
        int r25 = r12.a;
        if (r25 != 1) goto L50;
    L51:
        r12.a(1, "firstFrameRender", "remote_not_forward");
        return;
    L50:
        if (r25 == 3) goto L51;
        return;
    L58:
        return;
    L43:
        r24 = null;
        goto L44
    L56:
        return;
    L36:
        r20 = null;
        goto L37
    L38:
        jy0.b.d("ttlive_anchor_link_MultiChannelOpt", "list user " + r7 + " not found");
        r22 = true;
        goto L39
    L30:
        r6 = null;
        goto L32
    L27:
        r18 = null;
    L23:
        r0 = CollectionsKt.emptyList();
        goto L24
    }
}
