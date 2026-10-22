package com.obric.aiproactive.ui.feedback;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ProactiveValueRatingStore$1 extends FunctionReferenceImpl implements Function0<String> {
    ProactiveValueRatingStore$1(Object r8) {
        super(0, r8, AppContext.class, "getUserId", "getUserId()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return ((AppContext) ZeusTransformUtils.preCheckCast(this.receiver, AppContext.class, "com.obric.memorydata.plugin")).getUserId();
    }
}
