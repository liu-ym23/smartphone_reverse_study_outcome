package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    public ExtensionSchema() {
    }

    public abstract int extensionNumber(Map.Entry<?, ?> r8);

    public abstract Object findExtensionByNumber(ExtensionRegistryLite r8, MessageLite r10, int r11);

    public abstract FieldSet<T> getExtensions(Object r8);

    public abstract FieldSet<T> getMutableExtensions(Object r8);

    public abstract boolean hasExtensions(MessageLite r8);

    public abstract void makeImmutable(Object r8);

    public abstract <UT, UB> UB parseExtension(Object r8, Reader r10, Object r11, ExtensionRegistryLite r12, FieldSet<T> r13, UB r14, UnknownFieldSchema<UT, UB> r15);

    public abstract void parseLengthPrefixedMessageSetItem(Reader r8, Object r10, ExtensionRegistryLite r11, FieldSet<T> r12);

    public abstract void parseMessageSetItem(ByteString r8, Object r10, ExtensionRegistryLite r11, FieldSet<T> r12);

    public abstract void serializeExtension(Writer r8, Map.Entry<?, ?> r10);

    public abstract void setExtensions(Object r8, FieldSet<T> r10);
}
