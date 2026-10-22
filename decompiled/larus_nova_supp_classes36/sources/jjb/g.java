package jjb;

import com.bytedance.lark.pb.tool.v1.SwitchUserStateRequest;
import com.bytedance.lark.pb.tool.v1.UserLoginState;
import com.bytedance.lark.sdk.refactor.n;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g<T> implements ObservableOnSubscribe {
    public final /* synthetic */ j0c.e a;
    public final /* synthetic */ e b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ ObservableEmitter<j0c.c> b;
        public final /* synthetic */ e c;

        public a(j0c.e r1, ObservableEmitter<j0c.c> r2, e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Log.i("ComponentTask", "user{" + this.a.a.a.userId + "} switch background online finish result = " + ((Boolean) r6).booleanValue());
            ObservableEmitter<j0c.c> r7 = this.b;
            this.c.getClass();
            r7.onNext(new j0c.c(e.d, true, null, 12));
            this.b.onComplete();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ ObservableEmitter<j0c.c> b;
        public final /* synthetic */ e c;

        public b(j0c.e r1, ObservableEmitter<j0c.c> r2, e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            StringBuilder r0 = new StringBuilder("user{");
            r0.append(this.a.a.a.userId);
            r0.append("} switch background online failed error = ");
            String r1 = null;
            if (r7 == null) goto L5;
            String r2 = r7.getMessage();
        L6:
            r0.append(r2);
            Log.i("ComponentTask", r0.toString());
            ObservableEmitter<j0c.c> r3 = this.b;
            this.c.getClass();
            j0c.b r4 = e.d;
            if (r7 == null) goto L9;
            r1 = r7.getMessage();
        L9:
            r3.onNext(new j0c.c(r4, false, 3, r1));
            this.b.onComplete();
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public g(j0c.e r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<j0c.c> r6) {
        Intrinsics.checkNotNullParameter(r6, "e");
        User r0 = this.a.a.a;
        Long r1 = this.b.c.a(r0.userId);
        Log.d("ComponentTask", "switchBackgroundOnline containerIds is " + r1);
        if (r1 != null) goto L5;
        Log.e("ComponentTask", "switchBackgroundOnline containerIds is null");
    L5:
        SwitchUserStateRequest.Builder r2 = new SwitchUserStateRequest.Builder().user_id(Long.valueOf(CastLongProtector.parseLong(r0.userId))).destination_state(UserLoginState.BACKGROUND_ONLINE);
        if (r1 == null) goto L8;
        r2.previous_container_id(Long.valueOf(r1.longValue()));
    L8:
        e.b(this.b, r0.userId);
        n r3 = this.b.c;
        String r4 = r0.userId;
        Intrinsics.checkNotNull(r2);
        Observable r5 = r3.h(r4, r2);
        j0c.e r7 = this.a;
        e r8 = this.b;
        r5.subscribe(new a(r7, r6, r8), new b(r7, r6, r8));
    }
}
