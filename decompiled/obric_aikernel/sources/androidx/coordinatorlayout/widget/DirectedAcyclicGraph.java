package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph<T> {
    private final SimpleArrayMap<T, ArrayList<T>> mGraph;
    private final Pools.Pool<ArrayList<T>> mListPool;
    private final ArrayList<T> mSortResult;
    private final HashSet<T> mSortTmpMarked;

    public DirectedAcyclicGraph() {
        this.mListPool = new Pools.SimplePool(10);
        this.mGraph = new SimpleArrayMap();
        this.mSortResult = new ArrayList();
        this.mSortTmpMarked = new HashSet();
    }

    private void dfs(T r10, ArrayList<T> r11, HashSet<T> r12) {
        if (r11.contains(r10) == false) goto L6;
        return;
    L6:
        if (r12.contains(r10) == true) goto L15;
        r12.add(r10);
        ArrayList<T> r13 = this.mGraph.get(r10);
        if (r13 == null) goto L12;
        int r14 = 0;
        int r15 = r13.size();
    L10:
        if (r14 >= r15) goto L12;
        dfs(r13.get(r14), r11, r12);
        r14 = r14 + 1;
    L12:
        r12.remove(r10);
        r11.add(r10);
        return;
    L15:
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> r10 = this.mListPool.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new ArrayList();
    }

    private void poolList(@NonNull ArrayList<T> r10) {
        r10.clear();
        this.mListPool.release(r10);
    }

    public void addEdge(@NonNull T r10, @NonNull T r11) {
        if (this.mGraph.containsKey(r10) == false) goto L12;
        if (this.mGraph.containsKey(r11) == false) goto L12;
        ArrayList<T> r12 = this.mGraph.get(r10);
        if (r12 != null) goto L9;
        r12 = getEmptyList();
        this.mGraph.put(r10, r12);
    L9:
        r12.add(r11);
        return;
    L12:
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void addNode(@NonNull T r10) {
        if (this.mGraph.containsKey(r10) == true) goto L6;
        this.mGraph.put(r10, null);
        return;
    }

    public void clear() {
        int r10 = this.mGraph.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        ArrayList<T> r12 = this.mGraph.valueAt(r11);
        if (r12 == null) goto L7;
        poolList(r12);
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T r10) {
        return this.mGraph.containsKey(r10);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T r10) {
        return this.mGraph.get(r10);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T r10) {
        int r11 = this.mGraph.size();
        ArrayList r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L12;
        ArrayList<T> r14 = this.mGraph.valueAt(r13);
        if (r14 == null) goto L11;
        if (r14.contains(r10) == false) goto L11;
        if (r12 != null) goto L10;
        r12 = new ArrayList();
    L10:
        r12.add(this.mGraph.keyAt(r13));
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        return r12;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int r10 = this.mGraph.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        dfs(this.mGraph.keyAt(r11), this.mSortResult, this.mSortTmpMarked);
        r11 = r11 + 1;
        goto L3
    L6:
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T r10) {
        int r11 = this.mGraph.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        ArrayList<T> r13 = this.mGraph.valueAt(r12);
        if (r13 == null) goto L10;
        if (r13.contains(r10) == false) goto L10;
        return true;
    L10:
        r12 = r12 + 1;
        goto L3
    L11:
        return false;
    }

    int size() {
        return this.mGraph.size();
    }
}
