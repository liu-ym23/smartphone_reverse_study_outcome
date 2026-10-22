package qh0;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ h a;

    public p(h r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        this.a.b = r2;
    }
}
