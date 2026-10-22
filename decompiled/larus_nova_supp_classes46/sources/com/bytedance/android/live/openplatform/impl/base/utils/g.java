package com.bytedance.android.live.openplatform.impl.base.utils;

import android.os.SystemClock;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends BaseRequestListener {
    public long a;
    public String b;
    public ImageLoader.ImageFromSource c;
    public final /* synthetic */ ImageTag d;
    public final /* synthetic */ String e;

    public final void onRequestCancellation(String r9) {
        int r10 = qo0.a.a;
        qo0.a.c("OpenPlatformImageLoader", this.d.name() + "-onRequestCancellation");
        ImageLoader r11 = ImageLoader.a;
        ImageLoader.f(this.a, String.valueOf(this.d.getTagInt()), this.e, this.b, -2, "", this.c);
    }

    public g(ImageTag r1, String r2) {
        this.d = r1;
        this.e = r2;
        this.a = -1;
        this.b = "";
        this.c = ImageLoader.ImageFromSource.UNKNOWN;
    }

    public final void onRequestSuccess(ImageRequest r9, String r10, boolean r11) {
        int r12 = qo0.a.a;
        qo0.a.c("OpenPlatformImageLoader", this.d.name() + "-onRequestSuccess, isPrefetch: " + r11);
        ImageLoader r13 = ImageLoader.a;
        ImageLoader.f(this.a, String.valueOf(this.d.getTagInt()), this.e, this.b, 1, "", this.c);
    }

    public final void onUltimateProducerReached(String r2, String r3, boolean r4) {
        int r5 = qo0.a.a;
        qo0.a.c("OpenPlatformImageLoader", this.d.name() + "-onUltimateProducerReached: " + String.valueOf(r3) + ", success: " + r4);
        if (r3 != null) goto L6;
    L23:
        ImageLoader.ImageFromSource r6 = ImageLoader.ImageFromSource.UNKNOWN;
    L24:
        this.c = r6;
        return;
    L6:
        switch(r3.hashCode()) {
            case -1683996557: goto L21;
            case -1307634203: goto L18;
            case -1224383234: goto L15;
            case 656304759: goto L12;
            case 957714404: goto L9;
            default: goto L23;
        };
    L9:
        if (r3.equals("BitmapMemoryCacheProducer") == false) goto L23;
    L19:
        r6 = ImageLoader.ImageFromSource.MEMORY_CACHE;
        goto L24
    L12:
        if (r3.equals("DiskCacheProducer") == false) goto L23;
        r6 = ImageLoader.ImageFromSource.DISK_CACHE;
        goto L24
    L15:
        if (r3.equals("NetworkFetchProducer") == false) goto L23;
        r6 = ImageLoader.ImageFromSource.NETWORK;
        goto L24
    L18:
        if (r3.equals("EncodedMemoryCacheProducer") == false) goto L23;
    L21:
        if (r3.equals("LocalResourceFetchProducer") == false) goto L23;
        r6 = ImageLoader.ImageFromSource.LOCAL;
        goto L24
    }

    public final void onRequestFailure(ImageRequest r9, String r10, Throwable r11, boolean r12) {
        int r13 = qo0.a.a;
        qo0.a.c("OpenPlatformImageLoader", this.d.name() + "-onRequestFailure, isPrefetch: " + r12);
        ImageLoader r14 = ImageLoader.a;
        ImageLoader.f(this.a, String.valueOf(this.d.getTagInt()), this.e, this.b, -1, String.valueOf(r11), this.c);
    }

    public final void onRequestStart(ImageRequest r1, Object r2, String r3, boolean r4) {
        int r5 = qo0.a.a;
        qo0.a.c("OpenPlatformImageLoader", this.d.name() + "-onRequestStart, isPrefetch: " + r4);
        this.a = SystemClock.uptimeMillis();
        ImageLoader r6 = ImageLoader.a;
        ImageTag r7 = this.d;
        if (r7 != ImageTag.SNOW_FLAKE) goto L5;
    L16:
        HashMap<String, zo0.f> r8 = zo0.g.a;
        if (zo0.h.b(PerformanceScene.SNOW_FLAKE).c("is_from_enter") == false) goto L19;
    L18:
        String r9 = "enter";
    L20:
        this.b = r9;
        this.c = ImageLoader.ImageFromSource.UNKNOWN;
        return;
    L19:
        r9 = "msg";
        goto L20
    L5:
        if (r7 == ImageTag.SPREAD_FLOWERS) goto L16;
        if (r7 != ImageTag.SMALL_CARD_OUT) goto L10;
    L13:
        HashMap<String, zo0.f> r10 = zo0.g.a;
        if (zo0.h.b(PerformanceScene.EXPLAIN_CARD).c("is_from_enter") == false) goto L19;
    L10:
        if (r7 == ImageTag.EXPLAIN_CARD_COVER) goto L13;
        if (r7 != ImageTag.SMALL_CARD_OUT_V2) goto L19;
        goto L13
    }
}
