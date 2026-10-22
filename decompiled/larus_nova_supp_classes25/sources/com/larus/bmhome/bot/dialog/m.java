package com.larus.bmhome.bot.dialog;

import android.view.KeyEvent;
import android.widget.TextView;
import com.larus.bmhome.databinding.LarusDialogNicknameInputBottomBinding;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m implements TextView.OnEditorActionListener {
    public final /* synthetic */ BotNickNameEditDialog a;

    public m(BotNickNameEditDialog r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r2, int r3, KeyEvent r4) {
        if (r3 != 6) goto L16;
        FLogger r5 = FLogger.a;
        int r6 = BotNickNameEditDialog.n;
        r5.d("BotNickNameEditDialog", "onEditorAction : IME_ACTION_DONE");
        LarusDialogNicknameInputBottomBinding r7 = this.a.d;
        LarusDialogNicknameInputBottomBinding r8 = null;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        if (r7.d.isEnabled() == false) goto L18;
        BotNickNameEditDialog r9 = this.a;
        LarusDialogNicknameInputBottomBinding r0 = r9.d;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        r9.W90(r8.e.getText().toString());
        return true;
    L12:
        r8 = r0;
        goto L13
    L18:
        return true;
    L16:
        return false;
    }
}
