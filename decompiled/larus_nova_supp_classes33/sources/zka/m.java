package zka;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m {
    public final AtomicBoolean a;
    public final CopyOnWriteArraySet<Messenger> b;

    public m() {
        this.a = new AtomicBoolean(false);
        this.b = new CopyOnWriteArraySet();
    }

    public final boolean a(Context r5, Messenger r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "messenger");
        this.b.add(r6);
        Context r0 = r5.getApplicationContext();
        if (this.a.compareAndSet(false, true) == false) goto L18;
        l r2 = new l(this, r0, new Handler(Looper.getMainLooper()));
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        r0.getContentResolver().registerContentObserver(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider/server_alive"), false, r2);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        Bundle r4 = new Bundle();     // Catch: Exception -> L15
        r4.putParcelable("alarmTtsMessenger", r6);     // Catch: Exception -> L15
        Bundle r7 = r5.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_REGISTER_ALARM_TTS_MESSENGER, null, r4);     // Catch: Exception -> L15
        if (r7 == null) goto L20;
        return r7.getBoolean("accepted", false);
    L20:
        return false;
    L21:
        return false;
    }
}
