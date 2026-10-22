package com.bytedance.android.live;

import am2.a0;
import am2.b0;
import am2.x;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import b30.n;
import com.bytedance.android.live.api.MatchShareApi;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.helper.LiveShareHelper;
import com.bytedance.android.live.landscape.LandscapeShareActivity;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.portrait.PortraitShareActivity;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper;
import com.bytedance.android.livehostapi.business.depend.share.LiveQrCodeConfig;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SharePublishParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareSubScene;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.chatroom.f0;
import com.bytedance.android.livesdk.chatroom.ssposter.model.TicketGenerateResponse;
import com.bytedance.android.livesdk.chatroom.ssposter.model.TicketInfo;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.vs.model.SearchPanelParam;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionResponseDataSingle;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;
import ry.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bG\u0010HJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016Jp\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0018j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u0019H\u0016JF\u0010 \u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\fH\u0016J0\u0010%\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0016J0\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020\f2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0'2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fH\u0016J\u0012\u0010.\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0016J\u0012\u00105\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u00106\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020\bH\u0016J\u0018\u00109\u001a\u00020\b2\u0006\u00100\u001a\u00020/2\u0006\u00108\u001a\u00020/H\u0016J0\u0010;\u001a\u00020\b2&\u0010:\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0019H\u0016J\u001c\u0010=\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0<H\u0016J\u001c\u0010>\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0<H\u0016J\u001c\u0010?\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0<H\u0016J\u001c\u0010@\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0<H\u0016J6\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0018j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u00192\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020\u000fH\u0016J\b\u0010C\u001a\u00020\fH\u0016J\b\u0010D\u001a\u00020\fH\u0016J\u0014\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f0EH\u0016¨\u0006K"}, d2 = {"Lcom/bytedance/android/live/MatchShareService;", "Lcom/bytedance/android/live/room/api/IMatchShareService;", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/bytedance/android/livesdk/vs/model/MatchShareParam;", "shareParam", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "collectionItem", "", "showShareDialog", "Landroid/content/Context;", "context", "", "isLandscape", "launchMatchShare", "", "enterFrom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", NewBroadcastMonitor.PAGE.ROOM, "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "collectionId", "episodeId", "contentType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logParam", "launchMatchShareByCollectionId", "", "index", "preloadCollectionJson", "roomId", "launchMatchShareByRoomId", "Landroid/app/Activity;", "showPushPanel", "ticketGenerate", "extraParams", "launchMatchTicketShare", "addRoomInfo", "", "sharePosterList", "logExtra", "logReflowExtra", "launchVsMultiPosterShare", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "logQuickShotBtnShow", "", "clickTime", "logQuickShotBtnClick", "logQuickShotShareDialogClick", "logQuickShotShareDialogShow", "logQuickRecordBtnClick", "logQuickRecordBtnShow", "logQuickRecordFinish", "logQuickRecordShareDialogClick", "recordDuration", "logQuickRecordShareDialogShow", "params", "logMatchSharePublishPageShow", "", "logQuickShotFinish", "logQuickRecordTaskFinish", "logQuickRecordTaskFinish201", "logQuickRecordAudioOpen", "enterFromMerge", "generateShareLogParams", "allowQuickRecordShare", "allowQuickShotShare", "Lkotlin/Pair;", "openPushGuideDialogForSaas", "<init>", "()V", "Companion", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MatchShareService implements IMatchShareService {
    public static final a Companion = null;
    public static final String TICKET_SHARE = "ticket_share";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MatchShareService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Room d;
        public final /* synthetic */ Episode e;
        public final /* synthetic */ String f;
        public final /* synthetic */ HashMap g;
        public final /* synthetic */ Context h;
        public final /* synthetic */ boolean i;

        public b(MatchShareService r1, String r2, String r3, Room r4, Episode r5, String r6, HashMap r7, Context r8, boolean r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }

        public final void accept(Object r21) {
            Response r1 = (Response) r21;
            if (r1 == null) goto L10;
            CollectionResponseDataSingle r2 = (CollectionResponseDataSingle) ((BaseResponse) r1).data;
            if (r2 == null) goto L11;
            CollectionItem r3 = r2.getCollectionItem();
            if (r3 == null) goto L12;
            r3.setCollectionId(this.b);
            MatchShareParam r4 = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
            r4.a = this.c;
            r4.b = this.b;
            r4.d = CollectionsKt.mutableListOf(new CollectionItem[]{r3});
            r4.f = this.d;
            r4.g = this.e;
            String r5 = this.f;
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r4.m = r5;
            HashMap r6 = this.g;
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r4.n = r6;
            this.a.launchMatchShare(this.h, this.i, r4);
            return;
        L12:
            return;
        L11:
            return;
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
            f2.c("分享失败", 0);
            ((Throwable) r3).printStackTrace();
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/MatchShareService$d", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d extends TypeToken<List<? extends CollectionItem>> {
        public d() {
        }
    }

    static {
        Companion = new a();
    }

    public MatchShareService() {
    }

    public boolean allowQuickRecordShare() {
        int r0 = LiveShareHelper.a;
        return !PadConfigUtils.c();
    }

    public boolean allowQuickShotShare() {
        int r0 = LiveShareHelper.a;
        return !PadConfigUtils.c();
    }

    public void logQuickRecordFinish() {
        int r0 = jl0.a.a;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "other";
        r2.b = "live_detail";
        r1.h("livesdk_screencap_finish", null, new Object[]{r2, Room.class});
    }

    public void logQuickRecordShareDialogClick() {
        int r0 = jl0.a.a;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        Map r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_sjb", GamePromoteDataContext.GAME_TYPE_MOBILE)});
        x r5 = new x();
        r5.a = GamePromoteDataContext.LIVE;
        r5.e = "click";
        r5.b = "live_detail";
        r1.h("livesdk_screencap_floating_window_click", r2, new Object[]{r5, Room.class});
    }

    public void logQuickShotShareDialogClick() {
        int r0 = jl0.a.a;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "click";
        r2.b = "live_detail";
        r1.h("livesdk_screenshot_floating_window_click", null, new Object[]{r2, Room.class});
    }

    public Pair<Integer, String> openPushGuideDialogForSaas() {
        IHostService r0 = TTLiveSDK.hostService();
        Long r1 = null;
        if (r0 == null) goto L5;
        o r2 = r0.methodChannel();
    L7:
        if (r2 != null) goto L9;
    L37:
        ALogger.w("MatchShareService", "host not support");
        return TuplesKt.to(0, "host not support");
    L9:
        if (r2.m1("has_push_permission") == false) goto L37;
        if (r2.m1("show_push_permission_guide") == false) goto L37;
        StringBuilder r3 = new StringBuilder("last_push_permission_guide_");
        IHostService r4 = TTLiveSDK.hostService();
        if (r4 == null) goto L18;
        IHostUser r5 = r4.user();
        if (r5 == null) goto L18;
        r1 = Long.valueOf(r5.hostUserId());
    L18:
        r3.append(r1);
        String r6 = r3.toString();
        if (Intrinsics.areEqual(r2.Q3(), Boolean.FALSE) == false) goto L34;
        Integer r7 = (Integer) LiveSettingKeys.LIVE_PUSH_PERMISSION_GUIDE_FREQ_SECONDS.getValue();
        long r8 = System.currentTimeMillis();
        com.bytedance.android.livesdk.sharedpref.e r9 = new com.bytedance.android.livesdk.sharedpref.e(r6, 0L);
        if (r7.intValue() >= 0) goto L25;
        return TuplesKt.to(0, "feature offline");
    L25:
        if (r7.intValue() == 0) goto L31;
        if (r8 > (((long) r7.intValue()) + ((Number) r9.getValue()).longValue())) goto L31;
        String r11 = "throttled";
    L36:
        return TuplesKt.to(1, r11);
    L31:
        if (Intrinsics.areEqual(Boolean.TRUE, r2.Q3()) == false) goto L33;
        com.bytedance.android.livesdk.sharedpref.f.d(r9, Long.valueOf(r8));
        r11 = "showing";
        goto L36
    L33:
        r11 = "host ignores";
        goto L36
    L34:
        r11 = "already";
        goto L36
    L5:
        r2 = null;
        goto L7
    }

    public void logMatchSharePublishPageShow(HashMap<String, String> r5) {
        int r0 = jl0.a.a;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "show";
        r2.b = "live_detail";
        r1.h("livesdk_content_publish_page_show", r5, new Object[]{r2, Room.class});
    }

    public void logQuickRecordAudioOpen(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        int r1 = jl0.a.a;
        Intrinsics.checkNotNullParameter(r5, "params");
        com.bytedance.android.livesdk.log.g r0 = u.l();
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "other";
        r2.b = "live_detail";
        r0.h("livesdk_screenrecord_audio_open", r5, new Object[]{r2, Room.class});
    }

    public void logQuickRecordBtnClick(long r6) {
        int r0 = jl0.a.a;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_sjb", GamePromoteDataContext.GAME_TYPE_MOBILE), TuplesKt.to("click_time", String.valueOf(r6))});
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "click";
        r2.b = "live_detail";
        r1.h("livesdk_screencap_icon_click", r7, new Object[]{r2, Room.class});
    }

    public void logQuickRecordBtnShow(DataCenter r4) {
        int r0 = jl0.a.a;
        if (r4 == null) goto L6;
        new f0(r4).a("livesdk_screencap_icon_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_sjb", GamePromoteDataContext.GAME_TYPE_MOBILE)}));
        return;
    }

    public void logQuickRecordTaskFinish(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        int r1 = jl0.a.a;
        Intrinsics.checkNotNullParameter(r5, "params");
        com.bytedance.android.livesdk.log.g r0 = u.l();
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "other";
        r2.b = "live_detail";
        r0.h("livesdk_screenrecord_finish", r5, new Object[]{r2, Room.class});
    }

    public void logQuickRecordTaskFinish201(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        int r1 = jl0.a.a;
        Intrinsics.checkNotNullParameter(r5, "params");
        com.bytedance.android.livesdk.log.g r0 = u.l();
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "other";
        r2.b = "live_detail";
        r0.h("livesdk_screenrecord_finish_201", r5, new Object[]{r2, Room.class});
    }

    public void logQuickShotBtnClick(long r6) {
        int r0 = jl0.a.a;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(r6))});
        x r3 = new x();
        r3.a = GamePromoteDataContext.LIVE;
        r3.e = "click";
        r3.b = "live_detail";
        r1.h("livesdk_screenshot_icon_click", r7, new Object[]{r3, Room.class});
    }

    public void logQuickShotBtnShow(DataCenter r3) {
        int r0 = jl0.a.a;
        if (r3 == null) goto L6;
        new f0(r3).a("livesdk_screenshot_icon_show", null);
        return;
    }

    public void logQuickShotFinish(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        int r1 = jl0.a.a;
        Intrinsics.checkNotNullParameter(r5, "params");
        com.bytedance.android.livesdk.log.g r0 = u.l();
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "other";
        r2.b = "live_detail";
        r0.h("livesdk_screenshot_finish", r5, new Object[]{r2, Room.class});
    }

    public void logQuickShotShareDialogShow(long r8) {
        int r0 = jl0.a.a;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(r8)), TuplesKt.to("start_duration", String.valueOf(System.currentTimeMillis() - r8))});
        x r2 = new x();
        r2.a = GamePromoteDataContext.LIVE;
        r2.e = "show";
        r2.b = "live_detail";
        r1.h("livesdk_screenshot_floating_window_show", r9, new Object[]{r2, Room.class});
    }

    public HashMap<String, String> generateShareLogParams(DataCenter r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "enterFromMerge");
        int r1 = jl0.a.a;
        Intrinsics.checkNotNullParameter(r6, "enterFromMerge");
        HashMap<String, String> r0 = new HashMap();
        Room r2 = null;
        if (r5 == null) goto L5;
        r2 = (Room) r5.get("data_room", null);
    L5:
        r0.put("enter_from_merge", r6);
        String r7 = "";
        if (r2 == null) goto L9;
        String r3 = r2.getOwnerUserIdString();
        if (r3 == null) goto L9;
    L10:
        r0.put("anchor_id", r3);
        if (r2 == null) goto L14;
        String r4 = r2.getIdStr();
        if (r4 == null) goto L14;
    L15:
        r0.put("room_id", r4);
        IHostService r8 = TTLiveSDK.hostService();
        if (r8 == null) goto L22;
        IHostUser r9 = r8.user();
        if (r9 == null) goto L22;
        String r11 = r9.getCurUserId();
        if (r11 == null) goto L22;
        r7 = r11;
    L22:
        r0.put("user_id", r7);
        if (r2 == null) goto L25;
        String r12 = GamePromoteDataContext.LIVE;
    L26:
        r0.put("room_type", r12);
        if (r2 == null) goto L32;
        r0.putAll(u.l().c(Room.class).getMap());
        Map<? extends String, ? extends String> r13 = u.l().c(x.class).getMap();
        if (r13 == null) goto L31;
        r0.putAll(r13);
    L31:
        int r14 = ju2.f.M;
        ju2.f r15 = ju2.f.a.a(r2);
        r15.n = z.m(r5, true) ? 1 : 0;
        r0.putAll(r15.b());
    L48:
        return r0;
    L32:
        if (r5 == null) goto L48;
        nm1.h r16 = pm1.f.f();
        if (r16 == null) goto L39;
        Map r17 = r16.d(r5, a0.class);
        if (r17 == null) goto L39;
        Map<? extends String, ? extends String> r18 = MapsKt.toMutableMap(r17);
        if (r18 == null) goto L39;
    L40:
        r0.putAll(r18);
        nm1.h r19 = pm1.f.f();
        if (r19 == null) goto L46;
        Map r21 = r19.d(r5, b0.class);
        if (r21 == null) goto L46;
        Map<? extends String, ? extends String> r22 = MapsKt.toMutableMap(r21);
        if (r22 == null) goto L46;
    L47:
        r0.putAll(r22);
    L46:
        r22 = new LinkedHashMap();
    L39:
        r18 = new LinkedHashMap();
        goto L40
    L25:
        r12 = "replay";
    L14:
        r4 = "";
    L9:
        r3 = "";
        goto L10
    }

    public void logQuickRecordShareDialogShow(long r8, long r11) {
        int r0 = jl0.a.a;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_sjb", GamePromoteDataContext.GAME_TYPE_MOBILE), TuplesKt.to("click_time", String.valueOf(r8)), TuplesKt.to("record_duration", String.valueOf(r11)), TuplesKt.to("show_share_dialog_duration", String.valueOf(System.currentTimeMillis() - r8))});
        x r12 = new x();
        r12.a = GamePromoteDataContext.LIVE;
        r12.e = "show";
        r12.b = "live_detail";
        r1.h("livesdk_screencap_floating_window_show", r9, new Object[]{r12, Room.class});
    }

    public void launchMatchShare(Context r4, boolean r5, MatchShareParam r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "shareParam");
        int r2 = com.bytedance.android.live.c.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "shareParam");
        if (r5 == false) goto L5;
        Class<LandscapeShareActivity> r1 = LandscapeShareActivity.class;
    L6:
        Intent r0 = new Intent(r4, r1);
        f.a = r6;
        Context r3 = null;
        if (r5 == false) goto L16;
        if ((r4 instanceof Activity) == false) goto L12;
        r3 = r4;
    L12:
        Activity r7 = (Activity) r3;
        if (r7 == null) goto L22;
        r7.overridePendingTransition(2130772777, 0);
    L22:
        r4.startActivity(r0);
        return;
    L16:
        if ((r4 instanceof Activity) == false) goto L19;
        r3 = r4;
    L19:
        Activity r8 = (Activity) r3;
        if (r8 == null) goto L22;
        r8.overridePendingTransition(2130772776, 0);
        goto L22
    L5:
        r1 = PortraitShareActivity.class;
        goto L6
    }

    public void showShareDialog(FragmentActivity r2, MatchShareParam r3, CollectionItem r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "shareParam");
        Intrinsics.checkNotNullParameter(r4, "collectionItem");
        LiveShareHelper.b(r2, r3, r4, new HashMap());
    }

    public void launchVsMultiPosterShare(boolean r3, List<String> r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "sharePosterList");
        Intrinsics.checkNotNullParameter(r5, "logExtra");
        Intrinsics.checkNotNullParameter(r6, "logReflowExtra");
        xs2.b.a().post(new n(r3, r4, r5, r6));
    }

    public void launchMatchTicketShare(Activity r32, boolean r33, String r34, String r35, String r36) {
        String r9 = "is_vs";
        String r15 = "";
        Intrinsics.checkNotNullParameter(r32, "activity");
        Intrinsics.checkNotNullParameter(r34, "enterFrom");
        Intrinsics.checkNotNullParameter(r35, "ticketGenerate");
        Intrinsics.checkNotNullParameter(r36, "extraParams");
        ILiveService r2 = TTLiveService.getLiveService();
        if (r2 == null) goto L5;
        ILiveQrCodeShareHelper r3 = r2.getQrCodeShareHelper(4);
    L6:
        if (r3 == null) goto L8;
        Object r14 = r3.setTicketJson(r35);
    L9:
        LiveQrCodeConfig r4 = new LiveQrCodeConfig();
        HashMap r5 = new HashMap();
        u.l().c(x.class).a(r5);
        boolean r6 = r14 instanceof TicketGenerateResponse;
        if (r6 == true) goto L12;
        Object r7 = null;
    L13:
        TicketGenerateResponse r8 = (TicketGenerateResponse) r7;
        if (r8 != null) goto L16;
        r9 = "is_vs";
    L55:
        if (k.n(IHostBusiness.class).isHotsoonR() == false) goto L60;
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L128;
        r0.showDefaultNotificationSettingDialog(r32, "after_live_reservation");
        return;
    L128:
        return;
    L60:
        r4.setPanelType(4);
        if ((r3 instanceof IQrCodeShareHelper) == true) goto L63;
        ILiveQrCodeShareHelper r11 = null;
    L64:
        IQrCodeShareHelper r12 = (IQrCodeShareHelper) r11;
        if (r12 == null) goto L67;
        r4.setQrCodeShareHelper(r12);
    L67:
        ALogger.d(TICKET_SHARE, "ticketGenerate: " + r35 + ", extraParams: " + r36);
        r5.put("token_form", "pic");
        r5.put("share_type", "pic");
        r5.put("content_type", "live_booking");
        r5.put("sjb_content_type", "live_booking");
        IUserService r1 = k.f(IUserService.class);
        if (r1 == null) goto L73;
        com.bytedance.android.livesdk.user.f r13 = r1.user();
        if (r13 == null) goto L73;
        String r16 = r13.n();
        if (r16 == null) goto L73;
    L74:
        r5.put("from_user_id", r16);
        JSONObject r17 = new JSONObject(r36);     // Catch: Throwable -> L77
        r5.put("booking_anchor_id", r17.optString("booking_anchor_id", ""));     // Catch: Throwable -> L77
        r5.put("enter_from_merge", r17.optString("enter_from_merge", ""));     // Catch: Throwable -> L77
        r5.put("enter_method", r17.optString("enter_method", ""));     // Catch: Throwable -> L77
        r5.put("vs_episode_sub_type", r17.optString("vs_episode_sub_type", ""));     // Catch: Throwable -> L77
        String r18 = r9;
        r5.put(r18, r17.optString(r18, GamePromoteDataContext.GAME_TYPE_MOBILE));     // Catch: Throwable -> L77
        r5.put("vs_season_id", r17.optString("vs_season_id", ""));     // Catch: Throwable -> L77
        r5.put("vs_episode_id", r17.optString("vs_episode_id", ""));     // Catch: Throwable -> L77
        r5.put("room_type", r17.optString("room_type", GamePromoteDataContext.LIVE));     // Catch: Throwable -> L77
        r5.put("room_id", r17.optString("room_id", ""));     // Catch: Throwable -> L77
        r5.put("author_id", r17.optString("author_id", ""));     // Catch: Throwable -> L77
        String r19 = (String) r5.put("card_order", r17.optString("card_order", ""));     // Catch: Throwable -> L77
        String r21 = "shareTicket";
    L79:
        ShareParams.Builder r110 = ShareParams.builder();
        ShareParams.Builder r22 = r110.setShareSubScene(ShareSubScene.LiveMatchTicket).setEnterFrom("live_booking").setLiveQrCodeConfig(r4).setActivityInfo(r5).setExtraParams(r5).setLogExtraParams(r5);
        SharePublishParam r23 = new SharePublishParam();
        JSONObject r24 = new JSONObject(r36);     // Catch: Throwable -> L82
        r23.setActivityVideoType(r24.optInt("activity_video_type"));     // Catch: Throwable -> L82
        r23.setPublishJumpTitle(r24.optString("jump_title"));     // Catch: Throwable -> L82
    L84:
        if (r3 == null) goto L87;
        String r25 = r3.getRelatedReviewContent();
        if (r25 == null) goto L87;
    L88:
        r23.setRelatedReviewContent(r25);
        if (r6 == true) goto L91;
        Object r26 = null;
    L92:
        TicketGenerateResponse r27 = (TicketGenerateResponse) r26;
        if (r27 == null) goto L98;
        TicketInfo r28 = r27.getTicketInfo();
        if (r28 == null) goto L98;
        String r29 = r28.getSchema();
        if (r29 == null) goto L98;
    L99:
        r23.setPublishJumpScheme(r29);
        if (r6 == true) goto L102;
        Object r31 = null;
    L103:
        TicketGenerateResponse r37 = (TicketGenerateResponse) r31;
        if (r37 == null) goto L110;
        List r38 = r37.getMusicIdStrList();
        if (r38 == null) goto L110;
        List r39 = r38;
        if ((!r39.isEmpty()) == false) goto L111;
        r15 = (String) CollectionsKt.random(r39, Random.Default);
    L111:
        r23.setMusicId(String.valueOf(r15));
        r23.setShowOutsitePushAuthPanel(r33);
        r23.setShareTicketExtraJson(r36);
        Unit r41 = Unit.INSTANCE;
        r22.setSharePublishParam(r23);
        if (r6 == false) goto L122;
        TicketGenerateResponse r111 = (TicketGenerateResponse) r14;
        TicketInfo r42 = r111.getTicketInfo();
        if (r42 == null) goto L116;
        String r43 = r42.getShareScene();
    L117:
        ShareParams.Builder r44 = r110.setShareSceneConfigName(r43);
        TicketInfo r45 = r111.getTicketInfo();
        if (r45 == null) goto L120;
        String r46 = r45.getSchema();
    L121:
        r44.setUrl(r46);
        goto L122
    L120:
        r46 = null;
        goto L121
    L116:
        r43 = null;
    L122:
        k.n(ILiveShareService.class).share(new i81.a(null, r32, null, r110.build(), null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), TICKET_SHARE, LiveShareType.SHARE_DIALOG, null);
        return;
    L110:
        r15 = null;
        goto L111
    L102:
        r31 = r14;
    L98:
        r29 = "";
        goto L99
    L91:
        r26 = r14;
    L87:
        r25 = "";
    L82:
        th = move-exception;
        ALogger.e(r21, th);
    L77:
        th = move-exception;
        r21 = "shareTicket";
        ALogger.e(r21, th);
    L73:
        r16 = "0";
        goto L74
    L63:
        r11 = r3;
        goto L64
    L16:
        if (r8.getTicketInfo() != null) goto L18;
    L51:
        ALogger.e(TICKET_SHARE, "ticket generate data illegal.");
        return;
    L18:
        if (r8.getTicketIdList() == null) goto L51;
        List r210 = r8.getTicketIdList();
        if (r210 == null) goto L25;
        if (r210.isEmpty() == true) goto L51;
    L25:
        TicketInfo r47 = r8.getTicketInfo();
        if (r47 == null) goto L32;
        List r48 = r47.getTicketImgList();
        if (r48 == null) goto L32;
        if (r48.isEmpty() == true) goto L51;
    L32:
        TicketInfo r49 = r8.getTicketInfo();
        if (r49 == null) goto L35;
        Long r51 = r49.getContentId();
    L36:
        if (r51 == null) goto L42;
        TicketInfo r52 = r8.getTicketInfo();
        if (r52 == null) goto L40;
        Long r53 = r52.getContentId();
    L41:
        r5.put("vs_content_id", String.valueOf(r53));
        goto L42
    L40:
        r53 = null;
    L42:
        TicketGenerateResponse r54 = (TicketGenerateResponse) r14;
        if (r54 == null) goto L49;
        TicketInfo r55 = r54.getTicketInfo();
        if (r55 == null) goto L49;
        Long r56 = r55.getStageId();
        if (r56 == null) goto L49;
        long r211 = r56.longValue();
    L50:
        String r57 = (String) r5.put("stage_id", String.valueOf(r211));
    L49:
        r211 = 0;
        goto L50
    L35:
        r51 = null;
        goto L36
    L12:
        r7 = r14;
        goto L13
    L8:
        r14 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public void launchMatchShareByRoomId(Context r24, String r25, int r26, String r27, String r28, String r29, boolean r31) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "enterFrom");
        Type r3 = new d().getType();     // Catch: Exception -> L5
        List r4 = (List) GsonHelper.get().fromJson(r27, r3);     // Catch: Exception -> L5
    L6:
        if (r4 == null) goto L16;
        if (r26 >= 0) goto L9;
    L11:
        Object r5 = new CollectionItem();
    L12:
        CollectionItem r6 = (CollectionItem) r5;
        if (r6 == null) goto L16;
        String r7 = r6.getCollectionId();
        if (r7 == null) goto L16;
    L17:
        MatchShareParam r15 = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
        r15.a = r25;
        r15.b = r7;
        r15.d = r4;
        r15.e = null;
        Room r1 = new Room();
        if (r28 == null) goto L20;
        long r8 = CastLongProtector.parseLong(r28);
    L21:
        r1.id = r8;
        Unit r9 = Unit.INSTANCE;
        r15.f = r1;
        Episode r2 = new Episode();
        r2.idStr = r29;
        r15.g = r2;
        r15.j = new SearchPanelParam(r26, r4);
        launchMatchShare(r24, r31, r15);
        return;
    L20:
        r8 = 0;
        goto L21
    L9:
        if (r26 > CollectionsKt.getLastIndex(r4)) goto L11;
        r5 = ListProtector.get(r4, r26);
    L16:
        r7 = "";
    L5:
        r4 = new ArrayList();
        goto L6
    }

    public void launchMatchShareByCollectionId(Context r13, String r14, Room r15, Episode r16, boolean r17, String r18, String r19, String r21, HashMap<String, String> r22) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "enterFrom");
        Intrinsics.checkNotNullParameter(r18, "collectionId");
        Intrinsics.checkNotNullParameter(r19, "episodeId");
        Intrinsics.checkNotNullParameter(r21, "contentType");
        Intrinsics.checkNotNullParameter(r22, "logParam");
        Observable<Response<CollectionResponseDataSingle>> r11 = ((MatchShareApi) com.bytedance.android.live.network.c.b().e(MatchShareApi.class)).getCollectionDataByCollectionId(r18, r19);
        if (r11 == null) goto L6;
        r11.subscribe(new b(this, r18, r14, r15, r16, r21, r22, r13, r17), c.a);
        return;
    }
}
