package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.model.DisplayMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public p0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L35;
        AbsLivePlayerView r4 = this.a.R8();
        ILivePlayerScene r1 = null;
        if ((r4 instanceof LivePlayerView) == true) goto L7;
        r4 = null;
    L7:
        LivePlayerView r5 = (LivePlayerView) r4;
        if (r5 == null) goto L12;
        LivePlayerConfig r6 = r5.getConfig();
        if (r6 == null) goto L12;
        ILivePlayerScene r7 = r6.getScene();
    L13:
        ILivePlayerClient r0 = this.a.dr();
        if (r0 == null) goto L18;
        LivePlayerClientContext r2 = r0.context();
        if (r2 == null) goto L18;
        r1 = r2.getUseScene();
    L18:
        boolean r8 = Intrinsics.areEqual(r7, r1);
        if (((com.bytedance.android.live.platformplayer.b) this.a.ar().invoke()).b() == true) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r8 == false) goto L30;
        if (r9 == false) goto L30;
        ILivePlayerClient r10 = this.a.dr();
        if (r10 == null) goto L36;
        r10.updateDisplayMode(DisplayMode.INNER);
        return;
    L36:
        return;
    L30:
        if (LivePlayerWidget.wq(this.a) == true) goto L38;
        ILivePlayerClient r11 = this.a.dr();
        if (r11 == null) goto L39;
        r11.updateDisplayMode(DisplayMode.INNER_PREPLAY);
        return;
    L39:
        return;
    L38:
        return;
    L21:
        if (((com.bytedance.android.live.platformplayer.b) this.a.ar().invoke()).isUserVisible() == false) goto L23;
        r9 = true;
    L12:
        r7 = null;
        goto L13
    }
}
