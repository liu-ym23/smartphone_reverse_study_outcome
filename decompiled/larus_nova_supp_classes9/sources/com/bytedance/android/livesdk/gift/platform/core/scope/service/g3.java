package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g3 implements com.bytedance.android.scope.o {
    public final String a;
    public final int b;
    public final AssetsService c;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.delete.w d;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public g3(AssetsService r2, com.bytedance.android.livesdk.gift.platform.business.effect.delete.w r3) {
        Intrinsics.checkNotNullParameter(r2, "assetsService");
        Intrinsics.checkNotNullParameter(r3, "resourceRoomService");
        this.c = r2;
        this.d = r3;
        this.a = "SendTogetherService";
        this.b = 3;
    }

    public final void c(NormalGiftMessage r16, j3 r17) {
        Intrinsics.checkNotNullParameter(r17, "resultCallback");
        if (r16 != null) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        gm2.d r1 = r16.t;
        com.bytedance.android.livesdk.gift.model.h1 r5 = null;
        boolean r7 = true;
        if ((r1 instanceof o7) == false) goto L39;
        com.bytedance.android.livesdk.gift.model.h2 r2 = com.bytedance.android.livesdk.gift.platform.core.utils.u.f(r16.r());
        if (r2 != null) goto L11;
        return;
    L11:
        if (ArraysKt.contains((long[]) com.bytedance.android.livesdk.gift.platform.business.effect.a.O.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[39]), r2.getId()) == true) goto L32;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L16;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a, "SendTogtherService [AssetsInterceptor] use requiredAssets " + l0.c(r2));
    L16:
        if (r2.getType() == 13) goto L18;
        r0.add(Long.valueOf(r2.getPrimaryEffectId()));
    L35:
        if (r0.contains(Long.valueOf(r2.getPrimaryEffectId())) == true) goto L37;
        r0.add(Long.valueOf(r2.getPrimaryEffectId()));
    L37:
        r5 = r2;
    L65:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a, "资源下载id" + r0);
        if (r16.v == false) goto L68;
        AssetDownloadPriority r3 = AssetDownloadPriority.LOCAL;
    L69:
        AssetDownloadPriority r14 = r3;
        if (r5 == null) goto L99;
        Iterator r4 = r0.iterator();
    L73:
        if (r4.hasNext() == false) goto L81;
        long r9 = ((Number) r4.next()).longValue();
        com.bytedance.android.live.core.resources.e r6 = this.c.G1(r9);
        if (r6 == null) goto L76;
        if (this.c.O9(r6) == true) goto L73;
        a("assets 有效性校验失败", r16, r9);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.c.a(Long.valueOf(r16.a), "is not valid " + r6.getId(), new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, this.a + " onMsgReceived asset not valid"));
    L80:
        boolean r8 = false;
    L82:
        if (r8 == false) goto L99;
        Iterator r10 = r0.iterator();
    L85:
        if (r10.hasNext() == false) goto L89;
        long r11 = ((Number) r10.next()).longValue();
        String r13 = this.c.D1(r11);
        if (r13 == null) goto L85;
        this.d.a(r13);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftAssetClean", "资源ID：" + r11 + ", md5: " + r13 + ", 最近使用时间：" + (com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        goto L85
    L89:
        r16.setTimeStampMap(6, com.bytedance.live.kmp.util.e.b());
        if (r0.contains(Long.valueOf(r5.getPrimaryEffectId())) == true) goto L92;
        r7 = true ^ r0.isEmpty();
    L96:
        if (r7 == false) goto L98;
        com.bytedance.android.live.core.resources.e r15 = this.c.G1(r5.getPrimaryEffectId());
        Intrinsics.checkNotNull(r15);
        ArrayList r18 = new ArrayList();
        r18.addAll(r0);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a(this.c, r18, new f3(this, r16, r15, r17, r18), 4, r14);
        return;
    L98:
        this.c.r0(r5.getPrimaryEffectId(), new e3(this, r16, r17, r5.getPrimaryEffectId()), 4, r14);
        return;
    L92:
        if (r0.size() > 1) goto L96;
        r7 = false;
        goto L96
    L76:
        a("特效列表找不到该Id", r16, r9);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "checkAssetValid: 特效列表找不到该 Id " + r16.a);
        goto L80
    L81:
        r8 = true;
    L99:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.a, "资源校验错误，丢掉此次消息，消息id " + r16.a + ", 特效ID " + r0);
        return;
    L68:
        r3 = AssetDownloadPriority.OTHER_SEND;
        goto L69
    L18:
        List r19 = l0.c(r2);
        if (r19 == null) goto L21;
        int r20 = r19.size();
    L22:
        if (r20 <= 0) goto L29;
        List r21 = l0.c(r2);
        if (r21 == null) goto L26;
        List r23 = r21;
    L27:
        r0.addAll(r23);
        goto L35
    L26:
        r23 = new ArrayList();
        goto L27
    L29:
        if (r2.getAssetIds() == null) goto L35;
        r0.addAll(r2.getAssetIds());
        goto L35
    L21:
        r20 = 0;
        goto L22
    L32:
        if (r2.getAssetIds() == null) goto L35;
        r0.addAll(r2.getAssetIds());
        goto L35
    L39:
        if ((r1 instanceof q8) == false) goto L49;
        r5 = r16.s().getGift();
        if (r5 == null) goto L65;
        com.bytedance.android.livesdk.gift.model.h1 r24 = r5;
        if (r24.getAssetIds() == null) goto L46;
        r0.addAll(r24.getAssetIds());
    L46:
        if (r0.contains(Long.valueOf(r24.getPrimaryEffectId())) == true) goto L65;
        r0.add(Long.valueOf(r24.getPrimaryEffectId()));
        goto L65
    L49:
        if ((r1 instanceof k6) == false) goto L65;
        r0.add(Long.valueOf(r16.o().getAssetId()));
        List r25 = r16.o().getRequiredAssets();
        if (r25 != null) goto L53;
    L56:
        boolean r26 = true;
    L57:
        if (r26 == true) goto L65;
        List r27 = r16.o().getRequiredAssets();
        if (r27 == null) goto L65;
        List r28 = r27;
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L62:
        if (r30.hasNext() == false) goto L64;
        r29.add(Long.valueOf(((Number) r30.next()).intValue()));
        goto L62
    L64:
        r0.addAll(r29);
        goto L65
    L53:
        if (r25.isEmpty() == true) goto L56;
        r26 = false;
        goto L57
    }

    public static void a(String r3, NormalGiftMessage r4, long r5) {
        HashMap r0 = new HashMap();
        r0.put("gift_id", Long.valueOf(r4.b));
        r0.put("msg_id", Long.valueOf(r4.a));
        r0.put("asset_id", Long.valueOf(r5));
        r0.put("log_id", r4.getLogId());
        if (r3.length() <= 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        r0.put("desc", r3);
    L8:
        jy0.b.c("ttlive_gift", r0.toString(), null, 4);
        return;
    L5:
        r6 = false;
        goto L6
    }
}
