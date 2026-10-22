package com.bytedance.android.live.liveinteract.plantform.permission;

import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qh0.c;
import qh0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/permission/LinkPermissionCheckerFactoryService;", "Lcom/bytedance/android/live/liveinteract/plantform/permission/ILinkPermissionCheckerFactoryService;", "Lcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;", "operateType", "", "linkType", "Lqh0/c;", "createDyliteChecker", "<init>", "()V", "multilink-host-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LinkPermissionCheckerFactoryService implements ILinkPermissionCheckerFactoryService {
    public LinkPermissionCheckerFactoryService() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.permission.ILinkPermissionCheckerFactoryService
    public c createDyliteChecker(OperateType r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "operateType");
        return new e(r2, r3);
    }
}
