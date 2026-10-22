package gn8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.search.vm.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Context a;
    public final Lazy b;
    public final Lazy c;
    public e d;

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new a());
        this.c = LazyKt.lazy(new b(this));
    }
}
