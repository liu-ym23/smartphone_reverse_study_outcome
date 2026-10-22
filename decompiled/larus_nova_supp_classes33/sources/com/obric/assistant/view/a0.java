package com.obric.assistant.view;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricBannerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a0 implements View.OnClickListener {
    public final /* synthetic */ ObricUpdateBannerPopupWindow a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ Function1 c;

    public /* synthetic */ a0(ObricUpdateBannerPopupWindow r1, Activity r2, sba.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r11v4, types: [com.obric.assistant.view.f0] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.assistant.view.g0] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.assistant.view.d0] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        final ObricUpdateBannerPopupWindow r12 = this.a;
        FragmentActivity r0 = this.b;
        final Function1 r1 = this.c;
        r12.getClass();
        FLogger.a.i("ObricUpdateBannerPopupWindow", "onCloseUpdateClick, hostId=" + r12.a + ", bannerType=" + ObricUpdateBannerPopupWindow.e());
        ObricUpdateBannerPopupWindow.g("click_cancel");
        final ObricBannerType r2 = ObricUpdateBannerPopupWindow.e();
        final ?? r3 = new d0(r12, r1, r2);
        if (r2 != ObricBannerType.DOWNLOADING) goto L26;
        ?? r13 = new f0(r3);
        ?? r4 = new g0();
        CommonDialog.a r5 = new CommonDialog.a();
        AppHost.Companion r6 = AppHost.a;
        r5.i(r6.getApplication().getString(2131912657));
        r5.g(r6.getApplication().getString(2131912656));
        Unit r9 = null;
        com.larus.common_ui.dialog.f0 r7 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(r6.getApplication().getResources().getColor(2131101300)), null, 5);
        Intrinsics.checkNotNullParameter(r7, "commonDialogTextStyleConfig");
        r5.D = r7;
        CommonDialog.a.f(r5, new i0(r13), r6.getApplication().getString(2131912655), false, 12);
        CommonDialog.a.e(r5, new j0(r4), r6.getApplication().getString(2131912654), 4);
        Function0 r14 = new x();
        Intrinsics.checkNotNullParameter(r14, "callback");
        r5.B = r14;
        r5.z = false;
        CommonDialog r15 = r5.a();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L21
        if ((r0 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r10 = r0;     // Catch: Throwable -> L21
    L9:
        if (r10 == null) goto L19;
        IObricUpdateService r16 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Throwable -> L21
        if (r16 == null) goto L13;
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L21
        r17.put("source", "stop_download");     // Catch: Throwable -> L21
        r17.put("popup_type", "stop_download");     // Catch: Throwable -> L21
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r16.h("obric_upgrade_popup_show", r17);     // Catch: Throwable -> L21
    L13:
        FragmentManager r19 = r10.getSupportFragmentManager();     // Catch: Throwable -> L21
        LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L21
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, null, r20);     // Catch: Throwable -> L21
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r15, r20) == false) goto L29;
    L18:
        r9 = Unit.INSTANCE;     // Catch: Throwable -> L21
        goto L19
    L29:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28 Throwable -> L21
    L17:
        r15.show(r19, null);     // Catch: Throwable -> L21
    L19:
        Object r110 = Result.constructor-impl(r9);     // Catch: Throwable -> L21
    L23:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L33;
        FLogger.a.e("ObricUpdateBannerPopupWindow", "showCancelDownloadDialog, error: " + r111.getMessage(), r111);
        return;
    L33:
        return;
    L8:
        r10 = null;
    L21:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L26:
        r3.invoke(Boolean.FALSE);
    }
}
