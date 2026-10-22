package yi8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import jc8.c;
import jc8.d;
import jc8.e;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends jc8.b<a> {
    public TextView d;

    public final String c() {
        return "ArtifactFallbackBlockHolder";
    }

    public b() {
    }

    public final d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    public final void g(jc8.a r8) {
        Intrinsics.checkNotNullParameter((a) r8, "blockModel");
        TextView r9 = this.d;
        if (r9 == null) goto L5;
        r9.setText(AppHost.a.getApplication().getString(2131899295));
    L5:
        TextView r1 = this.d;
        if (r1 == null) goto L17;
        float r2 = i5.o();
        kc8.b r10 = c.a(this, kc8.b.class);
        if (r10 == null) goto L14;
        y r11 = r10.a;
        if (r11 == null) goto L14;
        if (r11.a() != true) goto L14;
        boolean r3 = true;
    L15:
        we8.a.b(r1, r2, r3, null, null, 12);
        return;
    L14:
        r3 = false;
        goto L15
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        TextView r0 = new TextView(r4.getContext());
        this.d = r0;
        r0.setTextColor(v19.c.a(2130972079, r4.getContext(), 2131103136));
        return r0;
    }
}
