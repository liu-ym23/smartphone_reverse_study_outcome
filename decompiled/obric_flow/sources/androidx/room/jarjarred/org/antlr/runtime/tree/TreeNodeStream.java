package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public interface TreeNodeStream extends IntStream {
    Object LT(int r5);

    Object get(int r5);

    TokenStream getTokenStream();

    TreeAdaptor getTreeAdaptor();

    Object getTreeSource();

    void replaceChildren(Object r5, int r10, int r11, Object r12);

    void reset();

    void setUniqueNavigationNodes(boolean r5);

    String toString(Object r5, Object r10);
}
