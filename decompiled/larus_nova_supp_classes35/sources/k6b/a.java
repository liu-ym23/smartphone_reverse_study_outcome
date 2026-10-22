package k6b;

import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntry;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponents;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static String d(List r3) {
        Intrinsics.checkNotNullParameter(r3, "stringList");
        StringBuilder r0 = new StringBuilder();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.append(((String) r4.next()) + ',');
        goto L4
    L7:
        return r0.toString();
    }

    public static void a(UrlCardPreviewEntity r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        if (r4 == null) goto L43;
        UrlInlinePreviewEntity r0 = r4.getInlineEntity();
        StringBuilder r1 = new StringBuilder("sourceId:");
        r1.append(r0.getSourceId());
        r1.append(", previewId: ");
        r1.append(r0.getPreviewId());
        r1.append(", version:");
        r1.append(r0.getVersion());
        r1.append(",needReload:");
        r1.append(r0.getNeedReload());
        r1.append(", currentStateID:");
        UrlPreviewBody r2 = r4.getPreviewBody();
        if (r2 == null) goto L7;
        String r3 = r2.getCurrentStateId();
    L8:
        r1.append(r3);
        r1.append(",TitleCount:");
        String r6 = r0.getTitle();
        if (r6 == null) goto L11;
        Integer r7 = Integer.valueOf(r6.length());
    L12:
        r1.append(r7);
        r1.append(", isSdkPreview:");
        r1.append(r0.isSdkPreview());
        String r8 = r1.toString();
        UrlPreviewBody r9 = r4.getPreviewBody();
        if (r9 == null) goto L15;
        UrlPreviewComponents r10 = r9.getUrlPreviewComponents();
    L16:
        if (r10 == null) goto L26;
        StringBuilder r11 = new StringBuilder();
        r11.append(r8);
        r11.append(" ,componentsCount:");
        UrlPreviewBody r12 = r4.getPreviewBody();
        if (r12 == null) goto L24;
        UrlPreviewComponents r13 = r12.getUrlPreviewComponents();
        if (r13 == null) goto L24;
        Map<String, UrlPreviewComponent> r14 = r13.getElements();
        if (r14 == null) goto L24;
        Integer r15 = Integer.valueOf(r14.size());
    L25:
        r11.append(r15);
        r8 = r11.toString();
    L24:
        r15 = null;
    L26:
        String r16 = r8 + " ,statesInfo:{";
        UrlPreviewBody r17 = r4.getPreviewBody();
        if (r17 == null) goto L38;
        Map<String, UrlPreviewState> r18 = r17.getStates();
        if (r18 == null) goto L38;
        Iterator<Map.Entry<String, UrlPreviewState>> r19 = r18.entrySet().iterator();
    L32:
        if (r19.hasNext() == false) goto L38;
        Map.Entry<String, UrlPreviewState> r20 = r19.next();
        StringBuilder r21 = new StringBuilder();
        r21.append(r16);
        r21.append("{ stateId:");
        r21.append(r20.getKey());
        r21.append(", tempalteId:");
        UrlPreviewState r22 = r20.getValue();
        if (r22 == null) goto L36;
        String r23 = r22.getTemplateId();
    L37:
        r21.append(r23);
        r21.append(" },");
        r16 = r21.toString();
        goto L32
    L36:
        r23 = null;
    L38:
        Log.i(r5, r16 + '}');
        return;
    L15:
        r10 = null;
        goto L16
    L11:
        r7 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    }

    public static void c(UrlPreViewEntries r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "urlPreViewEntries");
        Intrinsics.checkNotNullParameter(r4, "tag");
        String r0 = ("sourceId:" + r3.getSourceId() + ", sourceTextMD5:" + r3.getSourceTextMD5() + " , sourceType:" + r3.getSourceType()) + ", entryInfo = {";
        Iterator<T> r5 = r3.getEntryList().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        UrlPreViewEntry r1 = (UrlPreViewEntry) r5.next();
        r0 = r0 + "{ offset:" + r1.getOffset() + ", length:" + r1.getLength() + ", previewId:" + r1.getPreviewId() + " },";
        goto L4
    L6:
        Log.i(r4, r0 + '}');
    }

    public static void b(UrlInlinePreviewEntity r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (r1 == null) goto L10;
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
        r0.append(", sourceId:");
        r0.append(r1.getSourceId());
        r0.append(", previewId: ");
        r0.append(r1.getPreviewId());
        r0.append(", version:");
        r0.append(r1.getVersion());
        r0.append(",needReload:");
        r0.append(r1.getNeedReload());
        r0.append(", TitleCount:");
        String r4 = r1.getTitle();
        if (r4 == null) goto L7;
        Integer r5 = Integer.valueOf(r4.length());
    L8:
        r0.append(r5);
        r0.append(", isSdkPreview:");
        r0.append(r1.isSdkPreview());
        Log.i(r2, r0.toString());
        return;
    L7:
        r5 = null;
        goto L8
    }
}
