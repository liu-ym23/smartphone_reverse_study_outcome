package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.bytedance.android.live.browser.jsbridge.base.AlertCheckDialogResultModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "alertCheckDialog")
public final class h0 extends w20.g<w20.l7, AlertCheckDialogResultModel> {
    public boolean a;
    public boolean b;

    public h0() {
    }

    public static final void j(h0 r3) {
        r3.getClass();
        AlertCheckDialogResultModel r0 = new AlertCheckDialogResultModel();
        r0.a(AlertCheckDialogResultModel.Code.Success);
        AlertCheckDialogResultModel.a r1 = new AlertCheckDialogResultModel.a();
        r1.c(Boolean.FALSE);
        r1.a(Boolean.TRUE);
        r1.b(Boolean.valueOf(r3.a));
        Unit r2 = Unit.INSTANCE;
        r0.b(r1);
        r3.finishWithResult(r0);
        r3.b = true;
    }

    public final void invoke(Object r11, CallContext r12) {
        w20.l7 r13 = (w20.l7) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callcontext");
        boolean r1 = false;
        this.a = false;
        this.b = false;
        Context r14 = r12.getContext();
        Intrinsics.checkNotNullParameter(r13, "params");
        if (r14 == null) goto L50;
        View r0 = LayoutInflater.from(r14).inflate(2131565370, null);
        TextView r2 = (TextView) r0.findViewById(2131362501);
        TextView r3 = (TextView) r0.findViewById(2131362500);
        View r4 = r0.findViewById(2131362497);
        ToggleButton r5 = (ToggleButton) r0.findViewById(2131362499);
        TextView r6 = (TextView) r0.findViewById(2131362498);
        if (r13.f() == null) goto L16;
        String r7 = r13.f();
        if (r7 == null) goto L16;
        if (r7.length() <= 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 != true) goto L16;
        UtilityKotlinExtentionsKt.w(r2);
        r2.setText(r13.f());
        goto L16
    L12:
        r8 = false;
    L16:
        if (r13.d() == null) goto L26;
        String r9 = r13.d();
        if (r9 == null) goto L26;
        if (r9.length() <= 0) goto L22;
        boolean r15 = true;
    L23:
        if (r15 != true) goto L26;
        UtilityKotlinExtentionsKt.w(r3);
        r3.setText(r13.d());
        goto L26
    L22:
        r15 = false;
    L26:
        if (r13.b() == null) goto L39;
        String r16 = r13.b();
        if (r16 == null) goto L39;
        if (r16.length() <= 0) goto L32;
        boolean r17 = true;
    L33:
        if (r17 != true) goto L39;
        UtilityKotlinExtentionsKt.w(r4);
        r6.setText(r13.b());
        Boolean r18 = r13.e();
        if (r18 == null) goto L37;
        boolean r19 = r18.booleanValue();
    L38:
        this.a = r19;
        r5.setChecked(r19);
        r5.setOnCheckedChangeListener(new d0(this, r0));
        goto L39
    L37:
        r19 = false;
        goto L38
    L32:
        r17 = false;
    L39:
        ArrayList r21 = new ArrayList();
        if (r13.a() == null) goto L48;
        String r22 = r13.a();
        if (r22 == null) goto L48;
        if (r22.length() <= 0) goto L46;
        r1 = true;
    L46:
        if (r1 != true) goto L48;
        lm3.c r23 = new lm3.c();
        r23.b = r13.a();
        r23.c = new e0(this);
        r21.add(r23);
    L48:
        lm3.c r24 = new lm3.c();
        r24.b = r13.c();
        r24.c = new f0(this);
        r21.add(r24);
        lm3.d.a r110 = new lm3.d.a(r14);
        r110.d = r0;
        r110.e = r21;
        r110.a().setOnDismissListener(new g0(this));
        return;
    }
}
