package com.obric.assistant.voice;

import com.obric.capabilitykit.entity.app.EntityType;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class m {
    public static final Map<Integer, String> a = null;

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "wakeup_login_success"), TuplesKt.to(2, "wakeup_login_fail"), TuplesKt.to(11, "voice_print_register_success"), TuplesKt.to(12, "voice_print_register_fail"), TuplesKt.to(14, "voice_print_enroll_state_fail"), TuplesKt.to(15, "voice_print_enroll_sentence_result"), TuplesKt.to(100, "wakeup_stage1_pass"), TuplesKt.to(200, "wakeup_stage2_pass"), TuplesKt.to(Integer.valueOf(EntityType.CONTACT), "wakeup_stage2_reject"), TuplesKt.to(300, "wakeup_onshow_ui"), TuplesKt.to(13, "voice_print_enroll_check_sentence"), TuplesKt.to(104, "wakeup_stage1_breath_score"), TuplesKt.to(Integer.valueOf(EntityType.SCHEDULE), "wakeup_model_download_request"), TuplesKt.to(Integer.valueOf(EntityType.ICALENDAR_PROTOCOL), "wakeup_model_download_start"), TuplesKt.to(Integer.valueOf(EntityType.CALENDAR_EVENT), "wakeup_model_download_success"), TuplesKt.to(404, "wakeup_model_download_failed"), TuplesKt.to(405, "wakeup_model_updating"), TuplesKt.to(406, "wakeup_model_update_success"), TuplesKt.to(407, "wakeup_model_update_fail"), TuplesKt.to(408, "wakeup_model_update_ignore")});
    }
}
