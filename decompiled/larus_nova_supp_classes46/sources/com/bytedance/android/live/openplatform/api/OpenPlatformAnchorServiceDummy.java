package com.bytedance.android.live.openplatform.api;

import android.content.Context;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.livesdkapi.openplatform.LiveOpenApiCallback;
import h70.b;
import j70.h;
import java.util.List;
import java.util.Map;
import jc1.k;
import jo0.a;
import ko0.c;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mh1.p;
import org.json.JSONObject;
import w20.lc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b]\u0010^J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH\u0016J6\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\nH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0006H\u0016J\"\u0010-\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\"\u00100\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020\u001fH\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J \u00106\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0016J\n\u00108\u001a\u0004\u0018\u000107H\u0016J\u0018\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\u001fH\u0016J\u0018\u0010=\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0016J\b\u0010>\u001a\u00020\nH\u0016J\b\u0010?\u001a\u00020\nH\u0016J\u001a\u0010B\u001a\u00020\n2\u0006\u0010@\u001a\u00020+2\b\u0010\t\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u00020\n2\u0006\u0010@\u001a\u00020+2\b\u0010\t\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010D\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010CH\u0016J\b\u0010E\u001a\u00020\nH\u0016J(\u0010I\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020+2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010GH\u0016J\b\u0010J\u001a\u00020\u001fH\u0016J\"\u0010O\u001a\u00020\n2\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\b\u0010N\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010Q\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0016J\b\u0010R\u001a\u00020\nH\u0016J\b\u0010S\u001a\u00020\nH\u0016J\b\u0010T\u001a\u00020+H\u0016J\b\u0010U\u001a\u00020\nH\u0016J\u001a\u0010W\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010VH\u0016J\u0016\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010XH\u0016J\u001e\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020[\u0018\u00010X2\u0006\u0010Z\u001a\u00020+H\u0016¨\u0006_"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/OpenPlatformAnchorServiceDummy;", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAnchorService;", "Lko0/c;", "getMiniAppLiveCastEntranceInfo", "", "appId", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "callback", "", "invokeLiveOpenApi", "Lj70/h;", "Lh70/b;", "getAnchorMiniAppWidgetDescriptor", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "containerView", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "shootWay", "Ljo0/a;", "previewMiniAppWidget", "Landroidx/lifecycle/LifecycleObserver;", "getPreviewMiniAppWidgetLifecycleObserver", "schema", "Lko0/b;", "launchParams", "openMiniApp", "openLiveCastingMiniApp", "", "isMiniAppMounted", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "mount", "unmount", "getPreviewStarOrderId", "mountData", "openExplainCardSettingDialog", "success", "Landroid/view/Surface;", "surface", "", "fps", "notifyMiniAppStartLinkCastResult", "param", "clearSwitchingLock", "notifyMiniAppStopLinkCastResult", "openShelfManagementPage", "clickAnchorToolbarMiniApp", "mpId", "enterPosition", "exitSource", "reportExitMpBind", "Lcom/bytedance/android/live/openplatform/api/model/MemoryStatus;", "getMemoryStatus", "which", "remember", "updateMemoryStatus", "source", "reportDefaultOpenFirstExplainCardOn", "reportMpShow", "reportMpClick", "newScene", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAnchorService$a;", "pauseLinkCastWhenSceneSwitched", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformAnchorService$a;", "resumeLinkCastWhenSceneSwitched", "closeShelfManagementPage", "scene", "", "appIdList", "openCouponPage", "isMorePanelMiniAppRedDotShowing", "clickSource", "liveType", "Lmh1/p;", "miniAppOuterHelper", "openChoosePage", "type", "reportBubbleShow", "recordSnowFlakeShown", "recordMorePanelSnowFlakeShown", "getCoexistComponent", "clearLocalKVCache", "Lw20/lc$a;", "openLiveMicroApp", "", "getCommonEventParams", "cardType", "", "getMiniAppCommonCardExtraParams", "<init>", "()V", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformAnchorServiceDummy implements IOpenPlatformAnchorService {
    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void clearLocalKVCache() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void clickAnchorToolbarMiniApp() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void closeShelfManagementPage() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public h<? extends b> getAnchorMiniAppWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public int getCoexistComponent() {
        return 0;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public Map<String, String> getCommonEventParams() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public MemoryStatus getMemoryStatus() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public c getMiniAppLiveCastEntranceInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public LifecycleObserver getPreviewMiniAppWidgetLifecycleObserver(Context r1, ViewGroup r2, PreviewSourceParam r3, String r4, a r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "shootWay");
        Intrinsics.checkNotNullParameter(r5, "previewMiniAppWidget");
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public String getPreviewStarOrderId() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void invokeLiveOpenApi(String r2, JSONObject r3, LiveOpenApiCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public boolean isMiniAppMounted() {
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public boolean isMorePanelMiniAppRedDotShowing() {
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void mount(ShelfInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "shelfInfo");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void notifyMiniAppStartLinkCastResult(boolean r1, Surface r2, int r3) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void notifyMiniAppStopLinkCastResult(boolean r1, JSONObject r2, boolean r3) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openChoosePage(String r1, String r2, p r3) {
        Intrinsics.checkNotNullParameter(r1, "clickSource");
        Intrinsics.checkNotNullParameter(r2, "liveType");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openCouponPage(Context r1, int r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openExplainCardSettingDialog(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "mountData");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void openLiveCastingMiniApp() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void openLiveMicroApp(String r1, lc.a r2) {
        Intrinsics.checkNotNullParameter(r1, "schema");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openMiniApp(String r2, ko0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "launchParams");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void openShelfManagementPage() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void pauseLinkCastWhenSceneSwitched(int r1, IMiddlewareOpenPlatformAnchorService.a r2) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void pauseLinkCastWhenSceneSwitched(int r1, IOpenPlatformAnchorService.a r2) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void recordMorePanelSnowFlakeShown() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void recordSnowFlakeShown() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportBubbleShow(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mpId");
        Intrinsics.checkNotNullParameter(r3, "type");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportDefaultOpenFirstExplainCardOn(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mpId");
        Intrinsics.checkNotNullParameter(r3, "source");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportExitMpBind(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "mpId");
        Intrinsics.checkNotNullParameter(r3, "enterPosition");
        Intrinsics.checkNotNullParameter(r4, "exitSource");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportMpClick() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void reportMpShow() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService
    public void resumeLinkCastWhenSceneSwitched(IMiddlewareOpenPlatformAnchorService.a r1) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void resumeLinkCastWhenSceneSwitched(IOpenPlatformAnchorService.a r1) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void unmount() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService
    public void updateMemoryStatus(int r1, boolean r2) {
    }

    public OpenPlatformAnchorServiceDummy() {
        k.l(IOpenPlatformAnchorService.class, this);
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public Map<String, Object> getMiniAppCommonCardExtraParams(int r1) {
        return MapsKt.emptyMap();
    }
}
