package usb;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.newemoji.settings.EmojiConfigData;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    public static int a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        EmojiConfigData r1 = (EmojiConfigData) SettingManager.getInstance().get(EmojiConfigData.class);     // Catch: Throwable -> L4
    L6:
        if (r1 == null) goto L10;
        Integer r2 = r1.a();
        if (r2 == null) goto L10;
        return RangesKt.coerceAtLeast(r2.intValue(), 1);
    L10:
        return 2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r1 = null;
        goto L6
    }
}
