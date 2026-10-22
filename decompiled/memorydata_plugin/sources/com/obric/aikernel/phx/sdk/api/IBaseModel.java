package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.response.Response;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J#\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ)\u0010\n\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "Ljava/lang/AutoCloseable;", IslandSession.REOPEN_VALUE_CLOSE, "", "infer", "Lcom/obric/aikernel/sdk/response/Response;", "", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferAsFlow", "Lkotlinx/coroutines/flow/Flow;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBaseModel extends AutoCloseable {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void close(IBaseModel r2) {
            IBaseModel r3 = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r2, IBaseModel.class, "com.obric.memorydata.plugin");
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    Object infer(RequestParams r1, Continuation<? super Response<Object>> r2);

    Object inferAsFlow(RequestParams r1, Continuation<? super i<Response<Object>>> r2);
}
