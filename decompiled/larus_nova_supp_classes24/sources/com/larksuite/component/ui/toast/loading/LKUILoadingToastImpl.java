package com.larksuite.component.ui.toast.loading;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.crash.d;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larksuite/component/ui/toast/loading/LKUILoadingToastImpl;", "Lcom/larksuite/component/ui/dialog/LKUIDialog;", "context", "Landroid/content/Context;", "isBlock", "", "<init>", "(Landroid/content/Context;Z)V", "handler", "Landroid/os/Handler;", "mContent", "Lcom/larksuite/component/ui/toast/loading/LKUILoadingToastImpl$LoadingContent;", "mContext", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onMakeText", "text", "", "showLoading", "cancel", "success", "fail", "scheduleDismiss", "delay", "", "handleDismiss", "dismiss", "show", "duration", "postShow", "handleShow", "resetDismissDuration", "Companion", "LoadingContent", "ToastMessageHandler", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LKUILoadingToastImpl extends LKUIDialog {
    public static final /* synthetic */ int h = 0;
    public final boolean d;
    public final c e;
    public final b f;
    public final Context g;

    public static final class a {
    }

    public static final class b extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
        public TextView a;
        public ImageView b;
        public int c;
        public float d;
        public ValueAnimator e;

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.c != 1) goto L5;
            ValueAnimator r0 = this.e;
            Intrinsics.checkNotNull(r0);
            r0.start();
            return;
        L5:
            ValueAnimator r1 = this.e;
            Intrinsics.checkNotNull(r1);
            r1.cancel();
        }

        public b(Context r7) {
            Intrinsics.checkNotNullParameter(r7, "context");
            super(r7);
            this.c = -1;
            float r0 = j08.b.a(getContext(), 124);
            float r1 = j08.b.a(getContext(), 40);
            FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
            setMinimumWidth((int) r0);
            setMinimumHeight((int) r1);
            r2.gravity = 81;
            setLayoutParams(r2);
            int r3 = (int) j08.b.a(getContext(), 5.0f);
            int r4 = r3 * 4;
            setPadding(r4, r3, r4, r3);
            int r5 = (int) j08.b.a(getContext(), 20.0f);
            FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(r5, r5);
            this.b = new ImageView(getContext());
            TextView r8 = new TextView(getContext());
            r8.setTextColor(-1);
            r8.setTextSize(14.0f);
            r8.setMaxLines(4);
            r8.setEllipsize(TextUtils.TruncateAt.END);
            this.a = r8;
            FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
            r9.setMarginStart((int) j08.b.a(getContext(), 10.0f));
            LinearLayout r10 = new LinearLayout(getContext());
            r10.setGravity(16);
            r10.setOrientation(0);
            FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
            r11.gravity = 17;
            r10.addView(this.b, r6);
            r10.addView(this.a, r9);
            addView(r10, r11);
            GradientDrawable r12 = new GradientDrawable();
            r12.setShape(0);
            r12.setColor(j08.b.b(getContext().getResources().getColor(2131103451), 1.0f));
            r12.setCornerRadius(j08.b.a(getContext(), 50));
            setBackground(r12);
            ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
            r13.addUpdateListener(this);
            r13.setDuration(1000);
            r13.setRepeatMode(1);
            r13.setRepeatCount(-1);
            r13.setInterpolator(new LinearInterpolator());
            this.e = r13;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Float");
            this.d = ((Float) r3).floatValue();
            if (this.c != 1) goto L5;
            ImageView r4 = this.b;
            Intrinsics.checkNotNull(r4);
            r4.setRotation(this.d);
        L5:
            postInvalidate();
        }
    }

    public static final class c extends Handler {
        public final WeakReference<LKUILoadingToastImpl> a;

        public c(WeakReference<LKUILoadingToastImpl> r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            super(Looper.getMainLooper());
            this.a = r2;
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [android.app.Dialog, com.larksuite.component.ui.toast.loading.LKUILoadingToastImpl, java.lang.Object] */
        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            switch(r4.what) {
                case 61441: goto L17;
                case 61442: goto L5;
                default: goto L51;
            };
        L5:
            LKUILoadingToastImpl r5 = this.a.get();
            if (r5 == null) goto L38;
            Context r0 = r5.g;
            if ((r0 instanceof Activity) == false) goto L13;
            if (((Activity) r0).isFinishing() == false) goto L13;
            return;
        L13:
            if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L42;
            DialogLancet.handleBlockedDialogShow(r5);
            return;
        L42:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
        L16:
            DialogLancet.beforeDialogShow(r5);
            r5.show();
            DialogLancet.afterDialogShow(r5);
            return;
        L38:
            return;
        L17:
            LKUILoadingToastImpl r6 = this.a.get();
            if (r6 == 0) goto L47;
            int r1 = LKUILoadingToastImpl.h;
            if (r6.isShowing() == false) goto L48;
            Handler r2 = DialogLancet.resolveDialogHandler(r6);
            if (r2 != null) goto L24;
        L26:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L29 Exception -> L31
        L35:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L29:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L31:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L29
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L29
            if (r3 == null) goto L35;
            d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L29
            goto L35
        L24:
            if (Looper.myLooper() == r2.getLooper()) goto L26;
            r2.post(DialogLancet.createDismissRunnable(r6));
            return;
        L48:
            return;
        L47:
            return;
        }
    }

    static {
    }

    @Override // com.larksuite.component.ui.dialog.LKUIDialog
    public final void cancel() {
        Message r0 = Message.obtain(this.e, 61441);
        this.e.sendMessageDelayed(r0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.ui.dialog.LKUIDialog, com.larksuite.component.universe_design.dialog.UDDialog
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        ValueAnimator r1 = this.f.e;
        if (r1 == null) goto L26;
        Intrinsics.checkNotNull(r1);
        r1.cancel();
        return;
    L26:
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.e.removeMessages(61441);
        i08.a.a();
    }

    public LKUILoadingToastImpl(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, 2131952409);
        this.d = true;
        this.e = new c(new WeakReference(this));
        this.g = r3;
        this.f = new b(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.ui.dialog.LKUIDialog, com.larksuite.component.universe_design.dialog.UDDialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        b r5 = this.f;
        setContentView(r5, r5.getLayoutParams());
        setCanceledOnTouchOutside(!this.d);
        setCancelable(!this.d);
        if (this.d == true) goto L7;
        Window r6 = getWindow();
        if (r6 == null) goto L7;
        r6.setFlags(8, 8);
    L7:
        Window r7 = getWindow();
        Intrinsics.checkNotNull(r7);
        WindowManager.LayoutParams r8 = r7.getAttributes();
        int r0 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f.measure(r0, r0);
        Integer r1 = i08.c.a;
        Context r2 = getContext();
        Intrinsics.checkNotNullParameter(r2, "context");
        if (i08.c.b != null) goto L10;
        Toast r3 = new Toast(r2);
        i08.c.a = Integer.valueOf(r3.getYOffset());
        i08.c.b = Integer.valueOf(r3.getGravity());
    L10:
        Integer r9 = i08.c.b;
        Intrinsics.checkNotNull(r9);
        r8.gravity = r9.intValue();
        Context r10 = getContext();
        Intrinsics.checkNotNullParameter(r10, "context");
        if (i08.c.a != null) goto L13;
        Toast r11 = new Toast(r10);
        i08.c.a = Integer.valueOf(r11.getYOffset());
        i08.c.b = Integer.valueOf(r11.getGravity());
    L13:
        Integer r12 = i08.c.a;
        Intrinsics.checkNotNull(r12);
        r8.y = r12.intValue() + ((int) j08.b.a(getContext(), 40.0f));
        Window r13 = getWindow();
        if (r13 == null) goto L17;
        r13.setAttributes(r8);
        return;
    }
}
