package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.app.Dialog;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u implements q {
    public static Dialog a;
    public static final u b = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ t80.a b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Ref.ObjectRef d;
        public final /* synthetic */ Ref.ObjectRef e;

        public a(Activity r1, t80.a r2, int r3, Ref.ObjectRef r4, Ref.ObjectRef r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r3) {
            Integer r4 = (Integer) r3;
            String r5 = s1.B(2131916539);
            Dialog r0 = u.a;
            Activity r1 = this.a;
            c9.b r2 = new c9.b();
            r2.a = r1;
            r2.b = 2;
            r2.e = s1.B(2131923432);
            r2.f = r5;
            r2.g = 17;
            String r6 = s1.B(2131915442);
            s r7 = new s(this);
            r2.j = r6;
            r2.k = r7;
            String r8 = s1.B(2131920657);
            t r9 = new t(this);
            r2.l = r8;
            r2.m = r9;
            r2.p = false;
            r2.q = false;
            c9 r10 = new c9(r2.a, r2);
            if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r10);
        L7:
            u.a = r10;
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L6:
            DialogLancet.beforeDialogShow(r10);
            r10.show();
            DialogLancet.afterDialogShow(r10);
            goto L7
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public u() {
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final void c(String r1, ExtraResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
    }

    static {
        b = new u();
    }

    public static boolean d(int r9, RequestError r10, t80.a r11) {
        if (r9 == 4005178) goto L7;
        if (r9 == 4005177) goto L7;
        return false;
    L7:
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = "";
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = "";
        if (r9 != 4005178) goto L10;
        r7.element = "coin_exchange_two_element";
        r8.element = "verify_two_element";
    L10:
        if (r9 != 4005177) goto L12;
        r7.element = "coin_exchange_face";
        r8.element = "webcast_risk_auth";
    L12:
        Activity r4 = jc1.k.n(IHostApp.class).getCurrentActivity();
        if (r4 != null) goto L16;
        return false;
    L16:
        if (r10 == null) goto L18;
        r10.setBlockNotice(true);
    L18:
        Dialog r2 = a;
        if (r2 != null) goto L21;
    L23:
        int r3 = do0.a.a;
        RechargeVerifyTraceStep r5 = RechargeVerifyTraceStep.STEP_RECHARGE_COMMON_VERIFY_START;
        String r6 = (String) r7.element;
        String r12 = (String) r8.element;
        if (r10 == null) goto L26;
        String r13 = r10.url;
    L27:
        do0.a.b(r5, r9, r6, r12, r13);
        Observable.just(0).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r4, r11, r9, r7, r8), b.a);
        return true;
    L26:
        r13 = null;
        goto L27
    L21:
        if (r2.isShowing() != true) goto L23;
        return true;
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final boolean b(int r2, com.bytedance.android.live.network.response.c r3, RequestError r4) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
        return d(r2, r4, null);
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final boolean a(String r1, int r2, BaseResponse<?, ?> r3, String r4, RequestError r5) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        return d(r2, r5, null);
    }
}
