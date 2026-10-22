package com.bytedance.android.livesdk.feed.live;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.j2;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ap0;
import com.bytedance.android.livesdk.config.o51;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.config.p2;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdk.log.filter.m0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdk.utils.landscape.LandscapeScene;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.EntryType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.LinkMicBattleSetting;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLinkInfo;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MainCameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.paramtransfer.utils.LiveEntranceTag;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import jc1.k;
import jw1.a;
import jw1.b;
import jw1.g;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nm1.v;
import tv1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseLiveViewHolder extends BaseViewHolder<FeedItem> {
    public static final /* synthetic */ int q = 0;
    public final c a;
    public final f b;
    public final FeedDataKey c;
    public final boolean d;
    public final ILiveRoomListDataSource e;
    public final PublishSubject<FeedItem> f;
    public final PublishSubject<Boolean> g;
    public e h;
    public boolean i;
    public boolean j;
    public Map<String, String> k;
    public final j l;
    public final h m;
    public Room n;
    public int o;
    public FeedItem p;

    public abstract void U3(FeedItem r1, Room r2, int r3);

    public String W3() {
        return "";
    }

    public final void Z3() {
        if (this.d == true) goto L5;
        return;
    L5:
        SharedPrefHelper r0 = SharedPrefHelper.b(((RecyclerView.ViewHolder) this).itemView.getContext());
        long r4 = r0.i("hotsoon.pref.DISLIKE_TIPS_RECORD_TIME", 0);
        if (r4 >= 0) goto L8;
        return;
    L8:
        long r2 = System.currentTimeMillis();
        if (r2 > r4) goto L11;
        return;
    L11:
        if ((r2 - r4) > 5500) goto L19;
        r0.l("hotsoon.pref.DISLIKE_TIPS_RECORD_TIME", -1L);
        r0.a();
        int[] r1 = new int[2];
        ((RecyclerView.ViewHolder) this).itemView.getLocationInWindow(r1);
        int[] r3 = new int[2];
        View r5 = (View) ((RecyclerView.ViewHolder) this).itemView.getParent();
        if (r5 == null) goto L20;
        r5.getLocationInWindow(r3);
        int r6 = Math.max(0, r3[1] - r1[1]);
        int r7 = (((RecyclerView.ViewHolder) this).itemView.getHeight() - r6) - Math.max(0, ((r1[1] + ((RecyclerView.ViewHolder) this).itemView.getHeight()) - r3[1]) - r5.getHeight());
        int r8 = ((RecyclerView.ViewHolder) this).itemView.getContext().getResources().getDimensionPixelSize(2131168571);
        View r9 = View.inflate(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131567150, null);
        final LottieAnimationView r10 = r9.findViewById(2131362943);
        ((LinearLayout.LayoutParams) r10.getLayoutParams()).topMargin = (int) (((((RecyclerView.ViewHolder) this).itemView.getHeight() / 2.0f) - (r8 / 2.0f)) - r6);
        final LivePopupWindow r11 = new LivePopupWindow(r9, ((RecyclerView.ViewHolder) this).itemView.getWidth(), r7, true);
        r9.setOnClickListener(new jw1.f(r11));
        T3(r11, ((RecyclerView.ViewHolder) this).itemView, r1[0], r1[1] + r6);
        r11.setOnDismissListener(new g(r10));
        r10.setAnimation("dislike_live_tips.json");
        r10.loop(true);
        r10.playAnimation();
        return;
    L20:
        return;
    }

    public String V3() {
        if (TTLiveService.getLiveService() != null) goto L7;
        return "drawer_null";
    L7:
        return TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    }

    public void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        X3(this.n, new HashMap());
    }

    public void X3(Room r21, Map<String, String> r22) {
        if (r21 != null) goto L5;
        return;
    L5:
        String r3 = "0";
        if (r21.getOwner() != null) goto L8;
        String r2 = "0";
    L9:
        HashMap r4 = new HashMap();
        r4.putAll(r22);
        j r5 = this.l;
        if (r5 == null) goto L12;
        List<e> r6 = r5.c();
    L14:
        if (r6 != null) goto L16;
    L20:
        String r7 = "live_merge_null";
    L22:
        if (this.i == false) goto L24;
        r4.put("enter_from_merge", V3());
    L25:
        FeedItem r8 = this.p;
        if (r8 == null) goto L31;
        int r9 = r8.contentCategory;
        int r10 = com.bytedance.android.live.base.model.c.a;
        if (r9 != 1) goto L31;
        r4.put("is_similar", "1");
    L31:
        if (this.i == false) goto L33;
        String r11 = "drawer_cover";
    L34:
        r4.put("enter_method", r11);
        r4.put("log_pb", r21.getLog_pb());
        r4.put("anchor_id", String.valueOf(r2));
        r4.put("request_id", r21.getRequestId());
        r4.put("room_id", String.valueOf(r21.getId()));
        r4.put("show_type", "stay");
        if (r21.isLiveTypeAudio() == false) goto L37;
        String r12 = "voice_live";
    L38:
        r4.put("live_type", r12);
        if (r21.isThirdParty() == false) goto L41;
        String r13 = "thirdparty";
    L42:
        r4.put("streaming_type", r13);
        r4.put("event_belong", "live_view");
        r4.put("event_page", "live");
        if (r21.isReplay == false) goto L45;
        Object r14 = "1";
    L46:
        r4.put("is_live_recall", r14);
        r4.put("event_type", "core");
        Map<String, String> r15 = this.k;
        String r16 = "";
        if (r15 != null) goto L49;
    L52:
        String r17 = "";
    L53:
        r4.put("pull_type", r17);
        r4.put("event_module", "live");
        r4.put("action_type", "click");
        r4.put("is_with_cover", "1");
        r4.put("is_with_title", "1");
        n0 r18 = u.l().c(x.class);
        if ((r18 instanceof n0) == false) goto L59;
        String r19 = r18.i;
        if (r19 == null) goto L59;
        r4.put("distribute_source", r19);
    L59:
        if (this.i == false) goto L62;
        r4.put("live_window_mode", "small_picture");
    L62:
        if (r21.getSceneTypeInfo() != null) goto L64;
    L66:
        r4.put("order", String.valueOf(this.o));
        FeedItem r20 = this.p;
        if (r20 == null) goto L72;
        if (r20.isRecommendCard == false) goto L72;
        r4.put("is_popcard", "1");
    L72:
        if (r21.isMediaRoom() == false) goto L74;
        String r23 = "media";
    L75:
        r4.put("room_layout", r23);
        if (r21.getAutoCover() != 0) goto L78;
    L82:
        FeedItem r24 = this.p;
        if (r24 != null) goto L85;
    L87:
        FeedItem r25 = this.p;
        if (r25 == null) goto L95;
        if (r25.getRoom() == null) goto L95;
        if (TextUtils.isEmpty(this.p.getRoom().getItemExplicitInfo()) == true) goto L95;
        r4.put("live_recommend_info", this.p.getRoom().getItemExplicitInfo());
    L95:
        if (r21.getOperationLabel() == null) goto L97;
        r4.put("sub_info", String.valueOf(r21.getOperationLabel().getImageType()));
    L97:
        String r26 = "landscape";
        if (e5.n() == false) goto L100;
        Object r27 = "landscape";
    L101:
        r4.put("screen_direction", r27);
        Map<String, String> r28 = this.k;
        if (r28 != null) goto L104;
    L107:
        String r29 = "";
    L108:
        r4.put("cover_content_category", r29);
        if (r21.getContentLabel() == null) goto L111;
        r4.put("drawer_room_icon_type", String.valueOf(r21.getContentLabel().getImageType()));
    L111:
        int r30 = kw1.c.a;
        kw1.c.c(r4, ((RecyclerView.ViewHolder) this).itemView.getContext());
        r4.putAll(h1.a(r21));
        HashMap r31 = new HashMap();
        if (r21.getLinkMicInfo() == null) goto L146;
        RoomLinkInfo r110 = r21.getLinkMicInfo();
        r31.put("channel_id", String.valueOf(r110.channelId));
        r31.put("anchor_connect_status", String.valueOf(r110.linkmicAnchorCount));
        r31.put("invite_mode", "connection");
        r31.put("pk_id", "0");
        LinkMicBattleSetting r111 = r110.battleSetting;
        if (r111 == null) goto L146;
        if (r111.finished == 1) goto L146;
        long r112 = r111.battleId;
        if (r112 <= 0) goto L146;
        r31.put("pk_id", String.valueOf(r112));
        long r113 = r111.playMode;
        long r114 = r111.teamMode;
        long r32 = r111.activityMode;
        if (r113 != LinkMicBattleSetting.BattlePlayMode_SelfPK) goto L124;
        String r33 = "customize_pk";
    L145:
        r31.put("invite_mode", r33);
        goto L146
    L124:
        if (r113 != LinkMicBattleSetting.BattlePlayMode_Vote) goto L127;
        r33 = "vote";
        goto L145
    L127:
        if (r113 != LinkMicBattleSetting.BattlePlayMode_Compete) goto L130;
        r33 = "compete";
        goto L145
    L130:
        if (r113 != LinkMicBattleSetting.BattlePlayMode_SpecifyGift) goto L133;
        r33 = "focus_gift";
        goto L145
    L133:
        if (r113 != LinkMicBattleSetting.BattlePlayMode_Breakthrough) goto L136;
        r33 = "cooperation";
        goto L145
    L136:
        if (r32 != LinkMicBattleSetting.ActivityMode_FlexActivity) goto L139;
        r33 = "activity_pk";
        goto L145
    L139:
        if (r32 != LinkMicBattleSetting.ActivityMode_PkSeason) goto L142;
        r33 = "pk_season";
        goto L145
    L142:
        if (r114 != LinkMicBattleSetting.TeamMode_Team) goto L144;
        r33 = "team_pk";
        goto L145
    L144:
        r33 = "routine_pk";
    L146:
        r4.putAll(r31);
        RoomContext r34 = RoomContext.getShared();
        if (r34 == null) goto L162;
        if (r34.isVSSpecialDrawer() == false) goto L162;
        LiveVSLog.r.getClass();
        LiveVSLog r35 = LiveVSLog.b.a(r21);
        r4.put("is_vs", "1");
        if (((Boolean) r34.isPortraitInteraction().getValue()).booleanValue() == false) goto L153;
        r26 = "portrait";
    L153:
        r4.put("vs_screen_type", r26);
        if (TTLiveService.getLiveService() == null) goto L156;
        r16 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L156:
        r4.put("drawer_page", r16);
        r4.putAll(r35.a());
        FeedItem r36 = this.p;
        if (r36 == null) goto L159;
        int r37 = r36.cameraType;
    L160:
        jw1.j.a(r21, r37, r4);
        m0.J(r4);
        kw1.c.d("livesdk_live_machine_show", r4);
        return;
    L159:
        r37 = 0;
    L162:
        if (r21.getEpisodeExtra() != null) goto L164;
    L166:
        m0.J(r4);
        if (r21.getOwner() != null) goto L169;
    L174:
        kw1.c.d("livesdk_live_show", r4);
        return;
    L169:
        if (r21.getOwner().getFollowInfo() == null) goto L174;
        if (r21.getOwner().isFollowing() == false) goto L173;
        r3 = "1";
    L173:
        r4.put("is_fans", r3);
        goto L174
    L164:
        if (r21.isMergeVSRoom() == true) goto L166;
        int r38 = ju2.f.M;
        ju2.f r1 = ju2.f.a.a(r21);
        r4.put("is_vs", "1");
        com.bytedance.android.livesdk.vs.f.c.c("live_show", r4, new Object[]{r1});
        r4.putAll(r1.b());
        return;
    L104:
        if (TextUtils.isEmpty(r28.get("cover_content_category")) == true) goto L107;
        r29 = this.k.get("cover_content_category");
        goto L108
    L100:
        r27 = "portrait";
        goto L101
    L85:
        if (TextUtils.isEmpty(r24.liveReason) == true) goto L87;
        r4.put("live_reason", this.p.liveReason);
        goto L87
    L78:
        if (r21.getAutoCover() != 1) goto L80;
        String r39 = "autocover";
    L81:
        r4.put("cover_type", r39);
        goto L82
    L80:
        r39 = "other";
        goto L81
    L74:
        r23 = "normal";
        goto L75
    L64:
        if (r21.getSceneTypeInfo().isUnionLiveRoom() != true) goto L66;
        r4.put("joint_anchor_id", String.valueOf(r2));
        r4.put("is_joint_room", "1");
        goto L66
    L49:
        if (TextUtils.isEmpty(r15.get("pull_type")) == true) goto L52;
        r17 = this.k.get("pull_type");
        goto L53
    L45:
        r14 = "0";
        goto L46
    L41:
        r13 = "general";
        goto L42
    L37:
        r12 = "video_live";
        goto L38
    L33:
        r11 = "live_cover";
        goto L34
    L24:
        r4.put("enter_from_merge", r7);
        goto L25
    L16:
        if (r6.size() <= 0) goto L20;
        if (TextUtils.isEmpty(((e) ListProtector.get(r6, 0)).e()) == true) goto L20;
        r7 = ((e) ListProtector.get(r6, 0)).e();
        goto L22
    L12:
        r6 = p.f().c();
        goto L14
    L8:
        r2 = r21.getOwner().getIdStr();
        goto L9
    }

    public final void bind(Object r3, int r4) {
        FeedItem r5 = (FeedItem) r3;
        h r0 = this.m;
        if (r0 == null) goto L5;
        e r1 = r0.wg();
    L6:
        this.h = r1;
        if (r5 != null) goto L9;
    L18:
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(null);
        this.n = null;
        return;
    L9:
        if ((r5.getItem() instanceof Room) == false) goto L18;
        this.p = r5;
        this.n = r5.getItem();
        this.o = r4;
        if (this.d == false) goto L14;
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(new a(this));
    L15:
        U3(r5, this.n, r4);
        PublishSubject<Boolean> r6 = this.g;
        if (r6 == null) goto L20;
        register(r6.subscribe(new b(this), new jw1.c()));
        return;
    L20:
        return;
    L14:
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(null);
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public static void T3(LivePopupWindow r8, View r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r9) == false) goto L6;
        return;
    L6:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r8) == false) goto L9;
        r8.showAtLocation(r9, 51, r10, r11);
        return;
    L9:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r9);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r8, r9, r0, 51, r10, r11) == false) goto L12;
        return;
    L12:
        r8.showAtLocation(r9, 51, r10, r11);
        PopupWindowLancet.trackAfterShow(r8, r0, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.os.Bundle, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10, types: [int] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v61 */
    public boolean Y3(FeedItem r31, boolean r32, String r33, Bundle r34) {
        if (r31 != null) goto L5;
        return false;
    L5:
        if ((r31.getItem() instanceof Room) == false) goto L347;
        Room r2 = r31.getItem();
        if (r2.isPullUrlValid() == true) goto L10;
        return false;
    L10:
        r2.setLog_pb(r31.logPb);
        r2.setRequestId(r31.resId);
        if ((r31.getItem() instanceof Room) == false) goto L20;
        if (r31.getItem().getAutoCover() == 0) goto L20;
        if (r31.getItem().getAutoCover() != 1) goto L17;
        String r3 = "autocover";
    L18:
        r34.putString("cover_type", r3);
        goto L20
    L17:
        r3 = "other";
    L20:
        if (r2.getOperationLabel() == null) goto L22;
        r34.putString("enter_room_operation_label", String.valueOf(r2.getOperationLabel().getImageType()));
    L22:
        Context r13 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        if (NetworkUtils.isNetworkAvailable(r13) == true) goto L26;
        IESUIUtils.displayToast(r13, 2131916613);
        return false;
    L26:
        ILiveRoomService r4 = k.f(ILiveRoomService.class);
        long r14 = System.currentTimeMillis();
        HashMap r8 = new HashMap();
        if (r4 == null) goto L29;
        r4.recordEnterStart(EntryType.FEED);
    L29:
        String r6 = "live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME";
        if (r32 == false) goto L101;
        iw1.c r7 = new iw1.c(this.c, this.b);
        long r5 = this.n.getId();
        int r9 = 0;
    L33:
        if (r9 >= ((ArrayList) r7.b).size()) goto L38;
        String r24 = r6;
        if (((Bundle) ListProtector.get(r7.b, r9)).getLong("live.intent.extra.ROOM_ID") == r5) goto L36;
        r9 = r9 + 1;
        r6 = r24;
        goto L33
    L36:
        int r10 = r9;
    L39:
        this.e.setCurrentRoomList(r7);
        String r12 = r24;
        Bundle r11 = LiveRoomIntentBuilder.buildMultiIntent(r13, r10, "live_cover", r33, 1, this.d, r34);
        if (r11 == null) goto L92;
        r11.putLong(r12, r34.getLong(r12));
        r8.put("time", String.valueOf(System.currentTimeMillis() - r14));
        r8.put("location", "before start activity");
        if (r31.getRoom().mVerticalTypeInfo == null) goto L47;
        if (r31.getRoom().mVerticalTypeInfo.tagId == null) goto L47;
        r11.putString("tag_id", String.valueOf(r31.getRoom().mVerticalTypeInfo.tagId));
    L47:
        if (r11.get("live.intent.extra.USER_ID") != null) goto L49;
        r11.putString("live.intent.extra.USER_ID", this.n.getOwnerUserIdString());
    L49:
        e r15 = this.h;
        if (r15 == null) goto L55;
        if (r15.a() == false) goto L55;
        r11.putString("double_stream_feed_url", this.c.a);
    L55:
        if (r31.isPseudoLiving == false) goto L57;
        boolean r16 = true;
        r11.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", true);
    L58:
        r11.putString("enter_from_user_id", this.n.getOwnerUserIdString());
        if (TextUtils.isEmpty(this.n.getMultiStreamData()) == false) goto L61;
    L63:
        String r17 = ResolutionManager.INSTANCE.getMultiStreamDefaultQualitySdkKey(this.n, false, false);
        if (TextUtils.isEmpty(r17) == false) goto L66;
    L68:
        int r18 = r31.contentCategory;
        int r19 = com.bytedance.android.live.base.model.c.a;
        if (r18 == r16) goto L71;
    L78:
        StreamUrlExtra.SrConfig r20 = this.n.getStreamSrConfig();
        if (r20 != null) goto L81;
    L83:
        r11.putInt("live.intent.extra.STREAM_TYPE", this.n.getStreamType().ordinal());
        ArgumentsBuilder.buildCustomizeAudioRoomArgs(this.n, r11);
        if (((o51) j2.a.getValue()).liveLogDeleteOpt == true) goto L87;
        kw1.c.d("feed_enter_room", r8);
    L87:
        if (TTLiveSDK.hostService() != null) goto L89;
    L91:
        Context r21 = r13;
    L94:
        if (this.d == false) goto L98;
        SharedPrefHelper r22 = SharedPrefHelper.b(r21);
        if (r22.i("hotsoon.pref.DISLIKE_TIPS_RECORD_TIME", 0) < 0) goto L98;
        r22.l("hotsoon.pref.DISLIKE_TIPS_RECORD_TIME", Long.valueOf(System.currentTimeMillis()));
        r22.a();
    L98:
        r8.put("time", String.valueOf(System.currentTimeMillis() - r14));
        r8.put("location", "after sp");
        if (((o51) j2.a.getValue()).liveLogDeleteOpt == true) goto L340;
        kw1.c.d("feed_enter_room", r8);
    L340:
        boolean r110 = true;
    L341:
        this.f.onNext(r31);
        return r110;
    L89:
        if (TTLiveSDK.hostService().action() == null) goto L91;
        r21 = r13;
        kw1.c.b(r21, r34);
        TTLiveSDK.hostService().action().startLive(r21, this.n.getId(), r11);
        goto L94
    L81:
        if (r31.isPseudoLiving == true) goto L83;
        r11.putBoolean("live.intent.extra.EXTRA_STREAM_SR_ENABLED", r20.getEnabled());
        r11.putBoolean("live.intent.extra.EXTRA_STREAM_SR_ANTI_ALIAS", r20.getAntiAlias());
        r11.putInt("live.intent.extra.EXTRA_STREAM_SR_STRENGTH", r20.getStrength());
        goto L83
    L71:
        if (p2.a.getValue().booleanValue() == false) goto L73;
        r11.putBoolean("open_merge_drawer", r16);
        r11.putString("aggregate_column_title", s1.B(2131922538));
    L73:
        r11.putString("isInnerFromDrawer", "true");
        Room r23 = k.f(IRoomService.class).getCurrentRoomFromRoomContext();
        if (r23 != null) goto L76;
        r23 = k.f(IRoomService.class).getCurrentRoom();
    L76:
        if (r23 == null) goto L78;
        r11.putLong("similar_room_id", r23.getId());
        goto L78
    L66:
        if (r31.isPseudoLiving == true) goto L68;
        r11.putString("live.intent.extra.PULL_DEFAULT_RESOLUTION", r17);
        goto L68
    L61:
        if (r31.isPseudoLiving == true) goto L63;
        yt2.a.g(r11, "live.intent.extra.PULL_STREAM_DATA", this.n.getMultiStreamData());
        goto L63
    L57:
        r16 = true;
        goto L58
    L92:
        r21 = r13;
        goto L94
    L38:
        r24 = r6;
        r10 = 0;
        goto L39
    L101:
        ?? r25 = LiveRoomIntentBuilder.buildBundle(r13, this.n, this.c.b, r34);
        if (r25 == 0) goto L340;
        if (TTLiveSDK.hostService() == null) goto L340;
        if (TTLiveSDK.hostService().action() == null) goto L340;
        r25.putBoolean("is_from_match_room", r34.getBoolean("is_from_match_room"));
        r25.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", r34.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME"));
        r25.putAll(ArgumentsBuilder.buildRoomArgs(this.n));
        if (r31.getRoom().mVerticalTypeInfo == null) goto L113;
        if (r31.getRoom().mVerticalTypeInfo.tagId == null) goto L113;
        r25.putString("tag_id", String.valueOf(r31.getRoom().mVerticalTypeInfo.tagId));
    L113:
        if (r25.get("live.intent.extra.USER_ID") != null) goto L115;
        r25.putString("live.intent.extra.USER_ID", this.n.getOwnerUserIdString());
    L115:
        r25.putString("enter_from_user_id", this.n.getOwnerUserIdString());
        int r26 = r31.contentCategory;
        int r27 = com.bytedance.android.live.base.model.c.a;
        if (r26 == 1) goto L118;
    L125:
        IVSCameraInfo r111 = null;
        if (this.j == false) goto L134;
        r25.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        r25.putBoolean("live.intent.extra.LIVE_FROM_DRAWER", true);
        r25.putString("enter_from_live_source", "live_square");
        r25.putString("live.intent.extra.WINDOW_MODE", "small_picture");
        r25.putString("live.intent.extra.FEED_URL", W3());
        e r28 = this.h;
        if (r28 == null) goto L131;
        r25.putInt("live.intent.extra.DRAWER_JUMP_FROM", r28.getType());
    L131:
        if (r34.keySet().contains("live.intent.extra.ENTER_ROOM_IDS") == false) goto L151;
        r25.putLongArray("live.intent.extra.ENTER_ROOM_IDS", r34.getLongArray("live.intent.extra.ENTER_ROOM_IDS"));
    L151:
        if (r31.isPseudoLiving == false) goto L153;
        r25.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", true);
    L153:
        ALogger.i("BaseLiveViewHolder", "is same room: " + jw1.j.b(this.n));
        if (jw1.j.b(this.n) == false) goto L232;
        Room r29 = this.n;
        Intrinsics.checkNotNullParameter("jump_source_square_drawer", "source");
        Integer r30 = Integer.valueOf(r31.cameraType);
        if (r30 != null) goto L159;
    L164:
        if (r30 != null) goto L167;
    L176:
        long r112 = 0;
    L177:
        Integer r35 = Integer.valueOf(r31.cameraType);
        if (r35 != null) goto L181;
    L183:
        if (r35 != null) goto L186;
    L200:
        IBaseStreamUrl r36 = null;
    L201:
        Integer r37 = Integer.valueOf(r31.cameraType);
        if (r37 != null) goto L204;
        r110 = true;
    L207:
        if (r37 != null) goto L210;
    L225:
        int r38 = 0;
    L227:
        if (dq1.b.a(r29) == false) goto L231;
        dq1.a r39 = pm1.f.a();
        if (r39 == null) goto L341;
        dq1.a.C0379a.a(r39, Long.valueOf(r112), r34, true, "jump_source_square_drawer", null, 16);
        goto L341
    L231:
        VSJumpCameraEvent r40 = new VSJumpCameraEvent();
        r40.setCameraId(r112);
        r40.setStreamUrl(r36);
        r40.setStyle(r38);
        r40.setExtra(r34);
        r40.setShouldPushBackStack(r110);
        r40.setBackSource("jump_source_square_drawer");
        ALogger.d("CameraExt", "is Same Room Jump: " + r40);
        xs2.b.a().post(r40);
        goto L341
    L210:
        if (r37.intValue() != 2) goto L225;
        if (r29 == null) goto L217;
        EpisodeExtraInfo r41 = r29.getEpisodeComponentData();
        if (r41 == null) goto L217;
        List r42 = r41.getCameraInfos();
        if (r42 == null) goto L217;
        IVSCameraInfo r43 = (IVSCameraInfo) CollectionsKt.firstOrNull(r42);
    L219:
        if ((r43 instanceof VSCameraInfo) == false) goto L222;
        r111 = r43;
    L222:
        VSCameraInfo r113 = (VSCameraInfo) r111;
        if (r113 == null) goto L225;
        r38 = v.a(r113);
    L217:
        r43 = null;
        goto L219
    L204:
        r110 = true;
        if (r37.intValue() != 1) goto L207;
    L186:
        if (r35.intValue() != 2) goto L200;
        if (r29 == null) goto L195;
        EpisodeExtraInfo r44 = r29.getEpisodeComponentData();
        if (r44 == null) goto L195;
        List r45 = r44.getCameraInfos();
        if (r45 == null) goto L195;
        IVSCameraInfo r46 = (IVSCameraInfo) CollectionsKt.firstOrNull(r45);
        if (r46 == null) goto L195;
        IBaseStreamUrl r47 = r46.getStreamUrl();
    L196:
        if (r47 == null) goto L199;
        r36 = (StreamUrl) r47;
        goto L201
    L199:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.StreamUrl");
    L195:
        r47 = null;
        goto L196
    L181:
        if (r35.intValue() != 1) goto L183;
    L167:
        if (r30.intValue() != 2) goto L176;
        if (r29 == null) goto L176;
        EpisodeExtraInfo r48 = r29.getEpisodeComponentData();
        if (r48 == null) goto L176;
        List r49 = r48.getCameraInfos();
        if (r49 == null) goto L176;
        IVSCameraInfo r50 = (IVSCameraInfo) CollectionsKt.firstOrNull(r49);
        if (r50 == null) goto L176;
        r112 = r50.getCameraId();
        goto L177
    L159:
        if (r30.intValue() != 1) goto L164;
        if (r29 == null) goto L176;
        EpisodeExtraInfo r51 = r29.getEpisodeComponentData();
        if (r51 == null) goto L176;
        r112 = r51.getDefaultCameraId();
        goto L177
    L232:
        r110 = true;
        Room r52 = this.n;
        Intrinsics.checkNotNullParameter(r25, "bundle");
        int r53 = r31.cameraType;
        if (r53 != 1) goto L261;
        if (r52 == null) goto L238;
        EpisodeExtraInfo r54 = r52.getEpisodeComponentData();
        if (r54 == null) goto L238;
        long r114 = r54.getDefaultCameraId();
    L239:
        r25.putLong("live.intent.extra.EXTRA_VS_CAMERA_ID", r114);
        if (r52 == null) goto L246;
        EpisodeExtraInfo r55 = r52.getEpisodeComponentData();
        if (r55 == null) goto L246;
        MainCameraMatchInfo r56 = r55.getMainCameraMatchInfo();
        if (r56 == null) goto L246;
        long r115 = r56.getMatchId();
    L247:
        r25.putLong("live.intent.extra.EXTRA_VS_MATCH_ID", r115);
        StringBuilder r57 = new StringBuilder("different room mainCamera, CameraId:");
        if (r52 == null) goto L252;
        EpisodeExtraInfo r58 = r52.getEpisodeComponentData();
        if (r58 == null) goto L252;
        Long r59 = Long.valueOf(r58.getDefaultCameraId());
    L253:
        r57.append(r59);
        r57.append(", matchId: ");
        if (r52 == null) goto L260;
        EpisodeExtraInfo r60 = r52.getEpisodeComponentData();
        if (r60 == null) goto L260;
        MainCameraMatchInfo r61 = r60.getMainCameraMatchInfo();
        if (r61 == null) goto L260;
        r111 = Long.valueOf(r61.getMatchId());
    L260:
        r57.append(r111);
        ALogger.d("CameraExt", r57.toString());
    L301:
        r25.putString("extra_live_new_room_back_source", "jump_source_square_drawer");
        kw1.c.b(r13, r34);
        Room r62 = this.n;
        RoomContext r63 = RoomContext.getShared();
        if (PadConfigUtils.c() == true) goto L335;
        if (r63 == null) goto L335;
        if (r62 == null) goto L335;
        if (com.bytedance.android.livesdk.utils.landscape.b.a() == false) goto L308;
    L313:
        LandscapeLiveMonitor.setCurRoomInfo(new Pair(Long.valueOf(r62.getId()), LandscapeScene.JUMP));
        if (com.bytedance.android.livesdk.utils.landscape.b.a() == false) goto L317;
        r25.putBoolean("live.intent.extra.is_game_live", d1.a(r62));
    L317:
        if (r63.isVSSpecialDrawer() == false) goto L332;
        StreamUrl r64 = r62.getStreamUrl();
        if ((((RecyclerView.ViewHolder) this).itemView.getContext() instanceof Activity) == true) goto L321;
    L323:
        int r116 = 0;
    L325:
        if (((Boolean) r63.isPortraitInteraction().getValue()).booleanValue() == true) goto L331;
        if (r64 == null) goto L331;
        if (r64.getStreamOrientation() != 2) goto L331;
        ?? r65 = r116;
    L333:
        r25.putInt("live.intent.extra.SCREEN_ORIENTATION", r65);
    L331:
        r65 = 1;
        goto L333
    L321:
        if (oj1.a.getValue().h() == false) goto L323;
        r116 = ((Activity) ((RecyclerView.ViewHolder) this).itemView.getContext()).getRequestedOrientation();
        goto L325
    L332:
        r65 = ((Boolean) r63.isPortraitInteraction().getValue()).booleanValue();
        goto L333
    L308:
        if (r63.isVSRoom() == false) goto L335;
        if (r63.isVSSpecialDrawer() == false) goto L335;
        if (oj1.a.getValue().b() == true) goto L313;
    L335:
        if (ap0.a.getValue().booleanValue() == true) goto L337;
    L339:
        TTLiveSDK.hostService().action().startLive(r13, this.n.getId(), r25);
        goto L341
    L337:
        if (k.f(IMiddlewareRoomService.class) == null) goto L339;
        HashSet r66 = new HashSet();
        r66.add(LiveEntranceTag.TAG_DRAWER_IN_ROOM);
        k.f(IMiddlewareRoomService.class).configRoomParamsProducer(this.n, r66, r25);
    L252:
        r59 = null;
    L246:
        r115 = 0;
    L238:
        r114 = 0;
        goto L239
    L261:
        if (r53 != 2) goto L301;
        if (r52 == null) goto L270;
        EpisodeExtraInfo r67 = r52.getEpisodeComponentData();
        if (r67 == null) goto L270;
        List r68 = r67.getCameraInfos();
        if (r68 == null) goto L270;
        IVSCameraInfo r69 = (IVSCameraInfo) CollectionsKt.firstOrNull(r68);
        if (r69 == null) goto L270;
        long r117 = r69.getCameraId();
    L271:
        r25.putLong("live.intent.extra.EXTRA_VS_CAMERA_ID", r117);
        if (r52 == null) goto L280;
        EpisodeExtraInfo r70 = r52.getEpisodeComponentData();
        if (r70 == null) goto L280;
        List r71 = r70.getCameraInfos();
        if (r71 == null) goto L280;
        IVSCameraInfo r72 = (IVSCameraInfo) CollectionsKt.firstOrNull(r71);
        if (r72 == null) goto L280;
        long r118 = r72.getMatchId();
    L281:
        r25.putLong("live.intent.extra.EXTRA_VS_MATCH_ID", r118);
        StringBuilder r73 = new StringBuilder("different room SubCamera, CameraId:");
        if (r52 == null) goto L290;
        EpisodeExtraInfo r75 = r52.getEpisodeComponentData();
        if (r75 == null) goto L290;
        List r76 = r75.getCameraInfos();
        if (r76 == null) goto L290;
        IVSCameraInfo r77 = (IVSCameraInfo) CollectionsKt.firstOrNull(r76);
        if (r77 == null) goto L290;
        Long r78 = Long.valueOf(r77.getCameraId());
    L291:
        r73.append(r78);
        r73.append(", matchId: ");
        if (r52 == null) goto L300;
        EpisodeExtraInfo r79 = r52.getEpisodeComponentData();
        if (r79 == null) goto L300;
        List r80 = r79.getCameraInfos();
        if (r80 == null) goto L300;
        IVSCameraInfo r81 = (IVSCameraInfo) CollectionsKt.firstOrNull(r80);
        if (r81 == null) goto L300;
        r111 = Long.valueOf(r81.getMatchId());
    L300:
        r73.append(r111);
        ALogger.d("CameraExt", r73.toString());
    L290:
        r78 = null;
    L280:
        r118 = 0;
    L270:
        r117 = 0;
        goto L271
    L134:
        if (this.i == false) goto L151;
        r25.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        r25.putBoolean("live.intent.extra.LIVE_FROM_DRAWER", true);
        r25.putString("enter_from_live_source", "live_square");
        r25.putString("live.intent.extra.WINDOW_MODE", "small_picture");
        e r82 = this.h;
        if (r82 == null) goto L139;
        r25.putInt("live.intent.extra.DRAWER_JUMP_FROM", r82.getType());
    L139:
        if (TTLiveService.getLiveService() == null) goto L141;
        String r83 = TTLiveService.getLiveService().getLiveOntologyRecord().getInnerUrl();
    L143:
        if (TextUtils.isEmpty(r83) == false) goto L149;
        List<e> r84 = p.f().c();
        if (Lists.isEmpty(r84) == true) goto L151;
        if (ListProtector.get(r84, 0) == null) goto L151;
        r25.putString("live.intent.extra.FEED_URL", ((e) ListProtector.get(r84, 0)).n());
        goto L151
    L149:
        r25.putString("live.intent.extra.FEED_URL", r83);
        goto L151
    L141:
        r83 = null;
        goto L143
    L118:
        if (p2.a.getValue().booleanValue() == false) goto L120;
        r25.putBoolean("open_merge_drawer", true);
        r25.putString("aggregate_column_title", s1.B(2131922538));
    L120:
        r25.putString("isInnerFromDrawer", "true");
        Room r85 = k.f(IRoomService.class).getCurrentRoomFromRoomContext();
        if (r85 != null) goto L123;
        r85 = k.f(IRoomService.class).getCurrentRoom();
    L123:
        if (r85 == null) goto L125;
        r25.putLong("similar_room_id", r85.getId());
        goto L125
    L347:
        return false;
    }

    public BaseLiveViewHolder(View r1, c r2, f r3, FeedDataKey r4, j r5, ILiveRoomListDataSource r6, PublishSubject r7, PublishSubject r8, h r9) {
        super(r1);
        this.n = null;
        this.p = null;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if (r4 == null) goto L8;
        if (r5 == null) goto L8;
        if (r5.b(r4.c) == false) goto L8;
        boolean r10 = true;
    L9:
        this.d = r10;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.m = r9;
        this.l = r5;
        return;
    L8:
        r10 = false;
        goto L9
    }
}
