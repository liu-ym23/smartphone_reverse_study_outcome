package zka;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n {
    public final AtomicLong a;

    public static final class a {
    }

    static {
    }

    public n() {
        this.a = new AtomicLong(-1);
        Application r0 = AppHost.a.getApplication();
        o r2 = new o(this, new Handler(Looper.getMainLooper()));
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r0.getContentResolver().registerContentObserver(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider/server_alive"), false, r2);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static long a(Context r3) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Bundle r4 = r3.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_GET_FEATURES, null, null);     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        Long r5 = Long.valueOf(r4.getLong(WindowEvent.Params.RESULT));     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == true) goto L15;
        r0 = r6;
    L15:
        Long r2 = (Long) r0;
        if (r2 != null) goto L22;
        return 0;
    L22:
        return r2.longValue();
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final boolean b(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (this.a.get() != (-1)) goto L6;
        this.a.set(a(r6));
    L6:
        if ((this.a.get() & 1) <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if ((a(r5) & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
