package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.DownloadGiftAssetResultModel;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "downloadGiftAsset")
public final class q2 extends w20.n0<w20.t8, DownloadGiftAssetResultModel> {
    public q2() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void invoke(Object r9, CallContext r11) {
        w20.t8 r12 = (w20.t8) r9;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        ((IGiftService) jc1.k.n(IGiftService.class)).initGiftResourceManager(com.bytedance.android.live.core.utils.s1.getContext());     // Catch: Exception -> L54
        Integer r13 = r12.b();     // Catch: Exception -> L54
        int r0 = LoadingType.PLAY_LOADING.getType();     // Catch: Exception -> L54
        if (r13 != null) goto L7;
    L9:
        int r14 = 1008;
    L10:
        List<Integer> r15 = r12.a();     // Catch: Exception -> L54
        if (r15 == null) goto L16;
        ?? r1 = new ArrayList();     // Catch: Exception -> L54
        Iterator<Integer> r16 = r15.iterator();     // Catch: Exception -> L54
    L14:
        if (r16.hasNext() == false) goto L17;
        r1.add(Long.valueOf(r16.next().intValue()));     // Catch: Exception -> L54
    L17:
        IGiftService r17 = (IGiftService) jc1.k.f(IGiftService.class);     // Catch: Exception -> L54
        if (r17 == null) goto L20;
        IAssetsManager r18 = r17.getAssetsManager();     // Catch: Exception -> L54
    L23:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.T.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[44])).booleanValue() == true) goto L38;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L54
        Iterator r3 = ((Iterable) r1).iterator();     // Catch: Exception -> L54
    L26:
        if (r3.hasNext() == false) goto L52;
        long r5 = ((Number) r3.next()).longValue();     // Catch: Exception -> L54
        if (r18 == null) goto L30;
        com.bytedance.android.live.core.resources.e r7 = r18.G1(r5);     // Catch: Exception -> L54
    L31:
        if (r7 != null) goto L33;
        r2.add(Long.valueOf(r5));     // Catch: Exception -> L54
        com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.scope.service.p.class).a(r5, r14);     // Catch: Exception -> L54
    L35:
        if ((!r2.isEmpty()) == false) goto L26;
        if (r18 == null) goto L26;
        r18.ji(r14, ((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.y0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[75])).booleanValue(), r2, "DownloadGiftAssetMethod");     // Catch: Exception -> L54
        goto L26
    L33:
        com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.scope.service.p.class).f(r5, r14);     // Catch: Exception -> L54
        goto L35
    L30:
        r7 = null;
    L52:
        finishWithSuccess();     // Catch: Exception -> L54
        return;
    L38:
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L54
        Iterator r6 = ((Iterable) r1).iterator();     // Catch: Exception -> L54
    L40:
        if (r6.hasNext() == false) goto L49;
        long r8 = ((Number) r6.next()).longValue();     // Catch: Exception -> L54
        if (r18 == null) goto L44;
        com.bytedance.android.live.core.resources.e r19 = r18.G1(r8);     // Catch: Exception -> L54
    L45:
        if (r19 == null) goto L46;
        com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.scope.service.p.class).f(r8, r14);     // Catch: Exception -> L54
        goto L40
    L46:
        r4.add(Long.valueOf(r8));     // Catch: Exception -> L54
        com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.scope.service.p.class).a(r8, r14);     // Catch: Exception -> L54
        goto L40
    L44:
        r19 = null;
        goto L45
    L49:
        if ((!r4.isEmpty()) == false) goto L52;
        if (r18 == null) goto L52;
        r18.ji(r14, ((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.y0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[75])).booleanValue(), r4, "DownloadGiftAssetMethod");     // Catch: Exception -> L54
        goto L52
    L20:
        r18 = null;
        goto L23
    L16:
        r1 = CollectionsKt.emptyList();     // Catch: Exception -> L54
        goto L17
    L7:
        if (r13.intValue() != r0) goto L9;
        r14 = 1007;
    L54:
        e = move-exception;
        finishWithFailure(e);
    }
}
