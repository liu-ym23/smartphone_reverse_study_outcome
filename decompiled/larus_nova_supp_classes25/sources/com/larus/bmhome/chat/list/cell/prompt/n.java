package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.PromptContent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n implements Function1 {
    public /* synthetic */ n() {
    }

    public final Object invoke(Object r3) {
        PromptContent.SuggestItem r4 = (PromptContent.SuggestItem) r3;
        Keva r0 = PromptCell.Y;
        Intrinsics.checkNotNullParameter(r4, "it");
        StringBuilder r1 = new StringBuilder("{id=");
        r1.append(r4.getItemId());
        r1.append(",highlight=");
        r1.append(r4.isHighlightPush());
        r1.append(",text=");
        String r5 = r4.getSuggest();
        if (r5 == null) goto L5;
        String r6 = StringsKt.take(r5, 20);
    L6:
        r1.append(r6);
        r1.append('}');
        return r1.toString();
    L5:
        r6 = null;
        goto L6
    }
}
