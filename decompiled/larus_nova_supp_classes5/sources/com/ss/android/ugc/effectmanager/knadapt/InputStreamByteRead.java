package com.ss.android.ugc.effectmanager.knadapt;

import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import java.io.InputStream;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/InputStreamByteRead;", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "available", "", "close", "", "read", "", "b", "", "offset", "len", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class InputStreamByteRead implements ByteReadStream {
    private final InputStream inputStream;

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public boolean available() {
        if (this.inputStream.available() < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public void close() {
        this.inputStream.close();
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public int read() {
        return this.inputStream.read();
    }

    public InputStreamByteRead(InputStream r1) {
        this.inputStream = r1;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public int read(byte[] r2, int r3, int r4) {
        return this.inputStream.read(r2, r3, r4);
    }
}
