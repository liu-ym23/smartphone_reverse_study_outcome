package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lu22/d;", "p1", BuildConfig.FLAVOR, "invoke", "(Lu22/d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudioMessagePlayPlugin$registerEvents$1 extends FunctionReferenceImpl implements Function1<u22.d, Unit> {
    public AudioMessagePlayPlugin$registerEvents$1(AudioMessagePlayPlugin r8) {
        super(1, r8, AudioMessagePlayPlugin.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/interactivity/api/comment/event/AudioCommentPlayClickEvent;)V", 0);
    }

    public final void invoke(u22.d r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        AudioMessagePlayPlugin r0 = (AudioMessagePlayPlugin) ((CallableReference) this).receiver;
        int r1 = AudioMessagePlayPlugin.i;
        r0.getClass();
        ALogger.i("AudioMessagePlayPlugin", "on event:AudioCommentPlayClickEvent,path:" + r6.b + ",url:" + r6.a);
        t52.a r2 = r0.f;
        t52.a.C0282a r3 = null;
        if (r2 == null) goto L5;
        t52.a.C0282a r4 = r2.getPlaying();
    L7:
        if ((r4 instanceof AudioMessagePlayPlugin.b) == false) goto L10;
        r3 = r4;
    L10:
        AudioMessagePlayPlugin.b r5 = (AudioMessagePlayPlugin.b) r3;
        if (r5 == null) goto L14;
        String r7 = r5.a;
        if (r7 == null) goto L14;
    L16:
        if (TextUtils.isEmpty(r6.b) == true) goto L32;
        if (TextUtils.equals(r6.b, r7) == false) goto L21;
        r0.g();
        return;
    L21:
        if (TextUtils.isEmpty(r6.b) == true) goto L41;
        Application r8 = jc1.a.b();
        String r9 = r6.b;
        if (r8 == null) goto L30;
        if (r9 != null) goto L27;
        s0 r10 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.e("audio filepath empty");
        goto L30
    L27:
        f72.a.b("AudioMessagePresenter playAudioUseFilePath");
        t52.a r11 = r0.f;
        if (r11 == null) goto L30;
        r11.playAudioByPath(r8, new AudioMessagePlayPlugin.b(r9));
    L30:
        r0.f(r6.c, r6.d);
        return;
    L41:
        return;
    L32:
        if (TextUtils.isEmpty(r6.a) == false) goto L34;
        return;
    L34:
        if (TextUtils.equals(r6.a, r7) == false) goto L37;
        r0.g();
        return;
    L37:
        if (TextUtils.isEmpty(r6.a) == true) goto L45;
        r0.d(jc1.a.b(), r6.a);
        r0.f(r6.c, r6.d);
        return;
    L45:
        return;
    L14:
        r7 = BuildConfig.FLAVOR;
        goto L16
    L5:
        r4 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((u22.d) r1);
        return Unit.INSTANCE;
    }
}
