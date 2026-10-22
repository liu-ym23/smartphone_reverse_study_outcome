package c;

import android.graphics.Rect;
import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.u0;

/* JADX INFO: loaded from: classes.dex */
public final class h0 extends com.obric.oui.orecyclerview.widget.h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1055a;

    @Override // com.obric.oui.orecyclerview.widget.h0
    public final void a(Rect r5, View r10, RecyclerView r11, u0 r12) {
        if (r11.D(r10) != (r12.b() - 1)) goto L6;
        int r13 = this.f1055a;
    L5:
        r5.bottom = r13;
        return;
    L6:
        r13 = 0;
        goto L5
    }
}
