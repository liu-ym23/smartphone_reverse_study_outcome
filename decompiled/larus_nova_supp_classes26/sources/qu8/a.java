package qu8;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ String b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        Map<String, Boolean> r0 = b.b;
        LinkedHashMap r2 = (LinkedHashMap) r0;
        if (Intrinsics.areEqual(r2.get(this.b), Boolean.FALSE) == false) goto L14;
        r0.put(this.b, Boolean.TRUE);
        String r1 = b.a;
        String r3 = this.b;
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        b.d(r3, 0);
        goto L14
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r4 = false;
    L14:
        return true;
    }

    public a(ConstraintLayout r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
