package u7;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final FailSubFragmentProxy a(ViewGroup r1, Context r10, Map<String, String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        ((ba.b) Annie.getService(ba.b.class, r12)).I(r10, r1);
        String r13 = r11.get("theme");
        if (Intrinsics.areEqual(r13, "sjb") == false) goto L6;
        return new com.bytedance.android.annie.container.fragment.flavor.fail.c(r10, r1);
    L6:
        if (Intrinsics.areEqual(r13, "dark") == false) goto L8;
        FailSubFragmentProxy r14 = new com.bytedance.android.annie.container.fragment.flavor.fail.a(r10, r1);
        Intrinsics.checkNotNullParameter(r11, "paramsOut");
        ((HashMap) r14.g).clear();
        ((HashMap) r14.g).putAll(r11);
    L10:
        return r14;
    L8:
        r14 = new com.bytedance.android.annie.container.fragment.flavor.fail.b(r10, r1);
        Intrinsics.checkNotNullParameter(r11, "paramsOut");
        ((HashMap) r14.g).clear();
        ((HashMap) r14.g).putAll(r11);
        goto L10
    }

    @JvmStatic
    public static final v7.b b(c r1, ViewGroup r10, Context r11, String r12) {
        Intrinsics.checkNotNullParameter(r1, "configModel");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        ((ba.b) Annie.getService(ba.b.class, r12)).q0(r11, r10);
        return new v7.a(r11, r10);
    }
}
