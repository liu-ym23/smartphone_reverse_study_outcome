package jjb;

import com.bytedance.lark.pb.tool.v1.MakeUserOfflineV2Request;
import com.bytedance.lark.pb.tool.v1.UserLoginState;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ jjb.a a;
    public final /* synthetic */ User b;
    public final /* synthetic */ j0c.e c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ jjb.a b;
        public final /* synthetic */ User c;
        public final /* synthetic */ ObservableEmitter<j0c.c> d;

        public a(j0c.e r1, jjb.a r2, User r3, ObservableEmitter<j0c.c> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            Boolean r7 = (Boolean) r6;
            Log.i("ComponentTask", "user{" + this.a.a.a.userId + "} background offline success");
            jjb.a.a(this.b, this.c.userId, false);
            this.b.b(this.a.a.a.userId);
            ObservableEmitter<j0c.c> r8 = this.d;
            this.b.getClass();
            r8.onNext(new j0c.c(jjb.a.d, true, null, 12));
            this.d.onComplete();
        }
    }

    /* JADX INFO: renamed from: jjb.b$b, reason: collision with other inner class name */
    public static final class C0283b<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ jjb.a b;
        public final /* synthetic */ User c;
        public final /* synthetic */ ObservableEmitter<j0c.c> d;

        public C0283b(j0c.e r1, jjb.a r2, User r3, ObservableEmitter<j0c.c> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Log.e("ComponentTask", "user{" + this.a.a.a.userId + "} background offline failed , parse data error", r7);
            jjb.a.a(this.b, this.c.userId, true);
            this.b.b(this.a.a.a.userId);
            ObservableEmitter<j0c.c> r0 = this.d;
            this.b.getClass();
            j0c.b r2 = jjb.a.d;
            if (r7 == null) goto L5;
            String r8 = r7.getMessage();
        L6:
            r0.onNext(new j0c.c(r2, false, 3, r8));
            this.d.onComplete();
            return;
        L5:
            r8 = null;
            goto L6
        }
    }

    public b(jjb.a r1, User r2, j0c.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<j0c.c> r7) {
        Intrinsics.checkNotNullParameter(r7, "e");
        Pair r0 = this.a.c.i(this.b.userId);
        if (r0 == null) goto L5;
        Long r1 = (Long) r0.getSecond();
    L6:
        Log.d("ComponentTask", "makeUserBackgroundOffline componentId : " + r1);
        if (r1 != null) goto L9;
        Log.e("ComponentTask", "makeUserBackgroundOffline componentIds is null");
    L9:
        MakeUserOfflineV2Request.Builder r2 = new MakeUserOfflineV2Request.Builder().user_id(Long.valueOf(CastLongProtector.parseLong(this.b.userId))).prior_state(UserLoginState.BACKGROUND_ONLINE);
        j.a(r2, this.c);
        if (r1 == null) goto L12;
        r2.container_id(Long.valueOf(r1.longValue()));
    L12:
        Observable r3 = this.a.c.q(this.c.a.a.userId, r2, true);
        j0c.e r4 = this.c;
        jjb.a r5 = this.a;
        User r6 = this.b;
        r3.subscribe(new a(r4, r5, r6, r7), new C0283b(r4, r5, r6, r7));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
