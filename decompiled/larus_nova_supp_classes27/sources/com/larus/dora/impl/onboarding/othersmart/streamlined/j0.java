package com.larus.dora.impl.onboarding.othersmart.streamlined;

import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedWakeupBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j0<T> implements FlowCollector {
    public final /* synthetic */ DoraHStreamlinedWakeupFragment a;

    public j0(DoraHStreamlinedWakeupFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r9, Continuation r10) {
        String r11 = (String) r9;
        g49.d.d("DoraHStreamlinedWakeupFragment", "avatarUrlFlow collect: " + r11);
        if (r11 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L16;
        LarusDoraHSimplifiedWakeupBinding r1 = this.a.q;
        if (r1 == null) goto L16;
        CircleSimpleDraweeView r2 = r1.b;
        if (r2 == null) goto L16;
        CircleSimpleDraweeView.f(r2, com.larus.image.loader.b0.a(r11, "chat.user_avatar", false, false, 6), null, null, 0, 0, 62);
    L16:
        return Unit.INSTANCE;
    L5:
        if (r11.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
