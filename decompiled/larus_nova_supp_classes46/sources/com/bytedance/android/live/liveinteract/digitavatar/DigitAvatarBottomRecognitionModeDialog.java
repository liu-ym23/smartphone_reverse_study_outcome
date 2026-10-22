package com.bytedance.android.live.liveinteract.digitavatar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarBottomRecognitionModeDialog;", "Lcom/bytedance/android/livesdk/common/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DigitAvatarBottomRecognitionModeDialog extends com.bytedance.android.livesdk.common.b implements Observer<KVData> {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final PopupMenu.OnMenuItemClickListener h;
    public final PopupMenu.OnMenuItemClickListener i;
    public final PopupMenu.OnMenuItemClickListener j;
    public final PopupMenu.OnMenuItemClickListener k;
    public final PopupMenu.OnMenuItemClickListener l;
    public final DataCenter m;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.m.removeObserver(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        super.onStart();
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setWindowAnimations(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("cmd_dismiss_digit_avatar_recogntion_mode_dialog", r4.getKey()) == false) goto L27;
        Handler r5 = DialogLancet.resolveDialogHandler(this);
        if (r5 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r6 == null) goto L20;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r5.getLooper()) goto L11;
        r5.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super/*android.app.Dialog*/.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setBackgroundDrawable(new ColorDrawable(0));
        r4.setGravity(80);
        r4.setLayout(-1, -2);
    L5:
        setContentView(LayoutInflater.from(getContext()).inflate(2131565408, null));
        ((TextView) this.b.getValue()).setOnClickListener(new b(this));
        ((ImageView) this.c.getValue()).setOnClickListener(new c(this));
        ((TextView) this.d.getValue()).setOnClickListener(new d(this));
        ((ImageView) this.e.getValue()).setOnClickListener(new e(this));
        ((TextView) this.f.getValue()).setOnClickListener(new f(this));
        ((TextView) this.g.getValue()).setOnClickListener(new g(this));
        this.m.observe("cmd_dismiss_digit_avatar_recogntion_mode_dialog", this);
    }

    public DigitAvatarBottomRecognitionModeDialog(Context r2, m.a r3, m.b r4, m.c r5, m.d r6, m.e r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "optionActionPhoto");
        Intrinsics.checkNotNullParameter(r4, "optionActionCamera");
        Intrinsics.checkNotNullParameter(r5, "optionActionDefault");
        Intrinsics.checkNotNullParameter(r6, "optionActionRecognitionRule");
        Intrinsics.checkNotNullParameter(r7, "cancelAction");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        super(r2, true);
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.b = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$tvRecognitionPhoto$2(this));
        this.c = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$recognitionRuleForPhoto$2(this));
        this.d = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$tvRecognitionCamera$2(this));
        this.e = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$recognitionRuleForCamera$2(this));
        this.f = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$tvRecognitionDefault$2(this));
        this.g = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$cancelView$2(this));
    }
}
