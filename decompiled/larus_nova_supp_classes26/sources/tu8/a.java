package tu8;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.im.bean.bot.FirstMet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;
    public static final Keva b = null;

    public a() {
    }

    static {
        a = new a();
        b = Keva.getRepo("create_bot_cache", 0);
    }

    public static Object a(FirstMet r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (r3 != null) goto L6;
        b.erase("key_create_bot_first_met");     // Catch: Throwable -> L9
    L7:
        return Result.constructor-impl(Unit.INSTANCE);
    L6:
        b.storeString("key_create_bot_first_met", new Gson().toJson(r3));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }
}
