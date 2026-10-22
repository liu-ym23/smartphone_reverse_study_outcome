package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.bridge.d1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkOutManager implements com.bytedance.android.live.revenuelink.multimsg.e, n {
    public com.bytedance.android.live.revenuelink.multimsg.a a;
    public final CompositeDisposable b;
    public final HashMap<String, Disposable> c;
    public final MultiLinkServerMonitor d;
    public final ConnectDataContext e;
    public final com.bytedance.android.live.revenuelink.connect.j f;
    public final yz0.f g;
    public final com.bytedance.android.live.revenuelink.withroom.a h;
    public final IRoomBase i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.b b;
        public final /* synthetic */ long c;

        public a(LinkOutManager r1, d11.b r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r10) {
            ExtraResponse r12 = (ExtraResponse) r10;
            if (r12 == null) goto L20;
            com.bytedance.android.livesdk.link.model.f r0 = (com.bytedance.android.livesdk.link.model.f) r12.data;
            if (r0 == null) goto L21;
            com.bytedance.android.live.revenuelink.connect.j r1 = this.a.f;
            if (r1 == null) goto L9;
            r1.e5(this.b, r0, this.c);
        L9:
            MultiLinkServerMonitor r2 = this.a.d;
            int r3 = this.b.a;
            i97.a r4 = i97.a.a;
            long r5 = System.currentTimeMillis() - this.c;
            Intrinsics.checkNotNullParameter(r12, "$this$requestTypeExt");
            int r7 = r12.a;
            int r13 = MultiLinkServerMonitor.e;
            r2.f(r3, "linkmic/apply/", r5, r7, MultiLinkServerMonitor$monitorApiCallSuccess$2.INSTANCE);
            if (r0.getWaitSec() <= 0) goto L12;
            long r6 = r0.getWaitSec() + h11.a.f.a().O1();
        L13:
            com.bytedance.revenue.platform.api.core.rx.l r14 = com.bytedance.revenue.platform.api.core.rx.l.a;
            long r8 = r6 * ((long) WebcastRedirectException.UNKNOWN);
            int r15 = com.bytedance.revenue.platform.api.core.rx.p.a;
            Scheduler r16 = Schedulers.computation();
            Disposable r17 = Observable.timer(r8, TimeUnit.MILLISECONDS, r16).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this));
            this.a.b.add(r17);
            IBaseUser r9 = this.b.h.getOwnerKt();
            if (r9 == null) goto L16;
            String r18 = iz.a.a(r9);
        L17:
            if (r18 == null) goto L22;
            this.a.c.put(r18, r17);
            return;
        L22:
            return;
        L16:
            r18 = null;
            goto L17
        L12:
            r6 = h11.a.f.a().o2();
            goto L13
        L21:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.b b;
        public final /* synthetic */ long c;

        public b(LinkOutManager r1, d11.b r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            MultiLinkServerMonitor r0 = this.a.d;
            int r1 = this.b.a;
            i97.a r3 = i97.a.a;
            MultiLinkServerMonitor.e(r0, r1, "linkmic/apply/", r9, System.currentTimeMillis() - this.c);
            com.bytedance.android.live.revenuelink.connect.j r2 = this.a.f;
            if (r2 == null) goto L6;
            r2.W4(this.b, r9, this.c);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.c b;
        public final /* synthetic */ long c;

        public c(LinkOutManager r1, d11.c r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            ExtraResponse r9 = (ExtraResponse) r8;
            Disposable r10 = this.a.c.get(this.b.d);
            if (r10 == null) goto L5;
            r10.dispose();
        L5:
            HashMap<String, Disposable> r12 = this.a.c;
            String r0 = this.b.d;
            if (r12 == null) goto L12;
            TypeIntrinsics.asMutableMap(r12).remove(r0);
            MultiLinkServerMonitor r1 = this.a.d;
            int r2 = this.b.a;
            i97.a r13 = i97.a.a;
            long r3 = System.currentTimeMillis() - this.c;
            int r14 = MultiLinkServerMonitor.e;
            r1.g(r2, "linkmic/cancel/", r3, "");
            com.bytedance.android.live.revenuelink.connect.j r15 = this.a.f;
            if (r15 == null) goto L13;
            r15.d5(this.b, this.c);
            return;
        L13:
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.c b;
        public final /* synthetic */ long c;

        public d(LinkOutManager r1, d11.c r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            Disposable r0 = this.a.c.get(this.b.d);
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            HashMap<String, Disposable> r1 = this.a.c;
            String r2 = this.b.d;
            if (r1 == null) goto L12;
            TypeIntrinsics.asMutableMap(r1).remove(r2);
            MultiLinkServerMonitor r3 = this.a.d;
            int r4 = this.b.a;
            i97.a r5 = i97.a.a;
            MultiLinkServerMonitor.e(r3, r4, "linkmic/cancel/", r9, System.currentTimeMillis() - this.c);
            com.bytedance.android.live.revenuelink.connect.j r6 = this.a.f;
            if (r6 == null) goto L13;
            r6.S4(this.b, r9, this.c);
            return;
        L13:
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ Disposable b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ d11.d d;
        public final /* synthetic */ long e;

        public e(LinkOutManager r1, Disposable r2, Function1 r3, d11.d r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r15) {
            ExtraResponse r16 = (ExtraResponse) r15;
            if (r16 == null) goto L44;
            m0 r0 = (m0) r16.data;
            if (r0 == null) goto L45;
            final v4 r1 = r0.castTo(v4.class);
            if (r1 != null) goto L9;
            return;
        L9:
            if (this.b.isDisposed() == true) goto L13;
            Function1 r2 = this.c;
            if (r2 == null) goto L13;
            Unit r3 = (Unit) r2.invoke(this.d);
        L13:
            xa1.b r4 = xa1.b.d;
            r4.getClass();
            if (((Boolean) xa1.b.c.getValue(r4, xa1.b.a[1])).booleanValue() == true) goto L16;
        L18:
            com.bytedance.android.live.revenuelink.connect.j r5 = this.a.f;
            if (r5 == null) goto L21;
            r5.a5(this.d, this.e, r1);
        L21:
            final MultiLinkServerMonitor r7 = this.a.d;
            final d11.d r6 = this.d;
            final long r8 = this.e;
            Intrinsics.checkNotNullParameter(r16, "$this$requestTypeExt");
            int r10 = r16.a;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r6, "params");
            Intrinsics.checkNotNullParameter(r1, "result");
            int r17 = MultiLinkServerMonitor.e;
            int r18 = r6.a;
            int r9 = r6.i;
            if (r9 != 1) goto L24;
        L29:
            r18 = 1;
        L30:
            i97.a r12 = i97.a.a;
            int r13 = r18;
            r7.f(r13, "linkmic/invite/", System.currentTimeMillis() - r8, r10, new MultiLinkServerMonitor$monitorInviteSuccess$1(r7, r6, r1, r8));
            Intrinsics.checkNotNull(r1);
            if (r1.getWaitSec() <= 0) goto L33;
            long r14 = r1.getWaitSec() + h11.a.f.a().O1();
        L34:
            com.bytedance.revenue.platform.api.core.rx.l r19 = com.bytedance.revenue.platform.api.core.rx.l.a;
            long r20 = r14 * ((long) WebcastRedirectException.UNKNOWN);
            int r110 = com.bytedance.revenue.platform.api.core.rx.p.a;
            Scheduler r111 = Schedulers.computation();
            Disposable r112 = Observable.timer(r20, TimeUnit.MILLISECONDS, r111).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(this));
            this.a.b.add(r112);
            IRoom r22 = this.d.h;
            if (r22 == null) goto L40;
            IBaseUser r23 = r22.getOwnerKt();
            if (r23 == null) goto L40;
            String r24 = iz.a.a(r23);
            if (r24 == null) goto L40;
        L41:
            if (r24 == null) goto L47;
            this.a.c.put(r24, r112);
            return;
        L47:
            return;
        L40:
            r24 = this.d.f;
            goto L41
        L33:
            r14 = h11.a.f.a().D0();
            goto L34
        L24:
            if (r9 == 2) goto L29;
            if (r9 != 3) goto L30;
            r18 = 7;
            goto L30
        L16:
            if (r1.getInviteeRoom() == null) goto L18;
            d11.d r25 = this.d;
            r25.h = r1.getInviteeRoom();
            goto L18
        L45:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ Disposable b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ d11.d d;
        public final /* synthetic */ long e;

        public f(LinkOutManager r1, Disposable r2, Function1 r3, d11.d r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            if (this.b.isDisposed() == true) goto L7;
            Function1 r0 = this.c;
            if (r0 == null) goto L7;
            Unit r1 = (Unit) r0.invoke(this.d);
        L7:
            MultiLinkServerMonitor r2 = this.a.d;
            int r3 = this.d.a;
            i97.a r4 = i97.a.a;
            MultiLinkServerMonitor.e(r2, r3, "linkmic/invite/", r9, System.currentTimeMillis() - this.e);
            Integer r5 = null;
            if ((r9 instanceof ApiServerException) == true) goto L10;
            Throwable r6 = null;
        L11:
            ApiServerException r7 = (ApiServerException) r6;
            if (r7 == null) goto L14;
            r5 = Integer.valueOf(r7.getErrorCode());
        L14:
            if (r5 != null) goto L17;
        L19:
            com.bytedance.android.live.revenue.common.k.a(com.bytedance.live.kmp.util.c.a.getContext(), r9);
        L20:
            com.bytedance.android.live.revenuelink.connect.j r10 = this.a.f;
            if (r10 == null) goto L24;
            r10.V4(this.d, r9, this.e);
            return;
        L24:
            return;
        L17:
            if (r5.intValue() != 31012) goto L19;
        L10:
            r6 = r9;
            goto L11
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.e b;
        public final /* synthetic */ long c;

        public g(LinkOutManager r1, d11.e r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            ExtraResponse r10 = (ExtraResponse) r9;
            MultiLinkServerMonitor r1 = this.a.d;
            int r2 = this.b.a;
            i97.a r0 = i97.a.a;
            long r4 = System.currentTimeMillis() - this.c;
            Intrinsics.checkNotNullParameter(r10, "$this$requestTypeExt");
            int r6 = r10.a;
            int r12 = MultiLinkServerMonitor.e;
            r1.f(r2, "linkmic/kickout/", r4, r6, MultiLinkServerMonitor$monitorApiCallSuccess$2.INSTANCE);
            com.bytedance.android.live.revenuelink.connect.j r13 = this.a.f;
            if (r13 == null) goto L6;
            r13.Z1(this.b, this.c);
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.e b;
        public final /* synthetic */ long c;

        public h(LinkOutManager r1, d11.e r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            MultiLinkServerMonitor r0 = this.a.d;
            int r1 = this.b.a;
            i97.a r3 = i97.a.a;
            MultiLinkServerMonitor.e(r0, r1, "linkmic/kickout/", r9, System.currentTimeMillis() - this.c);
            com.bytedance.android.live.revenuelink.connect.j r2 = this.a.f;
            if (r2 == null) goto L6;
            r2.O1(this.b, r9, this.c);
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.f b;
        public final /* synthetic */ long c;

        public i(LinkOutManager r1, d11.f r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r13) {
            ExtraResponse r14 = (ExtraResponse) r13;
            if (r14 == null) goto L11;
            com.bytedance.android.livesdk.link.model.v r0 = (com.bytedance.android.livesdk.link.model.v) r14.data;
            if (r0 == null) goto L12;
            com.bytedance.android.live.revenuelink.connect.j r1 = this.a.f;
            if (r1 == null) goto L9;
            r1.U4(this.b, r0, this.c);
        L9:
            final MultiLinkServerMonitor r2 = this.a.d;
            final d11.f r3 = this.b;
            final com.bytedance.android.livesdk.link.model.v r4 = (com.bytedance.android.livesdk.link.model.v) r14.data;
            final long r5 = this.c;
            Intrinsics.checkNotNullParameter(r14, "$this$requestTypeExt");
            int r15 = r14.a;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "permitData");
            int r7 = r3.a;
            i97.a r6 = i97.a.a;
            r2.f(r7, "linkmic/permit/", System.currentTimeMillis() - r5, r15, new MultiLinkServerMonitor$monitorPermitSuccess$1(r2, r3, r4, r5));
            return;
        L12:
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.f b;
        public final /* synthetic */ long c;

        public j(LinkOutManager r1, d11.f r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            MultiLinkServerMonitor r0 = this.a.d;
            int r1 = this.b.a;
            i97.a r3 = i97.a.a;
            r0.d(r1, "linkmic/permit/", r9, System.currentTimeMillis() - this.c, new LinkOutManager$permit$3$1(this));
            com.bytedance.android.live.revenuelink.connect.j r2 = this.a.f;
            if (r2 == null) goto L6;
            r2.c5(this.b, r9, this.c);
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.g b;
        public final /* synthetic */ long c;
        public final /* synthetic */ boolean d;

        public k(LinkOutManager r1, d11.g r2, long r3, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r23) {
            ExtraResponse r1 = (ExtraResponse) r23;
            if (r1 == null) goto L41;
            d1 r2 = (d1) r1.data;
            if (r2 == null) goto L42;
            q5 r3 = r2.castTo(q5.class);
            if (r3 == null) goto L43;
            com.bytedance.android.live.revenuelink.connect.j r4 = this.a.f;
            if (r4 == null) goto L11;
            r4.R4(this.b, r3, this.c);
        L11:
            MultiLinkServerMonitor r9 = this.a.d;
            d11.g r10 = this.b;
            Intrinsics.checkNotNullParameter(r1, "$this$requestTypeExt");
            int r5 = r1.a;
            long r12 = this.c;
            boolean r13 = this.d;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r3, "replyResult");
            com.bytedance.android.live.revenuelink.withroom.a r6 = r9.c;
            int r7 = 1;
            if (r6 == null) goto L18;
            com.bytedance.android.live.revenuelink.f r8 = r6.getRevenueLinkTraceMonitor();
            if (r8 == null) goto L18;
            if (r8.X("linkmic/reply/") != true) goto L18;
            return;
        L18:
            int r14 = MultiLinkServerMonitor.e;
            int r15 = r10.a;
            int r16 = r10.b;
            if (r16 != 1) goto L21;
        L26:
            LiveTracingMonitorKt r17 = LiveTracingMonitorKt.a;
            LiveTracingMonitorKt.EventModule r18 = LiveTracingMonitorKt.a(r7);
            JSONObject r19 = new JSONObject();
            r9.b(r19, r7, r18);
            Iterator<p> r110 = r9.b.iterator();
        L28:
            if (r110.hasNext() == false) goto L30;
            r110.next().d(r10, r3, r12, r19);
            goto L28
        L30:
            int r20 = y50.b.a;
            i97.a r22 = i97.a.a;
            y50.b.a.c(r19, Constants.Keys.duration, System.currentTimeMillis() - r12);
            y50.b.a.d(r19, "server_api_name", "linkmic/reply/");
            y50.b.a.b(r19, "reply_type", r10.e);
            y50.b.a.b(r19, "request_type", r5);
            if (r13 == false) goto L33;
            String r24 = DataType.FALSE;
        L34:
            y50.b.a.d(r19, "from_status", r24);
            y50.b.a.b(r19, "to_biz_type", r3.getToBizType());
            HashMap r25 = new HashMap();
            r25.put("server_api_name", "linkmic/reply/");
            r25.put("android_event_key", "linkmic/reply/");
            com.bytedance.android.live.revenuelink.withroom.a r26 = r9.c;
            if (r26 == null) goto L44;
            com.bytedance.android.live.revenuelink.f r27 = r26.getRevenueLinkTraceMonitor();
            if (r27 == null) goto L45;
            r27.Z("ttlive_interact_server_api_call", r18, r25, r19, r10.c);
            return;
        L45:
            return;
        L44:
            return;
        L33:
            r24 = DataType.TRUE;
            goto L34
        L21:
            if (r16 == 2) goto L26;
            if (r16 == 3) goto L25;
            r7 = r15;
            goto L26
        L25:
            r7 = 7;
            goto L26
        L43:
            return;
        L42:
            return;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ LinkOutManager a;
        public final /* synthetic */ d11.g b;
        public final /* synthetic */ long c;

        public l(LinkOutManager r1, d11.g r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r10) {
            Throwable r12 = (Throwable) r10;
            MultiLinkServerMonitor r0 = this.a.d;
            final d11.g r1 = this.b;
            long r2 = this.c;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "params");
            int r4 = MultiLinkServerMonitor.e;
            int r5 = r1.a;
            int r6 = r1.b;
            if (r6 != 1) goto L5;
        L10:
            r5 = 1;
        L11:
            i97.a r7 = i97.a.a;
            long r8 = System.currentTimeMillis() - r2;
            Function1<JSONObject, Unit> r9 = new MultiLinkServerMonitor$monitorReplyFailed$1(r1);
            r0.d(r5, "linkmic/reply/", r12, r8, r9);
            com.bytedance.android.live.revenuelink.connect.j r3 = this.a.f;
            if (r3 == null) goto L15;
            r3.T4(this.b, r12, this.c);
            return;
        L15:
            return;
        L5:
            if (r6 == 2) goto L10;
            if (r6 != 3) goto L11;
            r5 = 7;
            goto L11
        }
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.e
    public final void a(yh6.c r2) {
        l(r2, true);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void b(com.bytedance.android.live.revlink.impl.multianchor.utils.t r3) {
        Intrinsics.checkNotNullParameter(r3, FileUtils.FILTER);
        MultiLinkServerMonitor r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, FileUtils.FILTER);
        if (r1.b.contains(r3) == true) goto L6;
        r1.b.add(r3);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void c(i6 r2) {
        Intrinsics.checkNotNullParameter(r2, "linkerMessage");
        l((yh6.c) r2.castTo(i6.class), false);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void i(com.bytedance.android.live.revlink.impl.multianchor.utils.t r3) {
        Intrinsics.checkNotNullParameter(r3, FileUtils.FILTER);
        MultiLinkServerMonitor r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, FileUtils.FILTER);
        if (r1.b.contains(r3) == true) goto L6;
        r1.b.remove(r3);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void j(d11.e r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        e11.b r2 = e11.c.a(e11.b.a);
        e11.a r3 = (e11.a) r2;
        Observable<ExtraResponse<Object, Extra>> r4 = r3.i(r12.b, r12.c, r12.d, r12.a, r12.e, r12.f);
        int r5 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r13 = r4.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r12, r1), new h(this, r12, r1));
        this.b.add(r13);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void d(d11.d r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        f(r2, null, null, r3);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void e(d11.c r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.connect.j r2 = this.f;
        if (r2 == null) goto L5;
        r2.Y1(r5, r1);
    L5:
        e11.b r3 = e11.c.a(e11.b.a);
        e11.a r4 = (e11.a) r3;
        Observable<ExtraResponse<Object, Extra>> r7 = r4.d(r5.a(), r6);
        int r8 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r9 = r7.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r5, r1), new d(this, r5, r1));
        this.b.add(r9);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void g(d11.b r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        i97.a r0 = i97.a.a;
        long r1 = System.currentTimeMillis();
        e11.b r2 = e11.c.a(e11.b.a);
        e11.a r3 = (e11.a) r2;
        Observable<ExtraResponse<com.bytedance.android.livesdk.link.model.f, Extra>> r7 = r3.c(r5.a(), r6);
        int r4 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r8 = r7.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r5, r1), new b(this, r5, r1));
        this.b.add(r8);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void h(d11.g r10, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        com.bytedance.android.live.revenuelink.connect.j r0 = this.f;
        if (r0 == null) goto L5;
        r0.Z3(r10);
    L5:
        ey.f r1 = (ey.f) this.e.getRealConnectState().getValue();
        if (r1 != null) goto L8;
        boolean r7 = true;
    L9:
        i97.a r2 = i97.a.a;
        long r3 = System.currentTimeMillis();
        e11.b r4 = e11.c.a(e11.b.a);
        e11.a r5 = (e11.a) r4;
        Observable<ExtraResponse<d1, Extra>> r13 = r5.l(r10.a(), r12);
        int r6 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r14 = r13.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this, r10, r3, r7), new l(this, r10, r3));
        if (r14 == null) goto L13;
        this.b.add(r14);
        return;
    L13:
        return;
    L8:
        r7 = true ^ (r1 instanceof ey.f.f);
        goto L9
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final void k(d11.f r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r6.b != 0) goto L17;
        MultiLinkServerMonitor r8 = this.d;
        int r9 = r6.a;
        LinkOutManager$permit$1 r0 = LinkOutManager$permit$1.INSTANCE;
        r8.getClass();
        Intrinsics.checkNotNullParameter("interact_link_channel_id_error", "event");
        Intrinsics.checkNotNullParameter(r0, "putExtra");
        LiveTracingMonitorKt r2 = LiveTracingMonitorKt.a;
        LiveTracingMonitorKt.EventModule r3 = LiveTracingMonitorKt.a(r9);
        com.bytedance.android.live.revenuelink.withroom.a r4 = r8.c;
        if (r4 == null) goto L11;
        com.bytedance.android.live.revenuelink.f r5 = r4.getRevenueLinkTraceMonitor();
        if (r5 == null) goto L11;
        if (r5.X("interact_link_channel_id_error") != true) goto L11;
        return;
    L11:
        JSONObject r10 = new JSONObject();
        r8.b(r10, r9, r3);
        r0.invoke(r10);
        HashMap r12 = new HashMap();
        r12.put("android_event_key", "interact_link_channel_id_error");
        com.bytedance.android.live.revenuelink.withroom.a r13 = r8.c;
        if (r13 == null) goto L19;
        com.bytedance.android.live.revenuelink.f r14 = r13.getRevenueLinkTraceMonitor();
        if (r14 == null) goto L20;
        com.bytedance.android.live.revenuelink.f.a.a(r14, "ttlive_pk_business_api_call", r3, r12, r10);
        return;
    L20:
        return;
    L19:
        return;
    L17:
        i97.a r1 = i97.a.a;
        long r15 = System.currentTimeMillis();
        e11.b r16 = e11.c.a(e11.b.a);
        e11.a r17 = (e11.a) r16;
        Observable<ExtraResponse<com.bytedance.android.livesdk.link.model.v, Extra>> r18 = r17.j(r6.a(), r7);
        int r19 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r20 = r18.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r6, r15), new j(this, r6, r15));
        this.b.add(r20);
    }

    public final void l(yh6.c r13, boolean r14) {
        ey.f r0 = (ey.f) this.e.getRealConnectState().getValue();
        if (r0 != null) goto L5;
        boolean r10 = true;
    L7:
        if ((r13 instanceof h1) == false) goto L50;
        i6 r4 = ((vh7.c) r13).castTo(i6.class);
        int r3 = (int) i1.b(r4);
        Intrinsics.checkNotNullParameter(r4, "$this$typeExt");
        int r7 = (int) r4.getType2();
        if (r7 != 3) goto L11;
        com.bytedance.android.live.revenuelink.connect.j r15 = this.f;
        if (r15 == null) goto L47;
        r15.Z4(r4);
    L47:
        if (r14 == false) goto L57;
        MultiLinkServerMonitor r2 = this.d;
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        long r5 = r4.getLinkerId();
        i97.a r16 = i97.a.a;
        MultiLinkServerMonitor.h(r2, r3, r4, r5, r7, System.currentTimeMillis(), r10, 192);
        return;
    L57:
        return;
    L11:
        if (r7 != 4) goto L13;
        com.bytedance.android.live.revenuelink.connect.j r17 = this.f;
        if (r17 == null) goto L42;
        r17.Y4(r4);
    L42:
        if (r14 == false) goto L55;
        MultiLinkServerMonitor r6 = this.d;
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        long r8 = r4.getLinkerId();
        i97.a r18 = i97.a.a;
        MultiLinkServerMonitor.h(r6, r3, r4, r8, r7, System.currentTimeMillis(), r10, 192);
        return;
    L55:
        return;
    L13:
        if (r7 != 5) goto L15;
    L26:
        k6 r19 = r4.getReply();
        if (r19 == null) goto L34;
        String r110 = r19.getToUid();
        if (r110 == null) goto L34;
        Disposable r1 = this.c.get(r110);
        if (r1 == null) goto L33;
        r1.dispose();
    L33:
        Disposable r111 = this.c.remove(r110);
    L34:
        com.bytedance.android.live.revenuelink.connect.j r112 = this.f;
        if (r112 == null) goto L37;
        r112.b5(r4);
    L37:
        if (r14 == false) goto L53;
        MultiLinkServerMonitor r9 = this.d;
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        long r12 = r4.getLinkerId();
        i97.a r113 = i97.a.a;
        MultiLinkServerMonitor.h(r9, r3, r4, r12, r7, System.currentTimeMillis(), r10, 192);
        return;
    L53:
        return;
    L15:
        if (r7 == 8) goto L26;
        if (r7 != 9) goto L19;
    L21:
        com.bytedance.android.live.revenuelink.connect.j r114 = this.f;
        if (r114 == null) goto L24;
        r114.X4(r4);
    L24:
        if (r14 == false) goto L51;
        MultiLinkServerMonitor r20 = this.d;
        Intrinsics.checkNotNullParameter(r4, "$this$linkerIdExt");
        long r22 = r4.getLinkerId();
        i97.a r115 = i97.a.a;
        MultiLinkServerMonitor.h(r20, r3, r4, r22, r7, System.currentTimeMillis(), r10, 192);
        return;
    L51:
        return;
    L19:
        if (r7 == 14) goto L21;
        return;
    L50:
        return;
    L5:
        r10 = true ^ (r0 instanceof ey.f.f);
        goto L7
    }

    @Override // com.bytedance.android.live.revenuelink.connect.n
    public final Disposable f(d11.d r12, Function1<? super d11.d, Unit> r13, Function1<? super d11.d, Unit> r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r12, "params");
        com.bytedance.android.live.revenuelink.connect.j r0 = this.f;
        if (r0 == null) goto L5;
        r0.A3(r12);
    L5:
        i97.a r1 = i97.a.a;
        long r8 = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.withroom.a r2 = this.h;
        if (r2 == null) goto L10;
        com.bytedance.android.live.revenuelink.connect.g r3 = r2.getAnchorConnectUtils();
        if (r3 == null) goto L10;
        Long r4 = Long.valueOf(r3.getChannelId());
    L11:
        long r5 = r4.longValue();
        int r6 = com.bytedance.revenue.platform.api.core.rx.h.a;
        Disposable r10 = com.bytedance.revenue.platform.api.core.rx.h.a(LinkOutManager$invite$disposable$1.INSTANCE);
        e11.b r7 = e11.c.a(e11.b.a);
        e11.a r9 = (e11.a) r7;
        Observable<ExtraResponse<m0, Extra>> r16 = r9.g(r12.a(r5), r15);
        if (r16 == null) goto L20;
        int r17 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r18 = r16.subscribeOn(Schedulers.io());
        if (r18 == null) goto L20;
        Observable r19 = r18.observeOn(AndroidSchedulers.mainThread());
        if (r19 == null) goto L20;
        Disposable r110 = r19.subscribe(new e(this, r10, r13, r12, r8), new f(this, r10, r14, r12, r8));
        if (r110 == null) goto L20;
        this.b.add(r110);
    L20:
        return r10;
    L10:
        r4 = null;
        goto L11
    }

    public LinkOutManager(ConnectDataContext r2, ConnectDataContext.e r3, yz0.f r4, com.bytedance.android.live.revenuelink.withroom.a r5, IRoomBase r6) {
        Intrinsics.checkNotNullParameter(r2, "connectDataContext");
        Intrinsics.checkNotNullParameter(r5, "linkStoreService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.b = new CompositeDisposable();
        this.c = new HashMap();
        this.d = new MultiLinkServerMonitor(r5, r6);
    }
}
