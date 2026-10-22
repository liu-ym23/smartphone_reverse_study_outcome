package com.larus.bmhome.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/auth/LaunchMetricDelegate;", "Lcom/larus/bmhome/auth/ILaunchMetricService;", "<init>", "()V", "report", "", "type", "", "stage", "success", "", "error", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LaunchMetricDelegate implements ILaunchMetricService {
    public static final LaunchMetricDelegate b = null;
    public final /* synthetic */ ILaunchMetricService a;

    static {
        b = new LaunchMetricDelegate();
    }

    @Override // com.larus.bmhome.auth.ILaunchMetricService
    public final void a(String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter("tourist_mode", "type");
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r5, "error");
        this.a.a(r3, r4, r5);
    }

    private LaunchMetricDelegate() {
        ILaunchMetricService r0 = (ILaunchMetricService) ServiceManager.get().getService(ILaunchMetricService.class);
        if (r0 != null) goto L5;
        r0 = new LaunchMetricServiceNoop();
    L5:
        this.a = r0;
    }
}
