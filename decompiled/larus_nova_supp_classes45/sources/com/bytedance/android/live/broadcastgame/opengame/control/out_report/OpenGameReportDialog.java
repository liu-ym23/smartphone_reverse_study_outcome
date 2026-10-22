package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.GameReportApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.android.live.broadcastgame.opengame.utils.i;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/control/out_report/OpenGameReportDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameReportDialog extends CommonBottomDialog {
    public static final /* synthetic */ int h = 0;
    public Disposable a;
    public boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final /* synthetic */ i20.a g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ OpenGameReportDialog a;

        public a(OpenGameReportDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            final List<q.a> r8 = ((q) ((BaseResponse) ((Response) r7)).data).a();
            if (r8 == null) goto L6;
            UtilityKotlinExtentionsKt.s(0, false, false, new OpenGameReportDialog$requestData$1$$special$$inlined$let$lambda$1(r8, this), 7);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final int getLayoutId() {
        return 2131564133;
    }

    public final void M0() {
        Lazy r0 = LiveOpenGameClient.d;
        this.a = ((GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class)).getReportReasonList("mini_app", -1).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new a(this), b.a);
    }

    public final void cancel() {
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialog*/.cancel();
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Disposable r1 = this.a;
        if (r1 == null) goto L20;
        r1.dispose();
    L20:
        this.g.b();
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b == true) goto L5;
        M0();
    L5:
        this.b = false;
    }

    public final void show() {
        Disposable r0 = i.b(RxUtilKt.h(xs2.b.a().b(q10.a.class)), new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r0, "$this$autoDispose");
        this.g.a(r0);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        ALogger.i("OpenGameReportDialog", this.c + ' ' + this.d + ' ' + this.e);
        if (this.f == false) goto L21;
        Window r9 = getWindow();
        if (r9 == null) goto L9;
        WindowManager.LayoutParams r11 = r9.getAttributes();
        if (r11 == null) goto L9;
        r11.width = s1.f(390.0f);
    L9:
        View r12 = findViewById(2131384819);
        if (r12 == null) goto L17;
        a1.k(r12, s1.q(getContext()).heightPixels);
        Drawable r13 = r12.getBackground();
        if ((r13 instanceof GradientDrawable) == true) goto L14;
        r13 = null;
    L14:
        GradientDrawable r14 = (GradientDrawable) r13;
        float r3 = s1.e(12.0f);
        if (r14 == null) goto L17;
        r14.setCornerRadii(new float[]{r3, r3, 0.0f, 0.0f, 0.0f, 0.0f, r3, r3});
    L17:
        Window r15 = getWindow();
        if (r15 == null) goto L20;
        r15.setGravity(5);
    L20:
        t8.d(getWindow());
    L21:
        M0();
        if ((!StringsKt.isBlank(this.c)) == false) goto L25;
        ((TextView) findViewById(2131390479)).setText(s1.C(2131922174, new Object[]{this.c}));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r2) {
        if (this.f == false) goto L6;
        if (r2 == false) goto L6;
        t8.d(getWindow());
    L6:
        super/*android.app.Dialog*/.onWindowFocusChanged(r2);
    }

    public OpenGameReportDialog(Context r2, String r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, OpenPlatformBaseDebugger.DEVELOP);
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "appName");
        super(r2, r6, false);
        this.g = new i20.a();
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.b = true;
    }
}
