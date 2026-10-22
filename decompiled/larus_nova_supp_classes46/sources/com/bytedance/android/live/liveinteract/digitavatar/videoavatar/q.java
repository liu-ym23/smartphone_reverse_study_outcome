package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.h0;
import com.bytedance.android.live.liveinteract.digitavatar.y;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ o a;

    public q(o r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        h0 r13 = (h0) r12;
        o r0 = this.a;
        r0.getClass();
        ALogger.i("KtvDigitAvatar", "onReceiveUpdateAvatarRequest: " + r13 + ", curGender=" + r0.h + ", selfOnline=" + r0.m + ", showMode=" + r0.l);
        if (r0.m == true) goto L5;
        return;
    L5:
        if (r0.l != VideoShowMode.DIGIT_AVATAR) goto L31;
        Sticker r1 = (Sticker) ((LinkedHashMap) y.a).get(r13.a);
        if (r1 == null) goto L32;
        List r3 = r0.o.c();
        ListIterator r4 = r3.listIterator(r3.size());
    L10:
        if (r4.hasPrevious() == false) goto L14;
        Object r5 = r4.previous();
        if (Intrinsics.areEqual(((Sticker) r5).getEffectId(), r1.getEffectId()) == false) goto L10;
    L16:
        if (r5 == null) goto L18;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L25;
        r0.o.b("livedigitavatar", "VideoShowModeProcessor_onReceiveUpdateAvatarRequest");
        r0.o.a("livedigitavatar", r1, "VideoShowModeProcessor_onReceiveUpdateAvatarRequest");
        r0.h = r13.a;
        String r2 = r0.b;
        if (r2 == null) goto L24;
        ALogger.i("KtvDigitAvatar", "向道具发送形象数据，avatarData=".concat(r2));
        DigitAvatarMsgController r7 = r0.n;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "mode");
        r7.a(203, 0, r2);
    L24:
        r0.b(r13.a);
        DigitAvatarMsgController r8 = r0.n;
        r8.getClass();
        ALogger.i("KtvDigitAvatar", "向effect发送可见性指令 visible=true");
        r8.a(208, 1, null);
    L25:
        DigitAvatarMsgController r9 = r0.n;
        String r14 = r13.b;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r14, "mode");
        r9.a(203, 0, r14);
        return;
    L18:
        r6 = false;
        goto L20
    L14:
        r5 = null;
        goto L16
    L32:
        return;
    }
}
