package com.bytedance.android.livesdk.chatroom.widget.unionlive;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.livesdk.chatroom.ui.r5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.message.model.om;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends Dialog {
    public View a;
    public Disposable b;
    public TextView c;
    public final Activity d;
    public final om e;

    public final void a() {
        Window r0 = getWindow();
        if (r0 == null) goto L9;
        WindowManager.LayoutParams r1 = r0.getAttributes();
        if (r1 == null) goto L7;
        r1.y = UtilityKotlinExtentionsKt.i(50);
    L7:
        r0.setAttributes(r0.getAttributes());
        r0.setType(BubbleId.PadCast);
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Disposable r1 = this.b;
        if (r1 == null) goto L26;
        r1.dispose();
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        a();
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

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return this.d.dispatchKeyEvent(r2);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        final Map.Entry r1 = null;
        this.a = LayoutInflater.from(this.d).inflate(2131567549, null, false);
        Window r7 = getWindow();
        if (r7 == null) goto L5;
        r7.requestFeature(1);
        a();
        r7.setDimAmount(0.0f);
        r7.setGravity(80);
        r7.setFlags(32, 32);
        r7.setFlags(262144, 262144);
    L5:
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        View r8 = this.a;
        if (r8 == null) goto L49;
        setContentView(r8);
        this.c = (TextView) findViewById(2131390479);
        ImageView r9 = (ImageView) findViewById(2131366972);
        if (r9 == null) goto L10;
        r9.setOnClickListener(new a(this));
    L10:
        String r10 = this.e.getText();
        Map r0 = this.e.E();
        if (r0 == null) goto L13;
        r1 = z0.a(r0);
    L13:
        if (r1 != null) goto L15;
    L27:
        TextView r2 = this.c;
        if (r2 == null) goto L30;
        r2.setText(r10);
    L30:
        int r11 = View.MeasureSpec.makeMeasureSpec(s1.y(), 1073741824);
        int r3 = View.MeasureSpec.makeMeasureSpec(0, 0);
        View r4 = this.a;
        if (r4 == null) goto L33;
        r4.measure(r11, r3);
    L33:
        View r12 = this.a;
        if (r12 == null) goto L36;
        int r13 = r12.getMeasuredHeight();
    L37:
        Window r5 = getWindow();
        if (r5 == null) goto L40;
        r5.setLayout(-1, r13);
    L40:
        Disposable r14 = this.b;
        if (r14 == null) goto L44;
        r14.dispose();
    L44:
        if (this.e.getDuration() <= 0) goto L46;
        long r15 = this.e.getDuration();
    L47:
        this.b = Observable.timer(r15, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    L46:
        r15 = 5;
        goto L47
    L36:
        r13 = -2;
        goto L37
    L15:
        if (r1.getKey() == null) goto L27;
        if (r1.getValue() == null) goto L27;
        String r16 = (String) r1.getKey();
        SpannableStringBuilder r17 = new SpannableStringBuilder(r10).append(r16);
        r17.setSpan(new r5(-65536, new UnionGuestBottomNoticeDialog$initView$clickSpan$1(this, r1)), r17.length() - r16.length(), r17.length(), 33);
        TextView r18 = this.c;
        if (r18 == null) goto L21;
        r18.setHighlightColor(0);
    L21:
        TextView r19 = this.c;
        if (r19 == null) goto L24;
        r19.setMovementMethod(LinkMovementMethod.getInstance());
    L24:
        TextView r20 = this.c;
        if (r20 == null) goto L30;
        r20.setText(r17);
        goto L30
    }

    public c(FragmentActivity r2, om r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "data");
        super(r2, 2131954802);
        this.d = r2;
        this.e = r3;
    }
}
