package com.ss.android.lark.passport.signinsdk_api.base.network.bizflow;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/EmptyBizFlow;", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlow;", "<init>", "()V", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class EmptyBizFlow extends BizFlow {
    public static final EmptyBizFlow INSTANCE = null;

    static {
        INSTANCE = new EmptyBizFlow();
    }

    private EmptyBizFlow() {
        super("EmptyBizFlow", EmptyDomainPolicy.INSTANCE, false);
    }
}
