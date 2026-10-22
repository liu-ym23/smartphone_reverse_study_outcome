package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceMonitorContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceSource;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.EntranceType;
import com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ToolbarComponentCheckInterface {
    public final /* synthetic */ AudienceShelfInfoService a;

    public c(AudienceShelfInfoService r1) {
        this.a = r1;
    }

    public final boolean checkThenLoad(ToolbarMatchInterface r10, final Function0<Unit> r11, final Function1<? super String, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r11, "loadButton");
        Intrinsics.checkNotNullParameter(r12, "stopLoadCallback");
        final AudienceShelfInfoService r3 = this.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r11, "loadButton");
        Intrinsics.checkNotNullParameter(r12, "stopLoadCallback");
        String r2 = r10.getComponentExtra();
        int r4 = r10.getSource();
        if (r4 == 0) goto L29;
        if (r4 != 1) goto L30;
        int r13 = qo0.a.a;
        qo0.a.c("AudienceShelfInfoService", "shelf toolbar message from im, extras: " + r2);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L9
        Object r15 = Result.constructor-impl((com.bytedance.android.live.openplatform.api.model.shelf.c) GsonHelper.get().fromJson(r2, com.bytedance.android.live.openplatform.api.model.shelf.c.class));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r15) == false) goto L14;
        r15 = null;
    L14:
        com.bytedance.android.live.openplatform.api.model.shelf.c r16 = (com.bytedance.android.live.openplatform.api.model.shelf.c) r15;
        if (r16 == null) goto L17;
        ShelfInfo r17 = r16.shelfInfo;
    L18:
        if (r17 != null) goto L21;
        r12.invoke("shelf info is null");
        qo0.a.c("AudienceShelfInfoService", "shelf info is null");
        goto L30
    L21:
        if (r17.status != 1) goto L28;
        ShelfMicroAppInfo r18 = r17.appInfo;
        if (r18 == null) goto L26;
        String r19 = r18.appId;
        if (r19 == null) goto L26;
    L27:
        EntranceSource r0 = EntranceSource.ImMessage;
        ShowEntranceTask r1 = ((EntranceMonitorContextService) r3.getOpenPlatformContext().getService(EntranceMonitorContextService.class)).f(EntranceType.Shelf);
        Intrinsics.checkNotNullParameter(r19, "mpId");
        Intrinsics.checkNotNullParameter(r0, "entranceSource");
        StateMachine<ShowEntranceTask.d, ShowEntranceTask.a, ShowEntranceTask.c> r5 = r1.d;
        ShowEntranceTask.a.c r6 = ShowEntranceTask.a.c.a;
        StateMachine.a r7 = StateMachine.c;
        r5.d(r6, null);
        r1.b = r19;
        r1.c = r0;
        r1.d.d(ShowEntranceTask.a.C0154a.a, null);
    L26:
        r19 = "";
    L28:
        HashMap<String, f> r110 = g.a;
        h.b(PerformanceScene.SHELF_REQUEST).o();
        r3.k(true, r11, new AudienceShelfInfoService$onReceiveToolbarData$2(r3, r12));
        goto L30
    L17:
        r17 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L30:
        return true;
    L29:
        int r9 = qo0.a.a;
        qo0.a.c("AudienceShelfInfoService", "shelf toolbar message from enter room, extras: " + r2);
        Function1<String, Unit> r20 = new AudienceShelfInfoService$onReceiveToolbarData$loadFail$1(r3, r12);
        EnterRoomShelfInfoStateMachine r111 = r3.a;
        Function0<Unit> r21 = new AudienceShelfInfoService$onReceiveToolbarData$1(r3, r11);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r21, "loadButton");
        Intrinsics.checkNotNullParameter(r20, "loadFail");
        StateMachine<EnterRoomShelfInfoStateMachine.c, EnterRoomShelfInfoStateMachine.a, EnterRoomShelfInfoStateMachine.b> r112 = r111.a;
        EnterRoomShelfInfoStateMachine.a.c r113 = new EnterRoomShelfInfoStateMachine.a.c(new EnterRoomShelfInfoStateMachine.e(r10, r21, r20));
        StateMachine.a r114 = StateMachine.c;
        r112.d(r113, null);
        goto L30
    }
}
