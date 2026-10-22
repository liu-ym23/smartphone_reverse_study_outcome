package xk8;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements lc8.b {
    public final vk8.b a;
    public final Lazy b;

    public final View getView() {
        return (View) this.b.getValue();
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new vk8.b(r2);
        this.b = LazyKt.lazy(new a(this));
    }

    public final void a(FileCardVMData r2, lc8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a.a(r2, r3);
    }
}
