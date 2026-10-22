package com.larus.bmhome.chat.list.cell.generate_image;

import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import lf8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ GenerateImageCell a;

    public /* synthetic */ j(GenerateImageCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        GenerateImageCell r0 = this.a;
        ConcurrentHashMap.KeySetView r1 = GenerateImageCell.A;
        return a.a(r0, IChatMessageShareAbility.class);
    }
}
