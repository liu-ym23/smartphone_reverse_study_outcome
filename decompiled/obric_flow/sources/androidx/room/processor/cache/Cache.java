package androidx.room.processor.cache;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XType;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.processor.FieldProcessor;
import androidx.room.vo.BuiltInConverterFlags;
import androidx.room.vo.EmbeddedField;
import androidx.room.vo.Entity;
import androidx.room.vo.Pojo;
import androidx.room.vo.Warning;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\u001e\u001f !B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0011R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Landroidx/room/processor/cache/Cache;", "", "parent", "converters", "Ljava/util/LinkedHashSet;", "Landroidx/room/compiler/processing/XType;", "suppressedWarnings", "", "Landroidx/room/vo/Warning;", "builtInConverterFlags", "Landroidx/room/vo/BuiltInConverterFlags;", "(Landroidx/room/processor/cache/Cache;Ljava/util/LinkedHashSet;Ljava/util/Set;Landroidx/room/vo/BuiltInConverterFlags;)V", "getBuiltInConverterFlags", "()Landroidx/room/vo/BuiltInConverterFlags;", "getConverters", "()Ljava/util/LinkedHashSet;", "entities", "Landroidx/room/processor/cache/Cache$Bucket;", "Landroidx/room/processor/cache/Cache$EntityKey;", "Landroidx/room/vo/Entity;", "getEntities", "()Landroidx/room/processor/cache/Cache$Bucket;", "getParent", "()Landroidx/room/processor/cache/Cache;", "pojos", "Landroidx/room/processor/cache/Cache$PojoKey;", "Landroidx/room/vo/Pojo;", "getPojos", "getSuppressedWarnings", "()Ljava/util/Set;", "Bucket", "EntityKey", "FullKey", "PojoKey", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Cache {
    private final BuiltInConverterFlags builtInConverterFlags;
    private final LinkedHashSet<XType> converters;
    private final Bucket<EntityKey, Entity> entities;
    private final Cache parent;
    private final Bucket<PojoKey, Pojo> pojos;
    private final Set<Warning> suppressedWarnings;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000R\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0002\u0010\u000eR \u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/room/processor/cache/Cache$Bucket;", "K", ExifInterface.GPS_DIRECTION_TRUE, "", "source", "Landroidx/room/processor/cache/Cache;", "(Landroidx/room/processor/cache/Cache;Landroidx/room/processor/cache/Cache$Bucket;)V", "entries", "", "Landroidx/room/processor/cache/Cache$FullKey;", "get", STGroup.DICT_KEY, "calculate", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class Bucket<K, T> {
        private final Map<FullKey<K>, T> entries;
        final /* synthetic */ Cache this$0;

        public Bucket(Cache r5, Bucket<K, T> r10) {
            this.this$0 = r5;
            if (r10 == null) goto L6;
            Map<FullKey<K>, T> r11 = r10.entries;
            if (r11 == null) goto L6;
        L7:
            this.entries = r11;
            return;
        L6:
            r11 = new LinkedHashMap();
            goto L7
        }

        public final T get(K r5, Function0<? extends T> r10) {
            Intrinsics.checkNotNullParameter(r10, "calculate");
            FullKey<K> r11 = new FullKey(this.this$0.getConverters(), this.this$0.getSuppressedWarnings(), this.this$0.getBuiltInConverterFlags(), r5);
            Map<FullKey<K>, T> r12 = this.entries;
            T r13 = r12.get(r11);
            if (r13 != null) goto L6;
            T r14 = r10.invoke();
            r12.put(r11, r14);
            return r14;
        L6:
            return r13;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/processor/cache/Cache$EntityKey;", "", "element", "Landroidx/room/compiler/processing/XElement;", "(Landroidx/room/compiler/processing/XElement;)V", "getElement", "()Landroidx/room/compiler/processing/XElement;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EntityKey {
        private final XElement element;

        public EntityKey(XElement r5) {
            Intrinsics.checkNotNullParameter(r5, "element");
            this.element = r5;
        }

        public static /* synthetic */ EntityKey copy$default(EntityKey r5, XElement r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.element;
        L6:
            return r5.copy(r10);
        }

        public final XElement component1() {
            return this.element;
        }

        public final EntityKey copy(XElement r5) {
            Intrinsics.checkNotNullParameter(r5, "element");
            return new EntityKey(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof EntityKey) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.element, ((EntityKey) r5).element) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final XElement getElement() {
            return this.element;
        }

        public int hashCode() {
            return this.element.hashCode();
        }

        public String toString() {
            return "EntityKey(element=" + this.element + ")";
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J\u000e\u0010\u0019\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0012JH\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Landroidx/room/processor/cache/Cache$FullKey;", ExifInterface.GPS_DIRECTION_TRUE, "", "converters", "Ljava/util/LinkedHashSet;", "Landroidx/room/compiler/processing/XType;", "suppressedWarnings", "", "Landroidx/room/vo/Warning;", "builtInConverterFlags", "Landroidx/room/vo/BuiltInConverterFlags;", STGroup.DICT_KEY, "(Ljava/util/LinkedHashSet;Ljava/util/Set;Landroidx/room/vo/BuiltInConverterFlags;Ljava/lang/Object;)V", "getBuiltInConverterFlags", "()Landroidx/room/vo/BuiltInConverterFlags;", "getConverters", "()Ljava/util/LinkedHashSet;", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSuppressedWarnings", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/LinkedHashSet;Ljava/util/Set;Landroidx/room/vo/BuiltInConverterFlags;Ljava/lang/Object;)Landroidx/room/processor/cache/Cache$FullKey;", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FullKey<T> {
        private final BuiltInConverterFlags builtInConverterFlags;
        private final LinkedHashSet<XType> converters;
        private final T key;
        private final Set<Warning> suppressedWarnings;

        /* JADX WARN: Multi-variable type inference failed */
        public FullKey(LinkedHashSet<XType> r5, Set<? extends Warning> r10, BuiltInConverterFlags r11, T r12) {
            Intrinsics.checkNotNullParameter(r5, "converters");
            Intrinsics.checkNotNullParameter(r10, "suppressedWarnings");
            Intrinsics.checkNotNullParameter(r11, "builtInConverterFlags");
            this.converters = r5;
            this.suppressedWarnings = r10;
            this.builtInConverterFlags = r11;
            this.key = r12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FullKey copy$default(FullKey r5, LinkedHashSet r10, Set r11, BuiltInConverterFlags r12, Object r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r10 = r5.converters;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = r5.suppressedWarnings;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = r5.builtInConverterFlags;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r13 = r5.key;
        L15:
            return r5.copy(r10, r11, r12, r13);
        }

        public final LinkedHashSet<XType> component1() {
            return this.converters;
        }

        public final Set<Warning> component2() {
            return this.suppressedWarnings;
        }

        public final BuiltInConverterFlags component3() {
            return this.builtInConverterFlags;
        }

        public final T component4() {
            return this.key;
        }

        public final FullKey<T> copy(LinkedHashSet<XType> r5, Set<? extends Warning> r10, BuiltInConverterFlags r11, T r12) {
            Intrinsics.checkNotNullParameter(r5, "converters");
            Intrinsics.checkNotNullParameter(r10, "suppressedWarnings");
            Intrinsics.checkNotNullParameter(r11, "builtInConverterFlags");
            return new FullKey(r5, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof FullKey) == true) goto L8;
            return false;
        L8:
            FullKey r10 = (FullKey) r5;
            if (Intrinsics.areEqual(this.converters, r10.converters) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.suppressedWarnings, r10.suppressedWarnings) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.builtInConverterFlags, r10.builtInConverterFlags) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.key, r10.key) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final BuiltInConverterFlags getBuiltInConverterFlags() {
            return this.builtInConverterFlags;
        }

        public final LinkedHashSet<XType> getConverters() {
            return this.converters;
        }

        public final T getKey() {
            return this.key;
        }

        public final Set<Warning> getSuppressedWarnings() {
            return this.suppressedWarnings;
        }

        public int hashCode() {
            int r5 = this.converters.hashCode() * 31;
            int r10 = (this.suppressedWarnings.hashCode() + r5) * 31;
            int r11 = (this.builtInConverterFlags.hashCode() + r10) * 31;
            T r12 = this.key;
            if (r12 != null) goto L5;
            int r13 = 0;
        L7:
            return r11 + r13;
        L5:
            r13 = r12.hashCode();
            goto L7
        }

        public String toString() {
            return "FullKey(converters=" + this.converters + ", suppressedWarnings=" + this.suppressedWarnings + ", builtInConverterFlags=" + this.builtInConverterFlags + ", key=" + this.key + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/room/processor/cache/Cache$PojoKey;", "", "element", "Landroidx/room/compiler/processing/XElement;", "scope", "Landroidx/room/processor/FieldProcessor$BindingScope;", "parent", "Landroidx/room/vo/EmbeddedField;", "(Landroidx/room/compiler/processing/XElement;Landroidx/room/processor/FieldProcessor$BindingScope;Landroidx/room/vo/EmbeddedField;)V", "getElement", "()Landroidx/room/compiler/processing/XElement;", "getParent", "()Landroidx/room/vo/EmbeddedField;", "getScope", "()Landroidx/room/processor/FieldProcessor$BindingScope;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PojoKey {
        private final XElement element;
        private final EmbeddedField parent;
        private final FieldProcessor.BindingScope scope;

        public PojoKey(XElement r5, FieldProcessor.BindingScope r10, EmbeddedField r11) {
            Intrinsics.checkNotNullParameter(r5, "element");
            Intrinsics.checkNotNullParameter(r10, "scope");
            this.element = r5;
            this.scope = r10;
            this.parent = r11;
        }

        public static /* synthetic */ PojoKey copy$default(PojoKey r5, XElement r10, FieldProcessor.BindingScope r11, EmbeddedField r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = r5.element;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = r5.scope;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r12 = r5.parent;
        L12:
            return r5.copy(r10, r11, r12);
        }

        public final XElement component1() {
            return this.element;
        }

        public final FieldProcessor.BindingScope component2() {
            return this.scope;
        }

        public final EmbeddedField component3() {
            return this.parent;
        }

        public final PojoKey copy(XElement r5, FieldProcessor.BindingScope r10, EmbeddedField r11) {
            Intrinsics.checkNotNullParameter(r5, "element");
            Intrinsics.checkNotNullParameter(r10, "scope");
            return new PojoKey(r5, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PojoKey) == true) goto L8;
            return false;
        L8:
            PojoKey r10 = (PojoKey) r5;
            if (Intrinsics.areEqual(this.element, r10.element) == true) goto L12;
            return false;
        L12:
            if (this.scope == r10.scope) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.parent, r10.parent) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final XElement getElement() {
            return this.element;
        }

        public final EmbeddedField getParent() {
            return this.parent;
        }

        public final FieldProcessor.BindingScope getScope() {
            return this.scope;
        }

        public int hashCode() {
            int r5 = this.element.hashCode() * 31;
            int r10 = (this.scope.hashCode() + r5) * 31;
            EmbeddedField r11 = this.parent;
            if (r11 != null) goto L5;
            int r12 = 0;
        L7:
            return r10 + r12;
        L5:
            r12 = r11.hashCode();
            goto L7
        }

        public String toString() {
            return "PojoKey(element=" + this.element + ", scope=" + this.scope + ", parent=" + this.parent + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cache(Cache r5, LinkedHashSet<XType> r10, Set<? extends Warning> r11, BuiltInConverterFlags r12) {
        Intrinsics.checkNotNullParameter(r10, "converters");
        Intrinsics.checkNotNullParameter(r11, "suppressedWarnings");
        Intrinsics.checkNotNullParameter(r12, "builtInConverterFlags");
        this.parent = r5;
        this.converters = r10;
        this.suppressedWarnings = r11;
        this.builtInConverterFlags = r12;
        Bucket<PojoKey, Pojo> r13 = null;
        if (r5 == null) goto L5;
        Bucket<EntityKey, Entity> r14 = r5.entities;
    L6:
        this.entities = new Bucket(this, r14);
        if (r5 == null) goto L9;
        r13 = r5.pojos;
    L9:
        this.pojos = new Bucket(this, r13);
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final BuiltInConverterFlags getBuiltInConverterFlags() {
        return this.builtInConverterFlags;
    }

    public final LinkedHashSet<XType> getConverters() {
        return this.converters;
    }

    public final Bucket<EntityKey, Entity> getEntities() {
        return this.entities;
    }

    public final Cache getParent() {
        return this.parent;
    }

    public final Bucket<PojoKey, Pojo> getPojos() {
        return this.pojos;
    }

    public final Set<Warning> getSuppressedWarnings() {
        return this.suppressedWarnings;
    }
}
