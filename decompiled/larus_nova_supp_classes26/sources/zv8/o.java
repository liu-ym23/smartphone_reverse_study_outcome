package zv8;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.larus.business.debug.base.register.EntranceType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class o extends e {
    public abstract BaseAdapter f();

    public abstract int g();

    public abstract AdapterView.OnItemSelectedListener h();

    public o() {
    }

    @Override // zv8.e
    public final EntranceType d() {
        return EntranceType.SPINNER;
    }
}
