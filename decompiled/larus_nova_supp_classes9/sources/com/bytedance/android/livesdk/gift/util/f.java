package com.bytedance.android.livesdk.gift.util;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends BaseRequestListener {
    public Object a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public f(String r1) {
    }

    public final void onUltimateProducerReached(String r1, String r2, boolean r3) {
        if (this.b == false) goto L8;
        if (Intrinsics.areEqual(r2, "NetworkFetchProducer") == false) goto L8;
        Objects.toString(this.a);
        System.currentTimeMillis();
    L8:
        if (this.b == false) goto L10;
        return;
    L10:
        if ((!Intrinsics.areEqual(r2, "BitmapMemoryCacheGetProducer")) == false) goto L14;
        Objects.toString(this.a);
        System.currentTimeMillis();
        return;
    }

    public final void onRequestStart(ImageRequest r1, Object r2, String r3, boolean r4) {
        this.a = r2;
        this.b = r4;
        System.currentTimeMillis();
    }
}
