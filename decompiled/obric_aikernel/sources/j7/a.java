package j7;

import com.bytedance.lego.init.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m3.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9776a = null;

    static {
        f9776a = new a();
    }

    private a() {
    }

    public final Map<String, String> a() {
        Map<String, g> r10 = k.g();
        if (r10 != null) goto L5;
        r10 = MapsKt.emptyMap();
    L5:
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Map.Entry<String, g>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L17;
        Map.Entry<String, g> r13 = r12.next();
        boolean r14 = false;
        if (r13.getValue().f11041s == true) goto L15;
        String r15 = r13.getKey();
        Intrinsics.checkNotNullExpressionValue(r15, "it.key");
        if (StringsKt.endsWith$default(r15, "_START", false, 2, null) == true) goto L15;
        String r16 = r13.getKey();
        Intrinsics.checkNotNullExpressionValue(r16, "it.key");
        if (StringsKt.endsWith$default(r16, "_END", false, 2, null) == true) goto L15;
        r14 = true;
    L15:
        if (r14 == false) goto L7;
        r11.put(r13.getKey(), r13.getValue());
        goto L7
    L17:
        ArrayList r17 = new ArrayList(r11.size());
        Iterator r18 = r11.entrySet().iterator();
    L19:
        if (r18.hasNext() == false) goto L22;
        Map.Entry r19 = (Map.Entry) r18.next();
        r17.add(TuplesKt.to(r19.getKey(), String.valueOf(((g) r19.getValue()).f11040r)));
        goto L19
    L22:
        return MapsKt.toMap(r17);
    }
}
