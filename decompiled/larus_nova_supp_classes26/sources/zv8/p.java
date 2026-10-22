package zv8;

import androidx.appcompat.widget.SwitchCompat;
import com.larus.business.debug.base.register.EntranceType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class p extends e {
    public SwitchCompat b;

    public abstract boolean f();

    public abstract void g();

    public p() {
    }

    @Override // zv8.e
    public final EntranceType d() {
        return EntranceType.SWITCH;
    }
}
