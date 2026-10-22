package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import android.os.Message;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.k;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.w;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import i12.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends a<EffectMessage> {
    public final int i;
    public final int j;
    public final int k;
    public final w l;
    public final Lazy m;
    public final IAssetsManager n;

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a
    public final y02.f<EffectMessage> f() {
        return new y02.c();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a, com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final /* bridge */ /* synthetic */ Object c() {
        return p();
    }

    public final EffectMessage p() {
        EffectMessage r0 = (EffectMessage) super.c();
        if (r0 == null) goto L5;
        r0.a(9, com.bytedance.live.kmp.util.e.b());
        return r0;
    L5:
        return null;
    }

    public d(AssetsService r3) {
        Intrinsics.checkNotNullParameter(r3, "mAssetsManager");
        this.n = r3;
        this.i = 200;
        this.j = 500;
        this.k = 400;
        Intrinsics.checkNotNullParameter("EffectMsgManager", "<set-?>");
        this.a = "EffectMsgManager";
        i12.e r4 = o.b();
        if (r4 == null) goto L5;
        Object r5 = m.e.d(r4, w.class);
    L6:
        this.l = (w) r5;
        this.m = LazyKt.lazy(EffectMsgManager$assetFindFailReport$2.INSTANCE);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a
    public final void h(Message r4) {
        String r0 = this.a;
        StringBuilder r1 = new StringBuilder("WARNING: consume timeout ");
        if (r4 == null) goto L5;
        Integer r2 = Integer.valueOf(r4.arg1);
    L6:
        r1.append(r2);
        r1.append(", force trigger consume next EffectMessage!");
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r0, r1.toString());
        super.h(r4);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final int n(EffectMessage r18) {
        boolean r2 = true;
        if (r18 != null) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "onMessageReceived: effectMessage is null");
        return 1;
    L6:
        int r5 = 4;
        r18.a(4, com.bytedance.live.kmp.util.e.b());
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.d(Long.valueOf(r18.a), "onMessageRecived");
        h2 r3 = u.e(r18);
        if (r3 != null) goto L10;
        m("找不到该礼物", r18);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "onMessageReceived: 找不到该礼物 " + r18);
    L10:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.a() == true) goto L12;
    L14:
        boolean r4 = false;
    L15:
        List r9 = null;
        long[] r7 = (long[]) com.bytedance.android.livesdk.gift.platform.business.effect.a.O.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[39]);
        if (r3 == null) goto L18;
        long r10 = r3.getId();
    L20:
        if (ArraysKt.contains(r7, r10) == false) goto L22;
        if (r4 == false) goto L47;
        List r6 = CollectionsKt.toMutableList(r18.M);
    L54:
        if (r6.contains(Long.valueOf(r18.b)) == true) goto L56;
        r6.add(Long.valueOf(r18.b));
    L56:
        Iterator r8 = r6.iterator();
    L58:
        if (r8.hasNext() == false) goto L78;
        long r11 = ((Number) r8.next()).longValue();
        com.bytedance.android.live.core.resources.e r13 = this.n.G1(r11);
        if (r13 == null) goto L61;
        if (this.n.O9(r13) == false) goto L68;
        if (r13.getResourceType() == 9) goto L72;
        if (r13.getId() != r18.b) goto L58;
        r18.f = r13.getResourceType();
        goto L58
    L72:
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.b(Long.valueOf(r18.a), "is multi effect");
        return 4;
    L68:
        m("assets 有效性校验失败", r18);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.a(Long.valueOf(r18.a), "is not valid " + r13.getId(), new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, this.a + " onMsgReceived asset not valid"));
        return 3;
    L61:
        m("特效列表找不到该Id", r18);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "onMessageReceived: 特效列表找不到该 Id " + r18);
        if (((Boolean) this.m.getValue()).booleanValue() == false) goto L151;
        h.u(r11, -2, "-2", -2, -2, -2);
        return 2;
    L151:
        return 2;
    L78:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.d().b() == false) goto L92;
        if (r4 == true) goto L92;
        String r14 = r18.d;
        if (r14 == null) goto L92;
        if (r14.length() <= 0) goto L85;
        boolean r15 = true;
    L86:
        if (r15 != true) goto L92;
        if (r18.f != 11) goto L92;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.b(Long.valueOf(r18.a), "resource ready, skip download");
        o(r18, this.i);
        return 0;
    L85:
        r15 = false;
    L92:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.d().a() == false) goto L104;
        if (r4 == true) goto L104;
        String r16 = r18.d;
        if (r16 == null) goto L104;
        if (r16.length() <= 0) goto L99;
        boolean r17 = true;
    L100:
        if (r17 != true) goto L104;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.b(Long.valueOf(r18.a), "resource ready, skip download");
        o(r18, this.i);
        return 0;
    L99:
        r17 = false;
    L104:
        if (r18.w == false) goto L106;
        AssetDownloadPriority r19 = AssetDownloadPriority.LOCAL;
    L107:
        AssetDownloadPriority r110 = r19;
        Iterator<Map.Entry<Long, iy1.a>> r20 = r18.e.entrySet().iterator();
    L109:
        if (r20.hasNext() == false) goto L116;
        Long r21 = r20.next().getKey();
        String r23 = this.n.D1(r21.longValue());
        if (r23 == null) goto L109;
        w r111 = this.l;
        if (r111 == null) goto L115;
        r111.a(r23);
    L115:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftAssetClean", "资源ID：" + r21 + ", md5: " + r23 + ", 最近使用时间：" + (com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        goto L109
    L116:
        r18.a(6, com.bytedance.live.kmp.util.e.b());
        if (r6.contains(Long.valueOf(r18.b)) == true) goto L119;
        r2 = true ^ r6.isEmpty();
    L123:
        if (r2 == false) goto L131;
        com.bytedance.android.live.core.resources.e r24 = this.n.G1(r18.b);
        Intrinsics.checkNotNull(r24);
        ArrayList r25 = new ArrayList();
        r25.addAll(r6);
        if (r18.w == true) goto L127;
    L129:
        k.a(this.n, r25, new c(this, r18, r24), r5, r110);
    L137:
        return 0;
    L127:
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().b() == false) goto L129;
        r5 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        goto L129
    L131:
        if (r18.w == true) goto L133;
    L135:
        int r112 = 4;
    L136:
        this.n.r0(r18.b, new b(this, r18), r112, r110);
        goto L137
    L133:
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().b() == false) goto L135;
        r112 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        goto L136
    L119:
        if (r6.size() > 1) goto L123;
        r2 = false;
        goto L123
    L106:
        r19 = AssetDownloadPriority.OTHER_SEND;
        goto L107
    L47:
        if (r3 == null) goto L52;
        List<Long> r26 = r3.getAssetIds();
        if (r26 == null) goto L52;
        r6 = CollectionsKt.toMutableList(r26);
        if (r6 != null) goto L54;
    L52:
        r6 = new ArrayList();
        goto L54
    L22:
        if (v.a() == false) goto L27;
        String r27 = this.a;
        StringBuilder r28 = new StringBuilder("EffectMsgManager [AssetsInterceptor]  use requiredAssets ");
        if (r3 == null) goto L26;
        r9 = l0.c(r3);
    L26:
        r28.append(r9);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r27, r28.toString());
    L27:
        if (r3 != null) goto L29;
    L44:
        r6 = CollectionsKt.arrayListOf(new Long[]{Long.valueOf(r18.b)});
        goto L54
    L29:
        if (r3.getType() != 13) goto L44;
        List r29 = l0.c(r3);
        if (r29 == null) goto L34;
        int r30 = r29.size();
    L35:
        if (r30 <= 0) goto L41;
        List r31 = l0.c(r3);
        if (r31 == null) goto L40;
        r6 = CollectionsKt.toMutableList(r31);
        if (r6 != null) goto L54;
    L40:
        r6 = new ArrayList();
        goto L54
    L41:
        r6 = CollectionsKt.toMutableList(r3.getAssetIds());
        if (r6 != null) goto L54;
        r6 = new ArrayList();
        goto L54
    L34:
        r30 = 0;
        goto L35
    L18:
        r10 = 0;
        goto L20
    L12:
        if ((!r18.M.isEmpty()) == false) goto L14;
        r4 = true;
        goto L15
    }

    public static void m(String r3, EffectMessage r4) {
        HashMap r0 = new HashMap();
        r0.put("gift_id", Long.valueOf(r4.l));
        r0.put("msg_id", Long.valueOf(r4.a));
        r0.put("asset_id", Long.valueOf(r4.b));
        r0.put("log_id", r4.n);
        if (r3.length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        r0.put("desc", r3);
    L8:
        jy0.b.c("ttlive_gift", r0.toString(), null, 4);
        return;
    L5:
        r5 = false;
        goto L6
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void o(EffectMessage r5, int r6) {
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.d(Long.valueOf(r5.a), "onMsgLoadEffectOnce isSuccess:" + r6);
        String r0 = v12.f.a;
        v12.f.y(r5, this.f.size(), r6);
        r5.a(8, com.bytedance.live.kmp.util.e.b());
        r5.a(14, this.f.size());
        if (r5.g == true) goto L5;
    L7:
        this.f.put((T) r5);
        if (r6 == this.i) goto L12;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "onMsgLoadEffectOnce not success, eId:" + r5.b + " resCode:" + r6);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.a(Long.valueOf(r5.a), "effectLoad failed eid:" + r5.b + " path:" + r5.d, BuildConfig.FLAVOR, new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, "effectLoad failed"));
        return;
    L12:
        return;
    L5:
        if (r6 != this.i) goto L7;
        this.f.putFirst((T) r5);
    }
}
