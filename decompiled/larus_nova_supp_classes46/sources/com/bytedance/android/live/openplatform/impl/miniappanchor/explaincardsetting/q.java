package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSensitiveResponse;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ ExplainCardTitleEditorDialog a;
    public final /* synthetic */ String b;

    public q(ExplainCardTitleEditorDialog r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Response r9 = (Response) r8;
        int r0 = qo0.a.a;
        qo0.a.c("ExplainCardTitleEditorDialog", "on title check success, response: " + ((StampSensitiveResponse) r9.data));
        String r1 = "";
        if (((StampSensitiveResponse) r9.data).getHit() == false) goto L21;
        TextView r10 = (TextView) this.a.S90(2131385937);
        if (r10 == null) goto L7;
        r10.setVisibility(0);
    L7:
        so0.a r11 = this.a.i;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L10:
        OpenPlatformContext r12 = r11.a();
        if (r12 == null) goto L65;
        AnchorMiniAppAppLogContextService r13 = (AnchorMiniAppAppLogContextService) r12.getService(AnchorMiniAppAppLogContextService.class);
        if (r13 == null) goto L66;
        ExplainCardSettingViewModel r2 = (ExplainCardSettingViewModel) this.a.e.getValue();
        if (r2 == null) goto L20;
        String r3 = r2.getAppId();
        if (r3 == null) goto L20;
        r1 = r3;
    L20:
        r13.reportPageShelfTitleChangeResult(r1, 2);
        return;
    L66:
        return;
    L65:
        return;
    L21:
        ExplainCardSettingViewModel r14 = (ExplainCardSettingViewModel) this.a.e.getValue();
        if (r14 == null) goto L24;
        r14.changeTitle(new ExplainCardSettingViewModel.b(this.a.f, this.b));
    L24:
        TextView r15 = (TextView) this.a.S90(2131385937);
        if (r15 == null) goto L27;
        r15.setVisibility(8);
    L27:
        ExplainCardTitleEditorDialog r16 = this.a;
        Context r4 = r16.getContext();
        View r5 = r16.S90(2131388860);
        if (r4 == null) goto L40;
        if (r5 == null) goto L40;
        Object r6 = r4.getSystemService("input_method");     // Catch: Exception -> L37
        if (r6 == null) goto L36;
        ((InputMethodManager) r6).hideSoftInputFromWindow(r5.getWindowToken(), 0);     // Catch: Exception -> L37
    L39:
        r5.clearFocus();
        goto L40
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L40:
        f2.b(2131921109, 0);
        r16.dismiss();     // Catch: Exception -> L43
    L47:
        so0.a r17 = this.a.i;
        if (r17 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L50:
        OpenPlatformContext r18 = r17.a();
        if (r18 == null) goto L68;
        AnchorMiniAppAppLogContextService r19 = (AnchorMiniAppAppLogContextService) r18.getService(AnchorMiniAppAppLogContextService.class);
        if (r19 == null) goto L69;
        ExplainCardSettingViewModel r7 = (ExplainCardSettingViewModel) this.a.e.getValue();
        if (r7 == null) goto L60;
        String r20 = r7.getAppId();
        if (r20 == null) goto L60;
        r1 = r20;
    L60:
        r19.reportPageShelfTitleChangeResult(r1, 1);
        return;
    L69:
        return;
    L68:
        return;
    L43:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r21 = DialogFragmentLancet.sLastShowStack;
        if (r21 == null) goto L47;
        com.bytedance.crash.d.d(r21, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L47
    }
}
