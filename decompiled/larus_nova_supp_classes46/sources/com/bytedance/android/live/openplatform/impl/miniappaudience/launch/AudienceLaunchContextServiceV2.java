package com.bytedance.android.live.openplatform.impl.miniappaudience.launch;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.CommonLaunchContextService;
import com.bytedance.live.datacontext.n;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/launch/AudienceLaunchContextServiceV2;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/launch/CommonLaunchContextService;", "Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$a;", "schemaInfoBuilder", "", "appendCommonParams", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLaunchContextServiceV2 extends CommonLaunchContextService {
    public AudienceLaunchContextServiceV2(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.launch.CommonLaunchContextService
    public void appendCommonParams(SchemaInfo.a r4) {
        Intrinsics.checkNotNullParameter(r4, "schemaInfoBuilder");
        if (((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn() == false) goto L5;
        String r0 = "guest";
    L6:
        r4.b("projection_user_type", r0);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        if (r1 == null) goto L18;
        n<lo0.a> r2 = r1.getPrivateMsgEntranceInfo();
        if (r2 == null) goto L20;
        lo0.a r3 = (lo0.a) r2.getValue();
        if (r3 == null) goto L21;
        Map<String, String> r5 = r3.b();
        if (r5 == null) goto L22;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L23;
        Map.Entry<String, String> r7 = r6.next();
        r4.b(r7.getKey(), r7.getValue());
        goto L16
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r0 = "audience";
        goto L6
    }
}
