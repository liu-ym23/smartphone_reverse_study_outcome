package com.larus.drive.sdk.impl.view.preview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.larus.common_ui.dialog.l0;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.share.service.IShareDoubaoForwardService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements com.larus.bmhome.share.panel.d {
    public final /* synthetic */ AiFilePreviewShareSheet a;
    public final /* synthetic */ com.larus.bmhome.share.panel.c b;
    public final /* synthetic */ com.larus.drive.sdk.impl.store.a c;
    public final /* synthetic */ String d;

    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    public final void f() {
    }

    public final void onDismiss() {
        FLogger.a.i("AiFilePreviewShare", "share panel dismissed");
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void e(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public c(AiFilePreviewShareSheet r1, com.larus.bmhome.share.panel.c r2, com.larus.drive.sdk.impl.store.a r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Type inference failed for: r10v7, types: [com.larus.drive.sdk.impl.view.preview.b] */
    public final boolean b(Context r9, DialogFragment r10, View r11, jr9.a r12) {
        Intrinsics.checkNotNullParameter(r12, "shareItemConfig");
        String r13 = r12.b();
        if (r13 == null) goto L73;
        int r14 = r13.hashCode();
        if (r14 == (-1879227763)) goto L54;
        String r2 = null;
        if (r14 == 1397633267) goto L29;
        if (r14 == 1406022185) goto L12;
        return false;
    L12:
        if (r13.equals("save_local") == false) goto L75;
        FLogger r15 = FLogger.a;
        r15.i("AiFilePreviewShare", "share channel clicked, channel=save_local");
        AiFilePreviewShareSheet r16 = this.a;
        AiFilePreviewShareSheet.a r0 = AiFilePreviewShareSheet.j;
        Bundle r1 = r16.getArguments();
        if (r1 == null) goto L17;
        r2 = r1.getString("download_request_key");
    L17:
        if (r2 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == false) goto L27;
        r15.w("AiFilePreviewShare", "request download unavailable, reason=request_key_missing");
        Context r17 = r16.getContext();
        if (r17 == null) goto L68;
        s.a.g(r17, 2131889802, false);
    L68:
        return true;
    L27:
        r16.getParentFragmentManager().setFragmentResult(r2, Bundle.EMPTY);
        r15.i("AiFilePreviewShare", "request download dispatched");
        AiFilePreviewShareSheet.S90(r16);
        goto L68
    L19:
        if (StringsKt.isBlank(r2) == true) goto L22;
        r3 = false;
        goto L23
    L75:
        return false;
    L29:
        if (r13.equals("save_cloud") == false) goto L76;
        FLogger r18 = FLogger.a;
        r18.i("AiFilePreviewShare", "share channel clicked, channel=save_cloud");
        final AiFilePreviewShareSheet r4 = this.a;
        com.larus.drive.sdk.impl.store.a r5 = this.c;
        String r6 = this.d;
        if (r4.h == false) goto L34;
        r18.i("AiFilePreviewShare", "skip save to space, reason=request_in_flight");
        goto L68
    L34:
        final Context r7 = r4.getContext();
        if (r7 == null) goto L68;
        IOfficeSdkServiceV2 r8 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r8 == null) goto L42;
        gk5.e r20 = r8.q0();
        if (r20 == null) goto L42;
        r2 = r20.e7();
    L42:
        if (r2 != null) goto L44;
        r18.w("AiFilePreviewShare", "save to space unavailable, reason=office_space_sdk_missing");
        s.a.g(r7, 2131889534, false);
        goto L68
    L44:
        r4.h = true;
        com.larus.bmhome.share.panel.a r21 = r4.e;
        if (r21 == null) goto L47;
        r21.c("save_cloud", false);
    L47:
        l0 r22 = new l0(r7, 0.0f, false, 6);
        if (DialogLancet.shouldBlockDialogShow(r22) == false) goto L71;
        DialogLancet.handleBlockedDialogShow(r22);
    L52:
        r4.g = r22;
        FLogger.a.i("AiFilePreviewShare", "save to space started");
        r2.d(r5.a.getCurrent().getToken(), r6, new b(r4, r7));
        goto L68
    L71:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L70
    L51:
        DialogLancet.beforeDialogShow(r22);
        r22.show();
        DialogLancet.afterDialogShow(r22);
        goto L52
    L76:
        return false;
    L54:
        if (r13.equals("message_forward") == false) goto L77;
        FLogger r23 = FLogger.a;
        r23.i("AiFilePreviewShare", "share channel clicked, channel=message_forward");
        AiFilePreviewShareSheet r110 = this.a;
        com.larus.bmhome.share.panel.c r24 = this.b;
        AiFilePreviewShareSheet.a r25 = AiFilePreviewShareSheet.j;
        Context r26 = r110.getContext();
        if (r26 == null) goto L68;
        IShareDoubaoForwardService r27 = (IShareDoubaoForwardService) ServiceManager.get().getService(IShareDoubaoForwardService.class);
        if (r27 != null) goto L62;
    L64:
        boolean r28 = false;
    L65:
        if (r28 == false) goto L67;
        r23.i("AiFilePreviewShare", "open file forward picker, result=accepted");
        AiFilePreviewShareSheet.S90(r110);
        goto L68
    L67:
        r23.w("AiFilePreviewShare", "open file forward picker, result=unavailable");
        s.a.g(r26, 2131908171, false);
        goto L68
    L62:
        if (r27.f(r26, r24) != true) goto L64;
        r28 = true;
        goto L65
    L77:
        return false;
    L73:
        return false;
    }
}
