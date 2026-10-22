package com.bytedance.android.live.broadcast.api.model;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.AudienceResolutionPickerDialog;
import com.bytedance.android.livesdk.chatroom.ui.i8;
import com.bytedance.android.livesdk.chatroom.ui.l5;
import com.bytedance.android.livesdk.config.bv;
import com.bytedance.android.livesdk.config.ke1;
import com.bytedance.android.livesdk.config.le1;
import com.bytedance.android.livesdk.config.qw0;
import com.bytedance.android.livesdk.config.ui;
import com.bytedance.android.livesdk.config.w21;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnchorVideoResolutionManager {
    public static final Map<String, Pair<Integer, Integer>> a = null;
    public static Disposable b;
    public static String c;
    public static final NextLiveData<String> d = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H'J,\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/AnchorVideoResolutionManager$ResolutionApi;", "", "changeResolution", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/broadcast/api/model/AnchorResolutionInfo;", "params", "", "", "queryRecommendResolution", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ResolutionApi {
        @FormUrlEncoded
        @POST("/webcast/room/change_resolution/")
        Observable<Response<AnchorResolutionInfo>> changeResolution(@FieldMap Map<String, String> r1);

        @FormUrlEncoded
        @POST("/webcast/room/recommend_resolution/")
        Observable<Response<AnchorResolutionInfo>> queryRecommendResolution(@FieldMap Map<String, String> r1);
    }

    public static final class a {
        public a() {
        }
    }

    public AnchorVideoResolutionManager() {
    }

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("ld", new Pair(540, 960)), TuplesKt.to("sd", new Pair(540, 960)), TuplesKt.to("hd", new Pair(720, 1280)), TuplesKt.to("uhd", new Pair(1080, 1920))});
        new HashMap();
        c = "";
        d = new NextLiveData();
    }

    public static List b() {
        return ((IResolutionInfoService) va1.b.a.a.a(IResolutionInfoService.class)).f5();
    }

    public static i8 c() {
        return ((IResolutionInfoService) va1.b.a.a.a(IResolutionInfoService.class)).L3();
    }

    public static String d() {
        return ((IResolutionInfoService) va1.b.a.a.a(IResolutionInfoService.class)).w0();
    }

    public static LiveMode e() {
        return ((IResolutionInfoService) va1.b.a.a.a(IResolutionInfoService.class)).K1();
    }

    public static final void a(String r4) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.l2;
        Object r1 = r0.getValue();
        ((Map) r1).put(e().name(), r4);
        Unit r2 = Unit.INSTANCE;
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        if (r4.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        r4 = "empty";
    L8:
        IFeatureService r5 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r5 == null) goto L13;
        z90.a r6 = r5.getFeatureManager();
        if (r6 == null) goto L13;
        r6.i("memory_broadcast_resolution_key", r4, FeatureType.MONITOR);
    L13:
        long r7 = System.currentTimeMillis();
        com.bytedance.android.livesdk.sharedpref.e<Long> r8 = b6.Z;
        Long r9 = Long.valueOf(r7);
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r9);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static RoomCreateInfo.p.a f(String r3) {
        Iterator r0 = b().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((RoomCreateInfo.p.a) r1).key, r3) == false) goto L4;
    L10:
        return (RoomCreateInfo.p.a) r1;
    L8:
        r1 = null;
        goto L10
    }

    public static String g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        RoomCreateInfo.p.a r2 = f(r1);
        if (r2 == null) goto L6;
        String r3 = r2.text;
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    public static void h(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("anchor_resolution", r1);
    }

    @JvmStatic
    public static final void i(Room r6) {
        Intrinsics.checkNotNullParameter("anchor_change", "reason");
        if (r6 != null) goto L5;
        return;
    L5:
        NextLiveData<String> r0 = ((IMiddlewareAnchorVideoResolutionManager) va1.b.a.a.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt();
        com.bytedance.android.livesdk.log.g r2 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r3 = new Pair[6];
        r3[0] = TuplesKt.to("definition", r0.getValue());
        r3[1] = TuplesKt.to("definition_reason", "anchor_change");
        StreamUrl r1 = r6.getStreamUrl();
        if (r1 == null) goto L12;
        IStreamUrlExtra r4 = r1.getExtra();
        if (r4 == null) goto L12;
        if (r4.isEnableH265() != true) goto L12;
        String r5 = "265";
    L13:
        r3[2] = TuplesKt.to("encoding_format", r5);
        LiveMode r7 = r6.getStreamType();
        int r8 = com.bytedance.android.live.core.utils.h1.a;
        r3[3] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r7));
        r3[4] = TuplesKt.to("is_anchor", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r3[5] = TuplesKt.to("anchor_id", r6.getOwnerUserIdString());
        r2.sendLog("performance_definition_monitor", MapsKt.mapOf(r3), new Object[]{Room.class});
        return;
    L12:
        r5 = "264";
        goto L13
    }

    public static void k(String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        c = r3;
        Iterator r0 = b().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((RoomCreateInfo.p.a) r1).key, r3) == false) goto L4;
    L9:
        RoomCreateInfo.p.a r2 = (RoomCreateInfo.p.a) r1;
        if (r2 == null) goto L17;
        va1.b r4 = va1.b.a.a;
        IMiddlewareAnchorVideoResolutionManager r5 = (IMiddlewareAnchorVideoResolutionManager) r4.a(IMiddlewareAnchorVideoResolutionManager.class);
        if (r5 == null) goto L16;
        NextLiveData<String> r6 = r5.getCurrResolutionTxt();
        if (r6 == null) goto L16;
        r6.setValue(r2.text);
    L16:
        h(e().name() + " update currentResolutionText : " + ((String) ((IMiddlewareAnchorVideoResolutionManager) r4.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt().getValue()));
    L17:
        d.setValue(r3);
        return;
    L8:
        r1 = null;
        goto L9
    }

    @JvmStatic
    public static final void l(final Context r17, final Room r18) {
        if (b().isEmpty() == true) goto L43;
        if (r17 == null) goto L43;
        ALogger.i("anchor_resolution", "showResolutionPicker");
        if (((w21) bv.a.getValue()).a() == false) goto L11;
        IBroadcastService r2 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r2 == null) goto L11;
        r2.getLiveByteCastSinkService();
    L11:
        List r3 = b();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L12:
        final boolean r6 = true;
        if (r5.hasNext() == false) goto L25;
        RoomCreateInfo.p.a r7 = (RoomCreateInfo.p.a) r5.next();
        boolean r8 = Intrinsics.areEqual(r7.key, c);
        String r9 = r7.text;
        if (r8 == false) goto L17;
        String r11 = "selected";
    L18:
        String r12 = r11;
        if (r18 != null) goto L21;
    L23:
        boolean r13 = false;
    L24:
        r4.add(new l5(r9, "", 0, r12, r13, null, null, r7.key, 736));
        goto L12
    L21:
        if (r18.isMergeVSRoom() != true) goto L23;
        r13 = true;
        goto L24
    L17:
        r11 = "unselected";
        goto L18
    L25:
        Iterator r14 = b().iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        j("livesdk_anchor_definition_setting_show", r18, ((RoomCreateInfo.p.a) r14.next()).text, "");
        goto L27
    L29:
        AudienceResolutionPickerDialog r15 = new AudienceResolutionPickerDialog(r17, r4, e(), new AnchorVideoResolutionManager$showResolutionPicker$2(r18, r6, r17));
        if (e() != LiveMode.SCREEN_RECORD) goto L35;
        if (((ke1) ui.a.getValue()).a() == false) goto L35;
        r15.Z0(c(), d(), AnchorVideoResolutionManager$showResolutionPicker$3$1.INSTANCE, AnchorVideoResolutionManager$showResolutionPicker$3$2.INSTANCE, AnchorVideoResolutionManager$showResolutionPicker$3$3.INSTANCE, AnchorVideoResolutionManager$showResolutionPicker$3$4.INSTANCE, null, null);
    L37:
        r15.N = AnchorVideoResolutionManager$showResolutionPicker$3$9.INSTANCE;
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L46;
        DialogLancet.handleBlockedDialogShow(r15);
        return;
    L46:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L41:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
        return;
    L35:
        if (e() != LiveMode.VIDEO) goto L37;
        ((le1) qw0.a.getValue()).a();
    L43:
        h("showResolutionPicker failed");
    }

    public static void j(String r17, Room r18, String r19, String r21) {
        NextLiveData<String> r1 = ((IMiddlewareAnchorVideoResolutionManager) va1.b.a.a.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt();
        com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r7 = new Pair[8];
        LiveMode r2 = e();
        int r3 = com.bytedance.android.live.core.utils.h1.a;
        r7[0] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r2));
        IUserService r4 = jc1.k.f(IUserService.class);
        String r9 = null;
        if (r4 == null) goto L7;
        com.bytedance.android.livesdk.user.f r5 = r4.user();
        if (r5 == null) goto L7;
        String r8 = r5.n();
    L8:
        r7[1] = TuplesKt.to("anchor_id", r8);
        if (r18 == null) goto L11;
        String r11 = "live_take_detail";
    L12:
        r7[2] = TuplesKt.to("event_page", r11);
        r7[3] = TuplesKt.to(FeedApi.SHOW_TYPE, "icon");
        r7[4] = TuplesKt.to("definition", r19);
        String r12 = (String) r1.getValue();
        if (r12 == null) goto L17;
        List r13 = StringsKt.split$default(r12, new String[]{" "}, false, 0, 6, null);
        if (r13 == null) goto L17;
        String r14 = (String) ListProtector.get(r13, 0);
    L18:
        r7[5] = TuplesKt.to("old_resolution", r14);
        if (r19 == null) goto L23;
        List r0 = StringsKt.split$default(r19, new String[]{" "}, false, 0, 6, null);
        if (r0 == null) goto L23;
        r9 = (String) ListProtector.get(r0, 0);
    L23:
        r7[6] = TuplesKt.to("new_resolution", r9);
        r7[7] = TuplesKt.to("if_use_recommend_image", r21);
        r6.sendLog(r17, MapsKt.mapOf(r7), new Object[]{Room.class});
        return;
    L17:
        r14 = null;
        goto L18
    L11:
        r11 = "live_take_page";
    L7:
        r8 = null;
        goto L8
    }
}
