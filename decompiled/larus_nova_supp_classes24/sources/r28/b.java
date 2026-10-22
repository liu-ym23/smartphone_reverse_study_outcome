package r28;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import q28.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements a {
    public final c a;
    public final LongSparseArray<View> b;
    public final u28.b c;
    public final Point d;
    public final Rect e;
    public final Point f;
    public final Rect g;

    public b(c r3, u28.a r4) {
        this.b = new LongSparseArray();
        this.d = new Point(-1, -1);
        this.e = new Rect(-1, -1, -1, -1);
        this.f = new Point(-1, -1);
        this.g = new Rect(-1, -1, -1, -1);
        this.a = r3;
        this.c = r4;
    }

    public final View a(RecyclerView r6, int r7) {
        long r0 = this.a.getHeaderId(r7);
        View r2 = (View) this.b.get(r0);
        if (r2 != null) goto L12;
        c r3 = this.a;
        if ((r3 instanceof q28.b) == false) goto L7;
        RecyclerView.ViewHolder r4 = ((q28.b) r3).m0();
    L8:
        this.a.onBindHeaderViewHolder(r4, r7);
        r2 = r4.itemView;
        if (r2.getLayoutParams() != null) goto L11;
        r2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L11:
        this.b.put(r0, r2);
        goto L12
    L7:
        r4 = r3.onCreateHeaderViewHolder(r6);
    L12:
        this.f.set(r6.getWidth(), r6.getHeight());
        this.g.set(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getPaddingRight(), r6.getPaddingBottom());
        Point r8 = this.d;
        Point r1 = this.f;
        if (r8 == r1) goto L15;
    L16:
        r8.set(r1.x, r1.y);
        this.e.set(this.g);
        if (((u28.a) this.c).a(r6) != 1) goto L19;
        int r9 = View.MeasureSpec.makeMeasureSpec(r6.getWidth(), 1073741824);
        int r5 = View.MeasureSpec.makeMeasureSpec(r6.getHeight(), 0);
    L20:
        r2.measure(ViewGroup.getChildMeasureSpec(r9, r6.getPaddingLeft() + r6.getPaddingRight(), r2.getLayoutParams().width), ViewGroup.getChildMeasureSpec(r5, r6.getPaddingTop() + r6.getPaddingBottom(), r2.getLayoutParams().height));
        r2.layout(0, 0, r2.getMeasuredWidth(), r2.getMeasuredHeight());
    L21:
        return r2;
    L19:
        r9 = View.MeasureSpec.makeMeasureSpec(r6.getWidth(), 0);
        r5 = View.MeasureSpec.makeMeasureSpec(r6.getHeight(), 1073741824);
        goto L20
    L15:
        if (this.e == this.g) goto L21;
        goto L16
    }
}
