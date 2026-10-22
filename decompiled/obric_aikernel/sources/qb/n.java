package qb;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface n extends jb.j {

    public static class a implements n {
        public a() {
        }

        @Override // qb.n
        public void a(jb.j r10) {
        }

        @Override // jb.j
        public int b(String r10, String r11) {
            return 0;
        }

        @Override // qb.n
        public int c(DownloadInfo r10) {
            return 0;
        }

        @Override // qb.n
        public boolean d() {
            return true;
        }
    }

    void a(jb.j r10);

    int c(DownloadInfo r10);

    boolean d();
}
