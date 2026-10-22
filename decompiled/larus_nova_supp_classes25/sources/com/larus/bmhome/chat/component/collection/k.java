package com.larus.bmhome.chat.component.collection;

import android.view.View;
import com.larus.bmhome.chat.larkforward.IChatLarkForwardService;
import com.larus.bmhome.chat.t2;
import com.larus.platform.model.MessageCollection;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements View.OnClickListener {
    public final /* synthetic */ ChatCollectMessageComponent a;

    public /* synthetic */ k(ChatCollectMessageComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        ChatCollectMessageComponent r14 = this.a;
        int r0 = ChatCollectMessageComponent.v;
        String r1 = r14.Y2();
        ConcurrentHashMap<String, MessageCollection> r2 = t2.a;
        boolean r3 = true;
        String r4 = null;
        if (r1 == null) goto L11;
        if ((!StringsKt.isBlank(r1)) == false) goto L7;
        String r5 = r1;
    L8:
        if (r5 == null) goto L11;
        r4 = t2.b.get(r5);
        goto L11
    L7:
        r5 = null;
    L11:
        if (r4 != null) goto L14;
        FLogger.a.w("ChatCollectMessageComponent", "forward readonly preview failed, host message ref missing, collectionId=" + r1);
        s.j(s.a, r14.getContext(), r14.getContext().getString(2131908171), null, false, 28);
        return;
    L14:
        if (((IChatLarkForwardService) r14.s.getValue()) != null) goto L36;
        FLogger.a.w("ChatCollectMessageComponent", "forward readonly preview failed, office service missing, collectionId=" + r1);
        s.j(s.a, r14.getContext(), r14.getContext().getString(2131908171), null, false, 28);
        return;
    L36:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L24
        IChatLarkForwardService r7 = (IChatLarkForwardService) r14.s.getValue();     // Catch: Throwable -> L24
        if (r7 != null) goto L19;
    L21:
        r3 = false;
    L22:
        Object r8 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L24
    L26:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L29;
        FLogger.a.e("ChatCollectMessageComponent", "forward readonly preview failed, collectionId=" + r1, r9);
        s.j(s.a, r14.getContext(), r14.getContext().getString(2131908171), null, false, 28);
    L29:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L33;
        r8 = r10;
    L33:
        if (((Boolean) r8).booleanValue() == true) goto L40;
        s.j(s.a, r14.getContext(), r14.getContext().getString(2131908171), null, false, 28);
        return;
    L40:
        return;
    L19:
        if (r7.G(r14.getContext(), r4) != true) goto L21;
    L24:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
