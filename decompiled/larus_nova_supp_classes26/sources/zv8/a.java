package zv8;

import android.widget.TextView;
import com.larus.business.debug.base.register.EntranceType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a extends e {
    public TextView b;

    public abstract void f();

    @Override // zv8.e
    public void a() {
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setText("");
    L5:
        TextView r1 = this.b;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    public a() {
    }

    @Override // zv8.e
    public final EntranceType d() {
        return EntranceType.BUTTON;
    }
}
