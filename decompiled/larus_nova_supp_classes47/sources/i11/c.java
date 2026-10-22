package i11;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c {

    public static class a implements b {
        public a() {
        }

        @Override // i11.c.b
        public void a(int r1, List r2) {
        }

        @Override // i11.c.b
        public void b(int r1, List<? extends p> r2) {
        }

        @Override // i11.c.b
        public void c(int r1, List<? extends IBaseUser> r2) {
        }

        @Override // i11.c.b
        public void d(int r1, List<? extends p> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
        }

        @Override // i11.c.b
        public void e(String r1) {
        }

        @Override // i11.c.b
        public void f() {
        }

        @Override // i11.c.b
        public final void g() {
        }

        @Override // i11.c.b
        public void h(int r1, List<? extends p> r2) {
        }

        @Override // i11.c.b
        public void i(int r1) {
        }
    }

    public interface b {
        void a(int r1, List r2);

        void b(int r1, List<? extends p> r2);

        void c(int r1, List<? extends IBaseUser> r2);

        void d(int r1, List<? extends p> r2);

        void e(String r1);

        void f();

        void g();

        void h(int r1, List<? extends p> r2);

        void i(int r1);
    }

    List<p> a();

    void b(int r1, String r2);

    Map<String, String> g();

    p getGuestInfo(String r1, String r2);

    List<p> getOnlineUserList();

    void i(b r1);

    void l(b r1);

    Disposable m(Function2<? super List<? extends p>, ? super Integer, Unit> r1);
}
