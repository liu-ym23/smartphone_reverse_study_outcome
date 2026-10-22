package com.obric.assistant.chat.menu;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/chat/menu/AsrFeedBack;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ToDouBao", "NotToDouBao", "Reset", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrFeedBack extends Enum<AsrFeedBack> {
    public static final AsrFeedBack NotToDouBao = null;
    public static final AsrFeedBack Reset = null;
    public static final AsrFeedBack ToDouBao = null;
    public static final /* synthetic */ AsrFeedBack[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AsrFeedBack> getEntries() {
        return b;
    }

    static {
        AsrFeedBack r0 = new AsrFeedBack("ToDouBao", 0, "1");
        ToDouBao = r0;
        AsrFeedBack r1 = new AsrFeedBack("NotToDouBao", 1, RiskPreferenceSettings.SMART_BALANCE);
        NotToDouBao = r1;
        AsrFeedBack r2 = new AsrFeedBack("Reset", 2, RiskPreferenceSettings.AUTONOMY_FIRST);
        Reset = r2;
        AsrFeedBack[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static AsrFeedBack[] values() {
        return (AsrFeedBack[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AsrFeedBack valueOf(String r1) {
        return (AsrFeedBack) r27.a.a(AsrFeedBack.class, r1);
    }

    public AsrFeedBack(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
