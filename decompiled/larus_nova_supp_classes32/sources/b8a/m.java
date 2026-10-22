package b8a;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.react.bridge.ReadableMap;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public static l e(ReadableMap r6) {
        HashMap<String, Object> r0 = r6.asHashMap();
        String r1 = (String) r0.get(EasyGoDbTable.Server.NAME);
        String r2 = (String) r0.get("entryType");
        if (r2.equals("pipeline") == false) goto L8;
        if (r1.equals("updateTriggeredByBts") == false) goto L8;
        n r3 = new n(r6.asHashMap());
        r3.c = true;
        return r3;
    L8:
        if (r2.equals("pipeline") == false) goto L13;
        if (r1.equals("updateTriggeredByNative") == false) goto L13;
        n r4 = new n(r6.asHashMap());
        r4.c = true;
        return r4;
    L13:
        if (r2.equals("pipeline") == false) goto L18;
        if (r1.equals("reactLynxHydrate") == false) goto L18;
        n r5 = new n(r6.asHashMap());
        r5.c = true;
        return r5;
    L18:
        if (r2.equals("pipeline") == false) goto L23;
        if (r1.equals("setNativeProps") == false) goto L23;
        n r7 = new n(r6.asHashMap());
        r7.c = true;
        return r7;
    L23:
        if (r2.equals("pipeline") == false) goto L28;
        if (r1.equals("updateGlobalProps") == false) goto L28;
        n r8 = new n(r6.asHashMap());
        r8.c = true;
        return r8;
    L28:
        if (r2.equals("pipeline") == false) goto L33;
        if (r1.equals("loadBundle") == false) goto L33;
        f r9 = new f(r6.asHashMap());
        r9.c = true;
        return r9;
    L33:
        if (r2.equals("init") == false) goto L38;
        if (r1.equals("container") == false) goto L38;
        b r10 = new b(r6.asHashMap());
        r10.c = true;
        return r10;
    L38:
        if (r2.equals("init") == false) goto L43;
        if (r1.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L43;
        c r11 = new c(r6.asHashMap());
        r11.c = true;
        return r11;
    L43:
        if (r2.equals("init") == false) goto L48;
        if (r1.equals("backgroundRuntime") == false) goto L48;
        a r12 = new a(r6.asHashMap());
        r12.c = true;
        return r12;
    L48:
        if (r2.equals("metric") == false) goto L53;
        if (r1.equals("fcp") == false) goto L53;
        j r13 = new j(r6.asHashMap());
        r13.c = true;
        return r13;
    L53:
        if (r2.equals("metric") == false) goto L58;
        if (r1.equals("fsp") == false) goto L58;
        k r14 = new k(r6.asHashMap());
        r14.c = true;
        return r14;
    L58:
        if (r2.equals("metric") == false) goto L63;
        if (r1.equals("actualFmp") == false) goto L63;
        i r15 = new i(r6.asHashMap());
        r15.c = true;
        return r15;
    L63:
        if (r2.equals("pipeline") == false) goto L68;
        if (r1.equals("reloadBundleFromNative") == false) goto L68;
        o r16 = new o(r6.asHashMap());
        r16.c = true;
        return r16;
    L68:
        if (r2.equals("pipeline") == false) goto L73;
        if (r1.equals("reloadBundleFromBts") == false) goto L73;
        o r17 = new o(r6.asHashMap());
        r17.c = true;
        return r17;
    L73:
        if (r2.equals("memory") == false) goto L78;
        if (r1.equals("memory") == false) goto L78;
        g r18 = new g(r6.asHashMap());
        r18.c = true;
        return r18;
    L78:
        if (r2.equals("resource") == false) goto L83;
        if (r1.equals("lazyBundle") == false) goto L83;
        e r19 = new e(r6.asHashMap());
        r19.c = true;
        return r19;
    L83:
        if (r2.equals("jsBlocking") == true) goto L85;
    L87:
        l r20 = new l(r6.asHashMap());
        r20.c = false;
        return r20;
    L85:
        if (r1.equals("jsBlocking") == false) goto L87;
        d r21 = new d(r6.asHashMap());
        r21.c = true;
        return r21;
    }

    public static Long c(HashMap r2, Long r3) {
        Object r4 = r2.get("sizeBytes");
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Long) == false) goto L10;
        return (Long) r4;
    L10:
        if ((r4 instanceof Number) == false) goto L14;
        return Long.valueOf(((Number) r4).longValue());
    L14:
        if ((r4 instanceof String) == false) goto L19;
        return Long.valueOf(CastLongProtector.parseLong((String) r4));
    L17:
        return r3;
    L19:
        if ((r4 instanceof Boolean) == true) goto L21;
        return r3;
    L21:
        return Long.valueOf(((Boolean) r4).booleanValue() ? 1 : 0);
    }

    public static String d(HashMap r0, String r1) {
        Object r2 = r0.get(r1);
        if (r2 != null) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        if ((r2 instanceof String) == false) goto L11;
        return (String) r2;
    L11:
        return String.valueOf(r2);
    }

    public static Boolean a(HashMap<String, Object> r0, String r1, Boolean r2) {
        Object r3 = r0.get(r1);
        if (r3 != null) goto L6;
        return r2;
    L6:
        if ((r3 instanceof Boolean) == false) goto L10;
        return (Boolean) r3;
    L10:
        if ((r3 instanceof Number) == false) goto L18;
        if (((Number) r3).intValue() == 0) goto L14;
        boolean r4 = true;
    L16:
        return Boolean.valueOf(r4);
    L14:
        r4 = false;
        goto L16
    L18:
        if ((r3 instanceof String) == true) goto L20;
        return r2;
    L20:
        return Boolean.valueOf(Boolean.parseBoolean((String) r3));
    }

    public static Double b(HashMap<String, Object> r0, String r1, Double r2) {
        Object r3 = r0.get(r1);
        if (r3 != null) goto L6;
        return r2;
    L6:
        if ((r3 instanceof Double) == false) goto L10;
        return (Double) r3;
    L10:
        if ((r3 instanceof Number) == false) goto L14;
        return Double.valueOf(((Number) r3).doubleValue());
    L14:
        if ((r3 instanceof String) == false) goto L19;
        return Double.valueOf(CastDoubleProtector.parseDouble((String) r3));
    L17:
        return r2;
    L19:
        if ((r3 instanceof Boolean) == true) goto L21;
        return r2;
    L21:
        return Double.valueOf(((Boolean) r3).booleanValue() ? 1.0d : 0.0d);
    }
}
