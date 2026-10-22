package wv1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.live.DislikeResult;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feed.LiveDrawerFeedPageFragment;
import com.bytedance.android.livesdk.feed.dislike.DislikeApi;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.EntryType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.livesdkapi.drawer.ILiveDoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdkapi.drawer.ILiveDrawerParentAction;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.common.utility.NetworkUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k0 implements ILiveDrawerParentAction {
    public com.bytedance.android.livesdk.feed.feed.e a;
    public WeakReference<LiveDrawerFeedPageFragment> b;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "resp");
            return (DislikeResult) ((BaseResponse) r3).data;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ k0 a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public c(k0 r1, Function1 r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r6) {
            DislikeResult r7 = (DislikeResult) r6;
            this.b.invoke(Boolean.valueOf(jc1.k.n(IHostBusiness.class).isEnablePersonalRecommend()));
            k0 r8 = this.a;
            String r0 = this.c;
            String r1 = this.d;
            String r2 = this.e;
            String r9 = r8.a();
            HashMap r3 = new HashMap();
            r3.put("enter_from_merge", r9);
            r3.put("enter_method", r0);
            r3.put("action_type", "click");
            r3.put("request_page", "long_press");
            r3.put("event_page", "live_cover");
            r3.put("to_user_id", r1.toString());
            r3.putAll(k0.b());
            r3.put("request_id", r2);
            r3.put("log_pb", "{\"impr_id\":\"" + r2 + "\"}");
            com.bytedance.android.livesdk.log.g r10 = com.bytedance.android.livesdk.log.u.l();
            int r4 = am2.c0.b;
            r10.sendLog("livesdk_dislike", r3, new Object[]{am2.x.class, Room.class, am2.n.f(), am2.c0.a.a(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal().v())});
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            StringBuilder r0 = new StringBuilder("dislike失败");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r0.append(r5);
            ALogger.e("LiveDrawerParentAction", r0.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public k0() {
    }

    public static Map b() {
        LinkedHashMap r0 = new LinkedHashMap();
        ILiveService r1 = TTLiveService.getLiveService();
        if (r1 == null) goto L8;
        ILiveOntologyInfoManager r2 = r1.getLiveOntologyRecord();
        if (r2 == null) goto L8;
        String r3 = r2.getEnterFromMerge();
        if (r3 == null) goto L8;
    L9:
        r0.put("drawer_page", r3);
        r0.put("pull_type", "");
        r0.put("is_preview", m2.b(false));
        return r0;
    L8:
        r3 = "";
        goto L9
    }

    public final String a() {
        com.bytedance.android.livesdk.feed.feed.e r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.j();
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        com.bytedance.android.livesdk.feed.feed.e r3 = this.a;
        if (r3 == null) goto L26;
        String r4 = r3.j();
        if (r4 != null) goto L27;
        return "";
    L27:
        return r4;
    L26:
        return "";
    L14:
        com.bytedance.android.livesdk.feed.feed.e r5 = this.a;
        if (r5 == null) goto L18;
        r1 = r5.e();
    L18:
        if (TextUtils.isEmpty(r1) == true) goto L24;
        com.bytedance.android.livesdk.feed.feed.e r6 = this.a;
        if (r6 == null) goto L28;
        r4 = r6.e();
        if (r4 != null) goto L27;
        return "";
    L28:
        return "";
    L24:
        return "drawer_hot";
    L5:
        r2 = null;
        goto L7
    }

    public final void closeLoading() {
        WeakReference<LiveDrawerFeedPageFragment> r0 = this.b;
        if (r0 == null) goto L8;
        LiveDrawerFeedPageFragment r1 = r0.get();
        if (r1 == null) goto L9;
        r1.showLoading(false);
        return;
    L9:
        return;
    }

    public final void showLoading() {
        WeakReference<LiveDrawerFeedPageFragment> r0 = this.b;
        if (r0 == null) goto L8;
        LiveDrawerFeedPageFragment r1 = r0.get();
        if (r1 == null) goto L9;
        r1.showLoading(true);
        return;
    L9:
        return;
    }

    public static Room c(String r2) {
        return (Room) GsonHelper.get().fromJson(r2, Room.class);
    L4:
        ALogger.e("LiveDrawerParentAction", "room结构解析失败");
        return null;
    }

    public final ILiveDoubleBallSwipeRefreshLayout createRefreshLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new fw1.a(r2);
    }

    public final void enterRoom(String r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "roomStruct");
        Intrinsics.checkNotNullParameter(r14, "enterExtra");
        Room r15 = c(r13);
        if (r15 != null) goto L7;
        ALogger.e("LiveDrawerParentAction", "room结构为空，进房失败");
        return;
    L7:
        if (r15.isPullUrlValid() == true) goto L10;
        ALogger.e("LiveDrawerParentAction", "room.isPullUrlValid为" + r15.isPullUrlValid() + "进房失败");
        return;
    L10:
        WeakReference<LiveDrawerFeedPageFragment> r1 = this.b;
        if (r1 == null) goto L121;
        LiveDrawerFeedPageFragment r2 = r1.get();
        if (r2 == null) goto L122;
        Context r3 = r2.getContext();
        if (r3 != null) goto L18;
        return;
    L18:
        if (NetworkUtils.isNetworkAvailable(r3) == true) goto L21;
        IESUIUtils.displayToast(r3, 2131916613);
        ALogger.e("LiveDrawerParentAction", "无网络，进房失败");
        return;
    L21:
        String r4 = "";
        r15.setRequestId(r14.getString("request_id", ""));
        String r0 = "{\"impr_id\":\"" + r15.getRequestId() + "\"}";
        r15.setLog_pb(r0);
        r14.putString("log_pb", r0);
        Map r5 = b();
        com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.u.l().c(am2.o.class);
        if (r6 != null) goto L24;
    L26:
        r14.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", System.currentTimeMillis());
        com.bytedance.android.livesdk.feed.feed.e r7 = this.a;
        if (r7 == null) goto L30;
        String r8 = r7.e();
        if (r8 == null) goto L30;
    L31:
        r14.putString("source", r8);
        Bundle r9 = new Bundle();
        r9.putString("live_source", "live_small_picture");
        r9.putString("subtab", r8);
        r9.putString("pull_type", "");
        r14.putBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1", r9);
        r14.putInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        r14.putString("enter_from", "live");
        com.bytedance.android.livesdk.feed.feed.e r10 = this.a;
        if (r10 == null) goto L34;
        long r11 = r10.l();
    L35:
        r14.putLong("live.intent.extra.USER_FROM", r11);
        r14.putString("enter_from_merge", a());
        String r12 = r15.getItemExplicitInfo();
        if (r12 != null) goto L38;
        r12 = "";
    L38:
        r14.putString("live_recommend_info", r12);
        ILiveService r16 = TTLiveService.getLiveService();
        if (r16 == null) goto L44;
        ILiveOntologyInfoManager r17 = r16.getLiveOntologyRecord();
        if (r17 == null) goto L44;
        String r18 = r17.getEnterFromMerge();
        if (r18 == null) goto L44;
    L45:
        r14.putString("drawer_page", r18);
        com.bytedance.android.livesdk.feed.feed.e r19 = this.a;
        if (r19 == null) goto L49;
        String r20 = r19.j();
        if (r20 == null) goto L49;
    L50:
        Bundle r21 = LiveRoomIntentBuilder.buildBundle(r3, r15, r20, r14);
        IHostService r22 = TTLiveSDK.hostService();
        if (r22 != null) goto L53;
        return;
    L53:
        if (r22.action() == null) goto L125;
        if (r21 != null) goto L57;
        return;
    L57:
        ILiveRoomService r23 = jc1.k.f(ILiveRoomService.class);
        if (r23 == null) goto L61;
        r23.recordEnterStart(EntryType.FEED);
    L61:
        if (r15.getAutoCover() != 1) goto L63;
        String r24 = "autocover";
    L64:
        r14.putString("cover_type", r24);
        py.k r25 = r15.getOperationLabel();
        if (r25 == null) goto L70;
        Integer r26 = r25.getImageType();
        if (r26 == null) goto L70;
        String r27 = String.valueOf(r26.intValue());
        if (r27 == null) goto L70;
    L71:
        r14.putString("enter_room_operation_label", r27);
        Bundle r28 = r14.getBundle("live.intent.extra.EXTRA_COMMON_LOG");
        if (r28 != null) goto L74;
        r28 = new Bundle();
    L74:
        r21.putBundle("live.intent.extra.EXTRA_COMMON_LOG", r28);
        if (r14.containsKey("is_from_match_room") == false) goto L78;
        r21.putBoolean("is_from_match_room", r14.getBoolean("is_from_match_room", false));
    L78:
        if (r14.containsKey("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME") == false) goto L81;
        r21.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", r14.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", 0));
    L81:
        if (r14.containsKey("live.intent.extra.ENTER_ROOM_IDS") == false) goto L83;
        r21.putLongArray("live.intent.extra.ENTER_ROOM_IDS", r14.getLongArray("live.intent.extra.ENTER_ROOM_IDS"));
    L83:
        r21.putAll(ArgumentsBuilder.buildRoomArgs(r15));
        VerticalTypeInfo r29 = r15.mVerticalTypeInfo;
        if (r29 == null) goto L91;
        Long r30 = r29.tagId;
        if (r30 == null) goto L91;
        String r31 = String.valueOf(r30.longValue());
        if (r31 == null) goto L91;
        r4 = r31;
    L91:
        r21.putString("tag_id", r4);
        if (r21.get("live.intent.extra.USER_ID") != null) goto L94;
        r21.putString("live.intent.extra.USER_ID", r15.getOwnerUserIdString());
    L94:
        r21.putString("enter_from_user_id", r15.getOwnerUserIdString());
        r21.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        r21.putBoolean("live.intent.extra.LIVE_FROM_DRAWER", true);
        r21.putString("enter_from_live_source", "live_square");
        r21.putString("live.intent.extra.WINDOW_MODE", "small_picture");
        UrlBuilder r32 = new UrlBuilder("/webcast/feed/").addParam("source_key", a().concat("_drawer_cover")).addParam("inner_from_drawer", 1).addParam("need_map", 1);
        com.bytedance.android.livesdk.feed.feed.e r33 = this.a;
        long r34 = -1;
        if (r33 == null) goto L97;
        long r110 = r33.f();
    L99:
        if (r110 < 0) goto L105;
        com.bytedance.android.livesdk.feed.feed.e r35 = this.a;
        if (r35 == null) goto L103;
        r34 = r35.f();
    L103:
        r32.addParam("tab_id", r34);
    L105:
        if (r14.containsKey("ecom_drawer_extra") != true) goto L109;
        String r36 = r14.getString("ecom_drawer_extra");
        if (TextUtils.isEmpty(r36) == true) goto L109;
        r32.addParam("ecom_drawer_extra", r36);
    L109:
        r21.putString("live.intent.extra.FEED_URL", r32.build());
        com.bytedance.android.livesdk.feed.feed.e r37 = this.a;
        if (r37 == null) goto L112;
        int r38 = r37.getType();
    L113:
        r21.putInt("live.intent.extra.DRAWER_JUMP_FROM", r38);
        r21.putString("extra_live_new_room_back_source", "jump_source_square_drawer");
        kw1.c.b(r3, r14);
        RoomContext r111 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r111 != null) goto L116;
    L119:
        TTLiveSDK.hostService().action().startLive(r3, r15.id, r21);
        xs2.b.a().post(new uv1.e(0));
        return;
    L116:
        if (com.bytedance.android.livesdk.utils.landscape.b.a() == false) goto L119;
        r21.putBoolean("live.intent.extra.is_game_live", com.bytedance.android.live.core.utils.d1.a(r15));
        boolean r112 = ((Boolean) r111.isPortraitInteraction().getValue()).booleanValue();
        Handler r39 = UtilityKotlinExtentionsKt.a;
        r21.putInt("live.intent.extra.SCREEN_ORIENTATION", r112 ? 1 : 0);
        goto L119
    L112:
        r38 = 0;
        goto L113
    L97:
        r110 = -1;
    L70:
        r27 = "";
        goto L71
    L63:
        r24 = "other";
        goto L64
    L125:
        return;
    L49:
        r20 = "";
    L44:
        r18 = "";
        goto L45
    L34:
        r11 = 0;
    L30:
        r8 = "";
        goto L31
    L24:
        if (r6.getMap() == null) goto L26;
        r6.getMap().putAll(r5);
        am2.o r40 = new am2.o();
        r40.a = r15.id;
        r6.setData(r40);
        goto L26
    L122:
        return;
    }

    public final void logEvent(String r19, String r20, Map<String, String> r21) {
        Intrinsics.checkNotNullParameter(r19, "event");
        Intrinsics.checkNotNullParameter(r21, "logMap");
        String r7 = "portrait";
        String r8 = "1";
        Object r10 = "";
        switch(r19.hashCode()) {
            case -1870323437: goto L161;
            case 172411538: goto L155;
            case 1431431928: goto L118;
            case 1499265855: goto L45;
            case 1763681274: goto L6;
            default: goto L163;
        };
    L163:
        com.bytedance.android.livesdk.log.u.l().sendLog(r19, r21, new Object[0]);
        return;
    L6:
        if (r19.equals("livesdk_live_window_duration_v2") == false) goto L163;
        Room r1 = c(r20);
        HashMap r9 = new HashMap();
        r9.putAll(r21);
        if (r1 == null) goto L21;
        r9.put("anchor_id", r1.getOwnerUserIdString());
        Object r16 = "landscape";
        r9.put("room_id", String.valueOf(r1.id));
        RoomSpecificSceneTypeInfo r2 = r1.getSceneTypeInfo();
        if (r2 != null) goto L12;
    L14:
        r9.put("is_life", "0");
    L16:
        if (r1.getRoomCart() != null) goto L18;
    L20:
        r9.put("is_ecom_live", "0");
    L22:
        r9.put("action_type", "click");
        r9.put("enter_from_merge", a());
        r9.put("enter_method", "drawer_cell");
        r9.putAll(b());
        if (r1 != null) goto L25;
    L43:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_window_duration_v2", r9, new Object[0]);
        return;
    L25:
        if (r1.isMergeVSRoom() == false) goto L43;
        LiveVSLog.r.getClass();
        r9.putAll(LiveVSLog.b.a(r1).a());
        WeakReference<LiveDrawerFeedPageFragment> r3 = this.b;
        if (r3 == null) goto L31;
        LiveDrawerFeedPageFragment r4 = r3.get();
        if (r4 == null) goto L31;
        Context r5 = r4.getContext();
    L32:
        if (r5 == null) goto L43;
        Activity r6 = bz2.b.a(r5);
        if (r6 == null) goto L43;
        if (r6.getRequestedOrientation() != 0) goto L38;
    L41:
        Object r11 = r16;
    L42:
        r9.put("vs_screen_type", r11);
        goto L43
    L38:
        if (r6.getRequestedOrientation() == 6) goto L41;
        r11 = "portrait";
    L31:
        r5 = null;
        goto L32
    L18:
        if (r1.getRoomCart().showCart != 1) goto L20;
        r9.put("is_ecom_live", "1");
        goto L22
    L12:
        if (r2.isLife() != true) goto L14;
        r9.put("is_life", "1");
        goto L16
    L21:
        r16 = "landscape";
        goto L22
    L45:
        if (r19.equals("livesdk_live_show") == false) goto L163;
        Room r12 = c(r20);
        if (r12 == null) goto L174;
        String r13 = r12.getOwnerUserIdString();
        if (r13 != null) goto L52;
        r13 = "0";
    L52:
        HashMap r14 = new HashMap();
        r14.putAll(r21);
        r14.put("enter_from_merge", a());
        r14.put("anchor_id", r13);
        r14.put("room_id", String.valueOf(r12.id));
        r14.put("show_type", "stay");
        if (r12.isLiveTypeAudio() == false) goto L55;
        String r15 = "voice_live";
    L56:
        r14.put("live_type", r15);
        if (r12.isThirdParty() == false) goto L59;
        String r17 = "thirdparty";
    L60:
        r14.put("streaming_type", r17);
        r14.put("event_belong", "live_view");
        r14.put("event_page", "live");
        if (r12.isReplay == false) goto L63;
        Object r18 = "1";
    L64:
        r14.put("is_live_recall", r18);
        r14.put("event_type", "core");
        r14.put("event_module", "live");
        r14.put("action_type", "click");
        r14.put("is_with_cover", "1");
        r14.put("is_with_title", "1");
        com.bytedance.android.livesdk.log.filter.n0 r22 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r22 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L69;
        String r23 = r22.i;
        if (r23 == null) goto L69;
        r14.put("distribute_source", r23);
    L69:
        r14.put("live_window_mode", "small_picture");
        RoomSpecificSceneTypeInfo r24 = r12.getSceneTypeInfo();
        if (r24 == null) goto L75;
        if (r24.isUnionLiveRoom() != true) goto L75;
        r14.put("joint_anchor_id", r13);
        r14.put("is_joint_room", "1");
    L75:
        if (r12.isMediaRoom() == false) goto L77;
        String r25 = "media";
    L78:
        r14.put("room_layout", r25);
        if (r12.getAutoCover() != 0) goto L81;
    L85:
        py.k r26 = r12.getOperationLabel();
        if (r26 == null) goto L88;
        Integer r27 = r26.getImageType();
    L89:
        r14.put("sub_info", String.valueOf(r27));
        if (e5.n() == false) goto L92;
        r7 = "landscape";
    L92:
        r14.put("screen_direction", r7);
        WeakReference<LiveDrawerFeedPageFragment> r28 = this.b;
        if (r28 == null) goto L99;
        LiveDrawerFeedPageFragment r29 = r28.get();
        if (r29 == null) goto L99;
        Context r30 = r29.getContext();
        if (r30 == null) goto L99;
        kw1.c.c(r14, r30);
    L99:
        r14.putAll(h1.a(r12));
        r14.putAll(b());
        if (r12.getEpisodeExtra2() != null) goto L102;
    L104:
        com.bytedance.android.livesdk.log.filter.m0.J(r14);
        User r31 = r12.getOwner();
        if (r31 == null) goto L107;
        FollowInfo r32 = r31.getFollowInfo();
    L108:
        if (r32 == null) goto L116;
        User r33 = r12.getOwner();
        if (r33 != null) goto L112;
    L114:
        r8 = "0";
    L115:
        r14.put("is_fans", r8);
        goto L116
    L112:
        if (r33.isFollowing() != true) goto L114;
    L116:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_show", r14, new Object[0]);
        return;
    L107:
        r32 = null;
        goto L108
    L102:
        if (r12.isMergeVSRoom() == true) goto L104;
        int r34 = ju2.f.M;
        ju2.f r35 = ju2.f.a.a(r12);
        r14.put("is_vs", "1");
        com.bytedance.android.livesdk.vs.f.c.c("live_show", r14, new Object[]{r35});
        r14.putAll(r35.b());
        return;
    L88:
        r27 = null;
        goto L89
    L81:
        if (r12.getAutoCover() != 1) goto L83;
        String r36 = "autocover";
    L84:
        r14.put("cover_type", r36);
        goto L85
    L83:
        r36 = "other";
        goto L84
    L77:
        r25 = "normal";
        goto L78
    L63:
        r18 = "0";
        goto L64
    L59:
        r17 = "general";
        goto L60
    L55:
        r15 = "video_live";
        goto L56
    L174:
        return;
    L118:
        if (r19.equals("livesdk_live_cover_info") == false) goto L163;
        Room r37 = c(r20);
        if (r37 == null) goto L125;
        String r38 = r37.getOwnerUserIdString();
        if (r38 == null) goto L125;
        String r110 = r38;
    L126:
        HashMap r39 = new HashMap();
        r39.putAll(r21);
        r39.putAll(b());
        r39.put("enter_from_merge", a());
        r39.put("anchor_id", r110);
        if (r37 == null) goto L129;
        Long r40 = Long.valueOf(r37.id);
    L130:
        r39.put("room_id", String.valueOf(r40));
        r39.put("action_type", "click");
        JSONObject r41 = new JSONObject();
        if (r37 != null) goto L166;
    L137:
        String r42 = "";
    L138:
        r41.put("location", r42);     // Catch: Exception -> L165
        if (r37 == null) goto L142;
        String r43 = r37.getLiveHashTagJson();     // Catch: Exception -> L165
        if (r43 == null) goto L142;
    L143:
        r41.put("challenge_info", r43);     // Catch: Exception -> L165
        if (r37 != null) goto L146;
    L150:
        if (r37 == null) goto L152;
        r10 = Long.valueOf(r37.getUserCount());     // Catch: Exception -> L165
    L152:
        r41.put("user_count", r10);     // Catch: Exception -> L165
    L153:
        r39.put("basic_info", r41.toString());
        com.bytedance.android.livesdk.log.u.l().sendLog("live_cover_info", r39, new Object[0]);
        return;
    L146:
        if (r37.isMediaRoom() != true) goto L150;
        IRoomStats r44 = r37.getStats();     // Catch: Exception -> L165
        if (r44 == null) goto L152;
        r10 = Integer.valueOf(r44.getTotalUser());     // Catch: Exception -> L165
    L142:
        r43 = "";
        goto L143
    L166:
        User r45 = r37.getOwner();     // Catch: Exception -> L165
        if (r45 == null) goto L137;
        r42 = r45.getCity();     // Catch: Exception -> L165
        if (r42 != null) goto L138;
    L129:
        r40 = null;
    L125:
        r110 = "0";
        goto L126
    L155:
        if (r19.equals("livesdk_click_trans_layer") == false) goto L163;
        com.bytedance.android.livesdk.log.filter.o r46 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r47 = a();
        if (r46.getMap().containsKey("action_type") == false) goto L159;
        r10 = (String) r46.getMap().get("action_type");
    L159:
        HashMap r48 = new HashMap();
        r48.putAll(r21);
        r48.put("enter_from_merge", r47);
        r48.put("action_type", r10);
        r48.put("event_page", "live_cover");
        r48.putAll(b());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_click_trans_layer", r48, new Object[]{Room.class});
        return;
    L161:
        if (r19.equals("livesdk_drawer_tab_stay_duration") == false) goto L163;
        HashMap r49 = new HashMap();
        r49.putAll(r21);
        r49.putAll(b());
        r49.put("enter_from_merge", a());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_tab_stay_duration", r49, new Object[0]);
    }

    public final Disposable dislikeCard(long r15, String r17, String r18, String r19, Function1<? super Boolean, Unit> r20) {
        Intrinsics.checkNotNullParameter(r17, "ownerId");
        Intrinsics.checkNotNullParameter(r18, "requestId");
        Intrinsics.checkNotNullParameter(r19, "enterMethod");
        Intrinsics.checkNotNullParameter(r20, "callback");
        return ((DislikeApi) com.bytedance.android.live.network.c.b().e(DislikeApi.class)).dislikeRoomSaasLegacy(r15, r17, r17, r18, "", a(), r19).map(b.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r20, r19, r17, r18), d.a);
    }
}
