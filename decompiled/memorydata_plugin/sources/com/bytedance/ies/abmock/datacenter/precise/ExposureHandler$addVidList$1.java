package com.bytedance.ies.abmock.datacenter.precise;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ExposureHandler$addVidList$1 extends Lambda implements Function1<String, Boolean> {
    final /* synthetic */ a this$0;

    ExposureHandler$addVidList$1(a r1) {
        this.this$0 = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Boolean.valueOf(!a.a(this.this$0).contains(r2));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
