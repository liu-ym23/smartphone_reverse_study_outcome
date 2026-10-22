package cb;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.l0;

/* JADX INFO: loaded from: classes2.dex */
public class i extends bb.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BaseException f690l;

    class a implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f691a;

        a(i r10) {
            this.f691a = r10;
        }

        @Override // ib.l0
        public void a() {
            h r10 = i.n(this.f691a);
            r10.f681f = RunStatus.RUN_STATUS_COMPLETED;
            if (lb.a.a() == false) goto L6;
            lb.a.g("DownloadCompleteModule", i.o(this.f691a).getId(), "onSuccess", "Save file success");
            return;
        }

        @Override // ib.l0
        public void b(BaseException r10) {
            i.p(this.f691a, r10);
        }
    }

    public i() {
    }

    static /* synthetic */ h n(i r10) {
        return r10.f547k;
    }

    static /* synthetic */ DownloadInfo o(i r10) {
        return r10.f544h;
    }

    static /* synthetic */ BaseException p(i r10, BaseException r11) {
        r10.f690l = r11;
        return r11;
    }

    private void q() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadCompleteModule", this.f544h.getId(), "checkCompleted", "Run");
    L5:
        this.f690l = null;
        if (this.f544h.isChunked() == false) goto L8;
        DownloadInfo r10 = this.f544h;
        r10.setTotalBytes(r10.getCurBytes());
    L8:
        this.f544h.setFirstDownload(false);
        if (this.f544h.isIgnoreDataVerify() == true) goto L17;
        if (this.f544h.getCurBytes() == this.f544h.getTotalBytes()) goto L17;
        if (lb.a.a() == false) goto L15;
        lb.a.g("DownloadCompleteModule", this.f544h.getId(), "checkCompleted", "Error curBytes != totalBytes");
    L15:
        BaseException r11 = new BaseException(1027, "current bytes is not equals to total bytes");
    L22:
        this.f690l = r11;
    L33:
        if (this.f690l != null) goto L36;
        return;
    L36:
        if (lb.a.a() == false) goto L38;
        lb.a.g("DownloadCompleteModule", this.f544h.getId(), "checkCompleted", "Download fail and reset" + this.f690l);
    L38:
        this.f544h.reset();
        this.f542c.b(this.f544h);
        this.f542c.f2(this.f544h.getId());
        com.ss.android.socialbase.downloader.utils.g.i(this.f544h);
        throw this.f690l;
    L17:
        if (this.f544h.getCurBytes() > 0) goto L24;
        if (lb.a.a() == false) goto L21;
        lb.a.g("DownloadCompleteModule", this.f544h.getId(), "checkCompleted", "Error curBytes <=0");
    L21:
        r11 = new BaseException(1026, "curBytes <= 0");
        goto L22
    L24:
        if (this.f544h.isIgnoreDataVerify() == false) goto L26;
    L31:
        com.ss.android.socialbase.downloader.utils.c.Z(this.f544h, this.f543g.G(), new a(this));
        goto L33
    L26:
        if (this.f544h.getTotalBytes() > 0) goto L31;
        if (lb.a.a() == false) goto L30;
        lb.a.g("DownloadCompleteModule", this.f544h.getId(), "checkCompleted", "Error totalBytes <=0");
    L30:
        r11 = new BaseException(1044, "TotalBytes <= 0");
        goto L22
    }

    private boolean r() {
        if (m() == true) goto L14;
        RunStatus r10 = this.f547k.f681f;
        if (r10 == RunStatus.RUN_STATUS_INTERCEPT) goto L14;
        if (r10 == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L14;
        if (r10 == RunStatus.RUN_STATUS_END_RIGHT_NOW) goto L14;
        if (r10 == RunStatus.RUN_STATUS_END_FOR_FILE_EXIST) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("DownloadCompleteModule", this.f544h.getId(), "proceed", "Run");
    L6:
        if (r() == false) goto L8;
        return;
    L8:
        q();
    }
}
