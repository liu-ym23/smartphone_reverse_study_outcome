package pd;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    View getHybridView();

    void load(String r1, Map<String, ? extends Object> r10);

    void registerMethod(String r1, com.bytedance.ies.web.jsbridge2.f.b r10);

    <P, R> void registerMethod(String r1, com.bytedance.ies.web.jsbridge2.g<P, R> r10);

    void release();

    <T> void sendJsEvent(String r1, T r10);

    void updateData(Map<String, ? extends Object> r1);

    void updateGlobalProps(Map<String, ? extends Object> r1);
}
