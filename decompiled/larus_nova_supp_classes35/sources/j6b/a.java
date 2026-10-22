package j6b;

import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Map<String, UrlPreviewComponent> a(Map<String, URLPreviewComponent> r3, UrlPreviewEntity r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, URLPreviewComponent>> r5 = r3.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<String, URLPreviewComponent> r1 = r5.next();
        r0.put(r1.getKey(), f.f(r1.getValue(), r4));
        goto L7
    L9:
        return r0;
    }
}
