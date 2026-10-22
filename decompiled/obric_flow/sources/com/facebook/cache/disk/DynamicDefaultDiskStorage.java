package com.facebook.cache.disk;

import android.util.Log;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicDefaultDiskStorage implements DiskStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Supplier f7636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7637c;
    public final Supplier d;
    public final String e;
    public final NoOpCacheErrorLogger f;
    public volatile State g;

    public static class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DefaultDiskStorage f7638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File f7639b;

        public State(File r5, DefaultDiskStorage r10) {
            this.f7638a = r10;
            this.f7639b = r5;
        }
    }

    public DynamicDefaultDiskStorage(int r5, Supplier r10, String r11, Supplier r12, String r13, NoOpCacheErrorLogger r14) {
        this.f7635a = r5;
        this.f = r14;
        this.f7636b = r10;
        this.f7637c = r11;
        this.d = r12;
        this.e = r13;
        this.g = new State(null, null);
    }

    public final synchronized DiskStorage a() {
        monitor-enter(this);
        State r5 = this.g;     // Catch: Throwable -> L10
        if (r5.f7638a == null) goto L13;
        File r10 = r5.f7639b;     // Catch: Throwable -> L10
        if (r10 == null) goto L13;
        if (r10.exists() == false) goto L13;
    L31:
        DefaultDiskStorage r11 = this.g.f7638a;     // Catch: Throwable -> L10
        r11.getClass();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r11;
    L13:
        if (this.g.f7638a != null) goto L15;
    L17:
        File r12 = new File((File) this.f7636b.get(), this.f7637c);     // Catch: Throwable -> L10
        File r13 = new File((File) this.d.get(), this.e);     // Catch: Throwable -> L10
        FileUtils.a(r12);     // Catch: Throwable -> L10 FileUtils.CreateDirectoryException -> L34
        String r14 = r12.getAbsolutePath();     // Catch: Throwable -> L10
        if (FLogDefaultLoggingDelegate.f7658a.a(3) == false) goto L42;
        Log.println(3, FLogDefaultLoggingDelegate.a("DynamicDefaultDiskStorage"), "Created cache directory " + r14);     // Catch: Throwable -> L10
    L42:
        FileUtils.a(r13);     // Catch: Throwable -> L10 FileUtils.CreateDirectoryException -> L24
    L27:
        String r15 = r13.getAbsolutePath();     // Catch: Throwable -> L10
        if (FLogDefaultLoggingDelegate.f7658a.a(3) == false) goto L30;
        Log.println(3, FLogDefaultLoggingDelegate.a("DynamicDefaultDiskStorage"), "Created config directory " + r15);     // Catch: Throwable -> L10
    L30:
        this.g = new State(r12, new DefaultDiskStorage(r12, r13, this.f7635a, this.f));     // Catch: Throwable -> L10
        goto L31
    L24:
        Object[] r16 = {r13.getAbsoluteFile()};     // Catch: Throwable -> L10
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L27;
        Log.println(6, FLogDefaultLoggingDelegate.a("DynamicDefaultDiskStorage"), String.format(null, "create config directory %s failed", r16));     // Catch: Throwable -> L10
        goto L27
    L34:
        e = move-exception;
        this.f.getClass();     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L15:
        if (this.g.f7639b == null) goto L17;
        FileTree.a(this.g.f7639b);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        return ((DefaultDiskStorage) a()).f7583b;
    L4:
        return false;
    }

    public final void c() {
        DefaultDiskStorage r5 = (DefaultDiskStorage) a();     // Catch: IOException -> L4
        FileTree.a(r5.f7582a, new DefaultDiskStorage.PurgingVisitor(r5));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L11;
        FLogDefaultLoggingDelegate.a(6, "DynamicDefaultDiskStorage", "purgeUnexpectedResources", e);
        return;
    }
}
