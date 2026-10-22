package ow1;

import android.content.Context;
import android.util.Pair;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.feed.openui.view.HSLargeLiveCardView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.constant.CardStyle;
import com.bytedance.android.livesdkapi.feed.manager.ILiveListCardCallback;
import com.bytedance.android.livesdkapi.feed.manager.ILiveListManager;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements ILiveListManager {
    public static final b a = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ILiveListCardCallback a;

        public a(ILiveListCardCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILiveListCardCallback r0 = this.a;
            r0.onReceive((List) r2);
        }
    }

    /* JADX INFO: renamed from: ow1.b$b, reason: collision with other inner class name */
    public static final class C0408b<T> implements Consumer {
        public final /* synthetic */ ILiveListCardCallback a;

        public C0408b(ILiveListCardCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILiveListCardCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ILiveListCardCallback a;

        public c(ILiveListCardCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILiveListCardCallback r0 = this.a;
            r0.onReceive((List) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ILiveListCardCallback a;

        public d(ILiveListCardCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILiveListCardCallback r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r6) {
            BaseListResponse r7 = (BaseListResponse) r6;
            Intrinsics.checkNotNullParameter(r7, "response");
            ArrayList r0 = new ArrayList();
            List r1 = r7.data;
            if (r1 == null) goto L22;
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L22;
            FeedItem r3 = (FeedItem) r2.next();
            Room r4 = r3.getRoom();
            if (r4 == null) goto L6;
            String r5 = r3.resId;
            String r8 = "";
            if (r5 != null) goto L12;
            r5 = "";
        L12:
            r4.setRequestId(r5);
            FeedExtra r9 = r7.extra;
            if (r9 == null) goto L20;
            JsonObject r10 = r9.getLogPb();
            if (r10 == null) goto L20;
            String r11 = r10.toString();
            if (r11 == null) goto L20;
            r8 = r11;
        L20:
            r4.setLog_pb(r8);
            r0.add(r4);
        L22:
            return Pair.create(r0, r7.extra);
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ OpenFeedParams a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Ref.ObjectRef c;

        public f(OpenFeedParams r1, Context r2, Ref.ObjectRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r9) {
            Pair r10 = (Pair) r9;
            Intrinsics.checkNotNullParameter(r10, "pair");
            ArrayList r0 = new ArrayList();
            List r11 = (List) r10.first;
            if (r11 == null) goto L16;
            Iterator<T> r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L16;
            Room r1 = (Room) r12.next();
            CardStyle r2 = this.a.getCardStyle();
            HSLargeLiveCardView r3 = null;
            if (r2 != null) goto L11;
        L14:
            if (r3 == null) goto L6;
            r3.bindRoom(r1, (String) this.c.element, new LiveCoverConfig(this.a.getEnableOperationLabel(), this.a.getEnableContentLabel(), this.a.getEnableCategoryLabel()));
            r0.add(r3);
            goto L6
        L11:
            if (ow1.a.c[r2.ordinal()] != 1) goto L14;
            r3 = new HSLargeLiveCardView(this.b, null, 6, 0);
        L16:
            return r0;
        }
    }

    public b() {
    }

    static {
        a = new b();
    }

    public final void requestAndGetView(Context r10, OpenFeedParams r11, ILiveListCardCallback r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "openFeedParams");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        String r1 = "";
        r0.element = "";
        LinkedHashMap r8 = new LinkedHashMap();
        int r2 = ow1.a.a[r11.getFeedType().ordinal()];
        if (r2 == 1) goto L7;
        if (r2 != 2) goto L8;
        r0.element = "homepage_hot";
        r8.put("content_type", 0);
    L8:
        CardStyle r3 = r11.getCardStyle();
        if (r3 == null) goto L17;
        int r4 = ow1.a.b[r3.ordinal()];
        if (r4 == 1) goto L16;
        if (r4 != 2) goto L17;
        r8.put("style", Integer.valueOf(FeedApi.Style.SMALL_CARD.getStyleValue()));
        r1 = "drawer_cover";
        goto L17
    L16:
        r8.put("style", Integer.valueOf(FeedApi.Style.BIG_CARD.getStyleValue()));
        r1 = "live_window";
    L17:
        Integer r5 = r11.getCardCount();
        if (r5 == null) goto L20;
        r8.put(LiveEndPageData.TAG_COUNT, Integer.valueOf(r5.intValue()));
    L20:
        String r7 = ((String) r0.element) + '-' + r1;
        if (r11.getCardStyle() != CardStyle.PREVIEW_CARD_H) goto L23;
        int r6 = tb1.a.a;
    L23:
        Observable r13 = ((FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class)).feed(com.bytedance.android.live.core.feed.d.a((String) r0.element, r1), 0, "feed_refresh", r7, r8).map(e.a).observeOn(AndroidSchedulers.mainThread()).map(new f(r11, r10, r0));
        if (r13 == null) goto L26;
        Observable r14 = r13.subscribeOn(AndroidSchedulers.mainThread());
    L28:
        if ((r10 instanceof LifecycleOwner) == false) goto L33;
        if (r14 == null) goto L36;
        ObservableSubscribeProxy r15 = (ObservableSubscribeProxy) r14.as(AutoDispose.bind((LifecycleOwner) r10));
        if (r15 == null) goto L37;
        r15.subscribe(new a(r12), new C0408b(r12));
        return;
    L37:
        return;
    L36:
        return;
    L33:
        if (r14 == null) goto L39;
        r14.subscribe(new c(r12), new d(r12));
        return;
    L39:
        return;
    L26:
        r14 = null;
        goto L28
    L7:
        r0.element = "homepage_follow";
        r8.put("content_type", 3);
        goto L8
    }
}
