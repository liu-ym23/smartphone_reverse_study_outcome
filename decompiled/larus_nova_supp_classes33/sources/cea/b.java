package cea;

import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.h;
import com.obric.assistant.o;
import com.obric.assistant.t1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    static {
    }

    public static boolean a() {
        q38.a r0 = ILoginService.a.getAccountInfo();
        if (r0.a == true) goto L5;
    L9:
        return false;
    L5:
        if (r0.g == false) goto L9;
        FLogger.a.i("ObricUserGuideSkipHelper", "skip user guide for enterprise account");
        t1.a.a1();
        o.a = false;
        h.a.postValue(Boolean.TRUE);
        return true;
    }
}
