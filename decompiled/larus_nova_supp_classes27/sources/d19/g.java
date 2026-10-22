package d19;

import android.animation.Animator;
import com.larus.voicecall.impl.continue_talk.f2;
import com.larus.voicecall.impl.continue_talk.g2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface g {
    void a(f2 r1, g2 r2);

    void b(Function1<? super Animator, Unit> r1, Function1<? super Animator, Unit> r2);

    void c();

    void d();

    void destroy();

    void init();

    void setAudioAmplitude(float r1);

    void setDarkMode(boolean r1);
}
