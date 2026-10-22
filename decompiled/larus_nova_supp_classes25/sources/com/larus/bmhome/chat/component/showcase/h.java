package com.larus.bmhome.chat.component.showcase;

import android.widget.LinearLayout;
import com.larus.chat.common.databinding.LarusPageChatBottomCaseBinding;
import com.larus.platform.model.showcase.Case;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ ChatCaseMessageComponent a;

    public /* synthetic */ h(ChatCaseMessageComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        ChatCaseMessageComponent r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        int r1 = ChatCaseMessageComponent.z;
        r0.getClass();
        FLogger.a.i("ChatCaseMessageComponent", "onPlayStateChanged, isPlaying=" + r6);
        if (r6 == true) goto L15;
        LarusPageChatBottomCaseBinding r7 = r0.n;
        if (r7 == null) goto L9;
        LinearLayout r8 = r7.a;
        if (r8 == null) goto L9;
        e1.h(r8, 300);
    L9:
        String r9 = r0.Y2();
        Case r2 = r0.mz(false);
        if (r2 == null) goto L12;
        String r3 = r2.getRequestId();
    L13:
        tx9.w.b("continue_talk", r3, r9);
        goto L15
    L12:
        r3 = null;
    L15:
        return Unit.INSTANCE;
    }
}
