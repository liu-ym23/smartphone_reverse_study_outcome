package com.larus.bmhome.chat.list.cell.prompt;

import android.widget.TextView;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PromptCell$d implements PromptSpan.b {
    public final /* synthetic */ PromptCell a;
    public final /* synthetic */ Message b;

    @Override // com.larus.bmhome.chat.layout.item.PromptSpan.b
    public final void b(PromptContent.SuggestV2 r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        FLogger.a.i("WcbSugPromptCell", "start preLoad botId: " + r4.getBotId() + "，item：" + r4.hashCode() + ",holer :" + this.a.hashCode());
        PromptCell r0 = this.a;
        String r5 = r4.getBotId();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.x(r5, "", true);
    }

    public PromptCell$d(PromptCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.bmhome.chat.layout.item.PromptSpan.b
    public final void a(PromptContent.SuggestV2 r19, TextView r20) {
        Intrinsics.checkNotNullParameter(r19, "item");
        Intrinsics.checkNotNullParameter(r20, "textView");
        FLogger.a.i("WcbSugPromptCell", "onClick botId: " + r19.getBotId() + "，item：" + r19.hashCode());
        PromptContent.SuggestV2Extra r1 = y0.c(r19.getExtra());
        PromptCell r2 = this.a;
        String r3 = r19.getBotId();
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        if (r1 == null) goto L8;
        String r6 = r1.getRequestId();
    L9:
        r2.x(r3, r6, false);
        PromptCell r4 = this.a;
        Message r5 = this.b;
        if (r1 == null) goto L12;
        String r7 = r1.getRequestId();
    L13:
        String r8 = r19.getBotId();
        if (r1 == null) goto L16;
        String r9 = r1.getRecommendBot1StType();
    L17:
        if (r1 == null) goto L19;
        String r10 = r1.getRecommendBot2ndType();
    L20:
        if (r1 == null) goto L22;
        String r11 = r1.getRecommendBot3StType();
    L23:
        PromptCell.L(r4, r5, r20, r7, null, r8, r9, r10, r11, null, null, null, null, r19, null, 12040);
        return;
    L22:
        r11 = null;
        goto L23
    L19:
        r10 = null;
        goto L20
    L16:
        r9 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    }
}
