package com.bytedance.android.live.openplatform.api.minigame;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.livesdk.log.filter.v;
import com.google.gson.JsonObject;
import h70.b;
import j70.h;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J.\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J8\u0010&\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00112&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`$H\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110'H\u0016J\u001c\u0010,\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\u0016\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0016J\u001c\u00102\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001101H\u0016¨\u00065"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/minigame/OpenPlatformMgAnchorServiceDummy;", "Lcom/bytedance/android/live/openplatform/api/minigame/IOpenPlatformMgAnchorService;", "Lj70/h;", "Lh70/b;", "getAnchorMiniGameWidgetDescriptor", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "containerView", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "Landroidx/lifecycle/LifecycleObserver;", "getPreviewMiniGameWidgetLifecycleObserver", "Lorg/json/JSONObject;", "params", "", "openBottomFeaturePanel", "", "method", "Lcom/google/gson/JsonObject;", "param", "Lkotlin/Function1;", "callback", "handleCommonJSBInvoke", "", "isMiniGameMounted", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "item", "mount", "unmount", "openMountedGame", "isMount", "setMountStatus", "previewItemClick", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extra", "reportMiniGameAppLog", "", "getMiniGameAppCommonLogMap", "getMiniGameLotteryCommonLogMap", "fromTaskId", "toTaskId", "previewSwitchTask", "isOpeningLynxPanelInGame", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/log/filter/v;", "provideMgParams2LogInjector", "", "injectMgParams", "<init>", "()V", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformMgAnchorServiceDummy implements IOpenPlatformMgAnchorService {
    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public h<? extends b> getAnchorMiniGameWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public LifecycleObserver getPreviewMiniGameWidgetLifecycleObserver(Context r1, ViewGroup r2, PreviewSourceParam r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void handleCommonJSBInvoke(String r1, JsonObject r2, Function1<? super JsonObject, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "method");
        Intrinsics.checkNotNullParameter(r2, "param");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void injectMgParams(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public boolean isMiniGameMounted() {
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public boolean isOpeningLynxPanelInGame() {
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void mount(Context r2, u r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void openBottomFeaturePanel(Context r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void openMountedGame() {
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void previewItemClick(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void previewSwitchTask(String r1, String r2) {
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public Pair<String, v> provideMgParams2LogInjector() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void reportMiniGameAppLog(String r1, HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void setMountStatus(boolean r1) {
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void unmount() {
    }

    public OpenPlatformMgAnchorServiceDummy() {
        k.l(IOpenPlatformMgAnchorService.class, this);
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public Map<String, String> getMiniGameAppCommonLogMap() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public Map<String, String> getMiniGameLotteryCommonLogMap() {
        return MapsKt.emptyMap();
    }
}
