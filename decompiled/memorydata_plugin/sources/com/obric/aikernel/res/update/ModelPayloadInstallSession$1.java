package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class ModelPayloadInstallSession$1 extends FunctionReferenceImpl implements Function2<File, String, Unit> {
    ModelPayloadInstallSession$1(Object r8) {
        super(2, r8, com.obric.aikernel.res.integrity.a.class, "writeDurableMarker", "writeDurableMarker(Ljava/io/File;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(File r3, String r4) {
        invoke2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(File r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((com.obric.aikernel.res.integrity.a) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aikernel.res.integrity.a.class, "com.obric.memorydata.plugin")).b(r3, r4);
    }
}
