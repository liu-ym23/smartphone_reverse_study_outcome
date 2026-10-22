package eh8;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final ConcurrentHashMap<String, InterfaceC0076a> a = null;

    /* JADX INFO: renamed from: eh8.a$a, reason: collision with other inner class name */
    public interface InterfaceC0076a {
        void onResult(boolean r1);
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void b(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        FLogger.a.i("CodeRenderLynxManager", "[unregisterCallback] containerId=".concat(r3));
        a.remove(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void a(String r3, InterfaceC0076a r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        FLogger.a.w("CodeRenderLynxManager", "[registerCallback] skip empty containerId");
        return;
    L10:
        FLogger.a.i("CodeRenderLynxManager", "[registerCallback] containerId=".concat(r3));
        a.put(r3, r4);
        return;
    L5:
        r0 = false;
        goto L7
    }
}
