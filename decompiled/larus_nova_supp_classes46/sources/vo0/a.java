package vo0;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.openplatform.impl.minigameanchor.widget.PreviewMiniGameWidgetDelegate;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends xo0.a {
    boolean c();

    void d(String r1);

    dr0.a getAnchorMiniGameWidgetDescriptor();

    Map<String, String> getMiniGameAppCommonLogMap();

    PreviewMiniGameWidgetDelegate getPreviewMiniGameWidgetLifecycleObserver(Context r1, ViewGroup r2, PreviewSourceParam r3);

    void handleCommonJSBInvoke(String r1, JsonObject r2, Function1<? super JsonObject, Unit> r3);

    void mount(Context r1, u r2);

    void openBottomFeaturePanel(Context r1, JSONObject r2);

    void previewItemClick(Context r1);

    void previewSwitchTask(String r1, String r2);

    void reportMiniGameAppLog(String r1, HashMap<String, String> r2);

    void setMountStatus(boolean r1);

    void unmount();
}
