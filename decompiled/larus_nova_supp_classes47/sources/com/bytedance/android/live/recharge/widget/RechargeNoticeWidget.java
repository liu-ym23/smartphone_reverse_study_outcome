package com.bytedance.android.live.recharge.widget;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.r0;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.s0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeNoticeWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeNoticeWidget extends AbsRechargeWidget {
    public View i;
    public TextView j;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RechargeNoticeWidget a;
        public final /* synthetic */ com.bytedance.android.live.recharge.model.e b;

        public c(RechargeNoticeWidget r1, com.bytedance.android.live.recharge.model.e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            com.bytedance.tools.kcp.spongepreference.runtime.a r8 = r0.b;
            KProperty[] r0 = r0.a;
            HashMap r2 = (HashMap) r8.getValue(null, r0[0]);
            r2.put("sp_panel_last_open_date_long_key", Long.valueOf(new Date().getTime()));
            r2.put("sp_notice_show_times_int_key", Long.valueOf(this.b.a()));
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r8.setValue(null, r0[0], r2);
            this.a.h.getCloseNoticeEvent().onNext(Unit.INSTANCE);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567271;
    }

    public final void onUnload() {
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r2) {
        Intrinsics.checkNotNullParameter(r2, "dealSet");
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r1) {
    }

    public RechargeNoticeWidget(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onInit(Object[] r3) {
        View r4 = findViewById(2131366980);
        this.i = r4;
        Resources r0 = ((Widget) this).context.getResources();
        if (r0 == null) goto L5;
        String r1 = r0.getString(2131918650);
    L6:
        r3.c(r4, r1, true);
        this.j = (TextView) findViewById(2131381026);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onLoad(Object[] r20) {
        com.bytedance.android.live.recharge.model.e r1 = (com.bytedance.android.live.recharge.model.e) com.bytedance.android.live.recharge.util.g.g.getValue(null, com.bytedance.android.live.recharge.util.g.a[5]);
        View r2 = ((Widget) this).contentView;
        if (r1.d() == false) goto L33;
        com.bytedance.tools.kcp.spongepreference.runtime.a r4 = r0.b;
        KProperty[] r6 = r0.a;
        HashMap r7 = (HashMap) r4.getValue(null, r6[0]);
        Long r9 = (Long) r7.get("sp_panel_open_times_key");
        if (r9 == null) goto L8;
        int r10 = (int) r9.longValue();
    L9:
        int r12 = r10 + 1;
        Long r13 = (Long) r7.get("sp_panel_last_open_date_long_key");
        if (r13 != null) goto L12;
        r13 = 0L;
    L12:
        long r3 = r13.longValue();
        Long r16 = (Long) r7.get("sp_notice_show_times_int_key");
        if (r16 != null) goto L15;
        r16 = 0L;
    L15:
        long r17 = r16.longValue();
        if (s0.c(new u0(r3)) == true) goto L18;
        r12 = 1;
        long r14 = 0;
    L19:
        int r5 = r1.c();
        int r8 = r1.b();
        if (r14 >= r5) goto L22;
    L27:
        r14 = r14 + 1;
        boolean r15 = true;
    L28:
        r7.put("sp_panel_open_times_key", Long.valueOf(r12));
        r7.put("sp_panel_last_open_date_long_key", Long.valueOf(new Date().getTime()));
        r7.put("sp_notice_show_times_int_key", Long.valueOf(r14));
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r4.setValue(null, r6[0], r7);
        if (r15 == false) goto L33;
        if (r14 > r1.a()) goto L33;
        boolean r18 = true;
    L34:
        ViewUtilsKt.g(r2, r18);
        TextView r19 = this.j;
        if (r19 == null) goto L37;
        r19.setText(r1.e());
    L37:
        ((Widget) this).contentView.setOnClickListener(b.a);
        View r22 = this.i;
        if (r22 == null) goto L41;
        r22.setOnClickListener(new c(this, r1));
        return;
    L41:
        return;
    L22:
        if (r12 > (r5 + r8)) goto L24;
    L26:
        r15 = false;
        goto L28
    L24:
        if (((r12 - r5) % (r8 + 1)) != 0) goto L26;
    L18:
        r14 = r17;
        goto L19
    L8:
        r10 = 0;
    L33:
        r18 = false;
        goto L34
    }
}
