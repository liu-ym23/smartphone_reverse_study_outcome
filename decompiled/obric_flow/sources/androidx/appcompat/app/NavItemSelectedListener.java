package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes.dex */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener r5) {
        this.mListener = r5;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r5, View r10, int r11, long r12) {
        ActionBar.OnNavigationListener r13 = this.mListener;
        if (r13 == null) goto L6;
        r13.onNavigationItemSelected(r11, r12);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r5) {
    }
}
