package s5;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements h37.e {
    public a() {
    }

    public final SharedPreferences a(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        return new f(r10, r11);
    }
}
