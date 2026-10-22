package p82;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ak6.e {
    public final /* synthetic */ b.c a;

    public c(b.c r1) {
        this.a = r1;
    }

    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    public final void b(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        if (r2.a == null) goto L10;
        TextView r0 = this.a.a.h;
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r0);
    L7:
        TextView r1 = this.a.a.h;
        if (r1 == null) goto L14;
        r1.setText(r2.a);
        return;
    L14:
        return;
    L10:
        TextView r3 = this.a.a.h;
        if (r3 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    }
}
