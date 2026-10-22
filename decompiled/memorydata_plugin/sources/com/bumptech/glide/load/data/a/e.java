package com.bumptech.glide.load.data.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f678a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f679b;
    private final d c;
    private final com.bumptech.glide.load.engine.bitmap_recycle.b d;
    private final ContentResolver e;
    private final List<ImageHeaderParser> f;

    static {
        f678a = new a();
    }

    e(List<ImageHeaderParser> r3, a r4, d r5, com.bumptech.glide.load.engine.bitmap_recycle.b r6, ContentResolver r7) {
        List<ImageHeaderParser> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r10 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this.f679b = r4;
        this.c = r9;
        this.d = r10;
        this.e = r7;
        this.f = r8;
    }

    e(List<ImageHeaderParser> r9, d r10, com.bumptech.glide.load.engine.bitmap_recycle.b r11, ContentResolver r12) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r11, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this(r3, f678a, r5, r6, r12);
    }

    private boolean a(File r3) {
        if (this.f679b.a(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (0 >= this.f679b.b(r3)) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    private String c(Uri r6) {
        ?? r1 = 0;
        Cursor r5 = this.c.query(r6);     // Catch: Throwable -> L16 SecurityException -> L18
        if (r5 != null) goto L33;
    L13:
        if (r5 == null) goto L15;
        r5.close();
    L15:
        return null;
    L33:
    L11:
        e = e;
    L22:
        if (Log.isLoggable("ThumbStreamOpener", 3) == false) goto L24;
        Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + r6, e);     // Catch: Throwable -> L27
    L24:
        if (r5 == null) goto L26;
        r5.close();
    L26:
        return null;
    L6:
        if (r5.moveToFirst() == false) goto L13;
        String r7 = r5.getString(0);     // Catch: SecurityException -> L11 Throwable -> L27
        if (r5 == null) goto L10;
        r5.close();
    L10:
        return r7;
    L27:
        th = th;
        r1 = this;
    L29:
        if (r1 == 0) goto L31;
        r1.close();
    L31:
        throw th;
    L18:
        e = e;
        r5 = null;
    L16:
        th = th;
        goto L29
    }

    int a(Uri r5) {
        InputStream r1 = null;
        r1 = this.e.openInputStream(r5);     // Catch: Throwable -> L7 Throwable -> L9
        int r4 = com.bumptech.glide.load.b.a(this.f, r1, this.d);     // Catch: Throwable -> L7 Throwable -> L9
        if (r1 != null) goto L24;
    L6:
        return r4;
    L24:
        r1.close();     // Catch: IOException -> L21
        goto L6
    L7:
        th = move-exception;
        if (r1 != null) goto L26;
    L20:
        throw th;
    L26:
        r1.close();     // Catch: IOException -> L22
    L9:
        e = move-exception;
        if (Log.isLoggable("ThumbStreamOpener", 3) == false) goto L14;
        Log.d("ThumbStreamOpener", "Failed to open uri: " + r5, e);     // Catch: Throwable -> L7
    L14:
        if (r1 == null) goto L32;
        r1.close();     // Catch: IOException -> L23
        return -1;
    L33:
        return -1;
    L32:
        return -1;
    }

    public InputStream b(Uri r5) {
        String r0 = c(r5);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        File r1 = this.f679b.a(r0);
        if (a(r1) == true) goto L8;
        return null;
    L8:
        Uri r2 = Uri.fromFile(r1);
        return this.e.openInputStream(r2);
    L11:
        e = move-exception;
        throw ((FileNotFoundException) ZeusTransformUtils.preCheckCast(new FileNotFoundException("NPE opening uri: " + r5 + " -> " + r2).initCause(e), FileNotFoundException.class, "com.obric.memorydata.plugin"));
    }
}
