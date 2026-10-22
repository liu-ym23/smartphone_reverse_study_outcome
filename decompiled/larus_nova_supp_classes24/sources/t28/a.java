package t28;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import u28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final s28.a a;
    public final b b;
    public final Rect c;

    public a(u28.a r3) {
        s28.a r0 = new s28.a();
        this.c = new Rect();
        this.b = r3;
        this.a = r0;
    }

    public final void a(RecyclerView r6, Canvas r7, View r8, Rect r9) {
        r7.save();
        if (r6.getLayoutManager().getClipToPadding() == false) goto L9;
        Rect r0 = this.c;
        this.a.getClass();
        s28.a.a(r0, r8);
        if (((u28.a) this.b).a(r6) != 1) goto L7;
        r0.set(r6.getPaddingLeft(), r6.getPaddingTop(), (r6.getWidth() - r6.getPaddingRight()) - r0.right, r6.getHeight() - r6.getPaddingBottom());
    L8:
        r7.clipRect(this.c);
        goto L9
    L7:
        r0.set(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getWidth() - r6.getPaddingRight(), (r6.getHeight() - r6.getPaddingBottom()) - r0.bottom);
    L9:
        r7.translate(r9.left, r9.top);
        r8.draw(r7);
        r7.restore();
    }
}
