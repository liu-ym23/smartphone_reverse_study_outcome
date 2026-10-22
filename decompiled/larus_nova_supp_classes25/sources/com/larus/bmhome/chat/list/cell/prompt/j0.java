package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.PromptContent;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j0 implements Function1 {
    public /* synthetic */ j0() {
    }

    public final Object invoke(Object r5) {
        PromptContent.SuggestItem r6 = (PromptContent.SuggestItem) r5;
        Keva r0 = PromptCell.Y;
        Intrinsics.checkNotNullParameter(r6, "it");
        StringBuilder r1 = new StringBuilder("{id=");
        r1.append(r6.getItemId());
        r1.append(",highlight=");
        r1.append(r6.isHighlightPush());
        r1.append(",obric=");
        Map<String, String> r2 = r6.getExtra();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.get("o_suggest");
    L6:
        r1.append(r4);
        r1.append(",text=");
        String r7 = r6.getSuggest();
        if (r7 == null) goto L9;
        r3 = StringsKt.take(r7, 20);
    L9:
        r1.append(r3);
        r1.append('}');
        return r1.toString();
    L5:
        r4 = null;
        goto L6
    }
}
