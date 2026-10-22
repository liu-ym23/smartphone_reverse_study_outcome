package com.larus.bmhome.view;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class n1 implements Function1 {
    public final /* synthetic */ PipelineDraweeControllerBuilder a;

    public /* synthetic */ n1(PipelineDraweeControllerBuilder r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        PipelineDraweeControllerBuilder r0 = this.a;
        Uri r4 = (Uri) r3;
        int r1 = ChatTitleAlignLeftStyle.T;
        Intrinsics.checkNotNullParameter(r4, "imgUri");
        r0.setUri(r4);
        r0.setAutoPlayAnimations(true);
        return r0;
    }
}
