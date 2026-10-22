package com.obric.assistant.automic;

import aga.j;
import android.os.Build;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.voice.ContentScene;
import java.util.TimerTask;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends TimerTask {
    public final /* synthetic */ ObricAutoMicServiceImpl a;
    public final /* synthetic */ ContentScene b;

    public final void a() {
        if (Build.VERSION.SDK_INT < 33) goto L16;
        SoundEffectHelper.INSTANCE.playSendMessage();
        boolean r2 = true;
        BuildersKt.runBlocking$default(null, new ObricAutoMicServiceImpl$startCountDownTimer$1$1$1(null), 1, null);
        ObricAutoMicServiceImpl r0 = this.a;
        int r1 = ObricAutoMicServiceImpl.i;
        r0.getClass();
        if (ObricAutoMicServiceImpl.p() == null) goto L14;
        maa.e r3 = j.e();
        FLogger.a.i("AiIslandVoiceInteractionSession", "tryFinishAsrSession");
        if (r3 != null) goto L9;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L14;
        r3.Te();
        goto L14
    L9:
        if (r3.x3() != true) goto L11;
    L14:
        this.a.i(this.b, "morethan8s");
        return;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(ObricAutoMicServiceImpl r1, ContentScene r2) {
        this.a = r1;
        this.b = r2;
    }
}
