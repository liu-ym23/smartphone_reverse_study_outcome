package com.google.protobuf;

import androidx.core.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = null;
    static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static volatile boolean eagerlyParseMessageSets = false;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    private static class ExtensionClassHolder {
        static final Class<?> INSTANCE = null;

        static {
            INSTANCE = resolveExtensionClass();
        }

        private ExtensionClassHolder() {
        }

        static Class<?> resolveExtensionClass() {
            return Extension.class;
        }
    }

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
        EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    ExtensionRegistryLite(ExtensionRegistryLite r10) {
        if (r10 != EMPTY_REGISTRY_LITE) goto L5;
        Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> r11 = Collections.emptyMap();
    L6:
        this.extensionsByNumber = r11;
        return;
    L5:
        r11 = Collections.unmodifiableMap(r10.extensionsByNumber);
        goto L6
    }

    ExtensionRegistryLite(boolean r10) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        if (Protobuf.assumeLiteRuntime == true) goto L5;
        ExtensionRegistryLite r10 = emptyRegistry;
        if (r10 == null) goto L9;
    L18:
        return r10;
    L9:
        monitor-enter(ExtensionRegistryLite.class);
        r10 = emptyRegistry;     // Catch: Throwable -> L15
        if (r10 != null) goto L13;
        r10 = ExtensionRegistryFactory.createEmpty();     // Catch: Throwable -> L15
        emptyRegistry = r10;     // Catch: Throwable -> L15
    L13:
        monitor-exit(ExtensionRegistryLite.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L5:
        return EMPTY_REGISTRY_LITE;
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static ExtensionRegistryLite newInstance() {
        if (Protobuf.assumeLiteRuntime == false) goto L6;
        return new ExtensionRegistryLite();
    L6:
        return ExtensionRegistryFactory.create();
    }

    public static void setEagerlyParseMessageSets(boolean r10) {
        eagerlyParseMessageSets = r10;
    }

    public final void add(ExtensionLite<?, ?> r10) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(r10.getClass()) == false) goto L6;
        add((GeneratedMessageLite.GeneratedExtension) r10);
    L6:
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return;
    L8:
        if (ExtensionRegistryFactory.isFullRegistry(this) == true) goto L16;
        return;
    L16:
        getClass().getMethod("add", new Class[]{ExtensionClassHolder.INSTANCE}).invoke(this, new Object[]{r10});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{r10}), e);
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r10) {
        this.extensionsByNumber.put(new ObjectIntPair(r10.getContainingTypeDefaultInstance(), r10.getNumber()), r10);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r10, int r11) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r10, r11));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }
}
