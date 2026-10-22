package e92;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public i(k r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        FollowPair r4 = (FollowPair) r3;
        this.a.c = false;
        int r5 = w82.b.a;
        w82.b.b(this.b, this.c, false);
    }
}
