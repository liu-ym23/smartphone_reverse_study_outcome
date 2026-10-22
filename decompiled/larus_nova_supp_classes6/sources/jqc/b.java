package jqc;

import android.view.LayoutInflater;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public static void a(LayoutInflater r4) {
        FieldUtils.writeField(r4, "mFactory", null);     // Catch: Throwable -> L5
    L10:
        FieldUtils.writeField(r4, "mFactory2", null);     // Catch: Throwable -> L8
        return;
    L8:
        ZeusLogger.w("Zeus/resources_zeus", "clearFactory failed.");
        return;
    L5:
        ZeusLogger.w("Zeus/resources_zeus", "clearFactory failed.");
        goto L10
    }
}
