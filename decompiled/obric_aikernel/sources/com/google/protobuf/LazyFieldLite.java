package com.google.protobuf;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class LazyFieldLite {
    private volatile boolean corrupted;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;
    protected volatile MessageLite value;

    public LazyFieldLite() {
    }

    public LazyFieldLite(ExtensionRegistryLite r10, ByteString r11) {
        checkArguments(r10, r11);
        this.extensionRegistry = r10;
        this.delayedBytes = r11;
    }

    private static void checkArguments(ExtensionRegistryLite r10, ByteString r11) {
        Objects.requireNonNull(r10, "found null ExtensionRegistry");
        Objects.requireNonNull(r11, "found null ByteString");
    }

    public static LazyFieldLite fromValue(MessageLite r10) {
        LazyFieldLite r11 = new LazyFieldLite();
        r11.setValue(r10);
        return r11;
    }

    private static MessageLite mergeValueAndBytes(MessageLite r10, ByteString r11, ExtensionRegistryLite r12) {
        return r10.toBuilder().mergeFrom(r11, r12).build();
    L7:
        return r10;
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public boolean containsDefaultInstance() {
        ByteString r10 = this.memoizedBytes;
        ByteString r11 = ByteString.EMPTY;
        if (r10 != r11) goto L5;
    L11:
        return true;
    L5:
        if (this.value != null) goto L10;
        ByteString r12 = this.delayedBytes;
        if (r12 == null) goto L11;
        if (r12 == r11) goto L11;
    L10:
        return false;
    }

    protected void ensureInitialized(MessageLite r10) {
        if (this.value == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.value == null) goto L24;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L24:
        if (this.delayedBytes == null) goto L14;
        this.value = r10.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
        ByteString r11 = this.delayedBytes;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L13:
        this.memoizedBytes = r11;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
        goto L17
    L14:
        this.value = r10;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
        r11 = ByteString.EMPTY;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L17:
        this.corrupted = true;     // Catch: Throwable -> L20
        this.value = r10;     // Catch: Throwable -> L20
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L20
        goto L18
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LazyFieldLite) == true) goto L9;
        return false;
    L9:
        LazyFieldLite r11 = (LazyFieldLite) r10;
        MessageLite r12 = this.value;
        MessageLite r13 = r11.value;
        if (r12 != null) goto L14;
        if (r13 != null) goto L14;
        return toByteString().equals(r11.toByteString());
    L14:
        if (r12 == null) goto L18;
        if (r13 == null) goto L18;
        return r12.equals(r13);
    L18:
        if (r12 == null) goto L22;
        return r12.equals(r11.getValue(r12.getDefaultInstanceForType()));
    L22:
        return getValue(r13.getDefaultInstanceForType()).equals(r13);
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r10 = this.delayedBytes;
        if (r10 == null) goto L11;
        return r10.size();
    L11:
        if (this.value != null) goto L13;
        return 0;
    L13:
        return this.value.getSerializedSize();
    L5:
        return this.memoizedBytes.size();
    }

    public MessageLite getValue(MessageLite r10) {
        ensureInitialized(r10);
        return this.value;
    }

    public int hashCode() {
        return 1;
    }

    boolean isCorrupted() {
        return this.corrupted;
    }

    public void merge(LazyFieldLite r10) {
        if (r10.containsDefaultInstance() == false) goto L6;
        return;
    L6:
        if (containsDefaultInstance() == false) goto L10;
        set(r10);
        return;
    L10:
        if (this.extensionRegistry != null) goto L12;
        this.extensionRegistry = r10.extensionRegistry;
    L12:
        ByteString r11 = this.delayedBytes;
        if (r11 == null) goto L19;
        ByteString r12 = r10.delayedBytes;
        if (r12 == null) goto L19;
        this.delayedBytes = r11.concat(r12);
        return;
    L19:
        if (this.value != null) goto L25;
        if (r10.value == null) goto L25;
        setValue(mergeValueAndBytes(r10.value, this.delayedBytes, this.extensionRegistry));
        return;
    L25:
        if (this.value != null) goto L27;
    L30:
        setValue(this.value.toBuilder().mergeFrom(r10.value).build());
        return;
    L27:
        if (r10.value != null) goto L30;
        setValue(mergeValueAndBytes(this.value, r10.delayedBytes, r10.extensionRegistry));
    }

    public void mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        if (containsDefaultInstance() == false) goto L8;
        ByteString r12 = r10.readBytes();
    L5:
        setByteString(r12, r11);
        return;
    L8:
        if (this.extensionRegistry != null) goto L10;
        this.extensionRegistry = r11;
    L10:
        ByteString r13 = this.delayedBytes;
        if (r13 == null) goto L16;
        r12 = r13.concat(r10.readBytes());
        r11 = this.extensionRegistry;
        goto L5
    L16:
        setValue(this.value.toBuilder().mergeFrom(r10, r11).build());     // Catch: InvalidProtocolBufferException -> L15
        return;
    }

    public void set(LazyFieldLite r10) {
        this.delayedBytes = r10.delayedBytes;
        this.value = r10.value;
        this.memoizedBytes = r10.memoizedBytes;
        ExtensionRegistryLite r11 = r10.extensionRegistry;
        if (r11 == null) goto L6;
        this.extensionRegistry = r11;
        return;
    }

    public void setByteString(ByteString r10, ExtensionRegistryLite r11) {
        checkArguments(r11, r10);
        this.delayedBytes = r10;
        this.extensionRegistry = r11;
        this.value = null;
        this.memoizedBytes = null;
    }

    public MessageLite setValue(MessageLite r10) {
        MessageLite r11 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = r10;
        return r11;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r10 = this.delayedBytes;
        if (r10 == null) goto L9;
        return r10;
    L9:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (this.memoizedBytes == null) goto L16;
        ByteString r11 = this.memoizedBytes;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r11;
    L16:
        if (this.value != null) goto L19;
        ByteString r12 = ByteString.EMPTY;     // Catch: Throwable -> L23
    L18:
        this.memoizedBytes = r12;     // Catch: Throwable -> L23
        ByteString r13 = this.memoizedBytes;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r13;
    L19:
        r12 = this.value.toByteString();     // Catch: Throwable -> L23
        goto L18
    L5:
        return this.memoizedBytes;
    }

    void writeTo(Writer r10, int r11) {
        if (this.memoizedBytes == null) goto L6;
        ByteString r12 = this.memoizedBytes;
    L5:
        r10.writeBytes(r11, r12);
        return;
    L6:
        ByteString r13 = this.delayedBytes;
        if (r13 == null) goto L10;
        r10.writeBytes(r11, r13);
        return;
    L10:
        if (this.value == null) goto L12;
        r10.writeMessage(r11, this.value);
        return;
    L12:
        r12 = ByteString.EMPTY;
        goto L5
    }
}
