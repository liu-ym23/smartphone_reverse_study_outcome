package n5a;

import android.content.Context;
import com.lynx.clay.embedding.engine.plugins.platformview.InternalPlatformViewRegistry;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallbackResult;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewPlugin;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements i {
    public final Context a;
    public Context b;
    public final Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> c;

    public b(Context r2) {
        this.c = new HashMap();
        this.a = r2;
    }

    public final void a(int r4, String r5, j r6) {
        InternalPlatformViewRegistry r0 = InternalPlatformViewRegistry.e;
        Context r1 = this.a;
        monitor-enter(r0);
        r0.a();     // Catch: Throwable -> L17
        c r2 = (c) ((LinkedHashMap) r0.a).get(r5);     // Catch: Throwable -> L17
        if (r2 != null) goto L7;
        r2 = (c) ((LinkedHashMap) r0.b).get(r5);     // Catch: Throwable -> L17
    L7:
        if (r2 != null) goto L10;
        monitor-exit(r0);
        com.lynx.clay.embedding.engine.plugins.platformview.a r7 = null;
    L13:
        if ((r7 instanceof o5a.f) == false) goto L15;
        Context r3 = this.b;
        ((o5a.f) r7).h = r3;
    L15:
        r7.o(r6);
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r8 = this.c;
        HashMap r9 = (HashMap) r8;
        r9.put(Integer.valueOf(r4), r7);
        return;
    L10:
        r7 = r2.a(r1, r4, r5);     // Catch: Throwable -> L17
        monitor-exit(r0);
    L17:
        th = move-exception;
        throw th;
    }

    public final void b(int r3, String r4, JSONObject r5, PlatformViewPlugin.b r6) {
        a r0 = new a(r6);
        com.lynx.clay.embedding.engine.plugins.platformview.a r7 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) this.c).get(Integer.valueOf(r3));
        if (r7 != null) goto L5;
        HashMap r8 = new HashMap();
        r8.put("message", r3 + " node not found");
        r0.b(PlatformMethodCallbackResult.NODE_NOT_FOUND, r8);
        return;
    L5:
        if (r7.d(r4, r5, r0) == true) goto L9;
        HashMap r9 = new HashMap();
        r9.put("message", r4 + " method not found");
        r0.b(PlatformMethodCallbackResult.METHOD_NOT_FOUND, r9);
        return;
    }
}
