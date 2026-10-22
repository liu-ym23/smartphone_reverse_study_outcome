package ce8;

import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SelectTextAction;
import com.larus.platform.service.AccountService;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final boolean a(BotModel r1) {
        BotCreatorInfo r2 = r1.getBotCreatorInfo();
        if (r2 == null) goto L5;
        String r3 = r2.getId();
    L7:
        return Intrinsics.areEqual(r3, AccountService.a.getUserId());
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean b(BotModel r3) {
        if (r3 == null) goto L14;
        List r4 = r3.getSelectTextActions();
        if (r4 == null) goto L21;
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L22;
        SelectTextAction r0 = (SelectTextAction) r5.next();
        if (Intrinsics.areEqual(r0.getType(), "rewrite") == true) goto L12;
        if (Intrinsics.areEqual(r0.getType(), "question") == false) goto L7;
        return true;
    L12:
        return true;
    L22:
        return false;
    L21:
        return false;
    L14:
        return false;
    }
}
