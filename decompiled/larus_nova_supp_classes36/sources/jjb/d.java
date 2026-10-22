package jjb;

import com.bytedance.lark.pb.tool.v1.MakeUserOnlineV2Request;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements ObservableOnSubscribe {
    public final /* synthetic */ c a;
    public final /* synthetic */ User b;
    public final /* synthetic */ MakeUserOnlineV2Request.Builder c;
    public final /* synthetic */ j0c.e d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ c b;
        public final /* synthetic */ User c;
        public final /* synthetic */ ObservableEmitter<j0c.c> d;

        public a(j0c.e r1, c r2, User r3, ObservableEmitter<j0c.c> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            boolean r7 = ((Boolean) r6).booleanValue();
            Log.i("ComponentTask", "user{" + this.a.a.a.userId + "} background online success = " + r7);
            c r0 = this.b;
            String r1 = this.c.userId;
            j0c.b r2 = c.h;
            r0.b(r1);
            ObservableEmitter<j0c.c> r3 = this.d;
            this.b.getClass();
            r3.onNext(new j0c.c(c.h, r7, null, 12));
            this.d.onComplete();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ c b;
        public final /* synthetic */ User c;
        public final /* synthetic */ ObservableEmitter<j0c.c> d;

        public b(j0c.e r1, c r2, User r3, ObservableEmitter<j0c.c> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Log.i("ComponentTask", "user{" + this.a.a.a.userId + "} background online failed", r7);
            c.a(this.b, this.c.userId, false);
            ObservableEmitter<j0c.c> r0 = this.d;
            this.b.getClass();
            j0c.b r3 = c.h;
            if (r7 == null) goto L5;
            String r8 = r7.getMessage();
        L6:
            r0.onNext(new j0c.c(r3, false, 3, r8));
            this.d.onComplete();
            return;
        L5:
            r8 = null;
            goto L6
        }
    }

    public d(c r1, User r2, MakeUserOnlineV2Request.Builder r3, j0c.e r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter<j0c.c> r8) {
        Intrinsics.checkNotNullParameter(r8, "e");
        Observable r0 = this.a.f.k(this.b.userId, this.c, null, true);
        j0c.e r2 = this.d;
        c r3 = this.a;
        User r5 = this.b;
        r0.subscribe(new a(r2, r3, r5, r8), new b(r2, r3, r5, r8));
        c.a(this.a, this.b.userId, true);
    }
}
