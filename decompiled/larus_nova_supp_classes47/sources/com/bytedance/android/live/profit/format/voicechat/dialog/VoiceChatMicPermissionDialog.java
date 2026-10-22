package com.bytedance.android.live.profit.format.voicechat.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.bpea.cert.token.TokenCert;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/dialog/VoiceChatMicPermissionDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatMicPermissionDialog extends CommonBottomDialog {
    public static final TokenCert b = null;
    public static final List<String> c = null;
    public Function1<? super Boolean, Unit> a;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VoiceChatMicPermissionDialog a;

        public b(VoiceChatMicPermissionDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Function1<? super Boolean, Unit> r5 = this.a.a;
            if (r5 == null) goto L5;
            Unit r6 = (Unit) r5.invoke(Boolean.TRUE);
        L5:
            CommonBottomDialog r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r1 == null) goto L19;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L8:
            if (Looper.myLooper() == r0.getLooper()) goto L10;
            r0.post(DialogLancet.createDismissRunnable(r7));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ VoiceChatMicPermissionDialog a;

        public c(VoiceChatMicPermissionDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Function1<? super Boolean, Unit> r5 = this.a.a;
            if (r5 == null) goto L5;
            Unit r6 = (Unit) r5.invoke(Boolean.FALSE);
        L5:
            CommonBottomDialog r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r1 == null) goto L19;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L8:
            if (Looper.myLooper() == r0.getLooper()) goto L10;
            r0.post(DialogLancet.createDismissRunnable(r7));
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ VoiceChatMicPermissionDialog a;

        public d(VoiceChatMicPermissionDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            Function1<? super Boolean, Unit> r3 = this.a.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke(Boolean.FALSE);
            return;
        }
    }

    public final int getLayoutId() {
        return 2131566026;
    }

    static {
        b = TokenCert.Companion.with("bpea-live_format_voice_chat_audio_permission");
        c = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
    }

    public VoiceChatMicPermissionDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        View r3 = findViewById(2131392693);
        if (r3 == null) goto L5;
        r3.setOnClickListener(new b(this));
    L5:
        View r4 = findViewById(2131392694);
        if (r4 == null) goto L8;
        r4.setOnClickListener(new c(this));
    L8:
        setOnCancelListener(new d(this));
    }
}
