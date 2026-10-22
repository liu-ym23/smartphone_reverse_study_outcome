package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.builtins;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.BinaryVersion;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\u0012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/builtins/BuiltInsBinaryVersion;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/BinaryVersion;", "numbers", "", "", "([I)V", "isCompatible", "", "Companion", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final Companion Companion = null;

    @JvmField
    public static final BuiltInsBinaryVersion INSTANCE = null;

    @JvmField
    public static final BuiltInsBinaryVersion INVALID_VERSION = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/builtins/BuiltInsBinaryVersion$Companion;", "", "()V", "INSTANCE", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/builtins/BuiltInsBinaryVersion;", "INVALID_VERSION", "readFrom", "stream", "Ljava/io/InputStream;", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final BuiltInsBinaryVersion readFrom(InputStream r5) {
            Intrinsics.checkNotNullParameter(r5, "stream");
            DataInputStream r10 = new DataInputStream(r5);
            IntRange r11 = new IntRange(1, r10.readInt());
            ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
            Iterator<Integer> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            ((IntIterator) r13).nextInt();
            r12.add(Integer.valueOf(r10.readInt()));
            goto L4
        L6:
            int[] r14 = CollectionsKt.toIntArray(r12);
            return new BuiltInsBinaryVersion(Arrays.copyOf(r14, r14.length));
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new BuiltInsBinaryVersion(new int[]{1, 0, 7});
        INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);
    }

    public BuiltInsBinaryVersion(int... r5) {
        Intrinsics.checkNotNullParameter(r5, "numbers");
        super(Arrays.copyOf(r5, r5.length));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.BinaryVersion
    public boolean isCompatible() {
        return isCompatibleTo(INSTANCE);
    }
}
