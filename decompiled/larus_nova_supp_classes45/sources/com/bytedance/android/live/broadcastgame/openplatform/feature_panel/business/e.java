package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.livesdk.config.b30;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements a20.g {
    public final Set<String> a;
    public String b;

    @Override // a20.g
    public final void clear() {
        this.a.clear();
    }

    @Override // a20.g
    public final void d() {
        if (((k81) ft0.a.getValue()).b() == false) goto L15;
        this.b = "null";
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        fa0.c r1 = (fa0.c) com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r1 == null) goto L16;
        fa0.a r2 = r1.o0();
        if (r2 == null) goto L17;
        String r3 = r2.c;
        if (r3 == null) goto L18;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L12
        this.b = LiveSeiUtil.c(r3).optString("MiniAppID");     // Catch: Exception -> L12
        Unit r4 = Unit.INSTANCE;     // Catch: Exception -> L12
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public e() {
        this.a = new LinkedHashSet();
        this.b = "null";
    }

    @Override // a20.g
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a.remove(r2);
    }

    @Override // a20.g
    public final boolean a(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "id");
        String r0 = null;
        if (r9 == false) goto L77;
        if (((k81) ft0.a.getValue()).b() == false) goto L62;
        List<String> r11 = LiveEffectContext.h;
        Sticker r12 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.d));
        if (r12 == null) goto L9;
        String r13 = r12.getEffectId();
    L10:
        boolean r14 = Intrinsics.areEqual(r13, r8);
        if (((Boolean) b30.a.getValue()).booleanValue() == false) goto L18;
        IBroadcastService r3 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r3 == null) goto L18;
        if (r3.isPluginRunning(r8) != true) goto L18;
    L26:
        boolean r4 = true;
    L28:
        IBroadcastService r5 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r5 == null) goto L33;
        List<String> r6 = r5.getRunningInteractPluginIds();
        if (r6 == null) goto L33;
        boolean r7 = r6.contains(r8);
    L34:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r15 = AnchorMiniGameDataContext.a.a();
        if (r15 == null) goto L41;
        n r16 = r15.getMicroGameInfo();
        if (r16 == null) goto L41;
        c0 r17 = (c0) r16.getValue();
        if (r17 == null) goto L41;
        String r18 = r17.gameId;
    L42:
        boolean r19 = Intrinsics.areEqual(r18, r8);
        if (this.a.contains(r8) == true) goto L59;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r21 = AnchorMiniAppDataContext.a.a();
        if (r21 == null) goto L54;
        n r22 = r21.getShelfInfo();
        if (r22 == null) goto L54;
        ShelfInfo r23 = (ShelfInfo) r22.getValue();
        if (r23 == null) goto L54;
        ShelfMicroAppInfo r24 = r23.appInfo;
        if (r24 == null) goto L54;
        r0 = r24.appId;
    L54:
        if (Intrinsics.areEqual(r0, r8) == true) goto L59;
        if (r14 == true) goto L59;
        if (r4 == true) goto L59;
        if (r7 == true) goto L59;
        if (r19 == true) goto L59;
        return false;
    L59:
        return true;
    L41:
        r18 = null;
    L33:
        r7 = false;
    L18:
        if (Intrinsics.areEqual(this.b, r8) == false) goto L27;
        boolean r25 = com.bytedance.android.live.revenue.core.util.h.a;
        fa0.c r26 = (fa0.c) com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r26 == null) goto L24;
        fa0.a r27 = r26.o0();
        if (r27 == null) goto L24;
        boolean r28 = r27.a;
    L25:
        if (r28 == false) goto L27;
    L24:
        r28 = false;
    L27:
        r4 = false;
        goto L28
    L9:
        r13 = null;
        goto L10
    L62:
        if (this.a.contains(r8) == true) goto L74;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r29 = AnchorMiniAppDataContext.a.a();
        if (r29 == null) goto L73;
        n r31 = r29.getShelfInfo();
        if (r31 == null) goto L73;
        ShelfInfo r32 = (ShelfInfo) r31.getValue();
        if (r32 == null) goto L73;
        ShelfMicroAppInfo r33 = r32.appInfo;
        if (r33 == null) goto L73;
        r0 = r33.appId;
    L73:
        if (Intrinsics.areEqual(r0, r8) == true) goto L74;
        return false;
    L74:
        return true;
    L77:
        if (this.a.contains(r8) == true) goto L97;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r34 = AnchorMiniAppDataContext.a.a();
        if (r34 == null) goto L88;
        n r35 = r34.getShelfInfo();
        if (r35 == null) goto L88;
        ShelfInfo r36 = (ShelfInfo) r35.getValue();
        if (r36 == null) goto L88;
        ShelfMicroAppInfo r37 = r36.appInfo;
        if (r37 == null) goto L88;
        r0 = r37.appId;
    L88:
        if (Intrinsics.areEqual(r0, r8) == false) goto L101;
        AnchorMiniAppDataContext r38 = AnchorMiniAppDataContext.a.a();
        if (r38 == null) goto L97;
        n r39 = r38.getShelfInfo();
        if (r39 == null) goto L97;
        ShelfInfo r41 = (ShelfInfo) r39.getValue();
        if (r41 == null) goto L97;
        if (r41.e() != true) goto L97;
        return false;
    L101:
        return false;
    L97:
        return true;
    }

    @Override // a20.g
    public final void c(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        if (r3 == true) goto L6;
        this.a.clear();
    L6:
        if (this.a.contains(r2) == false) goto L8;
        return;
    L8:
        this.a.add(r2);
    }
}
