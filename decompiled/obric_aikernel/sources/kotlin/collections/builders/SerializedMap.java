package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class SerializedMap implements Externalizable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

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

    public SerializedMap() {
        this(MapsKt.emptyMap());
    }

    public SerializedMap(Map<?, ?> r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        this.map = r10;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        byte r11 = r10.readByte();
        if (r11 != 0) goto L14;
        int r12 = r10.readInt();
        if (r12 < 0) goto L12;
        Map r13 = MapsKt.createMapBuilder(r12);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13.put(r10.readObject(), r10.readObject());
        r14 = r14 + 1;
        goto L7
    L9:
        this.map = MapsKt.build(r13);
        return;
    L12:
        throw new InvalidObjectException("Illegal size value: " + r12 + '.');
    L14:
        throw new InvalidObjectException("Unsupported flags value: " + r11);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r10) {
        Intrinsics.checkNotNullParameter(r10, "output");
        r10.writeByte(0);
        r10.writeInt(this.map.size());
        Iterator<Map.Entry<?, ?>> r11 = this.map.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<?, ?> r12 = r11.next();
        r10.writeObject(r12.getKey());
        r10.writeObject(r12.getValue());
        goto L4
    }
}
