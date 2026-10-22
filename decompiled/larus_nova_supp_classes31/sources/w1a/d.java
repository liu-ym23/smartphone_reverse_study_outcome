package w1a;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class d {
    public d() {
    }

    public final d a(KProperty1<?, ?>... r11) {
        Intrinsics.checkNotNullParameter(r11, "properties");
        if ((this instanceof f) == false) goto L6;
        return f.a;
    L6:
        if ((this instanceof h) == false) goto L10;
        return new h(ArraysKt.joinToString$default(r11, ",", ((h) this).a + '_', null, 0, null, new c(), 28, null));
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
