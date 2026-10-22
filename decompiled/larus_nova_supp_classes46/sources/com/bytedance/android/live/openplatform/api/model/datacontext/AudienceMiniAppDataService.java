package com.bytedance.android.live.openplatform.api.model.datacontext;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.b;
import com.bytedance.live.datacontext.n;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/datacontext/AudienceMiniAppDataService;", "Lcom/bytedance/android/live/openplatform/api/model/datacontext/a;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/b;", "getSelfInfo", "<init>", "()V", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AudienceMiniAppDataService implements a {
    public AudienceMiniAppDataService() {
    }

    @Override // com.bytedance.android.live.openplatform.api.model.datacontext.a
    public b getSelfInfo() {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L7;
        return (ShelfInfo) r1.getValue();
    L7:
        return null;
    }
}
