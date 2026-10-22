package yrb;

import com.bytedance.lark.view_flow_wrapper.v;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.o;
import com.ss.android.lark.passportc.entity.UserState;
import f0c.h;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements v {
    public final m b;

    public static final class a implements o {
        public final /* synthetic */ b a;
        public final /* synthetic */ i<Unit> b;

        /* JADX INFO: renamed from: yrb.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0350a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UserState.values().length];
                r0[UserState.ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public final void onUserOffline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void onUserOnline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void a(h r3) {
            this.a.b.c(this);
            if (this.b.isActive() == true) goto L5;
            return;
        L5:
            UserState r4 = r3.a;
            if (C0350a.a[r4.ordinal()] != 1) goto L8;
            i<Unit> r5 = this.b;
            Result.Companion r0 = Result.Companion;
            r5.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            return;
        L8:
            i<Unit> r6 = this.b;
            Result.Companion r1 = Result.Companion;
            r6.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("user is not online"))));
        }

        public final void afterUserOffline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            a(r2);
        }

        public final void afterUserOnline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            a(r2);
        }

        public a(b r1, j r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public b(m r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.b = r2;
    }

    public final Object a(Continuation<? super Unit> r4) {
        if (this.b.getState().a == UserState.ONLINE) goto L5;
        j r0 = new j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        this.b.d(new a(this, r0));
        Object r1 = r0.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L10:
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r1;
    L13:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}
