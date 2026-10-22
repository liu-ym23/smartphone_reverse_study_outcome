package gs1;

import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenUtils;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static boolean a;
    public static final Map<String, ClearScreenUtils> b = null;

    static {
        b = new ConcurrentHashMap();
    }

    public static ClearScreenUtils a(String r3) {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L5;
        r3 = "ScopeClearScreenUtils_SSS_111";
    L5:
        if (r3 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        r3 = "ScopeClearScreenUtils_SSS_111";
    L13:
        Map<String, ClearScreenUtils> r1 = b;
        ClearScreenUtils r2 = (ClearScreenUtils) ((ConcurrentHashMap) r1).get(r3);
        if (r2 == null) goto L16;
        return r2;
    L16:
        monitor-enter(ClearScreenUtils.class);
        ClearScreenUtils r4 = (ClearScreenUtils) ((ConcurrentHashMap) r1).get(r3);     // Catch: Throwable -> L23
        if (r4 != null) goto L20;
        r4 = new ClearScreenUtils(r3);     // Catch: Throwable -> L23
        ((ConcurrentHashMap) r1).put(r3, r4);     // Catch: Throwable -> L23
    L20:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(ClearScreenUtils.class);
        return r4;
    L23:
        th = move-exception;
        throw th;
    L7:
        if (r3.length() == 0) goto L10;
        r0 = false;
        goto L11
    }

    @JvmStatic
    public static final void b(boolean r1) {
        if (ClearScreenHelper.i(null) == true) goto L6;
        a = false;
        return;
    L6:
        a = r1;
    }
}
