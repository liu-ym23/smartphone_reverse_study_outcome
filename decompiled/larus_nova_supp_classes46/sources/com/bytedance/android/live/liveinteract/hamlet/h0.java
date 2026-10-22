package com.bytedance.android.live.liveinteract.hamlet;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.xplay.basic.api.XplayBasicMessageType;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 implements g10.d {
    public final /* synthetic */ HamletAvatarWidget a;

    public h0(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.live.broadcastgame.api.xplay.f r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        Intrinsics.checkNotNullParameter(r3, "instance");
        ALogger.i("HamletAvatar", "onInstanceCreate");
        HamletAvatarWidget r0 = this.a;
        r0.b = r3;
        r0.cr();
    }

    public final void d(com.bytedance.android.live.broadcastgame.api.xplay.f r8) {
        Intrinsics.checkNotNullParameter(r8, "instance");
        ALogger.i("HamletAvatar", "onInstanceDestroy");
        HamletAvatarWidget r9 = this.a;
        int r0 = HamletAvatarWidget.T;
        r9.getClass();
        if (gh0.a.d() == false) goto L5;
        UtilityKotlinExtentionsKt.s(0, false, false, HamletAvatarWidget$resetAnchorSeiData$1.INSTANCE, 7);
    L5:
        Disposable r1 = r9.e;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        ViewGroup r2 = r9.Q;
        if (r2 == null) goto L11;
        r2.removeAllViews();
    L11:
        gd1.b r3 = r9.d;
        if (r3 == null) goto L14;
        r3.c(XplayBasicMessageType.Orser_Song_Message);
    L14:
        r9.c = null;
        r9.Wq(false);
        r9.Aq("onXplayDestory", true);
        this.a.b = null;
    }
}
