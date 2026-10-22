package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feed.drawerfeed.api.LiveHistoryApi;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdk.utils.landscape.LandscapeScene;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerLiveHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerLiveHistoryViewHolder extends RecyclerView.ViewHolder {
    public final View a;
    public final View b;
    public final View c;
    public final HSImageView d;
    public final HSImageView e;
    public final TextView f;
    public final TextView g;
    public FeedItem h;
    public final IDrawerFeedAction i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DrawerLiveHistoryViewHolder a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerLiveHistoryViewHolder$a$a, reason: collision with other inner class name */
        public static final class C0309a<T> implements Consumer {
            public static final C0309a a = null;

            static {
                a = new C0309a();
            }

            public C0309a() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Response r2 = (Response) r1;
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            this.b.invoke(this.a.h);
            IUserService r6 = jc1.k.f(IUserService.class);
            String r0 = "0";
            if (r6 == null) goto L14;
            com.bytedance.android.livesdk.user.f r7 = r6.user();
            if (r7 == null) goto L14;
            LiveHistoryApi r1 = (LiveHistoryApi) com.bytedance.android.live.network.c.b().e(LiveHistoryApi.class);
            String r8 = r7.n();
            ArrayList r2 = new ArrayList();
            FeedItem r3 = this.a.h;
            if (r3 == null) goto L12;
            ScheduledLiveItem r4 = r3.scheduledLive;
            if (r4 == null) goto L12;
            String r9 = r4.getUidStr();
            if (r9 == null) goto L12;
        L13:
            r2.add(r9);
            Unit r10 = Unit.INSTANCE;
            r1.deleteStoryRequest(r8, r2).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(C0309a.a, b.a);
        L12:
            r9 = "0";
        L14:
            DrawerLiveHistoryViewHolder r11 = this.a;
            r11.getClass();
            LinkedHashMap r12 = new LinkedHashMap();
            FeedItem r13 = r11.h;
            if (r13 == null) goto L19;
            ScheduledLiveItem r14 = r13.scheduledLive;
            if (r14 == null) goto L19;
            Room r15 = r14.getRoom();
        L20:
            if (r15 == null) goto L23;
            r0 = "1";
        L23:
            r12.put("history_is_on_live", r0);
            r12.put("enter_from_merge", "drawer_hot");
            r12.put("enter_method", "live_history_card");
            IUserService r16 = jc1.k.f(IUserService.class);
            String r17 = "";
            if (r16 == null) goto L29;
            com.bytedance.android.livesdk.user.f r18 = r16.user();
            if (r18 == null) goto L29;
            String r19 = r18.n();
            if (r19 == null) goto L29;
        L30:
            r12.put("user_id", r19);
            FeedItem r20 = r11.h;
            if (r20 == null) goto L36;
            ScheduledLiveItem r21 = r20.scheduledLive;
            if (r21 == null) goto L36;
            String r22 = r21.getUidStr();
            if (r22 == null) goto L36;
        L37:
            r12.put("anchor_id", r22);
            FeedItem r23 = r11.h;
            if (r23 == null) goto L47;
            ScheduledLiveItem r24 = r23.scheduledLive;
            if (r24 == null) goto L47;
            Room r25 = r24.getRoom();
            if (r25 == null) goto L47;
            String r26 = r25.getIdStr();
            if (r26 == null) goto L47;
            r17 = r26;
        L47:
            r12.put("room_id", r17);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_delete", r12, new Object[0]);
            return;
        L36:
            r22 = "";
        L29:
            r19 = "";
        L19:
            r15 = null;
            goto L20
        }

        public a(DrawerLiveHistoryViewHolder r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DrawerLiveHistoryViewHolder a;

        public b(DrawerLiveHistoryViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r17) {
            DrawerLiveHistoryViewHolder r1 = this.a;
            FeedItem r2 = r1.h;
            if (r2 == null) goto L7;
            ScheduledLiveItem r3 = r2.scheduledLive;
            if (r3 == null) goto L7;
            Room r4 = r3.getRoom();
        L8:
            String r8 = "";
            if (r4 == null) goto L34;
            FeedItem r5 = r1.h;
            if (r5 == null) goto L33;
            ScheduledLiveItem r6 = r5.scheduledLive;
            if (r6 == null) goto L33;
            Room r7 = r6.getRoom();
            if (r7 == null) goto L33;
            Bundle r9 = new Bundle();
            r9.putString("enter_from_merge", "drawer_hot");
            r9.putString("enter_method", "live_history_card");
            r9.putString("log_pb", r7.getLog_pb());
            r9.putString("request_id", r7.getRequestId());
            Bundle r10 = new Bundle();
            String r11 = new UrlBuilder("/webcast/feed/").addParam("need_map", 1).addParam("source_key", "drawer_hot_live_history_card").addParam("inner_from_drawer", 1).build();
            r10.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
            r10.putString("enter_from_live_source", "live_square");
            r10.putString("live.intent.extra.FEED_URL", r11);
            r10.putString("enter_from_merge", "drawer_hot");
            r10.putString("enter_method", "live_history_card");
            r10.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", r9);
            r10.putString("log_pb", r7.getLog_pb());
            r10.putString("request_id", r7.getRequestId());
            r10.putString("live.intent.extra.PULL_STREAM_URL", r7.buildPullUrl());
            StreamUrl r12 = r7.getStreamUrl();
            if (r12 == null) goto L19;
            yt2.a.f(r10, r12);
        L19:
            r10.putString("live.intent.extra.PULL_SDK_PARAMS", r7.getSdkParams());
            if (r7.getMultiStreamData() == null) goto L22;
            yt2.a.g(r10, "live.intent.extra.PULL_STREAM_DATA", r7.getMultiStreamData());
        L22:
            r10.putString("live.intent.extra.PULL_DEFAULT_RESOLUTION", r7.getMultiStreamDefaultQualitySdkKey());
            FeedItem r13 = r1.h;
            if (r13 == null) goto L25;
            long r14 = r13.latestWatchTime;
        L26:
            r10.putLong("live.intent.extra.latest_watch_time", r14);
            RoomContext r15 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r15 != null) goto L29;
        L32:
            TTLiveSDK.hostService().action().startLive(((RecyclerView.ViewHolder) r1).itemView.getContext(), r7.getId(), r10);
            goto L33
        L29:
            if (com.bytedance.android.livesdk.utils.landscape.b.a() == false) goto L32;
            LandscapeLiveMonitor.a r16 = LandscapeLiveMonitor.Companion;
            Pair r18 = TuplesKt.to(Long.valueOf(r7.id), LandscapeScene.JUMP);
            r16.getClass();
            LandscapeLiveMonitor.a.d(r18);
            r10.putBoolean("live.intent.extra.is_game_live", d1.a(r7));
            r10.putInt("live.intent.extra.SCREEN_ORIENTATION", ((Boolean) r15.isPortraitInteraction().getValue()).booleanValue() ? 1 : 0);
            goto L32
        L25:
            r14 = 0;
        L33:
            String r19 = null;
        L60:
            IDrawerFeedAction r20 = r1.i;
            if (r20 == null) goto L63;
            r20.closeDrawerDialog();
        L63:
            DrawerLiveHistoryViewHolder r21 = this.a;
            r21.getClass();
            LinkedHashMap r22 = new LinkedHashMap();
            FeedItem r23 = r21.h;
            if (r23 == null) goto L68;
            ScheduledLiveItem r24 = r23.scheduledLive;
            if (r24 == null) goto L68;
            String r110 = r24.getRoom();
        L69:
            if (r110 != null) goto L71;
            String r25 = "0";
        L72:
            r22.put("history_is_on_live", r25);
            r22.put("enter_from_merge", "drawer_hot");
            r22.put("enter_method", "live_history_card");
            IUserService r26 = jc1.k.f(IUserService.class);
            if (r26 == null) goto L78;
            com.bytedance.android.livesdk.user.f r27 = r26.user();
            if (r27 == null) goto L78;
            String r28 = r27.n();
            if (r28 == null) goto L78;
        L79:
            r22.put("user_id", r28);
            FeedItem r29 = r21.h;
            if (r29 == null) goto L85;
            ScheduledLiveItem r30 = r29.scheduledLive;
            if (r30 == null) goto L85;
            String r31 = r30.getUidStr();
            if (r31 == null) goto L85;
        L86:
            r22.put("anchor_id", r31);
            FeedItem r32 = r21.h;
            if (r32 == null) goto L96;
            ScheduledLiveItem r33 = r32.scheduledLive;
            if (r33 == null) goto L96;
            Room r34 = r33.getRoom();
            if (r34 == null) goto L96;
            String r35 = r34.getIdStr();
            if (r35 == null) goto L96;
            r8 = r35;
        L96:
            r22.put("room_id", r8);
            FeedItem r36 = r21.h;
            if (r36 == null) goto L101;
            ScheduledLiveItem r37 = r36.scheduledLive;
            if (r37 == null) goto L101;
            String r38 = r37.getRoom();
        L102:
            if (r38 != null) goto L104;
            String r39 = "personal_detail";
        L105:
            r22.put("click_type", r39);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_anchor_click", r22, new Object[0]);
            return;
        L104:
            r39 = "watch_live";
        L101:
            r38 = r19;
        L85:
            r31 = "";
        L78:
            r28 = "";
            goto L79
        L71:
            r25 = "1";
        L68:
            r110 = r19;
            goto L69
        L34:
            FeedItem r40 = r1.h;
            if (r40 == null) goto L40;
            ScheduledLiveItem r41 = r40.scheduledLive;
            if (r41 == null) goto L40;
            String r42 = r41.getSecUid();
            if (r42 == null) goto L40;
        L42:
            if (TextUtils.isEmpty(r42) == false) goto L50;
            FeedItem r43 = r1.h;
            if (r43 == null) goto L49;
            ScheduledLiveItem r44 = r43.scheduledLive;
            if (r44 == null) goto L49;
            r42 = r44.getUidStr();
            if (r42 != null) goto L50;
        L49:
            r42 = "";
        L50:
            HashMap r45 = new HashMap();
            if (TextUtils.isEmpty(r42) == true) goto L53;
            r45.put("sec_user_id", r42);
        L53:
            ILiveActionHandler r46 = jc1.k.n(IRoomService.class).actionHandler();
            FeedItem r47 = r1.h;
            if (r47 == null) goto L58;
            ScheduledLiveItem r48 = r47.scheduledLive;
            if (r48 == null) goto L58;
            String r111 = r48.getUidStr();
            r19 = null;
        L59:
            r46.showUserProfile(r111, r19, r45);
        L58:
            r19 = null;
            r111 = null;
        L40:
            r42 = "";
        L7:
            r4 = null;
            goto L8
        }
    }

    public DrawerLiveHistoryViewHolder(View r2, Function1<? super FeedItem, Unit> r3, IDrawerFeedAction r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "deleteAction");
        super(r2);
        this.i = r4;
        this.a = r2.findViewById(2131378540);
        this.b = r2.findViewById(2131381006);
        this.d = r2.findViewById(2131364129);
        this.e = r2.findViewById(2131363623);
        this.f = (TextView) r2.findViewById(2131378544);
        this.g = (TextView) r2.findViewById(2131381007);
        View r5 = r2.findViewById(2131374396);
        this.c = r5;
        if (r5 == null) goto L5;
        r5.setOnClickListener(new a(this, r3));
    L5:
        r2.setOnClickListener(new b(this));
    }
}
