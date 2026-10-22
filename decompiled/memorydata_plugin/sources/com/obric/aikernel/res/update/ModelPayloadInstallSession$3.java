package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class ModelPayloadInstallSession$3 extends FunctionReferenceImpl implements Function3<File, File, File, Unit> {
    ModelPayloadInstallSession$3(Object r8) {
        super(3, r8, com.obric.aikernel.res.integrity.a.class, "commitPayload", "commitPayload(Ljava/io/File;Ljava/io/File;Ljava/io/File;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(File r3, File r4, File r5) {
        invoke2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), (File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.memorydata.plugin"), (File) ZeusTransformUtils.preCheckCast(r5, File.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(File r3, File r4, File r5) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r4, "p1");
        Intrinsics.checkNotNullParameter(r5, "p2");
        ((com.obric.aikernel.res.integrity.a) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aikernel.res.integrity.a.class, "com.obric.memorydata.plugin")).a(r3, r4, r5);
    }
}
