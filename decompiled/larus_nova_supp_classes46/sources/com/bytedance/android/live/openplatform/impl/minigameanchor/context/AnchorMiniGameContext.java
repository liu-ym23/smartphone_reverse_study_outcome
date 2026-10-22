package com.bytedance.android.live.openplatform.impl.minigameanchor.context;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vo0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014R.\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/context/AnchorMiniGameContext;", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/MiniGameContext;", "", "onCreate", "onDestroy", "Lvo0/a;", "<set-?>", "miniGameAnchorService", "Lvo0/a;", "getMiniGameAnchorService", "()Lvo0/a;", "setMiniGameAnchorService", "(Lvo0/a;)V", "", "isAnchor", "Z", "()Z", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/view/ViewGroup;", "containerView", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Landroid/view/ViewGroup;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AnchorMiniGameContext extends MiniGameContext {
    private final boolean isAnchor;
    private a miniGameAnchorService;

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        OpenPlatformMgAnchorServiceImpl.Companion.getClass();
        po0.a.b r0 = (po0.a.b) OpenPlatformMgAnchorServiceImpl.access$getDiComponent$cp();
        r0.getClass();
        setMiniGameAnchorService((a) r0.a.e.get());
        a r1 = this.miniGameAnchorService;
        if (r1 == null) goto L6;
        r1.b(this);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        super.onDestroy();
        a r0 = this.miniGameAnchorService;
        if (r0 == null) goto L5;
        OpenPlatformContext r1 = r0.a();
    L7:
        if (Intrinsics.areEqual(r1, this) == false) goto L12;
        a r2 = this.miniGameAnchorService;
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

    public final a getMiniGameAnchorService() {
        return this.miniGameAnchorService;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isAnchor() {
        return this.isAnchor;
    }

    @Inject
    public final void setMiniGameAnchorService(a r1) {
        this.miniGameAnchorService = r1;
    }

    public AnchorMiniGameContext(Context r2, DataCenter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.isAnchor = true;
    }
}
