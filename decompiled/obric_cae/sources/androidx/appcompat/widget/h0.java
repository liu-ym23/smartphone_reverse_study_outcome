package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes.dex */
public final class h0 implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1163a;

    public h0(i0 r8) {
        this.f1163a = r8;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> r8, View r10, int r11, long r12) {
        if (r11 == (-1)) goto L8;
        e0 r13 = this.f1163a.f1172m;
        if (r13 == null) goto L9;
        r13.setListSelectionHidden(false);
        return;
    L9:
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> r8) {
    }
}
