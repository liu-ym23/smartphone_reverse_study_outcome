package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class LazyFieldLite {
    private ByteString bytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;
    protected volatile MessageLite value;

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

    public MessageLite setValue(MessageLite r5) {
        MessageLite r10 = this.value;
        this.value = r5;
        this.bytes = null;
        this.isDirty = true;
        return r10;
    }
}
