package ob2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements ek6.b {
    public final List<String> a;

    public final void a() {
    }

    public final String toString() {
        return "LiveGifResource[" + CollectionsKt.joinToString$default(this.a, null, null, null, 3, null, null, 55, null) + ']';
    }

    public a(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "urls");
        this.a = r2;
    }
}
