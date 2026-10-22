package com.obric.memorydata.middleware.impl.image;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.w;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import com.ss.bduploader.UploadEventManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXUploader;", "", "uploadCallback", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadCallback;", "<init>", "(Lcom/obric/memorydata/middleware/impl/image/ImageXUploadCallback;)V", "uploadImages", "", "paths", "", "", "bizType", "Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;", "([Ljava/lang/String;Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;)V", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11745a = null;
    private static final al c = null;
    private static final h d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f11746b;

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0012J4\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0012J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0082@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J4\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0082@¢\u0006\u0002\u0010#J'\u0010$\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010'J)\u0010(\u001a\u0004\u0018\u00010\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010'J)\u0010)\u001a\u0004\u0018\u00010\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010*J)\u0010+\u001a\u0004\u0018\u00010\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010-J'\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u00101J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXUploader$Companion;", "", "<init>", "()V", "uploads", "Lkotlinx/coroutines/CoroutineScope;", "TAG", "", "DEFAULT_UPLOAD_DOMAIN", "JPEG_QUALITY", "", "uploadImageSync", "bizType", "Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;", "uri", "Landroid/net/Uri;", "sourcePackage", "resize", "(Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadCompressedImageSync", "uploadPath", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", "path", "cacheFile", "Ljava/io/File;", "(Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "singleImageUpload", "Lcom/obric/memorydata/middleware/impl/image/ImageXSingleImageUpload;", "singleImageListener", "Lcom/ss/bduploader/BDImageXUploaderListener;", "callback", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadCallback;", "writePrivilegedUriFileToCache", "context", "Landroid/content/Context;", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeAssetFileToCacheLegacy", "afd", "Landroid/content/res/AssetFileDescriptor;", "(Landroid/content/Context;Landroid/content/res/AssetFileDescriptor;Ljava/lang/Integer;)Ljava/io/File;", "writeAssetFileToCache", "writeUriFileToCacheByContentResolver", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/Integer;)Ljava/io/File;", "writeLocalFileToCache", "sourceFile", "(Landroid/content/Context;Ljava/io/File;Ljava/lang/Integer;)Ljava/io/File;", "calculateScale", "width", "height", "(IILjava/lang/Integer;)I", "writeBitmapToCache", "", "bitmap", "Landroid/graphics/Bitmap;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.image.m$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"com/obric/memorydata/middleware/impl/image/ImageXUploader$Companion$singleImageListener$1", "Lcom/ss/bduploader/BDImageXUploaderListener;", "onNotify", "", "what", "", "parameter", "", "info", "Lcom/ss/bduploader/BDImageXInfo;", "onLog", "code", "", "imageXUploadCheckNetState", "errorCode", "tryCount", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0634a implements BDImageXUploaderListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f11747a;

            C0634a(k r3) {
                this.f11747a = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
            }

            @Override // com.ss.bduploader.BDImageXUploaderListener
            public int imageXUploadCheckNetState(int r1, int r2) {
                return NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) ? 1 : 0;
            }

            @Override // com.ss.bduploader.BDImageXUploaderListener
            public void onLog(int r1, int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "info");
            }

            @Override // com.ss.bduploader.BDImageXUploaderListener
            public void onNotify(int r3, long r4, BDImageXInfo r6) {
                if (r3 != 0) goto L4;
                this.f11747a.a();
                return;
            L4:
                if (r3 != 2) goto L6;
            L20:
                k r2 = this.f11747a;
                if (r6 == null) goto L23;
                r4 = r6.mErrorCode;
            L23:
                r2.a(0, r4, "UPLOAD_SDK_FAILED");
                return;
            L6:
                if (r3 != 3) goto L8;
                this.f11747a.a(0, 0, "UPLOAD_CANCELLED");
                return;
            L8:
                if (r3 != 6) goto L10;
                k r5 = this.f11747a;
                if (r6 == null) goto L15;
                String r7 = r6.mImageTosKey;
            L16:
                if (r7 != null) goto L18;
                r7 = "";
            L18:
                r5.a(0, r7);
                return;
            L15:
                r7 = null;
                goto L16
            L10:
                if (r3 == 7) goto L20;
            }
        }

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/middleware/impl/image/ImageXUploader$Companion$uploadPath$result$3$1", "Lcom/obric/memorydata/middleware/impl/image/ImageXSingleImageHandle;", CommonConsts.APM_INNER_EVENT_COST_START, "", "callback", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadCallback;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, IslandSession.REOPEN_VALUE_CLOSE, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f11748a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ BDImageXUploader f11749b;
            final /* synthetic */ String c;
            final /* synthetic */ File d;

            b(i r1, BDImageXUploader r2, String r3, File r4) {
                this.f11748a = r1;
                this.f11749b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // com.obric.memorydata.middleware.impl.image.g
            public void a() {
                BDImageXUploader r0 = this.f11749b;
                if (r0 == null) goto L6;
                r0.cancelUpload();
                return;
            }

            @Override // com.obric.memorydata.middleware.impl.image.g
            public void a(k r8) {
                k r9 = (k) ZeusTransformUtils.wrapperContextForParams(r8, k.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r9, "callback");
                i r0 = this.f11748a;
                if (r0 == null) goto L24;
                BDImageXUploader r3 = this.f11749b;
                if (r3 == null) goto L24;
                String r1 = r0.f();
                String r4 = null;
                if (r1 != null) goto L10;
            L14:
                r1 = "imagex.bytedanceapi.com";
            L15:
                r3.setUploadDomain(r1);
                String r2 = this.f11748a.g();
                if (r2 != null) goto L18;
            L22:
                this.f11749b.setTopAccessKey(this.f11748a.a());
                this.f11749b.setTopSecretKey(this.f11748a.b());
                this.f11749b.setTopSessionToken(this.f11748a.c());
                this.f11749b.setServiceID(this.f11748a.e());
                this.f11749b.setFilePath(1, new String[]{this.c});
                this.f11749b.setListener(a.a(m.f11745a, r9));
                this.f11749b.start();
                return;
            L18:
                if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L20;
                r4 = r2;
            L20:
                if (r4 == null) goto L22;
                this.f11749b.setFilePrefix(r4);
                goto L22
            L10:
                if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
                r1 = null;
            L13:
                if (r1 != null) goto L15;
            L24:
                r9.a(0, 0, "UPLOAD_AUTH_FAILED");
            }

            @Override // com.obric.memorydata.middleware.impl.image.g
            public void b() {
                BDImageXUploader r0 = this.f11749b;     // Catch: Throwable -> L10
                if (r0 == null) goto L5;
                r0.close();     // Catch: Throwable -> L10
            L5:
                UploadEventManager.instance.popAllEvents();     // Catch: Throwable -> L10
                File r1 = this.d;
                if (r1 == null) goto L17;
                r1.delete();
                return;
            L17:
                return;
            L10:
                th = move-exception;
                File r2 = this.d;
                if (r2 == null) goto L14;
                r2.delete();
            L14:
                throw th;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final int a(int r2, int r3, Integer r4) {
            if (r4 != null) goto L5;
            return 1;
        L5:
            if (r4.intValue() > 0) goto L7;
            return 1;
        L7:
            return RangesKt.coerceAtLeast(Math.min(r2 / r4.intValue(), r3 / r4.intValue()), 1);
        }

        private static final g a(ImageXBizType r2, String r3, File r4) {
            UploadEventManager.instance.setUseEngineUploader(false);
            i r5 = com.obric.memorydata.middleware.impl.image.b.f11718a.a(r2);
            if (r5 == null) goto L5;
            BDImageXUploader r0 = new BDImageXUploader();
        L7:
            return (g) ZeusTransformUtils.preCheckCast(new b(r5, r0, r3, r4), g.class, "com.obric.memorydata.plugin");
        L5:
            r0 = null;
            goto L7
        }

        private final BDImageXUploaderListener a(k r2) {
            return (BDImageXUploaderListener) ZeusTransformUtils.preCheckCast(new C0634a((k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin")), BDImageXUploaderListener.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ BDImageXUploaderListener a(a r2, k r3) {
            return r2.a((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin"));
        }

        private final File a(Context r6, AssetFileDescriptor r7, Integer r8) {
            File r9 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "img_" + System.currentTimeMillis() + ".jpg");
            FileDescriptor r5 = r7.getFileDescriptor();
            BitmapFactory.Options r10 = new BitmapFactory.Options();
            r10.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(r5, null, r10);
            r10.inJustDecodeBounds = false;
            r10.inSampleSize = m.f11745a.a(r10.outWidth, r10.outHeight, r8);
            Bitmap r11 = BitmapFactory.decodeFileDescriptor(r5, null, r10);
            Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r9), Closeable.class, "com.obric.memorydata.plugin");
            FileOutputStream r13 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r12, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r11 == null) goto L6;
            Boolean.valueOf(r11.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream) ZeusTransformUtils.preCheckCast(r13, OutputStream.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
        L6:
            CloseableKt.closeFinally(r12, null);
            if (r11 == null) goto L9;
            r11.recycle();
        L9:
            return r9;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r12, th);
            throw th;
        }

        private final File a(Context r12, Uri r13, Integer r14) {
            Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            String r1 = r13.getPath();
            if (r13.getScheme() != null) goto L5;
        L25:
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L28;
        L31:
            boolean r2 = true;
        L32:
            if (r2 == false) goto L36;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageXUploader", "invalid local image uri: " + r13, null, 4, null);
            return null;
        L36:
            return a(r15, new File(r1), r14);
        L28:
            if (StringsKt.isBlank(r0) == true) goto L31;
            r2 = false;
            goto L32
        L5:
            if (Intrinsics.areEqual(r13.getScheme(), "file") == true) goto L25;
            AssetFileDescriptor r3 = r15.getContentResolver().openAssetFileDescriptor(r13, "r");     // Catch: Throwable -> L22
            if (r3 == null) goto L20;
            Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
            File r16 = m.f11745a.b(r15, (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r4, AssetFileDescriptor.class, "com.obric.memorydata.plugin"), r14);     // Catch: Throwable -> L15
            CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L22
            if (r16 == null) goto L20;
            return r16;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L22
            throw th;     // Catch: Throwable -> L22
        L20:
            a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageXUploader", "open uri " + r13 + " failed", null, 4, null);     // Catch: Throwable -> L22
            return null;
        L22:
            th = move-exception;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageXUploader", "open uri " + r13 + " failed: " + th.getMessage(), null, 4, null);
            return null;
        }

        private final File a(Context r10, File r11, Integer r12) {
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            if (r11.exists() == true) goto L7;
            IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r9 = new StringBuilder();
            String r14 = "local image file not found: ";
        L5:
            IRunLog.a.b(r3, "ImageXUploader", r9.append(r14).append(r11.getAbsolutePath()).toString(), null, 4, null);
            return null;
        L7:
            BitmapFactory.Options r0 = new BitmapFactory.Options();
            r0.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(r11.getAbsolutePath(), r0);
            r0.inJustDecodeBounds = false;
            r0.inSampleSize = m.f11745a.a(r0.outWidth, r0.outHeight, r12);
            Bitmap r15 = BitmapFactory.decodeFile(r11.getAbsolutePath(), r0);
            if (r15 != null) goto L10;
            a r16 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
            r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r9 = new StringBuilder();
            r14 = "decode local image failed: ";
            goto L5
        L10:
            File r17 = new File(r13.getCacheDir(), "img_" + System.currentTimeMillis() + ".jpg");
            a(r15, r17);
            r15.recycle();
            return r17;
        }

        private final Object a(Context r13, Uri r14, String r15, Integer r16, Continuation<? super File> r17) {
            a r0 = this;
            Uri r1 = r14;
            String r2 = r15;
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, ImageXUploader$Companion$writePrivilegedUriFileToCache$1.class) == false) goto L7;
            ImageXUploader$Companion$writePrivilegedUriFileToCache$1 r6 = (ImageXUploader$Companion$writePrivilegedUriFileToCache$1) ZeusTransformUtils.preCheckCast(r5, ImageXUploader$Companion$writePrivilegedUriFileToCache$1.class, "com.obric.memorydata.plugin");
            if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
            r6.label -= Integer.MIN_VALUE;
        L8:
            Object r7 = r6.result;
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r9 = r6.label;
            if (r9 == 0) goto L14;
            if (r9 != 1) goto L13;
            Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r6.L$4, Integer.class, "com.obric.memorydata.plugin");
            String r10 = (String) ZeusTransformUtils.preCheckCast(r6.L$3, String.class, "com.obric.memorydata.plugin");
            Uri r11 = (Uri) ZeusTransformUtils.preCheckCast(r6.L$2, Uri.class, "com.obric.memorydata.plugin");
            r3 = (Context) ZeusTransformUtils.preCheckCast(r6.L$1, Context.class, "com.obric.memorydata.plugin");
            a r12 = (a) ZeusTransformUtils.preCheckCast(r6.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r7);
            Integer r18 = r4;
            r0 = r12;
            r2 = r10;
            r1 = r11;
        L26:
            UriFileAccessSession r19 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r7, UriFileAccessSession.class, "com.obric.memorydata.plugin");
            AssetFileDescriptor r20 = r19.getFd();
            if (r20 != null) goto L31;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageXUploader", "access uri " + r1 + " failed, sourcePackage: " + r2 + ", status: " + r19.getStatus() + ", message: " + r19.getMessage(), null, 4, null);
            return null;
        L31:
            return r0.b(r3, r20, r18);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");
            if (r21 != null) goto L17;
        L20:
            boolean r22 = true;
        L21:
            if (r22 == false) goto L23;
            return null;
        L23:
            AtomicCapabilitySdk r23 = AtomicCapabilitySdk.INSTANCE;
            r6.L$0 = r0;
            r6.L$1 = r3;
            r6.L$2 = r1;
            r6.L$3 = r2;
            r18 = r16;
            r6.L$4 = r18;
            r6.label = 1;
            r7 = r23.openFileDescriptorPrivileged(r15, r14, r6);
            if (r7 != r8) goto L26;
            return r8;
        L17:
            if (StringsKt.isBlank(r21) == true) goto L20;
            r22 = false;
        L7:
            r6 = new ImageXUploader$Companion$writePrivilegedUriFileToCache$1(this, r5);
            goto L8
        }

        private final Object a(final ImageXBizType r7, final String r8, final File r9, Continuation<? super d> r10) {
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r11, ImageXUploader$Companion$uploadPath$1.class) == false) goto L7;
            ImageXUploader$Companion$uploadPath$1 r0 = (ImageXUploader$Companion$uploadPath$1) ZeusTransformUtils.preCheckCast(r11, ImageXUploader$Companion$uploadPath$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r6 = r0.result;
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            r9 = (File) ZeusTransformUtils.preCheckCast(r0.L$0, File.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);
        L17:
            d r13 = (d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(r13.c(), "UPLOAD_BUSY") == false) goto L21;
            if (r9 == null) goto L21;
            Boxing.boxBoolean(r9.delete());
        L21:
            return r13;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r6);
            final com.obric.memorydata.middleware.api.logging.e r14 = new com.obric.memorydata.middleware.api.logging.e("imagex_image", UUID.randomUUID().toString(), "image_upload");
            h r3 = m.a();
            Function2<? super String, ? super String, Unit> r4 = new $$Lambda$m$a$ao7_DzEQr1inI16iFN5YWBVI1dQ(r14);
            Function0<Unit> r15 = new $$Lambda$m$a$cINqEBHBuI7ccpLKO5sP7ts_EI(r9);
            Function0<? extends g> r5 = new $$Lambda$m$a$FJg_B_jU2pniKWk6Bm2_firuc_8(r7, r8, r9);
            r0.L$0 = r9;
            r0.label = 1;
            r6 = r3.a(r4, r15, r5, r0);
            if (r6 != r12) goto L17;
            return r12;
        L7:
            r0 = new ImageXUploader$Companion$uploadPath$1(this, r11);
            goto L8
        }

        public static final /* synthetic */ Object a(a r8, Context r9, Uri r10, String r11, Integer r12, Continuation r13) {
            return r8.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, ImageXBizType r3, String r4, File r5, Continuation r6) {
            return r2.a(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private static final Unit a(com.obric.memorydata.middleware.api.logging.e r9, final String r10, final String r11) {
            Intrinsics.checkNotNullParameter(r10, "event");
            Intrinsics.checkNotNullParameter(r11, "code");
            o.a((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin"), "图片上传状态", r10, r9, new $$Lambda$m$a$px64Bj7MHt86cG9fJ8uQMVACe8(r10, r11), null, 16, null);
            return Unit.INSTANCE;
        }

        private static final Unit a(File r0) {
            if (r0 == null) goto L5;
            r0.delete();
        L5:
            return Unit.INSTANCE;
        }

        private static final Unit a(String r1, String r2, com.obric.memorydata.middleware.api.logging.g r3) {
            Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
            r3.a("upload_event", r1);
            r3.a("upload_code", r2);
            return Unit.INSTANCE;
        }

        private final void a(Bitmap r5, File r6) {
            Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.memorydata.plugin");
            FileOutputStream r7 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r4, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            r5.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream) ZeusTransformUtils.preCheckCast(r7, OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
            CloseableKt.closeFinally(r4, null);
            return;
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            CloseableKt.closeFinally(r4, th);
            throw th;
        }

        private final File b(Context r10, AssetFileDescriptor r11, Integer r12) {
            File r0 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "img_" + System.currentTimeMillis() + ".jpg");
            FileDescriptor r13 = r11.getFileDescriptor();
            BitmapFactory.Options r14 = new BitmapFactory.Options();
            r14.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(r13, null, r14);
            r14.inJustDecodeBounds = false;
            r14.inSampleSize = m.f11745a.a(r14.outWidth, r14.outHeight, r12);
            Bitmap r15 = BitmapFactory.decodeFileDescriptor(r13, null, r14);
            if (r15 != null) goto L6;
            a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageXUploader", "decode image fd failed", null, 4, null);
            return null;
        L6:
            a(r15, r0);
            r15.recycle();
            return r0;
        }

        public static /* synthetic */ g lambda$FJg_B_jU2pniKWk6Bm2_firuc_8(ImageXBizType r0, String r1, File r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ Unit lambda$ao7_DzEQr1inI16iFN5YWBVI1dQ(com.obric.memorydata.middleware.api.logging.e r0, String r1, String r2) {
            return a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$cINqEBHBuI7ccpLKO5sP7t-s_EI, reason: not valid java name */
        public static /* synthetic */ Unit m1020lambda$cINqEBHBuI7ccpLKO5sP7ts_EI(File r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$px64Bj7MHt86cG9fJ8uQMVACe-8, reason: not valid java name */
        public static /* synthetic */ Unit m1021lambda$px64Bj7MHt86cG9fJ8uQMVACe8(String r0, String r1, com.obric.memorydata.middleware.api.logging.g r2) {
            return a(r0, r1, r2);
        }

        public final Object a(ImageXBizType r9, Uri r10, String r11, Integer r12, Continuation<? super String> r13) {
            Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r14, ImageXUploader$Companion$uploadImageSync$1.class) == false) goto L7;
            ImageXUploader$Companion$uploadImageSync$1 r0 = (ImageXUploader$Companion$uploadImageSync$1) ZeusTransformUtils.preCheckCast(r14, ImageXUploader$Companion$uploadImageSync$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r15 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r15);
        L34:
            return ((d) ZeusTransformUtils.preCheckCast(r15, d.class, "com.obric.memorydata.plugin")).a();
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            Context r8 = (Context) ZeusTransformUtils.preCheckCast(r0.L$4, Context.class, "com.obric.memorydata.plugin");
            r12 = (Integer) ZeusTransformUtils.preCheckCast(r0.L$3, Integer.class, "com.obric.memorydata.plugin");
            r10 = (Uri) ZeusTransformUtils.preCheckCast(r0.L$2, Uri.class, "com.obric.memorydata.plugin");
            r9 = (ImageXBizType) ZeusTransformUtils.preCheckCast(r0.L$1, ImageXBizType.class, "com.obric.memorydata.plugin");
            a r16 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
            Context r17 = r8;
            a this = r16;
            Object r18 = r15;
        L21:
            AssetFileDescriptor r19 = ((UriFileAccessSession) ZeusTransformUtils.preCheckCast(r18, UriFileAccessSession.class, "com.obric.memorydata.plugin")).getFd();
            if (r19 != null) goto L25;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageXUploader", "access uri " + r10 + " failed", null, 4, null);
            return null;
        L25:
            File r110 = this.a(r17, r19, r12);
            String r111 = r110.getAbsolutePath();
            Intrinsics.checkNotNull(r111);
        L30:
            r0.L$0 = null;
            r0.L$1 = null;
            r0.L$2 = null;
            r0.L$3 = null;
            r0.L$4 = null;
            r0.label = 2;
            r15 = this.a(r9, r111, r110, r0);
            if (r15 != r2) goto L34;
            return r2;
        L16:
            ResultKt.throwOnFailure(r15);
            r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L26;
            AtomicCapabilitySdk r4 = AtomicCapabilitySdk.INSTANCE;
            r0.L$0 = this;
            r0.L$1 = r9;
            r0.L$2 = r10;
            r0.L$3 = r12;
            r0.L$4 = r17;
            r0.label = 1;
            r18 = r4.openFileDescriptorPrivileged(r11, r10, r0);
            if (r18 != r2) goto L21;
            return r2;
        L26:
            r111 = r10.getPath();
            if (r111 != null) goto L29;
            return null;
        L29:
            r110 = null;
        L7:
            r0 = new ImageXUploader$Companion$uploadImageSync$1(this, r14);
            goto L8
        }

        public final Object b(ImageXBizType r14, Uri r15, String r16, Integer r17, Continuation<? super String> r18) {
            Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r0, ImageXUploader$Companion$uploadCompressedImageSync$1.class) == false) goto L7;
            ImageXUploader$Companion$uploadCompressedImageSync$1 r1 = (ImageXUploader$Companion$uploadCompressedImageSync$1) ZeusTransformUtils.preCheckCast(r0, ImageXUploader$Companion$uploadCompressedImageSync$1.class, "com.obric.memorydata.plugin");
            if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
            r1.label -= Integer.MIN_VALUE;
        L8:
            ImageXUploader$Companion$uploadCompressedImageSync$1 r8 = r1;
            Object r2 = r8.result;
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r8.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r2);
        L30:
            return ((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin")).a();
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ImageXBizType r4 = (ImageXBizType) ZeusTransformUtils.preCheckCast(r8.L$1, ImageXBizType.class, "com.obric.memorydata.plugin");
            a r5 = (a) ZeusTransformUtils.preCheckCast(r8.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r2);
            ImageXBizType r12 = r4;
        L22:
            File r6 = (File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L26;
            return null;
        L26:
            String r7 = r6.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(r7, "getAbsolutePath(...)");
            r8.L$0 = null;
            r8.L$1 = null;
            r8.label = 2;
            r2 = r5.a(r12, r7, r6, r8);
            if (r2 != r9) goto L30;
            return r9;
        L16:
            ResultKt.throwOnFailure(r2);
            Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            r6 = a(r10, r15, r17);
            if (r6 != null) goto L25;
            r8.L$0 = this;
            r12 = r14;
            r8.L$1 = r12;
            r8.label = 1;
            r2 = a(r10, r15, r16, r17, r8);
            if (r2 != r9) goto L21;
            return r9;
        L21:
            r5 = this;
            goto L22
        L25:
            r12 = r14;
            r5 = this;
        L7:
            r1 = new ImageXUploader$Companion$uploadCompressedImageSync$1(this, r0);
            goto L8
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f11745a = new a(null);
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        Object[] r1 = 0 == true ? 1 : 0;
        d = new h(r1, 1, 0 == true ? 1 : 0);
    }

    public m(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "uploadCallback");
        this.f11746b = r4;
    }

    public static final /* synthetic */ h a() {
        return d;
    }

    public static final /* synthetic */ k a(m r0) {
        return r0.f11746b;
    }

    public final void a(String[] r9, ImageXBizType r10) {
        Intrinsics.checkNotNullParameter(r9, "paths");
        Intrinsics.checkNotNullParameter(r10, "bizType");
        Object[] r11 = Arrays.copyOf(r9, r9.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(...)");
        String[] r12 = (String[]) ZeusTransformUtils.preCheckCast(r11, String[].class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ImageXUploader$uploadImages$1(r12, this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
