package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.trace.CopyContentTypeString;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public static final k a = null;
    public static final LinkedHashSet<String> b = null;

    public k() {
    }

    static {
        a = new k();
        b = new LinkedHashSet();
    }

    public static /* synthetic */ void b(String r7, i r8, Integer r9, String r10, int r11) {
        k r0 = a;
        if ((r11 & 8) == 0) goto L5;
        Integer r4 = null;
    L7:
        if ((r11 & 16) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r11 & 32) == 0) goto L13;
        boolean r6 = !Intrinsics.areEqual(r7, "card_bind");
    L14:
        r0.a(r7, r8, null, r4, r5, r6);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r5 = r10;
        goto L11
    L5:
        r4 = r9;
        goto L7
    }

    public final void a(String r22, i r23, String r24, Integer r25, String r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r22, "stage");
        Intrinsics.checkNotNullParameter(r23, "context");
        String r5 = r23.c;
        String r6 = r23.h;
        String r7 = r23.a;
        String r8 = r23.b;
        String[] r9 = new String[5];
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        boolean r11 = false;
        r9[0] = r5;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r9[1] = r6;
        r9[2] = r22;
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r9[3] = r7;
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        r9[4] = r8;
        String r10 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r9), "|", null, null, 0, null, null, 62, null);
        if (r27 == false) goto L33;
        monitor-enter(this);
        LinkedHashSet<String> r12 = b;     // Catch: Throwable -> L30
        if (r12.contains(r10) == false) goto L21;
        monitor-exit(this);
        boolean r13 = false;
    L28:
        if (r13 == true) goto L33;
        return;
    L21:
        r12.add(r10);     // Catch: Throwable -> L30
        if (r12.size() <= 256) goto L26;
        Iterator<String> r14 = r12.iterator();     // Catch: Throwable -> L30
        if (r14.hasNext() == false) goto L26;
        r14.next();     // Catch: Throwable -> L30
        r14.remove();     // Catch: Throwable -> L30
    L26:
        monitor-exit(this);
        r13 = true;
    L30:
        th = move-exception;
        throw th;
    L33:
        String r15 = r23.l;
        if (r15 != null) goto L36;
    L37:
        r11 = true;
    L38:
        if (r11 == false) goto L41;
        String r16 = null;
    L44:
        String r17 = r23.a;
        String r18 = r23.b;
        String r19 = r23.c;
        String r20 = r23.d;
        String r110 = r23.e;
        String r111 = r23.j;
        String r112 = r23.k;
        Integer r113 = r23.g;
        String r114 = r23.h;
        Integer r115 = r23.i;
        Integer r4 = r23.m;
        String r21 = r23.n;
        JSONObject r28 = new JSONObject();
        r28.put("scene", r23.f);
        Unit r0 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r22, "stage");
        Intrinsics.checkNotNullParameter(r28, "params");
        r28.put("stage", r22);     // Catch: Exception -> L66
        r28.putOpt("record_id", r17);     // Catch: Exception -> L66
        r28.putOpt("record_id_v2", r18);     // Catch: Exception -> L66
        r28.putOpt("message_id", r19);     // Catch: Exception -> L66
        r28.putOpt("reply_message_id", r20);     // Catch: Exception -> L66
        r28.putOpt("conversation_id", r110);     // Catch: Exception -> L66
        r28.putOpt("device_id", r111);     // Catch: Exception -> L66
        r28.putOpt("user_id", r112);     // Catch: Exception -> L66
        if (r113 == null) goto L48;
        r28.put("block_type", r113.intValue());     // Catch: Exception -> L66
    L48:
        r28.putOpt("block_id", r114);     // Catch: Exception -> L66
        if (r115 == null) goto L51;
        r28.put("record_minutes_block_status", r115.intValue());     // Catch: Exception -> L66
    L51:
        r28.putOpt("effective_card_stage", r24);     // Catch: Exception -> L66
        r28.putOpt("is_same_device", r16);     // Catch: Exception -> L66
        Integer r3 = r25;
        if (r3 == null) goto L56;
        r28.put(CopyContentTypeString.CODE, r25.intValue());     // Catch: Exception -> L64
    L64:
        e = e;
    L65:
        String r29 = r26;
        Integer r30 = r4;
    L68:
        String r116 = "AudioRecordEventHelper";
        FLogger.a.e(r116, e.getMessage(), e);
    L69:
        TrackParams r1 = new TrackParams().merge(r28);
        by7.a r31 = new by7.a("flow_doc_record_minutes_block_funnel");
        FLogger.a.i(r116, "emit flow_doc_record_minutes_block_funnel: stage=" + r22 + ", code=" + r3 + ", reason=" + r29 + ", blockType=" + r113 + ", status=" + r115 + ", effectiveCardStage=" + r24 + ", isSameDevice=" + r16 + ", serverFailCode=" + r30);
        r31.a.merge(r1);
        r31.b();
        return;
    L56:
        r29 = r26;
        r30 = r4;
        r28.putOpt(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r29);     // Catch: Exception -> L62
        if (r30 == null) goto L60;
        r28.put("server_fail_code", r30.intValue());     // Catch: Exception -> L62
    L60:
        r28.putOpt("server_fail_info", r21);     // Catch: Exception -> L62
        r116 = "AudioRecordEventHelper";
    L62:
        e = e;
    L66:
        e = e;
        r3 = r25;
        goto L65
    L41:
        if (Intrinsics.areEqual(r23.l, r23.j) == false) goto L43;
        r16 = "1";
        goto L44
    L43:
        r16 = "0";
        goto L44
    L36:
        if (r15.length() != 0) goto L38;
        goto L37
    }
}
