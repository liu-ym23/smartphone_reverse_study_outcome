package com.obric.assistant.common.spi.network;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/common/spi/network/DefaultObricSecurityNetworkServiceImpl;", "Lcom/obric/assistant/common/spi/network/IObricSecurityNetworkService;", "<init>", "()V", "setTLSAuth", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "addObricHostsToOriginHost", "boeEnable", NameKeys.UnloadStrategy_No_Strategy, "ppeEnable", "hosts", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "allowedToDisplayPrivateUrl", "openUrl", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricSecurityNetworkServiceImpl implements IObricSecurityNetworkService {
    public DefaultObricSecurityNetworkServiceImpl() {
    }

    public final boolean a(String r1) {
        return false;
    }

    public final void b(boolean r1, boolean r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "hosts");
    }

    public final void c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }
}
