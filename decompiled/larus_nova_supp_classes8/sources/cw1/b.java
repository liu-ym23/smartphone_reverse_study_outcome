package cw1;

import android.util.Pair;
import bw1.e;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import com.bytedance.android.livesdk.log.a0;
import com.bytedance.android.livesdk.log.c0;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdk.viewmodel.j;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends bw1.d {
    public Disposable d;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            BaseListResponse r4 = (BaseListResponse) r3;
            Intrinsics.checkNotNullParameter(r4, "response");
            ArrayList r0 = new ArrayList();
            List r1 = r4.data;
            if (r1 == null) goto L6;
            r0.addAll(r1);
        L6:
            return Pair.create(r0, r4.extra);
        }
    }

    /* JADX INFO: renamed from: cw1.b$b, reason: collision with other inner class name */
    public static final class C0378b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0378b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Pair r7 = (Pair) r6;
            if (r7 == null) goto L5;
            List r0 = (List) r7.first;
        L6:
            if (r0 != null) goto L8;
            return;
        L8:
            if (((List) r7.first).isEmpty() == true) goto L44;
            Object r1 = r7.second;
            if (r1 == null) goto L46;
            JsonObject r2 = ((FeedExtra) r1).getLogPb();
            if (r2 == null) goto L45;
            Iterator<T> r8 = ((Iterable) r7.first).iterator();
        L16:
            if (r8.hasNext() == false) goto L47;
            FeedItem r3 = (FeedItem) r8.next();
            r3.logPb = r2.toString();
            this.a.getClass();
            int r4 = r3.type;
            if (r4 == 1) goto L22;
            if (r4 != 2) goto L16;
        L22:
            if ((r3.getItem() instanceof Room) == false) goto L16;
            Room r5 = r3.getItem();
            if (r5 == null) goto L33;
            Room r9 = r5;
            r9.setLog_pb(r3.logPb);
            User r10 = r9.getOwner();
            if (r10 == null) goto L31;
            String r11 = r3.logPb;
            if (r11 != null) goto L30;
            r11 = "";
        L30:
            r10.setLogPb(r11);
        L31:
            r9.setRequestId(r3.resId);
            r9.setIsFromRecommendCard(r3.isRecommendCard);
            r9.setLiveReason(r3.liveReason);
            goto L16
        L33:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
        L47:
            return;
        L45:
            return;
        L46:
            return;
        L44:
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ e b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;

        public c(b r1, e r2, long r3, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r5) {
            Pair r6 = (Pair) r5;
            SingleDrawViewModel r0 = this.a.a;
            if (r0 == null) goto L5;
            r0.setFetchingData(false);
        L5:
            if (r6 == null) goto L23;
            FeedExtra r1 = (FeedExtra) r6.second;
            if (r1 == null) goto L12;
            e r2 = this.b;
            if (r2 == null) goto L12;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r2.c = r1;
        L12:
            Object r3 = r6.first;
            if (r3 != null) goto L15;
            return;
        L15:
            if (((List) r3).isEmpty() == true) goto L24;
            TabListModel r4 = this.a.b;
            if (r4 == null) goto L22;
            r4.onDataUpdata(this.c, (List) r6.first, this.d);
            return;
        L22:
            return;
        L24:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            SingleDrawViewModel r4 = this.a.a;
            if (r4 == null) goto L6;
            r4.setFetchingData(false);
            return;
        }
    }

    @Override // bw1.d
    public final void a() {
    }

    public b() {
    }

    @Override // bw1.d
    public final void b(long r10) {
        TabListModel r0 = this.b;
        if (r0 == null) goto L5;
        r0.setCurrentStatus(2);
    L5:
        TabListModel r1 = this.b;
        if (r1 == null) goto L12;
        e r2 = r1.getCurrentTabModel();
        if (r2 == null) goto L12;
        FeedExtra r3 = r2.c;
        if (r3 == null) goto L12;
        long r4 = r3.maxTime;
    L13:
        long r5 = r4;
        TabListModel.Companion.getClass();
        e(r5, TabListModel.access$getREQ_FROM_FEED_LOAD_MORE$cp(), r10, 2);
        return;
    L12:
        r4 = 0;
        goto L13
    }

    @Override // bw1.d
    public final void c(long r10) {
        TabListModel r0 = this.b;
        if (r0 == null) goto L5;
        r0.setCurrentStatus(1);
    L5:
        TabListModel.Companion.getClass();
        e(0, TabListModel.access$getREQ_FROM_ENTER_AUTO$cp(), r10, 1);
    }

    @Override // bw1.d
    public final void d(long r10) {
        TabListModel r0 = this.b;
        if (r0 == null) goto L5;
        r0.setCurrentStatus(0);
    L5:
        TabListModel r1 = this.b;
        if (r1 == null) goto L26;
        e r2 = r1.getCurrentTabModel();
        if (r2 == null) goto L26;
        LinkedList<FeedItem> r3 = r2.b;
        if (r3 == null) goto L26;
        if ((!r3.isEmpty()) != true) goto L26;
        SingleDrawViewModel r11 = this.a;
        if (r11 == null) goto L28;
        NextLiveData r12 = r11.getItemsUpdate();
        if (r12 == null) goto L29;
        TabListModel r4 = this.b;
        if (r4 == null) goto L24;
        e r5 = r4.getCurrentTabModel();
        if (r5 == null) goto L24;
        List r6 = r5.b;
        if (r6 == null) goto L24;
    L25:
        r12.postValue(new j(r6, true));
        return;
    L24:
        r6 = CollectionsKt.emptyList();
        goto L25
    L29:
        return;
    L28:
        return;
    L26:
        TabListModel.Companion.getClass();
        e(0, TabListModel.access$getREQ_FROM_ENTER_AUTO$cp(), r10, 0);
    }

    public final void e(long r17, String r19, long r20, @IFeedRepository.FEED_ACTION int r22) {
        Intrinsics.checkNotNullParameter(r19, "from");
        TabListModel r1 = this.b;
        Disposable r2 = null;
        if (r1 == null) goto L5;
        e r3 = r1.getCurrentTabModel();
    L6:
        if (r3 == null) goto L8;
        FeedExtra r4 = r3.c;
    L9:
        if (r4 == null) goto L19;
        if (r3 == null) goto L19;
        FeedExtra r5 = r3.c;
        if (r5 == null) goto L19;
        if (((Extra) r5).hasMore == true) goto L19;
        if (r22 != 2) goto L19;
        return;
    L19:
        if (r3 == null) goto L21;
        String r6 = r3.e(uv1.c.c(r3.f));
    L22:
        if (r3 == null) goto L24;
        String r11 = r3.f();
    L26:
        if (r3 == null) goto L28;
        long r9 = r3.g();
    L29:
        FeedApi r7 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        int r12 = TimeZone.getDefault().getRawOffset() / BubbleId.PadCast;
        HashMap r13 = new HashMap();
        r13.put("action_type", r19);
        r13.put("req_from", r19);
        if (r9 <= 0) goto L32;
        r13.put("draw_room_tag_id", Long.valueOf(r9));
    L32:
        r13.put("viewed_history", c0.a());
        r13.put("viewed_room_details", a0.a());
        RoomContext.a r0 = RoomContext.Companion;
        if (RoomContext.a.c(r0, null, 0, 3) == null) goto L35;
        RoomContext r10 = RoomContext.a.c(r0, null, 0, 3);
        Intrinsics.checkNotNull(r10);
        Room r14 = (Room) r10.getRoom().getValue();
    L37:
        if (r14 == null) goto L75;
        RoomContext r15 = RoomContext.a.c(r0, null, 0, 3);
        if (r15 == null) goto L75;
        if (r15.isVSSpecialDrawer() != true) goto L75;
        r13.put("is_vs_config_drawer", 1);
        RoomContext r16 = RoomContext.a.c(r0, null, 0, 3);
        if (r16 == null) goto L49;
        m r18 = r16.getCameraId();
        if (r18 == null) goto L49;
        Long r110 = (Long) r18.getValue();
        if (r110 == null) goto L49;
        long r111 = r110.longValue();
    L50:
        IVSCameraInfo r112 = ew1.a.a(r14, r111);
        if (r112 == null) goto L53;
        long r113 = r112.getCameraId();
    L54:
        r13.put("camera_id", Long.valueOf(r113));
        RoomContext r114 = RoomContext.a.c(r0, null, 0, 3);
        if (r114 == null) goto L61;
        m r115 = r114.getRoom();
        if (r115 == null) goto L61;
        Room r116 = (Room) r115.getValue();
        if (r116 == null) goto L61;
        long r117 = r116.id;
    L62:
        r13.put("draw_room_id", Long.valueOf(r117));
        RoomContext r8 = RoomContext.a.c(r0, null, 0, 3);
        if (r8 == null) goto L70;
        m r21 = r8.getRoom();
        if (r21 == null) goto L70;
        Room r23 = (Room) r21.getValue();
        if (r23 == null) goto L70;
        String r24 = r23.getAnchorId();
        if (r24 == null) goto L70;
    L71:
        r13.put("draw_room_owner_id", r24);
        r13.put("show_type", 3);
        r13.put("need_map", 1);
        r13.put("source_key", "vs_config_drawer_live_cover");
        if (r6 != null) goto L74;
        r6 = "";
    L74:
        r6 = ew1.c.a(r6, CollectionsKt.arrayListOf(new String[]{"show_type", "need_map", "source_key"}));
    L70:
        r24 = "";
    L61:
        r117 = 0;
        goto L62
    L53:
        r113 = 0;
    L49:
        r111 = 0;
    L75:
        String r25 = r6;
        SingleDrawViewModel r26 = this.a;
        if (r26 == null) goto L78;
        r26.setFetchingData(true);
    L78:
        Observable r27 = r7.drawerFeed(r25, r17, r11, r13);
        if (r27 == null) goto L85;
        Observable r28 = r27.map(a.a);
        if (r28 == null) goto L85;
        Observable r29 = r28.doOnNext(new C0378b(this));
        if (r29 == null) goto L85;
        r2 = r29.subscribe(new c(this, r3, r20, r22), new d(this));
    L85:
        this.d = r2;
        return;
    L35:
        r14 = null;
        goto L37
    L28:
        r9 = 0;
        goto L29
    L24:
        r11 = null;
        goto L26
    L21:
        r6 = null;
        goto L22
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }
}
