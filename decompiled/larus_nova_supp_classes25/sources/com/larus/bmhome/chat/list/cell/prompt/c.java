package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.platform.service.z2;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function0 {
    public /* synthetic */ c() {
    }

    public final Object invoke() {
        Keva r0 = PromptCell.Y;
        return Boolean.valueOf(z2.a.delayPromptShowReport());
    }
}
