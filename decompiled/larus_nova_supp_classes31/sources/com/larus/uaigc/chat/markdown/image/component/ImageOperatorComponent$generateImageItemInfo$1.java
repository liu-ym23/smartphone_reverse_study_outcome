package com.larus.uaigc.chat.markdown.image.component;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent", f = "ImageOperatorComponent.kt", i = {}, l = {304, 319}, m = "generateImageItemInfo", n = {}, s = {})
public final class ImageOperatorComponent$generateImageItemInfo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageOperatorComponent this$0;

    public ImageOperatorComponent$generateImageItemInfo$1(ImageOperatorComponent r1, Continuation<? super ImageOperatorComponent$generateImageItemInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, this);
    }
}
