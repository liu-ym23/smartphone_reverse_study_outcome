package com.larus.asr.direct;

import com.larus.bmhome.chat.component.bottom.core.speaker.e;
import com.larus.bmhome.chat.component.bottom.core.speaker.f;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AsrDirectFillComponent$c implements e.b {
    public final /* synthetic */ AsrDirectFillComponent a;

    public final void A9() {
        AsrDirectFillComponent r0 = this.a;
        int r1 = AsrDirectFillComponent.A;
        l r2 = r0.U2();
        if (r2 == null) goto L6;
        r2.A9();
        return;
    }

    public AsrDirectFillComponent$c(AsrDirectFillComponent r1) {
        this.a = r1;
    }

    public final void B9(f r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        AsrDirectFillComponent r0 = this.a;
        int r1 = AsrDirectFillComponent.A;
        l r2 = r0.U2();
        if (r2 == null) goto L6;
        r2.e8(r3);
        return;
    }

    public final void C9(f r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        AsrDirectFillComponent r0 = this.a;
        int r1 = AsrDirectFillComponent.A;
        l r2 = r0.U2();
        if (r2 == null) goto L6;
        r2.B9(r3);
        return;
    }

    public final void D9(Function1<? super String, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "handle");
        AsrDirectFillComponent r0 = this.a;
        int r1 = AsrDirectFillComponent.A;
        l r2 = r0.U2();
        if (r2 == null) goto L6;
        l.a.b(r2, r3);
        return;
    }
}
