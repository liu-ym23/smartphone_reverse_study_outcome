package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyToastActionManager;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q8b.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements q8b.c {
    public long a;
    public final List<i> b;
    public final String c;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            ScsLogger.d("SecurityPolicy_PolicyCenterHandler", "click i know button.");
        }
    }

    static {
    }

    public e() {
        this.b = CollectionsKt.listOf(new i(new q8b.a("ACCESS_CONTROL_ACTION_COMMON"), new q8b.a("POLICY_CENTER"), 4));
        this.c = "PolicyCenterHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.c;
    }

    @Override // q8b.b
    public final List<i> getRules() {
        return this.b;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r5) {
        Intrinsics.checkNotNullParameter(r5, "internalSecurityAction");
        String r0 = r5.getCurrentAction().getParams().get("containerType");
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        int r1 = r0.hashCode();
        if (r1 == (-1332085432)) goto L26;
        if (r1 == 3433103) goto L17;
        if (r1 == 110532135) goto L13;
    L27:
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCenterHandler", "unrecognized containerType: ".concat(r0));
        Object r3 = r5.getInternalParams().get("comeFrom");
        if (r3 != null) goto L30;
        r3 = "SDK_INTERNAL";
    L30:
        FileAuthMonitor.UpdateTrigger[] r4 = FileAuthMonitor.a;
        FileAuthMonitor.o((String) r3, r5.toString(), "unsupportContainerType");
        if ((System.currentTimeMillis() - this.a) <= 30000) goto L47;
        Activity r6 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r6 == null) goto L39;
        UDDialog r7 = new UDDialogBuilder(r6).message(2131892542).addActionButton(2131391778, 2131892536, b.a).build();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(r7);
        goto L39
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L38:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    L39:
        this.a = System.currentTimeMillis();
        return;
    L47:
        return;
    L13:
        if (r0.equals("toast") == false) goto L27;
        SecurityPolicyToastActionManager.a(r5);
        return;
    L17:
        if (r0.equals("page") == false) goto L27;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L21;
    L24:
        Integer r8 = DisplayUtilsKt.c(r5);
        int r9 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_PolicyCenterHandler", "handleAction PAGE, geoChallengeType=" + r8);
        Bundle r10 = new Bundle();
        r10.putParcelable("param_action", r5);
        int r11 = g8b.b.a;
        g8b.b.a.a().c(NoPermissionType.CUSTOM_DISPLAY, r10);
        return;
    L21:
        if (w4c.c.a().C() == true) goto L24;
        ScsLogger.d("SecurityPolicy_PolicyCenterHandler", "doubao policy center page disabled");
        return;
    L26:
        if (r0.equals("dialog") == false) goto L27;
        SecurityPolicyDialogActionManager.a.d(92, r5);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r1) {
        return q8b.c.a.a(this, r1);
    }
}
