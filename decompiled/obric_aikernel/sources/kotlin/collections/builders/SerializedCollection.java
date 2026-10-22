package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
public final class SerializedCollection implements Externalizable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }

    public SerializedCollection(Collection<?> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "collection");
        this.collection = r10;
        this.tag = r11;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        byte r11 = r10.readByte();
        int r12 = r11 & 1;
        if ((r11 & (-2)) != 0) goto L25;
        int r13 = r10.readInt();
        if (r13 < 0) goto L23;
        int r14 = 0;
        if (r12 != 0) goto L9;
        List r15 = CollectionsKt.createListBuilder(r13);
    L17:
        if (r14 >= r13) goto L19;
        r15.add(r10.readObject());
        r14 = r14 + 1;
        goto L17
    L19:
        Collection<?> r16 = CollectionsKt.build(r15);
    L20:
        this.collection = r16;
        return;
    L9:
        if (r12 != 1) goto L15;
        Set r17 = SetsKt.createSetBuilder(r13);
    L11:
        if (r14 >= r13) goto L13;
        r17.add(r10.readObject());
        r14 = r14 + 1;
        goto L11
    L13:
        r16 = SetsKt.build(r17);
        goto L20
    L15:
        throw new InvalidObjectException("Unsupported collection type tag: " + r12 + '.');
    L23:
        throw new InvalidObjectException("Illegal size value: " + r13 + '.');
    L25:
        throw new InvalidObjectException("Unsupported flags value: " + r11 + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r10) {
        Intrinsics.checkNotNullParameter(r10, "output");
        r10.writeByte(this.tag);
        r10.writeInt(this.collection.size());
        Iterator<?> r11 = this.collection.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.writeObject(r11.next());
        goto L4
    }
}
