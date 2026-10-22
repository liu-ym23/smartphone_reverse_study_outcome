package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class SpreadBuilder {
    private final ArrayList<Object> list;

    public SpreadBuilder(int r5) {
        this.list = new ArrayList(r5);
    }

    public void add(Object r5) {
        this.list.add(r5);
    }

    public void addSpread(Object r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof Object[]) == false) goto L10;
        Object[] r10 = (Object[]) r5;
        if (r10.length <= 0) goto L24;
        ArrayList<Object> r11 = this.list;
        r11.ensureCapacity(r11.size() + r10.length);
        Collections.addAll(this.list, r10);
        return;
    L24:
        return;
    L10:
        if ((r5 instanceof Collection) == false) goto L13;
        this.list.addAll((Collection) r5);
        return;
    L13:
        if ((r5 instanceof Iterable) == false) goto L19;
        Iterator r12 = ((Iterable) r5).iterator();
    L16:
        if (r12.hasNext() == false) goto L31;
        this.list.add(r12.next());
        goto L16
    L31:
        return;
    L19:
        if ((r5 instanceof Iterator) == false) goto L26;
        Iterator r13 = (Iterator) r5;
    L22:
        if (r13.hasNext() == false) goto L32;
        this.list.add(r13.next());
        goto L22
    L32:
        return;
    L26:
        throw new UnsupportedOperationException("Don't know how to spread " + r5.getClass());
    }

    public int size() {
        return this.list.size();
    }

    public Object[] toArray(Object[] r5) {
        return this.list.toArray(r5);
    }
}
