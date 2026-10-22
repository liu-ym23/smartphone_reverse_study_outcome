package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final b a;
    public final d b;
    public final Set<String> c;

    public final synchronized void a(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "taskId");     // Catch: Throwable -> L12
        if (this.c.remove(r2) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.c.isEmpty() == false) goto L10;
        this.b.release();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public c(b r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.a = r2;
        this.b = r3;
        this.c = new LinkedHashSet();
    }

    public final synchronized void b(String r2, MmRecordingSource r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "taskId");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r3, "source");     // Catch: Throwable -> L15
        if (this.a.a.contains(r3) == true) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.c.add(r2) == false) goto L13;
        if (this.c.size() != 1) goto L11;
        this.b.a(r3);     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
