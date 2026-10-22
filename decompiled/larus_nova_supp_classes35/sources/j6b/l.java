package j6b;

import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.URLPreviewTemplate;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l {
    public static final LruCache<String, URLPreviewTemplate> a = null;

    static {
        a = new LruCache(30);
    }

    public static UrlPreviewTemplate a(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        URLPreviewTemplate r11 = a.get(r10);
        if (r11 == null) goto L12;
        byte[] r12 = r11.encode();
        URLPreviewTemplate r13 = (URLPreviewTemplate) URLPreviewTemplate.ADAPTER.decode(r12);
        int r1 = a.a;
        if (r13 != null) goto L11;
        return null;
    L11:
        return new UrlPreviewTemplate(r13.root_component_id, a.a(r13.elements, null), r13.image_ids, r13.at_ids, r13.button_ids, r13.richtext_ids, r13.template_id);
    L12:
        return null;
    }
}
