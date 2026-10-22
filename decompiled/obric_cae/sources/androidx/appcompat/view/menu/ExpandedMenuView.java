package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.v0;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements f.b, k, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f749b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f750a;

    static {
        f749b = new int[]{R.attr.background, R.attr.divider};
    }

    public ExpandedMenuView(Context r8, AttributeSet r10) {
        super(r8, r10);
        setOnItemClickListener(this);
        v0 r11 = new v0(r8, r8.obtainStyledAttributes(r10, f749b, R.attr.listViewStyle, 0));
        if (r11.l(0) == false) goto L6;
        setBackgroundDrawable(r11.e(0));
    L6:
        if (r11.l(1) == false) goto L8;
        setDivider(r11.e(1));
    L8:
        r11.n();
    }

    @Override // androidx.appcompat.view.menu.k
    public final void a(f r8) {
        this.f750a = r8;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean b(h r8) {
        return this.f750a.s(r8, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView r8, View r10, int r11, long r12) {
        b((h) getAdapter().getItem(r11));
    }
}
