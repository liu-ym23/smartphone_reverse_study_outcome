package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.AbstractEqualityComparator;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Array2DHashSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.DoubleKeyMap;
import cn.nubia.neopush.commons.Constant;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ATNConfigSet implements Set<ATNConfig> {
    private int cachedHashCode;
    public AbstractConfigHashSet configLookup;
    public final ArrayList<ATNConfig> configs;
    protected BitSet conflictingAlts;
    public boolean dipsIntoOuterContext;
    public final boolean fullCtx;
    public boolean hasSemanticContext;
    protected boolean readonly;
    public int uniqueAlt;

    public static abstract class AbstractConfigHashSet extends Array2DHashSet<ATNConfig> {
        public AbstractConfigHashSet(AbstractEqualityComparator<? super ATNConfig> r5) {
            this(r5, 16, 2);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.Array2DHashSet
        public /* bridge */ /* synthetic */ ATNConfig asElementType(Object r5) {
            return asElementType(r5);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.Array2DHashSet
        public /* bridge */ /* synthetic */ ATNConfig[] createBucket(int r5) {
            return createBucket(r5);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.Array2DHashSet
        public /* bridge */ /* synthetic */ ATNConfig[][] createBuckets(int r5) {
            return createBuckets(r5);
        }

        public AbstractConfigHashSet(AbstractEqualityComparator<? super ATNConfig> r5, int r10, int r11) {
            super(r5, r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.Array2DHashSet
        public final ATNConfig asElementType(Object r5) {
            if ((r5 instanceof ATNConfig) == true) goto L7;
            return null;
        L7:
            return (ATNConfig) r5;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.Array2DHashSet
        public final ATNConfig[] createBucket(int r5) {
            return new ATNConfig[r5];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.Array2DHashSet
        public final ATNConfig[][] createBuckets(int r5) {
            return new ATNConfig[r5][];
        }
    }

    public static final class ConfigEqualityComparator extends AbstractEqualityComparator<ATNConfig> {
        public static final ConfigEqualityComparator INSTANCE = null;

        static {
            INSTANCE = new ConfigEqualityComparator();
        }

        private ConfigEqualityComparator() {
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.EqualityComparator
        public /* bridge */ /* synthetic */ boolean equals(Object r5, Object r10) {
            return equals((ATNConfig) r5, (ATNConfig) r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.EqualityComparator
        public /* bridge */ /* synthetic */ int hashCode(Object r5) {
            return hashCode((ATNConfig) r5);
        }

        public boolean equals(ATNConfig r5, ATNConfig r10) {
            if (r5 != r10) goto L6;
            return true;
        L6:
            if (r5 == null) goto L18;
            if (r10 == null) goto L18;
            if (r5.state.stateNumber != r10.state.stateNumber) goto L17;
            if (r5.alt != r10.alt) goto L17;
            if (r5.semanticContext.equals(r10.semanticContext) == false) goto L17;
            return true;
        L17:
            return false;
        L18:
            return false;
        }

        public int hashCode(ATNConfig r5) {
            int r10 = (((Constant.SDK_VERSION + r5.state.stateNumber) * 31) + r5.alt) * 31;
            return r5.semanticContext.hashCode() + r10;
        }
    }

    public static class ConfigHashSet extends AbstractConfigHashSet {
        public ConfigHashSet() {
            super(ConfigEqualityComparator.INSTANCE);
        }
    }

    public ATNConfigSet(boolean r5) {
        this.readonly = false;
        this.configs = new ArrayList(7);
        this.cachedHashCode = -1;
        this.configLookup = new ConfigHashSet();
        this.fullCtx = r5;
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r5) {
        return add((ATNConfig) r5);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends ATNConfig> r5) {
        Iterator<? extends ATNConfig> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        add(r10.next());
        goto L4
    L6:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        if (this.readonly == true) goto L7;
        this.configs.clear();
        this.cachedHashCode = -1;
        this.configLookup.clear();
        return;
    L7:
        throw new IllegalStateException("This set is readonly");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r5) {
        AbstractConfigHashSet r10 = this.configLookup;
        if (r10 == null) goto L7;
        return r10.contains(r5);
    L7:
        throw new UnsupportedOperationException("This method is not implemented for readonly sets.");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r5) {
        throw new UnsupportedOperationException();
    }

    public boolean containsFast(ATNConfig r5) {
        AbstractConfigHashSet r10 = this.configLookup;
        if (r10 == null) goto L7;
        return r10.containsFast(r5);
    L7:
        throw new UnsupportedOperationException("This method is not implemented for readonly sets.");
    }

    public List<ATNConfig> elements() {
        return this.configs;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ATNConfigSet) == true) goto L8;
        return false;
    L8:
        ATNConfigSet r10 = (ATNConfigSet) r5;
        ArrayList<ATNConfig> r11 = this.configs;
        if (r11 == null) goto L24;
        if (r11.equals(r10.configs) == false) goto L24;
        if (this.fullCtx != r10.fullCtx) goto L24;
        if (this.uniqueAlt != r10.uniqueAlt) goto L24;
        if (this.conflictingAlts != r10.conflictingAlts) goto L24;
        if (this.hasSemanticContext != r10.hasSemanticContext) goto L24;
        if (this.dipsIntoOuterContext != r10.dipsIntoOuterContext) goto L24;
        return true;
    L24:
        return false;
    }

    public ATNConfig get(int r5) {
        return this.configs.get(r5);
    }

    public BitSet getAlts() {
        BitSet r5 = new BitSet();
        Iterator<ATNConfig> r10 = this.configs.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.set(r10.next().alt);
        goto L4
    L6:
        return r5;
    }

    public List<SemanticContext> getPredicates() {
        ArrayList r5 = new ArrayList();
        Iterator<ATNConfig> r10 = this.configs.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        SemanticContext r11 = r10.next().semanticContext;
        if (r11 == SemanticContext.NONE) goto L4;
        r5.add(r11);
        goto L4
    L8:
        return r5;
    }

    public Set<ATNState> getStates() {
        HashSet r5 = new HashSet();
        Iterator<ATNConfig> r10 = this.configs.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.add(r10.next().state);
        goto L4
    L6:
        return r5;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        if (isReadonly() == false) goto L10;
        if (this.cachedHashCode != (-1)) goto L8;
        this.cachedHashCode = this.configs.hashCode();
    L8:
        return this.cachedHashCode;
    L10:
        return this.configs.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.configs.isEmpty();
    }

    public boolean isReadonly() {
        return this.readonly;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<ATNConfig> iterator() {
        return this.configs.iterator();
    }

    public void optimizeConfigs(ATNSimulator r5) {
        if (this.readonly == true) goto L13;
        if (this.configLookup.isEmpty() == false) goto L7;
        return;
    L7:
        Iterator<ATNConfig> r10 = this.configs.iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        ATNConfig r11 = r10.next();
        r11.context = r5.getCachedContext(r11.context);
        goto L9
    L11:
        return;
    L13:
        throw new IllegalStateException("This set is readonly");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r5) {
        throw new UnsupportedOperationException();
    }

    public void setReadonly(boolean r5) {
        this.readonly = r5;
        this.configLookup = null;
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.configs.size();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ Object[] toArray() {
        return toArray();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(elements().toString());
        if (this.hasSemanticContext == false) goto L6;
        r5.append(",hasSemanticContext=");
        r5.append(this.hasSemanticContext);
    L6:
        if (this.uniqueAlt == 0) goto L9;
        r5.append(",uniqueAlt=");
        r5.append(this.uniqueAlt);
    L9:
        if (this.conflictingAlts == null) goto L12;
        r5.append(",conflictingAlts=");
        r5.append(this.conflictingAlts);
    L12:
        if (this.dipsIntoOuterContext == false) goto L15;
        r5.append(",dipsIntoOuterContext");
    L15:
        return r5.toString();
    }

    public boolean add(ATNConfig r5) {
        return add(r5, null);
    }

    @Override // java.util.Set, java.util.Collection
    public ATNConfig[] toArray() {
        return this.configLookup.toArray();
    }

    public boolean add(ATNConfig r5, DoubleKeyMap<PredictionContext, PredictionContext, PredictionContext> r10) {
        if (this.readonly == true) goto L20;
        if (r5.semanticContext == SemanticContext.NONE) goto L8;
        this.hasSemanticContext = true;
    L8:
        if (r5.getOuterContextDepth() <= 0) goto L10;
        this.dipsIntoOuterContext = true;
    L10:
        ATNConfig r11 = this.configLookup.getOrAdd(r5);
        if (r11 != r5) goto L14;
        this.cachedHashCode = -1;
        this.configs.add(r5);
        return true;
    L14:
        PredictionContext r12 = PredictionContext.merge(r11.context, r5.context, !this.fullCtx, r10);
        r11.reachesIntoOuterContext = Math.max(r11.reachesIntoOuterContext, r5.reachesIntoOuterContext);
        if (r5.isPrecedenceFilterSuppressed() == false) goto L17;
        r11.setPrecedenceFilterSuppressed(true);
    L17:
        r11.context = r12;
        return true;
    L20:
        throw new IllegalStateException("This set is readonly");
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r5) {
        return (T[]) this.configLookup.toArray(r5);
    }

    public ATNConfigSet() {
        this(true);
    }

    public ATNConfigSet(ATNConfigSet r5) {
        this(r5.fullCtx);
        addAll(r5);
        this.uniqueAlt = r5.uniqueAlt;
        this.conflictingAlts = r5.conflictingAlts;
        this.hasSemanticContext = r5.hasSemanticContext;
        this.dipsIntoOuterContext = r5.dipsIntoOuterContext;
    }
}
