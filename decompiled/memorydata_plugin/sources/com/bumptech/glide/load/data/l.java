package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentResolver f694b;
    private T c;

    public l(ContentResolver r1, Uri r2) {
        this.f694b = r1;
        this.f693a = r2;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void a(Priority r2, d.a<? super T> r3) {
        d.a r4 = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.memorydata.plugin");
        T r5 = b(this.f693a, this.f694b);     // Catch: FileNotFoundException -> L5
        this.c = r5;     // Catch: FileNotFoundException -> L5
        r4.a(r5);     // Catch: FileNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable("LocalUriFetcher", 3) == false) goto L9;
        Log.d("LocalUriFetcher", "Failed to open Uri", e);
    L9:
        r4.a(e);
    }

    public abstract void a(T r1);

    public abstract T b(Uri r1, ContentResolver r2);

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T r0 = this.c;
        if (r0 == null) goto L9;
        a(r0);     // Catch: IOException -> L6
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
