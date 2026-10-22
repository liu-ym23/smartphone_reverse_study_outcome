package bp1;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.ShopGuideApi;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5;
import com.bytedance.android.livesdk.config.setting.o;
import com.bytedance.android.livesdk.config.setting.p;
import com.bytedance.android.livesdk.config.tr0;
import com.bytedance.android.livesdk.config.y9;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.utils.i1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements s<Object> {
    public static final /* synthetic */ int h = 0;
    public RecyclerView a;
    public TextView b;
    public View c;
    public DouyinLoadingLayout d;
    public MultiTypeAdapter e;
    public boolean f;
    public final bp1.e g;

    /* JADX INFO: renamed from: bp1.a$a, reason: collision with other inner class name */
    public static final class C0002a {
    }

    public static final class b implements bp1.h {
        public final WeakReference<Context> a;

        /* JADX INFO: renamed from: bp1.a$b$a, reason: collision with other inner class name */
        public static final class C0003a<T1, T2, R> implements BiFunction {
            public static final C0003a a = null;

            static {
                a = new C0003a();
            }

            public C0003a() {
            }

            public final Object apply(Object r7, Object r8) {
                List r9 = (List) r7;
                List r10 = (List) r8;
                Intrinsics.checkNotNullParameter(r9, "userList");
                Intrinsics.checkNotNullParameter(r10, "thirdPartList");
                ArrayList r0 = new ArrayList();
                List r11 = r10;
                Iterator r1 = r11.iterator();
            L3:
                Object r3 = null;
                if (r1.hasNext() == false) goto L8;
                Object r2 = r1.next();
                if (Intrinsics.areEqual(((bp1.d) r2).getType(), "share_to_story") == false) goto L3;
            L9:
                bp1.d r4 = (bp1.d) r2;
                if (r4 == null) goto L12;
                r0.add(r4);
            L12:
                Iterator r5 = r11.iterator();
            L14:
                if (r5.hasNext() == false) goto L18;
                Object r6 = r5.next();
                if (Intrinsics.areEqual(((bp1.d) r6).getType(), "weixin") == false) goto L14;
            L19:
                bp1.d r12 = (bp1.d) r6;
                if (r12 == null) goto L22;
                r0.add(r12);
            L22:
                Iterator r13 = r11.iterator();
            L24:
                if (r13.hasNext() == false) goto L28;
                Object r14 = r13.next();
                if (Intrinsics.areEqual(((bp1.d) r14).getType(), "qq") == false) goto L24;
                r3 = r14;
            L28:
                bp1.d r15 = (bp1.d) r3;
                if (r15 == null) goto L31;
                r0.add(r15);
            L31:
                r0.addAll(r9);
                return r0;
            L18:
                r6 = null;
                goto L19
            L8:
                r2 = null;
                goto L9
            }
        }

        /* JADX INFO: renamed from: bp1.a$b$b, reason: collision with other inner class name */
        public static final class C0004b<T, R> implements Function {
            public static final C0004b a = null;

            static {
                a = new C0004b();
            }

            public C0004b() {
            }

            public final Object apply(Object r2) {
                Intrinsics.checkNotNullParameter((Throwable) r2, "it");
                int r3 = a.h;
                ALogger.e("ExtShareEnhancePanel", "zip list error.");
                return CollectionsKt.emptyList();
            }
        }

        @Override // bp1.h
        public final Observable<List<bp1.d>> a() {
            return Observable.zip(Observable.create(c.C0005a.a).compose(RxUtil.rxSchedulerHelper()).onErrorReturn(c.b.a), new d(this.a).a(), C0003a.a).compose(RxUtil.rxSchedulerHelper()).onErrorReturn(C0004b.a);
        }

        public b(WeakReference<Context> r2) {
            Intrinsics.checkNotNullParameter(r2, "contextRef");
            this.a = r2;
        }
    }

    public static final class c implements bp1.h {

        /* JADX INFO: renamed from: bp1.a$c$a, reason: collision with other inner class name */
        public static final class C0005a<T> implements ObservableOnSubscribe {
            public static final C0005a a = null;

            /* JADX INFO: renamed from: bp1.a$c$a$a, reason: collision with other inner class name */
            public static final class C0006a implements q {
                public final /* synthetic */ ObservableEmitter a;

                public C0006a(ObservableEmitter r1) {
                    this.a = r1;
                }

                public final void a(List<com.bytedance.android.live.base.model.user.f> r7) {
                    ArrayList r0 = new ArrayList();
                    if ((!r7.isEmpty()) == false) goto L5;
                    List<com.bytedance.android.live.base.model.user.f> r1 = r7;
                L6:
                    if (r1 == null) goto L11;
                    Iterator<T> r2 = r1.iterator();
                L9:
                    if (r2.hasNext() == false) goto L11;
                    ((com.bytedance.android.live.base.model.user.f) r2.next()).getClass();
                L11:
                    int r3 = r0.size();
                    int r4 = a.h;
                    if (r3 < 25) goto L14;
                    r0.add(new bp1.f("chat_merge", s1.B(2131916004), 2131251498));
                L14:
                    this.a.onNext(r0);
                    this.a.onComplete();
                    RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
                    if (r5 == null) goto L25;
                    n r6 = r5.getFragmentInfoGetter();
                    if (r6 == null) goto L25;
                    h80.d r8 = (h80.d) r6.getValue();
                    if (r8 == null) goto L25;
                    Pair r9 = (Pair) r8.get();
                    if (r9 == null) goto L25;
                    Fragment r10 = (Fragment) r9.getFirst();
                    if (r10 == null) goto L25;
                    TTLiveSDK.hostService().user().fetchActiveStatusList(r10, r7);
                L25:
                    ALogger.i("ExtShareEnhancePanel", "recent user ok.");
                    return;
                L5:
                    r1 = null;
                    goto L6
                }
            }

            static {
                a = new C0005a();
            }

            public C0005a() {
            }

            public final void subscribe(ObservableEmitter<List<bp1.d>> r3) {
                Intrinsics.checkNotNullParameter(r3, "it");
                IHostUser r0 = TTLiveSDK.hostService().user();
                int r1 = a.h;
                r0.loadRecentContact(25, new C0006a(r3));
            }
        }

        public static final class b<T, R> implements Function {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final Object apply(Object r3) {
                Throwable r4 = (Throwable) r3;
                Intrinsics.checkNotNullParameter(r4, "it");
                int r0 = a.h;
                ALogger.e("ExtShareEnhancePanel", "get recent user list error: " + r4);
                return CollectionsKt.emptyList();
            }
        }

        public c() {
        }

        @Override // bp1.h
        public final Observable<List<bp1.d>> a() {
            return Observable.create(C0005a.a).compose(RxUtil.rxSchedulerHelper()).onErrorReturn(b.a);
        }
    }

    public static final class d implements bp1.h {
        public final WeakReference<Context> a;

        /* JADX INFO: renamed from: bp1.a$d$a, reason: collision with other inner class name */
        public static final class C0007a<T, R> implements Function {
            public static final C0007a a = null;

            static {
                a = new C0007a();
            }

            public C0007a() {
            }

            public final Object apply(Object r2) {
                Intrinsics.checkNotNullParameter((Throwable) r2, "it");
                int r3 = a.h;
                ALogger.e("ExtShareEnhancePanel", "get 3rd list error.");
                return CollectionsKt.emptyList();
            }
        }

        @Override // bp1.h
        public final Observable<List<bp1.d>> a() {
            Context r0 = this.a.get();
            ArrayList r1 = new ArrayList();
            Room r6 = null;
            RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r2 == null) goto L7;
            m r3 = r2.getRoom();
            if (r3 == null) goto L7;
            r6 = (Room) r3.getValue();
        L7:
            Map r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.b.a(r6);
            if (p.a() == false) goto L20;
            if (r4 == null) goto L20;
            String r5 = (String) r4.get("ShareStory");
            if (r5 == null) goto L20;
            if (r5.equals("1") != true) goto L20;
            IMiddlewareHostApp r7 = k.f(IMiddlewareHostApp.class);
            if (r7 == null) goto L18;
            String r8 = r7.replaceBrand(2131922518);
            if (r8 == null) goto L18;
        L19:
            r1.add(new bp1.f("share_to_story", r8, 2131251486));
        L18:
            r8 = "转发日常";
        L20:
            r1.add(new bp1.f("chat_merge", s1.B(2131915953), 2131251507));
            if (puc.a.isInstalledApp(r0, "com.tencent.mm") == false) goto L23;
            r1.add(new bp1.f("weixin", s1.B(2131922894), 2131251510));
            r1.add(new bp1.f("weixin_moments", s1.B(2131922895), 2131251511));
        L23:
            r1.add(new bp1.f("link", s1.B(2131920493), 2131251490));
            if (puc.a.isInstalledApp(r0, "com.tencent.mobileqq") == false) goto L27;
            r1.add(new bp1.f("qq", s1.B(2131922892), 2131251502));
            r1.add(new bp1.f("qzone", s1.B(2131922893), 2131251503));
        L27:
            if (puc.a.isInstalledApp(r0, "com.sina.weibo") == false) goto L29;
            r1.add(new bp1.f("weibo", s1.B(2131922896), 2131251513));
        L29:
            r1.add(new bp1.f("qr_code", s1.B(2131920495), 2131251504));
            return Observable.just(CollectionsKt.toList(r1)).compose(RxUtil.rxSchedulerHelper()).onErrorReturn(C0007a.a);
        }

        public d(WeakReference<Context> r2) {
            Intrinsics.checkNotNullParameter(r2, "contextRef");
            this.a = r2;
        }
    }

    public static final class e<T1, T2, R> implements BiFunction {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r3, Object r4) {
            bp1.i r5 = (bp1.i) r3;
            List r6 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "shopData");
            Intrinsics.checkNotNullParameter(r6, "itemList");
            a r0 = this.a;
            r0.f = true;
            if (r5.c == false) goto L7;
            TextView r1 = r0.b;
            if (r1 == null) goto L10;
            r1.setText(2131922511);
        L10:
            int r2 = a.h;
            ALogger.i("ExtShareEnhancePanel", "data is ok.");
            Iterator r7 = r6.iterator();
        L12:
            if (r7.hasNext() == false) goto L14;
            ((bp1.d) r7.next()).h = r5;
            goto L12
        L14:
            return r6;
        L7:
            TextView r8 = r0.b;
            if (r8 == null) goto L10;
            r8.setText(2131916463);
            goto L10
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ DataCenter b;

        public f(a r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            List r8 = (List) r7;
            a r0 = this.a;
            r0.f = true;
            DouyinLoadingLayout r1 = r0.d;
            if (r1 == null) goto L5;
            r1.c();
        L5:
            ArrayList r2 = new ArrayList();
            if (r8 == null) goto L10;
            List r9 = r8;
            if ((!r9.isEmpty()) != true) goto L10;
            r2.addAll(r9);
        L10:
            Iterator r10 = r2.iterator();
        L11:
            String r3 = null;
            if (r10.hasNext() == false) goto L16;
            Object r4 = r10.next();
            if (Intrinsics.areEqual(((bp1.d) r4).getType(), "share_to_story") == false) goto L11;
        L18:
            if (((bp1.d) r4) == null) goto L40;
            a r11 = this.a;
            DataCenter r5 = this.b;
            r11.getClass();
            if (r5 == null) goto L22;
            Room r12 = (Room) r5.get("data_room", null);
        L23:
            HashMap r6 = new HashMap();
            if (r12 == null) goto L26;
            String r13 = r12.getOwnerUserIdString();
        L27:
            r6.put("anchor_id", String.valueOf(r13));
            if (r12 == null) goto L30;
            r3 = r12.getIdStr();
        L30:
            r6.put("room_id", String.valueOf(r3));
            r6.put("enter_from_merge", String.valueOf(u.l().c(x.class).getMap().get("enter_from_merge")));
            r6.put("enter_method", String.valueOf(u.l().c(x.class).getMap().get("enter_method")));
            r6.put("event_page", "live_detail");
            r6.put("request_page", "more");
            if (r12 == null) goto L37;
            User r14 = r12.getOwner();
            if (r14 == null) goto L37;
            if (r14.isFollowing() != true) goto L37;
            String r15 = "1";
        L38:
            r6.put("is_fans", r15);
            u.l().sendLog("livesdk_share_to_diary_show", r6, new Object[]{new x(), Room.class});
        L37:
            r15 = "0";
            goto L38
        L26:
            r13 = null;
            goto L27
        L22:
            r12 = null;
        L40:
            if (r2.size() <= 3) goto L44;
            View r16 = this.a.c;
            if (r16 == null) goto L48;
            UtilityKotlinExtentionsKt.w(r16);
        L48:
            MultiTypeAdapter r17 = this.a.e;
            if (r17 == null) goto L51;
            r17.a = r2;
        L51:
            if (r17 == null) goto L53;
            r17.notifyDataSetChanged();
        L53:
            int r18 = a.h;
            ALogger.i("ExtShareEnhancePanel", "load success.");
            return;
        L44:
            View r19 = this.a.c;
            if (r19 == null) goto L47;
            UtilityKotlinExtentionsKt.u(r19);
        L47:
            this.a.getClass();
            r2.add(new bp1.f("host_share_dialog", s1.B(2131920494), 2131250547));
            goto L48
        L16:
            r4 = null;
            goto L18
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ a a;

        public g(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            a r4 = this.a;
            r4.f = true;
            DouyinLoadingLayout r5 = r4.d;
            if (r5 == null) goto L5;
            r5.c();
        L5:
            int r6 = a.h;
            ALogger.e("ExtShareEnhancePanel", "load share panel data error.");
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ DataCenter a;

        public h(DataCenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            c0.b r4 = y3.f(this.a).t(ToolbarButton.SHARE);
            if ((r4 instanceof e5) == true) goto L5;
            r4 = null;
        L5:
            e5 r5 = (e5) r4;
            if (r5 == null) goto L8;
            r5.o = "ext_more";
            r5.onClick(null);
            r5.o = "";
        L8:
            DataCenter r6 = this.a;
            if (r6 == null) goto L12;
            r6.put("cmd_live_toolbarmore_dialog_dismiss", Boolean.TRUE);
            return;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ a a;

        public i(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L8
            if (r0.f == true) goto L11;
            DouyinLoadingLayout r1 = r0.d;     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.b();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void j() {
        this.a = null;
        this.e = null;
    }

    public a() {
        this.g = new bp1.e();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final View x(ViewGroup r4, float r5, com.bytedance.android.livesdk.chatroom.e r6) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        View r7 = LayoutInflater.from(r4.getContext()).inflate(2131567866, r4, false);
        DouyinLoadingLayout r8 = null;
        if (r7 == null) goto L5;
        TextView r9 = (TextView) r7.findViewById(2131363231);
    L6:
        this.b = r9;
        if (r7 == null) goto L9;
        RecyclerView r10 = (RecyclerView) r7.findViewById(2131363227);
    L10:
        this.a = r10;
        if (r7 == null) goto L13;
        View r11 = r7.findViewById(2131371980);
    L14:
        this.c = r11;
        if (r7 == null) goto L17;
        r8 = (DouyinLoadingLayout) r7.findViewById(2131371983);
    L17:
        this.d = r8;
        if (r8 == null) goto L20;
        r8.postDelayed(new i(this), 300);
    L20:
        RecyclerView r12 = this.a;
        if (r12 == null) goto L26;
        r12.setLayoutManager(new LinearLayoutManager(r12.getContext(), 0, false));
        MultiTypeAdapter r13 = new MultiTypeAdapter();
        r13.z2(bp1.d.class, this.g);
        Unit r14 = Unit.INSTANCE;
        this.e = r13;
        RecyclerView r15 = this.a;
        if (r15 == null) goto L26;
        r15.setAdapter(r13);
    L26:
        return r7;
    L13:
        r11 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void o(WeakReference<b2> r18, Object r19, View r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "button");
        Intrinsics.checkNotNullParameter(r20, "itemView");
        if (r18 == null) goto L76;
        b2 r1 = r18.get();
        if (r1 == null) goto L78;
        DataCenter r2 = r1.getDataCenter();
        if (r2 != null) goto L10;
        return;
    L10:
        this.g.b = r2;
        Room r3 = z.o(r2);
        if (r3 == null) goto L13;
        i1.d(r3, "click");
    L13:
        CompositeDisposable r4 = r1.getCompositeDisposable();
        if (r4 != null) goto L16;
        r4 = new CompositeDisposable();
    L16:
        boolean r5 = false;
        Single r6 = Single.just(new bp1.i(0));
        int r7 = com.bytedance.android.livesdk.chatroom.utils.y3.a;
        bp1.h r8 = null;
        Context r9 = null;
        Context r10 = null;
        if (y9.a.getValue().booleanValue() == true) goto L19;
    L34:
        Observable r11 = r6.toObservable();
        if (o.b() == true) goto L37;
    L39:
        boolean r12 = false;
    L40:
        if (r12 == false) goto L43;
        r8 = new c();
    L64:
        if (r8 == null) goto L68;
        Observable<List<bp1.d>> r13 = r8.a();
        if (r13 == null) goto L68;
    L69:
        Disposable r14 = Observable.zip(r11, r13, new e(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r2), new g(this));
        if (r14 == null) goto L72;
        RxUtilKt.c(r14, r4);
    L72:
        View r15 = this.c;
        if (r15 == null) goto L77;
        r15.setOnClickListener(new h(r2));
        return;
    L77:
        return;
    L68:
        r13 = Observable.just(CollectionsKt.emptyList());
        goto L69
    L43:
        if (o.b() == true) goto L45;
    L47:
        boolean r16 = false;
    L48:
        if (r16 == false) goto L55;
        RecyclerView r17 = this.a;
        if (r17 == null) goto L52;
        r9 = r17.getContext();
    L52:
        bp1.h r22 = new d(new WeakReference(r9));
    L53:
        r8 = r22;
        goto L64
    L55:
        if (o.b() == true) goto L57;
    L59:
        if (r5 == false) goto L64;
        RecyclerView r23 = this.a;
        if (r23 == null) goto L63;
        r10 = r23.getContext();
    L63:
        r22 = new b(new WeakReference(r10));
        goto L53
    L57:
        if (tr0.a.getValue().c() != 3) goto L59;
        r5 = true;
        goto L59
    L45:
        if (tr0.a.getValue().c() != 2) goto L47;
        r16 = true;
        goto L48
    L37:
        if (tr0.a.getValue().c() != 1) goto L39;
        r12 = true;
        goto L40
    L19:
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L34;
        if (tb1.c.g == false) goto L34;
        long r24 = z.o(r2).getId();
        String r110 = z.o(r2).getOwnerUserIdString();
        Intrinsics.checkNotNullParameter(r110, "userId");
        l.d().getClass();
        ShopGuideApi r25 = (ShopGuideApi) com.bytedance.android.live.network.c.b().e(ShopGuideApi.class);
        if (r25 == null) goto L25;
        Single r26 = r25.queryShopGuideId(r24, r110, null, null, null, null, null, null);
    L26:
        if (r26 == null) goto L34;
        Single r27 = r26.compose(RxUtil.rxSchedulerHelper());
        if (r27 == null) goto L34;
        Single r28 = r27.map(bp1.b.a);
        if (r28 == null) goto L34;
        Single r29 = r28.onErrorReturn(bp1.c.a);
        if (r29 == null) goto L34;
        r6 = r29;
        goto L34
    L25:
        r26 = null;
        goto L26
    L78:
        return;
    }
}
