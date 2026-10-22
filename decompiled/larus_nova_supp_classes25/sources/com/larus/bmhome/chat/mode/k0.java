package com.larus.bmhome.chat.mode;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k0 implements Function2 {
    public /* synthetic */ k0() {
    }

    public final Object invoke(Object r2, Object r3) {
        PipelineDraweeControllerBuilder r4 = (PipelineDraweeControllerBuilder) r2;
        Uri r5 = (Uri) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r5, "it");
        r4.setUri(r5);
        r4.setAutoPlayAnimations(true);
        return Unit.INSTANCE;
    }
}
