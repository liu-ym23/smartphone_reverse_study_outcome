package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiMicPanelIcon;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.link.model.ILinkerKickOutContent;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/MultiLinkAnchorMicDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkAnchorMicDialog extends CommonBottomDialog implements q46.a {
    public static final /* synthetic */ int i = 0;
    public final String a;
    public m21.h b;
    public final d21.b c;
    public final String d;
    public final String e;
    public final int f;
    public final int g;
    public final w h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MultiLinkAnchorMicDialog a;
        public final /* synthetic */ String b;

        public b(MultiLinkAnchorMicDialog r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            com.bytedance.android.live.revlink.impl.multianchor.service.b r8 = com.bytedance.android.live.revlink.impl.global.b.w();
            if (r8 == null) goto L5;
            r8.kickOut(this.a.d, "MultiMicPanel", ILinkerKickOutContent.KickOutSource.FromOrganizer);
        L5:
            com.bytedance.android.live.revlink.impl.multianchor.utils.q r9 = com.bytedance.android.live.revlink.impl.global.b.v();
            if (r9 == null) goto L22;
            String r0 = this.a.d;
            LinkedHashMap r1 = new LinkedHashMap();
            w31.c r2 = r9.k();
            if (r2 == null) goto L10;
            Map<String, String> r3 = r2.f();
        L11:
            r1.putAll(r3);
            com.bytedance.android.live.revlink.impl.multianchor.vm.g r4 = r9.g();
            Long r5 = null;
            if (r4 == null) goto L14;
            Long r6 = Long.valueOf(r4.a());
        L15:
            r1.put("channel_id", String.valueOf(r6));
            w31.c r10 = r9.k();
            if (r10 == null) goto L18;
            r5 = Long.valueOf(r10.i());
        L18:
            r1.put("pk_id", String.valueOf(r5));
            d31.d r12 = r9.m();
            if (r12 == null) goto L21;
            r12.r(r1);
        L21:
            r1.put("to_anchor_id", String.valueOf(r0));
            r1.put("connection_anchor_cnt", r9.b());
            mz0.n r13 = new mz0.n();
            Map<String, String> r14 = r13.a;
            Intrinsics.checkNotNullParameter(r14, "map");
            Intrinsics.checkNotNullParameter(r1, "map");
            r14.putAll(r1);
            mz0.m r15 = new mz0.m();
            r15.b(LogCommon.ROOM);
            ((ArrayList) r13.b).addAll(r15.a);
            cy0.e.a.getClass();
            cy0.j r16 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r17);
            ((mz0.i) ((f80.a) r17)).w3("livesdk_connection_kickout_click", r13.a, r13.b);
            goto L22
        L14:
            r6 = null;
            goto L15
        L10:
            r3 = MapsKt.emptyMap();
        L22:
            com.bytedance.android.live.revlink.impl.multianchor.utils.q r18 = com.bytedance.android.live.revlink.impl.global.b.v();
            if (r18 == null) goto L25;
            r18.r("out", this.a.d, this.b);
        L25:
            q46.a r19 = this.a;
            Handler r20 = DialogLancet.resolveDialogHandler(r19);
            if (r20 != null) goto L28;
        L30:
            DialogLancet.beforeDialogDismiss(r19);
            r19.dismiss();     // Catch: Throwable -> L33 Exception -> L35
        L39:
            DialogLancet.afterDialogDismiss(r19);
            return;
        L35:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
            Throwable r22 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
            if (r22 == null) goto L39;
            com.bytedance.crash.d.d(r22, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r19);
            throw th;
        L28:
            if (Looper.myLooper() == r20.getLooper()) goto L30;
            r20.post(DialogLancet.createDismissRunnable(r19));
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567010;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m21.h r0 = this.b;
        if (r0 == null) goto L6;
        r0.detachView();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r23) {
        super.onCreate(r23);
        String r0 = com.bytedance.android.live.revlink.impl.utils.u.e();
        if (r0 != null) goto L5;
        final String r12 = "";
    L6:
        boolean r13 = com.bytedance.android.live.revlink.impl.multianchor.utils.y.e();
        jy0.b.d(this.a, "onCreate, windowCount=" + this.g + ", isOrganizer=" + r13);
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r1 == null) goto L11;
        i11.b r2 = r1.getLinkUserCenter();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.link.model.p r3 = r2.getGuestInfo(this.d, null);
    L12:
        d21.b r4 = this.c;
        if (r3 == null) goto L18;
        IBaseUser r5 = r3.getUser();
        if (r5 == null) goto L18;
        String r6 = r5.getNickName();
        if (r6 == null) goto L18;
    L19:
        r4.getClass();
        final String r7 = d21.b.a(r6);
        TextView r8 = (TextView) findViewById(2131389658);
        if (r8 == null) goto L22;
        r8.setText(getContext().getString(2131920560, new Object[]{r7}));
    L22:
        w r9 = this.h;
        if (r9 != null) goto L25;
    L27:
        final boolean r10 = false;
    L28:
        if (r10 == false) goto L31;
        String r14 = "connection_info_area";
    L30:
        final String r15 = r14;
    L40:
        if (com.bytedance.android.live.revlink.impl.multianchor.utils.y.e() == false) goto L53;
        p21.b r16 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r16 != null) goto L44;
    L45:
        com.bytedance.android.live.revlink.impl.global.c r17 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r17 == null) goto L48;
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r18 = r17.km();
    L49:
        if (r18 == null) goto L53;
        if (r18.a() != true) goto L53;
    L52:
        boolean r19 = true;
    L55:
        if (r19 == false) goto L83;
        WrapLineFlowLayout r20 = findViewById(2131389657);
        if (r20 == null) goto L83;
        MultiMicPanelIcon r22 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        if (r10 == false) goto L61;
        int r24 = 2131920535;
    L62:
        r22.setDesc(s1.B(r24));
        IRoom r25 = com.bytedance.android.live.revlink.impl.utils.u.a();
        if (r25 == null) goto L65;
        LiveMode r26 = r25.getStreamType();
    L67:
        if (r26 != LiveMode.SCREEN_RECORD) goto L69;
        int r27 = 2131252424;
    L72:
        r22.setIcon(r27);
        p21.b r28 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r28 != null) goto L75;
    L76:
        p21.b r29 = com.bytedance.android.live.revlink.impl.global.b.A();
        if (r29 != null) goto L79;
    L81:
        float r30 = 1.0f;
    L82:
        r22.setAlpha(r30);
        r22.setOnClick(new MultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$1(this, r10, r15));
        Unit r32 = Unit.INSTANCE;
        r20.addView(r22);
        goto L83
    L79:
        if (r29.c() != true) goto L81;
    L80:
        r30 = 0.4f;
        goto L82
    L75:
        if (r28.b() == true) goto L80;
    L69:
        if (r10 == false) goto L71;
        r27 = 2131252428;
        goto L72
    L71:
        r27 = 2131252430;
        goto L72
    L65:
        r26 = null;
        goto L67
    L61:
        r24 = 2131920538;
    L83:
        com.bytedance.android.live.revlink.impl.multianchor.service.b r33 = com.bytedance.android.live.revlink.impl.global.b.w();
        if (r33 == null) goto L86;
        final com.bytedance.android.live.revlink.impl.multianchor.ui.i r34 = r33.getMuteManager();
    L87:
        if (r34 != null) goto L89;
    L91:
        final boolean r35 = false;
    L93:
        if (r41.f.a == false) goto L110;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r36 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r36 == null) goto L97;
        int r37 = r36.i();
    L98:
        if (r37 <= 2) goto L110;
        WrapLineFlowLayout r38 = findViewById(2131389657);
        if (r38 == null) goto L110;
        MultiMicPanelIcon r39 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        if (r35 == false) goto L104;
        int r40 = w11.a.a;
        int r42 = 2131920563;
    L105:
        r39.setDesc(s1.B(r42));
        if (r35 == false) goto L108;
        int r43 = 2131252437;
    L109:
        r39.setIcon(r43);
        r39.setOnClick(new MultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$2(this, r35, r34, r15));
        Unit r44 = Unit.INSTANCE;
        r38.addView(r39);
        goto L110
    L108:
        r43 = 2131252432;
        goto L109
    L104:
        int r45 = w11.a.a;
        r42 = 2131920555;
        goto L105
    L97:
        r37 = 0;
    L110:
        com.bytedance.android.live.revlink.impl.global.c r46 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r46 == null) goto L113;
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r47 = r46.km();
    L114:
        if (r47 == null) goto L116;
        r47.a();
    L116:
        if (r34 != null) goto L118;
    L120:
        final boolean r48 = false;
    L121:
        com.bytedance.android.live.revenuelink.rtc.f r49 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r49 == null) goto L132;
        com.bytedance.android.live.revenuelink.rtc.i r50 = r49.getRtcManager();
        if (r50 == null) goto L132;
        com.bytedance.android.live.revenuelink.rtc.p r52 = r50.L();
        if (r52 == null) goto L132;
        com.bytedance.android.live.revenuelink.rtc.o r53 = r52.k(this.e);
        if (r53 == null) goto L132;
        if (r53.j != true) goto L132;
        boolean r54 = true;
    L133:
        iq2.b r55 = vh6.c.b(er2.b.class).getChorusService();
        if (r55 != null) goto L136;
    L138:
        boolean r110 = false;
    L139:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r56 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r56 == null) goto L142;
        boolean r111 = r56.isInAudioPunish(this.e);
    L143:
        int r57 = this.f;
        int r58 = s11.a.b;
        if (r57 == 0) goto L161;
        if (r57 != 2) goto L148;
        final boolean r59 = true;
    L149:
        WrapLineFlowLayout r60 = findViewById(2131389657);
        if (r60 == null) goto L161;
        MultiMicPanelIcon r112 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        if (r59 == false) goto L154;
        String r62 = s1.B(2131920562);
    L155:
        r112.setDesc(r62);
        if (r59 == false) goto L158;
        int r63 = 2131252436;
    L159:
        r112.setIcon(r63);
        r112.setOnClick(new MultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$4(this, r59, r15));
        Unit r64 = Unit.INSTANCE;
        r60.addView(r112);
        goto L161
    L158:
        r63 = 2131252431;
        goto L159
    L154:
        r62 = s1.B(2131920552);
        goto L155
    L148:
        r59 = false;
    L161:
        WrapLineFlowLayout r65 = findViewById(2131389657);
        if (r65 == null) goto L185;
        MultiMicPanelIcon r66 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        if (r48 == false) goto L166;
    L171:
        String r67 = s1.B(2131920565);
    L172:
        r66.setDesc(r67);
        if (r111 == false) goto L175;
        int r68 = 2131252435;
    L184:
        r66.setIcon(r68);
        final boolean r69 = r110;
        final boolean r70 = r54;
        int r113 = 2131389657;
        final boolean r72 = r111;
        final String r114 = r15;
        final com.bytedance.android.live.revlink.impl.multianchor.ui.i r73 = r34;
        r66.setOnClick(new MultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$5(this, r48, r69, r70, r72, r7, r73, r114));
        Unit r74 = Unit.INSTANCE;
        r65.addView(r66);
    L186:
        WrapLineFlowLayout r75 = findViewById(r113);
        if (r75 == null) goto L189;
        MultiMicPanelIcon r76 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        r76.setDesc(s1.B(2131920566));
        r76.setIcon(2131252440);
        final String r77 = r114;
        r76.setOnClick(new MultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$6(this, r77));
        Unit r78 = Unit.INSTANCE;
        r75.addView(r76);
    L190:
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r79 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r79 == null) goto L198;
        com.bytedance.android.live.revlink.impl.global.c r80 = r79.b;
        if (r80 == null) goto L195;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r82 = r80.u5();
    L196:
        if (r82 == null) goto L198;
        boolean r83 = r82.ae();
    L199:
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r84 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r84 != null) goto L202;
    L208:
        boolean r85 = false;
    L209:
        jy0.b.d(this.a, "onCreate, changeOrganizerSwitch=" + r83 + ", isMoreThan4Windows=" + r85);
        if (r13 == false) goto L217;
        if (r83 == false) goto L217;
        if (r85 == false) goto L217;
        WrapLineFlowLayout r86 = findViewById(r113);
        if (r86 == null) goto L217;
        MultiMicPanelIcon r87 = new MultiMicPanelIcon(getContext(), null, 6, 0);
        r87.setDesc(s1.B(2131920551));
        r87.setIcon(2131252429);
        r87.setOnClick(new MultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$7(this, r77, r12));
        Unit r88 = Unit.INSTANCE;
        r86.addView(r87);
    L217:
        if (com.bytedance.android.live.revlink.impl.multianchor.utils.y.e() == true) goto L219;
    L226:
        m21.h r89 = new m21.h();
        this.b = r89;
        ((q46.b) r89).a = this;
        if (this.f != 0) goto L230;
        r89.c0(this.d, new MultiLinkAnchorMicDialog$tryQueryUser$1(this));
    L230:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r90 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r90 == null) goto L240;
        if (r19 == true) goto L234;
        String r115 = "";
    L238:
        r90.s(r115, this.d, r77);
        return;
    L234:
        if (r10 == false) goto L236;
        String r92 = "average";
    L237:
        r115 = r92;
        goto L238
    L236:
        r92 = "enlarge";
        goto L237
    L240:
        return;
    L219:
        if (this.g <= 2) goto L226;
        TextView r93 = (TextView) findViewById(2131389659);
        if (r93 == null) goto L223;
        r93.setOnClickListener(new b(this, r77));
    L223:
        TextView r94 = (TextView) findViewById(2131389659);
        if (r94 == null) goto L226;
        UtilityKotlinExtentionsKt.z(r94, true);
        goto L226
    L202:
        if (r84.i() <= 4) goto L204;
        boolean r95 = true;
    L206:
        if (r95 != true) goto L208;
        r85 = true;
        goto L209
    L204:
        r95 = false;
        goto L206
    L195:
        r82 = null;
    L198:
        r83 = false;
        goto L199
    L189:
        r77 = r114;
        goto L190
    L175:
        if (r48 == true) goto L183;
        if (this.g != 2) goto L181;
        if (r110 == false) goto L181;
        if (r54 == true) goto L183;
    L181:
        r68 = 2131252433;
    L183:
        r68 = 2131252438;
        goto L184
    L166:
        if (this.g != 2) goto L170;
        if (r110 == false) goto L170;
        if (r54 == true) goto L171;
    L170:
        r67 = s1.B(2131920557);
        goto L172
    L185:
        r114 = r15;
        r113 = 2131389657;
        goto L186
    L142:
        r111 = false;
        goto L143
    L136:
        if (r55.d() != 1) goto L138;
        r110 = true;
    L132:
        r54 = false;
        goto L133
    L118:
        if (r34.j(this.d, this.e) != true) goto L120;
        r48 = true;
        goto L121
    L113:
        r47 = null;
        goto L114
    L89:
        if (r34.h() != true) goto L91;
        r35 = true;
        goto L93
    L86:
        r34 = null;
        goto L87
    L48:
        r18 = null;
        goto L49
    L44:
        if (r16.f() == true) goto L52;
    L53:
        r19 = false;
        goto L55
    L31:
        w r96 = this.h;
        if (r96 == null) goto L34;
        UILayout r97 = r96.B5();
    L36:
        if (r97 != UILayout.FULL) goto L38;
        r14 = "connection_mini_window";
        goto L30
    L38:
        r15 = "";
        goto L40
    L34:
        r97 = null;
        goto L36
    L25:
        if (r9.x5(this.d) != true) goto L27;
        r10 = true;
    L18:
        r6 = "";
    L11:
        r3 = null;
        goto L12
    L5:
        r12 = r0;
        goto L6
    }

    public MultiLinkAnchorMicDialog(Context r2, String r3, String r4, DataCenter r5, int r6, int r7, c0 r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "linkerID");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        super(r2);
        this.d = r3;
        this.e = r4;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.a = "MultiLinkAnchorMicDialog";
        this.c = new d21.b();
    }
}
