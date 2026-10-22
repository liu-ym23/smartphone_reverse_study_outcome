package com.bytedance.android.ec.core.utils.rotation;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CommonLog {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(CommonLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(Function0 r10) {
        Intrinsics.checkNotNullParameter("tryWaitValidActivityCreatedWithErrorMessage", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L15;
        dm.a.b r0 = dm.a.a("common_log_tryWaitValidActivityCreatedWithErrorMessage");     // Catch: Exception -> L10
        String r11 = (String) r10.invoke();     // Catch: Exception -> L10
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        r0.a(r11);     // Catch: Exception -> L10
        return;
    }
}
