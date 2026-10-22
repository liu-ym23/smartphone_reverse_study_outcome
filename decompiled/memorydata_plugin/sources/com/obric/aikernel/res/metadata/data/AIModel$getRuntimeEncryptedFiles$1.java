package com.obric.aikernel.res.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/aikernel/res/metadata/config/Downloadable;", "invoke", "(Lcom/obric/aikernel/res/metadata/config/Downloadable;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AIModel$getRuntimeEncryptedFiles$1 extends Lambda implements Function1<com.obric.aikernel.res.metadata.config.c, Boolean> {
    public static final AIModel$getRuntimeEncryptedFiles$1 INSTANCE = null;

    static {
        INSTANCE = new AIModel$getRuntimeEncryptedFiles$1();
    }

    AIModel$getRuntimeEncryptedFiles$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(com.obric.aikernel.res.metadata.config.c r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Boolean.valueOf(Intrinsics.areEqual(r1.n(), "runtime"));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(com.obric.aikernel.res.metadata.config.c r3) {
        return invoke2((com.obric.aikernel.res.metadata.config.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.config.c.class, "com.obric.memorydata.plugin"));
    }
}
