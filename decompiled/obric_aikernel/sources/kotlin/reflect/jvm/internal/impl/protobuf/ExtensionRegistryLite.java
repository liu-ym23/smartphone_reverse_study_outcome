package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.core.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ExtensionRegistryLite {
    private static final ExtensionRegistryLite EMPTY = null;
    private static volatile boolean eagerlyParseMessageSets = false;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    private static final class ObjectIntPair {
        private final int number;
        private final Object object;

        ObjectIntPair(Object r10, int r11) {
            this.object = r10;
            this.number = r11;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r11 = (ObjectIntPair) r10;
            if (this.object == r11.object) goto L8;
            return false;
        L8:
            if (this.number != r11.number) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }
    }

    static {
        EMPTY = new ExtensionRegistryLite(true);
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    private ExtensionRegistryLite(boolean r10) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return EMPTY;
    }

    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r10) {
        this.extensionsByNumber.put(new ObjectIntPair(r10.getContainingTypeDefaultInstance(), r10.getNumber()), r10);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r10, int r11) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r10, r11));
    }
}
