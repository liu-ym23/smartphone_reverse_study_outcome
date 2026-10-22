package com.suite.lark.platform.feature.forward.doubao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.forwardv3.configuration.Forward$Source;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public u() {
    }

    public static void a(Context r2, ForwardTemplateNew r3, int r4, ExternalForwardSendMode r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = -1;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "template");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "template");
        int r7 = r3.getForwardSelectConfig().c;
        ForwardSelectConfig.a r0 = new ForwardSelectConfig.a();
        r0.b = false;
        r0.a = false;
        r0.c = r7;
        r3.setForwardSelectConfig(r0.a());
        if (r5 == null) goto L11;
    L14:
        Intent r8 = new Intent(r2, ForwardDoubaoActivity.class);
        boolean r1 = r2 instanceof Activity;
        if (r1 == true) goto L17;
        r8.addFlags(268435456);
    L17:
        r8.putExtra("key_intent_forward_template_new", r3);
        r8.putExtra("extra_external_forward_send_mode", r5.name());
        if (r1 == false) goto L20;
        Log.w("NewForward", "source fragment is null, which may affect the processing of returned");
        ((Activity) r2).startActivityForResult(r8, r4);
        return;
    L20:
        r2.startActivity(r8);
        return;
    L11:
        if (r3.getSource() != Forward$Source.DOUBAO) goto L13;
        r5 = ExternalForwardSendMode.DOUBAO_ENTRY;
        goto L14
    L13:
        r5 = ExternalForwardSendMode.MIXED_EXTERNAL_TARGET;
        goto L14
    }
}
