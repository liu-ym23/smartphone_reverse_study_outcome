package com.larus.bmhome.setting.migrate;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class UserSettingMigrateRepo {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object b(List r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserSettingMigrateRepo$requireSyncUserConfig$2(r3, null), r4);
    }

    public static Object a(List r3, int r4, String r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserSettingMigrateRepo$requireAllUserConfig$2(r3, r5, r4, null), r6);
    }
}
