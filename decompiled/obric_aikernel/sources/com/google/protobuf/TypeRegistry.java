package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class TypeRegistry {
    private static final Logger logger = null;
    private final Map<String, Descriptors.Descriptor> types;

    /* JADX INFO: renamed from: com.google.protobuf.TypeRegistry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final Set<String> files;
        private Map<String, Descriptors.Descriptor> types;

        private Builder() {
            this.files = new HashSet();
            this.types = new HashMap();
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void addFile(Descriptors.FileDescriptor r10) {
            if (this.files.add(r10.getFullName()) == true) goto L5;
            return;
        L5:
            Iterator<Descriptors.FileDescriptor> r11 = r10.getDependencies().iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            addFile(r11.next());
            goto L7
        L9:
            Iterator<Descriptors.Descriptor> r12 = r10.getMessageTypes().iterator();
        L11:
            if (r12.hasNext() == false) goto L13;
            addMessage(r12.next());
            goto L11
        }

        private void addMessage(Descriptors.Descriptor r10) {
            Iterator<Descriptors.Descriptor> r11 = r10.getNestedTypes().iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            addMessage(r11.next());
            goto L4
        L7:
            if (this.types.containsKey(r10.getFullName()) == false) goto L10;
            TypeRegistry.access$200().warning("Type " + r10.getFullName() + " is added multiple times.");
            return;
        L10:
            this.types.put(r10.getFullName(), r10);
        }

        public Builder add(Descriptors.Descriptor r10) {
            if (this.types == null) goto L7;
            addFile(r10.getFile());
            return this;
        L7:
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public Builder add(Iterable<Descriptors.Descriptor> r10) {
            if (this.types == null) goto L10;
            Iterator<Descriptors.Descriptor> r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L8;
            addFile(r11.next().getFile());
            goto L6
        L8:
            return this;
        L10:
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public TypeRegistry build() {
            TypeRegistry r10 = new TypeRegistry(this.types);
            this.types = null;
            return r10;
        }
    }

    private static class EmptyTypeRegistryHolder {
        private static final TypeRegistry EMPTY = null;

        static {
            EMPTY = new TypeRegistry(Collections.emptyMap());
        }

        private EmptyTypeRegistryHolder() {
        }

        static /* synthetic */ TypeRegistry access$000() {
            return EMPTY;
        }
    }

    static {
        logger = Logger.getLogger(TypeRegistry.class.getName());
    }

    TypeRegistry(Map<String, Descriptors.Descriptor> r10) {
        this.types = r10;
    }

    static /* synthetic */ Logger access$200() {
        return logger;
    }

    public static TypeRegistry getEmptyTypeRegistry() {
        return EmptyTypeRegistryHolder.access$000();
    }

    private static String getTypeName(String r10) {
        String[] r11 = r10.split("/");
        if (r11.length <= 1) goto L7;
        return r11[r11.length - 1];
    L7:
        throw new InvalidProtocolBufferException("Invalid type url found: " + r10);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public Descriptors.Descriptor find(String r10) {
        return this.types.get(r10);
    }

    public final Descriptors.Descriptor getDescriptorForTypeUrl(String r10) {
        return find(getTypeName(r10));
    }
}
