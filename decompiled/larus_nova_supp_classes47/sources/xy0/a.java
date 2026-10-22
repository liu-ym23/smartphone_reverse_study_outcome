package xy0;

import android.view.View;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import wy0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a<VIEW extends View> extends e, Disposable {
    void dispose();

    VIEW getHybridView();

    boolean isDisposed();

    void load();

    void load(String r1);

    void load(String r1, Map<String, ? extends Object> r2);

    HybridType o();

    @Override // wy0.e
    void registerMethod(String r1, f.b r2);

    @Override // wy0.e
    void registerMethod(String r1, g<?, ?> r2);

    @Override // wy0.e
    void sendJsEvent(String r1, Object r2);

    void updateData(Map<String, ? extends Object> r1);

    void updateGlobalProps(Map<String, ? extends Object> r1);

    void updateScreenMetrics(int r1, int r2);
}
