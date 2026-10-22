package ek8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.computerusetool.view.ComputerUseToolResultView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final Context a;
    public final Lazy b;
    public ComputerUseToolResultView c;
    public oj8.c d;

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new a());
    }
}
