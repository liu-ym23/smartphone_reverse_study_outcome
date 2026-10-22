package com.obric.memorydata.memory.memoryentity.a;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.memorydata.memory.memoryentity.e;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.e.d;
import com.obric.memorydata.utils.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J8\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0013J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/util/MemoryImageUtils;", "", "<init>", "()V", "TAG", "", "MEMORY_IMAGE_PATH", "JPEG_MIME_TYPE", "saveUploadBitmap", "bitmap", "Landroid/graphics/Bitmap;", "resizeFactor", "", "quality", "", "deleteUploadImage", "", Params.FILE_PATH, "saveMemoryBitmap", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "sourceImageInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "(Landroid/graphics/Bitmap;Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;FILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOriginalJpegIfPossible", "imageFile", "Ljava/io/File;", "isJpeg", "", "deleteMemoryImage", "fileEntity", "getMemoryImagePath", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10310a = null;

    static {
        f10310a = new a();
    }

    private a() {
    }

    public static /* synthetic */ Object a(a r6, Bitmap r7, e r8, float r9, int r10, Continuation r11, int r12, Object r13) {
        Continuation<? super FileEntity> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        e r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = 1.0f;
    L8:
        float r3 = r9;
        if ((r12 & 8) == 0) goto L12;
        r10 = 100;
    L12:
        return r6.a(r7, r2, r3, r10, r5);
    }

    public static /* synthetic */ String a(a r0, Bitmap r1, float r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0.5f;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 100;
    L9:
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ String a(a r0, e r1, File r2) {
        return r0.a(r1, r2);
    }

    private final String a(e r13, File r14) {
        Object r1 = null;
        if (r13 != null) goto L5;
    L52:
        return null;
    L5:
        if (r13.i() == true) goto L52;
        if (a(r13) == false) goto L52;
        long r2 = SystemClock.elapsedRealtime();
        ContentResolver r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L12
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Object r15 = Result.m1421constructorimpl(Uri.parse(r13.a()));     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r15) == false) goto L17;
        r15 = null;
    L17:
        Uri r16 = (Uri) ZeusTransformUtils.preCheckCast(r15, Uri.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L59;
        return null;
    L59:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L41
        a r12 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        InputStream r17 = r4.openInputStream(r16);     // Catch: Throwable -> L41
        if (r17 == null) goto L38;
        Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(r17, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        InputStream r0 = (InputStream) ZeusTransformUtils.preCheckCast(r18, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r14), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        FileOutputStream r9 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r5, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        ByteStreamsKt.copyTo$default(r0, (OutputStream) ZeusTransformUtils.preCheckCast(r9, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L28
        r9.flush();     // Catch: Throwable -> L28
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L33
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryImageUtils", "save original jpeg for memory detail, size=" + r14.length() + ", cost=" + (SystemClock.elapsedRealtime() - r2) + "ms, uri=" + r16, false, 4, null);     // Catch: Throwable -> L33
        String r19 = r14.getAbsolutePath();     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L41
    L39:
        Object r110 = Result.m1421constructorimpl(r19);     // Catch: Throwable -> L41
    L44:
        if (Result.m1424exceptionOrNullimpl(r110) == null) goto L47;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryImageUtils", "save original jpeg failed, fallback to encode jpeg, uri=" + r16, null, 4, null);
    L47:
        if (Result.m1427isFailureimpl(r110) == true) goto L51;
        r1 = r110;
    L51:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L38:
        r19 = null;
    L41:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final boolean a(e r5) {
        String r4 = r5.e();
        if (r4 == null) goto L5;
        String r6 = r4.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "toLowerCase(...)");
    L7:
        if (Intrinsics.areEqual(r6, "image/jpeg") == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(r6, "image/jpg") == true) goto L20;
        String r7 = r5.a().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
        if (StringsKt.endsWith$default(r7, ".jpg", false, 2, null) == false) goto L14;
        return true;
    L14:
        if (StringsKt.endsWith$default(r7, ".jpeg", false, 2, null) == false) goto L17;
        return true;
    L17:
        return false;
    L20:
        return true;
    L5:
        r6 = null;
        goto L7
    }

    private static final String b(Bitmap r5, float r6, int r7) {
        File r0 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "MemoryImage");
        boolean r1 = r0.exists();
        if (r1 == true) goto L6;
        r1 = r0.mkdirs();
    L6:
        if (r1 == false) goto L11;
        long r3 = System.currentTimeMillis();
        File r4 = new File(r0, d.f13218a.a(r3));
        x r2 = x.f13267a;
        String r8 = r4.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r8, "getAbsolutePath(...)");
        String r9 = r2.a(r5, r8, r6, r7);
        if (com.obric.memorydata.utils.b.b(r9) == true) goto L10;
        return null;
    L10:
        return r9;
    L11:
        return null;
    }

    private static final Unit b(FileEntity r4) {
        File r1 = new File(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "MemoryImage"), r4.getFileName());
        if (r1.exists() == false) goto L6;
        r1.delete();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit b(String r2) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L14;
        File r3 = new File(r2);
        if (r3.exists() == false) goto L14;
        r3.delete();
    L14:
        return Unit.INSTANCE;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static /* synthetic */ String lambda$I2PSxWjgglgGndGiQQBCK2r_OAI(Bitmap r0, float r1, int r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$J6pFnhK9BtczHIMxkfmdYCGEA-8, reason: not valid java name */
    public static /* synthetic */ Unit m739lambda$J6pFnhK9BtczHIMxkfmdYCGEA8(FileEntity r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$ub8S0XN8jlqlY1Lb8OY-eQQP5oY, reason: not valid java name */
    public static /* synthetic */ Unit m740lambda$ub8S0XN8jlqlY1Lb8OYeQQP5oY(String r0) {
        return b(r0);
    }

    public final Object a(Bitmap r22, e r23, float r24, int r25, Continuation<? super FileEntity> r26) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        o r2 = new o(IntrinsicsKt.intercepted(r0), 1);
        r2.e();
        n r3 = (n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.memorydata.plugin");
        File r4 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "MemoryImage");
        boolean r5 = r4.exists();
        if (r5 == true) goto L6;
        r5 = r4.mkdirs();
    L6:
        if (r5 == false) goto L13;
        long r7 = System.currentTimeMillis();
        File r9 = new File(r4, d.f13218a.a(r7));
        String r6 = a(f10310a, r23, r9);
        if (r6 != null) goto L11;
        x r8 = x.f13267a;
        String r10 = r9.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r10, "getAbsolutePath(...)");
        r6 = r8.a(r22, r10, r24, r25);
    L11:
        if (com.obric.memorydata.utils.b.b(r6) == false) goto L13;
        long r13 = System.currentTimeMillis();
        File r11 = new File(r6);
        String r12 = String.valueOf(r7);
        String r15 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "getName(...)");
        FileEntity r14 = new FileEntity(r12, r13, r13, r15, r11.length(), x.f13267a.a(r11), FileTypeEnum.FILE, "image/jpeg");
        Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.m1421constructorimpl(r14);
    L14:
        r1.resumeWith(r17);
        Object r18 = r2.h();
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L17:
        return r18;
    L13:
        r1 = (Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r19 = Result.Companion;
        r17 = Result.m1421constructorimpl(null);
        goto L14
    }

    public final String a(final Bitmap r1, final float r2, final int r3) {
        Intrinsics.checkNotNullParameter(r1, "bitmap");
        return (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.d.a(new $$Lambda$a$I2PSxWjgglgGndGiQQBCK2r_OAI(r1, r2, r3)), String.class, "com.obric.memorydata.plugin");
    }

    public final void a(final FileEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "fileEntity");
        com.obric.memorydata.sdk.d.a(new $$Lambda$a$J6pFnhK9BtczHIMxkfmdYCGEA8(r1));
    }

    public final void a(final String r1) {
        com.obric.memorydata.sdk.d.a(new $$Lambda$a$ub8S0XN8jlqlY1Lb8OYeQQP5oY(r1));
    }
}
