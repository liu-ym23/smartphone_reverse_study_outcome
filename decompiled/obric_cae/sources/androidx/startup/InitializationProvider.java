package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Trace;
import d1.a;
import d1.c;

/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    public InitializationProvider() {
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r8, String r10, String[] r11) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r8) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r8, ContentValues r10) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r8 = getContext();
        if (r8 == null) goto L19;
        if (r8.getApplicationContext() == null) goto L16;
        a r10 = a.c(r8);
        Context r11 = r10.f6749c;
        Trace.beginSection("Startup");     // Catch: Throwable -> L9 PackageManager.NameNotFoundException -> L11
        ComponentName r12 = new ComponentName(r11.getPackageName(), InitializationProvider.class.getName());     // Catch: Throwable -> L9 PackageManager.NameNotFoundException -> L11
        r10.a(r11.getPackageManager().getProviderInfo(r12, 128).metaData);     // Catch: Throwable -> L9 PackageManager.NameNotFoundException -> L11
        Trace.endSection();
        return true;
    L9:
        th = move-exception;
        Trace.endSection();
        throw th;
    L11:
        e = move-exception;
        throw new c(e);     // Catch: Throwable -> L9
    L16:
        return true;
    L19:
        throw new c();
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r8, String[] r10, String r11, String[] r12, String r13) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        throw new IllegalStateException("Not allowed.");
    }
}
