package mmb;

import com.bytedance.ee.bear.lark.dependency.j;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.pb.ai.GetEnterpriseTopicRequest;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements j {
    public final void a() {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).dismissEnterpriseTopicCard();
    }

    public a() {
    }

    public final void b(wb5.a r12, IGetDataCallback<String> r13) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).showEnterpriseTopic(r12.a, r12.b, r12.c, r12.d, r12.e, r12.f, GetEnterpriseTopicRequest.Scene.DOCS, r12.g, r13);
    }
}
