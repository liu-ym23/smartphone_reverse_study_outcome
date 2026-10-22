package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends View.AccessibilityDelegate {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e a;

    public b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r1) {
        this.a = r1;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r6, "info");
        super.onInitializeAccessibilityNodeInfo(r5, r6);
        r6.setClassName(Button.class.getName());
        int r7 = AudienceVideoResolutionManager.a;
        Iterator r8 = AudienceVideoResolutionManager.b.iterator();
    L3:
        Object r1 = null;
        if (r8.hasNext() == false) goto L11;
        Object r0 = r8.next();
        String r2 = ((LiveCoreSDKData.Quality) r0).sdkKey;
        ILivePlayerClient r3 = LivePlatformPlayerManager.f();
        if (r3 == null) goto L9;
        r1 = r3.getCurrentResolution();
    L9:
        if (Intrinsics.areEqual(r2, r1) == false) goto L3;
        r1 = r0;
    L11:
        LiveCoreSDKData.Quality r4 = (LiveCoreSDKData.Quality) r1;
        if (r4 == null) goto L15;
        String r9 = r4.getName();
        if (r9 == null) goto L15;
    L16:
        r6.setContentDescription(this.a.f + r9);
        return;
    L15:
        r9 = "";
        goto L16
    }
}
