package p72;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;

    public e(long r1, String r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        ALogger.e("FusionEmoji", "download emoji failed, emojiId:" + this.a + ",roomId:" + this.b);
    }
}
