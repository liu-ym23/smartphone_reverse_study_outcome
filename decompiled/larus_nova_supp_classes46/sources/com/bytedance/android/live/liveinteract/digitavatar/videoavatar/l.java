package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.livesdk.config.sn;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ VideoDigitAvatarWidget a;

    public l(VideoDigitAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        VideoDigitAvatarWidget r7 = this.a;
        int r0 = VideoDigitAvatarWidget.l;
        r7.getClass();
        DigitAvatarContext.a r1 = DigitAvatarContext.Companion;
        DigitAvatarContext r2 = r1.getContext();
        VideoShowMode r3 = null;
        if (r2 == null) goto L5;
        VideoShowMode r4 = r2.getCurrentVideoShowMode();
    L7:
        if (r4 != VideoShowMode.DIGIT_AVATAR) goto L30;
        jg6.a r8 = r7.getScopeServiceInMultiLinkRoom(cg6.a.class).e5();
        if (r8 == null) goto L14;
        lh6.b r9 = r8.a();
        if (r9 == null) goto L14;
        if (r9.e() != true) goto L14;
    L27:
        VideoDigitAvatarWidget.b r10 = r7.i;
        if (r10 == null) goto L30;
        r10.gn();
    L14:
        DigitAvatarContext r11 = r1.getContext();
        if (r11 == null) goto L17;
        VideoShowMode r12 = r11.getLastVideoShowMode();
    L19:
        if (r12 == VideoShowMode.VIDEO) goto L27;
        if (Intrinsics.areEqual(sn.a.getValue(), Boolean.TRUE) == false) goto L30;
        DigitAvatarContext r13 = r1.getContext();
        if (r13 == null) goto L26;
        r3 = r13.getLastVideoShowMode();
    L26:
        if (r3 != VideoShowMode.AUDIO) goto L30;
    L17:
        r12 = null;
    L30:
        VideoDigitAvatarWidget r14 = this.a;
        Disposable r15 = r14.d;
        if (r15 == null) goto L34;
        r14.a.remove(r15);
        return;
    L34:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
