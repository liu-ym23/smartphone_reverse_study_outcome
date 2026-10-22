package m00;

import android.content.Intent;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.sk;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f {
    void a(kj r1, LiveMode r2);

    void d(sk r1);

    void destroy();

    void onActivityResult(int r1, int r2, Intent r3);
}
