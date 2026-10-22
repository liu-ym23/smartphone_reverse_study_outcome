package com.bytedance.android.live.lynx.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.jo;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/lynx/widget/LynxTestWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxTestWidget extends LiveRecyclableWidget {
    public int a;
    public View b;
    public View c;
    public View d;
    public View e;
    public TextView f;
    public a g;
    public DialogFragment h;

    public final class a extends Dialog {
        public EditText a;
        public final /* synthetic */ LynxTestWidget b;

        /* JADX INFO: renamed from: com.bytedance.android.live.lynx.widget.LynxTestWidget$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0125a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0125a(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r4) {
                a r5 = this.a;
                LynxTestWidget r0 = r5.b;
                EditText r6 = r5.a;
                if (r6 == null) goto L7;
                Editable r7 = r6.getText();
                if (r7 == null) goto L7;
                String r8 = r7.toString();
            L8:
                r0.wq(r8);
                a r9 = this.a;
                Handler r1 = DialogLancet.resolveDialogHandler(r9);
                if (r1 != null) goto L11;
            L13:
                DialogLancet.beforeDialogDismiss(r9);
                r9.dismiss();     // Catch: Throwable -> L16 Exception -> L18
            L22:
                DialogLancet.afterDialogDismiss(r9);
                return;
            L18:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
                Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
                if (r2 == null) goto L22;
                com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r9);
                throw th;
            L11:
                if (Looper.myLooper() == r1.getLooper()) goto L13;
                r1.post(DialogLancet.createDismissRunnable(r9));
                return;
            L7:
                r8 = null;
                goto L8
            }
        }

        @Override // android.app.Dialog
        public final void onCreate(Bundle r3) {
            super.onCreate(r3);
            LinearLayout r4 = new LinearLayout(getContext());
            r4.setOrientation(1);
            EditText r0 = new EditText(r4.getContext());
            this.a = r0;
            Unit r1 = Unit.INSTANCE;
            r4.addView(r0);
            Button r2 = new Button(r4.getContext());
            r2.setText(2131915913);
            r2.setOnClickListener(new ViewOnClickListenerC0125a(this));
            r4.addView(r2);
            setContentView(r4);
        }

        public a(LynxTestWidget r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.b = r2;
            super(r3);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LynxTestWidget a;

        public b(LynxTestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            LynxTestWidget r4 = this.a;
            r4.getClass();
            a r0 = new a(r4, ((Widget) r4).context);
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r0);
        L7:
            Unit r1 = Unit.INSTANCE;
            r4.g = r0;
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L6:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            goto L7
        }
    }

    public static final class c implements View.OnLongClickListener {
        public final /* synthetic */ LynxTestWidget a;

        public c(LynxTestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            LynxTestWidget r4 = this.a;
            r4.getClass();
            r4.startActivityForResult(k.n(IHostAction.class).getScanQRIntent(((Widget) r4).context), r4.a);
            return true;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LynxTestWidget a;

        public d(LynxTestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getClass();
            k.n(IHostAction.class).clearGeckoFiles();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ LynxTestWidget a;

        public e(LynxTestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getClass();
            k.n(IHostAction.class).updateGeckoForAll();
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ LynxTestWidget a;

        public f(LynxTestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            TextView r3 = this.a.f;
            if (r3 == null) goto L6;
            r3.setText(k.n(IHostAction.class).getGeckoVersionsString());
            return;
        }
    }

    public final int getLayoutId() {
        return 2131566880;
    }

    public final void onUnload() {
        a r0 = this.g;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        DialogFragment r3 = this.h;
        if (r3 == null) goto L35;
        r3.dismiss();     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L36;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L36:
        return;
    }

    public LynxTestWidget() {
    }

    public final void onInit(Object[] r2) {
        View r3 = findViewById(2131364822);
        r3.setOnClickListener(new b(this));
        r3.setOnLongClickListener(new c(this));
        Unit r0 = Unit.INSTANCE;
        this.b = r3;
        View r4 = findViewById(2131364678);
        r4.setOnClickListener(new d(this));
        this.c = r4;
        View r5 = findViewById(2131364874);
        r5.setOnClickListener(new e(this));
        this.d = r5;
        View r6 = findViewById(2131364733);
        r6.setOnClickListener(new f(this));
        this.e = r6;
        this.f = (TextView) findViewById(2131391683);
    }

    public final void onLoad(Object[] r2) {
        this.a++;
        ((Widget) this).contentView.setBackgroundColor(ColorProtector.parseColor("#00000000"));
    }

    public final void wq(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (StringsKt.startsWith$default(r6, "http", false, 2, null) == false) goto L6;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L15;
        r6 = null;
    L15:
        if (r6 != null) goto L17;
        return;
    L17:
        if (StringsKt.startsWith$default(r6, "sslocal://lynxview?", false, 2, null) == false) goto L19;
        r6 = UriProtector.getQueryParameter(UriProtector.parse(r6), "compile_path");
    L19:
        if (r6 != null) goto L21;
        return;
    L21:
        if (((Boolean) jo.a.getValue()).booleanValue() == true) goto L27;
        BaseWebDialogFragment r7 = k.n(IBrowserService.class).buildLynxDialog(r6, null, null).build();
        LiveDialogFragment.a r1 = LiveDialogFragment.Companion;
        FragmentActivity r2 = ((Widget) this).context;
        if (r2 == null) goto L26;
        r1.getClass();
        LiveDialogFragment.a.a(r2, r7);
        Unit r3 = Unit.INSTANCE;
        this.h = r7;
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L27:
        k.n(IBrowserService.class).getRenderUrlByH5Service(r6);
        this.h = k.n(IBrowserService.class).showHybridDialog(((Widget) this).context, x6.a.c(r6).appendQueryParameter("type", "popup").appendQueryParameter("fallback_url", "").build(), null);
        return;
    L6:
        if (StringsKt.startsWith$default(r6, "https", false, 2, null) == true) goto L11;
        if (k.n(IRoomService.class).actionHandler().handle(((Widget) this).context, r6) == false) goto L11;
        r0 = false;
        goto L12
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        if (r1 == this.a) goto L5;
        return;
    L5:
        if (r3 == null) goto L10;
        String r4 = r3.getStringExtra("url");
        if (r4 == null) goto L11;
        wq(r4);
        return;
    L11:
        return;
    }
}
