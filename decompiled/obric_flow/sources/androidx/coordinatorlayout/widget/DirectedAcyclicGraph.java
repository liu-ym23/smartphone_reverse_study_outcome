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

    private void dfs(T r5, ArrayList<T> r10, HashSet<T> r11) {
        if (r10.contains(r5) == false) goto L6;
        return;
    L6:
        if (r11.contains(r5) == true) goto L15;
        r11.add(r5);
        ArrayList<T> r12 = this.mGraph.get(r5);
        if (r12 == null) goto L12;
        int r13 = r12.size();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L12;
        dfs(r12.get(r14), r10, r11);
        r14 = r14 + 1;
    L12:
        r11.remove(r5);
        r10.add(r5);
        return;
    L15:
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> r5 = this.mListPool.acquire();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new ArrayList();
    }

    private void poolList(@NonNull ArrayList<T> r5) {
        r5.clear();
        this.mListPool.release(r5);
    }

    public void addEdge(@NonNull T r5, @NonNull T r10) {
        if (this.mGraph.containsKey(r5) == false) goto L12;
        if (this.mGraph.containsKey(r10) == false) goto L12;
        ArrayList<T> r11 = this.mGraph.get(r5);
        if (r11 != null) goto L9;
        r11 = getEmptyList();
        this.mGraph.put(r5, r11);
    L9:
        r11.add(r10);
        return;
    L12:
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void addNode(@NonNull T r5) {
        if (this.mGraph.containsKey(r5) == true) goto L6;
        this.mGraph.put(r5, null);
        return;
    }

    public void clear() {
        int r5 = this.mGraph.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        ArrayList<T> r11 = this.mGraph.valueAt(r10);
        if (r11 == null) goto L7;
        poolList(r11);
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T r5) {
        return this.mGraph.containsKey(r5);
    }

    @Nullable
    public List<T> getIncomingEdges(@NonNull T r5) {
        ArrayList<T> r10 = getIncomingEdgesInternal(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r10);
    }

    @Nullable
    public ArrayList<T> getIncomingEdgesInternal(@NonNull T r5) {
        return this.mGraph.get(r5);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T r5) {
        int r10 = this.mGraph.size();
        ArrayList r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L12;
        ArrayList<T> r13 = this.mGraph.valueAt(r12);
        if (r13 == null) goto L11;
        if (r13.contains(r5) == false) goto L11;
        if (r11 != null) goto L10;
        r11 = new ArrayList();
    L10:
        r11.add(this.mGraph.keyAt(r12));
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        return r11;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int r5 = this.mGraph.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L6;
        dfs(this.mGraph.keyAt(r10), this.mSortResult, this.mSortTmpMarked);
        r10 = r10 + 1;
        goto L3
    L6:
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T r5) {
        int r10 = this.mGraph.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        ArrayList<T> r12 = this.mGraph.valueAt(r11);
        if (r12 == null) goto L10;
        if (r12.contains(r5) == false) goto L10;
        return true;
    L10:
        r11 = r11 + 1;
        goto L3
    L11:
        return false;
    }

    public int size() {
        return this.mGraph.size();
    }
}
