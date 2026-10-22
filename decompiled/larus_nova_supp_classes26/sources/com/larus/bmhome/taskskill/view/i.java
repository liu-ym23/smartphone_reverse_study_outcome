package com.larus.bmhome.taskskill.view;

import android.app.Application;
import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ PcConnectionStatusManager a;

    public /* synthetic */ i(PcConnectionStatusManager r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        PcConnectionStatusManager r0 = this.a;
        Integer r10 = (Integer) r9;
        FLogger.a.i("PcConnectionStatusManager", "receive completionErrorCodeLiveData change to " + r10);
        r0.getClass();
        int r1 = DispatchErrorCode.DISPATCH_ERROR_CODE_INCOMPATIBLE_COMPLETION_VERSION.value;
        if (r10 != null) goto L6;
    L7:
        int r2 = DispatchErrorCode.DISPATCH_ERROR_CODE_UNKNOWN_COMMAND.value;
        if (r10 != null) goto L11;
    L13:
        int r3 = DispatchErrorCode.DISPATCH_ERROR_CODE_SANDBOX_UNREADY.value;
        if (r10 != null) goto L17;
    L19:
        int r4 = DispatchErrorCode.DISPATCH_ERROR_CODE_SEND_MESSAGE_FAILED.value;
        if (r10 != null) goto L23;
    L25:
        int r5 = DispatchErrorCode.DISPATCH_ERROR_CODE_UNKNOWN_TASK_MODE.value;
        if (r10 != null) goto L29;
    L42:
        return Unit.INSTANCE;
    L29:
        if (r10.intValue() != r5) goto L42;
        int r11 = 2131901726;
    L32:
        long r6 = SystemClock.elapsedRealtime();
        if ((r6 - r0.c) <= 5000) goto L42;
        Long r7 = (Long) ((LinkedHashMap) r0.d).get(Integer.valueOf(r11));
        if (r7 != null) goto L38;
    L40:
        r0.d.put(Integer.valueOf(r11), Long.valueOf(r6));
        t19.s r8 = t19.s.a;
        AppHost.Companion r12 = AppHost.a;
        Application r13 = r12.getApplication();
        String r14 = r12.getApplication().getString(r11);
        r8.getClass();
        t19.s.t(r13, r14);
        goto L42
    L38:
        if ((r6 - r7.longValue()) > 3000) goto L40;
    L23:
        if (r10.intValue() != r4) goto L25;
        r11 = 2131901721;
        goto L32
    L17:
        if (r10.intValue() != r3) goto L19;
        r11 = 2131901738;
        goto L32
    L11:
        if (r10.intValue() != r2) goto L13;
    L31:
        r11 = 2131901739;
        goto L32
    L6:
        if (r10.intValue() == r1) goto L31;
        goto L7
    }
}
