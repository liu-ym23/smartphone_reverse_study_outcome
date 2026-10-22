package v19;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i7 implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0<Unit> b;

    public i7(View r1, com.larus.bmhome.chat.component.bottom.core.l7 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.a.removeOnLayoutChangeListener(this);
        this.b.invoke();
    }
}
