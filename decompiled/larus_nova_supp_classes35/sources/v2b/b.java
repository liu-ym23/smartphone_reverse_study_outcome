package v2b;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.widget.light.layout.TextLayoutViewHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.ss.android.lark.widget.light.viewstub.f {
    public final /* synthetic */ Context b;

    public b(Context r1) {
        this.b = r1;
    }

    public final View a(com.ss.android.lark.widget.light.viewstub.h r2) {
        Intrinsics.checkNotNullParameter(r2, "stubSpan");
        return r2.b(this.b);
    }

    public final void b(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        TextLayoutViewHelperKt.a(r2, r3);
    }
}
