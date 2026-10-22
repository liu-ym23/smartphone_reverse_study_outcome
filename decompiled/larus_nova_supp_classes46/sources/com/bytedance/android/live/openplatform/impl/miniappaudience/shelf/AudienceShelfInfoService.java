package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.ImageLoader;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceMonitorContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceType;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceLynxExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.SnowToolbarContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.api.MiniAppEntranceApi;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.ShelfInfoContextService;
import com.bytedance.android.live.room.api.messagewindow.state.CardAction;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/AudienceShelfInfoService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/ShelfInfoContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceShelfInfoService extends ShelfInfoContextService {
    public static final /* synthetic */ int e = 0;
    public final EnterRoomShelfInfoStateMachine a;
    public final AudienceShelfInfoService$enterRoomShelfInfoStateListener$1 b;
    public CompositeDisposable c;
    public ShelfInfo d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            e r3 = (e) r2;
            qo0.a.c("AudienceShelfInfoService", "request shelf/visit/ success");
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            qo0.a.b("AudienceShelfInfoService", "request shelf/visit/ fail", (Throwable) r3);
        }
    }

    static {
    }

    public final void j() {
        this.d = null;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        if (r1 == null) goto L8;
        n<ShelfInfo> r2 = r1.m618getShelfInfo();
        if (r2 == null) goto L8;
        r2.setValue(null);
    L8:
        if (m71.e.c(10) == false) goto L12;
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r0 = ((AudienceLynxExplainCardContextService) getOpenPlatformContext().getService(AudienceLynxExplainCardContextService.class)).a;
        if (r0 == null) goto L14;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r3 = r0.a;
        r3.getClass();
        xs2.b.a().post(new z61.a(CardAction.HIDE, r3));
        return;
    L14:
        return;
    L12:
        AudienceExplainCardContextService r4 = (AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class);
        int r5 = AudienceExplainCardContextService.h;
        r4.f(false);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        Lazy r0 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.g(getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.MiniApp.INSTANCE);
        CompositeDisposable r1 = this.c;
        if (r1 == null) goto L6;
        r1.clear();
        return;
    }

    public AudienceShelfInfoService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new EnterRoomShelfInfoStateMachine(r2);
        this.b = new AudienceShelfInfoService$enterRoomShelfInfoStateListener$1(this);
    }

    public static final void h(AudienceShelfInfoService r1, ShelfInfo r2) {
        r1.getClass();
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        n<ShelfInfo> r3 = r0.m618getShelfInfo();
        if (r3 == null) goto L7;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
    L8:
        r1.d = r4;
        AudienceMiniAppDataContext r5 = AudienceMiniAppDataContext.a.a();
        if (r5 == null) goto L14;
        n<ShelfInfo> r6 = r5.m618getShelfInfo();
        if (r6 == null) goto L15;
        r6.setValue(r2);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void l(String r3, JSONObject r4) {
        ((EntranceMonitorContextService) getOpenPlatformContext().getService(EntranceMonitorContextService.class)).f(EntranceType.Shelf).a(r3, r4);
    }

    public final void m(int r12, long r13) {
        Lazy r0 = LiveOpenPlatformClient.c;
        MiniAppEntranceApi r1 = (MiniAppEntranceApi) LiveOpenPlatformClient.a.a().a(MiniAppEntranceApi.class);
        long r2 = getOpenPlatformContext().getRoomId();
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r3 = MiniAppDataContext.a.b();
        if (r3 == null) goto L8;
        ShelfMicroAppInfo r4 = r3.appInfo;
        if (r4 == null) goto L8;
        String r5 = r4.appId;
        if (r5 == null) goto L8;
    L9:
        String r6 = r5;
        long r8 = System.currentTimeMillis() / ((long) 1000);
        IUserService r7 = k.f(IUserService.class);
        if (r7 == null) goto L15;
        f r9 = r7.user();
        if (r9 == null) goto L15;
        String r10 = r9.n();
        if (r10 == null) goto L15;
    L16:
        autoDispose(r1.visitShelf(r2, r6, r13, r12, r8, r10).subscribe(b.a, c.a));
        return;
    L15:
        r10 = "0";
    L8:
        r5 = "";
        goto L9
    }

    public final void k(final boolean r5, final Function0<Unit> r6, final Function1<? super String, Unit> r7) {
        int r0 = qo0.a.a;
        qo0.a.c("AudienceShelfInfoService", "request shelf/info, isFromIm: " + r5);
        HashMap<String, zo0.f> r1 = g.a;
        zo0.f r2 = h.b(PerformanceScene.SHELF_REQUEST);
        int r3 = zo0.f.d;
        r2.l("audience_request_start", null);
        StateMachine<ShowEntranceTask.d, ShowEntranceTask.a, ShowEntranceTask.c> r4 = ((EntranceMonitorContextService) getOpenPlatformContext().getService(EntranceMonitorContextService.class)).f(EntranceType.Shelf).d;
        ShowEntranceTask.a.d r8 = ShowEntranceTask.a.d.a;
        StateMachine.a r9 = StateMachine.c;
        r4.d(r8, null);
        requestShelfInfo(new AudienceShelfInfoService$doRequestShelfInfo$1(this, r5, r6, r7), new AudienceShelfInfoService$doRequestShelfInfo$2(this, r7));
    }

    public static final void g(AudienceShelfInfoService r6, ShelfInfo r7, ShelfInfo r8, boolean r9) {
        r6.getClass();
        com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b r0 = com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.c.a(r7);
        com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b r1 = com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.c.a(r8);
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r7) == false) goto L7;
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r8) == true) goto L7;
    L10:
        boolean r10 = true;
    L12:
        String r2 = null;
        if (r10 == true) goto L15;
    L19:
        if (r1 != null) goto L21;
        AudienceExplainCardContextService r11 = (AudienceExplainCardContextService) r6.getOpenPlatformContext().getService(AudienceExplainCardContextService.class);
        int r12 = AudienceExplainCardContextService.h;
        r11.f(false);
        return;
    L21:
        if ((!Intrinsics.areEqual(r1, r0)) == false) goto L32;
        if (r9 == false) goto L24;
    L31:
        AudienceExplainCardContextService.i((AudienceExplainCardContextService) r6.getOpenPlatformContext().getService(AudienceExplainCardContextService.class), r8, !r9, false, 4);
        return;
    L24:
        if (((wc1) de0.a.getValue()).d() == true) goto L31;
        ImageLoader r13 = ImageLoader.a;
        ImageLoader.d(r1.h);
        ImageLoader.d(r1.d);
        ImageModel r14 = r1.e;
        if (r14 == null) goto L30;
        List r15 = r14.getUrls();
        if (r15 == null) goto L30;
        r2 = (String) CollectionsKt.firstOrNull(r15);
    L30:
        ImageLoader.d(r2);
        goto L31
    L32:
        qo0.a.c("AudienceShelfInfoService", "explain card info is not changed");
        return;
    L15:
        if (((AudienceExplainCardContextService) r6.getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).b == false) goto L19;
        if (Intrinsics.areEqual(r0, r1) == false) goto L19;
        AudienceMiniAppAppLogContextService.reportMpLivePopupCardShow$default((AudienceMiniAppAppLogContextService) r6.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class), null, 1, null);
    L7:
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r7) == false) goto L9;
    L11:
        r10 = false;
        goto L12
    L9:
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r8) == false) goto L11;
        goto L10
    }

    public static final void f(AudienceShelfInfoService r4, boolean r5, tq0.a r6, Function1 r7, Function1 r8) {
        r4.getClass();
        if (r5 == true) goto L5;
        int r9 = qo0.a.a;
        qo0.a.c("Perf", "request shelf/info/ success on enter room, curr time: " + SystemClock.uptimeMillis());
    L5:
        ShelfInfo r10 = r6.shelfInfo;
        if (r6.disableEntrance == false) goto L10;
        r4.l("entrance disable", null);
        if (r8 == null) goto L23;
        Unit r11 = (Unit) r8.invoke("entrance disable");
        return;
    L23:
        return;
    L10:
        if (r10 != null) goto L14;
        r4.l("request shelf/info is empty", null);
        if (r8 == null) goto L25;
        Unit r12 = (Unit) r8.invoke("request shelf/info is empty");
        return;
    L25:
        return;
    L14:
        long r0 = r10.status;
        if (r0 != 1) goto L17;
    L21:
        r7.invoke(r10);
        return;
    L17:
        if (r0 == 2) goto L21;
        if (r8 == null) goto L27;
        Unit r13 = (Unit) r8.invoke("shelf is hide");
        return;
    }

    public static final void i(AudienceShelfInfoService r7, ShelfInfo r8, ShelfInfo r9, boolean r10, Function0 r11) {
        r7.getClass();
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r8) == false) goto L7;
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r9) == true) goto L7;
    L10:
        boolean r12 = true;
    L12:
        if (r12 == false) goto L17;
        int r13 = qo0.a.a;
        qo0.a.c("AudienceShelfInfoService", "coexist status changed, has coexist component: " + com.bytedance.android.live.openplatform.api.model.shelf.g.c(r9));
        if (y3.m(r7.getOpenPlatformContext().getDataCenter()).n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == false) goto L17;
        ((SnowToolbarContextService) r7.getOpenPlatformContext().getService(SnowToolbarContextService.class)).l();
    L17:
        if (r10 == true) goto L19;
    L20:
        HashMap<String, zo0.f> r14 = g.a;
        zo0.f r15 = h.b(PerformanceScene.SNOW_FLAKE);
        r15.o();
        r15.m("is_from_enter", !r10);
        StateMachine<ShowEntranceTask.d, ShowEntranceTask.a, ShowEntranceTask.c> r16 = ((EntranceMonitorContextService) r7.getOpenPlatformContext().getService(EntranceMonitorContextService.class)).f(EntranceType.Shelf).d;
        ShowEntranceTask.a.e r17 = ShowEntranceTask.a.e.a;
        StateMachine.a r0 = StateMachine.c;
        r16.d(r17, null);
    L21:
        SnowToolbarContextService r18 = (SnowToolbarContextService) r7.getOpenPlatformContext().getService(SnowToolbarContextService.class);
        r18.getClass();
        qo0.a.c("SnowToolbarContextService", "show snow flake");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r19 = AudienceMiniAppDataContext.a.a();
        if (r19 == null) goto L40;
        n<ShelfInfo> r20 = r19.m618getShelfInfo();
        if (r20 == null) goto L40;
        ShelfInfo r21 = (ShelfInfo) r20.getValue();
        if (r21 == null) goto L40;
        List<ShelfCardInfo> r22 = r21.cardInfoList;
        if (r22 == null) goto L40;
        ListIterator<ShelfCardInfo> r23 = r22.listIterator(r22.size());
    L31:
        if (r23.hasPrevious() == false) goto L38;
        ShelfCardInfo r110 = r23.previous();
        if (r110.getStatus() != 1) goto L35;
        boolean r1 = true;
    L36:
        if (r1 == false) goto L31;
    L39:
        ShelfCardInfo r111 = r110;
    L41:
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r24 = AudienceMiniAppDataContext.a.a();
        if (r24 == null) goto L50;
        n<ShelfInfo> r25 = r24.m618getShelfInfo();
        if (r25 == null) goto L50;
        ShelfInfo r26 = (ShelfInfo) r25.getValue();
        if (r26 == null) goto L50;
        List<ShelfCardInfo> r27 = r26.cardInfoList;
        if (r27 == null) goto L50;
        ShelfCardInfo r28 = (ShelfCardInfo) ListProtector.get(r27, 0);
    L51:
        m.f(Observable.create(new com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.b(((AudienceLaunchContextService) r18.getOpenPlatformContext().getService(AudienceLaunchContextService.class)).getLaunchSchema(MountedMiniAppSource.ExplainCard))).subscribeOn(Schedulers.io()), null);
        if ((!Intrinsics.areEqual(r111, r28)) == false) goto L55;
        if (r28 == null) goto L55;
        m.f(Observable.create(new com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.c(((AudienceLaunchContextService) r18.getOpenPlatformContext().getService(AudienceLaunchContextService.class)).getLaunchSchema(r28))).subscribeOn(Schedulers.io()), null);
    L55:
        if (r11 == null) goto L63;
        Unit r29 = (Unit) r11.invoke();
        return;
    L63:
        return;
    L50:
        r28 = null;
        goto L51
    L35:
        r1 = false;
        goto L36
    L38:
        r110 = null;
    L40:
        r111 = null;
        goto L41
    L19:
        if (r9.status != 1) goto L21;
    L7:
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r8) == false) goto L9;
    L11:
        r12 = false;
        goto L12
    L9:
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(r9) == false) goto L11;
        goto L10
    }
}
