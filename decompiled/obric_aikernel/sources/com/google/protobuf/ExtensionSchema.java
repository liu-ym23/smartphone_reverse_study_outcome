package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    ExtensionSchema() {
    }

    abstract int extensionNumber(Map.Entry<?, ?> r10);

    abstract Object findExtensionByNumber(ExtensionRegistryLite r10, MessageLite r11, int r12);

    abstract FieldSet<T> getExtensions(Object r10);

    abstract FieldSet<T> getMutableExtensions(Object r10);

    abstract boolean hasExtensions(MessageLite r10);

    abstract void makeImmutable(Object r10);

    abstract <UT, UB> UB parseExtension(Object r10, Reader r11, Object r12, ExtensionRegistryLite r13, FieldSet<T> r14, UB r15, UnknownFieldSchema<UT, UB> r16);

    abstract void parseLengthPrefixedMessageSetItem(Reader r10, Object r11, ExtensionRegistryLite r12, FieldSet<T> r13);

    abstract void parseMessageSetItem(ByteString r10, Object r11, ExtensionRegistryLite r12, FieldSet<T> r13);

    abstract void serializeExtension(Writer r10, Map.Entry<?, ?> r11);

    abstract void setExtensions(Object r10, FieldSet<T> r11);
}
