package dn8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.h0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Lazy a;
    public final h0 b;

    public c(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new a(r2));
        this.b = new h0();
    }
}
