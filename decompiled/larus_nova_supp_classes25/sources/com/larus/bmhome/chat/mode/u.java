package com.larus.bmhome.chat.mode;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u implements View.OnLayoutChangeListener {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ u(ModeSwitchComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        final ModeSwitchComponent r10 = this.a;
        int r11 = ModeSwitchComponent.k0;
        u7 r12 = r10.z3();
        if (r12 == null) goto L5;
        MessageAdapter r13 = r12.MF();
    L7:
        if ((r13 instanceof MessageAdapter) == true) goto L11;
        r13 = null;
    L11:
        if (r10.H == true) goto L18;
        if (r13 == null) goto L19;
        r10.H = true;
        r10.I = r13;
        r13.p1(r10.T);
        MutableLiveData<Boolean> r14 = r13.y;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r14.observe(com.larus.ui.arch.component.internal.attach.a.b(r10, r10).getViewLifecycleOwner(), new ModeSwitchComponent$c(new y(r10)));
        u r15 = r10.K;
        if (r15 == null) goto L16;
        r1.removeOnLayoutChangeListener(r15);
    L16:
        r10.J = null;
        r10.K = null;
        r10.G3();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r13 = null;
        goto L7
    }
}
