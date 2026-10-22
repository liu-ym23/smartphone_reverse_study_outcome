package com.obric.oui.button;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class OButtonGroup$AnimationBatch$start$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    OButtonGroup$AnimationBatch$start$1$1(Object r8) {
        super(0, r8, OButtonGroup.a.class, "done", "done()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        OButtonGroup.a.a((OButtonGroup.a) ZeusTransformUtils.preCheckCast(this.receiver, OButtonGroup.a.class, "com.obric.memorydata.plugin"));
    }
}
