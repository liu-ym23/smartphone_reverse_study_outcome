package s32;

import com.bytedance.android.livesdk.config.d8;
import com.bytedance.android.livesdk.config.y00;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final Map<Integer, ImageRecognitionBusiness> a = null;

    static {
        a = new HashMap();
    }

    public static void a(int r3, ImageRecognitionBusiness r4) {
        Intrinsics.checkNotNullParameter(r4, "business");
        int r0 = b.a;
        y00 r1 = y00.a;
        if (((d8) r1.getValue()).a() == false) goto L9;
        List r2 = ((d8) r1.getValue()).f();
        boolean r5 = true;
        if (r2 != null) goto L7;
    L10:
        if (r5 == false) goto L12;
        ((HashMap) a).put(Integer.valueOf(r3), new d(r4));
        int r6 = f.a;
        f.b("register business for scene " + r3);
        return;
    L12:
        int r7 = f.a;
        f.a("scene " + r3 + " is disabled");
        return;
    L7:
        if (r2.contains(Integer.valueOf(r3)) != true) goto L10;
    L9:
        r5 = false;
        goto L10
    }
}
