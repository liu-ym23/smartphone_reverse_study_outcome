package com.bytedance.android.live.effect.soundeffect;

import android.os.Looper;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements LiveSoundEffectHelper.b {
    public final /* synthetic */ LiveSoundEffectHelper a;
    public final /* synthetic */ Sticker b;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ Sticker b;

        public a(d r1, Sticker r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveSoundEffectHelper r0 = this.a.a;     // Catch: Throwable -> L4
            Sticker r1 = this.b;     // Catch: Throwable -> L4
            int r2 = LiveSoundEffectHelper.h;     // Catch: Throwable -> L4
            r0.b(r1, true, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void onError() {
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void x1(int r1, LiveSoundAdapter.ViewHolder r2) {
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void a(Sticker r3) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        List<String> r0 = LiveEffectContext.h;
        r3.setDownloaded(LiveEffectContext.a.a(this.a.getType()).b().r().q(this.b));
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L5;
        AndroidSchedulers.mainThread().scheduleDirect(new a(this, r3));
        return;
    L5:
        this.a.b(r3, true, true);
    }

    public d(LiveSoundEffectHelper r1, Sticker r2) {
        this.a = r1;
        this.b = r2;
    }
}
