package qh0;

import com.bytedance.android.live.liveinteract.plantform.permission.ILinkPermissionCheckerFactoryService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final c a(OperateType r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "operateType");
        return ((ILinkPermissionCheckerFactoryService) jc1.k.n(ILinkPermissionCheckerFactoryService.class)).createDyliteChecker(r1, r2);
    }
}
