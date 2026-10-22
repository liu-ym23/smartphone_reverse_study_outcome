package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.obric.memorydata.database.entity.hr;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class VideoFrameEntityEventHandler$1 extends FunctionReferenceImpl implements Function1<hr, Boolean> {
    VideoFrameEntityEventHandler$1(Object r8) {
        super(1, r8, l.a.class, "isFirstFrame", "isFirstFrame(Lcom/obric/memorydata/database/entity/RawVideoFrameEntity;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(hr r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return Boolean.valueOf(l.a.a((l.a) ZeusTransformUtils.preCheckCast(this.receiver, l.a.class, "com.obric.memorydata.plugin"), r3));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(hr r3) {
        return invoke2((hr) ZeusTransformUtils.preCheckCast(r3, hr.class, "com.obric.memorydata.plugin"));
    }
}
