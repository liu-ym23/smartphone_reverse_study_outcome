package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class LazyFieldLite {
    private ByteString bytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;
    protected volatile MessageLite value;

    protected void ensureInitialized(MessageLite r10) {
        if (this.value == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.value == null) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        if (this.bytes == null) goto L13;
        r10 = r10.getParserForType().parseFrom(this.bytes, this.extensionRegistry);     // Catch: IOException -> L19 Throwable -> L16
    L13:
        this.value = r10;     // Catch: IOException -> L19 Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    }

    public int getSerializedSize() {
        if (this.isDirty == false) goto L7;
        return this.value.getSerializedSize();
    L7:
        return this.bytes.size();
    }

    public MessageLite getValue(MessageLite r10) {
        ensureInitialized(r10);
        return this.value;
    }

    public MessageLite setValue(MessageLite r10) {
        MessageLite r11 = this.value;
        this.value = r10;
        this.bytes = null;
        this.isDirty = true;
        return r11;
    }
}
