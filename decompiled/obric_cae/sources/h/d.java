package h;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements f, j, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f7861a;

    public static int j(androidx.appcompat.view.menu.e r10, Context r11, int r12) {
        int r8 = 0;
        int r13 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r14 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r15 = r10.getCount();
        int r16 = 0;
        int r17 = 0;
        FrameLayout r18 = null;
        View r19 = null;
    L3:
        if (r8 >= r15) goto L15;
        int r20 = r10.getItemViewType(r8);
        if (r20 == r17) goto L7;
        r19 = null;
        r17 = r20;
    L7:
        if (r18 != null) goto L9;
        r18 = new FrameLayout(r11);
    L9:
        r19 = r10.getView(r8, r19, r18);
        r19.measure(r13, r14);
        int r21 = r19.getMeasuredWidth();
        if (r21 >= r12) goto L11;
        if (r21 <= r16) goto L14;
        r16 = r21;
    L14:
        r8 = r8 + 1;
        goto L3
    L11:
        return r12;
    L15:
        return r16;
    }

    public static boolean s(androidx.appcompat.view.menu.f r8) {
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L15;
        MenuItem r12 = r8.getItem(r11);
        if (r12.isVisible() == false) goto L9;
        if (r12.getIcon() == null) goto L9;
        return true;
    L9:
        r11 = r11 + 1;
        goto L3
    L15:
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c(h r8) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean f(h r8) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void h(Context r8, androidx.appcompat.view.menu.f r10) {
    }

    public abstract void i(androidx.appcompat.view.menu.f r8);

    public abstract void k(View r8);

    public final void l(Rect r8) {
        this.f7861a = r8;
    }

    public abstract void m(boolean r8);

    public abstract void n(int r8);

    public abstract void o(int r8);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r8, View r10, int r11, long r12) {
        ListAdapter r13 = (ListAdapter) r8.getAdapter();
        if ((r13 instanceof HeaderViewListAdapter) == false) goto L5;
        androidx.appcompat.view.menu.e r14 = (androidx.appcompat.view.menu.e) ((HeaderViewListAdapter) r13).getWrappedAdapter();
    L6:
        androidx.appcompat.view.menu.f r15 = r14.f808a;
        MenuItem r16 = (MenuItem) r13.getItem(r11);
        if ((!(this instanceof androidx.appcompat.view.menu.b)) == false) goto L9;
        int r17 = 0;
    L10:
        r15.s(r16, this, r17);
        return;
    L9:
        r17 = 4;
        goto L10
    L5:
        r14 = (androidx.appcompat.view.menu.e) r13;
        goto L6
    }

    public abstract void p(PopupWindow.OnDismissListener r8);

    public abstract void q(boolean r8);

    public abstract void r(int r8);
}
