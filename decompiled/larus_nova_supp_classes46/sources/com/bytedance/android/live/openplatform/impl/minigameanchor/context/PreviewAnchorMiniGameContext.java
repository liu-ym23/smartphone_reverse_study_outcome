package com.bytedance.android.live.openplatform.impl.minigameanchor.context;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.live.datacontext.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/context/PreviewAnchorMiniGameContext;", "Lcom/bytedance/android/live/openplatform/impl/minigameanchor/context/AnchorMiniGameContext;", "context", "Landroid/content/Context;", "containerView", "Landroid/view/ViewGroup;", "previewSourceParam", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;)V", "isInLive", "", "()Z", "getPreviewSourceParam", "()Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "onCreate", "", "onDestroy", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewAnchorMiniGameContext extends AnchorMiniGameContext {
    private final boolean isInLive;
    private final PreviewSourceParam previewSourceParam;

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.context.AnchorMiniGameContext, com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.context.AnchorMiniGameContext, com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L12;
        n<OpenPlatformMgInfoModel> r1 = r0.getOpenPlatformMg();
        if (r1 == null) goto L13;
        PreviewSourceParam r2 = this.previewSourceParam;
        if (r2 == null) goto L9;
        OpenPlatformMgInfoModel r3 = r2.getOpenPlatformMg();
    L10:
        r1.setValue(r3);
        return;
    L9:
        r3 = null;
        goto L10
    L13:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.context.AnchorMiniGameContext, com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        super.onDestroy();
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L8;
        n<OpenPlatformMgInfoModel> r1 = r0.getOpenPlatformMg();
        if (r1 == null) goto L9;
        r1.setValue(null);
        return;
    L9:
        return;
    }

    public final PreviewSourceParam getPreviewSourceParam() {
        return this.previewSourceParam;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isInLive() {
        return this.isInLive;
    }

    public PreviewAnchorMiniGameContext(Context r2, ViewGroup r3, PreviewSourceParam r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, null, r3);
        this.previewSourceParam = r4;
    }
}
