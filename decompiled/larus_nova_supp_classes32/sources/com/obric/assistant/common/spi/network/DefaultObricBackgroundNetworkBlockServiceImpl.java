package com.obric.assistant.common.spi.network;

import com.obric.aivoice.core.data.NameKeys;
import hm9.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/common/spi/network/DefaultObricBackgroundNetworkBlockServiceImpl;", "Lcom/obric/assistant/common/spi/network/IObricBackgroundNetworkBlockService;", "<init>", "()V", "shouldBlockNonDoraUserForObric", NameKeys.UnloadStrategy_No_Strategy, "()Ljava/lang/Boolean;", "isMainProcessBackground", "triggerBackgroundNetworkRestrictIfNeeded", NameKeys.UnloadStrategy_No_Strategy, "initNetworkRestrict", "getAssistantState", "registerMainProcessBackgroundListener", "listener", "Lcom/obric/assistant/common/spi/network/MainProcessBackgroundListener;", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricBackgroundNetworkBlockServiceImpl implements IObricBackgroundNetworkBlockService {
    public DefaultObricBackgroundNetworkBlockServiceImpl() {
    }

    public final Boolean a() {
        return null;
    }

    public final void b(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void c() {
    }

    public final boolean d() {
        return false;
    }

    public final Boolean e() {
        return null;
    }

    public final void f() {
    }
}
