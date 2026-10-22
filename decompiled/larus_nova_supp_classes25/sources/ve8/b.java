package ve8;

import com.larus.platform.service.z2;
import java.util.Iterator;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final String a(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        Iterator r1 = z2.a.W3().iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        if (new Regex((String) r1.next()).containsMatchIn(r4) == false) goto L13;
        return r4;
    L17:
        return null;
    L4:
        if (StringsKt.isBlank(r4) == true) goto L7;
        r0 = false;
        goto L9
    }
}
