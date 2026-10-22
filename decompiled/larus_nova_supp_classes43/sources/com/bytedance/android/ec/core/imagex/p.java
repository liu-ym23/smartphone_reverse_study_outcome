package com.bytedance.android.ec.core.imagex;

import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class p implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a {
    public p() {
    }

    public final ImageRequest b(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    public final void c(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
    }

    public abstract boolean d(Uri r1, SlcImageFetchManager r10, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r11, Object r12, SlcImageFetchManager.a r13, Function1 r14);

    public final boolean a(Uri r10, SlcImageFetchManager r11, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r12, Object r13, SlcImageFetchManager.a r14) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "imageManager");
        Intrinsics.checkNotNullParameter(r12, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r14, "callback");
        return d(r10, r11, r12, r13, r14, null);
    }
}
