package com.ss.android.lark.keyboard.biz.voice.inject;

import android.widget.EditText;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Runnable {
    public final /* synthetic */ VoiceInputPreviewDelegate a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ VoiceInputPreviewDelegate.PreviewOriginMode d;

    public g(VoiceInputPreviewDelegate r1, boolean r2, EditText r3, VoiceInputPreviewDelegate.PreviewOriginMode r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        if (((Boolean) this.a.d.invoke()).booleanValue() == false) goto L6;
        return;
    L6:
        if (this.b == false) goto L9;
        this.c.requestFocus();
        KeyboardUtils.showKeyboard(this.c);
        return;
    L9:
        if (this.d != VoiceInputPreviewDelegate.PreviewOriginMode.VOICE_MODE) goto L11;
        this.a.c.invoke();
        return;
    L11:
        this.c.clearFocus();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
