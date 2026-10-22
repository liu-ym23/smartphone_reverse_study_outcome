package com.larus.share.impl.message;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.crash.d;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.PreloadMessageShareHelper;
import com.larus.bmhome.share.network.f;
import com.larus.bmhome.share.panel.b;
import com.larus.bmhome.share.panel.h;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import sr8.c;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class SubConversationShareManager {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public SubConversationShareManager() {
    }

    public static void a(l0 r3) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void b(l0 r2, DialogFragment r3) {
        if (r2 != null) goto L24;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L12;
        if (r2 == null) goto L12;
        a(r2);     // Catch: Exception -> L6
    L12:
        if (r3 == null) goto L26;
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L15
    L28:
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L6
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L6
        if (r4 == null) goto L27;
        d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L6
        return;
    L27:
        return;
    L6:
        e = move-exception;
        FLogger.a.e("SubConversationShareManger", "selfDismiss exception=" + e.getMessage());
        return;
    L26:
        return;
    L24:
        r1 = true;
        if (r2.isShowing() != true) goto L8;
        goto L8
    }

    public static void c(Context r106, final e r107, final BotModel r108, ShareScene r109, by7.e r110) {
        Intrinsics.checkNotNullParameter(r109, "shareScene");
        if (r106 != null) goto L5;
        return;
    L5:
        boolean r0 = r106 instanceof FragmentActivity;
        if (r0 == false) goto L8;
        FragmentActivity r4 = (FragmentActivity) r106;
    L10:
        if (r4 != null) goto L12;
    L20:
        z2 r5 = z2.a;
        if (r5.getShareConfig().p() == false) goto L31;
        final l0 r10 = new l0(r106, 0.0f, false, 6);
        if (r107 == null) goto L25;
        String r14 = r107.a;
    L26:
        final f r11 = new f(r14, null, Boolean.valueOf(r5.getShareConfig().g()), Boolean.FALSE, Boolean.TRUE, 2);
        final PreloadMessageShareHelper r13 = new PreloadMessageShareHelper();
        r13.a(GlobalScope.INSTANCE, r11);
        ShareServiceDelegate r75 = ShareServiceDelegate.b;
        if (r0 == false) goto L29;
        FragmentActivity r76 = (FragmentActivity) r106;
    L30:
        IShareService.a.g(r75, r76, r109, new b(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108863), new h(r107, r108, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -4, -1, 1023), new SubConversationShareManager$shareConversationWithPreload$1(r13, r10, r11, r108, r107), r110, false, 192);
        return;
    L29:
        r76 = null;
        goto L30
    L25:
        r14 = null;
        goto L26
    L31:
        l0 r8 = new l0(r106, 0.0f, false, 6);
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L42;
        DialogLancet.handleBlockedDialogShow(r8);
    L36:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new SubConversationShareManager$shareConversation$1(r106, r108, r107, r109, r110, r8, null), 2, null);
        return;
    L42:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L35:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L36
    L12:
        if (c.a() == false) goto L20;
        l0 r9 = new l0(r4, 0.0f, false, 6);
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r9);
    L18:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new SubConversationShareManager$shareConversationWithCcmPanel$1(r4, r107, r108, r9, null), 2, null);
        return;
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L17:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L18
    L8:
        r4 = null;
        goto L10
    }
}
