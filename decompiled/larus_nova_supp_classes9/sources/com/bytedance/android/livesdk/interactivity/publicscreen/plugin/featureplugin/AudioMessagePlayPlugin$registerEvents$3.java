package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/s;", "p1", BuildConfig.FLAVOR, "invoke", "(Lzg1/s;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudioMessagePlayPlugin$registerEvents$3 extends FunctionReferenceImpl implements Function1<s, Unit> {
    public AudioMessagePlayPlugin$registerEvents$3(AudioMessagePlayPlugin r8) {
        super(1, r8, AudioMessagePlayPlugin.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/ClearScreenEvent;)V", 0);
    }

    public final void invoke(s r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        AudioMessagePlayPlugin r0 = (AudioMessagePlayPlugin) ((CallableReference) this).receiver;
        int r1 = AudioMessagePlayPlugin.i;
        r0.getClass();
        r0.e = r3.a;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((s) r1);
        return Unit.INSTANCE;
    }
}
