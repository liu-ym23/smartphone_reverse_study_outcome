package uy1;

import com.bytedance.android.anya.internal.MVIBindingImpl;
import com.bytedance.android.anya.q;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentFacade;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.livesdk.gift.grouplive.component.m;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.l;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.revenue.service.ui.a {
    public final /* synthetic */ e a;
    public final /* synthetic */ vy1.a b;

    public final void onCreate() {
    }

    public final void onHide() {
    }

    public final void onDestroy() {
        e r0 = this.a;
        r0.d = null;
        q r1 = r0.a;
        if (r1 == null) goto L5;
        r1.unbind();
    L5:
        e r2 = this.a;
        j r3 = r2.b;
        if (r3 != null) goto L8;
    L13:
        r2.b = null;
        return;
    L8:
        if (l.b(r3) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
        l.c(r3);
        goto L13
    }

    public final void onShow() {
        e r0 = this.a;
        k r1 = r0.g;
        MVIBindingImpl r3 = null;
        if (l.b(r1) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L27;
        m r2 = new m(r0.g);
        Intrinsics.checkNotNullParameter(r2, "scope");
        Object r4 = e33.k.a;
        if (r2.e != r4) goto L11;
        String r5 = "context";
    L23:
        if (r5 != null) goto L26;
        l.a(r2);
        Unit r6 = Unit.INSTANCE;
        r0.b = r2;
        goto L27
    L26:
        throw new UninitializedPropertyAccessException(r5);
    L11:
        if (r2.f != r4) goto L14;
        r5 = "dataCenter";
        goto L23
    L14:
        if (r2.g != r4) goto L17;
        r5 = "isInLive";
        goto L23
    L17:
        if (r2.h != r4) goto L20;
        r5 = "roomContext";
        goto L23
    L20:
        if (r2.i != r4) goto L22;
        r5 = "roomInstance";
        goto L23
    L22:
        r5 = null;
    L27:
        e r7 = this.a;
        m r8 = r7.b;
        if (r8 == null) goto L30;
        GroupComponentFacade r9 = (GroupComponentFacade) com.bytedance.android.scope.m.e.d(r8, GroupComponentFacade.class);
    L31:
        r7.c = r9;
        e r10 = this.a;
        GroupComponentFacade r11 = r10.c;
        if (r11 == null) goto L34;
        r3 = r11.c(this.b, com.bytedance.android.livesdk.gift.grouplive.component.viewmodel.a.class);
    L34:
        r10.a = r3;
        q r13 = this.a.a;
        if (r13 == null) goto L38;
        r13.a();
        return;
    L38:
        return;
    L30:
        r9 = null;
        goto L31
    }

    public a(e r1, vy1.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
