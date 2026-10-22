package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f8344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f8345b;

    public LocalVideoThumbnailProducer(ExecutorService r5, ContentResolver r10) {
        this.f8344a = r5;
        this.f8345b = r10;
    }

    public static String a(LocalVideoThumbnailProducer r11, ImageRequest r12) {
        r11.getClass();
        Uri r5 = r12.f8415b;
        Uri r10 = UriUtil.f7699a;
        if (r5 != null) goto L5;
        String r13 = null;
    L7:
        if ("file".equals(r13) == false) goto L21;
        monitor-enter(r12);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (r12.d != null) goto L14;
        r12.d = new File(r12.f8415b.getPath());     // Catch: Throwable -> L12
    L14:
        File r14 = r12.d;     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return r14.getPath();
    L21:
        if (UriUtil.a(r5) == true) goto L23;
    L38:
        return null;
    L23:
        if ("com.android.providers.media.documents".equals(r5.getAuthority()) == false) goto L25;
        String r15 = DocumentsContract.getDocumentId(r5);
        Uri r16 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String r17 = "_id=?";
        String[] r18 = {r15.split(":")[1]};
    L26:
        Cursor r19 = r11.f8345b.query(r16, new String[]{"_data"}, r17, r18, null);
        if (r19 != null) goto L39;
    L36:
        if (r19 == null) goto L38;
        r19.close();
        goto L38
    L39:
    L33:
        th = move-exception;
        r19.close();
        throw th;
    L29:
        if (r19.moveToFirst() == false) goto L36;
        String r110 = r19.getString(r19.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L33
        r19.close();
        return r110;
    L25:
        r16 = r5;
        r17 = null;
        r18 = null;
        goto L26
    L5:
        r13 = r5.getScheme();
        goto L7
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(final Consumer r11, final ProducerContext r12) {
        BaseProducerContext r5 = (BaseProducerContext) r12;
        final InternalRequestListener r10 = r5.f8259c;
        final ImageRequest r13 = r5.f8257a;
        r5.a("local", "video");
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> r14 = new AnonymousClass2(this, r11, r10, r12, r10, r12, r13);
        r5.a(new AnonymousClass3(r14));
        this.f8344a.execute(r14);
    }
}
