package cq9;

import com.larus.platform.creation.CreationMultiReferenceLogEvent;
import com.larus.platform.creation.CreationMultiReferenceProtocolState;
import com.larus.platform.creation.CreationMultiReferenceRuleResult;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final Set<String> a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;

    public b() {
    }

    static {
        a = SetsKt.setOf(new String[]{"video_creation", "creation_feed", "do_same_restore", "do_same", "model_switch", "tab_switch", "send_precheck", "album_callback"});
        b = SetsKt.setOf(new String[]{"model_input_rule_selector", "prefill", "album", "delete", "click_remove", "ref_resources", "model_selector", "creation_tab", "attachment_snapshot", "nested_file"});
        c = SetsKt.setOf(new String[]{"UNSUPPORTED_TYPE", "METADATA_UNAVAILABLE", "NOT_READY", "TYPE_COUNT", "MIXED_COUNT", "SINGLE_DURATION", "TOTAL_DURATION", "FILE_SIZE", "RESOLUTION", "RATIO"});
    }

    public static void a(CreationMultiReferenceLogEvent r13, Boolean r14, String r15, String r16, a r17, CreationMultiReferenceProtocolState r18, CreationMultiReferenceRuleResult r19, String r20, int r21) {
        String r2 = null;
        if ((r21 & 2) == 0) goto L5;
        Boolean r1 = null;
    L7:
        if ((r21 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r21 & 8) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r21 & 32) == 0) goto L17;
        a r5 = null;
    L19:
        if ((r21 & 64) == 0) goto L21;
        CreationMultiReferenceProtocolState r6 = null;
    L23:
        if ((r21 & 128) == 0) goto L25;
        CreationMultiReferenceRuleResult r7 = null;
    L27:
        if ((r21 & 256) == 0) goto L29;
        String r0 = null;
    L30:
        Intrinsics.checkNotNullParameter(r13, "event");
        List r8 = CollectionsKt.createListBuilder();
        r8.add("event=" + r13.getValue());
        if (r1 == null) goto L33;
        r8.add("gate=" + r1.booleanValue());
    L33:
        String r9 = "other";
        if (r3 != null) goto L36;
    L42:
        if (r4 != null) goto L44;
    L50:
        if (r5 == null) goto L54;
        r8.add("image_count=" + r5.a);
        r8.add("video_count=" + r5.b);
        r8.add("audio_count=" + r5.c);
        r8.add("unknown_count=" + r5.d);
        r8.add("video_duration=" + r5.e);
        r8.add("audio_duration=" + r5.f);
        r8.add("total_duration=" + (r5.e + r5.f));
        Integer r10 = r5.g;
        if (r10 == null) goto L54;
        r8.add("entity_summary=total:" + r10.intValue() + ",image:" + r5.a + ",video:" + r5.b + ",audio:" + r5.c + ",unknown:" + r5.d);
    L54:
        if (r6 == null) goto L56;
        r8.add("protocol_state=" + r6.getValue());
    L56:
        if (r7 == null) goto L58;
        r8.add("rule_result=" + r7.getValue());
    L58:
        if (r0 != null) goto L60;
    L66:
        FLogger.a.i("CreationMultiReference", CollectionsKt.joinToString$default(CollectionsKt.build(r8), " ", null, null, 0, null, null, 62, null));
        return;
    L60:
        if (c.contains(r0) == false) goto L62;
        r2 = r0;
    L62:
        if (r2 == null) goto L65;
        r9 = r2;
    L65:
        r8.add("reason=".concat(r9));
        goto L66
    L44:
        if (b.contains(r4) == true) goto L47;
        r4 = null;
    L47:
        if (r4 != null) goto L49;
        r4 = "other";
    L49:
        r8.add("source=".concat(r4));
        goto L50
    L36:
        if (a.contains(r3) == true) goto L39;
        r3 = null;
    L39:
        if (r3 != null) goto L41;
        r3 = "other";
    L41:
        r8.add("scene=".concat(r3));
        goto L42
    L29:
        r0 = r20;
        goto L30
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
