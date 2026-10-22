package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.ObjectEqualityComparator;

/* JADX INFO: loaded from: classes.dex */
public class OrderedATNConfigSet extends ATNConfigSet {

    public static class LexerConfigHashSet extends ATNConfigSet.AbstractConfigHashSet {
        public LexerConfigHashSet() {
            super(ObjectEqualityComparator.INSTANCE);
        }
    }

    public OrderedATNConfigSet() {
        this.configLookup = new LexerConfigHashSet();
    }
}
