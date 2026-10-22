package p82;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.config.fd;
import com.bytedance.android.livesdk.config.jl0;
import com.bytedance.android.livesdk.interactivity.PSOperatePanelDialog;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.api.CommentControlRetrofitApi;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils.CommentControlSwitchHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends p82.a {
    public ImageView e;
    public ImageView f;
    public LiveSwitchButton g;
    public TextView h;
    public ImageView i;
    public LiveSwitchButton j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public final RoomContext o;

    public static final class a {
    }

    /* JADX INFO: renamed from: p82.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0262b implements View.OnClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.entity.l b;
        public final /* synthetic */ Ref.ObjectRef c;

        public ViewOnClickListenerC0262b(b r1, com.bytedance.android.livesdk.interactivity.api.entity.l r2, Ref.ObjectRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ILiveService r4 = TTLiveService.getLiveService();
            if (r4 == null) goto L5;
            r4.handleSchema(this.b.getContext(), UriProtector.parse((String) this.c.element));
        L5:
            this.a.f();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            List<a5> r7 = ((com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a) r6).a();
            if (r7 == null) goto L8;
            a5 r8 = (a5) ListProtector.get(r7, 0);
            if (r8 == null) goto L9;
            LiveRichContentEngine.a().a().c(mb2.d.a(r8, null, 1.0f), new qb2.g(false, 0.0f, 7), new p82.c(this));
            return;
        L9:
            return;
        }
    }

    public static final class d implements LiveSwitchButton.e {
        public final /* synthetic */ b a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            public final void accept(Object r6) {
                List<a5> r7 = ((com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.c) ((BaseResponse) ((Response) r6)).data).a();
                if (r7 == null) goto L8;
                a5 r8 = (a5) ListProtector.get(r7, 0);
                if (r8 == null) goto L9;
                LiveRichContentEngine.a().a().c(mb2.d.a(r8, null, 1.0f), new qb2.g(false, 0.0f, 7), new p82.d(this));
                return;
            L9:
                return;
            }
        }

        /* JADX INFO: renamed from: p82.b$d$b, reason: collision with other inner class name */
        public static final class C0263b<T> implements Consumer {
            public static final C0263b a = null;

            static {
                a = new C0263b();
            }

            public C0263b() {
            }

            public final void accept(Object r1) {
                ((Throwable) r1).printStackTrace();
            }
        }

        public d(b r1) {
            this.a = r1;
        }

        public final void d0(LiveSwitchButton r8, boolean r9) {
            CommentControlSwitchHelper.d();
            this.a.g(r9);
            CommentControlRetrofitApi r0 = (CommentControlRetrofitApi) com.bytedance.android.live.network.c.b().e(CommentControlRetrofitApi.class);
            long r1 = ((Room) this.a.o.getRoom().getValue()).id;
            long r3 = CommentControlSwitchHelper.b();
            if (r9 == false) goto L5;
            long r10 = 1;
        L6:
            r0.updateCommentControlStatusRequest(r1, r3, r10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), C0263b.a);
            this.a.f();
            return;
        L5:
            r10 = 0;
            goto L6
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ b a;

        public e(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            List<a5> r11 = ((com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a) r10).a();
            if (r11 == null) goto L17;
            a5 r1 = (a5) ListProtector.get(r11, 0);
            if (r1 == null) goto L7;
            LiveRichContentEngine.a().a().c(mb2.d.a(r1, null, 1.0f), new qb2.g(false, 0.0f, 7), new p82.e(this));
        L7:
            a5 r2 = (a5) ListProtector.get(r11, 1);
            if (r2 == null) goto L10;
            LiveRichContentEngine.a().a().c(mb2.d.a(r2, null, 1.0f), new qb2.g(false, 0.0f, 7), new p82.f(this));
        L10:
            a5 r3 = (a5) ListProtector.get(r11, 2);
            if (r3 == null) goto L13;
            LiveRichContentEngine.a().a().c(mb2.d.a(r3, null, 1.0f), new qb2.g(false, 0.0f, 7), new p82.g(this));
        L13:
            a5 r13 = (a5) ListProtector.get(r11, 3);
            if (r13 == null) goto L18;
            LiveRichContentEngine.a().a().c(mb2.d.a(r13, null, 1.0f), new qb2.g(false, 0.0f, 7), new h(this));
            return;
        L18:
            return;
        }
    }

    public static final class f implements LiveSwitchButton.e {
        public final /* synthetic */ b a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ f a;

            public a(f r1) {
                this.a = r1;
            }

            public final void accept(Object r10) {
                List<a5> r11 = ((com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.c) ((BaseResponse) ((Response) r10)).data).a();
                if (r11 == null) goto L17;
                a5 r1 = (a5) ListProtector.get(r11, 0);
                if (r1 == null) goto L7;
                LiveRichContentEngine.a().a().c(mb2.d.a(r1, null, 1.0f), new qb2.g(false, 0.0f, 7), new i(this));
            L7:
                a5 r2 = (a5) ListProtector.get(r11, 1);
                if (r2 == null) goto L10;
                LiveRichContentEngine.a().a().c(mb2.d.a(r2, null, 1.0f), new qb2.g(false, 0.0f, 7), new j(this));
            L10:
                a5 r3 = (a5) ListProtector.get(r11, 2);
                if (r3 == null) goto L13;
                LiveRichContentEngine.a().a().c(mb2.d.a(r3, null, 1.0f), new qb2.g(false, 0.0f, 7), new k(this));
            L13:
                a5 r13 = (a5) ListProtector.get(r11, 3);
                if (r13 == null) goto L18;
                LiveRichContentEngine.a().a().c(mb2.d.a(r13, null, 1.0f), new qb2.g(false, 0.0f, 7), new l(this));
                return;
            L18:
                return;
            }
        }

        /* JADX INFO: renamed from: p82.b$f$b, reason: collision with other inner class name */
        public static final class C0264b<T> implements Consumer {
            public static final C0264b a = null;

            static {
                a = new C0264b();
            }

            public C0264b() {
            }

            public final void accept(Object r1) {
                ((Throwable) r1).printStackTrace();
            }
        }

        public f(b r1) {
            this.a = r1;
        }

        public final void d0(LiveSwitchButton r8, boolean r9) {
            CommentControlSwitchHelper.d();
            this.a.g(r9);
            CommentControlRetrofitApi r0 = (CommentControlRetrofitApi) com.bytedance.android.live.network.c.b().e(CommentControlRetrofitApi.class);
            long r1 = ((Room) this.a.o.getRoom().getValue()).id;
            long r3 = CommentControlSwitchHelper.b();
            if (r9 == false) goto L5;
            long r10 = 1;
        L6:
            r0.updateCommentControlStatusRequest(r1, r3, r10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), C0264b.a);
            this.a.f();
            return;
        L5:
            r10 = 0;
            goto L6
        }
    }

    public static final class g extends nk6.a {
        public final /* synthetic */ b a;

        public g(b r1) {
            this.a = r1;
        }

        public final void b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            ALogger.d("CommentProtectModeItem", "processSpanClic onViewClick");
        }

        public final boolean a(View r3, ek6.c r4, ClickableSpan r5) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "action");
            Intrinsics.checkNotNullParameter(r5, "span");
            boolean r6 = r4 instanceof ib2.a;
            if (r6 == false) goto L34;
            tb2.b r7 = null;
            if (r6 == true) goto L7;
            r4 = null;
        L7:
            ib2.a r8 = (ib2.a) r4;
            if (r8 == null) goto L34;
            tb2.b r9 = r8.a;
            boolean r10 = r9 instanceof tb2.e;
            if (r10 == false) goto L34;
            if (r10 == false) goto L14;
            r7 = r9;
        L14:
            tb2.e r11 = (tb2.e) r7;
            if (r11 == null) goto L34;
            m6 r13 = r11.a();
            if (r13.a() != null) goto L19;
        L20:
            String r14 = r13.a;
            if (r14 == null) goto L33;
            int r0 = r14.hashCode();
            if (r0 == 1718062152) goto L31;
            if (r0 != 1955284354) goto L33;
            if (r14.equals("live_manager_scheme_to_shield_words") == false) goto L33;
        L32:
            r13.b((String) fd.a.getValue());
            ALogger.d("CommentProtectModeItem", "processSpanClick use local settings url");
            goto L33
        L31:
            if (r14.equals("live_manager_scheme_to_mute") == true) goto L32;
        L33:
            boolean r15 = tb2.f.a(r11);
        L35:
            this.a.f();
            return r15;
        L19:
            if (Intrinsics.areEqual(r13.a(), BuildConfig.FLAVOR) == false) goto L33;
        L34:
            r15 = false;
            goto L35
        }
    }

    static {
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onDestroyView() {
        this.a = null;
    }

    @Override // p82.a
    public final int e() {
        long r0 = CommentControlSwitchHelper.b();
        com.bytedance.android.livesdk.sharedpref.e<Long> r2 = CommentControlSwitchHelper.a;
        if (r0 != 0) goto L6;
        return 2131567219;
    L6:
        if (r0 != 1) goto L9;
        return 2131567220;
    L9:
        return 2131567219;
    }

    public final void f() {
        Map r0 = MapsKt.mapOf(TuplesKt.to("event_user_type", d()));
        int r1 = com.bytedance.android.livesdk.interactivity.utils.r.a;
        long r2 = this.d.getId();
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r3 == null) goto L9;
        com.bytedance.live.datacontext.i r4 = r3.isAnchor();
        if (r4 == null) goto L9;
        boolean r5 = true;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L9;
    L10:
        com.bytedance.android.livesdk.interactivity.utils.r.a(r2, r5, r0);
        return;
    L9:
        r5 = false;
        goto L10
    }

    public b(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        super(PanelItemSymbol.COMMENT_CONTROL_MODE);
        this.o = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b r8 = CommentControlSwitchHelper.e;
        if (r8 != null) goto L6;
        r8 = new com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b();
    L6:
        if (r8.a() != 1) goto L8;
        boolean r0 = true;
    L10:
        if (((Boolean) this.o.isAnchor().getValue()).booleanValue() == false) goto L16;
        if (r0 == true) goto L13;
        return false;
    L13:
        if (((Boolean) jl0.a.getValue()).booleanValue() == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L8:
        r0 = false;
        goto L10
    }

    public final void g(boolean r15) {
        Map r0 = MapsKt.mapOf(TuplesKt.to("event_user_type", d()));
        int r1 = com.bytedance.android.livesdk.interactivity.utils.r.a;
        long r2 = this.d.getId();
        Intrinsics.checkNotNullParameter(r0, "extra");
        HashMap r3 = new HashMap();
        r3.putAll(r0);
        r3.put("item_id", String.valueOf(r2));
        RoomContext.a r4 = RoomContext.Companion;
        String r5 = null;
        RoomContext r8 = RoomContext.a.c(r4, null, 0, 3);
        String r9 = "1";
        if (r8 == null) goto L9;
        com.bytedance.live.datacontext.i r10 = r8.isAnchor();
        if (r10 == null) goto L9;
        if (((Boolean) r10.getValue()).booleanValue() != true) goto L9;
        Object r11 = "1";
    L10:
        r3.put("is_anchor", r11);
        if (r15 != true) goto L13;
        Object r13 = "0";
    L15:
        r3.put("before_status", r13);
        if (r15 != true) goto L18;
        Object r16 = "1";
    L20:
        r3.put("after_status", r16);
        if (r2 != PanelItemSymbol.COMMENT_CONTROL_MODE.getId()) goto L45;
        RoomContext r17 = RoomContext.a.c(r4, null, 0, 3);
        if (r17 == null) goto L29;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L29;
        Room r19 = (Room) r18.getValue();
        if (r19 == null) goto L29;
        String r110 = r19.getIdStr();
    L30:
        r3.put("anchor_id", r110);
        RoomContext r111 = RoomContext.a.c(r4, null, 0, 3);
        if (r111 == null) goto L37;
        com.bytedance.live.datacontext.m r112 = r111.getRoom();
        if (r112 == null) goto L37;
        Room r113 = (Room) r112.getValue();
        if (r113 == null) goto L37;
        r5 = r113.getOwnerUserIdString();
    L37:
        r3.put("room_id", r5);
        long r6 = CommentControlSwitchHelper.b();
        if (r6 != 0) goto L41;
    L43:
        r9 = "0";
    L44:
        r3.put("item_style", r9);
        goto L45
    L41:
        if (r6 != 1) goto L43;
    L29:
        r110 = null;
    L45:
        com.bytedance.android.livesdk.log.u.l().sendLog("live_public_screen_action_sheet_item_slide", r3, new Object[]{Room.class});
        return;
    L18:
        if (r15 == true) goto L48;
        r16 = "0";
        goto L20
    L48:
        throw new NoWhenBranchMatchedException();
    L13:
        if (r15 == true) goto L50;
        r13 = "1";
        goto L15
    L50:
        throw new NoWhenBranchMatchedException();
    L9:
        r11 = "0";
        goto L10
    }

    public final void h(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        CommentControlSwitchHelper.d();
        nk6.a r0 = new g(this);
        r3.setMovementMethod(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u.a());
        r3.setHighlightColor(0);
        r3.setOnClickListener(r0);
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r1) {
        CommentControlSwitchHelper.d();
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void c(com.bytedance.android.livesdk.interactivity.api.entity.l r20, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r21) {
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r2 = r21;
        Intrinsics.checkNotNullParameter(r20, "event");
        Intrinsics.checkNotNullParameter(r2, "bridge");
        super.c(r20, r21);
        com.bytedance.android.livesdk.sharedpref.e<Long> r3 = CommentControlSwitchHelper.a;
        long r4 = ((Room) this.o.getRoom().getValue()).id;
        ALogger.w("CommentControlSwitchHelper", "fetchCommentControlMessage");
        CommentControlSwitchHelper.g = ((CommentControlRetrofitApi) com.bytedance.android.live.network.c.b().e(CommentControlRetrofitApi.class)).getCommentControlMessageRequest(r4, CommentControlSwitchHelper.b()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(d32.a.a, d32.b.a);
        long r5 = CommentControlSwitchHelper.b();
        LiveSwitchButton r17 = null;
        if (r5 != 0) goto L96;
        View r6 = getView(r20.getContext());
        if (r6 == null) goto L7;
        TextView r7 = (TextView) r6.findViewById(2131391543);
    L8:
        if (r7 == null) goto L10;
        r7.setText(2131921789);
    L10:
        View r8 = getView(r20.getContext());
        if (r8 == null) goto L13;
        ImageView r9 = (ImageView) r8.findViewById(2131376651);
    L14:
        this.e = r9;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b r11 = CommentControlSwitchHelper.e;
        if (r11 != null) goto L17;
        r11 = new com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b();
    L17:
        String r13 = r11.c();
        r10.element = r13;
        if (r13 != null) goto L23;
        ImageView r14 = this.e;
        if (r14 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r14);
    L38:
        View r15 = getView(r20.getContext());
        if (r15 == null) goto L41;
        ImageView r16 = (ImageView) r15.findViewById(2131384095);
    L42:
        this.f = r16;
        Long r18 = CommentControlSwitchHelper.c();
        if (r18 != null) goto L46;
    L50:
        if (r18 != null) goto L53;
    L57:
        View r19 = getView(r20.getContext());
        if (r19 == null) goto L60;
        TextView r23 = (TextView) r19.findViewById(2131391540);
    L61:
        this.h = r23;
        Context r24 = r20.getContext();
        if ((r24 instanceof ViewModelStoreOwner) == true) goto L64;
        r24 = null;
    L64:
        ViewModelStoreOwner r25 = (ViewModelStoreOwner) r24;
        if ((r2 instanceof PSOperatePanelDialog) == true) goto L67;
        r2 = null;
    L67:
        PSOperatePanelDialog r26 = (PSOperatePanelDialog) r2;
        if (r26 == null) goto L70;
        LifecycleOwner r27 = r26.getViewLifecycleOwner();
    L71:
        if (r25 == null) goto L73;
        CommentControlSwitchHelper.BaseDisplayText r28 = (CommentControlSwitchHelper.BaseDisplayText) new ViewModelProvider(r25).get(CommentControlSwitchHelper.BaseDisplayText.class);
        CommentControlSwitchHelper.c = r28;
        LiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> r29 = r28.getBaseDisplayText();
        Intrinsics.checkNotNull(r27);
        r29.observe(r27, new c(this));
    L74:
        View r1 = getView(r20.getContext());
        if (r1 == null) goto L77;
        r17 = (LiveSwitchButton) r1.findViewById(2131386014);
    L77:
        this.g = r17;
        com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b r30 = CommentControlSwitchHelper.e;
        if (r30 != null) goto L81;
        r30 = new com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b();
    L81:
        if (r30.d() != 1) goto L83;
        boolean r31 = true;
    L84:
        if (r31 != true) goto L88;
        LiveSwitchButton r33 = this.g;
        if (r33 == null) goto L92;
        r33.setChecked(true);
    L92:
        LiveSwitchButton r34 = this.g;
        if (r34 == null) goto L173;
        r34.setOnCheckedChangeListener(new d(this));
        return;
    L173:
        return;
    L88:
        if (r31 == true) goto L92;
        LiveSwitchButton r35 = this.g;
        if (r35 == null) goto L92;
        r35.setChecked(false);
        goto L92
    L83:
        r31 = false;
        goto L84
    L73:
        ALogger.e("CommentProtectModeItem", "viewModelStoreOwner is null");
        goto L74
    L70:
        r27 = null;
        goto L71
    L60:
        r23 = null;
        goto L61
    L53:
        if (r18.longValue() != 1) goto L57;
        ImageView r36 = this.f;
        if (r36 == null) goto L57;
        UtilityKotlinExtentionsKt.t(r36);
        goto L57
    L46:
        if (r18.longValue() != 0) goto L50;
        ImageView r37 = this.f;
        if (r37 == null) goto L57;
        UtilityKotlinExtentionsKt.w(r37);
        goto L57
    L41:
        r16 = null;
        goto L42
    L23:
        if (r13.hashCode() == 0) goto L26;
    L30:
        ImageView r38 = this.e;
        if (r38 == null) goto L34;
        UtilityKotlinExtentionsKt.w(r38);
    L34:
        if (((String) r10.element) == null) goto L38;
        ImageView r39 = this.e;
        if (r39 == null) goto L38;
        r39.setOnClickListener(new ViewOnClickListenerC0262b(this, r20, r10));
        goto L38
    L26:
        if (r13.equals(BuildConfig.FLAVOR) == false) goto L30;
        ImageView r40 = this.e;
        if (r40 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r40);
        goto L38
    L13:
        r9 = null;
        goto L14
    L7:
        r7 = null;
        goto L8
    L96:
        if (r5 != 1) goto L175;
        View r41 = getView(r20.getContext());
        if (r41 == null) goto L100;
        TextView r43 = (TextView) r41.findViewById(2131391543);
    L101:
        if (r43 == null) goto L103;
        r43.setText(2131921789);
    L103:
        View r44 = getView(r20.getContext());
        if (r44 == null) goto L106;
        ImageView r45 = (ImageView) r44.findViewById(2131384095);
    L107:
        this.i = r45;
        Long r46 = CommentControlSwitchHelper.c();
        if (r46 != null) goto L111;
    L115:
        if (r46 != null) goto L118;
    L122:
        View r47 = getView(r20.getContext());
        if (r47 == null) goto L125;
        TextView r48 = (TextView) r47.findViewById(2131390842);
    L126:
        this.k = r48;
        View r49 = getView(r20.getContext());
        if (r49 == null) goto L129;
        TextView r50 = (TextView) r49.findViewById(2131390843);
    L130:
        this.l = r50;
        View r51 = getView(r20.getContext());
        if (r51 == null) goto L133;
        TextView r53 = (TextView) r51.findViewById(2131390844);
    L134:
        this.m = r53;
        View r54 = getView(r20.getContext());
        if (r54 == null) goto L137;
        TextView r55 = (TextView) r54.findViewById(2131391540);
    L138:
        this.n = r55;
        Context r56 = r20.getContext();
        if ((r56 instanceof ViewModelStoreOwner) == true) goto L141;
        r56 = null;
    L141:
        ViewModelStoreOwner r57 = (ViewModelStoreOwner) r56;
        if ((r2 instanceof PSOperatePanelDialog) == true) goto L144;
        r2 = null;
    L144:
        PSOperatePanelDialog r58 = (PSOperatePanelDialog) r2;
        if (r58 == null) goto L147;
        LifecycleOwner r59 = r58.getViewLifecycleOwner();
    L148:
        if (r57 == null) goto L150;
        CommentControlSwitchHelper.AdvancedDisplayText r60 = (CommentControlSwitchHelper.AdvancedDisplayText) new ViewModelProvider(r57).get(CommentControlSwitchHelper.AdvancedDisplayText.class);
        CommentControlSwitchHelper.d = r60;
        LiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> r61 = r60.getAdvancedDisplayText();
        Intrinsics.checkNotNull(r59);
        r61.observe(r59, new e(this));
    L151:
        View r63 = getView(r20.getContext());
        if (r63 == null) goto L154;
        r17 = (LiveSwitchButton) r63.findViewById(2131386014);
    L154:
        this.j = r17;
        com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b r64 = CommentControlSwitchHelper.e;
        if (r64 != null) goto L158;
        r64 = new com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b();
    L158:
        if (r64.d() != 1) goto L160;
        boolean r65 = true;
    L161:
        if (r65 != true) goto L165;
        LiveSwitchButton r66 = this.j;
        if (r66 == null) goto L169;
        r66.setChecked(true);
    L169:
        LiveSwitchButton r67 = this.j;
        if (r67 == null) goto L176;
        r67.setOnCheckedChangeListener(new f(this));
        return;
    L176:
        return;
    L165:
        if (r65 == true) goto L169;
        LiveSwitchButton r68 = this.j;
        if (r68 == null) goto L169;
        r68.setChecked(false);
        goto L169
    L160:
        r65 = false;
        goto L161
    L150:
        ALogger.e("CommentProtectModeItem", "viewModelStoreOwner is null");
        goto L151
    L147:
        r59 = null;
        goto L148
    L137:
        r55 = null;
        goto L138
    L133:
        r53 = null;
        goto L134
    L129:
        r50 = null;
        goto L130
    L125:
        r48 = null;
        goto L126
    L118:
        if (r46.longValue() != 1) goto L122;
        ImageView r69 = this.i;
        if (r69 == null) goto L122;
        UtilityKotlinExtentionsKt.t(r69);
        goto L122
    L111:
        if (r46.longValue() != 0) goto L115;
        ImageView r70 = this.i;
        if (r70 == null) goto L122;
        UtilityKotlinExtentionsKt.w(r70);
        goto L122
    L106:
        r45 = null;
        goto L107
    L100:
        r43 = null;
        goto L101
    }
}
