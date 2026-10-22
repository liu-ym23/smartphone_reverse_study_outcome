package ac2;

import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final z a = null;
    public static final lmc.a b = null;

    public static final class a implements amc.i {
        public a() {
        }

        public final lmc.h c() {
            z r0 = c.a;
            return c.a;
        }

        public final String e() {
            return "https://" + jc1.k.n(IMiddlewareHostNetwork.class).getHostDomain() + "/webcast/im/gw/uplink/message/";
        }

        public final boolean enable() {
            int r0 = k.a;
            return ((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.k.a.getValue()).booleanValue();
        }

        public final long a() {
            return k.a();
        }

        public final boolean b() {
            return k.d();
        }

        public final boolean d() {
            return k.b();
        }
    }

    static {
        z r3 = new z();
        a = r3;
        b = new lmc.a(new a(), r3, new v(), new bc2.e(), new bc2.a("Uplink"));
    }

    @JvmStatic
    public static final String a(com.ss.ugc.live.sdk.msg.network.g r4) {
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
