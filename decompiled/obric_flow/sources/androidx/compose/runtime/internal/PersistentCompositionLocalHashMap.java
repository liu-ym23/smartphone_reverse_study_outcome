package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005:\u0002\u0016\u0017B1\u0012\"\u0010\u0006\u001a\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0015R6\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\r0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "size", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "builder", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "get", ExifInterface.GPS_DIRECTION_TRUE, STGroup.DICT_KEY, "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "Builder", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentCompositionLocalHashMap extends PersistentHashMap<CompositionLocal<Object>, State<? extends Object>> implements PersistentCompositionLocalMap {
    public static final Companion Companion = null;
    private static final PersistentCompositionLocalHashMap Empty = null;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "map", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "(Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "setMap$runtime_release", "build", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder extends PersistentHashMapBuilder<CompositionLocal<Object>, State<? extends Object>> implements PersistentCompositionLocalMap.Builder {
        public static final int $stable = 8;
        private PersistentCompositionLocalHashMap map;

        public Builder(PersistentCompositionLocalHashMap r5) {
            Intrinsics.checkNotNullParameter(r5, "map");
            super(r5);
            this.map = r5;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        public /* bridge */ /* synthetic */ PersistentMap<CompositionLocal<Object>, State<? extends Object>> build() {
            return build();
        }

        public /* bridge */ boolean containsKey(CompositionLocal<Object> r5) {
            return super.containsKey(r5);
        }

        public /* bridge */ boolean containsValue(State<? extends Object> r5) {
            return super.containsValue(r5);
        }

        public /* bridge */ State<Object> get(CompositionLocal<Object> r5) {
            return (State) super.get(r5);
        }

        public final PersistentCompositionLocalHashMap getMap$runtime_release() {
            return this.map;
        }

        public /* bridge */ State<Object> getOrDefault(CompositionLocal<Object> r5, State<? extends Object> r10) {
            return (State) super.getOrDefault(r5, r10);
        }

        public /* bridge */ State<Object> remove(CompositionLocal<Object> r5) {
            return (State) super.remove(r5);
        }

        public final void setMap$runtime_release(PersistentCompositionLocalHashMap r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.map = r5;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ PersistentMap<CompositionLocal<Object>, State<? extends Object>> build2() {
            return build();
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r5) {
            if ((r5 instanceof CompositionLocal) == true) goto L7;
            return false;
        L7:
            return containsKey((CompositionLocal) r5);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r5) {
            if ((r5 instanceof State) == true) goto L7;
            return false;
        L7:
            return containsValue((State) r5);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ State<Object> get(Object r5) {
            if ((r5 instanceof CompositionLocal) == true) goto L7;
            return null;
        L7:
            return get((CompositionLocal) r5);
        }

        public final /* bridge */ State getOrDefault(Object r5, State r10) {
            if ((r5 instanceof CompositionLocal) == true) goto L6;
            return r10;
        L6:
            return getOrDefault((CompositionLocal) r5, r10);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ State<Object> remove(Object r5) {
            if ((r5 instanceof CompositionLocal) == true) goto L7;
            return null;
        L7:
            return remove((CompositionLocal) r5);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        public /* bridge */ /* synthetic */ PersistentMap<CompositionLocal<Object>, State<? extends Object>> build() {
            return build();
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object r5) {
            if ((r5 instanceof CompositionLocal) == true) goto L7;
            return null;
        L7:
            return get((CompositionLocal) r5);
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r5, Object r10) {
            if ((r5 instanceof CompositionLocal) == true) goto L6;
            return r10;
        L6:
            return getOrDefault((CompositionLocal) r5, (State) r10);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object r5) {
            if ((r5 instanceof CompositionLocal) == true) goto L7;
            return null;
        L7:
            return remove((CompositionLocal) r5);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        public PersistentMap<CompositionLocal<Object>, State<? extends Object>> build() {
            if (getNode$runtime_release() != this.map.getNode$runtime_release()) goto L5;
            PersistentCompositionLocalHashMap r5 = this.map;
        L6:
            this.map = r5;
            return r5;
        L5:
            setOwnership(new MutabilityOwnership());
            r5 = new PersistentCompositionLocalHashMap(getNode$runtime_release(), size());
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Companion;", "", "()V", "Empty", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "getEmpty$annotations", "getEmpty", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static /* synthetic */ void getEmpty$annotations() {
        }

        public final PersistentCompositionLocalHashMap getEmpty() {
            return PersistentCompositionLocalHashMap.access$getEmpty$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        TrieNode r5 = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>");
        Empty = new PersistentCompositionLocalHashMap(r5, 0);
    }

    public PersistentCompositionLocalHashMap(TrieNode<CompositionLocal<Object>, State<Object>> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "node");
        super(r5, r10);
    }

    public static final /* synthetic */ PersistentCompositionLocalHashMap access$getEmpty$cp() {
        return Empty;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public /* bridge */ /* synthetic */ PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder() {
        return builder();
    }

    public /* bridge */ boolean containsKey(CompositionLocal<Object> r5) {
        return super.containsKey(r5);
    }

    public /* bridge */ boolean containsValue(State<? extends Object> r5) {
        return super.containsValue(r5);
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public /* bridge */ State<Object> get(CompositionLocal<Object> r5) {
        return (State) super.get(r5);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public ImmutableSet<Map.Entry<CompositionLocal<Object>, State<Object>>> getEntries() {
        return super.getEntries();
    }

    public /* bridge */ State<Object> getOrDefault(CompositionLocal<Object> r5, State<? extends Object> r10) {
        return (State) super.getOrDefault(r5, r10);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    /* JADX INFO: renamed from: builder, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder2() {
        return builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r5) {
        if ((r5 instanceof CompositionLocal) == true) goto L7;
        return false;
    L7:
        return containsKey((CompositionLocal) r5);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r5) {
        if ((r5 instanceof State) == true) goto L7;
        return false;
    L7:
        return containsValue((State) r5);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ State<Object> get(Object r5) {
        if ((r5 instanceof CompositionLocal) == true) goto L7;
        return null;
    L7:
        return get((CompositionLocal) r5);
    }

    public final /* bridge */ State getOrDefault(Object r5, State r10) {
        if ((r5 instanceof CompositionLocal) == true) goto L6;
        return r10;
    L6:
        return getOrDefault((CompositionLocal) r5, r10);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public /* bridge */ /* synthetic */ PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder() {
        return builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r5) {
        if ((r5 instanceof CompositionLocal) == true) goto L7;
        return null;
    L7:
        return get((CompositionLocal) r5);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r5, Object r10) {
        if ((r5 instanceof CompositionLocal) == true) goto L6;
        return r10;
    L6:
        return getOrDefault((CompositionLocal) r5, (State) r10);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder() {
        return new Builder(this);
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public <T> T get(CompositionLocal<T> r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return (T) CompositionLocalMapKt.read(this, r5);
    }
}
