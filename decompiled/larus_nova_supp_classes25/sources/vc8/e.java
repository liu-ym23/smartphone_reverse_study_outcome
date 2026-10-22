package vc8;

import com.bytedance.keva.Keva;
import com.larus.im.bean.message.MessageTag;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final Keva a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageTag.values().length];
            r0[MessageTag.MessageTag_Onboarding_FIRSTMEG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MessageTag.MessageTag_Onboarding_WELCOMEBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MessageTag.MessageTag_Onboarding_LONG_TIME_NO_SEE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = Keva.getRepo(o2.a.e(), 0);
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        a.storeBoolean("1_on_boarding_tts_" + r4 + '_' + AccountService.a.getSecUserId(), true);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        a.storeString("need_show_change_icon_".concat(AccountService.a.getUserId()), r3);
    }
}
