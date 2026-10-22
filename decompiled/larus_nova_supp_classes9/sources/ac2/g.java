package ac2;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static String a(com.ss.ugc.live.sdk.msg.network.g r4) {
            Intrinsics.checkNotNullParameter(r4, "httpResponse");
            List r5 = r4.c;
            if (r5 == null) goto L15;
            Iterator r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L10;
            Object r0 = r6.next();
            if (StringsKt.equals("x-tt-logid", ((com.ss.ugc.live.sdk.msg.network.d) r0).a, true) == false) goto L6;
        L11:
            com.ss.ugc.live.sdk.msg.network.d r1 = (com.ss.ugc.live.sdk.msg.network.d) r0;
            if (r1 == null) goto L15;
            String r7 = r1.b;
            if (r7 == null) goto L15;
            return r7;
        L10:
            r0 = null;
        L15:
            return "not exist";
        }
    }

    static {
    }
}
