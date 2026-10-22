package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.text.Editable;
import android.view.View;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ VoiceActionAreaUseCase a;
    public final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a b;

    public b(VoiceActionAreaUseCase r1, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        ImmersiveVoiceViewModel r7 = this.a.e();
        Editable r0 = this.b.a().getText();
        if (r0 == null) goto L19;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        boolean r3 = true;
        if (r0.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == true) goto L19;
    L20:
        r7.whenClickCancel(r3, ExtensionEditTextCompatKt.f(this.b.a()), ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) this.b.a().q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).m(0, this.b.a().length()));
        return;
    L10:
        if (StringsKt.trim(r0).length() != 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        r1 = false;
        goto L17
    L12:
        r4 = false;
        goto L13
    L7:
        r2 = false;
    L19:
        r3 = false;
        goto L20
    }
}
