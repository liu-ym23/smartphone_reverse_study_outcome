package gx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Integer d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ f(String r1, String r2, String r3, Integer r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r9) {
        String r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        Integer r3 = this.d;
        String r4 = this.e;
        String r5 = this.f;
        com.larus.bmhome.chat.trace.a r10 = (com.larus.bmhome.chat.trace.a) r9;
        Intrinsics.checkNotNullParameter(r10, "$this$withChatBaseData");
        String r6 = r10.a;
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L12;
        r0 = r10.a;
    L12:
        String r11 = r10.g;
        boolean r8 = o3.a;
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r0 != null) goto L33;
    L17:
        if (r11 == null) goto L19;
        r12.put("conversation_id", r11);     // Catch: JSONException -> L15
    L19:
        if (r1 == null) goto L21;
        r12.put("message_id", r1);     // Catch: JSONException -> L15
    L21:
        if (r2 == null) goto L23;
        r12.put("onboarding_type", r2);     // Catch: JSONException -> L15
    L23:
        if (r3 == null) goto L25;
        r12.put("hide_count", r3.intValue());     // Catch: JSONException -> L15
    L25:
        if (r4 == null) goto L27;
        r12.put("hide_item_ids", r4);     // Catch: JSONException -> L15
    L27:
        if (r5 == null) goto L31;
        r12.put("hide_item_contents", r5);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper mobDevHideOnBoardingSuggest " + e.getLocalizedMessage());
    L31:
        TrackParams r13 = new TrackParams().merge(r12);
        by7.a r14 = new by7.a("dev_hide_onboarding_suggest");
        r14.a.merge(r13);
        r14.b();
        return Unit.INSTANCE;
    L33:
        r12.put("bot_id", r0);     // Catch: JSONException -> L15
        goto L17
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }
}
