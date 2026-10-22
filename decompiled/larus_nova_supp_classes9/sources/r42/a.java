package r42;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r52.g3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: r42.a$a, reason: collision with other inner class name */
    public static final class C0271a<T> implements SingleOnSubscribe {
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ vlc.d b;
        public final /* synthetic */ tlc.a c;

        /* JADX INFO: renamed from: r42.a$a$a, reason: collision with other inner class name */
        public static final class C0272a implements vlc.i {
            public final /* synthetic */ C0271a a;
            public final /* synthetic */ SingleEmitter b;

            public final void a(Throwable r3) {
                Intrinsics.checkNotNullParameter(r3, "error");
                int r0 = a.a;
                a.c("fetch first history messages failed due to " + r3.getMessage());
                if (this.b.isDisposed() == true) goto L6;
                this.b.onError(r3);
                return;
            }

            public C0272a(C0271a r1, SingleEmitter r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void b(List<? extends tlc.d> r5, boolean r6) {
                Intrinsics.checkNotNullParameter(r5, "messages");
                int r0 = a.a;
                a.c("fetch first history messages success, fetched count: " + r5.size() + ", hasMore: " + r6);
                ArrayList r1 = new ArrayList();
                Iterator<T> r7 = r5.iterator();
            L4:
                if (r7.hasNext() == false) goto L8;
                T r2 = r7.next();
                int r3 = a.a;
                if ((!a.a((tlc.d) r2, this.a.b)) == false) goto L4;
                r1.add(r2);
                goto L4
            L8:
                SingleEmitter r8 = this.b;
                int r4 = com.ss.ugc.live.sdk.msg.utils.g.a;
                r8.onSuccess(new com.ss.ugc.live.sdk.msg.utils.g.c(new p(r1, r6)));
            }
        }

        public C0271a(Ref.IntRef r1, vlc.d r2, tlc.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(SingleEmitter<com.ss.ugc.live.sdk.msg.utils.g<p, Throwable>> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            int r0 = a.a;
            a.c("public screen first message processor start fetch history message, count: " + this.a.element);
            vlc.d r1 = this.b;
            if ((r1 instanceof vlc.e) == true) goto L5;
            r1 = null;
        L5:
            vlc.e r2 = (vlc.e) r1;
            if (r2 == null) goto L9;
            r2.E(this.c, new C0272a(this, r4));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ o b;

        public b(long r1, o r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            com.ss.ugc.live.sdk.msg.utils.g.c r8 = (com.ss.ugc.live.sdk.msg.utils.g) r7;
            if ((r8 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L6;
            p r9 = (p) r8.b;
            z32.f.d(PSRoomStatValueNode.HistoryMessageFetchCostTime, System.currentTimeMillis() - this.a);
            this.b.a(new n(r9, null));
            return;
        L6:
            if ((r8 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L13;
            Throwable r10 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r8).b;
            o r0 = this.b;
            String r11 = r10.getMessage();
            if (r11 != null) goto L10;
            r11 = "Unknown";
        L10:
            r0.a(new n(null, r11));
            return;
        L13:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MainThreadPostUtils.e(new r42.b(this, (Throwable) r2));
        }
    }

    static {
    }

    public static void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("HISTORY_COMMENT_TAG", r1);
    }

    public static boolean a(tlc.d r1, vlc.d r2) {
        Intrinsics.checkNotNullParameter(r1, "message");
        if ((r2 instanceof vlc.e) == true) goto L5;
        r2 = null;
    L5:
        vlc.e r3 = (vlc.e) r2;
        if (r3 == null) goto L13;
        amc.e r4 = r3.q();
        if (r4 == null) goto L13;
        amc.b r5 = r4.b();
        if (r5 == null) goto L13;
        List r6 = r5.getInterceptors();
        if (r6 == null) goto L13;
    L14:
        Iterator r7 = r6.iterator();
    L16:
        if (r7.hasNext() == false) goto L21;
        if (((vlc.b) r7.next()).onMessage(r1) == false) goto L16;
        return true;
    L21:
        return false;
    L13:
        r6 = CollectionsKt.emptyList();
        goto L14
    }

    public static Disposable b(vlc.d r6, o r7) {
        Intrinsics.checkNotNullParameter(r7, "listener");
        Ref.IntRef r0 = new Ref.IntRef();
        r0.element = g.d();
        if (g.c() == false) goto L6;
        r0.element += 12;
    L6:
        return Single.create(new C0271a(r0, r6, new tlc.a(r0.element))).timeout(Math.max(500, ((Long) g3.a.getValue()).longValue()), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(System.currentTimeMillis(), r7), new c(r7));
    }
}
