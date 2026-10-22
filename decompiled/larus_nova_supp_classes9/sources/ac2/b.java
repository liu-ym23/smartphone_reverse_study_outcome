package ac2;

import android.util.Log;
import com.bytedance.common.utility.Logger;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ long a;
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.f b;

    public static final class a implements com.ss.ugc.live.sdk.msg.network.e {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            if ((r3 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L8;
            com.ss.ugc.live.sdk.msg.network.g r4 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r3).b;
            if (this.a.isDisposed() == true) goto L15;
            this.a.onNext(r4);
            this.a.onComplete();
            return;
        L15:
            return;
        L8:
            if ((r3 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L14;
            Exception r5 = (Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r3).b;
            Logger.i("LiveUplink", "e=" + Log.getStackTraceString(r5));
            if (this.a.isDisposed() == true) goto L17;
            this.a.onError(r5);
            return;
        L17:
            return;
        L14:
            throw new NoWhenBranchMatchedException();
        }
    }

    public b(long r1, com.ss.ugc.live.sdk.msg.network.f r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void subscribe(ObservableEmitter<com.ss.ugc.live.sdk.msg.network.g> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        z r0 = c.a;
        c.b.f(this.a, this.b, new a(r6));
    }
}
