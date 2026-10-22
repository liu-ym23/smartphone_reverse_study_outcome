package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.memory.MemoryContextService;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.message.model.dm;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends ro0.b<dm> {
    public final MessageType d;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.a$a, reason: collision with other inner class name */
    public static final class C0147a {
    }

    static {
    }

    @Override // ro0.b
    public final MessageType a() {
        return this.d;
    }

    public a(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.d = MessageType.TOOLBAR_CONTROL_MESSAGE;
    }

    @Override // ro0.b
    public final void b(tlc.d r13) {
        dm r14 = (dm) r13;
        Intrinsics.checkNotNullParameter(r14, MultiLinkOpenSource.MESSAGE);
        if (r14.getComponentType() != 3) goto L108;
        int r0 = qo0.a.a;
        qo0.a.c("AnchorShelfInfoMessageListener", "onReceiveMessage: " + r14);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r15 = Result.constructor-impl((com.bytedance.android.live.openplatform.api.model.shelf.c) GsonHelper.get().fromJson(r14.getExtraData(), com.bytedance.android.live.openplatform.api.model.shelf.c.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r15) == false) goto L13;
        r15 = null;
    L13:
        com.bytedance.android.live.openplatform.api.model.shelf.c r16 = (com.bytedance.android.live.openplatform.api.model.shelf.c) r15;
        if (r16 == null) goto L16;
        ShelfInfo r4 = r16.shelfInfo;
    L17:
        if (r4 != null) goto L19;
        qo0.a.c("AnchorShelfInfoMessageListener", "shelf info is null");
        return;
    L19:
        long r2 = r4.status;
        if (r2 != 3) goto L22;
    L25:
        boolean r3 = true;
    L26:
        if (r3 == false) goto L28;
        ((MemoryContextService) this.b.getService(MemoryContextService.class)).g(null);
    L29:
        int r5 = r4.punishStatus;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r6 = AnchorMiniAppDataContext.a.a();
        if (r6 == null) goto L38;
        n<ShelfInfo> r7 = r6.m618getShelfInfo();
        if (r7 == null) goto L38;
        ShelfInfo r8 = (ShelfInfo) r7.getValue();
        if (r8 == null) goto L38;
        if (r5 != r8.punishStatus) goto L38;
    L50:
        if (r4.source == 0) goto L106;
        long r9 = r4.status;
        if (r9 != 3) goto L54;
    L57:
        boolean r10 = true;
    L58:
        String r11 = "";
        if (r10 == false) goto L61;
        AnchorMiniAppAppLogContextService r12 = (AnchorMiniAppAppLogContextService) this.b.getService(AnchorMiniAppAppLogContextService.class);
        AnchorMiniAppDataContext r17 = AnchorMiniAppDataContext.a.a();
        if (r17 == null) goto L92;
        n<ShelfInfo> r18 = r17.m618getShelfInfo();
        if (r18 == null) goto L92;
        ShelfInfo r19 = (ShelfInfo) r18.getValue();
        if (r19 == null) goto L92;
        ShelfMicroAppInfo r20 = r19.appInfo;
        if (r20 == null) goto L92;
        String r21 = r20.appId;
        if (r21 == null) goto L92;
    L93:
        AnchorMiniAppDataContext r22 = AnchorMiniAppDataContext.a.a();
        if (r22 == null) goto L100;
        n<ShelfInfo> r23 = r22.m618getShelfInfo();
        if (r23 == null) goto L100;
        ShelfInfo r24 = (ShelfInfo) r23.getValue();
        if (r24 == null) goto L100;
        String r25 = r24.c();
    L101:
        r12.reportAnchorExitBindSuccess(r21, r25, "", "live_assistant");
        AnchorShelfContextService.onOffShelfSuccess$default((AnchorShelfContextService) this.b.getService(AnchorShelfContextService.class), null, 1, null);
        return;
    L100:
        r25 = "";
    L92:
        r21 = "";
        goto L93
    L61:
        if (r9 != 1) goto L69;
        AnchorMiniAppAppLogContextService r26 = (AnchorMiniAppAppLogContextService) this.b.getService(AnchorMiniAppAppLogContextService.class);
        String r27 = r4.c();
        ShelfMicroAppInfo r28 = r4.appInfo;
        if (r28 == null) goto L68;
        String r29 = r28.appId;
        if (r29 == null) goto L68;
        r11 = r29;
    L68:
        r26.reportAddShelfPageSuccess(r27, false, r11, "live_assistant");
    L69:
        ShelfInfo r30 = ((AnchorShelfContextService) this.b.getService(AnchorShelfContextService.class)).getCurShelfInfo();
        if (r30 == null) goto L81;
        List<ShelfCardInfo> r31 = r30.cardInfoList;
        if (r31 == null) goto L74;
        int r32 = r31.size();
    L75:
        if (r32 <= 1) goto L81;
        if (g.c(r30) == true) goto L81;
        if (g.c(r4) == false) goto L81;
        f2.c(s1.B(2131920407), 0);
        goto L81
    L74:
        r32 = 0;
    L81:
        AnchorShelfContextService.onModifyShelfSuccess$default((AnchorShelfContextService) this.b.getService(AnchorShelfContextService.class), r4, null, false, 6, null);
        return;
    L54:
        if (r9 == 4) goto L57;
        r10 = false;
        goto L58
    L106:
        return;
    L38:
        if (((Boolean) ud0.a.getValue()).booleanValue() == false) goto L40;
        xs2.b.a().post(new ep0.a());
    L43:
        DataCenter r33 = this.b.getDataCenter();
        if (r33 == null) goto L46;
        r33.put("cmd_live_shelf_display_dialog_dismiss", 0);
    L46:
        DataCenter r34 = this.b.getDataCenter();
        if (r34 == null) goto L50;
        r34.put("shelf_management_dismiss", 0);
        goto L50
    L40:
        DataCenter r35 = this.b.getDataCenter();
        if (r35 == null) goto L43;
        r35.put("cmd_live_toolbarmore_dialog_dismiss", 0);
        goto L43
    L28:
        ((MemoryContextService) this.b.getService(MemoryContextService.class)).g(r4);
        goto L29
    L22:
        if (r2 == 4) goto L25;
        r3 = false;
        goto L26
    L16:
        r4 = null;
    L8:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
