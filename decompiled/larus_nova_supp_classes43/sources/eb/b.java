package eb;

import com.lynx.tasm.q1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends q1 {
    public final Function0<Unit> a;
    public final Function0<Unit> b;

    public final void onFirstScreen() {
        super.onFirstScreen();
        this.b.invoke();
    }

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        this.a.invoke();
    }

    public b(Function0<Unit> r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "onLoadSuccessOuter");
        Intrinsics.checkNotNullParameter(r11, "onFirstScreenOuter");
        this.a = r10;
        this.b = r11;
    }
}
