package com.larus.voice_setting.voice.dialog;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.voice_setting.impl.databinding.LarusDialogOptUserVoiceInfoBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class p0 implements Function2 {
    public final /* synthetic */ LarusDialogOptUserVoiceInfoBinding a;

    public /* synthetic */ p0(LarusDialogOptUserVoiceInfoBinding r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        LarusDialogOptUserVoiceInfoBinding r0 = this.a;
        PipelineDraweeControllerBuilder r5 = (PipelineDraweeControllerBuilder) r3;
        Uri r6 = (Uri) r4;
        int r1 = UgcVoiceInfoOptimizeDialog.t;
        Intrinsics.checkNotNullParameter(r5, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r6, "it");
        r5.setOldController(r0.l.getController());
        r5.setImageRequest(ImageRequestBuilder.newBuilderWithSource(r6).build());
        r5.setAutoPlayAnimations(true);
        return Unit.INSTANCE;
    }
}
