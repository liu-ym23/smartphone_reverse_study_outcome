package com.obric.memorydata.personalcontext.index;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper;
import com.obric.memorydata.personalcontext.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bH\u0016J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/index/EntityVideoExtractHelper;", "Lcom/obric/memorydata/personalcontext/api/IEntityVideoExtractHelper;", "<init>", "()V", "getInst", "IMAGE_INDEX_TEMP", "", "VIDEO_EXTRACT_MAX_DURATION", "", "VIDEO_CLIP_MAX_COUNT", "", "extractFrame", "Landroid/net/Uri;", ObricMemoryConstants.KEY_PACKAGE_NAME, "video", "timestampMs", "getTempImageFileUri", "file", "Ljava/io/File;", "saveBitmapAsFile", "bitmap", "Landroid/graphics/Bitmap;", "deleteTempPicPath", "", "uri", "calculateVideoClip", "", "fileString", "intervalParam", "getVideoDuration", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityVideoExtractHelper implements IEntityVideoExtractHelper {
    private static final String IMAGE_INDEX_TEMP = "ImageIndexTemp";
    public static final EntityVideoExtractHelper INSTANCE = null;
    private static final int VIDEO_CLIP_MAX_COUNT = 30;
    private static final long VIDEO_EXTRACT_MAX_DURATION = 60000;

    static {
        INSTANCE = new EntityVideoExtractHelper();
    }

    private EntityVideoExtractHelper() {
    }

    @JvmStatic
    public static final EntityVideoExtractHelper getInst() {
        return INSTANCE;
    }

    private final Uri getTempImageFileUri(File r7) {
        Uri r8 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.fileprovider", r7, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).grantUriPermission("com.obric.aikernel", r8, 3);     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        e.printStackTrace();
        IRunLog.a.b(r0, "EntityIndexHelper", Unit.INSTANCE.toString(), null, 4, null);
        return null;
    }

    private final String saveBitmapAsFile(Bitmap r8) {
        String r7 = "frame_" + System.currentTimeMillis() + ".jpg";
        File r1 = new File(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), Environment.DIRECTORY_PICTURES), IMAGE_INDEX_TEMP);
        if (r1.exists() == true) goto L5;
        r1.mkdirs();
    L5:
        File r0 = new File(r1, r7);
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r0), Closeable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L16
        r8.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r9, FileOutputStream.class, "com.obric.memorydata.plugin"), OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r9, null);     // Catch: IOException -> L16
        String r10 = r0.getAbsolutePath();     // Catch: IOException -> L16
        Intrinsics.checkNotNull(r10);     // Catch: IOException -> L16
        return r10;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: IOException -> L16
        throw th;     // Catch: IOException -> L16
    L16:
        e = move-exception;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        e.printStackTrace();
        IRunLog.a.b(r2, "EntityIndexHelper", Unit.INSTANCE.toString(), null, 4, null);
        return "";
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper
    public List<Long> calculateVideoClip(String r16, Uri r17, long r18) {
        Intrinsics.checkNotNullParameter(r16, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r17, "video");
        MediaMetadataRetriever r2 = new MediaMetadataRetriever();
        List<Long> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        AssetFileDescriptor r0 = ((UriFileAccessSession) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityVideoExtractHelper$calculateVideoClip$permission$1(r16, r17, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), UriFileAccessSession.class, "com.obric.memorydata.plugin")).getFd();     // Catch: Throwable -> L37 RuntimeException -> L39
        if (r0 != null) goto L8;
        EntityVideoExtractHelper r1 = (EntityVideoExtractHelper) ZeusTransformUtils.preCheckCast(this, EntityVideoExtractHelper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37 RuntimeException -> L39
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "calculateVideoClip skipped: file descriptor is null", null, 4, null);     // Catch: Throwable -> L37 RuntimeException -> L39
        List<Long> r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L37 RuntimeException -> L39
        r2.release();
        return r4;
    L8:
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37 RuntimeException -> L39
        AssetFileDescriptor r6 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r5, AssetFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        long r7 = r6.getParcelFileDescriptor().getStatSize();     // Catch: Throwable -> L30
        long r9 = 0;
        if (r7 != 0) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "calculateVideoClip skipped: size=" + r7, null, 4, null);     // Catch: Throwable -> L30
        List<Long> r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L37 RuntimeException -> L39
        r2.release();
        return r8;
    L15:
        r2.setDataSource(r6.getFileDescriptor());     // Catch: Throwable -> L30
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L37 RuntimeException -> L39
        String r11 = r2.extractMetadata(9);     // Catch: Throwable -> L37 RuntimeException -> L39
        if (r11 == null) goto L19;
        long r12 = Long.parseLong(r11);     // Catch: Throwable -> L37 RuntimeException -> L39
    L21:
        if (r12 < 60000) goto L23;
        long r13 = r12 / ((long) 30);     // Catch: Throwable -> L37 RuntimeException -> L39
    L25:
        if (r9 >= r12) goto L27;
        r3.add(Long.valueOf(r9));     // Catch: Throwable -> L37 RuntimeException -> L39
        r9 = r9 + r13;     // Catch: Throwable -> L37 RuntimeException -> L39
        goto L25
    L27:
        if (r9 == r12) goto L41;
        r3.add(Long.valueOf(r12));     // Catch: Throwable -> L37 RuntimeException -> L39
    L41:
        r2.release();
        return r3;
    L23:
        r13 = r18;
        goto L25
    L19:
        r12 = 0;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L37 RuntimeException -> L39
        throw th;     // Catch: Throwable -> L37 RuntimeException -> L39
    L39:
        e = move-exception;
        RunLog.INSTANCE.error("EntityIndexHelper", "calculateVideoClip failed: exception=" + e.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r2.release();
        throw th;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper
    public List<Long> calculateVideoClip(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "fileString");
        return calculateVideoClip(r2, f.b(r3).getContentUrl(), r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper
    public void deleteTempPicPath(Uri r8) {
        Intrinsics.checkNotNullParameter(r8, "uri");
        String r7 = r8.getPath();
        if (r7 == null) goto L8;
        String r9 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.last(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"/"}, false, 0, 6, null)), String.class, "com.obric.memorydata.plugin");
        File r10 = new File(new File(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), Environment.DIRECTORY_PICTURES), IMAGE_INDEX_TEMP), r9);
        if (r10.exists() == false) goto L9;
        r10.delete();
        return;
    L9:
        return;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityVideoExtractHelper
    public Uri extractFrame(String r12, Uri r13, long r14) {
        Intrinsics.checkNotNullParameter(r12, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r13, "video");
        MediaMetadataRetriever r1 = new MediaMetadataRetriever();
        Uri r2 = null;
        AssetFileDescriptor r15 = ((UriFileAccessSession) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityVideoExtractHelper$extractFrame$permission$1(r12, r13, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), UriFileAccessSession.class, "com.obric.memorydata.plugin")).getFd();     // Catch: Throwable -> L25 RuntimeException -> L27
        if (r15 != null) goto L8;
        EntityVideoExtractHelper r11 = (EntityVideoExtractHelper) ZeusTransformUtils.preCheckCast(this, EntityVideoExtractHelper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25 RuntimeException -> L27
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "extractFrame skipped: file descriptor is null", null, 4, null);     // Catch: Throwable -> L25 RuntimeException -> L27
        r1.release();
        return null;
    L8:
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25 RuntimeException -> L27
        AssetFileDescriptor r17 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r16, AssetFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        long r3 = r17.getParcelFileDescriptor().getStatSize();     // Catch: Throwable -> L20
        if (r3 != 0) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "extractFrame skipped: size=" + r3, null, 4, null);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L25 RuntimeException -> L27
        r1.release();
        return null;
    L15:
        r1.setDataSource(r17.getFileDescriptor());     // Catch: Throwable -> L20
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L25 RuntimeException -> L27
        Bitmap r19 = r1.getFrameAtTime(r14 * ((long) 1000));     // Catch: Throwable -> L25 RuntimeException -> L27
        if (r19 != null) goto L19;
    L29:
        r1.release();
        return r2;
    L19:
        r2 = getTempImageFileUri(new File(saveBitmapAsFile(r19)));     // Catch: Throwable -> L25 RuntimeException -> L27
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L25 RuntimeException -> L27
        throw th;     // Catch: Throwable -> L25 RuntimeException -> L27
    L27:
        e = move-exception;
        RunLog.INSTANCE.error("EntityIndexHelper", "extractFrame failed: exception=" + e.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r1.release();
        throw th;
    }

    public final long getVideoDuration(String r17, Uri r18) {
        Intrinsics.checkNotNullParameter(r17, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r18, "video");
        MediaMetadataRetriever r3 = new MediaMetadataRetriever();
        long r4 = 0;
        AssetFileDescriptor r0 = ((UriFileAccessSession) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityVideoExtractHelper$getVideoDuration$permission$1(r17, r18, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), UriFileAccessSession.class, "com.obric.memorydata.plugin")).getFd();     // Catch: Throwable -> L27 RuntimeException -> L29
        if (r0 != null) goto L8;
        EntityVideoExtractHelper r1 = (EntityVideoExtractHelper) ZeusTransformUtils.preCheckCast(this, EntityVideoExtractHelper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27 RuntimeException -> L29
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "getVideoDuration skipped: file descriptor is null", null, 4, null);     // Catch: Throwable -> L27 RuntimeException -> L29
        r3.release();
        return 0;
    L8:
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27 RuntimeException -> L29
        AssetFileDescriptor r5 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r2, AssetFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        long r8 = r5.getParcelFileDescriptor().getStatSize();     // Catch: Throwable -> L20
        if (r8 != 0) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "getVideoDuration skipped: size=" + r8, null, 4, null);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L27 RuntimeException -> L29
        r3.release();
        return 0;
    L15:
        r3.setDataSource(r5.getFileDescriptor());     // Catch: Throwable -> L20
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L27 RuntimeException -> L29
        String r7 = r3.extractMetadata(9);     // Catch: Throwable -> L27 RuntimeException -> L29
        if (r7 == null) goto L31;
        r4 = Long.parseLong(r7);     // Catch: Throwable -> L27 RuntimeException -> L29
    L31:
        r3.release();
        return r4;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L27 RuntimeException -> L29
        throw th;     // Catch: Throwable -> L27 RuntimeException -> L29
    L27:
        th = move-exception;
        r3.release();
        throw th;
    L29:
        e = move-exception;
        RunLog.INSTANCE.error("EntityIndexHelper", "getVideoDuration failed: exception=" + e.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L31
    }
}
