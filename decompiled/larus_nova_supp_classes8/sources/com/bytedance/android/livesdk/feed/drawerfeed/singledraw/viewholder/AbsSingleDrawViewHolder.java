package com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import bw1.e;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.config.p2;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleDrawFeedAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.EntryType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAppearance;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/AbsSingleDrawViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsSingleDrawViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final HSImageView b;
    public Room c;
    public FeedItem d;
    public int e;
    public final View f;
    public final SingleDrawFeedAdapter g;
    public final RecyclerView h;
    public final TabListModel i;

    public static final class a {
    }

    public static final class b extends q0 {
        public final /* synthetic */ AbsSingleDrawViewHolder a;

        public b(AbsSingleDrawViewHolder r1) {
            this.a = r1;
        }

        public final void h(k r2, int r3, int r4) {
            HSImageView r5 = this.a.b;
            if (r5 == null) goto L6;
            ViewGroup.LayoutParams r0 = r5.getLayoutParams();
            r0.width = (int) (r0.height * (r3 / r4));
            r5.setLayoutParams(r0);
            return;
        }
    }

    public static final class c extends q0 {
        public final /* synthetic */ AbsSingleDrawViewHolder a;

        public c(AbsSingleDrawViewHolder r1) {
            this.a = r1;
        }

        public final void h(k r1, int r2, int r3) {
            HSImageView r4 = this.a.a;
            if (r4 == null) goto L5;
            ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        L6:
            float r6 = r3 / r2;
            HSImageView r7 = this.a.a;
            if (r7 == null) goto L9;
            float r8 = r7.getWidth();
        L10:
            if (r5 == null) goto L12;
            r5.height = (int) (r8 * r6);
        L12:
            HSImageView r9 = this.a.a;
            if (r9 == null) goto L16;
            r9.setLayoutParams(r5);
            return;
        L16:
            return;
        L9:
            r8 = 0.0f;
            goto L10
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public abstract void T3(FeedItem r1, int r2);

    public abstract void X3();

    public final void U3() {
        Room r0 = this.c;
        k r1 = null;
        if (r0 == null) goto L5;
        k r2 = r0.getOperationLabel();
    L7:
        if (r2 == null) goto L13;
        UIUtils.setViewVisibility(this.b, 0);
        Room r3 = this.c;
        if (r3 == null) goto L11;
        k r4 = r3.getOperationLabel();
    L12:
        ImageLoader.d r5 = ImageLoader.load(r4);
        r5.e = new b(this);
        r5.a(this.b);
    L14:
        Room r6 = this.c;
        if (r6 == null) goto L17;
        RoomAppearance r7 = r6.appearance;
    L18:
        if (r7 == null) goto L36;
        if (r6 == null) goto L23;
        RoomAppearance r8 = r6.appearance;
        if (r8 == null) goto L23;
        k r9 = r8.getCoverDynamicMask();
    L24:
        if (r9 == null) goto L36;
        HSImageView r10 = this.a;
        if (r10 == null) goto L29;
        r10.setVisibility(0);
    L29:
        Room r11 = this.c;
        if (r11 == null) goto L34;
        RoomAppearance r12 = r11.appearance;
        if (r12 == null) goto L34;
        r1 = r12.getCoverDynamicMask();
    L34:
        ImageLoader.d r13 = ImageLoader.load(r1);
        r13.e = new c(this);
        r13.f = true;
        r13.a(this.a);
        return;
    L23:
        r9 = null;
    L36:
        HSImageView r14 = this.a;
        if (r14 == null) goto L40;
        r14.setVisibility(8);
        return;
    L40:
        return;
    L17:
        r7 = null;
        goto L18
    L11:
        r4 = null;
        goto L12
    L13:
        UIUtils.setViewVisibility(this.b, 8);
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    public final void V3() {
        FeedItem r1 = this.d;
        if (r1 == null) goto L190;
        long r3 = 0;
        if (this.c == null) goto L16;
        HashMap<String, String> r2 = W3();
        o r5 = u.l().c(am2.o.class);
        if (r5 == null) goto L16;
        if (r5.getMap() == null) goto L16;
        r5.getMap().putAll(r2);
        am2.o r4 = new am2.o();
        Room r6 = this.c;
        if (r6 == null) goto L14;
        long r7 = r6.id;
    L15:
        r4.a = r7;
        r5.setData(r4);
        goto L16
    L14:
        r7 = 0;
    L16:
        Bundle r8 = new Bundle();
        r8.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", System.currentTimeMillis());
        TabListModel r9 = this.i;
        if (r9 == null) goto L19;
        e r10 = r9.getCurrentTabModel();
    L20:
        TabListModel r11 = this.i;
        if (r11 == null) goto L25;
        e r12 = r11.getCurrentTabModel();
        if (r12 == null) goto L25;
        com.bytedance.android.livesdk.feed.feed.e r13 = r12.f;
    L26:
        String r14 = "";
        if (r13 == null) goto L30;
        String r15 = r13.j();
        if (r15 == null) goto L30;
    L31:
        int r16 = 0;
        if (StringsKt.contains$default(r15, "live", false, 2, null) == false) goto L35;
        if (r13 == null) goto L35;
        r15 = r13.e();
    L35:
        r8.putString("source", r15);
        Bundle r17 = new Bundle();
        r17.putString("subtab", r15);
        r8.putBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1", r17);
        r8.putString("log_pb", r1.logPb);
        r8.putString("request_id", r1.resId);
        r8.putInt(VSConstants.EXTRA_ITEM_TYPE, r1.type);
        r8.putString("enter_from", "live");
        if (r13 == null) goto L38;
        r8.putLong("live.intent.extra.USER_FROM", r13.l());
    L38:
        if (r10 == null) goto L40;
        String r18 = r10.b();
    L41:
        r8.putString("enter_from_merge", r18);
        if (r10 == null) goto L44;
        r10.c();
        String r19 = "drawer_cover";
    L45:
        r8.putString("enter_method", r19);
        r8.putInt("live.intent.extra.ENTER_LIVE_ORDER", this.e);
        if (r1.isRecommendCard == false) goto L49;
        r8.putString("enter_from_merge_recommend", "pop_card");
    L49:
        if (TextUtils.isEmpty(r1.liveReason) == true) goto L51;
        r8.putString("live_reason", r1.liveReason);
    L51:
        Room r20 = this.c;
        if (r20 != null) goto L54;
    L60:
        ILiveService r21 = TTLiveService.getLiveService();
        if (r21 == null) goto L68;
        ILiveOntologyInfoManager r22 = r21.getLiveOntologyRecord();
        if (r22 == null) goto L68;
        String r23 = r22.getEnterFromMerge();
        if (r23 == null) goto L68;
        r14 = r23;
    L68:
        r8.putString("drawer_page", r14);
        if (r10 == null) goto L71;
        String r24 = r10.d();
    L72:
        r8.putString("drawer_inner_req_from", r24);
        Intrinsics.checkNotNullParameter(r8, "enterExtra");
        FeedItem r25 = this.d;
        if (r25 == null) goto L191;
        Room r26 = this.c;
        if (r26 != null) goto L77;
    L79:
        Room r27 = this.c;
        if (r27 == null) goto L82;
        r27.setLog_pb(r25.logPb);
    L82:
        Room r28 = this.c;
        if (r28 == null) goto L85;
        r28.setRequestId(r25.resId);
    L85:
        Room r29 = this.c;
        if (r29 != null) goto L88;
    L89:
        Room r30 = this.c;
        if (r30 != null) goto L92;
    L94:
        String r31 = "other";
    L95:
        r8.putString("cover_type", r31);
    L96:
        Room r32 = this.c;
        if (r32 != null) goto L99;
    L107:
        Context r33 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        if (NetworkUtils.isNetworkAvailable(r33) == true) goto L110;
        IESUIUtils.displayToast(r33, 2131916613);
        return;
    L110:
        ILiveRoomService r34 = jc1.k.f(ILiveRoomService.class);
        TabListModel r35 = this.i;
        if (r35 == null) goto L113;
        e r36 = r35.getCurrentTabModel();
    L114:
        if (r34 == null) goto L116;
        r34.recordEnterStart(EntryType.FEED);
    L116:
        Room r37 = this.c;
        if (r37 == null) goto L193;
        if (r36 == null) goto L122;
        com.bytedance.android.livesdk.feed.feed.e r110 = r36.f;
        if (r110 == null) goto L122;
        String r111 = r110.e();
    L123:
        Bundle r112 = LiveRoomIntentBuilder.buildBundle(r33, r37, r111, r8);
        if (r112 == null) goto L194;
        r112.putBoolean("is_from_match_room", r8.getBoolean("is_from_match_room"));
        r112.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", r8.getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME"));
        r112.putAll(ArgumentsBuilder.buildRoomArgs(r37));
        Room r38 = this.c;
        if (r38 == null) goto L132;
        VerticalTypeInfo r39 = r38.mVerticalTypeInfo;
        if (r39 == null) goto L132;
        Long r40 = r39.tagId;
        if (r40 == null) goto L132;
        String r41 = String.valueOf(r40.longValue());
    L133:
        r112.putString("tag_id", r41);
        if (r112.get("live.intent.extra.USER_ID") != null) goto L136;
        r112.putString("live.intent.extra.USER_ID", r37.getOwnerUserIdString());
    L136:
        r112.putString("enter_from_user_id", r37.getOwnerUserIdString());
        int r42 = r25.contentCategory;
        int r113 = com.bytedance.android.live.base.model.c.a;
        if (r42 == 1) goto L139;
    L145:
        TabListModel r43 = this.i;
        if (r43 != null) goto L148;
    L161:
        r112.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        r112.putBoolean("live.intent.extra.LIVE_FROM_DRAWER", true);
        r112.putString("enter_from_live_source", "live_square");
        r112.putString("live.intent.extra.WINDOW_MODE", "small_picture");
        if (r36 == null) goto L166;
        com.bytedance.android.livesdk.feed.feed.e r44 = r36.f;
        if (r44 == null) goto L166;
        int r45 = r44.getType();
    L167:
        r112.putInt("live.intent.extra.DRAWER_JUMP_FROM", r45);
        ILiveService r46 = TTLiveService.getLiveService();
        if (r46 == null) goto L172;
        ILiveOntologyInfoManager r47 = r46.getLiveOntologyRecord();
        if (r47 == null) goto L172;
        String r48 = r47.getInnerUrl();
    L174:
        if (TextUtils.isEmpty(r48) == false) goto L184;
        List<com.bytedance.android.livesdk.feed.feed.e> r49 = p.f().c();
        if (Lists.isEmpty(r49) == false) goto L178;
    L186:
        if (r25.isPseudoLiving == false) goto L188;
        r112.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", true);
    L188:
        r112.putString("extra_live_new_room_back_source", "jump_source_square_drawer");
        kw1.c.b(r33, r8);
        TTLiveSDK.hostService().action().startLive(r33, r37.id, r112);
        return;
    L178:
        if (ListProtector.get(r49, 0) == null) goto L186;
        com.bytedance.android.livesdk.feed.feed.e r50 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r49, 0);
        if (r50 == null) goto L182;
        String r51 = r50.n();
    L183:
        r112.putString("live.intent.extra.FEED_URL", r51);
        goto L186
    L182:
        r51 = null;
        goto L183
    L184:
        r112.putString("live.intent.extra.FEED_URL", r48);
    L172:
        r48 = null;
    L166:
        r45 = 0;
        goto L167
    L148:
        if (r43.isMultiTab() != true) goto L161;
        r112.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        r112.putBoolean("live.intent.extra.LIVE_FROM_DRAWER", true);
        r112.putString("enter_from_live_source", "live_square");
        if (r36 == null) goto L152;
        String r52 = r36.a(this.e);
    L153:
        r112.putString("live.intent.extra.FEED_URL", r52);
        if (r36 == null) goto L158;
        com.bytedance.android.livesdk.feed.feed.e r53 = r36.f;
        if (r53 == null) goto L158;
        r16 = r53.getType();
    L158:
        r112.putInt("live.intent.extra.DRAWER_JUMP_FROM", r16);
        if (r8.keySet().contains("live.intent.extra.ENTER_ROOM_IDS") == false) goto L186;
        r112.putLongArray("live.intent.extra.ENTER_ROOM_IDS", r8.getLongArray("live.intent.extra.ENTER_ROOM_IDS"));
        goto L186
    L152:
        r52 = null;
        goto L153
    L139:
        if (p2.a.getValue().booleanValue() == false) goto L141;
        r112.putBoolean("open_merge_drawer", true);
        r112.putString("aggregate_column_title", s1.B(2131922538));
    L141:
        r112.putString("isInnerFromDrawer", "true");
        Room r54 = jc1.k.n(IRoomService.class).getCurrentRoomFromRoomContext();
        if (r54 == null) goto L144;
        r3 = r54.id;
    L144:
        r112.putLong("similar_room_id", r3);
    L132:
        r41 = null;
        goto L133
    L194:
        return;
    L122:
        r111 = null;
        goto L123
    L193:
        return;
    L113:
        r36 = null;
        goto L114
    L99:
        if (r32.getOperationLabel() == null) goto L107;
        Room r55 = this.c;
        if (r55 == null) goto L105;
        k r56 = r55.getOperationLabel();
        if (r56 == null) goto L105;
        Integer r57 = r56.getImageType();
    L106:
        r8.putString("enter_room_operation_label", String.valueOf(r57));
    L105:
        r57 = null;
        goto L106
    L92:
        if (r30.getAutoCover() != 1) goto L94;
        r31 = "autocover";
        goto L95
    L88:
        if (r29.getAutoCover() == 0) goto L96;
    L77:
        if (r26.isPullUrlValid() == true) goto L79;
        return;
    L191:
        return;
    L71:
        r24 = null;
        goto L72
    L54:
        if (TextUtils.isEmpty(r20.getItemExplicitInfo()) == true) goto L60;
        Room r58 = this.c;
        if (r58 == null) goto L58;
        String r59 = r58.getItemExplicitInfo();
    L59:
        r8.putString("live_recommend_info", r59);
        goto L60
    L58:
        r59 = null;
        goto L59
    L44:
        r19 = null;
        goto L45
    L40:
        r18 = null;
    L30:
        r15 = "";
    L25:
        r13 = null;
        goto L26
    L19:
        r10 = null;
        goto L20
    }

    public final HashMap<String, String> W3() {
        HashMap<String, String> r0 = new HashMap();
        ILiveService r1 = TTLiveService.getLiveService();
        if (r1 == null) goto L8;
        ILiveOntologyInfoManager r2 = r1.getLiveOntologyRecord();
        if (r2 == null) goto L8;
        String r3 = r2.getEnterFromMerge();
        if (r3 == null) goto L8;
    L9:
        r0.put("drawer_page", r3);
        Room r4 = this.c;
        if (r4 != null) goto L12;
    L23:
        return r0;
    L12:
        if (r4.isMergeVSRoom() == false) goto L23;
        LiveVSLog.r.getClass();
        r0.putAll(LiveVSLog.b.a(r4).a());
        Activity r5 = bz2.b.a(((RecyclerView.ViewHolder) this).itemView.getContext());
        if (r5 == null) goto L23;
        if (r5.getRequestedOrientation() != 0) goto L18;
    L21:
        String r6 = "landscape";
    L22:
        r0.put("vs_screen_type", r6);
        goto L23
    L18:
        if (r5.getRequestedOrientation() == 6) goto L21;
        r6 = "portrait";
    L8:
        r3 = "";
        goto L9
    }

    public AbsSingleDrawViewHolder(View r2, SingleDrawFeedAdapter r3, RecyclerView r4, TabListModel r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        super(r2);
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378267);
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378422);
    }
}
