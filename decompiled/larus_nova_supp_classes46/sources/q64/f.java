package q64;

import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final String a;
    public final Map<String, String> b;

    public f(Map r3) {
        Intrinsics.checkNotNullParameter(ByteNetEnvHeaderName.PPE, "byteNetEnvHeaderName");
        Intrinsics.checkNotNullParameter(r3, "ppeConfigs");
        this.a = ByteNetEnvHeaderName.PPE;
        this.b = r3;
    }

    public final String a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "url");
        if (this.b.keySet().contains(r6) == true) goto L5;
        Iterator<T> r0 = this.b.keySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) r0.next();
        if (StringsKt.startsWith$default(r6, r1, false, 2, null) == false) goto L8;
        return this.b.get(r1);
    L13:
        return null;
    L5:
        return this.b.get(r6);
    }
}
