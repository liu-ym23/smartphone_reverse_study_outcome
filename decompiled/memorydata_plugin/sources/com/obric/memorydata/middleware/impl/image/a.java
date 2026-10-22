package com.obric.memorydata.middleware.impl.image;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.LruCache;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\u0006\u0010 \u001a\u00020!JB\u0010\"\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\u001a\u0010#\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0$j\n\u0012\u0006\u0012\u0004\u0018\u00010\r`%2\u0006\u0010 \u001a\u00020!H\u0002J:\u0010&\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\u001a\u0010#\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0$j\n\u0012\u0006\u0012\u0004\u0018\u00010\r`%H\u0002J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001dH\u0002J\u0016\u0010+\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\fH\u0002J\u000e\u0010,\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/GlobalSearchImageManager;", "", "<init>", "()V", "TAG", "", "MAX_CACHE_SIZE", "", "MAX_RETRY_COUNT", "IMAGE_INDEX_TEMP", "cache", "Landroid/util/LruCache;", "", "Lcom/obric/memorydata/middleware/impl/image/ImageUploadResult;", "uploadRetryMap", "", "uploadCompleteLocks", "Ljava/util/concurrent/CountDownLatch;", "UPLOAD_TIME_OUT", "", "getByLogIdWithTimeout", "logId", "timeoutMs", "notifyUploadComplete", "", "compressAndConvertToBase64", "imagePath", "encodeBase64", "image", "Lcom/obric/memorydata/middleware/impl/image/ImageUploadEntity;", "upload", "images", "bizType", "Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;", "handleUploadCompletion", "pendingResults", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkAndFinalize", "getImageFromMediaLibraryById", "context", "Landroid/content/Context;", "entity", "deleteLocalFiles", "clear", "clearAll", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LruCache<String, List<ImageUploadResult>> f11713b = null;
    private static final Map<Integer, Integer> c = null;
    private static final Map<String, CountDownLatch> d = null;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.image.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/middleware/impl/image/GlobalSearchImageManager$handleUploadCompletion$1", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadCallback;", "onSuccess", "", "fileIndex", "", "imageUrl", "", "onFailure", "errorCode", "", "errorMessage", "onComplete", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0632a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<ImageUploadResult> f11714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<Integer> f11715b;
        final /* synthetic */ List<ImageUploadEntity> c;
        final /* synthetic */ String d;

        C0632a(ArrayList<ImageUploadResult> r3, List<Integer> r4, List<ImageUploadEntity> r5, String r6) {
            List<Integer> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<ImageUploadEntity> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            this.f11714a = r3;
            this.f11715b = r7;
            this.c = r8;
            this.d = r6;
        }

        @Override // com.obric.memorydata.middleware.impl.image.k
        public void a() {
        }

        @Override // com.obric.memorydata.middleware.impl.image.k
        public void a(int r4, long r5, String r7) {
            Intrinsics.checkNotNullParameter(r7, "errorMessage");
            ArrayList<ImageUploadResult> r6 = this.f11714a;
            List<Integer> r8 = this.f11715b;
            String r9 = this.d;
            List<ImageUploadEntity> r3 = this.c;
            monitor-enter(r6);
            int r10 = ((Number) ZeusTransformUtils.preCheckCast(r8.get(r4), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L7
            Integer r11 = Integer.valueOf(r10);     // Catch: Throwable -> L7
            a.a().put(r11, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(a.a().getOrDefault(Integer.valueOf(r10), 0), Number.class, "com.obric.memorydata.plugin")).intValue() + 1));     // Catch: Throwable -> L7
            a.a(a.f11712a, r9, r3, r6);     // Catch: Throwable -> L7
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r6);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.memorydata.middleware.impl.image.k
        public void a(int r7, String r8) {
            Intrinsics.checkNotNullParameter(r8, "imageUrl");
            ArrayList<ImageUploadResult> r0 = this.f11714a;
            List<Integer> r1 = this.f11715b;
            List<ImageUploadEntity> r2 = this.c;
            String r6 = this.d;
            monitor-enter(r0);
            int r9 = ((Number) ZeusTransformUtils.preCheckCast(r1.get(r7), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L7
            String r3 = ((ImageUploadEntity) ZeusTransformUtils.preCheckCast(r2.get(r9), ImageUploadEntity.class, "com.obric.memorydata.plugin")).getEntityId();     // Catch: Throwable -> L7
            r0.set(r9, new ImageUploadResult(((ImageUploadEntity) ZeusTransformUtils.preCheckCast(r2.get(r9), ImageUploadEntity.class, "com.obric.memorydata.plugin")).getEntityType(), r3, r8));     // Catch: Throwable -> L7
            a.a(a.f11712a, r6, r2, r0);     // Catch: Throwable -> L7
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/middleware/impl/image/GlobalSearchImageManager$upload$imageXUploadCallback$1", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadCallback;", "onSuccess", "", "fileIndex", "", "imageUrl", "", "onFailure", "errorCode", "", "errorMessage", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<ImageUploadResult> f11716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<ImageUploadEntity> f11717b;
        final /* synthetic */ Ref.IntRef c;
        final /* synthetic */ String d;
        final /* synthetic */ ImageXBizType e;

        b(ArrayList<ImageUploadResult> r3, List<ImageUploadEntity> r4, Ref.IntRef r5, String r6, ImageXBizType r7) {
            List<ImageUploadEntity> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f11716a = r3;
            this.f11717b = r8;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }

        @Override // com.obric.memorydata.middleware.impl.image.k
        public void a() {
            k.a.a(this);
        }

        @Override // com.obric.memorydata.middleware.impl.image.k
        public void a(int r12, long r13, String r15) {
            Intrinsics.checkNotNullParameter(r15, "errorMessage");
            RunLog.INSTANCE.debug("GlobalSearchImageManager", "Image upload failed, errorCode: " + r13 + ", errorMessage: " + r15);
            ArrayList<ImageUploadResult> r0 = this.f11716a;
            Ref.IntRef r1 = this.c;
            List<ImageUploadEntity> r2 = this.f11717b;
            String r3 = this.d;
            ImageXBizType r11 = this.e;
            monitor-enter(r0);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalSearchImageManager", "Failed to upload image at index " + r12 + ", error code is " + r13 + ", error message: " + r15, null, 4, null);     // Catch: Throwable -> L10
            a.a().put(Integer.valueOf(r12), Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(a.a().getOrDefault(Integer.valueOf(r12), 0), Number.class, "com.obric.memorydata.plugin")).intValue() + 1));     // Catch: Throwable -> L10
            r1.element++;     // Catch: Throwable -> L10
            if (r1.element != r2.size()) goto L7;
            a.a(a.f11712a, r3, r2, r0, r11);     // Catch: Throwable -> L10
        L7:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r0);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.memorydata.middleware.impl.image.k
        public void a(int r9, String r10) {
            Intrinsics.checkNotNullParameter(r10, "imageUrl");
            RunLog.INSTANCE.debug("GlobalSearchImageManager", "Image uploaded successfully, imageUrl: " + r10);
            ArrayList<ImageUploadResult> r0 = this.f11716a;
            List<ImageUploadEntity> r1 = this.f11717b;
            Ref.IntRef r2 = this.c;
            String r3 = this.d;
            ImageXBizType r8 = this.e;
            monitor-enter(r0);
            r0.set(r9, new ImageUploadResult(((ImageUploadEntity) ZeusTransformUtils.preCheckCast(r1.get(r9), ImageUploadEntity.class, "com.obric.memorydata.plugin")).getEntityType(), ((ImageUploadEntity) ZeusTransformUtils.preCheckCast(r1.get(r9), ImageUploadEntity.class, "com.obric.memorydata.plugin")).getEntityId(), r10));     // Catch: Throwable -> L10
            r2.element++;     // Catch: Throwable -> L10
            if (r2.element != r1.size()) goto L7;
            a.a(a.f11712a, r3, r1, r0, r8);     // Catch: Throwable -> L10
        L7:
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r0);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        f11712a = new a();
        f11713b = new LruCache(20);
        c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private a() {
    }

    private final String a(Context r9, ImageUploadEntity r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
    L37:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalSearchImageManager", "Failed to copy and compress image: " + e.getMessage(), null, 4, null);
    L39:
        return "";
    L4:
        if (Intrinsics.areEqual(r10.getPackageName(), AppContext.INSTANCE.getPackageName()) == false) goto L6;
    L30:
        Uri r12 = Uri.parse(r10.getUri());     // Catch: Exception -> L37
        if (r12 == null) goto L39;
        String r13 = r12.getPath();     // Catch: Exception -> L37
        if (r13 != null) goto L36;
        return "";
    L36:
        return r13;
    L6:
        if (Intrinsics.areEqual(r10.getPackageName(), BuildConfig.LIBRARY_PACKAGE_NAME) == true) goto L30;
        UriFileAccessSession r14 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new GlobalSearchImageManager$getImageFromMediaLibraryById$permission$1(r10, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "permission: " + r14);     // Catch: Exception -> L37
        AssetFileDescriptor r15 = r14.getFd();     // Catch: Exception -> L37
        if (r15 == null) goto L39;
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        AssetFileDescriptor r3 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r16, AssetFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        File r4 = new File(r11.getCacheDir(), "temp_" + System.currentTimeMillis() + ".jpg");     // Catch: Throwable -> L25
        BitmapFactory.Options r17 = new BitmapFactory.Options();     // Catch: Throwable -> L25
        r17.inJustDecodeBounds = true;     // Catch: Throwable -> L25
        BitmapFactory.decodeFileDescriptor(r3.getFileDescriptor(), null, r17);     // Catch: Throwable -> L25
        int r0 = RangesKt.coerceAtLeast(Math.min(r17.outWidth / 1080, r17.outHeight / 1080), 1);     // Catch: Throwable -> L25
        r17.inJustDecodeBounds = false;     // Catch: Throwable -> L25
        r17.inSampleSize = r0;     // Catch: Throwable -> L25
        Bitmap r18 = BitmapFactory.decodeFileDescriptor(r3.getFileDescriptor(), null, r17);     // Catch: Throwable -> L25
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r4), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        FileOutputStream r5 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r1, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r18 == null) goto L14;
        Boolean.valueOf(r18.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream) ZeusTransformUtils.preCheckCast(r5, OutputStream.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L20
    L14:
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L25
        if (r18 == null) goto L17;
        r18.recycle();     // Catch: Throwable -> L25
    L17:
        String r19 = r4.getAbsolutePath();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r19, "getAbsolutePath(...)");     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r16, null);     // Catch: Exception -> L37
        return r19;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Exception -> L37
        throw th;     // Catch: Exception -> L37
    }

    public static final /* synthetic */ Map a() {
        return c;
    }

    public static final /* synthetic */ void a(a r2, String r3, List r4, ArrayList r5) {
        r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    public static final /* synthetic */ void a(a r2, String r3, List r4, ArrayList r5, ImageXBizType r6) {
        r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    private final void a(String r5) {
        CountDownLatch r4 = (CountDownLatch) ZeusTransformUtils.preCheckCast(d.remove(r5), CountDownLatch.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "Upload complete lock for logId " + r5 + " not found");
        f11713b.remove(r5);
        return;
    L5:
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "Upload complete for logId " + r5);
        r4.countDown();
    }

    private final void a(String r8, List<ImageUploadEntity> r9, ArrayList<ImageUploadResult> r10) {
        List<ImageUploadEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<Integer, Integer>> r0 = c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r2.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (((Number) ZeusTransformUtils.preCheckCast(r2.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue() <= 3) goto L4;
        if (r10.get(r3) != null) goto L4;
        r10.set(r3, new ImageUploadResult(((ImageUploadEntity) ZeusTransformUtils.preCheckCast(r11.get(r3), ImageUploadEntity.class, "com.obric.memorydata.plugin")).getEntityType(), ((ImageUploadEntity) ZeusTransformUtils.preCheckCast(r11.get(r3), ImageUploadEntity.class, "com.obric.memorydata.plugin")).getEntityId(), ""));
        goto L4
    L10:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L13;
    L15:
        Iterator r5 = r1.iterator();
    L17:
        if (r5.hasNext() == false) goto L14;
        if (((ImageUploadResult) ZeusTransformUtils.preCheckCast(r5.next(), ImageUploadResult.class, "com.obric.memorydata.plugin")) == null) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L17;
    L23:
        if (r4 == false) goto L38;
        f11713b.put(r8, CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")));
        a(r8);
        a(r11);
        return;
    L38:
        return;
    L21:
        r6 = false;
    L14:
        r4 = true;
        goto L23
    L13:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
        goto L14
    }

    private final void a(String r9, List<ImageUploadEntity> r10, ArrayList<ImageUploadResult> r11, ImageXBizType r12) {
        List<ImageUploadEntity> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Map<Integer, Integer> r0 = c;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<Integer, Integer>> r1 = r0.entrySet().iterator();
    L3:
        boolean r4 = true;
        if (r1.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(r3.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue() <= 3) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L3;
        r2.put(r3.getKey(), r3.getValue());
        goto L3
    L11:
        List r5 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r8.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        r6.add((ImageUploadEntity) ZeusTransformUtils.preCheckCast(r13.get(((Number) ZeusTransformUtils.preCheckCast(r14.next(), Number.class, "com.obric.memorydata.plugin")).intValue()), ImageUploadEntity.class, "com.obric.memorydata.plugin"));
        goto L15
    L17:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        m r7 = new m((k) ZeusTransformUtils.preCheckCast(new C0632a(r11, r5, r13, r9), k.class, "com.obric.memorydata.plugin"));
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L19:
        if (r18.hasNext() == false) goto L21;
        r17.add(((ImageUploadEntity) ZeusTransformUtils.preCheckCast(r18.next(), ImageUploadEntity.class, "com.obric.memorydata.plugin")).getUri());
        goto L19
    L21:
        r7.a((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), r12);
        return;
    L22:
        a(r9, r13, r11);
    }

    private final void a(List<ImageUploadEntity> r10) {
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L15;
        ImageUploadEntity r11 = (ImageUploadEntity) ZeusTransformUtils.preCheckCast(r9.next(), ImageUploadEntity.class, "com.obric.memorydata.plugin");
        String r1 = r11.getTempFilePath();
        if (r1 == null) goto L4;
        if (r11.getNeedDelete() == false) goto L4;
        File r2 = new File(r1);     // Catch: Exception -> L13
        if (r2.exists() == false) goto L4;
        r2.delete();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalSearchImageManager", "Failed to delete local file: " + r11.getUri() + ", error: " + e.getMessage(), null, 4, null);
        goto L4
    }

    private final String b(String r5) {
        BitmapFactory.Options r4 = new BitmapFactory.Options();
        r4.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r5, r4);
        float r0 = r4.outWidth / 1280;
        float r1 = r4.outHeight / 720;
        if (r0 > r1) goto L6;
        r0 = r1;
    L6:
        r4.inJustDecodeBounds = false;
        r4.inSampleSize = (int) Math.ceil(r0);
        Bitmap r6 = BitmapFactory.decodeFile(r5, r4);
        ByteArrayOutputStream r7 = new ByteArrayOutputStream();
        r6.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream) ZeusTransformUtils.preCheckCast(r7, OutputStream.class, "com.obric.memorydata.plugin"));
        return Base64.getEncoder().encodeToString(r7.toByteArray());
    }

    public final String a(ImageUploadEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "image");
        String r0 = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        r4.setTempFilePath(r0);
        String r1 = b(r0);
        if (r4.getNeedDelete() == false) goto L5;
        a(CollectionsKt.listOf(r4));
    L5:
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "encodeBase64: " + r1);
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    }

    public final List<ImageUploadResult> a(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "logId");
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "Getting images for logId: " + r7);
        LruCache<String, List<ImageUploadResult>> r6 = f11713b;
        List<ImageUploadResult> r0 = (List) ZeusTransformUtils.preCheckCast(r6.get(r7), List.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map<String, CountDownLatch> r1 = d;
        CountDownLatch r2 = r1.get(r7);
        if (r2 != null) goto L8;
        r2 = new CountDownLatch(1);
        r1.put(r7, r2);
    L8:
        CountDownLatch r3 = (CountDownLatch) ZeusTransformUtils.preCheckCast(r2, CountDownLatch.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "Waiting for upload results...");     // Catch: Throwable -> L17 InterruptedException -> L19
        if (r3.await(r8, TimeUnit.MILLISECONDS) == false) goto L16;
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "get complete for logId " + r7);     // Catch: Throwable -> L17 InterruptedException -> L19
        List<ImageUploadResult> r9 = (List) ZeusTransformUtils.preCheckCast(r6.get(r7), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17 InterruptedException -> L19
        if (r9 != null) goto L14;
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L17 InterruptedException -> L19
    L14:
        r1.remove(r7);
        return r9;
    L16:
        r1.remove(r7);
    L22:
        return CollectionsKt.emptyList();
    L19:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalSearchImageManager", "Waiting for upload results was interrupted", null, 4, null);     // Catch: Throwable -> L17
        d.remove(r7);
    L17:
        th = move-exception;
        d.remove(r7);
        throw th;
    }

    public final void a(String r11, List<ImageUploadEntity> r12, ImageXBizType r13) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "logId");
        Intrinsics.checkNotNullParameter(r10, "images");
        Intrinsics.checkNotNullParameter(r13, "bizType");
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "Uploading images for logId: " + r11);
        ArrayList r2 = new ArrayList(r10.size());
        int r14 = r10.size();
        int r1 = 0;
    L3:
        if (r1 >= r14) goto L5;
        r2.add(null);
        r1 = r1 + 1;
        goto L3
    L5:
        c.clear();
        Map<String, CountDownLatch> r15 = d;
        if (r15.get(r11) != null) goto L8;
        r15.put(r11, new CountDownLatch(1));
    L8:
        b r16 = new b(r2, r10, new Ref.IntRef(), r11, r13);
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L10:
        if (r19.hasNext() == false) goto L12;
        ImageUploadEntity r3 = (ImageUploadEntity) ZeusTransformUtils.preCheckCast(r19.next(), ImageUploadEntity.class, "com.obric.memorydata.plugin");
        String r4 = f11712a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3);
        RunLog.INSTANCE.debug("GlobalSearchImageManager", "Image path: " + r4);
        r3.setTempFilePath(r4);
        r18.add(r4);
        goto L10
    L12:
        String[] r110 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r5 = r110.length;
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L21;
        String r7 = r110[r6];
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L20;
        r111.add(r7);
    L20:
        r6 = r6 + 1;
        goto L13
    L17:
        r8 = false;
        goto L18
    L21:
        new m((k) ZeusTransformUtils.preCheckCast(r16, k.class, "com.obric.memorydata.plugin")).a((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), r13);
    }
}
