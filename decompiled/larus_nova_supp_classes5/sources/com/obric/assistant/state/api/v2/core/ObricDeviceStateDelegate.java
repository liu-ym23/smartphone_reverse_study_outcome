package com.obric.assistant.state.api.v2.core;

import com.obric.assistant.interaction.impl.window.helpers.OverlayPermissionGuideActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/ObricDeviceStateDelegate;", "Lcom/obric/assistant/state/api/v2/core/IObricDeviceStateService;", "<init>", "()V", "register", "", "listener", "Lcom/obric/assistant/state/api/v2/core/IObricDeviceStateService$ScreenStateListener;", "unregister", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDeviceStateDelegate implements IObricDeviceStateService {
    public static final ObricDeviceStateDelegate b = null;
    public final /* synthetic */ IObricDeviceStateService a;

    static {
        b = new ObricDeviceStateDelegate();
    }

    public final void a(OverlayPermissionGuideActivity.screenStateListener.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.a(r2);
    }

    public final void b(IObricDeviceStateService.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.b(r2);
    }

    private ObricDeviceStateDelegate() {
        this.a = (IObricDeviceStateService) ServiceManager.get().getService(IObricDeviceStateService.class);
    }
}
