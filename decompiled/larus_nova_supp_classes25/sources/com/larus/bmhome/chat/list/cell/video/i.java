package com.larus.bmhome.chat.list.cell.video;

import android.view.View;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.b1;
import com.larus.bmhome.chat.layout.holder.helper.o;
import com.larus.bmhome.chat.layout.holder.helper.x2;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import pi8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function3 {
    public final /* synthetic */ AwemeVideoListCell a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ BotModel c;

    public /* synthetic */ i(AwemeVideoListCell r1, Message r2, BotModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r19, Object r20, Object r21) {
        final AwemeVideoListCell r8 = this.a;
        final Message r10 = this.b;
        final BotModel r7 = this.c;
        pi8.k r1 = (pi8.k) r19;
        final oi8.k r6 = (oi8.k) r20;
        oi8.c r2 = (oi8.c) r21;
        int r3 = AwemeVideoListCell.j;
        Intrinsics.checkNotNullParameter(r1, "callbackData");
        Intrinsics.checkNotNullParameter(r6, "searchListData");
        if ((r1 instanceof pi8.s) == false) goto L10;
        pi8.s r4 = (pi8.s) r1;
        final int r5 = r4.b;
        final VideoInfo r9 = r4.a;
        View r15 = r4.c;
        r8.getClass();
        e1.d(r15, new k(r10, r5, r9, r8, r6, r7));
        q0 r11 = lf8.a.b(r8);
        q0 r12 = lf8.a.b(r8);
        if (r12 == null) goto L7;
        q0.a r13 = r12.getProvider();
    L8:
        b1.a(new o(r10, r11, r13, new x2(), null, null, null, DoraCallStateCode.DOUBAO_CMD_12), r15);
    L21:
        return Unit.INSTANCE;
    L7:
        r13 = null;
        goto L8
    L10:
        if ((r1 instanceof e) == true) goto L21;
        if ((r1 instanceof pi8.f) == true) goto L21;
        if ((r1 instanceof pi8.h) == true) goto L21;
        if ((r1 instanceof pi8.g) == true) goto L21;
        throw new NoWhenBranchMatchedException();
    }
}
