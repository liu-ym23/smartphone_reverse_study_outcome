package b9b;

import android.util.SparseIntArray;
import b9b.a;
import com.ss.android.lark.contact.base.entity.mobile.item.BaseItemAdapter;
import com.ss.android.lark.contact.base.entity.mobile.item.ItemViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<T extends a<T>> {
    public static final SparseIntArray d = null;
    public boolean a;
    public final int b;
    public BaseItemAdapter<T> c;

    public abstract void a(ItemViewHolder r1, int r2);

    static {
        d = new SparseIntArray();
    }

    public void update() {
        BaseItemAdapter<T> r0 = this.c;
        int r1 = r0.a.indexOf(this);
        if (r1 == (-1)) goto L6;
        r0.notifyItemRangeChanged(r1, 1, null);
        return;
    }

    public a(int r3) {
        this.a = false;
        int r0 = getClass().hashCode() + r3;
        this.b = r0;
        d.put(r0, r3);
    }

    public void b(ItemViewHolder r1) {
        this.a = false;
    }
}
