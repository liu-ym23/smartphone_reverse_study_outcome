package pp9;

import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r4) {
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r4) != 0) goto L5;
        boolean r0 = true;
    L6:
        FLogger.a.i("AlbumPermissionUtils", "[checkSelfPermission] " + r4 + ':' + r0);
        return r0;
    L5:
        r0 = false;
        goto L6
    }
}
