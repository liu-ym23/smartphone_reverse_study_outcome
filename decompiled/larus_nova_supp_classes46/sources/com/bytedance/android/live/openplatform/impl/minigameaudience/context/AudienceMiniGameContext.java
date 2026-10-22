package com.bytedance.android.live.openplatform.impl.minigameaudience.context;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AudienceMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAudienceServiceImpl;
import com.bytedance.android.live.openplatform.impl.minigameaudience.publishevent.AudiencePublishEventService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.CandyToolbarContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.qn;
import com.bytedance.android.livesdk.message.model.rn;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001*B#\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0014J\u0006\u0010\n\u001a\u00020\u0004J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016R.\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00158\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/context/AudienceMiniGameContext;", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/MiniGameContext;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "onCreate", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "instance", "onMiniGameInstanceCreate", "onDestroy", "refreshLayoutConfigIfNeed", "kvData", "onChanged", "Lwo0/a;", "<set-?>", "miniGameAudienceService", "Lwo0/a;", "getMiniGameAudienceService", "()Lwo0/a;", "setMiniGameAudienceService", "(Lwo0/a;)V", "", "isAnchor", "Z", "()Z", "isInLive", "Lvlc/l;", "messageListener", "Lvlc/l;", "", "getRoomStartTimeStamp", "()J", "roomStartTimeStamp", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/view/ViewGroup;", "containerView", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Landroid/view/ViewGroup;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniGameContext extends MiniGameContext implements Observer<KVData> {
    public static final a Companion = null;
    public static final String TAG = "AudienceMiniGameContext";
    private final boolean isAnchor;
    private final boolean isInLive;
    private final l messageListener;
    private wo0.a miniGameAudienceService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements l {
        public final /* synthetic */ AudienceMiniGameContext a;

        public b(AudienceMiniGameContext r1) {
            this.a = r1;
        }

        public final void onMessage(d r4) {
            if ((r4 instanceof qn) == false) goto L25;
            qn r5 = (qn) r4;
            qn.a r0 = r5.anchorInstantPlayChange;
            String r1 = null;
            if (r0 == null) goto L7;
            String r2 = r0.microGameId;
        L8:
            MiniGameDataContext.Companion.getClass();
            MiniGameDataContext r3 = MiniGameDataContext.a.a();
            if (r3 == null) goto L14;
            m<String> r6 = r3.getGameId();
            if (r6 == null) goto L14;
            r1 = (String) r6.getValue();
        L14:
            if (Intrinsics.areEqual(r2, r1) == false) goto L28;
            MiniGameDataContext r7 = MiniGameDataContext.a.a();
            if (r7 == null) goto L29;
            m<Integer> r8 = r7.getInstantPlayToggleStatus();
            if (r8 == null) goto L30;
            qn.a r9 = r5.anchorInstantPlayChange;
            if (r9 == null) goto L22;
            int r10 = r9.toggleOnStatus;
        L23:
            r8.setValue(Integer.valueOf(r10));
            return;
        L22:
            r10 = 0;
            goto L23
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L7:
            r2 = null;
            goto L8
        L25:
            if ((r4 instanceof rn) == false) goto L32;
            StringBuilder r11 = new StringBuilder("msg = ");
            rn r12 = (rn) r4;
            r11.append(r12.getGameId());
            r11.append(", ");
            r11.append(r12.getExtra());
            ALogger.d(AudienceMiniGameContext.TAG, r11.toString());
            this.a.refreshLayoutConfigIfNeed();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AudienceMiniGameContext a;

        public c(AudienceMiniGameContext r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((Boolean) r1).booleanValue() == true) goto L6;
            this.a.refreshLayoutConfigIfNeed();
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    private final long getRoomStartTimeStamp() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, getDataCenter(), 0, 2);
        if (r0 == null) goto L9;
        m r1 = r0.getEnterRoomTimeStamp();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return -1;
    }

    public final void refreshLayoutConfigIfNeed() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.getCurrentScene();
    L6:
        if (r2 == 0) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L13;
        IInteractService r3 = (IInteractService) k.f(IInteractService.class);
        if (r3 == null) goto L14;
        r3.refreshLayoutConfig();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        ALogger.i(TAG, "onCreate");
        OpenPlatformMgAudienceServiceImpl.Companion.getClass();
        po0.a.b r0 = (po0.a.b) OpenPlatformMgAudienceServiceImpl.access$getDiComponent$cp();
        r0.getClass();
        setMiniGameAudienceService((wo0.a) r0.a.f.get());
        wo0.a r1 = this.miniGameAudienceService;
        if (r1 == null) goto L5;
        r1.b(this);
    L5:
        ((CandyToolbarContextService) getService(CandyToolbarContextService.class)).i(getRoomStartTimeStamp());
        ((AudiencePublishEventService) getService(AudiencePublishEventService.class)).f();
        DataCenter r2 = getDataCenter();
        vlc.d r3 = null;
        if (r2 == null) goto L8;
        r3 = (vlc.d) r2.get("data_message_manager", null);
    L8:
        if (r3 == null) goto L10;
        r3.addMessageListener(MessageType.ANCHOR_INSTANT_PLAY_CHANGE_MESSAGE.getIntType(), this.messageListener);
    L10:
        if (r3 == null) goto L12;
        r3.addMessageListener(MessageType.GAME_START_CASTING_MESSAGE.getIntType(), this.messageListener);
    L12:
        AudienceMiniGameDataContext.Companion.getClass();
        AudienceMiniGameDataContext r4 = AudienceMiniGameDataContext.a.a();
        if (r4 == null) goto L21;
        m<Boolean> r5 = r4.isCandyToolbarShow();
        if (r5 == null) goto L21;
        Observable r6 = r5.a();
        if (r6 == null) goto L21;
        Disposable r7 = r6.subscribe(new c(this));
        if (r7 == null) goto L21;
        autoDispose(r7);
    L21:
        DataCenter r8 = getDataCenter();
        if (r8 == null) goto L25;
        r8.observeForever("data_link_state", this);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        super.onDestroy();
        wo0.a r0 = this.miniGameAudienceService;
        vlc.d r1 = null;
        if (r0 == null) goto L5;
        r0.b(null);
    L5:
        DataCenter r2 = getDataCenter();
        if (r2 == null) goto L8;
        r1 = (vlc.d) r2.get("data_message_manager", null);
    L8:
        if (r1 == null) goto L10;
        r1.removeMessageListener(MessageType.ANCHOR_INSTANT_PLAY_CHANGE_MESSAGE.getIntType(), this.messageListener);
    L10:
        if (r1 == null) goto L12;
        r1.removeMessageListener(MessageType.GAME_START_CASTING_MESSAGE.getIntType(), this.messageListener);
    L12:
        DataCenter r3 = getDataCenter();
        if (r3 == null) goto L15;
        r3.removeObserver(this);
    L15:
        dispose();
    }

    public final wo0.a getMiniGameAudienceService() {
        return this.miniGameAudienceService;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isAnchor() {
        return this.isAnchor;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isInLive() {
        return this.isInLive;
    }

    public void onChanged(KVData r4) {
        if (r4 == null) goto L15;
        String r0 = r4.getKey();
        if (r0.hashCode() == 872172481) goto L7;
        return;
    L7:
        if (r0.equals("data_link_state") == false) goto L16;
        Integer r5 = (Integer) r4.getData();
        if (r5 != null) goto L11;
        r5 = 0;
    L11:
        int r6 = r5.intValue();
        ALogger.i(TAG, "update linkState: " + r6);
        if (r6 != 32) goto L17;
        ((BridgeContextService) getService(BridgeContextService.class)).g("command_close_live_window", null);
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext
    public void onMiniGameInstanceCreate(MiniAppInstance r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        super.onMiniGameInstanceCreate(r3);
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_little_window_close", new ir0.b(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_instant_play_status", new lr0.b(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_instant_play_sync_progress", new ir0.a(this));
    }

    @Inject
    public final void setMiniGameAudienceService(wo0.a r1) {
        this.miniGameAudienceService = r1;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    public AudienceMiniGameContext(Context r2, DataCenter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.isInLive = true;
        this.messageListener = new b(this);
    }
}
