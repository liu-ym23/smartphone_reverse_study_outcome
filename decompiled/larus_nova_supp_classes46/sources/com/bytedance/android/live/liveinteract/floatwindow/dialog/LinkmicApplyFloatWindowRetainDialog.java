package com.bytedance.android.live.liveinteract.floatwindow.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rx1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/floatwindow/dialog/LinkmicApplyFloatWindowRetainDialog;", "Lcom/bytedance/android/live/liveinteract/floatwindow/dialog/BaseLinkmicFloatWindowRetainDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicApplyFloatWindowRetainDialog extends BaseLinkmicFloatWindowRetainDialog {
    public static final /* synthetic */ int d = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ye0.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public a(ye0.b r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            this.a.onSuccess();
            InteractLinkFullLinkMonitor.x(this.b, System.currentTimeMillis() - this.c, ((com.bytedance.android.live.network.response.e) r6).logId);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ye0.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public b(ye0.b r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            this.a.onFailure();
            InteractLinkFullLinkMonitor.w(this.b, System.currentTimeMillis() - this.c, r7);
            String r8 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r7);
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.length() <= 0) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == false) goto L12;
            f2.c(r8, 0);
            return;
        L12:
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    public static final class c implements ye0.b {
        public final /* synthetic */ LinkmicApplyFloatWindowRetainDialog a;

        @Override // ye0.b
        public final void onFailure() {
            Runnable r0 = this.a.c;
            if (r0 == null) goto L5;
            r0.run();
        L5:
            a(this.a);
        }

        @Override // ye0.b
        public final void onSuccess() {
            Runnable r0 = this.a.c;
            if (r0 == null) goto L5;
            r0.run();
        L5:
            a(this.a);
        }

        public c(LinkmicApplyFloatWindowRetainDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(LinkmicApplyFloatWindowRetainDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }
    }

    @Override // com.bytedance.android.live.liveinteract.floatwindow.dialog.BaseLinkmicFloatWindowRetainDialog
    public final int J0() {
        return 2131917751;
    }

    @Override // com.bytedance.android.live.liveinteract.floatwindow.dialog.BaseLinkmicFloatWindowRetainDialog
    public final int L0() {
        return 2131917749;
    }

    @Override // com.bytedance.android.live.liveinteract.floatwindow.dialog.BaseLinkmicFloatWindowRetainDialog
    public final String I0() {
        return "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_linkmic_apply_float_window_retain_dialog_head.png";
    }

    @Override // com.bytedance.android.live.liveinteract.floatwindow.dialog.BaseLinkmicFloatWindowRetainDialog
    public final void M0() {
        super.M0();
        com.bytedance.android.livesdk.sharedpref.e r0 = b6.A;
        Long r1 = Long.valueOf(System.currentTimeMillis());
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        P0(new c(this), "linkmic_float_window_cancel_click");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.floatwindow.dialog.BaseLinkmicFloatWindowRetainDialog
    public final void N0() {
        super.N0();
        com.bytedance.android.livesdk.sharedpref.e r0 = b6.A;
        Long r1 = Long.valueOf(System.currentTimeMillis());
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        if (m.e(getContext()) == true) goto L6;
        m.h(getContext());
        return;
    L6:
        Function0<Unit> r2 = new LinkmicApplyFloatWindowRetainDialog$onConfirmClick$1(this);
        Function1<Throwable, Unit> r3 = new LinkmicApplyFloatWindowRetainDialog$onConfirmClick$2(this);
        long r4 = System.currentTimeMillis();
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).applyStash(this.b.getRoomId(), 0, LinkApi.ApplyStashType.APPLY_WINDOW.ordinal()).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r2, r4), new f(r3, r4)), this.a);
    }

    public final void P0(ye0.b r6, String r7) {
        long r0 = System.currentTimeMillis();
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(this.b.getRoomId(), r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6, r7, r0), new b(r6, r7, r0)), this.a);
    }

    public LinkmicApplyFloatWindowRetainDialog(Context r2, IRoom r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        super(r2, r3, r4);
    }
}
