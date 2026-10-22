package com.larus.bmhome.taskskill;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class y implements Function2 {
    public /* synthetic */ y() {
    }

    public final Object invoke(Object r2, Object r3) {
        Regex r0 = SkillComponent.F2;
        return Boolean.valueOf(Intrinsics.areEqual((BotModel) r2, (BotModel) r3));
    }
}
