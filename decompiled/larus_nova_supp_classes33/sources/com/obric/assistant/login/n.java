package com.obric.assistant.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sdk.account.utils.d;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricSettingsApi;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.onelogin.impl.databinding.ObricEnterpriseAccountTipDialogBinding;
import com.obric.assistant.onelogin.impl.databinding.ObricEnterpriseAccountTipListItemBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.dialog.base.i;
import com.obric.oui.dialog.v2.alert.c;
import com.obric.oui.dialog.v2.alert.g;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ String a;

    public /* synthetic */ n(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final String r1 = this.a;
        s.a.getClass();
        IObricSettingsApi r2 = (IObricSettingsApi) ServiceManager.get().getService(IObricSettingsApi.class);
        if (r2 == null) goto L5;
        boolean r3 = r2.k0(r1);
    L6:
        if (r3 == true) goto L90;
        WeakReference<c> r4 = s.b;
        OButton r5 = null;
        if (r4 == null) goto L11;
        c r6 = r4.get();
    L12:
        if (r6 == null) goto L16;
        boolean r7 = true;
        if (r6.isShowing() != true) goto L16;
    L18:
        if (r7 == false) goto L20;
        FLogger.a.i("ObricEnterpriseAccountTipManager", "showDialogIfNeeded ignore, dialog showing");
        return;
    L20:
        Activity r8 = AppHost.a.a().getCurrentActivity();
        if (r8 != null) goto L24;
    L27:
        r8 = null;
    L28:
        if (r8 != null) goto L37;
        r8 = d.b();
        if (r8 != null) goto L33;
    L36:
        r8 = null;
        goto L37
    L33:
        if (r8.isFinishing() == true) goto L36;
        if (r8.isDestroyed() == true) goto L36;
    L37:
        if (r8 != null) goto L39;
        FLogger.a.i("ObricEnterpriseAccountTipManager", "showDialogIfNeeded ignore, activity null");
        return;
    L39:
        int r9 = r8.getResources().getDimensionPixelSize(2131166968);
        int r14 = r8.getResources().getDimensionPixelSize(2131167350);
        View r10 = LayoutInflater.from(r8).inflate(2131563990, null, false);
        int r11 = 2131367035;
        View r12 = ViewBindings.findChildViewById(r10, 2131367035);
        if (r12 == null) goto L84;
        ObricEnterpriseAccountTipListItemBinding r24 = ObricEnterpriseAccountTipListItemBinding.a(r12);
        r11 = 2131367812;
        if (((LinearLayout) ViewBindings.findChildViewById(r10, 2131367812)) == null) goto L84;
        r11 = 2131373139;
        if (((LinearLayout) ViewBindings.findChildViewById(r10, 2131373139)) == null) goto L84;
        r11 = 2131379875;
        View r13 = ViewBindings.findChildViewById(r10, 2131379875);
        if (r13 == null) goto L84;
        ObricEnterpriseAccountTipListItemBinding r25 = ObricEnterpriseAccountTipListItemBinding.a(r13);
        r11 = 2131380678;
        OCheckBoxLayout r19 = (OCheckBoxLayout) ViewBindings.findChildViewById(r10, 2131380678);
        if (r19 == null) goto L84;
        r11 = 2131380679;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131380679);
        if (r15 == null) goto L84;
        r11 = 2131380680;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131380680)) == null) goto L84;
        r11 = 2131382198;
        View r16 = ViewBindings.findChildViewById(r10, 2131382198);
        if (r16 == null) goto L84;
        ObricEnterpriseAccountTipListItemBinding r26 = ObricEnterpriseAccountTipListItemBinding.a(r16);
        r11 = 2131387982;
        View r17 = ViewBindings.findChildViewById(r10, 2131387982);
        if (r17 == null) goto L84;
        ObricEnterpriseAccountTipListItemBinding r18 = ObricEnterpriseAccountTipListItemBinding.a(r17);
        View r110 = ViewBindings.findChildViewById(r10, 2131392993);
        if (r110 == null) goto L82;
        ObricEnterpriseAccountTipListItemBinding r27 = ObricEnterpriseAccountTipListItemBinding.a(r110);
        final ObricEnterpriseAccountTipDialogBinding r111 = new ObricEnterpriseAccountTipDialogBinding((LinearLayout) r10, r24, r25, r19, r15, r26, r18, r27);
        s.b(r18, 2131244388, 2131912100, 2131912099, r9, r14);
        s.b(r24, 2131244385, 2131912091, 2131912090, r9, r14);
        s.b(r26, 2131244387, 2131912098, 2131912097, r9, r14);
        s.b(r25, 2131244386, 2131912094, 2131912093, r9, r14);
        s.a(r27, 2131244389, 2131912103, 2131912102, false, r9, r14);
        r15.setOnClickListener(new o(r111));
        g r20 = new g(r8);
        g.i(r20, r8.getText(2131912101));
        r20.i = r8.getText(2131912095);
        zla.g r21 = new zla.g(new p(r111));
        Intrinsics.checkNotNullParameter(r21, "controller");
        r20.x = r21;
        r20.w = false;
        r20.h(r8.getText(2131912092), new q(r111, r1));
        DialogInterface.OnDismissListener r22 = new r();
        Intrinsics.checkNotNullParameter(r22, "onDismissListener");
        ((i) r20).a = r22;
        c r23 = r20.a();
        s.b = new WeakReference(r23);
        if (DialogLancet.shouldBlockDialogShow(r23) == false) goto L86;
        DialogLancet.handleBlockedDialogShow(r23);
    L64:
        int r28 = vma.c.a;
        ButtonStyleController r29 = r23.M;
        if (r29 != null) goto L68;
    L70:
        r29 = null;
    L71:
        ButtonStyleController r30 = r29;
        if (r30 != null) goto L74;
        OButton r31 = null;
    L76:
        if ((r31 instanceof TextView) == false) goto L78;
        r5 = r31;
    L78:
        if (r5 == null) goto L80;
        r5.setTextColor(ContextCompat.getColorStateList(r8, 2131104350));
    L80:
        FLogger.a.i("ObricEnterpriseAccountTipManager", "enterprise account tip dialog showed");
        return;
    L74:
        r31 = r30.f();
        goto L76
    L68:
        if ((r29 instanceof ButtonStyleController) == false) goto L70;
    L86:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L85
    L63:
        DialogLancet.beforeDialogShow(r23);
        r23.show();
        DialogLancet.afterDialogShow(r23);
        goto L64
    L82:
        r11 = 2131392993;
    L84:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    L24:
        if (r8.isFinishing() == true) goto L27;
        if (r8.isDestroyed() == false) goto L28;
    L16:
        r7 = false;
        goto L18
    L11:
        r6 = null;
        goto L12
    L90:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
