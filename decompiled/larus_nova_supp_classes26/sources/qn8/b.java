package qn8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.standarduikit.splitline.view.SplitLineView;
import jc8.d;
import jc8.e;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pn8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public c d;

    public final String c() {
        return "SpliteLineBlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r5) {
        Intrinsics.checkNotNullParameter((a) r5, "blockModel");
        sn8.a r6 = new sn8.a(new Pair(0, 0));
        c r0 = this.d;
        if (r0 == null) goto L18;
        Intrinsics.checkNotNullParameter(r6, "vmData");
        sn8.b r3 = (sn8.b) r0.c.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "vmData");
        r3.a = r6;
        sn8.a r7 = ((sn8.b) r0.c.getValue()).a;
        if (r7 != null) goto L7;
        rn8.a r8 = new rn8.a(null);
    L8:
        ((sn8.b) r0.c.getValue()).getClass();
        rn8.b r2 = new rn8.b();
        SplitLineView r1 = (SplitLineView) r0.b.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "input");
        Intrinsics.checkNotNullParameter(r2, "output");
        Pair<Integer, Integer> r4 = r8.a;
        if (r4 == null) goto L11;
        int r9 = ((Number) r4.getFirst()).intValue();
    L12:
        Pair<Integer, Integer> r10 = r8.a;
        if (r10 == null) goto L15;
        int r11 = ((Number) r10.getSecond()).intValue();
    L16:
        r1.setPadding(0, r9, 0, r11);
        return;
    L15:
        r11 = 0;
        goto L16
    L11:
        r9 = 0;
        goto L12
    L7:
        r8 = new rn8.a(r7.a);
        goto L8
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        c r0 = new c(r2.getContext());
        this.d = r0;
        return (SplitLineView) r0.b.getValue();
    }
}
