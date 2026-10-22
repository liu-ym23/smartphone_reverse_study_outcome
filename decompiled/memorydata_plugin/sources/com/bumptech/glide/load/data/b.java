package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f681b;
    private T c;

    public b(AssetManager r1, String r2) {
        this.f681b = r1;
        this.f680a = r2;
    }

    public abstract T a(AssetManager r1, String r2);

    @Override // com.bumptech.glide.load.data.d
    public void a(Priority r2, d.a<? super T> r3) {
        d.a r4 = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.memorydata.plugin");
        T r5 = a(this.f681b, this.f680a);     // Catch: IOException -> L5
        this.c = r5;     // Catch: IOException -> L5
        r4.a(r5);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable("AssetPathFetcher", 3) == false) goto L9;
        Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
    L9:
        r4.a(e);
    }

    public abstract void a(T r1);

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        a(r0);     // Catch: IOException -> L7
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
