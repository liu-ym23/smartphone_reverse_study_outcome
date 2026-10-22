package com.obric.aiproactive.ui.progress;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MobileUsePlayerProviderClientKt$buildMobileUsePlayerRequest$1$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    MobileUsePlayerProviderClientKt$buildMobileUsePlayerRequest$1$1(Object r8) {
        super(2, r8, Bundle.class, "putString", "putString(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(String r3, String r4) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r3, String r4) {
        ((Bundle) ZeusTransformUtils.preCheckCast(this.receiver, Bundle.class, "com.obric.memorydata.plugin")).putString(r3, r4);
    }
}
