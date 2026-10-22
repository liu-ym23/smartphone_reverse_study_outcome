package com.bumptech.glide.load.data.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.g;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f673b;
    private InputStream c;

    static class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f674b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f675a;

        static {
            f674b = new String[]{"_data"};
        }

        a(ContentResolver r1) {
            this.f675a = r1;
        }

        @Override // com.bumptech.glide.load.data.a.d
        public Cursor query(Uri r8) {
            String r9 = r8.getLastPathSegment();
            return ZeusProviderTransform.query(this.f675a, MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f674b, "kind = 1 AND image_id = ?", new String[]{r9}, null, "com.obric.memorydata.plugin");
        }
    }

    static class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f676b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f677a;

        static {
            f676b = new String[]{"_data"};
        }

        b(ContentResolver r1) {
            this.f677a = r1;
        }

        @Override // com.bumptech.glide.load.data.a.d
        public Cursor query(Uri r8) {
            String r9 = r8.getLastPathSegment();
            return ZeusProviderTransform.query(this.f677a, MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f676b, "kind = 1 AND video_id = ?", new String[]{r9}, null, "com.obric.memorydata.plugin");
        }
    }

    c(Uri r1, e r2) {
        this.f672a = r1;
        this.f673b = r2;
    }

    public static c a(Context r2, Uri r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return a(r4, r3, new a(r4.getContentResolver()));
    }

    private static c a(Context r3, Uri r4, d r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r0 = com.bumptech.glide.c.a(r6).b();
        return new c(r4, new e(com.bumptech.glide.c.a(r6).g().a(), r7, r0, r6.getContentResolver()));
    }

    public static c b(Context r2, Uri r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return a(r4, r3, new b(r4.getContentResolver()));
    }

    private InputStream e() {
        InputStream r0 = this.f673b.b(this.f672a);
        if (r0 == null) goto L5;
        int r3 = this.f673b.a(this.f672a);
    L6:
        if (r3 != (-1)) goto L8;
        return r0;
    L8:
        return new g(r0, r3);
    L5:
        r3 = -1;
        goto L6
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void a(Priority r2, com.bumptech.glide.load.data.d.a<? super InputStream> r3) {
        com.bumptech.glide.load.data.d.a r4 = (com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin");
        InputStream r5 = e();     // Catch: FileNotFoundException -> L5
        this.c = r5;     // Catch: FileNotFoundException -> L5
        r4.a(r5);     // Catch: FileNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable("MediaStoreThumbFetcher", 3) == false) goto L9;
        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
    L9:
        r4.a(e);
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream r0 = this.c;
        if (r0 == null) goto L9;
        r0.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bumptech.glide.load.data.d
    public void c() {
    }

    @Override // com.bumptech.glide.load.data.d
    public DataSource d() {
        return DataSource.LOCAL;
    }
}
