package com.bytedance.android.live.broadcastgame.opengame.dialog.control;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/dialog/control/OpenControlBottomDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/broadcastgame/opengame/dialog/control/a;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenControlBottomDialog extends CommonBottomDialog implements com.bytedance.android.live.broadcastgame.opengame.dialog.control.a {
    public TextView a;
    public TextView b;
    public LinearLayout c;
    public Button d;
    public Long e;
    public Function0<Unit> f;
    public String g;
    public Disposable h;
    public String i;
    public String j;
    public String k;
    public Function0<Unit> l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ OpenControlBottomDialog b;

        public a(String r1, OpenControlBottomDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ((IBrowserService) k.n(IBrowserService.class)).buildFullScreenWebPage(this.b.getContext(), this.a).b();
            Button r4 = this.b.d;
            if (r4 == null) goto L6;
            r4.performClick();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OpenControlBottomDialog a;

        public b(OpenControlBottomDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.l;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ OpenControlBottomDialog a;

        public c(OpenControlBottomDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r1) {
            Function0<Unit> r2 = this.a.l;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ OpenControlBottomDialog a;

        public d(OpenControlBottomDialog r1) {
            this.a = r1;
        }

        public final void run() {
            Function0<Unit> r0 = this.a.f;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ OpenControlBottomDialog b;

        public e(long r1, OpenControlBottomDialog r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            OpenControlBottomDialog r0 = this.b;
            Button r1 = r0.d;
            if (r1 == null) goto L10;
            String r2 = r0.g;
            if (r2 == null) goto L7;
            String r11 = r2 + ' ' + ((this.a - r9.longValue()) - 1) + 's';
        L8:
            r1.setText(r11);
            return;
        L7:
            r11 = null;
            goto L8
        }
    }

    public final int getLayoutId() {
        return 2131565440;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "icon");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M0() {
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setText(this.i);
    L5:
        TextView r1 = this.b;
        if (r1 == null) goto L8;
        r1.setText(this.j);
    L8:
        String r2 = this.k;
        if (r2 == null) goto L16;
        LinearLayout r3 = this.c;
        if (r3 == null) goto L13;
        r3.setVisibility(0);
    L13:
        LinearLayout r4 = this.c;
        if (r4 == null) goto L16;
        r4.setOnClickListener(new a(r2, this));
    L16:
        Button r5 = this.d;
        if (r5 == null) goto L19;
        r5.setOnClickListener(new b(this));
    L19:
        Button r6 = this.d;
        if (r6 == null) goto L31;
        String r7 = this.g;
        if (r7 == null) goto L29;
        Long r8 = this.e;
        if (r8 == null) goto L27;
        String r9 = " " + r8.longValue() + 's';
        if (r9 == null) goto L27;
    L28:
        String r11 = r7.concat(r9);
    L30:
        r6.setText(r11);
    L27:
        r9 = "";
        goto L28
    L29:
        r11 = null;
    L31:
        setOnCancelListener(new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void dismiss() {
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void show() {
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        M0();
        Long r1 = this.e;
        if (r1 == null) goto L9;
        long r11 = r1.longValue();
        this.h = du2.a.e(0, r11, 1, 1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).doOnComplete(new d(this)).subscribe(new e(r11, this));
    L9:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public OpenControlBottomDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.g = r2.getString(2131920913);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void F0(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        this.k = r2;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.a = (TextView) findViewById(2131389508);
        this.b = (TextView) findViewById(2131389506);
        this.c = (LinearLayout) findViewById(2131389507);
        this.d = (Button) findViewById(2131389505);
        M0();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.j = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.i = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void v(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.l = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void y(String r2) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        this.g = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void n0(long r2, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.e = Long.valueOf(r2);
        this.f = r4;
    }
}
