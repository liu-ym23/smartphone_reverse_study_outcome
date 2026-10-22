package com.suite.lark.platform.component.cta.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.suite.lark.platform.component.cta.model.StuckSpotRequestExecutor", f = "StuckSpotRequestExecutor.kt", i = {}, l = {70}, m = "executeWithSdkSender", n = {}, s = {})
public final class StuckSpotRequestExecutor$executeWithSdkSender$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StuckSpotRequestExecutor this$0;

    public StuckSpotRequestExecutor$executeWithSdkSender$1(StuckSpotRequestExecutor r1, Continuation<? super StuckSpotRequestExecutor$executeWithSdkSender$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Target.SIZE_ORIGINAL;
        return this.this$0.c(null, null, null, null, this);
    }
}
