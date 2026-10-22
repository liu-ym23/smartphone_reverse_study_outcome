package ve8;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "what");
        return GsonProtectorUtils.toJson(new Gson(), r1);
    }
}
