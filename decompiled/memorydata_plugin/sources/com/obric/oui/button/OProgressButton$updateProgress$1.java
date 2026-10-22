package com.obric.oui.button;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", EventBody.KEY_VALUE, "", "velocity", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OProgressButton$updateProgress$1 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ OProgressButton this$0;

    OProgressButton$updateProgress$1(OProgressButton r1) {
        this.this$0 = r1;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(String r3, Object r4, Object r5) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r4, r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "$noName_0");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r4, "velocity");
        OProgressButton.a(this.this$0, ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.memorydata.plugin")).floatValue());
        OProgressButton r5 = this.this$0;
        r5.a(OProgressButton.a(r5));
        if (OProgressButton.b(this.this$0) == false) goto L5;
        OProgressButton.c(this.this$0);
    L5:
        this.this$0.invalidate();
    }
}
