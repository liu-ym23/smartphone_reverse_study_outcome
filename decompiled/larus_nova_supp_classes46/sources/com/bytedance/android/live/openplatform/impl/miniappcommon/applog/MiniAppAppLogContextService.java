package com.bytedance.android.live.openplatform.impl.miniappcommon.applog;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.ContextServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ContextServiceImpl(audienceService = "com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService", liveAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService", previewAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0004J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0006\u0010\u0012\u001a\u00020\u0006J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/applog/MiniAppAppLogContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "openPlatformContext", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "addUserInfo", "", "data", "", "", "clickMiniAppMoreButton", "enterMiniAppShow", "getCoexistParams", "getCommonEventParams", "", "getCommonParams", "getCurrentAppId", "getCurrentAppName", "miniAppMoreDialogShow", "previewMiniAppShow", "reportMiniAppClose", "duration", "", "reportMiniAppShow", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniAppAppLogContextService extends OpenPlatformContextService {
    public final Map<String, String> getCoexistParams() {
        Pair[] r0 = new Pair[1];
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r1 = MiniAppDataContext.a.b();
        if (r1 == null) goto L5;
        String r2 = r1.b();
    L6:
        r0[0] = TuplesKt.to("coexist_module", r2);
        return MapsKt.mutableMapOf(r0);
    L5:
        r2 = "";
        goto L6
    }

    public final Map<String, String> getCommonParams() {
        Map<String, String> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id", getCurrentAppId()), TuplesKt.to("program_name", getCurrentAppName()), TuplesKt.to("program_type", "little_program")});
        int r1 = n.a;
        n.d(getOpenPlatformContext().getRoom(), r0);
        return r0;
    }

    private final String getCurrentAppId() {
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r0 = MiniAppDataContext.a.a();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L12;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L12;
        ShelfMicroAppInfo r3 = r2.appInfo;
        if (r3 == null) goto L12;
        String r4 = r3.appId;
        if (r4 == null) goto L12;
        return r4;
    L12:
        return "";
    }

    private final String getCurrentAppName() {
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r0 = MiniAppDataContext.a.a();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L12;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L12;
        ShelfMicroAppInfo r3 = r2.appInfo;
        if (r3 == null) goto L12;
        String r4 = r3.name;
        if (r4 == null) goto L12;
        return r4;
    L12:
        return "";
    }

    public final Map<String, String> getCommonEventParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        IHostContext r1 = k.n(IHostContext.class);
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r2 = MiniAppDataContext.a.a();
        LiveMode r3 = null;
        if (r2 == null) goto L11;
        com.bytedance.live.datacontext.n<ShelfInfo> r4 = r2.m618getShelfInfo();
        if (r4 == null) goto L11;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
        if (r5 == null) goto L11;
        ShelfMicroAppInfo r6 = r5.appInfo;
        if (r6 == null) goto L11;
        String r7 = r6.appId;
    L13:
        if (r1.isMpInSandboxMode(r7) == false) goto L15;
        String r8 = "sandbox";
    L16:
        r0.put("_param_for_special", r8);
        IInteractService r9 = (IInteractService) k.n(IInteractService.class);
        int r10 = r9.getCurrentScene();
        if (r10 != 8) goto L19;
        String r11 = "1v6";
    L23:
        r0.put("live_category", r11);
        if (r9.isAudienceLinkEngineOn() == false) goto L26;
        String r12 = "guest";
    L27:
        r0.put("projection_user_type", r12);
        if (r9.isMultiLive() == false) goto L30;
        String r13 = "multi";
    L31:
        r0.put("cast_scene", r13);
        if (r9.isLinkEverCast() == false) goto L34;
        String r14 = "1";
    L35:
        r0.put("is_screenprojection", r14);
        r0.put("cast_biz_value", "applet");
        RoomContext r15 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r15 == null) goto L42;
        m r16 = r15.getRoom();
        if (r16 == null) goto L42;
        Room r17 = (Room) r16.getValue();
        if (r17 == null) goto L42;
        r3 = r17.getStreamType();
    L42:
        int r18 = h1.a;
        r0.put("live_type", i1.a(r3));
        if (r9.isLinkCasting() == false) goto L45;
        r0.put("if_mp_live_projection", "1");
    L45:
        return r0;
    L34:
        r14 = "0";
        goto L35
    L30:
        r13 = "single";
        goto L31
    L26:
        r12 = "audience";
        goto L27
    L19:
        if (r10 == 12) goto L21;
        r11 = "";
        goto L23
    L21:
        r11 = "party";
        goto L23
    L15:
        r8 = "micro_app";
    L11:
        r7 = null;
        goto L13
    }

    private final void enterMiniAppShow() {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(getCommonParams());
        Unit r2 = Unit.INSTANCE;
        r0.sendLog("livesdk_live_small_program_homepage_show", r1, new Object[]{Room.class});
    }

    private final void previewMiniAppShow() {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(getCommonParams());
        Unit r2 = Unit.INSTANCE;
        r0.sendLog("livesdk_live_takepage_small_program_homepage_show", r1, new Object[]{Room.class});
    }

    public final void clickMiniAppMoreButton() {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(getCommonParams());
        addUserInfo(r1);
        Unit r2 = Unit.INSTANCE;
        r0.sendLog("livesdk_live_small_program_more_click", r1, new Object[]{Room.class});
    }

    public final void miniAppMoreDialogShow() {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(getCommonParams());
        addUserInfo(r1);
        Unit r2 = Unit.INSTANCE;
        r0.sendLog("livesdk_live_small_program_more_panel_show", r1, new Object[]{Room.class});
    }

    public final void reportMiniAppShow() {
        if (getOpenPlatformContext().isInLive() == true) goto L5;
        previewMiniAppShow();
        return;
    L5:
        enterMiniAppShow();
    }

    public MiniAppAppLogContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    private final void addUserInfo(Map<String, String> r3) {
        if (getOpenPlatformContext().isAnchor() == false) goto L5;
        String r0 = "anchor";
    L6:
        r3.put("user_type", r0);
        String r1 = k.n(IUserService.class).user().b().getIdString();
        if (getOpenPlatformContext().isAnchor() == false) goto L9;
        r3.put("anchor_id", r1);
        return;
    L9:
        r3.put("user_id", r1);
        return;
    L5:
        r0 = "user";
        goto L6
    }

    public final void reportMiniAppClose(long r4) {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("duration", String.valueOf(r4));
        addUserInfo(r1);
        r1.putAll(getCommonParams());
        Unit r5 = Unit.INSTANCE;
        r0.sendLog("livesdk_small_program_close", r1, new Object[]{Room.class});
    }
}
