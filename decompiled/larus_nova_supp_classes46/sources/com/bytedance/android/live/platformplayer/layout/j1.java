package com.bytedance.android.live.platformplayer.layout;

import android.view.SurfaceControl;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.view.ISurfaceControlParent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j1 implements ISurfaceControlParent.Listener {
    public final /* synthetic */ LivePlayerWidget a;

    public static final class a implements Runnable {
        public final /* synthetic */ j1 a;

        public a(j1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget.yq(this.a.a, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onSurfaceControlDetach(boolean r1) {
    }

    public j1(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onSurfaceControlAttached(SurfaceControl r2) {
        AbsLivePlayerView r3 = this.a.R8();
        if (r3 == null) goto L6;
        r3.post(new a(this));
        return;
    }
}
