package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/TalkOnlineGuestClickOptionDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Option", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TalkOnlineGuestClickOptionDialog extends CommonBottomDialog {
    public final Boolean a;
    public final Boolean b;
    public final Function1<Option, Unit> c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/TalkOnlineGuestClickOptionDialog$Option;", "", "CHANGE_POSITION", "INVITE_FRIENDS", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Option extends Enum<Option> {
        public static final Option CHANGE_POSITION = null;
        public static final Option INVITE_FRIENDS = null;
        public static final /* synthetic */ Option[] a = null;

        static {
            Option r1 = new Option("CHANGE_POSITION", 0);
            CHANGE_POSITION = r1;
            Option r2 = new Option("INVITE_FRIENDS", 1);
            INVITE_FRIENDS = r2;
            a = new Option[]{r1, r2};
        }

        public static Option valueOf(String r1) {
            return (Option) r27.a.a(Option.class, r1);
        }

        public static Option[] values() {
            return (Option[]) a.clone();
        }

        public Option(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TalkOnlineGuestClickOptionDialog a;

        public a(TalkOnlineGuestClickOptionDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.c.invoke(Option.CHANGE_POSITION);
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TalkOnlineGuestClickOptionDialog a;

        public b(TalkOnlineGuestClickOptionDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.c.invoke(Option.INVITE_FRIENDS);
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TalkOnlineGuestClickOptionDialog a;

        public c(TalkOnlineGuestClickOptionDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
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
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public final int getLayoutId() {
        return 2131565558;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Boolean r5 = this.a;
        if (r5 != null) goto L5;
    L9:
        Boolean r6 = this.b;
        if (r6 != null) goto L12;
    L16:
        View r7 = findViewById(2131390293);
        if (r7 == null) goto L19;
        r7.setOnClickListener(new a(this));
    L19:
        View r8 = findViewById(2131390812);
        if (r8 == null) goto L22;
        r8.setOnClickListener(new b(this));
    L22:
        View r9 = findViewById(2131390273);
        if (r9 == null) goto L26;
        r9.setOnClickListener(new c(this));
        return;
    L26:
        return;
    L12:
        if (r6.booleanValue() == true) goto L16;
        View r10 = findViewById(2131390812);
        if (r10 == null) goto L16;
        r10.setVisibility(8);
        goto L16
    L5:
        if (r5.booleanValue() == true) goto L9;
        View r11 = findViewById(2131390293);
        if (r11 == null) goto L9;
        r11.setVisibility(8);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TalkOnlineGuestClickOptionDialog(Context r2, Boolean r3, Boolean r4, Function1<? super Option, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
