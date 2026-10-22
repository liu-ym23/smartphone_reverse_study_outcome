package com.obric.oui.button;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isEnd", "", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OProgressButton$updateProgress$2 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ OProgressButton this$0;

    OProgressButton$updateProgress$2(OProgressButton r1) {
        this.this$0 = r1;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(Boolean r3, Throwable r4) {
        invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r1, Throwable r2) {
        if (r1 == false) goto L7;
        OProgressButton r3 = this.this$0;
        OProgressButton.a(r3, OProgressButton.d(r3));
        OProgressButton r4 = this.this$0;
        r4.a(OProgressButton.a(r4));
        if (OProgressButton.b(this.this$0) == false) goto L8;
        OProgressButton.c(this.this$0);
        return;
    L8:
        return;
    }
}
