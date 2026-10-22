package com.bytedance.android.livesdk.interactivity.comment.audio;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.interactivity.comment.CommentPresenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/audio/LiveAudioResendDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAudioResendDialog extends AppCompatDialog implements View.OnClickListener {
    public final Lazy a;
    public final Lazy b;
    public final u22.c c;
    public CommentPresenter d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        Intrinsics.checkNotNullParameter(r13, "v");
        if (r13.getId() != 2131391296) goto L10;
        u22.c r14 = this.c;
        if (r14.c == false) goto L7;
        xs2.b r15 = xs2.b.a();
        u22.c r1 = this.c;
        r15.post(new u22.a(r1.a, r1.b));
        goto L10
    L7:
        CommentPresenter r5 = this.d;
        if (r5 == null) goto L10;
        r5.j0(r14.a, r14.b, true, false);
    L10:
        this.d = null;
        Handler r16 = DialogLancet.resolveDialogHandler(this);
        if (r16 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(this);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r17 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r17 == null) goto L24;
        com.bytedance.crash.d.d(r17, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r16.getLooper()) goto L15;
        r16.post(DialogLancet.createDismissRunnable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setGravity(80);
    L5:
        setContentView(LayoutInflater.from(getContext()).inflate(2131565393, null));
        Window r5 = getWindow();
        if (r5 == null) goto L8;
        r5.setLayout(-1, -2);
    L8:
        TextView r6 = (TextView) this.a.getValue();
        if (r6 == null) goto L11;
        r6.setOnClickListener(this);
    L11:
        TextView r7 = (TextView) this.b.getValue();
        if (r7 == null) goto L15;
        r7.setOnClickListener(this);
        return;
    }

    public LiveAudioResendDialog(Context r2, u22.c r3, CommentPresenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "failureEvent");
        super(r2, 2131954639);
        this.c = r3;
        this.d = r4;
        this.a = LazyKt.lazy(new LiveAudioResendDialog$resendView$2(this));
        this.b = LazyKt.lazy(new LiveAudioResendDialog$cancelView$2(this));
    }
}
