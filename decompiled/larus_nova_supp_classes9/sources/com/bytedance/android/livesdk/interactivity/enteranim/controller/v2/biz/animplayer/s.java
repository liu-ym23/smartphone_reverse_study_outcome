package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.profit.dress.api.OpenAssetPlayErrorType;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ OpenAssetVideoPlayer a;
    public final /* synthetic */ k32.c b;
    public final /* synthetic */ long c;
    public final /* synthetic */ a d;
    public final /* synthetic */ com.bytedance.android.live.profit.player.d e;
    public final /* synthetic */ AnimPlayer.a f;
    public final /* synthetic */ ViewGroup g;
    public final /* synthetic */ Context h;
    public final /* synthetic */ com.bytedance.android.live.profit.dress.u i;

    public s(OpenAssetVideoPlayer r1, k32.c r2, long r3, a r5, com.bytedance.android.live.profit.player.d r6, AnimPlayer.a r7, ViewGroup r8, Context r9, com.bytedance.android.live.profit.dress.u r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.profit.player.s r10 = (com.bytedance.android.live.profit.player.s) r9;
        List r0 = (List) r10.b();
        if (r0 != null) goto L9;
        OpenAssetVideoPlayer r1 = this.a;
        k32.c r2 = this.b;
        long r3 = this.c;
        OpenAssetPlayErrorType r5 = OpenAssetPlayErrorType.UserInfoRenderFailed;
        StringBuilder r4 = new StringBuilder("MaskSrc list create failed: ");
        Throwable r11 = r10.a();
        if (r11 == null) goto L7;
        String r13 = r11.getMessage();
    L8:
        r4.append(r13);
        r1.d(r2, r3, r5, r4.toString(), this.d);
        return;
    L7:
        r13 = null;
        goto L8
    L9:
        this.e.lh(this.c, new com.bytedance.android.live.profit.player.n(r0, new OpenAssetVideoPlayer$playAnim$1$1(this), new r(this), 1));
    }
}
