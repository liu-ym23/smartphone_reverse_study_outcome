package v2a;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.voice_setting.impl.databinding.LarusLayoutVoiceEditAreaNewBinding;
import com.larus.voice_setting.voice.mix.VoiceMixedView;
import com.larus.voice_setting.voice.mix.VoiceSingleView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n implements a {
    public final /* synthetic */ LarusLayoutVoiceEditAreaNewBinding a;

    @Override // v2a.a
    public final VoiceMixedView d() {
        return null;
    }

    @Override // v2a.a
    public final View e() {
        return null;
    }

    @Override // v2a.a
    public final ConstraintLayout a() {
        return this.a.b;
    }

    @Override // v2a.a
    public final TextView b() {
        return this.a.e;
    }

    @Override // v2a.a
    public final AppCompatTextView c() {
        return this.a.g;
    }

    @Override // v2a.a
    public final View f() {
        return this.a.i;
    }

    @Override // v2a.a
    public final SeekBar g() {
        return this.a.c;
    }

    @Override // v2a.a
    public final ImageView getPlayIcon() {
        VoiceSingleView r0 = this.a.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPlayIcon();
    }

    @Override // v2a.a
    public final View getRoot() {
        return this.a.a;
    }

    @Override // v2a.a
    public final LottieAdapterView h() {
        VoiceSingleView r0 = this.a.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPlayLottie();
    }

    @Override // v2a.a
    public final SeekBar i() {
        return this.a.f;
    }

    @Override // v2a.a
    public final AppCompatTextView j() {
        return this.a.d;
    }

    @Override // v2a.a
    public final VoiceSingleView k() {
        return this.a.j;
    }

    @Override // v2a.a
    public final TextView l() {
        return this.a.h;
    }

    public n(LarusLayoutVoiceEditAreaNewBinding r1) {
        this.a = r1;
    }
}
