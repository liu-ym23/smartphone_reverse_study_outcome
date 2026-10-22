package f4a;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends fx7.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    /* JADX INFO: renamed from: f4a.a$a, reason: collision with other inner class name */
    public static final class C0089a {
        @JvmStatic
        public static Map a(a r4) {
            Intrinsics.checkNotNullParameter(r4, LynxResourceModule.DATA_KEY);
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("platform", r4.a);
            r0.put("platform_app_id", r4.b);
            String r1 = r4.a;
            int r2 = r1.hashCode();
            if (r2 == (-1325936172)) goto L16;
            if (r2 == (-1240244679)) goto L13;
            if (r2 == (-791575966)) goto L10;
        L17:
            r0.put("access_token", r4.e);
        L19:
            return r0;
        L10:
            if (r1.equals("weixin") == false) goto L17;
        L18:
            r0.put(LynxResourceModule.CODE_KEY, r4.d);
            goto L19
        L13:
            if (r1.equals("google") == false) goto L17;
            r0.put("access_token_secret", r4.c);
            goto L19
        L16:
            if (r1.equals("douyin") == true) goto L18;
            goto L17
        }
    }

    static {
    }

    public a() {
        this.a = NameKeys.UnloadStrategy_No_Strategy;
        this.b = NameKeys.UnloadStrategy_No_Strategy;
        this.c = NameKeys.UnloadStrategy_No_Strategy;
        this.d = NameKeys.UnloadStrategy_No_Strategy;
        this.e = NameKeys.UnloadStrategy_No_Strategy;
    }
}
