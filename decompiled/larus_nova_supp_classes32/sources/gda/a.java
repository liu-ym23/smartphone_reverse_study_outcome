package gda;

import android.os.Bundle;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void a(Bundle r2, Function1<? super Bundle, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "traceInfo");
        if (r3 == null) goto L5;
        r3.invoke(r2);
    L5:
        o.a.b("obric_card_item_click", r2);
    }
}
