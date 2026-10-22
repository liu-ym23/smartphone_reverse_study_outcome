package com.facebook.imagepipeline.producers;

import ai.j0;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static final String[] d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContentResolver f8332c;

    static {
        d = new String[]{"_id", "_data"};
    }

    public LocalContentUriFetchProducer(ExecutorService r5, PooledByteBufferFactory r10, ContentResolver r11) {
        super(r5, r10);
        this.f8332c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String a() {
        return "LocalContentUriFetchProducer";
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage a(ImageRequest r10) {
        Uri r11 = r10.f8415b;
        if (UriUtil.a(r11) == true) goto L5;
    L24:
        String r5 = r11.toString();
        if (r5.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) == false) goto L27;
    L28:
        Cursor r12 = this.f8332c.query(r11, d, null, null, null);
        EncodedImage r13 = null;
        if (r12 != null) goto L49;
    L42:
        if (r13 == null) goto L45;
        return r13;
    L45:
        return a(this.f8332c.openInputStream(r11), -1);
    L49:
    L38:
        th = move-exception;
        r12.close();
        throw th;
    L32:
        if (r12.getCount() == 0) goto L41;
        r12.moveToFirst();     // Catch: Throwable -> L38 FileNotFoundException -> L46
        String r14 = r12.getString(r12.getColumnIndex("_data"));     // Catch: Throwable -> L38 FileNotFoundException -> L46
        if (r14 == null) goto L37;
        r13 = a(new FileInputStream(this.f8332c.openFileDescriptor(r11, "r").getFileDescriptor()), (int) new File(r14).length());     // Catch: Throwable -> L38 FileNotFoundException -> L46
    L37:
        r12.close();
    L41:
        r12.close();
        goto L42
    L27:
        if (r5.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()) == false) goto L45;
    L5:
        if ("com.android.contacts".equals(r11.getAuthority()) == false) goto L24;
        if (r11.getPath().startsWith(UriUtil.f7699a.getPath()) == true) goto L24;
        if (r11.toString().endsWith("/photo") == false) goto L12;
        InputStream r15 = this.f8332c.openInputStream(r11);
    L21:
        return a(r15, -1);
    L12:
        if (r11.toString().endsWith("/display_photo") == true) goto L47;
        InputStream r16 = ContactsContract.Contacts.openContactPhotoInputStream(this.f8332c, r11);
        if (r16 == null) goto L23;
        r15 = r16;
        goto L21
    L23:
        throw new IOException(j0.i(r11, "Contact photo does not exist: "));
    L47:
        r15 = this.f8332c.openAssetFileDescriptor(r11, "r").createInputStream();     // Catch: IOException -> L15
    L16:
        throw new IOException(j0.i(r11, "Contact photo does not exist: "));
    }
}
