package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.app.Activity;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.uaigc.impl.databinding.LarusFragmentCreationPageBinding;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t0 implements ChatConstraintLayout.b {
    public final /* synthetic */ ImageSelectorComponent a;

    public final void onUpdate(int r1) {
    }

    public final void a() {
        ImageSelectorComponent r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        Activity r2 = ImageSelectorComponent.h3(r0);     // Catch: Throwable -> L21
        boolean r3 = true;
        if (r2 != null) goto L6;
    L8:
        boolean r4 = false;
    L9:
        if (r4 == true) goto L19;
        LarusFragmentCreationPageBinding r5 = r0.d4();     // Catch: Throwable -> L21
        if (r5 == null) goto L17;
        ChatConstraintLayout r6 = r5.e;     // Catch: Throwable -> L21
        if (r6 == null) goto L17;
        if (ViewExtKt.h(r6) != true) goto L17;
    L18:
        r0.C3(r3);     // Catch: Throwable -> L21
        r0.B3(r3);     // Catch: Throwable -> L21
    L17:
        r3 = false;
    L19:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
        return;
    L6:
        if (r2.isFinishing() != true) goto L8;
        r4 = true;
    L21:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void b() {
        ImageSelectorComponent r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        Activity r2 = ImageSelectorComponent.h3(r0);     // Catch: Throwable -> L21
        boolean r3 = true;
        if (r2 != null) goto L6;
    L8:
        boolean r4 = false;
    L9:
        if (r4 == true) goto L19;
        LarusFragmentCreationPageBinding r5 = r0.d4();     // Catch: Throwable -> L21
        if (r5 == null) goto L17;
        ChatConstraintLayout r6 = r5.e;     // Catch: Throwable -> L21
        if (r6 == null) goto L17;
        if (ViewExtKt.h(r6) != true) goto L17;
    L18:
        r0.C3(r3);     // Catch: Throwable -> L21
        r0.B3(r3);     // Catch: Throwable -> L21
    L17:
        r3 = false;
    L19:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
        return;
    L6:
        if (r2.isFinishing() != true) goto L8;
        r4 = true;
    L21:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public t0(ImageSelectorComponent r1) {
        this.a = r1;
    }
}
