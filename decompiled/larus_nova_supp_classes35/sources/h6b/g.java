package h6b;

import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.span.KeyIconUrlInfo;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.RichUrlInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.lark.widget.span.f0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final g b = null;
    public final /* synthetic */ k6b.a a;

    static {
        b = new g();
    }

    public final void b(UrlCardPreviewEntity r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        this.a.getClass();
        k6b.a.a(r2, r3);
    }

    public g() {
        this.a = k6b.a.a;
    }

    public final String a(List<Long> r5) {
        Intrinsics.checkNotNullParameter(r5, "longList");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "longList");
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        long r1 = ((Number) r6.next()).longValue();
        StringBuilder r3 = new StringBuilder();
        r3.append(r1);
        r3.append(',');
        r0.append(r3.toString());
        goto L4
    L7:
        return r0.toString();
    }

    public static void c(String r5, UrlPreViewEntries.UrlPreViewSourceType r6, String r7, String r8, String r9, Long r10) {
        Intrinsics.checkNotNullParameter(r5, "sourceId");
        Intrinsics.checkNotNullParameter(r7, "sourceMD5");
        Intrinsics.checkNotNullParameter(r8, "tag");
        StringBuilder r0 = new StringBuilder();
        r0.append(r5);
        r0.append(r9);
        if (r6 == null) goto L5;
        Integer r1 = Integer.valueOf(r6.getValue());
    L6:
        r0.append(r1);
        String r2 = r0.toString();
        if (r10 == null) goto L12;
        String r3 = r2 + '_' + r10.longValue();
        if (r3 == null) goto L12;
        r2 = r3;
    L12:
        RecogniseSpansResult r4 = f0.a.a.a(r2);
        if (r4 == null) goto L42;
        StringBuilder r11 = new StringBuilder("sourceId:");
        r11.append(r5);
        r11.append(", sourceTextMD5:");
        r11.append(r7);
        r11.append(" , sourceType:");
        if (r6 == null) goto L17;
        Integer r12 = Integer.valueOf(r6.getValue());
    L18:
        r11.append(r12);
        r11.append(", privateDescriptionId:");
        r11.append(r10);
        r11.append(", cacheKey:");
        r11.append(r2);
        String r13 = r11.toString() + ", urlInfos = {";
        Iterator r14 = r4.getUrlSpanInfos().iterator();
    L20:
        if (r14.hasNext() == false) goto L34;
        UrlInfo r15 = (UrlInfo) r14.next();
        if ((r15 instanceof KeyIconUrlInfo) == true) goto L25;
        if ((r15 instanceof RichUrlInfo) == false) goto L20;
    L25:
        StringBuilder r16 = new StringBuilder();
        r16.append(r13);
        r16.append("{start:");
        r16.append(((SpanInfo) r15).start);
        r16.append(", end:");
        r16.append(((SpanInfo) r15).end);
        r16.append(",url length:");
        String r17 = r15.href;
        if (r17 == null) goto L28;
        Integer r18 = Integer.valueOf(r17.length());
    L29:
        r16.append(r18);
        r16.append("，title.length:");
        String r19 = ((SpanInfo) r15).text;
        if (r19 == null) goto L32;
        Integer r20 = Integer.valueOf(r19.length());
    L33:
        r16.append(r20);
        r16.append("},");
        r13 = r16.toString();
        goto L20
    L32:
        r20 = null;
        goto L33
    L28:
        r18 = null;
        goto L29
    L34:
        Log.i(r8, r13 + '}');
        return;
    L17:
        r12 = null;
        goto L18
    L42:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
