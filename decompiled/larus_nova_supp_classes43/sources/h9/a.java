package h9;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.StringsKt;
import y9.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static p.a a(String r10) {
        p r0 = AnnieConfigSettingKeys.ANNIE_PREFETCH_RES_MODE.a();
        int r1 = r0.a();
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        Object r12 = null;
        if (r11 == true) goto L23;
        if (r1 == 1) goto L24;
        Map<String, p.a> r13 = r0.b();
        Iterator<T> r14 = r13.keySet().iterator();
    L14:
        if (r14.hasNext() == false) goto L19;
        Object r15 = r14.next();
        if (StringsKt.contains$default(r10, (String) r15, false, 2, null) == false) goto L14;
        r12 = r15;
    L19:
        return r13.get(r12);
    L24:
        return null;
    L23:
        return null;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }
}
