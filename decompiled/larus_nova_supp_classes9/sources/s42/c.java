package s42;

import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface c {

    public static final class a {
        public static void a(TextMessageWidget r1, IRoom r2, m r3) {
            Intrinsics.checkNotNullParameter(r1, "widget");
            Intrinsics.checkNotNullParameter(r2, "room");
            Intrinsics.checkNotNullParameter(r3, "publicScreenData");
        }

        public static void b(IWidget r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "widget");
            Intrinsics.checkNotNullParameter(r2, "cause");
        }
    }

    public static final class b {
        public final int a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (this.a == ((b) r2).a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "ExtraUnloadInfo(maxMessageCountPerSec=" + this.a + ")";
        }

        public b(int r1) {
            this.a = r1;
        }
    }

    void a(TextMessageWidget r1, IRoom r2, boolean r3, boolean r4, m r5);

    void b(int r1);

    void c();

    void d(f<?> r1);

    void e(f<?> r1);

    void f(f<?> r1);

    void g(f<?> r1);

    void h(f<?> r1);

    void i();

    void j(IWidget r1, String r2);

    void k(tlc.d r1);

    void l(tlc.d r1);

    void m(f<?> r1);

    void n(f<?> r1);

    void o(f<?> r1);

    void p(f<?> r1);

    void q(f<?> r1);

    void r(f<?> r1);

    void s(IWidget r1, IRoom r2, b r3);

    void t(tlc.d r1);
}
