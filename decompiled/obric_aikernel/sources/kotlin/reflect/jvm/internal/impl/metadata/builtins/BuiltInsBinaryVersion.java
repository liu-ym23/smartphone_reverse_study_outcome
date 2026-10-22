package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final Companion Companion = null;

    @JvmField
    public static final BuiltInsBinaryVersion INSTANCE = null;

    @JvmField
    public static final BuiltInsBinaryVersion INVALID_VERSION = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final BuiltInsBinaryVersion readFrom(InputStream r10) {
            Intrinsics.checkNotNullParameter(r10, "stream");
            DataInputStream r11 = new DataInputStream(r10);
            IntRange r12 = new IntRange(1, r11.readInt());
            ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator<Integer> r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            ((IntIterator) r14).nextInt();
            r13.add(Integer.valueOf(r11.readInt()));
            goto L4
        L6:
            int[] r15 = CollectionsKt.toIntArray(r13);
            return new BuiltInsBinaryVersion(Arrays.copyOf(r15, r15.length));
        }
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new BuiltInsBinaryVersion(new int[]{1, 0, 7});
        INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);
    }

    public BuiltInsBinaryVersion(int... r10) {
        Intrinsics.checkNotNullParameter(r10, "numbers");
        super(Arrays.copyOf(r10, r10.length));
    }

    public boolean isCompatible() {
        return isCompatibleTo(INSTANCE);
    }
}
