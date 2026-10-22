package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public class LazyFieldLite {
    private volatile boolean corrupted;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;
    protected volatile MessageLite value;

    public LazyFieldLite() {
    }

    public LazyFieldLite(ExtensionRegistryLite r8, ByteString r10) {
        checkArguments(r8, r10);
        this.extensionRegistry = r8;
        this.delayedBytes = r10;
    }

    private static void checkArguments(ExtensionRegistryLite r8, ByteString r10) {
        if (r8 == null) goto L8;
        if (r10 == null) goto L6;
        return;
    L6:
        throw new NullPointerException("found null ByteString");
    L8:
        throw new NullPointerException("found null ExtensionRegistry");
    }

    public static LazyFieldLite fromValue(MessageLite r8) {
        LazyFieldLite r10 = new LazyFieldLite();
        r10.setValue(r8);
        return r10;
    }

    private static MessageLite mergeValueAndBytes(MessageLite r8, ByteString r10, ExtensionRegistryLite r11) {
        return r8.toBuilder().mergeFrom(r10, r11).build();
    L7:
        return r8;
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public int computeMessageSetExtensionSize(int r8) {
        int r10 = CodedOutputStream.computeTagSize(1) * 2;
        int r11 = CodedOutputStream.computeUInt32Size(2, r8) + r10;
        return computeSize(3) + r11;
    }

    public int computeSize(int r8) {
        int r10 = CodedOutputStream.computeTagSize(r8);
        return computeSizeNoTag() + r10;
    }

    public int computeSizeNoTag() {
        return CodedOutputStream.computeLengthDelimitedFieldSize(getSerializedSize());
    }

    public boolean containsDefaultInstance() {
        ByteString r8 = this.memoizedBytes;
        ByteString r10 = ByteString.EMPTY;
        if (r8 != r10) goto L5;
    L11:
        return true;
    L5:
        if (this.value != null) goto L10;
        ByteString r11 = this.delayedBytes;
        if (r11 == null) goto L11;
        if (r11 == r10) goto L11;
    L10:
        return false;
    }

    public void ensureInitialized(MessageLite r8) {
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
        this.value = r8.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
        ByteString r10 = this.delayedBytes;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L13:
        this.memoizedBytes = r10;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
        goto L17
    L14:
        this.value = r8;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
        r10 = ByteString.EMPTY;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L17:
        this.corrupted = true;     // Catch: Throwable -> L20
        this.value = r8;     // Catch: Throwable -> L20
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L20
        goto L18
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LazyFieldLite) == true) goto L9;
        return false;
    L9:
        LazyFieldLite r10 = (LazyFieldLite) r8;
        MessageLite r11 = this.value;
        MessageLite r12 = r10.value;
        if (r11 != null) goto L14;
        if (r12 != null) goto L14;
        return toByteString().equals(r10.toByteString());
    L14:
        if (r11 == null) goto L18;
        if (r12 == null) goto L18;
        return r11.equals(r12);
    L18:
        if (r11 == null) goto L22;
        return r11.equals(r10.getValue(r11.getDefaultInstanceForType()));
    L22:
        return getValue(r12.getDefaultInstanceForType()).equals(r12);
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r8 = this.delayedBytes;
        if (r8 == null) goto L11;
        return r8.size();
    L11:
        if (this.value != null) goto L13;
        return 0;
    L13:
        return this.value.getSerializedSize();
    L5:
        return this.memoizedBytes.size();
    }

    public MessageLite getValue(MessageLite r8) {
        ensureInitialized(r8);
        return this.value;
    }

    public int hashCode() {
        return 1;
    }

    public boolean isCorrupted() {
        return this.corrupted;
    }

    public void merge(LazyFieldLite r8) {
        if (r8.containsDefaultInstance() == false) goto L6;
        return;
    L6:
        if (containsDefaultInstance() == false) goto L10;
        set(r8);
        return;
    L10:
        if (this.extensionRegistry != null) goto L12;
        this.extensionRegistry = r8.extensionRegistry;
    L12:
        ByteString r10 = this.delayedBytes;
        if (r10 == null) goto L19;
        ByteString r11 = r8.delayedBytes;
        if (r11 == null) goto L19;
        this.delayedBytes = r10.concat(r11);
        return;
    L19:
        if (this.value != null) goto L25;
        if (r8.value == null) goto L25;
        setValue(mergeValueAndBytes(r8.value, this.delayedBytes, this.extensionRegistry));
        return;
    L25:
        if (this.value != null) goto L27;
    L30:
        setValue(this.value.toBuilder().mergeFrom(r8.value).build());
        return;
    L27:
        if (r8.value != null) goto L30;
        setValue(mergeValueAndBytes(this.value, r8.delayedBytes, r8.extensionRegistry));
    }

    public void mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        if (containsDefaultInstance() == false) goto L8;
        ByteString r11 = r8.readBytes();
    L5:
        setByteString(r11, r10);
        return;
    L8:
        if (this.extensionRegistry != null) goto L10;
        this.extensionRegistry = r10;
    L10:
        ByteString r12 = this.delayedBytes;
        if (r12 == null) goto L16;
        r11 = r12.concat(r8.readBytes());
        r10 = this.extensionRegistry;
        goto L5
    L16:
        setValue(this.value.toBuilder().mergeFrom(r8, r10).build());     // Catch: InvalidProtocolBufferException -> L15
        return;
    }

    public void set(LazyFieldLite r8) {
        this.delayedBytes = r8.delayedBytes;
        this.value = r8.value;
        this.memoizedBytes = r8.memoizedBytes;
        ExtensionRegistryLite r10 = r8.extensionRegistry;
        if (r10 == null) goto L6;
        this.extensionRegistry = r10;
        return;
    }

    public void setByteString(ByteString r8, ExtensionRegistryLite r10) {
        checkArguments(r10, r8);
        this.delayedBytes = r8;
        this.extensionRegistry = r10;
        this.value = null;
        this.memoizedBytes = null;
    }

    public MessageLite setValue(MessageLite r8) {
        MessageLite r10 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = r8;
        return r10;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r8 = this.delayedBytes;
        if (r8 == null) goto L9;
        return r8;
    L9:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (this.memoizedBytes == null) goto L16;
        ByteString r10 = this.memoizedBytes;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r10;
    L16:
        if (this.value != null) goto L19;
        ByteString r11 = ByteString.EMPTY;     // Catch: Throwable -> L23
    L18:
        this.memoizedBytes = r11;     // Catch: Throwable -> L23
        ByteString r12 = this.memoizedBytes;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r12;
    L19:
        r11 = this.value.toByteString();     // Catch: Throwable -> L23
        goto L18
    L5:
        return this.memoizedBytes;
    }

    public void writeTo(Writer r8, int r10) {
        if (this.memoizedBytes == null) goto L6;
        ByteString r11 = this.memoizedBytes;
    L5:
        r8.writeBytes(r10, r11);
        return;
    L6:
        ByteString r12 = this.delayedBytes;
        if (r12 == null) goto L10;
        r8.writeBytes(r10, r12);
        return;
    L10:
        if (this.value == null) goto L12;
        r8.writeMessage(r10, this.value);
        return;
    L12:
        r11 = ByteString.EMPTY;
        goto L5
    }
}
