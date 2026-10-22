package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ExtensionRegistry extends ExtensionRegistryLite {
    static final ExtensionRegistry EMPTY_REGISTRY = null;
    private final Map<String, ExtensionInfo> immutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> immutableExtensionsByNumber;
    private final Map<String, ExtensionInfo> mutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> mutableExtensionsByNumber;

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionRegistry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType = null;

        static {
            int[] r8 = new int[Extension.ExtensionType.values().length];
            $SwitchMap$com$google$protobuf$Extension$ExtensionType = r8;
            r8[Extension.ExtensionType.IMMUTABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension.ExtensionType.MUTABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final class DescriptorIntPair {
        private final Descriptors.Descriptor descriptor;
        private final int number;

        public DescriptorIntPair(Descriptors.Descriptor r8, int r10) {
            this.descriptor = r8;
            this.number = r10;
        }

        public static /* synthetic */ Descriptors.Descriptor access$000(DescriptorIntPair r8) {
            return r8.descriptor;
        }

        public boolean equals(Object r8) {
            if ((r8 instanceof DescriptorIntPair) == true) goto L5;
            return false;
        L5:
            DescriptorIntPair r10 = (DescriptorIntPair) r8;
            if (this.descriptor == r10.descriptor) goto L8;
            return false;
        L8:
            if (this.number != r10.number) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (this.descriptor.hashCode() * 65535) + this.number;
        }
    }

    public static final class ExtensionInfo {
        public final Message defaultInstance;
        public final Descriptors.FieldDescriptor descriptor;

        private ExtensionInfo(Descriptors.FieldDescriptor r8) {
            this.descriptor = r8;
            this.defaultInstance = null;
        }

        private ExtensionInfo(Descriptors.FieldDescriptor r8, Message r10) {
            this.descriptor = r8;
            this.defaultInstance = r10;
        }

        public /* synthetic */ ExtensionInfo(Descriptors.FieldDescriptor r8, Message r10, AnonymousClass1 r11) {
            this(r8, r10);
        }
    }

    static {
        EMPTY_REGISTRY = new ExtensionRegistry(true);
    }

    private ExtensionRegistry() {
        this.immutableExtensionsByName = new HashMap();
        this.mutableExtensionsByName = new HashMap();
        this.immutableExtensionsByNumber = new HashMap();
        this.mutableExtensionsByNumber = new HashMap();
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY_REGISTRY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ExtensionInfo newExtensionInfo(Extension<?, ?> r8) {
        AnonymousClass1 r10 = null;
        Object[] r11 = 0;
        Object[] r12 = 0;
        if (r8.getDescriptor().getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
        if (r8.getMessageDefaultInstance() == null) goto L9;
        return new ExtensionInfo(r8.getDescriptor(), r8.getMessageDefaultInstance(), r10);
    L9:
        throw new IllegalStateException("Registered message-type extension had null default instance: " + r8.getDescriptor().getFullName());
    L11:
        return new ExtensionInfo(r8.getDescriptor(), r12 == true ? 1 : 0, r11 == true ? 1 : 0);
    }

    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void add(Descriptors.FieldDescriptor r8) {
        if (r8.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        ExtensionInfo r10 = new ExtensionInfo(r8, null, 0 == true ? 1 : 0);
        add(r10, Extension.ExtensionType.IMMUTABLE);
        add(r10, Extension.ExtensionType.MUTABLE);
        return;
    L7:
        throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
    }

    @Deprecated
    public ExtensionInfo findExtensionByName(String r8) {
        return findImmutableExtensionByName(r8);
    }

    @Deprecated
    public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor r8, int r10) {
        return findImmutableExtensionByNumber(r8, r10);
    }

    public ExtensionInfo findImmutableExtensionByName(String r8) {
        return this.immutableExtensionsByName.get(r8);
    }

    public ExtensionInfo findImmutableExtensionByNumber(Descriptors.Descriptor r8, int r10) {
        return this.immutableExtensionsByNumber.get(new DescriptorIntPair(r8, r10));
    }

    @Deprecated
    public ExtensionInfo findMutableExtensionByName(String r8) {
        return this.mutableExtensionsByName.get(r8);
    }

    @Deprecated
    public ExtensionInfo findMutableExtensionByNumber(Descriptors.Descriptor r8, int r10) {
        return this.mutableExtensionsByNumber.get(new DescriptorIntPair(r8, r10));
    }

    public Set<ExtensionInfo> getAllImmutableExtensionsByExtendedType(String r8) {
        HashSet r10 = new HashSet();
        Iterator<DescriptorIntPair> r11 = this.immutableExtensionsByNumber.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        DescriptorIntPair r12 = r11.next();
        if (DescriptorIntPair.access$000(r12).getFullName().equals(r8) == false) goto L4;
        r10.add(this.immutableExtensionsByNumber.get(r12));
        goto L4
    L8:
        return r10;
    }

    @Deprecated
    public Set<ExtensionInfo> getAllMutableExtensionsByExtendedType(String r8) {
        HashSet r10 = new HashSet();
        Iterator<DescriptorIntPair> r11 = this.mutableExtensionsByNumber.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        DescriptorIntPair r12 = r11.next();
        if (DescriptorIntPair.access$000(r12).getFullName().equals(r8) == false) goto L4;
        r10.add(this.mutableExtensionsByNumber.get(r12));
        goto L4
    L8:
        return r10;
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }

    private ExtensionRegistry(ExtensionRegistry r8) {
        super(r8);
        this.immutableExtensionsByName = Collections.unmodifiableMap(r8.immutableExtensionsByName);
        this.mutableExtensionsByName = Collections.unmodifiableMap(r8.mutableExtensionsByName);
        this.immutableExtensionsByNumber = Collections.unmodifiableMap(r8.immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = Collections.unmodifiableMap(r8.mutableExtensionsByNumber);
    }

    public void add(Descriptors.FieldDescriptor r8, Message r10) {
        if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        add(new ExtensionInfo(r8, r10, null), Extension.ExtensionType.IMMUTABLE);
        return;
    L7:
        throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public /* bridge */ /* synthetic */ ExtensionRegistryLite getUnmodifiable() {
        return getUnmodifiable();
    }

    public ExtensionRegistry(boolean r8) {
        super(ExtensionRegistryLite.EMPTY_REGISTRY_LITE);
        this.immutableExtensionsByName = Collections.emptyMap();
        this.mutableExtensionsByName = Collections.emptyMap();
        this.immutableExtensionsByNumber = Collections.emptyMap();
        this.mutableExtensionsByNumber = Collections.emptyMap();
    }

    public void add(Extension<?, ?> r8) {
        if (r8.getExtensionType() != Extension.ExtensionType.IMMUTABLE) goto L5;
    L7:
        add(newExtensionInfo(r8), r8.getExtensionType());
        return;
    L5:
        if (r8.getExtensionType() == Extension.ExtensionType.MUTABLE) goto L7;
    }

    private void add(ExtensionInfo r8, Extension.ExtensionType r10) {
        if (r8.descriptor.isExtension() == false) goto L22;
        int r11 = AnonymousClass1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[r10.ordinal()];
        if (r11 != 1) goto L7;
        Map<String, ExtensionInfo> r12 = this.immutableExtensionsByName;
        Map<DescriptorIntPair, ExtensionInfo> r13 = this.immutableExtensionsByNumber;
    L11:
        r12.put(r8.descriptor.getFullName(), r8);
        r13.put(new DescriptorIntPair(r8.descriptor.getContainingType(), r8.descriptor.getNumber()), r8);
        Descriptors.FieldDescriptor r14 = r8.descriptor;
        if (r14.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L14;
        return;
    L14:
        if (r14.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) goto L16;
        return;
    L16:
        if (r14.isOptional() == true) goto L18;
        return;
    L18:
        if (r14.getExtensionScope() != r14.getMessageType()) goto L26;
        r12.put(r14.getMessageType().getFullName(), r8);
        return;
    L26:
        return;
    L7:
        if (r11 == 2) goto L9;
        return;
    L9:
        r12 = this.mutableExtensionsByName;
        r13 = this.mutableExtensionsByNumber;
        goto L11
    L22:
        throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
    }

    public void add(GeneratedMessage.GeneratedExtension<?, ?> r8) {
        add(r8);
    }
}
