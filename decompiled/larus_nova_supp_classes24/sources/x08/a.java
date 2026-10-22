package x08;

import android.content.Context;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.compose.foundation.toast.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final g a(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        UDToast.a r0 = UDToast.build(r3);
        r0.b.e(r4);
        r0.e(new UDLoadingDrawable(r3));
        r0.b.d = 2147483647L;
        return r0.a();
    }

    @JvmStatic
    public static final g b(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "text");
        UDToast.a r0 = UDToast.build(r3);
        r0.g(r4);
        r0.e(new UDLoadingDrawable(r3));
        r0.b.d = 2147483647L;
        return r0.a();
    }
}
