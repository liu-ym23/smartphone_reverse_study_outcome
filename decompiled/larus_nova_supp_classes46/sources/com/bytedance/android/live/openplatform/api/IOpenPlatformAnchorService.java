package com.bytedance.android.live.openplatform.api;

import android.content.Context;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import h70.b;
import j70.h;
import java.util.List;
import kotlin.Metadata;
import mh1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl")
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u00012\u00020\u0002:\u0001NJ\u0012\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003H&J6\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0017\u001a\u00020\u0015H&J\b\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001d\u001a\u00020\u0015H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\fH&J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001fH&J\"\u0010'\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H&J\"\u0010*\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u001f2\u0006\u0010)\u001a\u00020\u0018H&J\b\u0010+\u001a\u00020\u0015H&J\b\u0010,\u001a\u00020\u0015H&J \u00100\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\fH&J\u0018\u00103\u001a\u00020\u00152\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0018H&J\u0018\u00105\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH&J\b\u00106\u001a\u00020\u0015H&J\b\u00107\u001a\u00020\u0015H&J\u001a\u0010;\u001a\u00020\u00152\u0006\u00108\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u000109H&J\u0012\u0010<\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u000109H&J\b\u0010=\u001a\u00020\u0015H&J(\u0010A\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010>\u001a\u00020%2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010?H&J\b\u0010B\u001a\u00020\u0018H&J$\u0010G\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010EH&J\u0018\u0010I\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\f2\u0006\u0010H\u001a\u00020\fH&J\b\u0010J\u001a\u00020\u0015H&J\b\u0010K\u001a\u00020\u0015H&J\b\u0010L\u001a\u00020%H&J\b\u0010M\u001a\u00020\u0015H&¨\u0006O"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAnchorService;", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformService;", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformAnchorService;", "Lj70/h;", "Lh70/b;", "getAnchorMiniAppWidgetDescriptor", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "containerView", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "", "shootWay", "Ljo0/a;", "previewMiniAppWidget", "Landroidx/lifecycle/LifecycleObserver;", "getPreviewMiniAppWidgetLifecycleObserver", "schema", "Lko0/b;", "launchParams", "", "openMiniApp", "openLiveCastingMiniApp", "", "isMiniAppMounted", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "mount", "unmount", "getPreviewStarOrderId", "Lorg/json/JSONObject;", "mountData", "openExplainCardSettingDialog", "success", "Landroid/view/Surface;", "surface", "", "fps", "notifyMiniAppStartLinkCastResult", "param", "clearSwitchingLock", "notifyMiniAppStopLinkCastResult", "openShelfManagementPage", "clickAnchorToolbarMiniApp", "mpId", "enterPosition", "exitSource", "reportExitMpBind", "which", "remember", "updateMemoryStatus", "source", "reportDefaultOpenFirstExplainCardOn", "reportMpShow", "reportMpClick", "newScene", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAnchorService$a;", "callback", "pauseLinkCastWhenSceneSwitched", "resumeLinkCastWhenSceneSwitched", "closeShelfManagementPage", "scene", "", "appIdList", "openCouponPage", "isMorePanelMiniAppRedDotShowing", "clickSource", "liveType", "Lmh1/p;", "miniAppOuterHelper", "openChoosePage", "type", "reportBubbleShow", "recordSnowFlakeShown", "recordMorePanelSnowFlakeShown", "getCoexistComponent", "clearLocalKVCache", "a", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.openplatform.api.OpenPlatformAnchorServiceDummy")
public interface IOpenPlatformAnchorService extends IOpenPlatformService, IMiddlewareOpenPlatformAnchorService {

    public interface a extends IMiddlewareOpenPlatformAnchorService.a {
        void a();
    }

    void clearLocalKVCache();

    void clickAnchorToolbarMiniApp();

    void closeShelfManagementPage();

    h<? extends b> getAnchorMiniAppWidgetDescriptor();

    int getCoexistComponent();

    LifecycleObserver getPreviewMiniAppWidgetLifecycleObserver(Context r1, ViewGroup r2, PreviewSourceParam r3, String r4, jo0.a r5);

    String getPreviewStarOrderId();

    boolean isMiniAppMounted();

    boolean isMorePanelMiniAppRedDotShowing();

    void mount(ShelfInfo r1);

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    void notifyMiniAppStartLinkCastResult(boolean r1, Surface r2, int r3);

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    void notifyMiniAppStopLinkCastResult(boolean r1, JSONObject r2, boolean r3);

    void openChoosePage(String r1, String r2, p r3);

    void openCouponPage(Context r1, int r2, List<String> r3);

    void openExplainCardSettingDialog(JSONObject r1);

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    void openLiveCastingMiniApp();

    void openMiniApp(String r1, ko0.b r2);

    void openShelfManagementPage();

    void pauseLinkCastWhenSceneSwitched(int r1, a r2);

    void recordMorePanelSnowFlakeShown();

    void recordSnowFlakeShown();

    void reportBubbleShow(String r1, String r2);

    void reportDefaultOpenFirstExplainCardOn(String r1, String r2);

    void reportExitMpBind(String r1, String r2, String r3);

    void reportMpClick();

    void reportMpShow();

    void resumeLinkCastWhenSceneSwitched(a r1);

    void unmount();

    void updateMemoryStatus(int r1, boolean r2);
}
