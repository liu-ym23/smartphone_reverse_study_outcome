package com.larus.bmhome.instruction.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b!\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/ActionBarInstructionKey;", "", "key", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getCode", "()I", "COCO_CALL", "COCO_NEWS_ACTIONBAR_NAME", "COCO_HEALTH_CONSULTATION", "COCO_MUSIC_RANDOM_PLAY", "COCO_RECORD", "COCO_CALL_ENGLISH_LEARNING", "COCO_CALL_IDIOM", "COCO_CALL_INTERVIEW", "COCO_CALL_TREE_HOLE", "COCO_COMMAND", "COCO_DAILY_NEWS", "COCO_OLYMPIC_DAILY_CARD", "COCO_SPEAKER", "COMPLEX_SEARCH", "COCO_LISTEN_PODCAST", "COCO_CALL_VIDEO", "CREATION_TEMPLATE_AIGENING", "CREATION_TEMPLATE_AIREPLICA", "COCO_DEEP_THINKING", "COCO_SINGER", "COCO_INMATE", "COCO_ENGLISH_LEARNING", "COCO_PODCAST_GENERATION", "COCO_ECOM_ASSISTANT", "COCO_TRAVEL_ASK_DOUBAO", "COCO_AI_SIMUL_INTERPRET", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarInstructionKey extends Enum<ActionBarInstructionKey> {
    public static final ActionBarInstructionKey COCO_AI_SIMUL_INTERPRET = null;
    public static final ActionBarInstructionKey COCO_CALL = null;
    public static final ActionBarInstructionKey COCO_CALL_ENGLISH_LEARNING = null;
    public static final ActionBarInstructionKey COCO_CALL_IDIOM = null;
    public static final ActionBarInstructionKey COCO_CALL_INTERVIEW = null;
    public static final ActionBarInstructionKey COCO_CALL_TREE_HOLE = null;
    public static final ActionBarInstructionKey COCO_CALL_VIDEO = null;
    public static final ActionBarInstructionKey COCO_COMMAND = null;
    public static final ActionBarInstructionKey COCO_DAILY_NEWS = null;
    public static final ActionBarInstructionKey COCO_DEEP_THINKING = null;
    public static final ActionBarInstructionKey COCO_ECOM_ASSISTANT = null;
    public static final ActionBarInstructionKey COCO_ENGLISH_LEARNING = null;
    public static final ActionBarInstructionKey COCO_HEALTH_CONSULTATION = null;
    public static final ActionBarInstructionKey COCO_INMATE = null;
    public static final ActionBarInstructionKey COCO_LISTEN_PODCAST = null;
    public static final ActionBarInstructionKey COCO_MUSIC_RANDOM_PLAY = null;
    public static final ActionBarInstructionKey COCO_NEWS_ACTIONBAR_NAME = null;
    public static final ActionBarInstructionKey COCO_OLYMPIC_DAILY_CARD = null;
    public static final ActionBarInstructionKey COCO_PODCAST_GENERATION = null;
    public static final ActionBarInstructionKey COCO_RECORD = null;
    public static final ActionBarInstructionKey COCO_SINGER = null;
    public static final ActionBarInstructionKey COCO_SPEAKER = null;
    public static final ActionBarInstructionKey COCO_TRAVEL_ASK_DOUBAO = null;
    public static final ActionBarInstructionKey COMPLEX_SEARCH = null;
    public static final ActionBarInstructionKey CREATION_TEMPLATE_AIGENING = null;
    public static final ActionBarInstructionKey CREATION_TEMPLATE_AIREPLICA = null;
    public static final /* synthetic */ ActionBarInstructionKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;
    private final String key;

    public static EnumEntries<ActionBarInstructionKey> getEntries() {
        return b;
    }

    static {
        ActionBarInstructionKey r0 = new ActionBarInstructionKey("COCO_CALL", 0, "coco_call", 1001);
        COCO_CALL = r0;
        ActionBarInstructionKey r1 = new ActionBarInstructionKey("COCO_NEWS_ACTIONBAR_NAME", 1, "coco_news_actionbar_name", 1002);
        COCO_NEWS_ACTIONBAR_NAME = r1;
        ActionBarInstructionKey r2 = new ActionBarInstructionKey("COCO_HEALTH_CONSULTATION", 2, "coco_health_consultation", 1003);
        COCO_HEALTH_CONSULTATION = r2;
        ActionBarInstructionKey r3 = new ActionBarInstructionKey("COCO_MUSIC_RANDOM_PLAY", 3, "coco_music_random_play", 1004);
        COCO_MUSIC_RANDOM_PLAY = r3;
        ActionBarInstructionKey r5 = new ActionBarInstructionKey("COCO_RECORD", 4, "coco_record", 1005);
        COCO_RECORD = r5;
        ActionBarInstructionKey r7 = new ActionBarInstructionKey("COCO_CALL_ENGLISH_LEARNING", 5, "coco_call_english_learning", 1006);
        COCO_CALL_ENGLISH_LEARNING = r7;
        ActionBarInstructionKey r9 = new ActionBarInstructionKey("COCO_CALL_IDIOM", 6, "coco_call_idiom", 1007);
        COCO_CALL_IDIOM = r9;
        ActionBarInstructionKey r11 = new ActionBarInstructionKey("COCO_CALL_INTERVIEW", 7, "coco_call_interview", 1008);
        COCO_CALL_INTERVIEW = r11;
        ActionBarInstructionKey r13 = new ActionBarInstructionKey("COCO_CALL_TREE_HOLE", 8, "coco_call_tree_hole", 1009);
        COCO_CALL_TREE_HOLE = r13;
        ActionBarInstructionKey r12 = new ActionBarInstructionKey("COCO_COMMAND", 9, "coco_command", 1010);
        COCO_COMMAND = r12;
        ActionBarInstructionKey r10 = new ActionBarInstructionKey("COCO_DAILY_NEWS", 10, "coco_daily_news", 1011);
        COCO_DAILY_NEWS = r10;
        ActionBarInstructionKey r8 = new ActionBarInstructionKey("COCO_OLYMPIC_DAILY_CARD", 11, "coco_olympic_daily_card", 1012);
        COCO_OLYMPIC_DAILY_CARD = r8;
        ActionBarInstructionKey r6 = new ActionBarInstructionKey("COCO_SPEAKER", 12, "coco_speaker", 1013);
        COCO_SPEAKER = r6;
        ActionBarInstructionKey r4 = new ActionBarInstructionKey("COMPLEX_SEARCH", 13, "complex_search", 1014);
        COMPLEX_SEARCH = r4;
        ActionBarInstructionKey r14 = new ActionBarInstructionKey("COCO_LISTEN_PODCAST", 14, "coco_listen_podcast", 1015);
        COCO_LISTEN_PODCAST = r14;
        ActionBarInstructionKey r15 = new ActionBarInstructionKey("COCO_CALL_VIDEO", 15, "coco_call_video", 1016);
        COCO_CALL_VIDEO = r15;
        ActionBarInstructionKey r16 = new ActionBarInstructionKey("CREATION_TEMPLATE_AIGENING", 16, "creation_template_AiGenImg", 1017);
        CREATION_TEMPLATE_AIGENING = r16;
        ActionBarInstructionKey r17 = new ActionBarInstructionKey("CREATION_TEMPLATE_AIREPLICA", 17, "creation_template_AiReplica", 1018);
        CREATION_TEMPLATE_AIREPLICA = r17;
        ActionBarInstructionKey r18 = new ActionBarInstructionKey("COCO_DEEP_THINKING", 18, "coco_deep_thinking", 1019);
        COCO_DEEP_THINKING = r18;
        ActionBarInstructionKey r19 = new ActionBarInstructionKey("COCO_SINGER", 19, "coco_singer", 1020);
        COCO_SINGER = r19;
        ActionBarInstructionKey r20 = new ActionBarInstructionKey("COCO_INMATE", 20, "coco_inmate", 1021);
        COCO_INMATE = r20;
        ActionBarInstructionKey r21 = new ActionBarInstructionKey("COCO_ENGLISH_LEARNING", 21, "coco_english_learning", 1022);
        COCO_ENGLISH_LEARNING = r21;
        ActionBarInstructionKey r22 = new ActionBarInstructionKey("COCO_PODCAST_GENERATION", 22, "coco_podcast_generation", 1023);
        COCO_PODCAST_GENERATION = r22;
        ActionBarInstructionKey r23 = new ActionBarInstructionKey("COCO_ECOM_ASSISTANT", 23, "coco_ecom_assistant", 1024);
        COCO_ECOM_ASSISTANT = r23;
        ActionBarInstructionKey r24 = new ActionBarInstructionKey("COCO_TRAVEL_ASK_DOUBAO", 24, "coco_travel_ask_doubao", 1025);
        COCO_TRAVEL_ASK_DOUBAO = r24;
        ActionBarInstructionKey r25 = new ActionBarInstructionKey("COCO_AI_SIMUL_INTERPRET", 25, "coco_ai_simul_interpret", 1026);
        COCO_AI_SIMUL_INTERPRET = r25;
        ActionBarInstructionKey[] r26 = {r0, r1, r2, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25};
        a = r26;
        b = EnumEntriesKt.enumEntries(r26);
    }

    public static ActionBarInstructionKey[] values() {
        return (ActionBarInstructionKey[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getKey() {
        return this.key;
    }

    public static ActionBarInstructionKey valueOf(String r1) {
        return (ActionBarInstructionKey) a.a(ActionBarInstructionKey.class, r1);
    }

    public ActionBarInstructionKey(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.key = r3;
        this.code = r4;
    }
}
