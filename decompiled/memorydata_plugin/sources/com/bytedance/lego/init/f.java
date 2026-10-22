package com.bytedance.lego.init;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0004"}, d2 = {"singleAsync", "", "runnable", "Lkotlin/Function0;", "initscheduler_release"}, k = 2, mv = {1, 1, 13})
public final class f {
    public static final void a(Function0<Unit> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "runnable");
        e.f2767b.a().execute((Runnable) ZeusTransformUtils.preCheckCast(new g(r4), Runnable.class, "com.obric.memorydata.plugin"));
    }
}
