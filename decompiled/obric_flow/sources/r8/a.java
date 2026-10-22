package r8;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.message.log.PushLog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static void a(Context r5, String r10, Bundle r11) {
        PushLog.onEventV3Bundle(r5, r10, r11);     // Catch: Throwable -> L4
        return;
    }
}
