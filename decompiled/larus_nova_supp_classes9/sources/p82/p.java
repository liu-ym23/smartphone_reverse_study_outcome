package p82;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.b7;
import com.bytedance.android.livesdk.c7;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.h6;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.MarkUserApi;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends p82.a {
    public LiveSwitchButton e;
    public ImageView f;
    public TextView g;
    public boolean h;
    public final String i;
    public int j;
    public boolean k;
    public String l;
    public String m;
    public final String n;
    public final com.bytedance.android.livesdk.sharedpref.e<Boolean> o;
    public final Long p;
    public final long q;
    public CompositeDisposable r;
    public final RoomContext s;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            TextView r3 = this.a.g;
            if (r3 == null) goto L6;
            UtilityKotlinExtentionsKt.t(r3);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ p a;

        public c(p r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.c r5 = (com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.c) ((BaseResponse) ((Response) r4)).data;
            if (r5 == null) goto L5;
            Boolean r6 = r5.a();
        L6:
            boolean r0 = false;
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L11;
            LiveSwitchButton r7 = this.a.e;
            if (r7 == null) goto L11;
            r7.f(false, false);
        L11:
            p r8 = this.a;
            LiveSwitchButton r1 = r8.e;
            if (r1 != null) goto L14;
        L16:
            r8.h = r0;
            p r9 = this.a;
            if (r9.h == false) goto L19;
            String r2 = "on";
        L20:
            r9.l = r2;
            return;
        L19:
            r2 = "off";
            goto L20
        L14:
            if (r1.isChecked() != true) goto L16;
            r0 = true;
            goto L16
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ALogger.e("PSOperatePanel", "get user mark status error");
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ p a;
        public final /* synthetic */ IBaseUser b;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ e a;

            public a(e r1) {
                this.a = r1;
            }

            public final void accept(Object r10) {
                BaseResponse r11 = (BaseResponse) r10;
                LiveSwitchButton r13 = this.a.a.e;
                boolean r0 = false;
                if (r13 == null) goto L5;
                r13.f(false, false);
            L5:
                LiveSwitchButton r14 = this.a.a.e;
                if (r14 == null) goto L8;
                r14.setEnabled(false);
            L8:
                p.f(this.a.a);
                p r15 = this.a.a;
                LiveSwitchButton r1 = r15.e;
                if (r1 != null) goto L11;
            L13:
                boolean r2 = false;
            L14:
                r15.h = r2;
                if (this.a.a.h == false) goto L17;
                f2.c(s1.B(2131920211), 0);
            L18:
                p r16 = this.a.a;
                r16.k = true;
                Map r17 = MapsKt.mapOf(TuplesKt.to("event_user_type", r16.d()));
                int r3 = com.bytedance.android.livesdk.interactivity.utils.r.a;
                long r4 = this.a.a.d.getId();
                RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
                if (r5 == null) goto L25;
                com.bytedance.live.datacontext.i r6 = r5.isAnchor();
                if (r6 == null) goto L25;
                if (((Boolean) r6.getValue()).booleanValue() != true) goto L25;
                r0 = true;
            L25:
                com.bytedance.android.livesdk.interactivity.utils.r.a(r4, r0, r17);
                return;
            L17:
                f2.c(s1.B(2131923001), 0);
                goto L18
            L11:
                if (r1.isChecked() != true) goto L13;
                r2 = true;
                goto L14
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ e a;

            public b(e r1) {
                this.a = r1;
            }

            public final void accept(Object r6) {
                CustomApiServerException r7 = (Throwable) r6;
                LiveSwitchButton r0 = this.a.a.e;
                if (r0 == null) goto L5;
                r0.setEnabled(false);
            L5:
                p.f(this.a.a);
                String r1 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r7);
                if (r1 == null) goto L9;
                f2.c(r1, 0);
            L9:
                if (4021040 != com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r7)) goto L30;
                User r2 = ((Room) this.a.a.s.getRoom().getValue()).getOwner();
                String r3 = BuildConfig.FLAVOR;
                if (r2 == null) goto L14;
                String r4 = r2.getIdString();
                if (r4 == null) goto L14;
            L16:
                if ((r7 instanceof CustomApiServerException) == true) goto L28;
            L25:
                r3 = null;
            L26:
                com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_tag_priority_display_user_upper_limit_toast", MapsKt.mapOf(new Pair[]{TuplesKt.to("anchor_id", r4), TuplesKt.to("upper_limit_user_number", r3)}), new Object[]{Room.class});
                return;
            L28:
                com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.d r8 = (com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.d) GsonHelper.get().fromJson(r7.getExtra(), com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.d.class);     // Catch: Exception -> L23
                if (r8 == null) goto L26;
                String r9 = String.valueOf(r8.a());     // Catch: Exception -> L23
                if (r9 == null) goto L26;
                r3 = r9;
            L23:
                e = move-exception;
                ALogger.e("PSOperatePanel", "MarkUserItem limit parse error,e:" + e.getMessage());
            L14:
                r4 = BuildConfig.FLAVOR;
                goto L16
            }
        }

        public e(p r1, IBaseUser r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            if (this.a.h == false) goto L5;
            long r0 = 2;
        L6:
            long r6 = r0;
            MarkUserApi.a.getClass();
            MarkUserApi r2 = (MarkUserApi) com.bytedance.android.live.network.c.b().e(MarkUserApi.class);
            if (r2 == null) goto L22;
            IBaseUser r10 = this.b;
            if (r10 == null) goto L11;
            String r11 = r10.getIdString();
        L12:
            long r3 = d5.c(r11);
            IBaseUser r13 = this.b;
            if (r13 == null) goto L16;
            String r14 = r13.getIdString();
            if (r14 == null) goto L16;
        L17:
            Observable<BaseResponse<Object, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.d>> r15 = r2.markUser(r3, r14, r6);
            if (r15 == null) goto L22;
            Disposable r16 = r15.subscribe(new a(this), new b(this));
            if (r16 == null) goto L22;
            RxUtilKt.c(r16, this.a.r);
        L16:
            r14 = BuildConfig.FLAVOR;
            goto L17
        L11:
            r11 = null;
        L22:
            TextView r17 = this.a.g;
            if (r17 == null) goto L26;
            UtilityKotlinExtentionsKt.t(r17);
            return;
        L26:
            return;
        L5:
            r0 = 1;
            goto L6
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ p a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e b;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.entity.l c;

        public f(p r1, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r2, com.bytedance.android.livesdk.interactivity.api.entity.l r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            TextView r4 = this.a.g;
            if (r4 == null) goto L5;
            UtilityKotlinExtentionsKt.t(r4);
        L5:
            this.a.j = RangesKt.coerceAtLeast(400, (int) s1.G(this.b.ot()));
            String r5 = this.a.i + this.a.j;
            ILiveService r0 = TTLiveService.getLiveService();
            if (r0 == null) goto L9;
            r0.handleSchema(this.c.getContext(), UriProtector.parse(r5));
            return;
        }
    }

    static {
    }

    @Override // p82.a
    public final int e() {
        return 2131567223;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onDestroyView() {
        CompositeDisposable r0 = this.r;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.r = null;
        if (this.h == false) goto L8;
        String r1 = "on";
    L9:
        this.m = r1;
        if (this.k == false) goto L27;
        com.bytedance.android.livesdk.interactivity.api.entity.l r2 = this.b;
        if (r2 == null) goto L14;
        com.bytedance.android.live.base.model.message.t r3 = r2.b;
    L16:
        if ((r3 instanceof u3) == true) goto L18;
        r3 = null;
    L18:
        u3 r4 = (u3) r3;
        if (r4 == null) goto L21;
        IBaseUser r5 = r4.getUserInMessage();
    L22:
        Pair[] r6 = new Pair[4];
        r6[0] = TuplesKt.to("status_before", this.l);
        r6[1] = TuplesKt.to("status_after", this.m);
        r6[2] = TuplesKt.to("page_from", "comment_operate_panel");
        if (r5 == null) goto L25;
        String r7 = r5.getIdString();
    L26:
        r6[3] = TuplesKt.to("user_id", r7);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_tag_priority_display_user_click", MapsKt.mapOf(r6), new Object[]{Room.class});
        goto L27
    L25:
        r7 = null;
        goto L26
    L21:
        r5 = null;
        goto L22
    L14:
        r3 = null;
    L27:
        this.a = null;
        return;
    L8:
        r1 = "off";
        goto L9
    }

    public p(RoomContext r4) {
        Intrinsics.checkNotNullParameter(r4, "roomContext");
        super(PanelItemSymbol.MARK_USER);
        this.s = r4;
        this.i = (String) c7.a.getValue();
        this.l = "off";
        this.m = "off";
        this.n = (String) b7.a.getValue();
        this.o = new com.bytedance.android.livesdk.sharedpref.e("mark_user_bubble_" + ((User) r4.getUser().getValue()).getIdString(), Boolean.FALSE);
        this.p = (Long) h6.a.getValue();
        this.q = 5000;
    }

    public static final void f(p r3) {
        RxUtilKt.c(RxUtilKt.h(Observable.timer(r3.p.longValue(), TimeUnit.MILLISECONDS)).subscribe(new q(r3)), r3.r);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        RoomAuthStatus r0 = ((Room) this.s.getRoom().getValue()).getRoomAuthStatus();
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        com.bytedance.android.live.base.model.message.t r3 = r8.b;
        k0 r5 = null;
        if ((r3 instanceof u3) == true) goto L13;
        r3 = null;
    L13:
        u3 r4 = (u3) r3;
        if (r4 == null) goto L16;
        IBaseUser r6 = r4.getUserInMessage();
    L18:
        if ((r6 instanceof User) == true) goto L20;
        r6 = null;
    L20:
        User r7 = (User) r6;
        IUserService r9 = jc1.k.f(IUserService.class);
        if (r9 == null) goto L26;
        com.bytedance.android.livesdk.user.f r10 = r9.user();
        if (r10 == null) goto L26;
        String r11 = r10.n();
        if (r11 == null) goto L26;
    L27:
        if (r7 != null) goto L29;
    L33:
        boolean r13 = false;
    L34:
        com.bytedance.android.live.base.model.message.t r14 = r8.b;
        if ((r14 instanceof k0) == true) goto L37;
        r14 = null;
    L37:
        k0 r15 = (k0) r14;
        if (r15 != null) goto L40;
    L50:
        boolean r16 = true;
    L51:
        if (r1 == false) goto L56;
        if (r13 == false) goto L57;
        if (r16 == false) goto L58;
        return true;
    L58:
        return false;
    L57:
        return false;
    L56:
        return false;
    L40:
        if (r15.isFromOtherIntercomRoom() != true) goto L50;
        k0 r17 = r8.b;
        if ((r17 instanceof k0) == false) goto L45;
        r5 = r17;
    L45:
        k0 r18 = r5;
        if (r18 == null) goto L50;
        if (r18.intercomHideUserCard() != true) goto L50;
        r16 = false;
        goto L51
    L29:
        if (r7.isMysteryMan() == true) goto L33;
        if ((!Intrinsics.areEqual(r7.getIdString(), r11)) == false) goto L33;
        r13 = true;
    L26:
        r11 = "0";
        goto L27
    L16:
        r6 = null;
        goto L18
    L5:
        if (r0.isEnableMarkUser() != true) goto L9;
        if (((Boolean) this.s.isAnchor().getValue()).booleanValue() == false) goto L9;
        r1 = true;
        goto L10
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r1) {
        TextView r2 = this.g;
        if (r2 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r2);
        return;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void c(com.bytedance.android.livesdk.interactivity.api.entity.l r8, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r9) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r9, "bridge");
        super.c(r8, r9);
        View r0 = getView(r8.getContext());
        String r1 = null;
        if (r0 == null) goto L5;
        ImageView r2 = (ImageView) r0.findViewById(2131379543);
    L6:
        this.f = r2;
        View r3 = getView(r8.getContext());
        if (r3 == null) goto L9;
        LiveSwitchButton r4 = (LiveSwitchButton) r3.findViewById(2131364759);
    L10:
        this.e = r4;
        View r5 = getView(r8.getContext());
        if (r5 == null) goto L13;
        TextView r6 = (TextView) r5.findViewById(2131388723);
    L14:
        this.g = r6;
        com.bytedance.android.live.base.model.message.t r7 = r8.b;
        if ((r7 instanceof u3) == true) goto L17;
        r7 = null;
    L17:
        u3 r10 = (u3) r7;
        if (r10 == null) goto L20;
        IBaseUser r11 = r10.getUserInMessage();
    L21:
        this.r = new CompositeDisposable();
        Boolean r13 = (Boolean) this.o.getValue();
        Boolean r14 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r13, r14)) == false) goto L30;
        TextView r15 = this.g;
        if (r15 == null) goto L26;
        r15.setText(this.n);
    L26:
        TextView r16 = this.g;
        if (r16 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r16);
    L29:
        RxUtilKt.c(RxUtilKt.h(Observable.timer(this.q, TimeUnit.MILLISECONDS)).subscribe(new b(this)), this.r);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r17 = this.o;
        r17.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r17, r14);
        com.bytedance.android.livesdk.log.u.l().d("livesdk_anchor_tag_priority_display_user_bubble_show", new Object[]{Room.class});
    L33:
        MarkUserApi.a.getClass();
        MarkUserApi r18 = (MarkUserApi) com.bytedance.android.live.network.c.b().e(MarkUserApi.class);
        if (r18 == null) goto L49;
        if (r11 == null) goto L37;
        r1 = r11.getIdString();
    L37:
        long r19 = d5.c(r1);
        if (r11 == null) goto L41;
        String r20 = r11.getIdString();
        if (r20 == null) goto L41;
    L42:
        Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.c>> r21 = r18.getUserMarked(r19, r20, "mark");
        if (r21 == null) goto L49;
        Observable r23 = r21.observeOn(AndroidSchedulers.mainThread());
        if (r23 == null) goto L49;
        Disposable r24 = r23.subscribe(new c(this), d.a);
        if (r24 == null) goto L49;
        RxUtilKt.c(r24, this.r);
    L41:
        r20 = BuildConfig.FLAVOR;
    L49:
        LiveSwitchButton r25 = this.e;
        if (r25 == null) goto L52;
        r25.setOnClickListener(new e(this, r11));
    L52:
        ImageView r26 = this.f;
        if (r26 == null) goto L56;
        r26.setOnClickListener(new f(this, r9, r8));
        return;
    L56:
        return;
    L30:
        TextView r27 = this.g;
        if (r27 == null) goto L33;
        UtilityKotlinExtentionsKt.t(r27);
        goto L33
    L20:
        r11 = null;
        goto L21
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
