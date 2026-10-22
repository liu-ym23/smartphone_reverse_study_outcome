package c62;

import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements h80.d {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final Object get() {
        IHostWebView r0 = jc1.k.f(IHostWebView.class);
        if (r0 == null) goto L30;
        Map r1 = r0.getHeaderMap("https://" + jc1.k.n(IHostNetwork.class).getHostDomain());
        if (r1 == null) goto L30;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r1.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L36;
        Map.Entry r4 = (Map.Entry) r3.next();
        CharSequence r5 = (CharSequence) r4.getKey();
        boolean r6 = true;
        if (r5 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == true) goto L26;
        CharSequence r8 = (CharSequence) r4.getValue();
        if (r8 != null) goto L20;
    L23:
        boolean r9 = true;
    L24:
        if (r9 == true) goto L26;
    L27:
        if (r6 == false) goto L8;
        r2.put(r4.getKey(), r4.getValue());
        goto L8
    L20:
        if (r8.length() == 0) goto L23;
        r9 = false;
    L26:
        r6 = false;
        goto L27
    L12:
        if (r5.length() == 0) goto L15;
        r7 = false;
        goto L16
    L36:
        return r2;
    L30:
        return new HashMap();
    }
}
