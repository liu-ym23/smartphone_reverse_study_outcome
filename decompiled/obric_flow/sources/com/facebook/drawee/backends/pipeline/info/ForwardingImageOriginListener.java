package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class ForwardingImageOriginListener implements ImageOriginListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7746a;

    public ForwardingImageOriginListener(ImageOriginListener... r5) {
        ArrayList r10 = new ArrayList(r5.length);
        this.f7746a = r10;
        Collections.addAll(r10, r5);
    }

    public final synchronized void a(ImageOriginListener r5) {
        monitor-enter(this);
        this.f7746a.add(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public final synchronized void a(String r10, int r11, boolean r12, String r13) {
        monitor-enter(this);
        int r5 = this.f7746a.size();     // Catch: Throwable -> L9
        int r14 = 0;
    L4:
        if (r14 >= r5) goto L14;
        ImageOriginListener r15 = (ImageOriginListener) this.f7746a.get(r14);     // Catch: Throwable -> L9
        if (r15 == null) goto L13;
        r15.a(r10, r11, r12, r13);     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        FLog.a("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);     // Catch: Throwable -> L9
    L13:
        r14 = r14 + 1;
        goto L4
    L14:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
