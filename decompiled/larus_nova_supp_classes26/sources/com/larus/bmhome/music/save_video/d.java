package com.larus.bmhome.music.save_video;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(kotlinx.coroutines.i<? super Boolean> r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        kotlinx.coroutines.i<Boolean> r3 = this.a;
        Result.Companion r4 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(Boolean.FALSE));
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        kotlinx.coroutines.i<Boolean> r5 = this.a;
        Result.Companion r6 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(Boolean.TRUE));
    }
}
