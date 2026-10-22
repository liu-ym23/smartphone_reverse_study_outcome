package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "()V", "collection", "", "tag", "", "(Ljava/util/Collection;I)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
public final class SerializedCollection implements Externalizable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/collections/builders/SerializedCollection$Companion;", "", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SerializedCollection(Collection<?> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        this.collection = r5;
        this.tag = r10;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        byte r5 = r10.readByte();
        int r11 = r5 & 1;
        if ((r5 & (-2)) != 0) goto L25;
        int r12 = r10.readInt();
        if (r12 < 0) goto L23;
        int r13 = 0;
        if (r11 != 0) goto L9;
        List r14 = CollectionsKt.createListBuilder(r12);
    L17:
        if (r13 >= r12) goto L19;
        r14.add(r10.readObject());
        r13 = r13 + 1;
        goto L17
    L19:
        Set r15 = CollectionsKt.build(r14);
    L20:
        this.collection = r15;
        return;
    L9:
        if (r11 != 1) goto L15;
        Set r16 = SetsKt.createSetBuilder(r12);
    L11:
        if (r13 >= r12) goto L13;
        r16.add(r10.readObject());
        r13 = r13 + 1;
        goto L11
    L13:
        r15 = SetsKt.build(r16);
        goto L20
    L15:
        throw new InvalidObjectException("Unsupported collection type tag: " + r11 + '.');
    L23:
        throw new InvalidObjectException("Illegal size value: " + r12 + '.');
    L25:
        throw new InvalidObjectException("Unsupported flags value: " + r5 + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r5) {
        Intrinsics.checkNotNullParameter(r5, "output");
        r5.writeByte(this.tag);
        r5.writeInt(this.collection.size());
        Iterator<?> r10 = this.collection.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.writeObject(r10.next());
        goto L4
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }
}
