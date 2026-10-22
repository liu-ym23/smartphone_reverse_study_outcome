package com.bytedance.android.live.openplatform.impl.base;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.openplatform.IOpenPlatformOuterService;
import com.bytedance.android.livesdkapi.openplatform.LiveOpenApiCallback;
import com.bytedance.live.datacontext.i;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/OpenPlatformOuterServiceImpl;", "Lcom/bytedance/android/livesdkapi/openplatform/IOpenPlatformOuterService;", "()V", "invokeLiveOpenApi", "", "appId", "", "params", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "openExplainCardSettingDialog", "openMiniGameAnchorPanel", "context", "Landroid/content/Context;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenPlatformOuterServiceImpl implements IOpenPlatformOuterService {
    public OpenPlatformOuterServiceImpl() {
        k.l(IOpenPlatformOuterService.class, this);
    }

    public void openMiniGameAnchorPanel(Context r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        ((IOpenPlatformMgAnchorService) k.n(IOpenPlatformMgAnchorService.class)).openBottomFeaturePanel(r2, r3);
    }

    public void invokeLiveOpenApi(String r6, JSONObject r7, LiveOpenApiCallback r8) {
        Intrinsics.checkNotNullParameter(r6, "appId");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L9;
        ((IOpenPlatformAudienceService) k.n(IOpenPlatformAudienceService.class)).invokeLiveOpenApi(r6, r7, r8);
        return;
    L9:
        ((IOpenPlatformAnchorService) k.n(IOpenPlatformAnchorService.class)).invokeLiveOpenApi(r6, r7, r8);
    }

    public void openExplainCardSettingDialog(String r2, JSONObject r3, LiveOpenApiCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((IOpenPlatformAnchorService) k.n(IOpenPlatformAnchorService.class)).openExplainCardSettingDialog(r3);
        r4.onSuccess(null);
    }
}
