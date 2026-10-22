package slb;

import com.ss.android.lark.pb.office_ai_inline.QuickAction;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface e {

    public interface a {
        void onError(Throwable r1);

        void onSuccess(List<QuickAction> r1);
    }

    void a(j r1, List<m> r2);

    void b();

    void c(Map<String, String> r1, a r2);

    void d(String r1);

    void e(List<m> r1);

    i1<Boolean> isShowing();
}
