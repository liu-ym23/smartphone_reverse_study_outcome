package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/MultiLinkSelfAnchorMicDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkSelfAnchorMicDialog extends CommonBottomDialog {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final int b;
    public final w c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MultiLinkSelfAnchorMicDialog a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public b(MultiLinkSelfAnchorMicDialog r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(MultiLinkSelfAnchorMicDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            com.bytedance.android.live.revlink.impl.multianchor.utils.q r7 = com.bytedance.android.live.revlink.impl.global.b.v();
            if (r7 != null) goto L5;
        L9:
            p21.b r8 = com.bytedance.android.live.revlink.impl.global.b.A();
            boolean r1 = false;
            if (r8 != null) goto L12;
        L15:
            p21.b r9 = com.bytedance.android.live.revlink.impl.global.b.A();
            if (r9 != null) goto L18;
        L21:
            w r10 = this.a.c;
            if (r10 != null) goto L24;
        L27:
            p21.b r12 = com.bytedance.android.live.revlink.impl.global.b.A();
            if (r12 == null) goto L40;
            com.bytedance.android.live.revlink.impl.multianchor.utils.w r13 = r12.e();
            if (r13 == null) goto L32;
            int r14 = r13.i();
        L34:
            if (p21.b.d(r14) == false) goto L38;
            y41.d r15 = y41.d.j;
            r15.getClass();
            if (((Boolean) y41.d.f.getValue(r15, y41.d.a[4])).booleanValue() == false) goto L38;
            r1 = true;
        L38:
            if (r1 != true) goto L40;
        L43:
            MultiLinkSelfAnchorMicDialog r16 = this.a;
            w r2 = r16.c;
            if (r2 == null) goto L46;
            r2.A5(r16.a, true ^ this.b);
        L46:
            a(this.a);
            return;
        L32:
            r14 = 0;
        L40:
            if (this.a.M0() == true) goto L43;
            a(this.a);
            return;
        L24:
            if (r10.x5(null) != true) goto L27;
            ToastUtil.a(2131920541, 0);
            a(this.a);
            return;
        L18:
            if (r9.c() != true) goto L21;
            int r17 = ToastUtil.a;
            com.bytedance.live.kmp.util.c r18 = com.bytedance.live.kmp.util.c.a;
            int r19 = w11.a.a;
            ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131920542, new Object[0]), 0);
            a(this.a);
            return;
        L12:
            if (r8.b() != true) goto L15;
            int r20 = ToastUtil.a;
            com.bytedance.live.kmp.util.c r22 = com.bytedance.live.kmp.util.c.a;
            int r23 = w11.a.a;
            ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131920567, new Object[0]), 0);
            a(this.a);
            return;
        L5:
            if (this.b == false) goto L7;
            String r0 = "average";
        L8:
            r7.t(r0, this.c);
            goto L9
        L7:
            r0 = "enlarge";
            goto L8
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MultiLinkSelfAnchorMicDialog a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public c(MultiLinkSelfAnchorMicDialog r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(MultiLinkSelfAnchorMicDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            p21.b r5 = com.bytedance.android.live.revlink.impl.global.b.A();
            if (r5 != null) goto L5;
        L8:
            p21.b r6 = com.bytedance.android.live.revlink.impl.global.b.A();
            if (r6 != null) goto L11;
        L14:
            MultiLinkSelfAnchorMicDialog r7 = this.a;
            int r0 = MultiLinkSelfAnchorMicDialog.d;
            if (r7.N0() == false) goto L35;
            p21.b r8 = com.bytedance.android.live.revlink.impl.global.b.A();
            if (r8 == null) goto L21;
            if (r8.f() != true) goto L21;
        L23:
            com.bytedance.android.live.revlink.impl.multianchor.utils.q r9 = com.bytedance.android.live.revlink.impl.global.b.v();
            if (r9 != null) goto L26;
        L30:
            MultiLinkSelfAnchorMicDialog r10 = this.a;
            w r1 = r10.c;
            if (r1 == null) goto L33;
            r1.P4(r10.a, true ^ this.b);
        L33:
            a(this.a);
            return;
        L26:
            if (this.b == false) goto L28;
            String r2 = "average_all";
        L29:
            r9.t(r2, this.c);
            goto L30
        L28:
            r2 = "enlarge_all";
        L21:
            if (this.a.M0() == true) goto L23;
        L35:
            a(this.a);
            return;
        L11:
            if (r6.c() != true) goto L14;
            int r12 = ToastUtil.a;
            com.bytedance.live.kmp.util.c r13 = com.bytedance.live.kmp.util.c.a;
            int r14 = w11.a.a;
            ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131920540, new Object[0]), 0);
            a(this.a);
            return;
        L5:
            if (r5.b() != true) goto L8;
            int r15 = ToastUtil.a;
            com.bytedance.live.kmp.util.c r16 = com.bytedance.live.kmp.util.c.a;
            int r17 = w11.a.a;
            ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131920567, new Object[0]), 0);
            a(this.a);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MultiLinkSelfAnchorMicDialog a;
        public final /* synthetic */ String b;

        public d(MultiLinkSelfAnchorMicDialog r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.live.revlink.impl.multianchor.utils.q r5 = com.bytedance.android.live.revlink.impl.global.b.v();
            if (r5 == null) goto L5;
            r5.t("cancel", this.b);
        L5:
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r1 == null) goto L19;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L8:
            if (Looper.myLooper() == r0.getLooper()) goto L10;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567013;
    }

    public final boolean N0() {
        if (this.b == 7) goto L17;
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 != null) goto L8;
    L10:
        w31.c r1 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r1 != null) goto L13;
    L15:
        return false;
    L13:
        if (r1.e() != true) goto L15;
        return true;
    L8:
        if (r0.q() != true) goto L10;
        return com.bytedance.android.live.revlink.impl.multianchor.utils.y.e();
    L17:
        return com.bytedance.android.live.revlink.impl.multianchor.utils.y.e();
    }

    public final boolean M0() {
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r0 = com.bytedance.android.live.revlink.impl.global.b.c();
        if (r0 != null) goto L5;
    L6:
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r1 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r1 == null) goto L10;
        UILayout r2 = r1.b();
        if (r2 == null) goto L10;
    L12:
        if (r2 == UILayout.FULL) goto L17;
        return false;
    L17:
        return true;
    L10:
        r2 = UILayout.Normal;
        goto L12
    L5:
        if (r0.a() != true) goto L6;
        return true;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        w r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        w r3 = this.c;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        TextView r5 = (TextView) findViewById(2131389544);
        if (r5 == null) goto L20;
        if (r2 == false) goto L18;
        int r6 = 2131920536;
    L19:
        r5.setText(s1.B(r6));
        goto L20
    L18:
        r6 = 2131920539;
    L20:
        TextView r7 = (TextView) findViewById(2131389543);
        if (r7 == null) goto L27;
        if (r4 == false) goto L24;
        int r8 = 2131920535;
    L25:
        r7.setText(s1.B(r8));
        goto L27
    L24:
        r8 = 2131920538;
    L27:
        if (N0() == false) goto L35;
        p21.b r9 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r9 == null) goto L33;
        if (r9.f() != true) goto L33;
    L34:
        boolean r10 = true;
    L36:
        if (r10 == false) goto L40;
        TextView r12 = (TextView) findViewById(2131389543);
        if (r12 == null) goto L40;
        UtilityKotlinExtentionsKt.z(r12, true);
    L40:
        p21.b r13 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r13 == null) goto L54;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r14 = r13.e();
        if (r14 == null) goto L45;
        int r15 = r14.i();
    L47:
        if (p21.b.d(r15) == false) goto L51;
        y41.d r16 = y41.d.j;
        r16.getClass();
        if (((Boolean) y41.d.f.getValue(r16, y41.d.a[4])).booleanValue() == false) goto L51;
        boolean r17 = true;
    L52:
        if (r17 != true) goto L54;
    L57:
        if (N0() == false) goto L61;
        if (r4 == false) goto L61;
    L62:
        if (r1 == false) goto L66;
        TextView r18 = (TextView) findViewById(2131389544);
        if (r18 == null) goto L66;
        UtilityKotlinExtentionsKt.z(r18, true);
    L66:
        TextView r19 = (TextView) findViewById(2131389544);
        float r20 = 0.4f;
        if (r19 == null) goto L79;
        p21.b r110 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r110 != null) goto L71;
    L72:
        p21.b r111 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r111 != null) goto L75;
    L77:
        float r112 = 1.0f;
    L78:
        r19.setAlpha(r112);
        goto L79
    L75:
        if (r111.c() != true) goto L77;
    L76:
        r112 = 0.4f;
        goto L78
    L71:
        if (r110.b() == true) goto L76;
    L79:
        TextView r22 = (TextView) findViewById(2131389543);
        if (r22 == null) goto L92;
        p21.b r113 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r113 != null) goto L84;
    L85:
        p21.b r114 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r114 != null) goto L88;
    L90:
        r20 = 1.0f;
    L91:
        r22.setAlpha(r20);
        goto L92
    L88:
        if (r114.c() != true) goto L90;
    L84:
        if (r113.b() == true) goto L91;
    L92:
        String r23 = "";
        Long r24 = null;
        if (r2 == true) goto L104;
        if (r4 == true) goto L104;
        w r25 = this.c;
        if (r25 == null) goto L99;
        UILayout r26 = r25.B5();
    L101:
        if (r26 != UILayout.FULL) goto L103;
        String r27 = "connection_mini_window";
    L105:
        TextView r28 = (TextView) findViewById(2131389544);
        if (r28 == null) goto L108;
        r28.setOnClickListener(new b(this, r2, r27));
    L108:
        TextView r29 = (TextView) findViewById(2131389543);
        if (r29 == null) goto L111;
        r29.setOnClickListener(new c(this, r4, r27));
    L111:
        TextView r30 = (TextView) findViewById(2131389670);
        if (r30 == null) goto L114;
        r30.setOnClickListener(new d(this, r27));
    L114:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r32 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r32 != null) goto L117;
        return;
    L117:
        if (r1 == true) goto L119;
        String r33 = "";
    L122:
        if (r10 == false) goto L127;
        if (r4 == false) goto L126;
        r23 = "average";
        goto L127
    L126:
        r23 = "enlarge";
    L127:
        Intrinsics.checkNotNullParameter(r33, "selfControlType");
        Intrinsics.checkNotNullParameter(r23, "allControlType");
        Intrinsics.checkNotNullParameter(r27, "source");
        LinkedHashMap r34 = new LinkedHashMap();
        w31.c r35 = r32.k();
        if (r35 == null) goto L130;
        Map<String, String> r36 = r35.f();
    L131:
        r34.putAll(r36);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r37 = r32.g();
        if (r37 == null) goto L134;
        Long r38 = Long.valueOf(r37.a());
    L135:
        r34.put("channel_id", String.valueOf(r38));
        w31.c r39 = r32.k();
        if (r39 == null) goto L138;
        r24 = Long.valueOf(r39.i());
    L138:
        r34.put("pk_id", String.valueOf(r24));
        d31.d r40 = r32.m();
        if (r40 == null) goto L141;
        r40.r(r34);
    L141:
        r34.put("connection_anchor_cnt", r32.b());
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r42 = r32.i();
        if (r42 != null) goto L144;
    L146:
        String r43 = DataType.FALSE;
    L147:
        r34.put("is_manager", r43);
        r34.put("self_control_type", r33);
        r34.put("all_control_type", r23);
        r34.put("source", r27);
        mz0.n r44 = new mz0.n();
        Map<String, String> r45 = r44.a;
        Intrinsics.checkNotNullParameter(r45, "map");
        Intrinsics.checkNotNullParameter(r34, "map");
        r45.putAll(r34);
        mz0.m r46 = new mz0.m();
        r46.b(LogCommon.ROOM);
        ((ArrayList) r44.b).addAll(r46.a);
        cy0.e.a.getClass();
        cy0.j r47 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r48 = com.bytedance.android.scope.m.b(r47).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r48);
        ((mz0.i) ((f80.a) r48)).w3("livesdk_connection_self_manage_banner_show", r44.a, r44.b);
        return;
    L144:
        if (com.bytedance.android.live.revlink.impl.multianchor.utils.w.f(r42) != true) goto L146;
        r43 = DataType.TRUE;
        goto L147
    L134:
        r38 = null;
        goto L135
    L130:
        r36 = MapsKt.emptyMap();
        goto L131
    L119:
        if (r2 == false) goto L121;
        r33 = "average";
        goto L122
    L121:
        r33 = "enlarge";
        goto L122
    L103:
        r27 = "";
        goto L105
    L99:
        r26 = null;
    L104:
        r27 = "connection_info_area";
    L61:
        r1 = true;
    L51:
        r17 = false;
        goto L52
    L45:
        r15 = 0;
    L54:
        if (M0() == true) goto L57;
    L33:
        if (M0() == true) goto L34;
    L35:
        r10 = false;
        goto L36
    L11:
        if (r3.x5(this.a) != true) goto L13;
        r4 = true;
        goto L14
    L5:
        if (r0.t4(this.a) != true) goto L7;
        r2 = true;
        goto L8
    }

    public MultiLinkSelfAnchorMicDialog(Context r2, String r3, c0 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
        this.b = 7;
        this.c = r4;
    }
}
