package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = null;
    static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static volatile boolean eagerlyParseMessageSets = false;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static class ExtensionClassHolder {
        static final Class<?> INSTANCE = null;

        static {
            INSTANCE = resolveExtensionClass();
        }

        private ExtensionClassHolder() {
        }

        public static Class<?> resolveExtensionClass() {
            return Extension.class;
        }
    }

    public static final class ObjectIntPair {
        private final int number;
        private final Object object;

        public ObjectIntPair(Object r8, int r10) {
            this.object = r8;
            this.number = r10;
        }

        public boolean equals(Object r8) {
            if ((r8 instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r10 = (ObjectIntPair) r8;
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
        EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        if (Android.assumeLiteRuntime == true) goto L5;
        ExtensionRegistryLite r8 = emptyRegistry;
        if (r8 == null) goto L9;
    L18:
        return r8;
    L9:
        monitor-enter(ExtensionRegistryLite.class);
        r8 = emptyRegistry;     // Catch: Throwable -> L15
        if (r8 != null) goto L13;
        r8 = ExtensionRegistryFactory.createEmpty();     // Catch: Throwable -> L15
        emptyRegistry = r8;     // Catch: Throwable -> L15
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
        if (Android.assumeLiteRuntime == false) goto L6;
        return new ExtensionRegistryLite();
    L6:
        return ExtensionRegistryFactory.create();
    }

    public static void setEagerlyParseMessageSets(boolean r8) {
        eagerlyParseMessageSets = r8;
    }

    public final void add(ExtensionLite<?, ?> r8) {
        if ((r8 instanceof GeneratedMessageLite.GeneratedExtension) == false) goto L6;
        add((GeneratedMessageLite.GeneratedExtension) r8);
    L6:
        if (Android.assumeLiteRuntime == false) goto L8;
        return;
    L8:
        if (ExtensionRegistryFactory.isFullRegistry(this) == false) goto L17;
        getClass().getMethod("add", new Class[]{ExtensionClassHolder.INSTANCE}).invoke(this, new Object[]{r8});     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{r8}), e);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r8, int r10) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r8, r10));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public ExtensionRegistryLite(ExtensionRegistryLite r8) {
        if (r8 != EMPTY_REGISTRY_LITE) goto L5;
        Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> r10 = Collections.emptyMap();
    L6:
        this.extensionsByNumber = r10;
        return;
    L5:
        r10 = Collections.unmodifiableMap(r8.extensionsByNumber);
        goto L6
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r8) {
        this.extensionsByNumber.put(new ObjectIntPair(r8.getContainingTypeDefaultInstance(), r8.getNumber()), r8);
    }

    public ExtensionRegistryLite(boolean r8) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
