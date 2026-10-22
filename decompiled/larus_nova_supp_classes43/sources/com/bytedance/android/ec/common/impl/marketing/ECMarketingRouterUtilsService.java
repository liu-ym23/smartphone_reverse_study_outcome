package com.bytedance.android.ec.common.impl.marketing;

import com.bytedance.android.ec.common.api.marketing.IMarketingRouterUtilsService;
import com.bytedance.android.ec.core.hybrid.utils.j;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/impl/marketing/ECMarketingRouterUtilsService;", "Lcom/bytedance/android/ec/common/api/marketing/IMarketingRouterUtilsService;", "()V", "getMegaObject", "Lorg/json/JSONObject;", "megaObjectId", "", "setMegaObject", "", "megaObject", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMarketingRouterUtilsService implements IMarketingRouterUtilsService {
    public ECMarketingRouterUtilsService() {
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingRouterUtilsService
    public JSONObject getMegaObject(String r10) {
        Intrinsics.checkNotNullParameter(r10, "megaObjectId");
        HashMap<String, JSONObject> r0 = j.a;
        return j.d(r10);
    }

    @Override // com.bytedance.android.ec.common.api.marketing.IMarketingRouterUtilsService
    public void setMegaObject(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "megaObjectId");
        HashMap<String, JSONObject> r0 = j.a;
        j.h(r10, r11);
    }
}
