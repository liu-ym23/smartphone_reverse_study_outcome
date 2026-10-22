package com.bytedance.android.live.liveinteract.linkcast;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static c a(LinkScreenCastType r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "linkCastType");
            Intrinsics.checkNotNullParameter(r3, "appId");
            int r4 = h.a[r2.ordinal()];
            boolean r1 = false;
            if (r4 != 1) goto L5;
            Boolean r5 = m.i().isAnchor();
            if (r5 == null) goto L18;
            r1 = r5.booleanValue();
        L18:
            com.bytedance.android.live.broadcastgame.api.model.h r6 = k.n(IMiddlewareInteractGameService.class).fetchGameIconInfo(r3, r1);
            if (r6 != null) goto L24;
        L21:
            return null;
        L24:
            return new c(r6.a, r6.c, r6.b);
        L5:
            if (r4 != 2) goto L21;
            Boolean r7 = m.i().isAnchor();
            if (r7 == null) goto L10;
            r1 = r7.booleanValue();
        L10:
            if (r1 == false) goto L12;
            ko0.c r8 = ((IMiddlewareOpenPlatformAnchorService) k.n(IMiddlewareOpenPlatformAnchorService.class)).getMiniAppLiveCastEntranceInfo();
        L13:
            if (r8 == null) goto L21;
            return new c(r8.a, r8.c, r8.b);
        L12:
            r8 = ((IMiddlewareOpenPlatformAudienceService) k.n(IMiddlewareOpenPlatformAudienceService.class)).getMiniAppLiveCastEntranceInfo();
            goto L13
        }

        public static void b(LinkScreenCastType r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "linkCastType");
            Intrinsics.checkNotNullParameter(r2, "appId");
            int r3 = h.b[r1.ordinal()];
            if (r3 != 1) goto L5;
            Room r4 = m.i().getCurrentRoom();
            if (r4 == null) goto L19;
            IBaseUser r5 = r4.getOwner();
            if (r5 == null) goto L19;
            String r6 = r5.getIdString();
        L21:
            if (Intrinsics.areEqual(r6, k.n(IMiddlewareUserService.class).user().n()) == false) goto L23;
            k.n(IMiddlewareInteractGameService.class).anchorLaunchGame(r2);
            return;
        L23:
            k.n(IMiddlewareInteractGameService.class).audienceLaunchGame();
            return;
        L19:
            r6 = null;
            goto L21
        L5:
            if (r3 != 2) goto L28;
            Boolean r7 = m.i().isAnchor();
            if (r7 == null) goto L10;
            boolean r8 = r7.booleanValue();
        L11:
            if (r8 == false) goto L13;
            ((IMiddlewareOpenPlatformAnchorService) k.n(IMiddlewareOpenPlatformAnchorService.class)).openLiveCastingMiniApp();
            return;
        L13:
            ((IMiddlewareOpenPlatformAudienceService) k.n(IMiddlewareOpenPlatformAudienceService.class)).openMountedMiniApp(MountedMiniAppSource.ConnectionPanel);
            return;
        L10:
            r8 = false;
            goto L11
        }

        public static void c(LinkScreenCastType r1, boolean r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "linkCastType");
            Intrinsics.checkNotNullParameter(r3, "reason");
            int r5 = h.d[r1.ordinal()];
            if (r5 != 1) goto L5;
            k.n(IMiddlewareInteractGameService.class).notifyStopLinkCastResult(r2);
            return;
        L5:
            if (r5 != 2) goto L11;
            JSONObject r6 = new JSONObject();
            r6.put("key_stop_reason", r3);
            ((IMiddlewareOpenPlatformAnchorService) k.n(IMiddlewareOpenPlatformAnchorService.class)).notifyMiniAppStopLinkCastResult(r2, r6, r4);
            return;
        }
    }

    static {
    }
}
