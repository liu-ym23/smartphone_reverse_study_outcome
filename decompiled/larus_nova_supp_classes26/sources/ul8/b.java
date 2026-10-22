package ul8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Lazy a;
    public final h b;

    public b(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new a(r2));
        this.b = new h();
    }
}
