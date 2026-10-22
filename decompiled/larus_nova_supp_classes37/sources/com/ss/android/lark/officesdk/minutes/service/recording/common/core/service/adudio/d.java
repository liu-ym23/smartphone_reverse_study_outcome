package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public d(b r1, String r2, long r3, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void a() {
        b r5 = this.a;
        String r6 = this.b;
        long r7 = this.c;
        long r9 = this.d;
        monitor-enter(r5);
        VFSFile r11 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r6);     // Catch: Throwable -> L15
        if (r11.exists() == true) goto L7;
    L12:
        lvb.a.b("MmAudioCacheCleanupUtil", "Error: Cache directory does not exist or is not a valid directory: ".concat(r6));     // Catch: Throwable -> L15
        monitor-exit(r5);
        return;
    L7:
        if (r11.isDirectory() == false) goto L12;
        lvb.a.e("MmAudioCacheCleanupUtil", "Starting cache cleanup for directory: ".concat(r6));     // Catch: Throwable -> L15
        lvb.a.e("MmAudioCacheCleanupUtil", "Policy 1: Delete files older than " + r7 + " days.");     // Catch: Throwable -> L15
        lvb.a.e("MmAudioCacheCleanupUtil", "Policy 2: If directory size exceeds " + r9 + " MB, clean oldest files.");     // Catch: Throwable -> L15
        b.a(r5, r11, r7);     // Catch: Throwable -> L15
        b.b(r5, r11, r9 * 1048576);     // Catch: Throwable -> L15
        lvb.a.e("MmAudioCacheCleanupUtil", "Cache directory cleanup finished: ".concat(r6));     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r5);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
