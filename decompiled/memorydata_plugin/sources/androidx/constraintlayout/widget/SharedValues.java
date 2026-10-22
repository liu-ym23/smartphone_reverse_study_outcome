package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        void onNewValue(int r1, int r2, int r3);
    }

    public SharedValues() {
        this.mValues = new SparseIntArray();
        this.mValuesListeners = new HashMap();
    }

    public void addListener(int r4, SharedValuesListener r5) {
        SharedValuesListener r6 = (SharedValuesListener) ZeusTransformUtils.wrapperContextForParams(r5, SharedValuesListener.class, "com.obric.memorydata.plugin");
        HashSet<WeakReference<SharedValuesListener>> r0 = (HashSet) ZeusTransformUtils.preCheckCast(this.mValuesListeners.get(Integer.valueOf(r4)), HashSet.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new HashSet();
        this.mValuesListeners.put(Integer.valueOf(r4), r0);
    L5:
        r0.add(new WeakReference(r6));
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public void fireNewValue(int r7, int r8) {
        int r0 = this.mValues.get(r7, -1);
        if (r0 != r8) goto L5;
        return;
    L5:
        this.mValues.put(r7, r8);
        HashSet r6 = (HashSet) ZeusTransformUtils.preCheckCast(this.mValuesListeners.get(Integer.valueOf(r7)), HashSet.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L8;
        return;
    L8:
        Iterator r1 = r6.iterator();
        boolean r3 = false;
    L10:
        if (r1.hasNext() == false) goto L15;
        SharedValuesListener r4 = (SharedValuesListener) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r1.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), SharedValuesListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
        r3 = true;
        goto L10
    L13:
        r4.onNewValue(r7, r8, r0);
        goto L10
    L15:
        if (r3 == false) goto L35;
        ArrayList r9 = new ArrayList();
        Iterator r10 = r6.iterator();
    L18:
        if (r10.hasNext() == false) goto L22;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r10.next(), WeakReference.class, "com.obric.memorydata.plugin");
        if (((SharedValuesListener) ZeusTransformUtils.preCheckCast(r2.get(), SharedValuesListener.class, "com.obric.memorydata.plugin")) != null) goto L18;
        r9.add(r2);
        goto L18
    L22:
        r6.removeAll(r9);
        return;
    }

    public int getValue(int r2) {
        return this.mValues.get(r2, -1);
    }

    public void removeListener(int r6, SharedValuesListener r7) {
        SharedValuesListener r8 = (SharedValuesListener) ZeusTransformUtils.wrapperContextForParams(r7, SharedValuesListener.class, "com.obric.memorydata.plugin");
        HashSet r5 = (HashSet) ZeusTransformUtils.preCheckCast(this.mValuesListeners.get(Integer.valueOf(r6)), HashSet.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        ArrayList r9 = new ArrayList();
        Iterator r0 = r5.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        SharedValuesListener r3 = (SharedValuesListener) ZeusTransformUtils.preCheckCast(r2.get(), SharedValuesListener.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (r3 != r8) goto L7;
    L11:
        r9.add(r2);
        goto L7
    L12:
        r5.removeAll(r9);
    }

    public void removeListener(SharedValuesListener r5) {
        SharedValuesListener r6 = (SharedValuesListener) ZeusTransformUtils.wrapperContextForParams(r5, SharedValuesListener.class, "com.obric.memorydata.plugin");
        Iterator<Integer> r0 = this.mValuesListeners.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        removeListener(((Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r6);
        goto L4
    }
}
