package com.bytedance.map.api.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.map.api.exception.BDMapException;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MapImageLoader {

    /* JADX INFO: renamed from: com.bytedance.map.api.image.MapImageLoader$1, reason: invalid class name */
    final class AnonymousClass1 implements ImageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageCallback f6905a;

        public AnonymousClass1(ImageCallback r5) {
            this.f6905a = r5;
        }

        @Override // com.bytedance.map.api.image.ImageCallback
        public final void a(Bitmap r5) {
        }

        @Override // com.bytedance.map.api.image.ImageCallback
        public final void a(BDMapException r5) {
            this.f6905a.a(r5);
        }
    }

    public static abstract class PriorityImageCallback implements ImageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6910a;

        public PriorityImageCallback(int r5) {
            this.f6910a = r5;
        }
    }

    public static void a(List r13, ImageCallback r14) {
        if (r13 != null) goto L4;
    L41:
        r14.a(new BDMapException("option is null"));
        return;
    L4:
        if (r13.size() == 0) goto L41;
        final AnonymousClass1 r5 = new AnonymousClass1(r14);
        final ArrayList r15 = new ArrayList();
        final CountDownLatch r10 = new CountDownLatch(r13.size());
        Iterator r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L43;
        ImageOptions r11 = (ImageOptions) r16.next();
        final int r12 = r11.d;
        a(r11, new AnonymousClass2(r12, r15, r10, r5));
        goto L8
    L43:
        r10.await(3, TimeUnit.SECONDS);     // Catch: InterruptedException -> L12
    L15:
        if (r10.getCount() != 0) goto L51;
        Collections.sort(r15);
        ArrayList r17 = new ArrayList();
        Iterator r18 = r15.iterator();
    L18:
        if (r18.hasNext() == false) goto L20;
        r17.add(((BitmapWrapper) r18.next()).f6900a);
        goto L18
    L20:
        int r19 = 1;
        if (r17.size() != 1) goto L23;
        Bitmap r110 = (Bitmap) r17.get(0);
    L39:
        r5.f6905a.a(r110);
        return;
    L23:
        Bitmap r111 = (Bitmap) r17.get(0);
    L25:
        if (r19 >= r17.size()) goto L38;
        Bitmap r20 = (Bitmap) r17.get(r19);
        if (r111 != null) goto L29;
    L36:
        r111 = r20;
    L37:
        r19 = r19 + 1;
        goto L25
    L29:
        if (r111.isRecycled() == true) goto L36;
        if (r20 == null) goto L37;
        if (r20.isRecycled() == true) goto L37;
        int r21 = r111.getWidth();
        int r22 = r111.getHeight();
        int r23 = r20.getWidth();
        int r24 = r20.getHeight();
        int r25 = Math.max(r21, r23);
        int r26 = Math.max(r22, r24);
        Bitmap r27 = Bitmap.createBitmap(r25, r26, Bitmap.Config.ARGB_8888);
        Canvas r112 = new Canvas(r27);
        r112.drawBitmap(r111, (r25 - r21) / 2.0f, (r26 - r22) / 2.0f, null);
        r112.drawBitmap(r20, (r25 - r23) / 2.0f, (r26 - r24) / 2.0f, null);
        r111 = r27;
        goto L37
    L38:
        r110 = r111;
        goto L39
    L51:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static void a(final ImageOptions r10, final ImageCallback r11) {
        if (r10 != null) goto L6;
        r11.a(new BDMapException("option is null"));
        return;
    L6:
        if (TextUtils.isEmpty(r10.f6902a) == false) goto L8;
    L12:
        String r5 = r10.f6902a;
        if (r5 != null) goto L15;
    L21:
        ImageRequest r12 = null;
    L22:
        Fresco.a().e().a(r12, null, ImageRequest.RequestLevel.f8431b, null).a(new AnonymousClass3(r10, r11), UiThreadImmediateExecutorService.b());
        return;
    L15:
        if (r5.length() == 0) goto L21;
        Uri r13 = Uri.parse(r5);
        if (r13 == null) goto L21;
        r12 = ImageRequestBuilder.a(r13).a();
        goto L22
    L8:
        if (r10.f6903b == 0) goto L12;
        if (r10.f6904c == 0) goto L12;
        ImageRequestBuilder r14 = ImageRequestBuilder.a(Uri.parse(r10.f6902a));
        r14.f8436c = new ResizeOptions(r10.f6903b, r10.f6904c, 2048.0f);
        r12 = r14.a();
        goto L22
    }
}
