package d80;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LocalComponentXLoadConfig;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static String a;
    public static int b;

    static {
        a = "";
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (v.a() == true) goto L5;
        return;
    L5:
        b++;
        a += "_&_" + r2;
    }

    public static void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "groupKey");
        if (v.a() == true) goto L5;
        return;
    L5:
        e r0 = com.bytedance.android.livesdk.sharedpref.b.Q3;
        if (r0.getValue() != null) goto L8;
        f.d(r0, new ArrayList());
    L8:
        ArrayList r1 = (ArrayList) r0.getValue();
        LocalComponentXLoadConfig r7 = new LocalComponentXLoadConfig(null, null, 0, 7, null);
        r7.setBatch(r8);
        r7.setComponentListStr(a);
        r7.setComponentCount(b);
        Unit r2 = Unit.INSTANCE;
        r1.add(r7);
        ALogger.i("ComponentX_ComponentList", "当前加载的批次是 " + r8 + "  个数为: " + b + " 个");
        ALogger.i("ComponentX_ComponentList", a);
        a = "";
        b = 0;
    }
}
