package ih0;

import android.view.View;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c extends Disposable {

    public static final class a {
        public static /* synthetic */ void a(c r2, Map r3, Map r4, int r5) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            r2.h(r3, r4);
        }
    }

    Boolean A();

    void J();

    void N(long r1);

    View S0();

    void f1();

    View getHybridView();

    void h(Map r1, Map r2);

    Completable onLoadSuccess();

    void r1();

    void registerMethod(String r1, com.bytedance.ies.web.jsbridge2.f.b r2);

    void release();

    void sendJsEvent(String r1, Object r2);

    void updateData(Map<String, ? extends Object> r1);

    void updateGlobalProps(Map<String, ? extends Object> r1);
}
