package so0;

import android.content.Context;
import android.view.Surface;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.widget.PreviewMiniAppWidgetDelegate;
import java.util.List;
import ko0.b;
import mh1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends uo0.a {
    void clickAnchorToolbarMiniApp();

    void closeShelfManagementPage();

    PreviewMiniAppWidgetDelegate d(Context r1, ViewGroup r2, PreviewSourceParam r3, String r4);

    boolean e();

    eq0.a getAnchorMiniAppWidgetDescriptor();

    int getCoexistComponent();

    MemoryStatus getMemoryStatus();

    String getPreviewStarOrderId();

    void h(boolean r1, boolean r2, JSONObject r3);

    void i(String r1, b r2);

    void mount(ShelfInfo r1);

    void notifyMiniAppStartLinkCastResult(boolean r1, Surface r2, int r3);

    void openChoosePage(String r1, String r2, p r3);

    void openCouponPage(Context r1, int r2, List<String> r3);

    void openExplainCardSettingDialog(JSONObject r1);

    void openLiveCastingMiniApp();

    void openMiniApp(String r1, b r2);

    void openShelfManagementPage();

    void pauseLinkCastWhenSceneSwitched(int r1, IOpenPlatformAnchorService.a r2);

    void reportBubbleShow(String r1, String r2);

    void reportDefaultOpenFirstExplainCardOn(String r1, String r2);

    void reportExitMpBind(String r1, String r2, String r3);

    void reportMpClick();

    void reportMpShow();

    void resumeLinkCastWhenSceneSwitched(IOpenPlatformAnchorService.a r1);

    void unmount();

    void updateMemoryStatus(int r1, boolean r2);
}
