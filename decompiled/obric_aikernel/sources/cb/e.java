package cb;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class e extends bb.a {
    public e() {
    }

    private void n() {
        kb.a r10 = new kb.a(this.f544h.getSavePath(), this.f544h.getName());
        if (r10.n() == false) goto L5;
        this.f542c.j(this.f544h.getId());
        throw new BaseException(1081, "download savePath error:" + this.f544h.getSavePath() + " extra:" + r10.a());
    L5:
        if (r10.p() == false) goto L7;
        return;
    L7:
        File r11 = new File(this.f544h.getSavePath());
        if (r11.exists() == true) goto L32;
        boolean r12 = r11.mkdirs();
        if (r12 == false) goto L12;
        return;
    L12:
        if (r11.exists() == true) goto L48;
        int r13 = 0;
    L15:
        if (r12 == true) goto L21;
        int r14 = r13 + 1;
        if (r13 >= 3) goto L21;
        Thread.sleep(10);     // Catch: InterruptedException -> L43
        r12 = r11.mkdirs();
        r13 = r14;
    L21:
        if (r12 == false) goto L23;
        return;
    L23:
        if (r11.exists() == false) goto L25;
        return;
    L25:
        if (com.ss.android.socialbase.downloader.utils.g.n(this.f544h.getSavePath()) >= PlaybackStateCompat.ACTION_PREPARE) goto L29;
        throw new BaseException(PointerIconCompat.TYPE_CELL, "download savePath directory can not created:" + this.f544h.getSavePath());
    L29:
        throw new BaseException(1030, "download savePath directory can not created:" + this.f544h.getSavePath());
    L48:
        return;
    L32:
        if (r11.isDirectory() == true) goto L50;
        r11.delete();
        if (r11.mkdirs() == false) goto L36;
        return;
    L36:
        if (r11.exists() == false) goto L39;
        return;
    L39:
        throw new BaseException(1031, "download savePath is not directory:path=" + this.f544h.getSavePath());
    }

    @Override // bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadCheckPathModule", this.f544h.getId(), "proceed", "Run");
    L5:
        n();
        r10.b();
    }
}
