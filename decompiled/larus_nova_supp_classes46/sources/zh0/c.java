package zh0;

import com.bytedance.android.live.core.setting.c4;
import com.bytedance.android.livesdkapi.model.RadioSpeakingUpdateTimeConfig;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final long a;
    public Disposable b;
    public final com.bytedance.android.live.pushstream.d c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        com.bytedance.android.live.pushstream.d r0 = this.c;
        if (r0 == null) goto L5;
        r0.c1("radio_sei", null, 1, false, true);
    L5:
        Disposable r1 = this.b;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.b = null;
    }

    public c(com.bytedance.android.live.pushstream.d r3) {
        this.c = r3;
        this.a = ((RadioSpeakingUpdateTimeConfig) c4.a.getValue()).getSeiSendInterval();
    }
}
