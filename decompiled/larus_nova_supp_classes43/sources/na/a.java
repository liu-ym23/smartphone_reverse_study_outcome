package na;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import com.bytedance.ies.bullet.core.kit.bridge.h;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    void a();

    void b(String r1, Map r10, m16.b r11, AnnieXLiteContainer.b r12);

    void c(Activity r1);

    boolean canGoBack();

    View d();

    void e(Activity r1);

    void enterBackground();

    void enterForeground();

    void goBack();

    void release();

    boolean reload();

    void sendEvent(h r1);

    void updateData(String r1);

    void updateData(Map<String, ? extends Object> r1);

    void updateGlobalProps(Map<String, ? extends Object> r1);
}
