package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class LazyFieldLite {
    private ByteString bytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;
    protected volatile MessageLite value;

    public LazyFieldLite(ExtensionRegistryLite r5, ByteString r10) {
        this.isDirty = false;
        this.extensionRegistry = r5;
        this.bytes = r10;
    }

    public static LazyFieldLite fromValue(MessageLite r5) {
        LazyFieldLite r10 = new LazyFieldLite();
        r10.setValue(r5);
        return r10;
    }

    public void clear() {
        this.bytes = null;
        this.value = null;
        this.extensionRegistry = null;
        this.isDirty = true;
    }

    public boolean containsDefaultInstance() {
        if (this.value == null) goto L5;
    L7:
        return false;
    L5:
        if (this.bytes != null) goto L7;
        return true;
    }

    public void ensureInitialized(MessageLite r5) {
        if (this.value == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.value == null) goto L22;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L22:
        if (this.bytes == null) goto L15;
        this.value = r5.getParserForType().parseFrom(this.bytes, this.extensionRegistry);     // Catch: Throwable -> L10 IOException -> L20
    L21:
        goto L16
    L15:
        this.value = r5;     // Catch: Throwable -> L10 IOException -> L20
    L16:
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public ExtensionRegistryLite getExtensionRegistry() {
        return this.extensionRegistry;
    }

    public int getSerializedSize() {
        if (this.isDirty == false) goto L7;
        return this.value.getSerializedSize();
    L7:
        return this.bytes.size();
    }

    public MessageLite getValue(MessageLite r5) {
        ensureInitialized(r5);
        return this.value;
    }

    public void merge(LazyFieldLite r5) {
        if (r5.containsDefaultInstance() == false) goto L5;
        return;
    L5:
        ByteString r10 = this.bytes;
        if (r10 != null) goto L8;
        this.bytes = r5.bytes;
    L9:
        this.isDirty = false;
        return;
    L8:
        r10.concat(r5.toByteString());
        goto L9
    }

    public void setByteString(ByteString r5, ExtensionRegistryLite r10) {
        this.bytes = r5;
        this.extensionRegistry = r10;
        this.isDirty = false;
    }

    public MessageLite setValue(MessageLite r5) {
        MessageLite r10 = this.value;
        this.value = r5;
        this.bytes = null;
        this.isDirty = true;
        return r10;
    }

    public ByteString toByteString() {
        if (this.isDirty == false) goto L5;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.isDirty == true) goto L15;
        ByteString r5 = this.bytes;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r5;
    L15:
        if (this.value != null) goto L17;
        this.bytes = ByteString.EMPTY;     // Catch: Throwable -> L12
    L18:
        this.isDirty = false;     // Catch: Throwable -> L12
        ByteString r10 = this.bytes;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r10;
    L17:
        this.bytes = this.value.toByteString();     // Catch: Throwable -> L12
        goto L18
    L5:
        return this.bytes;
    }

    public LazyFieldLite() {
        this.isDirty = false;
    }
}
