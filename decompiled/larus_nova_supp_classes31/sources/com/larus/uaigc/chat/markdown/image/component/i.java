package com.larus.uaigc.chat.markdown.image.component;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.utils.u;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.m3;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements j {
    public final j a;
    public long b;

    public static final class a extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
        public final /* synthetic */ long a;
        public final /* synthetic */ i b;
        public final /* synthetic */ ResizeOptions c;
        public final /* synthetic */ SimpleDraweeView d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ImageRequest f;
        public final /* synthetic */ Uri g;
        public final /* synthetic */ Uri h;
        public final /* synthetic */ BaseControllerListener<ImageInfo> i;

        public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r11) {
            Intrinsics.checkNotNullParameter(r11, "ds");
            long r0 = this.a;
            i r12 = this.b;
            if (r0 == r12.b) goto L5;
            return;
        L5:
            FLogger.a.w(r12.getLogTag(), "[thumbProbe] fetch encoded thumb failed, fallback to origin");
            this.b.e(this.d, this.e, this.f, this.h, this.g, this.c, this.i);
        }

        public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r14) {
            Intrinsics.checkNotNullParameter(r14, "ds");
            if (r14.isFinished() == true) goto L6;
            return;
        L6:
            if (this.a == this.b.b) goto L8;
            return;
        L8:
            CloseableReference r15 = (CloseableReference) r14.getResult();
            ImageRequest r0 = null;
            boolean r1 = false;
            if (r15 != null) goto L61;
            Pair r3 = TuplesKt.to(0, 0);
        L22:
            int r16 = ((Number) r3.component1()).intValue();
            int r2 = ((Number) r3.component2()).intValue();
            int r4 = u.a;
            ResizeOptions r5 = this.c;
            if (r5 == null) goto L25;
            int r6 = r5.width;
        L26:
            if (r5 == null) goto L28;
            int r7 = r5.height;
        L29:
            if (r16 <= 0) goto L41;
            if (r2 <= 0) goto L41;
            if (r6 <= 0) goto L39;
            if (r7 <= 0) goto L39;
            if (r16 < r6) goto L41;
            if (r2 < r7) goto L41;
        L37:
            r1 = true;
        L39:
            if (Math.max(r16, r2) > 700) goto L37;
        L41:
            FLogger r8 = FLogger.a;
            String r9 = this.b.getLogTag();
            StringBuilder r10 = new StringBuilder("[thumbProbe] thumbW=");
            r10.append(r16);
            r10.append(" thumbH=");
            r10.append(r2);
            r10.append(" containerW=");
            ResizeOptions r17 = this.c;
            if (r17 == null) goto L44;
            Integer r18 = Integer.valueOf(r17.width);
        L45:
            r10.append(r18);
            r10.append(" containerH=");
            ResizeOptions r19 = this.c;
            if (r19 == null) goto L48;
            Integer r110 = Integer.valueOf(r19.height);
        L49:
            r10.append(r110);
            r10.append(" keepThumbOnly=");
            r10.append(r1);
            r8.i(r9, r10.toString());
            i r11 = this.b;
            SimpleDraweeView r12 = this.d;
            String r13 = this.e;
            if (r1 == true) goto L53;
            r0 = this.f;
        L53:
            ImageRequest r20 = r0;
            if (r1 == false) goto L56;
            Uri r111 = this.g;
        L57:
            r11.e(r12, r13, r20, r111, this.g, this.c, this.i);
            return;
        L56:
            r111 = this.h;
            goto L57
        L48:
            r110 = null;
            goto L49
        L44:
            r18 = null;
            goto L45
        L28:
            r7 = 0;
            goto L29
        L25:
            r6 = 0;
            goto L26
        L61:
            EncodedImage r21 = new EncodedImage(r15);     // Catch: Throwable -> L15
            r21.parseMetaData();     // Catch: Throwable -> L15
            r3 = TuplesKt.to(Integer.valueOf(r21.getWidth()), Integer.valueOf(r21.getHeight()));     // Catch: Throwable -> L13
            r21.close();
            CloseableReference.closeSafely(r15);
        L13:
            Throwable th = th;
        L17:
            if (r21 == null) goto L19;
            r21.close();
        L19:
            CloseableReference.closeSafely(r15);
            throw th;
        L15:
            th = move-exception;
            r21 = null;
            th = th;
            goto L17
        }

        public a(long r1, i r3, ResizeOptions r4, SimpleDraweeView r5, String r6, ImageRequest r7, Uri r8, Uri r9, BaseControllerListener<ImageInfo> r10) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ String a;
        public final /* synthetic */ i b;
        public final /* synthetic */ Ref.BooleanRef c;
        public final /* synthetic */ Message d;
        public final /* synthetic */ BaseControllerListener<ImageInfo> e;
        public final /* synthetic */ Uri f;

        public final void onFailure(String r6, Throwable r7) {
            String r0 = this.a;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L12;
            FLogger.a.e(this.b.getLogTag(), "[image_load_failed]:" + this.a, r7);
        L12:
            if (this.c.element == true) goto L23;
            Message r2 = this.d;
            if (r2 == null) goto L23;
            i r3 = this.b;
            nq9.f r4 = m3.a.o();
            if (r4 == null) goto L23;
            OldUgcGenImgPerfMonitor r5 = r4.a(true);
            if (r5 == null) goto L23;
            String r8 = r3.a();
            if (r8 != null) goto L22;
            r8 = "";
        L22:
            r5.f(r2, r8);
        L23:
            BaseControllerListener<ImageInfo> r9 = this.e;
            if (r9 == null) goto L27;
            r9.onFailure(r6, r7);
            return;
        L27:
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public final void onIntermediateImageSet(String r6, Object r7) {
            ImageInfo r8 = (ImageInfo) r7;
            FLogger r0 = FLogger.a;
            String r1 = this.b.getLogTag();
            StringBuilder r2 = new StringBuilder("[onIntermediateImageSet]:");
            r2.append(this.f);
            r2.append("   ");
            r2.append(r6);
            r2.append(' ');
            if (r8 == null) goto L7;
            ImageFormat r4 = r8.getImageFormat();
            if (r4 == null) goto L7;
            String r5 = r4.getFileExtension();
        L8:
            r2.append(r5);
            r2.append(' ');
            r0.i(r1, r2.toString());
            super.onIntermediateImageSet(r6, r8);
            if (this.c.element == true) goto L20;
            Message r3 = this.d;
            if (r3 == null) goto L20;
            i r9 = this.b;
            nq9.f r10 = m3.a.o();
            if (r10 == null) goto L20;
            OldUgcGenImgPerfMonitor r11 = r10.a(true);
            if (r11 == null) goto L20;
            String r12 = r9.a();
            if (r12 != null) goto L19;
            r12 = "";
        L19:
            r11.b(r3, r12);
        L20:
            BaseControllerListener<ImageInfo> r13 = this.e;
            if (r13 == null) goto L24;
            r13.onIntermediateImageSet(r6, r8);
            return;
        L24:
            return;
        L7:
            r5 = null;
            goto L8
        }

        public final void onSubmit(String r5, Object r6) {
            super.onSubmit(r5, r6);
            if (this.c.element == true) goto L14;
            Message r0 = this.d;
            if (r0 == null) goto L14;
            i r1 = this.b;
            nq9.f r2 = m3.a.o();
            if (r2 == null) goto L14;
            OldUgcGenImgPerfMonitor r3 = r2.a(true);
            if (r3 == null) goto L14;
            String r4 = r1.a();
            if (r4 != null) goto L13;
            r4 = "";
        L13:
            r3.g(r0, r4);
        L14:
            BaseControllerListener<ImageInfo> r7 = this.e;
            if (r7 == null) goto L18;
            r7.onSubmit(r5, r6);
            return;
        }

        public final void onFinalImageSet(String r5, Object r6, Animatable r7) {
            ImageInfo r8 = (ImageInfo) r6;
            FLogger r0 = FLogger.a;
            String r1 = this.b.getLogTag();
            StringBuilder r2 = new StringBuilder("[onFinalImageSet]:");
            r2.append(this.a);
            r2.append("   ");
            r2.append(r5);
            r2.append("  ");
            if (r8 == null) goto L7;
            ImageFormat r3 = r8.getImageFormat();
            if (r3 == null) goto L7;
            String r4 = r3.getFileExtension();
        L8:
            r2.append(r4);
            r2.append(' ');
            r0.i(r1, r2.toString());
            super.onFinalImageSet(r5, r8, r7);
            if (this.c.element == true) goto L20;
            Message r9 = this.d;
            if (r9 == null) goto L20;
            i r10 = this.b;
            nq9.f r11 = m3.a.o();
            if (r11 == null) goto L20;
            OldUgcGenImgPerfMonitor r12 = r11.a(true);
            if (r12 == null) goto L20;
            String r13 = r10.a();
            if (r13 != null) goto L19;
            r13 = "";
        L19:
            r12.b(r9, r13);
        L20:
            BaseControllerListener<ImageInfo> r14 = this.e;
            if (r14 == null) goto L24;
            r14.onFinalImageSet(r5, r8, r7);
            return;
        L24:
            return;
        L7:
            r4 = null;
            goto L8
        }

        public b(String r1, i r2, Ref.BooleanRef r3, Message r4, BaseControllerListener<ImageInfo> r5, Uri r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.j
    public final String a() {
        return this.a.a();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.j
    public final Message b() {
        return this.a.b();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.j
    public final String getLogTag() {
        return this.a.getLogTag();
    }

    public i(j r2) {
        Intrinsics.checkNotNullParameter(r2, "depend");
        this.a = r2;
    }

    public static int c(int... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        int r3 = r5[r2];
        boolean r4 = true;
        if (r3 > 1) goto L8;
        r4 = false;
    L8:
        if (r4 == true) goto L9;
        r2 = r2 + 1;
        goto L3
    L9:
        Integer r6 = Integer.valueOf(r3);
    L12:
        if (r6 != null) goto L14;
        return 0;
    L14:
        return r6.intValue();
    L11:
        r6 = null;
        goto L12
    }

    public final void d(SimpleDraweeView r15, Uri r16, Uri r17, String r18, BaseControllerListener<ImageInfo> r19, ResizeOptions r20) {
        Intrinsics.checkNotNullParameter(r15, "imageView");
        if (r16 != null) goto L7;
        if (r17 != null) goto L7;
        FLogger.a.e(getLogTag(), "loadImage url is invalid ");
        r15.setActualImageResource(2131240764);
        return;
    L7:
        long r1 = this.b + 1;
        this.b = r1;
        ImageDecodeOptions r0 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        if (r16 == null) goto L10;
        ImageRequestBuilder r3 = ImageRequestBuilder.newBuilderWithSource(r16);
        r3.setResizeOptions(new ResizeOptions(i5.d(), i5.d()));
        ImageRequest r2 = r3.setImageDecodeOptions(r0).build();
    L11:
        ImageRequest r7 = r2;
        if (u.c() == false) goto L18;
        if (r7 == null) goto L18;
        if (r17 == null) goto L18;
        Fresco.getImagePipeline().fetchEncodedImage(r7, r15.getContext().getApplicationContext()).subscribe(new a(r1, this, r20, r15, r18, r7, r16, r17, r19), UiThreadImmediateExecutorService.getInstance());
        return;
    L18:
        e(r15, r18, r7, r17, r16, r20, r19);
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void e(final SimpleDraweeView r17, String r18, final ImageRequest r19, Uri r20, final Uri r21, final ResizeOptions r22, final BaseControllerListener<ImageInfo> r23) {
        if (r20 != null) goto L5;
        FLogger.a.e(getLogTag(), "submitController main uri is null");
        r17.setActualImageResource(2131240764);
        return;
    L5:
        final Ref.BooleanRef r6 = new Ref.BooleanRef();
        final String r7 = y0.k(r20);
        final Message r8 = b();
        MessageImageLoader r0 = MessageImageLoader.a;
        if (r8 == null) goto L8;
        String r1 = r8.getMessageId();
    L9:
        IMessageImageLoaderService.a.a(r0, r1, MessageImageType.IMAGE, r17, r20.toString(), r18, new g(r19, r17, this, r22, r6, r7, r8, r23, r21), 32);
        return;
    L8:
        r1 = null;
        goto L9
    }
}
