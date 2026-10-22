package r42;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements SingleOnSubscribe {
    public final /* synthetic */ vlc.e a;
    public final /* synthetic */ String b;

    public static final class a implements vlc.m {
        public final /* synthetic */ SingleEmitter a;

        public a(SingleEmitter r1) {
            this.a = r1;
        }

        public final void a(List<? extends tlc.d> r3) {
            Intrinsics.checkNotNullParameter(r3, "messages");
            SingleEmitter r0 = this.a;
            int r1 = com.ss.ugc.live.sdk.msg.utils.g.a;
            r0.onSuccess(new com.ss.ugc.live.sdk.msg.utils.g.c(r3));
        }

        public final void b(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.onError(r2);
        }
    }

    public c(vlc.e r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<com.ss.ugc.live.sdk.msg.utils.g<List<tlc.d>, Throwable>> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        this.a.G(new tlc.e(this.b), new a(r4));
    }
}
