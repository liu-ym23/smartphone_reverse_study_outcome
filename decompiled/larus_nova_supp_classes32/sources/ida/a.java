package ida;

import android.view.View;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import hda.c1;
import hda.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements k5<u> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r8, com.obric.assistant.cocreationreview.a r9) {
        u r10 = (u) r9;
        Intrinsics.checkNotNullParameter(r8, "buildContext");
        Intrinsics.checkNotNullParameter(r10, "record");
        String r4 = c1.c(r10.g);
        if (r4 != null) goto L5;
        View r11 = new View(r8.getContext());
        r11.setVisibility(8);
        return r11;
    L5:
        e1 r12 = e1.a(r10.m, r4, r4, r4, null, 1044455);
        int r0 = hda.c.a;
        int r1 = c.a.e;
        return hda.c.a(r8, r12);
    }
}
