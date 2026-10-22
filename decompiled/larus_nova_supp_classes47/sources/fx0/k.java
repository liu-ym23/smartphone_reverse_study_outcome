package fx0;

import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.OpenRechargeDialogResultModel;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.sc;
import w20.t4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends t4<sc, OpenRechargeDialogResultModel> {
    public boolean a;
    public String b;
    public WeakReference<Context> c;
    public final a d;

    public static final class a implements com.bytedance.android.live.recharge.k.a {
        public final /* synthetic */ k a;

        @Override // com.bytedance.android.live.recharge.k.a
        public final /* synthetic */ void a() {
        }

        public a(k r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.recharge.k.a
        public final void b(int r4, int r5, long r6) {
            k r7 = this.a;
            boolean r1 = false;
            if (r7.a == true) goto L5;
            if (r4 == 1) goto L16;
            OpenRechargeDialogResultModel r8 = new OpenRechargeDialogResultModel();
            OpenRechargeDialogResultModel.a r9 = new OpenRechargeDialogResultModel.a();
            r9.b(String.valueOf(0));
            Unit r10 = Unit.INSTANCE;
            r8.a(r9);
            r7.finishWithResult(r8);
            return;
        L16:
            OpenRechargeDialogResultModel r12 = new OpenRechargeDialogResultModel();
            OpenRechargeDialogResultModel.a r0 = new OpenRechargeDialogResultModel.a();
            r0.b(String.valueOf(1));
            r0.a(Long.valueOf(r6));
            Unit r13 = Unit.INSTANCE;
            r12.a(r0);
            r7.finishWithResult(r12);
            return;
        L5:
            if (r7.b.length() <= 0) goto L7;
            r1 = true;
        L7:
            if (r1 == false) goto L18;
            WeakReference<Context> r14 = this.a.c;
            if (r14 == null) goto L19;
            Context r15 = r14.get();
            if (r15 == null) goto L20;
            ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(r15, this.a.b);
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    public final void onTerminate() {
        this.a = true;
    }

    public k() {
        this.b = "";
        this.d = new a(this);
    }

    public final void invoke(Object r24, CallContext r25) {
        sc r1 = (sc) r24;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r25, "context");
        String r2 = r1.c();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        this.b = r2;
        com.bytedance.android.live.revenue.core.util.j.a r5 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r6 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r5.a(), yz0.k.class);
        if (r6 == null) goto L9;
        Context r7 = r6.getContext();
        if (r7 == null) goto L9;
    L10:
        this.c = new WeakReference(r7);
        f80.b r3 = com.bytedance.android.live.revenue.core.util.f.d(r5.a(), yz0.k.class);
        int r8 = 0;
        if (r3 == null) goto L13;
        boolean r9 = true;
    L14:
        String r4 = r1.h();
        if (r4 != null) goto L17;
        String r10 = "";
    L18:
        Integer r12 = r1.i();
        int r13 = -1;
        if (r12 == null) goto L21;
        int r15 = r12.intValue();
    L22:
        Integer r14 = r1.b();
        if (r14 == null) goto L25;
        int r16 = r14.intValue();
    L26:
        String r17 = r1.d();
        if (r17 != null) goto L29;
        String r18 = "";
    L30:
        Integer r19 = r1.f();
        if (r19 == null) goto L33;
        long r110 = r19.intValue();
    L34:
        Integer r20 = r1.a();
        if (r20 == null) goto L37;
        r13 = r20.intValue();
    L37:
        String r22 = r1.e();
        if (r22 != null) goto L40;
        r22 = "";
    L40:
        Integer r23 = r1.g();
        if (r23 == null) goto L43;
        r8 = r23.intValue();
    L43:
        com.bytedance.android.live.recharge.model.d r26 = new com.bytedance.android.live.recharge.model.d(r9, r18, r10, r110, false, r16, r15, null, null, null, new com.bytedance.android.live.recharge.model.f(r13, r22, r8), null, null, 31632);
        IRechargeService r27 = (IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class);
        WeakReference<Context> r28 = this.c;
        if (r28 == null) goto L46;
        Context r29 = r28.get();
    L47:
        r27.showRechargeDialogFragment(r29, r26, this.d);
        CallContext r30 = getCallContext();
        if (r30 == null) goto L55;
        String r32 = r30.b;
        if (r32 == null) goto L55;
        String r33 = UriProtector.parse(r32).getPath();
        if (r33 == null) goto L55;
        String r111 = r33;
    L56:
        int r34 = com.bytedance.android.live.recharge.utils.m.a;
        String r35 = r26.c;
        String r36 = r26.b;
        long r37 = r26.d;
        com.bytedance.android.live.recharge.model.b r38 = r26.j;
        long r112 = -1;
        if (r38 == null) goto L59;
        long r113 = r38.e;
    L60:
        if (r38 == null) goto L62;
        r112 = r38.c;
    L62:
        long r114 = r112;
        int r39 = r26.f;
        String r40 = r26.l;
        if (r40 != null) goto L65;
        r40 = "";
    L65:
        com.bytedance.android.live.recharge.utils.m.n("OpenRechargeDialogMethod", r35, "", r36, r37, r113, r114, r39, r40, r111, null, 3072);
        return;
    L59:
        r113 = -1;
    L55:
        r111 = "";
        goto L56
    L46:
        r29 = null;
        goto L47
    L33:
        r110 = 0;
        goto L34
    L29:
        r18 = r17;
        goto L30
    L25:
        r16 = -1;
        goto L26
    L21:
        r15 = -1;
        goto L22
    L17:
        r10 = r4;
        goto L18
    L13:
        r9 = false;
    L9:
        r7 = r25.getContext();
        goto L10
    }
}
