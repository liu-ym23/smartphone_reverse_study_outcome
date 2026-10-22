package com.larus.uaigc.avatar.instruction;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class c implements Function2 {
    public final /* synthetic */ DigitalAvatarSelectorHolder a;

    public /* synthetic */ c(DigitalAvatarSelectorHolder r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        DigitalAvatarSelectorHolder r0 = this.a;
        PipelineDraweeControllerBuilder r5 = (PipelineDraweeControllerBuilder) r3;
        Uri r6 = (Uri) r4;
        int r1 = DigitalAvatarSelectorHolder.g;
        Intrinsics.checkNotNullParameter(r5, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r6, "it");
        r5.setOldController(r0.c.getController());
        r5.setImageRequest(ImageRequestBuilder.newBuilderWithSource(r6).build());
        r5.setControllerListener(new d(r0));
        return Unit.INSTANCE;
    }
}
