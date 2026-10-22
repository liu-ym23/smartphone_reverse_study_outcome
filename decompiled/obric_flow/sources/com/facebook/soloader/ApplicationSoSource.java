package com.facebook.soloader;

import android.content.Context;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationSoSource extends SoSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DirectorySoSource f8460b;

    public ApplicationSoSource(Context r5, int r10) {
        Context r11 = r5.getApplicationContext();
        this.f8459a = r11;
        if (r11 != null) goto L5;
        Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.ApplicationSoSource fallbacks to: " + r5.getApplicationInfo().nativeLibraryDir);
        this.f8459a = r5;
    L5:
        this.f8460b = new DirectorySoSource(new File(this.f8459a.getApplicationInfo().nativeLibraryDir), r10);
    }

    @Override // com.facebook.soloader.SoSource
    public final void a(int r5) {
        this.f8460b.getClass();
    }

    public final String toString() {
        return this.f8460b.toString();
    }
}
