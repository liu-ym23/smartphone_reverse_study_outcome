package com.bytedance.android.live.pushstream.report;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.l;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.pushstream.StatusApi;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.e11;
import com.bytedance.android.livesdk.config.fb;
import com.bytedance.android.livesdk.config.mh;
import com.bytedance.android.livesdk.config.u11;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ms1.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements com.bytedance.android.live.pushstream.report.a, Handler.Callback {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final Lazy g;
    public final Handler h;
    public final long i;
    public final int j;
    public final int k;
    public final Map<String, Object> l;
    public Disposable m;
    public final IRoom n;
    public final com.bytedance.android.live.pushstream.report.c o;

    public static final class a {
    }

    public static final class b extends l.a {
        public final /* synthetic */ d a;
        public final /* synthetic */ int b;
        public final /* synthetic */ e11 c;

        public final boolean a(Throwable r2, int r3) {
            if (this.b != this.a.e) goto L7;
            if (this.c.b() == false) goto L7;
        L10:
            Boolean r4 = NewBroadcastMonitor.a;
            int r5 = NewBroadcastMonitor.d(r2);
            if (this.c.a().contains(Integer.valueOf(r5)) == false) goto L17;
            return false;
        L17:
            return true;
        L7:
            if (this.b == this.a.d) goto L9;
            return true;
        L9:
            if (this.c.e() == true) goto L10;
            return true;
        }

        public b(d r1, int r2, e11 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;

        public c(d r1, int r2, boolean r3, long r4, int r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r12) {
            BaseResponse r13 = (BaseResponse) r12;
            int r14 = this.b;
            d r0 = this.a;
            if (r14 != r0.e) goto L5;
            boolean r15 = true;
        L6:
            d.a(r0, r15, 0, null);
            com.bytedance.android.live.pushstream.report.c r1 = this.a.o;
            if (r1 == null) goto L10;
            r1.a(this.b, r15, 0, null);
        L10:
            if (this.c == false) goto L25;
            long r3 = System.currentTimeMillis() - this.d;
            d r2 = this.a;
            int r5 = this.b;
            int r6 = this.e;
            String r7 = this.f;
            r2.getClass();
            NewBroadcastMonitor.a r4 = NewBroadcastMonitor.c("ttlive_on_handle_update_room_status", null, null, 14);
            r4.l(0);
            r4.c(String.valueOf(r5));
            r4.d(r7);
            r4.h(r3);
            r4.i("reason", Integer.valueOf(r6));
            r4.i("source", r7);
            if (r5 != r2.b) goto L15;
            String r8 = "prepare";
        L24:
            r4.i("status_msg", r8);
            r4.a().report();
            goto L25
        L15:
            if (r5 != r2.e) goto L18;
            r8 = "finish";
            goto L24
        L18:
            if (r5 != r2.d) goto L21;
            r8 = "pause";
            goto L24
        L21:
            if (r5 != r2.c) goto L23;
            r8 = "play";
            goto L24
        L23:
            r8 = "";
        L25:
            if (r15 == false) goto L28;
            com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.D;
            Pair r9 = new Pair(DataType.FALSE, DataType.FALSE);
            r16.getClass();
            f.d(r16, r9);
            return;
        L28:
            return;
        L5:
            r15 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.pushstream.report.d$d, reason: collision with other inner class name */
    public static final class C0059d<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ e11 h;
        public final /* synthetic */ Map i;

        public C0059d(d r1, int r2, String r3, int r4, boolean r5, int r6, int r7, e11 r8, Map r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }

        public final void accept(Object r22) {
            ApiServerException r1 = (Throwable) r22;
            if (this.b != this.a.e) goto L5;
            boolean r2 = true;
        L6:
            String r9 = DataType.TRUE;
            if (r2 == false) goto L21;
            NewBroadcastMonitor.a r12 = NewBroadcastMonitor.c("ttlive_anchor_real_close_room_fail", null, null, 14);
            r12.n(r1);
            r12.c(String.valueOf(this.b));
            r12.d(this.c);
            r12.e("reason", String.valueOf(this.d));
            if (this.e == false) goto L11;
            String r13 = DataType.TRUE;
        L12:
            r12.e("status_change", r13);
            r12.e("retry_times", String.valueOf(this.f));
            if (this.f <= 0) goto L15;
            String r14 = String.valueOf(this.g);
        L16:
            r12.e("last_error_code", r14);
            if (NetworkUtils.f(jc1.a.b()) == false) goto L19;
            String r15 = DataType.TRUE;
        L20:
            r12.e("is_network_available", r15);
            r12.a().report();
            goto L21
        L19:
            r15 = DataType.FALSE;
            goto L20
        L15:
            r14 = "";
            goto L16
        L11:
            r13 = DataType.FALSE;
        L21:
            if (r2 == false) goto L31;
            mh r16 = mh.a;
            if (((u11) r16.getValue()).b() == false) goto L31;
            if (this.h.b() == true) goto L31;
            if (this.f >= ((u11) r16.getValue()).c()) goto L31;
            Boolean r17 = NewBroadcastMonitor.a;
            int r20 = NewBroadcastMonitor.d(r1);
            if (((u11) r16.getValue()).a().contains(Integer.valueOf(r20)) == false) goto L31;
            this.a.b(this.b, this.d, this.c, this.i, this.e, this.f + 1, r20);
            return;
        L31:
            d.a(this.a, r2, 1, r1);
            if ((r1 instanceof ApiServerException) == false) goto L36;
            com.bytedance.android.live.pushstream.report.c r18 = this.a.o;
            if (r18 == null) goto L36;
            r18.a(this.b, r2, r1.getErrorCode(), r1);
        L36:
            com.bytedance.android.live.pushstream.report.c r19 = this.a.o;
            if (r19 == null) goto L39;
            r19.a(this.b, r2, 0, r1);
        L39:
            TokenCert r110 = y50.d.a;
            y50.d.b(LiveTracingMonitor.EventModule.OPEN_LIVE, y50.d.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("server_api_name", "/room/ping/anchor/")}), this.b));
            NewBroadcastMonitor.a r3 = NewBroadcastMonitor.c("ttlive_anchor_close_room_fail", null, null, 14);
            r3.n(r1);
            r3.c(String.valueOf(this.b));
            r3.d(this.c);
            r3.e("reason", String.valueOf(this.d));
            if (this.e == true) goto L43;
            r9 = DataType.FALSE;
        L43:
            r3.e("status_change", r9);
            r3.a().report();
            if (r2 == false) goto L48;
            com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.D;
            String r5 = String.valueOf(this.a.n.getId());
            Boolean r6 = NewBroadcastMonitor.a;
            Pair r7 = new Pair(r5, String.valueOf(NewBroadcastMonitor.d(r1)));
            r4.getClass();
            f.d(r4, r7);
            return;
        L48:
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    static {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r10) {
        Intrinsics.checkNotNullParameter(r10, Constants.OperatorKey.MSG);
        int r12 = r10.what;
        int r0 = this.f;
        if (r0 != r12) goto L17;
        Handler r13 = this.h;
        if (r13 == null) goto L7;
        r13.removeMessages(r0);
    L7:
        b(this.k, 0, "", this.l, false, 0, 0);
        if (this.a == true) goto L11;
    L11:
        if (this.e == this.k) goto L18;
        Handler r14 = this.h;
        if (r14 == null) goto L19;
        r14.sendEmptyMessageDelayed(this.f, this.i);
        return true;
    L19:
        return true;
    L18:
        return true;
    L17:
        return true;
    }

    public d(IRoom r2, com.bytedance.android.live.pushstream.report.c r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        this.n = r2;
        this.o = r3;
        this.a = k.n(IMiddleWareHostContext.class).isLocalTest();
        this.b = 1;
        this.c = 2;
        this.d = 3;
        this.e = 4;
        this.f = 102;
        Lazy r4 = LazyKt.lazy(PushStreamReporter$DEFAULT_INTERVAL$2.INSTANCE);
        this.g = r4;
        this.j = 1;
        this.k = 1;
        this.l = new LinkedHashMap();
        this.h = new Handler(this);
        this.i = ((Long) r4.getValue()).longValue();
    }

    public static final void a(d r0, boolean r1, int r2, Throwable r3) {
        r0.getClass();
        if (r1 == false) goto L14;
        ALogger.e("StatusReport", "monitorRoomFinishStatus status: " + r2 + ", throwable: " + r3);
        JSONObject r4 = new JSONObject();
        if (r3 != null) goto L12;
    L10:
        LiveSlardarMonitor.monitorStatus("ttlive_anchor_close_room_all", r2, r4);
        return;
    L12:
        r4.put("throwable", r3.getMessage());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final void b(int r19, int r20, String r22, Map<String, ? extends Object> r23, boolean r24, int r25, int r26) {
        if (r19 != this.e) goto L19;
        TokenCert r0 = y50.d.a;
        y50.d.b(LiveTracingMonitor.EventModule.OPEN_LIVE, y50.d.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("server_api_name", "/room/close/")}), r19));
        if (112 != r20) goto L11;
        if (v.a() == false) goto L42;
        f2.c("cannot reach here. room start cannot finish room. Connect ShangHai", 0);
        return;
    L42:
        return;
    L11:
        if (h.a() == false) goto L19;
        if (115 != r20) goto L19;
        if (v.a() == false) goto L17;
        f2.c("暂时离开，不关播", 0);
    L17:
        ALogger.i("ttlive_anchor_swallow_back", "temporary close,not send ping anchor finish");
        return;
    L19:
        if (r23 == null) goto L21;
        Object r1 = r23.get("current_sticker_id");
    L22:
        Long r8 = (Long) r1;
        long r14 = System.currentTimeMillis();
        LinkedHashMap r9 = new LinkedHashMap();
        if (this.j != this.b) goto L25;
        int r2 = this.k;
        int r3 = this.c;
    L25:
        e11 r7 = (e11) fb.a.getValue();
        StatusApi r4 = (StatusApi) com.bytedance.android.live.network.c.b().e(StatusApi.class);
        long r5 = this.n.getId();
        long r6 = this.n.getStreamId();
        if (r22 != null) goto L28;
        String r16 = "";
    L29:
        Observable r10 = r4.sendStatusWithExtra(r5, r19, r6, r20, r16, r8, r9).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        if (r7.b() == true) goto L34;
        if (r7.e() == true) goto L34;
    L38:
        Observable r12 = r10;
        e11 r13 = r7;
    L40:
        this.m = r12.subscribe(new c(this, r19, r24, r14, r20, r22), new C0059d(this, r19, r22, r20, r24, r25, r26, r13, r23));
        return;
    L34:
        if (r19 != this.e) goto L36;
    L39:
        r13 = r7;
        r12 = r10.retryWhen(new l(r7.d(), r7.c(), new b(this, r19, r13)));
        goto L40
    L36:
        if (r19 != this.d) goto L38;
    L28:
        r16 = r22;
        goto L29
    L21:
        r1 = null;
        goto L22
    }
}
