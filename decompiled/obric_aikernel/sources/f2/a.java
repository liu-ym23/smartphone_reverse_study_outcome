package f2;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.message.log.PushLog;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Context r10, String r11, Bundle r12) {
        PushLog.onEventV3Bundle(r10, r11, r12);     // Catch: Throwable -> L4
        return;
    }
}
