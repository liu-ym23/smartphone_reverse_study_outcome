package com.larus.common.venue.impl.venue.component;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IXBridgeEventSender;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/larus/common/venue/impl/venue/component/FlowCommonVenueLynxEventComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "firstResume", "", "appBackGroundListener", "com/larus/common/venue/impl/venue/component/FlowCommonVenueLynxEventComponent$appBackGroundListener$1", "Lcom/larus/common/venue/impl/venue/component/FlowCommonVenueLynxEventComponent$appBackGroundListener$1;", "onResume", "", "onCreate", "onDestroy", "onStop", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCommonVenueLynxEventComponent extends BaseContentWidget {
    public boolean m;
    public final a n;

    public static final class a implements f09.a.b {
        public a() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            IXBridgeEventSender r0 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
            if (r0 == null) goto L6;
            r0.sendEvent("appResignActive", MapsKt.emptyMap());
            return;
        }

        public final void onAppForeground() {
            IXBridgeEventSender r0 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
            if (r0 == null) goto L6;
            r0.sendEvent("appBecomeActive", MapsKt.emptyMap());
            return;
        }
    }

    public final void onDestroy() {
        AppHost.a.a().c(this.n);
    }

    public FlowCommonVenueLynxEventComponent() {
        this.m = true;
        this.n = new a();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        AppHost.a.a().j(this.n);
    }

    public final void onResume() {
        IXBridgeEventSender r0 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
        if (r0 == null) goto L6;
        r0.sendEvent("viewAppeared", MapsKt.mapOf(TuplesKt.to("isViewFirstAppeared", Boolean.valueOf(this.m))));
    L6:
        if (this.m == false) goto L9;
        this.m = false;
        return;
    }

    public final void onStop() {
        IXBridgeEventSender r0 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
        if (r0 == null) goto L6;
        r0.sendEvent("viewDisappeared", MapsKt.emptyMap());
        return;
    }
}
