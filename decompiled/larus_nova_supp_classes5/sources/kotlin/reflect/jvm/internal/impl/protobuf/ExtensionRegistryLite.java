package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ExtensionRegistryLite {
    private static final ExtensionRegistryLite EMPTY = null;
    private static volatile boolean eagerlyParseMessageSets;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static final class ObjectIntPair {
        private final int number;
        private final Object object;

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r5 = (ObjectIntPair) r4;
            if (this.object == r5.object) goto L8;
            return false;
        L8:
            if (this.number != r5.number) goto L12;
            return true;
        L12:
            return false;
        }

        public ObjectIntPair(Object r1, int r2) {
            this.object = r1;
            this.number = r2;
        }
    }

    static {
        EMPTY = new ExtensionRegistryLite(true);
    }

    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return EMPTY;
    }

    private ExtensionRegistryLite(boolean r1) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r5) {
        this.extensionsByNumber.put(new ObjectIntPair(r5.getContainingTypeDefaultInstance(), r5.getNumber()), r5);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r3, int r4) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r3, r4));
    }
}
