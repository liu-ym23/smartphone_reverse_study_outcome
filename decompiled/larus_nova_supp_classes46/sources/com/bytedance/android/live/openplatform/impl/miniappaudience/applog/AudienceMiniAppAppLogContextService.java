package com.bytedance.android.live.openplatform.impl.miniappaudience.applog;

import am2.n;
import am2.x;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductJumpSetting;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.d;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.api.utils.h;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardWidget;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.ExplainCardAnimType;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfSupplementInfoContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.SnowToolbarContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.applog.MiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b;
import com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.c;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.g90;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.config.vc1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.wrds.syncdata.openplatform.a;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LJ.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J.\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u001e\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0002J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0002J&\u0010\u001a\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u001d\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0002J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J$\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0002J(\u0010,\u001a\u00020\b2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!2\u0006\u0010+\u001a\u00020*H\u0002J\u000e\u0010-\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\u001c\u0010.\u001a\u00020\b2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006J\u000e\u0010/\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J$\u00100\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006J\u0006\u00101\u001a\u00020\bJ\u000e\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020!J\u0016\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\u001f2\u0006\u00102\u001a\u00020!J\u000e\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020!J\u0016\u0010:\u001a\u00020\b2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001fJ\u000e\u0010;\u001a\u00020\b2\u0006\u00106\u001a\u00020!J\u001e\u0010<\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!2\u0006\u00106\u001a\u00020!J&\u0010>\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u00106\u001a\u00020!J\u001e\u0010B\u001a\u00020\b2\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u001fJ\u001e\u0010C\u001a\u00020\b2\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u001fJ\u000e\u0010D\u001a\u00020\b2\u0006\u0010%\u001a\u00020$J\u000e\u0010E\u001a\u00020\b2\u0006\u0010%\u001a\u00020$J\u0006\u0010F\u001a\u00020\bJ\u001e\u0010G\u001a\u00020\b2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!2\u0006\u0010+\u001a\u00020*J\u001e\u0010H\u001a\u00020\b2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!2\u0006\u0010+\u001a\u00020*¨\u0006M"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/applog/AudienceMiniAppAppLogContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/applog/MiniAppAppLogContextService;", "", "eventName", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "source", "", "extraParams", "", "commonShow", "enterPosition", "commonClick", "", "getLiveCastParams", "getToolbarDirectMicroAppLogParams", "type", "getExplainCardLogParams", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "cardInfo", "getCardOptLogParams", "getCoverTypeParam", "getConnectionPanelLogParams", "getLogParams", "getAdLogParams", "logExtra", "map", "insertLogExtra", "getShelfInfoParams", "getLinkType", "getCommonShelfParams", "getProductInfoShowMap", "", "cardId", "", "isCardPin", "getCommonShelfCardParams", "Llo0/a;", "privateMsgEntranceInfo", "getMpImAuthPushEntryParams", "isStart", "isEnterRoom", "isLynxCard", "Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/ExplainCardAnimType;", "animType", "reportMpLivePopupCardShowAnim", "reportMpLiveLinkShow", "reportMpLivePopupCardShow", "reportMpLiveLinkClick", "reportMpLivePopupCardClick", "reportMpLivePopupCardClose", "isGuest", "reportAudienceLiveProjectionWatch", "duration", "reportAudienceLiveProjectionWatchDuration", "isSecurityDeposit", "reportMpLiveLinkShelfShow", "shelfUseTime", "mpUseTime", "reportMpLiveLinkShelfStayTime", "reportShelfTopMpEntranceClick", "reportMpLiveLinkShelfCardShow", "clickPosition", "reportMpLiveLinkShelfCardClick", "show", "bubbleType", "num", "reportHotAtmosphereVisibilityChanged", "reportSupplementInfoVisibilityChanged", "reportMpImAuthPushEntryShow", "reportMpImAuthPushEntryClick", "reportSnowFlakeAnimShow", "reportMpLivePopupCardShowAnimStart", "reportMpLivePopupCardShowAnimEnd", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniAppAppLogContextService extends MiniAppAppLogContextService {
    private final Map<String, String> getAdLogParams() {
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = n.f().a();
        boolean r4 = true;
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        String r6 = null;
        if (r3 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        r1.put("aid", r2);
        String r5 = (String) r1.put("ad_id", r2);
    L12:
        String r7 = n.f().c();
        if (r7.length() <= 0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == true) goto L19;
        r7 = null;
    L19:
        if (r7 == null) goto L21;
        String r9 = (String) r1.put("cid", r7);
    L21:
        String r10 = n.f().d();
        if (r10.length() <= 0) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L27;
        r6 = r10;
    L27:
        if (r6 == null) goto L39;
        String r12 = (String) r1.put("log_extra", r6);
    L39:
        String r13 = new JSONObject(n.f().d()).optString("clickid");     // Catch: JSONException -> L31
    L33:
        if (r13.length() > 0) goto L36;
        r4 = false;
    L36:
        if (r4 == false) goto L38;
        r1.put("clickid", r13);
    L38:
        return r1;
    L31:
        r13 = "";
        goto L33
    L24:
        r11 = false;
        goto L25
    L15:
        r8 = false;
        goto L16
    L5:
        r3 = false;
        goto L6
    }

    private final Map<String, String> getConnectionPanelLogParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("location", "connection_panel");
        r0.put("enter_position", "connection_panel");
        return r0;
    }

    private final Map<String, String> getLiveCastParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        IInteractService r1 = (IInteractService) k.n(IInteractService.class);
        if (r1.isMultiLive() == false) goto L5;
        String r2 = "multi";
    L7:
        if (r1.isLinkEverCast() == false) goto L9;
        String r3 = "1";
    L10:
        r0.put("cast_scene", r2);
        r0.put("is_screenprojection", r3);
        r0.put("cast_biz_value", "applet");
        LiveMode r7 = null;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L17;
        m r5 = r4.getRoom();
        if (r5 == null) goto L17;
        Room r6 = (Room) r5.getValue();
        if (r6 == null) goto L17;
        r7 = r6.getStreamType();
    L17:
        int r8 = h1.a;
        r0.put("live_type", i1.a(r7));
        if (r1.isLinkCasting() == false) goto L20;
        r0.put("if_mp_live_projection", "1");
    L20:
        return r0;
    L9:
        r3 = "0";
        goto L10
    L5:
        r2 = "single";
        goto L7
    }

    private final Map<String, String> getLogParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        IHostContext r1 = k.n(IHostContext.class);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        if (r2 == null) goto L11;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L11;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L11;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L11;
        String r6 = r5.appId;
    L13:
        if (r1.isMpInSandboxMode(r6) == false) goto L15;
        String r7 = "sandbox";
    L16:
        r0.put("_param_for_special", r7);
        r0.put("scene", LaunchParamConstant$Scene.b);
        MiniAppDataContext.Companion.getClass();
        String r8 = "coexist_live";
        if (g.c(MiniAppDataContext.a.b()) == false) goto L19;
        Object r9 = "coexist_live";
    L20:
        r0.put("launch_from", r9);
        if (g.c(MiniAppDataContext.a.b()) == true) goto L24;
        r8 = "live";
    L24:
        r0.put("entrance_form", r8);
        if (g.a(MiniAppDataContext.a.b()) == null) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        String r11 = "1";
    L31:
        r0.put("is_explaining", r11);
        r0.putAll(getCoexistParams());
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L45;
        int r12 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r12 != 8) goto L36;
        String r13 = "1v6";
    L40:
        r0.put("live_category", r13);
        if (((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn() == false) goto L43;
        String r14 = "guest";
    L44:
        r0.put("projection_user_type", r14);
        goto L45
    L43:
        r14 = "audience";
        goto L44
    L36:
        if (r12 == 12) goto L38;
        r13 = "";
        goto L40
    L38:
        r13 = "party";
    L45:
        return r0;
    L30:
        r11 = "0";
        goto L31
    L27:
        r10 = false;
        goto L28
    L19:
        r9 = "live";
        goto L20
    L15:
        r7 = "micro_app";
    L11:
        r6 = null;
        goto L13
    }

    private final Map<String, String> getShelfInfoParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.n<ShelfInfo> r2 = r1.m618getShelfInfo();
        if (r2 == null) goto L11;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
        if (r3 == null) goto L11;
        List<ShelfCardInfo> r4 = r3.cardInfoList;
        if (r4 == null) goto L11;
        int r5 = r4.size();
    L12:
        r0.put("shelf_card_num", String.valueOf(r5));
        return r0;
    L11:
        r5 = 0;
        goto L12
    }

    private final Map<String, String> getToolbarDirectMicroAppLogParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        String r2 = "";
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r1.m618getShelfInfo();
        if (r3 == null) goto L12;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L12;
        String r6 = r5.appId;
        if (r6 == null) goto L12;
    L13:
        r0.put("mp_id", r6);
        AudienceMiniAppDataContext r7 = AudienceMiniAppDataContext.a.a();
        if (r7 == null) goto L23;
        com.bytedance.live.datacontext.n<ShelfInfo> r8 = r7.m618getShelfInfo();
        if (r8 == null) goto L23;
        ShelfInfo r9 = (ShelfInfo) r8.getValue();
        if (r9 == null) goto L23;
        ShelfMicroAppInfo r10 = r9.appInfo;
        if (r10 == null) goto L23;
        String r11 = r10.name;
        if (r11 == null) goto L23;
    L24:
        r0.put("mp_name", r11);
        r0.put("location", "in_live_link");
        r0.put("enter_position", "live_link");
        AudienceMiniAppDataContext r12 = AudienceMiniAppDataContext.a.a();
        if (r12 == null) goto L31;
        com.bytedance.live.datacontext.n<ShelfInfo> r13 = r12.m618getShelfInfo();
        if (r13 == null) goto L31;
        ShelfInfo r14 = (ShelfInfo) r13.getValue();
        if (r14 == null) goto L31;
        String r15 = r14.logExtra;
    L32:
        insertLogExtra(r15, r0);
        AudienceMiniAppDataContext r16 = AudienceMiniAppDataContext.a.a();
        if (r16 == null) goto L45;
        com.bytedance.live.datacontext.n<ShelfInfo> r17 = r16.m618getShelfInfo();
        if (r17 == null) goto L45;
        ShelfInfo r18 = (ShelfInfo) r17.getValue();
        if (r18 == null) goto L45;
        List<ShelfCardInfo> r19 = r18.cardInfoList;
        if (r19 == null) goto L45;
        ShelfCardInfo r20 = (ShelfCardInfo) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L45;
        String r21 = r20.a0();
        if (r21 == null) goto L45;
        String r22 = h.c(r21);
    L46:
        r0.put("page_path", r22);
        r0.putAll(getShelfInfoParams());
        ((SnowToolbarContextService) getOpenPlatformContext().getService(SnowToolbarContextService.class)).getClass();
        if (SnowToolbarContextService.k() == true) goto L58;
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r23 = MiniAppDataContext.a.b();
        if (r23 == null) goto L58;
        List<ShelfCardInfo> r24 = r23.cardInfoList;
        if (r24 == null) goto L58;
        ShelfCardInfo r25 = (ShelfCardInfo) CollectionsKt.firstOrNull(r24);
        if (r25 == null) goto L58;
        String r26 = String.valueOf(r25.getCardId());
        if (r26 == null) goto L58;
        r2 = r26;
    L58:
        r0.put("card_page_id", r2);
        return r0;
    L45:
        r22 = "";
    L31:
        r15 = null;
    L23:
        r11 = "";
    L12:
        r6 = "";
        goto L13
    }

    public final void reportMpLivePopupCardClose() {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(getExplainCardLogParams(PbRequest.SwitchType.OTHER));
        r1.putAll(getLogParams());
        r1.putAll(getAdLogParams());
        r1.putAll(getCommonParams());
        r1.putAll(getLiveCastParams());
        r1.putAll(MapsKt.mapOf(TuplesKt.to("click_position", "card")));
        Unit r2 = Unit.INSTANCE;
        r0.e("mp_live_popup_card_close", r1, new Object[]{Room.class, x.class});
    }

    public final void reportSnowFlakeAnimShow() {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L12;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L12;
        String r6 = r5.appId;
        if (r6 == null) goto L12;
    L13:
        r1.put("mp_id", r6);
        r1.put("entrance_form", "live");
        ((SnowToolbarContextService) getOpenPlatformContext().getService(SnowToolbarContextService.class)).getClass();
        if (SnowToolbarContextService.k() == false) goto L16;
        String r7 = "live_shelf_card";
    L17:
        r1.put("enter_position", r7);
        r1.putAll(getCommonParams());
        Unit r8 = Unit.INSTANCE;
        r0.e("mp_live_link_special_effects_show", r1, new Object[]{Room.class});
        return;
    L16:
        r7 = "live_link";
    L12:
        r6 = "";
        goto L13
    }

    public AudienceMiniAppAppLogContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    private final Map<String, String> getCardOptLogParams(ShelfCardInfo r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        d90 r1 = d90.a;
        r0.put("is_new_pattern", String.valueOf(((vc1) r1.getValue()).a()));
        r0.put("back_image_type", getCoverTypeParam(r9));
        String r2 = "";
        Long r3 = null;
        if (r9 == null) goto L14;
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r4 = MiniAppDataContext.a.b();
        if (r4 == null) goto L10;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L10;
        String r6 = r5.name;
        if (r6 == null) goto L10;
    L11:
        Pair<Integer, String> r7 = r9.a(r6);
        if (r7 == null) goto L14;
        Integer r8 = (Integer) r7.getFirst();
    L15:
        AudienceShelfSupplementInfoContextService r10 = (AudienceShelfSupplementInfoContextService) getOpenPlatformContext().getService(AudienceShelfSupplementInfoContextService.class);
        if (r9 == null) goto L18;
        r3 = Long.valueOf(r9.getCardId());
    L18:
        a r11 = r10.f(r3);
        if (r8 != null) goto L22;
    L24:
        if (r8 == null) goto L30;
        if (r8.intValue() != 2) goto L30;
        String r12 = "define_title";
    L36:
        r0.put("title_type_one", r12);
        if (r11 == null) goto L39;
        r2 = "market_info";
    L39:
        r0.put("title_type_two", r2);
        return r0;
    L30:
        if (((vc1) r1.getValue()).a() == 1) goto L32;
    L35:
        r12 = MultiLinkOpenSource.DEFAULT;
        goto L36
    L32:
        if (((vc1) r1.getValue()).c() != 1) goto L35;
        if (r11 == null) goto L35;
        r12 = "market_info";
        goto L36
    L22:
        if (r8.intValue() != 4) goto L24;
        r12 = "commodity";
    L10:
        r6 = "";
    L14:
        r8 = null;
        goto L15
    }

    private final void getCommonShelfParams(Map<String, String> r11) {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L7;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
    L8:
        int r3 = 0;
        if (r2 == null) goto L13;
        List<ShelfCardInfo> r4 = r2.cardInfoList;
        if (r4 == null) goto L13;
        int r5 = r4.size();
    L14:
        r11.put("shelf_card_num", String.valueOf(r5));
        if (r2 == null) goto L38;
        List<ShelfCardInfo> r6 = r2.cardInfoList;
        if (r6 == null) goto L38;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L20:
        if (r8.hasNext() == false) goto L37;
        Object r9 = r8.next();
        ShelfCardInfo r10 = (ShelfCardInfo) r9;
        List<ImageModel> r12 = r10.L();
        if (r12 == null) goto L28;
        ImageModel r13 = (ImageModel) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L28;
        List r14 = r13.getUrls();
        if (r14 == null) goto L28;
        String r15 = (String) CollectionsKt.firstOrNull(r14);
    L30:
        if (Intrinsics.areEqual(r15, r10.F()) == true) goto L32;
    L34:
        boolean r16 = false;
    L35:
        if (r16 == false) goto L20;
        r7.add(r9);
        goto L20
    L32:
        if (r10.w0() == true) goto L34;
        r16 = true;
    L28:
        r15 = null;
        goto L30
    L37:
        int r17 = r7.size();
    L39:
        r11.put("base_pic_shelf_card_num", String.valueOf(r17));
        if (r2 == null) goto L61;
        List<ShelfCardInfo> r18 = r2.cardInfoList;
        if (r18 == null) goto L61;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L45:
        if (r20.hasNext() == false) goto L60;
        Object r21 = r20.next();
        ShelfCardInfo r22 = (ShelfCardInfo) r21;
        String r23 = r22.E();
        if (r23 != null) goto L49;
    L52:
        boolean r24 = true;
    L53:
        if (r24 == true) goto L55;
    L57:
        boolean r25 = false;
    L58:
        if (r25 == false) goto L45;
        r19.add(r21);
        goto L45
    L55:
        if (r22.y0() == true) goto L57;
        r25 = true;
        goto L58
    L49:
        if (StringsKt.isBlank(r23) == true) goto L52;
        r24 = false;
        goto L53
    L60:
        int r26 = r19.size();
    L62:
        r11.put("base_title_shelf_card_num", String.valueOf(r26));
        if (r2 == null) goto L86;
        List<ShelfCardInfo> r27 = r2.cardInfoList;
        if (r27 == null) goto L86;
        ArrayList r28 = new ArrayList();
        Iterator<T> r29 = r27.iterator();
    L68:
        if (r29.hasNext() == false) goto L85;
        Object r30 = r29.next();
        ShelfCardInfo r31 = (ShelfCardInfo) r30;
        List<ImageModel> r32 = r31.L();
        if (r32 == null) goto L76;
        ImageModel r33 = (ImageModel) CollectionsKt.firstOrNull(r32);
        if (r33 == null) goto L76;
        List r34 = r33.getUrls();
        if (r34 == null) goto L76;
        String r35 = (String) CollectionsKt.firstOrNull(r34);
    L78:
        if (Intrinsics.areEqual(r35, r31.F()) == true) goto L80;
    L82:
        boolean r36 = false;
    L83:
        if (r36 == false) goto L68;
        r28.add(r30);
        goto L68
    L80:
        if (r31.w0() == false) goto L82;
        r36 = true;
    L76:
        r35 = null;
        goto L78
    L85:
        int r37 = r28.size();
    L87:
        r11.put("buffer_pic_shelf_card_num", String.valueOf(r37));
        if (r2 == null) goto L109;
        List<ShelfCardInfo> r38 = r2.cardInfoList;
        if (r38 == null) goto L109;
        ArrayList r39 = new ArrayList();
        Iterator<T> r40 = r38.iterator();
    L93:
        if (r40.hasNext() == false) goto L108;
        Object r41 = r40.next();
        ShelfCardInfo r42 = (ShelfCardInfo) r41;
        String r43 = r42.E();
        if (r43 != null) goto L97;
    L100:
        boolean r44 = true;
    L101:
        if (r44 == true) goto L103;
    L105:
        boolean r45 = false;
    L106:
        if (r45 == false) goto L93;
        r39.add(r41);
        goto L93
    L103:
        if (r42.y0() == false) goto L105;
        r45 = true;
        goto L106
    L97:
        if (StringsKt.isBlank(r43) == true) goto L100;
        r44 = false;
        goto L101
    L108:
        r3 = r39.size();
    L109:
        r11.put("buffer_title_shelf_card_num", String.valueOf(r3));
        return;
    L86:
        r37 = 0;
    L61:
        r26 = 0;
    L38:
        r17 = 0;
    L13:
        r5 = 0;
    L7:
        r2 = null;
        goto L8
    }

    private final String getCoverTypeParam(ShelfCardInfo r3) {
        if (r3 == null) goto L6;
        Pair<Integer, String> r4 = r3.o(false);
        if (r4 == null) goto L6;
        Integer r5 = (Integer) r4.getFirst();
    L7:
        if (r5 != null) goto L10;
    L12:
        if (r5 != null) goto L15;
    L17:
        if (r5 != null) goto L20;
    L22:
        if (r5 != null) goto L25;
    L27:
        if (r5 != null) goto L30;
    L32:
        return "";
    L30:
        if (r5.intValue() != 3) goto L32;
        return "screenshot";
    L25:
        if (r5.intValue() != 2) goto L27;
        return "text_generate";
    L20:
        if (r5.intValue() != 1) goto L22;
        return "developer_default";
    L15:
        if (r5.intValue() != 4) goto L17;
        return "define_picture";
    L10:
        if (r5.intValue() != (-1)) goto L12;
        return "commodity";
    L6:
        r5 = null;
        goto L7
    }

    private final Map<String, String> getExplainCardLogParams(String r14) {
        LinkedHashMap r0 = new LinkedHashMap();
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        String r2 = "";
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r1.m618getShelfInfo();
        if (r3 == null) goto L12;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L12;
        String r6 = r5.appId;
        if (r6 == null) goto L12;
    L13:
        r0.put("mp_id", r6);
        AudienceMiniAppDataContext r7 = AudienceMiniAppDataContext.a.a();
        if (r7 == null) goto L23;
        com.bytedance.live.datacontext.n<ShelfInfo> r8 = r7.m618getShelfInfo();
        if (r8 == null) goto L23;
        ShelfInfo r9 = (ShelfInfo) r8.getValue();
        if (r9 == null) goto L23;
        ShelfMicroAppInfo r10 = r9.appInfo;
        if (r10 == null) goto L23;
        String r11 = r10.name;
        if (r11 == null) goto L23;
    L24:
        r0.put("mp_name", r11);
        AudienceMiniAppDataContext r12 = AudienceMiniAppDataContext.a.a();
        a r13 = null;
        if (r12 == null) goto L43;
        com.bytedance.live.datacontext.n<ShelfInfo> r15 = r12.m618getShelfInfo();
        if (r15 == null) goto L43;
        ShelfInfo r16 = (ShelfInfo) r15.getValue();
        if (r16 == null) goto L43;
        List<ShelfCardInfo> r17 = r16.cardInfoList;
        if (r17 == null) goto L43;
        ListIterator<ShelfCardInfo> r18 = r17.listIterator(r17.size());
    L34:
        if (r18.hasPrevious() == false) goto L41;
        ShelfCardInfo r19 = r18.previous();
        if (r19.getStatus() != 1) goto L38;
        boolean r20 = true;
    L39:
        if (r20 == false) goto L34;
    L42:
        ShelfCardInfo r21 = r19;
    L44:
        if (r21 != null) goto L46;
    L48:
        String r22 = "0";
    L49:
        r0.put("is_change_cover", r22);
        r0.put("location", "in_live_card");
        r0.put("enter_position", "live_popup_card");
        if (r21 == null) goto L54;
        ProductInfo r23 = r21.getProductInfo();
        if (r23 == null) goto L54;
        String r24 = r23.productId;
    L55:
        if (r24 != null) goto L57;
    L60:
        boolean r25 = true;
    L61:
        if (r25 == true) goto L63;
        String r26 = "go_purchase";
    L64:
        r0.put("click_icon_type", r26);
        r0.put("icon_link_type", getLinkType(r21));
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r27 = AudienceMiniAppDataContext.a.a();
        if (r27 == null) goto L85;
        com.bytedance.live.datacontext.n<ShelfInfo> r28 = r27.m618getShelfInfo();
        if (r28 == null) goto L85;
        ShelfInfo r29 = (ShelfInfo) r28.getValue();
        if (r29 == null) goto L85;
        List<ShelfCardInfo> r30 = r29.cardInfoList;
        if (r30 == null) goto L85;
        ListIterator<ShelfCardInfo> r31 = r30.listIterator(r30.size());
    L74:
        if (r31.hasPrevious() == false) goto L81;
        ShelfCardInfo r32 = r31.previous();
        if (r32.getStatus() != 1) goto L78;
        boolean r110 = true;
    L79:
        if (r110 == false) goto L74;
    L82:
        ShelfCardInfo r33 = r32;
        if (r33 == null) goto L85;
        String r34 = r33.R();
    L86:
        insertLogExtra(r34, r0);
        if (r21 == null) goto L91;
        String r35 = r21.a0();
        if (r35 == null) goto L91;
        String r36 = h.c(r35);
    L92:
        r0.put("page_path", r36);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r37 = AudienceMiniAppDataContext.a.a();
        if (r37 == null) goto L105;
        com.bytedance.live.datacontext.n<ShelfInfo> r38 = r37.m618getShelfInfo();
        if (r38 == null) goto L105;
        ShelfInfo r39 = (ShelfInfo) r38.getValue();
        if (r39 == null) goto L105;
        if (g.c(r39) != true) goto L105;
        uc1 r40 = (uc1) ee0.a.getValue();
        if (r40 == null) goto L109;
        String r41 = r40.k();
        if (r41 == null) goto L109;
    L110:
        r0.put("tag_type", r41);
        r0.putAll(getShelfInfoParams());
        if (Intrinsics.areEqual(r14, "click") == false) goto L136;
        AudienceExplainCardWidget<b> r111 = ((AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).c;
        if (r111 == null) goto L115;
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r112 = r111.g.getCurrentHotAtmosphereData();
    L116:
        String r42 = "none";
        if (r112 == null) goto L119;
        String r43 = "hot_sale";
    L120:
        r0.put("top_atmos_bubble_type", r43);
        long r44 = 0;
        if (r112 == null) goto L123;
        long r45 = r112.d();
    L124:
        r0.put("top_atmos_show_number", String.valueOf(r45));
        AudienceExplainCardWidget<b> r113 = ((AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).c;
        if (r113 == null) goto L127;
        r13 = r113.g.getCurrentSupplementInfo();
    L127:
        if (r13 == null) goto L132;
        String r114 = r13.type;
        if (r114 == null) goto L132;
        r42 = r114;
    L132:
        r0.put("page_info_bubble_type", r42);
        if (r13 == null) goto L135;
        r44 = r13.amount;
    L135:
        r0.put("page_info_show_number", String.valueOf(r44));
        goto L136
    L123:
        r45 = 0;
        goto L124
    L119:
        r43 = "none";
        goto L120
    L115:
        r112 = null;
    L136:
        MiniAppDataContext.Companion.getClass();
        b r115 = c.a(MiniAppDataContext.a.b());
        if (r115 == null) goto L142;
        String r116 = String.valueOf(r115.a);
        if (r116 == null) goto L142;
        r2 = r116;
    L142:
        r0.put("card_page_id", r2);
        r0.putAll(getCardOptLogParams(r21));
        return r0;
    L109:
        r41 = "";
    L105:
        uc1 r46 = (uc1) ee0.a.getValue();
        if (r46 == null) goto L109;
        r41 = r46.l();
        if (r41 != null) goto L110;
    L91:
        r36 = "";
        goto L92
    L78:
        r110 = false;
        goto L79
    L81:
        r32 = null;
    L85:
        r34 = null;
        goto L86
    L63:
        r26 = "view";
        goto L64
    L57:
        if (StringsKt.isBlank(r24) == true) goto L60;
        r25 = false;
    L54:
        r24 = null;
        goto L55
    L46:
        if (r21.F0() != true) goto L48;
        r22 = "1";
        goto L49
    L38:
        r20 = false;
        goto L39
    L41:
        r19 = null;
    L43:
        r21 = null;
    L23:
        r11 = "";
    L12:
        r6 = "";
        goto L13
    }

    private final String getLinkType(ShelfCardInfo r3) {
        Integer r0 = (Integer) g90.a.getValue();
        if (r3 == null) goto L20;
        ProductInfo r4 = r3.getProductInfo();
        if (r4 == null) goto L23;
        ProductJumpSetting r5 = r4.jumpSetting;
        if (r5 != null) goto L9;
        return "mp_page";
    L9:
        if (r5.isJumpToOtherPage != true) goto L25;
        if (r0 != null) goto L13;
    L14:
        if (r0 != null) goto L17;
        return "mp_page";
    L17:
        if (r0.intValue() != 2) goto L26;
        return "confirm_payment_page";
    L26:
        return "mp_page";
    L13:
        if (r0.intValue() != 1) goto L14;
        return "confirm_payment_page";
    L25:
        return "mp_page";
    L23:
        return "mp_page";
    L20:
        return "mp_page";
    }

    private final Map<String, String> getMpImAuthPushEntryParams(lo0.a r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("_param_for_special", "micro_app");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        String r2 = "";
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r1.m618getShelfInfo();
        if (r3 == null) goto L12;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r6 = r4.appInfo;
        if (r6 == null) goto L12;
        String r7 = r6.appId;
        if (r7 == null) goto L12;
    L13:
        r0.put("mp_id", r7);
        r0.put("auth_entry_show_page", "live_shelf_panel");
        String r8 = r5.h();
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r0.put("auth_entry_title", r8);
        String r9 = r5.c();
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        r0.put("auth_entry_text", r9);
        String r10 = r5.d();
        if (r10 == null) goto L23;
        r2 = r10;
    L23:
        r0.put("button_name", r2);
        Map<String, String> r11 = r5.e();
        if (r11 != null) goto L26;
        r11 = MapsKt.emptyMap();
    L26:
        r0.putAll(r11);
        r0.putAll(getCommonParams());
        return r0;
    L12:
        r7 = "";
        goto L13
    }

    private final Map<String, String> getProductInfoShowMap(ShelfCardInfo r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.openplatform.api.utils.b r1 = com.bytedance.android.live.openplatform.api.utils.b.b;
        String r4 = "1";
        String r7 = null;
        if (r1.c() == false) goto L17;
        ProductInfo r2 = r11.getProductInfo();
        if (r2 == null) goto L7;
        String r3 = r2.imgUrl;
    L8:
        if (r3 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L17;
        Object r6 = "1";
    L18:
        r0.put("has_product_pic", r6);
        if (r1.f() == false) goto L31;
        ProductInfo r8 = r11.getProductInfo();
        if (r8 == null) goto L23;
        String r9 = r8.title;
    L24:
        if (r9 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == true) goto L31;
    L32:
        r0.put("has_product_title", r4);
        String r12 = "empty";
        if (r1.e() == false) goto L48;
        int r13 = k81.c.a;
        ProductInfo r14 = r11.getProductInfo();
        if (r14 == null) goto L39;
        ProductPriceInfo r15 = r14.price;
        if (r15 == null) goto L39;
        String r16 = r15.currentPrice;
    L41:
        if (k81.c.b(r16) == false) goto L48;
        ProductInfo r17 = r11.getProductInfo();
        if (r17 == null) goto L48;
        ProductPriceInfo r18 = r17.price;
        if (r18 == null) goto L48;
        String r19 = r18.currentPrice;
        if (r19 == null) goto L48;
    L49:
        r0.put("price_tag", r19);
        String r20 = "";
        if (r1.d() == false) goto L69;
        ProductInfo r21 = r11.getProductInfo();
        if (r21 == null) goto L69;
        List<ProductIntroductionInfo> r22 = r21.introductionList;
        if (r22 == null) goto L69;
        Iterator<T> r23 = r22.iterator();
    L57:
        if (r23.hasNext() == false) goto L64;
        Object r24 = r23.next();
        if (((ProductIntroductionInfo) r24).introductionType != 1) goto L61;
        boolean r25 = true;
    L62:
        if (r25 == false) goto L57;
    L65:
        ProductIntroductionInfo r26 = (ProductIntroductionInfo) r24;
        if (r26 == null) goto L69;
        String r27 = r26.content;
        if (r27 == null) goto L69;
    L70:
        r0.put("category_rank", r27);
        if (com.bytedance.android.live.openplatform.api.utils.b.b.g() == false) goto L90;
        ProductInfo r28 = r11.getProductInfo();
        if (r28 == null) goto L90;
        List<ProductLabelInfo> r29 = r28.labelList;
        if (r29 == null) goto L90;
        Iterator<T> r30 = r29.iterator();
    L78:
        if (r30.hasNext() == false) goto L85;
        Object r31 = r30.next();
        if (((ProductLabelInfo) r31).labelType != 3) goto L82;
        boolean r32 = true;
    L83:
        if (r32 == false) goto L78;
    L86:
        ProductLabelInfo r33 = (ProductLabelInfo) r31;
        if (r33 == null) goto L90;
        String r34 = r33.leftText;
        if (r34 == null) goto L90;
    L91:
        r0.put("expiration_date", r34);
        if (com.bytedance.android.live.openplatform.api.utils.b.b.a() == false) goto L111;
        ProductInfo r35 = r11.getProductInfo();
        if (r35 == null) goto L111;
        List<ProductIntroductionInfo> r36 = r35.introductionList;
        if (r36 == null) goto L111;
        Iterator<T> r37 = r36.iterator();
    L99:
        if (r37.hasNext() == false) goto L106;
        Object r38 = r37.next();
        if (((ProductIntroductionInfo) r38).introductionType != 2) goto L103;
        boolean r39 = true;
    L104:
        if (r39 == false) goto L99;
    L107:
        ProductIntroductionInfo r40 = (ProductIntroductionInfo) r38;
        if (r40 == null) goto L111;
        String r41 = r40.content;
        if (r41 == null) goto L111;
    L112:
        r0.put("available_cnt", r41);
        if (com.bytedance.android.live.openplatform.api.utils.b.b.b() == false) goto L134;
        ProductInfo r42 = r11.getProductInfo();
        if (r42 == null) goto L134;
        List<ProductLabelInfo> r43 = r42.labelList;
        if (r43 == null) goto L134;
        Iterator<T> r44 = r43.iterator();
    L120:
        if (r44.hasNext() == false) goto L127;
        Object r45 = r44.next();
        if (((ProductLabelInfo) r45).labelType != 2) goto L124;
        boolean r46 = true;
    L125:
        if (r46 == false) goto L120;
    L128:
        ProductLabelInfo r47 = (ProductLabelInfo) r45;
        if (r47 == null) goto L134;
        String r48 = r47.leftText;
        if (r48 == null) goto L134;
        r20 = r48;
        goto L134
    L124:
        r46 = false;
        goto L125
    L127:
        r45 = null;
    L134:
        r0.put("has_complement", r20);
        if (com.bytedance.android.live.openplatform.api.utils.b.b.e() == false) goto L151;
        int r49 = k81.c.a;
        ProductInfo r50 = r11.getProductInfo();
        if (r50 == null) goto L142;
        ProductPriceInfo r51 = r50.price;
        if (r51 == null) goto L142;
        r7 = r51.originalPrice;
    L142:
        if (k81.c.b(r7) == false) goto L151;
        ProductInfo r110 = r11.getProductInfo();
        if (r110 == null) goto L151;
        ProductPriceInfo r111 = r110.price;
        if (r111 == null) goto L151;
        String r112 = r111.originalPrice;
        if (r112 == null) goto L151;
        r12 = r112;
    L151:
        r0.put("original_price", r12);
        return r0;
    L103:
        r39 = false;
        goto L104
    L106:
        r38 = null;
    L111:
        r41 = "";
        goto L112
    L82:
        r32 = false;
        goto L83
    L85:
        r31 = null;
    L90:
        r34 = "";
        goto L91
    L61:
        r25 = false;
        goto L62
    L64:
        r24 = null;
    L69:
        r27 = "";
    L39:
        r16 = null;
    L48:
        r19 = "empty";
        goto L49
    L26:
        if (StringsKt.isBlank(r9) == true) goto L29;
        r10 = false;
        goto L30
    L23:
        r9 = null;
    L31:
        r4 = "0";
        goto L32
    L10:
        if (StringsKt.isBlank(r3) == true) goto L13;
        r5 = false;
        goto L14
    L7:
        r3 = null;
    L17:
        r6 = "0";
        goto L18
    }

    public final void reportAudienceLiveProjectionWatch(boolean r6) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        String r3 = "";
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r4 = r2.m618getShelfInfo();
        if (r4 == null) goto L12;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
        if (r5 == null) goto L12;
        ShelfMicroAppInfo r7 = r5.appInfo;
        if (r7 == null) goto L12;
        String r8 = r7.appId;
        if (r8 == null) goto L12;
    L13:
        r1.put("mp_id", r8);
        int r9 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r9 != 8) goto L16;
        r3 = "1v6";
    L20:
        r1.put("live_category", r3);
        if (r6 == false) goto L23;
        String r10 = "guest";
    L24:
        r1.put("projection_user_type", r10);
        Unit r11 = Unit.INSTANCE;
        r0.sendLog("livesdk_mp_live_projection_watch", r1, new Object[]{Room.class, getCommonParams()});
        return;
    L23:
        r10 = "audience";
        goto L24
    L16:
        if (r9 != 12) goto L20;
        r3 = "party";
    L12:
        r8 = "";
        goto L13
    }

    public final void reportMpImAuthPushEntryClick(lo0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "privateMsgEntranceInfo");
        u.l().e("mp_im_auth_push_entry_click", getMpImAuthPushEntryParams(r5), new Object[]{Room.class});
    }

    public final void reportMpImAuthPushEntryShow(lo0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "privateMsgEntranceInfo");
        u.l().e("mp_im_auth_push_entry_show", getMpImAuthPushEntryParams(r5), new Object[]{Room.class});
    }

    public final void reportMpLiveLinkClick(MountedMiniAppSource r14) {
        Intrinsics.checkNotNullParameter(r14, "source");
        commonClick$default(this, "mp_click", r14, null, 4, null);
        commonClick$default(this, "mp_live_link_click", r14, null, 4, null);
    }

    public final void reportMpLiveLinkShelfShow(boolean r6) {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L7;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
    L8:
        com.bytedance.android.livesdk.log.g r3 = u.l();
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("_param_for_special", "micro_app");
        if (r2 == null) goto L14;
        ShelfMicroAppInfo r5 = r2.appInfo;
        if (r5 == null) goto L14;
        String r7 = r5.appId;
        if (r7 == null) goto L14;
    L15:
        r4.put("mp_id", r7);
        getCommonShelfParams(r4);
        r4.putAll(getCommonParams());
        if (r6 == false) goto L18;
        String r8 = "1";
    L19:
        r4.put("if_security_deposit_tag", r8);
        MiniAppDataContext.Companion.getClass();
        r4.put("sell_point_shelf_card_num", String.valueOf(g.b(MiniAppDataContext.a.b())));
        Unit r9 = Unit.INSTANCE;
        r3.e("mp_live_link_shelf_show", r4, new Object[]{Room.class, x.class});
        return;
    L18:
        r8 = "0";
    L14:
        r7 = "";
    L7:
        r2 = null;
        goto L8
    }

    public final void reportMpLiveLinkShow(MountedMiniAppSource r14) {
        Intrinsics.checkNotNullParameter(r14, "source");
        commonShow$default(this, "mp_show", r14, null, 4, null);
        commonShow$default(this, "mp_live_link_show", r14, null, 4, null);
    }

    public final void reportMpLivePopupCardShow(Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r8, "extraParams");
        MountedMiniAppSource r0 = MountedMiniAppSource.ExplainCard;
        commonShow$default(this, "mp_show", r0, null, 4, null);
        commonShow("mp_live_popup_card_show", r0, r8);
    }

    public final void reportShelfTopMpEntranceClick(boolean r5) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L12;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r6 = r4.appInfo;
        if (r6 == null) goto L12;
        String r7 = r6.appId;
        if (r7 == null) goto L12;
    L13:
        r1.put("mp_id", r7);
        getCommonShelfParams(r1);
        r1.putAll(getCommonParams());
        if (r5 == false) goto L16;
        String r8 = "1";
    L17:
        r1.put("if_security_deposit_tag", r8);
        Unit r9 = Unit.INSTANCE;
        r0.e("mp_live_link_shelf_top_mp_entrance_click", r1, new Object[]{Room.class, getCommonParams(), x.class});
        return;
    L16:
        r8 = "0";
    L12:
        r7 = "";
        goto L13
    }

    public final void reportMpLiveLinkClick(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterPosition");
        commonClick("mp_click", r2);
        commonClick("mp_live_link_click", r2);
    }

    public final void reportMpLiveLinkShow(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterPosition");
        commonShow("mp_show", r2);
        commonShow("mp_live_link_show", r2);
    }

    private final void commonClick(String r5, String r6) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        Map<String, String> r2 = getToolbarDirectMicroAppLogParams();
        r2.put("enter_position", r6);
        r2.put("location", r6);
        Unit r7 = Unit.INSTANCE;
        r1.putAll(r2);
        r1.putAll(getLogParams());
        r1.putAll(getAdLogParams());
        r1.putAll(getCommonParams());
        r1.putAll(getLiveCastParams());
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L5;
        r1.put("if_mp_live_projection", "1");
    L5:
        r0.e(r5, r1, new Object[]{Room.class, x.class});
    }

    private final void commonShow(String r5, String r6) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        Map<String, String> r2 = getToolbarDirectMicroAppLogParams();
        r2.put("enter_position", r6);
        r2.put("location", r6);
        Unit r7 = Unit.INSTANCE;
        r1.putAll(r2);
        r1.putAll(getLogParams());
        r1.putAll(getAdLogParams());
        r1.putAll(getCommonParams());
        r1.putAll(getLiveCastParams());
        r0.e(r5, r1, new Object[]{Room.class, x.class});
    }

    private final Map<String, String> getCommonShelfCardParams(long r10, boolean r12) {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        String r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<ShelfInfo> r2 = r0.m618getShelfInfo();
        if (r2 == null) goto L7;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
    L8:
        boolean r4 = false;
        if (r3 == null) goto L23;
        List<ShelfCardInfo> r5 = r3.cardInfoList;
        if (r5 == null) goto L23;
        Iterator<T> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        if (((ShelfCardInfo) r7).getCardId() != r10) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L14;
    L22:
        ShelfCardInfo r9 = (ShelfCardInfo) r7;
    L24:
        LinkedHashMap r11 = new LinkedHashMap();
        String r13 = "1";
        if (r12 == false) goto L27;
        Object r14 = "1";
    L28:
        r11.put("if_card_pin", r14);
        r11.put("real_card_rank", String.valueOf(d.a(r10)));
        if (r9 != null) goto L31;
    L33:
        Object r15 = "0";
    L34:
        r11.put("if_card_explanation", r15);
        if (r9 == null) goto L43;
        List<ImageModel> r16 = r9.L();
        if (r16 == null) goto L43;
        ImageModel r17 = (ImageModel) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L43;
        List r18 = r17.getUrls();
        if (r18 == null) goto L43;
        String r19 = (String) CollectionsKt.firstOrNull(r18);
    L44:
        if (r9 == null) goto L46;
        String r110 = r9.F();
    L48:
        if ((!Intrinsics.areEqual(r19, r110)) == false) goto L50;
        Object r111 = "1";
    L55:
        r11.put("if_change_pic", r111);
        if (r9 == null) goto L58;
        r1 = r9.E();
    L58:
        if (r1 != null) goto L60;
    L61:
        r4 = true;
    L62:
        if (r4 == false) goto L69;
        if (r9 != null) goto L66;
    L68:
        r13 = "0";
        goto L69
    L66:
        if (r9.y0() != true) goto L68;
        r13 = "2";
    L69:
        r11.put("if_change_title", r13);
        r11.put("back_image_type", getCoverTypeParam(r9));
        return r11;
    L60:
        if (StringsKt.isBlank(r1) == false) goto L62;
    L50:
        if (r9 != null) goto L52;
    L54:
        r111 = "0";
        goto L55
    L52:
        if (r9.w0() != true) goto L54;
        r111 = "2";
        goto L55
    L46:
        r110 = null;
    L43:
        r19 = null;
        goto L44
    L31:
        if (r9.getStatus() != 1) goto L33;
        r15 = "1";
        goto L34
    L27:
        r14 = "0";
        goto L28
    L18:
        r8 = false;
        goto L19
    L21:
        r7 = null;
    L23:
        r9 = null;
    L7:
        r3 = null;
        goto L8
    }

    private final void insertLogExtra(String r4, Map<String, String> r5) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L16;
        return;
    L16:
        JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L15
        Iterator<String> r6 = r1.keys();     // Catch: JSONException -> L15
    L11:
        if (r6.hasNext() == false) goto L21;
        String r2 = r6.next();     // Catch: JSONException -> L15
        r5.put(r2, JSONObjectProtectorUtils.getString(r1, r2));     // Catch: JSONException -> L15
    L21:
        return;
    L20:
        return;
    L4:
        if (StringsKt.isBlank(r4) == true) goto L7;
        r0 = false;
        goto L8
    }

    public final void reportAudienceLiveProjectionWatchDuration(long r6, boolean r8) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        String r3 = "";
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r4 = r2.m618getShelfInfo();
        if (r4 == null) goto L12;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
        if (r5 == null) goto L12;
        ShelfMicroAppInfo r7 = r5.appInfo;
        if (r7 == null) goto L12;
        String r9 = r7.appId;
        if (r9 == null) goto L12;
    L13:
        r1.put("mp_id", r9);
        r1.put("duration", String.valueOf(r6));
        int r10 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r10 != 8) goto L16;
        r3 = "1v6";
    L20:
        r1.put("live_category", r3);
        if (r8 == false) goto L23;
        String r11 = "guest";
    L24:
        r1.put("projection_user_type", r11);
        Unit r12 = Unit.INSTANCE;
        r0.sendLog("livesdk_mp_live_projection_watch_duration", r1, new Object[]{Room.class, getCommonParams()});
        return;
    L23:
        r11 = "audience";
        goto L24
    L16:
        if (r10 != 12) goto L20;
        r3 = "party";
    L12:
        r9 = "";
        goto L13
    }

    public final void reportMpLiveLinkShelfStayTime(long r5, long r7) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        IHostContext r2 = k.n(IHostContext.class);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r3 = AudienceMiniAppDataContext.a.a();
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.n<ShelfInfo> r4 = r3.m618getShelfInfo();
        if (r4 == null) goto L11;
        ShelfInfo r6 = (ShelfInfo) r4.getValue();
        if (r6 == null) goto L11;
        ShelfMicroAppInfo r8 = r6.appInfo;
        if (r8 == null) goto L11;
        String r9 = r8.appId;
    L13:
        if (r2.isMpInSandboxMode(r9) == false) goto L15;
        String r10 = "sandbox";
    L16:
        r1.put("_param_for_special", r10);
        AudienceMiniAppDataContext r11 = AudienceMiniAppDataContext.a.a();
        if (r11 == null) goto L26;
        com.bytedance.live.datacontext.n<ShelfInfo> r12 = r11.m618getShelfInfo();
        if (r12 == null) goto L26;
        ShelfInfo r13 = (ShelfInfo) r12.getValue();
        if (r13 == null) goto L26;
        ShelfMicroAppInfo r14 = r13.appInfo;
        if (r14 == null) goto L26;
        String r15 = r14.appId;
        if (r15 == null) goto L26;
    L27:
        r1.put("mp_id", r15);
        r1.put("duration", String.valueOf(r5 + r7));
        r1.put("shelf_duration", String.valueOf(r5));
        r1.put("mp_duration", String.valueOf(r7));
        r1.putAll(getCommonParams());
        Unit r16 = Unit.INSTANCE;
        r0.e("mp_live_link_shelf_stay_time", r1, new Object[]{Room.class, x.class});
        return;
    L26:
        r15 = "";
        goto L27
    L15:
        r10 = "micro_app";
    L11:
        r9 = null;
        goto L13
    }

    public final void reportMpLivePopupCardClick(MountedMiniAppSource r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r8, "source");
        Intrinsics.checkNotNullParameter(r9, "extraParams");
        commonClick$default(this, "mp_click", r8, null, 4, null);
        commonClick("mp_live_popup_card_click", r8, r9);
    }

    private final void commonClick(String r7, MountedMiniAppSource r8, Map<String, String> r9) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        int r2 = hq0.a.b[r8.ordinal()];
        if (r2 == 1) goto L12;
        if (r2 != 2) goto L6;
    L11:
        Map<String, String> r3 = getExplainCardLogParams("click");
    L13:
        r1.putAll(r3);
        r1.putAll(getLogParams());
        r1.putAll(getAdLogParams());
        r1.putAll(getCommonParams());
        r1.putAll(getLiveCastParams());
        int r10 = hq0.a.c[r8.ordinal()];
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L17;
        Map r11 = MapsKt.emptyMap();
    L19:
        r1.putAll(r11);
        r1.putAll(r9);
        Unit r12 = Unit.INSTANCE;
        r0.e(r7, r1, new Object[]{Room.class, x.class});
        return;
    L17:
        r11 = MapsKt.mapOf(TuplesKt.to("click_position", "icon"));
        goto L19
    L18:
        r11 = MapsKt.mapOf(TuplesKt.to("click_position", "card"));
        goto L19
    L6:
        if (r2 == 3) goto L11;
        if (r2 == 4) goto L10;
        r3 = MapsKt.emptyMap();
        goto L13
    L10:
        r3 = getToolbarDirectMicroAppLogParams();
        goto L13
    L12:
        r3 = getConnectionPanelLogParams();
        goto L13
    }

    private final void commonShow(String r6, MountedMiniAppSource r7, Map<String, String> r8) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        int r9 = hq0.a.a[r7.ordinal()];
        if (r9 == 1) goto L12;
        if (r9 != 2) goto L6;
    L11:
        Map<String, String> r10 = getExplainCardLogParams("show");
    L13:
        r1.putAll(r10);
        r1.putAll(getLogParams());
        r1.putAll(getAdLogParams());
        r1.putAll(getCommonParams());
        r1.putAll(getLiveCastParams());
        r1.putAll(r8);
        Unit r11 = Unit.INSTANCE;
        r0.e(r6, r1, new Object[]{Room.class, x.class});
        return;
    L6:
        if (r9 == 3) goto L11;
        if (r9 == 4) goto L10;
        r10 = MapsKt.emptyMap();
        goto L13
    L10:
        r10 = getToolbarDirectMicroAppLogParams();
        goto L13
    L12:
        r10 = getConnectionPanelLogParams();
        goto L13
    }

    public final void reportHotAtmosphereVisibilityChanged(boolean r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "bubbleType");
        com.bytedance.android.livesdk.log.g r0 = u.l();
        if (r5 == false) goto L5;
        String r8 = "mp_live_popup_card_top_atmos_bubble_show";
    L6:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("bubble_type", r6);
        r1.put("show_number", String.valueOf(r7));
        r1.putAll(getCommonParams());
        Unit r9 = Unit.INSTANCE;
        r0.e(r8, r1, new Object[]{Room.class});
        return;
    L5:
        r8 = "mp_live_popup_card_top_atmos_bubble_hide";
        goto L6
    }

    public final void reportMpLiveLinkShelfCardShow(ShelfCardInfo r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "cardInfo");
        com.bytedance.android.livesdk.log.g r15 = u.l();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("_param_for_special", "micro_app");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        String r2 = "";
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r1.m618getShelfInfo();
        if (r3 == null) goto L12;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L12;
        String r6 = r5.appId;
        if (r6 == null) goto L12;
    L13:
        r0.put("mp_id", r6);
        AudienceMiniAppDataContext r7 = AudienceMiniAppDataContext.a.a();
        if (r7 == null) goto L23;
        com.bytedance.live.datacontext.n<ShelfInfo> r8 = r7.m618getShelfInfo();
        if (r8 == null) goto L23;
        ShelfInfo r9 = (ShelfInfo) r8.getValue();
        if (r9 == null) goto L23;
        ShelfMicroAppInfo r10 = r9.appInfo;
        if (r10 == null) goto L23;
        String r11 = r10.name;
        if (r11 == null) goto L23;
    L24:
        r0.put("mp_name", r11);
        r0.put("enter_position", "live_shelf_card");
        r0.put("entrance_form", "live");
        String r16 = com.bytedance.android.live.openplatform.impl.base.utils.n.a();
        if (r16.length() <= 0) goto L27;
        boolean r17 = true;
    L28:
        String r18 = null;
        if (r17 == true) goto L32;
        r16 = null;
    L32:
        if (r16 != null) goto L34;
        r16 = "natural";
    L34:
        r0.put("is_ad_channel", r16);
        r0.putAll(getCommonShelfCardParams(r12.getCardId(), r13));
        AudienceMiniAppDataContext r19 = AudienceMiniAppDataContext.a.a();
        if (r19 == null) goto L55;
        com.bytedance.live.datacontext.n<ShelfInfo> r110 = r19.m618getShelfInfo();
        if (r110 == null) goto L55;
        ShelfInfo r111 = (ShelfInfo) r110.getValue();
        if (r111 == null) goto L55;
        List<ShelfCardInfo> r112 = r111.cardInfoList;
        if (r112 == null) goto L55;
        ListIterator<ShelfCardInfo> r113 = r112.listIterator(r112.size());
    L44:
        if (r113.hasPrevious() == false) goto L51;
        ShelfCardInfo r20 = r113.previous();
        if (r20.getCardId() != r12.getCardId()) goto L48;
        boolean r21 = true;
    L49:
        if (r21 == false) goto L44;
    L52:
        ShelfCardInfo r22 = r20;
        if (r22 == null) goto L55;
        String r114 = r22.R();
    L56:
        insertLogExtra(r114, r0);
        String r115 = r12.a0();
        if (r115 == null) goto L59;
        r2 = h.c(r115);
    L59:
        r0.put("page_path", r2);
        r0.putAll(getCommonParams());
        r0.putAll(getProductInfoShowMap(r12));
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r116 = AudienceMiniAppDataContext.a.a();
        if (r116 == null) goto L68;
        com.bytedance.live.datacontext.n<ShelfInfo> r117 = r116.m618getShelfInfo();
        if (r117 == null) goto L68;
        ShelfInfo r118 = (ShelfInfo) r117.getValue();
        if (r118 == null) goto L68;
        List<ShelfCardInfo> r119 = r118.cardInfoList;
        if (r119 == null) goto L68;
        int r120 = r119.size();
    L69:
        r0.put("shelf_card_num", String.valueOf(r120));
        ProductInfo r121 = r12.getProductInfo();
        if (r121 == null) goto L72;
        r18 = r121.productId;
    L72:
        if (r18 != null) goto L74;
    L77:
        boolean r122 = true;
    L78:
        if (r122 == true) goto L80;
        String r123 = "go_purchase";
    L81:
        r0.put("click_icon_type", r123);
        r0.put("icon_link_type", getLinkType(r12));
        r0.put("card_page_id", String.valueOf(r12.getCardId()));
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r124 = MiniAppDataContext.a.b();
        int r23 = ((uc1) ee0.a.getValue()).p();
        if (r23 == 1) goto L86;
        if (r23 == 2) goto L85;
        boolean r125 = false;
    L87:
        String r24 = "1";
        if (r125 == false) goto L90;
        String r126 = "1";
    L91:
        r0.put("if_larger", r126);
        List<ProductLabelInfo> r127 = rq0.b.a(r12);
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator<T> r129 = r127.iterator();
    L93:
        if (r129.hasNext() == false) goto L95;
        r128.add(String.valueOf(((ProductLabelInfo) r129.next()).labelType));
        goto L93
    L95:
        Object[] r130 = r128.toArray(new String[0]);
        if (r130 == null) goto L104;
        r0.put("card_tag_list", Arrays.toString(r130));
        MiniAppDataContext.Companion.getClass();
        if (g.b(MiniAppDataContext.a.b()) != 0) goto L101;
        r24 = "0";
    L101:
        r0.put("if_has_sell_point", r24);
        Unit r131 = Unit.INSTANCE;
        r15.e("mp_live_link_shelf_card_show", r0, new Object[]{Room.class, getCommonParams(), x.class});
        return;
    L104:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L90:
        r126 = "0";
        goto L91
    L85:
        r125 = g.d(r124);
        goto L87
    L86:
        r125 = true;
        goto L87
    L80:
        r123 = "view";
        goto L81
    L74:
        if (StringsKt.isBlank(r18) == true) goto L77;
        r122 = false;
    L68:
        r120 = 0;
        goto L69
    L48:
        r21 = false;
        goto L49
    L51:
        r20 = null;
    L55:
        r114 = null;
        goto L56
    L27:
        r17 = false;
    L23:
        r11 = "";
    L12:
        r6 = "";
        goto L13
    }

    public final void reportMpLivePopupCardShowAnimEnd(boolean r2, boolean r3, ExplainCardAnimType r4) {
        Intrinsics.checkNotNullParameter(r4, "animType");
        reportMpLivePopupCardShowAnim(false, r2, r3, r4);
    }

    public final void reportMpLivePopupCardShowAnimStart(boolean r2, boolean r3, ExplainCardAnimType r4) {
        Intrinsics.checkNotNullParameter(r4, "animType");
        reportMpLivePopupCardShowAnim(true, r2, r3, r4);
    }

    public final void reportSupplementInfoVisibilityChanged(boolean r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "bubbleType");
        com.bytedance.android.livesdk.log.g r0 = u.l();
        if (r5 == false) goto L5;
        String r8 = "mp_live_popup_card_page_info_show";
    L6:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("bubble_type", r6);
        r1.put("show_number", String.valueOf(r7));
        r1.putAll(getCommonParams());
        Unit r9 = Unit.INSTANCE;
        r0.e(r8, r1, new Object[]{Room.class});
        return;
    L5:
        r8 = "mp_live_popup_card_page_info_hide";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportMpLivePopupCardShow$default(AudienceMiniAppAppLogContextService r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        r0.reportMpLivePopupCardShow(r1);
    }

    private final void reportMpLivePopupCardShowAnim(boolean r6, boolean r7, boolean r8, ExplainCardAnimType r9) {
        if (r6 == false) goto L4;
        String r10 = "mp_live_popup_card_show_anim_start";
    L5:
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L15;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L15;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L15;
        String r11 = r5.appId;
        if (r11 == null) goto L15;
    L16:
        r1.put("mp_id", r11);
        String r12 = "1";
        if (r7 == false) goto L19;
        Object r13 = "1";
    L20:
        r1.put("is_enter_room", r13);
        if (r8 == true) goto L24;
        r12 = "0";
    L24:
        r1.put("is_lynx_card", r12);
        r1.put("anim_type", String.valueOf(r9.getValue()));
        r1.putAll(getCommonParams());
        Unit r14 = Unit.INSTANCE;
        r0.e(r10, r1, new Object[]{Room.class});
        return;
    L19:
        r13 = "0";
    L15:
        r11 = "";
        goto L16
    L4:
        r10 = "mp_live_popup_card_show_anim_end";
        goto L5
    }

    public final void reportMpLiveLinkShelfCardClick(ShelfCardInfo r12, String r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "cardInfo");
        Intrinsics.checkNotNullParameter(r13, "clickPosition");
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        String r3 = "";
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r4 = r2.m618getShelfInfo();
        if (r4 == null) goto L12;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
        if (r5 == null) goto L12;
        ShelfMicroAppInfo r6 = r5.appInfo;
        if (r6 == null) goto L12;
        String r7 = r6.appId;
        if (r7 == null) goto L12;
    L13:
        r1.put("mp_id", r7);
        AudienceMiniAppDataContext r8 = AudienceMiniAppDataContext.a.a();
        if (r8 == null) goto L23;
        com.bytedance.live.datacontext.n<ShelfInfo> r9 = r8.m618getShelfInfo();
        if (r9 == null) goto L23;
        ShelfInfo r10 = (ShelfInfo) r9.getValue();
        if (r10 == null) goto L23;
        ShelfMicroAppInfo r11 = r10.appInfo;
        if (r11 == null) goto L23;
        String r16 = r11.name;
        if (r16 == null) goto L23;
    L24:
        r1.put("mp_name", r16);
        r1.put("enter_position", "live_shelf_card");
        r1.put("entrance_form", "live");
        r1.putAll(getCommonShelfCardParams(r12.getCardId(), r14));
        r1.put("click_position", r13);
        String r17 = com.bytedance.android.live.openplatform.impl.base.utils.n.a();
        if (r17.length() <= 0) goto L27;
        boolean r18 = true;
    L28:
        String r19 = null;
        if (r18 == true) goto L32;
        r17 = null;
    L32:
        if (r17 != null) goto L34;
        r17 = "natural";
    L34:
        r1.put("is_ad_channel", r17);
        AudienceMiniAppDataContext r110 = AudienceMiniAppDataContext.a.a();
        if (r110 == null) goto L55;
        com.bytedance.live.datacontext.n<ShelfInfo> r111 = r110.m618getShelfInfo();
        if (r111 == null) goto L55;
        ShelfInfo r112 = (ShelfInfo) r111.getValue();
        if (r112 == null) goto L55;
        List<ShelfCardInfo> r113 = r112.cardInfoList;
        if (r113 == null) goto L55;
        ListIterator<ShelfCardInfo> r114 = r113.listIterator(r113.size());
    L44:
        if (r114.hasPrevious() == false) goto L51;
        ShelfCardInfo r115 = r114.previous();
        if (r115.getCardId() != r12.getCardId()) goto L48;
        boolean r20 = true;
    L49:
        if (r20 == false) goto L44;
    L52:
        ShelfCardInfo r116 = r115;
        if (r116 == null) goto L55;
        String r117 = r116.R();
    L56:
        insertLogExtra(r117, r1);
        String r118 = r12.a0();
        if (r118 == null) goto L59;
        r3 = h.c(r118);
    L59:
        r1.put("page_path", r3);
        r1.putAll(getCommonParams());
        r1.putAll(getProductInfoShowMap(r12));
        String r119 = "1";
        if (r15 == false) goto L62;
        String r120 = "1";
    L63:
        r1.put("if_security_deposit_tag", r120);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r121 = AudienceMiniAppDataContext.a.a();
        if (r121 == null) goto L72;
        com.bytedance.live.datacontext.n<ShelfInfo> r122 = r121.m618getShelfInfo();
        if (r122 == null) goto L72;
        ShelfInfo r123 = (ShelfInfo) r122.getValue();
        if (r123 == null) goto L72;
        List<ShelfCardInfo> r124 = r123.cardInfoList;
        if (r124 == null) goto L72;
        int r125 = r124.size();
    L73:
        r1.put("shelf_card_num", String.valueOf(r125));
        ProductInfo r126 = r12.getProductInfo();
        if (r126 == null) goto L76;
        r19 = r126.productId;
    L76:
        if (r19 != null) goto L78;
    L81:
        boolean r127 = true;
    L82:
        if (r127 == true) goto L84;
        String r128 = "go_purchase";
    L85:
        r1.put("click_icon_type", r128);
        r1.put("icon_link_type", getLinkType(r12));
        r1.put("card_page_id", String.valueOf(r12.getCardId()));
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r129 = MiniAppDataContext.a.b();
        int r21 = ((uc1) ee0.a.getValue()).p();
        if (r21 == 1) goto L90;
        if (r21 == 2) goto L89;
        boolean r130 = false;
    L91:
        if (r130 == false) goto L93;
        String r131 = "1";
    L94:
        r1.put("if_larger", r131);
        List<ProductLabelInfo> r132 = rq0.b.a(r12);
        ArrayList r133 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r132, 10));
        Iterator<T> r134 = r132.iterator();
    L96:
        if (r134.hasNext() == false) goto L98;
        r133.add(String.valueOf(((ProductLabelInfo) r134.next()).labelType));
        goto L96
    L98:
        Object[] r135 = r133.toArray(new String[0]);
        if (r135 == null) goto L107;
        r1.put("card_tag_list", Arrays.toString(r135));
        MiniAppDataContext.Companion.getClass();
        if (g.b(MiniAppDataContext.a.b()) != 0) goto L104;
        r119 = "0";
    L104:
        r1.put("if_has_sell_point", r119);
        Unit r136 = Unit.INSTANCE;
        r0.e("mp_live_link_shelf_card_click", r1, new Object[]{Room.class, getCommonParams(), x.class});
        return;
    L107:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L93:
        r131 = "0";
        goto L94
    L89:
        r130 = g.d(r129);
        goto L91
    L90:
        r130 = true;
        goto L91
    L84:
        r128 = "view";
        goto L85
    L78:
        if (StringsKt.isBlank(r19) == true) goto L81;
        r127 = false;
    L72:
        r125 = 0;
        goto L73
    L62:
        r120 = "0";
        goto L63
    L48:
        r20 = false;
        goto L49
    L51:
        r115 = null;
    L55:
        r117 = null;
        goto L56
    L27:
        r18 = false;
    L23:
        r16 = "";
    L12:
        r7 = "";
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportMpLivePopupCardClick$default(AudienceMiniAppAppLogContextService r0, MountedMiniAppSource r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = MapsKt.emptyMap();
    L5:
        r0.reportMpLivePopupCardClick(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void commonClick$default(AudienceMiniAppAppLogContextService r0, String r1, MountedMiniAppSource r2, Map r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = MapsKt.emptyMap();
    L5:
        r0.commonClick(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void commonShow$default(AudienceMiniAppAppLogContextService r0, String r1, MountedMiniAppSource r2, Map r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = MapsKt.emptyMap();
    L5:
        r0.commonShow(r1, r2, r3);
    }
}
