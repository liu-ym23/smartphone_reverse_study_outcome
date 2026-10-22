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
public final class i<T> implements ObservableOnSubscribe {
    public final /* synthetic */ h a;
    public final /* synthetic */ User b;
    public final /* synthetic */ j0c.e c;
    public final /* synthetic */ long d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ h b;
        public final /* synthetic */ User c;
        public final /* synthetic */ ObservableEmitter<j0c.c> d;

        public a(j0c.e r1, h r2, User r3, long r4, ObservableEmitter<j0c.c> r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r6;
        }

        public final void accept(Object r6) {
            boolean r7 = ((Boolean) r6).booleanValue();
            Log.i("ComponentTask", "user{" + this.a.a.a.userId + "} switch foreground online finish result = " + r7);
            h.a(this.b, this.c.userId);
            l0c.b r0 = this.b.l;
            if (r0 == null) goto L5;
            String r1 = h.m.a;
            r0.b();
        L5:
            ObservableEmitter<j0c.c> r2 = this.d;
            this.b.getClass();
            r2.onNext(new j0c.c(h.m, r7, null, 12));
            this.d.onComplete();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j0c.e a;
        public final /* synthetic */ h b;
        public final /* synthetic */ ObservableEmitter<j0c.c> c;

        public b(j0c.e r1, h r2, ObservableEmitter<j0c.c> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            StringBuilder r0 = new StringBuilder("user{");
            r0.append(this.a.a.a.userId);
            r0.append("} switch foreground online failed error = ");
            String r1 = null;
            if (r7 == null) goto L5;
            String r2 = r7.getMessage();
        L6:
            r0.append(r2);
            Log.i("ComponentTask", r0.toString());
            l0c.b r3 = this.b.l;
            if (r3 == null) goto L12;
            String r4 = h.m.a;
            if (r7 == null) goto L11;
            r7.getMessage();
        L11:
            r3.a();
        L12:
            ObservableEmitter<j0c.c> r5 = this.c;
            this.b.getClass();
            j0c.b r8 = h.m;
            if (r7 == null) goto L15;
            r1 = r7.getMessage();
        L15:
            r5.onNext(new j0c.c(r8, false, 3, r1));
            this.c.onComplete();
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public i(h r1, User r2, j0c.e r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter<j0c.c> r12) {
        Intrinsics.checkNotNullParameter(r12, "e");
        Long r0 = this.a.f.a(this.b.userId);
        Log.d("ComponentTask", "switchUserForegroundOnline containerId is " + r0 + ' ');
        if (r0 != null) goto L5;
        Log.e("ComponentTask", "switchUserForegroundOnline containerId is null ");
    L5:
        SwitchUserStateRequest.Builder r1 = new SwitchUserStateRequest.Builder().user_id(Long.valueOf(CastLongProtector.parseLong(this.b.userId))).destination_state(UserLoginState.FOREGROUND_ONLINE);
        if (r0 == null) goto L8;
        r0.longValue();
        r1.previous_container_id(r0);
    L8:
        n r2 = this.a.f;
        String r3 = this.b.userId;
        Intrinsics.checkNotNull(r1);
        Observable r4 = r2.t(r3, r1);
        j0c.e r9 = this.c;
        h r10 = this.a;
        r4.subscribe(new a(r9, r10, this.b, this.d, r12), new b(r9, r10, r12));
    }
}
