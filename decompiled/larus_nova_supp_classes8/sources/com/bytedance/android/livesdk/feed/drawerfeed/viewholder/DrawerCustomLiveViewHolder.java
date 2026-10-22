package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerUIManager;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.widget.LiveSportScoreBoardView;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.MatchData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MainCameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.PublishSubject;
import j40.b4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerCustomLiveViewHolder;", "Lcom/bytedance/android/livesdk/feed/live/BaseLiveViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerCustomLiveViewHolder extends BaseLiveViewHolder {
    public static final /* synthetic */ int A = 0;
    public final LiveSportScoreBoardView r;
    public final TextView s;
    public final HSImageView t;
    public final HSImageView u;
    public k v;
    public int w;
    public final ViewGroup x;
    public final IFeedActionCallback y;
    public final IDrawerUIManager z;

    public static final class a implements Runnable {
        public final /* synthetic */ DrawerCustomLiveViewHolder a;

        public a(DrawerCustomLiveViewHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((RecyclerView.ViewHolder) this.a).itemView.setTag(2131389800, Unit.INSTANCE);     // Catch: Throwable -> L4
            DrawerCustomLiveViewHolder r0 = this.a;     // Catch: Throwable -> L4
            int r1 = ((RecyclerView.ViewHolder) r0).itemView.getMeasuredWidth() - s1.f(6.0f);     // Catch: Throwable -> L4
            int r2 = DrawerCustomLiveViewHolder.A;     // Catch: Throwable -> L4
            r0.c4(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DrawerCustomLiveViewHolder a;
        public final /* synthetic */ FeedItem b;
        public final /* synthetic */ Room c;

        public b(DrawerCustomLiveViewHolder r1, FeedItem r2, Room r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r15) {
            DrawerCustomLiveViewHolder r16 = this.a;
            FeedItem r0 = this.b;
            Room r1 = this.c;
            int r2 = DrawerCustomLiveViewHolder.A;
            r16.getClass();
            if (r0 != null) goto L5;
        L12:
            Bundle r3 = new Bundle();
            r3.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", System.currentTimeMillis());
            String r4 = r16.c.b;
            if (StringsKt.contains$default(r4, "live", false, 2, null) == false) goto L17;
            com.bytedance.android.livesdk.feed.feed.e r5 = r16.h;
            if (r5 == null) goto L17;
            r4 = r5.e();
        L17:
            r3.putString("source", r4);
            Bundle r6 = new Bundle();
            LinkedHashMap r7 = new LinkedHashMap();
            r6.putString("live_source", "live_small_picture");
            r6.putString("subtab", r4);
            Map<String, String> r8 = r16.k;
            String r9 = "";
            if (r8 != null) goto L20;
        L23:
            String r10 = "";
        L24:
            r6.putString("pull_type", r10);
            r6.putString("enter_from_game", "drawer_game");
            jw1.j.a(r1, r0.cameraType, r7);
            LinkedHashMap r11 = new LinkedHashMap();
            Iterator r12 = r7.entrySet().iterator();
        L26:
            if (r12.hasNext() == false) goto L30;
            Map.Entry r13 = (Map.Entry) r12.next();
            if (ArraysKt.contains(new String[]{"is_game_data", "is_tag"}, (String) r13.getKey()) == false) goto L26;
            r11.put(r13.getKey(), r13.getValue());
            goto L26
        L30:
            Iterator r14 = r11.entrySet().iterator();
        L32:
            if (r14.hasNext() == false) goto L34;
            Map.Entry r17 = (Map.Entry) r14.next();
            r6.putString((String) r17.getKey(), (String) r17.getValue());
            goto L32
        L34:
            r3.putBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1", r6);
            r3.putString("log_pb", r0.logPb);
            r3.putString("request_id", r0.resId);
            r3.putInt(VSConstants.EXTRA_ITEM_TYPE, ArgumentsBuilder.getRoomType(r1));
            r3.putString("enter_from", "live");
            com.bytedance.android.livesdk.feed.feed.e r18 = r16.h;
            if (r18 == null) goto L37;
            r3.putLong("live.intent.extra.USER_FROM", r18.l());
        L37:
            r3.putString("enter_from_merge", "drawer_game");
            r3.putString("enter_method", "drawer_cover");
            r3.putBoolean("is_from_match_room", true);
            r3.putInt("live.intent.extra.ENTER_LIVE_ORDER", r16.o);
            if (r0.isRecommendCard == false) goto L41;
            r3.putString("enter_from_merge_recommend", "pop_card");
        L41:
            if (TextUtils.isEmpty(r0.liveReason) == true) goto L44;
            r3.putString("live_reason", r0.liveReason);
        L44:
            if (r0.getRoom() != null) goto L46;
        L48:
            ILiveService r19 = TTLiveService.getLiveService();
            if (r19 == null) goto L54;
            ILiveOntologyInfoManager r20 = r19.getLiveOntologyRecord();
            if (r20 == null) goto L54;
            String r21 = r20.getEnterFromMerge();
            if (r21 == null) goto L54;
        L55:
            r3.putString("drawer_page", r21);
            r3.putString("drawer_inner_req_from", "");
            r3.putBoolean("disable_inner_drawer", true);
            com.bytedance.android.livesdk.log.filter.o r22 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
            if (r22.getMap().containsKey("action_type") == false) goto L61;
            String r23 = (String) r22.getMap().get("action_type");
            if (r23 == null) goto L61;
            r9 = r23;
        L61:
            LiveVSLog.r.getClass();
            LiveVSLog r24 = LiveVSLog.b.a(r1);
            HashMap r110 = new HashMap();
            r110.put("enter_from_merge", "drawer_game");
            r110.put("enter_method", "drawer_cover");
            r110.put("action_type", r9);
            r110.put("event_page", "live_cover");
            r110.putAll(DrawerCustomLiveViewHolder.b4());
            r110.putAll(r24.a());
            jw1.j.a(r1, r0.cameraType, r110);
            com.bytedance.android.livesdk.log.filter.m0.J(r110);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_machine_click", r110, new Object[]{Room.class});
            r16.Y3(r0, false, "small_picture", r3);
            return;
        L54:
            r21 = "";
            goto L55
        L46:
            if (TextUtils.isEmpty(r0.getRoom().getItemExplicitInfo()) == true) goto L48;
            r3.putString("live_recommend_info", r0.getRoom().getItemExplicitInfo());
            goto L48
        L20:
            if (TextUtils.isEmpty(r8.get("pull_type")) == true) goto L23;
            r10 = r16.k.get("pull_type");
            goto L24
        L5:
            if (r0.getRoom() == null) goto L12;
            Map r25 = DrawerCustomLiveViewHolder.b4();
            com.bytedance.android.livesdk.log.filter.o r26 = com.bytedance.android.livesdk.log.u.l().c(am2.o.class);
            if (r26 == null) goto L12;
            if (r26.getMap() == null) goto L12;
            r26.getMap().putAll(r25);
            am2.o r27 = new am2.o();
            r27.a = r0.getRoom().id;
            r26.setData(r27);
            goto L12
        }
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final String V3() {
        return "drawer_game";
    }

    public static Map b4() {
        HashMap r0 = new HashMap();
        ILiveService r1 = TTLiveService.getLiveService();
        if (r1 == null) goto L8;
        ILiveOntologyInfoManager r2 = r1.getLiveOntologyRecord();
        if (r2 == null) goto L8;
        String r3 = r2.getEnterFromMerge();
        if (r3 == null) goto L8;
    L9:
        r0.put("drawer_page", r3);
        return r0;
    L8:
        r3 = "";
        goto L9
    }

    public final void a4() {
        IDrawerUIManager r0 = this.z;
        if (r0 == null) goto L6;
        c4(((r0.panelSize() - s1.f(14.0f)) - s1.f(12.0f)) / 2);
        return;
    L6:
        if (((RecyclerView.ViewHolder) this).itemView.getTag(2131389800) != null) goto L10;
        ((RecyclerView.ViewHolder) this).itemView.post(new a(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        IFeedActionCallback r0 = this.y;
        if (r0 == null) goto L6;
        r0.WS(IFeedActionCallback.FeedAction.FIRST_CARD_SHOWN, Unit.INSTANCE);
        return;
    }

    public final void unbind() {
        super.unbind();
        k r0 = this.v;
        if (r0 == null) goto L7;
        ViewGroup r1 = this.x;
        if (r1 == null) goto L7;
        r1.removeOnLayoutChangeListener(r0);
    L7:
        this.v = null;
    }

    public final void c4(int r5) {
        if (r5 != this.w) goto L5;
        return;
    L5:
        this.w = r5;
        HSImageView r0 = this.t;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if (r1 == null) goto L8;
        r1.height = r5;
        r1.width = r5;
        Unit r3 = Unit.INSTANCE;
    L9:
        r0.setLayoutParams(r1);
        LiveSportScoreBoardView r4 = this.r;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if (r6 == null) goto L12;
        r6.height = r5;
        r6.width = r5;
        Unit r7 = Unit.INSTANCE;
    L13:
        r4.setLayoutParams(r6);
        TextView r8 = this.s;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L16;
        r9.width = r5;
        Unit r10 = Unit.INSTANCE;
        r2 = r9;
    L16:
        r8.setLayoutParams(r2);
        return;
    L12:
        r6 = null;
        goto L13
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void U3(FeedItem r12, Room r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "feedItem");
        Intrinsics.checkNotNullParameter(r13, "room");
        a4();
        if (b4.a() == false) goto L7;
        k r15 = new k(this);
        this.v = r15;
        ViewGroup r0 = this.x;
        if (r0 == null) goto L7;
        r0.addOnLayoutChangeListener(r15);
    L7:
        int r16 = r12.type;
        Object r1 = null;
        if (r16 != 1) goto L10;
        String r17 = r13.getTitle();
    L29:
        if (TextUtils.isEmpty(r17) == false) goto L31;
        r17 = r13.getTitle();
    L31:
        this.s.setText(r17);
        r13.getOwner();
        int r18 = r12.type;
        if (r18 != 1) goto L34;
        py.k r19 = r13.getCover();
    L48:
        if (r19 != null) goto L51;
        r19 = r13.getCover();
    L51:
        if (r19 != null) goto L53;
    L58:
        a1.m(this.t, 2131250288);
    L59:
        int r110 = r12.type;
        if (r110 == 1) goto L77;
        if (r110 != 27) goto L77;
        if (r12.cameraType != 1) goto L70;
        EpisodeExtraInfo r111 = r13.getEpisodeExtra2();
        if (r111 == null) goto L77;
        VSConfigDrawer r112 = r111.getVsConfigDrawer();
        if (r112 == null) goto L77;
        py.k r113 = r112.drawerLabel;
    L79:
        if (r113 == null) goto L81;
        UIUtils.setViewVisibility(this.u, 0);
        HSImageView r5 = this.u;
        ImageLoader.bindImageWithAnimation(r5, r113, new l(r5), r113.isAnimated());
    L83:
        if (r12.cameraType != 1) goto L252;
        Integer[] r114 = {0, 1};
        EpisodeExtraInfo r6 = r13.getEpisodeComponentData();
        if (r6 == null) goto L91;
        MainCameraMatchInfo r7 = r6.getMainCameraMatchInfo();
        if (r7 == null) goto L91;
        MatchData r8 = r7.getMatchData();
        if (r8 == null) goto L91;
        Integer r9 = Integer.valueOf(r8.getMatchStatus());
    L93:
        if (ArraysKt.contains(r114, r9) == false) goto L252;
        this.r.setVisibility(0);
        LiveSportScoreBoardView r115 = this.r;
        EpisodeExtraInfo r10 = r13.getEpisodeComponentData();
        if (r10 == null) goto L99;
        MainCameraMatchInfo r11 = r10.getMainCameraMatchInfo();
        if (r11 == null) goto L99;
        MatchData r20 = r11.getMatchData();
    L100:
        EpisodeExtraInfo r21 = r13.getEpisodeExtra2();
        if (r21 == null) goto L105;
        VSConfigDrawer r22 = r21.getVsConfigDrawer();
        if (r22 == null) goto L105;
        py.k r23 = r22.drawerBackground;
    L106:
        r115.getClass();
        if (r20 == null) goto L111;
        IAgainst r24 = r20.getAgainst();
        if (r24 == null) goto L111;
        String r25 = r24.getLeftGoal();
    L112:
        if (r20 == null) goto L116;
        IAgainst r26 = r20.getAgainst();
        if (r26 == null) goto L116;
        String r27 = r26.getRightGoal();
    L118:
        if (r25 != null) goto L120;
    L121:
        if (r27 == null) goto L125;
        if (new Regex("\\d{2}\\(.*\\)").matches(r27) != true) goto L125;
    L131:
        TextView r28 = r115.d;
        if (r28 == null) goto L134;
        r28.setTextSize(10.0f);
    L134:
        TextView r29 = r115.e;
        if (r29 == null) goto L156;
        r29.setTextSize(10.0f);
    L156:
        TextView r30 = r115.d;
        String r31 = "/";
        if (r30 == null) goto L166;
        if (r20 == null) goto L164;
        IAgainst r32 = r20.getAgainst();
        if (r32 == null) goto L164;
        String r33 = r32.getLeftGoal();
        if (r33 == null) goto L164;
    L165:
        r30.setText(r33);
    L164:
        r33 = "/";
    L166:
        TextView r34 = r115.e;
        if (r34 == null) goto L176;
        if (r20 == null) goto L174;
        IAgainst r35 = r20.getAgainst();
        if (r35 == null) goto L174;
        String r36 = r35.getRightGoal();
        if (r36 == null) goto L174;
    L175:
        r34.setText(r36);
    L174:
        r36 = "/";
    L176:
        TextView r37 = r115.b;
        if (r37 == null) goto L186;
        if (r20 == null) goto L184;
        IAgainst r38 = r20.getAgainst();
        if (r38 == null) goto L184;
        String r39 = r38.getLeftName();
        if (r39 == null) goto L184;
    L185:
        r37.setText(r39);
    L184:
        r39 = "/";
    L186:
        TextView r40 = r115.c;
        if (r40 == null) goto L195;
        if (r20 == null) goto L194;
        IAgainst r41 = r20.getAgainst();
        if (r41 == null) goto L194;
        String r42 = r41.getRightName();
        if (r42 == null) goto L194;
        r31 = r42;
    L194:
        r40.setText(r31);
    L195:
        TextView r43 = r115.f;
        if (r43 == null) goto L206;
        StringBuilder r44 = new StringBuilder();
        if (r20 == null) goto L200;
        String r45 = r20.getMatchGroup();
    L201:
        r44.append(r45);
        r44.append(' ');
        if (r20 == null) goto L204;
        String r46 = r20.getMatchRound();
    L205:
        r44.append(r46);
        r43.setText(r44.toString());
        goto L206
    L204:
        r46 = null;
        goto L205
    L200:
        r45 = null;
    L206:
        if (r20 == null) goto L221;
        IAgainst r47 = r20.getAgainst();
        if (r47 == null) goto L221;
        py.k r48 = r47.getLeftLogo();
        if (r48 == null) goto L221;
        HSImageView r49 = r115.g;
        if (r49 == null) goto L214;
        Object r50 = r49.getTag(2131389795);
    L216:
        if ((!Intrinsics.areEqual(r50, r48.getUri())) == false) goto L221;
        HSImageView r51 = r115.g;
        if (r51 == null) goto L220;
        r51.setTag(2131389795, r48.getUri());
    L220:
        ImageUtil.loadImageWithRadius(r115.g, r48, 0, 0);
        goto L221
    L214:
        r50 = null;
    L221:
        if (r20 == null) goto L236;
        IAgainst r52 = r20.getAgainst();
        if (r52 == null) goto L236;
        py.k r53 = r52.getRightLogo();
        if (r53 == null) goto L236;
        HSImageView r54 = r115.h;
        if (r54 == null) goto L229;
        Object r55 = r54.getTag(2131389795);
    L231:
        if ((!Intrinsics.areEqual(r55, r53.getUri())) == false) goto L236;
        HSImageView r56 = r115.h;
        if (r56 == null) goto L235;
        r56.setTag(2131389795, r53.getUri());
    L235:
        ImageUtil.loadImageWithRadius(r115.h, r53, 0, 0);
        goto L236
    L229:
        r55 = null;
    L236:
        HSImageView r57 = r115.a;
        if (r57 == null) goto L239;
        r57.setVisibility(8);
    L239:
        if (r23 == null) goto L253;
        HSImageView r4 = r115.a;
        if (r4 == null) goto L243;
        r4.setVisibility(0);
    L243:
        HSImageView r58 = r115.a;
        if (r58 == null) goto L247;
        r1 = r58.getTag(2131389795);
    L247:
        if ((!Intrinsics.areEqual(r1, r23.getUri())) == false) goto L253;
        HSImageView r2 = r115.a;
        if (r2 == null) goto L251;
        r2.setTag(2131389795, r23.getUri());
    L251:
        ImageUtil.loadImage(r115.a, r23, 0);
    L253:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new b(this, r12, r13));
        return;
    L125:
        if (r25 != null) goto L127;
    L128:
        if (r27 == null) goto L138;
        if (new Regex(".*\\(\\d{2}\\).*").matches(r27) == true) goto L131;
    L138:
        if (r25 != null) goto L140;
    L141:
        if (r27 != null) goto L143;
    L150:
        TextView r59 = r115.d;
        if (r59 == null) goto L153;
        r59.setTextSize(17.0f);
    L153:
        TextView r60 = r115.e;
        if (r60 == null) goto L156;
        r60.setTextSize(17.0f);
        goto L156
    L143:
        if (new Regex(".*\\(.*\\)").matches(r27) != true) goto L150;
    L144:
        TextView r61 = r115.d;
        if (r61 == null) goto L147;
        r61.setTextSize(14.0f);
    L147:
        TextView r62 = r115.e;
        if (r62 == null) goto L156;
        r62.setTextSize(14.0f);
        goto L156
    L140:
        if (new Regex(".*\\(.*\\)").matches(r25) == true) goto L144;
    L127:
        if (new Regex(".*\\(\\d{2}\\).*").matches(r25) == true) goto L131;
    L120:
        if (new Regex("\\d{2}\\(.*\\)").matches(r25) == true) goto L131;
    L116:
        r27 = null;
    L111:
        r25 = null;
    L105:
        r23 = null;
    L99:
        r20 = null;
    L91:
        r9 = null;
    L252:
        this.r.setVisibility(8);
        goto L253
    L81:
        UIUtils.setViewVisibility(this.u, 8);
        goto L83
    L70:
        EpisodeExtraInfo r116 = r13.getEpisodeComponentData();
        if (r116 == null) goto L77;
        List r117 = r116.getCameraInfos();
        if (r117 == null) goto L77;
        IVSCameraInfo r118 = (IVSCameraInfo) CollectionsKt.firstOrNull(r117);
        if (r118 == null) goto L77;
        r113 = r118.getLabel();
    L77:
        r113 = null;
        goto L79
    L53:
        if (Lists.isEmpty(r19.getUrls()) == true) goto L58;
        if ((!Intrinsics.areEqual(this.t.getTag(2131389795), r19.getUri())) == false) goto L59;
        this.t.setTag(2131389795, r19.getUri());
        ImageUtil.loadImage(this.t, r19, 2131250570);
        goto L59
    L34:
        if (r18 == 27) goto L36;
    L47:
        r19 = null;
        goto L48
    L36:
        if (r12.cameraType != 1) goto L40;
        EpisodeExtraInfo r119 = r13.getEpisodeComponentData();
        if (r119 == null) goto L47;
        r19 = r119.getMainCameraCover();
        goto L48
    L40:
        EpisodeExtraInfo r120 = r13.getEpisodeComponentData();
        if (r120 == null) goto L47;
        List r121 = r120.getCameraInfos();
        if (r121 == null) goto L47;
        IVSCameraInfo r122 = (IVSCameraInfo) CollectionsKt.firstOrNull(r121);
        if (r122 == null) goto L47;
        r19 = r122.getCover();
        goto L48
    L10:
        if (r16 == 27) goto L12;
    L27:
        r17 = null;
        goto L29
    L12:
        if (r12.cameraType != 1) goto L20;
        EpisodeExtraInfo r123 = r13.getEpisodeComponentData();
        if (r123 == null) goto L17;
        r17 = r123.getMainCameraTitle();
        if (r17 != null) goto L29;
    L17:
        EpisodeExtraInfo r124 = r13.getEpisodeComponentData();
        if (r124 == null) goto L27;
        r17 = r124.getTitle();
        goto L29
    L20:
        EpisodeExtraInfo r125 = r13.getEpisodeComponentData();
        if (r125 == null) goto L27;
        List r126 = r125.getCameraInfos();
        if (r126 == null) goto L27;
        IVSCameraInfo r127 = (IVSCameraInfo) CollectionsKt.firstOrNull(r126);
        if (r127 == null) goto L27;
        r17 = r127.getTitle();
        goto L29
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final boolean Y3(FeedItem r1, boolean r2, String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r1, "feedItem");
        Intrinsics.checkNotNullParameter("small_picture", "feedStyle");
        Intrinsics.checkNotNullParameter(r4, "enterExtra");
        boolean r5 = super.Y3(r1, false, "small_picture", r4);
        if (r5 == false) goto L5;
        xs2.b.a().post(new uv1.e(0));
    L5:
        return r5;
    }

    public DrawerCustomLiveViewHolder(View r13, tv1.c r14, com.bytedance.android.livesdk.feed.f r15, FeedDataKey r16, com.bytedance.android.livesdk.feed.j r17, ILiveRoomListDataSource r18, PublishSubject r19, PublishSubject r20, ViewGroup r21, Map r22, com.bytedance.android.livesdk.feed.h r23, IFeedActionCallback r24, IDrawerUIManager r25) {
        Intrinsics.checkNotNullParameter(r13, "itemView");
        super(r13, r14, r15, r16, r17, r18, r19, r20, r23);
        this.x = r21;
        this.y = r24;
        this.z = r25;
        this.r = r13.findViewById(2131378458);
        this.s = (TextView) r13.findViewById(2131378489);
        this.t = r13.findViewById(2131378264);
        this.u = r13.findViewById(2131378326);
        this.k = r22;
        this.i = true;
    }
}
