package com.obric.assistant.privacy.dialog;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common_ui.dialog.p0;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.privacy.IObricPrivacyService;
import com.obric.assistant.t1;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0003J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u001a\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/assistant/privacy/dialog/ObricPrivacyDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "privacyContext", "Landroid/content/Context;", "privacySheet", "Lcom/obric/oui/privacy/OPrivacySheet;", "isAgreeClicked", "", "fullScreen", "enableEnterAnim", "getPrivacyStr", "", "resId", "", "showPrivacySheet", "", "isMainActivity", "onPrivacyAgreeClick", "onPrivacyDisagreeClick", "clickPrivacyLink", "linkUrl", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "dismiss", "dismissAllowingStateLoss", "Companion", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyDialog extends DialogFragment {
    public static final /* synthetic */ int k = 0;
    public p0 d;
    public com.larus.common_ui.dialog.u e;
    public Context f;
    public com.obric.oui.privacy.c g;
    public boolean h;
    public boolean i;
    public boolean j;

    public static final class a {
    }

    static {
    }

    public final void dismiss() {
        this.g = null;
        this.f = null;
    }

    public final void dismissAllowingStateLoss() {
        this.g = null;
        this.f = null;
        this.d = null;
        this.e = null;
    }

    public ObricPrivacyDialog() {
        this.j = true;
    }

    public static final void T90(ObricPrivacyDialog r3) {
        FLogger.a.i("ObricPrivacyDialog", "click agree");
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L5;
        r0.e();
    L5:
        Application r1 = AppHost.a.getApplication();
        HomeService.a.Y(r1, true);
        p0 r2 = r3.d;
        if (r2 == null) goto L8;
        r2.confirm();
    L8:
        IObricPrivacyService.a.getClass();
        if (ObricFeatureServiceDelegate.b.c() == false) goto L11;
        IObricPrivacyService r4 = (IObricPrivacyService) ServiceManager.get().getService(IObricPrivacyService.class);
    L12:
        if (r4 == null) goto L21;
        r4.c();
    L21:
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L23;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L23:
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final String U90(int r2) {
        Context r0 = this.f;
        if (r0 == null) goto L8;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L8;
        String r3 = r1.getString(r2);
        if (r3 == null) goto L8;
        return r3;
    L8:
        return "";
    }

    public static final void S90(final ObricPrivacyDialog r3, final String r4) {
        FragmentActivity r0 = r3.f;
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 == null) goto L13;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 == null) goto L14;
        SecurityService r5 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r5 == null) goto L15;
        r5.x(r2, new q(r4, r3));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void show(FragmentManager r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "manager");
        Context r16 = this.f;
        if (r16 == null) goto L5;
        HomeService.a.Q(r16);
    L5:
        HomeService.a.x(new JSONObject());
        int r17 = Build.VERSION.SDK_INT;
        if (r17 >= 23) goto L8;
        return;
    L8:
        if (r17 == 26) goto L15;
        Context r18 = this.f;
        if ((r18 instanceof Activity) == false) goto L12;
        Activity r19 = (Activity) r18;
    L13:
        if (r19 == null) goto L15;
        r19.setRequestedOrientation(1);
        goto L15
    L12:
        r19 = null;
    L15:
        com.obric.oui.privacy.h r110 = new com.obric.oui.privacy.h(AppHost.a.getApplication().getPackageName(), U90(2131896110), U90(2131912344), CollectionsKt.listOf(new com.obric.oui.privacy.j[]{new com.obric.oui.privacy.j.b(U90(2131912087), ObricUpdateSettingDelegate.a.a(), new o()), new com.obric.oui.privacy.j.b(U90(2131912083), t1.a.g0(), new p(this)), new com.obric.oui.privacy.j.a(U90(2131912373), CollectionsKt.listOf(new String[]{U90(2131912355), U90(2131912360), U90(2131912364), U90(2131912361), U90(2131912358), U90(2131912367), U90(2131912354), U90(2131912359), U90(2131912372), U90(2131912368), U90(2131912370), U90(2131912371), U90(2131912366), U90(2131912356), U90(2131912353), U90(2131912369), U90(2131912357), U90(2131912365), U90(2131912363), U90(2131912362)}))}), U90(2131912375), CollectionsKt.listOf(new String[]{U90(2131912376), U90(2131912345), U90(2131912346)}), U90(2131911955), U90(2131912275), true, true, this.j);
        Context r111 = this.f;
        if (r111 == null) goto L24;
        com.obric.oui.privacy.c r0 = new com.obric.oui.privacy.c(r111, r110);
        ObricPrivacyDialog$showPrivacySheet$1$1 r112 = new ObricPrivacyDialog$showPrivacySheet$1$1(this);
        Intrinsics.checkNotNullParameter(r112, "listener");
        r0.e = r112;
        r0.d();
        this.g = r0;
        if (this.i == false) goto L25;
        OSheet r113 = r0.c;
        if (r113 == null) goto L26;
        com.obric.oui.sheet.v2.i r114 = r113.getScaffoldController();
        RadiusLayout r1 = r114.c;
        OneShotPreDrawListener.add(r1, new r(r1, r114, r113));
        return;
    L26:
        return;
    L25:
        return;
    }
}
