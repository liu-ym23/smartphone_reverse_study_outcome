package qb;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private jb.j f12498a;

    public c() {
    }

    private int e(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L15:
        return 0;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (kb.b.p(r11) == false) goto L10;
        r11 = kb.b.g(r11);
    L10:
        String r12 = com.ss.android.socialbase.downloader.utils.g.W(r10 + "_" + r11);
        if (TextUtils.isEmpty(r12) == false) goto L14;
        return 0;
    L14:
        return r12.hashCode();
    }

    @Override // qb.n
    public void a(jb.j r10) {
        this.f12498a = r10;
    }

    @Override // jb.j
    public int b(String r10, String r11) {
        jb.j r12 = this.f12498a;
        if (r12 == null) goto L7;
        return r12.b(r10, r11);
    L7:
        return e(r10, r11);
    }

    @Override // qb.n
    public int c(DownloadInfo r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        String r11 = r10.getTaskKey();
        if (TextUtils.isEmpty(r11) == false) goto L9;
        r11 = r10.getUrl();
    L9:
        return b(r11, r10.getSavePath());
    }

    @Override // qb.n
    public boolean d() {
        if (this.f12498a != null) goto L5;
        return true;
    L5:
        return false;
    }
}
