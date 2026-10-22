package qk8;

import android.content.Context;
import com.larus.bmhome.block.newheader.foldcontainer.FolderContainerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import uk8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements hb8.a {
    public final Lazy a;
    public final Lazy b;

    public final void f() {
        ((f) this.b.getValue()).f();
        ((FolderContainerView) this.a.getValue()).f();
    }

    public c(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new a(r2));
        this.b = LazyKt.lazy(new b());
    }
}
