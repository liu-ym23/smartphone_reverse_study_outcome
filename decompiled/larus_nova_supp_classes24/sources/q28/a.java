package q28;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final c a;
    public final u28.b b;
    public final r28.a c;
    public final s28.a d;
    public final Rect e;
    public final Rect f;

    /* JADX INFO: renamed from: q28.a$a, reason: collision with other inner class name */
    public class C0121a implements Comparator<b> {
        public C0121a() {
        }

        @Override // java.util.Comparator
        public final int compare(b r1, b r2) {
            return r1.b - r2.b;
        }
    }

    public static class b {
        public final View a;
        public final int b;

        public b(View r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static int b(RecyclerView r1) {
        if (r1.getLayoutManager().getClipToPadding() == true) goto L5;
        return 0;
    L5:
        return r1.getPaddingLeft();
    }

    public static int c(RecyclerView r1) {
        if (r1.getLayoutManager().getClipToPadding() == true) goto L5;
        return 0;
    L5:
        return r1.getPaddingTop();
    }

    public final View a(RecyclerView r9, View r10) {
        boolean r0 = ((u28.a) this.b).b(r9);
        if (r0 == false) goto L5;
        int r2 = -1;
    L6:
        int r3 = 0;
        if (r0 == false) goto L9;
        int r1 = r9.getChildCount() - 1;
    L10:
        ArrayList r4 = new ArrayList(r9.getChildCount());
    L12:
        if (r3 >= r9.getChildCount()) goto L14;
        View r5 = r9.getChildAt(r3);
        r4.add(new b(r5, r9.getChildAdapterPosition(r5)));
        r3 = r3 + 1;
        goto L12
    L14:
        Collections.sort(r4, new C0121a());
    L15:
        if (r1 < 0) goto L28;
        if (r1 > (r9.getChildCount() - 1)) goto L22;
        View r6 = ((b) ListProtector.get(r4, r1)).a;
        if (g(r9, r6, r10, ((u28.a) this.b).a(r9)) == false) goto L20;
        r1 = r1 + r2;
        goto L15
    L20:
        return r6;
    L22:
        return null;
    L28:
        return null;
    L9:
        r1 = 0;
        goto L10
    L5:
        r2 = 1;
        goto L6
    }

    public final boolean d(int r8, boolean r9) {
        if (r8 >= 0) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        long r3 = this.a.getHeaderId(r8);
        if (r3 >= 0) goto L14;
        return false;
    L14:
        if (r9 == false) goto L16;
        int r4 = 1;
    L17:
        int r5 = r4 + r8;
        if (r5 >= 0) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == true) goto L26;
        long r7 = this.a.getHeaderId(r5);
    L27:
        if (r9 == false) goto L29;
        int r10 = this.a.getItemCount() - 1;
    L30:
        if (r8 != r10) goto L32;
    L33:
        return true;
    L32:
        if (r3 != r7) goto L33;
        return false;
    L29:
        r10 = 0;
        goto L30
    L26:
        r7 = -1;
        goto L27
    L20:
        if (r5 >= this.a.getItemCount()) goto L23;
        r6 = false;
        goto L24
    L16:
        r4 = -1;
        goto L17
    L5:
        if (r8 >= this.a.getItemCount()) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean e(View r4, int r5, int r6) {
        s28.a r0 = this.d;
        Rect r1 = this.e;
        r0.getClass();
        s28.a.a(r1, r4);
        if (r5 != 1) goto L5;
        int r7 = r4.getTop();
        int r8 = this.e.top;
    L6:
        if (r7 <= r8) goto L8;
    L10:
        return false;
    L8:
        if (this.a.getHeaderId(r6) < 0) goto L10;
        return true;
    L5:
        r7 = r4.getLeft();
        r8 = this.e.left;
        goto L6
    }

    public a(c r2, r28.b r3, u28.a r4, s28.a r5) {
        this.e = new Rect();
        this.f = new Rect();
        this.a = r2;
        this.c = r3;
        this.b = r4;
        this.d = r5;
    }

    public final boolean g(RecyclerView r5, View r6, View r7, int r8) {
        RecyclerView.LayoutParams r0 = r6.getLayoutParams();
        s28.a r1 = this.d;
        Rect r2 = this.e;
        r1.getClass();
        s28.a.a(r2, r7);
        int r3 = r5.getChildAdapterPosition(r6);
        if (r3 != (-1)) goto L5;
    L16:
        return false;
    L5:
        if (((r28.b) this.c).a(r5, r3) != r7) goto L16;
        if (r8 != 1) goto L12;
        int r9 = r6.getTop() - ((ViewGroup.MarginLayoutParams) r0).topMargin;
        int r10 = c(r5) + r7.getBottom();
        Rect r11 = this.e;
        if (r9 < ((r10 + r11.bottom) + r11.top)) goto L15;
        return false;
    L15:
        return true;
    L12:
        int r12 = r6.getLeft() - ((ViewGroup.MarginLayoutParams) r0).leftMargin;
        int r13 = b(r5) + r7.getRight();
        Rect r14 = this.e;
        if (r12 < ((r13 + r14.right) + r14.left)) goto L15;
        return false;
    }

    public final void f(Rect r7, RecyclerView r8, View r9, View r10, boolean r11) {
        int r0 = ((u28.a) this.b).a(r8);
        s28.a r1 = this.d;
        Rect r2 = this.e;
        r1.getClass();
        s28.a.a(r2, r9);
        ViewGroup.LayoutParams r3 = r10.getLayoutParams();
        boolean r4 = false;
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r3;
        int r6 = r5.leftMargin;
        int r12 = r5.topMargin;
    L7:
        if (r0 != 1) goto L9;
        int r13 = (r10.getLeft() - r6) + this.e.left;
        int r14 = Math.max(((r10.getTop() - r12) - r9.getHeight()) - this.e.bottom, c(r8) + this.e.top);
    L10:
        r7.set(r13, r14, r9.getWidth() + r13, r9.getHeight() + r14);
        if (r11 == false) goto L37;
        View r15 = a(r8, r9);
        int r16 = r8.getChildAdapterPosition(r15);
        if (r16 == (-1)) goto L27;
        boolean r17 = ((u28.a) this.b).b(r8);
        if (r16 <= 0) goto L27;
        if (d(r16, r17) == false) goto L27;
        View r19 = ((r28.b) this.c).a(r8, r16);
        s28.a r20 = this.d;
        Rect r21 = this.e;
        r20.getClass();
        s28.a.a(r21, r19);
        s28.a r22 = this.d;
        Rect r23 = this.f;
        r22.getClass();
        s28.a.a(r23, r9);
        if (((u28.a) this.b).a(r8) != 1) goto L24;
        int r110 = ((r15.getTop() - this.e.bottom) - r19.getHeight()) - this.e.top;
        int r111 = r8.getPaddingTop() + r9.getBottom();
        Rect r24 = this.f;
        if (r110 >= ((r111 + r24.top) + r24.bottom)) goto L27;
    L26:
        r4 = true;
        goto L27
    L24:
        int r112 = ((r15.getLeft() - this.e.right) - r19.getWidth()) - this.e.left;
        int r113 = r8.getPaddingLeft() + r9.getRight();
        Rect r25 = this.f;
        if (r112 < ((r113 + r25.left) + r25.right)) goto L26;
    L27:
        if (r4 == false) goto L38;
        View r114 = a(r8, r9);
        View r115 = ((r28.b) this.c).a(r8, r8.getChildAdapterPosition(r114));
        int r26 = ((u28.a) this.b).a(r8);
        s28.a r27 = this.d;
        Rect r29 = this.e;
        r27.getClass();
        s28.a.a(r29, r115);
        s28.a r30 = this.d;
        Rect r31 = this.f;
        r30.getClass();
        s28.a.a(r31, r9);
        if (r26 != 1) goto L33;
        int r32 = c(r8);
        Rect r33 = this.f;
        int r34 = (r32 + r33.top) + r33.bottom;
        int r116 = r114.getTop() - r115.getHeight();
        Rect r117 = this.e;
        int r118 = (((r116 - r117.bottom) - r117.top) - r9.getHeight()) - r34;
        if (r118 >= r34) goto L39;
        r7.top += r118;
        return;
    L39:
        return;
    L33:
        int r35 = b(r8);
        Rect r36 = this.f;
        int r37 = (r35 + r36.left) + r36.right;
        int r119 = r114.getLeft() - r115.getWidth();
        Rect r120 = this.e;
        int r121 = (((r119 - r120.right) - r120.left) - r9.getWidth()) - r37;
        if (r121 >= r37) goto L41;
        r7.left += r121;
        return;
    L41:
        return;
    L38:
        return;
    L37:
        return;
    L9:
        int r38 = (r10.getTop() - r12) + this.e.top;
        r13 = Math.max(((r10.getLeft() - r6) - r9.getWidth()) - this.e.right, b(r8) + this.e.left);
        r14 = r38;
        goto L10
    L5:
        r12 = 0;
        r6 = 0;
        goto L7
    }
}
