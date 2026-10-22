package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class LazyFieldLite {
    private volatile boolean corrupted;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;
    protected volatile MessageLite value;

    public LazyFieldLite() {
    }

    public LazyFieldLite(ExtensionRegistryLite r1, ByteString r2) {
        checkArguments(r1, r2);
        this.extensionRegistry = r1;
        this.delayedBytes = r2;
    }

    private static void checkArguments(ExtensionRegistryLite r1, ByteString r2) {
        Objects.requireNonNull(r1, "found null ExtensionRegistry");
        Objects.requireNonNull(r2, "found null ByteString");
    }

    public static LazyFieldLite fromValue(MessageLite r2) {
        MessageLite r3 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin");
        LazyFieldLite r0 = new LazyFieldLite();
        r0.setValue(r3);
        return r0;
    }

    private static MessageLite mergeValueAndBytes(MessageLite r2, ByteString r3, ExtensionRegistryLite r4) {
        MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin");
        return r5.toBuilder().mergeFrom(r3, r4).build();
    L8:
        return r5;
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public boolean containsDefaultInstance() {
        if (this.memoizedBytes != ByteString.EMPTY) goto L5;
    L12:
        return true;
    L5:
        if (this.value != null) goto L11;
        ByteString r2 = this.delayedBytes;
        if (r2 == null) goto L12;
        if (r2 == ByteString.EMPTY) goto L12;
    L11:
        return false;
    }

    public void ensureInitialized(MessageLite r4) {
        MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
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
        this.value = (MessageLite) ZeusTransformUtils.preCheckCast(r5.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry), MessageLite.class, "com.obric.memorydata.plugin");     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
        ByteString r0 = this.delayedBytes;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L13:
        this.memoizedBytes = r0;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
        goto L17
    L14:
        this.value = r5;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
        r0 = ByteString.EMPTY;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L20
    L17:
        this.corrupted = true;     // Catch: Throwable -> L20
        this.value = r5;     // Catch: Throwable -> L20
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L20
        goto L18
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, LazyFieldLite.class) == true) goto L10;
        return false;
    L10:
        LazyFieldLite r4 = (LazyFieldLite) ZeusTransformUtils.preCheckCast(r3, LazyFieldLite.class, "com.obric.memorydata.plugin");
        MessageLite r0 = this.value;
        MessageLite r1 = r4.value;
        if (r0 != null) goto L15;
        if (r1 != null) goto L15;
        return toByteString().equals(r4.toByteString());
    L15:
        if (r0 == null) goto L19;
        if (r1 == null) goto L19;
        return r0.equals(r1);
    L19:
        if (r0 == null) goto L23;
        return r0.equals(r4.getValue(r0.getDefaultInstanceForType()));
    L23:
        return getValue(r1.getDefaultInstanceForType()).equals(r1);
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L11;
        return r0.size();
    L11:
        if (this.value != null) goto L13;
        return 0;
    L13:
        return this.value.getSerializedSize();
    L5:
        return this.memoizedBytes.size();
    }

    public MessageLite getValue(MessageLite r3) {
        ensureInitialized((MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin"));
        return this.value;
    }

    public int hashCode() {
        return 1;
    }

    boolean isCorrupted() {
        return this.corrupted;
    }

    public void merge(LazyFieldLite r3) {
        if (r3.containsDefaultInstance() == false) goto L6;
        return;
    L6:
        if (containsDefaultInstance() == false) goto L10;
        set(r3);
        return;
    L10:
        if (this.extensionRegistry != null) goto L12;
        this.extensionRegistry = r3.extensionRegistry;
    L12:
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L19;
        ByteString r1 = r3.delayedBytes;
        if (r1 == null) goto L19;
        this.delayedBytes = r0.concat(r1);
        return;
    L19:
        if (this.value != null) goto L25;
        if (r3.value == null) goto L25;
        setValue(mergeValueAndBytes(r3.value, this.delayedBytes, this.extensionRegistry));
        return;
    L25:
        if (this.value != null) goto L27;
    L30:
        setValue(this.value.toBuilder().mergeFrom(r3.value).build());
        return;
    L27:
        if (r3.value != null) goto L30;
        setValue(mergeValueAndBytes(this.value, r3.delayedBytes, r3.extensionRegistry));
    }

    public void mergeFrom(CodedInputStream r2, ExtensionRegistryLite r3) {
        if (containsDefaultInstance() == false) goto L8;
        ByteString r4 = r2.readBytes();
    L5:
        setByteString(r4, r3);
        return;
    L8:
        if (this.extensionRegistry != null) goto L10;
        this.extensionRegistry = r3;
    L10:
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L16;
        r4 = r0.concat(r2.readBytes());
        r3 = this.extensionRegistry;
        goto L5
    L16:
        setValue(this.value.toBuilder().mergeFrom(r2, r3).build());     // Catch: InvalidProtocolBufferException -> L15
        return;
    }

    public void set(LazyFieldLite r2) {
        this.delayedBytes = r2.delayedBytes;
        this.value = r2.value;
        this.memoizedBytes = r2.memoizedBytes;
        ExtensionRegistryLite r3 = r2.extensionRegistry;
        if (r3 == null) goto L6;
        this.extensionRegistry = r3;
        return;
    }

    public void setByteString(ByteString r1, ExtensionRegistryLite r2) {
        checkArguments(r2, r1);
        this.delayedBytes = r1;
        this.extensionRegistry = r2;
        this.value = null;
        this.memoizedBytes = null;
    }

    public MessageLite setValue(MessageLite r3) {
        MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
        MessageLite r0 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = r4;
        return r0;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L9;
        return r0;
    L9:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (this.memoizedBytes == null) goto L16;
        ByteString r1 = this.memoizedBytes;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r1;
    L16:
        if (this.value != null) goto L19;
        ByteString r2 = ByteString.EMPTY;     // Catch: Throwable -> L23
    L18:
        this.memoizedBytes = r2;     // Catch: Throwable -> L23
        ByteString r3 = this.memoizedBytes;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r3;
    L19:
        r2 = this.value.toByteString();     // Catch: Throwable -> L23
        goto L18
    L5:
        return this.memoizedBytes;
    }

    void writeTo(Writer r3, int r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin");
        if (this.memoizedBytes == null) goto L6;
        ByteString r2 = this.memoizedBytes;
    L5:
        r5.writeBytes(r4, r2);
        return;
    L6:
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L10;
        r5.writeBytes(r4, r0);
        return;
    L10:
        if (this.value == null) goto L12;
        r5.writeMessage(r4, this.value);
        return;
    L12:
        r2 = ByteString.EMPTY;
        goto L5
    }
}
