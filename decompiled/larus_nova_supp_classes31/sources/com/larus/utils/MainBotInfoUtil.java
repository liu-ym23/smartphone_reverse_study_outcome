package com.larus.utils;

import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.i1;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class MainBotInfoUtil {
    public static BotModel a;

    static {
        i1 r0 = LaunchCacheDelegate.b.e();
        if (r0 == null) goto L5;
        String r1 = r0.c;
    L6:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if ((!StringsKt.isBlank(r1)) == false) goto L11;
        FLogger.a.i("MainBotInfoUtil", "start listener main bot info change.mainBotId=".concat(r1));
        com.larus.im.d.a().registerBotChangeListener(r1, new c0());
        return;
    L11:
        FLogger.a.e("MainBotInfoUtil", "init failed. mainBotId is empty");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void a() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MainBotInfoUtil$updateMainBotInfo$1(null), 3, null);
    }
}
