package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import u22.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lu22/e;", "p1", BuildConfig.FLAVOR, "invoke", "(Lu22/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudioMessagePlayPlugin$registerEvents$2 extends FunctionReferenceImpl implements Function1<e, Unit> {
    public AudioMessagePlayPlugin$registerEvents$2(AudioMessagePlayPlugin r8) {
        super(1, r8, AudioMessagePlayPlugin.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/interactivity/api/comment/event/AudioCommentStopPlayEvent;)V", 0);
    }

    public final void invoke(e r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((AudioMessagePlayPlugin) ((CallableReference) this).receiver).onEvent(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((e) r1);
        return Unit.INSTANCE;
    }
}
