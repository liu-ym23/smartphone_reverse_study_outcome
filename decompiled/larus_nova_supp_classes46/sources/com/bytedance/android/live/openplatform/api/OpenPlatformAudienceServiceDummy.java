package com.bytedance.android.live.openplatform.api;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdkapi.openplatform.LiveOpenApiCallback;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h70.b;
import j70.h;
import java.util.Map;
import jc1.k;
import ko0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mo0.a;
import org.json.JSONObject;
import w20.lc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\nH\u0016J\u0018\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u001e\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000207\u0018\u0001062\u0006\u00105\u001a\u000204H\u0016J\u001a\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010:H\u0016J\u0016\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000106H\u0016J\u001a\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0016¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/OpenPlatformAudienceServiceDummy;", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAudienceService;", "Lko0/c;", "getMiniAppLiveCastEntranceInfo", "", "appId", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "callback", "", "invokeLiveOpenApi", "Lj70/h;", "Lh70/b;", "getAudienceMiniAppWidgetDescriptor", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "source", "openMountedMiniApp", "location", "openSnowFlake", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "button", "onSnowFlakeShow", "", "isFromMsg", "onSnowFlakeHide", "reportMpLiveLinkShow", "reportMpLiveLinkClick", "isMiniAppExplainCardShowing", "hideMiniAppExplainCard", "showMiniAppExplainCard", "sei", "onSei", "isGuest", "reportAudienceLiveProjectionWatch", "", "duration", "reportAudienceLiveProjectionWatchDuration", "recordSnowFlakeShown", "showType", "reportExplainCardShown", "deleteMiniAppMountInfo", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "preloadMiniAppContext", "reportSnowFlakeAnimShow", "Lmo0/a;", "getOpenPlatformImageLoader", "Lis2/b;", "getShelfInfoBackendHandler", "", "cardType", "", "", "getMiniAppCommonCardExtraParams", "schema", "Lw20/lc$a;", "openLiveMicroApp", "getCommonEventParams", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/a0;", "createToolbarComponentConfig", "<init>", "()V", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformAudienceServiceDummy implements IOpenPlatformAudienceService {
    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public a0 createToolbarComponentConfig(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void deleteMiniAppMountInfo() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public h<? extends b> getAudienceMiniAppWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public Map<String, String> getCommonEventParams() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public Map<String, Object> getMiniAppCommonCardExtraParams(int r1) {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformService
    public c getMiniAppLiveCastEntranceInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public a getOpenPlatformImageLoader() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public is2.b getShelfInfoBackendHandler() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void hideMiniAppExplainCard() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void invokeLiveOpenApi(String r2, JSONObject r3, LiveOpenApiCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public boolean isMiniAppExplainCardShowing() {
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSnowFlakeHide(boolean r1) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void onSnowFlakeShow(s r1) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformService
    public void openLiveMicroApp(String r1, lc.a r2) {
        Intrinsics.checkNotNullParameter(r1, "schema");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void openMountedMiniApp(MountedMiniAppSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void openMountedMiniApp(String r2) {
        Intrinsics.checkNotNullParameter(r2, "location");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void openSnowFlake() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void preloadMiniAppContext(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void recordSnowFlakeShown() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void reportAudienceLiveProjectionWatch(boolean r1) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService, com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void reportAudienceLiveProjectionWatchDuration(long r1, boolean r3) {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportExplainCardShown(String r2) {
        Intrinsics.checkNotNullParameter(r2, "showType");
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportMpLiveLinkClick() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportMpLiveLinkShow() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService
    public void reportSnowFlakeAnimShow() {
    }

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    public void showMiniAppExplainCard() {
    }

    public OpenPlatformAudienceServiceDummy() {
        k.l(IOpenPlatformAudienceService.class, this);
    }
}
