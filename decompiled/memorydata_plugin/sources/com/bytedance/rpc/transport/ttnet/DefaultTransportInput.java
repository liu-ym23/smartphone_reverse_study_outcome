package com.bytedance.rpc.transport.ttnet;

import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.rpc.transport.StreamClosedCallback;
import com.bytedance.rpc.transport.TransportInput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultTransportInput implements TransportInput {
    private StreamClosedCallback streamClosedCallback;
    private TypedInput typedInput;

    public DefaultTransportInput(TypedInput r3, StreamClosedCallback r4) {
        TypedInput r5 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r3, TypedInput.class, "com.obric.memorydata.plugin");
        StreamClosedCallback r6 = (StreamClosedCallback) ZeusTransformUtils.wrapperContextForParams(r4, StreamClosedCallback.class, "com.obric.memorydata.plugin");
        this.typedInput = r5;
        this.streamClosedCallback = r6;
    }

    static /* synthetic */ StreamClosedCallback access$000(DefaultTransportInput r0) {
        return r0.streamClosedCallback;
    }

    @Override // com.bytedance.rpc.transport.TransportInput
    public long contentLength() {
        return this.typedInput.length();
    }

    @Override // com.bytedance.rpc.transport.TransportInput
    public String contentType() {
        return this.typedInput.mimeType();
    }

    @Override // com.bytedance.rpc.transport.TransportInput
    public InputStream in() {
        final InputStream r0 = this.typedInput.in();
        return new AnonymousClass1(this, r0);
    }
}
