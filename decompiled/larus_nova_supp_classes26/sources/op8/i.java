package op8;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface i {

    public static abstract class a {

        /* JADX INFO: renamed from: op8.i$a$a, reason: collision with other inner class name */
        public static final class C0127a extends a {
            public static final C0127a a = null;

            static {
                a = new C0127a();
            }

            public C0127a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    void M2(a r1);

    void a(View r1, MotionEvent r2);

    Fragment b(Boolean r1, String r2, Map<String, String> r3);

    void o8();

    void stopInput();
}
