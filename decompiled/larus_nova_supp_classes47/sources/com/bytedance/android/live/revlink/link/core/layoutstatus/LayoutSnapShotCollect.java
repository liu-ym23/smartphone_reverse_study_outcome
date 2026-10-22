package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.core.service.o;
import com.bytedance.android.live.revlink.link.core.service.s;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.q;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LayoutSnapShotCollect {
    public n a;
    public final h b;
    public final g c;
    public final ValidStreamsSnapShot d;
    public final ForwardControlSnapShot e;
    public final AnchorPositionSnapShot f;
    public final j g;
    public final MinFramesSnapShot h;
    public final m i;
    public final List<c<? extends Object>> j;
    public o51.e k;

    public final void a(Function1<? super n, Unit> r22, Function1<? super String, Unit> r23) {
        Intrinsics.checkNotNullParameter(r22, "onResolve");
        Intrinsics.checkNotNullParameter(r23, "onReject");
        final g r3 = this.c;
        o51.e r4 = r3.c.getUiLayout();
        s r5 = r3.b;
        o51.f r6 = r4.a;
        Function1<t51.g, Unit> r7 = new LayoutConfigSnapShot$snapShot$1(r3);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "routerKey");
        Intrinsics.checkNotNullParameter(r7, "onGeckoUpdate");
        Pair r8 = r5.a.b(r6, r7);
        t51.g r9 = (t51.g) r8.component1();
        Disposable r10 = (Disposable) r8.component2();
        Disposable r12 = r3.a;
        if (r12 == null) goto L5;
        r12.dispose();
    L5:
        r3.a = r10;
        if (r9 == null) goto L8;
        f r13 = new f(r4.a, r9);
    L9:
        ValidStreamsSnapShot r14 = this.d;
        r14.getClass();
        LinkedHashMap r15 = new LinkedHashMap();
        r15.putAll(r14.b);
        ForwardControlSnapShot r16 = this.e;
        r16.getClass();
        ArrayList r17 = new ArrayList();
        List<Long> r18 = r16.b;
        if (r18.isEmpty() == false) goto L12;
        r18 = r16.c;
    L12:
        r17.addAll(r18);
        AnchorPositionSnapShot r19 = this.f;
        int r20 = r19.g.d.o;
        r19.b(r19.e.a);
        o r24 = (o) r19.g.b.getValue();
        if (r24 == null) goto L15;
        r19.c(r24);
    L15:
        LinkedHashMap r110 = new LinkedHashMap();
        r110.putAll(r19.c);
        j r25 = this.g;
        Map r26 = (Map) r25.c.getRenderFrames().getValue();
        if (r25.a == true) goto L21;
        LinkedHashMap r27 = new LinkedHashMap(MapsKt.mapCapacity(r26.size()));
        Iterator r28 = r26.entrySet().iterator();
    L19:
        if (r28.hasNext() == false) goto L54;
        Map.Entry r29 = (Map.Entry) r28.next();
        Object r30 = r29.getKey();
        String r32 = (String) r29.getKey();
        r27.put(r30, new i(r32, com.bytedance.android.live.revlink.link.biz.service.i.t(r25).getGuestInfo(null, r32), MainBackupStreamStatus.BACKUP_FLAG_WITH_BACKUP_LINK_ID));
    L54:
        LinkedHashMap r111 = r27;
        l r112 = this.h.a;
        this.i.getClass();
        g r33 = this.c;
        n r34 = this.a;
        if (r34 == null) goto L57;
        f r35 = r34.b;
    L58:
        r33.getClass();
        if (r35 == null) goto L61;
        o51.f r36 = r35.a;
    L62:
        if (r13 == null) goto L64;
        o51.f r37 = r13.a;
    L66:
        if (Intrinsics.areEqual(r36, r37) == false) goto L80;
        if (r35 == null) goto L71;
        t51.g r38 = r35.b;
        if (r38 == null) goto L71;
        String r39 = r38.c();
    L72:
        if (r13 == null) goto L76;
        t51.g r40 = r13.b;
        if (r40 == null) goto L76;
        String r42 = r40.c();
    L78:
        if (Intrinsics.areEqual(r39, r42) == false) goto L80;
        boolean r43 = true;
    L81:
        boolean r44 = !r43;
        ValidStreamsSnapShot r45 = this.d;
        n r46 = this.a;
        if (r46 == null) goto L84;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r47 = r46.c;
    L85:
        boolean r48 = !r45.a(r47, r15);
        ForwardControlSnapShot r49 = this.e;
        n r113 = this.a;
        if (r113 == null) goto L88;
        List<Long> r114 = r113.d;
    L89:
        r49.getClass();
        if (r114 != null) goto L92;
    L101:
        boolean r50 = false;
    L102:
        boolean r52 = !r50;
        AnchorPositionSnapShot r53 = this.f;
        n r115 = this.a;
        if (r115 == null) goto L105;
        Map<String, Integer> r116 = r115.e;
    L106:
        boolean r54 = !r53.a(r116, r110);
        j r117 = this.g;
        n r55 = this.a;
        if (r55 == null) goto L109;
        Map<String, i> r56 = r55.f;
    L110:
        r117.getClass();
        if (r56 != null) goto L113;
    L139:
        boolean r57 = true;
    L140:
        boolean r1 = false;
    L141:
        boolean r2 = r1 ^ r57;
        MinFramesSnapShot r58 = this.h;
        n r118 = this.a;
        if (r118 == null) goto L144;
        l r119 = r118.g;
    L145:
        r58.getClass();
        boolean r59 = MinFramesSnapShot.a(r119, r112) ^ r57;
        n r120 = this.a;
        if (r120 == null) goto L154;
        o51.e r121 = r120.a;
        if (r121 == null) goto L154;
        if (r121.a(this.b.getUiLayout()) != true) goto L154;
        boolean r60 = false;
    L155:
        this.i.getClass();
        if (r44 == true) goto L164;
        if (r48 == true) goto L164;
        if (r52 == true) goto L164;
        if (r54 == true) goto L164;
        if (r60 == true) goto L164;
        if (r2 == true) goto L164;
        if (r59 == true) goto L164;
        boolean r122 = false;
    L165:
        jy0.b.c("LayoutSnapShotCollect", "snapShot with uiLayout: " + this.k + " layoutConfig: " + r13 + ", validStream: " + r15 + ", forwardControl: " + r17 + ", anchorPosition: " + r110 + " and uiLayoutChange: " + r60 + ", layoutChange: " + r44 + ", validStreamChange: " + r48 + ", forwardControlChange: " + r52 + ", anchorPositionChange: " + r54, null, 4);
        if (r122 == true) goto L169;
        r23.invoke("no change");
        return;
    L169:
        n r62 = new n(this.k, r13, r15, r17, r110, r111, r112);
        this.a = r62;
        r22.invoke(r62);
        return;
    L164:
        r122 = true;
    L154:
        r60 = true;
        goto L155
    L144:
        r119 = null;
        goto L145
    L113:
        if (r56.size() != r111.size()) goto L139;
        Iterator r63 = r56.keySet().iterator();
    L117:
        if (r63.hasNext() == false) goto L138;
        String r123 = (String) r63.next();
        Map<String, i> r210 = r56;
        i r64 = r56.get(r123);
        if (r64 == null) goto L139;
        i r124 = (i) r111.get(r123);
        Iterator r125 = r63;
        String r65 = r64.a;
        if (r124 == null) goto L123;
        String r66 = r124.a;
    L125:
        if (Intrinsics.areEqual(r65, r66) == false) goto L133;
        int r67 = r64.c.ordinal();
        if (r124 == null) goto L133;
        MainBackupStreamStatus r68 = r124.c;
        if (r68 == null) goto L133;
        if (r67 != r68.ordinal()) goto L133;
        boolean r69 = true;
    L134:
        r57 = true;
        if (r69 != true) goto L140;
        r63 = r125;
        r56 = r210;
    L133:
        r69 = false;
        goto L134
    L123:
        r66 = null;
        goto L125
    L138:
        r57 = true;
        r1 = true;
        goto L141
    L109:
        r56 = null;
        goto L110
    L105:
        r116 = null;
        goto L106
    L92:
        if (r114.size() != r17.size()) goto L101;
        Iterator<T> r70 = r114.iterator();
    L96:
        if (r70.hasNext() == false) goto L100;
        if (r17.contains(Long.valueOf(((Number) r70.next()).longValue())) == true) goto L96;
    L100:
        r50 = true;
        goto L102
    L88:
        r114 = null;
        goto L89
    L84:
        r47 = null;
    L76:
        r42 = null;
    L71:
        r39 = null;
    L80:
        r43 = false;
        goto L81
    L64:
        r37 = null;
        goto L66
    L61:
        r36 = null;
        goto L62
    L57:
        r35 = null;
        goto L58
    L21:
        r27 = new LinkedHashMap(MapsKt.mapCapacity(r26.size()));
        Iterator r72 = r26.entrySet().iterator();
    L23:
        if (r72.hasNext() == false) goto L54;
        Map.Entry r73 = (Map.Entry) r72.next();
        Object r74 = r73.getKey();
        String r75 = (String) r73.getKey();
        p r126 = com.bytedance.android.live.revlink.link.biz.service.i.t(r25).getGuestInfo(null, r75);
        if (r25.a == false) goto L50;
        if (r126 == null) goto L50;
        com.bytedance.android.livesdk.link.model.bridge.j r127 = q.b(r126);
        if (r127 == null) goto L50;
        if (r127.getUseBackupStream() == false) goto L36;
        if (Intrinsics.areEqual(r75, r127.getMainLinkMicId()) == false) goto L36;
        i r128 = new i(r75, r126, MainBackupStreamStatus.BACKUP_FLAG_WITH_MAIN_LINK_ID);
    L51:
        if (r128 != null) goto L53;
        r128 = new i(r75, com.bytedance.android.live.revlink.link.biz.service.i.t(r25).getGuestInfo(null, r75), MainBackupStreamStatus.BACKUP_FLAG_WITH_BACKUP_LINK_ID);
    L53:
        r27.put(r74, r128);
    L36:
        if (r127.getUseBackupStream() == true) goto L41;
        if (Intrinsics.areEqual(r75, r127.getBackupLinkMicId()) == false) goto L41;
        r128 = new i(r75, r126, MainBackupStreamStatus.MAIN_FLAG_WITH_BACKUP_LINK_ID);
    L41:
        if (r127.getUseBackupStream() == true) goto L46;
        if (Intrinsics.areEqual(r75, r127.getMainLinkMicId()) == false) goto L46;
        r128 = new i(r75, r126, MainBackupStreamStatus.MAIN_FLAG_WITH_MAIN_LINK_ID);
    L46:
        if (r127.getUseBackupStream() == false) goto L50;
        if (Intrinsics.areEqual(r75, r127.getBackupLinkMicId()) == false) goto L50;
        r128 = new i(r75, r126, MainBackupStreamStatus.BACKUP_FLAG_WITH_BACKUP_LINK_ID);
    L50:
        r128 = null;
        goto L51
    L8:
        r13 = null;
        goto L9
    }

    public LayoutSnapShotCollect(s r6, com.bytedance.android.live.revlink.link.infra.rtcbiz.b r7, AnchorLinkUserCenterV2 r8, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r6, "dynamicLayoutClient");
        Intrinsics.checkNotNullParameter(r7, "rtcDataContext");
        Intrinsics.checkNotNullParameter(r8, "anchorLinkUserCenter");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "requestLayout");
        h r0 = new h(r10, new LayoutSnapShotCollect$snapShopContext$1(this));
        this.b = r0;
        g r12 = new g(r6, r0);
        this.c = r12;
        ValidStreamsSnapShot r13 = new ValidStreamsSnapShot(r7, r0);
        this.d = r13;
        ForwardControlSnapShot r1 = new ForwardControlSnapShot(r7, r0, r9);
        this.e = r1;
        AnchorPositionSnapShot r2 = new AnchorPositionSnapShot(r8, r0, r9);
        this.f = r2;
        j r14 = new j(r7, r9);
        this.g = r14;
        MinFramesSnapShot r15 = new MinFramesSnapShot(r9, r0);
        this.h = r15;
        m r3 = new m(r0);
        this.i = r3;
        this.j = CollectionsKt.listOf(new c[]{r12, r13, r1, r2, r14, r15, r3});
        this.k = com.bytedance.android.live.revlink.link.core.service.c.a(r9);
    }
}
