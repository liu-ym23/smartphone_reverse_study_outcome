package com.bytedance.android.live.openplatform.impl.miniappanchor.context;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.eventlisteners.OnLiveShelfSaveEventListener;
import com.bytedance.android.live.openplatform.impl.miniappanchor.eventlisteners.b;
import com.bytedance.android.live.openplatform.impl.miniappanchor.eventlisteners.c;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.bridge.BridgeContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import so0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R.\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/context/AnchorMiniAppContext;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/MiniAppContext;", "", "onCreate", "onDestroy", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "instance", "onMiniAppInstanceCreate", "onMiniAppInstanceDestroy", "Lso0/a;", "<set-?>", "miniAppAnchorService", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "", "isAnchor", "Z", "()Z", "Landroid/view/ViewGroup;", "containerView", "Landroid/view/ViewGroup;", "getContainerView", "()Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Landroid/view/ViewGroup;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AnchorMiniAppContext extends MiniAppContext {
    private final ViewGroup containerView;
    private final boolean isAnchor;
    private a miniAppAnchorService;

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService((a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get());
        a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L6;
        r0.b(this);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        super.onDestroy();
        a r0 = this.miniAppAnchorService;
        if (r0 == null) goto L5;
        OpenPlatformContext r1 = r0.a();
    L7:
        if (Intrinsics.areEqual(r1, this) == false) goto L12;
        a r2 = this.miniAppAnchorService;
        if (r2 == null) goto L13;
        r2.b(null);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext
    public void onMiniAppInstanceDestroy() {
        super.onMiniAppInstanceDestroy();
        ((AnchorShelfContextService) getService(AnchorShelfContextService.class)).clearShelfInfoTemp();
    }

    public final ViewGroup getContainerView() {
        return this.containerView;
    }

    public final a getMiniAppAnchorService() {
        return this.miniAppAnchorService;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isAnchor() {
        return this.isAnchor;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext
    public void onMiniAppInstanceCreate(MiniAppInstance r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        super.onMiniAppInstanceCreate(r3);
        ((AnchorShelfContextService) getService(AnchorShelfContextService.class)).copyShelfInfoTemp(r3.getAppId());
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mount_page", new b(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_unmount_page", new c(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_get_page_config", new com.bytedance.android.live.openplatform.impl.miniappanchor.eventlisteners.a(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_shelf_save", new OnLiveShelfSaveEventListener(this));
    }

    @Inject
    public final void setMiniAppAnchorService(a r1) {
        this.miniAppAnchorService = r1;
    }

    public AnchorMiniAppContext(Context r2, DataCenter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.containerView = r4;
        this.isAnchor = true;
    }
}
