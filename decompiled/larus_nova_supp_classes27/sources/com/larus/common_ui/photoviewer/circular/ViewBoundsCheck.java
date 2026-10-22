package com.larus.common_ui.photoviewer.circular;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ViewBoundsCheck {
    public final b a;
    public final a b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;

        public final boolean a() {
            int r0 = this.a;
            int r2 = 2;
            if ((r0 & 7) == 0) goto L14;
            int r1 = this.d;
            int r6 = this.b;
            if (r1 <= r6) goto L7;
            int r3 = 1;
        L11:
            if (((r3 << 0) & r0) != 0) goto L14;
            return false;
        L7:
            if (r1 != r6) goto L9;
            r3 = 2;
            goto L11
        L9:
            r3 = 4;
        L14:
            if ((r0 & 112) == 0) goto L25;
            int r4 = this.d;
            int r7 = this.c;
            if (r4 <= r7) goto L18;
            int r5 = 1;
        L22:
            if (((r5 << 4) & r0) != 0) goto L25;
            return false;
        L18:
            if (r4 != r7) goto L20;
            r5 = 2;
            goto L22
        L20:
            r5 = 4;
        L25:
            if ((r0 & 1792) == 0) goto L36;
            int r8 = this.e;
            int r9 = this.b;
            if (r8 <= r9) goto L29;
            int r10 = 1;
        L33:
            if (((r10 << 8) & r0) != 0) goto L36;
            return false;
        L29:
            if (r8 != r9) goto L31;
            r10 = 2;
            goto L33
        L31:
            r10 = 4;
        L36:
            if ((r0 & 28672) == 0) goto L46;
            int r11 = this.e;
            int r12 = this.c;
            if (r11 <= r12) goto L40;
            r2 = 1;
        L44:
            if ((r0 & (r2 << 12)) != 0) goto L46;
            return false;
        L40:
            if (r11 == r12) goto L44;
            r2 = 4;
        L46:
            return true;
        }

        public a() {
            this.a = 0;
        }
    }

    public interface b {
    }

    public ViewBoundsCheck(LooperHorizontalLinearLayoutManager.a r1) {
        this.a = r1;
        this.b = new a();
    }

    public final View a(int r9, int r10, int r11, int r12) {
        int r0 = ((LooperHorizontalLinearLayoutManager.a) this.a).a.getPaddingLeft();
        LooperHorizontalLinearLayoutManager.a r1 = (LooperHorizontalLinearLayoutManager.a) this.a;
        int r2 = r1.a.getWidth() - r1.a.getPaddingRight();
        if (r10 <= r9) goto L5;
        int r3 = 1;
    L6:
        View r4 = null;
    L7:
        if (r9 == r10) goto L18;
        View r5 = ((LooperHorizontalLinearLayoutManager.a) this.a).a.getChildAt(r9);
        LooperHorizontalLinearLayoutManager.a r6 = (LooperHorizontalLinearLayoutManager.a) this.a;
        r6.getClass();
        RecyclerView.LayoutParams r7 = r5.getLayoutParams();
        int r8 = r6.a.getDecoratedLeft(r5) - ((ViewGroup.MarginLayoutParams) r7).leftMargin;
        LooperHorizontalLinearLayoutManager.a r13 = (LooperHorizontalLinearLayoutManager.a) this.a;
        r13.getClass();
        RecyclerView.LayoutParams r14 = r5.getLayoutParams();
        int r15 = r13.a.getDecoratedRight(r5) + ((ViewGroup.MarginLayoutParams) r14).rightMargin;
        a r16 = this.b;
        r16.b = r0;
        r16.c = r2;
        r16.d = r8;
        r16.e = r15;
        if (r11 == 0) goto L13;
        r16.a = r11 | 0;
        if (r16.a() == false) goto L13;
        return r5;
    L13:
        if (r12 == 0) goto L17;
        a r17 = this.b;
        r17.a = r12 | 0;
        if (r17.a() == false) goto L17;
        r4 = r5;
    L17:
        r9 = r9 + r3;
        goto L7
    L18:
        return r4;
    L5:
        r3 = -1;
        goto L6
    }
}
