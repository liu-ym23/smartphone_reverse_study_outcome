package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.g0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorMiniAppBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.c4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.f2;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b0 {
        public b() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b0
        public final boolean a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3) {
            Intrinsics.checkNotNullParameter(r3, "model");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Object r4 = Result.constructor-impl((com.bytedance.android.live.openplatform.api.model.shelf.c) GsonHelper.get().fromJson(r3.d, com.bytedance.android.live.openplatform.api.model.shelf.c.class));     // Catch: Throwable -> L5
        L7:
            ShelfInfo r1 = null;
            if (Result.isFailure-impl(r4) == false) goto L10;
            r4 = null;
        L10:
            com.bytedance.android.live.openplatform.api.model.shelf.c r5 = (com.bytedance.android.live.openplatform.api.model.shelf.c) r4;
            if (r5 == null) goto L13;
            r1 = r5.shelfInfo;
        L13:
            if (r1 != null) goto L15;
            return true;
        L15:
            return false;
        L5:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.OPEN_PLATFORM_MINI_APP;
        if (ud0.a.getValue().booleanValue() == false) goto L5;
        ToolbarButton r2 = ToolbarButton.OPEN_PLATFORM_MINI_APP_MORE;
    L7:
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, null, r1, r2);
    L5:
        r2 = null;
        goto L7
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.MiniApp.INSTANCE;
    }

    public m(Context r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        List r1 = null;
        super(null, null, 6);
        this.f = r8;
        this.g = r9;
        ALogger.i("OpenPlatformLog_MiniAppConfig", "init");
        SparseArray<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b0> r0 = g0.a;
        b r2 = new b();
        Intrinsics.checkNotNullParameter(r2, "filter");
        g0.a.put(3, r2);
        if (tb1.c.a == false) goto L32;
        boolean r3 = false;
        if (com.bytedance.android.live.core.utils.z.e(r9, false) == false) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.core.utils.z.m(r9, true) == false) goto L34;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L15;
        Room r6 = (Room) r5.getValue();
        if (r6 == null) goto L15;
        r1 = r6.getRoomStamps();
    L15:
        if (r1 == null) goto L25;
        RoomStampInfo r7 = (RoomStampInfo) CollectionsKt.getOrNull(r1, 0);
        if (r7 == null) goto L25;
        if (r7.getType() != 4) goto L25;
        if (r7.getStatus() != 0) goto L23;
    L24:
        r3 = true;
        goto L25
    L23:
        if (r7.getStatus() == 1) goto L24;
    L25:
        if (r3 == true) goto L27;
        return;
    L27:
        if (de0.a.getValue().b() != 1) goto L36;
        IOpenPlatformAudienceService r10 = jc1.k.f(IOpenPlatformAudienceService.class);
        if (r10 == null) goto L37;
        r10.preloadMiniAppContext(r8, r9);
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        if (r4 == false) goto L8;
        if (r3 == false) goto L10;
        return new f2(this.f, this.g);
    L10:
        return new ToolbarAnchorMiniAppBehavior(this.f);
    L8:
        return new c4(this.f);
    }
}
