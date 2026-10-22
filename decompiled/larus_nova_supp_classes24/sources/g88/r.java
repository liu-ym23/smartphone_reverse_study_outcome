package g88;

import android.content.Intent;
import com.larus.audio.call.mgr.MajorState;
import com.larus.im.service.audio.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface r {
    void A0();

    void D9(z0.a r1);

    void I6(jd9.c r1);

    void o1(MajorState r1, int r2, MajorState r3, int r4);

    void onActivityResult(int r1, int r2, Intent r3);

    void onAppBackground();

    void onAppForeground();

    void z2(String r1, Object r2);
}
