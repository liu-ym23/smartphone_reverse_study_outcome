package com.larus.bmhome.chat.component.immerse;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.h1;
import com.larus.bmhome.chat.view.ImmerseBgVideoView;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements y.a<BotModel> {
    public final /* synthetic */ ImmerseComponent a;

    public l(ImmerseComponent r1) {
        this.a = r1;
    }

    public final void c(Object r6) {
        BotModel r7 = (BotModel) r6;
        Intrinsics.checkNotNullParameter(r7, "new");
        FLogger r0 = FLogger.a;
        r0.d("ImmerseComponent" + hashCode(), "onChange: new bgVideoModel = " + r7.getBgVideoModel());
        this.a.r = r7.getBgVideoModel();
        h1 r1 = this.a.h;
        if (r1 == null) goto L17;
        String r8 = r7.getBgVideoModel();
        r0.i(r1.f, "updateBgVideoModel, current=" + r1.l + ", new = " + r8);
        if (z2.a.immerseBgDynamicEnable() == true) goto L7;
        return;
    L7:
        if (o0.d(r8) == true) goto L9;
        return;
    L9:
        if (r1.l != null) goto L20;
        r1.l = r8;
        if (r8 == null) goto L21;
        ImmerseBgVideoView r2 = r1.k;
        if (r2 == null) goto L15;
        int r3 = ImmerseBgVideoView.m;
        r2.b(r8, false);
    L15:
        r0.i(r1.f, "updateBgVideoModel, real play");
        return;
    L21:
        return;
    L20:
        return;
    }
}
