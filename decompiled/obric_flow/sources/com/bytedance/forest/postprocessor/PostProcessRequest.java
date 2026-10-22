package com.bytedance.forest.postprocessor;

import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007B9\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\r\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u000eB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\tH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/forest/postprocessor/PostProcessRequest;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/bytedance/forest/model/Request;", "request", "postProcessor", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/postprocessor/ForestPostProcessor;)V", "originUrl", "", "forest", "Lcom/bytedance/forest/Forest;", "customParams", "", "(Ljava/lang/String;Lcom/bytedance/forest/Forest;Ljava/util/Map;Lcom/bytedance/forest/postprocessor/ForestPostProcessor;)V", "(Lcom/bytedance/forest/postprocessor/PostProcessRequest;)V", "getPostProcessor$forest_release", "()Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
public final class PostProcessRequest<T> extends Request {
    private final ForestPostProcessor<T> postProcessor;

    public PostProcessRequest(Request r5, ForestPostProcessor<T> r10) {
        super(r5);
        this.postProcessor = r10;
    }

    public final ForestPostProcessor<T> getPostProcessor$forest_release() {
        return this.postProcessor;
    }

    @Override // com.bytedance.forest.model.Request
    public String toString() {
        return "{request: " + super.toString() + ", processor: " + this.postProcessor + '}';
    }

    public PostProcessRequest(String r41, Forest r42, Map<String, Object> r43, ForestPostProcessor<T> r44) {
        m r5 = null;
        boolean r10 = false;
        boolean r11 = false;
        boolean r12 = false;
        boolean r13 = false;
        boolean r14 = false;
        boolean r15 = false;
        boolean r16 = false;
        boolean r17 = false;
        boolean r18 = false;
        boolean r19 = false;
        int r110 = 0;
        Scene r111 = null;
        boolean r112 = false;
        String r113 = null;
        boolean r114 = false;
        boolean r20 = false;
        boolean r21 = false;
        List r22 = null;
        boolean r23 = false;
        boolean r24 = false;
        boolean r25 = false;
        String r26 = null;
        Object r27 = null;
        boolean r28 = false;
        boolean r29 = false;
        int r30 = 0;
        boolean r31 = false;
        Map r32 = null;
        Set r33 = null;
        boolean r34 = false;
        boolean r35 = false;
        List r36 = null;
        int r37 = -8;
        super(r41, r42, r43, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, 15, null);
        this.postProcessor = r44;
    }

    public PostProcessRequest(PostProcessRequest<T> r5) {
        super(r5);
        this.postProcessor = r5.postProcessor;
    }
}
