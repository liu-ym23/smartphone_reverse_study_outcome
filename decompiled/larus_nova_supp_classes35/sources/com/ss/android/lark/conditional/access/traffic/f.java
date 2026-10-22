package com.ss.android.lark.conditional.access.traffic;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final InternalSecurityAction a = null;

    static {
        a = new InternalSecurityAction(new SecurityAction(BuildConfig.FLAVOR, null, 0, 0, 14, null), new DecisionData.Action(), CollectionsKt.emptyList());
    }
}
