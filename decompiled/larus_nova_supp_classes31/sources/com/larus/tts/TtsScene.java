package com.larus.tts;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/tts/TtsScene;", "", "<init>", "(Ljava/lang/String;I)V", "Auto_ReceiveMessage", "Auto_UpdateMessage", "Auto_Streaming", "Auto_OnBoarding", "Auto_Other", "Manual_ActionView", "Manual_LongPress", "Manual_Selector", "Manual_Other", "Default", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TtsScene extends Enum<TtsScene> {
    public static final TtsScene Auto_OnBoarding = null;
    public static final TtsScene Auto_Other = null;
    public static final TtsScene Auto_ReceiveMessage = null;
    public static final TtsScene Auto_Streaming = null;
    public static final TtsScene Auto_UpdateMessage = null;
    public static final TtsScene Default = null;
    public static final TtsScene Manual_ActionView = null;
    public static final TtsScene Manual_LongPress = null;
    public static final TtsScene Manual_Other = null;
    public static final TtsScene Manual_Selector = null;
    public static final /* synthetic */ TtsScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TtsScene> getEntries() {
        return b;
    }

    static {
        TtsScene r0 = new TtsScene("Auto_ReceiveMessage", 0);
        Auto_ReceiveMessage = r0;
        TtsScene r1 = new TtsScene("Auto_UpdateMessage", 1);
        Auto_UpdateMessage = r1;
        TtsScene r3 = new TtsScene("Auto_Streaming", 2);
        Auto_Streaming = r3;
        TtsScene r5 = new TtsScene("Auto_OnBoarding", 3);
        Auto_OnBoarding = r5;
        TtsScene r7 = new TtsScene("Auto_Other", 4);
        Auto_Other = r7;
        TtsScene r9 = new TtsScene("Manual_ActionView", 5);
        Manual_ActionView = r9;
        TtsScene r11 = new TtsScene("Manual_LongPress", 6);
        Manual_LongPress = r11;
        TtsScene r13 = new TtsScene("Manual_Selector", 7);
        Manual_Selector = r13;
        TtsScene r15 = new TtsScene("Manual_Other", 8);
        Manual_Other = r15;
        TtsScene r14 = new TtsScene("Default", 9);
        Default = r14;
        TtsScene[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static TtsScene[] values() {
        return (TtsScene[]) a.clone();
    }

    public static TtsScene valueOf(String r1) {
        return (TtsScene) a.a(TtsScene.class, r1);
    }

    public TtsScene(String r1, int r2) {
        super(r1, r2);
    }
}
