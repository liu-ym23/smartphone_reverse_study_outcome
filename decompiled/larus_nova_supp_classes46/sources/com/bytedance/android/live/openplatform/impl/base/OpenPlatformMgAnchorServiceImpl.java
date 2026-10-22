package com.bytedance.android.live.openplatform.impl.base;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonObject;
import j70.h;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import po0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b;\u0010<J\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J.\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J8\u0010&\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00112&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`$H\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110'H\u0016J\u001c\u0010,\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\u0016\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0016J\u001c\u00102\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001101H\u0016R0\u00105\u001a\u0004\u0018\u0001032\n\b\u0001\u00104\u001a\u0004\u0018\u0001038\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/OpenPlatformMgAnchorServiceImpl;", "Lcom/bytedance/android/live/openplatform/api/minigame/IOpenPlatformMgAnchorService;", "Lj70/h;", "Lh70/b;", "getAnchorMiniGameWidgetDescriptor", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "containerView", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "Landroidx/lifecycle/LifecycleObserver;", "getPreviewMiniGameWidgetLifecycleObserver", "Lorg/json/JSONObject;", "params", "", "openBottomFeaturePanel", "", "method", "Lcom/google/gson/JsonObject;", "param", "Lkotlin/Function1;", "callback", "handleCommonJSBInvoke", "", "isMiniGameMounted", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "item", "mount", "unmount", "openMountedGame", "isMount", "setMountStatus", "previewItemClick", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extra", "reportMiniGameAppLog", "", "getMiniGameAppCommonLogMap", "getMiniGameLotteryCommonLogMap", "fromTaskId", "toTaskId", "previewSwitchTask", "isOpeningLynxPanelInGame", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/log/filter/v;", "provideMgParams2LogInjector", "", "injectMgParams", "Lvo0/a;", "<set-?>", "miniGameAnchorService", "Lvo0/a;", "getMiniGameAnchorService", "()Lvo0/a;", "setMiniGameAnchorService", "(Lvo0/a;)V", "<init>", "()V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformMgAnchorServiceImpl implements IOpenPlatformMgAnchorService {
    public static final a Companion = null;
    private static final e diComponent = null;
    private vo0.a miniGameAnchorService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements v {
        public b() {
        }

        public final void Rd() {
        }

        public final void onRemove() {
        }

        public final void L9(String r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "eventName");
            Intrinsics.checkNotNullParameter(r4, "params");
            AnchorMiniGameDataContext.Companion.getClass();
            AnchorMiniGameDataContext r5 = AnchorMiniGameDataContext.a.a();
            if (r5 == null) goto L16;
            m<String> r6 = r5.getGameId();
            if (r6 == null) goto L17;
            String r7 = (String) r6.getValue();
            if (r7 != null) goto L10;
            return;
        L10:
            if (r4.containsKey("is_micro_game") == true) goto L13;
            r4.put("is_micro_game", "1");
        L13:
            if (r4.containsKey("mp_id") == true) goto L18;
            r4.put("mp_id", r7);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    static {
        Companion = new a();
        diComponent = po0.a.a();
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public h<? extends h70.b> getAnchorMiniGameWidgetDescriptor() {
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnchorMiniGameWidgetDescriptor();
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public Map<String, String> getMiniGameAppCommonLogMap() {
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.getMiniGameAppCommonLogMap();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public boolean isMiniGameMounted() {
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public boolean isOpeningLynxPanelInGame() {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L9;
        m<Boolean> r1 = r0.getOpenLynxPanelInGame();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void openMountedGame() {
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.d("");
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public Pair<String, v> provideMgParams2LogInjector() {
        return TuplesKt.to("OpenPlatformMgAnchorServiceImpl", new b());
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void unmount() {
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.unmount();
        return;
    }

    public OpenPlatformMgAnchorServiceImpl() {
        setMiniGameAnchorService((vo0.a) ((po0.a.b) diComponent).e.get());
        k.l(IOpenPlatformMgAnchorService.class, this);
        com.bytedance.android.live.openplatform.impl.base.utils.v.a();
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public Map<String, String> getMiniGameLotteryCommonLogMap() {
        if (isMiniGameMounted() == false) goto L6;
        return getMiniGameAppCommonLogMap();
    L6:
        return MapsKt.emptyMap();
    }

    public static final /* synthetic */ e access$getDiComponent$cp() {
        return diComponent;
    }

    public final vo0.a getMiniGameAnchorService() {
        return this.miniGameAnchorService;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void injectMgParams(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L16;
        m<String> r1 = r0.getGameId();
        if (r1 == null) goto L17;
        String r2 = (String) r1.getValue();
        if (r2 != null) goto L10;
        return;
    L10:
        if (r4.containsKey("is_micro_game") == true) goto L13;
        r4.put("is_micro_game", "1");
    L13:
        if (r4.containsKey("mp_id") == true) goto L18;
        r4.put("mp_id", r2);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void previewItemClick(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.previewItemClick(r2);
        return;
    }

    @Inject
    public final void setMiniGameAnchorService(vo0.a r1) {
        this.miniGameAnchorService = r1;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void setMountStatus(boolean r2) {
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.setMountStatus(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void mount(Context r2, u r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "item");
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.mount(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void openBottomFeaturePanel(Context r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.openBottomFeaturePanel(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void previewSwitchTask(String r2, String r3) {
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.previewSwitchTask(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void reportMiniGameAppLog(String r2, HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.reportMiniGameAppLog(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public LifecycleObserver getPreviewMiniGameWidgetLifecycleObserver(Context r2, ViewGroup r3, PreviewSourceParam r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPreviewMiniGameWidgetLifecycleObserver(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService
    public void handleCommonJSBInvoke(String r2, JsonObject r3, Function1<? super JsonObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "param");
        vo0.a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L6;
        r0.handleCommonJSBInvoke(r2, r3, r4);
        return;
    }
}
