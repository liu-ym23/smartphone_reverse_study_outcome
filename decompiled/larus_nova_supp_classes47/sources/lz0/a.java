package lz0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "core.service.LazyLoadService")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "Load")
    Single<c> load(b r1);
}
