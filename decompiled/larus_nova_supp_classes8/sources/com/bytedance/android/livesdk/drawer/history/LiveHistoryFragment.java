package com.bytedance.android.livesdk.drawer.history;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.ui.FadingEdgeRecyclerview;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.google.gson.JsonObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kn2.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/history/LiveHistoryFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHistoryFragment extends BaseFragment {
    public static boolean x;
    public static int y;
    public View d;
    public FadingEdgeRecyclerview e;
    public final MultiTypeAdapter f;
    public final Items g;
    public FeedExtra h;
    public boolean i;
    public DouyinLoadingLayout j;
    public com.bytedance.android.livesdk.drawer.history.e k;
    public FrameLayout l;
    public ViewGroup m;
    public View n;
    public final CompositeDisposable o;
    public final NextLiveData<Boolean> p;
    public boolean q;
    public int r;
    public TextView s;
    public ImageView t;
    public TextView u;
    public LinearLayout v;
    public final e w;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
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

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveHistoryFragment a;

        public c(LiveHistoryFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Pair r9 = (Pair) r8;
            this.a.r++;
            JsonObject r0 = ((FeedExtra) r9.second).getLogPb();
            if (r0 == null) goto L8;
            Iterator<T> r1 = ((Iterable) r9.first).iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            ((FeedItem) r1.next()).logPb = r0.toString();
        L8:
            LiveHistoryFragment r2 = this.a;
            DouyinLoadingLayout r3 = r2.j;
            if (r3 == null) goto L11;
            r3.c();
        L11:
            DouyinLoadingLayout r4 = r2.j;
            if (r4 == null) goto L14;
            r4.setVisibility(8);
        L14:
            this.a.p.postValue(Boolean.FALSE);
            if (CollectionUtils.isEmpty((Collection) r9.first) == false) goto L32;
            LiveHistoryFragment r5 = this.a;
            if (r5.r != 1) goto L32;
            DouyinLoadingLayout r10 = r5.j;
            if (r10 == null) goto L21;
            r10.c();
        L21:
            DouyinLoadingLayout r11 = r5.j;
            if (r11 == null) goto L24;
            r11.setVisibility(8);
        L24:
            ViewGroup r12 = r5.m;
            if (r12 == null) goto L27;
            r12.setVisibility(0);
        L27:
            FrameLayout r13 = r5.l;
            if (r13 == null) goto L30;
            r13.setVisibility(8);
        L30:
            this.a.q = false;
            return;
        L32:
            if (CollectionUtils.isEmpty((Collection) r9.first) == false) goto L38;
            FeedExtra r6 = (FeedExtra) r9.second;
            if (r6 == null) goto L38;
            if (((Extra) r6).hasMore == true) goto L38;
            LiveHistoryFragment r14 = this.a;
            r14.h = r6;
            r14.S90(new com.bytedance.android.livesdk.drawer.history.a());
            LiveHistoryFragment r15 = this.a;
            r15.q = false;
            r15.f.notifyItemInserted(r15.g.size());
            return;
        L38:
            LiveHistoryFragment r7 = this.a;
            r7.h = (FeedExtra) r9.second;
            r7.q = false;
            List r16 = (List) r9.first;
            Intrinsics.checkNotNullParameter(r16, "itemList");
            if (CollectionUtils.isEmpty(r16) == true) goto L89;
            int r17 = r7.g.size();
            Iterator<T> r18 = r16.iterator();
        L43:
            if (r18.hasNext() == false) goto L55;
            FeedItem r19 = (FeedItem) r18.next();
            int r20 = r19.type;
            if (r20 != 11) goto L47;
            r7.S90(r19.placeHolder);
            goto L43
        L47:
            if (r20 != 12) goto L43;
            r7.S90(r19.scheduledLive);
            ScheduledLiveItem r21 = r19.scheduledLive;
            if (r21 == null) goto L43;
            Room r22 = r21.getRoom();
            if (r22 == null) goto L43;
            r22.setRequestId(r19.requestId());
            goto L43
        L55:
            FeedExtra r23 = r7.h;
            if (r23 == null) goto L61;
            if (((Extra) r23).hasMore == true) goto L61;
            r7.S90(new com.bytedance.android.livesdk.drawer.history.a());
        L61:
            if ((CollectionsKt.last(r7.g) instanceof com.bytedance.android.livesdk.drawer.history.f) == true) goto L63;
            r7.S90(new com.bytedance.android.livesdk.drawer.history.f(r7.p, r7));
        L63:
            MultiTypeAdapter r24 = r7.f;
            Items r25 = r7.g;
            r24.a = r25;
            if (r25.size() == r17) goto L88;
            FrameLayout r26 = r7.l;
            if (r26 == null) goto L68;
            r26.setVisibility(0);
        L68:
            ViewGroup r27 = r7.m;
            if (r27 == null) goto L71;
            r27.setVisibility(8);
        L71:
            r7.f.notifyItemRangeInserted(r17, r7.g.size() - r17);
            return;
        L88:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveHistoryFragment a;

        public d(LiveHistoryFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ((Throwable) r4).printStackTrace();
            LiveHistoryFragment r5 = this.a;
            DouyinLoadingLayout r0 = r5.j;
            if (r0 == null) goto L5;
            r0.c();
        L5:
            DouyinLoadingLayout r1 = r5.j;
            if (r1 == null) goto L8;
            r1.setVisibility(8);
        L8:
            ViewGroup r2 = r5.m;
            if (r2 == null) goto L11;
            r2.setVisibility(0);
        L11:
            FrameLayout r6 = r5.l;
            if (r6 == null) goto L15;
            r6.setVisibility(8);
            return;
        }
    }

    public static final class e extends com.bytedance.android.livesdk.user.h<IBaseUser> {
        public final /* synthetic */ LiveHistoryFragment a;

        public e(LiveHistoryFragment r1) {
            this.a = r1;
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.o.add(r2);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ LiveHistoryFragment a;

        public f(LiveHistoryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            LiveHistoryFragment r4 = this.a;
            if (r4.i == false) goto L10;
            com.bytedance.android.livesdk.drawer.history.e r0 = r4.k;
            if (r0 == null) goto L8;
            r0.a(false);
        L8:
            r4.o.dispose();
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ LiveHistoryFragment a;

        public static final class a<T> implements Predicate {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final boolean test(Object r2) {
                UserEvent r3 = (UserEvent) r2;
                Intrinsics.checkNotNullParameter(r3, "res");
                if (r3.isLogOut() == false) goto L5;
            L8:
                return true;
            L5:
                if (r3.isLogin() == true) goto L8;
                return false;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ g a;

            public b(g r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                if (((UserEvent) r3).isLogin() == false) goto L18;
                LiveHistoryFragment r4 = this.a.a;
                DouyinLoadingLayout r0 = r4.j;
                if (r0 == null) goto L7;
                r0.setVisibility(0);
            L7:
                DouyinLoadingLayout r5 = r4.j;
                if (r5 == null) goto L10;
                r5.b();
            L10:
                View r6 = this.a.a.n;
                if (r6 == null) goto L13;
                r6.setVisibility(8);
            L13:
                FadingEdgeRecyclerview r7 = this.a.a.e;
                if (r7 == null) goto L16;
                r7.setVisibility(0);
            L16:
                this.a.a.T90(0);
                return;
            }
        }

        public g(LiveHistoryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.user.f r5 = k.n(IUserService.class).user();
            Context r0 = this.a.getContext();
            l.a r1 = new l.a();
            r1.c = -1;
            r5.login(r0, new l(r1)).subscribe(this.a.w);
            Disposable r6 = k.n(IUserService.class).user().m().filter(a.a).subscribe(new b(this));
            this.a.o.add(r6);
        }
    }

    static {
    }

    public LiveHistoryFragment() {
        this.f = new MultiTypeAdapter();
        this.g = new Items();
        this.o = new CompositeDisposable();
        NextLiveData<Boolean> r0 = new NextLiveData();
        r0.setValue(Boolean.FALSE);
        Unit r1 = Unit.INSTANCE;
        this.p = r0;
        this.w = new e(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.g.clear();
        this.o.clear();
    }

    public final void S90(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (this.g.isEmpty() == false) goto L5;
    L7:
        this.g.add(r3);
        return;
    L5:
        if ((CollectionsKt.last(this.g) instanceof com.bytedance.android.livesdk.drawer.history.f) == false) goto L7;
        Items r0 = this.g;
        r0.add(r0.size() - 1, r3);
    }

    public final void T90(long r9) {
        FeedExtra r0 = this.h;
        if (r0 == null) goto L7;
        if (((Extra) r0).hasMore == true) goto L7;
        return;
    L7:
        if (this.q == true) goto L11;
        this.p.postValue(Boolean.TRUE);
        this.q = true;
        com.bytedance.android.livesdk.service.l.d().getClass();
        Disposable r10 = ((FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class)).feed(r9, 1, "drawer_hot_live_history", "drawer_hot-live_history").map(b.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
        this.o.add(r10);
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L6:
        y = r3;
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        MultiTypeAdapter r10 = this.f;
        com.bytedance.android.livesdk.drawer.history.e r1 = this.k;
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L5;
        boolean r2 = false;
    L6:
        r10.z2(ScheduledLiveItem.class, new com.bytedance.android.livesdk.drawer.history.c(r1, r2));
        MultiTypeAdapter r11 = this.f;
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L9;
        boolean r3 = false;
    L10:
        r11.z2(PlaceHolder.class, new i(r3));
        this.f.z2(com.bytedance.android.livesdk.drawer.history.a.class, new com.bytedance.android.livesdk.drawer.history.b());
        this.f.z2(com.bytedance.android.livesdk.drawer.history.f.class, new com.bytedance.android.livesdk.drawer.history.g());
        FadingEdgeRecyclerview r12 = this.e;
        ViewGroup.LayoutParams r13 = null;
        if (r12 == null) goto L16;
        final LinearLayoutManager r4 = new LinearLayoutManager(r12.getContext(), 1, false);
        r12.setLayoutManager(r4);
        r12.setAdapter(this.f);
        if (r12.a != null) goto L15;
        r12.a = new m(new ln2.c(r12));
        r12.setOnTouchListener(null);
    L15:
        r12.addOnScrollListener(new LiveHistoryFragment$onViewCreated$$inlined$apply$lambda$1(r4, this));
    L16:
        View r14 = this.d;
        if (r14 == null) goto L20;
        r14.setOnClickListener(new f(this));
    L20:
        if (k.n(IUserService.class).user().isLogin() == true) goto L32;
        View r15 = this.n;
        if (r15 == null) goto L24;
        r15.setVisibility(0);
    L24:
        FadingEdgeRecyclerview r16 = this.e;
        if (r16 == null) goto L27;
        r16.setVisibility(8);
    L27:
        View r17 = this.n;
        if (r17 == null) goto L46;
        View r18 = r17.findViewById(2131370243);
        if (r18 == null) goto L46;
        r18.setOnClickListener(new g(this));
    L46:
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L48;
        boolean r19 = false;
    L49:
        if (r19 == false) goto L92;
        View r20 = this.d;
        int r5 = s1.f(40.0f);
        if (r20 == null) goto L56;
        ViewGroup.LayoutParams r6 = r20.getLayoutParams();
        r6.width = r6.width;
        if (r5 != (-1)) goto L55;
        r5 = r6.height;
    L55:
        r6.height = r5;
        r20.setLayoutParams(r6);
    L56:
        TextView r21 = this.s;
        int r7 = s1.f(40.0f);
        if (r21 == null) goto L62;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        r22.width = r22.width;
        if (r7 != (-1)) goto L61;
        r7 = r22.height;
    L61:
        r22.height = r7;
        r21.setLayoutParams(r22);
    L62:
        TextView r23 = this.s;
        if (r23 == null) goto L65;
        r23.setTextSize(0, s1.f(14.0f));
    L65:
        TextView r24 = this.s;
        if (r24 == null) goto L68;
        r24.setTypeface(Typeface.defaultFromStyle(1));
    L68:
        ImageView r25 = this.t;
        int r26 = s1.f(120.0f);
        int r27 = s1.f(80.0f);
        if (r25 == null) goto L77;
        ViewGroup.LayoutParams r28 = r25.getLayoutParams();
        if (r26 != (-1)) goto L73;
        r26 = r28.width;
    L73:
        r28.width = r26;
        if (r27 != (-1)) goto L76;
        r27 = r28.height;
    L76:
        r28.height = r27;
        r25.setLayoutParams(r28);
    L77:
        TextView r29 = this.u;
        if (r29 == null) goto L80;
        r29.setTextSize(0, s1.f(12.0f));
    L80:
        LinearLayout r30 = this.v;
        if (r30 == null) goto L83;
        a1.o(r30, s1.f(20.0f));
    L83:
        ImageView r31 = this.t;
        if (r31 == null) goto L86;
        r13 = r31.getLayoutParams();
    L86:
        if (r13 == null) goto L91;
        LinearLayout.LayoutParams r32 = (LinearLayout.LayoutParams) r13;
        r32.topMargin = s1.f(120.0f);
        ImageView r33 = this.t;
        if (r33 == null) goto L93;
        r33.setLayoutParams(r32);
        return;
    L93:
        return;
    L91:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L92:
        return;
    L48:
        r19 = e5.n();
        goto L49
    L32:
        DouyinLoadingLayout r34 = this.j;
        if (r34 == null) goto L35;
        r34.setVisibility(0);
    L35:
        DouyinLoadingLayout r35 = this.j;
        if (r35 == null) goto L38;
        r35.b();
    L38:
        View r36 = this.n;
        if (r36 == null) goto L41;
        r36.setVisibility(8);
    L41:
        FadingEdgeRecyclerview r37 = this.e;
        if (r37 == null) goto L44;
        r37.setVisibility(0);
    L44:
        T90(0);
        goto L46
    L9:
        r3 = e5.n();
        goto L10
    L5:
        r2 = e5.n();
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566159, r3, false);
        this.d = r5.findViewById(2131374387);
        this.e = r5.findViewById(2131374419);
        this.j = (DouyinLoadingLayout) r5.findViewById(2131374408);
        this.l = (FrameLayout) r5.findViewById(2131374423);
        this.m = (ViewGroup) r5.findViewById(2131374417);
        this.n = r5.findViewById(2131374409);
        this.s = (TextView) r5.findViewById(2131374427);
        this.t = (ImageView) r5.findViewById(2131371581);
        this.u = (TextView) r5.findViewById(2131371580);
        View r6 = this.n;
        if (r6 == null) goto L5;
        LinearLayout r7 = (LinearLayout) r6.findViewById(2131379179);
    L6:
        this.v = r7;
        return r5;
    L5:
        r7 = null;
        goto L6
    }
}
