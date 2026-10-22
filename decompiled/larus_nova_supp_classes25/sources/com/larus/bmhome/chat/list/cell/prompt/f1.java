package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f1 implements Function0 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ PromptContent.SuggestV2 b;
    public final /* synthetic */ PromptContent.SuggestItem c;
    public final /* synthetic */ PromptContent.SuggestV2ExtraForMultiAction d;
    public final /* synthetic */ View e;

    public /* synthetic */ f1(Message r1, PromptContent.SuggestV2 r2, PromptContent.SuggestItem r3, PromptContent.SuggestV2ExtraForMultiAction r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        Message r0 = this.a;
        PromptContent.SuggestV2 r1 = this.b;
        PromptContent.SuggestItem r2 = this.c;
        PromptContent.SuggestV2ExtraForMultiAction r3 = this.d;
        View r4 = this.e;
        String r5 = r0.getLocalMessageId();
        boolean r6 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L14;
        Map r8 = r0.getBusinessExt();
        if (r8 == null) goto L13;
        String r9 = (String) r8.get("suggested_type");
        if (r9 == null) goto L13;
        return r9;
    L13:
        return "suggested_prompt";
    L14:
        String r10 = y0.d(r1);
        if (r10 != null) goto L35;
        String r11 = com.larus.bmhome.chat.bean.d.f1(r0, r1, r2);
        if (r3 == null) goto L23;
        String r12 = r3.getSuggestType();
        if (r12 == null) goto L23;
        return r12;
    L23:
        Intrinsics.checkNotNullParameter(r11, "suggestType");
        if (CollectionsKt.listOf("music_ugc_first_met").contains(r11) == true) goto L38;
        Intrinsics.checkNotNullParameter(r4, "view");
        if (y0.b(r4) != null) goto L30;
        r6 = false;
    L30:
        if (r6 == false) goto L37;
        return "bot_recommend";
    L37:
        return r11;
    L38:
        return r11;
    L35:
        return r10;
    L5:
        if (StringsKt.contains$default(r5, "-aweme", false, 2, null) != true) goto L7;
        r7 = true;
        goto L8
    }
}
