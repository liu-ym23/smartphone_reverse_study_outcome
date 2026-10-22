package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AudienceLandTopToolbarMoreDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AudiencePortToolbarMoreDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d2;
import com.bytedance.android.livesdk.config.setting.t;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class AudienceMoreDialogManagerService {
    public final String a;
    public boolean b;
    public CommonStandardBottomDialog c;
    public final CompositeDisposable d;
    public final AudienceMoreDialogDataManagerImpl e;
    public final DataCenter f;
    public final Context g;

    public boolean g() {
        return false;
    }

    public CommonStandardBottomDialog d() {
        if (this.b == false) goto L6;
        return new AudiencePortToolbarMoreDialog(this.g);
    L6:
        return new AudienceLandTopToolbarMoreDialog(this.g);
    }

    public final void h() {
        if (g() == false) goto L5;
    L7:
        this.b = ((Boolean) this.f.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        e().c(new AudienceMoreDialogManagerService$onCreate$1(this));
        return;
    L5:
        if (t.a() == false) goto L7;
        MorePanelDynamicControllerViewModel.Companion r0 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r1 = this.f;
        r0.getClass();
        MorePanelDynamicControllerViewModel.Companion.b(r1);
        goto L7
    }

    public f e() {
        return this.e;
    }

    public String f() {
        return this.a;
    }

    public final Context getContext() {
        return this.g;
    }

    public static void a(CommonStandardBottomDialog r3) {
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

    public static final void c(AudienceMoreDialogManagerService r1) {
        r1.update("control");
    }

    private final void update(String r5) {
        Context r0 = this.g;
        if ((r0 instanceof Activity) == true) goto L5;
    L7:
        CommonStandardBottomDialog r1 = this.c;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isShowing() != true) goto L21;
        ALogger.i(f(), "Updating started by " + r5);
        CommonStandardBottomDialog r6 = this.c;
        if ((r6 instanceof d2) == true) goto L14;
        return;
    L14:
        if ((r6 instanceof d2) == true) goto L16;
        r6 = null;
    L16:
        d2 r7 = (d2) r6;
        if (r7 == null) goto L23;
        r7.l0(e().getData(), true);
        return;
    L23:
        return;
    L21:
        return;
    L5:
        if (((Activity) r0).isFinishing() == false) goto L7;
    }

    public final void i(String r4) {
        CommonStandardBottomDialog r0 = d();
        if ((r0.getContext() instanceof Activity) == false) goto L13;
        Context r1 = r0.getContext();
        if ((r1 instanceof Activity) == true) goto L7;
        r1 = null;
    L7:
        Activity r2 = (Activity) r1;
        if (r2 == null) goto L13;
        if (r2.isFinishing() != true) goto L13;
        return;
    L13:
        if ((r0 instanceof d2) == false) goto L16;
        d2 r3 = (d2) r0;
        r3.setEnterFrom(r4);
        r3.setDataCenter(this.f);
        e().a();
        ALogger.i(f(), "on dialog show");
        r3.l0(e().getData(), false);
    L16:
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(r0);
    L20:
        Unit r5 = Unit.INSTANCE;
        this.c = r0;
        return;
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L19:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L20
    }

    public AudienceMoreDialogManagerService(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.f = r2;
        this.g = r3;
        this.a = "AudienceMoreDialogManagerService";
        this.d = new CompositeDisposable();
        this.e = new AudienceMoreDialogDataManagerImpl(r2, r3);
    }

    public static final /* synthetic */ void b(AudienceMoreDialogManagerService r0, String r1) {
        r0.update(r1);
    }
}
