package fd2;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessLifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface s {
    void Ch(String r1, long r2, Function0<Unit> r4);

    e0 D7();

    void Fi(MusicPanel r1, Function1<Object, Unit> r2, Function1<? super Throwable, Unit> r3);

    String Kb();

    String Mm();

    void Pa();

    xe2.c Qe();

    long Qm();

    void W8(String r1);

    boolean Y5();

    void cp(LifecycleOwner r1, Observer<Integer> r2);

    int f8();

    int i0();

    boolean isPlaying();

    boolean k8();

    void kj(LifecycleOwner r1, Observer<Boolean> r2);

    void km(double r1, int r3, Function1<? super Boolean, Unit> r4);

    boolean ko();

    nd2.d oj();

    void pn(LifecycleOwner r1, Observer<Integer> r2);

    void qf(boolean r1);

    int sb();

    void setChorusCDNInfo(com.bytedance.android.livesdk.chatroom.model.v r1);

    long u7();

    void y9(RealTimeChorusBusinessLifecycleOwner r1, RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$.inlined.let.lambda.1 r2);

    void yj(String r1, boolean r2);
}
