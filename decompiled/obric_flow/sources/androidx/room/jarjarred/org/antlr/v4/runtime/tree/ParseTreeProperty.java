package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ParseTreeProperty<V> {
    protected Map<ParseTree, V> annotations;

    public ParseTreeProperty() {
        this.annotations = new IdentityHashMap();
    }

    public V get(ParseTree r5) {
        return this.annotations.get(r5);
    }

    public void put(ParseTree r5, V r10) {
        this.annotations.put(r5, r10);
    }

    public V removeFrom(ParseTree r5) {
        return this.annotations.remove(r5);
    }
}
