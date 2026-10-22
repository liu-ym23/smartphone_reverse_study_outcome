package com.bytedance.android.live.openplatform.impl.miniappanchor.applog;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.memory.MemoryContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.d;
import com.bytedance.android.live.openplatform.impl.miniappcommon.applog.MiniAppAppLogContextService;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.bl;
import com.bytedance.android.livesdk.message.model.el;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b9\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J&\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u000bJ&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aJ&\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011J\u001e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0011J\u0016\u0010$\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007J\u0016\u0010&\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0011J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J>\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010/\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007J\u0016\u00101\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007J\u0016\u00102\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J\u000e\u00104\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J&\u00105\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u0007J\u000e\u00109\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010:\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007J\u0016\u0010<\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020\u000bJ\u000e\u0010?\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010@\u001a\u00020\u000bJ\u0018\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u00072\b\u0010C\u001a\u0004\u0018\u00010\u0007J\u0016\u0010D\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010E\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010F\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010G\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010H\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007J(\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010M\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u001dJ\u0006\u0010O\u001a\u00020\u000bJ\u0006\u0010P\u001a\u00020\u000bJ(\u0010Q\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u001d2\b\b\u0002\u0010S\u001a\u00020\u001dJ&\u0010T\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u001dJ\u0016\u0010V\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!J\u000e\u0010W\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J&\u0010X\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007¨\u0006Z"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/applog/AnchorMiniAppAppLogContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/applog/MiniAppAppLogContextService;", "openPlatformContext", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "getMpShowOrClickCommonParams", "", "", "mpId", "enterPosition", "insertCreateInfo", "", "createInfo", "map", "", "reportAddShelfPageSuccess", "isBeforeLive", "", "bindSource", "reportAnchorCancelExplain", "reportAnchorExitBindSuccess", "exitSource", "reportAnchorExplainCardSettingsShow", "reportAnchorShelfDisplayDialogCardShow", "clickSource", "cardInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "reportAnchorShelfDisplayDialogShow", "cardNum", "", "hasCommodityCard", "reportAnchorShelfDisplayDialogShowDuration", "duration", "", "reportAnchorStartExplain", "fromSwitchPlay", "reportCardMorePanelClick", "operatePosition", "reportCardMorePanelShow", "showSetExplainCard", "reportCoexistExplainFrequencyLimit", "reportCoexistShelfDisplayDialogBannerClick", "reportCoexistShelfDisplayDialogBannerShow", "reportCoexistStatusChangedStart", "isCoexistStart", "isMountedBeforeStart", "endSource", "reportCouponEntranceClick", "pageLocation", "reportCouponEntranceShow", "reportDefaultOpenFirstExplainCardOn", "source", "reportEditSellingPointPanelShow", "reportEditSellingPointResult", "pass", "sellingPointLength", "rejectReason", "reportEditSellingPointStart", "reportExitBindPushClick", "clickPosition", "reportExitBindPushShow", "reportExplainCardClickEdit", "reportExplainCardOnOffSet", "reportExplainCardSettingChangeCover", "reportExplainCardSettingShow", "reportGiveUpRemainder", "appId", "startPageUrl", "reportMpClick", "reportMpShow", "reportOpenExplainCardNotice", "reportPageShelfAuditResult", "reportPageShelfBubblePush", "bubbleType", "reportPageShelfSubmitAudit", "isChangePic", "isChangeTitle", "reportPageShelfTitleChangeResult", "reviewStatus", "reportReSetMiniCardCover", "reportReSetMiniCardTitle", "reportShelfSettingPageOperate", "addingPageNum", "deletePageNum", "reportShelfSettingPageShow", "sellingPointNum", "reportShelfSettingPageStayDuration", "reportShowImportantCardClose", "reportSmallProgramAdd", "homePath", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniAppAppLogContextService extends MiniAppAppLogContextService {
    public final void reportAnchorCancelExplain() {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r2 = AnchorMiniAppDataContext.a.a();
        if (r2 == null) goto L12;
        n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L12;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L12;
        String r6 = r5.appId;
        if (r6 == null) goto L12;
    L13:
        r1.put("mp_id", r6);
        r1.put("bind_source", "app");
        MiniAppDataContext.Companion.getClass();
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(MiniAppDataContext.a.b()) == false) goto L16;
        String r7 = "1";
    L17:
        r1.put("if_coexist", r7);
        r1.putAll(getCoexistParams());
        r1.putAll(getCommonParams());
        Unit r8 = Unit.INSTANCE;
        r0.h("mp_anchor_cancel_explain", r1, new Object[]{Room.class});
        return;
    L16:
        r7 = "0";
    L12:
        r6 = "";
        goto L13
    }

    public final void reportExplainCardOnOffSet() {
        u.l().sendLog("livesdk_small_program_explanation_card_on_off_set", getCommonParams(), new Object[]{Room.class});
    }

    public final void reportExplainCardSettingShow() {
        u.l().sendLog("livesdk_small_program_explanation_card_set_show", getCommonParams(), new Object[]{Room.class});
    }

    public final void reportReSetMiniCardCover() {
        u.l().sendLog("livesdk_small_program_explanation_card_picture_set", getCommonParams(), new Object[]{Room.class});
    }

    public final void reportReSetMiniCardTitle() {
        u.l().sendLog("livesdk_small_program_explanation_card_title_set", getCommonParams(), new Object[]{Room.class});
    }

    public AnchorMiniAppAppLogContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public final void reportAnchorExplainCardSettingsShow(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r6 = "in_live";
    L6:
        r1.put("live_status", r6);
        r1.putAll(getCommonParams());
        Unit r7 = Unit.INSTANCE;
        r0.h("mp_anchor_explanation_card_settings_show", r1, new Object[]{Room.class});
        return;
    L5:
        r6 = "before_live";
        goto L6
    }

    public final void reportAnchorStartExplain(boolean r7) {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r2 = AnchorMiniAppDataContext.a.a();
        if (r2 == null) goto L12;
        n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L12;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L12;
        String r6 = r5.appId;
        if (r6 == null) goto L12;
    L13:
        r1.put("mp_id", r6);
        r1.put("bind_source", "app");
        MiniAppDataContext.Companion.getClass();
        String r8 = "1";
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(MiniAppDataContext.a.b()) == false) goto L16;
        Object r9 = "1";
    L17:
        r1.put("if_coexist", r9);
        r1.putAll(getCoexistParams());
        if (r7 == true) goto L21;
        r8 = "0";
    L21:
        r1.put("if_change", r8);
        r1.putAll(getCommonParams());
        Unit r10 = Unit.INSTANCE;
        r0.h("mp_anchor_start_explain", r1, new Object[]{Room.class});
        return;
    L16:
        r9 = "0";
    L12:
        r6 = "";
        goto L13
    }

    public final void reportCoexistExplainFrequencyLimit(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.h("mp_coexist_bind_frequency_push", r1, new Object[]{Room.class});
    }

    public final void reportCoexistShelfDisplayDialogBannerClick(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.h("mp_coexist_bind_guide_click", r1, new Object[]{Room.class});
    }

    public final void reportCoexistShelfDisplayDialogBannerShow(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.h("mp_coexist_bind_guide_show", r1, new Object[]{Room.class});
    }

    public final void reportEditSellingPointPanelShow(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r6 = "in_live";
    L6:
        r1.put("live_status", r6);
        r1.put("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        Unit r7 = Unit.INSTANCE;
        r0.h("mp_anchor_sell_point_settings_show", r1, new Object[0]);
        return;
    L5:
        r6 = "before_live";
        goto L6
    }

    public final void reportEditSellingPointStart(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r6 = "in_live";
    L6:
        r1.put("live_status", r6);
        r1.put("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        Unit r7 = Unit.INSTANCE;
        r0.h("mp_anchor_sell_point_edit", r1, new Object[0]);
        return;
    L5:
        r6 = "before_live";
        goto L6
    }

    public final void reportExplainCardClickEdit(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r6 = "in_live";
    L6:
        r1.put("live_status", r6);
        Unit r7 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_click_edit_card", r1, new Object[]{Room.class});
        return;
    L5:
        r6 = "before_live";
        goto L6
    }

    public final void reportExplainCardSettingChangeCover(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r6 = "in_live";
    L6:
        r1.put("live_status", r6);
        r1.putAll(getCommonParams());
        Unit r7 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_click_change_pic", r1, new Object[]{Room.class});
        return;
    L5:
        r6 = "before_live";
        goto L6
    }

    public final void reportOpenExplainCardNotice(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.h("mp_anchor_page_default_popup_card_reminder", r1, new Object[]{Room.class});
    }

    public final void reportPageShelfAuditResult(ShelfCardInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "cardInfo");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r2 = AnchorMiniAppDataContext.a.a();
        String r3 = "";
        if (r2 == null) goto L12;
        n<ShelfInfo> r4 = r2.m618getShelfInfo();
        if (r4 == null) goto L12;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
        if (r5 == null) goto L12;
        ShelfMicroAppInfo r7 = r5.appInfo;
        if (r7 == null) goto L12;
        String r8 = r7.appId;
        if (r8 == null) goto L12;
    L13:
        r1.put("mp_id", r8);
        int r9 = r6.s();
        if (r9 != ShelfCardInfo.Source.Phone.getValue()) goto L17;
        r3 = "app";
    L19:
        r1.put("bind_source", r3);
        if (r6.F0() == false) goto L23;
        String r10 = "pass";
    L26:
        r1.put("result", r10);
        insertCreateInfo(r6.t(), r1);
        r1.putAll(getCommonParams());
        Unit r11 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_audit_result", r1, new Object[]{Room.class});
        return;
    L23:
        if (r6.G0(1) == false) goto L25;
        r10 = "reject";
        goto L26
    L25:
        r10 = "end_live";
        goto L26
    L17:
        if (r9 != ShelfCardInfo.Source.PC.getValue()) goto L19;
        r3 = "live_assistant";
    L12:
        r8 = "";
        goto L13
    }

    public final void reportShowImportantCardClose(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        Unit r6 = Unit.INSTANCE;
        r0.h("mp_anchor_page_key_info_card_close", r1, new Object[]{Room.class});
    }

    private final Map<String, String> getMpShowOrClickCommonParams(String r4, String r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("_param_for_special", "micro_app");
        r0.put("mp_id", r4);
        r0.put("entrance_form", "solid_entrance");
        r0.put("enter_position", r5);
        r0.put("enter_from_merge", "live_take_page");
        String r6 = LaunchParamConstant$Scene.a;
        r0.put("scene", LaunchParamConstant$Scene.a);
        r0.put("launch_from", "live");
        r0.put("location", PbRequest.SwitchType.PREVIEW);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r7 = "in_live";
    L6:
        r0.put("live_status", r7);
        return r0;
    L5:
        r7 = "before_live";
        goto L6
    }

    private final void insertCreateInfo(String r4, Map<String, String> r5) {
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

    public final void reportCardMorePanelClick(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "operatePosition");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r7 = "in_live";
    L6:
        r1.put("live_status", r7);
        r1.put("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        r1.put("operate_position", r6);
        Unit r8 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_setting_page_more_panel_operate", r1, new Object[0]);
        return;
    L5:
        r7 = "before_live";
        goto L6
    }

    public final void reportCardMorePanelShow(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r7 = "in_live";
    L6:
        r1.put("live_status", r7);
        r1.put("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        if (r6 == false) goto L9;
        String r8 = "1";
    L10:
        r1.put("is_has_set_explanation_card", r8);
        Unit r9 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_setting_page_more_panel_show", r1, new Object[0]);
        return;
    L9:
        r8 = "0";
        goto L10
    L5:
        r7 = "before_live";
        goto L6
    }

    public final void reportCouponEntranceClick(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "pageLocation");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        r1.put("page_location", r6);
        MiniAppDataContext.Companion.getClass();
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(MiniAppDataContext.a.b()) == false) goto L5;
        String r7 = "1";
    L6:
        r1.put("if_coexist", r7);
        r1.putAll(getCoexistParams());
        r1.putAll(getCommonParams());
        Unit r8 = Unit.INSTANCE;
        r0.h("mp_coupon_config_entrance_click", r1, new Object[]{Room.class});
        return;
    L5:
        r7 = "0";
        goto L6
    }

    public final void reportCouponEntranceShow(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "pageLocation");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        r1.put("page_location", r6);
        MiniAppDataContext.Companion.getClass();
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(MiniAppDataContext.a.b()) == false) goto L5;
        String r7 = "1";
    L6:
        r1.put("if_coexist", r7);
        r1.putAll(getCoexistParams());
        r1.putAll(getCommonParams());
        Unit r8 = Unit.INSTANCE;
        r0.h("mp_coupon_config_entrance_show", r1, new Object[]{Room.class});
        return;
    L5:
        r7 = "0";
        goto L6
    }

    public final void reportDefaultOpenFirstExplainCardOn(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "source");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        r1.put("open_source", r6);
        Unit r7 = Unit.INSTANCE;
        r0.h("mp_anchor_page_default_popup_card_open", r1, new Object[]{Room.class});
    }

    public final void reportExitBindPushShow(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "exitSource");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r7 = "in_live";
    L6:
        r1.put("live_status", r7);
        r1.put("exit_source", r6);
        r1.putAll(getCommonParams());
        Unit r8 = Unit.INSTANCE;
        r0.h("mp_anchor_exit_bind_push_show", r1, new Object[]{Room.class});
        return;
    L5:
        r7 = "before_live";
        goto L6
    }

    public final void reportGiveUpRemainder(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "appId");
        g r0 = u.l();
        Map<String, String> r1 = getCommonParams();
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r2 = "in_live";
    L6:
        r1.put("live_status", r2);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r3 = AnchorMiniAppDataContext.a.a();
        String r4 = null;
        if (r3 == null) goto L11;
        n<ShelfInfo> r7 = r3.m618getShelfInfo();
        if (r7 == null) goto L11;
        ShelfInfo r8 = (ShelfInfo) r7.getValue();
    L12:
        if (r8 != null) goto L14;
        String r9 = "add_new";
    L27:
        r1.put("add_type", r9);
        r1.put("page_path", String.valueOf(r6));
        Unit r10 = Unit.INSTANCE;
        r0.sendLog("livesdk_small_program_giveup_reminder", r1, new Object[]{Room.class});
        return;
    L14:
        AnchorMiniAppDataContext r11 = AnchorMiniAppDataContext.a.a();
        if (r11 == null) goto L24;
        n<ShelfInfo> r12 = r11.m618getShelfInfo();
        if (r12 == null) goto L24;
        ShelfInfo r13 = (ShelfInfo) r12.getValue();
        if (r13 == null) goto L24;
        ShelfMicroAppInfo r14 = r13.appInfo;
        if (r14 == null) goto L24;
        r4 = r14.appId;
    L24:
        if (Intrinsics.areEqual(r5, r4) == false) goto L26;
        r9 = "change_page";
        goto L27
    L26:
        r9 = "change_mp";
    L11:
        r8 = null;
        goto L12
    L5:
        r2 = "before_live";
        goto L6
    }

    public final void reportMpClick(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "mpId");
        Intrinsics.checkNotNullParameter(r5, "enterPosition");
        u.l().h("mp_click", getMpShowOrClickCommonParams(r4, r5), new Object[]{Room.class});
    }

    public final void reportMpShow(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "mpId");
        Intrinsics.checkNotNullParameter(r5, "enterPosition");
        u.l().h("mp_show", getMpShowOrClickCommonParams(r4, r5), new Object[]{Room.class});
    }

    public final void reportPageShelfBubblePush(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "bubbleType");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r7 = "in_live";
    L6:
        r1.put("live_status", r7);
        r1.put("bubble_type", r6);
        r1.putAll(getCommonParams());
        Unit r8 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_bubble_push", r1, new Object[]{Room.class});
        return;
    L5:
        r7 = "before_live";
        goto L6
    }

    public final void reportPageShelfTitleChangeResult(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r7 = "in_live";
    L6:
        r1.put("live_status", r7);
        if (r6 != 1) goto L9;
        String r8 = "pass";
    L13:
        r1.put("result", r8);
        r1.putAll(getCommonParams());
        Unit r9 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_title_change_result", r1, new Object[]{Room.class});
        return;
    L9:
        if (r6 == 2) goto L11;
        r8 = "";
        goto L13
    L11:
        r8 = "reject";
        goto L13
    L5:
        r7 = "before_live";
        goto L6
    }

    public final void reportShelfSettingPageStayDuration(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r7 = "in_live";
    L6:
        r1.put("live_status", r7);
        r1.put("duration", String.valueOf(r6));
        r1.putAll(getCommonParams());
        Unit r8 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_setting_page_stay_duration", r1, new Object[]{Room.class});
        return;
    L5:
        r7 = "before_live";
        goto L6
    }

    public final void reportAnchorShelfDisplayDialogCardShow(String r12, String r13, ShelfCardInfo r14) {
        Intrinsics.checkNotNullParameter(r12, "mpId");
        Intrinsics.checkNotNullParameter(r13, "clickSource");
        Intrinsics.checkNotNullParameter(r14, "cardInfo");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r12);
        r1.put("click_source", r13);
        if (r14.v0() == false) goto L5;
        String r15 = "1";
    L6:
        r1.put("if_product", r15);
        r1.put("card_page_id", String.valueOf(r14.getCardId()));
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r16 = AnchorMiniAppDataContext.a.a();
        if (r16 == null) goto L19;
        n<el> r17 = r16.getShelfTradeData();
        if (r17 == null) goto L19;
        el r18 = (el) r17.getValue();
        if (r18 == null) goto L19;
        Map r19 = r18.a();
        if (r19 == null) goto L19;
        bl r110 = (bl) r19.get(Long.valueOf(r14.getCardId()));
        if (r110 == null) goto L19;
        List r111 = r110.a();
        if (r111 == null) goto L19;
        r1.put("data_list", CollectionsKt.joinToString$default(r111, ",", null, null, 0, null, AnchorMiniAppAppLogContextService$reportAnchorShelfDisplayDialogCardShow$1$1$1.INSTANCE, 30, null));
    L19:
        Unit r112 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_card_show", r1, new Object[]{Room.class});
        return;
    L5:
        r15 = "0";
        goto L6
    }

    public final void reportAnchorShelfDisplayDialogShowDuration(String r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "clickSource");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        r1.put("click_source", r6);
        r1.put("duration", String.valueOf(r7));
        Unit r8 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_half_page_stay_time", r1, new Object[]{Room.class});
    }

    public final void reportExitBindPushClick(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "exitSource");
        Intrinsics.checkNotNullParameter(r7, "clickPosition");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r8 = "in_live";
    L6:
        r1.put("live_status", r8);
        r1.put("exit_source", r6);
        r1.put("click_position", r7);
        r1.putAll(getCommonParams());
        Unit r9 = Unit.INSTANCE;
        r0.h("mp_anchor_exit_bind_push_icon_click", r1, new Object[]{Room.class});
        return;
    L5:
        r8 = "before_live";
        goto L6
    }

    public final void reportAddShelfPageSuccess(String r5, boolean r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "enterPosition");
        Intrinsics.checkNotNullParameter(r7, "mpId");
        Intrinsics.checkNotNullParameter(r8, "bindSource");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r7);
        r1.put("mp_position", r5);
        if (r6 == false) goto L5;
        String r9 = "before_live";
    L6:
        r1.put("adding_page_live_status", r9);
        r1.put("bind_source", r8);
        r1.putAll(getCommonParams());
        Unit r10 = Unit.INSTANCE;
        r0.h("mp_anchor_add_shelf_page_success", r1, new Object[]{Room.class});
        return;
    L5:
        r9 = "in_live";
        goto L6
    }

    public final void reportAnchorExitBindSuccess(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "mpId");
        Intrinsics.checkNotNullParameter(r9, "enterPosition");
        Intrinsics.checkNotNullParameter(r10, "exitSource");
        Intrinsics.checkNotNullParameter(r11, "bindSource");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r8);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r12 = AnchorMiniAppDataContext.a.a();
        if (r12 == null) goto L11;
        n<ShelfInfo> r13 = r12.m618getShelfInfo();
        if (r13 == null) goto L11;
        ShelfInfo r14 = (ShelfInfo) r13.getValue();
        if (r14 == null) goto L11;
        if (r14.isAutoMount != true) goto L11;
        r9 = "auto";
    L11:
        r1.put("mp_position", r9);
        int r15 = d.a;
        AnchorMiniAppDataContext r16 = AnchorMiniAppDataContext.a.a();
        if (r16 == null) goto L20;
        n<ShelfInfo> r17 = r16.m618getShelfInfo();
        if (r17 == null) goto L20;
        ShelfInfo r18 = (ShelfInfo) r17.getValue();
        if (r18 == null) goto L20;
        ShelfMicroAppInfo r19 = r18.appInfo;
        if (r19 == null) goto L20;
        int r20 = r19.anchorLiveStatus;
    L21:
        if (r20 == 0) goto L25;
        if (r20 == 1) goto L24;
        String r21 = "";
    L26:
        r1.put("adding_page_live_status", r21);
        r1.put("bind_source", r11);
        r1.put("exit_source", r10);
        AnchorMiniAppDataContext r22 = AnchorMiniAppDataContext.a.a();
        if (r22 == null) goto L35;
        n<ShelfInfo> r23 = r22.m618getShelfInfo();
        if (r23 == null) goto L35;
        ShelfInfo r24 = (ShelfInfo) r23.getValue();
        if (r24 == null) goto L35;
        List<ShelfCardInfo> r25 = r24.cardInfoList;
        if (r25 == null) goto L35;
        int r26 = r25.size();
    L36:
        r1.put("shelf_card_num", String.valueOf(r26));
        AnchorMiniAppDataContext r27 = AnchorMiniAppDataContext.a.a();
        if (r27 == null) goto L64;
        n<ShelfInfo> r28 = r27.m618getShelfInfo();
        if (r28 == null) goto L64;
        ShelfInfo r29 = (ShelfInfo) r28.getValue();
        if (r29 == null) goto L64;
        List<ShelfCardInfo> r30 = r29.cardInfoList;
        if (r30 == null) goto L64;
        ArrayList r110 = new ArrayList();
        Iterator<T> r31 = r30.iterator();
    L46:
        if (r31.hasNext() == false) goto L63;
        Object r3 = r31.next();
        ShelfCardInfo r4 = (ShelfCardInfo) r3;
        List<ImageModel> r5 = r4.L();
        if (r5 == null) goto L54;
        ImageModel r6 = (ImageModel) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L54;
        List r7 = r6.getUrls();
        if (r7 == null) goto L54;
        String r32 = (String) CollectionsKt.firstOrNull(r7);
    L56:
        if (Intrinsics.areEqual(r32, r4.F()) == true) goto L58;
    L60:
        boolean r33 = false;
    L61:
        if (r33 == false) goto L46;
        r110.add(r3);
        goto L46
    L58:
        if (r4.w0() == true) goto L60;
        r33 = true;
    L54:
        r32 = null;
        goto L56
    L63:
        int r34 = r110.size();
    L65:
        r1.put("base_pic_shelf_card_num", String.valueOf(r34));
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r35 = AnchorMiniAppDataContext.a.a();
        if (r35 == null) goto L91;
        n<ShelfInfo> r36 = r35.m618getShelfInfo();
        if (r36 == null) goto L91;
        ShelfInfo r37 = (ShelfInfo) r36.getValue();
        if (r37 == null) goto L91;
        List<ShelfCardInfo> r38 = r37.cardInfoList;
        if (r38 == null) goto L91;
        ArrayList r111 = new ArrayList();
        Iterator<T> r39 = r38.iterator();
    L75:
        if (r39.hasNext() == false) goto L90;
        Object r40 = r39.next();
        ShelfCardInfo r41 = (ShelfCardInfo) r40;
        String r42 = r41.N();
        if (r42 != null) goto L79;
    L82:
        boolean r43 = true;
    L83:
        if (r43 == true) goto L85;
    L87:
        boolean r44 = false;
    L88:
        if (r44 == false) goto L75;
        r111.add(r40);
        goto L75
    L85:
        if (r41.y0() == true) goto L87;
        r44 = true;
        goto L88
    L79:
        if (StringsKt.isBlank(r42) == true) goto L82;
        r43 = false;
        goto L83
    L90:
        int r45 = r111.size();
    L92:
        r1.put("base_title_shelf_card_num", String.valueOf(r45));
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r46 = AnchorMiniAppDataContext.a.a();
        if (r46 == null) goto L120;
        n<ShelfInfo> r47 = r46.m618getShelfInfo();
        if (r47 == null) goto L120;
        ShelfInfo r48 = (ShelfInfo) r47.getValue();
        if (r48 == null) goto L120;
        List<ShelfCardInfo> r49 = r48.cardInfoList;
        if (r49 == null) goto L120;
        ArrayList r112 = new ArrayList();
        Iterator<T> r50 = r49.iterator();
    L102:
        if (r50.hasNext() == false) goto L119;
        Object r51 = r50.next();
        ShelfCardInfo r52 = (ShelfCardInfo) r51;
        List<ImageModel> r53 = r52.L();
        if (r53 == null) goto L110;
        ImageModel r54 = (ImageModel) CollectionsKt.firstOrNull(r53);
        if (r54 == null) goto L110;
        List r55 = r54.getUrls();
        if (r55 == null) goto L110;
        String r56 = (String) CollectionsKt.firstOrNull(r55);
    L112:
        if (Intrinsics.areEqual(r56, r52.F()) == true) goto L114;
    L116:
        boolean r57 = false;
    L117:
        if (r57 == false) goto L102;
        r112.add(r51);
        goto L102
    L114:
        if (r52.w0() == false) goto L116;
        r57 = true;
    L110:
        r56 = null;
        goto L112
    L119:
        int r58 = r112.size();
    L121:
        r1.put("buffer_pic_shelf_card_num", String.valueOf(r58));
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r59 = AnchorMiniAppDataContext.a.a();
        if (r59 == null) goto L147;
        n<ShelfInfo> r60 = r59.m618getShelfInfo();
        if (r60 == null) goto L147;
        ShelfInfo r61 = (ShelfInfo) r60.getValue();
        if (r61 == null) goto L147;
        List<ShelfCardInfo> r62 = r61.cardInfoList;
        if (r62 == null) goto L147;
        ArrayList r113 = new ArrayList();
        Iterator<T> r63 = r62.iterator();
    L131:
        if (r63.hasNext() == false) goto L146;
        Object r114 = r63.next();
        ShelfCardInfo r65 = (ShelfCardInfo) r114;
        String r66 = r65.N();
        if (r66 != null) goto L135;
    L138:
        boolean r67 = true;
    L139:
        if (r67 == true) goto L141;
    L143:
        boolean r68 = false;
    L144:
        if (r68 == false) goto L131;
        r113.add(r114);
        goto L131
    L141:
        if (r65.y0() == false) goto L143;
        r68 = true;
        goto L144
    L135:
        if (StringsKt.isBlank(r66) == true) goto L138;
        r67 = false;
        goto L139
    L146:
        int r69 = r113.size();
    L148:
        r1.put("buffer_title_shelf_card_num", String.valueOf(r69));
        if (((MemoryContextService) getOpenPlatformContext().getService(MemoryContextService.class)).a.c != 1) goto L151;
        boolean r70 = true;
    L152:
        if (r70 == false) goto L154;
        String r71 = "1";
    L155:
        r1.put("if_real_time_data_show", r71);
        r1.putAll(getCommonParams());
        Unit r72 = Unit.INSTANCE;
        r0.h("mp_anchor_exit_bind_success", r1, new Object[]{Room.class});
        return;
    L154:
        r71 = "0";
        goto L155
    L151:
        r70 = false;
    L147:
        r69 = 0;
    L120:
        r58 = 0;
    L91:
        r45 = 0;
    L64:
        r34 = 0;
    L35:
        r26 = 0;
        goto L36
    L24:
        r21 = "in_live";
        goto L26
    L25:
        r21 = "before_live";
    L20:
        r20 = -1;
        goto L21
    }

    public final void reportAnchorShelfDisplayDialogShow(String r12, String r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "mpId");
        Intrinsics.checkNotNullParameter(r13, "clickSource");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r12);
        r1.put("click_source", r13);
        r1.put("shelf_card_num", String.valueOf(r14));
        MiniAppDataContext.Companion.getClass();
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(MiniAppDataContext.a.b()) == false) goto L5;
        String r16 = "1";
    L6:
        r1.put("if_coexist", r16);
        if (r15 == false) goto L11;
        if (r14 <= 1) goto L10;
        String r17 = "multi_with_product";
    L12:
        r1.put("top_content_type", r17);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r18 = AnchorMiniAppDataContext.a.a();
        if (r18 == null) goto L21;
        n<el> r19 = r18.getShelfTradeData();
        if (r19 == null) goto L21;
        el r110 = (el) r19.getValue();
        if (r110 == null) goto L21;
        List r111 = r110.b();
        if (r111 == null) goto L21;
        String r112 = (String) r1.put("top_content_list", CollectionsKt.joinToString$default(r111, ",", null, null, 0, null, AnchorMiniAppAppLogContextService$reportAnchorShelfDisplayDialogShow$1$1$1.INSTANCE, 30, null));
    L21:
        r1.putAll(getCoexistParams());
        r1.put("has_sell_point_card_num", String.valueOf(com.bytedance.android.live.openplatform.api.model.shelf.g.b(MiniAppDataContext.a.b())));
        r1.putAll(getCommonParams());
        Unit r113 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_half_page_show", r1, new Object[]{Room.class});
        return;
    L10:
        r17 = "single_with_product";
        goto L12
    L11:
        r17 = "no_product";
        goto L12
    L5:
        r16 = "0";
        goto L6
    }

    public final void reportEditSellingPointResult(String r5, boolean r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r8, "rejectReason");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r9 = "in_live";
    L6:
        r1.put("live_status", r9);
        r1.put("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        if (r6 == false) goto L9;
        String r10 = "pass";
    L10:
        r1.put("result", r10);
        r1.put("sell_point_num", String.valueOf(r7));
        r1.put("reject_reason", r8);
        Unit r11 = Unit.INSTANCE;
        r0.h("mp_anchor_sell_point_edit_result", r1, new Object[0]);
        return;
    L9:
        r10 = "reject";
        goto L10
    L5:
        r9 = "before_live";
        goto L6
    }

    public final void reportPageShelfSubmitAudit(String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "isChangePic");
        Intrinsics.checkNotNullParameter(r6, "isChangeTitle");
        Intrinsics.checkNotNullParameter(r8, "mpId");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r8);
        r1.put("bind_source", "app");
        r1.put("if_change_pic", r5);
        r1.put("if_change_title", r6);
        insertCreateInfo(r7, r1);
        Unit r9 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_submit_audit", r1, new Object[]{Room.class});
    }

    public final void reportShelfSettingPageOperate(String r5, String r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r6, "operatePosition");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r9 = "in_live";
    L6:
        r1.put("live_status", r9);
        r1.put("adding_page_num", String.valueOf(r7));
        r1.put("operate_position", r6);
        if (r8 == (-1)) goto L9;
        r1.put("delete_page_num", String.valueOf(r8));
    L9:
        r1.putAll(getCommonParams());
        Unit r10 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_setting_page_operate", r1, new Object[0]);
        return;
    L5:
        r9 = "before_live";
        goto L6
    }

    public final void reportShelfSettingPageShow(String r5, int r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "mpId");
        Intrinsics.checkNotNullParameter(r7, "source");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r5);
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r9 = "in_live";
    L6:
        r1.put("live_status", r9);
        r1.put("adding_page_num", String.valueOf(r6));
        r1.put("click_source", r7);
        r1.put("has_sell_point_num", String.valueOf(r8));
        r1.putAll(getCommonParams());
        Unit r10 = Unit.INSTANCE;
        r0.h("mp_anchor_page_shelf_setting_page_show", r1, new Object[0]);
        return;
    L5:
        r9 = "before_live";
        goto L6
    }

    public final void reportSmallProgramAdd(String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "appId");
        Intrinsics.checkNotNullParameter(r7, "startPageUrl");
        Intrinsics.checkNotNullParameter(r8, "homePath");
        Intrinsics.checkNotNullParameter(r9, "enterPosition");
        String r0 = UriProtector.parse(r7).getPath();
        g r1 = u.l();
        HashMap r2 = new HashMap();
        if (getOpenPlatformContext().isInLive() == false) goto L5;
        String r3 = "in_live";
    L6:
        r2.put("live_status", r3);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        String r5 = null;
        if (r4 == null) goto L11;
        n<ShelfInfo> r10 = r4.m618getShelfInfo();
        if (r10 == null) goto L11;
        ShelfInfo r11 = (ShelfInfo) r10.getValue();
    L12:
        if (r11 != null) goto L14;
        String r12 = "add_new";
    L27:
        r2.put("add_type", r12);
        r2.put("page_path", r7);
        r2.put("mp_position", r9);
        AnchorMiniAppDataContext r13 = AnchorMiniAppDataContext.a.a();
        String r14 = "1";
        if (r13 == null) goto L36;
        n<ShelfInfo> r15 = r13.m618getShelfInfo();
        if (r15 == null) goto L36;
        ShelfInfo r16 = (ShelfInfo) r15.getValue();
        if (r16 == null) goto L36;
        if (r16.isAutoMount != true) goto L36;
        Object r17 = "1";
    L37:
        r2.put("is_auto", r17);
        if (r8.length() <= 0) goto L40;
        boolean r18 = true;
    L41:
        if (r18 == true) goto L43;
    L45:
        r14 = "0";
    L46:
        r2.put("if_change_home_page", r14);
        r2.putAll(getCommonParams());
        Unit r19 = Unit.INSTANCE;
        r1.sendLog("livesdk_live_small_program_add", r2, new Object[]{Room.class});
        return;
    L43:
        if (Intrinsics.areEqual(r8, r0) == false) goto L45;
    L40:
        r18 = false;
    L36:
        r17 = "0";
        goto L37
    L14:
        AnchorMiniAppDataContext r20 = AnchorMiniAppDataContext.a.a();
        if (r20 == null) goto L24;
        n<ShelfInfo> r21 = r20.m618getShelfInfo();
        if (r21 == null) goto L24;
        ShelfInfo r22 = (ShelfInfo) r21.getValue();
        if (r22 == null) goto L24;
        ShelfMicroAppInfo r23 = r22.appInfo;
        if (r23 == null) goto L24;
        r5 = r23.appId;
    L24:
        if (Intrinsics.areEqual(r6, r5) == false) goto L26;
        r12 = "change_page";
        goto L27
    L26:
        r12 = "change_mp";
    L11:
        r11 = null;
        goto L12
    L5:
        r3 = "before_live";
        goto L6
    }

    public static /* synthetic */ void reportShelfSettingPageOperate$default(AnchorMiniAppAppLogContextService r0, String r1, String r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = -1;
    L5:
        r0.reportShelfSettingPageOperate(r1, r2, r3, r4);
    }

    public final void reportCoexistStatusChangedStart(boolean r5, String r6, String r7, boolean r8, String r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r6, "mpId");
        Intrinsics.checkNotNullParameter(r7, "enterPosition");
        Intrinsics.checkNotNullParameter(r9, "bindSource");
        Intrinsics.checkNotNullParameter(r10, "endSource");
        g r0 = u.l();
        if (r5 == false) goto L5;
        String r12 = "mp_anchor_coexist_bind_start";
    L6:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("_param_for_special", "micro_app");
        r1.put("mp_id", r6);
        r1.put("mp_position", r7);
        if (r8 == false) goto L9;
        String r13 = "before_live";
    L10:
        r1.put("adding_page_live_status", r13);
        r1.put("bind_source", r9);
        r1.put("end_source", r10);
        r1.putAll(getCoexistParams());
        r1.put("shelf_card_num", String.valueOf(r11));
        Unit r14 = Unit.INSTANCE;
        r0.h(r12, r1, new Object[]{Room.class});
        return;
    L9:
        r13 = "in_live";
        goto L10
    L5:
        r12 = "mp_anchor_coexist_bind_end";
        goto L6
    }
}
