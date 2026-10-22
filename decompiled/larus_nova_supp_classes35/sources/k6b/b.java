package k6b;

import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.URLPreviewTemplate;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponents;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import j6b.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static void a(UrlCardPreviewEntity r3, ArrayList r4, HashMap r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "urlPreviewEntity");
        Intrinsics.checkNotNullParameter(r4, "templateList");
        Intrinsics.checkNotNullParameter(r5, "previewEntityNoTemplate");
        Intrinsics.checkNotNullParameter(r6, "previewId");
        UrlPreviewBody r0 = r3.getPreviewBody();
        if (r0 == null) goto L5;
        UrlPreviewComponents r1 = r0.getUrlPreviewComponents();
    L6:
        if (r1 == null) goto L8;
        return;
    L8:
        UrlPreviewBody r2 = r3.getPreviewBody();
        if (r2 == null) goto L20;
        Map<String, UrlPreviewState> r7 = r2.getStates();
        if (r7 == null) goto L28;
        Iterator<Map.Entry<String, UrlPreviewState>> r8 = r7.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L29;
        Map.Entry<String, UrlPreviewState> r9 = r8.next();
        String r10 = r9.getKey();
        UrlPreviewState r11 = r9.getValue();
        if (r11 == null) goto L14;
        LruCache<String, URLPreviewTemplate> r12 = l.a;
        if (l.a(r11.getTemplateId()) != null) goto L14;
        r4.add(r11.getTemplateId());
        r5.put(r6, r3);
        goto L14
    L29:
        return;
    L28:
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
