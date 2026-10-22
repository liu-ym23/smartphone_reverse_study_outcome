package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowMediaCompressHelper", f = "FlowMediaCompressHelper.kt", i = {0, 1}, l = {55, 57}, m = "compress", n = {"entity", "entity"}, s = {"L$0", "L$0"})
public final class FlowMediaCompressHelper$compress$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMediaCompressHelper this$0;

    public FlowMediaCompressHelper$compress$1(FlowMediaCompressHelper r1, Continuation<? super FlowMediaCompressHelper$compress$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Target.SIZE_ORIGINAL;
        return this.this$0.a(null, null, null, null, this);
    }
}
