package com.ss.android.lark.compose.foundation.toast;

import android.os.Handler;
import android.os.Message;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Handler.Callback {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Handler r0 = FlowActionToastManager.a;
        int r4 = r3.what;
        LinkedList<FlowActionToastManager.a> r1 = FlowActionToastManager.b;
        if (r1.isEmpty() == true) goto L11;
        final FlowActionToastManager.a r2 = (FlowActionToastManager.a) CollectionsKt.first(r1);
        if (r2.b != r4) goto L12;
        r2.a.a(new FlowActionToastManager$dismissByTag$1(r2));
        return true;
    L12:
        return true;
    L11:
        return true;
    }
}
