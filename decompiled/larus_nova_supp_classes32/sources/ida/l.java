package ida;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import hda.b1;
import hda.c1;
import hda.e1;
import hda.o0;
import hda.p0;
import hda.q0;
import hda.r0;
import hda.r1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements r0<u> {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public static JSONObject d(o0 r2) {
        String r3 = r2.c(new String[]{"transcript"});
        Object r0 = null;
        if (r3 != null) goto L15;
        return null;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(new JSONObject(r3));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r4) == true) goto L14;
        r0 = r4;
    L14:
        return (JSONObject) r0;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // hda.r0
    public final String a(com.obric.assistant.cocreationreview.a r2) {
        u r3 = (u) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.n;
    }

    @Override // hda.r0
    public final String b(com.obric.assistant.cocreationreview.a r2) {
        u r3 = (u) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.o;
    }

    @Override // hda.r0
    public final com.obric.assistant.cocreationreview.a c(q0 r22) {
        Intrinsics.checkNotNullParameter(r22, "record");
        o0 r2 = new o0(r22);
        r1.a.getClass();
        e1 r15 = r1.f(r22);
        String r0 = r22.d;
        if (r0 != null) goto L7;
        r0 = r2.c(new String[]{"summaryText", "displaySummary", "summary"});
        if (r0 != null) goto L7;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        String r9 = b1.a(r0);
        String r1 = r2.c(new String[]{"transcriptText"});
        if (r1 != null) goto L29;
        JSONObject r3 = r2.a.optJSONObject("transcript");
        if (r3 == null) goto L17;
        String r8 = p0.b(r3, LynxAccessibilityModule.MSG_CONTENT);
        if (r8 != null) goto L16;
        r8 = p0.b(r3, "text");
        if (r8 != null) goto L16;
        r8 = p0.b(r3, "value");
    L16:
        r1 = r8;
    L18:
        if (r1 != null) goto L29;
        JSONObject r4 = d(r2);
        if (r4 == null) goto L28;
        String r7 = p0.b(r4, LynxAccessibilityModule.MSG_CONTENT);
        if (r7 != null) goto L27;
        String r6 = p0.b(r4, "text");
        if (r6 != null) goto L26;
        r1 = p0.b(r4, "value");
        goto L29
    L26:
        r1 = r6;
        goto L29
    L27:
        r1 = r7;
        goto L29
    L28:
        r1 = null;
        goto L29
    L17:
        r1 = null;
    L29:
        String r11 = c1.c(r1);
        Long r5 = r2.b(new String[]{"productType"});
        if (r5 == null) goto L32;
        Integer r10 = Integer.valueOf((int) r5.longValue());
    L33:
        boolean r12 = false;
        if (r10 != null) goto L37;
    L39:
        boolean r13 = false;
    L40:
        String r14 = r22.a;
        ModuleKey r16 = ModuleKey.AUDIO_MEMORY;
        String r17 = p0.a(r22);
        Long r18 = r2.b(new String[]{"startTimestamp", "createTime"});
        if (r18 != null) goto L43;
    L50:
        String r19 = r17;
        String r20 = r2.d();
        if (r20 != null) goto L53;
        r20 = r2.c(new String[]{"topic"});
    L53:
        String r110 = r20;
        String r111 = r15.c;
        JSONObject r21 = r2.a.optJSONObject("audioInfo");
        if (r21 == null) goto L60;
        JSONObject r23 = r21.optJSONObject("file");
        if (r23 == null) goto L60;
        String r24 = p0.b(r23, "fileName");
        if (r24 == null) goto L60;
    L78:
        String r25 = r2.c(new String[]{"transcriptContentUrl", "transcriptUrl"});
        if (r25 != null) goto L89;
        JSONObject r26 = r2.a.optJSONObject("transcript");
        if (r26 == null) goto L83;
        r25 = p0.b(r26, "contentUrl");
    L84:
        if (r25 != null) goto L89;
        JSONObject r27 = d(r2);
        if (r27 == null) goto L88;
        String r112 = p0.b(r27, "contentUrl");
    L91:
        return new u(r14, r16, r19, r110, r111, r9, r24, r11, r112, r13, !r13, r15, r22.e, r22.g);
    L88:
        r112 = null;
        goto L91
    L83:
        r25 = null;
    L89:
        r112 = r25;
    L60:
        JSONObject r28 = r2.a.optJSONObject("file");
        if (r28 == null) goto L63;
        r24 = p0.b(r28, "fileName");
    L64:
        if (r24 != null) goto L78;
        r24 = r2.c(new String[]{"fileName", "audioFileName", "recordingFileName"});
        if (r24 != null) goto L78;
        String r29 = r2.c(new String[]{"file"});
        if (r29 != null) goto L92;
        r24 = null;
        goto L78
    L92:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L72
        Object r31 = Result.constructor-impl(p0.b(new JSONObject(r29), "fileName"));     // Catch: Throwable -> L72
    L75:
        if (Result.isFailure-impl(r31) == false) goto L77;
        r31 = null;
    L77:
        r24 = (String) r31;
    L72:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L63:
        r24 = null;
        goto L64
    L43:
        if (r18.longValue() <= 0) goto L45;
        r12 = true;
    L45:
        if (r12 == true) goto L48;
        r18 = null;
    L48:
        if (r18 == null) goto L50;
        r17 = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r18.longValue()));
        goto L50
    L37:
        if (r10.intValue() != 1006) goto L39;
        r13 = true;
        goto L40
    L32:
        r10 = null;
        goto L33
    }
}
