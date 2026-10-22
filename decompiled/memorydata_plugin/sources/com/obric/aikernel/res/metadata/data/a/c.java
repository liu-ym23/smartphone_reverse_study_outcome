package com.obric.aikernel.res.metadata.data.a;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/dynamic/IDynamicResourceProxy;", "", "checkIsAvail", "", "type", "", ActivityLifecycle.NAME, "version", "requestParams", "Lcom/obric/aikernel/sdk/config/RequestParams;", Params.LORA_TYPE, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface c {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static /* synthetic */ boolean a(c r6, String r7, String r8, String r9, RequestParams r10, String r11, int r12, Object r13) {
            c r0 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
            if (r13 != null) goto L14;
            if ((r12 & 8) == 0) goto L7;
            r10 = new RequestParams(null, null, 3, null);
        L7:
            RequestParams r4 = r10;
            if ((r12 & 16) == 0) goto L10;
            String r5 = null;
        L12:
            return r0.a(r7, r8, r9, r4, r5);
        L10:
            r5 = r11;
            goto L12
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkIsAvail");
        }
    }

    boolean a(String r1, String r2, String r3, RequestParams r4, String r5);
}
