package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.util.LiveBlurProcessorV2;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a1 {

    public class a extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ c b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.utils.a1$a$a, reason: collision with other inner class name */
        public class C0032a implements Consumer<Bitmap> {
            public final /* synthetic */ a a;

            public C0032a(a r1) {
                this.a = r1;
            }

            public final void accept(Object r7) throws Exception {
                Bitmap r2 = (Bitmap) r7;
                if (r2 != null) goto L5;
            L10:
                boolean r8 = false;
            L11:
                if (r8 == true) goto L16;
                c r9 = this.a.b;
                if (r9 == null) goto L17;
                new RuntimeException();
                r9.onFail();
                return;
            L17:
                return;
            L16:
                return;
            L5:
                if (r2.getNinePatchChunk() == null) goto L10;
                a1.i(r2.getNinePatchChunk());
                NinePatchDrawable r10 = new NinePatchDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r2, r2.getNinePatchChunk(), new Rect(), null);
                r10.setAutoMirrored(this.a.a);
                c r0 = this.a.b;
                if (r0 == null) goto L9;
                r0.a(r10);
            L9:
                r8 = true;
                goto L11
            }
        }

        public class b implements Function<PooledByteBuffer, Bitmap> {
            public b() {
            }

            public final Object apply(Object r2) throws Exception {
                return BitmapFactory.decodeStream(new PooledByteBufferInputStream((PooledByteBuffer) r2));
            }
        }

        public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r2) {
            c r3 = this.b;
            if (r3 == null) goto L6;
            new RuntimeException();
            r3.onFail();
            return;
        }

        public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (r3.isFinished() == true) goto L6;
            return;
        L6:
            if (r3.getResult() != null) goto L8;
            return;
        L8:
            if (((CloseableReference) r3.getResult()).get() == null) goto L15;
            Observable.just((PooledByteBuffer) ((CloseableReference) r3.getResult()).get()).subscribeOn(Schedulers.io()).map(new b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0032a(this), RxUtil.getNoOpThrowable());
            return;
        }

        public a(boolean r1, c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface b {
        void a(Bitmap r1);

        void onFail(Exception r1);
    }

    public interface c {
        void a(NinePatchDrawable r1);

        void onFail();
    }

    public static Rect i(byte[] r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ByteBuffer r3 = ByteBuffer.wrap(r2).order(ByteOrder.nativeOrder());
        if (r3.get() != 0) goto L8;
        return null;
    L8:
        r3.get();
        r3.get();
        r3.get();
        r3.getInt();
        r3.getInt();
        Rect r0 = new Rect();
        r0.left = r3.getInt();
        r0.right = r3.getInt();
        r0.top = r3.getInt();
        r0.bottom = r3.getInt();
        return r0;
    }

    public static boolean j(py.k r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isValid() == false) goto L6;
        return true;
    }

    public static Observable<Bitmap> k(py.k r2) {
        return l(r2, 0, 0, false, null);
    }

    public static void z(py.k r1) {
        if (r1 == null) goto L5;
        k(r1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    }

    public static ImageRequest[] b(py.k r9, int r10) {
        if (r9 != null) goto L5;
    L33:
        return null;
    L5:
        if (r9.getUrls() == null) goto L33;
        if (r9.getUrls().size() == 0) goto L33;
        ArrayList r1 = new ArrayList();
        ImageNetworkRequestsMonitor r2 = new ImageNetworkRequestsMonitor();
        Iterator r11 = r9.getUrls().iterator();
    L11:
        if (r11.hasNext() == false) goto L29;
        String r3 = (String) r11.next();
        if (StringUtils.isEmpty(r3) == true) goto L11;
        ImageRequestBuilder r4 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3));
        r2.monitor(r4);
        if (r10 < 0) goto L27;
        CountingMemoryCache r5 = com.bytedance.android.live.core.utils.fresco.e.a;
        Bitmap.Config r6 = Bitmap.Config.ARGB_8888;
        if (r4 == null) goto L27;
        ImageDecodeOptionsBuilder r7 = new ImageDecodeOptionsBuilder().setBitmapConfig(r6);
        Method r8 = com.bytedance.android.live.core.utils.fresco.e.b;
        if (r8 != null) goto L34;
    L26:
        r4.setImageDecodeOptions(r7.build());
        goto L27
    L34:
        r8.invoke(r7, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L25
    L25:
        ALogger.e("Fresco", "");
    L27:
        r1.add(r4.build());
        goto L11
    L29:
        if (r1.size() != 0) goto L32;
        return null;
    L32:
        return (ImageRequest[]) r1.toArray(new ImageRequest[r1.size()]);
    }

    public static Drawable e(py.k r2, boolean r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.getUrls() != null) goto L6;
        return null;
    L6:
        if (r2.getUrls().size() == 0) goto L16;
        ImageRequest[] r4 = b(r2, -1);
        AbstractDraweeController r5 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r4).setAutoPlayAnimations(true).build();
        GenericDraweeHierarchy r0 = new GenericDraweeHierarchyBuilder(com.bytedance.android.live.core.utils.s1.getResources()).build();
        if (r3 == false) goto L11;
        r0.setFadeDuration(0);
    L11:
        DraweeHolder r6 = DraweeHolder.create(r0, com.bytedance.android.live.core.utils.s1.getContext());
        r6.setController(r5);
        return r6.getTopLevelDrawable();
    L16:
        return null;
    }

    public static NinePatchDrawable h(Bitmap r13, float r14) {
        Matrix r5 = new Matrix();
        r5.postScale(r14, r14);
        Bitmap r9 = Bitmap.createBitmap(r13, 0, 0, r13.getWidth(), r13.getHeight(), r5, true);
        if (r13.getNinePatchChunk() == null) goto L24;
        byte[] r15 = r13.getNinePatchChunk();
        if (r15 != null) goto L7;
    L6:
        byte[] r10 = null;
    L23:
        return new NinePatchDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r9, r10, i(r10), null);
    L7:
        ByteBuffer r0 = ByteBuffer.allocate(r15.length).order(ByteOrder.nativeOrder());
        ByteBuffer r16 = ByteBuffer.wrap(r15).order(ByteOrder.nativeOrder());
        if (r16.get() == 0) goto L6;
        r0.put((byte) 1);
        int r2 = r16.get();
        int[] r3 = new int[r2];
        int r4 = r16.get();
        int[] r6 = new int[r4];
        int r7 = r16.get();
        int[] r8 = new int[r7];
        r0.put((byte) r2);
        r0.put((byte) r4);
        r0.put((byte) r7);
        r0.putInt(r16.getInt());
        r0.putInt(r16.getInt());
        r0.putInt((int) (r16.getInt() * r14));
        r0.putInt((int) (r16.getInt() * r14));
        r0.putInt((int) (r16.getInt() * r14));
        r0.putInt((int) (r16.getInt() * r14));
        r0.putInt(r16.getInt());
        int r11 = 0;
        r3[0] = r16.getInt();
        int r12 = r16.getInt();
        r3[1] = r12;
        int r17 = (int) (r3[0] * r14);
        int r18 = (int) (r12 * r14);
        if (r18 != r17) goto L14;
        if (r18 == 0) goto L14;
        r18 = r18 + 1;
    L14:
        r0.putInt(r17);
        r0.putInt(r18);
        r6[0] = r16.getInt();
        int r19 = r16.getInt();
        r6[1] = r19;
        int r1 = (int) (r6[0] * r14);
        int r110 = (int) (r19 * r14);
        if (r1 != r110) goto L18;
        if (r110 == 0) goto L18;
        r110 = r110 + 1;
    L18:
        r0.putInt(r1);
        r0.putInt(r110);
    L19:
        if (r11 >= r7) goto L21;
        r0.putInt(r16.getInt());
        r11 = r11 + 1;
        goto L19
    L21:
        r10 = r0.array();
        goto L23
    L24:
        return null;
    }

    public static void m(ImageView r0, int r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        ImageUtil.loadImage(r0, Integer.valueOf(r1));
    }

    public static void n(HSImageView r1, String r2) {
        py.k r0 = vh7.f.c(py.k.class);
        r0.setUrls(Collections.singletonList(r2));
        ImageUtil.loadImage(r1, r0, 0);
    }

    public static void s(HSImageView r1, String r2) {
        FrescoLoader.with(r1.getContext()).load(r2).cornersRadius(com.bytedance.android.live.core.utils.s1.f(8)).actualScaleType(ImageView.ScaleType.CENTER_CROP).into(r1);
    }

    @Deprecated(message = "新方案多端统一，不再使用.9图，需要UI给新png图，见ResizableImageLoader")
    public static void u(py.k r2, b r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getUrls() != null) goto L6;
        return;
    L6:
        if (r2.getUrls().size() == 0) goto L12;
        Uri r4 = UriProtector.parse((String) ListProtector.get(r2.getUrls(), 0));
        ImageNetworkRequestsMonitor r0 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r5 = ImageRequestBuilder.newBuilderWithSource(r4);
        r0.monitor(r5);
        ImageRequest r6 = r5.build();
        Fresco.getImagePipeline().fetchEncodedImage(r6, null).subscribe(new z0(r3), UiThreadImmediateExecutorService.getInstance());
        return;
    }

    @Deprecated(message = "新方案多端统一，不再使用.9图，需要UI给新png图，见ResizableImageLoader")
    public static void d(py.k r2, boolean r3, c r4) {
        if (r2.getUrls() != null) goto L5;
        return;
    L5:
        if (r2.getUrls().size() == 0) goto L10;
        Uri r5 = UriProtector.parse((String) ListProtector.get(r2.getUrls(), 0));
        ImageNetworkRequestsMonitor r0 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r6 = ImageRequestBuilder.newBuilderWithSource(r5);
        r0.monitor(r6);
        ImageRequest r7 = r6.build();
        Fresco.getImagePipeline().fetchEncodedImage(r7, null).subscribe(new a(r3, r4), UiThreadImmediateExecutorService.getInstance());
        return;
    }

    public static void o(HSImageView r8, py.k r9, ImageView.ScaleType r10) {
        ImageUtil.loadImage(r8, r9, -1, -1, false, 0, r10, null);
    }

    public static void q(HSImageView r11, py.k r12, boolean r13) {
        ImageLoader.bindImage(r11, r12, null, 300, -1, -1, null, null, false, r13, true);
    }

    public static void r(HSImageView r3, String r4, int r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r4) == true) goto L12;
        ImageNetworkRequestsMonitor r0 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r6 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r4));
        r0.monitor(r6);
        ImageRequest r7 = r6.build();
        AbstractDraweeController r8 = Fresco.newDraweeControllerBuilder().setOldController(r3.getController()).setFirstAvailableImageRequests(new ImageRequest[]{r7}).build();
        if (r5 == 0) goto L9;
        r3.getHierarchy().setPlaceholderImage(r5);
    L9:
        r3.setController(r8);
        return;
    }

    public static void v(ImageView r6, py.k r7, int r8) {
        ImageUtil.loadRoundImage(r6, r7, 0, 0, r8, null);
    }

    public static byte[] f(byte[] r8, float r9, boolean r10, boolean r11) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ByteBuffer r1 = ByteBuffer.allocate(r8.length).order(ByteOrder.nativeOrder());
        ByteBuffer r12 = ByteBuffer.wrap(r8).order(ByteOrder.nativeOrder());
        if (r12.get() != 0) goto L8;
        return null;
    L8:
        r1.put((byte) 1);
        int r2 = r12.get();
        int[] r3 = new int[r2];
        int r4 = r12.get();
        int[] r5 = new int[r4];
        int r6 = r12.get();
        int[] r7 = new int[r6];
        r1.put((byte) r2);
        r1.put((byte) r4);
        r1.put((byte) r6);
        r1.putInt(r12.getInt());
        r1.putInt(r12.getInt());
        r1.putInt((int) (r12.getInt() * r9));
        r1.putInt((int) (r12.getInt() * r9));
        r1.putInt((int) (r12.getInt() * r9));
        r1.putInt((int) (r12.getInt() * r9));
        r1.putInt(r12.getInt());
        int r13 = 0;
        r3[0] = r12.getInt();
        int r14 = r12.getInt();
        r3[1] = r14;
        if (r10 == false) goto L15;
        int r15 = (int) (r3[0] * r9);
        int r16 = (int) (r14 * r9);
        if (r16 != r15) goto L14;
        if (r16 == 0) goto L14;
        r16 = r16 + 1;
    L14:
        r1.putInt(r15);
        r1.putInt(r16);
    L16:
        r5[0] = r12.getInt();
        int r17 = r12.getInt();
        r5[1] = r17;
        if (r11 == false) goto L23;
        int r18 = (int) (r5[0] * r9);
        int r19 = (int) (r17 * r9);
        if (r19 != r18) goto L22;
        if (r19 == 0) goto L22;
        r19 = r19 + 1;
    L22:
        r1.putInt(r18);
        r1.putInt(r19);
    L24:
        if (r13 >= r6) goto L27;
        r1.putInt(r12.getInt());
        r13 = r13 + 1;
        goto L24
    L27:
        return r1.array();
    L23:
        r1.putInt((int) (r5[0] * r9));
        r1.putInt((int) (r5[1] * r9));
        goto L24
    L15:
        r1.putInt((int) (r3[0] * r9));
        r1.putInt((int) (r3[1] * r9));
        goto L16
    }

    public static NinePatchDrawable g(Bitmap r14, float r15, boolean r16, boolean r17) {
        Matrix r6 = new Matrix();
        r6.postScale(r15, r15);
        Bitmap r10 = Bitmap.createBitmap(r14, 0, 0, r14.getWidth(), r14.getHeight(), r6, true);
        if (r14.getNinePatchChunk() == null) goto L6;
        byte[] r11 = f(r14.getNinePatchChunk(), r15, r16, r17);
        Rect r12 = i(r11);
        return new NinePatchDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r10, r11, r12, null);
    L6:
        return null;
    }

    public static void p(HSImageView r12, String r13, LiveBlurProcessorV2 r14, boolean r15) {
        py.k r2 = vh7.f.c(py.k.class);
        r2.setUrls(Collections.singletonList(r13));
        ImageLoader.bindImage(r12, r2, null, 300, -1, -1, r14, null, false, r15, true);
    }

    @Deprecated(message = "新方案多端统一，不再使用.9图，需要UI给新png图，见ResizableImageLoader")
    public static void t(View r2, py.k r3, boolean r4, ht2.e r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getUrls() != null) goto L6;
        return;
    L6:
        if (r3.getUrls().size() == 0) goto L12;
        Uri r6 = UriProtector.parse((String) ListProtector.get(r3.getUrls(), 0));
        ImageNetworkRequestsMonitor r0 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r7 = ImageRequestBuilder.newBuilderWithSource(r6);
        r0.monitor(r7);
        ImageRequest r8 = r7.build();
        Fresco.getImagePipeline().fetchEncodedImage(r8, null).subscribe(new w0(r2, r4, r5), UiThreadImmediateExecutorService.getInstance());
        return;
    }

    public static void w(ImageView r6, py.k r7, int r8, int r9) {
        ImageUtil.loadRoundImage(r6, r7, r8, r9, 0, null);
    }

    public static DataSource<CloseableReference<CloseableImage>> a(py.k r3, int r4, int r5, boolean r6, Postprocessor r7) {
        if (r6 == true) goto L9;
        if (r4 <= 0) goto L6;
        if (r5 > 0) goto L9;
    L6:
        if (r7 != null) goto L9;
        ImageRequest[] r8 = b(r3, -1);
    L13:
        if (r8 != null) goto L15;
    L29:
        return null;
    L15:
        if (r8.length == 0) goto L29;
        ArrayList r9 = new ArrayList();
        int r10 = r8.length;
        int r11 = 0;
    L18:
        if (r11 >= r10) goto L25;
        ImageRequest r12 = r8[r11];
        if (r12 == null) goto L23;
        r9.add(Fresco.getImagePipeline().getDataSourceSupplier(r12, null, ImageRequest.RequestLevel.FULL_FETCH));
    L23:
        r11 = r11 + 1;
        goto L18
    L25:
        if (r9.isEmpty() == false) goto L28;
        return null;
    L28:
        return FirstAvailableDataSourceSupplier.create(r9).get();
    L9:
        if (r6 == false) goto L11;
        Bitmap.Config r13 = Bitmap.Config.RGB_565;
    L12:
        r8 = c(r3, r4, r5, r13, r7);
        goto L13
    L11:
        r13 = null;
        goto L12
    }

    public static ImageRequest[] c(py.k r5, int r6, int r7, Bitmap.Config r8, Postprocessor r9) {
        if (r5 != null) goto L5;
    L29:
        return null;
    L5:
        if (r5.getUrls() == null) goto L29;
        if (r5.getUrls().size() == 0) goto L29;
        ArrayList r1 = new ArrayList();
        ImageNetworkRequestsMonitor r2 = new ImageNetworkRequestsMonitor();
        Iterator r10 = r5.getUrls().iterator();
    L11:
        if (r10.hasNext() == false) goto L25;
        String r3 = (String) r10.next();
        if (StringUtils.isEmpty(r3) == true) goto L11;
        ImageRequestBuilder r4 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3));
        if (r6 <= 0) goto L19;
        if (r7 <= 0) goto L19;
        r4.setResizeOptions(new ResizeOptions(r6, r7));
    L19:
        if (r8 == null) goto L21;
        r4.setImageDecodeOptions(new ImageDecodeOptionsBuilder().setBitmapConfig(r8).build());
    L21:
        if (r9 == null) goto L23;
        r4.setPostprocessor(r9);
    L23:
        r2.monitor(r4);
        r1.add(r4.build());
        goto L11
    L25:
        if (r1.size() != 0) goto L28;
        return null;
    L28:
        return (ImageRequest[]) r1.toArray(new ImageRequest[r1.size()]);
    }

    public static Observable l(final py.k r8, final int r9, final int r10, final boolean r11, final com.bytedance.android.livesdk.utils.l3 r12) {
        if (r8 == null) goto L4;
    L6:
        Throwable r0 = null;
    L7:
        final Throwable r7 = r0;
        return Observable.create(new t0(r11, r9, r10, r12, r8, r7));
    L4:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        r0 = new Throwable();
        goto L7
    }

    public static void x(ImageView r6, py.k r7, int r8, int r9, int r10) {
        ImageUtil.loadRoundImage(r6, r7, r8, r9, r10, null);
    }

    public static void y(ImageView r9, py.k r10, int r11, int r12, float r13) {
        ImageUtil.loadRoundImageWithBorder(r9, r10, 0, 0, r11, r12, r13, false, null);
    }
}
