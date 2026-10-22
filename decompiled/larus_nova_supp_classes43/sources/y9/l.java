package y9;

import android.content.Context;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements o {
    public l() {
    }

    @Override // y9.o
    public final void D0(Context r1, String r10, String r11, Type r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r12, "type");
    }

    @Override // y9.o
    public final void G(Context r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
    }

    @Override // y9.o
    public final void x1(Context r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
    }
}
