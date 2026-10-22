package com.larus.trace;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/trace/SendingTextEditTriggeredScene;", "", "<init>", "(Ljava/lang/String;I)V", "ASR", "EDIT_TEXT", "ACTION_MENU_ENTRANCE", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum SendingTextEditTriggeredScene extends Enum<SendingTextEditTriggeredScene> {
    public static final SendingTextEditTriggeredScene ACTION_MENU_ENTRANCE = null;
    public static final SendingTextEditTriggeredScene ASR = null;
    public static final SendingTextEditTriggeredScene EDIT_TEXT = null;
    public static final /* synthetic */ SendingTextEditTriggeredScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SendingTextEditTriggeredScene> getEntries() {
        return b;
    }

    static {
        SendingTextEditTriggeredScene r0 = new SendingTextEditTriggeredScene("ASR", 0);
        ASR = r0;
        SendingTextEditTriggeredScene r1 = new SendingTextEditTriggeredScene("EDIT_TEXT", 1);
        EDIT_TEXT = r1;
        SendingTextEditTriggeredScene r3 = new SendingTextEditTriggeredScene("ACTION_MENU_ENTRANCE", 2);
        ACTION_MENU_ENTRANCE = r3;
        SendingTextEditTriggeredScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SendingTextEditTriggeredScene[] values() {
        return (SendingTextEditTriggeredScene[]) a.clone();
    }

    public static SendingTextEditTriggeredScene valueOf(String r1) {
        return (SendingTextEditTriggeredScene) a.a(SendingTextEditTriggeredScene.class, r1);
    }

    public SendingTextEditTriggeredScene(String r1, int r2) {
        super(r1, r2);
    }
}
