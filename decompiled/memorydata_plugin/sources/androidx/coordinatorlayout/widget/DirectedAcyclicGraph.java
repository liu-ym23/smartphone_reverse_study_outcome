package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX WARN: Multi-variable type inference failed */
    private void dfs(T r5, ArrayList<T> r6, HashSet<T> r7) {
        if (r6.contains(r5) == false) goto L6;
        return;
    L6:
        if (r7.contains(r5) == true) goto L15;
        r7.add(r5);
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mGraph.get(r5), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        int r1 = 0;
        int r2 = r0.size();
    L10:
        if (r1 >= r2) goto L12;
        dfs(r0.get(r1), r6, r7);
        r1 = r1 + 1;
    L12:
        r7.remove(r5);
        r6.add(r5);
        return;
    L15:
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private ArrayList<T> getEmptyList() {
        ArrayList<T> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mListPool.acquire(), ArrayList.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    private void poolList(ArrayList<T> r1) {
        r1.clear();
        this.mListPool.release(r1);
    }

    public void addEdge(T r4, T r5) {
        if (this.mGraph.containsKey(r4) == false) goto L12;
        if (this.mGraph.containsKey(r5) == false) goto L12;
        ArrayList<T> r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mGraph.get(r4), ArrayList.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        r0 = getEmptyList();
        this.mGraph.put(r4, r0);
    L9:
        r0.add(r5);
        return;
    L12:
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void addNode(T r2) {
        if (this.mGraph.containsKey(r2) == true) goto L6;
        this.mGraph.put(r2, null);
        return;
    }

    public void clear() {
        int r0 = this.mGraph.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        ArrayList<T> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mGraph.valueAt(r1), ArrayList.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        poolList(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        this.mGraph.clear();
    }

    public boolean contains(T r1) {
        return this.mGraph.containsKey(r1);
    }

    public List getIncomingEdges(T r2) {
        return (List) ZeusTransformUtils.preCheckCast(this.mGraph.get(r2), List.class, "com.obric.memorydata.plugin");
    }

    public List<T> getOutgoingEdges(T r7) {
        int r0 = this.mGraph.size();
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mGraph.valueAt(r2), ArrayList.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (r3.contains(r7) == false) goto L11;
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        r1.add(this.mGraph.keyAt(r2));
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return r1;
    }

    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int r0 = this.mGraph.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        dfs(this.mGraph.keyAt(r1), this.mSortResult, this.mSortTmpMarked);
        r1 = r1 + 1;
        goto L3
    L6:
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(T r7) {
        int r0 = this.mGraph.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mGraph.valueAt(r2), ArrayList.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        if (r3.contains(r7) == false) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    int size() {
        return this.mGraph.size();
    }
}
