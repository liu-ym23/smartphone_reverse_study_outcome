package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.user.IMiddlewareUserService;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements InteractLiveCorePermissionGuarantor.a {
    public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

    @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
    public final void b(boolean r1) {
    }

    public n(MultiLinkVoiceChatRoomAnchorWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
    public final void a(boolean r7) {
        if (r7 == false) goto L23;
        this.a.G4(true, "on particular page show");
        VoiceChatMuteManager r8 = this.a.C;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L8:
        if (r8.o() != 0) goto L13;
        this.a.yq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        VoiceChatMuteManager r9 = this.a.C;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L12:
        r9.k("onPause");
    L13:
        this.a.getClass();
        sb6.a r10 = GuestLinkContext.Companion.a();
        if (r10 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        if (r11 == false) goto L37;
        MultiLinkVoiceChatRoomAnchorWidget r12 = this.a;
        r12.T1 = true;
        hg6.g r13 = r12.D;
        if (r13 == null) goto L38;
        r13.P(0);
        return;
    L38:
        return;
    L37:
        return;
    L16:
        if (r10.c != true) goto L18;
        r11 = true;
        goto L19
    L23:
        WeakReference r14 = com.bytedance.android.live.core.utils.a.a;
        if (com.bytedance.android.live.core.utils.a.e(this.a.getContext()) == false) goto L31;
        MultiLinkVoiceChatRoomAnchorWidget r15 = this.a;
        int r3 = MultiLinkVoiceChatRoomAnchorWidget.E2;
        if (r15.Sq() != 3) goto L31;
        VoiceChatMuteManager r16 = this.a.C;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L30:
        r16.l("on particular page close");
    L31:
        MultiLinkVoiceChatRoomAnchorWidget r17 = this.a;
        if (r17.T1 == false) goto L40;
        r17.T1 = false;
        hg6.g r18 = r17.D;
        if (r18 == null) goto L41;
        r18.P(100);
        return;
    L41:
        return;
    }
}
