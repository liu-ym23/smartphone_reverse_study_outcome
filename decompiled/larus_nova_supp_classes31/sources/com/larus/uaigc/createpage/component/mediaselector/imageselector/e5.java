package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.uaigc.impl.databinding.LarusFragmentCreationPageBinding;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e5 implements ChatConstraintLayout.b {
    public final /* synthetic */ TransparentSelectorComponent a;

    public final void onUpdate(int r1) {
    }

    public final void a() {
        TransparentSelectorComponent r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        if (s1a.a.getActivity(r0).isFinishing() == true) goto L14;
        LarusFragmentCreationPageBinding r2 = (LarusFragmentCreationPageBinding) r0.o.getValue();     // Catch: Throwable -> L16
        if (r2 == null) goto L12;
        ChatConstraintLayout r3 = r2.e;     // Catch: Throwable -> L16
        if (r3 == null) goto L12;
        boolean r4 = true;
        if (ViewExtKt.h(r3) != true) goto L12;
    L13:
        TransparentSelectorComponent.Y2(r0, r4);     // Catch: Throwable -> L16
    L12:
        r4 = false;
    L14:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void b() {
        if (s1a.a.getActivity(this.a).isFinishing() == true) goto L14;
        LarusFragmentCreationPageBinding r0 = (LarusFragmentCreationPageBinding) this.a.o.getValue();
        if (r0 == null) goto L11;
        ChatConstraintLayout r1 = r0.e;
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (ViewExtKt.h(r1) != true) goto L11;
    L12:
        TransparentSelectorComponent.Y2(this.a, r2);
        return;
    L11:
        r2 = false;
        goto L12
    }

    public e5(TransparentSelectorComponent r1) {
        this.a = r1;
    }
}
