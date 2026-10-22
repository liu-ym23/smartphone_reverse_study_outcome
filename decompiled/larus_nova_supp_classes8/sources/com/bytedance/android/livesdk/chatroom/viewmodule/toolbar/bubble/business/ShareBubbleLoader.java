package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.ConfigCompatFixLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.g81;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ShareBubbleLoader extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a {
    public final String b;
    public final CompositeDisposable c;
    public final Lazy d;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {
        public final ToolbarButton a;
        public final pp1.c b;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a getCallback() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return BubbleId.Share;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final ToolbarButton a() {
            return this.a;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final pp1.c getView() {
            return this.b;
        }

        public a(ShareBubbleLoader r5) {
            this.a = ToolbarButton.SHARE;
            int r0 = pp1.c.o;
            String r1 = ((g81) r5.d.getValue()).a();
            Intrinsics.checkNotNullParameter(r1, "content");
            pp1.c.a.C0410a r2 = new pp1.c.a.C0410a(r1);
            r2.b = (int) ((g81) r5.d.getValue()).b();
            this.b = r2.a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business.ShareBubbleLoader$onLoad$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ ShareBubbleLoader this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business.ShareBubbleLoader$onLoad$1$a */
        public static final class a<T> implements Consumer {
            public final /* synthetic */ AnonymousClass1 a;

            public a(AnonymousClass1 r1) {
                this.a = r1;
            }

            public final void accept(Object r6) {
                Long r7 = (Long) r6;
                boolean r8 = y3.m(this.a.this$0.a.c).n(ToolbarButton.SHARE);
                boolean r0 = jc1.k.n(IUserService.class).user().isLogin();
                if (r8 == true) goto L25;
                if (r0 == false) goto L25;
                DataCenter r9 = this.a.this$0.a.c;
                if (r9 == null) goto L39;
                Room r10 = z.o(r9);
                if (r10 == null) goto L40;
                long r1 = r10.getRoomId();
                com.bytedance.android.live.network.c r11 = com.bytedance.android.live.network.c.b();
                if (r11 == null) goto L41;
                RoomRetrofitApi r12 = (RoomRetrofitApi) r11.e(RoomRetrofitApi.class);
                if (r12 == null) goto L42;
                Observable r13 = r12.getRoomInfoByScene(r1, "toolbar_bubble_audience");
                if (r13 == null) goto L43;
                Observable r14 = r13.observeOn(AndroidSchedulers.mainThread());
                if (r14 == null) goto L44;
                Observable r15 = r14.subscribeOn(Schedulers.io());
                if (r15 == null) goto L45;
                Observable r16 = r15.map(l.a);
                if (r16 == null) goto L46;
                Disposable r17 = r16.subscribe(new m(this), n.a);
                if (r17 == null) goto L47;
                RxUtilKt.c(r17, this.a.this$0.c);
                return;
            L47:
                return;
            L46:
                return;
            L45:
                return;
            L44:
                return;
            L43:
                return;
            L42:
                return;
            L41:
                return;
            L40:
                return;
            L39:
                return;
            L25:
                MorePanelBubbleAlog.SimpleAlogArgsBuilder r2 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
                r2.d(this.a.this$0.b);
                r2.c("因频控无法加载分享引导气泡");
                int r4 = 0;
                Pair[] r3 = {TuplesKt.to("shareInUnfold", Boolean.valueOf(r8)), TuplesKt.to("login", Boolean.valueOf(r0))};
            L26:
                if (r4 >= 2) goto L33;
                Pair r18 = r3[r4];
                if (r18 == null) goto L32;
                Object r5 = r18.getSecond();
                if (r5 == null) goto L32;
                r2.a((String) r18.getFirst(), r5);
            L32:
                r4 = r4 + 1;
                goto L26
            L33:
                MorePanelBubbleAlog.a(r2.b());
            }
        }

        public AnonymousClass1(ShareBubbleLoader r1) {
            this.this$0 = r1;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m187invoke() {
            RxUtilKt.c(RxUtilKt.h(Observable.timer(10, TimeUnit.SECONDS)).subscribe(new a(this)), this.this$0.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m187invoke();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final boolean S8() {
        DataCenter r0 = this.a.c;
        if (r0 == null) goto L9;
        int r3 = ConfigCompatFixLoader.i;
        if (ConfigCompatFixLoader.a.a(r0) == true) goto L9;
        if (((g81) this.d.getValue()).c() != 1) goto L9;
        boolean r1 = true;
    L10:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r4 = this.a.a().query(BubbleId.Share);
        if (r4 != null) goto L13;
    L16:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r2 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r2.d(this.b);
        r2.c("checkCanLoad");
        r2.a("enable", Boolean.valueOf(r1));
        MorePanelBubbleAlog.a(r2.b());
        return r1;
    L13:
        if (r4.g() != true) goto L16;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r5 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r5.d(this.b);
        r5.c("因频控无法加载分享引导气泡");
        MorePanelBubbleAlog.a(r5.b());
        return false;
    L9:
        r1 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return new a(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        AnonymousClass1 r0 = new AnonymousClass1(this);
        ILivePlayerClient r1 = LivePlatformPlayerManager.f();
        Boolean r2 = null;
        if (r1 == null) goto L7;
        IRoomEventHub r3 = r1.getEventHub();
        if (r3 == null) goto L7;
        MutableLiveData r4 = r3.getFirstFrame();
    L8:
        if (r4 == null) goto L11;
        r2 = (Boolean) r4.getValue();
    L11:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L13;
        r0.invoke();
        return;
    L13:
        k r5 = new k(r0);
        if (r4 == null) goto L16;
        r4.observeForever(r5);
    L16:
        this.c.add(Disposables.fromAction(new j(r4, r5)));
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
        this.c.clear();
    }

    public ShareBubbleLoader(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.b = "ShareBubbleLoader";
        this.c = new CompositeDisposable();
        this.d = LazyKt.lazy(ShareBubbleLoader$setting$2.INSTANCE);
    }
}
