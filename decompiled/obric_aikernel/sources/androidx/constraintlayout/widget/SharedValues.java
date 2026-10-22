package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues;
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> mValuesListeners;

    public interface SharedValuesListener {
        void onNewValue(int r10, int r11, int r12);
    }

    public SharedValues() {
        this.mValues = new SparseIntArray();
        this.mValuesListeners = new HashMap();
    }

    public void addListener(int r10, SharedValuesListener r11) {
        HashSet<WeakReference<SharedValuesListener>> r12 = this.mValuesListeners.get(Integer.valueOf(r10));
        if (r12 != null) goto L5;
        r12 = new HashSet();
        this.mValuesListeners.put(Integer.valueOf(r10), r12);
    L5:
        r12.add(new WeakReference(r11));
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public void fireNewValue(int r10, int r11) {
        int r12 = this.mValues.get(r10, -1);
        if (r12 != r11) goto L5;
        return;
    L5:
        this.mValues.put(r10, r11);
        HashSet<WeakReference<SharedValuesListener>> r13 = this.mValuesListeners.get(Integer.valueOf(r10));
        if (r13 != null) goto L8;
        return;
    L8:
        Iterator<WeakReference<SharedValuesListener>> r14 = r13.iterator();
        boolean r15 = false;
    L10:
        if (r14.hasNext() == false) goto L15;
        SharedValuesListener r16 = r14.next().get();
        if (r16 != null) goto L13;
        r15 = true;
        goto L10
    L13:
        r16.onNewValue(r10, r11, r12);
        goto L10
    L15:
        if (r15 == false) goto L35;
        ArrayList r17 = new ArrayList();
        Iterator<WeakReference<SharedValuesListener>> r18 = r13.iterator();
    L18:
        if (r18.hasNext() == false) goto L22;
        WeakReference<SharedValuesListener> r19 = r18.next();
        if (r19.get() != null) goto L18;
        r17.add(r19);
        goto L18
    L22:
        r13.removeAll(r17);
        return;
    }

    public int getValue(int r10) {
        return this.mValues.get(r10, -1);
    }

    public void removeListener(int r10, SharedValuesListener r11) {
        HashSet<WeakReference<SharedValuesListener>> r12 = this.mValuesListeners.get(Integer.valueOf(r10));
        if (r12 != null) goto L5;
        return;
    L5:
        ArrayList r13 = new ArrayList();
        Iterator<WeakReference<SharedValuesListener>> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L12;
        WeakReference<SharedValuesListener> r15 = r14.next();
        SharedValuesListener r16 = r15.get();
        if (r16 == null) goto L11;
        if (r16 != r11) goto L7;
    L11:
        r13.add(r15);
        goto L7
    L12:
        r12.removeAll(r13);
    }

    public void removeListener(SharedValuesListener r10) {
        Iterator<Integer> r11 = this.mValuesListeners.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        removeListener(r11.next().intValue(), r10);
        goto L4
    }
}
