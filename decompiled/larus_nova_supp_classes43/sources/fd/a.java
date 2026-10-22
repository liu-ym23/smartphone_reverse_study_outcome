package fd;

import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.util.f;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<String, PageInfoStack> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static void a(Object r10, PageProp r11, boolean r12) {
        if (r11.getSingleton() == true) goto L5;
        return;
    L5:
        String r13 = BtmPageRecorder.a;
        PageInfoStack r14 = BtmPageRecorder.m(r10, r12);
        String r15 = r10.getClass().getName();
        Map<String, PageInfoStack> r0 = a;
        PageInfoStack r1 = (PageInfoStack) ((LinkedHashMap) r0).get(r15);
        if (r1 != null) goto L8;
        r0.put(r15, r14);
        return;
    L8:
        String r16 = r14.getBtmPre();
        if (r16 != null) goto L11;
    L14:
        boolean r17 = true;
    L15:
        if (r17 == false) goto L17;
        BtmPageRecorder.d.put(new f(r10), r1);
        return;
    L17:
        r0.put(r15, r14);
        return;
    L11:
        if (r16.length() == 0) goto L14;
        r17 = false;
        goto L15
    }
}
