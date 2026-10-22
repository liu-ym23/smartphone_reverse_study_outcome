package com.obric.mcpclient.complextasksdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ComplexTaskHandleSdk$executeTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ c $callback;
    final /* synthetic */ boolean $isShow;
    final /* synthetic */ String $taskData;

    ComplexTaskHandleSdk$executeTask$1(String r3, boolean r4, c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        this.$taskData = r3;
        this.$isShow = r4;
        this.$callback = r6;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.obric.mcpclient.complextasksdk.b.c.f8283a.c(a.b(), "dispatchServerActions");
        a.a(a.f8276a).a(this.$taskData, this.$isShow, this.$callback);
    }
}
