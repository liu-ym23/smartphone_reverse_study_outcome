package com.bytedance.android.live.revlink.impl.multianchor.widget.dialogmananger;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.impl.multianchor.connect.MultiAnchorRelinkService;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.AnchorRelinkWaitingDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.MultiLinkAnchorMicDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.MultiLinkSelfAnchorMicDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.PkAnchorMicDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.c0;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorRecordLinkSimpleDialog;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkFeedbackDialog;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkMuteCheckDialogFragment;
import com.bytedance.android.live.revlink.impl.utils.RevLinkBannedUtil$showPkBanDialog$$inlined$let$lambda$1;
import com.bytedance.android.live.revlink.impl.utils.q;
import com.bytedance.android.live.revlink.link.biz.service.l;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.AlertBizType;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.LiveDialogButtonKey;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.k;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.n;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.o;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileClickPos;
import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileReportType;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DialogLaunchService implements k {
    public CommonBottomDialog a;
    public final Map<AlertBizType, j0> b;
    public PkAnchorMicDialog c;
    public PkMuteCheckDialogFragment d;
    public x0 e;
    public PkFeedbackDialog f;
    public MultiAnchorRecordLinkSimpleDialog g;
    public zy0.d h;
    public final Lazy i;
    public final NextLiveData<Integer> j;
    public final Context k;
    public final DataCenter l;
    public final IRoom m;
    public final Function0<AnchorUILayoutManager> n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ com.bytedance.android.live.revlink.link.domain.anchorimpl.e a;

        public b(com.bytedance.android.live.revlink.link.domain.anchorimpl.e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.b;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ com.bytedance.android.live.revlink.link.domain.anchorimpl.e a;

        public c(com.bytedance.android.live.revlink.link.domain.anchorimpl.e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.c;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class d implements PkFeedbackDialog.b {
        public final /* synthetic */ com.bytedance.android.live.revlink.link.domain.anchorimpl.e a;

        public d(com.bytedance.android.live.revlink.link.domain.anchorimpl.e r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.dialog.PkFeedbackDialog.b
        public final void a(boolean r2) {
            Function1<? super Boolean, Unit> r0 = this.a.e;
            if (r0 == null) goto L6;
            Unit r3 = (Unit) r0.invoke(Boolean.valueOf(r2));
            return;
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.dialog.PkFeedbackDialog.b
        public final void onFeedBackInfoUpdate(boolean r2, List<String> r3) {
            Function2<? super Boolean, ? super List<String>, Unit> r0 = this.a.d;
            if (r0 == null) goto L6;
            Unit r4 = (Unit) r0.invoke(Boolean.valueOf(r2), r3);
            return;
        }
    }

    public static final class e implements l {
        public final /* synthetic */ com.bytedance.android.live.revlink.link.domain.anchorimpl.e a;

        public e(com.bytedance.android.live.revlink.link.domain.anchorimpl.e r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.link.biz.service.l
        public final void a(boolean r2) {
            Function1<? super Boolean, Unit> r0 = this.a.f;
            if (r0 == null) goto L6;
            Unit r3 = (Unit) r0.invoke(Boolean.valueOf(r2));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void b() {
        PkFeedbackDialog r0 = this.f;
        if (r0 == null) goto L6;
        q(r0);
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void d() {
        b51.b r0 = b51.b.c0;
        r0.getClass();
        ReadOnlyProperty r1 = b51.b.M;
        KProperty[] r2 = b51.b.a;
        if (((Boolean) r1.getValue(r0, r2[37])).booleanValue() == false) goto L53;
        String r3 = (String) b51.b.O.getValue(r0, r2[39]);
        if (TextUtils.isEmpty(r3) == true) goto L60;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r4 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r4 == null) goto L21;
        MultiAnchorRelinkService r5 = r4.Fa();
        if (r5 == null) goto L21;
        List<String> r6 = r5.q(false);
        if (r6 == null) goto L21;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L22;
        String r9 = (String) r8.next();
        i11.b r10 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r10 == null) goto L18;
        p r12 = r10.getGuestInfo(r9, null);
    L19:
        if (r12 == null) goto L14;
        r7.add(r12);
        goto L14
    L18:
        r12 = null;
    L22:
        final com.bytedance.android.live.revenue.common.x0 r13 = new com.bytedance.android.live.revenue.common.x0(r3);
        com.bytedance.android.live.revenue.common.x0 r14 = r13.d("url");
        IRoom r15 = this.m;
        if (r15 == null) goto L25;
        Long r16 = Long.valueOf(r15.getRoomId());
    L26:
        r14.b("room_id", String.valueOf(r16));
        r14.b("business_type", r41.b.a());
        r14.b("group", r41.b.a());
        r14.b("panel_type", "waiting");
        String r17 = "";
        if (r7 == null) goto L34;
        p r18 = (p) CollectionsKt.firstOrNull(r7);
        if (r18 == null) goto L34;
        IBaseUser r19 = r18.getUser();
        if (r19 == null) goto L34;
        String r20 = r19.getIdString();
        if (r20 == null) goto L34;
    L35:
        r14.b("invitee_id", r20);
        if (r7 == null) goto L45;
        p r22 = (p) CollectionsKt.getOrNull(r7, 1);
        if (r22 == null) goto L45;
        IBaseUser r23 = r22.getUser();
        if (r23 == null) goto L45;
        String r24 = r23.getIdString();
        if (r24 == null) goto L45;
        r17 = r24;
    L45:
        r14.b("other_invitee_id", r17);
        g r25 = (g) f.d(j.C0.a(), g.class);
        if (r25 == null) goto L61;
        Context r26 = r25.getContext();
        if (r26 == null) goto L62;
        cy0.e.a.getClass();
        cy0.j r27 = cy0.e.a.a;
        m.e.getClass();
        Object r28 = m.b(r27).a(Reflection.getOrCreateKotlinClass(vy0.c.class));
        Intrinsics.checkNotNull(r28);
        HybridDialogImpl r29 = ((vy0.b) ((f80.a) r28)).U0(r26, r13.c(), null);
        this.h = r29;
        if (r29 == null) goto L63;
        r29.j0(new DialogLaunchService$showAnchorRelinkWaitingDialog$$inlined$let$lambda$1(this, r13));
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L34:
        r20 = "";
        goto L35
    L25:
        r16 = null;
    L21:
        r7 = null;
        goto L22
    L60:
        return;
    L53:
        p8.a(new AnchorRelinkWaitingDialog(), this.k);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void f() {
        MultiAnchorRecordLinkSimpleDialog r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        MultiAnchorRecordLinkSimpleDialog r1 = new MultiAnchorRecordLinkSimpleDialog();
        this.g = r1;
        DataCenter r2 = this.l;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.f = r2;
    L10:
        MultiAnchorRecordLinkSimpleDialog r3 = this.g;
        if (r3 == null) goto L14;
        p8.a(r3, this.k);
        return;
    L14:
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final NextLiveData c() {
        return this.j;
    }

    public static void n(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void o(CommonBottomDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void p(j0 r3) {
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

    public static void q(LiveDialogFragment r1) {
        if (r1.isShowing() == false) goto L13;
        r1.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L14;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void h(AlertBizType r3) {
        Intrinsics.checkNotNullParameter(r3, "alertBizType");
        j0 r0 = (j0) ((LinkedHashMap) this.b).get(r3);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isShowing() == false) goto L8;
        p(r0);
    L8:
        this.b.remove(r3);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void i(Function1<? super o, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "builderScope");
        PkMuteCheckDialogFragment r0 = this.d;
        if (r0 == null) goto L5;
        q(r0);
    L5:
        final o r1 = new o();
        r4.invoke(r1);
        PkMuteCheckDialogFragment r5 = new PkMuteCheckDialogFragment();
        r5.l = new DialogLaunchService$showMuteCheckDialog$$inlined$apply$lambda$1(this, r1);
        r5.j = r1.b;
        r5.k = r1.c;
        Unit r2 = Unit.INSTANCE;
        this.d = r5;
        FragmentActivity r6 = ContextUtil.contextToFragmentActivity(this.k);
        if (r6 == null) goto L20;
        FragmentManager r7 = r6.getSupportFragmentManager();
        if (r7 == null) goto L21;
        PkMuteCheckDialogFragment r3 = this.d;
        if (r3 == null) goto L22;
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r3, r8) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r3.show(r7, "");
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void j(Function1<? super com.bytedance.android.live.revlink.link.domain.anchorimpl.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "builderScope");
        final com.bytedance.android.live.revlink.link.domain.anchorimpl.a r0 = new com.bytedance.android.live.revlink.link.domain.anchorimpl.a();
        r5.invoke(r0);
        Map<AlertBizType, j0> r6 = this.b;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        j0 r8 = (j0) r7.get(r0.a);
        if (r8 != null) goto L5;
    L7:
        Map<AlertBizType, j0> r9 = this.b;
        AlertBizType r1 = r0.a;
        j0.a r2 = new j0.a(this.k);
        r2.c = r0.b;
        r2.b = new DialogLaunchService$showLiveAlertDialog$$inlined$apply$lambda$1(r0);
        r2.e = r0.d;
        r2.d = new DialogLaunchService$showLiveAlertDialog$$inlined$apply$lambda$2(r0);
        r2.f = r0.f;
        r2.a = r0.g;
        Unit r3 = Unit.INSTANCE;
        r9.put(r1, r2.c());
        return;
    L5:
        if (r8.isShowing() == false) goto L7;
        p(r8);
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void k(Function1<? super n, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "builderScope");
        x0 r0 = this.e;
        if (r0 != null) goto L5;
    L9:
        n r1 = new n();
        r6.invoke(r1);
        z0 r7 = z0.a();
        Context r2 = this.k;
        r7.getClass();
        x0.b r8 = z0.b(r2);
        r8.a.d = r1.b;
        Iterator r3 = ((LinkedHashMap) r1.a).entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r3.next();
        LiveDialogButtonKey r5 = (LiveDialogButtonKey) r4.getKey();
        Pair r9 = (Pair) r4.getValue();
        String r10 = (String) r9.component1();
        final Function1 r12 = (Function1) r9.component2();
        r8.j(r5.ordinal(), r10, new DialogLaunchService$showLiveDialog$1$1$1(r12));
        goto L11
    L13:
        Unit r13 = Unit.INSTANCE;
        this.e = r8.n();
        return;
    L5:
        if (r0.isShowing() != true) goto L9;
        x0 r14 = this.e;
        if (r14 == null) goto L9;
        n(r14);
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void l(com.bytedance.android.livesdk.link.model.j0 r10) {
        Intrinsics.checkNotNullParameter(r10, "banUser");
        int r0 = q.a;
        Context r1 = this.k;
        Intrinsics.checkNotNullParameter(r1, "context");
        String r3 = null;
        if (r10 == null) goto L15;
        String r4 = r10.getSchemaUrl();
        if (r4 == null) goto L15;
        if (r4.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        jy0.b.c("ttlive_anchor_link", "show new pk ban dialog " + r10.getSchemaUrl(), null, 4);
        vh6.c.b(pq2.a.class).handleSchema(r1, r10.getSchemaUrl());
        return;
    L9:
        r5 = false;
    L15:
        if (r10 == null) goto L80;
        String r6 = r10.getReason();
        if (r6 == null) goto L81;
        o5 r7 = new o5(r1);
        TextView r8 = r7.b;
        if (r8 == null) goto L25;
        Resources r9 = r1.getResources();
        if (r9 == null) goto L23;
        String r12 = r9.getString(2131922203);
    L24:
        r8.setText(r12);
        goto L25
    L23:
        r12 = null;
    L25:
        TextView r13 = r7.c;
        if (r13 == null) goto L28;
        r13.setText(r6);
    L28:
        TextView r14 = r7.c;
        if (r14 == null) goto L32;
        UtilityKotlinExtentionsKt.z(r14, true ^ StringsKt.isBlank(r6));
    L32:
        if (TextUtils.isEmpty(r10.getUrl()) == false) goto L39;
        TextView r15 = r7.d;
        if (r15 == null) goto L36;
        r15.setVisibility(8);
    L36:
        View r16 = r7.e;
        if (r16 == null) goto L55;
        r16.setVisibility(8);
    L55:
        Button r17 = r7.f;
        if (r17 == null) goto L61;
        Resources r2 = r1.getResources();
        if (r2 == null) goto L60;
        r3 = r2.getString(2131917832);
    L60:
        r17.setText(r3);
    L61:
        Button r18 = r7.g;
        if (r18 == null) goto L64;
        r18.setVisibility(8);
    L64:
        TextView r19 = r7.h;
        if (r19 == null) goto L67;
        r19.setVisibility(8);
    L67:
        Button r110 = r7.f;
        if (r110 == null) goto L71;
        r110.setOnClickListener(new com.bytedance.android.live.revlink.impl.utils.p(r7));
    L71:
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L77;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L77:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L76
    L74:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
        return;
    L39:
        TextView r20 = r7.d;
        if (r20 == null) goto L42;
        r20.setVisibility(0);
    L42:
        View r22 = r7.e;
        if (r22 == null) goto L45;
        r22.setVisibility(0);
    L45:
        TextView r23 = r7.d;
        if (r23 == null) goto L52;
        Resources r24 = r1.getResources();
        if (r24 == null) goto L50;
        String r25 = r24.getString(2131915262);
    L51:
        r23.setText(r25);
        goto L52
    L50:
        r25 = null;
    L52:
        View r26 = r7.a;
        if (r26 == null) goto L55;
        r26.setOnClickListener(new RevLinkBannedUtil$showPkBanDialog$$inlined$let$lambda$1(r7, r1, r10));
        goto L55
    L81:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void m(Function1<? super com.bytedance.android.live.revlink.link.domain.anchorimpl.e, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "builderScope");
        com.bytedance.android.live.revlink.link.domain.anchorimpl.e r0 = new com.bytedance.android.live.revlink.link.domain.anchorimpl.e();
        r4.invoke(r0);
        PkFeedbackDialog r5 = this.f;
        if (r5 == null) goto L5;
        q(r5);
    L5:
        int r6 = PkFeedbackDialog.p;
        PkFeedbackDialog r7 = PkFeedbackDialog.a.a(true, this.m, r0.a);
        r7.e = new b(r0);
        r7.f = new c(r0);
        r7.g = new d(r0);
        r7.h = new e(r0);
        Unit r1 = Unit.INSTANCE;
        this.f = r7;
        FragmentActivity r2 = this.k;
        if (r2 == null) goto L14;
        FragmentManager r3 = r2.getSupportFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "PkFeedbackDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r7, r8) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L11:
        r7.show(r3, "PkFeedbackDialog");
        return;
    L18:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void showUserProfile(String r8) {
        wq2.f r0 = ma1.a.a();
        if (r0 == null) goto L5;
        wq2.f.a.a(r0, r8, UserProfileClickPos.POSITION_LINKED_ANCHOR_MANAGE_SETTING, "anchor_linkmic", UserProfileReportType.DATA_TYPE_CARD_LINKED_ANCHOR, 0, 96);
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r1 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r1 == null) goto L9;
        r1.r("profile", r8, "");
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "linkerID");
        CommonBottomDialog r5 = this.a;
        if (r5 != null) goto L5;
    L6:
        int r6 = MultiLinkSelfAnchorMicDialog.d;
        Context r7 = this.k;
        c0 r0 = new c0((AnchorUILayoutManager) this.i.getValue());
        Intrinsics.checkNotNullParameter(r7, "context");
        MultiLinkSelfAnchorMicDialog r1 = new MultiLinkSelfAnchorMicDialog(r7, r3, r0);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r1);
    L11:
        this.a = r1;
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L10:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        goto L11
    L5:
        if (r5.isShowing() != true) goto L6;
    }

    public DialogLaunchService(Context r2, DataCenter r3, IRoom r4, Function0<AnchorUILayoutManager> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "uiLayoutManagerGetter");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.b = new LinkedHashMap();
        this.i = LazyKt.lazy(r5);
        this.j = new NextLiveData();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void e(String r12, String r13, int r14, Function1<? super Boolean, Unit> r15) {
        Intrinsics.checkNotNullParameter(r13, "linkerID");
        Intrinsics.checkNotNullParameter(r15, "setMute");
        q46.a r2 = this.c;
        if (r2 != null) goto L5;
    L7:
        int r3 = PkAnchorMicDialog.j;
        Context r4 = this.k;
        IRoom r7 = this.m;
        c0 r10 = new c0((AnchorUILayoutManager) this.i.getValue());
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r13, "linkerID");
        Intrinsics.checkNotNullParameter(r15, "setMute");
        PkAnchorMicDialog r0 = new PkAnchorMicDialog(r4, r12, r13, r7, r14, r15, r10);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r0);
    L12:
        this.c = r0;
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L11:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L12
    L5:
        if (r2.isShowing() != true) goto L7;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.k
    public final void g(String r10, String r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "linkerID");
        DataCenter r5 = this.l;
        if (r5 != null) goto L5;
        return;
    L5:
        CommonBottomDialog r1 = this.a;
        if (r1 != null) goto L8;
    L12:
        int r2 = MultiLinkAnchorMicDialog.i;
        Context r3 = this.k;
        c0 r8 = new c0((AnchorUILayoutManager) this.i.getValue());
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r12, "linkerID");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        MultiLinkAnchorMicDialog r0 = new MultiLinkAnchorMicDialog(r3, r10, r12, r5, r13, r14, r8);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r0);
    L17:
        this.a = r0;
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L16:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L17
    L8:
        if (r1.isShowing() != true) goto L12;
        CommonBottomDialog r4 = this.a;
        if (r4 == null) goto L12;
        o(r4);
        goto L12
    }
}
