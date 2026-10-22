package jjb;

import com.bytedance.lark.pb.tool.v1.MakeUserOfflineV2Request;
import com.bytedance.lark.pb.tool.v1.UserLoginState;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.log.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> implements ObservableOnSubscribe {
    public final /* synthetic */ e a;
    public final /* synthetic */ j0c.e b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ e b;
        public final /* synthetic */ MakeUserOfflineV2Request.Builder c;
        public final /* synthetic */ ObservableEmitter<j0c.c> d;

        public a(j0c.e r1, e r2, MakeUserOfflineV2Request.Builder r3, ObservableEmitter<j0c.c> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            Boolean r7 = (Boolean) r6;
            Log.i("ComponentTask", "user{" + this.a.a.a.userId + "} foreground offline success");
            e.a(this.b, this.c.user_id.toString(), false);
            e.b(this.b, this.a.a.a.userId);
            ObservableEmitter<j0c.c> r8 = this.d;
            this.b.getClass();
            r8.onNext(new j0c.c(e.d, true, null, 12));
            this.d.onComplete();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ e b;
        public final /* synthetic */ MakeUserOfflineV2Request.Builder c;
        public final /* synthetic */ ObservableEmitter<j0c.c> d;

        public b(j0c.e r1, e r2, MakeUserOfflineV2Request.Builder r3, ObservableEmitter<j0c.c> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Log.e("ComponentTask", "user{" + this.a.a.a.userId + "} foreground offline failed ", r7);
            e.a(this.b, this.c.user_id.toString(), true);
            e.b(this.b, this.a.a.a.userId);
            ObservableEmitter<j0c.c> r0 = this.d;
            this.b.getClass();
            j0c.b r2 = e.d;
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

    public f(e r1, j0c.e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<j0c.c> r7) {
        Intrinsics.checkNotNullParameter(r7, "e");
        Pair r0 = this.a.c.i(this.b.a.a.userId);
        if (r0 == null) goto L5;
        Long r1 = (Long) r0.getSecond();
    L6:
        Log.d("ComponentTask", "makeUserForegroundOffline containerId is " + r1);
        if (r1 != null) goto L9;
        Log.e("ComponentTask", "makeUserForegroundOffline containerId is null");
    L9:
        MakeUserOfflineV2Request.Builder r2 = new MakeUserOfflineV2Request.Builder().user_id(Long.valueOf(CastLongProtector.parseLong(this.b.a.a.userId))).prior_state(UserLoginState.FOREGROUND_ONLINE);
        j.a(r2, this.b);
        if (r1 == null) goto L12;
        r2.container_id(Long.valueOf(r1.longValue()));
    L12:
        Observable r3 = this.a.c.q(this.b.a.a.userId, r2, false);
        j0c.e r4 = this.b;
        e r5 = this.a;
        r3.subscribe(new a(r4, r5, r2, r7), new b(r4, r5, r2, r7));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
