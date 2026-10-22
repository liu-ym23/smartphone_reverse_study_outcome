package gx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;

    public /* synthetic */ n(String r1, String r2, String r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r7) {
        String r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        long r3 = this.d;
        com.larus.bmhome.chat.trace.a r8 = (com.larus.bmhome.chat.trace.a) r7;
        Intrinsics.checkNotNullParameter(r8, "$this$withChatBaseData");
        String r9 = r8.j;
        by7.e r4 = IAIChatControlTraceService.a.ob(r3);
        boolean r5 = o3.a;
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r9 != null) goto L20;
    L7:
        if (r0 == null) goto L9;
        r6.put("category_id", r0);     // Catch: JSONException -> L5
    L9:
        if (r1 == null) goto L11;
        r6.put("candidate_type", r1);     // Catch: JSONException -> L5
    L11:
        if (r2 == null) goto L15;
        r6.put("current_chat_type", r2);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper showOfficeOnboardingCard " + e.getLocalizedMessage());
    L15:
        TrackParams r10 = new TrackParams().merge(r6);
        by7.a r11 = new by7.a("show_office_onboarding_card");
        if (r4 == null) goto L18;
        r11.b = r4;
    L18:
        r11.a.merge(r10);
        r11.b();
        return Unit.INSTANCE;
    L20:
        r6.put("current_page", r9);     // Catch: JSONException -> L5
        goto L7
    }
}
