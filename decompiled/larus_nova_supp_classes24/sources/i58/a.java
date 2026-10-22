package i58;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(String r1, Integer r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        String r0 = this.a;
        Integer r1 = this.b;
        String r2 = this.c;
        FLogger.a.i("AiNoteTracer", "sendAiNoteStartEvent: messageId=" + r0 + ", errorCode=" + r1 + ", errorMsg=" + r2);
        JSONObject r3 = new JSONObject();
        if (r0 == null) goto L5;
        r3.put("message_id", r0);
    L5:
        if (r1 == null) goto L7;
        r3.put("error_code", r1.intValue());
    L7:
        if (r2 == null) goto L9;
        r3.put("error_msg", r2);
    L9:
        TrackParams r4 = new TrackParams().merge(r3);
        by7.a r5 = new by7.a("flow_ainote_start");
        r5.a.merge(r4);
        r5.b();
        return Unit.INSTANCE;
    }
}
