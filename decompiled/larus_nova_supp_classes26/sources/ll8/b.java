package ll8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.BrowserControlView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Context a;
    public final Lazy b;
    public BrowserControlView c;

    public final Context getContext() {
        return this.a;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new a());
    }
}
