package z52;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        this.a.y.setGiftOpen(r3);
        b r4 = this.a;
        r4.e(r4.y);
        xs2.b.a().post(new q22.b(this.a.y));
    }
}
