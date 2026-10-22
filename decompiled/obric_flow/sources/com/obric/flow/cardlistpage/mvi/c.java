package com.obric.flow.cardlistpage.mvi;

import android.text.TextUtils;
import cn.nubia.neopush.commons.Constant;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.popupdialog.l;
import com.obric.flow.cardlistpage.ui.component.popupdialog.o;
import com.obric.flow.cardlistpage.ui.component.popupdialog.q;
import com.obric.flow.cardlistpage.ui.component.popupdialog.r;
import com.obric.flow.cardlistpage.ui.component.popupdialog.s;
import com.obric.flow.cardlistpage.ui.component.popupdialog.u;
import com.obric.flow.cardlistpage.ui.component.popupdialog.w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import m.f0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f11533c;

    public c(a5.c r5) {
        this.f11531a = r5;
    }

    public abstract a5.d a();

    public a5.d b(String r10) {
    L9:
        th = move-exception;
        mn.h.g("startup_handle", th);
        return null;
    L3:
        if (new JSONObject(r10).optInt("errno", 0) != 200) goto L18;
        d5.b.c("ISettingRequestService", "monitor setting request: succeeded");     // Catch: Throwable -> L9
        String r5 = ((a5.c) this.f11531a).e;     // Catch: Throwable -> L9
        a5.d r11 = f0.b(r10);     // Catch: Throwable -> L9
        com.bytedance.android.monitorV2.constant.a.d("monitor_setting_response", r10);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L11:
        this.f11533c = r10;     // Catch: Throwable -> L9
        this.f11532b = r11;     // Catch: Throwable -> L9
        return r11;
    L7:
        if ("0".equals(r5) == true) goto L11;
        com.bytedance.android.monitorV2.constant.a.c("monitor_setting_response_fetch_time", System.currentTimeMillis() / 1000);     // Catch: Throwable -> L9
        goto L11
    L18:
        return null;
    }

    public a5.d c() {
    L15:
        th = move-exception;
        Throwable th2 = th;
        a5.d r5 = null;
    L17:
        mn.h.g("startup_handle", th2);
        return r5;
    L4:
        if (TextUtils.isEmpty((String) this.f11533c) == false) goto L7;
        return null;
    L7:
        if (((a5.d) this.f11532b) != null) goto L9;
        return null;
    L9:
        a5.d r10 = f0.k((String) this.f11533c);     // Catch: Throwable -> L15
        r5 = (a5.d) this.f11532b;     // Catch: Throwable -> L15
        r5.f106a = r10.f106a;     // Catch: Throwable -> L12
        return r5;
    L12:
        th2 = th;
        goto L17
    }

    public void d(j r5) {
        Intrinsics.checkNotNullParameter(r5, "intent");
        ((a) this.f11531a).a(r5);
    }

    public void e(f r18) {
        Intrinsics.checkNotNullParameter(r18, "action");
        CardFeedLayout r5 = (CardFeedLayout) this.f11533c;
        Intrinsics.checkNotNullParameter(r18, "action");
        MviLogLevel r10 = h.f11535a;
        Intrinsics.checkNotNullParameter(r18, "action");
        String r11 = r18.a();
        if (r11 != null) goto L5;
        r11 = r18.toString();
    L5:
        h.a(r18.b(), "[" + r18.getClass().getSimpleName() + "] Action: " + r11);
        Intrinsics.checkNotNullParameter(r18, "action");
        boolean r12 = r18 instanceof com.obric.flow.cardlistpage.ui.component.floatingbtn.c;
        hq.h r13 = hq.e.f17363a;
        if (r12 == false) goto L14;
        com.obric.flow.cardlistpage.ui.component.floatingbtn.c r14 = (com.obric.flow.cardlistpage.ui.component.floatingbtn.c) r18;
        if (Intrinsics.areEqual(r14, com.obric.flow.cardlistpage.ui.component.floatingbtn.a.f11631a) == false) goto L11;
        r5.k(r13);
        return;
    L11:
        if (Intrinsics.areEqual(r14, com.obric.flow.cardlistpage.ui.component.floatingbtn.b.f11632a) == false) goto L75;
        r5.k(hq.c.f17360a);
        return;
    L75:
        return;
    L14:
        if ((r18 instanceof com.obric.flow.cardlistpage.ui.component.search.a) == false) goto L19;
        if (Intrinsics.areEqual((com.obric.flow.cardlistpage.ui.component.search.a) r18, com.obric.flow.cardlistpage.ui.component.search.a.f11752a) == false) goto L77;
        r5.k(hq.b.f17359a);
        return;
    L77:
        return;
    L19:
        if ((r18 instanceof l) == false) goto L42;
        l r15 = (l) r18;
        int r16 = r5.getLeft();
        int r17 = r5.getTop();
        int r19 = r5.getRight();
        int r110 = r5.getBottom();
        com.obric.flow.cardlistpage.ui.j r20 = new com.obric.flow.cardlistpage.ui.j(r16, r17, r19, r110);
        Intrinsics.checkNotNullParameter(r15, "action");
        Intrinsics.checkNotNullParameter(r20, "dismissGestureBounds");
        if (Intrinsics.areEqual(r15, com.obric.flow.cardlistpage.ui.component.popupdialog.k.f11737a) == false) goto L24;
        r13 = new hq.g(Constant.ClientMessageType.SHOW, 0, 0, 0, 0);
    L38:
        r5.k(r13);
        return;
    L24:
        if (Intrinsics.areEqual(r15, com.obric.flow.cardlistpage.ui.component.popupdialog.i.f11734a) == false) goto L27;
        r13 = new hq.g("dismiss", r16, r17, r19, r110);
        goto L38
    L27:
        if (Intrinsics.areEqual(r15, com.obric.flow.cardlistpage.ui.component.popupdialog.f.f11729a) == true) goto L38;
        if ((r15 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.g) == false) goto L33;
        com.obric.flow.cardlistpage.ui.component.popupdialog.g r21 = (com.obric.flow.cardlistpage.ui.component.popupdialog.g) r15;
        r13 = new hq.d(r21.f11730a, r21.f11731b);
        goto L38
    L33:
        if ((r15 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.h) == false) goto L36;
        com.obric.flow.cardlistpage.ui.component.popupdialog.h r22 = (com.obric.flow.cardlistpage.ui.component.popupdialog.h) r15;
        r13 = new hq.f(r22.f11732a, r22.f11733b);
        goto L38
    L36:
        if ((r15 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.j) == false) goto L40;
        com.obric.flow.cardlistpage.ui.component.popupdialog.j r23 = (com.obric.flow.cardlistpage.ui.component.popupdialog.j) r15;
        r13 = new hq.a(r23.f11735a, r23.f11736b);
        goto L38
    L40:
        throw new NoWhenBranchMatchedException();
    L42:
        if ((r18 instanceof com.obric.flow.cardlistpage.ui.component.feedlist.e) == false) goto L80;
        com.obric.flow.cardlistpage.ui.component.feedlist.e r24 = (com.obric.flow.cardlistpage.ui.component.feedlist.e) r18;
        Intrinsics.checkNotNullParameter(r24, "action");
        boolean r25 = r24 instanceof com.obric.flow.cardlistpage.ui.component.feedlist.b;
        boolean r26 = true;
        if (r25 == false) goto L46;
        boolean r27 = true;
    L47:
        if (r27 == false) goto L49;
        boolean r28 = true;
    L50:
        com.obric.flow.cardlistpage.ui.component.feedlist.c r29 = com.obric.flow.cardlistpage.ui.component.feedlist.c.f11580a;
        if (r28 == true) goto L54;
        r26 = Intrinsics.areEqual(r24, r29);
    L54:
        if (r26 == false) goto L73;
        Intrinsics.checkNotNullParameter(r24, "action");
        if ((r24 instanceof com.obric.flow.cardlistpage.ui.component.feedlist.d) == false) goto L59;
        w r30 = new u(((com.obric.flow.cardlistpage.ui.component.feedlist.d) r24).f11581a);
    L66:
        o r31 = r5.D;
        if (r31 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("popupDialogComponent");
        r31 = null;
    L69:
        r31.k(r30);
        return;
    L59:
        if (Intrinsics.areEqual(r24, r29) == false) goto L61;
        r30 = q.f11741a;
        goto L66
    L61:
        if (r25 == false) goto L64;
        r30 = new s(((com.obric.flow.cardlistpage.ui.component.feedlist.b) r24).f11579a);
        goto L66
    L64:
        if ((r24 instanceof com.obric.flow.cardlistpage.ui.component.feedlist.a) == false) goto L71;
        r30 = new r(((com.obric.flow.cardlistpage.ui.component.feedlist.a) r24).f11578a);
        goto L66
    L71:
        throw new NoWhenBranchMatchedException();
    L73:
        throw new NoWhenBranchMatchedException();
    L49:
        r28 = r24 instanceof com.obric.flow.cardlistpage.ui.component.feedlist.d;
        goto L50
    L46:
        r27 = r24 instanceof com.obric.flow.cardlistpage.ui.component.feedlist.a;
        goto L47
    }

    public void f(e r10) {
        Intrinsics.checkNotNullParameter(r10, Constant.COMMAND);
        String r5 = ((a) this.f11531a).getClass().getSimpleName();
        MviLogLevel r11 = h.f11535a;
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "storeName");
        Intrinsics.checkNotNullParameter(r10, Constant.COMMAND);
        String r12 = r10.a();
        if (r12 != null) goto L5;
        r12 = r10.toString();
    L5:
        h.a(r10.b(), "[" + r5 + "] Command: " + r12);
        g(r10);
    }

    public abstract void g(e r5);

    public abstract void h();

    public void i() {
        h();
        j();
    }

    public abstract void j();

    public c(a r5, CoroutineScope r10, CardFeedLayout r11) {
        Intrinsics.checkNotNullParameter(r5, "store");
        Intrinsics.checkNotNullParameter(r10, "coroutineScope");
        Intrinsics.checkNotNullParameter(r11, "parent");
        this.f11531a = r5;
        this.f11532b = r10;
        this.f11533c = r11;
    }
}
