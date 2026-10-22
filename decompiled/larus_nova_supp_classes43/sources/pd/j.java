package pd;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface j {
    void a();

    View b();

    void c(LifecycleOwner r1);

    View getHybridView();

    void loadUrl(String r1);

    void registerCrashMonitor();

    void registerStatefulMethod(String r1, com.bytedance.ies.web.jsbridge2.f.b r10);

    <P, R> void registerStatelessMethod(String r1, com.bytedance.ies.web.jsbridge2.g<P, R> r10);

    void release();

    void renderTemplate(String r1, Map<String, ? extends Object> r10);

    <T> void sendJsEvent(String r1, T r10);

    void updateBusinessGlobalProps(Map<String, ? extends Object> r1);

    void updateData(Map<String, ? extends Object> r1);

    void updateGlobalProps(Map<String, ? extends Object> r1);
}
