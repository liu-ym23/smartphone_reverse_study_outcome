package rqb;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(Object r4) {
        if ((r4 instanceof ReadableMap) == false) goto L16;
        HashMap r5 = ((ReadableMap) r4).toHashMap();
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L14;
        Iterator r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) r6.next();
        String r2 = (String) r1.getKey();
        r0.put(r2, a(r1.getValue()));     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        Log.e("BridgeUtils", e.toString());
    L14:
        return r0;
    L16:
        if ((r4 instanceof ReadableArray) == false) goto L23;
        ArrayList r7 = ((ReadableArray) r4).toArrayList();
        JSONArray r3 = new JSONArray();
        if (r7 == null) goto L22;
        int r8 = r7.size();
        int r9 = 0;
    L20:
        if (r9 >= r8) goto L22;
        r3.put(a(ListProtector.get(r7, r9)));
        r9 = r9 + 1;
    L22:
        return r3;
    L23:
        return r4;
    }

    public static JavaOnlyMap b(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        JavaOnlyMap r0 = JavaOnlyMap.from(r4);
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r5.next();
        String r2 = (String) r1.getKey();
        Object r3 = r1.getValue();
        if ((r3 instanceof Map) == false) goto L4;
        if ((r3 instanceof JavaOnlyMap) == true) goto L4;
        Intrinsics.checkNotNull(r0);
        r0.put(r2, b((Map) r3));
        goto L4
    L10:
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
