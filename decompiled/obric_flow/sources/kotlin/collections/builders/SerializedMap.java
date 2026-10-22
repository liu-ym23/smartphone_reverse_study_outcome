package kotlin.collections.builders;

import ai.j0;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "()V", "map", "", "(Ljava/util/Map;)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SerializedMap implements Externalizable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/SerializedMap$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public SerializedMap(Map<?, ?> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        this.map = r5;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        byte r5 = r10.readByte();
        if (r5 != 0) goto L14;
        int r11 = r10.readInt();
        if (r11 < 0) goto L12;
        Map r12 = MapsKt.createMapBuilder(r11);
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L9;
        r12.put(r10.readObject(), r10.readObject());
        r13 = r13 + 1;
        goto L7
    L9:
        this.map = MapsKt.build(r12);
        return;
    L12:
        throw new InvalidObjectException("Illegal size value: " + r11 + '.');
    L14:
        throw new InvalidObjectException(j0.g(r5, "Unsupported flags value: "));
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r5) {
        Intrinsics.checkNotNullParameter(r5, "output");
        r5.writeByte(0);
        r5.writeInt(this.map.size());
        Iterator<Map.Entry<?, ?>> r10 = this.map.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<?, ?> r11 = r10.next();
        r5.writeObject(r11.getKey());
        r5.writeObject(r11.getValue());
        goto L4
    }

    public SerializedMap() {
        this(MapsKt.emptyMap());
    }
}
