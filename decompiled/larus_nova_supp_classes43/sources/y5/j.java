package y5;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ai.utils.l;
import com.bytedance.ai.utils.o;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements x5.a {
    public final AppletPopupSchemaParam a;
    public final View b;

    @Override // x5.a
    public final void invoke() {
        int r0 = this.a.getRealWidth(this.b.getContext());
        ViewGroup.LayoutParams r1 = this.b.getLayoutParams();
        if (r0 <= 0) goto L5;
        r0 = RangesKt.coerceAtMost(r0, l.c(null));
    L10:
        r1.width = r0;
        return;
    L5:
        if (r0 != 0) goto L10;
        if (Intrinsics.areEqual(this.a.getRealGravity(this.b.getContext()), "center") == false) goto L9;
        int r10 = o.a;
        r0 = o.b(this.b.getContext(), 300.0d);
        goto L10
    L9:
        r0 = -1;
        goto L10
    }

    public j(AppletPopupSchemaParam r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "view");
        this.a = r10;
        this.b = r11;
    }
}
