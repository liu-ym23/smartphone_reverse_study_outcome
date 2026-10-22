package com.bytedance.android.livesdk.interactivity.medialink.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import com.bytedance.bdlocation.BuildConfig;
import e92.m;
import ey.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ MediaMultiLinkAnchorWidget a;
    public final /* synthetic */ AnchorLinkUser b;
    public final /* synthetic */ String c;
    public final /* synthetic */ LinkerKickOutContent.KickOutSource d;

    public e(MediaMultiLinkAnchorWidget r1, AnchorLinkUser r2, LinkerKickOutContent.KickOutSource r3) {
        this.a = r1;
        this.b = r2;
        this.c = "MultiMicPanel";
        this.d = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r11, int r13) {
        MediaMultiLinkAnchorWidget r14 = this.a;
        AnchorLinkUser r0 = this.b;
        String r6 = this.c;
        LinkerKickOutContent.KickOutSource r7 = this.d;
        r14.getClass();
        if (m.h() > 2) goto L5;
        ALogger.e("MediaLinkTracer", "drop kick out operation for window count no more than 2");
        boolean r15 = false;
    L6:
        if (r15 == false) goto L24;
        if (r0 != null) goto L10;
        ALogger.e("MediaLinkTracer", "drop kick out operation for info null");
        goto L24
    L10:
        x82.a.t2.getClass();
        x82.a r16 = x82.a.C0295a.a();
        if (r16 == null) goto L24;
        k r17 = r16.getLinkOutManager();
        if (r17 == null) goto L24;
        long r2 = MediaMultiAnchorLinkContext.Companion.a();
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L17;
        String r3 = r1.getIdString();
    L18:
        String r4 = r3;
        IBaseUser r5 = r0.getUser();
        if (r5 == null) goto L22;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        String r8 = r5.getCastSecUid();
        if (r8 == null) goto L22;
    L23:
        r17.a(new fy.g(r2, r4, r8, r6, r7, 64));
    L22:
        r8 = BuildConfig.FLAVOR;
        goto L23
    L17:
        r3 = null;
    L24:
        r11.dismiss();
        return;
    L5:
        r15 = true;
        goto L6
    }
}
