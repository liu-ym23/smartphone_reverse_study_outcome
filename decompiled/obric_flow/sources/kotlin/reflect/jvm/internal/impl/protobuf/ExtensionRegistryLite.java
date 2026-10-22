package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ExtensionRegistryLite {
    private static final ExtensionRegistryLite EMPTY = null;
    private static volatile boolean eagerlyParseMessageSets = false;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static final class ObjectIntPair {
        private final int number;
        private final Object object;

        public ObjectIntPair(Object r5, int r10) {
            this.object = r5;
            this.number = r10;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r10 = (ObjectIntPair) r5;
            if (this.object == r10.object) goto L8;
            return false;
        L8:
            if (this.number != r10.number) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    static {
        EMPTY = new ExtensionRegistryLite(true);
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return EMPTY;
    }

    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r5) {
        this.extensionsByNumber.put(new ObjectIntPair(r5.getContainingTypeDefaultInstance(), r5.getNumber()), r5);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r5, int r10) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r5, r10));
    }

    private ExtensionRegistryLite(boolean r5) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
