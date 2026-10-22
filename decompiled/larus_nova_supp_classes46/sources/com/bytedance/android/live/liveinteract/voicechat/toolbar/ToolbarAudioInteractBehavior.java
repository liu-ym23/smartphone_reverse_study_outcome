package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import am2.x;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.g0;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.widget.widget.q;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.aq;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pp1.m;
import zg1.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ToolbarAudioInteractBehavior implements c0.b, Observer<KVData> {
    public DataCenter a;
    public TextView b;
    public View c;
    public LottieAnimationView d;
    public HSImageView e;
    public ImageView f;
    public HSImageView g;
    public boolean h;
    public final b i;
    public com.bytedance.android.live.liveinteract.chatroom.chatroom.b j;
    public boolean k;
    public boolean l;
    public com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b m;
    public q n;
    public String o;
    public Context p;
    public final CompositeDisposable q;
    public IRoom r;
    public final String s;
    public final String t;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ToolbarAudioInteractBehavior a;

        public b(ToolbarAudioInteractBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ToolbarAudioInteractBehavior r0 = this.a;
            r0.g((Integer) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ToolbarAudioInteractBehavior a;

        public c(ToolbarAudioInteractBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((b2) r2).getType() != 1) goto L6;
            this.a.c(((Integer) ((ge1.a) hd0.c.f()).b).intValue());
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ToolbarAudioInteractBehavior a;

        public d(ToolbarAudioInteractBehavior r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L4
            String r0 = ChatMatchWidget.o;     // Catch: Throwable -> L4
            ChatMatchViewModel r1 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ToolbarAudioInteractBehavior a;

        public e(ToolbarAudioInteractBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((i) r2).a != 0) goto L8;
            TextView r3 = this.a.b;
            if (r3 == null) goto L9;
            r3.setVisibility(8);
            return;
        L9:
            return;
        }
    }

    public final /* synthetic */ class f implements androidx.lifecycle.Observer {
        public final /* synthetic */ Function1 a;

        public f(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final boolean a() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.performance.a r1 = r0.getMultiLinkPerfAbilityManager(true);
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.a("multilink_toolbar_degrade");
    L8:
        return true;
    }

    public ToolbarAudioInteractBehavior() {
        this.i = new b(this);
        this.m = new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b();
        this.q = new CompositeDisposable();
        this.s = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/fast_match.webp";
        this.t = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/fast_json_lottie.json";
    }

    public final void f() {
        if (vm2.d.w0().a() == false) goto L16;
        LottieAnimationView r0 = this.d;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        HSImageView r1 = this.e;
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri(vm2.d.w0().b).setAutoPlayAnimations(a()).build();
        HSImageView r3 = this.e;
        if (r3 == null) goto L13;
        r3.setController(r2);
    L13:
        ImageView r4 = this.f;
        if (r4 == null) goto L26;
        r4.setBackgroundResource(0);
        return;
    L26:
        return;
    L16:
        HSImageView r5 = this.e;
        if (r5 == null) goto L19;
        r5.setVisibility(8);
    L19:
        LottieAnimationView r6 = this.d;
        if (r6 == null) goto L22;
        r6.setVisibility(0);
    L22:
        g0.a(vm2.d.b().interactIcCallingId, this.d, null);
        LottieAnimationView r7 = this.d;
        if (r7 == null) goto L28;
        r7.setBackgroundResource(2131250014);
        return;
    }

    public final void b(KVData r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_audio_talk_dot_with_number_show") == false) goto L21;
        String r5 = (String) r4.getData();
        if (r5 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L15;
        TextView r6 = this.b;
        if (r6 == null) goto L35;
        r6.setVisibility(8);
        return;
    L35:
        return;
    L15:
        TextView r2 = this.b;
        if (r2 == null) goto L18;
        r2.setText(r5);
    L18:
        TextView r7 = this.b;
        if (r7 == null) goto L37;
        r7.setVisibility(0);
        return;
    L37:
        return;
    L21:
        if (r4 == null) goto L24;
        r0 = r4.getKey();
    L24:
        if (Intrinsics.areEqual(r0, "data_self_is_silenced") == false) goto L39;
        Boolean r8 = (Boolean) r4.getData();
        if (r8 != null) goto L28;
        return;
    L28:
        if ((!r8.booleanValue()) == true) goto L30;
        d(2131250851);
        return;
    L30:
        if (hd0.c.f().h() == false) goto L41;
        f();
        return;
    L41:
        return;
    L39:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void c(int r3) {
        StringBuilder r0 = new StringBuilder("onClickToolbarAudience, multiInternalService is null: ");
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        ALogger.d("ToolbarAudioInteractBehavior", r0.toString());
        com.bytedance.android.live.liveinteract.plantform.base.g r2 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r2 == null) goto L10;
        r2.d9(r3);
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void d(int r4) {
        if (vm2.d.w0().a() == false) goto L16;
        LottieAnimationView r0 = this.d;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        HSImageView r1 = this.e;
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        ImageView r2 = this.f;
        if (r2 == null) goto L13;
        r2.setBackgroundResource(0);
    L13:
        HSImageView r3 = this.e;
        if (r3 == null) goto L32;
        r3.setActualImageResource(r4);
        return;
    L32:
        return;
    L16:
        HSImageView r5 = this.e;
        if (r5 == null) goto L19;
        r5.setVisibility(8);
    L19:
        LottieAnimationView r6 = this.d;
        if (r6 == null) goto L22;
        r6.setVisibility(0);
    L22:
        LottieAnimationView r7 = this.d;
        if (r7 == null) goto L25;
        r7.clearAnimation();
    L25:
        LottieAnimationView r8 = this.d;
        if (r8 == null) goto L28;
        r8.setBackgroundResource(0);
    L28:
        LottieAnimationView r9 = this.d;
        if (r9 == null) goto L34;
        r9.setImageResource(r4);
        return;
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        Intrinsics.checkNotNullParameter(r2, "command");
        if ((r2 instanceof m) == false) goto L6;
        e(((m) r2).a);
        return;
    L6:
        if ((r2 instanceof pp1.g) == false) goto L14;
        this.k = ((pp1.g) r2).a;
        if (this.l == false) goto L10;
        int r3 = 0;
    L11:
        e(r3);
        return;
    L10:
        r3 = 8;
        goto L11
    }

    public final void e(int r6) {
        int r0 = u40.a.a;
        if (((Boolean) aq.a.getValue()).booleanValue() == false) goto L6;
        ALogger.i("NewToolbarLog", "audio link mic stop view change by self.");
        return;
    L6:
        boolean r1 = false;
        if (r6 != 0) goto L9;
        boolean r7 = true;
    L10:
        this.l = r7;
        if (this.k == false) goto L13;
        View r8 = this.c;
        if (r8 == null) goto L22;
        r8.setVisibility(8);
    L22:
        if (this.l == false) goto L27;
        if (this.j != null) goto L29;
        this.j = new com.bytedance.android.live.liveinteract.chatroom.chatroom.b(this);
        y3.f(this.a).k(ToolbarButton.INTERACTION_MORE, this.j);
    L29:
        DataCenter r9 = this.a;
        if (r9 != null) goto L32;
        return;
    L32:
        if (this.l == true) goto L34;
    L36:
        r9.put("data_has_interact_more", Boolean.valueOf(r1));
        return;
    L34:
        if (this.k == false) goto L36;
        r1 = true;
        goto L36
    L27:
        if (this.j == null) goto L29;
        y3.f(this.a).d(ToolbarButton.INTERACTION_MORE, this.j);
        this.j = null;
        goto L29
    L13:
        if (this.j == null) goto L15;
        y3.f(this.a).d(ToolbarButton.INTERACTION_MORE, this.j);
        this.j = null;
    L15:
        View r10 = this.c;
        if (r10 == null) goto L29;
        UtilityKotlinExtentionsKt.z(r10, this.l);
        goto L29
    L9:
        r7 = false;
        goto L10
    }

    public final void g(Integer r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        String r0 = ChatMatchWidget.o;
        ChatMatchViewModel r1 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r1 == null) goto L40;
        MutableLiveData<Boolean> r2 = r1.getMatchingState();
        if (r2 == null) goto L40;
        if (Intrinsics.areEqual((Boolean) r2.getValue(), Boolean.TRUE) == false) goto L40;
        if (vm2.d.w0().a() == false) goto L24;
        LottieAnimationView r10 = this.d;
        if (r10 == null) goto L15;
        r10.setVisibility(8);
    L15:
        HSImageView r11 = this.e;
        if (r11 == null) goto L18;
        r11.setVisibility(0);
    L18:
        AbstractDraweeController r12 = Fresco.newDraweeControllerBuilder().setUri(this.s).setAutoPlayAnimations(a()).build();
        HSImageView r3 = this.e;
        if (r3 == null) goto L21;
        r3.setController(r12);
    L21:
        ImageView r13 = this.f;
        if (r13 == null) goto L92;
        r13.setBackgroundResource(2131250014);
        return;
    L92:
        return;
    L24:
        HSImageView r14 = this.e;
        if (r14 == null) goto L27;
        r14.setVisibility(8);
    L27:
        LottieAnimationView r15 = this.d;
        if (r15 == null) goto L30;
        r15.setVisibility(0);
    L30:
        LottieAnimationView r16 = this.d;
        if (r16 == null) goto L33;
        r16.setAnimationFromUrl(this.t);
    L33:
        LottieAnimationView r17 = this.d;
        if (r17 == null) goto L36;
        r17.playAnimation();
    L36:
        LottieAnimationView r18 = this.d;
        if (r18 == null) goto L94;
        r18.setBackgroundResource(2131250014);
        return;
    L94:
        return;
    L40:
        int r4 = 2131243758;
        Object r6 = null;
        if (r9.intValue() != 0) goto L48;
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == true) goto L46;
        r4 = 2131250847;
    L46:
        d(r4);
    L81:
        int r19 = 2131917693;
    L82:
        HSImageView r5 = this.e;
        if (r5 == null) goto L85;
        ViewParent r7 = r5.getParent();
    L87:
        if ((r7 instanceof View) == false) goto L90;
        r6 = r7;
    L90:
        r3.c((View) r6, s1.B(r19), true);
        ht2.g.c(12, this.r, this.d);
        return;
    L85:
        r7 = null;
        goto L87
    L48:
        if (1 != r9.intValue()) goto L74;
        if (vm2.d.w0().a() == false) goto L63;
        LottieAnimationView r20 = this.d;
        if (r20 == null) goto L54;
        r20.setVisibility(8);
    L54:
        HSImageView r21 = this.e;
        if (r21 == null) goto L57;
        r21.setVisibility(0);
    L57:
        AbstractDraweeController r22 = Fresco.newDraweeControllerBuilder().setUri(vm2.d.w0().c).setAutoPlayAnimations(a()).build();
        HSImageView r8 = this.e;
        if (r8 == null) goto L60;
        r8.setController(r22);
    L60:
        ImageView r23 = this.f;
        if (r23 == null) goto L72;
        r23.setBackgroundResource(0);
    L72:
        r19 = 2131917742;
        goto L82
    L63:
        HSImageView r24 = this.e;
        if (r24 == null) goto L66;
        r24.setVisibility(8);
    L66:
        LottieAnimationView r25 = this.d;
        if (r25 == null) goto L69;
        r25.setVisibility(0);
    L69:
        g0.a(vm2.d.b().interactIcWaitingId, this.d, null);
        LottieAnimationView r26 = this.d;
        if (r26 == null) goto L72;
        r26.setBackgroundResource(2131250014);
        goto L72
    L74:
        if (2 != r9.intValue()) goto L77;
        f();
        HashMap r27 = new HashMap();
        r27.put("live_type", "voice_live");
        r27.put("room_type", "radio");
        j0 r28 = j0.l();
        x r29 = new x();
        r29.b = "live_detail";
        r29.a = "live";
        r28.sendLog("audience_connection_success", r27, new Object[]{r29, IRoom.class});
        r19 = 2131917701;
        goto L82
    L77:
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == true) goto L80;
        r4 = 2131250847;
    L80:
        d(r4);
        goto L81
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        b((KVData) r1);
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        c(((Integer) ((ge1.a) hd0.c.f()).b).intValue());
        xs2.b.a().post(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.h());
    }

    public final void R9(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        StringBuilder r6 = new StringBuilder("AudioBehavior#onUnload, roomId = ");
        IRoom r7 = this.r;
        if (r7 == null) goto L5;
        Long r8 = Long.valueOf(r7.getId());
    L6:
        r6.append(r8);
        ALogger.e("dzy-toolbar", r6.toString());
        Log.getStackTraceString(new Throwable("AudioBehavior#onUnload"));
        hd0.c.f().e(this.i);
        String r9 = this.o;
        if (r9 == null) goto L13;
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.performance.a r2 = r1.getMultiLinkPerfAbilityManager(false);
        if (r2 == null) goto L13;
        r2.c("multilink_toolbar_degrade", r9);
    L13:
        this.o = null;
        DataCenter r10 = this.a;
        if (r10 == null) goto L16;
        r10.removeObserver(new f(new ToolbarAudioInteractBehavior$resetData$1(this)));
    L16:
        this.a = null;
        this.p = null;
        this.r = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.j = null;
        this.k = false;
        this.l = false;
        this.m.a();
        this.m = new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b();
        this.q.clear();
        return;
    L5:
        r8 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        this.c = r6;
        this.p = r6.getContext();
        View r0 = this.c;
        if (r0 == null) goto L5;
        r0.setOnClickListener(this);
    L5:
        Long r1 = null;
        IRoom r2 = (IRoom) r7.get("data_enter_room", null);
        this.r = r2;
        if (r2 != null) goto L8;
        this.r = (IRoom) r7.get("data_room", null);
    L8:
        View r3 = this.c;
        if (r3 == null) goto L11;
        TextView r4 = (TextView) r3.findViewById(2131381099);
    L12:
        this.b = r4;
        View r5 = this.c;
        if (r5 == null) goto L15;
        LottieAnimationView r8 = (LottieAnimationView) r5.findViewById(2131374931);
    L16:
        this.d = r8;
        View r9 = this.c;
        if (r9 == null) goto L19;
        HSImageView r10 = (HSImageView) r9.findViewById(2131393135);
    L20:
        this.e = r10;
        View r11 = this.c;
        if (r11 == null) goto L23;
        ImageView r12 = (ImageView) r11.findViewById(2131393132);
    L24:
        this.f = r12;
        View r13 = this.c;
        if (r13 == null) goto L27;
        HSImageView r14 = (HSImageView) r13.findViewById(2131393134);
    L28:
        this.g = r14;
        g((Integer) ((ge1.a) hd0.c.f()).b);
        this.h = a0.m(r7).c;
        this.a = r7;
        r7.observeForever("data_audio_talk_dot_with_number_show", new f(new ToolbarAudioInteractBehavior$onLoad$1(this)));
        r7.observe("cmd_finish_voice_talk_room_result", new f(new ToolbarAudioInteractBehavior$onLoad$2(this)));
        DataCenter r15 = this.a;
        if (r15 == null) goto L31;
        r15.observe("data_self_is_silenced", new f(new ToolbarAudioInteractBehavior$onLoad$3(this)));
    L31:
        hd0.c.f().c(this.i);
        Disposable r16 = xs2.b.a().b(b2.class).subscribe(new c(this));
        if (r16 == null) goto L34;
        this.q.add(r16);
    L34:
        r6.post(new d(this));
        j r17 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r17 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r18 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r17.getValue();
        if (r18 == null) goto L43;
        BehaviorSubject r19 = r18.a();
        if (r19 == null) goto L43;
        Disposable r20 = r19.subscribe(new e(this));
        if (r20 == null) goto L43;
        RxUtilKt.c(r20, this.q);
    L43:
        String r21 = this.o;
        if (r21 != null) goto L51;
        IInteractService r22 = (IInteractService) k.f(IInteractService.class);
        if (r22 == null) goto L50;
        com.bytedance.android.live.liveinteract.plantform.performance.a r23 = r22.getMultiLinkPerfAbilityManager(true);
        if (r23 == null) goto L50;
        r21 = r23.b("multilink_toolbar_degrade", new ToolbarAudioInteractBehavior$onLoad$8(this));
    L50:
        r21 = null;
    L51:
        this.o = r21;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b r24 = this.m;
        HSImageView r25 = this.g;
        boolean r26 = this.h;
        IRoom r27 = this.r;
        if (r27 == null) goto L56;
        String r28 = r27.getAnchorId();
        if (r28 == null) goto L56;
    L57:
        IRoom r29 = this.r;
        if (r29 == null) goto L60;
        String r30 = String.valueOf(r29.getRoomId());
    L61:
        r24.b(r25, r26, r28, r30);
        StringBuilder r31 = new StringBuilder("AudioBehavior#onLoad, roomId = ");
        IRoom r32 = this.r;
        if (r32 == null) goto L64;
        r1 = Long.valueOf(r32.getId());
    L64:
        r31.append(r1);
        ALogger.e("dzy-toolbar", r31.toString());
        Log.getStackTraceString(new Throwable("AudioBehavior#onload"));
        return;
    L60:
        r30 = null;
    L56:
        r28 = null;
        goto L57
    L27:
        r14 = null;
        goto L28
    L23:
        r12 = null;
        goto L24
    L19:
        r10 = null;
        goto L20
    L15:
        r8 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    }
}
