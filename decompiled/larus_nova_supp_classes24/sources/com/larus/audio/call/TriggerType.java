package com.larus.audio.call;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/larus/audio/call/TriggerType;", "", "typeInt", "", "logName", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getTypeInt", "()I", "getLogName", "()Ljava/lang/String;", "TYPE_HELLO", "TYPE_WAIT", "TYPE_HANG_UP", "TYPE_DENY_AUTH", "TYPE_AUTH_SUCCESS", "TYPE_ONBOARDING_START", "TYPE_CONTINUE", "TYPE_NOTIFICATION_SUMMARY", "TYPE_IMAGE_QUERY", "TYPE_QUERY_WHEN_SILENCE", "TYPE_CLIENT_SUMMON_NOTICE", "TYPE_DORA_E_BOT_ACTIVE", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TriggerType extends Enum<TriggerType> {
    public static final a Companion = null;
    public static final TriggerType TYPE_AUTH_SUCCESS = null;
    public static final TriggerType TYPE_CLIENT_SUMMON_NOTICE = null;
    public static final TriggerType TYPE_CONTINUE = null;
    public static final TriggerType TYPE_DENY_AUTH = null;
    public static final TriggerType TYPE_DORA_E_BOT_ACTIVE = null;
    public static final TriggerType TYPE_HANG_UP = null;
    public static final TriggerType TYPE_HELLO = null;
    public static final TriggerType TYPE_IMAGE_QUERY = null;
    public static final TriggerType TYPE_NOTIFICATION_SUMMARY = null;
    public static final TriggerType TYPE_ONBOARDING_START = null;
    public static final TriggerType TYPE_QUERY_WHEN_SILENCE = null;
    public static final TriggerType TYPE_WAIT = null;
    public static final /* synthetic */ TriggerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String logName;
    private final int typeInt;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TriggerType> getEntries() {
        return b;
    }

    static {
        TriggerType r0 = new TriggerType("TYPE_HELLO", 0, 1, "greeting");
        TYPE_HELLO = r0;
        TriggerType r1 = new TriggerType("TYPE_WAIT", 1, 2, "waiting");
        TYPE_WAIT = r1;
        TriggerType r4 = new TriggerType("TYPE_HANG_UP", 2, 4, "hand_up");
        TYPE_HANG_UP = r4;
        TriggerType r6 = new TriggerType("TYPE_DENY_AUTH", 3, 5, "deny_auth");
        TYPE_DENY_AUTH = r6;
        TriggerType r8 = new TriggerType("TYPE_AUTH_SUCCESS", 4, 6, "auth_success");
        TYPE_AUTH_SUCCESS = r8;
        TriggerType r11 = new TriggerType("TYPE_ONBOARDING_START", 5, 8, "onboarding_start");
        TYPE_ONBOARDING_START = r11;
        TriggerType r13 = new TriggerType("TYPE_CONTINUE", 6, 12, "continue");
        TYPE_CONTINUE = r13;
        TriggerType r7 = new TriggerType("TYPE_NOTIFICATION_SUMMARY", 7, 13, "notification_summary");
        TYPE_NOTIFICATION_SUMMARY = r7;
        TriggerType r5 = new TriggerType("TYPE_IMAGE_QUERY", 8, 14, "image_query");
        TYPE_IMAGE_QUERY = r5;
        TriggerType r9 = new TriggerType("TYPE_QUERY_WHEN_SILENCE", 9, 15, "type_query_when_silence");
        TYPE_QUERY_WHEN_SILENCE = r9;
        TriggerType r3 = new TriggerType("TYPE_CLIENT_SUMMON_NOTICE", 10, 16, "type_client_summon_notice");
        TYPE_CLIENT_SUMMON_NOTICE = r3;
        TriggerType r2 = new TriggerType("TYPE_DORA_E_BOT_ACTIVE", 11, 17, "dora_e_bot_active");
        TYPE_DORA_E_BOT_ACTIVE = r2;
        TriggerType[] r10 = {r0, r1, r4, r6, r8, r11, r13, r7, r5, r9, r3, r2};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public static TriggerType[] values() {
        return (TriggerType[]) a.clone();
    }

    public final String getLogName() {
        return this.logName;
    }

    public final int getTypeInt() {
        return this.typeInt;
    }

    public static TriggerType valueOf(String r1) {
        return (TriggerType) r27.a.a(TriggerType.class, r1);
    }

    public TriggerType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.typeInt = r3;
        this.logName = r4;
    }
}
