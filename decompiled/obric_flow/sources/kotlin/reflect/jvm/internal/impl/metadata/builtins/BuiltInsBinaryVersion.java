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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final Companion Companion = null;

    @JvmField
    public static final BuiltInsBinaryVersion INSTANCE = null;

    @JvmField
    public static final BuiltInsBinaryVersion INVALID_VERSION = null;

    @SourceDebugExtension({"SMAP\nBuiltInsBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInsBinaryVersion.kt\norg/jetbrains/kotlin/metadata/builtins/BuiltInsBinaryVersion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,33:1\n1549#2:34\n1620#2,3:35\n*S KotlinDebug\n*F\n+ 1 BuiltInsBinaryVersion.kt\norg/jetbrains/kotlin/metadata/builtins/BuiltInsBinaryVersion$Companion\n*L\n29#1:34\n29#1:35,3\n*E\n"})
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

    public boolean isCompatibleWithCurrentCompilerVersion() {
        return isCompatibleTo(INSTANCE);
    }
}
