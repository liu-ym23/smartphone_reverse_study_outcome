package f39;

import com.ixigua.lib.track.TrackParams;
import com.larus.doc.impl.audio.DocAudioComponent;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ DocAudioComponent a;

    public /* synthetic */ f(DocAudioComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r14) {
        DocAudioComponent r0 = this.a;
        int r15 = ((Integer) r14).intValue();
        int r1 = DocAudioComponent.x;
        FLogger.a.i("DocAudioComponent", "stop voiceInput, length:" + r15);
        String r2 = m39.a.a;
        long r3 = r0.v;
        String r4 = r0.w;
        Intrinsics.checkNotNullParameter("ai_doc_detail", "currentPage");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        int r5 = !Intrinsics.areEqual(r4, VoiceInputFrom.TOOL_BAR_LONG_PRESS) ? 1 : 0;
        String r6 = m39.a.a;
        String r7 = m39.a.b;
        Integer r8 = m39.a.c;
        if (r15 <= 0) goto L5;
        int r9 = 1;
    L6:
        String r10 = m39.a.d;
        Integer r11 = 1;
        Integer r12 = Integer.valueOf(r5);
        Long r13 = Long.valueOf(r3);
        Integer r16 = Integer.valueOf(r15);
        Integer r17 = Integer.valueOf(r9);
        JSONObject r18 = new JSONObject();
        Intrinsics.checkNotNullParameter(r18, "params");
        if (r11 != null) goto L33;
    L11:
        if (r10 == null) goto L13;
        r18.put("click_from", r10);     // Catch: JSONException -> L9
    L13:
        if (r12 == null) goto L15;
        r18.put("is_handsfree_speak", r12.intValue());     // Catch: JSONException -> L9
    L15:
        if (r6 == null) goto L17;
        r18.put("page_token", r6);     // Catch: JSONException -> L9
    L17:
        if (r7 == null) goto L19;
        r18.put("artifact_meta_id", r7);     // Catch: JSONException -> L9
    L19:
        if (r8 == null) goto L21;
        r18.put("resource_type", r8.intValue());     // Catch: JSONException -> L9
    L21:
        r18.put("current_page", "ai_doc_detail");     // Catch: JSONException -> L9
        if (r13 == null) goto L24;
        r18.put("speak_duration", r13.longValue());     // Catch: JSONException -> L9
    L24:
        if (r16 == null) goto L26;
        r18.put("content_length", r16.intValue());     // Catch: JSONException -> L9
    L26:
        r18.put("end_method", "click");     // Catch: JSONException -> L9
        if (r17 == null) goto L31;
        r18.put(FlowDoraConnectReason.SUCCESS, r17.intValue());     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobFinishSpeakInput: " + e.getLocalizedMessage());
    L31:
        TrackParams r110 = new TrackParams().merge(r18);
        by7.a r20 = new by7.a("finish_speak_input");
        r20.a.merge(r110);
        r20.b();
        r0.v = 0;
        return Unit.INSTANCE;
    L33:
        r18.put("is_ai_doc", r11.intValue());     // Catch: JSONException -> L9
        goto L11
    L5:
        r9 = 0;
        goto L6
    }
}
