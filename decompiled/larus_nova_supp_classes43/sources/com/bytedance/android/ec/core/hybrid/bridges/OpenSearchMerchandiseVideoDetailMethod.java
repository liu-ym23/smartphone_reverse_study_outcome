package com.bytedance.android.ec.core.hybrid.bridges;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.g2;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.helper.SearchVideoMemorySharer;
import com.bytedance.android.ec.sdk.helper.p;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/OpenSearchMerchandiseVideoDetailMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenSearchMerchandiseVideoDetailMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public OpenSearchMerchandiseVideoDetailMethod() {
        this.e = "openSearchMerchandiseVideoDetail";
    }

    public final String getName() {
        return this.e;
    }

    public final void d(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("logExtra");     // Catch: Throwable -> L12
        if (r11 == null) goto L15;
        String r0 = r11.optString("btm");     // Catch: Throwable -> L12
        if (r0 == null) goto L16;
        JSONObject r1 = r11.optJSONObject("bcm");     // Catch: Throwable -> L12
        if (r1 != null) goto L10;
        r1 = new JSONObject();     // Catch: Throwable -> L12
    L10:
        BtmSDK r12 = BtmSDK.INSTANCE;     // Catch: Throwable -> L12
        com.bytedance.android.btm.api.model.d r13 = new com.bytedance.android.btm.api.model.d();     // Catch: Throwable -> L12
        r13.a = r0;     // Catch: Throwable -> L12
        r13.b = PageFinder.via(b().a);     // Catch: Throwable -> L12
        BcmParams.Companion.getClass();     // Catch: Throwable -> L12
        r13.c = BcmParams.a.b(r1);     // Catch: Throwable -> L12
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r11.put("source_btm_token", r12.createJumpSourceBtmTokenForJSB(r13));     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r1 = "openSearchMerchandiseVideoDetail-" + System.currentTimeMillis();
        d(r10);     // Catch: Throwable -> L22
        String r12 = r10.toString();     // Catch: Throwable -> L22
        SearchVideoMemorySharer.store.1 r13 = SearchVideoMemorySharer.a;     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r1, "key");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);     // Catch: Throwable -> L22
        SearchVideoMemorySharer.a.put(r1, new SoftReference(r12));     // Catch: Throwable -> L22
        g2 r14 = new g2("//search/order_middle");     // Catch: Throwable -> L22
        r14.a("key", r1);     // Catch: Throwable -> L22
        String r15 = r14.b();     // Catch: Throwable -> L22
        Context r0 = getContext();     // Catch: Throwable -> L22
        if ((r0 instanceof Activity) == true) goto L6;
        r0 = null;
    L6:
        Activity r16 = (Activity) r0;     // Catch: Throwable -> L22
        if (r16 == null) goto L11;
        ActivityOptionsCompat r17 = ActivityOptionsCompat.makeSceneTransitionAnimation(r16, new Pair[0]);     // Catch: Throwable -> L22
        if (r17 == null) goto L11;
        Bundle r18 = r17.toBundle();     // Catch: Throwable -> L22
    L12:
        if (r18 == null) goto L14;
        p.a.a(getContext(), r15, r18);     // Catch: Throwable -> L22
    L20:
        r11.onSuccess(null);     // Catch: Throwable -> L22
        return;
    L14:
        p.a.openSchema(getContext(), r15);     // Catch: Throwable -> L22
        Context r19 = getContext();     // Catch: Throwable -> L22
        if ((r19 instanceof Activity) == true) goto L17;
        r19 = null;
    L17:
        Activity r20 = (Activity) r19;     // Catch: Throwable -> L22
        if (r20 == null) goto L20;
        r20.overridePendingTransition(2130772623, 2130772624);     // Catch: Throwable -> L22
    L11:
        r18 = null;
    L22:
        th = move-exception;
        r11.onFailed(-1, th.getMessage());
        SearchVideoMemorySharer.store.1 r21 = SearchVideoMemorySharer.a;
        if (r21 == null) goto L28;
        TypeIntrinsics.asMutableMap(r21).remove(r1);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
