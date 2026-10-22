package cb;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class c extends bb.a {
    public c() {
    }

    public static void n(h r10) {
        if (r10.f687l.equals(r10.f678c.getName()) == false) goto L5;
        RunStatus r11 = RunStatus.RUN_STATUS_END_RIGHT_NOW;
    L6:
        r10.f681f = r11;
        r10.f678c.setCacheExistsInDownloading(true);
        return;
    L5:
        r11 = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
        goto L6
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
        if (lb.a.a() == false) goto L6;
        lb.a.g("DownloadCheckFileExistModule", this.f544h.getId(), "proceed", "Run");
    L6:
        if (TextUtils.isEmpty(this.f547k.f687l) == true) goto L15;
        if (this.f544h.isExpiredRedownload() == false) goto L10;
        h r11 = this.f547k;
        DownloadInfo r12 = this.f544h;
        r11.f685j = com.ss.android.socialbase.downloader.utils.g.b(r12, r12.isExpiredHttpCheck());
    L10:
        h r13 = this.f547k;
        if (r13.f685j == true) goto L15;
        n(r13);
        return;
    L15:
        if (this.f544h.isExpiredRedownload() == true) goto L21;
        if (this.f544h.isDownloaded() == false) goto L21;
        h r14 = this.f547k;
        r14.f687l = this.f544h.getName();
        h r15 = this.f547k;
        r15.f686k = this.f544h.getSavePath();
        n(this.f547k);
        return;
    L21:
        if (this.f544h.getChunkCount() <= 1) goto L23;
        this.f544h.reset();
        com.ss.android.socialbase.downloader.utils.g.i(this.f544h);
        this.f542c.b(this.f544h);
    L23:
        r10.b();
    }
}
