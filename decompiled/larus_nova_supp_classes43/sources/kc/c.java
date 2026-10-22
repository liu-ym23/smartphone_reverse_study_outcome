package kc;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int c = 0;
    public final Map<String, ? extends BcmParams> a;
    public final Map<String, ? extends BcmParams> b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof c) == false) goto L10;
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<String, ? extends BcmParams> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Map<String, ? extends BcmParams> r12 = this.b;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        JSONObject r0 = new JSONObject();
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L24
        Map<String, ? extends BcmParams> r11 = this.a;     // Catch: Throwable -> L22
        if (r11 == null) goto L11;
        Iterator<Map.Entry<String, ? extends BcmParams>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r12.hasNext() == false) goto L11;
        Map.Entry<String, ? extends BcmParams> r13 = r12.next();     // Catch: Throwable -> L22
        r10.put(r13.getKey(), r13.getValue().toJSONObject());     // Catch: Throwable -> L22
    L11:
        r0.put(AIStateLogRequest.SOURCE_PAGE, r10);     // Catch: Throwable -> L24
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L24
        Map<String, ? extends BcmParams> r15 = this.b;     // Catch: Throwable -> L23
        if (r15 == null) goto L19;
        Iterator<Map.Entry<String, ? extends BcmParams>> r16 = r15.entrySet().iterator();     // Catch: Throwable -> L23
    L16:
        if (r16.hasNext() == false) goto L19;
        Map.Entry<String, ? extends BcmParams> r17 = r16.next();     // Catch: Throwable -> L23
        r14.put(r17.getKey(), r17.getValue().toJSONObject());     // Catch: Throwable -> L23
    L19:
        r0.put("unit", r14);     // Catch: Throwable -> L24
    L21:
        return r0.toString();
    }

    public c(Map<String, ? extends BcmParams> r1, Map<String, ? extends BcmParams> r10) {
        this.a = r1;
        this.b = r10;
    }
}
