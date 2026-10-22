package v2a;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.mix.VoiceMixedView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j0 implements d {
    public final /* synthetic */ VoiceMixedView a;

    @Override // v2a.d
    public final void b(SpeakerVoice r1, Integer r2) {
    }

    @Override // v2a.d
    public final void a() {
        this.a.getCollapseCallback().invoke();
    }

    public j0(VoiceMixedView r1) {
        this.a = r1;
    }

    @Override // v2a.d
    public final void c(SpeakerVoice r2) {
        Function1<? super SpeakerVoice, Unit> r0 = this.a.i;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    @Override // v2a.d
    public final void d(SpeakerVoice r2) {
        Function1<? super SpeakerVoice, Unit> r0 = this.a.h;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    @Override // v2a.d
    public final void e(MixVoice r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        VoiceMixedView r0 = this.a;
        int r1 = VoiceMixedView.r;
        r0.e(r3, "from_mix");
    }
}
