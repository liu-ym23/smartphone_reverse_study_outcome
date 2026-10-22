package com.obric.aikernel.model.device;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class UnNamedExceptionStrategy$onException$exceptionCount$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Integer> {
    public static final UnNamedExceptionStrategy$onException$exceptionCount$1 INSTANCE = null;

    static {
        INSTANCE = new UnNamedExceptionStrategy$onException$exceptionCount$1();
    }

    UnNamedExceptionStrategy$onException$exceptionCount$1() {
        super(2, Integer.TYPE, "plus", "plus(I)I", 0);
    }

    public final Integer invoke(int r1, int r2) {
        return Integer.valueOf(r1 + r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Integer invoke(Integer r3, Integer r4) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
    }
}
