package com.larksuite.component.card.component.text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ UniversalCardTextLynxUI a;

    public r(UniversalCardTextLynxUI r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        UniversalCardTextLynxUI r9 = this.a;
        int r0 = UniversalCardTextLynxUI.g;
        Context r1 = r9.getLynxContext().getContext();
        com.ss.android.lark.widget.select.g r2 = r9.a;
        if (r2 == null) goto L5;
        CharSequence r3 = r2.a;
    L6:
        Token r4 = new Token("LARK-PSDA-openplatform-android-copy-card-detail");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "token");
        if (TextUtils.isEmpty(r3) == true) goto L15;
        Object r5 = r1.getSystemService("clipboard");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.content.ClipboardManager");
        qf7.a.a.a((ClipboardManager) r5, ClipData.newPlainText("", com.ss.android.lark.utils.o.c(r3)), r4);     // Catch: Exception -> L11 SensitiveAPIException -> L13
        UDToast.show(r1, 2131891640);     // Catch: Exception -> L11 SensitiveAPIException -> L13
    L13:
        e = move-exception;
        UDToast.show(r1, 2131891032);
        Log.e("UniversalCardTextLynxUI", "copy failed: " + e.getMessage());
    L11:
        e = move-exception;
        Log.e("UniversalCardTextLynxUI", e, true);
    L15:
        com.ss.android.lark.widget.select.m r6 = r9.b;
        if (r6 == null) goto L18;
        r6.a();
    L18:
        com.ss.android.lark.widget.select.m r7 = r9.b;
        if (r7 == null) goto L21;
        r7.h();
    L21:
        PopupWindow r10 = (PopupWindow) r9.d.getValue();
        PopupWindowLancet.handleDismissBeforeOrigin(r10);
        r10.dismiss();
        return;
    L5:
        r3 = null;
        goto L6
    }
}
