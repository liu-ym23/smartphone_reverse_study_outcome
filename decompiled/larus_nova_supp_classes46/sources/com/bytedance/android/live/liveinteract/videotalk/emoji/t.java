package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t {
    public Context a;
    public DataCenter b;
    public Boolean c;
    public String d;
    public boolean e;
    public boolean f;

    public t() {
    }

    public final q0 a() {
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r0, 32) == false) goto L7;
        return b();
    L7:
        if (gd0.v.a(r0, 8) == false) goto L11;
        return c();
    L11:
        return c();
    }

    public final void d() {
        if (this.a == null) goto L18;
        if (this.b == null) goto L16;
        if (this.c == null) goto L14;
        if (this.d == null) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("call setRequestPage() before call build()");
    L14:
        throw new IllegalArgumentException("call setShowExtraButton() before call build()");
    L16:
        throw new IllegalArgumentException("call setDataCenter() before call build()");
    L18:
        throw new IllegalArgumentException("call setContext() before call build()");
    }

    public final q0 b() {
        d();
        Context r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        DataCenter r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L8:
        Boolean r4 = this.c;
        if (r4 == null) goto L11;
        boolean r5 = r4.booleanValue();
    L12:
        boolean r6 = this.f;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        String r1 = this.d;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L15:
        Intrinsics.checkNotNullParameter(r1, "requestPage");
        if (hg6.i.a() == false) goto L24;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r3 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r7 == null) goto L22;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r8 = r7.getLinkUserInfoCenter();
        if (r8 == null) goto L22;
        ILinkPlayerInfoBridge r9 = (ILinkPlayerInfoBridge) r8.getGuestInfo(je0.d.b0(), tc0.c.h().f);
    L23:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r9, r1, r5);
        return r3;
    L22:
        r9 = null;
        goto L23
    L24:
        ALogger.d("DynamicEmojiDialog Refactor VideoTalk", "new instance video talk dynamic from " + r1);
        VideoTalkDynamicEmojiDialog r10 = new VideoTalkDynamicEmojiDialog(r0, r2, r5, r6);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r10.u = r1;
        tb6.c r11 = r10.A;
        if (r11 == null) goto L28;
        r11.a();
        Intrinsics.checkNotNullParameter(r1, "requestPage");
        r11.d = r1;
    L28:
        return r10;
    L11:
        r5 = false;
        goto L12
    }

    public final q0 c() {
        d();
        Context r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        DataCenter r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L8:
        Boolean r4 = this.c;
        if (r4 == null) goto L11;
        boolean r5 = r4.booleanValue();
    L12:
        boolean r6 = this.e;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        String r1 = this.d;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L15:
        Intrinsics.checkNotNullParameter(r1, "requestPage");
        if (hg6.i.a() == false) goto L24;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r3 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r7 == null) goto L22;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r8 = r7.getLinkUserInfoCenter();
        if (r8 == null) goto L22;
        ILinkPlayerInfoBridge r9 = (ILinkPlayerInfoBridge) r8.getGuestInfo(je0.d.b0(), tc0.c.h().f);
    L23:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r9, r1, r5);
        return r3;
    L22:
        r9 = null;
        goto L23
    L24:
        ALogger.d("VoiceChatDynamicEmojiDialog", "new instance voice chat dynamic from " + r1);
        VoiceChatDynamicEmojiDialog r10 = new VoiceChatDynamicEmojiDialog(r0, r2, r5, r6);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r10.u = r1;
        tb6.c r11 = r10.A;
        if (r11 == null) goto L28;
        r11.a();
        Intrinsics.checkNotNullParameter(r1, "requestPage");
        r11.d = r1;
    L28:
        return r10;
    L11:
        r5 = false;
        goto L12
    }

    public final void e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void f(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }

    public final void g(boolean r1) {
        this.c = Boolean.valueOf(r1);
    }
}
