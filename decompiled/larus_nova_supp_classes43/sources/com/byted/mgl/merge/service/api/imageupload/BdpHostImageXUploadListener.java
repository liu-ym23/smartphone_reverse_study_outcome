package com.byted.mgl.merge.service.api.imageupload;

import com.byted.cast.sink.api.IAPI;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/byted/mgl/merge/service/api/imageupload/BdpHostImageXUploadListener;", "", "onResult", "", "isSuccess", "", "imageTosKey", "", "extraMsg", "params", "", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface BdpHostImageXUploadListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onResult$default(BdpHostImageXUploadListener r0, boolean r1, String r10, String r11, Map r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 8) == 0) goto L6;
            r12 = null;
        L6:
            r0.onResult(r1, r10, r11, r12);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
        }
    }

    void onResult(boolean r1, String r10, String r11, Map<String, ? extends Object> r12);
}
