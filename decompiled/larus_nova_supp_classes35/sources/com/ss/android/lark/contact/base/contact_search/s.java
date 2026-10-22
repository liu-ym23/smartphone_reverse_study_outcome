package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.window.layout.WindowMetricsCalculator;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.lark.contact.base.dependency.BaseContactThirdBizService;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.a1;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s extends fcc.c<s> {
    public boolean A;
    public boolean B;
    public final String l;
    public final String m;
    public final a n;
    public final boolean o;
    public final ApiUtils.a<Boolean> p;
    public LinearLayout q;
    public EditText r;
    public TextView s;
    public LinearLayout t;
    public TextView u;
    public EditText v;
    public TextView w;
    public TextView x;
    public ImageView y;
    public boolean z;

    public interface a {
        void a(String r1, boolean r2, boolean r3);
    }

    public final int e() {
        return 2131561564;
    }

    public final void l() {
        this.w.setText(this.v.getText());
        this.w.setVisibility(0);
        this.v.setVisibility(8);
        this.y.setEnabled(false);
    }

    public final void f() {
        super.f();
    }

    public static void k(final s r2) {
        Activity r0 = ViewUtils.getActivityByContext(((fcc.c) r2).a);
        if (r0 == null) goto L7;
        r2.z = true;
        super.f();
        ContactBaseModuleDependency.b.openCountrySelect(r0);
        boolean r1 = a1.f;
        a1.a.a.a(2131361935, new e(r2));
        return;
    }

    public final com.larksuite.component.ui.dialog.d d(com.larksuite.component.ui.dialog.d r2) {
        r2.f(1.0f);
        return r2;
    }

    public final void i(LKUIDialog r6) {
        if (r6.getWindow() != null) goto L5;
        return;
    L5:
        RelativeLayout r7 = (RelativeLayout) h(2131374904);
        LinearLayout r8 = (LinearLayout) h(2131374895);
        this.q = (LinearLayout) h(2131374896);
        this.r = (EditText) h(2131374901);
        this.s = (TextView) h(2131374900);
        this.t = (LinearLayout) h(2131374897);
        this.u = (TextView) h(2131374899);
        this.v = (EditText) h(2131374903);
        this.w = (TextView) h(2131374902);
        this.x = (TextView) h(2131374898);
        ImageView r9 = (ImageView) h(2131374905);
        this.y = r9;
        int r0 = 1;
        com.ss.android.lark.utils.q.b(new View[]{r9});
        String r10 = this.l.replace(" ", BuildConfig.FLAVOR);
        if (this.o == false) goto L8;
        this.x.setText(this.m);
        this.q.setVisibility(0);
        this.r.addTextChangedListener(new k(this));
        this.r.setText(this.l);
        this.r.setOnFocusChangeListener(new l(this));
        this.r.post(new m(this));
        this.r.setOnEditorActionListener(new n(this));
        this.s.setOnTouchListener(new o(this));
        this.y.setOnClickListener(new p(this));
    L25:
        ((fcc.c) this).h = new j(this);
        return;
    L8:
        this.x.setText(this.m);
        TextView r1 = this.u;
        View.OnClickListener r3 = new d(this);
        if (r1 == null) goto L12;
        r1.setOnClickListener(new com.ss.android.lark.inv.export.util.a(r3));
    L12:
        this.v.addTextChangedListener(new q(this));
        this.t.setVisibility(0);
        if (r10.startsWith("+") == false) goto L19;
        int r2 = h9b.d.a;
        Lazy r4 = BaseContactThirdBizService.a;
        if ((!((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand()) == true) goto L18;
        r0 = 86;
    L18:
        Pair<Integer, String> r11 = ContactMobileUtils.e(r0, r10);
        this.u.setText("+" + r11.first);
        this.v.setText((CharSequence) r11.second);
    L24:
        this.v.setOnFocusChangeListener(new r(this));
        this.v.post(new f(this));
        this.v.setOnEditorActionListener(new g(this));
        this.w.setOnTouchListener(new h(this));
        this.y.setOnClickListener(new i(this));
        goto L25
    L19:
        TextView r5 = this.u;
        int r12 = h9b.d.a;
        StringBuilder r13 = new StringBuilder("+");
        Lazy r14 = BaseContactThirdBizService.a;
        if ((!((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand()) == true) goto L23;
        r0 = 86;
    L23:
        r13.append(r0);
        r5.setText(r13.toString());
        this.v.setText(h9b.b.a(r10));
        goto L24
    }

    public final void m(Boolean r3) {
        this.w.setVisibility(8);
        this.v.setVisibility(0);
        this.y.setEnabled(r3.booleanValue());
    }

    public s(Context r3, String r4, String r5, a r6, ApiUtils.a<Boolean> r7) {
        boolean r0 = r4.contains("@");
        super(r3);
        this.B = false;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.p = r7;
        this.o = r0;
        ((fcc.c) this).j = true;
        if (Build.VERSION.SDK_INT < 29) goto L10;
        if (r3 == null) goto L10;
        Activity r8 = ViewUtils.getActivityByContext(r3);
        if (r8 == null) goto L10;
        int r9 = WindowMetricsCalculator.-CC.getOrCreate().computeCurrentWindowMetrics(r8).getBounds().height();
        Log.i("InviteExternalSearchNothingDrawerDialog", "screenHeight: " + r9);
        if (r9 <= 0) goto L10;
        int r10 = r9 - DeviceUtils.getStatusHeight(r3);
    L11:
        ((fcc.c) this).k = r10 - UIHelper.dp2px(64.0f);
        return;
    L10:
        r10 = DeviceUtils.getScreenHeight(r3);
        goto L11
    }
}
