package com.bytedance.android.debug;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\b"}, d2 = {"<anonymous>", "", "jsObj", "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", "invoke", "com/bytedance/android/debug/KmpDebugAssetsManager$downloadAssetByUrl$2$finalResult$1$onResult$2$1$1", "com/bytedance/android/debug/KmpDebugAssetsManager$downloadAssetByUrl$2$finalResult$1$$special$$inlined$runCatching$lambda$1", "com/bytedance/android/debug/KmpDebugAssetsManager$downloadAssetByUrl$2$finalResult$1$onResult$$inlined$forEach$lambda$1"}, k = 3, mv = {1, 5, 1})
final class KmpDebugAssetsManager$downloadAssetByUrl$$inlined$let$lambda$1$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $file$inlined;
    final /* synthetic */ n this$0;

    public KmpDebugAssetsManager$downloadAssetByUrl$$inlined$let$lambda$1$2(String r1, n r10) {
        this.$file$inlined = r1;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "jsObj");
        boolean r11 = true;
        if (r10.has("requirement") == false) goto L13;
        if (JSONObjectProtectorUtils.getJSONObject(r10, "requirement").toString().length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L13;
        jy0.b.d("LiveAnchorPushStreamMockManager", "requirement " + JSONObjectProtectorUtils.getJSONObject(r10, "requirement"));
        throw null;
    L7:
        r1 = false;
    L13:
        if (r10.has("model_names") == true) goto L15;
        return;
    L15:
        if (JSONObjectProtectorUtils.getJSONObject(r10, "model_names").toString().length() > 0) goto L18;
        r11 = false;
    L18:
        if (r11 == false) goto L23;
        jy0.b.d("LiveAnchorPushStreamMockManager", "model_names " + JSONObjectProtectorUtils.getJSONObject(r10, "model_names"));
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
