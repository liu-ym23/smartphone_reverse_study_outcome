package com.larus.bmhome.chat.component.showcase;

import android.widget.LinearLayout;
import com.larus.chat.common.databinding.LarusPageChatBottomPlaybackBinding;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u implements Function1 {
    public final /* synthetic */ ChatPlaybackComponent a;

    public /* synthetic */ u(ChatPlaybackComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ChatPlaybackComponent r0 = this.a;
        if (((Boolean) r4).booleanValue() == false) goto L9;
        LarusPageChatBottomPlaybackBinding r5 = r0.p;
        if (r5 == null) goto L15;
        LinearLayout r6 = r5.a;
        if (r6 == null) goto L15;
        e1.h(r6, 300);
    L15:
        return Unit.INSTANCE;
    L9:
        LarusPageChatBottomPlaybackBinding r7 = r0.p;
        if (r7 == null) goto L15;
        LinearLayout r8 = r7.a;
        if (r8 == null) goto L15;
        e1.i(r8, 300);
        goto L15
    }
}
