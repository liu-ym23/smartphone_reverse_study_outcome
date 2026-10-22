package com.bytedance.android.ec.core.utils;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w {
    public final ControllerListener<? super ImageInfo> a;
    public final Function1<? super DraweeController, Unit> b;

    public w(ControllerListener<? super ImageInfo> r1, Function1<? super DraweeController, Unit> r10) {
        this.a = r1;
        this.b = r10;
    }
}
