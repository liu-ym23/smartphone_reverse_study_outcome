package com.obric.memorydata.middleware.impl.bdtracker;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemoryAppLogCommonParams$syncSystemOsDeviceId$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public static final MemoryAppLogCommonParams$syncSystemOsDeviceId$1 INSTANCE = null;

    static {
        INSTANCE = new MemoryAppLogCommonParams$syncSystemOsDeviceId$1();
    }

    MemoryAppLogCommonParams$syncSystemOsDeviceId$1() {
        super(1, Intrinsics.Kotlin.class, "updateHeader", "syncSystemOsDeviceId$updateHeader(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(String r3) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r1) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        a.a(r1);
    }
}
