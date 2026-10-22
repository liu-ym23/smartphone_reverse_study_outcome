package x8;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements d {
    public c() {
    }

    @Override // x8.d
    public final void e(String r10, Throwable r11) {
        HybridLogger r0 = HybridLogger.a;
        String r1 = "unknown";
        if (r10 != null) goto L5;
        String r12 = "unknown";
    L6:
        if (r11 == null) goto L12;
        String r13 = r11.getMessage();
        if (r13 == null) goto L12;
        r1 = r13;
    L12:
        if (HybridLogger.c(r12, r1, LogLevel.E) == false) goto L14;
        return;
    L14:
        ALog.e(r10, r11);
        return;
    L5:
        r12 = r10;
        goto L6
    }

    @Override // x8.d
    public final void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        HybridLogger r0 = HybridLogger.a;
        if (HybridLogger.c(r10, r11, LogLevel.I) == false) goto L5;
        return;
    L5:
        ALog.i(r10, r11);
    }

    @Override // x8.d
    public final void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        HybridLogger r0 = HybridLogger.a;
        if (HybridLogger.c(r10, r11, LogLevel.E) == false) goto L5;
        return;
    L5:
        ALog.e(r10, r11);
    }
}
