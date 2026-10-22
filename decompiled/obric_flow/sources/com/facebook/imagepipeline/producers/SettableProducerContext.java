package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes2.dex */
public class SettableProducerContext extends BaseProducerContext {
    public SettableProducerContext(ImageRequest r12, String r13, InternalRequestListener r14, ForwardingRequestListener r15, Object r16, ImageRequest.RequestLevel r17, Priority r18, ImagePipelineConfig r19) {
        super(r12, r13, r14, r15, r16, r17, true, false, r18, r19);
    }

    public SettableProducerContext(ImageRequest r12, String r13, InternalRequestListener r14, ForwardingRequestListener r15, Object r16, ImageRequest.RequestLevel r17, boolean r18, Priority r19, ImagePipelineConfig r20) {
        super(r12, r13, r14, r15, r16, r17, false, r18, r19, r20);
    }
}
