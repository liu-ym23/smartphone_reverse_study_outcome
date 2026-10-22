package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite;

import android.content.Context;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeGroupChatViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeHeaderOneAvatarViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeHeaderThreeAvatarViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeHeaderTwoAvatarViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeListEmptyViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeSubTitleViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeTitleViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeUserItemViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeUserRecommendItemViewBinder;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.LambdaObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import py.k;
import zg1.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/ChannelEmptyWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/c;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/InviteeListEmptyViewBinder$a;", "Ls22/e$c;", BuildConfig.FLAVOR, "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelEmptyWidget extends RoomRecyclableWidget implements com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.c, InviteeListEmptyViewBinder.a, s22.e.c {
    public static final /* synthetic */ int i = 0;
    public TextView a;
    public RecyclerView b;
    public MultiTypeAdapter c;
    public final List<Object> d;
    public final Map<String, com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.b> e;
    public final List<com.bytedance.android.live.base.model.user.f> f;
    public final List<com.bytedance.android.live.base.model.user.f> g;
    public CompositeDisposable h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChannelEmptyWidget a;

        public b(ChannelEmptyWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            k1 r3 = (k1) r2;
            ChannelEmptyWidget r4 = this.a;
            int r0 = ChannelEmptyWidget.i;
            r4.yq();
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ IHostUser a;
        public final /* synthetic */ ChannelEmptyWidget b;

        public static final class a implements q {
            public final /* synthetic */ c a;
            public final /* synthetic */ long b;
            public final /* synthetic */ ObservableEmitter c;

            public final void a(List<com.bytedance.android.live.base.model.user.f> r7) {
                ChannelEmptyWidget r0 = this.a.b;
                String r1 = "load recent contacts success. num=" + Integer.valueOf(((ArrayList) r7).size()) + " cost=" + (System.currentTimeMillis() - this.b);
                int r2 = ChannelEmptyWidget.i;
                r0.xq(r1);
                this.c.onNext(r7);
                this.c.onComplete();
            }

            public a(c r1, long r2, ObservableEmitter r4) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
            }
        }

        public c(IHostUser r1, ChannelEmptyWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<List<com.bytedance.android.live.base.model.user.f>> r5) {
            Intrinsics.checkNotNullParameter(r5, "emitter");
            long r0 = System.currentTimeMillis();
            this.a.loadRecentContact(26, new a(this, r0, r5));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ ChannelEmptyWidget b;

        public d(long r1, ChannelEmptyWidget r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            ChannelEmptyWidget r0 = this.b;
            String r8 = "load recommend contacts success. num=" + ((List) r7).size() + " cost=" + (System.currentTimeMillis() - this.a);
            int r1 = ChannelEmptyWidget.i;
            r0.xq(r8);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ChannelEmptyWidget a;

        public e(ChannelEmptyWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ChannelEmptyWidget r0 = this.a;
            int r1 = ChannelEmptyWidget.i;
            r0.getClass();
            ALogger.e("ChannelEmptyWidget", "load recommend contacts failed", (Throwable) r3);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ChannelEmptyWidget a;

        public f(ChannelEmptyWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ArrayList r0 = (ArrayList) this.a.g;
            r0.addAll((List) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ChannelEmptyWidget a;

        public g(ChannelEmptyWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            ChannelEmptyWidget.wq(this.a);
        }
    }

    public static final class h implements Action {
        public final /* synthetic */ ChannelEmptyWidget a;

        public h(ChannelEmptyWidget r1) {
            this.a = r1;
        }

        public final void run() {
            ChannelEmptyWidget.wq(this.a);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ ChannelEmptyWidget a;

        public i(ChannelEmptyWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            RxUtilKt.c((Disposable) r2, this.a.h);
        }
    }

    static {
    }

    @Override // s22.e.c
    public final void Df() {
    }

    @Override // s22.e.c
    public final void Ij(long r1, long r3, Long r5, Long r6, Throwable r7) {
    }

    @Override // s22.e.c
    public final void Nc() {
    }

    @Override // s22.e.c
    public final void Va(long r1) {
    }

    @Override // s22.e.c
    public final void Y9(long r1) {
    }

    @Override // s22.e.c
    public final void a3(long r1, Throwable r3) {
    }

    public final int getLayoutId() {
        return 2131566633;
    }

    @Override // s22.e.c
    public final void p6(long r1) {
    }

    @Override // s22.e.c
    public final void t9(long r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.InviteeListEmptyViewBinder.a
    public final void cd() {
        Context r0 = ((Widget) this).context;
        if (r0 != null) goto L5;
        return;
    L5:
        RoomContext r1 = getRoomContext();
        if (r1 != null) goto L8;
        return;
    L8:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 != null) goto L11;
        return;
    L11:
        s22.e r3 = ChatChannelUtils.b(r1);
        if (r3 != null) goto L14;
        return;
    L14:
        r3.addListener(this);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r10 = new com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e("chat_tab");
        n62.h.a(r0, r1, r2, r3, new n62.i(true, 0, false, r10)).c(this.h);
        j.c(r10);
    }

    public final void onUnload() {
        xq("unload");
        ((ArrayList) this.d).clear();
        MultiTypeAdapter r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("multiTypeAdapter");
    L5:
        r0.notifyDataSetChanged();
        ((ArrayList) this.g).clear();
        ((LinkedHashMap) this.e).clear();
        ((ArrayList) this.f).clear();
        CompositeDisposable r1 = this.h;
        r1.dispose();
        r1.clear();
    }

    public final void yq() {
        ((ArrayList) this.g).clear();
        ((ArrayList) this.f).clear();
        IHostUser r0 = TTLiveSDK.hostService().user();
        if (r0 == null) goto L15;
        Observable r1 = Observable.create(new ChannelEmptyWidget$prepareInviteContactList$$inlined$let$lambda$1(this));
        Observable r2 = Observable.create(new c(r0, this)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread());
        long r3 = System.currentTimeMillis();
        Observable r4 = r0.loadRecommendUserList(20);
        if (r4 == null) goto L9;
        Observable r5 = r4.doOnNext(new d(r3, this));
        if (r5 == null) goto L9;
        Observable r6 = r5.doOnError(new e(this));
    L10:
        if (r6 != null) goto L12;
        Observable r7 = Observable.mergeDelayError(r1, r2);
    L13:
        r7.subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LambdaObserver(new f(this), new g(this), new h(this), new i(this)));
        return;
    L12:
        r7 = Observable.mergeDelayError(r1, r2, r6);
    L9:
        r6 = null;
        goto L10
    }

    public ChannelEmptyWidget() {
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new CompositeDisposable();
    }

    @Override // s22.e.c
    public final void Oo() {
        s22.e r0 = ChatChannelUtils.b(getRoomContext());
        if (r0 == null) goto L6;
        r0.removeListener(this);
        return;
    }

    public static final void wq(ChannelEmptyWidget r15) {
        ((ArrayList) r15.d).clear();
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        RoomContext r5 = r15.getDataContext();
        if (r5 == null) goto L9;
        m r6 = r5.getUser();
        if (r6 == null) goto L9;
        User r7 = (User) r6.getValue();
        if (r7 == null) goto L9;
        k r8 = r7._avatarLarge;
    L11:
        if ((r8 instanceof ImageModel) == true) goto L13;
        r8 = null;
    L13:
        ImageModel r9 = (ImageModel) r8;
        if (r9 != null) goto L16;
        r9 = new ImageModel();
    L16:
        IUserService r10 = jc1.k.f(IUserService.class);
        if (r10 == null) goto L24;
        com.bytedance.android.livesdk.user.f r11 = r10.user();
        if (r11 == null) goto L24;
        IUser r13 = r11.b();
        if (r13 == null) goto L24;
        String r14 = r13.getIdString();
        if (r14 == null) goto L24;
    L25:
        Iterator r16 = ((ArrayList) r15.f).iterator();
    L27:
        if (r16.hasNext() == false) goto L33;
        com.bytedance.android.live.base.model.user.f r17 = (com.bytedance.android.live.base.model.user.f) r16.next();
        Widget.WidgetCallback r18 = ((Widget) r15).widgetCallback;
        if (r18 == null) goto L31;
        WidgetManager r19 = r18.getWidgetManager();
    L32:
        r1.add(new InviteeGroupChatViewBinder.a(r17, r15, r19));
        r4.add(r17);
        goto L27
    L31:
        r19 = null;
        goto L32
    L33:
        Iterator r20 = ((ArrayList) r15.g).iterator();
    L34:
        boolean r110 = false;
        if (r20.hasNext() == false) goto L53;
        com.bytedance.android.live.base.model.user.f r21 = (com.bytedance.android.live.base.model.user.f) r20.next();
        r21.getClass();
        if ((!Intrinsics.areEqual(r14, null)) == false) goto L34;
        Iterator r111 = ((ArrayList) r15.f).iterator();
    L40:
        if (r111.hasNext() == false) goto L44;
        Object r112 = r111.next();
        ((com.bytedance.android.live.base.model.user.f) r112).getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L40;
    L45:
        if (r112 == null) goto L47;
        r110 = true;
    L47:
        if (r110 == true) goto L34;
        Widget.WidgetCallback r113 = ((Widget) r15).widgetCallback;
        if (r113 == null) goto L51;
        WidgetManager r114 = r113.getWidgetManager();
    L52:
        r2.add(new InviteeUserItemViewBinder.a(r21, r15, r114));
        r4.add(r21);
        r0.size();
        goto L34
    L51:
        r114 = null;
        goto L52
    L44:
        r112 = null;
        goto L45
    L53:
        int r23 = 0;
    L55:
        if (r0.size() >= 2) goto L62;
        if (r3.size() <= 0) goto L62;
        if (r23 >= r3.size()) goto L62;
        ((InviteeUserRecommendItemViewBinder.a) ListProtector.get(r3, r23)).a.getClass();
        r23 = r23 + 1;
    L62:
        if (r2.isEmpty() == true) goto L64;
    L71:
        int r24 = r0.size();
        if (r24 == 0) goto L78;
        if (r24 == 1) goto L77;
        if (r24 != 2) goto L79;
        ((ArrayList) r15.d).add(new InviteeHeaderThreeAvatarViewBinder.a(r9, (ImageModel) ListProtector.get(r0, 0), (ImageModel) ListProtector.get(r0, 1)));
    L79:
        TextView r25 = r15.a;
        if (r25 == null) goto L82;
        r25.setVisibility(0);
    L82:
        ((ArrayList) r15.d).add(new InviteeTitleViewBinder.a());
        if (r2.size() <= 0) goto L86;
        ((ArrayList) r15.d).add(new InviteeSubTitleViewBinder.a(s1.B(2131915753)));
        ((ArrayList) r15.d).addAll(r1);
        ((ArrayList) r15.d).addAll(r2);
    L86:
        if (r3.size() <= 0) goto L88;
        ((ArrayList) r15.d).add(new InviteeSubTitleViewBinder.a(s1.B(2131915754)));
        ((ArrayList) r15.d).addAll(r3);
    L88:
        MultiTypeAdapter r26 = r15.c;
        if (r26 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("multiTypeAdapter");
    L91:
        r26.notifyDataSetChanged();
        Widget.WidgetCallback r115 = ((Widget) r15).widgetCallback;
        if (r115 == null) goto L117;
        WidgetManager r116 = r115.getWidgetManager();
        if (r116 == null) goto L118;
        IHostUser r27 = TTLiveSDK.hostService().user();
        if (r27 == null) goto L119;
        r27.fetchActiveStatusList(r116, r4);
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L77:
        ((ArrayList) r15.d).add(new InviteeHeaderTwoAvatarViewBinder.a(r9, (ImageModel) ListProtector.get(r0, 0)));
        goto L79
    L78:
        ((ArrayList) r15.d).add(new InviteeHeaderOneAvatarViewBinder.a(r9));
        goto L79
    L64:
        if (r3.isEmpty() == false) goto L71;
        ((ArrayList) r15.d).clear();
        ((ArrayList) r15.d).add(new InviteeListEmptyViewBinder.b(r15));
        MultiTypeAdapter r28 = r15.c;
        if (r28 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("multiTypeAdapter");
    L68:
        r28.notifyDataSetChanged();
        TextView r117 = r15.a;
        if (r117 == null) goto L115;
        r117.setVisibility(8);
        return;
    L115:
        return;
    L24:
        r14 = BuildConfig.FLAVOR;
    L9:
        r8 = null;
        goto L11
    }

    @Override // s22.e.c
    public final void Dm(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void W5(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void d8(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void gf(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void hb(List<? extends s22.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "channels");
        Intrinsics.checkNotNullParameter(r2, "channels");
    }

    @Override // s22.e.c
    public final void kf(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    public final void onInit(Object[] r3) {
        this.a = (TextView) ((Widget) this).contentView.findViewById(2131368192);
        this.b = ((Widget) this).contentView.findViewById(2131384076);
        MultiTypeAdapter r4 = new MultiTypeAdapter(this.d);
        r4.z2(InviteeHeaderOneAvatarViewBinder.a.class, new InviteeHeaderOneAvatarViewBinder());
        r4.z2(InviteeHeaderTwoAvatarViewBinder.a.class, new InviteeHeaderTwoAvatarViewBinder());
        r4.z2(InviteeHeaderThreeAvatarViewBinder.a.class, new InviteeHeaderThreeAvatarViewBinder());
        r4.z2(InviteeListEmptyViewBinder.b.class, new InviteeListEmptyViewBinder());
        r4.z2(InviteeTitleViewBinder.a.class, new InviteeTitleViewBinder());
        r4.z2(InviteeSubTitleViewBinder.a.class, new InviteeSubTitleViewBinder());
        r4.z2(InviteeGroupChatViewBinder.a.class, new InviteeGroupChatViewBinder());
        r4.z2(InviteeUserItemViewBinder.a.class, new InviteeUserItemViewBinder());
        r4.z2(InviteeUserRecommendItemViewBinder.a.class, new InviteeUserRecommendItemViewBinder());
        Unit r0 = Unit.INSTANCE;
        this.c = r4;
        RecyclerView r1 = this.b;
        if (r1 == null) goto L6;
        r1.setAdapter(r4);
        SSLinearLayoutManager r5 = new SSLinearLayoutManager(r1.getContext());
        r5.setOrientation(1);
        r1.setLayoutManager(r5);
        r1.setItemAnimator(null);
        return;
    }

    public final void onLoad(Object[] r2) {
        xq("load");
        if (this.h.isDisposed() == false) goto L5;
        this.h = new CompositeDisposable();
    L5:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r3 = ChatChannelUtils.f(getRoomContext());
        if (r3 == null) goto L12;
        m<com.bytedance.android.livesdk.interactivity.api.base.d> r4 = r3.getState();
        if (r4 == null) goto L12;
        Disposable r5 = i80.a.a(r4, new AnonymousClass1(this));
        if (r5 == null) goto L12;
        RxUtilKt.c(r5, this.h);
    L12:
        yq();
        TextView r6 = this.a;
        if (r6 == null) goto L15;
        r6.setOnClickListener(x0.a(new ChannelEmptyWidget$onLoad$$inlined$apply$lambda$1(this)));
        r3.e(r6, new ChannelEmptyWidget$onLoad$2$2());
    L15:
        RxUtilKt.c(xs2.b.a().b(k1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.h);
    }

    @Override // s22.e.c
    public final void vg(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    public final void xq(String r2) {
        ALogger.i("ChannelEmptyWidget", r2);
    }

    @Override // s22.e.c
    public final void D9(s22.a r2, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r3) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        s22.e r4 = ChatChannelUtils.b(getRoomContext());
        if (r4 == null) goto L5;
        r4.removeListener(this);
    L5:
        Iterator r5 = ((LinkedHashMap) this.e).entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.b) ((Map.Entry) r5.next()).getValue()).b = false;
        goto L7
    L9:
        ((LinkedHashMap) this.e).clear();
        MultiTypeAdapter r6 = this.c;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("multiTypeAdapter");
    L12:
        r6.notifyDataSetChanged();
    }

    @Override // s22.e.c
    public final void Gh(s22.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "channel");
        Intrinsics.checkNotNullParameter(r1, "channel");
    }

    @Override // s22.e.c
    public final void Hh(long r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    @Override // s22.e.c
    public final void Rn(long r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.c
    public final void bl(com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.b r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "itemUser");
        if (r4 == false) goto L5;
        Map<String, com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.b> r5 = this.e;
        r3.a.getClass();
        r5.put(null, r3);
        return;
    L5:
        Map<String, com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.b> r6 = this.e;
        r3.a.getClass();
        r6.remove(null);
    }
}
