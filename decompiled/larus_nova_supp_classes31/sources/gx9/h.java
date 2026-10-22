package gx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;

    public /* synthetic */ h(String r1, String r2, String r3, long r4) {
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
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r9 != null) goto L20;
    L7:
        if (r0 == null) goto L9;
        r5.put("category_id", r0);     // Catch: JSONException -> L5
    L9:
        if (r1 == null) goto L11;
        r5.put("candidate_type", r1);     // Catch: JSONException -> L5
    L11:
        if (r2 == null) goto L15;
        r5.put("current_chat_type", r2);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickOfficeOnboardingCard " + e.getLocalizedMessage());
    L15:
        TrackParams r10 = new TrackParams().merge(r5);
        by7.a r6 = new by7.a("click_office_onboarding_card");
        if (r4 == null) goto L18;
        r6.b = r4;
    L18:
        r6.a.merge(r10);
        r6.b();
        return Unit.INSTANCE;
    L20:
        r5.put("current_page", r9);     // Catch: JSONException -> L5
        goto L7
    }
}
