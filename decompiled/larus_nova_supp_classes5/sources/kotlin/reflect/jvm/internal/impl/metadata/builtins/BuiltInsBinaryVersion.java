package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final Companion Companion = null;
    public static final BuiltInsBinaryVersion INSTANCE = null;
    public static final BuiltInsBinaryVersion INVALID_VERSION = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final BuiltInsBinaryVersion readFrom(InputStream r4) {
            Intrinsics.checkNotNullParameter(r4, "stream");
            DataInputStream r0 = new DataInputStream(r4);
            IntRange r5 = new IntRange(1, r0.readInt());
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<Integer> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ((IntIterator) r6).nextInt();
            r1.add(Integer.valueOf(r0.readInt()));
            goto L4
        L6:
            int[] r7 = CollectionsKt.toIntArray(r1);
            return new BuiltInsBinaryVersion(Arrays.copyOf(r7, r7.length));
        }
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new BuiltInsBinaryVersion(new int[]{1, 0, 7});
        INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);
    }

    public boolean isCompatibleWithCurrentCompilerVersion() {
        return isCompatibleTo(INSTANCE);
    }

    public BuiltInsBinaryVersion(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "numbers");
        super(Arrays.copyOf(r2, r2.length));
    }
}
