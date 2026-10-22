package com.larus.bmhome.chat.component.feedback;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements y.a<BotModel> {
    public final /* synthetic */ BotFeedbackComponent a;

    public g(BotFeedbackComponent r1) {
        this.a = r1;
    }

    public final void c(Object r13) {
        BotModel r14 = (BotModel) r13;
        Intrinsics.checkNotNullParameter(r14, "new");
        BotFeedbackComponent r0 = this.a;
        r0.o = r14;
        BotCreatorInfo r1 = r14.getBotCreatorInfo();
        List r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getId();
    L6:
        r0.p = Intrinsics.areEqual(r3, this.a.n);
        BotFeedbackComponent r4 = this.a;
        BotModel r5 = r4.o;
        boolean r6 = false;
        if (r5 == null) goto L14;
        Integer r7 = r5.getPrivateStatus();
        if (r7 == null) goto L14;
        if (r7.intValue() != 1) goto L14;
        boolean r8 = true;
    L15:
        r4.q = r8;
        BotFeedbackComponent r9 = this.a;
        String r10 = ((Keva) r9.m.getValue()).getString(r9.n, "");
        if (r10 != null) goto L18;
    L19:
        r6 = true;
    L21:
        if (r6 == true) goto L28;
        r2 = new ArrayList();
        r2 = (List) HttpExtKt.f.fromJson(r10, new f().getType());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        FLogger.a.e("BotFeedbackComponent", "getCacheConfig, err.msg=" + e.getMessage());
    L28:
        if (r2 == null) goto L31;
        List r11 = CollectionsKt.toMutableList(r2);
        if (r11 == null) goto L31;
    L32:
        r9.w = r11;
        FLogger.a.d("BotFeedbackComponent" + hashCode(), "on bot Change: new = " + r14.getName() + ", showedFeedBackBotList = " + CollectionsKt.joinToString$default(this.a.w, null, null, null, 0, null, null, 63, null));
        return;
    L31:
        r11 = new ArrayList();
        goto L32
    L18:
        if (r10.length() != 0) goto L21;
    L14:
        r8 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }
}
