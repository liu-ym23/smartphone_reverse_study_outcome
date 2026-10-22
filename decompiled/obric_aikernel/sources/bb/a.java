package bb;

import cb.h;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import jb.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected i f542c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected com.ss.android.socialbase.downloader.model.d f543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected DownloadInfo f544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected rb.a f545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected jb.e f546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected h f547k;

    public a() {
    }

    @Override // bb.e
    public void c(long r10, int r11) {
    }

    @Override // bb.e
    public void cancel() {
    }

    @Override // bb.e
    public e e(h r10) {
        this.f547k = r10;
        this.f542c = r10.f676a;
        this.f543g = r10.f677b;
        this.f544h = r10.f678c;
        this.f545i = r10.f679d;
        this.f546j = r10.f680e;
        return this;
    }

    @Override // bb.e
    public void f() {
    }

    @Override // bb.e
    public void h(boolean r10) {
    }

    public boolean m() {
        if (this.f547k.f678c.getStatus() != (-2)) goto L8;
        h r10 = this.f547k;
        RunStatus r11 = r10.f681f;
        RunStatus r12 = RunStatus.RUN_STATUS_PAUSE;
        if (r11 == r12) goto L7;
        r10.f681f = r12;
    L7:
        return true;
    L8:
        int r13 = this.f547k.f678c.getStatus();
        h r14 = this.f547k;
        if (r13 != (-4)) goto L14;
        RunStatus r15 = r14.f681f;
        RunStatus r16 = RunStatus.RUN_STATUS_CANCELED;
        if (r15 == r16) goto L13;
        r14.f681f = r16;
    L13:
        return true;
    L14:
        RunStatus r17 = r14.f681f;
        if (r17 != RunStatus.RUN_STATUS_CANCELED) goto L17;
        return true;
    L17:
        if (r17 == RunStatus.RUN_STATUS_PAUSE) goto L22;
        return false;
    L22:
        return true;
    }
}
