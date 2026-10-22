package com.bytedance.android.livesdk.interactivity;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.helper.DataContextExtKt;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.config.dl0;
import com.bytedance.android.livesdk.config.kk0;
import com.bytedance.android.livesdk.config.tj0;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdk.interactivity.api.IHighlightService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityDegradeService;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.MsgOptPanel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.personalized.PersonalizedChannelUplinkManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bf\u0010gJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"R!\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015R!\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015R!\u0010.\u001a\b\u0012\u0004\u0012\u00020(0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010\"R!\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015R!\u00106\u001a\b\u0012\u0004\u0012\u0002030\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0013\u001a\u0004\b5\u0010\u0015R!\u00109\u001a\b\u0012\u0004\u0012\u0002030\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0013\u001a\u0004\b8\u0010\u0015R!\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0013\u001a\u0004\b<\u0010\u0015R!\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0013\u001a\u0004\b@\u0010\u0015R!\u0010E\u001a\b\u0012\u0004\u0012\u00020B0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0013\u001a\u0004\bD\u0010\u0015R!\u0010I\u001a\b\u0012\u0004\u0012\u00020F0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0013\u001a\u0004\bH\u0010\u0015R!\u0010M\u001a\b\u0012\u0004\u0012\u00020J0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u0013\u001a\u0004\bL\u0010\u0015R=\u0010T\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0Nj\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P`Q0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0013\u001a\u0004\bS\u0010\"R!\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0013\u001a\u0004\bW\u0010\u0015R!\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0013\u001a\u0004\b[\u0010\u0015R!\u0010b\u001a\b\u0012\u0004\u0012\u00020^0]8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0013\u001a\u0004\b`\u0010aR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006h"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/InteractivityContext;", "Lcom/bytedance/android/livesdk/interactivity/InteractivityPlatformContext;", "Lcom/bytedance/android/livesdk/interactivity/api/f;", BuildConfig.FLAVOR, "isShopShow", "Ll22/d;", "getBaseUserActionCollector", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "initContextForPreview", "initContext", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/interactivity/api/like/datacontext/DiggContext;", "diggContext$delegate", "Lcom/bytedance/live/datacontext/p;", "getDiggContext", "()Lcom/bytedance/live/datacontext/j;", "diggContext", "Ls22/e;", "chatChannelManager$delegate", "getChatChannelManager", "chatChannelManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/square/b;", "squareTabManager$delegate", "getSquareTabManager", "squareTabManager", "Lcom/bytedance/live/datacontext/m;", "chatChannelLandscapeDialogState$delegate", "getChatChannelLandscapeDialogState", "()Lcom/bytedance/live/datacontext/m;", "chatChannelLandscapeDialogState", BuildConfig.FLAVOR, "userFansCountOnStart$delegate", "getUserFansCountOnStart", "userFansCountOnStart", BuildConfig.FLAVOR, "userHonorLevelOnStart$delegate", "getUserHonorLevelOnStart", "userHonorLevelOnStart", "markHighlightStatusCode$delegate", "getMarkHighlightStatusCode", "markHighlightStatusCode", "Lt22/g;", "topicTipManager$delegate", "getTopicTipManager", "topicTipManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/a;", "publicScreenAreaStateManager$delegate", "getPublicScreenAreaStateManager", "publicScreenAreaStateManager", "multiChatTabAreaStateManager$delegate", "getMultiChatTabAreaStateManager", "multiChatTabAreaStateManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/b;", "psOperatePanelManager$delegate", "getPsOperatePanelManager", "psOperatePanelManager", "Li42/b;", "miniAppPreloader$delegate", "getMiniAppPreloader", "miniAppPreloader", "Lo32/b;", "highlightDataContext$delegate", "getHighlightDataContext", "highlightDataContext", "Ll22/a;", "anchorAsrContext$delegate", "getAnchorAsrContext", "anchorAsrContext", "Lcom/bytedance/android/livesdk/interactivity/common/adjuster/layoutadjust/adapter/LiveRoomEnvStateHolder;", "liveRoomEnvStateHolder$delegate", "getLiveRoomEnvStateHolder", "liveRoomEnvStateHolder", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "chatImageBitmapMap$delegate", "getChatImageBitmapMap", "chatImageBitmapMap", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/MsgOptPanel;", "psOperatePanelItem$delegate", "getPsOperatePanelItem", "psOperatePanelItem", "Lcom/bytedance/android/livesdk/interactivity/api/utils/PSTopMessagePayload;", "psTopMessage$delegate", "getPsTopMessage", "psTopMessage", "Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/android/livesdk/interactivity/common/adjuster/layoutadjust/k;", "psHeightPlatformStrategyReporter$delegate", "getPsHeightPlatformStrategyReporter", "()Lcom/bytedance/live/datacontext/i;", "psHeightPlatformStrategyReporter", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractivityContext extends InteractivityPlatformContext implements com.bytedance.android.livesdk.interactivity.api.f {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p anchorAsrContext$delegate;
    private final CompositeDisposable cd;
    private final com.bytedance.live.datacontext.p chatChannelLandscapeDialogState$delegate;
    private final com.bytedance.live.datacontext.p chatChannelManager$delegate;
    private final com.bytedance.live.datacontext.p chatImageBitmapMap$delegate;
    private final com.bytedance.live.datacontext.p diggContext$delegate;
    private final com.bytedance.live.datacontext.p highlightDataContext$delegate;
    private final com.bytedance.live.datacontext.p liveRoomEnvStateHolder$delegate;
    private final com.bytedance.live.datacontext.p markHighlightStatusCode$delegate;
    private final com.bytedance.live.datacontext.p miniAppPreloader$delegate;
    private final com.bytedance.live.datacontext.p multiChatTabAreaStateManager$delegate;
    private final com.bytedance.live.datacontext.p psHeightPlatformStrategyReporter$delegate;
    private final com.bytedance.live.datacontext.p psOperatePanelItem$delegate;
    private final com.bytedance.live.datacontext.p psOperatePanelManager$delegate;
    private final com.bytedance.live.datacontext.p psTopMessage$delegate;
    private final com.bytedance.live.datacontext.p publicScreenAreaStateManager$delegate;
    private final com.bytedance.live.datacontext.p squareTabManager$delegate;
    private final com.bytedance.live.datacontext.p topicTipManager$delegate;
    private final com.bytedance.live.datacontext.p userFansCountOnStart$delegate;
    private final com.bytedance.live.datacontext.p userHonorLevelOnStart$delegate;

    public static final class a implements Action {
        public final /* synthetic */ InteractivityContext a;

        public a(InteractivityContext r1) {
            this.a = r1;
        }

        public final void run() {
            InteractivityContext.access$getCd$p(this.a).clear();
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ InteractivityContext a;

        public b(InteractivityContext r1) {
            this.a = r1;
        }

        public final void run() {
            InteractivityContext.access$getCd$p(this.a).clear();
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "diggContext", "getDiggContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "chatChannelManager", "getChatChannelManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "squareTabManager", "getSquareTabManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "chatChannelLandscapeDialogState", "getChatChannelLandscapeDialogState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "userFansCountOnStart", "getUserFansCountOnStart()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "userHonorLevelOnStart", "getUserHonorLevelOnStart()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "markHighlightStatusCode", "getMarkHighlightStatusCode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "topicTipManager", "getTopicTipManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "publicScreenAreaStateManager", "getPublicScreenAreaStateManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "multiChatTabAreaStateManager", "getMultiChatTabAreaStateManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "psOperatePanelManager", "getPsOperatePanelManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "miniAppPreloader", "getMiniAppPreloader()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "highlightDataContext", "getHighlightDataContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "anchorAsrContext", "getAnchorAsrContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "liveRoomEnvStateHolder", "getLiveRoomEnvStateHolder()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "chatImageBitmapMap", "getChatImageBitmapMap()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "psOperatePanelItem", "getPsOperatePanelItem()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "psTopMessage", "getPsTopMessage()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityContext.class, "psHeightPlatformStrategyReporter", "getPsHeightPlatformStrategyReporter()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0))};
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.f
    public com.bytedance.live.datacontext.j<l22.a> getAnchorAsrContext() {
        return (com.bytedance.live.datacontext.j) this.anchorAsrContext$delegate.a(this, $$delegatedProperties[13]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Boolean> getChatChannelLandscapeDialogState() {
        return (com.bytedance.live.datacontext.m) this.chatChannelLandscapeDialogState$delegate.a(this, $$delegatedProperties[3]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.f
    public com.bytedance.live.datacontext.j<s22.e> getChatChannelManager() {
        return (com.bytedance.live.datacontext.j) this.chatChannelManager$delegate.a(this, $$delegatedProperties[1]);
    }

    public com.bytedance.live.datacontext.m<HashMap<String, Bitmap>> getChatImageBitmapMap() {
        return (com.bytedance.live.datacontext.m) this.chatImageBitmapMap$delegate.a(this, $$delegatedProperties[15]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<DiggContext> getDiggContext() {
        return (com.bytedance.live.datacontext.j) this.diggContext$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.f
    public com.bytedance.live.datacontext.j<o32.b> getHighlightDataContext() {
        return (com.bytedance.live.datacontext.j) this.highlightDataContext$delegate.a(this, $$delegatedProperties[12]);
    }

    public final com.bytedance.live.datacontext.j<LiveRoomEnvStateHolder> getLiveRoomEnvStateHolder() {
        return (com.bytedance.live.datacontext.j) this.liveRoomEnvStateHolder$delegate.a(this, $$delegatedProperties[14]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Integer> getMarkHighlightStatusCode() {
        return (com.bytedance.live.datacontext.m) this.markHighlightStatusCode$delegate.a(this, $$delegatedProperties[6]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.f
    public com.bytedance.live.datacontext.j<i42.b> getMiniAppPreloader() {
        return (com.bytedance.live.datacontext.j) this.miniAppPreloader$delegate.a(this, $$delegatedProperties[11]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> getMultiChatTabAreaStateManager() {
        return (com.bytedance.live.datacontext.j) this.multiChatTabAreaStateManager$delegate.a(this, $$delegatedProperties[9]);
    }

    public final com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.k> getPsHeightPlatformStrategyReporter() {
        return (com.bytedance.live.datacontext.i) this.psHeightPlatformStrategyReporter$delegate.a(this, $$delegatedProperties[18]);
    }

    public com.bytedance.live.datacontext.j<MsgOptPanel> getPsOperatePanelItem() {
        return (com.bytedance.live.datacontext.j) this.psOperatePanelItem$delegate.a(this, $$delegatedProperties[16]);
    }

    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.b> getPsOperatePanelManager() {
        return (com.bytedance.live.datacontext.j) this.psOperatePanelManager$delegate.a(this, $$delegatedProperties[10]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<PSTopMessagePayload> getPsTopMessage() {
        return (com.bytedance.live.datacontext.j) this.psTopMessage$delegate.a(this, $$delegatedProperties[17]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> getPublicScreenAreaStateManager() {
        return (com.bytedance.live.datacontext.j) this.publicScreenAreaStateManager$delegate.a(this, $$delegatedProperties[8]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b> getSquareTabManager() {
        return (com.bytedance.live.datacontext.j) this.squareTabManager$delegate.a(this, $$delegatedProperties[2]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<t22.g> getTopicTipManager() {
        return (com.bytedance.live.datacontext.j) this.topicTipManager$delegate.a(this, $$delegatedProperties[7]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<Long> getUserFansCountOnStart() {
        return (com.bytedance.live.datacontext.j) this.userFansCountOnStart$delegate.a(this, $$delegatedProperties[4]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<Integer> getUserHonorLevelOnStart() {
        return (com.bytedance.live.datacontext.j) this.userHonorLevelOnStart$delegate.a(this, $$delegatedProperties[5]);
    }

    public InteractivityContext() {
        if (ht1.a.a() == false) goto L5;
        com.bytedance.live.datacontext.p r0 = DataContextExtKt.b(this, "diggContext");
    L6:
        this.diggContext$delegate = r0;
        this.chatChannelManager$delegate = ConstantKt.c(this);
        this.squareTabManager$delegate = ConstantKt.b(this, InteractivityContext$squareTabManager$2.INSTANCE);
        this.chatChannelLandscapeDialogState$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.FALSE);
        this.userFansCountOnStart$delegate = ConstantKt.c(this);
        this.userHonorLevelOnStart$delegate = ConstantKt.c(this);
        this.markHighlightStatusCode$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.topicTipManager$delegate = ConstantKt.b(this, InteractivityContext$topicTipManager$2.INSTANCE);
        if (ht1.a.a() == false) goto L9;
        com.bytedance.live.datacontext.p r1 = DataContextExtKt.b(this, "publicScreenAreaStateManager");
    L10:
        this.publicScreenAreaStateManager$delegate = r1;
        if (ht1.a.a() == false) goto L13;
        com.bytedance.live.datacontext.p r2 = DataContextExtKt.b(this, "multiChatTabAreaStateManager");
    L14:
        this.multiChatTabAreaStateManager$delegate = r2;
        this.psOperatePanelManager$delegate = ConstantKt.b(this, InteractivityContext$psOperatePanelManager$2.INSTANCE);
        if (ht1.a.a() == false) goto L17;
        com.bytedance.live.datacontext.p r3 = DataContextExtKt.b(this, "miniAppPreloader");
    L18:
        this.miniAppPreloader$delegate = r3;
        if (ht1.a.a() == false) goto L21;
        com.bytedance.live.datacontext.p r4 = DataContextExtKt.b(this, "highlightDataContext");
    L22:
        this.highlightDataContext$delegate = r4;
        this.anchorAsrContext$delegate = ConstantKt.c(this);
        if (ht1.a.a() == false) goto L25;
        com.bytedance.live.datacontext.p r5 = DataContextExtKt.b(this, "liveRoomEnvStateHolder");
    L26:
        this.liveRoomEnvStateHolder$delegate = r5;
        this.chatImageBitmapMap$delegate = com.bytedance.live.datacontext.q.d(this, new HashMap());
        if (ht1.a.a() == false) goto L29;
        com.bytedance.live.datacontext.p r6 = DataContextExtKt.b(this, "psOperatePanelItem");
    L30:
        this.psOperatePanelItem$delegate = r6;
        if (ht1.a.a() == false) goto L33;
        com.bytedance.live.datacontext.p r7 = DataContextExtKt.b(this, "psTopMessage");
    L34:
        this.psTopMessage$delegate = r7;
        this.psHeightPlatformStrategyReporter$delegate = ConstantKt.a(this, new com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.k(), InteractivityContext$psHeightPlatformStrategyReporter$2.INSTANCE);
        this.cd = new CompositeDisposable();
        return;
    L33:
        r7 = ConstantKt.c(this);
        goto L34
    L29:
        r6 = ConstantKt.c(this);
        goto L30
    L25:
        r5 = ConstantKt.c(this);
        goto L26
    L21:
        r4 = ConstantKt.c(this);
        goto L22
    L17:
        r3 = ConstantKt.c(this);
        goto L18
    L13:
        r2 = ConstantKt.c(this);
        goto L14
    L9:
        r1 = ConstantKt.c(this);
        goto L10
    L5:
        r0 = ConstantKt.c(this);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext, com.bytedance.android.livesdk.interactivity.api.h
    public l22.d getBaseUserActionCollector() {
        l22.a r0 = (l22.a) getAnchorAsrContext().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUserActionCollector();
    }

    @Override // com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext
    public boolean isShopShow() {
        LiveRoomEnvStateHolder r0 = (LiveRoomEnvStateHolder) getLiveRoomEnvStateHolder().getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.e;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(InteractivityContext r0) {
        return r0.cd;
    }

    public final void initContext(Context r28, final RoomContext r29, final DataCenter r30) {
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "roomContext");
        Intrinsics.checkNotNullParameter(r30, "dataCenter");
        getPublicScreenAreaStateManager().e(new AnonymousClass1(r29));
        getMultiChatTabAreaStateManager().e(new AnonymousClass2(r29));
        initContext(r28, r30, n3.g(r29), r29);
        if (ht1.a.a() == false) goto L5;
        getDiggContext().e(AnonymousClass3.INSTANCE);
        getHighlightDataContext().e(AnonymousClass4.INSTANCE);
        getMiniAppPreloader().e(AnonymousClass5.INSTANCE);
    L6:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.b> r5 = getPsOperatePanelManager();
        q r6 = new q();
        Intrinsics.checkNotNullParameter(r29, "roomContext");
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r30, "dataCenter");
        r6.d = r29;
        r6.e = r28;
        ALogger.d("PSOperatePanel", "init PSPanelItemManager");
        int r1 = y.a;
        y.a(r30, r6.h, "OpenPSOperatePanelEvent", new s(r6, r30));
        Unit r2 = Unit.INSTANCE;
        r5.d(r6);
        int r3 = h.a;
        final CompositeDisposable r11 = this.cd;
        Intrinsics.checkNotNullParameter(r29, "roomContext");
        Intrinsics.checkNotNullParameter(this, "interactionContext");
        Intrinsics.checkNotNullParameter(r30, "dataCenter");
        IRoomModuleService r4 = jc1.k.f(IRoomModuleService.class);
        h32.a r17 = null;
        if (r4 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.room.backend.g r7 = r4.getLiveRoomBackendUtils();
        if (r7 == null) goto L24;
        com.bytedance.live.datacontext.m r8 = r29.getRoom();
        if (r8 == null) goto L15;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L15;
        Long r10 = Long.valueOf(r9.getRoomId());
    L16:
        long r13 = r10.longValue();
        Function0<Unit> r14 = new InteractivityContextInitHelper$getInteractionInfo$1(r29, this, r11, r30);
        Function3<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.q, BackendGeneratedData, BackendItem, Unit> r15 = new InteractivityContextInitHelper$getInteractionInfo$2(this, r29, r30, r11);
        a50.a r16 = (a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r16 != null) goto L19;
    L21:
        boolean r18 = false;
    L22:
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r7, r13, r29, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.q.class, r14, null, r15, null, null, r11, r18, false, 3152);
        goto L24
    L19:
        if (r16.e() != true) goto L21;
        r18 = true;
    L15:
        r10 = null;
    L24:
        CompositeDisposable r19 = this.cd;
        Intrinsics.checkNotNullParameter(r29, "roomContext");
        Intrinsics.checkNotNullParameter(this, "interactionContext");
        Intrinsics.checkNotNullParameter(r19, "disposable");
        if (((Boolean) dl0.a.getValue()).booleanValue() == false) goto L27;
    L30:
        final boolean r110 = true;
    L31:
        IRoomModuleService r20 = jc1.k.f(IRoomModuleService.class);
        if (r20 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.room.backend.g r21 = r20.getLiveRoomBackendUtils();
        if (r21 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r21, ((Room) r29.getRoom().getValue()).getRoomId(), r29, PSTopMessagePayload.class, new InteractivityContextInitHelper$getPublicScreenTopMsg$2(r110, this), new InteractivityContextInitHelper$getPublicScreenTopMsg$3(r110, this), new InteractivityContextInitHelper$getPublicScreenTopMsg$1(this), null, null, r19, r110, false, 3136);
    L38:
        if (((Boolean) r29.getNeedQueryHistoryMentionChat().getValue()).booleanValue() == false) goto L48;
        final CompositeDisposable r111 = this.cd;
        Intrinsics.checkNotNullParameter(r29, "roomContext");
        Intrinsics.checkNotNullParameter(this, "interactionContext");
        Intrinsics.checkNotNullParameter(r111, "disposable");
        IRoomModuleService r23 = jc1.k.f(IRoomModuleService.class);
        if (r23 == null) goto L48;
        com.bytedance.android.livesdk.chatroom.room.backend.g r24 = r23.getLiveRoomBackendUtils();
        if (r24 == null) goto L48;
        Room r25 = (Room) r29.getRoom().getValue();
        if (r25 == null) goto L46;
        Long r26 = Long.valueOf(r25.getRoomId());
    L47:
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r24, r26.longValue(), r29, com.bytedance.android.livesdk.interactivity.api.publicscreen.model.b.class, new InteractivityContextInitHelper$getHistoryMentionChat$1(r29, this, r111), null, new InteractivityContextInitHelper$getHistoryMentionChat$2(this, r29, r111), null, null, r111, true, false, 3152);
        goto L48
    L46:
        r26 = null;
    L48:
        com.bytedance.live.datacontext.j<h32.a> r27 = getDegradeManager();
        IInteractivityDegradeService r31 = (IInteractivityDegradeService) jc1.k.f(IInteractivityDegradeService.class);
        if (r31 == null) goto L51;
        r17 = r31.createDegradeManager(r29);
    L51:
        r27.d(r17);
        h32.a r33 = (h32.a) getDegradeManager().getValue();
        if (r33 == null) goto L54;
        r33.init();
    L54:
        Disposable r34 = getOnCleared().subscribe(new a(this));
        if (r34 == null) goto L57;
        this.cd.add(r34);
    L57:
        boolean r35 = l.a;
        l.a = ((Boolean) l42.a.c.getValue()).booleanValue();
        if (PublicScreenABHelper.g(((Boolean) r29.isAnchor().getValue()).booleanValue()).enablePersonalizedChannel == true) goto L60;
        return;
    L60:
        if (ht1.a.a() == false) goto L62;
        getPersonalizedChannelManager().e(new AnonymousClass9(r29));
        return;
    L62:
        com.bytedance.live.datacontext.j<x42.a> r36 = getPersonalizedChannelManager();
        PersonalizedChannelUplinkManager r37 = new PersonalizedChannelUplinkManager(r29);
        r37.b();
        r36.d(r37);
        return;
    L27:
        if (PublicScreenABHelper.P == true) goto L30;
        r110 = false;
        goto L31
    L5:
        getDiggContext().d(new DiggContext());
        getHighlightDataContext().d(((IHighlightService) jc1.k.n(IHighlightService.class)).createHighlightContext());
        getMiniAppPreloader().d(new i42.b());
        goto L6
    }

    public final void initContextForPreview(Context r2, RoomContext r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        if (((com.bytedance.android.live.base.g) tj0.a.getValue()).a() == false) goto L12;
        if (ht1.a.a() == false) goto L7;
        getDiggContext().e(C03031.INSTANCE);
    L9:
        if (((Boolean) kk0.a.getValue()).booleanValue() == false) goto L12;
        int r5 = h.a;
        h.e(r3, this, this.cd, r4);
        goto L12
    L7:
        getDiggContext().d(new DiggContext());
    L12:
        if (LivePreviewDanmakuConfig.Companion.isPreviewDanmakuEnable() == false) goto L18;
        IBarrageService r6 = (IBarrageService) jc1.k.f(IBarrageService.class);
        if (r6 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r7 = r6.createBarrageContext();
        if (r7 == null) goto L18;
        getBarrageContext().d(r7);
    L18:
        Disposable r8 = getOnCleared().subscribe(new b(this));
        this.cd.add(r8);
    }
}
