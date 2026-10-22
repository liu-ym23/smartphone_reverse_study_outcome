package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    private interface a {
        int a(ImageHeaderParser r1);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.b$b, reason: collision with other inner class name */
    private interface InterfaceC0062b {
        ImageHeaderParser.ImageType a(ImageHeaderParser r1);
    }

    private static int a(List<ImageHeaderParser> r6, a r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        int r0 = r8.size();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L9;
        int r4 = r9.a((ImageHeaderParser) ZeusTransformUtils.preCheckCast(r8.get(r2), ImageHeaderParser.class, "com.obric.memorydata.plugin"));
        if (r4 != (-1)) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return r4;
    L9:
        return -1;
    }

    public static int a(List<ImageHeaderParser> r2, final ParcelFileDescriptorRewinder r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        final com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        return a(r5, new AnonymousClass6(r3, r6));
    }

    public static int a(List<ImageHeaderParser> r2, final InputStream r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        final com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return -1;
    L7:
        if (r3.markSupported() == true) goto L9;
        r3 = new RecyclableBufferedInputStream(r3, r6);
    L9:
        r3.mark(5242880);
        return a(r5, new AnonymousClass5(r3, r6));
    }

    public static int a(List<ImageHeaderParser> r2, final ByteBuffer r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        final com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return -1;
    L7:
        return a(r5, new AnonymousClass4(r3, r6));
    }

    private static ImageHeaderParser.ImageType a(List<ImageHeaderParser> r5, InterfaceC0062b r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        InterfaceC0062b r8 = (InterfaceC0062b) ZeusTransformUtils.wrapperContextForParams(r6, InterfaceC0062b.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        ImageHeaderParser.ImageType r3 = r8.a((ImageHeaderParser) ZeusTransformUtils.preCheckCast(r7.get(r2), ImageHeaderParser.class, "com.obric.memorydata.plugin"));
        if (r3 != ImageHeaderParser.ImageType.UNKNOWN) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r2, final ParcelFileDescriptorRewinder r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        final com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        return a(r5, new AnonymousClass3(r3, r6));
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r2, final InputStream r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L7:
        if (r3.markSupported() == true) goto L9;
        r3 = new RecyclableBufferedInputStream(r3, r6);
    L9:
        r3.mark(5242880);
        return a(r5, new AnonymousClass1(r3));
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r2, final ByteBuffer r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L7:
        return a(r4, new AnonymousClass2(r3));
    }
}
