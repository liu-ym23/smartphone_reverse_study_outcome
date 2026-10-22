package ce8;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;
import t1a.b;
import tx9.c0;
import v19.e6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final StateFlowImpl a = null;
    public static String b;
    public static String c;

    static {
        a = j1.a(Boolean.FALSE);
        b = "";
        c = "";
    }

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    public static void c(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (a() == false) goto L5;
        String r0 = "1";
    L6:
        r2.put("is_continuous_speak", r0);
        if (a() == false) goto L9;
        String r1 = b;
    L10:
        r2.put("call_id", r1);
        if (a() == false) goto L14;
        r2.put("call_enter_method", c);
        return;
    L14:
        return;
    L9:
        r1 = "";
        goto L10
    L5:
        r0 = "0";
        goto L6
    }

    public static void b(String r16, String r17, b r18) {
        y r0 = r18.getAbility(y.class);
        if (r0 != null) goto L5;
        return;
    L5:
        BotModel r1 = r0.j0();
        if (r1 != null) goto L8;
        return;
    L8:
        wc9.e r2 = r0.h();
        if (r2 != null) goto L11;
        return;
    L11:
        JSONObject r13 = new JSONObject();
        r13.put("is_continuous_speak", "1");
        r13.put("call_id", r17);
        String r3 = r1.getBotId();
        String r4 = r2.a;
        LruCache r5 = ko8.a.a;
        Integer r6 = r2.v;
        Integer r7 = r1.getBotType();
        BotCreatorInfo r8 = r1.getBotCreatorInfo();
        if (r8 == null) goto L14;
        String r9 = r8.getId();
    L15:
        String r10 = ko8.a.f(r6, r7, Intrinsics.areEqual(r9, AccountService.a.getUserId()));
        e6 r11 = e6.a;
        c0.e(r3, r4, "chat", null, r16, r10, null, null, "1", r11.c(), r11.b(), r13, null, 290712);
        return;
    L14:
        r9 = null;
        goto L15
    }
}
