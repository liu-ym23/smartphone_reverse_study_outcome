package d4;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import d3.a0;
import e3.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Map<String, String> a(Map<String, ? extends Object> r10) {
        if (r10 != null) goto L4;
        r10 = MapsKt.emptyMap();
    L4:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L14;
        Map.Entry<String, ? extends Object> r1 = r11.next();
        String r12 = r1.getKey();
        Object r13 = r1.getValue();
        String r14 = StringsKt.trim(r12).toString();
        if (StringsKt.isBlank(r14) == false) goto L10;
        Pair r15 = null;
    L11:
        if (r15 == null) goto L6;
        r0.add(r15);
        goto L6
    L10:
        r15 = TuplesKt.to(r14, d(r13));
        goto L11
    L14:
        return MapsKt.toMap(r0);
    }

    public static final Map<String, String> b(Map<String, ? extends Object> r10) {
        if (r10 != null) goto L4;
        r10 = MapsKt.emptyMap();
    L4:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L20;
        Map.Entry<String, ? extends Object> r1 = r11.next();
        String r12 = r1.getKey();
        Object r13 = r1.getValue();
        String r14 = StringsKt.trim(r12).toString();
        String r15 = d(r13);
        if (StringsKt.isBlank(r14) == false) goto L10;
    L16:
        Pair r16 = null;
    L17:
        if (r16 == null) goto L6;
        r0.add(r16);
        goto L6
    L10:
        if (r15.length() != 0) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == true) goto L16;
        r16 = TuplesKt.to(r14, r15);
        goto L17
    L12:
        r17 = false;
        goto L13
    L20:
        return MapsKt.toMap(r0);
    }

    public static final b c(d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        a0 r11 = r10.getContainerContext();
        if (r11 == null) goto L21;
        String r12 = r11.getAppletId();
        if (r12 != null) goto L7;
        return null;
    L7:
        if (r12.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r12 = null;
    L13:
        if (r12 == null) goto L25;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r13 = AppletAppManagerService.a(r12);
        if (r13 == null) goto L23;
        v r14 = r13.h();
        if (r14 != null) goto L20;
        return null;
    L20:
        return (b) r14.j.getValue();
    L23:
        return null;
    L25:
        return null;
    L9:
        r1 = false;
        goto L10
    L21:
        return null;
    }

    public static final String d(Object r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        if (Intrinsics.areEqual(r1, JSONObject.NULL) == false) goto L7;
        return "";
    L7:
        if ((r1 instanceof String) == false) goto L10;
        return (String) r1;
    L10:
        if ((r1 instanceof Number) == true) goto L31;
        if ((r1 instanceof Boolean) == true) goto L31;
        if ((r1 instanceof JSONObject) == false) goto L18;
        return ((JSONObject) r1).toString();
    L18:
        if ((r1 instanceof JSONArray) == false) goto L21;
        return ((JSONArray) r1).toString();
    L21:
        if ((r1 instanceof Map) == false) goto L24;
        return new JSONObject((Map) r1).toString();
    L24:
        if ((r1 instanceof List) == false) goto L27;
        return new JSONArray((Collection) r1).toString();
    L27:
        if ((r1 instanceof Object[]) == false) goto L40;
        return new JSONArray(ArraysKt.toList((Object[]) r1)).toString();
    L40:
        return r1.toString();
    L31:
        return r1.toString();
    }
}
