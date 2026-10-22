package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class EasterEggAnimationDialog extends Dialog {
    public static volatile AtomicInteger h;
    public static final a i = null;
    public Function0<Unit> a;
    public HSImageView b;
    public View c;
    public View d;
    public final Lazy e;
    public boolean f;
    public boolean g;

    public static final class a {
        public a() {
        }

        public static void a(Context r2, Function0 r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "confirmAction");
            if (EasterEggAnimationDialog.h.get() <= 0) goto L6;
            ALogger.d("EasterEggAnimationDialog", "showing not allowed, skip launch.");
            return;
        L6:
            ALogger.d("EasterEggAnimationDialog", "start launch");
            EasterEggAnimationDialog r0 = new EasterEggAnimationDialog(r2);
            r0.a = r3;
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r0);
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ EasterEggAnimationDialog a;

        public b(EasterEggAnimationDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            int r5 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
            Intrinsics.checkNotNullParameter("open", "clickType");
            LinkedHashMap r6 = new LinkedHashMap();
            r6.put("operate_type", "open");
            r6.put("interactive_name", "like_scene");
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_sjb_interactive_page_click", r6);
            Function0<Unit> r7 = this.a.a;
            if (r7 == null) goto L5;
            Unit r8 = (Unit) r7.invoke();
        L5:
            EasterEggAnimationDialog r9 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r9);
            if (r0 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r9);
            r9.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r9);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r1 == null) goto L19;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r9);
            throw th;
        L8:
            if (Looper.myLooper() == r0.getLooper()) goto L10;
            r0.post(DialogLancet.createDismissRunnable(r9));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ EasterEggAnimationDialog a;

        public c(EasterEggAnimationDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            int r5 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
            Intrinsics.checkNotNullParameter("close", "clickType");
            LinkedHashMap r6 = new LinkedHashMap();
            r6.put("operate_type", "close");
            r6.put("interactive_name", "like_scene");
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_sjb_interactive_page_click", r6);
            EasterEggAnimationDialog r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r7));
        }
    }

    static {
        i = new a();
        h = new AtomicInteger(0);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ALogger.d("EasterEggAnimationDialog", "dismiss");
        com.bytedance.android.livesdk.f.d().f();
        if (this.g == true) goto L5;
        this.g = true;
        ALogger.d("EasterEggAnimationDialog", "likeEggDialogCount decrement: " + h.decrementAndGet());
    L5:
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r0.getLooper()) goto L10;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        ALogger.d("EasterEggAnimationDialog", "start show");
        com.bytedance.android.livesdk.f.d().a();
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

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (this.b != null) goto L13;
        this.b = findViewById(2131362963);
        this.c = findViewById(2131364673);
        this.d = findViewById(2131364689);
        HSImageView r0 = this.b;
        if (r0 == null) goto L7;
        r0.setController((DraweeController) this.e.getValue());
    L7:
        View r1 = this.d;
        if (r1 == null) goto L10;
        r1.setOnClickListener(new b(this));
    L10:
        View r2 = this.c;
        if (r2 == null) goto L13;
        r2.setOnClickListener(new c(this));
    L13:
        int r3 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("interactive_name", "like_scene");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_sjb_interactive_page_show", r4);
    }

    public EasterEggAnimationDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 2131954703);
        this.e = LazyKt.lazy(EasterEggAnimationDialog$easterEggWebpController$2.INSTANCE);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L6;
        r4.requestFeature(1);
    L6:
        if (PadConfigUtils.c() == false) goto L8;
        int r5 = 2131566821;
    L9:
        setContentView(r5);
        Window r6 = getWindow();
        if (r6 == null) goto L12;
        r6.setLayout(-1, -1);
    L12:
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        if (this.f == true) goto L16;
        this.f = true;
        ALogger.d("EasterEggAnimationDialog", "likeEggDialogCount increment: " + h.incrementAndGet());
        return;
    L16:
        return;
    L8:
        r5 = 2131566820;
        goto L9
    }
}
