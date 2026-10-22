package mab;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class c extends BaseAdapter {
    public boolean[] a;
    public final Context b;
    public int c;
    public final int d;

    public abstract String a(int r1);

    @Override // android.widget.Adapter
    public abstract int getCount();

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return r3;
    }

    public boolean b(int r3) {
        if (r3 < 0) goto L7;
        boolean[] r0 = this.a;
        if (r3 < r0.length) goto L6;
        return false;
    L6:
        return r0[r3];
    L7:
        return false;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return a(r1);
    }

    public c(Context r3, int r4, int r5) {
        this.b = r3;
        int r0 = getCount() / r4;
        this.d = Math.round((r5 - ((r0 - 1) * r3.getResources().getDimension(2131165848))) / r0);
    }

    @Override // android.widget.Adapter
    public final View getView(int r5, View r6, ViewGroup r7) {
        int r0 = 2131106607;
        if (r6 != null) goto L5;
        TextView r8 = new TextView(r7.getContext());
        AbsListView.LayoutParams r1 = new AbsListView.LayoutParams(-1, this.d);
        r8.setBackgroundColor(r7.getContext().getResources().getColor(2131100548));
        r8.setTextColor(r7.getContext().getResources().getColor(2131106607));
        r8.setLayoutParams(r1);
        r8.setGravity(17);
        r8.setTextSize(16.0f);
        r8.setVisibility(0);
        TextView r9 = r8;
        View r10 = r8;
    L6:
        Context r2 = r10.getContext();
        if (r5 >= 0) goto L9;
    L15:
        return r10;
    L9:
        if (r5 >= this.a.length) goto L15;
        r9.setText(a(r5));
        if (this.a[r5] == false) goto L13;
        Resources r11 = r2.getResources();
        r0 = 2131105548;
    L14:
        r9.setTextColor(r11.getColor(r0));
        goto L15
    L13:
        r11 = r2.getResources();
        goto L14
    L5:
        TextView r12 = (TextView) r6;
        r10 = r6;
        r9 = r12;
        goto L6
    }
}
