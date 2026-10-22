package tw1;

import am2.x;
import android.util.Pair;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.g;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.open.OpenRoom;
import com.bytedance.android.livesdkapi.depend.model.open.OpenUser;
import com.bytedance.android.livesdkapi.feed.EnterParams;
import com.bytedance.android.livesdkapi.feed.FeedLoadingCallback;
import com.bytedance.android.livesdkapi.feed.IOpenFeedLogger;
import com.bytedance.android.livesdkapi.feed.IOpenFeedRepository;
import com.bytedance.android.livesdkapi.feed.constant.FeedChannel;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kw1.d;
import py.j;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements IOpenFeedRepository {
    public Disposable a;
    public long b;
    public String c;
    public String d;
    public FeedType e;
    public String f;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final Object apply(Object r26) {
            BaseListResponse r0 = (BaseListResponse) r26;
            Intrinsics.checkNotNullParameter(r0, "response");
            ArrayList r1 = new ArrayList();
            List r2 = r0.data;
            if (r2 == null) goto L63;
            Iterator<T> r3 = r2.iterator();
        L6:
            if (r3.hasNext() == false) goto L63;
            FeedItem r4 = (FeedItem) r3.next();
            Room r15 = r4.getRoom();
            if (r15 == null) goto L61;
            FeedType r5 = this.a.e;
            FeedExtra r6 = r0.extra;
            if (r6 == null) goto L14;
            JsonObject r7 = r6.getLogPb();
            if (r7 == null) goto L14;
            String r16 = r7.toString();
        L15:
            int r8 = tw1.c.a;
            Intrinsics.checkNotNullParameter(r15, "room");
            Intrinsics.checkNotNullParameter(r4, "feedItem");
            Intrinsics.checkNotNullParameter(r5, "feedType");
            nn2.a r9 = nn2.a.d;
            nn2.a.a.a().c(r15.getRoomId(), r4.type);
            User r10 = r15.getOwner();
            if (r10 == null) goto L18;
            String r11 = r10.getNickName();
        L19:
            if (r10 == null) goto L21;
            k r12 = r10.getAvatarThumb();
        L23:
            if ((r12 instanceof ImageModel) == true) goto L25;
            r12 = null;
        L25:
            ImageModel r13 = (ImageModel) r12;
            if (r10 == null) goto L28;
            String r14 = r10.getUserId();
        L29:
            if (r10 == null) goto L31;
            j r17 = r10.getFollowInfo();
        L33:
            if ((r17 instanceof FollowInfo) == true) goto L35;
            r17 = null;
        L35:
            OpenUser r18 = new OpenUser(r11, r13, r14, (FollowInfo) r17);
            String r19 = r15.getTitle();
            k r20 = r15.getContentLabel();
            if ((r20 instanceof ImageModel) == true) goto L38;
            r20 = null;
        L38:
            ImageModel r21 = (ImageModel) r20;
            k r22 = r15.getOperationLabel();
            if ((r22 instanceof ImageModel) == true) goto L41;
            r22 = null;
        L41:
            ImageModel r110 = (ImageModel) r22;
            int r111 = (int) r15.getStatus();
            k r23 = r15.getCover();
            if (r23 == null) goto L50;
            List r24 = r23.getUrls();
            if (r24 == null) goto L50;
            if ((!r24.isEmpty()) != true) goto L50;
            k r25 = r15.getCover();
            if (r25 == null) goto L50;
            List r112 = r25.getUrls();
        L51:
            int r27 = r15.getAudienceCount();
            StreamUrl r28 = r15.getStreamUrl();
            if ((r28 instanceof StreamUrl) == true) goto L54;
            StreamUrl r29 = null;
        L55:
            long r30 = r15.id;
            String r31 = r4.resId;
            if (r5 != FeedType.FOLLOW_FEED) goto L58;
            Boolean r32 = Boolean.FALSE;
        L59:
            r1.add(new OpenRoom(r18, r19, r21, r110, r111, r112, r27, r29, r30, r31, r16, r32.booleanValue(), Integer.valueOf(r4.type), r4.adRawString, r4.isPseudoLiving, r15));
            goto L61
        L58:
            r32 = (Boolean) g.a.getValue();
            goto L59
        L54:
            r29 = r28;
        L50:
            r112 = null;
            goto L51
        L31:
            r17 = null;
            goto L33
        L28:
            r14 = null;
            goto L29
        L21:
            r12 = null;
            goto L23
        L18:
            r11 = null;
        L14:
            r16 = null;
        L61:
            r3 = r3;
        L63:
            return Pair.create(r1, r0.extra);
        }
    }

    /* JADX INFO: renamed from: tw1.b$b, reason: collision with other inner class name */
    public static final class C0419b<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ FeedLoadingCallback b;
        public final /* synthetic */ String c;

        public C0419b(b r1, FeedLoadingCallback r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Pair r6 = (Pair) r5;
            b r0 = this.a;
            FeedExtra r1 = (FeedExtra) r6.second;
            r0.b = r1.maxTime;
            this.b.onSuccess((List) r6.first, ((Extra) r1).hasMore, this.c);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FeedLoadingCallback a;

        public c(FeedLoadingCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            FeedLoadingCallback r0 = this.a;
            r0.onFailed((Throwable) r2);
        }
    }

    public final void detach() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
    }

    public b() {
        this.e = FeedType.COMMON_FEED;
        this.f = FeedChannel.DEFAULT.getChannelName();
    }

    public final IOpenFeedLogger getLogger() {
        return d.a;
    }

    public final void config(EnterParams r3, FeedType r4) {
        Intrinsics.checkNotNullParameter(r3, "enterParams");
        Intrinsics.checkNotNullParameter(r4, "feedType");
        this.c = r3.getEnterFromMerge();
        this.d = r3.getEnterMethod();
        this.e = r4;
        o r5 = u.l().c(x.class);
        r5.getMap().put("enter_from_merge", this.c);
        r5.getMap().put("enter_method", this.d);
    }

    public final void config(EnterParams r2, FeedType r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "enterParams");
        Intrinsics.checkNotNullParameter(r3, "feedType");
        config(r2, r3);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this.f = r4;
    }

    public final void requestFeed(boolean r12, int r13, FeedLoadingCallback r14) {
        Intrinsics.checkNotNullParameter(r14, "loadingCallback");
        if (this.c == null) goto L5;
    L11:
        String r1 = this.c;
        String r2 = "";
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        StringBuilder r0 = new StringBuilder(r1);
        String r3 = this.d;
        if (r3 != null) goto L17;
    L22:
        String r9 = r0.toString();
        if (r12 == false) goto L25;
        this.b = 0;
        String r15 = "feed_refresh";
    L26:
        String r8 = r15;
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("style", 7);
        if (r13 >= 0) goto L29;
        r13 = 0;
    L29:
        r10.put(LiveEndPageData.TAG_COUNT, Integer.valueOf(r13));
        FeedType r16 = this.e;
        if (r16 != FeedType.COMMON_FEED) goto L33;
        r10.put("content_type", 0);
        r10.put("channel_name", this.f);
    L35:
        String r17 = this.c;
        if (r17 != null) goto L38;
        r17 = "";
    L38:
        String r18 = this.d;
        if (r18 == null) goto L42;
        r2 = r18;
    L42:
        String r19 = com.bytedance.android.live.core.feed.d.a(r17, r2);
        this.a = ((FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class)).feed(r19, this.b, r8, r9, r10).map(new a(this)).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0419b(this, r14, r19), new c(r14));
        return;
    L33:
        if (r16 != FeedType.FOLLOW_FEED) goto L35;
        r10.put("content_type", 3);
        goto L35
    L25:
        r15 = "feed_loadmore";
        goto L26
    L17:
        if (r3.length() <= 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 != true) goto L22;
        r0.append("-");
        r0.append(this.d);
        goto L22
    L19:
        r4 = false;
        goto L20
    L5:
        if (this.d != null) goto L11;
        if (v.a() == false) goto L11;
        throw new RuntimeException("埋点参数异常，请检查config()方法是否正确调用");
    }
}
