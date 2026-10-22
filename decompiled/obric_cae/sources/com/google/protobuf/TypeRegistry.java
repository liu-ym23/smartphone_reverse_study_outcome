package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class TypeRegistry {
    private static final Logger logger = null;
    private final Map<String, Descriptors.Descriptor> types;

    /* JADX INFO: renamed from: com.google.protobuf.TypeRegistry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final Set<String> files;
        private Map<String, Descriptors.Descriptor> types;

        private Builder() {
            this.files = new HashSet();
            this.types = new HashMap();
        }

        private void addFile(Descriptors.FileDescriptor r8) {
            if (this.files.add(r8.getFullName()) == true) goto L5;
            return;
        L5:
            Iterator<Descriptors.FileDescriptor> r10 = r8.getDependencies().iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            addFile(r10.next());
            goto L7
        L9:
            Iterator<Descriptors.Descriptor> r11 = r8.getMessageTypes().iterator();
        L11:
            if (r11.hasNext() == false) goto L13;
            addMessage(r11.next());
            goto L11
        }

        private void addMessage(Descriptors.Descriptor r8) {
            Iterator<Descriptors.Descriptor> r10 = r8.getNestedTypes().iterator();
        L4:
            if (r10.hasNext() == false) goto L7;
            addMessage(r10.next());
            goto L4
        L7:
            if (this.types.containsKey(r8.getFullName()) == false) goto L10;
            TypeRegistry.access$200().warning("Type " + r8.getFullName() + " is added multiple times.");
            return;
        L10:
            this.types.put(r8.getFullName(), r8);
        }

        public Builder add(Descriptors.Descriptor r8) {
            if (this.types == null) goto L7;
            addFile(r8.getFile());
            return this;
        L7:
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public TypeRegistry build() {
            TypeRegistry r8 = new TypeRegistry(this.types);
            this.types = null;
            return r8;
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder add(Iterable<Descriptors.Descriptor> r8) {
            if (this.types == null) goto L10;
            Iterator<Descriptors.Descriptor> r10 = r8.iterator();
        L6:
            if (r10.hasNext() == false) goto L8;
            addFile(r10.next().getFile());
            goto L6
        L8:
            return this;
        L10:
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }
    }

    public static class EmptyTypeRegistryHolder {
        private static final TypeRegistry EMPTY = null;

        static {
            EMPTY = new TypeRegistry(Collections.emptyMap());
        }

        private EmptyTypeRegistryHolder() {
        }

        public static /* synthetic */ TypeRegistry access$000() {
            return EMPTY;
        }
    }

    static {
        logger = Logger.getLogger(TypeRegistry.class.getName());
    }

    public TypeRegistry(Map<String, Descriptors.Descriptor> r8) {
        this.types = r8;
    }

    public static /* synthetic */ Logger access$200() {
        return logger;
    }

    public static TypeRegistry getEmptyTypeRegistry() {
        return EmptyTypeRegistryHolder.access$000();
    }

    private static String getTypeName(String r8) {
        String[] r10 = r8.split("/");
        if (r10.length <= 1) goto L7;
        return r10[r10.length - 1];
    L7:
        throw new InvalidProtocolBufferException("Invalid type url found: ".concat(r8));
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public Descriptors.Descriptor find(String r8) {
        return this.types.get(r8);
    }

    public final Descriptors.Descriptor getDescriptorForTypeUrl(String r8) {
        return find(getTypeName(r8));
    }
}
