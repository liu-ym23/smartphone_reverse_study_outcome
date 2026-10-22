package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.BattleLaunchType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.mergepk.params.LinkmicBizType;
import com.bytedance.android.live.revlink.impl.mergepk.params.ReplyType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleAuxiliaryConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage;
import com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.bridge.p0;
import com.bytedance.android.livesdk.link.model.bridge.t0;
import com.bytedance.android.livesdk.link.model.bridge.w0;
import com.bytedance.android.livesdk.link.model.bridge.x0;
import com.bytedance.android.livesdk.link.model.e5;
import com.bytedance.android.livesdk.link.model.h5;
import com.bytedance.android.livesdk.link.model.j7;
import com.bytedance.android.livesdk.link.model.n1;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import w20.ea;
import w20.o7;
import w20.q7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkAnchorLauncher implements com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a {
    public final yz0.f A;
    public final x11.a B;
    public boolean a;
    public final CompositeDisposable b;
    public boolean c;
    public boolean d;
    public boolean e;
    public Disposable f;
    public Disposable g;
    public final MutableLiveData<c21.c> h;
    public final MutableLiveData i;
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.C0127a> j;
    public final MutableLiveData k;
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.c> l;
    public final MutableLiveData m;
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.d> n;
    public final MutableLiveData o;
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.e> p;
    public final MutableLiveData q;
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.f> r;
    public final MutableLiveData s;
    public final h41.e t;
    public final Function0<Integer> u;
    public final LiveData<PkBaseStateMachine.c> v;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e w;
    public final IRoom x;
    public final com.bytedance.android.livesdk.revenue.service.room.c y;
    public final com.bytedance.android.live.revlink.impl.global.c z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.b b;
        public final /* synthetic */ c21.l c;
        public final /* synthetic */ long d;
        public final /* synthetic */ c21.a e;
        public final /* synthetic */ Ref.ObjectRef f;

        public a(PkAnchorLauncher r1, c21.b r2, c21.l r3, long r4, c21.a r6, Ref.ObjectRef r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r20) {
            ExtraResponse r1 = (ExtraResponse) r20;
            PkAnchorLauncher r2 = this.a;
            r2.a = true;
            Disposable r3 = r2.f;
            if (r3 == null) goto L5;
            r3.dispose();
        L5:
            PkAnchorLauncher r4 = this.a;
            r4.c = false;
            r4.h.setValue(new c21.c.d());
            PkAnchorLauncher.t(this.a);
            d31.f r5 = PkAnchorLauncher.r(this.a);
            if (r5 == null) goto L8;
            r5.e("linkmic/battle/invite/", new d31.a(0, this.c.a.getType(), 0, 0, null, 0, this.c.c, null, null, null, null, 4029), t.a(this.d));
        L8:
            b21.e r6 = this.a.z();
            if (r6 == null) goto L13;
            c21.b r7 = this.b;
            long r9 = t.a(this.d);
            int r12 = ((Number) this.a.u.invoke()).intValue();
            Intrinsics.checkNotNullParameter(r7, "battleInviteParams");
            HashMap<String, String> r13 = new HashMap();
            r6.b(r13);
            b21.e.a(r13, r7);
            LiveFullLinkPKMonitor r8 = r6.c();
            if (r8 == null) goto L13;
            LiveFullLinkPKMonitor.s(r8, "linkmic/battle/invite", r9, 0, r12, r13, 4);
        L13:
            int r10 = ToastUtil.a;
            n1 r14 = (n1) r1.data;
            if (r14 == null) goto L16;
            String r15 = r14.getToast();
        L17:
            ToastUtil.b(r15, 0);
            com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r16 = this.a.y();
            if (r16 == null) goto L20;
            r16.setPkLauncher(true);
        L20:
            c21.a r17 = this.e;
            if (r17 == null) goto L24;
            r17.a(this.b);
        L24:
            if (d51.c.A0.e() == false) goto L27;
            this.a.B((Map) this.f.element, ((n1) r1.data).getEventTrackingInfo(), "livesdk_connection_invite");
            return;
        L27:
            return;
        L16:
            r15 = null;
            goto L17
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.l b;
        public final /* synthetic */ long c;
        public final /* synthetic */ c21.b d;
        public final /* synthetic */ c21.a e;
        public final /* synthetic */ Ref.ObjectRef f;

        public b(PkAnchorLauncher r1, c21.l r2, long r3, c21.b r5, c21.a r6, Ref.ObjectRef r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r25) {
            Throwable r10 = (Throwable) r25;
            Disposable r1 = this.a.f;
            if (r1 == null) goto L5;
            r1.dispose();
        L5:
            PkAnchorLauncher r2 = this.a;
            r2.c = false;
            r2.h.setValue(c21.c.C0008c.a);
            d31.f r3 = PkAnchorLauncher.r(this.a);
            if (r3 == null) goto L8;
            r3.c("linkmic/battle/invite/", new d31.a(0, this.b.a.getType(), 0, 0, null, 0, this.b.c, null, null, null, null, 4029), r10, t.a(this.c));
        L8:
            b21.e r4 = this.a.z();
            if (r4 == null) goto L13;
            c21.b r5 = this.d;
            long r6 = t.a(this.c);
            int r7 = ((Number) this.a.u.invoke()).intValue();
            Intrinsics.checkNotNullParameter(r5, "battleInviteParams");
            Intrinsics.checkNotNullParameter(r10, "throwable");
            HashMap<String, String> r8 = new HashMap();
            r4.b(r8);
            b21.e.a(r8, r5);
            LiveFullLinkPKMonitor r9 = r4.c();
            if (r9 == null) goto L13;
            LiveFullLinkPKMonitor.r(r9, "linkmic/battle/invite", r10, r6, 0, r7, r8, 8);
        L13:
            c21.a r12 = this.e;
            if (r12 == null) goto L16;
            r12.b(this.d);
        L16:
            h41.b.a(r10);
            com.bytedance.android.live.revenue.common.k.c(r10);
            if (d51.c.A0.e() == false) goto L20;
            this.a.B((Map) this.f.element, null, "livesdk_connection_invite");
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.d b;
        public final /* synthetic */ c21.e c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;
        public final /* synthetic */ String f;

        public c(PkAnchorLauncher r1, c21.d r2, c21.e r3, long r4, long r6, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r8;
        }

        public final void accept(Object r10) {
            ExtraResponse r12 = (ExtraResponse) r10;
            com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r13 = this.a.y();
            if (r13 == null) goto L5;
            r13.setPkLauncher(true);
        L5:
            c21.d r14 = this.b;
            if (r14 == null) goto L8;
            r14.a(this.c);
        L8:
            d31.f r15 = PkAnchorLauncher.r(this.a);
            if (r15 == null) goto L11;
            r15.e("linkmic/battle/open/", PkAnchorLauncher.q(this.a, this.c), t.a(this.d));
        L11:
            b21.e r0 = this.a.z();
            if (r0 == null) goto L15;
            long r1 = this.e;
            String r3 = this.f;
            c21.e r4 = this.c;
            long r5 = t.a(this.d);
            int r7 = ((Number) this.a.u.invoke()).intValue();
            int r16 = b21.e.b;
            r0.f(r1, r3, r4, r5, r7, null);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.d b;
        public final /* synthetic */ c21.e c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;
        public final /* synthetic */ String f;

        public d(PkAnchorLauncher r1, c21.d r2, c21.e r3, long r4, long r6, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r8;
        }

        public final void accept(Object r10) {
            Throwable r12 = (Throwable) r10;
            c21.d r0 = this.b;
            if (r0 == null) goto L5;
            r0.b(this.c, r12);
        L5:
            d31.f r1 = PkAnchorLauncher.r(this.a);
            if (r1 == null) goto L8;
            r1.c("linkmic/battle/open/", PkAnchorLauncher.q(this.a, this.c), r12, t.a(this.d));
        L8:
            h41.b.a(r12);
            b21.e r2 = this.a.z();
            if (r2 == null) goto L11;
            r2.f(this.e, this.f, this.c, t.a(this.d), ((Number) this.a.u.invoke()).intValue(), r12);
        L11:
            com.bytedance.android.live.revenue.common.k.c(r12);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public e(PkAnchorLauncher r1, String r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r8) {
            ExtraResponse r9 = (ExtraResponse) r8;
            b21.e r0 = this.a.z();
            if (r0 == null) goto L5;
            String r1 = this.b;
            int r2 = this.c;
            int r4 = ((Number) this.a.u.invoke()).intValue();
            long r5 = t.a(this.d);
            int r10 = b21.e.b;
            r0.h(r1, r2, null, r4, r5);
        L5:
            this.a.h.setValue(c21.c.C0008c.a);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public f(PkAnchorLauncher r1, String r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            b21.e r0 = this.a.z();
            if (r0 == null) goto L5;
            r0.h(this.b, this.c, r9, ((Number) this.a.u.invoke()).intValue(), t.a(this.d));
        L5:
            com.bytedance.android.live.revenue.common.k.c(r9);
            this.a.h.setValue(c21.c.C0008c.a);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.i b;
        public final /* synthetic */ long c;
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b d;

        public g(PkAnchorLauncher r1, c21.i r2, long r3, com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r12) {
            ExtraResponse r13 = (ExtraResponse) r12;
            b21.b r14 = this.a.w();
            if (r14 == null) goto L7;
            c21.i r0 = this.b;
            long r5 = t.a(this.c);
            int r8 = ((Number) this.a.u.invoke()).intValue();
            Intrinsics.checkNotNullParameter(r0, "bizEndParams");
            HashMap r9 = new HashMap();
            b21.b.a(r9, r0);
            LiveFullLinkPKMonitor r3 = r14.d();
            if (r3 == null) goto L7;
            LiveFullLinkPKMonitor.s(r3, "linkmic/biz/end", r5, 0, r8, r9, 4);
        L7:
            this.a.e = false;
            q7 r15 = new q7();
            r15.a = 1;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r1 = this.d;
            if (r1 == null) goto L11;
            r1.a(r15);
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.i b;
        public final /* synthetic */ long c;
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b d;

        public h(PkAnchorLauncher r1, c21.i r2, long r3, com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r10) {
            ApiServerException r12 = (Throwable) r10;
            if ((r12 instanceof ApiServerException) == false) goto L16;
            ApiServerException r0 = r12;
            String r2 = r0.getErrorMsg();
            if (r2 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L16;
            String r1 = r0.getErrorMsg();
            if (r1 != null) goto L15;
            r1 = "";
        L15:
            com.bytedance.android.live.revenue.common.k.d(r12, r1);
        L17:
            PkAnchorLauncher r4 = this.a;
            r4.e = false;
            b21.b r5 = r4.w();
            if (r5 == null) goto L22;
            c21.i r6 = this.b;
            long r7 = t.a(this.c);
            int r8 = ((Number) this.a.u.invoke()).intValue();
            Intrinsics.checkNotNullParameter(r6, "bizEndParams");
            Intrinsics.checkNotNullParameter(r12, "throwable");
            HashMap r9 = new HashMap();
            b21.b.a(r9, r6);
            LiveFullLinkPKMonitor r13 = r5.d();
            if (r13 == null) goto L22;
            LiveFullLinkPKMonitor.r(r13, "linkmic/biz/end", r12, r7, 0, r8, r9, 8);
        L22:
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r14 = this.d;
            if (r14 == null) goto L26;
            r14.onFailed(r12);
            return;
        L26:
            return;
        L7:
            if (r2.length() == 0) goto L10;
            r3 = false;
        L16:
            com.bytedance.android.live.revenue.common.k.c(r12);
            goto L17
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.j b;
        public final /* synthetic */ long c;
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b d;

        public i(PkAnchorLauncher r1, c21.j r2, long r3, com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r12) {
            ExtraResponse r13 = (ExtraResponse) r12;
            b21.b r14 = this.a.w();
            if (r14 == null) goto L7;
            c21.j r0 = this.b;
            long r5 = t.a(this.c);
            int r8 = ((Number) this.a.u.invoke()).intValue();
            Intrinsics.checkNotNullParameter(r0, "bizInviteParams");
            HashMap r9 = new HashMap();
            b21.b.b(r9, r0);
            LiveFullLinkPKMonitor r3 = r14.d();
            if (r3 == null) goto L7;
            LiveFullLinkPKMonitor.s(r3, "linkmic/biz/invite", r5, 0, r8, r9, 4);
        L7:
            PkAnchorLauncher r15 = this.a;
            r15.a = true;
            r15.c = false;
            r15.h.setValue(new c21.c.d(0));
            if (this.d != null) goto L10;
            int r16 = ToastUtil.a;
            int r17 = w11.a.a;
            ToastUtil.a(2131917673, 0);
        L10:
            q7 r18 = new q7();
            r18.a = 1;
            JSONObject r1 = new JSONObject();
            int r2 = w11.a.a;
            r1.put("toast", 2131917673);
            Unit r4 = Unit.INSTANCE;
            r18.b = r1;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r6 = this.d;
            if (r6 == null) goto L14;
            r6.a(r18);
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ c21.j c;
        public final /* synthetic */ long d;
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b e;

        public j(PkAnchorLauncher r1, Ref.ObjectRef r2, c21.j r3, long r4, com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r10) {
            ApiServerException r12 = (Throwable) r10;
            PkAnchorLauncher r0 = this.a;
            boolean r1 = false;
            r0.c = false;
            r0.h.setValue(c21.c.C0008c.a);
            if ((r12 instanceof ApiServerException) == false) goto L20;
            ApiServerException r2 = r12;
            String r3 = r2.getErrorMsg();
            if (r3 != null) goto L7;
        L8:
            r1 = true;
        L9:
            if (r1 == true) goto L20;
            String r4 = r2.getErrorMsg();
            String r5 = "";
            if (r4 != null) goto L13;
            r4 = "";
        L13:
            com.bytedance.android.live.revenue.common.k.d(r12, r4);
            Map r6 = (Map) this.b.element;
            if (r6 == null) goto L21;
            String r7 = r12.getErrorMsg();
            if (r7 == null) goto L19;
            r5 = r7;
        L19:
            String r8 = (String) r6.put("reason", r5);
        L21:
            b21.b r9 = this.a.w();
            if (r9 == null) goto L26;
            c21.j r13 = this.c;
            long r14 = t.a(this.d);
            int r15 = ((Number) this.a.u.invoke()).intValue();
            Intrinsics.checkNotNullParameter(r13, "bizInviteParams");
            Intrinsics.checkNotNullParameter(r12, "throwable");
            HashMap r16 = new HashMap();
            b21.b.b(r16, r13);
            LiveFullLinkPKMonitor r17 = r9.d();
            if (r17 == null) goto L26;
            LiveFullLinkPKMonitor.r(r17, "linkmic/biz/invite", r12, r14, 0, r15, r16, 8);
        L26:
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r18 = this.e;
            if (r18 == null) goto L29;
            r18.onFailed(r12);
        L29:
            this.a.B((Map) this.b.element, null, "livesdk_connection_invite_fail");
            return;
        L7:
            if (r3.length() != 0) goto L9;
        L20:
            com.bytedance.android.live.revenue.common.k.c(r12);
            goto L21
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.k b;
        public final /* synthetic */ long c;

        public k(PkAnchorLauncher r1, c21.k r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r12) {
            ExtraResponse r13 = (ExtraResponse) r12;
            b21.b r14 = this.a.w();
            if (r14 == null) goto L7;
            c21.k r0 = this.b;
            long r5 = t.a(this.c);
            int r8 = ((Number) this.a.u.invoke()).intValue();
            Intrinsics.checkNotNullParameter(r0, "bizStartParams");
            HashMap r9 = new HashMap();
            b21.b.c(r9, r0);
            LiveFullLinkPKMonitor r3 = r14.d();
            if (r3 == null) goto L7;
            LiveFullLinkPKMonitor.s(r3, "linkmic/biz/start", r5, 0, r8, r9, 4);
        L7:
            this.a.d = false;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;
        public final /* synthetic */ c21.k b;
        public final /* synthetic */ long c;

        public l(PkAnchorLauncher r1, c21.k r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r10) {
            ApiServerException r2 = (Throwable) r10;
            if ((r2 instanceof ApiServerException) == false) goto L16;
            ApiServerException r12 = r2;
            String r1 = r12.getErrorMsg();
            if (r1 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L16;
            String r13 = r12.getErrorMsg();
            if (r13 != null) goto L15;
            r13 = "";
        L15:
            com.bytedance.android.live.revenue.common.k.d(r2, r13);
        L17:
            PkAnchorLauncher r14 = this.a;
            r14.d = false;
            b21.b r15 = r14.w();
            if (r15 == null) goto L23;
            c21.k r0 = this.b;
            long r4 = t.a(this.c);
            int r6 = ((Number) this.a.u.invoke()).intValue();
            Intrinsics.checkNotNullParameter(r0, "bizStartParams");
            Intrinsics.checkNotNullParameter(r2, "throwable");
            HashMap r7 = new HashMap();
            b21.b.c(r7, r0);
            LiveFullLinkPKMonitor r5 = r15.d();
            if (r5 == null) goto L24;
            LiveFullLinkPKMonitor.r(r5, "linkmic/biz/start", r2, r4, 0, r6, r7, 8);
            return;
        L24:
            return;
        L23:
            return;
        L7:
            if (r1.length() == 0) goto L10;
            r3 = false;
        L16:
            com.bytedance.android.live.revenue.common.k.c(r2);
            goto L17
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ PkAnchorLauncher a;

        public n(PkAnchorLauncher r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.c = false;
        }
    }

    public static final class o<T> implements Consumer {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final boolean A() {
        if (((Number) this.u.invoke()).intValue() == 1) goto L19;
        com.bytedance.android.live.revlink.impl.global.c r0 = this.z;
        if (r0 == null) goto L8;
        i11.b r1 = r0.c8();
    L9:
        if (r1 == null) goto L13;
        List<p> r2 = r1.getOnlineUserList();
        if (r2 == null) goto L13;
        int r3 = r2.size();
    L15:
        if (r3 < 3) goto L18;
        return true;
    L18:
        return false;
    L13:
        r3 = 0;
        goto L15
    L8:
        r1 = null;
        goto L9
    L19:
        return false;
    }

    public final void C() {
        Disposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        com.bytedance.revenue.platform.api.core.rx.l r1 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r2 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.f = Observable.timer(5000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this), o.a);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void n() {
        this.j.setValue(null);
        this.l.setValue(null);
        this.n.setValue(null);
        this.p.setValue(null);
        this.r.setValue(null);
    }

    public final void u() {
        yz0.f r0 = this.A;
        if (r0 == null) goto L6;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_BATTLE_INVITE");
        Observable r3 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.j.getValue(), false, 6);
        final PkAnchorLauncher$attach$1$1 r5 = new PkAnchorLauncher$attach$1$1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new m(r5)), this.b);
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_BATTLE_REJECT");
        Observable r4 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.k.getValue(), false, 6);
        final PkAnchorLauncher$attach$1$2 r6 = new PkAnchorLauncher$attach$1$2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r4.subscribe(new m(r6)), this.b);
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_BIZ_INVITE_MESSAGE");
        Observable r7 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.C.getValue(), false, 6);
        final PkAnchorLauncher$attach$1$3 r8 = new PkAnchorLauncher$attach$1$3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r7.subscribe(new m(r8)), this.b);
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_BIZ_REPLY_MESSAGE");
        Observable r9 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.D.getValue(), false, 6);
        final PkAnchorLauncher$attach$1$4 r10 = new PkAnchorLauncher$attach$1$4(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r9.subscribe(new m(r10)), this.b);
        return;
    }

    public final com.bytedance.android.live.revenuelink.connect.g v() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnchorConnectUtils();
    }

    public final b21.b w() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.v2();
    }

    public final r31.a x() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkNetwork();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b y() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Q1();
    }

    public final b21.e z() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Gm();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final MutableLiveData e() {
        return this.q;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final MutableLiveData f() {
        return this.k;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final MutableLiveData g() {
        return this.i;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final MutableLiveData h() {
        return this.s;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final MutableLiveData j() {
        return this.m;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final MutableLiveData l() {
        return this.o;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final boolean p() {
        return this.a;
    }

    public static final d31.f r(PkAnchorLauncher r0) {
        com.bytedance.android.live.revlink.impl.global.c r1 = r0.z;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.y2();
    }

    public static final void t(PkAnchorLauncher r4) {
        Disposable r0 = r4.g;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        k51.a r1 = k51.a.h;
        r1.getClass();
        long r2 = ((r11.c) k51.a.f.getValue(r1, k51.a.a[4])).b6() * ((long) WebcastRedirectException.UNKNOWN);
        com.bytedance.revenue.platform.api.core.rx.l r3 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r5 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Scheduler r6 = Schedulers.computation();
        r4.g = Observable.timer(r2, TimeUnit.MILLISECONDS, r6).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.h(r4), com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.i.a);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void c(c21.g r15) {
        Intrinsics.checkNotNullParameter(r15, "battleReplyParams");
        int r0 = r15.a;
        String r12 = r15.b;
        int r8 = r15.c;
        int r9 = r15.d;
        jy0.b.d("ttlive_anchor_pk_launcher", "replyBattle " + r12 + " status=" + r0);
        i97.a r16 = i97.a.a;
        long r13 = System.currentTimeMillis();
        r31.a r1 = x();
        if (r1 == null) goto L18;
        com.bytedance.android.live.revenuelink.connect.g r17 = v();
        if (r17 == null) goto L7;
        long r2 = r17.getChannelId();
    L8:
        Observable<ExtraResponse<Object, Extra>> r18 = r1.k(r2, this.w.getPkId(), r12, r0, r8, r9, ((Number) this.u.invoke()).intValue());
        if (r18 == null) goto L19;
        int r3 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r19 = r18.subscribeOn(Schedulers.io());
        if (r19 == null) goto L20;
        Observable r110 = r19.observeOn(AndroidSchedulers.mainThread());
        if (r110 == null) goto L21;
        Disposable r111 = r110.subscribe(new e(this, r12, r0, r13), new f(this, r12, r0, r13));
        if (r111 == null) goto L22;
        this.b.add(r111);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void k(c21.k r15) {
        Intrinsics.checkNotNullParameter(r15, "bizStartParams");
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        com.bytedance.android.live.revenuelink.connect.g r0 = v();
        long r1 = 0;
        if (r0 == null) goto L8;
        long r10 = r0.getChannelId();
    L9:
        int r6 = r15.a.b.ordinal();
        String r7 = r15.a.c;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.z;
        Long r3 = null;
        if (r2 == null) goto L12;
        s r4 = r2.getRevLinkCommonUtil();
    L13:
        if (r4 == null) goto L15;
        r3 = Long.valueOf(r4.d());
    L15:
        i97.a r5 = i97.a.a;
        long r12 = System.currentTimeMillis();
        r31.a r8 = x();
        if (r8 == null) goto L29;
        if (r3 == null) goto L19;
        r1 = r3.longValue();
    L19:
        Observable<ExtraResponse<Object, Extra>> r9 = r8.Q(r6, r7, r1, r10);
        if (r9 == null) goto L30;
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r14 = r9.subscribeOn(Schedulers.io());
        if (r14 == null) goto L31;
        Observable r16 = r14.observeOn(AndroidSchedulers.mainThread());
        if (r16 == null) goto L32;
        Disposable r17 = r16.subscribe(new k(this, r15, r12), new l(this, r15, r12));
        if (r17 == null) goto L33;
        this.b.add(r17);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L12:
        r4 = null;
        goto L13
    L8:
        r10 = 0;
        goto L9
    }

    public static final d31.a q(PkAnchorLauncher r13, c21.e r14) {
        r13.getClass();
        String r8 = r14.c;
        PlayMode r0 = r14.a.c;
        if (r0 == null) goto L5;
        int r7 = r0.toNetFormat();
    L7:
        return new d31.a(0, 0, 0, 0, null, 0, r7, r8, null, "duration=" + r14.a.a, null, 2879);
    L5:
        r7 = 0;
        goto L7
    }

    public static final void s(PkAnchorLauncher r19, yh6.c r20) {
        r19.getClass();
        c21.c.a r6 = null;
        if ((r20 instanceof p0) == false) goto L23;
        ILinkMicBattleInviteMessage r1 = ((vh7.c) r20).castTo(ILinkMicBattleInviteMessage.class);
        b21.e r2 = r19.z();
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter(r1, "message");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("msg_id", String.valueOf(qj.a(r1)));
        r8.put("channel_id", Long.valueOf(r1.getChannelId()));
        r8.put("pk_id", Long.valueOf(r1.getBattleId()));
        b21.e.i(r2, "receive_battle_invite_msg", r8);
    L7:
        long r3 = r1.getChannelId();
        com.bytedance.android.live.revenuelink.connect.g r4 = r19.v();
        if (r4 != null) goto L10;
        return;
    L10:
        if (r3 != r4.getChannelId()) goto L136;
        Disposable r5 = r19.g;
        if (r5 == null) goto L15;
        r5.dispose();
    L15:
        r19.a = false;
        MutableLiveData<c21.c> r7 = r19.h;
        com.bytedance.android.live.revlink.impl.global.c r9 = r19.z;
        if (r9 == null) goto L18;
        d21.d r10 = r9.getMergePkHelper();
    L19:
        if (r10 == null) goto L21;
        r6 = new c21.c.a(d21.d.a(r10, r1.getBattleConfigSetting(), r1.getMultiPkMode(), ((Number) r19.u.invoke()).intValue()));
    L21:
        r7.setValue(r6);
        r19.j.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.C0127a(r1));
        return;
    L18:
        r10 = null;
        goto L19
    L136:
        return;
    L23:
        if ((r20 instanceof t0) == false) goto L40;
        e5 r12 = ((vh7.c) r20).castTo(e5.class);
        b21.e r13 = r19.z();
        if (r13 == null) goto L27;
        Intrinsics.checkNotNullParameter(r12, "message");
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("msg_id", String.valueOf(qj.a(r12)));
        r14.put("channel_id", Long.valueOf(r12.getChannelId()));
        r14.put("pk_id", Long.valueOf(r12.getBattleId()));
        b21.e.i(r13, "receive_battle_reject_msg", r14);
    L27:
        long r15 = r12.getChannelId();
        com.bytedance.android.live.revenuelink.connect.g r16 = r19.v();
        if (r16 != null) goto L30;
        return;
    L30:
        if (r15 == r16.getChannelId()) goto L32;
        return;
    L32:
        if (((Number) r19.u.invoke()).intValue() == 1) goto L34;
    L36:
        r19.a = false;
        Disposable r17 = r19.g;
        if (r17 == null) goto L39;
        r17.dispose();
    L39:
        r19.h.setValue(c21.c.C0008c.a);
        r19.l.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.c(r12));
        return;
    L34:
        if ((r19.i.getValue() instanceof c21.c.d) == true) goto L36;
        return;
    L40:
        String r18 = "";
        if ((r20 instanceof w0) == false) goto L68;
        ILinkMicBizInviteMessage r22 = ((vh7.c) r20).castTo(ILinkMicBizInviteMessage.class);
        r19.n.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.d(r22));
        r19.a = false;
        MutableLiveData<c21.c> r23 = r19.h;
        h5 r110 = r22.getLinkMicBizExtra();
        if (r110 == null) goto L48;
        j7 r111 = r110.getOpenGameConfig();
        if (r111 == null) goto L48;
        String r112 = r111.getGameAppId();
        if (r112 == null) goto L48;
    L49:
        r23.setValue(new c21.c.a(new c21.f.c(r112)));
        b21.b r0 = r19.w();
        if (r0 == null) goto L133;
        Intrinsics.checkNotNullParameter(r22, "message");
        LinkedHashMap r24 = new LinkedHashMap();
        r24.put("msg_id", String.valueOf(qj.a(r22)));
        r24.put("invite_type", Integer.valueOf(r22.getInviteType()));
        h5 r25 = r22.getLinkMicBizExtra();
        if (r25 == null) goto L58;
        j7 r26 = r25.getOpenGameConfig();
        if (r26 == null) goto L58;
        String r27 = r26.getGameAppId();
        if (r27 == null) goto L58;
    L59:
        r24.put("game_app_id", r27);
        h5 r28 = r22.getLinkMicBizExtra();
        if (r28 == null) goto L66;
        j7 r29 = r28.getOpenGameConfig();
        if (r29 == null) goto L66;
        String r30 = r29.getGameTitle();
        if (r30 == null) goto L66;
        r18 = r30;
    L66:
        r24.put("game_title", r18);
        b21.b.e(r0, "receive_biz_invite_msg", r24);
        return;
    L58:
        r27 = "";
        goto L59
    L133:
        return;
    L48:
        r112 = "";
        goto L49
    L68:
        if ((r20 instanceof x0) == false) goto L135;
        ILinkMicBizReplyMessage r32 = ((vh7.c) r20).castTo(ILinkMicBizReplyMessage.class);
        r19.p.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.e(r32));
        r19.h.setValue(c21.c.C0008c.a);
        b21.b r33 = r19.w();
        if (r33 == null) goto L89;
        Intrinsics.checkNotNullParameter(r32, "message");
        LinkedHashMap r34 = new LinkedHashMap();
        r34.put("msg_id", String.valueOf(qj.a(r32)));
        r34.put("invite_type", Integer.valueOf(r32.getInviteType()));
        r34.put("rep_code", String.valueOf(r32.getRepCode()));
        h5 r35 = r32.getLinkMicBizExtra();
        if (r35 == null) goto L78;
        j7 r36 = r35.getOpenGameConfig();
        if (r36 == null) goto L78;
        String r37 = r36.getGameAppId();
        if (r37 == null) goto L78;
    L79:
        r34.put("game_app_id", r37);
        h5 r38 = r32.getLinkMicBizExtra();
        if (r38 == null) goto L86;
        j7 r39 = r38.getOpenGameConfig();
        if (r39 == null) goto L86;
        String r40 = r39.getGameTitle();
        if (r40 == null) goto L86;
    L87:
        r34.put("game_title", r40);
        b21.b.e(r33, "receive_biz_reply_msg", r34);
    L86:
        r40 = "";
    L78:
        r37 = "";
    L89:
        if (d51.c.A0.e() == false) goto L91;
        Map r42 = r19.t.u(7, null, 0, 0, null);
    L92:
        if (r42 == null) goto L101;
        Integer r43 = r32.getRepCode();
        int r44 = ReplyType.Accept.ordinal();
        if (r43 != null) goto L97;
    L99:
        String r45 = "reject";
    L100:
        String r46 = r42.put("result", r45);
        goto L101
    L97:
        if (r43.intValue() != r44) goto L99;
        r45 = "accept";
    L101:
        if (r42 != null) goto L103;
    L107:
        if (r42 == null) goto L116;
        com.bytedance.android.live.revlink.impl.global.c r47 = r19.z;
        if (r47 == null) goto L111;
        d31.e r48 = r47.q4();
    L112:
        if (r48 == null) goto L114;
        String r49 = r48.a();
    L115:
        String r50 = r42.put("source", r49);
        goto L116
    L114:
        r49 = "";
        goto L115
    L111:
        r48 = null;
    L116:
        if (r42 == null) goto L126;
        h5 r52 = r32.getLinkMicBizExtra();
        if (r52 == null) goto L125;
        j7 r53 = r52.getOpenGameConfig();
        if (r53 == null) goto L125;
        String r54 = r53.getGameAppId();
        if (r54 == null) goto L125;
        r18 = r54;
    L125:
        String r55 = r42.put("open_game_app_id", r18);
    L126:
        r19.B(r42, null, "livesdk_connection_invite_result");
        return;
    L103:
        if (r32.getInviteType() != ILinkMicBizInviteMessage.BizInviteType.BizInviteReStart.ordinal()) goto L105;
        String r56 = DataType.TRUE;
    L106:
        String r57 = r42.put("is_oncemore", r56);
        goto L107
    L105:
        r56 = DataType.FALSE;
        goto L106
    L91:
        r42 = null;
        goto L92
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void b(c21.b r28, c21.a r29) {
        Intrinsics.checkNotNullParameter(r28, "battleInviteParams");
        if (this.c == false) goto L5;
    L99:
        int r0 = ToastUtil.a;
        int r1 = w11.a.a;
        ToastUtil.a(2131918086, 0);
        return;
    L5:
        if ((this.i.getValue() instanceof c21.c.d) == true) goto L99;
        i97.a r2 = i97.a.a;
        long r10 = System.currentTimeMillis();
        c21.l r12 = r28.a;
        com.bytedance.android.live.revenuelink.connect.g r3 = v();
        if (r3 == null) goto L10;
        long r4 = r3.getChannelId();
    L11:
        long r14 = r4;
        if ((this.v.getValue() instanceof PkBaseStateMachine.c.a) == false) goto L14;
    L17:
        boolean r16 = true;
    L18:
        int r17 = r12.a.getType();
        long r18 = this.w.getPkId();
        long r5 = r12.b;
        c21.f r6 = r28.b;
        if ((r6 instanceof c21.f.m) == false) goto L22;
        IBattleConfigSetting r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.Vote.getType());
        r7.setVoteData(((c21.f.m) r28.b).b);
    L48:
        IBattleConfigSetting r8 = r7;
    L50:
        String r9 = GsonProtectorUtils.toJson(l97.a.a, r8);
        if (r9 != null) goto L53;
        String r13 = null;
    L54:
        jy0.b.f("ttlive_anchor_pk_launcher", "request battleInvite " + r28 + ' ' + r13, null, 4);
        com.bytedance.android.live.revlink.impl.global.c r15 = this.z;
        if (r15 == null) goto L57;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r19 = r15.getLinkOptLogContext();
    L58:
        if (r19 == null) goto L60;
        r19.b(null);
    L60:
        this.c = true;
        C();
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = null;
        if (d51.c.A0.e() == true) goto L63;
        r5 = r5;
        r10 = r10;
        r14 = r14;
        r20 = r20;
        r13 = r13;
        if (((Number) this.u.invoke()).intValue() != 7) goto L82;
        com.bytedance.android.live.revlink.impl.global.c r22 = this.z;
        if (r22 == null) goto L79;
        b21.a r23 = r22.Rj();
    L80:
        if (r23 == null) goto L83;
        Intrinsics.checkNotNullParameter(r28, "battleInviteParams");
        r23.b(r23.a(r28), "livesdk_connection_invite");
    L83:
        r31.a r110 = x();
        if (r110 == null) goto L101;
        int r24 = r12.c;
        v3 r25 = r12.f;
        if (r25 == null) goto L88;
        String r26 = w3.a(r25);
    L89:
        Observable r27 = r110.u(r14, r16, r17, r18, r5, r13, r24, r26);
        if (r27 == null) goto L102;
        int r30 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r32 = r27.subscribeOn(Schedulers.io());
        if (r32 == null) goto L103;
        Observable r111 = r32.observeOn(AndroidSchedulers.mainThread());
        if (r111 == null) goto L104;
        Ref.ObjectRef r33 = r20;
        Disposable r34 = r111.subscribe(new a(this, r28, r12, r10, r29, r33), new b(this, r12, r10, r28, r29, r33));
        if (r34 == null) goto L105;
        this.b.add(r34);
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L88:
        r26 = null;
        goto L89
    L101:
        return;
    L79:
        r23 = null;
        goto L80
    L82:
        h41.e r112 = this.t;
        int r35 = r12.a.getType();
        long r36 = r12.b;
        long r37 = r12.e;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r28, "battleInviteParams");
        Intrinsics.checkNotNullParameter("livesdk_connection_invite", "eventName");
        r112.v(r112.u(r35, r8, r36, r37, r28), "livesdk_connection_invite");
        goto L83
    L63:
        if (((Number) this.u.invoke()).intValue() != 7) goto L72;
        com.bytedance.android.live.revlink.impl.global.c r38 = this.z;
        if (r38 == null) goto L67;
        b21.a r39 = r38.Rj();
    L68:
        if (r39 == null) goto L70;
        Map<String, String> r40 = r39.a(r28);
    L73:
        r20.element = r40;
        goto L83
    L70:
        r40 = null;
        goto L73
    L67:
        r39 = null;
        goto L68
    L72:
        r5 = r5;
        r10 = r10;
        r40 = this.t.u(r12.a.getType(), r8, r12.b, r12.e, r28);
        goto L73
    L57:
        r19 = null;
        goto L58
    L53:
        r13 = r9;
        goto L54
    L22:
        if ((r6 instanceof c21.f.d) == false) goto L25;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.Default.getType());
        r7.setSelfData(((c21.f.d) r28.b).b);
        goto L48
    L25:
        if ((r6 instanceof c21.f.k) == false) goto L28;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.Default.getType());
        r7.setShellConfig(((c21.f.k) r28.b).b);
        goto L48
    L28:
        if ((r6 instanceof c21.f.e) == false) goto L31;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.Default.getType());
        r7.setActivityId(((c21.f.e) r28.b).b);
        goto L48
    L31:
        if ((r6 instanceof c21.f.a) == false) goto L34;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.BreakThrough.getType());
        goto L48
    L34:
        if ((r6 instanceof c21.f.l) == false) goto L37;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setSpecifyGiftConfig(((c21.f.l) r28.b).b);
        goto L48
    L37:
        if ((r6 instanceof c21.f.i) == false) goto L40;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.RobC.getType());
        goto L48
    L40:
        if ((r6 instanceof c21.f.b) == false) goto L43;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.CloudCollaborate.getType());
        r7.setCloudCollaborateConfig(((c21.f.b) r28.b).b);
        goto L48
    L43:
        if ((r6 instanceof c21.f.g) == false) goto L46;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.Custom.getType());
        r7.setCustomConfig(((c21.f.g) r28.b).b);
        goto L48
    L46:
        if ((r6 instanceof c21.f.j) == false) goto L49;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.SeasonRank.getType());
        goto L48
    L49:
        r8 = null;
        goto L50
    L14:
        if ((this.v.getValue() instanceof PkBaseStateMachine.c.b) == true) goto L17;
        r16 = false;
        goto L18
    L10:
        r4 = 0;
        goto L11
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void d(long r26, aa r28) {
        Intrinsics.checkNotNullParameter(r28, "voteSetting");
        com.bytedance.android.live.revlink.impl.multianchor.service.a r3 = null;
        if (((Number) this.u.invoke()).intValue() != 1) goto L16;
        com.bytedance.android.live.revlink.impl.global.c r1 = this.z;
        if (r1 == null) goto L7;
        q r2 = r1.getPkUtils();
    L8:
        if (r2 == null) goto L76;
        com.bytedance.android.live.revlink.impl.global.c r4 = r2.c;
        if (r4 == null) goto L12;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b r5 = r4.L1();
    L13:
        if (r5 == null) goto L77;
        r5.startVoteBattleInvite(r26, r28, false, 0, com.bytedance.android.live.revlink.impl.pk.utils.l.f.c);
        return;
    L77:
        return;
    L12:
        r5 = null;
        goto L13
    L76:
        return;
    L7:
        r2 = null;
        goto L8
    L16:
        if (((Number) this.u.invoke()).intValue() != 7) goto L25;
        if (A() == true) goto L25;
        com.bytedance.android.live.revlink.impl.global.c r6 = this.z;
        if (r6 == null) goto L22;
        r3 = r6.u5();
    L22:
        if (r3 == null) goto L79;
        PkDoubleAnchorDataContext.d r7 = new PkDoubleAnchorDataContext.d(r26, r28, 4);
        int r8 = ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Unknown.ordinal();
        IBattleConfigSetting r9 = vh7.f.c(IBattleConfigSetting.class);
        r9.setVoteData(r28);
        Unit r10 = Unit.INSTANCE;
        r3.na(new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g(r7, r8, null, false, r9, 122855));
        return;
    L79:
        return;
    L25:
        if (((Number) this.u.invoke()).intValue() == 7) goto L27;
        return;
    L27:
        if (A() == false) goto L82;
        k51.a r12 = k51.a.h;
        r12.getClass();
        if (((Boolean) k51.a.e.getValue(r12, k51.a.a[3])).booleanValue() == false) goto L83;
        boolean r13 = this.w.isBattleShow();
        boolean r14 = this.w.isInVote();
        com.bytedance.android.live.revlink.impl.global.c r15 = this.z;
        if (r15 == null) goto L33;
        MultiPKLauncher r16 = r15.Be();
    L34:
        if (r16 == null) goto L84;
        if (r13 == false) goto L46;
        if (r14 == false) goto L46;
        int r17 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        com.bytedance.android.live.revlink.impl.pk.utils.l.c r19 = com.bytedance.android.live.revlink.impl.pk.utils.l.c.c;
        IBaseBattleSetting r18 = this.w.getBattleSettings();
        if (r18 == null) goto L89;
        long r20 = r18.getBattleId();
        long r110 = r18.getDuration();
        IBattleConfigSetting r22 = r18.getBattleConfigSetting();
        if (r22 == null) goto L85;
        aa r23 = r22.getVoteData();
        if (r23 == null) goto L90;
        r16.invitePk(new h31.f(PkBaseDataContext.PKModType.Vote, r110, null, new h31.e(r20, 3, true, true, 1), new h31.i(r23), null, null, null, h31.h.C0248h.b, 0, r19, null, 4480), null);
        return;
    L90:
        return;
    L85:
        return;
    L89:
        return;
    L46:
        if (r13 == false) goto L51;
        int r24 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        com.bytedance.android.live.revlink.impl.pk.utils.l.c r111 = com.bytedance.android.live.revlink.impl.pk.utils.l.c.c;
        IBaseBattleSetting r25 = this.w.getBattleSettings();
        if (r25 == null) goto L91;
        r16.invitePk(new h31.f(PkBaseDataContext.PKModType.Vote, r26, null, new h31.e(r25.getBattleId(), 3, true, false, 1), new h31.i(r28), null, null, null, h31.h.C0248h.b, 0, r111, null, 4480), null);
        return;
    L91:
        return;
    L51:
        int r27 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        com.bytedance.android.live.revlink.impl.pk.utils.l.c r112 = com.bytedance.android.live.revlink.impl.pk.utils.l.c.c;
        com.bytedance.android.live.revlink.impl.global.c r29 = this.z;
        if (r29 == null) goto L54;
        i11.b r30 = r29.c8();
    L55:
        if (r30 == null) goto L88;
        List<p> r32 = r30.getOnlineUserList();
        if (r32 == null) goto L92;
        PkBaseDataContext.PKModType r33 = PkBaseDataContext.PKModType.Vote;
        PlayMode r34 = PlayMode.PERSONAL_PK;
        int r113 = r32.size();
        ArrayList r114 = new ArrayList();
        Iterator<p> r35 = r32.iterator();
    L61:
        if (r35.hasNext() == false) goto L67;
        IBaseUser r115 = r35.next().getUser();
        if (r115 == null) goto L61;
        String r116 = iz.a.a(r115);
        if (r116 == null) goto L61;
        r114.add(r116);
        goto L61
    L67:
        r16.openPk(new h31.f(r33, r26, new h31.d(r34, r113, r114), null, new h31.i(r28), null, null, null, h31.h.C0248h.b, 0, r112, null, 4480), null);
        return;
    L92:
        return;
    L88:
        return;
    L54:
        r30 = null;
        goto L55
    L84:
        return;
    L33:
        r16 = null;
        goto L34
    L83:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void i(c21.i r18, com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r19) {
        Intrinsics.checkNotNullParameter(r18, "bizEndParams");
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        com.bytedance.android.live.revenuelink.connect.g r0 = v();
        long r1 = 0;
        if (r0 == null) goto L8;
        long r13 = r0.getChannelId();
    L9:
        int r9 = r18.a.b.ordinal();
        String r10 = r18.a.c;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.z;
        Long r3 = null;
        if (r2 == null) goto L12;
        s r4 = r2.getRevLinkCommonUtil();
    L13:
        if (r4 == null) goto L15;
        r3 = Long.valueOf(r4.d());
    L15:
        i97.a r5 = i97.a.a;
        long r15 = System.currentTimeMillis();
        r31.a r8 = x();
        if (r8 == null) goto L29;
        if (r3 == null) goto L19;
        r1 = r3.longValue();
    L19:
        Observable<ExtraResponse<Object, Extra>> r6 = r8.K(r9, r10, r1, r13);
        if (r6 == null) goto L30;
        int r7 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r12 = r6.subscribeOn(Schedulers.io());
        if (r12 == null) goto L31;
        Observable r14 = r12.observeOn(AndroidSchedulers.mainThread());
        if (r14 == null) goto L32;
        Disposable r16 = r14.subscribe(new g(this, r18, r15, r19), new h(this, r18, r15, r19));
        if (r16 == null) goto L33;
        this.b.add(r16);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L12:
        r4 = null;
        goto L13
    L8:
        r13 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void m(o7 r37, com.bytedance.android.live.revlink.impl.jsb.a r38) {
        Intrinsics.checkNotNullParameter(r37, "params");
        Integer r1 = r37.a;
        int r2 = BattleLaunchType.Invite.getType();
        long r10 = 0;
        String r12 = "";
        if (r1 != null) goto L6;
    L62:
        int r3 = BattleLaunchType.Reply.getType();
        if (r1 != null) goto L66;
    L84:
        int r4 = BattleLaunchType.Open.getType();
        if (r1 != null) goto L88;
    L126:
        int r5 = BattleLaunchType.BizInvite.getType();
        if (r1 != null) goto L130;
    L158:
        int r6 = BattleLaunchType.BizEnd.getType();
        if (r1 != null) goto L162;
        return;
    L162:
        if (r1.intValue() != r6) goto L197;
        JSONObject r0 = ea.a(r37);     // Catch: Throwable -> L184
        if (r0 == null) goto L198;
        String r7 = r0.optString("battle_config_setting_str");     // Catch: Throwable -> L184
        if (r7 == null) goto L199;
        Object r8 = new JSONObject(r7).get("game_config");     // Catch: Throwable -> L184
        if (r8 == null) goto L173;
        String r9 = r8.toString();     // Catch: Throwable -> L184
        if (r9 == null) goto L173;
    L174:
        Object r13 = new JSONObject(r9).get("game_app_id");     // Catch: Throwable -> L184
        if (r13 == null) goto L177;
        String r14 = r13.toString();     // Catch: Throwable -> L184
    L178:
        LinkmicBizType r15 = LinkmicBizType.LinkmicBizTypeOpenGame;     // Catch: Throwable -> L184
        if (r14 != null) goto L181;
        String r16 = "";
    L182:
        i(new c21.i(new c21.h(0, r15, r16, false, 57)), r38);     // Catch: Throwable -> L184
        return;
    L181:
        r16 = r14;
        goto L182
    L177:
        r14 = null;
    L173:
        r9 = "";
        goto L174
    L199:
        return;
    L198:
        return;
    L184:
        th = move-exception;
        jy0.b.c("bizEndByJsb", th.toString(), null, 4);
        return;
    L197:
        return;
    L130:
        if (r1.intValue() != r5) goto L158;
        JSONObject r17 = ea.a(r37);     // Catch: Throwable -> L156
        if (r17 == null) goto L194;
        String r18 = r17.optString("battle_config_setting_str");     // Catch: Throwable -> L156
        if (r18 == null) goto L195;
        JSONObject r19 = new JSONObject(r18);     // Catch: Throwable -> L156
        Object r20 = r19.get("game_config");     // Catch: Throwable -> L156
        if (r20 == null) goto L141;
        String r22 = r20.toString();     // Catch: Throwable -> L156
        if (r22 == null) goto L141;
    L142:
        Object r23 = r19.get("limited_by_mix_stream_type");     // Catch: Throwable -> L156
        if (r23 == null) goto L145;
        String r24 = r23.toString();     // Catch: Throwable -> L156
    L146:
        Object r25 = new JSONObject(r22).get("game_app_id");     // Catch: Throwable -> L156
        if (r25 == null) goto L149;
        String r26 = r25.toString();     // Catch: Throwable -> L156
    L150:
        int r27 = ILinkMicBizInviteMessage.BizInviteType.BizInviteStart.ordinal();     // Catch: Throwable -> L156
        LinkmicBizType r28 = LinkmicBizType.LinkmicBizTypeOpenGame;     // Catch: Throwable -> L156
        if (r26 != null) goto L153;
        String r29 = "";
    L154:
        o(new c21.j(new c21.h(r27, r28, r29, Intrinsics.areEqual(r24, DataType.TRUE), 40)), r38);     // Catch: Throwable -> L156
        return;
    L153:
        r29 = r26;
        goto L154
    L149:
        r26 = null;
        goto L150
    L145:
        r24 = null;
    L141:
        r22 = "";
        goto L142
    L195:
        return;
    L194:
        return;
    L156:
        th = move-exception;
        jy0.b.c("bizInviteByJsb", th.toString(), null, 4);
        return;
    L88:
        if (r1.intValue() != r4) goto L126;
        JSONObject r30 = ea.a(r37);
        if (r30 == null) goto L191;
        i97.a r32 = i97.a.a;
        long r110 = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.connect.g r33 = v();
        if (r33 == null) goto L95;
        long r34 = r33.getChannelId();
    L96:
        long r111 = r30.optLong(Constants.Keys.duration);
        int r210 = r30.optInt("invite_type");
        String r211 = r30.optString(FileUtils.PICTURE_THEME);
        String r212 = r30.optString(Constants.OperatorKey.KEY_TOKEN);
        String r35 = r30.optString("battle_config_setting_str");
        String r112 = r30.optString("invitee_ids");
        int r36 = r30.optInt("multi_pk_mode");
        if (r30.has("panel_source") == false) goto L99;
        r12 = r30.optString("panel_source");
    L99:
        com.bytedance.android.live.revlink.impl.global.c r39 = this.z;
        if (r39 == null) goto L102;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r40 = r39.getLinkOptLogContext();
    L103:
        if (r40 == null) goto L105;
        r40.b(r12);
    L105:
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r42 = y();
        if (r42 == null) goto L108;
        r42.setPkLauncher(true);
    L108:
        jy0.b.c("ttlive_anchor_pk_launcher", "battleOpenByJsb inviteeIds = " + r112 + ", battleConfigSettingStr = " + r35 + ", duration = " + r111, null, 4);
        r31.a r213 = x();
        if (r213 == null) goto L191;
        com.bytedance.android.live.revlink.impl.global.c r43 = this.z;
        if (r43 == null) goto L113;
        s r44 = r43.getRevLinkCommonUtil();
    L114:
        if (r44 == null) goto L116;
        Long r214 = Long.valueOf(r44.d());
    L117:
        Observable r45 = r213.e(r34, r111, r211, r210, r212, r35, r214, r112, r36, null);
        if (r45 == null) goto L191;
        int r46 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r47 = r45.subscribeOn(Schedulers.io());
        if (r47 == null) goto L191;
        Observable r113 = r47.observeOn(AndroidSchedulers.mainThread());
        if (r113 == null) goto L191;
        long r48 = r34;
        Disposable r49 = r113.subscribe(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.d(this, r36, r111, r110, r48, r112, r30, r38), new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.e(this, r36, r111, r110, r48, r112, r30, r38));
        if (r49 == null) goto L192;
        this.b.add(r49);
        return;
    L192:
        return;
    L116:
        r214 = null;
        goto L117
    L113:
        r44 = null;
        goto L114
    L102:
        r40 = null;
        goto L103
    L95:
        r34 = 0;
    L191:
        return;
    L66:
        if (r1.intValue() != r3) goto L84;
        JSONObject r50 = ea.a(r37);
        if (r50 == null) goto L191;
        int r114 = r50.optInt("reply_status");
        String r52 = String.valueOf(r50.optLong("invite_uid"));
        int r215 = r50.optInt("invite_type");
        int r216 = r50.optInt("multi_pk_mode");
        jy0.b.d("ttlive_anchor_pk_launcher", "replyBattle " + r52 + " status=" + r114);
        i97.a r53 = i97.a.a;
        long r54 = System.currentTimeMillis();
        r31.a r115 = x();
        if (r115 == null) goto L191;
        com.bytedance.android.live.revenuelink.connect.g r55 = v();
        if (r55 == null) goto L75;
        r10 = r55.getChannelId();
    L75:
        Observable<ExtraResponse<Object, Extra>> r56 = r115.k(r10, this.w.getPkId(), r52, r114, r215, r216, ((Number) this.u.invoke()).intValue());
        if (r56 == null) goto L191;
        int r57 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r58 = r56.subscribeOn(Schedulers.io());
        if (r58 == null) goto L191;
        Observable r59 = r58.observeOn(AndroidSchedulers.mainThread());
        if (r59 == null) goto L191;
        Disposable r60 = r59.subscribe(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.f(this, r52, r114, r54, r38), new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.g(this, r52, r114, r54, r38));
        if (r60 == null) goto L191;
        this.b.add(r60);
        goto L191
    L6:
        if (r1.intValue() != r2) goto L62;
        boolean r62 = false;
        if (this.c == false) goto L10;
    L60:
        int r63 = ToastUtil.a;
        int r64 = w11.a.a;
        ToastUtil.a(2131918086, 0);
        goto L191
    L10:
        if ((this.i.getValue() instanceof c21.c.d) == true) goto L12;
    L14:
        JSONObject r65 = ea.a(r37);
        if (r65 == null) goto L191;
        i97.a r66 = i97.a.a;
        long r116 = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.connect.g r67 = v();
        if (r67 == null) goto L20;
        long r217 = r67.getChannelId();
    L22:
        if ((this.v.getValue() instanceof PkBaseStateMachine.c.a) == false) goto L24;
    L27:
        boolean r218 = true;
    L28:
        int r68 = r65.optInt("invite_type");
        long r219 = this.w.getPkId();
        Long r69 = Long.valueOf(r65.optLong(Constants.Keys.duration, 0));
        if (r69.longValue() <= 0) goto L31;
        r62 = true;
    L31:
        if (r62 == true) goto L34;
        r69 = null;
    L34:
        if (r69 == null) goto L36;
        long r70 = r69.longValue();
    L37:
        long r220 = r70;
        String r310 = r65.optString("battle_config_setting_str");
        int r117 = r65.optInt("multi_pk_mode");
        String r311 = r65.optString("client_attached_info");
        if (r65.has("panel_source") == false) goto L40;
        r12 = r65.optString("panel_source");
    L40:
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r72 = y();
        if (r72 == null) goto L43;
        r72.setPkLauncher(true);
    L43:
        jy0.b.f("ttlive_anchor_pk_launcher", "request battleInvite by jsb " + r65, null, 4);
        com.bytedance.android.live.revlink.impl.global.c r73 = this.z;
        if (r73 == null) goto L46;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r74 = r73.getLinkOptLogContext();
    L47:
        if (r74 == null) goto L49;
        r74.b(r12);
    L49:
        this.c = true;
        C();
        r31.a r221 = x();
        if (r221 == null) goto L191;
        Observable r75 = r221.u(r217, r218, r68, r219, r220, r310, r117, r311);
        if (r75 == null) goto L191;
        int r76 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r77 = r75.subscribeOn(Schedulers.io());
        if (r77 == null) goto L191;
        Observable r118 = r77.observeOn(AndroidSchedulers.mainThread());
        if (r118 == null) goto L191;
        Disposable r78 = r118.subscribe(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.b(this, r68, r117, r116, r65, r38), new com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.c(this, r68, r117, r116, r65, r38));
        if (r78 == null) goto L191;
        this.b.add(r78);
        goto L191
    L46:
        r74 = null;
        goto L47
    L36:
        r70 = l51.a.j();
        goto L37
    L24:
        if ((this.v.getValue() instanceof PkBaseStateMachine.c.b) == true) goto L27;
        r218 = false;
        goto L28
    L20:
        r217 = 0;
        goto L22
    L12:
        if (A() == true) goto L14;
        goto L14
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void o(c21.j r20, com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b r22) {
        Intrinsics.checkNotNullParameter(r20, "bizInviteParams");
        if (this.c == false) goto L5;
    L115:
        int r0 = ToastUtil.a;
        int r1 = w11.a.a;
        ToastUtil.a(2131918086, 0);
        return;
    L5:
        if ((this.i.getValue() instanceof c21.c.d) == true) goto L115;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.z;
        if (r2 == null) goto L10;
        com.bytedance.android.live.revenuelink.rtc.f r3 = r2.m0();
    L11:
        if (r3 == null) goto L15;
        com.bytedance.android.live.revenuelink.rtc.i r4 = r3.getRtcManager();
        if (r4 == null) goto L15;
        Boolean r5 = Boolean.valueOf(r4.F());
    L16:
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = null;
        boolean r6 = d51.c.A0.e();
        String r7 = DataType.FALSE;
        if (r6 == true) goto L19;
    L71:
        Map r9 = (Map) r8.element;
        if (r9 != null) goto L74;
    L77:
        Map r10 = (Map) r8.element;
        if (r10 == null) goto L81;
        String r12 = (String) r10.put("open_game_app_id", r20.a.c);
    L81:
        if ((!Intrinsics.areEqual(r5, Boolean.TRUE)) == true) goto L83;
    L91:
        this.c = true;
        com.bytedance.android.live.revenuelink.connect.g r13 = v();
        long r14 = 0;
        if (r13 == null) goto L94;
        long r15 = r13.getChannelId();
    L95:
        int r16 = r20.a.b.ordinal();
        c21.h r17 = r20.a;
        String r18 = r17.c;
        int r19 = r17.a;
        com.bytedance.android.live.revlink.impl.global.c r23 = this.z;
        if (r23 == null) goto L98;
        w31.c r24 = r23.getPkLinkUtils();
    L99:
        if (r24 == null) goto L103;
        String r25 = r24.c();
        if (r25 == null) goto L103;
        r14 = CastLongProtector.parseLong(r25);
    L103:
        long r110 = r14;
        i97.a r26 = i97.a.a;
        long r111 = System.currentTimeMillis();
        B((Map) r8.element, null, "livesdk_connection_invite");
        r31.a r27 = x();
        if (r27 == null) goto L117;
        Observable<ExtraResponse<Object, Extra>> r28 = r27.l(r15, r16, r18, r19, r110);
        if (r28 == null) goto L118;
        int r29 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r30 = r28.subscribeOn(Schedulers.io());
        if (r30 == null) goto L119;
        Observable r32 = r30.observeOn(AndroidSchedulers.mainThread());
        if (r32 == null) goto L120;
        Disposable r33 = r32.subscribe(new i(this, r20, r111, r22), new j(this, r8, r20, r111, r22));
        if (r33 == null) goto L121;
        this.b.add(r33);
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L98:
        r24 = null;
        goto L99
    L94:
        r15 = 0;
        goto L95
    L83:
        if (r20.a.e == false) goto L91;
        p41.b r34 = p41.b.c;
        r34.getClass();
        if (((p41.a) p41.b.b.getValue(r34, p41.b.a[0])).a() == true) goto L91;
        int r35 = ToastUtil.a;
        int r36 = w11.a.a;
        ToastUtil.a(2131917624, 0);
        Map r37 = (Map) r8.element;
        if (r37 == null) goto L89;
        String r38 = (String) r37.put("reason", "fail_for_device_limited");
    L89:
        B((Map) r8.element, null, "livesdk_connection_invite_fail");
        return;
    L74:
        if (r20.a.a != ILinkMicBizInviteMessage.BizInviteType.BizInviteReStart.ordinal()) goto L76;
        r7 = DataType.TRUE;
    L76:
        String r39 = (String) r9.put("is_oncemore", r7);
        goto L77
    L19:
        if (((Number) this.u.invoke()).intValue() != 7) goto L69;
        com.bytedance.android.live.revlink.impl.global.c r40 = this.z;
        if (r40 == null) goto L23;
        b21.a r42 = r40.Rj();
    L24:
        if (r42 == null) goto L68;
        Intrinsics.checkNotNullParameter(r20, "battleInviteParams");
        r20.getClass();
        Map r43 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r112 = r42.a;
        if (r112 == null) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r113 = r112.Q1();
    L29:
        if (r113 == null) goto L31;
        r43.putAll(r113.getCurrentSceneLogParam());
    L31:
        r43.put("invite_mode", "cohost_game");
        r43.put("is_oncemore", DataType.FALSE);
        r43.put("invite_type", "play");
        r43.put("invitee_room_status", "pk");
        com.bytedance.android.live.revlink.impl.global.c r114 = r42.a;
        if (r114 == null) goto L34;
        w r115 = r114.getMultiLinkUtil();
    L35:
        if (r115 == null) goto L41;
        i11.b r116 = r115.a();
        if (r116 == null) goto L41;
        List<p> r117 = r116.getOnlineUserList();
        if (r117 == null) goto L41;
        Integer r118 = Integer.valueOf(r117.size());
    L42:
        r43.put("invitee_connect_cnt", String.valueOf(r118));
        com.bytedance.android.live.revlink.impl.global.c r119 = r42.a;
        if (r119 == null) goto L45;
        d31.d r120 = r119.getRevLinkLogHelper();
    L46:
        String r121 = "";
        if (r120 == null) goto L50;
        String r122 = r120.a();
        if (r122 == null) goto L50;
    L51:
        r43.put("audience_connect_cnt", r122);
        r43.put("anchor_connection_type", "invite");
        com.bytedance.android.live.revlink.impl.global.c r123 = r42.a;
        if (r123 == null) goto L54;
        d31.d r124 = r123.getRevLinkLogHelper();
    L55:
        if (r124 == null) goto L67;
        com.bytedance.android.live.revlink.impl.global.c r44 = r42.a;
        if (r44 == null) goto L59;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r45 = r44.getMultiAnchorLinkContextObj();
    L60:
        if (r45 == null) goto L62;
        int r46 = r45.b();
    L63:
        String r47 = r124.p(r46);
        if (r47 == null) goto L67;
        r121 = r47;
        goto L67
    L62:
        r46 = 0;
        goto L63
    L59:
        r45 = null;
    L67:
        r43.put("invitee_list", r121);
        r43.put("list_num", DataType.FALSE);
    L70:
        r8.element = r43;
        goto L71
    L54:
        r124 = null;
    L50:
        r122 = "";
        goto L51
    L45:
        r120 = null;
    L41:
        r118 = null;
        goto L42
    L34:
        r115 = null;
        goto L35
    L28:
        r113 = null;
        goto L29
    L68:
        r43 = null;
        goto L70
    L23:
        r42 = null;
        goto L24
    L69:
        r43 = this.t.u(7, null, 0, 0, null);
    L15:
        r5 = null;
        goto L16
    L10:
        r3 = null;
        goto L11
    }

    public final void B(Map<String, String> r3, String r4, String r5) {
        if (((Number) this.u.invoke()).intValue() != 7) goto L15;
        if (r3 == null) goto L22;
        if (r4 == null) goto L9;
        Map<String, String> r6 = h41.h.a(r4);
        if (r6 == null) goto L9;
        r3.putAll(r6);
    L9:
        com.bytedance.android.live.revlink.impl.global.c r7 = this.z;
        if (r7 == null) goto L12;
        b21.a r8 = r7.Rj();
    L13:
        if (r8 == null) goto L23;
        r8.b(r3, r5);
        return;
    L23:
        return;
    L12:
        r8 = null;
        goto L13
    L22:
        return;
    L15:
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        Map<String, String> r9 = h41.h.a(r4);
        if (r9 == null) goto L20;
        r3.putAll(r9);
    L20:
        this.t.v(r3, r5);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a
    public final void a(c21.e r38, c21.d r39, Map<String, String> r40) {
        Intrinsics.checkNotNullParameter(r38, "battleOpenParams");
        i97.a r0 = i97.a.a;
        long r12 = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.connect.g r1 = v();
        if (r1 == null) goto L5;
        long r2 = r1.getChannelId();
    L6:
        long r26 = r2;
        c21.e.a r3 = r38.a;
        long r4 = r3.a;
        int r19 = r3.d.getType();
        String r5 = r3.e;
        String r6 = r3.f;
        c21.f r7 = r38.b;
        if ((r7 instanceof c21.f.m) == false) goto L12;
        IBattleConfigSetting r8 = vh7.f.c(IBattleConfigSetting.class);
        r8.setModType(PkBaseDataContext.PKModType.Vote.getType());
        r8.setVoteData(((c21.f.m) r38.b).b);
        String r9 = GsonProtectorUtils.toJson(l97.a.a, r8);
        if (r9 == null) goto L82;
    L83:
        String r10 = "";
        if (r9 != null) goto L86;
        r9 = "";
    L86:
        List<String> r13 = r3.g;
        if (r13 == null) goto L99;
        ArrayList r14 = new ArrayList();
        Iterator<String> r15 = r13.iterator();
    L91:
        if (r15.hasNext() == false) goto L98;
        String r16 = r15.next();
        if (r16.length() <= 0) goto L95;
        boolean r17 = true;
    L96:
        if (r17 == false) goto L91;
        r14.add(r16);
        goto L91
    L95:
        r17 = false;
        goto L96
    L98:
        r10 = CollectionsKt.joinToString$default(r14, ",", null, null, 0, null, null, 62, null);
    L99:
        PlayMode r18 = r3.c;
        if (r18 == null) goto L102;
        int r24 = r18.toNetFormat();
    L103:
        com.bytedance.android.live.revlink.impl.global.c r20 = this.z;
        if (r20 == null) goto L106;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r22 = r20.getLinkOptLogContext();
    L107:
        if (r22 == null) goto L109;
        r22.b(null);
    L109:
        jy0.b.c("ttlive_anchor_pk_launcher", r38.c + " multiBattleOpen inviteeIds = " + r10 + ", battleConfigSettingStr = " + r9 + ", duration = " + r4, null, 4);
        r31.a r110 = x();
        if (r110 == null) goto L133;
        com.bytedance.android.live.revlink.impl.global.c r23 = this.z;
        if (r23 == null) goto L114;
        s r25 = r23.getRevLinkCommonUtil();
    L115:
        if (r25 == null) goto L117;
        Long r27 = Long.valueOf(r25.d());
    L118:
        Observable r28 = r110.e(r26, r4, r5, r19, r6, r9, r27, r10, r24, r40);
        if (r28 == null) goto L134;
        int r29 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r30 = r28.subscribeOn(Schedulers.io());
        if (r30 == null) goto L135;
        Observable r111 = r30.observeOn(AndroidSchedulers.mainThread());
        if (r111 == null) goto L136;
        String r112 = r10;
        Disposable r32 = r111.subscribe(new c(this, r39, r38, r12, r26, r112), new d(this, r39, r38, r12, r26, r112));
        if (r32 == null) goto L137;
        this.b.add(r32);
        return;
    L137:
        return;
    L136:
        return;
    L135:
        return;
    L134:
        return;
    L117:
        r27 = null;
        goto L118
    L114:
        r25 = null;
        goto L115
    L133:
        return;
    L106:
        r22 = null;
        goto L107
    L102:
        r24 = 0;
    L82:
        r9 = null;
        goto L83
    L12:
        if ((r7 instanceof c21.f.d) == false) goto L17;
        IBattleConfigSetting r33 = vh7.f.c(IBattleConfigSetting.class);
        r33.setModType(PkBaseDataContext.PKModType.Default.getType());
        r33.setSelfData(((c21.f.d) r38.b).b);
        r9 = GsonProtectorUtils.toJson(l97.a.a, r33);
        if (r9 != null) goto L83;
    L17:
        if ((r7 instanceof c21.f.k) == false) goto L26;
        IBattleConfigSetting r34 = vh7.f.c(IBattleConfigSetting.class);
        r34.setModType(PkBaseDataContext.PKModType.Default.getType());
        r34.setShellConfig(((c21.f.k) r38.b).b);
        IBattleConfigSetting r35 = r38.a.i;
        if (r35 == null) goto L21;
        IBattleAuxiliaryConfig r36 = r35.getAuxiliaryConfig();
    L22:
        r34.setAuxiliaryConfig(r36);
        r9 = GsonProtectorUtils.toJson(l97.a.a, r34);
        if (r9 != null) goto L83;
    L21:
        r36 = null;
        goto L22
    L26:
        if ((r7 instanceof c21.f.l) == false) goto L31;
        IBattleConfigSetting r37 = vh7.f.c(IBattleConfigSetting.class);
        r37.setModType(PkBaseDataContext.PKModType.Default.getType());
        r37.setSpecifyGiftConfig(((c21.f.l) r38.b).b);
        r9 = GsonProtectorUtils.toJson(l97.a.a, r37);
        if (r9 != null) goto L83;
    L31:
        if ((r7 instanceof c21.f.e) == false) goto L41;
        IBattleConfigSetting r42 = vh7.f.c(IBattleConfigSetting.class);
        r42.setModType(PkBaseDataContext.PKModType.Default.getType());
        PkBaseStateMachine.c r43 = (PkBaseStateMachine.c) this.v.getValue();
        if (r43 != null) goto L35;
    L36:
        r42.setActivityId(((c21.f.e) r38.b).b);
    L37:
        r9 = GsonProtectorUtils.toJson(l97.a.a, r42);
        if (r9 != null) goto L83;
    L35:
        if ((r43 instanceof PkBaseStateMachine.c.b) == true) goto L37;
    L41:
        if ((r7 instanceof c21.f.a) == false) goto L46;
        IBattleConfigSetting r44 = vh7.f.c(IBattleConfigSetting.class);
        r44.setModType(PkBaseDataContext.PKModType.BreakThrough.getType());
        r9 = GsonProtectorUtils.toJson(l97.a.a, r44);
        if (r9 != null) goto L83;
    L46:
        if ((r7 instanceof c21.f.i) == false) goto L51;
        IBattleConfigSetting r45 = vh7.f.c(IBattleConfigSetting.class);
        r45.setModType(PkBaseDataContext.PKModType.RobC.getType());
        r9 = GsonProtectorUtils.toJson(l97.a.a, r45);
        if (r9 != null) goto L83;
    L51:
        if ((r7 instanceof c21.f.b) == false) goto L56;
        IBattleConfigSetting r46 = vh7.f.c(IBattleConfigSetting.class);
        r46.setModType(PkBaseDataContext.PKModType.CloudCollaborate.getType());
        r46.setCloudCollaborateConfig(((c21.f.b) r38.b).b);
        r9 = GsonProtectorUtils.toJson(l97.a.a, r46);
        if (r9 != null) goto L83;
    L56:
        if ((r7 instanceof c21.f.g) == false) goto L61;
        IBattleConfigSetting r47 = vh7.f.c(IBattleConfigSetting.class);
        r47.setModType(PkBaseDataContext.PKModType.Custom.getType());
        r47.setCustomConfig(((c21.f.g) r38.b).b);
        r9 = GsonProtectorUtils.toJson(l97.a.a, r47);
        if (r9 != null) goto L83;
    L61:
        if ((r7 instanceof c21.f.j) == false) goto L72;
        IBattleConfigSetting r48 = vh7.f.c(IBattleConfigSetting.class);
        r48.setModType(PkBaseDataContext.PKModType.SeasonRank.getType());
        c21.e.a r49 = r38.a;
        if (r49 == null) goto L67;
        IBattleConfigSetting r50 = r49.i;
        if (r50 == null) goto L67;
        IBattleAuxiliaryConfig r52 = r50.getAuxiliaryConfig();
    L68:
        r48.setAuxiliaryConfig(r52);
        r9 = GsonProtectorUtils.toJson(l97.a.a, r48);
        if (r9 != null) goto L83;
    L67:
        r52 = null;
        goto L68
    L72:
        if ((r7 instanceof c21.f.C0009f) == false) goto L76;
        r9 = GsonProtectorUtils.toJson(l97.a.a, ((c21.f.C0009f) r7).b);
        if (r9 != null) goto L83;
    L76:
        c21.e.a r53 = r38.a;
        if (r53 == null) goto L79;
        IBattleConfigSetting r54 = r53.i;
    L80:
        if (r54 == null) goto L82;
        r9 = GsonProtectorUtils.toJson(l97.a.a, r54);
        goto L83
    L79:
        r54 = null;
        goto L80
    L5:
        r2 = 0;
        goto L6
    }

    public PkAnchorLauncher(Function0<Integer> r2, LiveData<PkBaseStateMachine.c> r3, com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r4, IRoom r5, com.bytedance.android.livesdk.revenue.service.room.c r6, com.bytedance.android.live.revlink.impl.global.c r7, yz0.f r8, x11.a r9) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "pkState");
        Intrinsics.checkNotNullParameter(r4, "pkBaseService");
        this.u = r2;
        this.v = r3;
        this.w = r4;
        this.x = r5;
        this.y = r6;
        this.z = r7;
        this.A = r8;
        this.B = r9;
        this.b = new CompositeDisposable();
        MutableLiveData<c21.c> r10 = new MutableLiveData();
        this.h = r10;
        this.i = r10;
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.C0127a> r12 = new MutableLiveData();
        this.j = r12;
        this.k = r12;
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.c> r13 = new MutableLiveData();
        this.l = r13;
        this.m = r13;
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.d> r14 = new MutableLiveData();
        this.n = r14;
        this.o = r14;
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.e> r15 = new MutableLiveData();
        this.p = r15;
        this.q = r15;
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.f> r16 = new MutableLiveData();
        this.r = r16;
        this.s = r16;
        if (r5 != null) goto L5;
        r5 = (IRoom) vh7.f.c(IRoom.class);
    L5:
        this.t = new h41.e(r7, true, r5, r9);
    }
}
