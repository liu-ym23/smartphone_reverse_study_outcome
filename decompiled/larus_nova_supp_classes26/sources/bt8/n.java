package bt8;

import android.view.View;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpCommandWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n implements View.OnLayoutChangeListener {
    public final /* synthetic */ KmpCommandWidget a;
    public final /* synthetic */ cq8.i b;
    public final /* synthetic */ com.larus.bmhome.actionbar.model.c c;

    public n(KmpCommandWidget r1, cq8.i r2, com.larus.bmhome.actionbar.model.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        KmpCommandWidget.Y5(this.a, this.b, this.c);
    }
}
