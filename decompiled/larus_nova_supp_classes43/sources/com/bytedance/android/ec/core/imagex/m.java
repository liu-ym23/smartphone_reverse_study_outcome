package com.bytedance.android.ec.core.imagex;

import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m extends p {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    @Override // com.bytedance.android.ec.core.imagex.p
    public final boolean d(Uri r10, SlcImageFetchManager r11, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r12, Object r13, SlcImageFetchManager.a r14, Function1 r15) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "imageManager");
        Intrinsics.checkNotNullParameter(r12, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r14, "callback");
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.i.getValue()).booleanValue() == false) goto L5;
        SlcImageLoaderHookImpl r0 = SlcImageLoaderHookImpl.d;
    L6:
        SlcImageLoaderHookImpl r1 = r0;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.d(r10, r11, r12, r13, r14, r15) != true) goto L11;
        return true;
    L5:
        r0 = null;
        goto L6
    }
}
