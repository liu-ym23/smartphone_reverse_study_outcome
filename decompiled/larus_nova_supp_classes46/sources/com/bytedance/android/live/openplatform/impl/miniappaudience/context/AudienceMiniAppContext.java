package com.bytedance.android.live.openplatform.impl.miniappaudience.context;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.utils.g;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAudienceServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.utils.ImageLoader;
import com.bytedance.android.live.openplatform.impl.miniappaudience.comment.AudienceCommentContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.debug.MiniAppAudienceDebugContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceMonitorContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceSource;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceType;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.im.AudienceImContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.openapi.MiniAppAudienceOpenApiHandler;
import com.bytedance.android.live.openplatform.impl.miniappaudience.privatemsg.AudiencePrivateMsgContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService$enterRoomShelfInfoStateListener$1;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfSupplementInfoContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine;
import com.bytedance.android.live.openplatform.impl.miniappcommon.bridge.BridgeContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.o90;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdk.config.yc1;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.InteractOpenExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import ko0.e;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001+B\u0019\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016R.\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00188\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R\u001a\u0010#\u001a\u00020\u001f8\u0016X\u0096D¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b#\u0010\"¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/context/AudienceMiniAppContext;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/MiniAppContext;", "Lh80/a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "consumer", "", "runWithRoomEntered", "onCreate", "Lro0/a;", "manager", "onMessageManagerInitialized", "onDestroy", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "instance", "onMiniAppInstanceCreate", "onMiniAppInstanceDestroy", "Lto0/a;", "<set-?>", "miniAppAudienceService", "Lto0/a;", "getMiniAppAudienceService", "()Lto0/a;", "setMiniAppAudienceService", "(Lto0/a;)V", "Lyo0/b;", "openApiService", "Lyo0/b;", "getOpenApiService", "()Lyo0/b;", "setOpenApiService", "(Lyo0/b;)V", "", "isAnchor", "Z", "()Z", "isInLive", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniAppContext extends MiniAppContext {
    public static final a Companion = null;
    private static final String TAG = "AudienceMiniAppContext";
    private final boolean isAnchor;
    private final boolean isInLive;
    private to0.a miniAppAudienceService;
    private yo0.b openApiService;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements h80.a {
        public final /* synthetic */ AudienceMiniAppContext a;

        public b(AudienceMiniAppContext r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            ShowEntranceTask r0 = ((EntranceMonitorContextService) this.a.getService(EntranceMonitorContextService.class)).f(EntranceType.Shelf);
            String r8 = ((RoomStampInfo) r7).getId();
            EntranceSource r1 = EntranceSource.EnterRoom;
            Intrinsics.checkNotNullParameter(r8, "mpId");
            Intrinsics.checkNotNullParameter(r1, "entranceSource");
            StateMachine<ShowEntranceTask.d, ShowEntranceTask.a, ShowEntranceTask.c> r2 = r0.d;
            ShowEntranceTask.a.c r3 = ShowEntranceTask.a.c.a;
            StateMachine.a r4 = StateMachine.c;
            String r5 = null;
            r2.d(r3, null);
            r0.b = r8;
            r0.c = r1;
            r0.d.d(ShowEntranceTask.a.C0154a.a, null);
            AudienceExplainCardContextService r9 = (AudienceExplainCardContextService) this.a.getService(AudienceExplainCardContextService.class);
            r9.getClass();
            de0 r6 = de0.a;
            if (((wc1) r6.getValue()).f() == false) goto L6;
            new AsyncLayoutInflater(r9.getOpenPlatformContext().getContext()).inflate(com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.c.b(), new FrameLayout(r9.getOpenPlatformContext().getContext()), new com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.a(r9));
        L6:
            ImageLoader r10 = ImageLoader.a;
            if (((wc1) r6.getValue()).k() != 1) goto L26;
            e.e.getClass();
            o90 r11 = o90.a;
            String r12 = ((yc1) r11.getValue()).h();
            if (r2.a(r12) == true) goto L12;
            r12 = null;
        L12:
            if (r12 == null) goto L14;
            ImageLoader.e(r12);
        L14:
            String r13 = ((yc1) r11.getValue()).c();
            if (((wc1) r6.getValue()).i() == 1) goto L17;
        L19:
            boolean r14 = false;
        L20:
            if (r14 == true) goto L23;
            r13 = null;
        L23:
            if (r13 == null) goto L26;
            ImageLoader.e(r13);
            goto L26
        L17:
            if (r2.a(r13) == false) goto L19;
            r14 = true;
        L26:
            if (((wc1) r6.getValue()).l() != 1) goto L35;
            String r15 = ((yc1) o90.a.getValue()).b();
            if (r15 != null) goto L30;
            return;
        L30:
            if (r2.a(r15) == false) goto L32;
            r5 = r15;
        L32:
            if (r5 == null) goto L37;
            ImageLoader.e(r5);
            return;
        L37:
            return;
        }
    }

    public static final class c<T> implements h80.a {
        public final /* synthetic */ AudienceMiniAppContext a;

        public c(AudienceMiniAppContext r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            Room r13 = (Room) r12;
            MiniAppAudienceDebugContextService r14 = (MiniAppAudienceDebugContextService) this.a.getService(MiniAppAudienceDebugContextService.class);
            LinkedHashMap r0 = new LinkedHashMap();
            r14.getClass();
            Intrinsics.checkNotNullParameter(r0, "extraParams");
            Intrinsics.checkNotNullParameter(r0, "extraParams");
            Room r4 = null;
            RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r1 == null) goto L7;
            m r2 = r1.getRoom();
            if (r2 == null) goto L7;
            r4 = (Room) r2.getValue();
        L7:
            if (r4 == null) goto L47;
            InteractOpenExtra r3 = r4.interactOpenExtra;
            if (r3 == null) goto L14;
            Map r5 = r3.getDebugInfo();
            if (r5 == null) goto L14;
            String r6 = (String) r5.get("app_id");
            if (r6 == null) goto L14;
        L15:
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r14.b = r6;
            InteractOpenExtra r7 = r4.interactOpenExtra;
            if (r7 == null) goto L22;
            Map r8 = r7.getDebugInfo();
            if (r8 == null) goto L22;
            String r9 = (String) r8.get("debug_game_id");
            if (r9 == null) goto L22;
            CastLongProtector.parseLong(r9);
        L22:
            InteractOpenExtra r10 = r4.interactOpenExtra;
            if (r10 == null) goto L29;
            Map r11 = r10.getDebugInfo();
            if (r11 == null) goto L29;
            String r15 = (String) r11.get("app_kind");
            if (r15 == null) goto L29;
            long r16 = CastLongProtector.parseLong(r15);
        L30:
            long r17 = r16;
            long r18 = r4.id;
            String r19 = r14.b;
            InteractOpenExtra r20 = r4.interactOpenExtra;
            if (r20 == null) goto L48;
            Map r21 = r20.getDebugInfo();
            if (r21 == null) goto L49;
            String r22 = (String) r21.get("develop");
            if (r22 == null) goto L50;
            int r23 = CastIntegerProtector.parseInt(r22);
            InteractOpenExtra r24 = r4.interactOpenExtra;
            if (r24 == null) goto L51;
            Map r25 = r24.getDebugInfo();
            if (r25 == null) goto L52;
            String r110 = (String) r25.get("sign");
            if (r110 != null) goto L44;
            return;
        L44:
            if (r14.f(r18, r19, r23, r110, r17) == true) goto L53;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r14.b = "";
            return;
        L53:
            return;
        L52:
            return;
        L51:
            return;
        L50:
            return;
        L49:
            return;
        L48:
            return;
        L29:
            r16 = -1;
        L14:
            r6 = "";
            goto L15
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ h80.a a;

        public d(h80.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.accept(sh6.c.b((sh6.b) r2));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 == null) goto L5;
        r0.b(null);
    L5:
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        if (r1 == null) goto L10;
        n<ShelfInfo> r2 = r1.m618getShelfInfo();
        if (r2 == null) goto L10;
        r2.setValue(null);
    L10:
        super.onDestroy();
        int r3 = qo0.a.a;
        qo0.a.c(TAG, "onDestroy, room id: " + getRoomId());
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        int r0 = qo0.a.a;
        qo0.a.c(TAG, "onCreate, room id: " + getRoomId());
        OpenPlatformAudienceServiceImpl.Companion.getClass();
        po0.a.b r1 = (po0.a.b) OpenPlatformAudienceServiceImpl.access$getDiComponent$cp();
        r1.getClass();
        po0.a.b r2 = r1.a;
        setMiniAppAudienceService((to0.a) r2.d.get());
        setOpenApiService((yo0.b) r2.c.get());
        int r3 = g.a;
        Room r4 = getRoom();
        b r5 = new b(this);
        Intrinsics.checkNotNullParameter(r5, "consumer");
        if (r4 == null) goto L5;
        List r6 = r4.getRoomStamps();
    L6:
        if (r6 == null) goto L16;
        RoomStampInfo r7 = (RoomStampInfo) CollectionsKt.getOrNull(r6, 0);
        if (r7 == null) goto L16;
        if (r7.getType() != 4) goto L16;
        if (r7.getStatus() != 0) goto L14;
    L15:
        r5.accept(r7);
        goto L16
    L14:
        if (r7.getStatus() == 1) goto L15;
    L16:
        AudienceShelfInfoService r8 = (AudienceShelfInfoService) getService(AudienceShelfInfoService.class);
        EnterRoomShelfInfoStateMachine r9 = r8.a;
        AudienceShelfInfoService$enterRoomShelfInfoStateListener$1 r10 = r8.b;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "listener");
        r9.b = r10;
        StateMachine<EnterRoomShelfInfoStateMachine.c, EnterRoomShelfInfoStateMachine.a, EnterRoomShelfInfoStateMachine.b> r11 = r8.a.a;
        EnterRoomShelfInfoStateMachine.a.d r12 = EnterRoomShelfInfoStateMachine.a.d.a;
        StateMachine.a r13 = StateMachine.c;
        r11.d(r12, null);
        Lazy r14 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r8.getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.MiniApp.INSTANCE, new com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.c(r8));
        ((AudienceCommentContextService) getService(AudienceCommentContextService.class)).f();
        ((AudienceHighIntentionContextService) getService(AudienceHighIntentionContextService.class)).g();
        ((AudienceShelfSupplementInfoContextService) getService(AudienceShelfSupplementInfoContextService.class)).h();
        ((AudiencePrivateMsgContextService) getService(AudiencePrivateMsgContextService.class)).g();
        runWithRoomEntered(new c(this));
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext
    public void onMiniAppInstanceDestroy() {
        super.onMiniAppInstanceDestroy();
        if (((uc1) ee0.a.getValue()).c() == true) goto L12;
        yo0.b r0 = this.openApiService;
        if (r0 == null) goto L12;
        MiniAppInstance r1 = getMiniAppInstance();
        if (r1 == null) goto L10;
        String r2 = r1.getAppId();
        if (r2 == null) goto L10;
    L11:
        r0.d(r2);
    L10:
        r2 = "";
    L12:
        ((BridgeContextService) getService(BridgeContextService.class)).i("on_mini_app_clue_complete");
    }

    public final to0.a getMiniAppAudienceService() {
        return this.miniAppAudienceService;
    }

    public final yo0.b getOpenApiService() {
        return this.openApiService;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isAnchor() {
        return this.isAnchor;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isInLive() {
        return this.isInLive;
    }

    private final void runWithRoomEntered(h80.a<Room> r6) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return;
    L5:
        Room r1 = (Room) r0.getInteractionDataPrepared().getValue();
        if (r1 == null) goto L8;
        r6.accept(r1);
        return;
    L8:
        autoDispose(r0.getInteractionDataPrepared().a().subscribe(new d(r6)));
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onMessageManagerInitialized(ro0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        super.onMessageManagerInitialized(r4);
        AudienceImContextService r1 = (AudienceImContextService) getService(AudienceImContextService.class);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "manager");
        Intrinsics.checkNotNullParameter(r4, "manager");
        r4.a(new com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.a(r1.getOpenPlatformContext()));
        r4.a(new nq0.a(r1.getOpenPlatformContext()));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext
    public void onMiniAppInstanceCreate(MiniAppInstance r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        super.onMiniAppInstanceCreate(r3);
        if (((uc1) ee0.a.getValue()).c() == true) goto L7;
        yo0.b r0 = this.openApiService;
        if (r0 == null) goto L7;
        r0.b(new MiniAppAudienceOpenApiHandler(this, r3.getAppId()));
    L7:
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_app_clue_complete", new lq0.a(this));
    }

    @Inject
    public final void setMiniAppAudienceService(to0.a r1) {
        this.miniAppAudienceService = r1;
    }

    @Inject
    public final void setOpenApiService(yo0.b r1) {
        this.openApiService = r1;
    }

    public AudienceMiniAppContext(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.isInLive = true;
    }
}
