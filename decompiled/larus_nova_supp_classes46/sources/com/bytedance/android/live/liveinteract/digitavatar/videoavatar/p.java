package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        c r6 = (c) r5;
        o r0 = this.a;
        VideoShowMode r1 = r6.a;
        DigitAvatarContext r2 = DigitAvatarContext.Companion.getContext();
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.getSkipFrequencyCheck() != true) goto L7;
    L8:
        r6.getClass();
        VideoShowMode r7 = r0.l;
        if (r7 == r1) goto L12;
        r0.c(r7);
        r0.l = r1;
        r0.e(r1, r3, null, "on showmode update");
        return;
    L12:
        return;
    L7:
        r3 = false;
        goto L8
    }
}
