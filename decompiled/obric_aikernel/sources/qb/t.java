package qb;

import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.a0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface t {

    public static class a implements t {
        public a() {
        }

        @Override // qb.t
        @Nullable
        public DownloadInfo a(int r10) {
            return null;
        }

        @Override // qb.t
        public void b(int r10) {
        }

        @Override // qb.t
        public void c(int r10, a0 r11, ListenerType r12, boolean r13) {
        }

        @Override // qb.t
        public int n(int r10) {
            return 0;
        }

        @Override // qb.t
        public boolean o(int r10) {
            return false;
        }

        @Override // qb.t
        public void p(int r10, boolean r11) {
        }

        @Override // qb.t
        public void q(int r10, boolean r11) {
        }

        @Override // qb.t
        public void r(List<String> r10) {
        }

        @Override // qb.t
        public void s(int r10) {
        }

        @Override // qb.t
        public void t(int r10, long r11, int r12) {
        }

        @Override // qb.t
        public void u() {
        }

        @Override // qb.t
        public void w(List<String> r10) {
        }

        @Override // qb.t
        public void y(com.ss.android.socialbase.downloader.model.d r10) {
        }

        @Override // qb.t
        public void z(int r10) {
        }
    }

    @Nullable
    DownloadInfo a(int r10);

    void b(int r10);

    void c(int r10, a0 r11, ListenerType r12, boolean r13);

    int n(int r10);

    boolean o(int r10);

    void p(int r10, boolean r11);

    void q(int r10, boolean r11);

    void r(List<String> r10);

    void s(int r10);

    void t(int r10, long r11, int r12);

    void u();

    void w(List<String> r10);

    void y(com.ss.android.socialbase.downloader.model.d r10);

    void z(int r10);
}
