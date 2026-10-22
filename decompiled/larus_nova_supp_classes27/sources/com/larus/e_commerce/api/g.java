package com.larus.e_commerce.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.api.IShareService;
import com.larus.platform.service.z2;
import com.larus.share.service.e;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements com.larus.bmhome.share.panel.d {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IShareService c;
    public final /* synthetic */ FragmentActivity d;

    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    public final void f() {
    }

    public final void onDismiss() {
    }

    public final void e(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public g(e r1, String r2, IShareService r3, FragmentActivity r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final boolean b(Context r8, DialogFragment r9, View r10, jr9.a r11) {
        Intrinsics.checkNotNullParameter(r11, "shareItemConfig");
        if (Intrinsics.areEqual(r11.b(), "copy_link") == true) goto L5;
        return false;
    L5:
        String r12 = this.a.b.c;
        if (r12 == null) goto L8;
        String r13 = StringsKt.trim(r12).toString();
    L9:
        String r2 = "";
        if (r13 != null) goto L13;
        r13 = "";
    L13:
        if (r13.length() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        int r14 = ECommerceRouterInterceptor.c;
        return false;
    L19:
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        String r5 = z2.a.getSaasShareConfig().a();
        if (r5 == null) goto L23;
        r2 = r5;
    L23:
        String r15 = String.format(r2, Arrays.copyOf(new Object[]{this.b, r13}, 2));
        IShareService r0 = this.c;
        e r6 = this.a;
        r0.s(r6.a, "copy_link", r6.c, null);
        IShareService r1 = this.c;
        if (r8 != null) goto L26;
        r8 = this.d;
    L26:
        r1.o(r8, r15);
        this.c.d("copy_link", "url", this.a.b.k, "1");
        if (r9 != null) goto L36;
    L34:
        int r16 = ECommerceRouterInterceptor.c;
        return true;
    L36:
        r9.dismissAllowingStateLoss();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r17 = DialogFragmentLancet.sLastShowStack;
        if (r17 == null) goto L34;
        com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L34
    L15:
        r3 = false;
        goto L16
    L8:
        r13 = null;
        goto L9
    }
}
