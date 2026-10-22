package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends c {
    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c
    public final int c() {
        return 2131567045;
    }

    public j(InputFunctionEnum r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r4, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "bridges");
        super.t(r4, r5);
        EditText r6 = r5.a;
        if (r6 != null) goto L5;
        return;
    L5:
        int r0 = r6.getSelectionStart();
        int r1 = b72.c.a;
        Editable r2 = r6.getText();
        TokenCert r3 = b72.a.a;
        b72.c.a r7 = b72.c.a(r2, b72.a.d(r5.l0()));
        if (r7 != null) goto L17;
        return;
    L17:
    L13:
        e = move-exception;
        SafetyGuard.a(null, e, "mention input comment failed");
        return;
    L9:
        if ((r7.b + 1) > b72.a.d(r5.l0())) goto L11;
        r6.getEditableText().insert(r0, "@");     // Catch: Exception -> L13
        r5.D0();     // Catch: Exception -> L13
    L16:
        return;
    L11:
        b72.a.e(r5.l0());     // Catch: Exception -> L13
        goto L16
    }
}
