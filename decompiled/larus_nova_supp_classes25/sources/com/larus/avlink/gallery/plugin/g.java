package com.larus.avlink.gallery.plugin;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements zk9.a {
    public l0 a;
    public volatile boolean b;

    public static final class a {
    }

    static {
    }

    public g() {
    }

    public final void Wg() {
        l0 r1 = this.a;     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        a(r1);     // Catch: Exception -> L8
    L6:
        this.a = null;     // Catch: Exception -> L8
        this.b = false;     // Catch: Exception -> L8
        FLogger.a.e("GallerySyncPluginLoadingUI", "Plugin loading failed, dialog dismissed");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e("GallerySyncPluginLoadingUI", "Failed to handle error loading", e);
    }

    public final void zV() {
        l0 r1 = this.a;     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        a(r1);     // Catch: Exception -> L8
    L6:
        this.a = null;     // Catch: Exception -> L8
        this.b = false;     // Catch: Exception -> L8
        FLogger.a.i("GallerySyncPluginLoadingUI", "Plugin loading finished, dialog dismissed");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e("GallerySyncPluginLoadingUI", "Failed to finish loading dialog", e);
    }

    public static void a(l0 r3) {
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

    public final void Zp(FragmentManager r6) {
        Intrinsics.checkNotNullParameter(r6, "manager");
        if (this.b == false) goto L23;
        FLogger.a.i("GallerySyncPluginLoadingUI", "Loading dialog already shown, skipping");
        return;
    L23:
        Activity r7 = AppHost.a.a().getCurrentActivity();     // Catch: Exception -> L17
        if (r7 == null) goto L15;
        l0 r1 = new l0(r7, 0.0f, false, 6);     // Catch: Exception -> L17
        this.a = r1;     // Catch: Exception -> L17
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r1);     // Catch: Exception -> L17
    L14:
        this.b = true;     // Catch: Exception -> L17
        FLogger.a.i("GallerySyncPluginLoadingUI", "Plugin loading dialog started");     // Catch: Exception -> L17
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L13:
        DialogLancet.beforeDialogShow(r1);     // Catch: Exception -> L17
        r1.show();     // Catch: Exception -> L17
        DialogLancet.afterDialogShow(r1);     // Catch: Exception -> L17
        goto L14
    L15:
        FLogger.a.w("GallerySyncPluginLoadingUI", "Cannot show loading dialog: current activity is null");     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        FLogger.a.e("GallerySyncPluginLoadingUI", "Failed to start loading dialog", e);
    }

    public final void eg(int r5) {
        FLogger.a.d("GallerySyncPluginLoadingUI", "Plugin loading progress: " + r5 + '%');     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("GallerySyncPluginLoadingUI", "Failed to update loading progress", e);
    }
}
