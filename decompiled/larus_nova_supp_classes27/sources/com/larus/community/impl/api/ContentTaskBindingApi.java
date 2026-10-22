package com.larus.community.impl.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/community/impl/api/ContentTaskBindingApi;", "", "saveContentTaskBinding", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/community/impl/api/SaveContentTaskBindingResponse;", "request", "Lcom/larus/community/impl/api/SaveContentTaskBindingRequest;", "(Lcom/larus/community/impl/api/SaveContentTaskBindingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ContentTaskBindingApi {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;

        static {
            a = new Companion();
        }

        public Companion() {
        }

        public static Object a(Function2 r3, Continuation r4) {
            return BuildersKt.withContext(Dispatchers.getIO(), new ContentTaskBindingApi$Companion$safeCall$2(r3, null), r4);
        }
    }

    static {
        a = Companion.a;
    }

    @POST("/creativity/community/content_task_binding/save")
    Object saveContentTaskBinding(@Body r r1, Continuation<? super BizResponse<s>> r2);
}
