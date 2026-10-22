package com.obric.memorydata.database.util.file_utils;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.memorydata.database.entity.ft;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0004J\b\u0010\u001f\u001a\u00020 H\u0004J\b\u0010!\u001a\u00020\u001eH\u0004J>\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020 H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020 H\u0084@¢\u0006\u0002\u0010-J*\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u000201H\u0094@¢\u0006\u0002\u00102J \u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\nH\u0014J \u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0014J \u0010;\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020\u001bH\u0014R\u0012\u0010\u0005\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@TX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006>"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor;", "Lcom/obric/memorydata/database/util/file_utils/IDocumentImageProcessor;", "Lcom/obric/memorydata/database/util/file_utils/IFileProcessor;", "<init>", "()V", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "autoIncrementIndex", "", "processedImageCount", EventBody.KEY_VALUE, "maxImageCount", "getMaxImageCount", "()I", "setMaxImageCount", "(I)V", "imageStorageDir", "Ljava/io/File;", "getImageStorageDir", "()Ljava/io/File;", "imageStorageDir$delegate", "Lkotlin/Lazy;", "process", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetImageCounters", "", "canProcessMoreImages", "", "incrementProcessedImageCount", "processImage", "imageBytes", "", "imageInfo", "Lcom/obric/memorydata/database/util/file_utils/DocumentImageInfo;", "tree", "parentId", "docFileEntity", "useAutoIncrement", "([BLcom/obric/memorydata/database/util/file_utils/DocumentImageInfo;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureStorageDir", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveImageFile", "fileName", "maxSizeBytes", "", "([BLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateImageFileName", "format", "docEntityId", "index", "createFileEntity", "file", "entityId", "mimeType", "createPhotoEntity", "Lcom/obric/memorydata/database/entity/AbstractRawPhotoEntity;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class b implements n, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9638b;
    private int c;
    private int d;
    private final Lazy e;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor$Companion;", "", "<init>", "()V", "DEFAULT_IMAGE_STORAGE_DIR", "", "DEFAULT_SAVE_IMAGE_MAX_SIZE", "", "DEFAULT_MAX_IMAGE_COUNT", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9637a = new a(null);
    }

    public b() {
        this.d = 100;
        this.e = LazyKt.lazy(new $$Lambda$b$afs6yImXaOB_hO4n971bgcECnyU(this));
    }

    private static final File a(b r4) {
        File r0 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "DocumentImages/" + r4.j().getValue());
        RunLog.INSTANCE.debug(r4.a(), r4.j().getValue() + " image storage path: " + r0.getAbsolutePath());
        return r0;
    }

    static /* synthetic */ Object a(b r1, FileEntity r2, Continuation<? super j> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        r1.d();
        return null;
    }

    static /* synthetic */ Object a(b r16, byte[] r17, i r18, j r19, int r20, FileEntity r21, boolean r22, Continuation<? super Boolean> r23) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, BaseDocumentImageProcessor$processImage$1.class) == false) goto L7;
        BaseDocumentImageProcessor$processImage$1 r2 = (BaseDocumentImageProcessor$processImage$1) ZeusTransformUtils.preCheckCast(r1, BaseDocumentImageProcessor$processImage$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        BaseDocumentImageProcessor$processImage$1 r6 = r2;
        Object r3 = r6.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r6.label;
        boolean r11 = false;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        int r0 = r6.I$0;
        FileEntity r5 = (FileEntity) ZeusTransformUtils.preCheckCast(r6.L$3, FileEntity.class, "com.obric.memorydata.plugin");
        j r7 = (j) ZeusTransformUtils.preCheckCast(r6.L$2, j.class, "com.obric.memorydata.plugin");
        i r8 = (i) ZeusTransformUtils.preCheckCast(r6.L$1, i.class, "com.obric.memorydata.plugin");
        b r9 = (b) ZeusTransformUtils.preCheckCast(r6.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        FileEntity r15 = r5;
        j r14 = r7;
        i r13 = r8;
    L25:
        File r12 = (File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L28;
        String r24 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r13.a());     // Catch: Exception -> L34
        if (r24 != null) goto L32;
        r24 = "image/" + r13.a();     // Catch: Exception -> L34
    L32:
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r9.a(r9.a(r12, FilesKt.getNameWithoutExtension(r12), r24), r13, r15), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);     // Catch: Exception -> L34
        j.a(r14, NodeType.IMAGE, q.f9661a.a(new q(String.valueOf(r13.b()), null, 2, null)), 0, Boxing.boxInt(r0), 4, null);     // Catch: Exception -> L34
        r9.f();     // Catch: Exception -> L34
        r11 = true;
    L37:
        return Boxing.boxBoolean(r11);
    L34:
        e = move-exception;
        RunLog.INSTANCE.error(r9.a(), "Failed to process image", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L37
    L28:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        if (r16.e() == true) goto L18;
        RunLog.INSTANCE.debug(r16.a(), "The maximum number of image resolutions for a single document has been reached: " + r16.c + '/' + r16.b());
        return Boxing.boxBoolean(false);
    L18:
        if (r22 == false) goto L20;
        int r25 = r16.f9638b;
        r16.f9638b = r25 + 1;
    L21:
        String r26 = r16.a(r18.a(), r21.getId(), r25);
        r6.L$0 = r16;
        r13 = r18;
        r6.L$1 = r13;
        r14 = r19;
        r6.L$2 = r14;
        r15 = r21;
        r6.L$3 = r15;
        r6.I$0 = r20;
        r6.label = 1;
        r3 = a(r16, r17, r26, 0, r6, 4, null);
        if (r3 != r10) goto L24;
        return r10;
    L24:
        r9 = r16;
        r0 = r20;
        goto L25
    L20:
        r25 = r18.b();
    L7:
        r2 = new BaseDocumentImageProcessor$processImage$1(r16, r1);
        goto L8
    }

    static /* synthetic */ Object a(b r10, byte[] r11, String r12, long r13, Continuation<? super File> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new BaseDocumentImageProcessor$saveImageFile$2(r10, r11, r13, r12, null), Function2.class, "com.obric.memorydata.plugin"), r16);
    }

    public static /* synthetic */ Object a(b r6, byte[] r7, String r8, long r9, Continuation r11, int r12, Object r13) {
        Continuation<? super File> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L10;
        if ((r12 & 4) == 0) goto L8;
        r9 = 5242880;
    L8:
        return r6.a(r7, r8, r9, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveImageFile");
    }

    public static /* synthetic */ File lambda$afs6yImXaOB_hO4n971bgcECnyU(b r0) {
        return a(r0);
    }

    public FileEntity a(File r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "file");
        Intrinsics.checkNotNullParameter(r14, "entityId");
        Intrinsics.checkNotNullParameter(r15, "mimeType");
        long r2 = System.currentTimeMillis();
        long r4 = System.currentTimeMillis();
        String r6 = r13.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "getName(...)");
        long r7 = r13.length();
        Uri r9 = Uri.fromFile(r13);
        Intrinsics.checkNotNullExpressionValue(r9, "fromFile(...)");
        return new FileEntity(r14, r2, r4, r6, r7, r9, FileTypeEnum.FILE, r15);
    }

    public com.obric.memorydata.database.entity.g a(FileEntity r27, i r28, FileEntity r29) {
        Intrinsics.checkNotNullParameter(r27, "fileEntity");
        Intrinsics.checkNotNullParameter(r28, "imageInfo");
        Intrinsics.checkNotNullParameter(r29, "docFileEntity");
        String r6 = r27.getId();
        long r7 = r27.getCreateTime();
        long r9 = r27.getLastModifiedTime();
        long r12 = System.currentTimeMillis();
        String r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
        Intrinsics.checkNotNullExpressionValue(r4, "getPackageName(...)");
        String r17 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r27, AppEntity.class, "com.obric.memorydata.plugin"));
        int r21 = r29.getType();
        String r22 = r29.getId();
        return (com.obric.memorydata.database.entity.g) ZeusTransformUtils.preCheckCast(new ft(0, r6, r7, r9, NetError.ERR_UNSAFE_REDIRECT, r12, r4, 0, null, r17, "PHOTO", null, null, r21, r22, "resFiles", 257, null), com.obric.memorydata.database.entity.g.class, "com.obric.memorydata.plugin");
    }

    public Object a(FileEntity r3, Continuation<? super j> r4) {
        return a(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object a(Continuation<? super Boolean> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new BaseDocumentImageProcessor$ensureStorageDir$2(this, null), Function2.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.obric.memorydata.database.util.file_utils.n
    public Object a(byte[] r9, i r10, j r11, int r12, FileEntity r13, boolean r14, Continuation<? super Boolean> r15) {
        return a(this, r9, r10, r11, r12, r13, r14, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public Object a(byte[] r7, String r8, long r9, Continuation<? super File> r11) {
        return a(this, r7, r8, r9, (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public abstract String a();

    public String a(String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "format");
        Intrinsics.checkNotNullParameter(r5, "docEntityId");
        return "img_" + j().getValue() + '_' + System.currentTimeMillis() + '_' + r5 + '_' + r6 + '.' + r4;
    }

    public void a(int r2) {
        this.d = RangesKt.coerceAtLeast(r2, 0);
    }

    public int b() {
        return this.d;
    }

    public File c() {
        return (File) ZeusTransformUtils.preCheckCast(this.e.getValue(), File.class, "com.obric.memorydata.plugin");
    }

    public final void d() {
        this.c = 0;
        this.f9638b = 0;
    }

    public final boolean e() {
        if (this.c >= b()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f() {
        this.c++;
    }
}
