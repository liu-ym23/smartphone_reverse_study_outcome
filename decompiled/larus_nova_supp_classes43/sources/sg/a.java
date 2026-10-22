package sg;

import cl.d;
import com.bytedance.android.ec.sdk.helper.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r1, Object r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r10, "defaultValue");
        Intrinsics.checkNotNullParameter(r11, "origin");
        d r0 = k.a();
        if (r0 == null) goto L6;
        r0.a(r1, r10, r11);
    L6:
        return r11.invoke();
    }
}
