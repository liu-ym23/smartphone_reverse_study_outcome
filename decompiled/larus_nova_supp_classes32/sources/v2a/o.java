package v2a;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.voice_setting.impl.databinding.LarusLayoutVoiceEditAreaBinding;
import com.larus.voice_setting.voice.mix.VoiceMixedView;
import com.larus.voice_setting.voice.mix.VoiceSingleView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements a {
    public final /* synthetic */ LarusLayoutVoiceEditAreaBinding a;

    @Override // v2a.a
    public final VoiceSingleView k() {
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
        return this.a.j;
    }

    @Override // v2a.a
    public final VoiceMixedView d() {
        return this.a.n;
    }

    @Override // v2a.a
    public final View e() {
        return this.a.f;
    }

    @Override // v2a.a
    public final View f() {
        return this.a.m;
    }

    @Override // v2a.a
    public final SeekBar g() {
        return this.a.c;
    }

    @Override // v2a.a
    public final ImageView getPlayIcon() {
        return this.a.g;
    }

    @Override // v2a.a
    public final View getRoot() {
        return this.a.a;
    }

    @Override // v2a.a
    public final LottieAdapterView h() {
        return this.a.h;
    }

    @Override // v2a.a
    public final SeekBar i() {
        return this.a.i;
    }

    @Override // v2a.a
    public final AppCompatTextView j() {
        return this.a.d;
    }

    @Override // v2a.a
    public final TextView l() {
        return this.a.k;
    }

    public o(LarusLayoutVoiceEditAreaBinding r1) {
        this.a = r1;
    }
}
