package fx0;

import am2.x;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.RevenueRechargeCheckResultModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import w20.n5;
import w20.qd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m extends n5<qd, RevenueRechargeCheckResultModel> {
    public boolean a;
    public WeakReference<Context> b;
    public final CompositeDisposable c;
    public String d;
    public boolean e;
    public final a f;

    public static final class a implements com.bytedance.android.live.recharge.k.a {
        public final /* synthetic */ m a;

        @Override // com.bytedance.android.live.recharge.k.a
        public final /* synthetic */ void a() {
        }

        public a(m r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.recharge.k.a
        public final void b(int r3, int r4, long r5) {
            m r6 = this.a;
            if (r6.a == false) goto L13;
            if (by0.b.a(r6.d) == false) goto L17;
            WeakReference<Context> r7 = this.a.b;
            if (r7 == null) goto L18;
            Context r8 = r7.get();
            if (r8 == null) goto L19;
            ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(r8, this.a.d);
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        L13:
            if (r3 == 1) goto L15;
            r6.j(false, ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter().getAvailableDiamonds(), true);
            return;
        L15:
            r6.j(true, ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter().getAvailableDiamonds(), true);
        }
    }

    public final void onTerminate() {
        this.a = true;
        this.c.clear();
    }

    public final void onDestroy() {
        this.c.clear();
        this.e = false;
        super/*com.bytedance.ies.web.jsbridge2.f*/.onDestroy();
    }

    public m() {
        this.c = new CompositeDisposable();
        this.d = "";
        this.f = new a(this);
    }

    public final void invoke(Object r29, CallContext r30) {
        qd r2 = (qd) r29;
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r30, "context");
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L5;
        finishWithFailure(new Exception("user not login"));
    L5:
        com.bytedance.android.live.revenue.core.util.j.a r4 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r5 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r4.a(), yz0.k.class);
        if (r5 == null) goto L9;
        Context r6 = r5.getContext();
        if (r6 == null) goto L9;
    L10:
        this.b = new WeakReference(r6);
        qd.a r3 = r2.a();
        if (r3 == null) goto L14;
        String r7 = r3.b();
        if (r7 == null) goto L14;
    L15:
        this.d = r7;
        long r8 = ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter().getAvailableDiamonds();
        Integer r9 = r2.d();
        if (r9 == null) goto L18;
        int r10 = r9.intValue();
    L19:
        long r12 = r10;
        if (r8 < r12) goto L23;
        j(true, r8, false);
        boolean r1 = true;
    L107:
        int r13 = com.bytedance.android.live.recharge.utils.m.a;
        Pair[] r14 = new Pair[3];
        r14[0] = TuplesKt.to("charge_reason", String.valueOf(r2.b()));
        if (r1 == false) goto L110;
        String r15 = DataType.TRUE;
    L111:
        r14[1] = TuplesKt.to("is_balance_enough", r15);
        r14[2] = TuplesKt.to("is_from_cache", DataType.TRUE);
        Map r16 = MapsKt.mapOf(r14);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r17 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_rd_recharge_check_jsb", r16, new Class[]{IRoom.class, x.class});
        return;
    L110:
        r15 = DataType.FALSE;
        goto L111
    L23:
        if (Intrinsics.areEqual(r2.c(), Boolean.TRUE) == false) goto L26;
        j(false, r8, false);
    L106:
        r1 = false;
        goto L107
    L26:
        if (this.e == true) goto L106;
        ToastUtil.b("余额不足", 0);
        if (r10 <= 0) goto L31;
        long r18 = r12 - r8;
    L32:
        long r19 = r18;
        if (com.bytedance.android.live.revenue.core.util.f.d(r4.a(), yz0.k.class) == null) goto L35;
        boolean r110 = true;
    L36:
        String r20 = r2.b();
        if (r20 != null) goto L39;
        String r111 = "";
    L40:
        qd.a r22 = r2.a();
        if (r22 == null) goto L46;
        String r23 = r22.d();
        if (r23 == null) goto L46;
        String r112 = r23;
    L47:
        qd.a r24 = r2.a();
        int r25 = -1;
        if (r24 == null) goto L52;
        Integer r26 = r24.a();
        if (r26 == null) goto L52;
        int r113 = r26.intValue();
    L53:
        qd.a r27 = r2.a();
        Context r28 = null;
        if (r27 == null) goto L56;
        JsonObject r32 = r27.c();
    L57:
        if (r32 != null) goto L113;
    L62:
        Integer r33 = null;
    L63:
        if (r32 == null) goto L67;
        JsonElement r114 = r32.get("enough_callback");     // Catch: JSONException -> L61
        if (r114 == null) goto L67;
        String r115 = r114.getAsString();     // Catch: JSONException -> L61
    L68:
        if (r32 == null) goto L72;
        JsonElement r34 = r32.get("recharge_source");     // Catch: JSONException -> L61
        if (r34 == null) goto L72;
        Integer r35 = Integer.valueOf(r34.getAsInt());     // Catch: JSONException -> L61
    L74:
        if (r33 == null) goto L76;
        r25 = r33.intValue();     // Catch: JSONException -> L61
    L76:
        if (r115 != null) goto L78;
        r115 = "";
    L78:
        if (r35 == null) goto L80;
        int r36 = r35.intValue();     // Catch: JSONException -> L61
    L81:
        com.bytedance.android.live.recharge.model.f r210 = new com.bytedance.android.live.recharge.model.f(r25, r115, r36);     // Catch: JSONException -> L61
    L84:
        com.bytedance.android.live.recharge.model.d r37 = new com.bytedance.android.live.recharge.model.d(r110, r111, r112, r19, false, r113, 0, null, null, null, r210, null, null, 31696);
        IRechargeService r38 = (IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class);
        WeakReference<Context> r39 = this.b;
        if (r39 == null) goto L87;
        r28 = r39.get();
    L87:
        r38.showRechargeDialogFragment(r28, r37, this.f);
        this.e = true;
        String r40 = r30.b;
        if (r40 == null) goto L93;
        String r42 = UriProtector.parse(r40).getPath();
        if (r42 == null) goto L93;
        String r211 = r42;
    L94:
        int r43 = com.bytedance.android.live.recharge.utils.m.a;
        String r116 = r37.c;
        String r117 = r37.b;
        long r44 = r37.d;
        com.bytedance.android.live.recharge.model.b r45 = r37.j;
        if (r45 == null) goto L97;
        long r118 = r45.e;
    L98:
        if (r45 == null) goto L100;
        long r212 = r45.c;
    L101:
        int r46 = r37.f;
        String r47 = r37.l;
        if (r47 != null) goto L104;
        String r213 = "";
    L105:
        com.bytedance.android.live.recharge.utils.m.n("RechargeCheckMethod", r116, "", r117, r44, r118, r212, r46, r213, r211, String.valueOf(r37.k), 2048);
        goto L106
    L104:
        r213 = r47;
        goto L105
    L100:
        r212 = -1;
        goto L101
    L97:
        r118 = -1;
    L93:
        r211 = "";
    L83:
        r210 = null;
        goto L84
    L80:
        r36 = 0;
    L72:
        r35 = null;
    L67:
        r115 = null;
        goto L68
    L113:
        JsonElement r48 = r32.get("account");     // Catch: JSONException -> L61
        if (r48 == null) goto L62;
        r33 = Integer.valueOf(r48.getAsInt());     // Catch: JSONException -> L61
        goto L63
    L56:
        r32 = null;
    L52:
        r113 = -1;
    L46:
        r112 = "";
        goto L47
    L39:
        r111 = r20;
        goto L40
    L35:
        r110 = false;
        goto L36
    L31:
        r18 = 0;
        goto L32
    L18:
        r10 = 0;
    L14:
        r7 = "";
    L9:
        r6 = r30.getContext();
        goto L10
    }

    public final void j(boolean r3, long r4, boolean r6) {
        RevenueRechargeCheckResultModel r0 = new RevenueRechargeCheckResultModel();
        r0.a(RevenueRechargeCheckResultModel.Code.Success);
        RevenueRechargeCheckResultModel.a r1 = new RevenueRechargeCheckResultModel.a();
        r1.b(Long.valueOf(r4));
        r1.setResult(Boolean.valueOf(r3));
        r1.a(Boolean.valueOf(r6));
        Unit r5 = Unit.INSTANCE;
        r0.b(r1);
        finishWithResult(r0);
    }
}
