package ms.bd.c;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class d4 {
    public static final /* synthetic */ int a = 0;

    static {
        String r0 = (String) p2.a(16777217, 0, 0, "c1c7b9", new byte[]{70, 7, 62, 70, 73, 12, 111, 20, 43, 74, 125, 55, 25, 69, 84, 43, 114});
    }

    public static String a(RequestBody r1) {
        Buffer r0 = new Buffer();     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        r1.writeTo(r0);     // Catch: Exception -> L8
        return r0.readUtf8();
    L6:
        return "";
    }

    public static RequestBody b(RequestBody r16, HashMap r17) {
        String r0 = a(r16);     // Catch: Exception -> L11
        Iterator r1 = r17.keySet().iterator();     // Catch: Exception -> L11
        FormBody.Builder r2 = new FormBody.Builder();     // Catch: Exception -> L11
    L4:
        if (r1.hasNext() == false) goto L6;
        String r3 = (String) r1.next();     // Catch: Exception -> L11
        r2.add(r3, ((String) r17.get(r3)).replaceAll((String) p2.a(16777217, 0, 0, "531ff8", new byte[]{ByteCompanionObject.MAX_VALUE}), (String) p2.a(16777217, 0, 0, "d7e4d9", new byte[]{48, 102, 52})));     // Catch: Exception -> L11
        goto L4
    L6:
        FormBody r4 = r2.build();     // Catch: Exception -> L11
        StringBuilder r5 = new StringBuilder(r0);     // Catch: Exception -> L11
        if (r0.length() <= 0) goto L9;
        r5.append((String) p2.a(16777217, 0, 0, "646373", new byte[]{97}));     // Catch: Exception -> L11
    L9:
        r5.append(a(r4));     // Catch: Exception -> L11
        return RequestBody.create(r16.contentType(), r5.toString());
    L12:
        return r16;
    }
}
