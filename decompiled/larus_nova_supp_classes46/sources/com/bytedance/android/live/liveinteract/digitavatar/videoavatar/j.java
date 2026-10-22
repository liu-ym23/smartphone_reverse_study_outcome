package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ VideoDigitAvatarWidget a;
    public final /* synthetic */ m00.g b;

    public j(VideoDigitAvatarWidget r1, m00.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        VideoDigitAvatarWidget r5 = this.a;
        m00.g r0 = this.b;
        int r1 = VideoDigitAvatarWidget.l;
        r5.getClass();
        jg6.a r6 = r5.getScopeServiceInMultiLinkRoom(cg6.a.class).e5();
        if (r6 == null) goto L6;
        r6.a();
    L6:
        if (je0.d.G() == true) goto L12;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.j() != 5) goto L14;
        r0.p();
        return;
    L14:
        return;
    }
}
