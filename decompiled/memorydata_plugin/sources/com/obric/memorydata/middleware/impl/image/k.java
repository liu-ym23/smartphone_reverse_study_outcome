package com.obric.memorydata.middleware.impl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXUploadCallback;", "", "onSuccess", "", "fileIndex", "", "imageUrl", "", "onFailure", "errorCode", "", "errorMessage", "onComplete", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface k {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static void a(k r2) {
            k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
        }
    }

    void a();

    void a(int r1, long r2, String r4);

    void a(int r1, String r2);
}
