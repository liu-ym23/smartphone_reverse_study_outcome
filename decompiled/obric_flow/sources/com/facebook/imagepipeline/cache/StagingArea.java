package com.facebook.imagepipeline.cache;

import android.util.Log;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class StagingArea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f8040a;

    public StagingArea() {
        this.f8040a = new HashMap();
    }

    public final synchronized EncodedImage a(SimpleCacheKey r10) {
        monitor-enter(this);
        EncodedImage r5 = (EncodedImage) this.f8040a.get(r10);     // Catch: Throwable -> L23
        if (r5 == null) goto L25;
        monitor-enter(r5);     // Catch: Throwable -> L23
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L7:
        if (EncodedImage.c(r5) == true) goto L17;
        this.f8040a.remove(r10);     // Catch: Throwable -> L11
        int r11 = System.identityHashCode(r5);     // Catch: Throwable -> L11
        String r12 = r10.f7579a;     // Catch: Throwable -> L11
        int r13 = System.identityHashCode(r10);     // Catch: Throwable -> L11
        if (FLogDefaultLoggingDelegate.f7658a.a(5) == false) goto L13;
        Log.println(5, FLogDefaultLoggingDelegate.a("StagingArea"), "Found closed reference " + r11 + " for key " + r12 + " (" + r13 + ")");     // Catch: Throwable -> L11
    L13:
        monitor-exit(r5);     // Catch: Throwable -> L11
        monitor-exit(this);
        return null;
    L17:
        EncodedImage r14 = EncodedImage.a(r5);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r14;
    L25:
        monitor-exit(this);
        return r5;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void a() {
        monitor-enter(this);
        FLog.a(StagingArea.class, "Count = %d", Integer.valueOf(this.f8040a.size()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(SimpleCacheKey r5, EncodedImage r10) {
        monitor-enter(this);
        r10.getClass();     // Catch: Throwable -> L12
        if (EncodedImage.c(r10) == false) goto L38;
        EncodedImage r11 = (EncodedImage) this.f8040a.get(r5);     // Catch: Throwable -> L12
        if (r11 != null) goto L9;
        monitor-exit(this);
        return;
    L9:
        CloseableReference r12 = r11.f8177a;     // Catch: Throwable -> L12
        CloseableReference r13 = null;
        if (r12 == null) goto L14;
        CloseableReference r14 = r12.b();     // Catch: Throwable -> L12
    L15:
        CloseableReference r15 = r10.f8177a;     // Catch: Throwable -> L12
        if (r15 == null) goto L18;
        r13 = r15.b();     // Catch: Throwable -> L12
    L18:
        if (r14 == null) goto L30;
        if (r13 == null) goto L30;
    L27:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L12
        r14.close();     // Catch: Throwable -> L12
        r11.close();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L21:
        if (r14.c() != r13.c()) goto L30;
        this.f8040a.remove(r5);     // Catch: Throwable -> L27
        r13.close();     // Catch: Throwable -> L12
        r14.close();     // Catch: Throwable -> L12
        r11.close();     // Catch: Throwable -> L12
        a();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L30:
        if (r13 == null) goto L32;
        r13.close();     // Catch: Throwable -> L12
    L32:
        if (r14 == null) goto L34;
        r14.close();     // Catch: Throwable -> L12
    L34:
        r11.close();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L14:
        r14 = null;
        goto L15
    L38:
        throw new IllegalArgumentException();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
