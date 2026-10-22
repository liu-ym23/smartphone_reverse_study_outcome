package com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder;

import am2.x;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bw1.e;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.c;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleDrawFeedAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import com.bytedance.android.livesdk.log.filter.m0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import df6.q;
import df6.r;
import dw1.b;
import java.util.HashMap;
import java.util.List;
import ju2.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/RoomSingleDrawViewHolder;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/AbsSingleDrawViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomSingleDrawViewHolder extends AbsSingleDrawViewHolder {
    public final SmartImageView j;
    public final FrameLayout k;
    public final LottieAnimationView l;
    public final TextView m;
    public final TextView n;
    public boolean o;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ RoomSingleDrawViewHolder a;

        public a(RoomSingleDrawViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            RoomSingleDrawViewHolder r5 = this.a;
            UtilityKotlinExtentionsKt.w(r5.l);
            UtilityKotlinExtentionsKt.w(r5.k);
            r5.l.playAnimation();
            r5.o = true;
            r5.h.smoothScrollToPosition(r5.getAdapterPosition());
            SingleDrawViewModel r0 = r5.g.c;
            if (r0 == null) goto L11;
            NextLiveData r1 = r0.getOnRoomSelect();
            if (r1 == null) goto L11;
            Room r2 = r5.c;
            if (r2 == null) goto L9;
            Long r3 = Long.valueOf(r2.id);
        L10:
            r1.setValue(r3);
            goto L11
        L9:
            r3 = null;
        L11:
            TabListModel r6 = r5.i;
            if (r6 == null) goto L14;
            r6.setChosenTab(r6.getCurrentTabModel());
        L14:
            r5.V3();
        }
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder
    public final void X3() {
        Room r1 = this.c;
        if (r1 == null) goto L209;
        User r2 = r1.getOwner();
        if (r2 == null) goto L8;
        String r3 = r2.getIdStr();
        if (r3 == null) goto L8;
    L9:
        TabListModel r4 = this.i;
        if (r4 == null) goto L12;
        e r5 = r4.getCurrentTabModel();
    L13:
        TabListModel r6 = this.i;
        if (r6 == null) goto L16;
        boolean r7 = r6.isMultiTab();
    L17:
        TabListModel r8 = this.i;
        if (r8 == null) goto L20;
        List<com.bytedance.android.livesdk.feed.feed.e> r9 = r8.getTabList();
    L21:
        if (r9 != null) goto L23;
    L27:
        String r10 = "live_merge_null";
    L28:
        HashMap r11 = new HashMap();
        String r12 = "";
        if (r7 == false) goto L35;
        if (r5 == null) goto L33;
        String r13 = r5.b();
        if (r13 == null) goto L33;
    L34:
        r11.put("enter_from_merge", r13);
    L36:
        FeedItem r14 = this.d;
        String r15 = "1";
        if (r14 == null) goto L42;
        int r16 = r14.contentCategory;
        int r17 = c.a;
        if (r16 != 1) goto L42;
        r11.put("is_similar", "1");
    L42:
        if (r5 == null) goto L44;
        r5.c();
        Object r18 = "drawer_cover";
    L45:
        r11.put("enter_method", r18);
        r11.put("log_pb", r1.getLog_pb());
        r11.put("anchor_id", r3);
        r11.put("request_id", r1.getRequestId());
        boolean r19 = r7;
        r11.put("room_id", String.valueOf(r1.id));
        r11.put("show_type", "stay");
        if (r1.isLiveTypeAudio() == false) goto L48;
        String r20 = "voice_live";
    L49:
        r11.put("live_type", r20);
        if (r1.isThirdParty() == false) goto L52;
        String r21 = "thirdparty";
    L53:
        r11.put("streaming_type", r21);
        r11.put("event_belong", "live_view");
        r11.put("event_page", "live");
        if (r1.isReplay == false) goto L56;
        Object r22 = "1";
    L57:
        r11.put("is_live_recall", r22);
        r11.put("event_type", "core");
        r11.put("event_module", "live");
        r11.put("action_type", "click");
        r11.put("is_with_cover", "1");
        r11.put("is_with_title", "1");
        n0 r23 = u.l().c(x.class);
        if ((r23 instanceof n0) == false) goto L62;
        String r24 = r23.i;
        if (r24 == null) goto L62;
        r11.put("distribute_source", r24);
    L62:
        if (r19 == false) goto L65;
        r11.put("live_window_mode", "small_picture");
    L65:
        if (r1.getSceneTypeInfo() == null) goto L71;
        RoomSpecificSceneTypeInfo r25 = r1.getSceneTypeInfo();
        if (r25 == null) goto L71;
        if (r25.isUnionLiveRoom() != true) goto L71;
        r11.put("joint_anchor_id", r3);
        r11.put("is_joint_room", "1");
    L71:
        r11.put("order", String.valueOf(this.e));
        FeedItem r26 = this.d;
        if (r26 == null) goto L77;
        if (r26.isRecommendCard != true) goto L77;
        r11.put("is_popcard", "1");
    L77:
        if (r1.isMediaRoom() == false) goto L79;
        String r27 = "media";
    L80:
        r11.put("room_layout", r27);
        if (r1.getAutoCover() != 0) goto L83;
    L87:
        FeedItem r28 = this.d;
        if (r28 != null) goto L90;
    L97:
        FeedItem r29 = this.d;
        if (r29 == null) goto L102;
        Room r30 = r29.getRoom();
        if (r30 == null) goto L102;
        String r31 = r30.getItemExplicitInfo();
    L104:
        if (TextUtils.isEmpty(r31) == true) goto L114;
        FeedItem r32 = this.d;
        if (r32 == null) goto L111;
        Room r33 = r32.getRoom();
        if (r33 == null) goto L111;
        String r34 = r33.getItemExplicitInfo();
        if (r34 == null) goto L111;
    L112:
        r11.put("live_recommend_info", r34);
    L111:
        r34 = "";
    L114:
        if (r1.getOperationLabel() == null) goto L124;
        k r35 = r1.getOperationLabel();
        if (r35 == null) goto L121;
        Integer r36 = r35.getImageType();
        if (r36 == null) goto L121;
        String r37 = String.valueOf(r36.intValue());
        if (r37 == null) goto L121;
    L122:
        r11.put("sub_info", r37);
    L121:
        r37 = "";
    L124:
        if (e5.n() == false) goto L126;
        String r38 = "landscape";
    L127:
        r11.put("screen_direction", r38);
        int r39 = kw1.c.a;
        kw1.c.c(r11, ((RecyclerView.ViewHolder) this).itemView.getContext());
        r11.putAll(h1.a(r1));
        RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1.getEpisodeExtra2() != null) goto L130;
    L132:
        m0.J(r11);
        User r40 = r1.getOwner();
        if (r40 == null) goto L138;
        if (r40.isFollowing() != true) goto L138;
    L139:
        r11.put("is_fans", r15);
        u.l().sendLog("livesdk_live_show", r11, new Object[0]);
    L140:
        Intrinsics.checkNotNullParameter(r1, "room");
        User r41 = r1.getOwner();
        if (r41 == null) goto L144;
        String r42 = r41.getIdStr();
        if (r42 == null) goto L144;
    L145:
        HashMap r43 = new HashMap();
        TabListModel r44 = this.i;
        if (r44 == null) goto L151;
        e r45 = r44.getCurrentTabModel();
        if (r45 == null) goto L151;
        String r46 = r45.b();
        if (r46 == null) goto L151;
    L152:
        r43.put("enter_from_merge", r46);
        TabListModel r47 = this.i;
        if (r47 == null) goto L157;
        e r48 = r47.getCurrentTabModel();
        if (r48 == null) goto L157;
        r48.c();
        Object r49 = "drawer_cover";
    L158:
        r43.put("enter_method", r49);
        r43.put("anchor_id", r42);
        r43.put("request_id", r1.getRequestId());
        r43.put("room_id", String.valueOf(r1.getId()));
        r43.put("action_type", "click");
        JSONObject r50 = new JSONObject();
        uj r51 = uj.a;     // Catch: Exception -> L164
        if (r51.getValue() != null) goto L162;
    L165:
        boolean r110 = false;
    L166:
        if (r110 == false) goto L168;
        String r52 = "";
    L169:
        r50.put("challenge_info", r52);     // Catch: Exception -> L164
        if (r51.getValue() != null) goto L172;
    L174:
        boolean r111 = false;
    L175:
        if (r111 == true) goto L177;
    L179:
        r12 = r1.getContentTag();     // Catch: Exception -> L164
    L180:
        r50.put("content_tag", r12);     // Catch: Exception -> L164
        if (r1.isMediaRoom() == true) goto L183;
    L188:
        Object r112 = Long.valueOf(r1.getUserCount());     // Catch: Exception -> L164
    L189:
        Object r53 = r112;
    L190:
        r50.put("user_count", r53);     // Catch: Exception -> L164
        goto L192
    L183:
        if (r1.getStats() == null) goto L188;
        IRoomStats r54 = r1.getStats();     // Catch: Exception -> L164
        if (r54 == null) goto L187;
        r112 = Integer.valueOf(r54.getTotalUser());     // Catch: Exception -> L164
        goto L189
    L187:
        r53 = null;
        goto L190
    L177:
        if (r1.getLiveHashTagInfo() == null) goto L179;
    L172:
        if (r51.getValue().showChallenge == false) goto L174;
        r111 = true;
        goto L175
    L168:
        r52 = r1.getLiveHashTagJson();     // Catch: Exception -> L164
        goto L169
    L162:
        if (r51.getValue().showChallenge == false) goto L165;
        r110 = true;
    L192:
        if (r1.getContentLabel() == null) goto L199;
        k r55 = r1.getContentLabel();
        if (r55 == null) goto L196;
        Integer r113 = r55.getImageType();
    L197:
        r43.put("main_info", String.valueOf(r113));
        goto L199
    L196:
        r113 = null;
    L199:
        if (r1.getOperationLabel() == null) goto L205;
        k r56 = r1.getOperationLabel();
        if (r56 == null) goto L203;
        Integer r57 = r56.getImageType();
    L204:
        r43.put("sub_info", String.valueOf(r57));
        goto L205
    L203:
        r57 = null;
    L205:
        r43.put("basic_info", r50.toString());
        r43.putAll(W3());
        u.l().sendLog("live_cover_info", r43, new Object[0]);
        return;
    L157:
        r49 = "";
    L151:
        r46 = "";
    L144:
        r42 = "0";
    L138:
        r15 = "0";
        goto L139
    L130:
        if (r1.isMergeVSRoom() == true) goto L132;
        int r58 = f.M;
        f r59 = f.a.a(r1);
        r11.put("is_vs", "1");
        com.bytedance.android.livesdk.vs.f.c.c("live_show", r11, new Object[]{r59});
        r11.putAll(r59.b());
        goto L140
    L126:
        r38 = "portrait";
    L102:
        r31 = null;
        goto L104
    L90:
        if (TextUtils.isEmpty(r28.liveReason) == true) goto L97;
        FeedItem r60 = this.d;
        if (r60 == null) goto L95;
        String r61 = r60.liveReason;
        if (r61 == null) goto L95;
    L96:
        r11.put("live_reason", r61);
    L95:
        r61 = "";
        goto L96
    L83:
        if (r1.getAutoCover() != 1) goto L85;
        String r62 = "autocover";
    L86:
        r11.put("cover_type", r62);
        goto L87
    L85:
        r62 = "other";
        goto L86
    L79:
        r27 = "normal";
        goto L80
    L56:
        r22 = "0";
        goto L57
    L52:
        r21 = "general";
        goto L53
    L48:
        r20 = "video_live";
        goto L49
    L44:
        r18 = "";
    L33:
        r13 = "";
        goto L34
    L35:
        r11.put("enter_from_merge", r10);
        goto L36
    L23:
        if (r9.size() <= 0) goto L27;
        if (TextUtils.isEmpty(((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r9, 0)).e()) == true) goto L27;
        r10 = ((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r9, 0)).e();
        goto L28
    L20:
        r9 = null;
        goto L21
    L16:
        r7 = false;
        goto L17
    L12:
        r5 = null;
    L8:
        r3 = "0";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder
    public final void T3(FeedItem r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "feedItem");
        this.d = r4;
        this.e = r5;
        this.c = r4.getRoom();
        q.b(new r(new r.a(s1.getContext())));
        TextView r6 = this.m;
        Room r7 = this.c;
        List r0 = null;
        if (r7 == null) goto L5;
        String r8 = r7.getTitle();
    L6:
        r6.setText(r8);
        TextView r9 = this.n;
        StringBuilder r10 = new StringBuilder("@");
        Room r1 = this.c;
        if (r1 == null) goto L11;
        User r2 = r1.getOwner();
        if (r2 == null) goto L11;
        String r3 = r2.getRemarkNameOrRealNickName();
    L12:
        r10.append(r3);
        r9.setText(r10.toString());
        this.k.setVisibility(8);
        Room r11 = this.c;
        if (r11 == null) goto L17;
        k r12 = r11.getCover();
        if (r12 == null) goto L17;
        r0 = r12.getUrls();
    L17:
        df6.u r13 = q.c(new ef6.a(r0));
        r13.t = this.j;
        r13.c();
        UtilityKotlinExtentionsKt.t(this.l);
        UtilityKotlinExtentionsKt.t(this.k);
        this.l.pauseAnimation();
        this.o = false;
        U3();
        SingleDrawViewModel r14 = this.g.c;
        if (r14 == null) goto L22;
        NextLiveData r15 = r14.getOnRoomSelect();
        if (r15 == null) goto L22;
        r15.observe(this.g.d, new b(this));
    L22:
        this.j.setOnClickListener(new a(this));
        Room r16 = jc1.k.n(IRoomService.class).getCurrentRoomFromRoomContext();
        if (r16 == null) goto L25;
        long r17 = r16.id;
    L26:
        Room r18 = this.c;
        if (r18 != null) goto L29;
        return;
    L29:
        if (r17 != r18.id) goto L37;
        Room r19 = jc1.k.n(IRoomService.class).getCurrentRoomFromRoomContext();
        if (r19 != null) goto L33;
        return;
    L33:
        if (r19.withAggregateColumn == true) goto L39;
        UtilityKotlinExtentionsKt.w(this.l);
        UtilityKotlinExtentionsKt.w(this.k);
        this.l.playAnimation();
        this.o = true;
        return;
    L39:
        return;
    L37:
        return;
    L25:
        r17 = 0;
    L11:
        r3 = null;
        goto L12
    L5:
        r8 = null;
        goto L6
    }

    public RoomSingleDrawViewHolder(View r2, SingleDrawFeedAdapter r3, RecyclerView r4, TabListModel r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        super(r2, r3, r4, r5);
        this.j = r2.findViewById(2131386627);
        this.k = (FrameLayout) r2.findViewById(2131386630);
        this.l = r2.findViewById(2131386635);
        this.m = (TextView) r2.findViewById(2131386626);
        this.n = (TextView) r2.findViewById(2131386636);
        HSImageView r6 = r2.findViewById(2131378267);
        HSImageView r7 = r2.findViewById(2131378422);
    }
}
