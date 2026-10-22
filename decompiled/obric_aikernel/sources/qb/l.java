package qb;

import android.content.Context;
import androidx.annotation.Nullable;
import ib.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface l {

    public static class a implements l {
        public a() {
        }

        @Override // qb.l
        public com.ss.android.socialbase.downloader.downloader.b a() {
            return new com.ss.android.socialbase.downloader.downloader.b.a();
        }

        @Override // qb.l
        public void b(Runnable r10) {
        }

        @Override // qb.l
        public void c(jb.g r10) {
        }

        @Override // qb.l
        public void d(jb.g r10) {
        }

        @Override // qb.l
        @Nullable
        public jb.t e() {
            return null;
        }

        @Override // qb.l
        public void f(Context r10) {
        }

        @Override // qb.l
        public JSONObject g() {
            return ab.b.f134g;
        }

        @Override // qb.l
        @Nullable
        public Context getAppContext() {
            return null;
        }

        @Override // qb.l
        @Nullable
        public z h() {
            return null;
        }

        @Override // qb.l
        public boolean isInit() {
            return false;
        }
    }

    com.ss.android.socialbase.downloader.downloader.b a();

    void b(Runnable r10);

    void c(jb.g r10);

    void d(jb.g r10);

    @Nullable
    jb.t e();

    void f(Context r10);

    JSONObject g();

    @Nullable
    Context getAppContext();

    @Nullable
    z h();

    boolean isInit();
}
