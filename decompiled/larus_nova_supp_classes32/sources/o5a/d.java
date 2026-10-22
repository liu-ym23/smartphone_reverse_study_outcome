package o5a;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EditText;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends EditText {
    public b a;
    public a b;

    public interface a {
        void a();
    }

    public interface b {
    }

    public d(Context r1) {
        super(r1);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r1) {
        super.onDraw(r1);
        a r2 = this.b;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    public void setOnAfterDrawListener(a r1) {
        this.b = r1;
    }

    public void setOnSelectionChangeListener(b r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r5, int r6) {
        super.onSelectionChanged(r5, r6);
        b r0 = this.a;
        if (r0 == null) goto L8;
        o5a.a.e r1 = (o5a.a.e) r0;
        if (r1.a.c("selectionchange") == false) goto L9;
        HashMap r2 = new HashMap();
        r2.put("start", Integer.valueOf(r5));
        r2.put("end", Integer.valueOf(r6));
        r2.put("direction", "forward");
        r1.a.q("selectionchange", r2);
        return;
    L9:
        return;
    }
}
