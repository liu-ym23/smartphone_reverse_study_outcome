package com.bytedance.android.bcm.impl;

import com.bytedance.android.btm.api.model.e;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/btm/api/model/e;", "", "invoke", "(Lcom/bytedance/android/btm/api/model/e;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class BcmRecorder$onPageDestroyed$1 extends Lambda implements Function1<e, Boolean> {
    final /* synthetic */ PageInfo $pageInfo;

    public BcmRecorder$onPageDestroyed$1(PageInfo r1) {
        this.$pageInfo = r1;
        super(1);
    }

    public final boolean invoke(e r10) {
        return Intrinsics.areEqual(r10.c, this.$pageInfo.getPageId());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((e) r1));
    }
}
