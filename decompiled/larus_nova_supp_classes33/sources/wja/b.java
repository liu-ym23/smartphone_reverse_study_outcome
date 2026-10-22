package wja;

import android.util.Xml;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(PolarisFileInputStreamWrapper r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "inputStream");
        Intrinsics.checkNotNullParameter(r11, "onFileFound");
        XmlPullParser r0 = Xml.newPullParser();
        r0.setInput(r10, "UTF-8");
        int r12 = r0.getEventType();
    L4:
        if (r12 == 1) goto L35;
        if (r12 != 2) goto L34;
        if (Intrinsics.areEqual(r0.getName(), "file") == false) goto L34;
        String r1 = r0.getAttributeValue(null, "base");
        if (r1 != null) goto L12;
        String r4 = "";
    L13:
        String r2 = r0.getAttributeValue(null, "path");
        if (r2 != null) goto L16;
        String r5 = "";
    L17:
        String r3 = r0.getAttributeValue(null, "relative_path");
        if (r3 != null) goto L20;
        String r9 = r5;
    L21:
        String r6 = r0.getAttributeValue(null, "size");
        if (r6 == null) goto L26;
        Long r7 = StringsKt.toLongOrNull(r6);
        if (r7 == null) goto L26;
        long r8 = r7.longValue();
    L27:
        long r13 = r8;
        String r14 = r0.getAttributeValue(null, "retry_times");
        if (r14 == null) goto L32;
        Integer r15 = StringsKt.toIntOrNull(r14);
        if (r15 == null) goto L32;
        int r16 = r15.intValue();
    L33:
        r11.invoke(new a(r4, r5, r13, r16, r9));
    L32:
        r16 = 5;
    L26:
        r8 = 0;
        goto L27
    L20:
        r9 = r3;
        goto L21
    L16:
        r5 = r2;
        goto L17
    L12:
        r4 = r1;
    L34:
        r12 = r0.next();
        goto L4
    }

    public static void b(Sequence r6, PolarisFileOutputStreamWrapper r7) {
        Intrinsics.checkNotNullParameter(r6, "files");
        Intrinsics.checkNotNullParameter(r7, "outputStream");
        XmlSerializer r0 = Xml.newSerializer();
        r0.setOutput(r7, "UTF-8");
        r0.startDocument("UTF-8", Boolean.TRUE);
        r0.startTag(null, "list");
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        a r2 = (a) r8.next();
        r0.startTag(null, "file");
        r0.attribute(null, "base", r2.a);
        r0.attribute(null, "path", r2.b);
        r0.attribute(null, "relative_path", r2.e);
        r0.attribute(null, "size", String.valueOf(r2.c));
        r0.attribute(null, "retry_times", String.valueOf(r2.d));
        r0.endTag(null, "file");
        r0.flush();
        goto L4
    L6:
        r0.endTag(null, "list");
        r0.endDocument();
        r0.flush();
    }
}
