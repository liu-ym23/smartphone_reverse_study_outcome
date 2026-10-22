package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparable f1421c;
    public final Object d;

    public /* synthetic */ b(int r5, Comparable r10, Object r11) {
        this.f1419a = r5;
        this.d = r11;
        this.f1421c = r10;
    }

    private final void a() {
    }

    private final void f() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch(this.f1419a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        Object r5 = this.f1420b;
        if (r5 == null) goto L19;
        g(r5);     // Catch: IOException -> L13
        return;
    L20:
        return;
    L19:
        return;
    L8:
        Object r10 = this.f1420b;
        if (r10 == null) goto L21;
        g(r10);     // Catch: IOException -> L14
        return;
    L22:
        return;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int r5 = this.f1419a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource d() {
        switch(this.f1419a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return DataSource.LOCAL;
    L7:
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(Priority r5, d r10) {
        switch(this.f1419a) {
            case 0: goto L22;
            default: goto L20;
        };
    L20:
        Uri r11 = (Uri) this.f1421c;     // Catch: FileNotFoundException -> L6
        Object r12 = h((ContentResolver) this.d, r11);     // Catch: FileNotFoundException -> L6
        this.f1420b = r12;     // Catch: FileNotFoundException -> L6
        r10.f(r12);
        return;
    L6:
        e = move-exception;
        if (Log.isLoggable("LocalUriFetcher", 3) == false) goto L10;
        Log.d("LocalUriFetcher", "Failed to open Uri", e);
    L10:
        r10.a(e);
        return;
    L22:
        Object r13 = i((AssetManager) this.d, (String) this.f1421c);     // Catch: IOException -> L14
        this.f1420b = r13;     // Catch: IOException -> L14
        r10.f(r13);
        return;
    L14:
        e = move-exception;
        if (Log.isLoggable("AssetPathFetcher", 3) == false) goto L18;
        Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
    L18:
        r10.a(e);
    }

    public abstract void g(Object r5);

    public abstract Object h(ContentResolver r5, Uri r10);

    public abstract Object i(AssetManager r5, String r10);
}
