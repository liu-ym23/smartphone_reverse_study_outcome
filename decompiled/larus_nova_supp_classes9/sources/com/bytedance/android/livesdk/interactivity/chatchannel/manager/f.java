package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import android.os.Handler;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements IPlayerActionListener {
    public final /* synthetic */ ChatChannelAnimManager.b a;
    public final /* synthetic */ IPlayerActionListener b;

    public final /* synthetic */ void onFirstFrame() {
        IPlayerActionListener.-CC.$default$onFirstFrame(this);
    }

    public final /* synthetic */ void onReportPlayMetrics(Map r1) {
        IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
    }

    public final void onEnd() {
        ChatChannelAnimManager r0 = this.a.h;
        int r1 = ChatChannelAnimManager.e;
        r0.getClass();
        ChatChannelAnimManager.e("onEnd");
        this.b.onEnd();
        ChatChannelAnimManager.b r2 = this.a;
        if (r2.c == true) goto L5;
        r2.c = true;
        Handler r3 = r2.h.d();
        ChatChannelAnimManager.b r4 = this.a;
        r3.postDelayed(r4.d, r4.g);
    L5:
        ChatChannelAnimManager.b r5 = this.a;
        ChatChannelAnimManager.c(r5.h, r5);
    }

    public final void onStart() {
        ChatChannelAnimManager r0 = this.a.h;
        int r1 = ChatChannelAnimManager.e;
        r0.getClass();
        ChatChannelAnimManager.e("onStart");
        this.b.onStart();
    }

    public final void onStop() {
        this.b.onStop();
    }

    public f(ChatChannelAnimManager.b r1, IPlayerActionListener r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFileLoaded(int r2, int r3) {
        this.b.onFileLoaded(r2, r3);
    }

    public final void updateTextEffectPosition(float r2, float r3, float r4, float r5) {
        this.b.updateTextEffectPosition(r2, r3, r4, r5);
    }
}
