package com.obric.aikernel.res.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class AIModel$isResourceManagerOwnedModelPath$2 extends FunctionReferenceImpl implements Function1<String, File> {
    public static final AIModel$isResourceManagerOwnedModelPath$2 INSTANCE = null;

    static {
        INSTANCE = new AIModel$isResourceManagerOwnedModelPath$2();
    }

    AIModel$isResourceManagerOwnedModelPath$2() {
        super(1, File.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final File invoke2(String r1) {
        return new File(r1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ File invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
