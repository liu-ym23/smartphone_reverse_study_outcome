package com.bytedance.crash.upload;

import android.os.FileObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4155b;

    public r(s r5, String r10) {
        this.f4154a = 0;
        this.f4155b = r5;
        super(r10, 1032);
    }

    @Override // android.os.FileObserver
    public final void onEvent(int r5, String r10) {
        switch(this.f4154a) {
            case 0: goto L13;
            default: goto L5;
        };
    L13:
        io.reactivex.exceptions.a.i("disaster: FileObserver event=" + r5);
        if ((r5 & 8) != 0) goto L18;
        if ((r5 & 1024) != 0) goto L18;
        return;
    L18:
        if (((s) this.f4155b).d == false) goto L20;
        io.reactivex.exceptions.a.i("disaster: current process updating file");
        ((s) this.f4155b).d = false;
        return;
    L20:
        l9.o.e().c(new a6.a(this, 10), 100);
        return;
    L5:
        if (r5 == 512) goto L8;
        if (r5 == 1024) goto L8;
        return;
    L8:
        com.bytedance.android.monitorV2.k r11 = e3.c.f16757a;
        e3.a r12 = (e3.a) this.f4155b;
        Intrinsics.checkNotNullParameter(r12, "info");
        String r13 = r12.f16752b;
        com.bytedance.android.monitorV2.k r14 = e3.c.f16757a;
        if (r14 == null) goto L11;
        e3.a r15 = (e3.a) r14.remove(r13);
    L11:
        e3.c.f16758b.remove(r13);
    }

    public r(e3.a r5, String r10) {
        this.f4154a = 1;
        this.f4155b = r5;
        super(r10, 1536);
    }
}
