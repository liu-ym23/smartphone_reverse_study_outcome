package cb;

import androidx.core.view.InputDeviceCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class d extends bb.a {
    public d() {
    }

    private void n() {
        int r10 = this.f544h.getId();
        int r11 = com.ss.android.socialbase.downloader.downloader.a.t(this.f544h);
        DownloadInfo r12 = this.f542c.a(r11);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.getId() != r10) goto L7;
        return;
    L7:
        if (r12.equalsTask(this.f544h) == true) goto L10;
        return;
    L10:
        if (com.ss.android.socialbase.downloader.downloader.a.s().C(r12.getId()) == true) goto L16;
        com.ss.android.socialbase.downloader.utils.g.i(this.f544h);
        this.f542c.j(r11);
        if (r12.isFileDataValid() == true) goto L14;
        return;
    L14:
        this.f544h.copyFromCacheData(r12, false);
        this.f542c.b(this.f544h);
        throw new BaseException(1089, "retry task because id generator changed");
    L16:
        this.f542c.j(r10);
        throw new BaseException(InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
    }

    @Override // bb.a, bb.e
    public bb.e e(h r10) {
        if (r10.f678c.isFastDownload() == false) goto L7;
        return null;
    L7:
        return super.e(r10);
    }

    @Override // bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadCheckHasAnotherSameTaskModule", this.f544h.getId(), "proceed", "Run");
    L5:
        n();
        r10.b();
    }
}
