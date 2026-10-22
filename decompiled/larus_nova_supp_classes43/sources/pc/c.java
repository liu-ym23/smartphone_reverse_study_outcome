package pc;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final boolean a(List<String> r10, List<String> r11) {
        if (r10.size() == r11.size()) goto L5;
        return false;
    L5:
        Iterator<String> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        if (r11.contains(r12.next()) == true) goto L7;
        return false;
    L11:
        return true;
    }
}
