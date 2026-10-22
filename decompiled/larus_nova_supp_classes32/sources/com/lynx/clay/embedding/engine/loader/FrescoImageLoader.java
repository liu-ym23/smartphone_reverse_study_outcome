package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aivoice.core.data.NameKeys;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrescoImageLoader extends ResourceLoaderImpl.b {
    private static ArrayList<Integer> validEncodedType;
    private volatile boolean destroyed;
    private HashMap<ResourceLoaderCallback, DataSource<CloseableReference<PooledByteBuffer>>> pendingCallbacks;
    private HashMap<ResourceLoaderCallback, DataSource<CloseableReference<CloseableImage>>> pendingImages;

    public class a extends BaseBitmapDataSubscriber {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ ResourceLoaderCallback b;
        public final /* synthetic */ FrescoImageLoader c;

        /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.loader.FrescoImageLoader$a$a, reason: collision with other inner class name */
        public class RunnableC0035a implements Runnable {
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ a b;

            @Override // java.lang.Runnable
            public final void run() {
                Bitmap r0 = this.a;     // Catch: Throwable -> L8
                if (r0 == null) goto L5;
                a r1 = this.b;     // Catch: Throwable -> L8
                r1.b.onSucceeded(FrescoImageLoader.access$000(r1.c, r0));     // Catch: Throwable -> L8
            L6:
                a r2 = this.b;     // Catch: Throwable -> L8
                r2.c.removeImagePendingRequest(r2.b);     // Catch: Throwable -> L8
                return;
            L5:
                this.b.b.onFailed("empty bitmap");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }

            public RunnableC0035a(a r1, Bitmap r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ DataSource a;
            public final /* synthetic */ a b;

            public final void a() {
                if (this.a.getFailureCause() == null) goto L5;
                this.b.b.onFailed(this.a.getFailureCause().getMessage());
            L6:
                a r0 = this.b;
                r0.c.removeImagePendingRequest(r0.b);
                return;
            L5:
                this.b.b.onFailed(NameKeys.UnloadStrategy_No_Strategy);
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(a r1, DataSource r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public final void onFailureImpl(DataSource r3) {
            this.a.post(new b(this, r3));
        }

        public final void onNewResultImpl(Bitmap r3) {
            this.a.post(new RunnableC0035a(this, r3));
        }

        public a(FrescoImageLoader r1, Handler r2, ResourceLoaderCallback r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
        public final /* synthetic */ ResourceLoaderCallback a;
        public final /* synthetic */ Handler b;
        public final /* synthetic */ FrescoImageLoader c;

        public class a implements Runnable {
            public final /* synthetic */ DataSource a;
            public final /* synthetic */ b b;

            public final void a() {
                if (this.a.getFailureCause() == null) goto L5;
                this.b.a.onFailed(this.a.getFailureCause().getMessage());
            L6:
                b r0 = this.b;
                r0.c.removePendingRequest(r0.a);
                return;
            L5:
                this.b.a.onFailed(NameKeys.UnloadStrategy_No_Strategy);
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r1, DataSource r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r3) {
            this.b.post(new a(this, r3));
        }

        public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r4) {
            if (r4.isFinished() == true) goto L5;
            return;
        L5:
            CloseableReference r0 = (CloseableReference) r4.getResult();
            if (r0 != null) goto L9;
            r4.close();
            return;
        L9:
            InputStream r1 = null;
            InputStream r2 = new PooledByteBufferInputStream((PooledByteBuffer) r0.get());     // Catch: Throwable -> L16
            byte[] r5 = new byte[r2.available()];     // Catch: Throwable -> L14
            r2.read(r5);     // Catch: Throwable -> L14
            this.a.onSucceeded(r5);     // Catch: Throwable -> L14
            this.c.removePendingRequest(this.a);     // Catch: Throwable -> L14
            CloseableReference.closeSafely(r0);
            Closeables.closeQuietly(r2);
            return;
        L14:
            th = th;
            r1 = r2;
        L17:
            CloseableReference.closeSafely(r0);
            if (r1 == null) goto L20;
            Closeables.closeQuietly(r1);
        L20:
            throw th;
        L16:
            th = th;
            goto L17
        }

        public b(FrescoImageLoader r1, ResourceLoaderCallback r2, Handler r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        validEncodedType = new ArrayList(Arrays.asList(new Integer[]{0, 2, 3, 4}));
    }

    public static FrescoImageLoader create() {
        return new FrescoImageLoader();
    }

    public FrescoImageLoader() {
        this.pendingCallbacks = new HashMap();
        this.pendingImages = new HashMap();
    }

    public static void Initialize(Context r0) {
        Fresco.initialize(r0);
    }

    private byte[] bitmapToByteArray(Bitmap r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r4.compress(Bitmap.CompressFormat.PNG, 100, r0);
        return r0.toByteArray();
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl.b
    public void cancelAll(boolean r3) {
        if (this.destroyed == false) goto L5;
        return;
    L5:
        this.destroyed = r3;
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<PooledByteBuffer>>> r4 = this.pendingCallbacks;
        monitor-enter(r4);
        Iterator<DataSource<CloseableReference<PooledByteBuffer>>> r0 = this.pendingCallbacks.values().iterator();     // Catch: Throwable -> L29
    L9:
        if (r0.hasNext() == false) goto L13;
        DataSource<CloseableReference<PooledByteBuffer>> r1 = r0.next();     // Catch: Throwable -> L29
        if (r1 == null) goto L9;
        r1.close();     // Catch: Throwable -> L29
        goto L9
    L13:
        this.pendingCallbacks.clear();     // Catch: Throwable -> L29
        monitor-exit(r4);     // Catch: Throwable -> L29
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<CloseableImage>>> r2 = this.pendingImages;
        monitor-enter(r2);
        Iterator<DataSource<CloseableReference<CloseableImage>>> r5 = this.pendingImages.values().iterator();     // Catch: Throwable -> L26
    L19:
        if (r5.hasNext() == false) goto L23;
        DataSource<CloseableReference<CloseableImage>> r6 = r5.next();     // Catch: Throwable -> L26
        if (r6 == null) goto L19;
        r6.close();     // Catch: Throwable -> L26
        goto L19
    L23:
        this.pendingImages.clear();     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    public void removeImagePendingRequest(ResourceLoaderCallback r4) {
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<CloseableImage>>> r0 = this.pendingImages;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.pendingImages.containsKey(r4) == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        DataSource<CloseableReference<CloseableImage>> r1 = this.pendingImages.get(r4);     // Catch: Throwable -> L13
        this.pendingImages.remove(r4);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (r1 == null) goto L17;
        r1.close();
        return;
    }

    public void removePendingRequest(ResourceLoaderCallback r4) {
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<PooledByteBuffer>>> r0 = this.pendingCallbacks;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.pendingCallbacks.containsKey(r4) == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        DataSource<CloseableReference<PooledByteBuffer>> r1 = this.pendingCallbacks.get(r4);     // Catch: Throwable -> L13
        this.pendingCallbacks.remove(r4);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (r1 == null) goto L17;
        r1.close();
        return;
    }

    public static /* synthetic */ byte[] access$000(FrescoImageLoader r0, Bitmap r1) {
        return r0.bitmapToByteArray(r1);
    }

    private void loadDocodedImage(DataSource<CloseableReference<CloseableImage>> r4, ResourceLoaderCallback r5, boolean r6) {
        Handler r0 = new Handler(Looper.getMainLooper());
        if (r6 == true) goto L34;
        r4.subscribe(new a(this, r0, r5), UiThreadImmediateExecutorService.getInstance());
        this.pendingImages.put(r5, r4);
        return;
    L34:
        CloseableReference r1 = (CloseableReference) DataSources.waitForFinalResult(r4);     // Catch: Throwable -> L18
        if (r1 != null) goto L33;
    L12:
        r5.onFailed("failed to get result from data sources");     // Catch: Throwable -> L16
        r4.close();
        if (r1 == null) goto L36;
    L23:
        CloseableReference.closeSafely(r1);
        return;
    L36:
        return;
    L33:
        CloseableBitmap r7 = (CloseableImage) r1.get();     // Catch: Throwable -> L16
        if ((r7 instanceof CloseableBitmap) == false) goto L12;
        r5.onSucceeded(bitmapToByteArray(r7.getUnderlyingBitmap()));     // Catch: Throwable -> L16
        r4.close();
        CloseableReference.closeSafely(r1);
        return;
    L16:
        Throwable th = th;
    L31:
        r5.onFailed(th.toString());     // Catch: Throwable -> L24
        r4.close();
        if (r1 != null) goto L23;
        return;
    L24:
        th = move-exception;
        r4.close();
        if (r1 == null) goto L28;
        CloseableReference.closeSafely(r1);
    L28:
        throw th;
    L18:
        th = move-exception;
        r1 = null;
        th = th;
        goto L31
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl.b
    public void load(int r2, String r3, ResourceLoaderCallback r4, boolean r5, boolean r6) {
        if (this.destroyed == true) goto L51;
        if (r4 != null) goto L7;
        return;
    L7:
        if (Fresco.hasBeenInitialized() == true) goto L10;
        r4.onFailed("Fresco has not been initialized!");
        return;
    L10:
        ImagePipeline r7 = Fresco.getImagePipeline();
        ImageRequest r8 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3)).build();
        InputStream r0 = null;
        if (validEncodedType.contains(Integer.valueOf(r8.getSourceUriType())) == true) goto L14;
        loadDocodedImage(r7.fetchDecodedImage(r8, null), r4, r5);
        return;
    L14:
        DataSource<CloseableReference<PooledByteBuffer>> r9 = r7.fetchEncodedImage(r8, null);
        if (r5 == true) goto L57;
        r9.subscribe(new b(this, r4, new Handler(Looper.getMainLooper())), UiThreadImmediateExecutorService.getInstance());
        HashMap<ResourceLoaderCallback, DataSource<CloseableReference<PooledByteBuffer>>> r10 = this.pendingCallbacks;
        monitor-enter(r10);
        this.pendingCallbacks.put(r4, r9);     // Catch: Throwable -> L48
        monitor-exit(r10);     // Catch: Throwable -> L48
        return;
    L48:
        th = move-exception;
        throw th;
    L57:
        InputStream r11 = (CloseableReference) DataSources.waitForFinalResult(r9);     // Catch: Throwable -> L29
        if (r11 == null) goto L21;
        InputStream r12 = new PooledByteBufferInputStream((PooledByteBuffer) r11.get());     // Catch: Throwable -> L27
        byte[] r13 = new byte[r12.available()];     // Catch: Throwable -> L52
        r12.read(r13);     // Catch: Throwable -> L52
        r4.onSucceeded(r13);     // Catch: Throwable -> L52
        r0 = r12;
    L22:
        r9.close();
        if (r11 == null) goto L25;
        CloseableReference.closeSafely(r11);
    L25:
        if (r0 == null) goto L63;
        Closeables.closeQuietly(r0);
        return;
    L63:
        return;
    L28:
        r0 = r11;
    L61:
        r4.onFailed(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L36
        r9.close();
        if (r0 == null) goto L34;
        CloseableReference.closeSafely(r0);
    L34:
        if (r12 == null) goto L65;
        Closeables.closeQuietly(r12);
        return;
    L65:
        return;
    L36:
        th = move-exception;
        r9.close();
        if (r0 == null) goto L40;
        CloseableReference.closeSafely(r0);
    L40:
        if (r12 == null) goto L42;
        Closeables.closeQuietly(r12);
    L42:
        throw th;
    L21:
        r4.onFailed(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L27
    L27:
        r12 = r0;
    L29:
        r12 = null;
        goto L61
    }
}
