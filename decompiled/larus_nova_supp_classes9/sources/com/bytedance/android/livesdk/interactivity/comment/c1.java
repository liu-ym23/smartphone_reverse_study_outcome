package com.bytedance.android.livesdk.interactivity.comment;

import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.interactivity.comment.audio.LiveAudioResendDialog;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c1 implements Consumer<u22.c> {
    public final /* synthetic */ CommentWidget a;

    public c1(CommentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        u22.c r5 = (u22.c) r4;
        CommentWidget r0 = this.a;
        if (r0.y != null) goto L6;
        return;
    L6:
        if (r0.isScreenPortrait() == false) goto L16;
        AppCompatDialog r1 = new LiveAudioResendDialog(((Widget) r0).context, r5, r0.y);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return;
    }
}
