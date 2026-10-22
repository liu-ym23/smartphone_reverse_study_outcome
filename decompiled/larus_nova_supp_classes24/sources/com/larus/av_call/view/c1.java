package com.larus.av_call.view;

import com.larus.common_ui.widget.UrlSpanTextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c1 implements UrlSpanTextView.a {
    public final /* synthetic */ VoiceCallBottomLayout a;
    public final /* synthetic */ Function0<Unit> b;

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        if (Intrinsics.areEqual(r2, "pp") == false) goto L6;
        this.a.l8();
        this.b.invoke();
        return;
    }

    public c1(VoiceCallBottomLayout r1, com.larus.voicecall.impl.component.denoise.u r2) {
        this.a = r1;
        this.b = r2;
    }
}
