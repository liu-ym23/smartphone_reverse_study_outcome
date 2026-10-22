package u01;

import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.service.RevMessageHub;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements RevMessageHub {
    public final MessageHub a;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ l a;
        public final /* synthetic */ Class b;
        public final /* synthetic */ String c;

        /* JADX INFO: renamed from: u01.l$a$a, reason: collision with other inner class name */
        public static final class C0328a implements ttc.c {
            public final /* synthetic */ a a;
            public final /* synthetic */ vlc.l b;

            public C0328a(a r1, vlc.l r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void cancel() {
                a r0 = this.a;
                r0.a.a.removeMessageListener(r0.c, this.b);
            }
        }

        public static final class b implements vlc.l {
            public final /* synthetic */ a a;
            public final /* synthetic */ ObservableEmitter b;

            public b(a r1, ObservableEmitter r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onMessage(tlc.d r3) {
                ObservableEmitter r0 = this.b;
                if (r3 == null) goto L11;
                yh6.c r4 = com.bytedance.android.live.base.model.m.a((vh7.c) r3, this.a.b);
                if (r4 == null) goto L9;
                r0.onNext(r4);
                return;
            L9:
                throw new NullPointerException("null cannot be cast to non-null type T");
            L11:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
            }
        }

        public static final class c implements vlc.l {
            public final /* synthetic */ ObservableEmitter a;

            public c(ObservableEmitter r1) {
                this.a = r1;
            }

            public final void onMessage(tlc.d r2) {
                ObservableEmitter r0 = this.a;
                if (r2 == null) goto L7;
                r0.onNext((yh6.c) r2);
                return;
            L7:
                throw new NullPointerException("null cannot be cast to non-null type T");
            }
        }

        public a(l r1, Class r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(ObservableEmitter<T> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            if (vh7.e.class.isAssignableFrom(this.b) == false) goto L5;
            vlc.l r0 = new b(this, r3);
        L6:
            r3.setCancellable(new C0328a(this, r0));
            this.a.a.addMessageListener(this.c, r0);
            return;
        L5:
            r0 = new c(r3);
            goto L6
        }
    }

    public l(MessageHub r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    public final <T extends yh6.c> Observable<T> observe(String r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "type");
        return RxCompatKt.c(Observable.create(new a(this, r3, r2)));
    }
}
