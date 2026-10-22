package l2;

import android.view.View;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.h;
import h5.k;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    void a(String r1);

    Object b(k r1, Continuation<? super AppletWidgetContainer> r10);

    void c(h r1);

    void d(String r1, String r10);

    void e(k r1);

    void f(List<String> r1);

    void g(k r1);

    void h(Iterable<? extends View> r1);

    void onHostDestroy();

    void onHostHide();

    void onHostShow();
}
