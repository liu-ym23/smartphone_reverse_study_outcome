package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongAvatarMicSeatView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements Runnable {
    public final /* synthetic */ q a;

    public p(q r1) {
        this.a = r1;
    }

    public final void a() {
        LinkMicQuickInteractView r0 = this.a.A;
        if (r0 == null) goto L19;
        ViewParent r2 = null;
        r0.l(4, null);
        this.a.Q().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewParent r1 = this.a.Q().getParent();
        if ((r1 instanceof ViewGroup) == false) goto L8;
        r2 = r1;
    L8:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L11;
        r3.removeView(this.a.Q());
    L11:
        r0.getExtraContainer().removeAllViews();
        r0.getExtraContainer().addView(this.a.Q());
        r0.getStaticBg().setVisibility(8);
        RequestSongAvatarMicSeatView r4 = this.a.Q();
        Context r5 = this.a.getContext();
        Intrinsics.checkNotNull(r5);
        r4.c(r5, r0);
        q r6 = this.a;
        MultiLinkGuestViewBinder.a r7 = r6.e;
        if (r7 == null) goto L20;
        ch0.e r8 = r7.k;
        if (r8 == null) goto L21;
        ILinkPlayerInfoBridge r9 = r8.a;
        if (r9 == null) goto L22;
        r6.Q().b(r9);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
