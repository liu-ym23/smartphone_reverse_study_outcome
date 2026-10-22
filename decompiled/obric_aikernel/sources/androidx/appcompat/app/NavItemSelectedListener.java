package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes.dex */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener r10) {
        this.mListener = r10;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r10, View r11, int r12, long r13) {
        ActionBar.OnNavigationListener r14 = this.mListener;
        if (r14 == null) goto L6;
        r14.onNavigationItemSelected(r12, r13);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r10) {
    }
}
