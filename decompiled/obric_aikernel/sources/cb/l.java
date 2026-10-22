package cb;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes2.dex */
public class l extends bb.a {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f692a = null;

        static {
            int[] r10 = new int[RunStatus.values().length];
            f692a = r10;
            r10[RunStatus.RUN_STATUS_CANCELED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f692a[RunStatus.RUN_STATUS_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f692a[RunStatus.RUN_STATUS_INTERCEPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f692a[RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f692a[RunStatus.RUN_STATUS_END_RIGHT_NOW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f692a[RunStatus.RUN_STATUS_END_FOR_FILE_EXIST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f692a[RunStatus.RUN_STATUS_COMPLETED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public l() {
    }

    private void n(BaseException r10) {
        switch(a.f692a[this.f547k.f681f.ordinal()]) {
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
        if (r10 != null) goto L12;
        r10 = new BaseException(1092, "Unknown runStatus:" + this.f547k.f681f);
    L12:
        this.f546j.l(r10);
        return;
    L6:
        this.f546j.v();
        com.ss.android.socialbase.downloader.impls.m.d().c();
        return;
    L7:
        jb.e r11 = this.f546j;
        h r12 = this.f547k;
        r11.k(r12.f686k, r12.f687l);
        return;
    L8:
        this.f546j.j();
        return;
    L9:
        this.f546j.n();
        return;
    L10:
        this.f546j.o();
        return;
    L11:
        this.f546j.i();
        return;
    }

    private void o(BaseException r10) {
        if (lb.a.a() == false) goto L14;
        lb.a.g("DownloadBeginModule", this.f544h.getId(), "onDownloadTaskEnd", "RunStatus: " + this.f547k.f681f);
    L14:
        this.f547k.f677b.M().f8191k = System.currentTimeMillis();     // Catch: Throwable -> L8 BaseException -> L10
        com.ss.android.socialbase.downloader.downloader.a.O0(this.f547k.f677b, false);     // Catch: Throwable -> L8 BaseException -> L10
        n(r10);     // Catch: Throwable -> L8 BaseException -> L10
    L12:
        this.f547k.f682g = false;
        return;
    L10:
        e = move-exception;
        this.f546j.l(e);
    L8:
        th = move-exception;
        this.f546j.l(new BaseException(1046, th));
        goto L12
    }

    @Override // bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("DownloadBeginModule", this.f544h.getId(), "proceed", "Run");
    L6:
        if (m() == false) goto L8;
        return;
    L8:
        r10.a();
        this.f546j.c();     // Catch: Throwable -> L11 BaseException -> L14
        r10.b();     // Catch: Throwable -> L11 BaseException -> L14
        o(null);
    L21:
        return;
    L18:
        th = move-exception;
        o(null);
        throw th;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        o(e);
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        o(new BaseException(1000, th));
        goto L21
    }
}
