package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.listener.BaseRequestListener;

/* JADX INFO: loaded from: classes2.dex */
public class ImageOriginRequestListener extends BaseRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageOriginListener f7748b;

    public ImageOriginRequestListener(String r5, ImageOriginListener r10) {
        this.f7748b = r10;
        this.f7747a = r5;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void a(String r10, String r11, boolean r12) {
        int r13 = 7;
        ImageOriginListener r5 = this.f7748b;
        if (r5 == null) goto L75;
        String r14 = this.f7747a;
        r11.getClass();
        byte r15 = -1;
        switch(r11.hashCode()) {
            case -1917159454: goto L64;
            case -1914072202: goto L60;
            case -1683996557: goto L56;
            case -1579985851: goto L52;
            case -1307634203: goto L48;
            case -1224383234: goto L44;
            case 473552259: goto L40;
            case 656304759: goto L36;
            case 957714404: goto L32;
            case 1019542023: goto L28;
            case 1023071510: goto L24;
            case 1721672898: goto L20;
            case 1793127518: goto L16;
            case 2109593398: goto L12;
            case 2113652014: goto L8;
            default: goto L67;
        };
    L67:
        switch(r15) {
            case 0: goto L73;
            case 1: goto L72;
            case 2: goto L73;
            case 3: goto L73;
            case 4: goto L71;
            case 5: goto L70;
            case 6: goto L73;
            case 7: goto L69;
            case 8: goto L72;
            case 9: goto L73;
            case 10: goto L72;
            case 11: goto L73;
            case 12: goto L73;
            case 13: goto L69;
            case 14: goto L73;
            default: goto L68;
        };
    L68:
        r13 = 1;
        goto L73
    L69:
        r13 = 3;
        goto L73
    L70:
        r13 = 2;
        goto L73
    L71:
        r13 = 4;
        goto L73
    L72:
        r13 = 5;
    L73:
        r5.a(r14, r13, r12, r11);
        return;
    L8:
        if (r11.equals("LocalContentUriFetchProducer") == false) goto L67;
        r15 = 14;
        goto L67
    L12:
        if (r11.equals("PartialDiskCacheProducer") == false) goto L67;
        r15 = 13;
        goto L67
    L16:
        if (r11.equals("LocalContentUriThumbnailFetchProducer") == false) goto L67;
        r15 = 12;
        goto L67
    L20:
        if (r11.equals("DataFetchProducer") == false) goto L67;
        r15 = 11;
        goto L67
    L24:
        if (r11.equals("PostprocessedBitmapMemoryCacheProducer") == false) goto L67;
        r15 = 10;
        goto L67
    L28:
        if (r11.equals("LocalAssetFetchProducer") == false) goto L67;
        r15 = 9;
        goto L67
    L32:
        if (r11.equals("BitmapMemoryCacheProducer") == false) goto L67;
        r15 = 8;
        goto L67
    L36:
        if (r11.equals("DiskCacheProducer") == false) goto L67;
        r15 = 7;
        goto L67
    L40:
        if (r11.equals("VideoThumbnailProducer") == false) goto L67;
        r15 = 6;
        goto L67
    L44:
        if (r11.equals("NetworkFetchProducer") == false) goto L67;
        r15 = 5;
        goto L67
    L48:
        if (r11.equals("EncodedMemoryCacheProducer") == false) goto L67;
        r15 = 4;
        goto L67
    L52:
        if (r11.equals("LocalFileFetchProducer") == false) goto L67;
        r15 = 3;
        goto L67
    L56:
        if (r11.equals("LocalResourceFetchProducer") == false) goto L67;
        r15 = 2;
        goto L67
    L60:
        if (r11.equals("BitmapMemoryCacheGetProducer") == false) goto L67;
        r15 = 1;
        goto L67
    L64:
        if (r11.equals("QualifiedResourceFetchProducer") == false) goto L67;
        r15 = 0;
        goto L67
    }
}
