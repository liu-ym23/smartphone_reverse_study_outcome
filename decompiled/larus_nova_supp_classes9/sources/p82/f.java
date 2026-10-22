package p82;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements ak6.e {
    public final /* synthetic */ b.e a;

    public f(b.e r1) {
        this.a = r1;
    }

    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    public final void b(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        if (r2.a == null) goto L13;
        TextView r0 = this.a.a.l;
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r0);
    L7:
        TextView r1 = this.a.a.l;
        if (r1 == null) goto L10;
        r1.setText(r2.a);
    L10:
        b r3 = this.a.a;
        TextView r4 = r3.l;
        if (r4 == null) goto L17;
        r3.h(r4);
        return;
    L17:
        return;
    L13:
        TextView r5 = this.a.a.l;
        if (r5 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r5);
        return;
    }
}
