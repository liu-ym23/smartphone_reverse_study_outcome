package com.obric.memorydata.middleware.impl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ImageXUploadAwaiter$Session$start$1$1 extends FunctionReferenceImpl implements Function1<d, Unit> {
    ImageXUploadAwaiter$Session$start$1$1(Object r8) {
        super(1, r8, j.b.class, "finish", "finish(Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(d r3) {
        invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ((j.b) ZeusTransformUtils.preCheckCast(this.receiver, j.b.class, "com.obric.memorydata.plugin")).a(r3);
    }
}
