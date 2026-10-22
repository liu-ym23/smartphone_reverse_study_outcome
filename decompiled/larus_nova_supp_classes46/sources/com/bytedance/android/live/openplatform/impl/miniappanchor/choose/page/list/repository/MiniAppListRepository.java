package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.repository;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import jp0.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import np0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/repository/MiniAppListRepository;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppListRepository extends OpenPlatformContextService {
    public final a a;
    public final b<Result<ip0.b>> b;

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        qo0.a.c("choose_list", "destroy MiniAppListRepository");
    }

    public MiniAppListRepository(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new a();
        this.b = new b();
        qo0.a.c("choose_list", "init MiniAppListRepository");
    }
}
