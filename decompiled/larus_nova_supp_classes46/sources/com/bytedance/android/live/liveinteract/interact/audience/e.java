package com.bytedance.android.live.liveinteract.interact.audience;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements qh0.d<rh0.a> {
    public final /* synthetic */ InteractAudienceGuestWidget a;
    public final /* synthetic */ lg6.a b;
    public final /* synthetic */ boolean c;

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        lg6.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFailed(r2);
    L6:
        if (r2.getCheckType() != BaseCheckException.CheckType.ServerPermission) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.c;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, 2);
        return;
    }

    @Override // qh0.d
    public final void onResult(rh0.a r5) {
        if (this.c == true) goto L5;
        com.bytedance.android.live.liveinteract.linksecurity.a r6 = com.bytedance.android.live.liveinteract.linksecurity.a.g;
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r1 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r2 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        Intrinsics.checkNotNullParameter(r2, "config");
        r6.e("close_camera_by_self", r0, r1, r2);
    L5:
        lg6.a r7 = this.b;
        if (r7 == null) goto L8;
        r7.a(Unit.INSTANCE);
    L8:
        m00.d r8 = this.a.E;
        if (r8 == null) goto L12;
        r8.switchCamera();
        return;
    }

    public e(InteractAudienceGuestWidget r1, lh6.c r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
