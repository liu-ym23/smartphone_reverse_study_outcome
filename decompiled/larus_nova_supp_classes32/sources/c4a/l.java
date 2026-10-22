package c4a;

import com.larus.av_call.constant.ThemeType;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new j());
        b = LazyKt.lazy(new k());
    }

    public static boolean a() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static ThemeType b(BotModel r3) {
        if (r3 != null) goto L4;
    L16:
        ThemeType r4 = ThemeType.DEFAULT;
    L17:
        FLogger.a.i("ThemeCreator", "getThemeType, type:" + r4);
        return r4;
    L4:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L16;
        Integer r0 = r3.getBotType();
        if (r0 == null) goto L13;
        if (r0.intValue() != 1) goto L13;
        r4 = ThemeType.MAIN_BOT;
    L13:
        if (g.a(r3) == false) goto L15;
        r4 = ThemeType.IMMERS_BOT;
        goto L17
    L15:
        r4 = ThemeType.UGC_BOT;
        goto L17
    }
}
