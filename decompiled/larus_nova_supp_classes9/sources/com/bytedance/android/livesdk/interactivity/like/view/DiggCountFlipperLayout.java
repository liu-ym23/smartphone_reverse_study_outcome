package com.bytedance.android.livesdk.interactivity.like.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.q4;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.e51;
import com.bytedance.android.livesdk.config.l61;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.like.utils.UserInfoDiggBridge;
import com.bytedance.android.livesdk.message.model.ii;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j40.b1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DiggCountFlipperLayout extends FrameLayout {
    public static final /* synthetic */ int E = 0;
    public final View A;
    public final String B;
    public final View C;
    public final u32.n D;
    public boolean a;
    public int b;
    public CompositeDisposable c;
    public d d;
    public int e;
    public final HashMap<View, Boolean> f;
    public TranslateAnimation g;
    public TranslateAnimation h;
    public String i;
    public final l61 j;
    public boolean k;
    public c l;
    public int m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public TextView q;
    public b r;
    public final ArrayList<View> s;
    public final ArrayList<View> t;
    public final ArrayList<View> u;
    public final ArrayList<ArrayList<View>> v;
    public Function1<? super String, Unit> w;
    public final DataCenter x;
    public final View y;
    public final View z;

    public static final class a {
    }

    public interface b {
        void a(int r1);
    }

    public static final class c extends CountDownTimer {
        public final /* synthetic */ DiggCountFlipperLayout a;
        public final /* synthetic */ Function0 b;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            int r0 = n81.a.a;
            n81.a.b("appointment time out, type = " + this.a.B);
            DiggCountFlipperLayout r1 = this.a;
            int r2 = DiggCountFlipperLayout.E;
            r1.m = 3;
            this.b.invoke();
            u32.n r3 = this.a.D;
            if (r3 == null) goto L6;
            r3.b();
            return;
        }

        public c(DiggCountFlipperLayout r1, Function0 r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            super(r3, r5);
        }
    }

    public static final class d extends CountDownTimer {
        public final /* synthetic */ DiggCountFlipperLayout a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            String r0 = this.a.B;
            int r1 = DiggCountFlipperLayout.E;
            if (Intrinsics.areEqual(r0, "flip_appointment_cert_digg") == false) goto L11;
            DiggCountFlipperLayout r2 = this.a;
            int r3 = r2.m;
            if (r3 != 2) goto L7;
            n81.a.b("digg time out, showAppointmentOrCert, appointmentCountdownTimerState == TIMER_STATE_RUNNING");
            r2.i(true, true, false);
            return;
        L7:
            if (r3 != 1) goto L9;
            n81.a.b("digg time out, showAppointmentOrCert, appointmentCountdownTimerState == TIMER_STATE_PENDING");
            r2.l();
            r2.i(true, true, false);
            return;
        L9:
            n81.a.b("digg time out, showAppointmentOrCert, show cert");
            r2.k(true, true, false);
            return;
        L11:
            if (Intrinsics.areEqual(this.a.B, "flip_appointment_digg") == false) goto L18;
            DiggCountFlipperLayout r4 = this.a;
            int r5 = r4.m;
            if (r5 != 2) goto L15;
            n81.a.b("digg time out, showAppointmentOrDigg, appointmentCountdownTimerState == TIMER_STATE_RUNNING");
            r4.i(true, true, true);
            return;
        L15:
            if (r5 != 1) goto L17;
            n81.a.b("digg time out, showAppointmentOrDigg, appointmentCountdownTimerState == TIMER_STATE_PENDING");
            r4.l();
            r4.i(true, true, true);
            return;
        L17:
            n81.a.b("digg time out, showAppointmentOrDigg, do nothing");
            return;
        L18:
            this.a.k(true, true, true);
        }

        public d(DiggCountFlipperLayout r3) {
            this.a = r3;
            super(2000, 2000);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ DiggCountFlipperLayout a;

        public e(DiggCountFlipperLayout r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.h();
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ DiggCountFlipperLayout b;

        public f(View r1, DiggCountFlipperLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiggCountFlipperLayout.c(this.b, this.a, 1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ DiggCountFlipperLayout a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public g(DiggCountFlipperLayout r1, View r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiggCountFlipperLayout.c(this.a, this.b, this.c);     // Catch: Throwable -> L4
            this.b.setTag(2131389806, null);     // Catch: Throwable -> L4
            this.b.setTag(2131389805, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements com.bytedance.android.livesdk.interactivity.service.textrender.core.q {
        public final /* synthetic */ DiggCountFlipperLayout a;

        public h(DiggCountFlipperLayout r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
        public final void a(py.k r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r2, "model");
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
        public final void b(SpannableString r3, com.bytedance.android.livesdk.interactivity.service.textrender.core.q.a r4) {
            Intrinsics.checkNotNullParameter(r3, "spannable");
            Intrinsics.checkNotNullParameter(r4, "info");
            Intrinsics.checkNotNullParameter(r3, "spannable");
            Intrinsics.checkNotNullParameter(r4, "info");
            TextView r5 = this.a.q;
            if (r5 == null) goto L5;
            r5.setText(r3);
        L5:
            DiggCountFlipperLayout r6 = this.a;
            u32.n r0 = r6.D;
            if (r0 == null) goto L9;
            r0.c(r6.q, r3);
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ DiggCountFlipperLayout a;

        public i(DiggCountFlipperLayout r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            n81.a.b("user digg");
            this.a.h();
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ DiggCountFlipperLayout a;

        public j(DiggCountFlipperLayout r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            n81.a.b("user digg");
            this.a.h();
        }
    }

    static {
    }

    public final void h() {
        int r0 = this.e;
        if (r0 == 0) goto L6;
        if (2 == r0) goto L6;
    L14:
        d r1 = this.d;
        if (r1 == null) goto L18;
        r1.cancel();
        r1.start();
        return;
    L18:
        return;
    L6:
        if (Intrinsics.areEqual(this.B, "flip_appointment_cert_digg") == false) goto L12;
        int r2 = this.e;
        if (r2 != 2) goto L10;
        j(true, false, true);
    L13:
        this.e = 1;
        goto L14
    L10:
        if (r2 != 0) goto L13;
        j(true, true, false);
        goto L13
    L12:
        j(true, true, true);
        goto L13
    }

    public final void l() {
        if (this.m == 1) goto L5;
        return;
    L5:
        n81.a.b("startAppointmentTimerIfPending, start pending timer");
        c r0 = this.l;
        if (r0 == null) goto L8;
        r0.start();
    L8:
        this.m = 2;
        u32.n r1 = this.D;
        if (r1 == null) goto L12;
        r1.g();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.d = new d(this);
        this.c = new CompositeDisposable();
        TranslateAnimation r0 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 1.0f, 1, 0.0f);
        r0.setDuration(300);
        r0.setFillAfter(true);
        this.g = r0;
        TranslateAnimation r1 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, 0.0f, 2, -1.0f);
        r1.setDuration(300);
        r1.setFillAfter(true);
        this.h = r1;
        Iterator<View> r2 = this.s.iterator();
    L3:
        ViewParent r3 = null;
        if (r2.hasNext() == false) goto L15;
        View r4 = r2.next();
        ViewParent r8 = r4.getParent();
        if ((r8 instanceof ViewGroup) == false) goto L9;
        r3 = r8;
    L9:
        ViewGroup r5 = (ViewGroup) r3;
        if (r5 == null) goto L12;
        r5.removeView(r4);
    L12:
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 16;
        Unit r7 = Unit.INSTANCE;
        addView(r4, r6);
        if (Intrinsics.areEqual(this.B, "flip_extra") == false) goto L3;
        r4.setVisibility(8);
        goto L3
    L15:
        Iterator<View> r9 = this.u.iterator();
    L17:
        if (r9.hasNext() == false) goto L25;
        View r10 = r9.next();
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == true) goto L21;
        r11 = null;
    L21:
        ViewGroup r13 = (ViewGroup) r11;
        if (r13 == null) goto L24;
        r13.removeView(r10);
    L24:
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 16;
        Unit r15 = Unit.INSTANCE;
        addView(r10, r14);
        goto L17
    L25:
        String r16 = this.B;
        if (Intrinsics.areEqual(r16, "origin") == false) goto L33;
        Iterator<View> r17 = this.t.iterator();
    L29:
        if (r17.hasNext() == false) goto L31;
        r17.next().setVisibility(8);
        goto L29
    L31:
        k(false, true, true);
        return;
    L33:
        if (Intrinsics.areEqual(r16, "new") == false) goto L40;
        Iterator<View> r18 = this.s.iterator();
    L36:
        if (r18.hasNext() == false) goto L38;
        r18.next().setVisibility(8);
        goto L36
    L38:
        j(false, true, true);
        return;
    L40:
        if (Intrinsics.areEqual(r16, "flip") == false) goto L43;
        ((ObservableSubscribeProxy) du2.a.b(0, 5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).doFinally(new q(this)).map(new r(this)).as(AutoDispose.bind(this))).subscribe();
        return;
    L43:
        if (Intrinsics.areEqual(r16, "flip_active") == false) goto L55;
        DiggContext.a r19 = DiggContext.Companion;
        DataCenter r20 = this.x;
        r19.getClass();
        DiggContext r21 = DiggContext.a.a(r20);
        if (r21 == null) goto L53;
        com.bytedance.live.datacontext.m<Long> r23 = r21.getDiggTime();
        if (r23 == null) goto L53;
        Observable r24 = r23.a();
        if (r24 == null) goto L53;
        Disposable r25 = r24.subscribe(new e(this));
        if (r25 == null) goto L53;
        d(r25);
    L53:
        k(false, true, true);
        return;
    L55:
        if (Intrinsics.areEqual(r16, "flip_extra") == false) goto L58;
        ((ObservableSubscribeProxy) du2.a.b(0, 5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).doFinally(new o(this)).map(new p(this, this.v.size())).as(AutoDispose.bind(this))).subscribe();
        return;
    L58:
        if (Intrinsics.areEqual(r16, "flip_appointment_cert_digg") == false) goto L114;
        n81.a.b("flip type is FLIP_APPOINTMENT_CERT_DIGG");
        u32.n r26 = this.D;
        if (r26 == null) goto L62;
        TextView r27 = r26.e();
    L63:
        this.q = r27;
        if (r27 == null) goto L73;
        ViewParent r28 = r27.getParent();
        if ((r28 instanceof ViewGroup) == false) goto L69;
        r3 = r28;
    L69:
        ViewGroup r29 = (ViewGroup) r3;
        if (r29 == null) goto L72;
        r29.removeView(r27);
    L72:
        FrameLayout.LayoutParams r30 = new FrameLayout.LayoutParams(-2, -2);
        r30.gravity = 16;
        Unit r31 = Unit.INSTANCE;
        addView(r27, r30);
        r27.setVisibility(8);
    L73:
        u32.n r33 = this.D;
        if (r33 == null) goto L76;
        boolean r34 = r33.a();
    L77:
        u32.n r35 = this.D;
        if (r35 == null) goto L80;
        long r36 = r35.d();
    L81:
        n81.a.b("configAppointmentCertDiggFlip, flipWhenInit = " + r34 + ", flipTime = " + r36);
        if (r34 == true) goto L84;
    L103:
        n81.a.b("configAppointmentCertDiggFlip, load no appointment");
        DiggContext.a r37 = DiggContext.Companion;
        DataCenter r38 = this.x;
        r37.getClass();
        DiggContext r39 = DiggContext.a.a(r38);
        if (r39 == null) goto L112;
        com.bytedance.live.datacontext.m<Long> r40 = r39.getDiggTime();
        if (r40 == null) goto L112;
        Observable r41 = r40.a();
        if (r41 == null) goto L112;
        Disposable r43 = r41.subscribe(new m(this));
        if (r43 == null) goto L112;
        d(r43);
    L112:
        k(false, true, true);
        return;
    L84:
        if (r36 <= 0) goto L103;
        Iterator<View> r44 = this.s.iterator();
    L87:
        if (r44.hasNext() == false) goto L89;
        r44.next().setVisibility(8);
        goto L87
    L89:
        Iterator<View> r45 = this.t.iterator();
    L91:
        if (r45.hasNext() == false) goto L93;
        r45.next().setVisibility(8);
        goto L91
    L93:
        f(r36 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW), true, new DiggCountFlipperLayout$configAppointmentCertDiggFlip$4(this));
        DiggContext.a r46 = DiggContext.Companion;
        DataCenter r47 = this.x;
        r46.getClass();
        DiggContext r48 = DiggContext.a.a(r47);
        if (r48 == null) goto L102;
        com.bytedance.live.datacontext.m<Long> r49 = r48.getDiggTime();
        if (r49 == null) goto L102;
        Observable r50 = r49.a();
        if (r50 == null) goto L102;
        Disposable r51 = r50.subscribe(new l(this));
        if (r51 == null) goto L102;
        d(r51);
    L102:
        i(false, true, true);
        return;
    L80:
        r36 = 0;
        goto L81
    L76:
        r34 = false;
        goto L77
    L62:
        r27 = null;
        goto L63
    L114:
        if (Intrinsics.areEqual(r16, "flip_appointment_digg") == false) goto L187;
        n81.a.b("flip type is FLIP_APPOINTMENT_DIGG");
        u32.n r53 = this.D;
        if (r53 == null) goto L118;
        TextView r54 = r53.e();
    L119:
        this.q = r54;
        if (r54 == null) goto L129;
        ViewParent r55 = r54.getParent();
        if ((r55 instanceof ViewGroup) == false) goto L125;
        r3 = r55;
    L125:
        ViewGroup r56 = (ViewGroup) r3;
        if (r56 == null) goto L128;
        r56.removeView(r54);
    L128:
        FrameLayout.LayoutParams r57 = new FrameLayout.LayoutParams(-2, -2);
        r57.gravity = 16;
        Unit r58 = Unit.INSTANCE;
        addView(r54, r57);
        r54.setVisibility(8);
    L129:
        u32.n r59 = this.D;
        if (r59 == null) goto L132;
        boolean r60 = r59.a();
    L133:
        u32.n r61 = this.D;
        if (r61 == null) goto L136;
        long r63 = r61.d();
    L137:
        n81.a.b("configAppointmentCertDiggFlip, flipWhenInit = " + r60 + ", flipTime = " + r63);
        if (r60 == true) goto L140;
    L159:
        n81.a.b("configAppointmentCertDiggFlip, load no appointment");
        Iterator<View> r64 = this.s.iterator();
    L161:
        if (r64.hasNext() == false) goto L163;
        r64.next().setVisibility(8);
        goto L161
    L163:
        j(false, true, true);
        return;
    L140:
        if (r63 <= 0) goto L159;
        Iterator<View> r65 = this.s.iterator();
    L143:
        if (r65.hasNext() == false) goto L145;
        r65.next().setVisibility(8);
        goto L143
    L145:
        Iterator<View> r66 = this.t.iterator();
    L147:
        if (r66.hasNext() == false) goto L149;
        r66.next().setVisibility(8);
        goto L147
    L149:
        f(r63 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW), true, new DiggCountFlipperLayout$configAppointmentDiggFlip$4(this));
        DiggContext.a r67 = DiggContext.Companion;
        DataCenter r68 = this.x;
        r67.getClass();
        DiggContext r69 = DiggContext.a.a(r68);
        if (r69 == null) goto L158;
        com.bytedance.live.datacontext.m<Long> r70 = r69.getDiggTime();
        if (r70 == null) goto L158;
        Observable r71 = r70.a();
        if (r71 == null) goto L158;
        Disposable r73 = r71.subscribe(new n(this));
        if (r73 == null) goto L158;
        d(r73);
    L158:
        i(false, true, true);
        return;
    L136:
        r63 = 0;
        goto L137
    L132:
        r60 = false;
        goto L133
    L118:
        r54 = null;
        goto L119
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (((e51) b1.a.getValue()).a() == false) goto L19;
        Iterator<View> r0 = this.s.iterator();
    L6:
        if (r0.hasNext() == false) goto L19;
        View r2 = r0.next();
        HashMap<View, Boolean> r3 = this.f;
        if (r3 == null) goto L10;
        Boolean r4 = r3.get(r2);
    L11:
        if (r4 == null) goto L18;
        HashMap<View, Boolean> r5 = this.f;
        if (r5 == null) goto L15;
        Boolean r6 = r5.get(r2);
    L17:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L6;
    L15:
        r6 = null;
    L18:
        int r7 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(this.x, this.c, "sendTagShowLog", new f(r2, this));
        goto L6
    L10:
        r4 = null;
    L19:
        CompositeDisposable r1 = this.c;
        if (r1 == null) goto L22;
        r1.dispose();
    L22:
        d r8 = this.d;
        if (r8 == null) goto L25;
        r8.cancel();
    L25:
        this.d = null;
        c r9 = this.l;
        if (r9 == null) goto L28;
        r9.cancel();
    L28:
        this.l = null;
    }

    public final DataCenter getDataCenter() {
        return this.x;
    }

    public final int getFlipCount() {
        return this.b;
    }

    public static final void a(DiggCountFlipperLayout r2) {
        if (r2.e != 1) goto L5;
        n81.a.b("onAppointmentExpireWithCertDigg, is digging");
        return;
    L5:
        n81.a.b("onAppointmentExpireWithCertDigg, change to cert");
        r2.k(true, false, true);
    }

    public static final void b(DiggCountFlipperLayout r2) {
        if (r2.e != 1) goto L5;
        n81.a.b("onAppointmentExpireWithCertDigg, is digging");
        return;
    L5:
        n81.a.b("onAppointmentExpireWithCertDigg, change to digg");
        r2.j(true, true, true);
    }

    public final void d(Disposable r2) {
        CompositeDisposable r0 = this.c;
        if (r0 == null) goto L6;
        r0.add(r2);
        return;
    }

    public final void m(ii r13) {
        Intrinsics.checkNotNullParameter(r13, "message");
        if ((!Intrinsics.areEqual(this.B, "flip_appointment_cert_digg")) == false) goto L9;
        if ((!Intrinsics.areEqual(this.B, "flip_appointment_digg")) == false) goto L9;
        int r14 = n81.a.a;
        n81.a.b("tryShowAppointmentMessage, flip type error, is " + this.B);
        return;
    L9:
        if (this.m == 0) goto L12;
        int r15 = n81.a.a;
        n81.a.b("tryShowAppointmentMessage, appointmentCountdownTimerState error, is " + this.m);
        return;
    L12:
        Long r0 = r13.getDuration();
        long r4 = 0;
        if (r0 == null) goto L15;
        long r6 = r0.longValue();
    L17:
        if (r6 > 0) goto L20;
        int r1 = n81.a.a;
        r6 = ((Long) q4.a.getValue()).longValue();
    L20:
        int r2 = n81.a.a;
        n81.a.b("tryShowAppointmentMessage, flipTime is " + r6);
        if (r6 <= 0) goto L71;
        a5 r16 = r13.E();
        if (r16 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.r.g.d(r16, null, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(0.0f), new h(this));
    L25:
        String r17 = this.B;
        int r3 = r17.hashCode();
        if (r3 == (-2118222249)) goto L37;
        if (r3 == (-1446375826)) goto L31;
        return;
    L31:
        if (r17.equals("flip_appointment_cert_digg") == true) goto L33;
        return;
    L33:
        if (this.e != 1) goto L35;
        n81.a.b("tryShowAppointmentMessage, type is FLIP_APPOINTMENT_CERT_DIGG, mState is STATE_DIGGING");
        f(r6 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW), false, new DiggCountFlipperLayout$tryShowAppointmentMessage$2(this));
        return;
    L35:
        n81.a.b("tryShowAppointmentMessage, type is FLIP_APPOINTMENT_CERT_DIGG, mState is " + this.e);
        f(r6 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW), true, new DiggCountFlipperLayout$tryShowAppointmentMessage$3(this));
        i(true, false, true);
        return;
    L37:
        if (r17.equals("flip_appointment_digg") == false) goto L75;
        DiggContext.a r18 = DiggContext.Companion;
        DataCenter r5 = this.x;
        r18.getClass();
        DiggContext r19 = DiggContext.a.a(r5);
        if (r19 == null) goto L46;
        com.bytedance.live.datacontext.m<Long> r110 = r19.getDiggTime();
        if (r110 == null) goto L46;
        Long r111 = (Long) r110.getValue();
        if (r111 == null) goto L46;
        r4 = r111.longValue();
    L46:
        if ((System.currentTimeMillis() - r4) >= 2000) goto L48;
        boolean r112 = true;
    L49:
        if (r112 == false) goto L60;
        DiggContext r113 = DiggContext.a.a(this.x);
        if (r113 == null) goto L59;
        com.bytedance.live.datacontext.m<Long> r114 = r113.getDiggTime();
        if (r114 == null) goto L59;
        Observable r115 = r114.a();
        if (r115 == null) goto L59;
        Disposable r116 = r115.subscribe(new i(this));
        if (r116 == null) goto L59;
        d(r116);
    L59:
        n81.a.b("tryShowAppointmentMessage, type is FLIP_APPOINTMENT_DIGG, mState is STATE_DIGGING");
        f(r6 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW), false, new DiggCountFlipperLayout$tryShowAppointmentMessage$5(this));
        h();
        return;
    L60:
        DiggContext r117 = DiggContext.a.a(this.x);
        if (r117 == null) goto L69;
        com.bytedance.live.datacontext.m<Long> r118 = r117.getDiggTime();
        if (r118 == null) goto L69;
        Observable r119 = r118.a();
        if (r119 == null) goto L69;
        Disposable r120 = r119.subscribe(new j(this));
        if (r120 == null) goto L69;
        d(r120);
    L69:
        n81.a.b("tryShowAppointmentMessage, type is FLIP_APPOINTMENT_DIGG, mState is Origin Digg");
        f(r6 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW), true, new DiggCountFlipperLayout$tryShowAppointmentMessage$7(this));
        i(true, true, true);
        return;
    L48:
        r112 = false;
        goto L49
    L75:
        return;
    L71:
        return;
    L15:
        r6 = 0;
        goto L17
    }

    public final void n(int r2) {
        TextView r0 = this.n;
        if (r0 == null) goto L5;
        r0.setTextColor(r2);
    L5:
        TextView r1 = this.o;
        if (r1 == null) goto L8;
        r1.setTextColor(r2);
    L8:
        TextView r3 = this.p;
        if (r3 == null) goto L12;
        r3.setTextColor(r2);
        return;
    }

    public final void o(String r4) {
        Intrinsics.checkNotNullParameter(r4, "countString");
        this.i = s1.C(2131916203, new Object[]{r4});
        if (this.j.a() == false) goto L13;
        String r1 = this.i;
        TextView r2 = this.n;
        if (r2 == null) goto L7;
        CharSequence r3 = r2.getText();
    L9:
        if ((!Intrinsics.areEqual(r1, r3)) == false) goto L16;
        TextView r5 = this.n;
        if (r5 == null) goto L16;
        r5.setText(this.i);
    L16:
        TextView r6 = this.o;
        if (r6 == null) goto L20;
        r6.setText(r4);
    L20:
        if (this.e != 1) goto L25;
        Function1<? super String, Unit> r7 = this.w;
        if (r7 == null) goto L26;
        Unit r8 = (Unit) r7.invoke(this.i);
        return;
    L26:
        return;
    L25:
        return;
    L7:
        r3 = null;
        goto L9
    L13:
        TextView r9 = this.n;
        if (r9 == null) goto L16;
        r9.setText(this.i);
        goto L16
    }

    public final void setAnchor(boolean r1) {
        this.a = r1;
    }

    public final void setCanFlip(boolean r1) {
        this.k = r1;
    }

    public final void setContentDescriptionAction(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.w = r2;
    }

    public final void setFlipCount(b r2) {
        Intrinsics.checkNotNullParameter(r2, "flipListener");
        this.r = r2;
    }

    public final void setFlipCount(int r1) {
        this.b = r1;
    }

    public final void g(View r4, int r5) {
        int r0 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(this.x, this.c, "sendTagShowLog", new g(this, r4, r5));
    }

    public final void p(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "countStr");
        Intrinsics.checkNotNullParameter(r6, "descText");
        if ((this.b % 2) != 1) goto L10;
        TextView r0 = this.o;
        if (r0 == null) goto L7;
        r0.setText(r5);
        ALogger.d("Flip", "  diggCountView  : " + r5);
    L7:
        TextView r7 = this.p;
        if (r7 == null) goto L24;
        r7.setText(r6);
        ALogger.d("Flip", "  diggDescriptionView  : " + r6);
        Unit r8 = Unit.INSTANCE;
        return;
    L24:
        return;
    L10:
        View r1 = this.z;
        View r3 = null;
        if ((r1 instanceof TextView) == true) goto L13;
        r1 = null;
    L13:
        TextView r2 = (TextView) r1;
        if (r2 == null) goto L16;
        r2.setText(r5);
        ALogger.d("Flip", "  countView  : " + r5);
    L16:
        View r9 = this.A;
        if ((r9 instanceof TextView) == false) goto L20;
        r3 = r9;
    L20:
        TextView r4 = (TextView) r3;
        if (r4 == null) goto L26;
        r4.setText(r6);
        ALogger.d("Flip", "  descriptionView  : " + r6);
        Unit r10 = Unit.INSTANCE;
        return;
    }

    public static final void c(DiggCountFlipperLayout r9, View r10, int r11) {
        r9.getClass();
        Object r0 = r10.getTag(2131389806);
        Object r1 = r10.getTag(2131389805);
        Object r2 = r10.getTag(2131389802);
        Object r3 = r10.getTag(2131389803);
        Object r4 = r10.getTag(2131389807);
        boolean r5 = r0 instanceof String;
        if (r5 == false) goto L5;
    L10:
        com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
        LinkedHashMap r7 = new LinkedHashMap();
        if (r5 == true) goto L13;
        Object r8 = null;
    L15:
        if (((String) r8) == null) goto L18;
        r7.put("tag_type", r0);
    L18:
        if ((r1 instanceof Integer) == true) goto L20;
        Object r13 = null;
    L21:
        Integer r14 = (Integer) r13;
        if (r14 == null) goto L25;
        r14.intValue();
        r7.put("tag_name", r1.toString());
    L25:
        if ((r3 instanceof String) == true) goto L27;
        r3 = null;
    L27:
        String r15 = (String) r3;
        if (r15 == null) goto L31;
        r7.put("tag_detail", r15);
    L31:
        if ((r2 instanceof String) == true) goto L33;
        r2 = null;
    L33:
        String r16 = (String) r2;
        if (r16 == null) goto L37;
        r7.put("EVENT_ORIGIN_FEATURE", r16);
    L37:
        if ((r4 instanceof Map) == true) goto L39;
        r4 = null;
    L39:
        Map r17 = (Map) r4;
        if (r17 == null) goto L42;
        r7.putAll(r17);
    L42:
        r7.put("tag_order", String.valueOf(r11));
        Unit r18 = Unit.INSTANCE;
        r6.sendLog("livesdk_tag_show", r7, new Object[]{am2.x.class, Room.class});
        r9.f.put(r10, Boolean.TRUE);
        return;
    L20:
        r13 = r1;
        goto L21
    L13:
        r8 = r0;
        goto L15
    L5:
        if ((r1 instanceof Integer) == true) goto L10;
        if ((r2 instanceof String) == true) goto L10;
        if ((r3 instanceof String) == true) goto L10;
    }

    public final void e(boolean r3, boolean r4, boolean r5) {
        if (Intrinsics.areEqual(this.B, "flip_appointment_cert_digg") == false) goto L37;
        if (r3 == true) goto L9;
        Iterator<T> r6 = this.t.iterator();
    L7:
        if (r6.hasNext() == false) goto L13;
        View r0 = (View) r6.next();
        r0.clearAnimation();
        UtilityKotlinExtentionsKt.t(r0);
    L13:
        if (r4 == true) goto L18;
        Iterator<T> r7 = this.s.iterator();
    L16:
        if (r7.hasNext() == false) goto L22;
        View r8 = (View) r7.next();
        r8.clearAnimation();
        UtilityKotlinExtentionsKt.t(r8);
    L22:
        if (r5 == true) goto L29;
        TextView r9 = this.q;
        if (r9 == null) goto L26;
        r9.clearAnimation();
    L26:
        TextView r10 = this.q;
        if (r10 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r10);
        return;
    L38:
        return;
    L29:
        TextView r11 = this.q;
        if (r11 == null) goto L40;
        UtilityKotlinExtentionsKt.w(r11);
        return;
    L40:
        return;
    L18:
        Iterator<T> r13 = this.s.iterator();
    L20:
        if (r13.hasNext() == false) goto L22;
        UtilityKotlinExtentionsKt.w((View) r13.next());
        goto L20
    L9:
        Iterator<T> r14 = this.t.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        UtilityKotlinExtentionsKt.w((View) r14.next());
        goto L11
    }

    public final void f(long r9, boolean r11, Function0<Unit> r13) {
        c r0 = this.l;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.l = new c(this, r13, r9, r9);
        if (r11 == false) goto L13;
        n81.a.b("createAppointmentTimer, start");
        c r10 = this.l;
        if (r10 == null) goto L10;
        r10.start();
    L10:
        this.m = 2;
        u32.n r14 = this.D;
        if (r14 == null) goto L15;
        r14.g();
        return;
    L15:
        return;
    L13:
        n81.a.b("createAppointmentTimer, pending");
        this.m = 1;
    }

    public final void i(boolean r3, boolean r4, boolean r5) {
        int r0 = n81.a.a;
        n81.a.b("showAppointmentView, isNeedFlip = " + r3);
        if (r3 == false) goto L18;
        e(r4, r5, true);
        if (r4 == false) goto L10;
        Iterator<View> r6 = this.t.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r6.next().startAnimation(this.h);
    L10:
        if (r5 == false) goto L15;
        Iterator<View> r7 = this.s.iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        r7.next().startAnimation(this.h);
    L15:
        TextView r8 = this.q;
        if (r8 == null) goto L18;
        r8.startAnimation(this.g);
    L18:
        u32.n r9 = this.D;
        if (r9 == null) goto L21;
        r9.f("appointment");
    L21:
        TextView r10 = this.q;
        if (r10 == null) goto L32;
        n81.b.a.getClass();
        Object r11 = r10.getTag(2131389804);
        if ((r11 instanceof n81.b) == true) goto L26;
        r11 = null;
    L26:
        n81.b r13 = (n81.b) r11;
        if (r13 == null) goto L29;
        r13.onShow();
    L29:
        r10.setVisibility(0);
        if (((e51) b1.a.getValue()).a() == true) goto L32;
        g(r10, 1);
    L32:
        this.e = 2;
    }

    public final void j(boolean r5, boolean r6, boolean r7) {
        if (r5 == false) goto L17;
        e(true, r6, r7);
        Iterator<View> r1 = this.t.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().startAnimation(this.g);
        goto L6
    L8:
        if (r6 == false) goto L13;
        Iterator<View> r8 = this.s.iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        r8.next().startAnimation(this.h);
    L13:
        if (r7 == false) goto L17;
        TextView r9 = this.q;
        if (r9 == null) goto L17;
        r9.startAnimation(this.h);
    L17:
        u32.n r10 = this.D;
        if (r10 == null) goto L20;
        r10.f("digg");
    L20:
        Iterator<View> r11 = this.t.iterator();
    L22:
        if (r11.hasNext() == false) goto L34;
        View r13 = r11.next();
        n81.b.a.getClass();
        Object r2 = r13.getTag(2131389804);
        if ((r2 instanceof n81.b) == true) goto L26;
        r2 = null;
    L26:
        n81.b r3 = (n81.b) r2;
        if (r3 == null) goto L29;
        r3.onShow();
    L29:
        r13.setVisibility(0);
        if (r5 == true) goto L32;
        int r4 = 1;
    L33:
        g(r13, r4);
        goto L22
    L32:
        r4 = 2;
        goto L33
    L34:
        this.e = 1;
    }

    public final void k(boolean r4, boolean r5, boolean r6) {
        if (r4 == false) goto L18;
        e(r5, true, r6);
        if (r5 == false) goto L10;
        Iterator<View> r7 = this.t.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r7.next().startAnimation(this.h);
    L10:
        if (r6 == false) goto L14;
        TextView r8 = this.q;
        if (r8 == null) goto L14;
        r8.startAnimation(this.h);
    L14:
        Iterator<View> r9 = this.s.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r9.next().startAnimation(this.g);
    L18:
        u32.n r10 = this.D;
        if (r10 == null) goto L21;
        r10.f("cert");
    L21:
        Iterator<View> r11 = this.s.iterator();
    L23:
        if (r11.hasNext() == false) goto L33;
        View r13 = r11.next();
        n81.b.a.getClass();
        Object r1 = r13.getTag(2131389804);
        if ((r1 instanceof n81.b) == true) goto L27;
        r1 = null;
    L27:
        n81.b r2 = (n81.b) r1;
        if (r2 == null) goto L30;
        r2.onShow();
    L30:
        r13.setVisibility(0);
        if (((e51) b1.a.getValue()).a() == true) goto L23;
        g(r13, 1);
        goto L23
    L33:
        this.e = 0;
    }

    public DiggCountFlipperLayout(DataCenter r18, Context r19, View r20, View r21, View r23, String r24, View r25, u32.n r26, int r27) {
        if ((r27 & 4) == 0) goto L5;
        View r4 = null;
    L7:
        if ((r27 & 8) == 0) goto L9;
        View r6 = null;
    L11:
        if ((r27 & 16) == 0) goto L13;
        View r7 = null;
    L15:
        if ((r27 & 32) == 0) goto L17;
        String r8 = BuildConfig.FLAVOR;
    L19:
        if ((r27 & 64) == 0) goto L21;
        View r10 = null;
    L23:
        if ((r27 & 128) == 0) goto L25;
        u32.n r3 = null;
    L26:
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r8, "flipType");
        super(r19);
        this.x = r18;
        this.y = r4;
        this.z = r6;
        this.A = r7;
        this.B = r8;
        this.C = r10;
        this.D = r3;
        Room r5 = jc1.k.n(IRoomService.class).getCurrentRoom();
        if (r5 == null) goto L31;
        User r9 = r5.getOwner();
        if (r9 == null) goto L31;
        String r11 = r9.getIdStr();
    L32:
        this.a = Intrinsics.areEqual(r11, jc1.k.n(IUserService.class).user().n());
        this.f = new HashMap();
        this.i = BuildConfig.FLAVOR;
        l61 r13 = (l61) LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue();
        this.j = r13;
        int r14 = (int) s1.e(66.0f);
        this.k = true;
        if (r4 == null) goto L39;
        TextView r15 = new TextView(r19);
        r15.setVisibility(8);
        r15.setTextSize(1, 8.0f);
        r15.setTextColor(ColorProtector.parseColor("#b3ffffff"));
        r15.setMaxLines(1);
        r15.setSingleLine(true);
        r15.setTag(2131389806, "like_cnt");
        n81.b.a.getClass();
        r15.setTag(2131389804, new k(this));
        Unit r16 = Unit.INSTANCE;
        if (r13.a() == true) goto L38;
        r14 = -2;
    L38:
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(r14, -2);
        r17.gravity = 16;
        addView(r15, r17);
    L40:
        this.n = r15;
        if (r6 == null) goto L47;
        TextView r28 = new TextView(r19);
        r28.setVisibility(8);
        r28.setTextSize(1, 12.0f);
        if (this.a == false) goto L45;
        r28.setTextColor(ColorProtector.parseColor("#FFFFFF"));
    L46:
        r28.setMaxLines(1);
        r28.setSingleLine(true);
        r28.setTag(2131389806, "like_cnt");
        Unit r29 = Unit.INSTANCE;
        FrameLayout.LayoutParams r30 = new FrameLayout.LayoutParams(-2, -2);
        r30.gravity = 16;
        addView(r28, r30);
    L48:
        this.o = r28;
        if (r7 == null) goto L62;
        TextView r31 = new TextView(r19);
        r31.setVisibility(8);
        r31.setTextSize(1, 10.0f);
        if (this.a == false) goto L60;
        DiggContext r1 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(RoomContext.a.c(RoomContext.Companion, r18, 0, 2));
        if (r1 == null) goto L59;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.getInDoubleLike();
        if (r2 == null) goto L59;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L59;
        r31.setTextColor(UserInfoDiggBridge.e);
    L61:
        r31.setMaxLines(1);
        r31.setSingleLine(true);
        r31.setText(2131916204);
        Unit r33 = Unit.INSTANCE;
        FrameLayout.LayoutParams r34 = new FrameLayout.LayoutParams(-2, -2);
        r34.gravity = 16;
        addView(r31, r34);
    L63:
        this.p = r31;
        ArrayList<View> r35 = new ArrayList();
        if (r4 == null) goto L66;
        r35.add(r4);
    L66:
        if (r6 == null) goto L68;
        r35.add(r6);
    L68:
        if (r7 == null) goto L70;
        r35.add(r7);
    L70:
        Unit r36 = Unit.INSTANCE;
        this.s = r35;
        ArrayList<View> r37 = new ArrayList();
        if (r15 == null) goto L73;
        r37.add(r15);
    L73:
        if (r28 == null) goto L75;
        r37.add(r28);
    L75:
        if (r31 == null) goto L77;
        r37.add(r31);
    L77:
        this.t = r37;
        ArrayList<View> r38 = new ArrayList();
        if (r10 == null) goto L80;
        r38.add(r10);
    L80:
        this.u = r38;
        ArrayList<ArrayList<View>> r39 = new ArrayList();
        if (r38.size() <= 0) goto L84;
        r39.add(r38);
    L84:
        if (r35.size() <= 0) goto L87;
        r39.add(r35);
    L87:
        if (r37.size() <= 0) goto L89;
        r39.add(r37);
    L89:
        this.v = r39;
        return;
    L59:
        r31.setTextColor(ColorProtector.parseColor("#EAE9E9"));
        goto L61
    L60:
        r31.setTextColor(ColorProtector.parseColor("#b3ffffff"));
        goto L61
    L62:
        r31 = null;
        goto L63
    L45:
        r28.setTextColor(ColorProtector.parseColor("#b3ffffff"));
        goto L46
    L47:
        r28 = null;
        goto L48
    L39:
        r15 = null;
    L31:
        r11 = null;
        goto L32
    L25:
        r3 = r26;
        goto L26
    L21:
        r10 = r25;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r7 = r23;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r4 = r20;
        goto L7
    }
}
