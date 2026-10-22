package com.bytedance.android.live.profit.format.voicechat.dialog;

import android.app.Activity;
import com.bytedance.bpea.cert.token.TokenCert;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o60.a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void a(Activity r1, final o60.b r2, String[] r3) {
        TokenCert r4 = VoiceChatMicPermissionDialog.b;
        Function1<Boolean, Unit> r5 = new VoiceChatMicPermissionDialog$Companion$requestPermission$1$1(r2);
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        VoiceChatMicPermissionDialog r6 = new VoiceChatMicPermissionDialog(r1);
        r6.a = r5;
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
    }
}
