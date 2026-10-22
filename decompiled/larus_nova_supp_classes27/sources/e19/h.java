package e19;

import android.content.Context;
import android.view.View;
import com.larus.common_ui.floatwindow.manager.FloatPriority;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface h {
    void a();

    void b();

    int c();

    List<String> d();

    void e(boolean r1);

    boolean f();

    boolean g();

    View getContentView();

    int getHeight();

    FloatPriority getPriority();

    int getWidth();

    f h();

    boolean i();

    void j(b r1);

    String k();

    View l(Context r1);

    boolean n0();

    void onWindowDismiss();

    void onWindowShow();

    void setHeight(int r1);

    void setWidth(int r1);
}
