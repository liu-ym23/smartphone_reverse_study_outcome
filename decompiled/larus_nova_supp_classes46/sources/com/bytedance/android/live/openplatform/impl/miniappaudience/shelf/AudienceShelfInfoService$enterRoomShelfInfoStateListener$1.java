package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceMonitorContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceType;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask;
import com.bytedance.android.live.openplatform.impl.miniappcommon.monitor.MiniAppMonitor;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AudienceShelfInfoService$enterRoomShelfInfoStateListener$1 implements EnterRoomShelfInfoStateMachine.d {
    public final /* synthetic */ AudienceShelfInfoService a;

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine.d
    public final void a() {
        final AudienceShelfInfoService r7 = this.a;
        int r1 = AudienceShelfInfoService.e;
        final long r5 = r7.getOpenPlatformContext().getRoomId();
        int r2 = qo0.a.a;
        qo0.a.c("AudienceShelfInfoService", "start get shelf info from backend, room id: " + r5);
        HashMap<String, f> r3 = g.a;
        h.b(PerformanceScene.SHELF_REQUEST).o();
        final long r17 = SystemClock.uptimeMillis();
        ((OpenPlatformPerformanceReportService) r7.getOpenPlatformContext().getService(OpenPlatformPerformanceReportService.class)).getClass();
        OpenPlatformPerformanceReportService.i(r5, 1, "begin", 0, "", 0);
        StateMachine<ShowEntranceTask.d, ShowEntranceTask.a, ShowEntranceTask.c> r4 = ((EntranceMonitorContextService) r7.getOpenPlatformContext().getService(EntranceMonitorContextService.class)).f(EntranceType.Shelf).d;
        ShowEntranceTask.a.d r6 = ShowEntranceTask.a.d.a;
        StateMachine.a r8 = StateMachine.c;
        r4.d(r6, null);
        r7.c = new CompositeDisposable();
        IRoomModuleService r9 = k.f(IRoomModuleService.class);
        if (r9 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.room.backend.g r19 = r9.getLiveRoomBackendUtils();
        if (r19 == null) goto L16;
        long r20 = r7.getOpenPlatformContext().getRoomId();
        Function0<Unit> r10 = new AudienceShelfInfoService$doSubscribeBackendData$1(r7);
        Function2<Long, String, Unit> r25 = new AudienceShelfInfoService$doSubscribeBackendData$2(r7, r17, r5);
        Function3<tq0.a, BackendGeneratedData, BackendItem, Unit> r26 = new AudienceShelfInfoService$doSubscribeBackendData$3(r7, r17, r5);
        CompositeDisposable r11 = r7.c;
        de0 r12 = de0.a;
        if (((wc1) r12.getValue()).c() != 1) goto L9;
    L12:
        boolean r31 = true;
    L13:
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r19, r20, null, tq0.a.class, r10, r25, r26, null, null, r11, false, r31, 2754);
        return;
    L9:
        if (((wc1) r12.getValue()).e() == true) goto L12;
        r31 = false;
        goto L13
    L16:
        return;
    }

    public AudienceShelfInfoService$enterRoomShelfInfoStateListener$1(AudienceShelfInfoService r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine.d
    public final void b(tq0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        if (r4.disableEntrance == true) goto L8;
        ShelfInfo r5 = r4.shelfInfo;
        if (r5 == null) goto L9;
        AudienceShelfInfoService.h(this.a, r5);
        AudienceShelfInfoService r0 = this.a;
        AudienceShelfInfoService.g(r0, r0.d, r5, false);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine.d
    public final void d(EnterRoomShelfInfoStateMachine.e r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "toolbarData");
        Object r1 = null;
        if (r8 == false) goto L5;
        qo0.a.c("AudienceShelfInfoService", "get shelf info fallback to request ");
        HashMap<String, f> r9 = g.a;
        f r10 = h.b(PerformanceScene.SHELF_REQUEST);
        int r2 = f.d;
        r10.l("audience_backend_end", null);
        r10.m("audience_is_backend_sucess", false);
    L6:
        AudienceShelfInfoService r11 = this.a;
        ToolbarMatchInterface r3 = r7.a;
        Function0<Unit> r4 = r7.b;
        Function1<String, Unit> r12 = r7.c;
        int r5 = AudienceShelfInfoService.e;
        r11.getClass();
        Type r6 = new b().getType();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L9
        Object r14 = Result.constructor-impl((List) GsonHelper.get().fromJson(r3.getComponentExtra(), r6));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r14) == true) goto L15;
        r1 = r14;
    L15:
        List r15 = (List) r1;
        if (r15 != null) goto L18;
        r15 = CollectionsKt.emptyList();
    L18:
        RoomStampInfo r16 = (RoomStampInfo) CollectionsKt.lastOrNull(r15);
        if (r16 != null) goto L21;
        int r17 = MiniAppMonitor.a;
        MiniAppMonitor.a(MiniAppMonitor.ExceptionType.Room, "room stamp is empty");
        r12.invoke("room stamp is empty");
        return;
    L21:
        if (r16.getType() == 4) goto L23;
        return;
    L23:
        if (r16.getStatus() != 0) goto L25;
    L30:
        r11.k(false, r4, r12);
        return;
    L25:
        if (r16.getStatus() == 1) goto L30;
        if (r16.getStatus() != 3) goto L36;
        int r18 = MiniAppMonitor.a;
        MiniAppMonitor.a(MiniAppMonitor.ExceptionType.Room, "room is punished");
        r12.invoke("room is punished");
        return;
    L36:
        return;
    L9:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        HashMap<String, f> r20 = g.a;
        h.b(PerformanceScene.SHELF_REQUEST).o();
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine.d
    public final void c(final EnterRoomShelfInfoStateMachine.e r3, tq0.a r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "toolbarData");
        Intrinsics.checkNotNullParameter(r4, "response");
        AudienceShelfInfoService.f(this.a, false, r4, new AudienceShelfInfoService$enterRoomShelfInfoStateListener$1$showSnowFlakeAndExplainCardIfNeeded$1(this, r5, r3), r3.c);
    }
}
