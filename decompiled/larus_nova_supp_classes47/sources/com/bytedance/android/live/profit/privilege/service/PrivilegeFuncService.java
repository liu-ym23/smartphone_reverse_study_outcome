package com.bytedance.android.live.profit.privilege.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdk.message.model.wb;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.e1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.kmp.core.KmpEnv;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yz0.h;
import yz0.k;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PrivilegeFuncService implements o {
    public static final long f = 0;
    public static final /* synthetic */ int g = 0;
    public final CompositeDisposable a;
    public final NextLiveData<wb> b;
    public final d c;
    public final k d;
    public final l e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PrivilegeFuncService a;
        public final /* synthetic */ e1 b;
        public final /* synthetic */ IRoom c;
        public final /* synthetic */ Bundle d;

        public b(PrivilegeFuncService r1, e1 r2, IRoom r3, Bundle r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            if (this.b.isShowing() == false) goto L21;
            e1 r7 = this.b;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r7);
            goto L21
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r7));
        L21:
            vh6.c.b(dr2.b.class).startLive(PrivilegeFuncService.a(this.a), this.c.getRoomId(), this.d);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ PrivilegeFuncService a;

        public d(PrivilegeFuncService r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            wb r4 = (wb) r3;
            this.a.getClass();
            if (r4.getData() == null) goto L6;
            ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).sendEventToAllJsBridges("webcast.saas_coin.task_msg", tv5.a.b(r4));
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.privilege.service.PrivilegeFuncService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(PrivilegeFuncService r8) {
            super(1, r8, PrivilegeFuncService.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            PrivilegeFuncService r0 = (PrivilegeFuncService) ((CallableReference) this).receiver;
            int r1 = PrivilegeFuncService.g;
            r0.getClass();
        L7:
            th = move-exception;
            int r2 = v.a;
            v.c("PrivilegeDataService", th);
            return;
        L4:
            if ((r3 instanceof wb) == false) goto L12;
            r0.b.setValue(r3);     // Catch: Throwable -> L7
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    static {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        long r1 = 1;
    L6:
        f = r1;
        return;
    L5:
        r1 = -1;
        goto L6
    }

    private final Context getContext() {
        return this.d.getContext();
    }

    public final void onStart() {
        l r0 = this.e;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r1 = h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.z, false, 6);
        final AnonymousClass1 r2 = new AnonymousClass1(this);
        RxUtilKt.c(r1.subscribe(new c(r2)), this.a);
        if ((this.d.getContext() instanceof LifecycleOwner) == false) goto L9;
        NextLiveData<wb> r3 = this.b;
        LifecycleOwner r4 = this.d.getContext();
        if (r4 == null) goto L8;
        r3.observe(r4, this.c);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public final void onStop() {
        this.a.dispose();
        this.b.removeObserver(this.c);
    }

    public static final /* synthetic */ Context a(PrivilegeFuncService r0) {
        return r0.getContext();
    }

    public PrivilegeFuncService(com.bytedance.android.live.profit.privilege.datalayer.d r2, k r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "roomMessageService");
        this.d = r3;
        this.e = r4;
        this.a = new CompositeDisposable();
        this.b = new NextLiveData();
        this.c = new d(this);
    }

    public final void c(long r12, String r13, String r14, String r15) {
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r0 = ((mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class)).W2(LogCommon.PAGE_SOURCE_LOG);
        String r2 = "";
        if (r0 == null) goto L8;
        Map<String, String> r3 = r0.getMap();
        if (r3 == null) goto L8;
        String r4 = r3.get("enter_from_merge");
        if (r4 == null) goto L8;
    L10:
        if (r0 == null) goto L17;
        Map<String, String> r1 = r0.getMap();
        if (r1 == null) goto L17;
        String r5 = r1.get("enter_method");
        if (r5 == null) goto L17;
        r2 = r5;
    L17:
        IRoom r6 = this.d.getRoom();
        Bundle r7 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).Xk(r6);
        r7.putBoolean("live_reenter_room", true);
        Object r8 = vh6.c.b(dr2.d.class).getFeedTab(f).get("feed_url");
        if ((r8 instanceof String) == true) goto L20;
        r8 = null;
    L20:
        r7.putString("live.intent.extra.FEED_URL", (String) r8);
        r7.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        Bundle r9 = new Bundle();
        r9.putString("enter_from_merge", r4);
        r9.putString("enter_method", r2);
        r7.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", r9);
        if (by0.b.a(r15) == false) goto L24;
        r7.putString("extra_live_enter_room_handle_schema", r15);
    L24:
        if (StringsKt.contains$default(r4, "general_search", false, 2, null) == true) goto L40;
        if (StringsKt.contains$default(r4, "search_result", false, 2, null) == true) goto L40;
        if (r12 > 0) goto L31;
    L38:
        vh6.c.b(dr2.b.class).startLive(getContext(), r6.getRoomId(), r7);
        return;
    L31:
        if (by0.b.a(r13) == false) goto L38;
        e1 r16 = new e1((Activity) getContext());
        r16.setCancelable(false);
        r16.setCanceledOnTouchOutside(false);
        r16.c = r13;
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r16);
    L37:
        this.a.add(RxUtilKt.h(Observable.timer(r12, TimeUnit.MILLISECONDS)).subscribe(new b(this, r16, r6, r7)));
        return;
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
    L36:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
    L40:
        if (by0.b.a(r14) == false) goto L48;
        ToastUtil.b(r14, 0);
        return;
    L48:
        return;
    L8:
        r4 = "";
        goto L10
    }
}
