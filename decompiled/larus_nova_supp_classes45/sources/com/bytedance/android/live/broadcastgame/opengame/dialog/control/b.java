package com.bytedance.android.live.broadcastgame.opengame.dialog.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements com.bytedance.android.live.broadcastgame.opengame.dialog.control.a {
    public final c9 a;
    public Long b;
    public Function0<Unit> c;
    public String d;
    public Disposable e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.dialog.control.b$b, reason: collision with other inner class name */
    public static final class C0061b implements Action {
        public final /* synthetic */ b a;

        public C0061b(b r1) {
            this.a = r1;
        }

        public final void run() {
            Function0<Unit> r0 = this.a.c;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ b b;

        public c(long r1, b r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            b r0 = this.b;
            c9 r1 = r0.a;
            String r2 = r0.d;
            if (r2 == null) goto L5;
            String r11 = r2 + ' ' + ((this.a - r9.longValue()) - 1) + 's';
        L6:
            r1.h.setText(r11);
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void F0(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void dismiss() {
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        c9 r1 = this.a;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r1);
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r3 == null) goto L19;
        d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L8:
        if (Looper.myLooper() == r2.getLooper()) goto L10;
        r2.post(DialogLancet.createDismissRunnable(r1));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final boolean isShowing() {
        return this.a.isShowing();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void show() {
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        c9 r1 = this.a;
        String r2 = this.d;
        if (r2 == null) goto L13;
        Long r3 = this.b;
        if (r3 == null) goto L11;
        String r4 = " " + r3.longValue() + 's';
        if (r4 == null) goto L11;
    L12:
        String r5 = r2.concat(r4);
    L14:
        r1.h.setText(r5);
        Long r6 = this.b;
        if (r6 == null) goto L17;
        long r11 = r6.longValue();
        this.e = du2.a.e(0, r11, 1, 1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).doOnComplete(new C0061b(this)).subscribe(new c(r11, this));
    L17:
        c9 r7 = this.a;
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L21:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
        return;
    L11:
        r4 = "";
        goto L12
    L13:
        r5 = null;
        goto L14
    }

    public b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        c9.b r0 = new c9.b();
        r0.a = r4;
        r0.b = 1;
        r0.c = 2131565738;
        r0.p = false;
        r0.g = 17;
        r0.q = false;
        this.a = new c9(r0.a, r0);
        this.d = r4.getString(2131920913);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.a.c(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setIcon(Drawable r4) {
        Intrinsics.checkNotNullParameter(r4, "icon");
        c9 r0 = this.a;
        r0.b.setVisibility(0);
        r0.c.setImageDrawable(r4);
        c9 r5 = this.a;
        r5.b.setVisibility(0);
        r5.c.setVisibility(0);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.a.d(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void v(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        c9 r0 = this.a;
        a r1 = new a(r3);
        r0.h.setOnClickListener(r1);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void y(String r2) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        this.d = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.a
    public final void n0(long r2, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b = Long.valueOf(r2);
        this.c = r4;
    }
}
