package edb;

import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final UrlPreviewComponent a(PreviewHangPoint r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        UrlCardPreviewEntity r5 = r4.getUrlCardPreviewEntity();
        Object r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        UrlPreviewBody r1 = r5.getPreviewBody();
        if (r1 == null) goto L37;
        String r2 = r1.getCurrentStateId();
        if (r2 == null) goto L40;
        UrlPreviewTemplate r6 = r5.getPreviewBody().getTemplates().get(r2);
        if (r6 != null) goto L13;
        return null;
    L13:
        Map<String, UrlPreviewComponent> r7 = r6.getElements();
        if (r7 == null) goto L38;
        Collection<UrlPreviewComponent> r8 = r7.values();
        if (r8 == null) goto L39;
        Iterator<T> r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L31;
        Object r3 = r9.next();
        UrlPreviewComponent r10 = (UrlPreviewComponent) r3;
        if (r10 == null) goto L23;
        Type r11 = r10.getType();
    L25:
        if (r11 != Type.DOC_IMAGE) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L19;
        r0 = r3;
        goto L31
    L27:
        r12 = false;
        goto L28
    L23:
        r11 = null;
    L31:
        return (UrlPreviewComponent) r0;
    L39:
        return null;
    L38:
        return null;
    L40:
        return null;
    L37:
        return null;
    }
}
