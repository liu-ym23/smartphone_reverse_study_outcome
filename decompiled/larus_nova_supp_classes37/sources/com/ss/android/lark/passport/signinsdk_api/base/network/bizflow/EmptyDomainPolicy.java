package com.ss.android.lark.passport.signinsdk_api.base.network.bizflow;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/EmptyDomainPolicy;", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/DomainPolicy;", "<init>", "()V", "getDomain", "", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class EmptyDomainPolicy extends DomainPolicy {
    public static final EmptyDomainPolicy INSTANCE = null;

    static {
        INSTANCE = new EmptyDomainPolicy();
    }

    @Override // com.ss.android.lark.passport.signinsdk_api.base.network.bizflow.DomainPolicy
    public String getDomain() {
        return "EmptyDomainPolicy";
    }

    private EmptyDomainPolicy() {
    }
}
