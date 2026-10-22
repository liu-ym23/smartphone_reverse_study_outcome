package com.obric.assistant.interaction.impl.window;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.AssistantWindowHideReason;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/AssistantChatDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "toastContextWrapper", "getToastContextWrapper", "()Landroid/content/Context;", "setToastContextWrapper", "isInteractiveState", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setInteractive", "isInteractive", "", "onBackPressed", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onStart", "onStop", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantChatDialog extends Dialog {
    public static final Companion Companion = null;
    private static final String TAG = "AssistantChatDialog";
    private final AtomicBoolean isInteractiveState;
    private Context toastContextWrapper;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/AssistantChatDialog$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        FLogger.a.i(TAG, "onBackPressed");
        if (WindowHost.INSTANCE.dispatchBackPressed() == false) goto L5;
        return;
    L5:
        AssistantWindowHideReason.INSTANCE.setNext("back_pressed");
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L9;
        IAssistantChatWindow$DefaultImpls.stash$default(r0, null, 1, null);
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger.a.i(TAG, "onAttachedToWindow");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.a.i(TAG, "onDetachedFromWindow");
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        FLogger.a.i(TAG, "onStart");
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        FLogger.a.i(TAG, "onStop");
    }

    public final Context getToastContextWrapper() {
        return this.toastContextWrapper;
    }

    public AssistantChatDialog(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.isInteractiveState = new AtomicBoolean(true);
        FLogger.a.i(TAG, "init");
        Window r4 = getWindow();
        if (r4 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        int r0 = 2038;
    L8:
        r4.setType(r0);
        return;
    L7:
        r0 = ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR;
        goto L8
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_AssistantChatDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        FLogger.a.i(TAG, "onCreate");
        Window r6 = getWindow();
        if (r6 == null) goto L19;
        WindowManager.LayoutParams r1 = r6.getAttributes();
        r1.setTitle("obric-assistant-window");
        r6.setAttributes(r1);
        r6.setBackgroundDrawable(new ColorDrawable(0));
        r6.setLayout(-1, -1);
        r6.setDimAmount(0.0f);
        r6.addFlags(-2147221216);
        r6.setSoftInputMode(16);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_AssistantChatDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r6).setSystemUiVisibility(1792);
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r6.getAttributes().layoutInDisplayCutoutMode = 1;
    L7:
        r6.setWindowAnimations(0);
        r6.setGravity(8388659);
        WindowManager.LayoutParams r2 = r6.getAttributes();
        WindowUtils r3 = WindowUtils.INSTANCE;
        Intrinsics.checkNotNull(r2);
        r3.disableMoveAnimationReflectively(r2);
        r6.setAttributes(r2);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(Boolean.valueOf(t9a.b.b().windowManager().c(r6)));     // Catch: Throwable -> L10
    L12:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L15;
        FLogger.a.w(TAG, "setAssistantWindowInKeyguardMode failed", r8);
    L15:
        Result.box-impl(r7);
        return;
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getActionMasked() != 4) goto L9;
        if (WindowHost.INSTANCE.onDialogOutsideTouch$impl_mainlandRelease(this, r4.getRawX(), r4.getRawY()) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r4);
    }

    public final void setInteractive(boolean r7) {
        if (this.isInteractiveState.compareAndSet(!r7, r7) == false) goto L22;
        FLogger r0 = FLogger.a;
        r0.i(TAG, "setInteractive: " + r7);
        Window r1 = getWindow();
        if (r1 == null) goto L18;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        if (r7 == false) goto L9;
        r2.flags = (r2.flags & (-17)) & (-9);
    L20:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Object r4 = getContext().getSystemService("window");     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Throwable -> L12
        ((WindowManager) r4).updateViewLayout(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_AssistantChatDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1), r2);     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L17;
        FLogger.a.w(TAG, "setInteractive updateViewLayout failed: isInteractive=" + r7, r6);
    L17:
        Result.box-impl(r5);
        return;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L9:
        r2.flags = (r2.flags | 16) | 8;
        goto L20
    L18:
        r0.w(TAG, "setInteractive: window is null");
        return;
    }

    public final void setToastContextWrapper(Context r1) {
        this.toastContextWrapper = r1;
    }
}
