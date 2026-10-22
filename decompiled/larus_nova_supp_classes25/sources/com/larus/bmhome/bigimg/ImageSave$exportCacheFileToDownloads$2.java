package com.larus.bmhome.bigimg;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$exportCacheFileToDownloads$2", f = "ImageSave.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ImageSave$exportCacheFileToDownloads$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ String $cacheFilePath;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $subDirName;
    private /* synthetic */ Object L$0;
    int label;

    public ImageSave$exportCacheFileToDownloads$2(String r1, String r2, String r3, Context r4, Continuation<? super ImageSave$exportCacheFileToDownloads$2> r5) {
        this.$cacheFilePath = r1;
        this.$fileName = r2;
        this.$subDirName = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ImageSave$exportCacheFileToDownloads$2 r6 = new ImageSave$exportCacheFileToDownloads$2(this.$cacheFilePath, this.$fileName, this.$subDirName, this.$context, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Uri> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L80;
        ResultKt.throwOnFailure(r14);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        String r16 = this.$cacheFilePath;
        String r1 = this.$fileName;
        String r2 = this.$subDirName;
        Context r3 = this.$context;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L73
        PolarisFileWrapper r6 = new PolarisFileWrapper(r16);     // Catch: Throwable -> L73
        if (r6.exists() == true) goto L10;
        FLogger.a.w("ImageSave", "exportCacheFileToDownloads cacheFile not exist: " + r16);     // Catch: Throwable -> L73
        return null;
    L10:
        if (r1 != null) goto L12;
    L16:
        r1 = r6.getName();     // Catch: Throwable -> L73
    L17:
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L73
        if ((!StringsKt.isBlank(r1)) == true) goto L21;
        r1 = null;
    L21:
        if (r1 != null) goto L24;
        r1 = r2 + '_' + System.currentTimeMillis();     // Catch: Throwable -> L73
    L24:
        if (Build.VERSION.SDK_INT < 29) goto L26;
        ContentResolver r0 = r3.getApplicationContext().getContentResolver();     // Catch: Throwable -> L73
        String r4 = URLConnection.guessContentTypeFromName(r1);     // Catch: Throwable -> L73
        if (r4 != null) goto L43;
        BitmapFactory.Options r7 = new BitmapFactory.Options();     // Catch: Throwable -> L73
        r7.inJustDecodeBounds = true;     // Catch: Throwable -> L73
        BitmapFactory.decodeFile(r6.getAbsolutePath(), r7);     // Catch: Throwable -> L73
        r4 = r7.outMimeType;     // Catch: Throwable -> L73
        if (r4 != null) goto L38;
    L40:
        r4 = null;
    L41:
        if (r4 != null) goto L43;
        r4 = "application/octet-stream";
        goto L43
    L38:
        if ((true ^ StringsKt.isBlank(r4)) == false) goto L40;
    L43:
        ContentValues r17 = new ContentValues();     // Catch: Throwable -> L73
        r17.put("_display_name", r1);     // Catch: Throwable -> L73
        r17.put("title", r1);     // Catch: Throwable -> L73
        r17.put("mime_type", r4);     // Catch: Throwable -> L73
        r17.put("relative_path", Environment.DIRECTORY_DOWNLOADS + '/' + r2);     // Catch: Throwable -> L73
        Object r18 = Result.constructor-impl(a(r0, MediaStore.Downloads.EXTERNAL_CONTENT_URI, r17));     // Catch: Throwable -> L46
    L49:
        if (Result.isFailure-impl(r18) == false) goto L51;
        r18 = null;
    L51:
        Uri r19 = (Uri) r18;     // Catch: Throwable -> L73
        if (r19 != null) goto L54;
        return null;
    L54:
        OutputStream r8 = ContentResolverWrapper.openOutputStream(r0, r19);     // Catch: Throwable -> L73
        if (r8 != null) goto L83;
        return null;
    L83:
        PolarisFileInputStreamWrapper r9 = new PolarisFileInputStreamWrapper(r6);     // Catch: Throwable -> L67
        ByteStreamsKt.copyTo$default(r9, r8, 0, 2, null);     // Catch: Throwable -> L62
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L67
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L73
        return r19;
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L67
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        throw th;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L73
        throw th;     // Catch: Throwable -> L73
    L46:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L73
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L73
        goto L49
    L26:
        if (ContextCompat.checkSelfPermission(r3, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L28;
        return null;
    L28:
        PolarisFileWrapper r11 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), r2);     // Catch: Throwable -> L73
        if (r11.exists() == true) goto L31;
        r11.mkdirs();     // Catch: Throwable -> L73
    L31:
        PolarisFileWrapper r12 = ImageSave.b(ImageSave.a, r11, r1);     // Catch: Throwable -> L73
        FilesKt.copyTo$default(r6, r12, false, 0, 4, null);     // Catch: Throwable -> L73
        MediaScannerConnection.scanFile(r3.getApplicationContext(), new String[]{r12.getAbsolutePath()}, null, null);     // Catch: Throwable -> L73
        return i1.c(r3, r12);
    L12:
        if ((!StringsKt.isBlank(r1)) == true) goto L15;
        r1 = null;
    L15:
        if (r1 != null) goto L17;
    L73:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Object r110 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r110) == false) goto L78;
        return null;
    L78:
        return r110;
    L80:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static Uri a(ContentResolver r18, Uri r19, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
