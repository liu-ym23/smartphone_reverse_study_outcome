package uy8;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a() {
        int r1 = la9.a.a;
        AtomicReference r2 = ga9.a.a;
        return new a(c.a(ga9.a.a("enabled_quick_input_entries", new JSONArray("[]"))), ga9.a.b("quick_input_attachment_add_enable", false), ga9.a.b("quick_input_data_protocol_enable", false));
    }

    public static boolean c() {
        return a().c;
    }

    public static boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        int r1 = la9.a.a;
        AtomicReference r2 = ga9.a.a;
        Set<String> r3 = c.a(ga9.a.a("enabled_preview_scenes", new JSONArray("[]")));
        boolean r4 = c();
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r3, "enabledScenes");
        if (r3.contains(r5) == false) goto L24;
        int r0 = r5.hashCode();
        if (r0 == (-1963501277)) goto L19;
        if (r0 == (-1176625545)) goto L15;
        if (r0 == 92896879) goto L12;
    L20:
        r4 = false;
    L21:
        if (r4 == false) goto L25;
        return true;
    L25:
        return false;
    L12:
        if (r5.equals("album") == true) goto L21;
    L15:
        if (r5.equals("camera_result") == false) goto L20;
        r4 = true;
        goto L21
    L19:
        if (r5.equals("attachment") == true) goto L21;
    L24:
        return false;
    }
}
