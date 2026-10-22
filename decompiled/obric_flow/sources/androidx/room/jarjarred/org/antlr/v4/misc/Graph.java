package androidx.room.jarjarred.org.antlr.v4.misc;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.OrderedHashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Graph<T> {
    protected Map<T, Node<T>> nodes;

    public static class Node<T> {
        public List<Node<T>> edges;
        public T payload;

        public Node(T r5) {
            this.edges = Collections.EMPTY_LIST;
            this.payload = r5;
        }

        public void addEdge(Node<T> r5) {
            if (this.edges != Collections.EMPTY_LIST) goto L6;
            this.edges = new ArrayList();
        L6:
            if (this.edges.contains(r5) == true) goto L9;
            this.edges.add(r5);
            return;
        }

        public String toString() {
            return this.payload.toString();
        }
    }

    public Graph() {
        this.nodes = new LinkedHashMap();
    }

    public void DFS(Node<T> r5, Set<Node<T>> r10, ArrayList<T> r11) {
        if (r10.contains(r5) == false) goto L5;
        return;
    L5:
        r10.add(r5);
        List<Node<T>> r12 = r5.edges;
        if (r12 == null) goto L11;
        Iterator<Node<T>> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L11;
        DFS(r13.next(), r10, r11);
    L11:
        r11.add(r5.payload);
    }

    public void addEdge(T r5, T r10) {
        getNode(r5).addEdge(getNode(r10));
    }

    public Node<T> getNode(T r5) {
        Node<T> r10 = this.nodes.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        Node<T> r11 = new Node(r5);
        this.nodes.put(r5, r11);
        return r11;
    }

    public List<T> sort() {
        OrderedHashSet r5 = new OrderedHashSet();
        ArrayList<T> r10 = new ArrayList();
    L4:
        if (r5.size() >= this.nodes.size()) goto L12;
        Iterator<Node<T>> r11 = this.nodes.values().iterator();
        Node<T> r12 = null;
    L7:
        if (r11.hasNext() == false) goto L10;
        r12 = r11.next();
        if (r5.contains(r12) == true) goto L7;
    L10:
        if (r12 == null) goto L4;
        DFS(r12, r5, r10);
        goto L4
    L12:
        return r10;
    }
}
