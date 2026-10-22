package s62;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        a r0 = this.a;
        boolean r3 = ((Boolean) r2).booleanValue();
        r0.c = r3;
        if (r3 == false) goto L9;
        yo2.e r4 = r0.d;
        if (r4 == null) goto L15;
        View r5 = r4.e();
        if (r5 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r5);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        yo2.e r6 = r0.d;
        if (r6 == null) goto L18;
        View r7 = r6.e();
        if (r7 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r7);
        return;
    L19:
        return;
    }
}
