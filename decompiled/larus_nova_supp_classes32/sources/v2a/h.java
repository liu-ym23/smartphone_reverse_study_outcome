package v2a;

import com.larus.voice_setting.voice.mix.SingleVoiceBar;
import com.larus.voice_setting.voice.mix.VoiceSingleView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ h(Function0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function0 r0 = this.a;
        int r1 = SingleVoiceBar.b;
        Intrinsics.checkNotNullParameter((VoiceSingleView) r3, "it");
        r0.invoke();
        return Unit.INSTANCE;
    }
}
