package com.ss.android.socialbase.downloader.b.a;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class m extends com.ss.android.socialbase.downloader.b.a {

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.b.a.m$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15274a = null;

        static {
            int[] r0 = new int[RunStatus.values().length];
            f15274a = r0;
            r0[RunStatus.RUN_STATUS_CANCELED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f15274a[RunStatus.RUN_STATUS_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f15274a[RunStatus.RUN_STATUS_INTERCEPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f15274a[RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f15274a[RunStatus.RUN_STATUS_END_RIGHT_NOW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f15274a[RunStatus.RUN_STATUS_END_FOR_FILE_EXIST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f15274a[RunStatus.RUN_STATUS_COMPLETED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public m() {
    }

    private void a(BaseException r5) {
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPrepareModule", this.c, "onDownloadTaskEnd", "RunStatus: " + this.f.f);
    L14:
        this.f.f15272b.getTimingInfo().k = System.currentTimeMillis();     // Catch: Throwable -> L8 BaseException -> L10
        com.ss.android.socialbase.downloader.downloader.b.a(this.f.f15272b, false);     // Catch: Throwable -> L8 BaseException -> L10
        b(r5);     // Catch: Throwable -> L8 BaseException -> L10
    L12:
        this.f.g = false;
        return;
    L10:
        e = move-exception;
        this.e.b(e);
    L8:
        th = move-exception;
        this.e.b(new BaseException(1046, th));
        goto L12
    }

    private void b(BaseException r4) {
        switch(AnonymousClass1.f15274a[this.f.f.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L14;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        if (r4 != null) goto L12;
        r4 = new BaseException(1092, "Unknown runStatus:" + this.f.f);
    L12:
        this.e.b(r4);
        return;
    L6:
        this.e.g();
        com.ss.android.socialbase.downloader.impls.n.a().b();
        return;
    L7:
        this.e.a(this.f.k, this.f.l);
        return;
    L8:
        this.e.h();
        return;
    L9:
        this.e.f();
        return;
    L10:
        this.e.e();
        return;
    L11:
        this.e.d();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r5) {
        com.ss.android.socialbase.downloader.b.f r6 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPrepareModule", this.c, "proceed", "Run");
    L6:
        if (j_() == false) goto L8;
        return;
    L8:
        r6.b();
        this.e.b();     // Catch: Throwable -> L11 BaseException -> L14
        r6.a();     // Catch: Throwable -> L11 BaseException -> L14
        a(null);
        return;
    L18:
        th = move-exception;
        a(null);
        throw th;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        a(e);
    L21:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        a(new BaseException(1000, th));
        goto L21
    }
}
