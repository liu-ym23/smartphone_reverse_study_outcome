package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    public static final String[] d = null;
    public static final String[] e = null;
    public static final Rect f = null;
    public static final Rect g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContentResolver f8333c;

    static {
        d = new String[]{"_id", "_data"};
        e = new String[]{"_data"};
        f = new Rect(0, 0, 512, 384);
        g = new Rect(0, 0, 96, 96);
    }

    public LocalContentUriThumbnailFetchProducer(ExecutorService r5, PooledByteBufferFactory r10, ContentResolver r11) {
        super(r5, r10);
        this.f8333c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public final boolean a(ResizeOptions r5) {
        Rect r10 = f;
        return ThumbnailSizeChecker.a(r10.width(), r10.height(), r5);
    }

    public final EncodedImage a(ResizeOptions r5, long r10) {
        Rect r11 = g;
        if (ThumbnailSizeChecker.a(r11.width(), r11.height(), r5) == false) goto L5;
        int r12 = 3;
    L10:
        if (r12 != 0) goto L12;
        return null;
    L12:
        Cursor r13 = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.f8333c, r10, r12, e);
        if (r13 != null) goto L32;
        return null;
    L32:
    L26:
        th = move-exception;
        r13.close();
        throw th;
    L16:
        if (r13.moveToFirst() == false) goto L28;
        String r14 = r13.getString(r13.getColumnIndex("_data"));     // Catch: Throwable -> L26
        if (new File(r14).exists() == false) goto L28;
        FileInputStream r15 = new FileInputStream(r14);     // Catch: Throwable -> L26
        if (r14 != null) goto L22;
        int r16 = -1;
    L23:
        EncodedImage r17 = a(r15, r16);     // Catch: Throwable -> L26
        r13.close();
        return r17;
    L22:
        r16 = (int) new File(r14).length();     // Catch: Throwable -> L26
    L28:
        r13.close();
        return null;
    L5:
        Rect r18 = f;
        if (ThumbnailSizeChecker.a(r18.width(), r18.height(), r5) == false) goto L8;
        r12 = 1;
        goto L10
    L8:
        r12 = 0;
        goto L10
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String a() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer, com.facebook.imagepipeline.producers.LocalFetchProducer] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.content.ContentResolver] */
    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage a(ImageRequest r10) {
        ?? r5 = r10.f8415b;
        Uri r11 = UriUtil.f7699a;
        String r12 = r5.toString();
        ?? r13 = 0;
        EncodedImage r14 = null;
        r14 = null;
        if (r12.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) == false) goto L5;
    L8:
        ResizeOptions r15 = r10.g;
        Rect r16 = g;
        if (ThumbnailSizeChecker.a(r16.width(), r16.height(), r15) == true) goto L75;
        Rect r17 = f;
        if (ThumbnailSizeChecker.a(r17.width(), r17.height(), r15) == true) goto L75;
        return null;
    L75:
        Bundle r18 = new Bundle();     // Catch: Throwable -> L35 Exception -> L37 IOException -> L39 FileNotFoundException -> L41
        r18.putParcelable("android.content.extra.SIZE", new Point(r15.f8051a, r15.f8052b));     // Catch: Throwable -> L35 Exception -> L37 IOException -> L39 FileNotFoundException -> L41
        r5 = new FileInputStream(this.f8333c.openTypedAssetFile(r5, "image/*", r18, null).getFileDescriptor());     // Catch: Throwable -> L35 Exception -> L37 IOException -> L39 FileNotFoundException -> L41
    L84:
        int r19 = r5.available();     // Catch: Throwable -> L27 Exception -> L29 IOException -> L31 FileNotFoundException -> L33
        if (r19 > 0) goto L21;
        r5.close();     // Catch: Throwable -> L27 Exception -> L29 IOException -> L31 FileNotFoundException -> L33
        r5.close();     // Catch: IOException -> L19
        return null;
    L19:
        IOException e4 = e;
    L26:
        FLog.a(LocalContentUriThumbnailFetchProducer.class, e4.getMessage());
    L63:
        return r14;
    L21:
        EncodedImage r20 = a(r5, r19);     // Catch: Throwable -> L27 Exception -> L29 IOException -> L31 FileNotFoundException -> L33
        r5.close();     // Catch: Throwable -> L27 Exception -> L29 IOException -> L31 FileNotFoundException -> L33
        r5.close();     // Catch: IOException -> L24
        return r20;
    L24:
        e = move-exception;
        r14 = r20;
        e4 = e;
    L33:
        e = e;
    L58:
        FLog.a(LocalContentUriThumbnailFetchProducer.class, e.getMessage());     // Catch: Throwable -> L50
        if (r5 == 0) goto L77;
        r5.close();     // Catch: IOException -> L48
        r5 = r5;
    L74:
    L77:
    L31:
        e = e;
    L53:
        FLog.a(LocalContentUriThumbnailFetchProducer.class, e.getMessage());     // Catch: Throwable -> L50
        if (r5 == 0) goto L77;
        r5.close();     // Catch: IOException -> L48
        r5 = r5;
    L29:
        e = e;
    L44:
        FLog.a(LocalContentUriThumbnailFetchProducer.class, e.getMessage());     // Catch: Throwable -> L50
        if (r5 == 0) goto L77;
        r5.close();     // Catch: IOException -> L48
        r5 = r5;
    L27:
        th = th;
    L65:
        if (r5 != 0) goto L81;
    L70:
        throw th;
    L81:
        r5.close();     // Catch: IOException -> L68
    L68:
        e = move-exception;
        FLog.a(LocalContentUriThumbnailFetchProducer.class, e.getMessage());
    L48:
        e = move-exception;
        FLog.a(LocalContentUriThumbnailFetchProducer.class, e.getMessage());
    L50:
        th = th;
        r13 = r5;
    L64:
        r5 = r13;
    L41:
        e = e;
        r5 = 0;
    L39:
        e = e;
        r5 = 0;
    L37:
        e = e;
        r5 = 0;
    L35:
        th = th;
        goto L64
    L5:
        if (r12.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()) == true) goto L8;
        return null;
    }
}
